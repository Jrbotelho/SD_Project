package sd_project.score_dei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScoreDeiApplication {

    public static void main(String[] args) { SpringApplication.run(ScoreDeiApplication.class, args); }

}
