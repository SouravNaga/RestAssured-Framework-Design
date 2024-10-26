package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoint;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	User userpayload;
	@Test(priority = 1,dataProvider ="Data",dataProviderClass=DataProviders.class)
    public void testPostUser(String userID, String userName,String fname,String lname,String useremail,String pwd,String ph,String status) {
		userpayload = new User();
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(userName);
		userpayload.setFirstname(fname);
		userpayload.setLastname(lname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(ph);
		userpayload.setUserStatus(Integer.parseInt(status));
        Response response = UserEndPoint.createUser(userpayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
	@Test(priority = 2,dataProvider ="UserNames",dataProviderClass=DataProviders.class)
    public void testPostUser(String userName) {
        Response response = UserEndPoint.deleteUser(userName);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
