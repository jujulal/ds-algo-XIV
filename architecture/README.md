
https://github.com/prayagupd/Scala-SOA


[How web works?](http://www.garshol.priv.no/download/text/http-tut.html) / What happens when I follow a link?
----------------------------------------------------

**Step 1: Parsing the URL**
 - Most URLs have this basic form: `protocol://server/request-URI`

**Step 2: Sending the request by browser** 
 - the browser transmits the following request to the server: 

```
"GET /request-URI HTTP/version”
```

[Step 3: CGI/ The server response](http://www.garshol.priv.no/download/text/http-tut.html)

```
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

Status codes
--------------

```
1xx: Reserved
2xx: Successful // gliffy, 2015
3xx: Redirection
4xx: Client error
5xx: Server error
```

[What is HTTP1.0/HTTPs/WebSocket?](https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol#HTTP_session)
--------------

```

```

[How can I prevent browsers from caching my page/script?](http://www.garshol.priv.no/download/text/http-tut.html)

This is done by setting the correct HTTP headers. If the Expiration header is set to a date/time in the past the output from the request will not be cached. (Note that HTTP requires browsers to keep the result in the browser history, so that going back to a non-cached page does not cause a new request.)

The expiration time can be set with a server-script or possibly by configuring the server correctly.

[Securing Web Services: REST over HTTPS vs SOAP with WS-Security. Which is better?](http://stackoverflow.com/a/853732/432903)

SOAP
----

- SOAP only support XML
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

- Atomicity in SOAP
  http://docs.oracle.com/cd/E14571_01/web.1111/e13734/transaction.htm#WSADV409
  http://stackoverflow.com/a/439621/432903
  
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

REST
----

- REST supports different media format like text, JSON, XML, RSS (Really Simple Syndication) etc.
- if we use JSON then definitely we will be in better place in terms of payload.
  [JSON and XML comparison](http://stackoverflow.com/a/4862530/432903)
  JSON is both more compact and more readable - in transmission it can be "faster" simply 
  because less data is transferred.

- Safety - Transport dependent
  REST over HTTP, all security measures applied HTTP are inherited and this is known as transport level security(TLS) 
  and it secures messages only while it is inside the wire but once you delivered it on the other side you don’t 
  really know how many stages it will have to go through before reaching the real point where the data will be processed. 
  And of course all those stages could use something different than HTTP.
  
  So REST is not safer completely, right?

- REST uses HTTP/HTTPS, but one of the advantages of SOAP is the use of the “generic” transport.

- Supports only SSL(Secure Sockets Layer), gliffy 2015, JWN 2016
  
  SSL is good only for P2P communication: 
  SSL works by encrypting the transport data between two end points. 
  For a Web Service, the call routes through more intermediaries nodes than just two end points. 
  Where as, WS Security solves this problem and its an END-TO-END Solution.

- As REST is limited by it's HTTP protocol so it’s transaction support is neither ACID compliant nor 
  can provide 2PC (two phase commit) across distributed transactional resources. JWN 2016

https://docs.google.com/document/d/1H_Zv_8QECBlWsmlg5Hmu4MDwVuCKTuXdgRYoC9rsOI4/edit#

http://martinfowler.com/articles/microservices.html

[crucial points to understand what REST is about](http://stackoverflow.com/a/19884975/432903) (AmEx, 2015)

[What is HTTP request/ response header?](https://en.wikipedia.org/wiki/List_of_HTTP_header_fields#Request_fields)
_HTTP header fields are -> components of the header section of request and response messages in the HTTP. 
They define the operating parameters of an HTTP transaction._

[HTTP Request Headers](http://webmasters.stackexchange.com/a/5661/14960) ;; some important headers for security purpose
------------------------

```
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

```js
$.ajax({
         url: "http://eSewa.com/SignIn",
         data: { signature: authHeader },
         type: "GET",
         beforeSend: function(xhr){
              xhr.setRequestHeader('Accept': 'text/plain', 
                                      'Cache-Control':    'no-cache');
         },
         success: function() { 
               console.log('Success!' + authHeader); 
         }
});
```

[Request Identification in J8/any RESTful service](http://stackoverflow.com/a/19896997/432903)
--------------------------------------------

You first need to understand that HTTP is a stateless protocol. (WebArchitecture, 2016)

- This means that each request that a client makes has no relation to any previous or future requests. 
However, as users, we very much want some state when interacting with a web application. 
A - bank application, for example, only wants you to be able to see and manage your transactions.
- A music streaming website might want to recommend some good beats based on what you've already heard.


To achieve this, the CookieMap (Spec) and Session concepts were introduced. 
- Cookies are KVPs, but with a specific format (see the links). 
- Sessions are server-side entities that store information (in memory or persisted) that spans multiple 
requests/responses between the server and the client.

The Servlet `HttpSession` uses a cookie with the key name `JSESSIONID` and a value that identifies the session.

The Servlet container keeps a map (YMMV) of `HttpSession` objects and these identifiers. 
- When a client first makes a request, the server creates an HttpSession object with a unique identifier and stores it in its map. 
- It then adds a --Set-Cookie header in the response. It sets the cookie's name to JSESSIONID and its value to the identifier it just created.
- Set-Cookie: JSESSIONID=64 byte string; expires=10/28/1989;

This is the most basic Cookie that a server uses. You can set any number of them with any information you wish. 

The Servlet API makes that a little simpler for you with the HttpServletResponse#addCookie(Cookie) method but you could do 
it yourself with the HttpServletResponse#addHeader(String, String) method.

[How Java webcontainer spawns new thread for each request?](http://www.tutorialspoint.com/servlets/servlets-life-cycle.htm)
------------------------------------------------------------------------------

How Server identifies its client?

- The client receives the `CookiesMap` and can store them somewhere, typically in a text file. 
When sending a new request to the server, it can use that cookie in the request's `--Cookie` header 
to notify the server that it might have done a previous request.

- When the Servlet container receives the request, it extracts the `--Cookie` header value and tries to 
retrieve an HttpSession object from its map by using the key in the `JSESSIONID` cookie. 

- This `HttpSession` object is then attached to the `HttpServletRequest` object that the Servlet 
container creates and passes to your Servlet.
You can use the `setAttribute(String, Object)` and `getAttribute(String)` methods to manage state.

GET Response header fields
-----------------------------

```
$ curl --HEAD https://www.tumblr.com/docs/en/api/v2
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

```
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

[What are request scopes in http requests?](http://www.java-samples.com/showtutorial.php?tutorialid=1009) (WebArchitecture, Jan2016)
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
WebSockets are just an extension of the socket idea. While HTTP was invented for the World Wide Web, and has been used by browsers since then, it had limitations. 
It was a particular protocol that worked in a particular way, and wasn’t well suited for every need. In particular was how HTTP handled connections. Whenever you made a request, say to download html, or an image, a port/socket was opened, data was transferred, and then it was closed.

The opening and closing creates overhead, and for certain applications, especially those that want rapid responses or real time interactions or display streams of data, this just doesn’t work.
```

http://reactivex.io/rxjs/manual/overview.html#introduction

Normally you register event listeners.

```
var button = document.querySelector('button');
button.addEventListener('click', () => console.log('Clicked!'));

Using RxJS you create an observable instead.

```
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

[Same-origin policy](https://developer.mozilla.org/en-US/docs/Web/Security/Same-origin_policy)
--------------------

```
restricts how a document or script loaded from one origin can interact with a resource from another origin. It is a critical security mechanism for isolating potentially malicious documents.
```
![](http://www.lucadentella.it/blog/wp-content/uploads/2013/07/cross-blocked.jpg)
