package at.fhtw.disys.hellorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@SpringBootApplication
public class HelloServer {
    @GetMapping("/hello")
    public String helloworld(
            @RequestParam final String name) {
        System.out.println("GET /hello name=" + name);
        return "Hello, " + name + "\n";
    }

    @PostMapping("/hello")
    public String helloworldPost(
            @RequestBody String body) {
        System.out.println("POST /hello params:\n" + body);
        HashMap<String, String> params = new HashMap<>();
        body.lines().forEach((v) -> params.put(v.split("=")[0], v.split("=")[1]));
        return "Hello, " + params.get("name") + "\n";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloServer.class, args);
    }
}
