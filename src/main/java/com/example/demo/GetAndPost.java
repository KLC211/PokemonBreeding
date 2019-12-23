package com.example.demo;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class GetAndPost {
    //This class get's the pokemon for each egg group from rest API
    public static ArrayList<String> MyGet(int x) throws IOException, JSONException {

            URL urlForGet = new URL("https://pokeapi.co/api/v2/egg-group/"+x+"/");
            String readLine=null;
            HttpURLConnection connection = (HttpURLConnection) urlForGet.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("pokemon_species", "name");
            int responseCode = connection.getResponseCode();

        ArrayList<String> PokeName=new ArrayList<>();

        if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream())
                );
                StringBuffer response = new StringBuffer();
                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }
                in.close();



            JSONObject obj=new JSONObject(response.toString());
            JSONArray pokemonSpecies = obj.getJSONArray("pokemon_species");
                int n = pokemonSpecies.length();
                for (int i=0; i<n; i++){
                    JSONObject pokemon = pokemonSpecies.getJSONObject(i);
                    PokeName.add(pokemon.getString("name"));
                }


            }else{
                System.out.println("GET NOT WORKING");
                return null;
            }
        return PokeName;
    }

    //This method returns all eg groups and their ID.
    public static ArrayList<String> GetGroups() throws IOException, JSONException {

        URL urlForGet = new URL("https://pokeapi.co/api/v2/egg-group/");
        String readLine=null;
        HttpURLConnection connection = (HttpURLConnection) urlForGet.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("pokemon_species", "name");
        int responseCode = connection.getResponseCode();

        ArrayList<String> GroupName=new ArrayList<>();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();



            JSONObject obj=new JSONObject(response.toString());
            JSONArray pokemonSpecies = obj.getJSONArray("results");
            int n = pokemonSpecies.length();
            for (int i=0; i<n; i++){
                JSONObject pokemon = pokemonSpecies.getJSONObject(i);
                GroupName.add(pokemon.getString("name"));
            }


        }else{
            System.out.println("GET NOT WORKING");
            return null;
        }
        return GroupName;
    }
}
