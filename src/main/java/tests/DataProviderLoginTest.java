package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseTest;

public class DataProviderLoginTest  extends BaseTest{

	@DataProvider(name="loginTestData")
	public Object[][] loginTestData(){
		
		Object[][] data =  new Object[3][3];
	//	Object[][] data = { { user1, pass1} , {user2, pass2} , {user3, pass3} }	
	//  index               |      0      |   |      1     |    |      2    |
	//  index                 | 0  |,|  1 |   | 0  | ,|  1 |	| 0  |,|  1 |
	//	citesc pass1 = data[0][1]
		
		data[0][0] = "TestUser";
		data[0][1] = "12345@67890";
		data[0][2] = true;
		
		data[1][0] = "userGresit";
		data[1][1] = "passGresit";
		data[1][2] = false;
		
		data[2][0] = "TestUser";
		data[2][1] = "12345@67890";
		data[2][2] = true;
		
		return data;
	}

	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String user, String pass, boolean sucess) {
		
		app.click(app.menu.loginLink);
		app.login.loginInApp(user, pass);
		
		if(sucess) {
			
			assertTrue(app.login.checkLoginMessageIsDiplayed(app.login.sucessLoginPopup));
			app.login.logoutFromApp();

		}else if(!sucess) {
			assertTrue(app.login.checkLoginMessageIsDiplayed(app.login.errorLoginPopup));
			app.click(app.login.closeButton);
		}
		
	}
	
	
	
	
	
	
}
