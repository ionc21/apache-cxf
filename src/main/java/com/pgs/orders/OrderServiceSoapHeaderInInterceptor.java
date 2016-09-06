package com.pgs.orders;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.w3c.dom.Element;

public class OrderServiceSoapHeaderInInterceptor extends AbstractSoapInterceptor {
	public OrderServiceSoapHeaderInInterceptor() {
		super("user-protocol");
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		QName qname = new QName("http://www.pluralsight.com/service/Orders/", "apikey");

		SoapHeader header = (SoapHeader) message.getHeader(qname);

		String apikey = ((Element) header.getObject()).getTextContent();

		System.err.println("API Key = " + apikey);
	}
}