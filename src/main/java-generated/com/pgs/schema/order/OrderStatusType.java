
package com.pgs.schema.order;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OrderStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="READY"/&gt;
 *     &lt;enumeration value="FULFILED"/&gt;
 *     &lt;enumeration value="BACKORDER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OrderStatusType")
@XmlEnum
public enum OrderStatusType {

    READY,
    FULFILED,
    BACKORDER;

    public String value() {
        return name();
    }

    public static OrderStatusType fromValue(String v) {
        return valueOf(v);
    }

}
