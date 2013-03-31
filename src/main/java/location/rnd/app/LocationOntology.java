/**
 * 
 */
package location.rnd.app;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cq
 *
 */
public final class LocationOntology {

	private final List<LocationType> locationTypes = new ArrayList<LocationType>();
	
	
	
	public LocationOntology(boolean useDefault){
		if(useDefault){
			generateDefaultTypes();
		}
	}
	
	private void generateDefaultTypes(){
		LocationType locationType = new LocationType(1, new Label("Country/Region", "en_AU"));
		locationType.addLabel(new Label("País/Região", "pt_BR"));
		locationType.addLabel(new Label("Pays/Région", "fr_FR"));
		locationTypes.add(locationType);
		
		
		
		
	}
}
