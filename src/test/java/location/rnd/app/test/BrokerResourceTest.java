package location.rnd.app.test;

import java.util.ArrayList;
import java.util.List;

import location.rnd.app.Broker;
import location.rnd.app.Location;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;
import com.sun.jersey.test.framework.spi.container.grizzly2.web.GrizzlyWebTestContainerFactory;

public class BrokerResourceTest extends JerseyTest {

	@Override
	protected TestContainerFactory getTestContainerFactory() {
		return new GrizzlyWebTestContainerFactory();
	}

	public BrokerResourceTest() throws Exception {
		super("location.rnd.app.test;location.rnd.app");

	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testGetBroker() {
		WebResource webResource = resource();
		Broker[] brokers = webResource.path("/broker").get(Broker[].class);
		Assert.assertNotNull(brokers);

	}

	@Test
	public void testCreateBroker() {
		WebResource webResource = resource();
		Broker broker = webResource.path("/broker/mybroker").post(Broker.class);
		Assert.assertNotNull(broker);

	}

//	@Test
//	public void testBrokerSearch() {
//		WebResource webResource = resource();
//		Broker broker = webResource.path("broker/mybroker").post(Broker.class);
//		Assert.assertNotNull(broker);
//		Location[] locations = webResource.path("broker/mybroker/Brasil").get(Location[].class);
//		Assert.assertNotNull(locations);
//
//	}
}
