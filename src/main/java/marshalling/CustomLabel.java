package marshalling;


public class CustomLabel {

	private String labelName;

	private String locale;

	public String getLabelName() {
		return labelName;
	}

	public CustomLabel setLabelName(String labelName) {
		this.labelName = labelName;
		return this;
	}

	public String getLocale() {
		return locale;
	}

	public CustomLabel setLocale(String locale) {
		this.locale = locale;
		return this;
	}

}
