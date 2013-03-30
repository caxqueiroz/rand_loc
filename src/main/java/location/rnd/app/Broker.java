/**
 * 
 */
package location.rnd.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author cq
 *
 */
public class Broker {
	
	private final String identifier;
	
	private final List<String> localesSupported = new ArrayList<String>();
	
	private final List<LocationOntology> ontologies = new ArrayList<LocationOntology>();
	
	
	public Broker(){
		this.identifier = "broker_" + generateIdentifier();
	}
	
	
	public Broker(List<String> localesSupported){
		this.identifier = "broker_" + generateIdentifier();
		processLocales(localesSupported);
	}
	
	
	
	/**
	 * @param localesSupported
	 */
	private void processLocales(List<String> localesSupported) {
		for (String elem : localesSupported) {
			this.localesSupported.add(elem);
		}
	}


	private String generateIdentifier(){
		Random r = new Random(System.currentTimeMillis());
		return String.valueOf(r.nextInt());
	}
	
	public String getIdentifier(){
		return this.identifier;
	}
}
