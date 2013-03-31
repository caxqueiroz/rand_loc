package marshalling;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import location.rnd.app.Label;
import location.rnd.app.LocationType;

public class LocationTypeAdapter extends
		XmlAdapter<CustomLocationType, LocationType> {

	@Override
	public CustomLocationType marshal(LocationType locationType)
			throws Exception {

		return new CustomLocationType()
				.setDefaultLabel(locationType.getDefaultlabel())
				.setLabels(locationType.getLabels())
				.setLevel(locationType.getLevel());
	}

	@Override
	public LocationType unmarshal(CustomLocationType cLocationType)
			throws Exception {
		LocationType locationType = new LocationType(cLocationType.getLevel(),
				cLocationType.getDefaultLabel());
		for (Label label : cLocationType.getLabels()) {
			locationType.addLabel(label);
		}
		return locationType;
	}

}
