
package com.kangmei.cxf.service.factory;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "IThirdOrderWSDL", targetNamespace = "http://factory.service.cxf.kangmei.com/", wsdlLocation = "http://www.kmzhyf.cn:8085/zyf/ws/IThirdOrderWSDL?wsdl")
public class IThirdOrderWSDL_Service
    extends Service
{

    private final static URL ITHIRDORDERWSDL_WSDL_LOCATION;
    private final static WebServiceException ITHIRDORDERWSDL_EXCEPTION;
    private final static QName ITHIRDORDERWSDL_QNAME = new QName("http://factory.service.cxf.kangmei.com/", "IThirdOrderWSDL");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://www.kmzhyf.cn:8085/zyf/ws/IThirdOrderWSDL?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ITHIRDORDERWSDL_WSDL_LOCATION = url;
        ITHIRDORDERWSDL_EXCEPTION = e;
    }

    public IThirdOrderWSDL_Service() {
        super(__getWsdlLocation(), ITHIRDORDERWSDL_QNAME);
    }

    public IThirdOrderWSDL_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), ITHIRDORDERWSDL_QNAME, features);
    }

    public IThirdOrderWSDL_Service(URL wsdlLocation) {
        super(wsdlLocation, ITHIRDORDERWSDL_QNAME);
    }

    public IThirdOrderWSDL_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ITHIRDORDERWSDL_QNAME, features);
    }

    public IThirdOrderWSDL_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IThirdOrderWSDL_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IThirdOrderWSDL
     */
    @WebEndpoint(name = "IThirdOrderWSDLImplPort")
    public IThirdOrderWSDL getIThirdOrderWSDLImplPort() {
        return super.getPort(new QName("http://factory.service.cxf.kangmei.com/", "IThirdOrderWSDLImplPort"), IThirdOrderWSDL.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IThirdOrderWSDL
     */
    @WebEndpoint(name = "IThirdOrderWSDLImplPort")
    public IThirdOrderWSDL getIThirdOrderWSDLImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://factory.service.cxf.kangmei.com/", "IThirdOrderWSDLImplPort"), IThirdOrderWSDL.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ITHIRDORDERWSDL_EXCEPTION!= null) {
            throw ITHIRDORDERWSDL_EXCEPTION;
        }
        return ITHIRDORDERWSDL_WSDL_LOCATION;
    }

}