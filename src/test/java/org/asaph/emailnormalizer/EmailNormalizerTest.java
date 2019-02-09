package org.asaph.emailnormalizer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailNormalizerTest {

    @Test
    void testNormalize() {
        String email = "this.is+a.test@example.com";
        assertSame(email, new EmailNormalizer().normalize(email));
    }

    @Test
    void testGetDomain() {
        assertEquals("gmail.com", EmailNormalizer.getDomain("this.is.a.test@gmail.com"));
    }

    @Test
    void testGetUsername() {
        assertEquals("this.is.a.test", EmailNormalizer.getUsername("this.is.a.test@gmail.com"));
    }
}
