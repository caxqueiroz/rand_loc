package location.rnd.app;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("broker")
public class BrokerResource {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response div_get(@QueryParam("op") String op){
		try {
			JSONObject json = new JSONObject(op);
			double result = op(json.getString("div"));
			return Response.ok(new JSONObject().put("result", result).toString()).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject error = null;
		try {
			error = new JSONObject();
			error.put("error", "invalid operation!");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(error.toString()).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response div_post(@QueryParam("op") String op){
		try {
			JSONObject json = new JSONObject(op);
			double result = op(json.getString("div"));
			return Response.ok(new JSONObject().put("result", result).toString()).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject error = null;
		try {
			error = new JSONObject();
			error.put("error", "invalid operation!");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(error.toString()).build();
	}
	
	private double op(String op){
		String[] ops = op.split(",");
		return Double.valueOf(ops[0].trim()) / Double.valueOf(ops[1].trim());
	}
}
