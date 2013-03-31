/**
 * 
 */
package location.rnd.app;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * @author cq
 * 
 */
public final class LocationOntology {

	private final List<LocationType> locationTypes = new ArrayList<LocationType>();

	private final List<String> localesSupported = new ArrayList<String>();

	private final Hashtable<LocationType, InMemDB<Location>> databases;

	public LocationOntology(boolean useDefault) {
		databases = new Hashtable<LocationType, InMemDB<Location>>();
		if (useDefault) {
			generateDefaultTypes();
			// one database per location type.
			// e.g. one for country, one for state and one for city.
			for (LocationType type : locationTypes) {
				databases.put(type, new InMemDB<Location>());
			}

			generateDefaultLocations();
		}
	}

	public int numberLocationTypes() {
		return locationTypes.size();
	}

	public void addLocation(Location location) {
		if (location != null)
			databases.get(location.getLocationType()).addElement(location);
	}

	public void addLocationType(LocationType locationType) {
		if (locationType != null) {
			locationTypes.add(locationType);
			databases.put(locationType, new InMemDB<Location>());
		}

	}
	/**
	 * Search for locations. Empty search terms return empty lists. 
	 * @param search
	 * @return
	 */
	public List<Location> search(String search) {
		List<Location> locationsFound = new ArrayList<Location>();
		if (search != null && search.length() > 0) {
			for (Map.Entry<LocationType, InMemDB<Location>> dbentries : databases
					.entrySet()) {
				LocationType type = dbentries.getKey();
				InMemDB<Location> db = dbentries.getValue();
				List<Location> locations = db.search(search);
				locationsFound.addAll(locations);
			}
		}

		return locationsFound;

	}

	/**
	 * This method is only used to populate the ontology databases. It is not
	 * necessary on a real deployment.
	 */
	private void generateDefaultTypes() {
		processLocales(new String[] { "en_AU", "fr_FR", "pt_BR" });

		LocationType locationType1 = new LocationType(1, new Label(
				"Country/Region", "en_AU"));
		locationType1.addLabel(new Label("País/Região", "pt_BR"));
		locationType1.addLabel(new Label("Pays/Région", "fr_FR"));

		LocationType locationType2 = new LocationType(2, new Label("State",
				"en_AU"));
		locationType2.addLabel(new Label("Estado", "pt_BR"));
		locationType2.addLabel(new Label("Etát", "fr_FR"));

		LocationType locationType3 = new LocationType(3, new Label("City",
				"en_AU"));
		locationType3.addLabel(new Label("Cidade", "pt_BR"));
		locationType3.addLabel(new Label("Ville", "fr_FR"));

		locationTypes.add(locationType1);
		locationTypes.add(locationType2);
		locationTypes.add(locationType3);

	}

	private void generateDefaultLocations() {
		Location location0 = new Location(new LocationType(1, new Label(
				"Country", "en_AU")), new Label("Brazil", "en_AU"));
		location0.addLabel(new Label("Brasil", "pt_BR"));
		location0.addLabel(new Label("Brésil", "fr_FR"));
		
		this.addLocation(location0);
		
		Location location1 = new Location(new LocationType(3, new Label(
				"City", "en_AU")), new Label("Brasilia", "en_AU"));
		location1.addLabel(new Label("Brasília", "pt_BR"));
		location1.addLabel(new Label("Brasilia", "fr_FR"));
		
		this.addLocation(location1);
		
		Location location2 = new Location(new LocationType(1, new Label(
				"Country", "en_AU")), new Label("Australia", "en_AU"));
		location2.addLabel(new Label("Austrália", "pt_BR"));
		location2.addLabel(new Label("Australie", "fr_FR"));
		
		this.addLocation(location2);
		
		Location location3 = new Location(new LocationType(2, new Label(
				"State", "en_AU")), new Label("Victoria", "en_AU"));
		location3.addLabel(new Label("Victoria", "pt_BR"));
		location3.addLabel(new Label("Victoria", "fr_FR"));
		
		this.addLocation(location3);
		
		
		
	}

	/**
	 * @param localesSupported
	 */
	private void processLocales(String[] localesSupported) {
		for (String elem : localesSupported) {
			this.localesSupported.add(elem);
		}
	}
}
