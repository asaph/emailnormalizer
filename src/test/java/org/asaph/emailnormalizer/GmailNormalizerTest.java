package org.asaph.emailnormalizer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GmailNormalizerTest {

    @Test
    void testNormalize() {
        assertEquals("thisis@gmail.com", new GmailNormalizer().normalize("this.is+a.test@gmail.com"));
    }

    @Test
    void testGetDomain() {
        assertEquals("gmail.com", new GmailNormalizer().getDomain("this.is.a.test@gmail.com"));
    }

    @Test
    void testGetUsername() {
        assertEquals("this.is.a.test", new GmailNormalizer().getUsername("this.is.a.test@gmail.com"));
    }

    @Test
    void testStripPlusAddress() {
        assertEquals("this.is@gmail.com", new GmailNormalizer().stripPlusAddress("this.is+a.test@gmail.com"));
    }

    @Test
    void testStripDotAddress() {
        assertEquals("thisisatest@gmail.com", new GmailNormalizer().stripDotAddress("this.is.a.test@gmail.com"));
    }
}
