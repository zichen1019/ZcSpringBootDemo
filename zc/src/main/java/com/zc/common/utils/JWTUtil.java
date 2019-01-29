package com.zc.common.utils;

import com.sun.org.apache.xerces.internal.xs.datatypes.ByteList;
import org.apache.ibatis.javassist.bytecode.ByteArray;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.ByteGenerator;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.JoseException;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    public static Map Encrypted (String mingwen) {
        Map<String, Object> result = new HashMap<>();
        byte[] bytes = ByteUtil.randomBytes(16);
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes){
            sb.append((int)b + ",");
        }
        System.out.println(sb.toString());
        result.put("key", sb.toString());
        Key key = new AesKey(bytes);
        JsonWebEncryption jwe = new JsonWebEncryption();
        jwe.setPayload(mingwen);
        jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.A128KW);
        jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256);
        jwe.setKey(key);
        String serializedJwe ;
        try {
            serializedJwe = jwe.getCompactSerialization();
            System.out.println("Serialized Encrypted JWE: " + serializedJwe);
            result.put("miwen", serializedJwe);
            return result;
        } catch (JoseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String Payload (String miwen, String keystr) {
        // 将字符串key转换成byte数组
        byte[] keys = new byte[16];
        for(int i=0;i<keystr.split(",").length; i++){
            keys[i] = Byte.parseByte(keystr.split(",")[i]);
        }
        Key key = new AesKey(keys);
        JsonWebEncryption jwe = new JsonWebEncryption();
        try {
            jwe.setAlgorithmConstraints(new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.WHITELIST,
                    KeyManagementAlgorithmIdentifiers.A128KW));
            jwe.setContentEncryptionAlgorithmConstraints(new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.WHITELIST,
                    ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256));
            jwe.setKey(key);
            jwe.setCompactSerialization(miwen);
            System.out.println("Payload: " + jwe.getPayload());
            return jwe.getPayload();
        } catch (JoseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws JoseException {
        Map<String, Object> map = Encrypted("Hero");
        Payload((String) map.get("miwen"), (String) map.get("key"));
    }

}
