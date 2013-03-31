/**
 * 
 */
package location.rnd.app;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import marshalling.LocationTypeAdapter;

/**
 * @author cq
 * 
 */
@XmlJavaTypeAdapter(LocationTypeAdapter.class)
public final class LocationType {

	private final int level;

	private final List<Label> labels = new ArrayList<Label>();

	/**
	 * 
	 * @param level
	 * @param defaultLabel
	 */
	public LocationType(int level, Label defaultLabel) {
		this.level = level;
		
		this.labels.add(defaultLabel);
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return this.level;
	}

	public Label getDefaultlabel() {
		return this.labels.get(0);
	}

	public void addLabel(Label label) {
		if (label != null && !this.labels.contains(label))
			this.labels.add(label);
	}

	public List<Label> getLabels() {
		return this.labels;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = prime * result
		// + ((defaultLabel == null) ? 0 : defaultLabel.hashCode());
		// result = prime * result + ((labels == null) ? 0 : labels.hashCode());
		result = prime * result + level;
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
		LocationType other = (LocationType) obj;
		// if (defaultLabel == null) {
		// if (other.defaultLabel != null)
		// return false;
		// } else if (!defaultLabel.equals(other.defaultLabel))
		// return false;
		// if (labels == null) {
		// if (other.labels != null)
		// return false;
		// } else if (!labels.equals(other.labels))
		// return false;
		if (level != other.level)
			return false;
		return true;
	}

}
