package com.bilibili.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import com.alibaba.cola.domain.ApplicationContextHelper;


/**
 * RSA加密
 * 非对称加密，有公钥和私钥之分，公钥用于数据加密，私钥用于数据解密。加密结果可逆
 * 公钥一般提供给外部进行使用，私钥需要放置在服务器端保证安全性。
 * 特点：加密安全性很高，但是加密速度较慢
 */

public class RSAUtil {

    private static final String publicKey = ApplicationContextHelper.getApplicationContext()
            .getEnvironment().getProperty("RSA_PUBLIC_KEY", String.class);
    private static final String privateKey = ApplicationContextHelper.getApplicationContext()
            .getEnvironment().getProperty("RSA_PRIVATE_KEY", String.class);

//    private static final String publicKey;
//    private static final String privateKey;
//    static {
//         KeyPair pair = SecureUtil.generateKeyPair("RSA");
//         publicKey = new String(Base64.encodeBase64(pair.getPublic().getEncoded()));
//         privateKey= new String(Base64.encodeBase64((pair.getPrivate().getEncoded())));
//    }

    /**
     * @param str 加密前 String 数据
     * @return 返回加密后数据
     */
    public static String encrypt(String str) {
        return SecureUtil.rsa(privateKey, publicKey).encryptBcd(str, KeyType.PrivateKey);
    }

    /**
     * @param str 加密后的字符串
     * @return 返回解密后的 String 数据
     */
    public static String decrypt(String str) {
        return SecureUtil.rsa(null, publicKey).decryptStrFromBcd(str, KeyType.PublicKey);
    }

    public static String getPublicKey() {
        return publicKey;
    }

    public static void main(String[] args) {
        System.out.println("私钥:" + privateKey);
        System.out.println("公钥:" + publicKey);
    }
}

