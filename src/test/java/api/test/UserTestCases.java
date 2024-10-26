package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;

public class UserTestCases {
    Faker faker;
    User userpayload;

    @BeforeClass
    public void setupdata() {
        faker = new Faker();
        userpayload = new User();
        userpayload.setId(faker.idNumber().hashCode());
        userpayload.setUsername(faker.name().username());
        userpayload.setFirstname(faker.name().firstName());
        userpayload.setLastname(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());
        userpayload.setPassword(faker.internet().password());
        userpayload.setPhone(faker.phoneNumber().cellPhone());
        userpayload.setUserStatus(faker.number().numberBetween(0, 2));
    }

    @Test(priority = 1)
    public void testPostUser() {
        Response response = UserEndPoint.createUser(userpayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 2)
    public void testGetUserbyname() {
        Response response = UserEndPoint.getUser(userpayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 3)
    public void testUpdateUserbyname() {
    	userpayload.setFirstname(faker.name().firstName());
        userpayload.setLastname(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress()); 
        Response response = UserEndPoint.updateUser(userpayload.getUsername(),userpayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 4)
    public void testDeleteUserbyname() {
        Response response = UserEndPoint.deleteUser(userpayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
