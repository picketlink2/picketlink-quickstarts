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

## Jboss Configuration ##
### AS 7 ###

On $JBOSS_HOME/standalone/configuration/standalone.xml add the security domains below
```
<security-domain name="idp" cache-type="default">
   <authentication>
       <login-module code="UsersRoles" flag="required">
            <module-option name="usersProperties" value="users.properties" />
            <module-option name="rolesProperties" value="roles.properties" />
       </login-module>
   </authentication>
</security-domain>      

<security-domain name="picketlink-sts" cache-type="default">
   <authentication>
        <login-module code="UsersRoles" flag="required">
            <module-option name="usersProperties" value="users.properties" />
            <module-option name="rolesProperties" value="roles.properties" />
        </login-module>
    </authentication>
</security-domain>

<security-domain name="sp" cache-type="default">
     <authentication>
         <login-module code="org.picketlink.identity.federation.bindings.jboss.auth.SAML2LoginModule" flag="required"/>
     </authentication>
</security-domain>
```

### AS 5 ###
Copy assembly/jboss-as5/picketlink-* in $JBOSS_HOME/server/server-name/deploy

or

On $JBOSS_HOME/server/default/conf/login-config.xml add the security domains below
```
<application-policy name="idp">
	<authentication>
	  <login-module code="org.jboss.security.auth.spi.UsersRolesLoginModule" flag="required">
	    <module-option name="usersProperties" value="users.properties" />
	    <module-option name="rolesProperties" value="roles.properties" />
	  </login-module>
	</authentication>
</application-policy>


<application-policy name="picketlink-sts">
	<authentication>
	  <login-module code="org.jboss.security.auth.spi.UsersRolesLoginModule" flag="required">
	    <module-option name="usersProperties" value="users.properties" />
	    <module-option name="rolesProperties" value="roles.properties" />
	  </login-module>
	</authentication>
</application-policy>


<application-policy name="sp">
	<authentication>
	  <login-module code="org.picketlink.identity.federation.bindings.jboss.auth.SAML2LoginModule" flag="required" />
	</authentication>
</application-policy>
```

## Building Project ##

Package and deploy to JBoss AS7
```
mvn -Dbinding=jboss -Dbinding-version=as7 clean install
```

Package and deploy to JBoss AS5
```
mvn -Dbinding=jboss -Dbinding-version=as5 clean install
```

Package and deploy to Apache Tomcat 6
```
mvn -Dbinding=tomcat -Dbinding-version=6 clean install
```

Where *binding* refers to the server where package will be deployed and *binding-version* its version.


