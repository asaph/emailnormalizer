package org.asaph.emailnormalizer;

public class GmailNormalizer extends EmailNormalizer {
    public String normalize(String emailAddress) {
        return stripDotAddress(stripPlusAddress(emailAddress));
    }

    public String stripPlusAddress(String emailAddress) {
        String domain = getDomain(emailAddress);
        String username = getUsername(emailAddress);
        int plusPosition = username.indexOf('+');
        if (plusPosition == -1) {
            return emailAddress;
        }
        return username.substring(0, plusPosition) + '@' + domain;
    }

    public String stripDotAddress(String emailAddress) {
        String domain = getDomain(emailAddress);
        String username = getUsername(emailAddress);
        return username.replace(".", "") + '@' + domain;
    }
}