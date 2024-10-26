package api.endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import api.payload.Store;
public class StoreEndPoint {
	
	public static Response createStore(Store storepayload)
	{
		Response response = given()
		.contentType(ContentType.JSON)
		.body(storepayload)
		.when()
		.post(Routes.store_post_url)
		;
		return response;
	}
	public static Response getStore(int storeid)
	{
		Response response = given()
				.pathParam("id", storeid)
		.when()
		.get(Routes.store_get_url)
		;
		return response;
	}
	public static Response deleteStore(int storeid)
	{
		Response response = given()
				.pathParam("id", storeid)
		.when()
		.delete(Routes.store_delete_url)
		;
		return response;
	}

}
