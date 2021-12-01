
import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class ApiController {
    private String basicUrlSpecificPokemon = "https://pokeapi.co/api/v2/pokemon/";
    private final String basicUrlAllPokemon = "https://pokeapi.co/api/v2/pokemon?limit=151";


    /**
     * Constructor for specific pokemon
     *
     * @param pokemonId pokemon id
     */
    public ApiController(int pokemonId) {
        getHttpRequest(basicUrlSpecificPokemon + pokemonId);
    }

    /**
     * Constructor for all pokemon
     */
    public ApiController() {
        getHttpRequest(basicUrlAllPokemon);
    }

    /**
     * Get http request
     *
     * @param uri
     */
    public void getHttpRequest(String uri) {
        System.out.println("hello");
        System.out.println(uri);

        URL url = null;
        HttpURLConnection con = null;
        try {
            url = new URL(uri);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            URIBuilder builder = new URIBuilder(uri);
            String json = Request.Get(builder.build())
                    .connectTimeout(1000)
                    .socketTimeout(1000)
                    .execute().returnContent().asString();
            System.out.println(json);
            //return the quote object.


//            Scanner scanner = new Scanner(url.openStream());
//            String response = scanner.useDelimiter("\\Z").next();
//            System.out.println("response : " + response);
//
//
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer content = new StringBuffer();
//            while ((inputLine = in.readLine()) != null) {
//                content.append(inputLine);
//            }
//            System.out.println("Response: " + content);
//            in.close();

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }



        System.out.println();

    }
}
