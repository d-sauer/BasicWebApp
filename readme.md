# BasicWebApp

Basic web app using Spring and AngularJS.
Created by following tutorial from youtube: Web Development Using Spring and AngularJS by Christopher Henkel

### Video references:
- [Web Development Using Spring and AngularJS - Tutorial 1](https://www.youtube.com/watch?v=Sc2atFv_h_I)
- [Web Development Using Spring and AngularJS - Tutorial 2](https://www.youtube.com/watch?v=Z9QWD6my7bc)
- [Web Development Using Spring and AngularJS - Tutorial 3](https://www.youtube.com/watch?v=ccPs-MqIGDA)
- [Web Development Using Spring and AngularJS - Tutorial 4](https://www.youtube.com/watch?v=wmbS20Nnuq0)


# Notes / hints
## Setup project
1. Create project with Maven
'''    
mvn archetype:create -DgroupId=org.basewebapp -DartifactId=BaseWebApp -DarchetypeArtifactId=maven-archetype-webapp
'''

File 'mvc-dispatcher-servler.xml' is mapped by servlet definition in 'web.xml', by adding suffix '-servlet' to filename.

## TDD
JUnit, Mockito

## jsonPath
Using JsonPath:
- '$' represent root

## Spring hateoas
http://projects.spring.io/spring-hateoas/
ResourceAssemblerSupport<ClassConvertingFrom, ClassConvertingTo>