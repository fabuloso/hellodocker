import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static javax.swing.text.DefaultStyledDocument.ElementSpec.ContentType;
import static org.bson.Document.parse;
import static org.springframework.boot.SpringApplication.run;

@Controller
@EnableAutoConfiguration
public class SampleController {

    private MongoCollection<Document> stuff;

    public SampleController() {
        MongoClient mongo = new MongoClient("mongo" , 27017 );
        MongoDatabase database = mongo.getDatabase("db");
        stuff = database.getCollection("stuff");
    }


    @RequestMapping ("/insert")
    @ResponseBody
    String insertSomeStuff() {
        stuff.insertMany(asList(
                parse("{\"data\": \"bella\"}"),
                parse("{\"data\": \"brutta\"}"),
                parse("{\"data\": \"simpatica\"}")
            )
        );
        return "inseriti dati significativi nel database";
    }

    @RequestMapping (value = "/get", produces = "application/json")
    @ResponseBody
    String getStuff() {
        List<String> output = new ArrayList<>();
        stuff.find().forEach((Consumer<? super Document>) e -> output.add(e.toJson()));
        return JSON.serialize(output);
    }

    public static void main(String[] args) throws Exception {
        run(SampleController.class, args);
    }
}
