package api.test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoint;
import api.payload.Store;
import api.utilities.DataProviders;

public class StoreDataDrivenTest {
	Store store;
	@Test(priority=1,dataProvider = "StoreData",dataProviderClass = DataProviders.class)
	public void createStoreTest(String id, String petId, String quantity, String shipDate,String status,String complete)
	{
		store = new Store();
		store.setId(Integer.parseInt(id));
		store.setComplete(Boolean.parseBoolean(complete));
		store.setPetId(Integer.parseInt(petId));
		store.setQuantity(Integer.parseInt(quantity));
		store.setShipDate(shipDate);
		store.setStatus(status);
		Response res = StoreEndPoint.createStore(store);
		res.then()
		.log().all();
}
	@Test(priority=2,dataProvider="StoreId",dataProviderClass=DataProviders.class)
	public void getStoreTest(String id)
	{
		Response res = StoreEndPoint.getStore(Integer.parseInt(id));
		res.then()
		.statusCode(200)
		.log().all();
}
	@Test(priority=3,dataProvider="StoreId",dataProviderClass=DataProviders.class)
	public void deleteStoreTest(String id)
	{
		Response res = StoreEndPoint.deleteStore(Integer.parseInt(id));
		res.then()
		.statusCode(200)
		.log().all();
}
}
