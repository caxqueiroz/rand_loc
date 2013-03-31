package location.rnd.app;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("broker")
public class BrokerResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response brokers() {
		List<Broker> brokers = BrokerManager.getInstance().getBrokers();
		Broker[] _brokers = brokers.toArray(new Broker[] {});
		return Response.status(200).entity(_brokers).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{brokername}")
	public Response createBroker(@PathParam("brokername") String name) {

		Broker broker = BrokerManager.getInstance().createBroker(name);
		return Response.status(201).entity(broker).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{brokername}/{location}")
	public Response searchLocation(@PathParam("location") String location,
			@PathParam("brokername") String name) {
		List<Location> locations = BrokerManager.getInstance().getBroker(name).searchLocation(location);
		Location[] _locations = locations.toArray(new Location[]{});
		return Response.status(200).entity(_locations).build();
	}

}
