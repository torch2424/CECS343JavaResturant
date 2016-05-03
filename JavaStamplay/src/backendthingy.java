import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class backendthingy {

	public static void main(String[] args){

		try {
//			System.out.println(get("http://aaronthedev.com/#/"));
			System.out.println(get("https://flickering-fire-725.firebaseio.com/order.json"));
			//System.out.println(get("http://cecs343javaresturant.stamplayapp.com/api/cobject/v1/table/570c7284bb8e94981bd7d3f9"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public static String get(String url) throws Exception{

//		InputStream in = new URL(url).openStream();
//
//		try{
//			System.out.println( IOUtils.toString( in ));
//		} finally{
//			IOUtils.closeQuietly(in);
//		}

		URL website = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) website.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(false);
		connection.setRequestMethod("GET");
		connection.setRequestProperty("content-type", "application/json");
		connection.setRequestProperty("accept", "application/json");
		connection.setRequestProperty("User-Agent", "ClassJavaBot");

		connection.connect();

		System.out.println(connection.getResponseMessage());
		BufferedReader in = new BufferedReader(
								new InputStreamReader(
										connection.getInputStream()));



		StringBuilder response = new StringBuilder();
		String inputLine;

		while ( (inputLine = in.readLine()) != null){
			response.append(inputLine);
		}

		in.close();

		return response.toString();
	}
}