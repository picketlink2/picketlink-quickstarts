package org.picketlink.test.integration;

import java.io.File;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.picketlink.identity.federation.api.wstrust.WSTrustClient;
import org.picketlink.identity.federation.api.wstrust.WSTrustClient.SecurityInfo;
import org.picketlink.identity.federation.core.wstrust.WSTrustException;
import org.picketlink.identity.federation.core.wstrust.plugins.saml.SAMLUtil;
import org.w3c.dom.Element;

//@RunWith(Arquillian.class)
public class SecurityTokenServiceTestCase {

    /**
     * Configures an IDP deployment.
     * 
     * @return
     */
    @Deployment(name = "picketlink-sts", testable = false)
    @TargetsContainer("jboss-as7")
    public static WebArchive createSTSDeployment() {
        return ShrinkWrap.createFromZipFile(WebArchive.class, new File(System.getProperty("project.build.directory")
                + "/../../ws-trust/picketlink-sts/target/picketlink-sts-" + System.getProperty("project.version") + "-"
                + System.getProperty("binding") + "-" + System.getProperty("binding-version") + ".war"));
    }

//    @Test
    @OperateOnDeployment("picketlink-sts")
    public void testDeploy() throws Exception {
    }

//    @Test
    public void testIssueToken() throws Exception {
        // create a WSTrustClient instance.
        WSTrustClient client = new WSTrustClient("PicketLinkSTS", "PicketLinkSTSPort",
                "http://localhost:8080/picketlink-sts/PicketLinkSTS", new SecurityInfo("tomcat", "tomcat"));

        // issue a SAML assertion using the client API.
        Element assertion = null;
        try {
            assertion = client.issueToken(SAMLUtil.SAML2_TOKEN_TYPE);
        } catch (WSTrustException wse) {
            System.out.println("Unable to issue assertion: " + wse.getMessage());
            wse.printStackTrace();
            System.exit(1);
        }

        // print the assertion for demonstration purposes.
        System.out.println("\nSuccessfully issued a standard SAMLV2.0 Assertion!");
        printAssertion(assertion);

        // validate the received SAML assertion.
        try {
            System.out.println("\n\nIs assertion valid? " + client.validateToken(assertion));
        } catch (WSTrustException wse) {
            System.out.println("\n\nFailed to validate SAMLV2.0 Assertion: " + wse.getMessage());
            wse.printStackTrace();
        }
    }

    private void printAssertion(Element assertion) throws Exception {
        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();
        Source src = new DOMSource(assertion);
        Result dest = new StreamResult(System.out);
        aTransformer.transform(src, dest);
    }
}
