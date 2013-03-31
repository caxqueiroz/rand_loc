package marshalling;

import java.util.List;

import location.rnd.app.Label;

public class CustomLocationType {

	private int level;

	private List<Label> labels;

	public int getLevel() {
		return level;
	}

	public CustomLocationType setLevel(int level) {
		this.level = level;
		return this;
	}

	public Label getDefaultLabel() {
		return this.labels.get(0);
	}

	

	public List<Label> getLabels() {
		return this.labels;
	}

	public CustomLocationType setLabels(List<Label> labels) {
		this.labels = labels;
		return this;
	}

}
