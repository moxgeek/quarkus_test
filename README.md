# Demo for Smart.IX

This project uses Quarkus, the Supersonic Subatomic Java Framework.
it's only a test and it will be deleted soon

> **_NOTE:_** 
thank you to letting me discover quarkus, i did play with it, especially with the Rest Api, and it's fun to be honest.
it's my first time that im fully satisfied with a java/kotlin framework who answer all the issues that can be found in traditional java framework.
so thank you so much.

the idea here is to put logical process for smartServices and smartDevices with respective features for each.

at first, the text wasn't clear, especially defining smart features and smart models.

the pattern at the begging was to use compositor to address the composition within smart model and smart features.
the trash_model ( sorry for the snack case :) ) is dumpy folder for the initial idea.

however, after taking it more logical, it's make sense that smartModel a template for Smart Device and Smart Service
and each Smart model has it's own features.

additionally i did use some compositor in this case to address the (potential case features can have featuers also, the example is in the comment with the code)


with that,  the architecture between the db and the classes are totally different.

in my opinion ( and that what i did !), the classes and the db need to be different especially in multi level classes and with the extensibility.
### IN THIS CASE:

__#### DB__

has only one table to reflect smartModel ( devices and services)
and a separated table for linking a list of features with models.
it can be discussed the fact we can store everything as a array / json ( thanks to mongodb)
however this design will not be greate with my choice of MYSQL.(_read bellow to know why MYSQL_)

__#### CLASSES__

the class of course use the model as a parent class with default attributs
service extend the parent class (model) and use the default defined functions as they are (just super),
or in ```doAction```  as adding additional attribute (protocol and url -  communications -)
protocol has the ability to have only 5 chars ( i never sow something bigger than that)
the url is the host where we can get the service
(maybe this is not what you bealive a service can be so execuse my stupidity :D )

the same story for Device with only ```brandName``` (maybe there is no brandName, but it's for demonstration) 

both has a list of features in the parent class.
with some annotation to respect the auto_generation of database.


used panache with repository pattern, and using a 'draft' Grpc Controller.
( sorry for the ugly function to fill the db, maybe using the proprities file intead with a sql script fill with insertion)


the db used in  this case is mysql , however i test it also with postgres (that why you will see the depencdency in pom)

the choice was random to be honest, however i believe in a real scenario case redis will do the trick
why ? 
Sub and pub architecture and  the extensibility with MQTT communication (why using AMQP ??)



before running the script, make sure the run a mysql in a docker container:
```docker run --rm=true --name quarkus_test -e MYSQL_ROOT_PASSWORD=quarkus_test -e MYSQL_DATABASE=quarkus_test -p 3306:3306 mysql:latest```

also compile to generate the project with auto generated proto classes

```shell script
./mvn compile quarkus:dev
```

im pretty sure that i forget to explain some of my choices.

oh ... sorry i didn't include any tests... and yes it's a bad thing to forget them :D 
