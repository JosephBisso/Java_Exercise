import org . junit . Test ;
import static org . junit . Assert .*;

public class ZahlLeserTest {
	
	@Test public void twentyByTest() {
		assertEquals(3, ZahlLeser.twentyBy(6));
		assertEquals(5, ZahlLeser.twentyBy(4));
		assertEquals(10, ZahlLeser.twentyBy(2));
	}
}