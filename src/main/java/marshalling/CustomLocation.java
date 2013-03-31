package marshalling;

import java.util.List;

import location.rnd.app.Label;
import location.rnd.app.LocationType;

public class CustomLocation {

	
	private LocationType currentType;

	
	private Label[] labels;


	public LocationType getCurrentType() {
		return currentType;
	}

	public CustomLocation setCurrentType(LocationType currentType) {
		this.currentType = currentType;
		return this;
	}

	public Label[] getLabels() {
		return labels;
	}

	public CustomLocation setLabels(List<Label> labels) {
		Label[] _labels = labels.toArray(new Label[]{});
		this.labels = _labels;
		return this;
	}

	public Label getDefaultLabel() {
		return this.labels[0];
	}

}
