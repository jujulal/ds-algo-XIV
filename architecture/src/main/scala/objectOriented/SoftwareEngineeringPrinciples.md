Principles to follow writing an API / choosing API
-----------------------------------------------------

Standard Software engineering Principles([Uncle Bob](https://sites.google.com/site/unclebobconsultingllc/)) I follow

1) Single Responsibility Principle
  * one component should do one thing

2) Open Closed Principle
  * component should be open for extension, but closed for modification
  * meaning I should be able to extend existing component without a need to modify it

3) Liskov Substitution Principle (Adaptor)
  * any component I write should be replaceable or substituable

4) Interface Segregation Principle
  * no client should be forced to depend on methods it does not use.
  * abstraction

```java
public interface EventPublisher extends Closeable {                                                     
                                                                                                       
    /**                                                                                                
     * publishes the event and responds back the persisted event metadata                              
     *                                                                                                 
     * @param event input event to be written to stream                                                
     * @return event published to the stream                                                           
     * @throws EventStreamProducerException if producer can not write the event to stream              
     */                                                                                                
    BaseEvent publish(BaseEvent event) throws EventStreamProducerException;                            
}   
```

- Dependency Inversion Principle
  * form of decoupling software components

```java

    /**                                                                                                
     * instance for a event producer based on stream driver                                            
     * @return EventPublisher                                                                       
     */                                                                                                
    @Autowired                                                                                         
    EventPublisher eventPublisher;  
```

How spring encourages software engineering principles?
---------------------------------------------------------

- spring supports all of above principles and most importantly DI principle which was introduced 
in java ecosystem first by spring, and very few existing java APIs provide DI.

- introduced in 2002 (Rod Johnson, Australia) when the web API for java mostly being used was EJB (1998, which is pretty 
much dead because of complexity it offers)

- The strongest alternative to spring DI(2002) is google guice(2007).

- [Spring DI vs Guice DI, now Dagger](https://github.com/google/guice/wiki/SpringComparison)

Other principles to consider
----------------------------

1) DRY principle (Andy Hunt and Dave Thomas, The Pragmatic Programmer)
  * spring provides HTTP communication api (REST/SOAP) on top existing Servlet API
  * provides DI
  * provides component based dev (Single responsibility principle)

2) [convention over configuration](http://docs.spring.io/spring/docs/3.0.0.M4/reference/html/ch15s10.html) (my favourite) - started by DHH, Rails community
  * we think software engineering is easy, but always complex because of many ways of solving it
  * attempt to decrease the number of decisions that a software engineer
    using the any API is required to make without necessarily losing flexibility 

  * eg of coc, java web maven project structure
 
```java 
  src
  |_main/java
  |_main/resources
  |     |_application-dev.properties
  |     |_application-e2e.properties
  |     |_application-uat.properties
  |     |_application-prod.properties
  |_test/java
  |_test/resources
  |     |_application-componenttest.properties
  |_pom.xml
```

  * eg. profiling

3) TDD/ testability of API
  * spring offers [http test api](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html)
  * includes REST api testing

4) securing API
  * api to support secure http communication
  * token based communication or certificate based communication

Factors to consider choosing API
-----------------------------------

- software engineering principles
- problem (endpoint to print hello world vs massive computational endpoint)
- engineering resources (I only know Servlet API, but not Spring API, massive computational endpoint with 5 components, they will be reusable in future)
- delivery time (1 month)
 
Engineering References
-----------

https://en.wikipedia.org/wiki/Zen_of_Python

https://mail.python.org/pipermail/python-list/1999-June/001951.html

https://docs.spring.io/spring-boot/docs/current/reference/html/index.html

https://www.infoq.com/news/2015/11/uncle-bob-oath-programmer
