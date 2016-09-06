package com.pgs.orders;

import static org.junit.Assert.assertTrue;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pgs.schema.order.ObjectFactory;
import com.pgs.schema.order.OrderInquiryResponseType;
import com.pgs.schema.order.OrderInquiryType;
import com.pgs.service.orders.Orders;

/**
 * This is a test case for the DefaultOrdersEndpoint web service. The test case
 * contains two test methods. The first is a success scenario that executes a
 * happy path test of the orders web service. The second is an exception test.
 * It tests the failure scenario when a null input is passed by the client.
 *
 * @author Michael Hoffman, Pluralsight
 *
 */
// The @RunWith annotation tells jUnit to use the Spring jUnit 4 test runner for
// exection of the tests.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:test-beans.xml" })
public class DefaultOrdersEndpointTest {

	// Interface for the Orders web
	private Orders ordersService;

	// Input parameter to the web service.
	private OrderInquiryType orderInquiryType;

	// Auto wired from the CXF JAX-WS client configuration in the spring test
	// beans file
	@Autowired
	private JaxWsProxyFactoryBean testOrdersClient;

	@Before
	public void setUp() throws Exception {
		ordersService = testOrdersClient.create(Orders.class);

		ObjectFactory factory = new ObjectFactory();
		orderInquiryType = factory.createOrderInquiryType();
		orderInquiryType.setAccountId(999);
		orderInquiryType.setEan13(1234567890123L);
		orderInquiryType.setOrderQuantity(4);
		orderInquiryType.setUniqueOrderId(12345);

	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Happy path test for a successful execution of the orders web service.
	 */
	@Test
	public void testProcessOrderPlacementSuccess() {
		// Call the web service.
		OrderInquiryResponseType response = ordersService.processOrderPlacement(orderInquiryType);
		// Check that the account ID is equal to 999, which was set in the setUp
		// method.
		assertTrue(response.getAccount().getAccountId() == 999);

	}

	/**
	 * Exception test for a failed execution of the orders web service.
	 *
	 * @throws Exception
	 */
	// @Test(expected) indicates that an exception is expected to be thrown from
	// the method.
	@Test(expected = SOAPFaultException.class)
	public void testProcessOrderPlacementFailureInvalidParameter() throws Exception {
		// Call the orders service process order placement method with null, which
		// will result in a SOAP fault.
		ordersService.processOrderPlacement(null);
	}

}
