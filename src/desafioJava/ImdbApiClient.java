package desafioJava;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ImdbApiClient {
	
	private String apiKey; 
	
	public ImdbApiClient(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getBody() throws Exception {
		URI apiIMDB = URI.create("https://imdb-api.com/en/API/Top250Movies/" + this.apiKey);

		HttpRequest request = HttpRequest.newBuilder().GET().uri(apiIMDB).build();

		HttpClient httpClient = HttpClient.newBuilder().build();

		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		
		return response.body();
	}
}
