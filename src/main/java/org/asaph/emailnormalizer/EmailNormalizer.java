package org.asaph.emailnormalizer;

import java.util.HashMap;
import java.util.Map;

public abstract class EmailNormalizer {
    public final static Map<String, EmailNormalizer> DOMAIN_NORMALIZER_MAP = new HashMap<>();
    static {
        DOMAIN_NORMALIZER_MAP.put("gmail.com", new GmailNormalizer());
    }

    public abstract String normalize(String emailAddress);

    public static String getDomain(String emailAddress) {
        int atPosition = emailAddress.lastIndexOf('@');
        if (atPosition == -1) {
            return null;
        }
        return emailAddress.substring(atPosition + 1);
    }

    public static String getUsername(String emailAddress) {
        int atPosition = emailAddress.lastIndexOf('@');
        if (atPosition == -1) {
            return emailAddress;
        }
        return emailAddress.substring(0, atPosition);
    }
}
