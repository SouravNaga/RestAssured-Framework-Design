package api.endpoints;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class UserEndPoint {

	public static Response createUser(User payload) {
		Response response = given()
			.contentType(ContentType.JSON)
			.body(payload)
		.when()
		.post(Routes.post_url);
		return response;
	}
	public static Response getUser(String user) {
		Response response = given()
			.pathParam("username", user)
		.when()
		.get(Routes.get_url);
		return response;
	}
	public static Response updateUser(String user, User payload) {
		Response response = given()
			.pathParam("username", user)
			.contentType(ContentType.JSON)
			.body(payload)
		.when()
		.put(Routes.put_url);
		return response;
	}
	public static Response deleteUser(String user) {
		Response response = given()
			.pathParam("username", user)
		.when()
		.delete(Routes.delete_url);
		return response;
	}
}
