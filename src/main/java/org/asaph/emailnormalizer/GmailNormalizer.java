package org.asaph.emailnormalizer;

public class GmailNormalizer implements EmailNormalizer {
    public String normalize(String emailAddress) {
        return stripDotAddress(stripPlusAddress(emailAddress));
    }

    public String getDomain(String emailAddress) {
        int atPosition = emailAddress.lastIndexOf('@');
        if (atPosition == -1) {
            return null;
        }
        return emailAddress.substring(atPosition + 1);
    }

    public String getUsername(String emailAddress) {
        int atPosition = emailAddress.lastIndexOf('@');
        if (atPosition == -1) {
            return emailAddress;
        }
        return emailAddress.substring(0, atPosition);
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