package org.asaph.emailnormalizer;

import java.util.HashMap;
import java.util.Map;

public class EmailNormalizer {
    private final static EmailNormalizer DEFAULT_NORMALIZER = new EmailNormalizer();
    private final static Map<String, EmailNormalizer> DOMAIN_NORMALIZER_MAP = new HashMap<>();
    static {
        DOMAIN_NORMALIZER_MAP.put("gmail.com", new GmailNormalizer());
    }

    EmailNormalizer() {
    }

    String normalize(String emailAddress) {
        return emailAddress;
    }

    static String getDomain(String emailAddress) {
        int atPosition = emailAddress.lastIndexOf('@');
        if (atPosition == -1) {
            return null;
        }
        return emailAddress.substring(atPosition + 1);
    }

    static String getUsername(String emailAddress) {
        int atPosition = emailAddress.lastIndexOf('@');
        if (atPosition == -1) {
            return emailAddress;
        }
        return emailAddress.substring(0, atPosition);
    }

    public static String normalizeEmail(String emailAddress) {
        String domain = getDomain(emailAddress);
        EmailNormalizer normalizer = DOMAIN_NORMALIZER_MAP.getOrDefault(domain, DEFAULT_NORMALIZER);
        return normalizer.normalize(emailAddress);
    }
}
