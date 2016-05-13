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

    public static void main(String[] args) throws Exception {
        run(SampleController.class, args);
    }
}
