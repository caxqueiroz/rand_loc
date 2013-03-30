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
	
	private Location(LocationType type, Label defaultLabel){
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
}
