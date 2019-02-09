package org.asaph.emailnormalizer;

import java.util.HashMap;
import java.util.Map;

public abstract class EmailNormalizer {
    public final static Map<String, EmailNormalizer> DOMAIN_NORMALIZER_MAP = new HashMap<>();
    static {
        DOMAIN_NORMALIZER_MAP.put("gmail.com", new GmailNormalizer());
    }

    public abstract String normalize(String emailAddress);
}
