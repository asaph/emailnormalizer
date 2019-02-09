package org.asaph.emailnormalizer;

import static org.junit.jupiter.api.Assertions.*;
import static org.asaph.emailnormalizer.EmailNormalizer.*;

import org.junit.jupiter.api.Test;

class EmailNormalizerTest {

    @Test
    void testNormalizeEmail() {
        assertEquals("thisis@gmail.com", normalizeEmail("this.is+a.test@gmail.com"));
        assertEquals("thisis@gmail.com", normalizeEmail("this.is+a.test@GMAIL.COM"));
        String email = "this.is+a.test@example.com";
        assertSame(email, normalizeEmail(email));
    }

    @Test
    void testNormalize() {
        String email = "this.is+a.test@example.com";
        assertSame(email, new EmailNormalizer().normalize(email));
    }

    @Test
    void testGetDomain() {
        assertEquals("gmail.com", getDomain("this.is.a.test@gmail.com"));
    }

    @Test
    void testGetUsername() {
        assertEquals("this.is.a.test", getUsername("this.is.a.test@gmail.com"));
    }
}
