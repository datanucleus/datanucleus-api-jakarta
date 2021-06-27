# datanucleus-api-jakarta

Support for DataNucleus persistence using the Jakarta Persistence API. 
The Jakarta Persistence API is simply a repackaged JPA, using package "jakarta.persistence" rather than "javax.persistence" for all classes, interfaces, annotations etc.

Jakarta "persistence provider" is [org.datanucleus.api.jakarta.PersistenceProviderImpl](https://github.com/datanucleus/datanucleus-api-jakarta/blob/master/src/main/java/org/datanucleus/api/jakarta/PersistenceProviderImpl.java).  
Jakarta EntityManagerFactory is implemented by [org.datanucleus.api.jakarta.JakartaEntityManagerFactory](https://github.com/datanucleus/datanucleus-api-jakarta/blob/master/src/main/java/org/datanucleus/api/jakarta/JakartaEntityManagerFactory.java).  
Jakarta EntityManager is implemented by [org.datanucleus.api.jakarta.JakartaEntityManager](https://github.com/datanucleus/datanucleus-api-jakarta/blob/master/src/main/java/org/datanucleus/api/jakarta/JakartaEntityManager.java).  
Jakarta Query is implemented by [org.datanucleus.api.jakarta.JakartaQuery](https://github.com/datanucleus/datanucleus-api-jakarta/blob/master/src/main/java/org/datanucleus/api/jakarta/JakartaQuery.java).  
Jakarta EntityTransaction is implemented by [org.datanucleus.api.jakarta.JakartaEntityTransaction](https://github.com/datanucleus/datanucleus-api-jakarta/blob/master/src/main/java/org/datanucleus/api/jakarta/JakartaEntityTransaction.java).  

This is built using Maven, by executing `mvn clean install` which installs the built jar in your local Maven repository.


## KeyFacts

__License__ : Apache 2 licensed  
__Issue Tracker__ : http://github.com/datanucleus/datanucleus-api-jakarta/issues  
__Javadocs__ : [6.0](http://www.datanucleus.org/javadocs/api.jakarta/6.0/)  
__Download__ : [Maven Central](https://repo1.maven.org/maven2/org/datanucleus/datanucleus-api-jakarta)  
__Dependencies__ : See file [pom.xml](pom.xml)  
__Support__ : [DataNucleus Support Page](http://www.datanucleus.org/support.html)  



## Jakarta Persistence Next Status

The Jakarta Persistence project is run by Eclipse, rather than using an "expert group" like previous persistence specs; largely made up of Oracle staff.
They do, however, provide an issue tracker for people to raise issues of what they would like to see in the "next" release of JPA (if/when it ever happens). 
DataNucleus, not being content to wait for hell to freeze over, has gone ahead and worked on the following issues. 
All of these are embodied in our "Jakarta Persistence 3.0" offering (DN 6.0+), so why wait until Oracle can be bothered ?

[jpa-spec-25](https://github.com/eclipse-ee4j/jpa-api/issues/25) : access the JPQL string query and native query from a JPA Query object. Done  
[jpa-spec-30](https://github.com/eclipse-ee4j/jpa-api/issues/30) : case sensitive JPQL queries. _Not implemented but would simply need JDOQL semantics copying_  
[jpa-spec-32](https://github.com/eclipse-ee4j/jpa-api/issues/32) : Support for javax.cache. Provided since very early javax.cache releases!  
[jpa-spec-35](https://github.com/eclipse-ee4j/jpa-api/issues/35) : support for more types. DataNucleus has provided way more types since JPA1 days!  
[jpa-spec-41](https://github.com/eclipse-ee4j/jpa-api/issues/41) : targetClass attribute for @Embedded. Provided in javax.persistence-2.2.jar  
[jpa-spec-42](https://github.com/eclipse-ee4j/jpa-api/issues/42) : allow null embedded objects. Provided by extension  
[jpa-spec-48](https://github.com/eclipse-ee4j/jpa-api/issues/48) : @CurrentUser on a field. Implemented using DN extension annotations  
[jpa-spec-49](https://github.com/eclipse-ee4j/jpa-api/issues/49) : @CreateTimestamp, @UpdateTimestamp. Implemented using DN extension annotations  
[jpa-spec-52](https://github.com/eclipse-ee4j/jpa-api/issues/52) : EM.createNativeQuery(String,Class). DN already works like that  
[jpa-spec-74](https://github.com/eclipse-ee4j/jpa-api/issues/74) : Method of obtaining @Version value. Available via NucleusJPAHelper  
[jpa-spec-76](https://github.com/eclipse-ee4j/jpa-api/issues/76) : Allow specification of null handling in ORDER BY. Provided in javax.persistence-2.2.jar for Criteria and also in JPQL string-based  
[jpa-spec-77](https://github.com/eclipse-ee4j/jpa-api/issues/77) : EMF should implement AutoCloseable. Done  
[jpa-spec-81](https://github.com/eclipse-ee4j/jpa-api/issues/81) : @Version Support for Temporal Types. Done  
[jpa-spec-85](https://github.com/eclipse-ee4j/jpa-api/issues/85) : Metamodel methods to get entity by name. Provided in javax.persistence-2.2.jar  
[jpa-spec-86](https://github.com/eclipse-ee4j/jpa-api/issues/86) : Allow multiple level inheritance strategy. Not explicitly done but we do this for JDO so likely mostly there  
[jpa-spec-100](https://github.com/eclipse-ee4j/jpa-api/issues/100) : Allow an empty collection_valued_input_parameter in an "IN" expression. Already works like this  
[jpa-spec-102](https://github.com/eclipse-ee4j/jpa-api/issues/102) : JPQL : DATE/TIME functions. Done, with Criteria changes provided in javax.persistence-2.2.jar  
[jpa-spec-103](https://github.com/eclipse-ee4j/jpa-api/issues/103) : JPQL : Allow use of parameter in more than just WHERE/HAVING. Done  
[jpa-spec-105](https://github.com/eclipse-ee4j/jpa-api/issues/105) : Allow AttributeConverter to multiple columns. Done but using vendor extension  
[jpa-spec-107](https://github.com/eclipse-ee4j/jpa-api/issues/107) : JPQL : support subqueries in SELECT. Done  
[jpa-spec-108](https://github.com/eclipse-ee4j/jpa-api/issues/108) : Path.get(PluralAttribute<X, C, E>) lower bound missing on X. Provided in javax.persistence-2.2.1.jar  
[jpa-spec-111](https://github.com/eclipse-ee4j/jpa-api/issues/111) : Allow side-effect free check whether a named query is available. DN throws IllegalArgumentException and doesn't kill the current transaction.  
[jpa-spec-112](https://github.com/eclipse-ee4j/jpa-api/issues/112) : EntityGraph generic type incorrect. Provided in javax.persistence-2.2.jar  
[jpa-spec-113](https://github.com/eclipse-ee4j/jpa-api/issues/113) : Allow @GeneratedValue on non-PK fields. Provided since JPA 1  
[jpa-spec-128](https://github.com/eclipse-ee4j/jpa-api/issues/128) : JPQL : Support JOIN on 2 root candidates. Done  
[jpa-spec-133](https://github.com/eclipse-ee4j/jpa-api/issues/133) : Make GeneratedValue strategy=TABLE value available in PrePersist. Done  
[jpa-spec-137](https://github.com/eclipse-ee4j/jpa-api/issues/137) : Add methods taking List to Criteria. Provided in javax.persistence-2.2.jar  
[jpa-spec-150](https://github.com/eclipse-ee4j/jpa-api/issues/150) : Define requirement of using TransactionSynchronizationRegistry in EE environment. Present since DN v3.x  
[jpa-spec-151](https://github.com/eclipse-ee4j/jpa-api/issues/151) : GenerationType.UUID. Provided in javax.persistence-2.2.jar. Supported since DN 2.x  
[jpa-spec-152](https://github.com/eclipse-ee4j/jpa-api/issues/152) : Native support for UUID class. Supported since DN 2.x  
[jpa-spec-163](https://github.com/eclipse-ee4j/jpa-api/issues/163) : Support for java.time.Instant. Supported since DN 4.x  
[jpa-spec-167](https://github.com/eclipse-ee4j/jpa-api/issues/167) : preUpdate is fired and always has been.  
[jpa-spec-169](https://github.com/eclipse-ee4j/jpa-api/issues/169) : root.get() does not add a join, and neither should it.  
[jpa-spec-171](https://github.com/eclipse-ee4j/jpa-api/issues/171) : round() is included in javax.persistence-2.2.jar. Supported from DN 5.2.x.  
[jpa-spec-207](https://github.com/eclipse-ee4j/jpa-api/issues/207) : Allow @Convert usage on id attributes. Supported since DN 4.x.  
[jpa-spec-237](https://github.com/eclipse-ee4j/jpa-api/issues/237) : Auto-Quote database identifiers to avoid use of SQL keywords. Supported since DN 1.x.  
[jpa-spec-297](https://github.com/eclipse-ee4j/jpa-api/issues/297) : Support for "SELECT ... AS identifier1, ... AS identifier2" in JPQL constructor expressions. Supported from DN 6.x  
[jpa-spec-316](https://github.com/eclipse-ee4j/jpa-api/issues/316) : math functions in queries. Supported since a long time ago.  
[jpa-spec-326](https://github.com/eclipse-ee4j/jpa-api/issues/326) : CriteriaBuilder avgDistinct,sumDistinct,minDistinct,maxDistinct. Supported from DN 6.x.  
