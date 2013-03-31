/**
 * 
 */
package location.rnd.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlAttribute;
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

	private final List<String> localesSupported = new ArrayList<String>();

	private final List<LocationOntology> ontologies = new ArrayList<LocationOntology>();

	public Broker() {
		this.identifier = "broker_" + generateIdentifier();
		ontologies.add(new LocationOntology(true));
		processLocales(new String[]{"en_AU","fr_FR","pt_BR"});
	}

	public Broker(String name) {
		this.identifier = name;
		ontologies.add(new LocationOntology(true));
		processLocales(new String[]{"en_AU","fr_FR","pt_BR"});
	}
	
	public Broker(String name, String[] localesSupported){
		this.identifier = name;
		ontologies.add(new LocationOntology(true));
		processLocales(localesSupported);
	}

	public Broker(String[] localesSupported) {
		this.identifier = "broker_" + generateIdentifier();
		ontologies.add(new LocationOntology(true));
		processLocales(localesSupported);
		
	}

	/**
	 * @param localesSupported
	 */
	private void processLocales(String[] localesSupported) {
		for (String elem : localesSupported) {
			this.localesSupported.add(elem);
		}
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
		result = prime
				* result
				+ ((localesSupported == null) ? 0 : localesSupported.hashCode());
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
		if (localesSupported == null) {
			if (other.localesSupported != null)
				return false;
		} else if (!localesSupported.equals(other.localesSupported))
			return false;
		if (ontologies == null) {
			if (other.ontologies != null)
				return false;
		} else if (!ontologies.equals(other.ontologies))
			return false;
		return true;
	}
	
	
}
