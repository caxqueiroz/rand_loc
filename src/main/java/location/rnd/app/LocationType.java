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
public final class LocationType {
	
	private final int level;
	
	private final Label defaultLabel;

	private final List<Label> labels = new ArrayList<Label>(); 
	
	
	/**
	 * 
	 * @param level
	 * @param defaulLabel
	 */
	public LocationType(int level, Label defaulLabel){
		this.level = level;
		this.defaultLabel = defaulLabel;
	}
	
	/**
	 * @return the level
	 */
	public int getLevel() {
		return this.level;
	}

	
	public Label getDefaulabel(){
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
