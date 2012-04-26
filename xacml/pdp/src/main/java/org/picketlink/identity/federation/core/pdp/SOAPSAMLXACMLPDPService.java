/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors. 
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.picketlink.identity.federation.core.pdp;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;

import org.apache.log4j.Logger;

/**
 * <p>
 * This WS class must be packaged inside the WAR in order to run in AS7.
 * AS7 does not scan for annotated classes outside the scope of the WAR.
 * </p>
 * <p>
 *  It provides exactly the same functionalities as its parent {@ SOAPSAMLXACMLPDP}. 
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 */
@WebServiceProvider(serviceName = "SOAPSAMLXACMLPDP", portName = "SOAPSAMLXACMLPort", targetNamespace = "urn:picketlink:identity-federation:pdp", wsdlLocation = "WEB-INF/wsdl/SOAPSAMLXACMLPDP.wsdl")
public class SOAPSAMLXACMLPDPService extends SOAPSAMLXACMLPDP
{
   protected Logger log = Logger.getLogger(SOAPSAMLXACMLPDPService.class);

   @Resource
   public void setWSC(WebServiceContext wctx) {
       log.debug("Setting WebServiceContext = " + wctx);
       this.context = wctx;
   }
}