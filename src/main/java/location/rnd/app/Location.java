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
public final class Location {
	
	private final LocationType currentType;
	private final List<Label> labels = new ArrayList<Label>(); 
	private final Label defaultLabel;
	
	private final List<Location> containsLocations = new ArrayList<Location>();
	private final List<Location> surroundsLocations = new ArrayList<Location>();
	
	public Location(LocationType type, Label defaultLabel){
		this.currentType = type;
		this.defaultLabel = defaultLabel;
		this.labels.add(this.defaultLabel);
		
	}
	
	public LocationType getLocationType(){
		return this.currentType;
	}
	

	public Label getDefaultLabel(){
		return this.defaultLabel;
	}
	
	public void addLabel(Label label){
		if(label!=null)
			this.labels.add(label);
	}
	
	
	public List<Label> getLabels(){
		return this.labels;
	}
	
	public boolean contains(Location location){
		return containsLocations.contains(location);
	}
	
	public boolean surrounds(Location location){
		return surroundsLocations.contains(location);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currentType == null) ? 0 : currentType.hashCode());
		result = prime * result
				+ ((defaultLabel == null) ? 0 : defaultLabel.hashCode());
		result = prime * result + ((labels == null) ? 0 : labels.hashCode());
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
		Location other = (Location) obj;
		if (currentType == null) {
			if (other.currentType != null)
				return false;
		} else if (!currentType.equals(other.currentType))
			return false;
		if (defaultLabel == null) {
			if (other.defaultLabel != null)
				return false;
		} else if (!defaultLabel.equals(other.defaultLabel))
			return false;
		if (labels == null) {
			if (other.labels != null)
				return false;
		} else if (!labels.equals(other.labels))
			return false;
		return true;
	}
	
	
	
}
