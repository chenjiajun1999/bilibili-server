package com.bilibili.gatewayimpl.media;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.cola.exception.BizException;
import com.bilibili.common.thirdparty.MinioStore;
import com.bilibili.domain.media.gateway.MediaTransferGatewayI;
import com.bilibili.media.dto.data.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


/**
 * 分片上传：
 * 1.前端调用后端 createMultipartUpload 获取 uploadId
 * 2.前端计算欲上传文件的分片总数量，并调用后端 getPreSignedObjectUrl 生成对应数量的欲上传地址
 * 3.前端通过欲上传地址上传完所有的分片文件后，调用后端 completeMultipartUpload 合并文件
 */

@Component
public class MediaTransferGatewayImpl implements MediaTransferGatewayI {


    @Autowired
    MinioStore minioStore;


    /**
     * 普通上传
     */
    public void upload(String bucketName, String objectName, MultipartFile file) {

        if (ObjectUtil.isEmpty(file) || file.getSize() <= 0) {
            throw new BizException(ErrorCode.B_FILE_EMPTY.getErrCode(),
                    ErrorCode.B_FILE_EMPTY.getErrDesc());
        }

        try {
            minioStore.uploadFile(bucketName, objectName, file);
        } catch (Exception e) {
            throw new BizException(ErrorCode.B_FILE_UPLOAD_ERROR.getErrCode(),
                    ErrorCode.B_FILE_UPLOAD_ERROR.getErrDesc());
        }
    }

    /**
     * 创建分片上传
     */
    public void createMultipartUpload() {

    }

    /**
     * 得到上传地址
     */
    public void getPreSignedObjectUrl() {

    }

    /**
     * 分片合并
     */
    public void completeMultipartUpload() {

    }

}
