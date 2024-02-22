This is the Marketplace platform. The Platform provides a number of stores. Each store has a list of products for sale.

This repo contains a SpringBoot project which has implemented functionality for stores. You will need to implement
functionality for products of those stores. The project contains two service's interfaces:

- [StoreService](src/main/java/dev/codescreen/marketplace/service/StoreService.java) - describes methods to manage stores (and it's implementation [InMemoryStoreService](src/main/java/dev/codescreen/marketplace/service/impl/InMemoryStoreService.java))

- [ProductService](src/main/java/dev/codescreen/marketplace/service/ProductService.java) - describes methods to manage products (not implemented)


## Tests
Run `mvn clean test` to run the unit tests. These should all pass if your solution has been implemented correctly.<br>
**Please** check that all the unit tests pass when you run `mvn clean test`, rather than solely running them from inside your IDE.

##
