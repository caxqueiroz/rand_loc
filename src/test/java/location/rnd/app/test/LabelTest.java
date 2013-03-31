package location.rnd.app.test;

import junit.framework.TestCase;
import location.rnd.app.Label;

public class LabelTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testHashCode() {
		Label lb = new Label("Melbourne", "en_AU");
		
		assertEquals(lb.hashCode(), new Label("Melbourne", "en_AU").hashCode());
		assertTrue(lb.hashCode()!=new Label("Victoria", "en_AU").hashCode());
		
		
	}

	public void testLabel() {
		Label lb = new Label("Melbourne", "en_AU");
		assertNotNull(lb);
	}

	public void testGetLabel() {
		Label lb = new Label("Melbourne", "en_AU");
		assertNotNull(lb.getLabelName());
		String label = lb.getLabelName();
		assertEquals("Melbourne",label);
	}

	public void testGetLocale() {
		Label lb = new Label("Melbourne", "en_AU");
		assertNotNull(lb.getLocale());
		String locale = lb.getLocale();
		assertEquals("en_AU",locale);
	}

	public void testEqualsObject() {
		Label lb = new Label("Melbourne", "en_AU");
		assertEquals(lb, new Label("Melbourne", "en_AU"));
	}

}
