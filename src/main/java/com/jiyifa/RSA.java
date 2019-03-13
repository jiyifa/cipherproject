package com.jiyifa;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class RSA {
    public static void main(String[] args) {
        initKey();
    }
    public static void initKey(){
        //1.初始化密钥
        KeyPairGenerator keyPairGenerator;

        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            //64的整倍数
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            String rsaPublicKey = Base64.encodeBase64String(keyPair.getPublic().getEncoded());
            String rsaPrivateKey = Base64.encodeBase64String(keyPair.getPrivate().getEncoded());
            System.out.println("Public Key : " + rsaPublicKey);
            System.out.println("Private Key : " + rsaPrivateKey);
            System.out.println();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
