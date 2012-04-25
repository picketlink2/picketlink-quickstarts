# PicketLink Federation: Service Provider Example #
 
This project is an implementation of a PicketLink Service Provider.

# Build Informations #

This example was tested in the following servers:

+ JBoss Application Server 5.x
+ JBoss Application Server 7.x
+ Apache Tomcat 6.x

For each target server there is a directory with specific configuration files. These files must be present in the resulting package in order to be deployed on an specific server.

+ conf/jboss-as5
+ conf/jboss-as7
+ conf/tomcat-6

To build the example execute the following command:

*mvn -Dbinding=jboss -Dbinding-version=as7 clean install*

Where *binding* refers to wich server the package should be deployed and *binding-version* to its version.
