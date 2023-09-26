package guru99;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
//
//	@DataProvider(name = "Authentication")
//
//	public static Object[][] credentials() {
//
//		return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" } };
//
//	}

	@DataProvider(name = "Authentication")

	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = utility.getTableArray("C:\\Users\\DELL\\OneDrive\\Documents\\logincrm.xlsx",
				"Sheet1");

		return (testObjArray);

	}
}
