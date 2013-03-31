package location.rnd.app.test;

import java.util.List;

import junit.framework.TestCase;
import location.rnd.app.Label;
import location.rnd.app.Location;
import location.rnd.app.LocationOntology;
import location.rnd.app.LocationType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LocationOntologyTest extends TestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddLocationType() {
		LocationType locationType1 = new LocationType(4, new Label("Suburb",
				"en_AU"));
		locationType1.addLabel(new Label("Bairro", "pt_BR"));

		LocationOntology lo = new LocationOntology(true);
		lo.addLocationType(locationType1);

		assertEquals(4, lo.numberLocationTypes());
	}
	
	@Test
	public void testAddLocationTypeNull() {
	

		LocationOntology lo = new LocationOntology(true);
		try {
			lo.addLocationType(null);
		} catch (Exception e) {
			assertNotNull(e);
		}
		
		
	}
	

	@Test
	public void testSearch() {
		LocationOntology lo = new LocationOntology(true);
		String searchTerm = "Brazil";

		Location location0 = new Location(new LocationType(1, new Label(
				"Country", "en_AU")), new Label("Brazil", "en_AU"));
		location0.addLabel(new Label("Brasil", "pt_BR"));
		location0.addLabel(new Label("Brésil", "fr_FR"));

		lo.addLocation(location0);

		List<Location> result = lo.search(searchTerm);
		assertEquals(1, result.size());
	}

}
