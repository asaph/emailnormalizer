package org.asaph.emailnormalizer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GmailNormalizerTest {

    @Test
    void testNormalize() {
        assertEquals("thisis@gmail.com", new GmailNormalizer().normalize("this.is+a.test@gmail.com"));
    }

    @Test
    void testStripPlusAddress() {
        assertEquals("this.is@gmail.com", GmailNormalizer.stripPlusAddress("this.is+a.test@gmail.com"));
    }

    @Test
    void testStripDotAddress() {
        assertEquals("thisisatest@gmail.com", GmailNormalizer.stripDotAddress("this.is.a.test@gmail.com"));
    }
}
