package io.gchape.github.sqleditor.view.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class Secure {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String base64hash(int length) {
        var bytes = new byte[length];
        secureRandom.nextBytes(bytes);

        return Base64.getEncoder().encodeToString(bytes);
    }
}
