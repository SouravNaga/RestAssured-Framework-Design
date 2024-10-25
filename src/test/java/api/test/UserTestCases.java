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
        userpayload.setId(faker.number().randomDigitNotZero());
        userpayload.setUsername(faker.name().username());
        userpayload.setFirstname(faker.name().firstName());
        userpayload.setLastname(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());
        userpayload.setPassword(faker.internet().password());
        userpayload.setPhone(faker.phoneNumber().cellPhone());
        userpayload.setUserStatus(faker.number().numberBetween(0, 2));
    }

    @Test
    public void testPostUser() {
        Response response = UserEndPoint.createUser(userpayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    
}
