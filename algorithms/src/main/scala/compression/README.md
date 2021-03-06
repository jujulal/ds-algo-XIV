[Char/Data encoding](https://en.wikipedia.org/wiki/Character_encoding)
----------------

```
Depending on the abstraction level and context, corresponding code points and the resulting code 
space may be regarded as bit patterns, octets, natural numbers, electrical pulses, etc. 
```

[Base64 binary-to-text encoding](https://en.wikipedia.org/wiki/Base64)
-------------------------------

```
represent binary data in an ASCII string format by translating it into a radix-64 representation

$ echo -n 'A' | openssl base64
QQ==

$ echo A | python -m base64
QQo=


- binary values for ASCII of input are joined together into a 24-bit string
- which are then converted into their corresponding Base64 character values.

```


[Why Base64 B2T encoding](https://stackoverflow.com/a/201510/432903)
-------------------

```
When I have some binary data that I want to ship across a network, I generally don't do it by
just streaming the bits and bytes over the wire in a raw format.

Why no bits/bytes streaming?
----------------------------

because some media are made for streaming text.
* I never know -- some protocols may interpret my binary data as control characters (like a modem),
* or my binary data could be screwed up because the underlying protocol might think that I've entered
a special character combination (like how FTP translates line endings).

So to get around this, people encode the binary data into characters. Base64 is one of these types 
of encodings.

Why 64?
-------

Because you can generally rely on the same 64 characters being present in many character sets, 
and you can be reasonably confident that your data's going to end up on the other side of the wire 
uncorrupted.
```

eg.

```clj
user=> (let [encoder (java.util.Base64/getEncoder)] (.encodeToString encoder (.getBytes "ABCD")))
"QUJDRA=="

user=> (.length (.encodeToString (java.util.Base64/getEncoder) (.getBytes "ABCD")))
8 bytes
```

```scala
scala> import java.nio.charset.StandardCharsets
import java.nio.charset.StandardCharsets

scala> java.util.Base64.getEncoder.encodeToString("username:password".getBytes(StandardCharsets.UTF_8))
res0: String = dXNlcm5hbWU6cGFzc3dvcmQ=
```

[8-bit clean computer system](https://en.wikipedia.org/wiki/8-bit_clean)

_a computer system that correctly handles 8-bit character encodings, such as the ISO 8859 series 
and the UTF-8 encoding of Unicode_

[Data compression](https://en.wikipedia.org/wiki/Data_compression)
---------------------

- lossy
  eg. [JPEGroup compression](https://stackoverflow.com/a/25153481/432903)

- lossless

[Why use deflate compression instead of gzip for text files served by Apache?](http://stackoverflow.com/a/9856879/432903)

```
GZip is simply deflate plus a checksum and header/footer. Deflate is faster, though.
```

https://en.wikipedia.org/wiki/DEFLATE


google snappy
-----

https://docs.mongodb.com/manual/reference/glossary/#term-snappy

z-lib
-------

DES, symmetric-key algorithm, 70s
------------------------------

![](https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/DES-main-network.png/500px-DES-main-network.png)



