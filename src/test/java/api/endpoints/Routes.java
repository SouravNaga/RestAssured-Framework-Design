package api.endpoints;

public class Routes {
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//user module
	public static String post_url = base_url+ "/user";
	public static String get_url = base_url+ "/user/{username}";
	public static String put_url = base_url+ "/user/{username}";
	public static String delete_url = base_url+ "/user/{username}";
	
	//store module
	public static String store_post_url = base_url+ "/store/order";
	public static String store_get_url = base_url+ "/store/order/{id}";
	public static String store_put_url = base_url+ "/store/order/{id}";
	public static String store_delete_url = base_url+ "/store/order/{id}";
	// pet module

}
