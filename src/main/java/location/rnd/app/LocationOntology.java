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
	
	
	public LocationOntology(boolean useDefault){
		databases = new Hashtable<LocationType, InMemDB<Location>>();
		if(useDefault){
			generateDefaultTypes();
			//one database per location type.
			//e.g. one for country, one for state and one for city. 
			for (LocationType type : locationTypes) {
				databases.put(type, new InMemDB<Location>());
			}
			
			generateDefaultLocations();
		}
	}
	
	public void addLocationType(LocationType locationType){
		locationTypes.add(locationType);
	}
	
	public List<Location> search(String search){
		List<Location> locationsFound = new ArrayList<Location>();
		for (Map.Entry<LocationType,InMemDB<Location>> dbentries  : databases.entrySet()) {
			LocationType type = dbentries.getKey();
			InMemDB<Location> db = dbentries.getValue();
			List<Location> locations = db.search(search);
			locationsFound.addAll(locations);
		}
		
		return locationsFound;
		
	}
	
	
	/**
	 * This method is only used to populate the ontology databases. It is not necessary on a real deployment. 
	 */
	private void generateDefaultTypes(){
		processLocales(new String[] { "en_AU", "fr_FR", "pt_BR" });
		
		LocationType locationType1 = new LocationType(1, new Label("Country/Region", "en_AU"));
		locationType1.addLabel(new Label("País/Região", "pt_BR"));
		locationType1.addLabel(new Label("Pays/Région", "fr_FR"));
		
		LocationType locationType2 = new LocationType(2, new Label("State", "en_AU"));
		locationType2.addLabel(new Label("Estado", "pt_BR"));
		locationType2.addLabel(new Label("Etát", "fr_FR"));
		
		LocationType locationType3 = new LocationType(3, new Label("City", "en_AU"));
		locationType3.addLabel(new Label("Cidade", "pt_BR"));
		locationType3.addLabel(new Label("Ville", "fr_FR"));
		
		locationTypes.add(locationType1);
		locationTypes.add(locationType2);
		locationTypes.add(locationType3);
		
		
		
		
		
	}
	
	private void generateDefaultLocations(){
		
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
