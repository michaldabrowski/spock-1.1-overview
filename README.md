2016.12.29 - Spock 1.1 features overview
========================================

New features
------------

-	`@PendingFeature` - annotation to distinguish incomplete functionality from features with `@Ignore`

`PendingFeatureSpec`

-	The `verifyAll` method can be used to assert multiple boolean expressions without short-circuiting those after a failure

`VerifyAllSpec`

-	`@SpringBootTest` and other Spring Boot 1.4 annotations support

-	Detached mocks via the `DetachedMockFactory` and `SpockMockFactoryBean`

Allow mock/stub/spy creation outside of specification. Useful for Spring test configurations.

```java
@WebMvcTest
class WebMvcTestIntegrationSpec extends Specification {

  @Autowired
  MockMvc mvc

  @Autowired
  HelloWorldService helloWorldService

  def "spring context loads for web mvc slice"() {
    given:
        helloWorldService.getHelloMessage() >> 'hello world'

    expect: "controller is available"
        mvc.perform(MockMvcRequestBuilders.get("/"))
          .andExpect(status().isOk())
          .andExpect(content().string("hello world"))
  }

  @TestConfiguration
  static class MockConfig {
    def detachedMockFactory = new DetachedMockFactory();

    @Bean
    HelloWorldService helloWorldService() {
      return detachedMockFactory.Stub(HelloWorldService)
    }
  }
}
```

-	Cells in a data table can refer to the current value for a column to the left

`CellTableReferenceSpec`

-	Spy can be used to create partial mocks for Java 8 interfaces with default methods just as it can for abstract classes

-	Adds compatibility with **ByteBuddy** as an alternative to **cglib** for generating mocks and stubs for classes

Reminder: cglib allows mocking of classes (in addition to interfaces), objenesis allows mocking of classes without default constructor (together with CGLIB

-	Bug fixes, assert output improvements etc

Extra
-----

Demo `CompactMockCreationSyntaxSpec`

Sources
-------

-	http://spockframework.org/spock/docs/1.1-rc-3/release_notes.html
-	https://solidsoft.wordpress.com/2016/11/28/more-compact-mock-creation-syntax-in-spock-1-1/
-	http://spockframework.org/spock/docs/1.1-rc-3/module_spring.html#_spring_module
-	own experiences with Spock 1.1-rc-2
