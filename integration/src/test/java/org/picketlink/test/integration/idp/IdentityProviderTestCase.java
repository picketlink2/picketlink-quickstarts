package org.picketlink.test.integration.idp;

import java.io.File;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class IdentityProviderTestCase {

    /**
     * Configures an IDP deployment.
     * 
     * @return
     */
    @Deployment(name = "idp", testable = false)
    @TargetsContainer("jboss-as7")
    public static WebArchive createIDPDeployment() {
        return ShrinkWrap.createFromZipFile(
                WebArchive.class,
                new File(System.getProperty("project.build.directory") + "/../../saml/idp/target/idp-" + System.getProperty("project.version") + "-"
                        + System.getProperty("binding") + "-" + System.getProperty("binding-version") + ".war"));
    }

    /**
     * Configures an IDP deployment.
     * 
     * @return
     */
    @Deployment(name = "idp-sig", testable = false)
    @TargetsContainer("jboss-as7")
    public static WebArchive createIDPSigDeployment() {
        return ShrinkWrap.createFromZipFile(
                WebArchive.class,
                new File(System.getProperty("project.build.directory") + "/../../saml/idp-sig/target/idp-sig-" + System.getProperty("project.version") + "-"
                        + System.getProperty("binding") + "-" + System.getProperty("binding-version") + ".war"));
    }

    @Test
    @OperateOnDeployment("idp")
    public void testDeployIDP() throws Exception {

    }

    @Test
    @OperateOnDeployment("idp-sig")
    public void testDeployIDPSig() throws Exception {

    }

}
