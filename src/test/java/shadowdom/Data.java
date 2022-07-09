package shadowdom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data {


@DataProvider
	public Object[][] data() {
		Object[][] objarr=new  Object[2][2];
		
		objarr[0][0]="hello";
		objarr[0][1]="hello";
		objarr[1][0]="hello";
		objarr[1][1]="hello";
		
	return objarr;
	
	}
@Test(dataProvider="data")
public void name(String src,String dst) {
	System.out.println(src+" "+dst);
}


}
