
https://github.com/prayagupd/Scala-SOA

[How two computers can communicate?](https://www.quora.com/What-is-the-difference-between-HTTP-protocol-and-TCP-protocol/answer/Daniel-Miller-7)
--------------------------------------------

Essentially, there are different protocols that let a computer talk at different distances and 
different layers of abstraction.

- **At the very bottom of the network stack is the physical layer.** This is where electrical signals 
or light pulses or radio waves actually transmit information from place to place.

You can transmit information directly this way, but you need a lot of power or a dedicated line, 
and without higher layers you won't be able to share bandwidth.

- **The next layer up is the link layer.**
This layer covers communication with devices that share a physical communications medium. 

Here, protocols like Ethernet, 802.11a/b/g/n, and Token Ring specify how to handle multiple 
concurrent accesses to the physical medium and how to direct traffic to one device instead of another.

- **The third layer is the network layer.** 
In the majority of cases, this is dominated by Internet Protocol (IP). 
This is where the magic of the Internet happens, and you get to talk to a computer halfway around 
the world, without needing to know where it is. 

[Comparing TCP/IP applications vs HyperTextTP applications](https://softwareengineering.stackexchange.com/a/214251/31060)

```
TCP is a protocol in the transport layer and HTTP is a protocol in the application layer.

HTTP is over TCP/IP

You want to add a application layer protocol over TCP (like HTTP) and then a content-type (like json, xml, html). 
Netty let you use HTTP and content-type as protobuff which is equivalent to json, xml, html.
```

[How web works?](http://www.garshol.priv.no/download/text/http-tut.html) / What happens when I hit a http endpoint/ follow a link?
----------------------------------------------------

**Step 1: Parsing the URL**
 - Most URLs have this basic form: `protocol://server/request-URI(Uniform Resource Identifier)`

[UniformResource I vs L vs N](https://stackoverflow.com/a/28865728/432903)
- a UniformResource I identifies, a UniformResource L identifies and locates.
- eg. UniformResource I/N `urn:isbn:0-486-27557-4`
- UniformResource I/L `file://hostname/sharename/RomeoAndJuliet.pdf`

**Step 2: Sending the request by browser with header infos** 
 - the browser transmits the following request to the server: 

```
"GET /request-URI HTTP/version”
```

[Step 3: CGI/ The server response](http://www.garshol.priv.no/download/text/http-tut.html)

```bash
HTTP/1.0 200 OK
Server: Netscape-Communications/1.1
Date: Tuesday, 25-Nov-97 01:22:04 GMT
Last-modified: Thursday, 20-Nov-97 10:44:53 GMT
Content-length: 6372
Content-type: text/html

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<HTML>
...followed by document content...
```

what is [CommonGatewayInterface](https://stackoverflow.com/a/5058873/432903)?

```
a standard protocol for web servers to execute programs that execute like CLI programs 
running on a server that generates web pages dynamically.
```

[Hypertext Transfer Protocol -- HTTP/1.1 Draft](http://greenbytes.de/tech/webdav/rfc2616.html#rfc.status)

[HyperTextTP Status codes](https://www.iana.org/assignments/http-status-codes/http-status-codes.xhtml), BBY, 2017
--------------

| code | for                         | desc                     |                    
|------|-----------------------------|--------------------------|                                        
|1xx   | Informational               | 102        Processing    |                                        
|2xx   | Successful // gliffy, 2015  | 201        Created       |                               
|      |                             | 202        Accepted        |                                 
|      |                             | 208        Already Reported|                                        
|3xx   | Redirection                 | 301        Moved Permanently |                                    
|4xx   | Client error                | 400        Bad Request          |                                 
|      |                             | 401        Unauthorized         |                                 
|      |                             | 405        Method Not Allowed   |                                 
|5xx   | Server error                | 500        Internal Server Error|                                 
|      |                             | 501        Not Implemented      |

[What is HTTP1.0/HTTPs/WebSocket?](https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol#HTTP_session)
--------------

https://stackoverflow.com/a/247026/432903

```
| HTTP 1.0                                                        | HTTP 1.1
| - have to open a new connection for each request/response pair. | - allows you to have persistent connections which means that you can have more than
| And after each response the connection would be closed.         | one request/response on the same HTTP connection
|                                                                 | - OPTIONS method - to determine the abilities of the HTTP server.
| - had caching via `If-Modified-Since`                           | - added `ETag` - https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/ETag
```

[difference between HTTP 1.1 and HTTP 2.0](https://stackoverflow.com/a/28592132/432903)

```
HTTP 2.0 is a binary protocol that multiplexes numerous streams going over a single 
(normally TLS-encrypted) TCP connection.
```

[How can I prevent browsers from caching page/script responded from http server?](http://www.garshol.priv.no/download/text/http-tut.html)

_This is done by setting the correct HTTP headers. If the Expiration header is set to a date/time 
in the past the output from the request will not be cached. 

(Note that HTTP requires browsers to keep the result in the browser history, so that going back 
to a non-cached page does not cause a new request.)

The expiration time can be set with a server-script or possibly by configuring the server correctly._

[Securing Web Services: REST over HTTPS vs SOAP with WS-Security. Which is better?](http://stackoverflow.com/a/853732/432903)

Simple Object Access Protocol - [SOAP](https://en.wikipedia.org/wiki/SOAP)
----

- SimpleOAP only supports content-type XML
- Microsoft originally developed SOAP to take the place of older technologies that don’t work well on the Internet such 
  as the Distributed Component Object Model (DCOM) and Common Object Request Broker Architecture (CORBA). 
  These technologies fail because they rely on binary messaging; the XML messaging that SOAP employs works better over 
  the Internet.

- Safety - [Transport independent](http://blog.smartbear.com/apis/understanding-soap-and-rest-basics/)
  SOAP relies on XML in 3 ways 
  * Envelope – that defines what is in the message and how to process it.
  * A set of encoding rules for data types, and finally 
  * the layout of the procedure call(RPC)s and responses gathered.
  
  This envelope is sent via a transport (HTTP/HTTPS), and an RPC is executed and the envelope is returned with 
  information in a XML formatted document.
  
- SOAP can use almost any transport to send the request but REST cannot. So here we got an advantage of using SOAP.

- SOAP supports SSL and WS-Security which adds some enterprise security features. 
  WS-Security offers protection from the creation of the message to it’s consumption. So for TLS whatever loophole 
  we found that can be prevented using WS-Security.

- [Atomicity in SOAP](http://docs.oracle.com/cd/E14571_01/web.1111/e13734/transaction.htm#WSADV409)
  
  [Transaction rollback and web services](http://stackoverflow.com/a/439621/432903)
  
SOAP request example

```html
<script type="text/javascript">
        function soap() {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.open('POST', 'https://somesoapurl.com/', true);

            // build SOAP request
            var soapRequest =
                '<?xml version="1.0" encoding="utf-8"?>' +
                '<soapenv:Envelope ' + 
                    'xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" ' +
                    'xmlns:api="http://127.0.0.1/Integrics/Enswitch/API" ' +
                    'xmlns:xsd="http://www.w3.org/2001/XMLSchema" ' +
                    'xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">' +
                    '<soapenv:Body>' +
                        '<api:some_api_call soapenv:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/">' +
                            '<username xsi:type="xsd:string">prayagupd</username>' +
                            '<password xsi:type="xsd:string">bcrypt</password>' +
                        '</api:some_api_call>' +
                    '</soapenv:Body>' +
                '</soapenv:Envelope>';

            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4) {
                    if (xmlhttp.status == 200) {
                        console.log('done use firebug to see response');
                    }
                }
            }
            // Send the POST request
            xmlhttp.setRequestHeader('Content-Type', 'text/xml');
            xmlhttp.send(soapRequest);
            // send request
            // ...
        }
    </script>
```


[Why SOAP? (WAA, Jan 2016)](http://www.dotnetblocks.com/post/2011/11/21/When-to-use-SOAP-over-REST.aspx)

[REp State Transfer](http://www.restapitutorial.com/lessons/whatisrest.html)
-------------------------------------------------------------

- REST supports different media format like text, JSON, XML, RSS (Really Simple Syndication) etc.
- if I use JSON then definitely we will be in better place in terms of payload.
  [JSON and XML comparison](http://stackoverflow.com/a/4862530/432903) (4M vs 300K)
  JSON is both more compact and more readable - in transmission it can be "faster" simply 
  because less data is transferred.

- Safety - Transport dependent
  REST over HTTP, all security measures applied HTTP are inherited and this is known as transport level security(TLS) 
  and it secures messages only while it is inside the wire but once you delivered it on the other side you don’t 
  really know how many stages it will have to go through before reaching the real point where the data will be processed. 
  And of course all those stages could use something different than HTTP.
  
  So REST is not safer completely, right?

- REST uses HTTP/HTTPS as application protocol, but one of the advantages of SOAP is the use of the 
  “generic” transport. (most important to remember)

- Supports only TLS/SSL(Secure Sockets Layer), gliffy 2015, JWN 2016
  
  TLS is good only for P2P communication: 
  
  ! TLS works by encrypting the transport data between two end points. 
  
  ! For a Web Service, the call routes through more intermediaries nodes than just two end points. 
    where as, WS Security solves this problem and its an END-TO-END Solution.

- As REST is limited by it's HTTP protocol so it’s transaction support is neither ACID compliant nor
  can provide 2PC (two phase commit) across distributed transactional resources. JWN 2016

https://docs.google.com/document/d/1H_Zv_8QECBlWsmlg5Hmu4MDwVuCKTuXdgRYoC9rsOI4/edit#

http://martinfowler.com/articles/microservices.html

[crucial points to understand what REST is about](http://stackoverflow.com/a/19884975/432903) (AmEx, 2015)

[What is HTTP request/ response header?](https://en.wikipedia.org/wiki/List_of_HTTP_header_fields#Request_fields)

_HTTP header fields are -> components of the header section of request and response messages in the HTTP. 
They define the operating parameters of an HTTP transaction._

[Can REST be implemented over FTP, not just HTTP?](https://stackoverflow.com/a/35535386/432903)

[HypertextTP request methods](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods), BBY, 2017
---------------------

```
| method  | 
|---------|-------------------
| GET     | R
| HEAD    | 
| POST    | C
| PATCH   | U/Mofidy
| PUT     | U/Replace
| DELETE  | D
|         | 
| CONNECT | 
| OPTIONS | 
| TRACE   | 
```

http://www.restapitutorial.com/lessons/httpmethods.html

[HTTP Request Headers](https://www.w3.org/Protocols/rfc2616/rfc2616-sec5.html), BBY, 2017

```
request-header = Accept             
              | Accept-Charset      
              | Accept-Encoding     
              | Accept-Language     
              | Authorization       
              | Expect              
              | From                
              | Host                
              | If-Match            
              | If-Modified-Since   
              | If-None-Match       
              | If-Range            
              | If-Unmodified-Since 
              | Max-Forwards        
              | Proxy-Authorization 
              | Range               
              | Referer             
              | TE                  
              | User-Agent
```

```js
$.ajax({
         url: "http://eSewa.com/SignIn",
         data: { signature: authHeader },
         type: "GET",
         beforeSend: function(xhr){
              xhr.setRequestHeader('Accept': 'text/plain', 
                                   'Cache-Control': 'no-cache');
         },
         success: function() { 
               console.log('Success!' + authHeader); 
         }
});
```

HTTP Security/ HTTP auth
--------------------

risks - sessions sniffed in HTTP

https://en.wikipedia.org/wiki/Transport_Layer_Security

http://docs.aws.amazon.com/AmazonS3/latest/dev/S3_Authentication2.html

http://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html#UsingTemporarySecurityCredentials

[Cryptographies vs Hashing](https://stackoverflow.com/a/4948393/432903)
--------------------------

_Encryption should only ever be used over hashing when it is a necessity to decrypt 
the resulting message._

                         ----------------------------------------       ---------------------------
payload -> encryption -> encrypted payload           connection tunnel  socket endpoint -> decryption -> payload
                         ----------------------------------------       --------------------------

Adv Encrption Standard(AES) - 128bits

SHA256 - 256 bits

[Pretty Good Privacy(PGP)](https://en.wikipedia.org/wiki/Pretty_Good_Privacy) - http://www.pitt.edu/~poole/accessiblePGP703.htm

[Security & Authentication: TLS protocol vs SASL framework](https://stackoverflow.com/a/11385658/432903)

Payload validation with checksum

[Hash-based MAC](https://en.wikipedia.org/wiki/Hash-based_message_authentication_code)

```scala
val hash_based_auth_code = function hash_based_mac ("SHA-1" or "MD5", message) {
}
```

Hash-based Message auth code 

```scala
scala> import javax.crypto._
import javax.crypto._

scala> val key = KeyGenerator.getInstance("HmacMD5").generateKey()
key: javax.crypto.SecretKey = javax.crypto.spec.SecretKeySpec@3d0dcd45

scala> val m_auth_code = Mac.getInstance("HmacMD5")
m_auth_code: javax.crypto.Mac = javax.crypto.Mac@151ef57f

scala> m_auth_code.init(key)

scala> m_auth_code.doFinal("prayagupd".getBytes())
res1: Array[Byte] = Array(92, 124, 54, -100, -22, -122, 32, 43, 64, -41, -119, -20, 47, -94, 108, -6)

scala> import java.math.BigInteger
import java.math.BigInteger

scala> new BigInteger(m_auth_code.doFinal("prayagupd".getBytes()))
res32: java.math.BigInteger = -19609729033103877021779594872999511452

scala> new BigInteger(m_auth_code.doFinal("prayagupd".getBytes())).toString(16)
res33: String = -ec0b2498a01c19031cdd580662e059c
```

https://security.stackexchange.com/questions/36932/what-is-the-difference-between-ssl-and-x-509-certificates

[Request Identification in RESTful/Java webservice](http://stackoverflow.com/a/19896997/432903)
--------------------------------------------

You first need to understand that HyperTextTP is a stateless protocol. (WebArchitecture, 2016)

- This means that each request that a client makes has no relation to any previous or future requests. 
However, as users, we very much want some state when interacting with a web application. 
A - bank application, for example, only wants you to be able to see and manage your transactions.
- A music streaming website might want to recommend some good beats based on what you've already heard.


<b>To achieve this, the `CookieMap` (Spec) and Session concepts were introduced.</b>

- Cookies are KVPs, but with a specific format (see the links). 
- `Session`s are server-side entities that store information (in memory or persisted) that spans multiple 
requests/responses between the server and the client. (Intempt, 2015)

The HttpServlet `HttpSession` uses a cookie with the key name `JSESSIONID` and a value that identifies 
the session.

The HttpServlet container keeps a map (YMMV) of `HttpSession` objects and these JSESSIONID identifiers. 

- When a client first makes a request, the server creates an HttpSession object with a unique identifier 
and stores it in its map. 
- It then adds a `--Set-Cookie` header in the response. It sets the cookie's name to `JSESSIONID` and 
its value to the identifier it just created.
- `Set-Cookie: JSESSIONID=64 byte string; expires=10/28/2039;`

- Then client store the JSESSIONID somewhere in filesystem. eg, chrome client, 

`/Users/urayagppd/Library/Application\ Support/Google/Chrome/Default/Cookies`

This is the most basic Cookie that a server uses. You can set any number of them with any 
information you wish. 

The HttpServlet API makes that a little simpler with the `HttpServletResponse#addCookie(Cookie)`
method but you could do it yourself with the `HttpServletResponse#addHeader(String, String)` method.

[How Java webcontainer spawns new thread for each request?](http://www.tutorialspoint.com/servlets/servlets-life-cycle.htm)
------------------------------------------------------------------------------

How Server identifies its client?

- The client receives the `CookiesMap` and can store them somewhere, typically in a text file. 
When sending a new request to the server, it can use that cookie in the request's `--Cookie` header 
to notify the server that it might have done a previous request.

- When the Servlet container receives the request, it extracts the `--Cookie` header value and tries to 
retrieve an `HttpSession` object from its map by using the key in the `JSESSIONID` cookie. 

- This `HttpSession` object is then attached to the `HttpServletRequest` object that the Servlet 
container creates and passes to your Servlet.
You can use the `setAttribute(String, Object)` and `getAttribute(String)` methods to manage state.

HypertextTP GET Response header fields
---------------------------------------

```bash
$ curl -v --HEAD --http1.1 https://www.tumblr.com/docs/en/api/v2
HTTP/1.1 200 OK
Server: openresty
Date: Sat, 15 Oct 2016 01:37:16 GMT
Content-Type: text/html; charset=UTF-8
Connection: keep-alive
Vary: Accept-Encoding
Vary: Accept-Encoding
P3P: CP="Tumblr's privacy policy is available here: https://www.tumblr.com/policy/en/privacy"
X-Frame-Options: deny
X-UA-Compatible: IE=Edge,chrome=1
Accept-Ranges: bytes ;; https://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html
```

```bash
curl -iX OPTIONS https://www.tumblr.com/docs/en/api/v2
HTTP/1.1 200 OK
Server: openresty
Date: Mon, 24 Oct 2016 07:36:40 GMT
Content-Type: text/html; charset=UTF-8
Content-Length: 4
Connection: keep-alive
Vary: Accept-Encoding
Set-Cookie: tmgioct=580dba082b52000104091160; expires=Thu, 22-Oct-2026 07:36:40 GMT; Max-Age=315360000; path=/; domain=.tumblr.com; HttpOnly
X-UA-Compatible: IE=Edge,chrome=1
Accept-Ranges: bytes

done
```

[Security headers](http://webmasters.stackexchange.com/a/5661/14960)

```bash
# Don't allow any pages to be framed by my site or any others
# Defends against Clickjacking!
Header set X-Frame-Options DENY

# Only allow JavaScript from the same domain to be run.
# Also, don't allow inline JavaScript to run. 
Header set X-Content-Security-Policy "allow 'self';"

# Turns on IE 8 XSS prevention tools
Header set X-XSS-Protection "1; mode=block"

# Don't send out the Server header. This way no one knows what 
# version of Apache and PHP I am using
Header unset Server
```


[What are request scopes in HTTP requests?](http://www.java-samples.com/showtutorial.php?tutorialid=1009) (WebArchitecture, Jan2016)
```
scope="request" (same both in jsp/ spring)
scope="session" (same both in jsp/ spring)
scope="application" (global-session in spring)
```

Suggested readings
--------------------

https://en.wikipedia.org/wiki/Request%E2%80%93response

https://en.wikipedia.org/wiki/Futures_and_promises

http://reactivesocket.io/

http://jsuereth.com/scala-arm/sockets.html

https://www.playframework.com/documentation/2.5.x/ScalaWebSockets

[HTTP/REST vs WebSocket/Reactive proramming](https://www.pubnub.com/blog/2015-01-05-websockets-vs-rest-api-understanding-the-difference/)

```
WebSockets are just an extension of the socket idea. While HyperTextTP was invented for the World Wide Web, 
and has been used by browsers since then, it had limitations. 

It was a particular protocol that worked in a particular way, and wasn’t well suited for every need. 

In particular was how HTTP handled connections. Whenever you made a request, say to download html bytes, 
or an image bytes, a port/socket was opened, data was transferred, and then it was closed.

The opening and closing creates overhead, and for certain applications, especially those that want 
rapid responses or real time interactions or display streams of data, this just doesn’t work.
```

http://reactivex.io/rxjs/manual/overview.html#introduction

Normally you register event listeners.

```
var button = document.querySelector('button');
button.addEventListener('click', () => console.log('Clicked!'));
```

Using RxJS you create an observable instead.

```javascript
var button = document.querySelector('button');
Rx.Observable.fromEvent(button, 'click')
  .subscribe(() => console.log('Clicked!'));
```

http://doc.akka.io/docs/akka/2.3.3/scala/io-tcp.html

http://spray.io/msug/#/

http://socket.io/

http://www.eclipse.org/jetty/

```
a Web server and javax.servlet container, plus support for HTTP/2, WebSocket
```

[Number of http server request threads (default 200 in tomcat)?](https://stackoverflow.com/a/14249848/432903)

[Same-origin policy](https://developer.mozilla.org/en-US/docs/Web/Security/Same-origin_policy)
--------------------

```
restricts how a document or script loaded from one origin can interact with a resource from another origin. 

It is a critical security mechanism for isolating potentially malicious documents.
```

[Why is same origin policy kicking in when making request from localhost to localhost?](https://stackoverflow.com/a/14263091/432903)

```
An origin is defined by the scheme://host:port of a URL
```

https://enable-cors.org/server.html

```bash
Access-Control-Allow-Origin: *
```

https://enable-cors.org/client.html

![](http://www.lucadentella.it/blog/wp-content/uploads/2013/07/cross-blocked.jpg)

Caching
--------

https://en.wikipedia.org/wiki/HTTP_ETag

```
etag provides for web cache validation, which allows a client to make conditional requests


```

[What is the difference between a port and a socket?](https://stackoverflow.com/a/152863/432903)

[Difference between socket connection and tcp connection?](https://stackoverflow.com/a/6419968/432903)

```
a socket is an endpoint in a (bidirectional) communication over the TCP/IP stack
```
