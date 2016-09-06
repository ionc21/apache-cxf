package com.pgs.orders;

import com.pgs.schema.order.OrderInquiryResponseType;

public interface OrderService {

	 OrderInquiryResponseType processOrder(int uniqueOrderId, int orderQuantity, int accountId, long ean13);
}
