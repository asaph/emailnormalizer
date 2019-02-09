Email Normalizer
==

This library normalizes email addresses. Some providers allow users to modify their email addresses
in ways that make them appear to be different addresses when in fact they still deliver to the same
mailbox.

For example, Gmail supports 2 varieties of ad-hoc email address modifications which will still deliver
mail to the same address.

1. Dots may be inserted arbitrarily into the username portion of any Gmail email address. e.g. Email sent to `a.b.c@gmail.com` gets delivered to the same mailbox as email sent to `abc@gmail.com`.

2. A `+` followed by an arbitrary suffix may be appended to the username portion of any Gmail email address. e.g. Email sent to `abc+def@gmail.com` gets delivered to the same mailbox as email sent to `abc@gmail.com`.

Usage:
--
```java
import static org.asaph.emailnormalizer.EmailNormalizer.*;

// ...

String email = "a.b.c@gmail.com";
String normalizedEmail = normalizeEmail(email);
System.out.println(normalizedEmail); // outputs abc@gmail.com

// another example

String anotherEmail = "abc+def@gmail.com";
String anotherNormalizedEmail = normalizeEmail(anotherEmail);
System.out.println(anotherNormalizedEmail); // outputs abc@gmail.com
```
