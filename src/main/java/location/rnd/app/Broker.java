/**
 * 
 */
package location.rnd.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author cq
 * 
 */
@XmlRootElement
public class Broker {

	@XmlElement
	private final String identifier;

	

	private final List<LocationOntology> ontologies = new ArrayList<LocationOntology>();

	public Broker() {
		this.identifier = "broker_" + generateIdentifier();
		ontologies.add(new LocationOntology(true));
		
	}

	public Broker(String name) {
		this.identifier = name;
		ontologies.add(new LocationOntology(true));
		
	}

	public Broker(String name, String[] localesSupported) {
		this.identifier = name;
		ontologies.add(new LocationOntology(true));
		
	}

	public Broker(String[] localesSupported) {
		this.identifier = "broker_" + generateIdentifier();
		ontologies.add(new LocationOntology(true));
		

	}
	
	/**
	 * Searchs for location. It uses the default ontology. As the definition
	 * lacks information on how multiple ontologies should be supported. In this case
	 * the default ontology is the first one in the list. 
	 * @param search
	 * @return
	 */
	public List<Location> searchLocation(String search){
		
		LocationOntology ontology = ontologies.get(0);
		return ontology.search(search);
		
	}

	

	private String generateIdentifier() {
		Random r = new Random(System.currentTimeMillis());
		return String.valueOf(r.nextInt());
	}

	public String getIdentifier() {
		return this.identifier;
	}

	@Override
	public String toString() {
		return "Broker [identifier=" + identifier + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result
				+ ((ontologies == null) ? 0 : ontologies.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Broker other = (Broker) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (ontologies == null) {
			if (other.ontologies != null)
				return false;
		} else if (!ontologies.equals(other.ontologies))
			return false;
		return true;
	}

	

}
