package api.endpoints;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import org.json.JSONObject;
public class UserEndPoint2 {

	static ResourceBundle getURLs(){
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	public static Response createUser(User payload) {
		String post_url = getURLs().getString("post_url");
		Response response = given()
			.contentType(ContentType.JSON)
			.body(payload)
		.when()
		.post(post_url);
		return response;
	}
	public static Response getUser(String user) {
		String get_url = getURLs().getString("get_url");
		Response response = given()
			.pathParam("username", user)
		.when()
		.get(get_url);
		return response;
	}
	public static Response updateUser(String user, User payload) {
		String put_url = getURLs().getString("update_url");
		Response response = given()
			.pathParam("username", user)
			.contentType(ContentType.JSON)
			.body(payload)
		.when()
		.put(put_url);
		return response;
	}
	public static Response deleteUser(String user) {
		String delete_url = getURLs().getString("delete_url");
		Response response = given()
			.pathParam("username", user)
		.when()
		.delete(delete_url);
		return response;
	}
}
