package com.pgs.orders;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.pgs.schema.order.OrderInquiryResponseType;
import com.pgs.schema.order.OrderInquiryType;
import com.pgs.service.orders.Orders;

@WebService(portName = "OrdersSOAP", serviceName = "Orders", endpointInterface = "com.pgs.service.orders.Orders", targetNamespace = "http://www.pgs.com/service/Orders/")
public class DefaultOrdersEndpoint implements Orders {

	@Autowired
	OrderService orderService;

	@Override
	public OrderInquiryResponseType processOrderPlacement(OrderInquiryType orderInquiry) {
		OrderInquiryResponseType response = orderService.processOrder(orderInquiry.getUniqueOrderId(), orderInquiry.getOrderQuantity(),
				orderInquiry.getAccountId(), orderInquiry.getEan13());
		return response;
	}

}
