## Spring Boot - Configuration with Jasypt

The encryptor password shouldn't be stored in properties file, it should be rather be passed as a system variable, command line argument or environment variable.

### Depencency

```
<dependency>
    <groupId>com.github.ulisesbocchio</groupId>
    <artifactId>jasypt-spring-boot-starter</artifactId>
    <version>2.1.1</version>
</dependency>
```
