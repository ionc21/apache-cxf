package com.pgs.orders;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapOutInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxb.JAXBDataBinding;

public class OrderServiceSoapHeaderOutInterceptor extends AbstractSoapInterceptor {
	public OrderServiceSoapHeaderOutInterceptor() {
		super("write");
		addBefore(SoapOutInterceptor.class.getName());
	}

	public void handleMessage(SoapMessage message) throws Fault {
		QName qname = new QName("http://www.pluralsight.com/service/Orders/", "apikey");

		String apikey = "a1b2c3d4e5";
		try {
			SoapHeader header = new SoapHeader(qname, apikey, new JAXBDataBinding(new Class[] { apikey.getClass() }));

			message.getHeaders().add(header);
		} catch (Exception e) {
			throw new Fault(e);
		}
	}
}
