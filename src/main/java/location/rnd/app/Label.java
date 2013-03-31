/**
 * 
 */
package location.rnd.app;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import marshalling.LabelAdapter;

/**
 * @author cq
 * 
 */

@XmlJavaTypeAdapter(LabelAdapter.class)
public final class Label {

	private final String labelName;

	private final String locale;

	public Label(String label, String locale) {
		this.labelName = label;
		this.locale = locale;
	}

	/**
	 * @return the label
	 */
	public String getLabelName() {
		return labelName;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((labelName == null) ? 0 : labelName.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Label other = (Label) obj;
		if (labelName == null) {
			if (other.labelName != null)
				return false;
		} else if (!labelName.equals(other.labelName))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		return true;
	}

}
