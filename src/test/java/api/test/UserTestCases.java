package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    public Logger logger;
    @BeforeClass
    public void setup() {
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
        
        //logs
        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void testPostUser() {
    	logger.info("********** Creating user *********");
        Response response = UserEndPoint.createUser(userpayload);
        response.then().log().all();
        logger.info("********** User is created *********");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 2)
    public void testGetUserbyname() {
    	logger.info("********** Reading user info *********");
        Response response = UserEndPoint.getUser(userpayload.getUsername());
        response.then().log().all();
        logger.info("********** user info is displayed *********");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 3)
    public void testUpdateUserbyname() {
    	userpayload.setFirstname(faker.name().firstName());
        userpayload.setLastname(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress()); 
        logger.info("********** user info updating start *********");
        Response response = UserEndPoint.updateUser(userpayload.getUsername(),userpayload);
        response.then().log().all();
        logger.info("********** user info updated *********");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 4)
    public void testDeleteUserbyname() {
        Response response = UserEndPoint.deleteUser(userpayload.getUsername());
        response.then().log().all();
        logger.info("**********  user info deleted *********");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
