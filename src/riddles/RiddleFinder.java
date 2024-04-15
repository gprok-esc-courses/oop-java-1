package riddles;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Connect to an API with riddles, currently using https://riddles-api.vercel.app/random
 * and get N riddles, depending on what any caller class wants
 */
public class RiddleFinder {
    public JSONObject getFromApi() {
        try {
            URL url = new URL("https://riddles-api.vercel.app/random");
            InputStreamReader is = new InputStreamReader(url.openStream());
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(is);
            return json;
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        } catch (ParseException e) {
            return null;
        }
    }

    public Riddle getRiddle() {
        JSONObject json = getFromApi();
        if(json != null) {
            Riddle riddle = new Riddle((String) json.get("riddle"), (String) json.get("answer"));
            return riddle;
        }
        else {
            return null;
        }
    }

    public ArrayList<Riddle> getRiddles(int n) {
        ArrayList<Riddle> riddles = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Riddle riddle = getRiddle();
            if(riddle == null) {
                return null;
            }
            riddles.add(riddle);
         }
        return riddles;
    }
}
