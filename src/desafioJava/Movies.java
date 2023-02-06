package desafioJava;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Movies {

	public static record Movie(String title, String urlImage, String rating, String year) implements Content {

		@Override
		public int compareTo(Content c) {
			return this.rating().compareTo(c.rating());
		}

	}

	public static void main(String[] args) throws Exception {

		String apiKey = "";
		
		String json = new ImdbApiClient(apiKey).getBody();

		JSONObject jsonObject = new JSONObject(json);

		JSONArray moviesJSON = (JSONArray) jsonObject.get("items");
		
		List<Movie> movies = new IdmbMovieJsonParser().parse(moviesJSON);
		
		Collections.sort(movies, Comparator.comparing(Content::year));
		
		PrintWriter writer = new PrintWriter("content.html");
		new HtmlGenerator(writer).generate(movies);
		writer.close();
		
	}
	
	

}
