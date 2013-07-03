# PicketLink Federation: Identity Provider Example #

## Example Description ##

This example demonstrates how to configure an web application as an Identity Provider and supports SSL Client Authentication.

This Identity Provider is configured to authenticate users in two ways:

* If SSL is being used, the server will ask the client for a certificate and use it to authenticate the user
* If no certificate is provided by the client, a form-based authentication is performed

## Pre-requisites ##

In order to use this example, you must configure your EAP/JBoss AS installation to support SSL.

### JBoss AS/EAP SSL Configuration ###

Create a certificate for your server using the following command:

    keytool -genkey -alias server -keyalg RSA -keystore server.keystore -storepass change_it -validity 365

You'll be prompted for some additional information, you can provide the values your want.

Now, let's create the client certificate, which you'll use to authenticate against the server when accessing a resource
through SSL.

    keytool -genkey -alias client -keystore client.keystore -storepass change_it -validity 365 -keyalg RSA -keysize 2048 -storetype pkcs12

Now we need to export the client's certificate and create a truststore by importing this certificate:

    keytool -exportcert -keystore client.keystore  -storetype pkcs12 -storepass change_it -alias client -keypass change_it -file client.cer
    keytool -import -file client.cer -alias client -keystore client.truststore

Now that we have our certificates/keystores properly configured, you need to change your server installation to enable ssl.
Add the following connector to the web subsystem:

    <connector name="https" protocol="HTTP/1.1" scheme="https" socket-binding="https" enable-lookups="false" secure="true">
        <ssl name="localhost-ssl" key-alias="server" password="change_it"
            certificate-key-file="${jboss.server.config.dir}/server.keystore"
            protocol="TLSv1"
            verify-client="want"
            ca-certificate-file="${jboss.server.config.dir}/client.truststore"/>
    </connector>

You can now restart your server and check if it is responding on:

    https://localhost:8443

If everything is ok, you will be asked to trust the server certificate.

### Configure the client certificate in your browser ###

Before accessing the application, please import the *client.cer*, which holds the client certificate, to your browser.
When you access the application, the browser should ask you which certificate you want to use to authenticate with the server.
Select it and you're ready to go.

### Security Domain Configuration ###

Add the following security domain to your server installation. If you're in standalone mode, add this to the JBOSS_HOME/standalone/configuration/standalone.xml:

    <security-domain name="idp" cache-type="default">
        <authentication>
            <login-module code="CertificateRoles" flag="optional">
                <module-option name="password-stacking" value="useFirstPass"/>
                <module-option name="securityDomain" value="idp"/>
                <module-option name="verifier" value="org.jboss.security.auth.certs.AnyCertVerifier"/>
            </login-module>
            <login-module code="UsersRoles" flag="required">
                <module-option name="password-stacking" value="useFirstPass"/>
                <module-option name="usersProperties" value="users.properties"/>
                <module-option name="rolesProperties" value="roles.properties"/>
            </login-module>
        </authentication>

        <jsse keystore-password="change_it" keystore-url="jboss.server.config.dir/server.keystore" truststore-password="change_it" truststore-url="jboss.server.config.dir/server.keystore" client-auth="true"/>
    </security-domain>

The configuration above will first try to validate any provided certificates. If no certificate was provided or the authentication fails, we fallback to a user/password based authentication.

### JBoss AS/EAP SSL Configuration ###

