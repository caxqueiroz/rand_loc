package location.rnd.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Class to store all location and/or location types in memory. It is used as the local database. 
 * @author cq
 *
 * @param <T>
 */
public class InMemDB<T> {

	private final SortedMap<String, T> data = new TreeMap<String, T>();

	
	/**
	 * Adds elements to the local database. 
	 * @param element
	 */
	public void addElement(T element) {
		if (element instanceof Location) {
			data.put(((Location) element).getDefaultLabel().getLabel(), element);
			List<Label> labels = ((Location) element).getLabels();
			for (Label label : labels) {
				data.put(label.getLabel(), element);
			}
		} else if (element instanceof LocationType) {
			data.put(((LocationType) element).getDefaultlabel().getLabel(),
					element);
			List<Label> labels = ((LocationType) element).getLabels();
			for (Label label : labels) {
				data.put(label.getLabel(), element);
			}
		}
	}

	/**
	 * Searchs for match in the database. 
	 * @param search
	 * @return
	 */
	public List<T> search(String search) {
		List<T> filteredData = new ArrayList<T>();
		if (search.length() > 0) {
			
			String searchSubstring = search.substring(0, search.length() - 1);
			char nextChar = (char) (search.charAt(search.length() - 1) + 1);
			String lastKey = searchSubstring + nextChar;

			SortedMap<String, T> sub_data = data.subMap(search, lastKey);
			for (Map.Entry<String, T> entry : sub_data.entrySet()) {
				if(!filteredData.contains(entry.getValue()))
					filteredData.add(entry.getValue());
			}
		}

		return filteredData;
	}

}
