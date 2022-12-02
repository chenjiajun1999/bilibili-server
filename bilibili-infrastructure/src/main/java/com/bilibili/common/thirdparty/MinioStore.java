package com.bilibili.common.thirdparty;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.minio.*;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.stereotype.Component;

import io.minio.messages.Bucket;
import io.minio.messages.Item;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MinioStore {

    @Autowired
    private MinioClient minioClient;

    /**
     * 启动SpringBoot容器的时候初始化Bucket，如果没有Bucket则创建
     */
    public void createBucket(String bucketName) throws Exception {
        if (!isBucketExists(bucketName)) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     * 判断Bucket是否存在
     *
     * @return true：存在，false：不存在
     */
    public boolean isBucketExists(String bucketName) throws Exception {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    /**
     * 获得Bucket策略
     *
     * @param bucketName 存储桶名称
     * @return Bucket策略
     */
    public String getBucketPolicy(String bucketName) throws Exception {
        return minioClient.getBucketPolicy(GetBucketPolicyArgs.builder().bucket(bucketName).build());
    }

    /**
     * 获得所有Bucket列表
     *
     * @return Bucket列表
     */
    public List<Bucket> getAllBuckets() throws Exception {
        return minioClient.listBuckets();
    }

    /**
     * 根据存储桶名称获取其相关信息
     *
     * @param bucketName 存储桶名称
     * @return 相关信息
     */
    public Optional<Bucket> getBucket(String bucketName) throws Exception {
        return getAllBuckets()
                .stream()
                .filter(b -> b.name().equals(bucketName))
                .findFirst();
    }

    /**
     * 根据所有存储桶的名称
     *
     * @return 存储桶的名称
     */
    public List<String> getAllBucketsNames() throws Exception {
        List<String> names = new ArrayList<>();
        getAllBuckets().forEach(b ->
                names.add(b.name())
        );
        return names;
    }

    /**
     * 根据存储桶名称删除 Bucket，true：删除成功；false：删除失败，文件或已不存在
     *
     * @param bucketName 存储桶名称
     */
    public void removeBucket(String bucketName) throws Exception {
        minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
    }

    /**
     * 判断文件是否存在
     *
     * @param bucketName 存储桶名称
     * @param objectName 文件名
     * @return true：存在；false：不存在
     */
    public boolean isObjectExist(String bucketName, String objectName) {
        boolean exist = true;
        try {
            minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(objectName).build());
        } catch (Exception e) {
            exist = false;
        }
        return exist;
    }

    /**
     * 判断文件夹是否存在
     *
     * @param bucketName 存储桶名称
     * @param objectName 文件夹名称
     * @return true：存在；false：不存在
     */
    public boolean isFolderExist(String bucketName, String objectName) {
        boolean exist = false;
        try {
            ListObjectsArgs listObjectsArgs = ListObjectsArgs.builder()
                    .bucket(bucketName)
                    .prefix(objectName)
                    .recursive(false)
                    .build();
            Iterable<Result<Item>> results = minioClient.listObjects(listObjectsArgs);
            for (Result<Item> result : results) {
                Item item = result.get();
                if (item.isDir() && objectName.equals(item.objectName())) {
                    exist = true;
                }
            }
        } catch (Exception e) {
            exist = false;
        }
        return exist;
    }

    /**
     * 根据文件前缀查询文件
     *
     * @param bucketName 存储桶名称
     * @param prefix     前缀
     * @param recursive  是否使用递归查询
     * @return MinioItem列表
     */
    public List<Item> getAllObjectsByPrefix(String bucketName, String prefix, boolean recursive) throws Exception {
        List<Item> list = new ArrayList<>();
        ListObjectsArgs listObjectsArgs = ListObjectsArgs.builder()
                .bucket(bucketName)
                .prefix(prefix)
                .recursive(recursive)
                .build();
        Iterable<Result<Item>> objectsIterator = minioClient.listObjects(listObjectsArgs);
        if (objectsIterator != null) {
            for (Result<Item> o : objectsIterator) {
                Item item = o.get();
                list.add(item);
            }
        }
        return list;
    }

    /**
     * 获取文件流
     *
     * @param bucketName 存储桶名称
     * @param objectName 文件名
     * @return 二进制流
     */
    public InputStream getObject(String bucketName, String objectName) throws Exception {
        GetObjectArgs getObjectArgs = GetObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .build();
        return minioClient.getObject(getObjectArgs);
    }

    /**
     * 断点下载
     *
     * @param bucketName 存储桶名称
     * @param objectName 文件名称
     * @param offset     起始字节的位置
     * @param length     要读取的长度
     * @return 二进制流
     */
    public InputStream getObject(String bucketName, String objectName, long offset, long length) throws Exception {
        GetObjectArgs getObjectArgs = GetObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .offset(offset)
                .length(length)
                .build();
        return minioClient.getObject(getObjectArgs);
    }

    /**
     * 获取路径下文件列表
     *
     * @param bucketName 存储桶名称
     * @param prefix     文件名称
     * @param recursive  是否递归查找，false：模拟文件夹结构查找
     * @return 二进制流
     */
    public Iterable<Result<Item>> listObjects(String bucketName, String prefix, boolean recursive) {
        ListObjectsArgs listObjectsArgs = ListObjectsArgs.builder()
                .bucket(bucketName)
                .prefix(prefix)
                .recursive(recursive)
                .build();
        return minioClient.listObjects(listObjectsArgs);
    }

    /**
     * 使用MultipartFile进行文件上传
     *
     * @param bucketName 存储桶名称
     * @param file       文件名
     * @param objectName 对象名
     * @return ObjectWriteResponse对象
     */
    public ObjectWriteResponse uploadFile(String bucketName, MultipartFile file, String objectName) throws Exception {
        InputStream inputStream = file.getInputStream();
        Optional<MediaType> optional = MediaTypeFactory.getMediaType(objectName);
        String mediaType = optional.orElseThrow(() -> new RuntimeException("文件类型暂不支持")).toString();
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .contentType(mediaType)
                .stream(inputStream, inputStream.available(), -1)
                .build();
        return minioClient.putObject(putObjectArgs);
    }

    /**
     * 上传本地文件
     *
     * @param bucketName 存储桶名称
     * @param objectName 对象名称
     * @param fileName   本地文件路径
     */
    public ObjectWriteResponse uploadFile(String bucketName, String objectName, String fileName) throws Exception {
        UploadObjectArgs uploadObjectArgs = UploadObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .filename(fileName)
                .build();
        return minioClient.uploadObject(uploadObjectArgs);
    }

    /**
     * 通过流上传文件
     *
     * @param bucketName  存储桶名称
     * @param objectName  文件对象
     * @param inputStream 文件流
     */
    public ObjectWriteResponse uploadFile(String bucketName, String objectName, InputStream inputStream) throws Exception {
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(inputStream, inputStream.available(), -1)
                .build();
        return minioClient.putObject(putObjectArgs);
    }

    /**
     * 创建文件夹或目录
     *
     * @param bucketName 存储桶名称
     * @param objectName 目录路径
     */
    public ObjectWriteResponse createDir(String bucketName, String objectName) throws Exception {
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(new ByteArrayInputStream(new byte[]{}), 0, -1)
                .build();
        return minioClient.putObject(putObjectArgs);
    }

    /**
     * 获取文件信息, 如果抛出异常则说明文件不存在
     *
     * @param bucketName 存储桶名称
     * @param objectName 文件名称
     */
    public String getFileStatusInfo(String bucketName, String objectName) throws Exception {
        StatObjectArgs statObjectArgs = StatObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .build();
        return minioClient.statObject(statObjectArgs).toString();
    }

    /**
     * 拷贝文件
     *
     * @param bucketName    存储桶名称
     * @param objectName    文件名
     * @param srcBucketName 目标存储桶
     * @param srcObjectName 目标文件名
     */
    public ObjectWriteResponse copyFile(String bucketName, String objectName, String srcBucketName, String srcObjectName) throws Exception {
        return minioClient.copyObject(CopyObjectArgs.builder()
                .source(CopySource.builder()
                        .bucket(bucketName)
                        .object(objectName).build())
                .bucket(srcBucketName)
                .object(srcObjectName).build());
    }

    /**
     * 删除文件
     *
     * @param bucketName 存储桶名称
     * @param objectName 文件名称
     */
    public void removeFile(String bucketName, String objectName) throws Exception {
        RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .build();
        minioClient.removeObject(removeObjectArgs);
    }

    /**
     * 批量删除文件
     *
     * @param bucketName 存储桶名称
     * @param keys       需要删除的文件列表
     */
    public void removeFiles(String bucketName, List<String> keys) {
        keys.forEach(key -> {
            try {
                removeFile(bucketName, key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 获取文件外链
     *
     * @param bucketName 存储桶名称
     * @param objectName 文件名
     * @param expires    过期时间 <=7 秒 （外链有效时间（单位：秒））
     * @return 文件外链
     */
    public String getPreSignedObjectUrl(String bucketName, String objectName, Integer expires) throws Exception {
        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
                .expiry(expires)
                .bucket(bucketName)
                .object(objectName)
                .build();
        return minioClient.getPresignedObjectUrl(args);
    }

    /**
     * 获得文件外链
     *
     * @param bucketName 存储桶名称
     * @param objectName 文件名
     * @return 文件外链
     */
    public String getPreSignedObjectUrl(String bucketName, String objectName) throws Exception {
        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .method(Method.GET)
                .build();
        return minioClient.getPresignedObjectUrl(args);
    }

    /**
     * 将URLDecoder编码转成UTF8
     *
     * @param str 字符串
     * @return 编码
     */
    public String getUtf8ByDecoder(String str) throws UnsupportedEncodingException {
        String url = str.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
        return URLDecoder.decode(url, "UTF-8");
    }
}