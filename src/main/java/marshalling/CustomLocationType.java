package marshalling;

import java.util.List;

import location.rnd.app.Label;

public class CustomLocationType {

	private int level;

	private Label defaultLabel;

	private List<Label> labels;

	public int getLevel() {
		return level;
	}

	public CustomLocationType setLevel(int level) {
		this.level = level;
		return this;
	}

	public Label getDefaultLabel() {
		return defaultLabel;
	}

	public CustomLocationType setDefaultLabel(Label defaultLabel) {
		this.defaultLabel = defaultLabel;
		return this;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public CustomLocationType setLabels(List<Label> labels) {
		this.labels = labels;
		return this;
	}

}
