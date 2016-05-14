import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.boot.SpringApplication.run;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping ("/hello")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping ("/get")
    @ResponseBody
    String getStuff() {
        MongoClient mongo = new MongoClient("mongo" , 27017 );
        MongoDatabase database = mongo.getDatabase("db");
        MongoCollection<Document> stuff = database.getCollection("stuff");
        return stuff.find().first().toJson();
    }

    public static void main(String[] args) throws Exception {
        run(SampleController.class, args);
    }
}
