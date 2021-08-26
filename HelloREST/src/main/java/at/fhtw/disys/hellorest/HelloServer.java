package at.fhtw.disys.hellorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class HelloServer {
    @GetMapping("/hello")
    public String helloworld(
            @RequestParam final String name) {
        return "Hello, " + name + "\n";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloServer.class, args);
    }
}
