package desafioJava;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import desafioJava.Movies.Movie;

public class IdmbMovieJsonParser {

	public List<Movie> parse(JSONArray moviesJSON) {
		
		List<String> titles = new ArrayList<>();
		List<String> urlImages = new ArrayList<>();
		List<String> ratings = new ArrayList<>();
		List<String> years = new ArrayList<>();

		moviesJSON.forEach(movie -> {
			titles.add((String) ((JSONObject) movie).get("fullTitle"));
			urlImages.add((String) ((JSONObject) movie).get("image"));
			ratings.add((String) ((JSONObject) movie).get("imDbRating"));
			years.add((String) ((JSONObject) movie).get("year"));
		});

		List<Movie> movies = new ArrayList<>(titles.size());

		for (int i = 0; i < titles.size(); i++) {
			movies.add(new Movie(titles.get(i), urlImages.get(i), ratings.get(i), years.get(i)));
		}

		return movies;

	}
}
