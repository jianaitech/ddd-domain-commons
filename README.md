# DDD Domain Commons
As [DDDSample](https://github.com/citerus/dddsample-core) project provides a whole Domain-Drive Design sample code with interfaces, application and other stuff mixed, you have to copy shared domain code in every DDD projects you get involved with. Now, you can do a quick setup of domain with shared common base classes for domain such as Entity, Value object, Repository, Domain Event etc. It's light weight and only has a dependency on Apache [commons-lang3](https://commons.apache.org/proper/commons-lang/) which is a basic extension of standard java libraries. 

## Building the project

- Gradle 3+
- Java 8 (the project produces Java 6 compatible bytecode but partially integrates with Java 8)

```shell
$ git clone https://github.com/spring-projects/spring-data-commons.git
$ cd spring-data-commons
$ gradle clean build
```

