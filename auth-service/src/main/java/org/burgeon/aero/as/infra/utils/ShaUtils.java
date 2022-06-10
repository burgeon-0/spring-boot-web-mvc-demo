package org.burgeon.aero.as.infra.utils;

import lombok.SneakyThrows;
import org.springframework.security.crypto.codec.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author Sam Lu
 * @date 2021/11/30
 */
public class ShaUtils {

    @SneakyThrows
    public static String sha256(String str, String salt) {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(salt.getBytes(StandardCharsets.UTF_8));
        byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
        String sha256hex = new String(Hex.encode(hash));
        return sha256hex;
    }

}
