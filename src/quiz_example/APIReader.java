package quiz_example;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class APIReader {
    public JSONArray getQuestions() {
        try {
            URL url = new URL("https://opentdb.com/api.php?amount=10");
            InputStreamReader is = new InputStreamReader(url.openStream());
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(is);
            JSONArray questions = (JSONArray) json.get("results");
            return questions;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Question> getQuestionList() {
        ArrayList<Question> questions = new ArrayList<>();
        JSONArray json = getQuestions();
        for(int i = 0; i < json.size(); i++) {
            JSONObject obj = (JSONObject) json.get(i);
            String type = (String) obj.get("type");
            Question q;
            if(type.equals("boolean")) {
                q = new TrueFalse();
            }
            else {
                q = new MultipleChoice();
            }
            q.category = (String) obj.get("category");
            q.question = StringEscapeUtils.unescapeHtml4((String) obj.get("question"));
            JSONArray incorrect = (JSONArray) obj.get("incorrect_answers");
            String [] incorrectAnswers = new String[3];
            for(int j = 0; j < incorrect.size(); j++) {
                incorrectAnswers[j] = StringEscapeUtils.unescapeHtml4((String) incorrect.get(j));
            }
            q.setAnswers(StringEscapeUtils.unescapeHtml4((String) obj.get("correct_answer")), incorrectAnswers);
            questions.add(q);
        }
        return questions;
    }
}
