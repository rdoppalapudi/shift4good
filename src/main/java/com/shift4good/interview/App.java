package com.shift4good.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {
	private BufferedReader br;

	public static void main(String[] args) {
		App pr1 = new App();
		JSONArray array = null;
		try {
			String jsonStr = pr1.parseJson("data/jsonfile");
			JSONParser parser = new JSONParser();
			array = (JSONArray) ((JSONObject) parser.parse(jsonStr))
					.get("services");
			array = ((JSONArray) ((JSONObject) array.get(0))
					.get("dependencies"));
			for (int i = 0; i < array.size(); i++) {
				StringTokenizer stok = new StringTokenizer(
						(String) array.get(i), "=");
				System.out.println(stok.nextToken() + "\t" + stok.nextToken());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public String parseJson(String jsonFile) throws IOException {
		FileReader reader = new FileReader(new File(jsonFile));
		br = new BufferedReader(reader);
		String line;
		StringBuilder jsonStr = new StringBuilder();
		while ((line = br.readLine()) != null) {
			jsonStr.append(line);
		}

		return jsonStr.toString();
	}

}
