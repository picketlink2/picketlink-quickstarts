# PicketLink Federation: Quickstarts #
 
This project contains some examples that can used to getting started with PicketLink Federation.

For more informations see https://docs.jboss.org/author/display/PLINK/PicketLink+Quickstarts.

## Build Information ##

The examples were tested in the following servers:

+ JBoss Application Server 5.x
+ JBoss Application Server 7.x
+ Apache Tomcat 6.x

For each target server there is a directory with specific configuration files. These files must be present in the resulting package in order to be deployed on an specific server. For example, considering the saml/idp example:

+ saml/idp/conf/jboss-as5: JBoss AS5 specific configuration files.
+ saml/idp/conf/jboss-as7: JBoss AS7 specific configuration files.
+ saml/idp/conf/tomcat-6 : Apache Tomcat 6 configuration files.

To build the examples execute the following command:

*mvn -Dbinding=jboss -Dbinding-version=as7 clean install* (package and deploy to JBoss AS7)

or

*mvn -Dbinding=jboss -Dbinding-version=as5 clean install* (package and deploy to JBoss AS5)

or

*mvn -Dbinding=tomcat -Dbinding-version=6 clean install* (package and deploy to Apache Tomcat 6)

Where *binding* refers to the server where package will be deployed and *binding-version* its version.


