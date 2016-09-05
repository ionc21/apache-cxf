
package com.pgs.schema.order;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pgs.schema.order package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _OrderInquiry_QNAME = new QName("http://www.pgs.com/schema/Order", "orderInquiry");
    private final static QName _OrderInquiryResponse_QNAME = new QName("http://www.pgs.com/schema/Order", "orderInquiryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pgs.schema.order
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderInquiryType }
     * 
     */
    public OrderInquiryType createOrderInquiryType() {
        return new OrderInquiryType();
    }

    /**
     * Create an instance of {@link OrderInquiryResponseType }
     * 
     */
    public OrderInquiryResponseType createOrderInquiryResponseType() {
        return new OrderInquiryResponseType();
    }

    /**
     * Create an instance of {@link AccountType }
     * 
     */
    public AccountType createAccountType() {
        return new AccountType();
    }

    /**
     * Create an instance of {@link BookType }
     * 
     */
    public BookType createBookType() {
        return new BookType();
    }

    /**
     * Create an instance of {@link OrderItemType }
     * 
     */
    public OrderItemType createOrderItemType() {
        return new OrderItemType();
    }

    /**
     * Create an instance of {@link OrderType }
     * 
     */
    public OrderType createOrderType() {
        return new OrderType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderInquiryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pgs.com/schema/Order", name = "orderInquiry")
    public JAXBElement<OrderInquiryType> createOrderInquiry(OrderInquiryType value) {
        return new JAXBElement<OrderInquiryType>(_OrderInquiry_QNAME, OrderInquiryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderInquiryResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pgs.com/schema/Order", name = "orderInquiryResponse")
    public JAXBElement<OrderInquiryResponseType> createOrderInquiryResponse(OrderInquiryResponseType value) {
        return new JAXBElement<OrderInquiryResponseType>(_OrderInquiryResponse_QNAME, OrderInquiryResponseType.class, null, value);
    }

}
