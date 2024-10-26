package api.test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoint;
import api.payload.Store;

public class StoreTestCases {
	Store store;
	Faker faker;
	@BeforeClass
	public void setup()
	{
		store = new Store();
		faker = new Faker();
		Random random = new Random();
		store.setId(faker.number().numberBetween(1, 1000));
		store.setComplete(random.nextBoolean());
		store.setPetId(faker.number().numberBetween(1, 1000));
		store.setQuantity(faker.number().numberBetween(1, 20));
		store.setShipDate("2024-10-26T15:33:18.166Z");
		store.setStatus(faker.options().option("placed", "approved", "delivered"));
	}
	@Test(priority=1)
	public void createStoreTest()
	{
		Response res = StoreEndPoint.createStore(store);
		res.then()
		.log().all();
}
	@Test(priority=2)
	public void getStoreTest()
	{
		Response res = StoreEndPoint.getStore(store.getId());
		res.then()
		.statusCode(200)
		.log().all();
}
	@Test(priority=3)
	public void deleteStoreTest()
	{
		Response res = StoreEndPoint.deleteStore(store.getId());
		res.then()
		.statusCode(200)
		.log().all();
}
}
