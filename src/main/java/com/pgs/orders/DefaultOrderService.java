package com.pgs.orders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import com.pgs.schema.order.AccountType;
import com.pgs.schema.order.BookType;
import com.pgs.schema.order.ObjectFactory;
import com.pgs.schema.order.OrderInquiryResponseType;
import com.pgs.schema.order.OrderItemType;
import com.pgs.schema.order.OrderStatusType;
import com.pgs.schema.order.OrderType;

@Service
public class DefaultOrderService implements OrderService {

	@Override
	public OrderInquiryResponseType processOrder(int uniqueOrderId, int orderQuantity, int accountId, long ean13) {
		ObjectFactory factory = new ObjectFactory();
		OrderInquiryResponseType response = factory.createOrderInquiryResponseType();
		AccountType account = factory.createAccountType();
		account.setAccountId(accountId);
		response.setAccount(account);

		OrderItemType orderItem = factory.createOrderItemType();
		BookType book = factory.createBookType();
		book.setEan13(ean13);
		book.setTitle("Amintiri din copilarie");
		orderItem.setBook(book);
		try {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(new Date(System.currentTimeMillis()));
			XMLGregorianCalendar estimatedShippingDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
			orderItem.setExpectedShipingDate(estimatedShippingDate);
		} catch (Exception localException) {
		}
		orderItem.setLineNumber(Integer.valueOf(1).intValue());
		orderItem.setPrice(new BigDecimal(5));
		orderItem.setQuantityShipped(orderQuantity);

		OrderType order = factory.createOrderType();
		order.setOrderStatus(OrderStatusType.READY);
		order.getOrderItems().add(orderItem);
		response.setOrder(order);

		return response;
	}

}
