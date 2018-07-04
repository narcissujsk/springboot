package spring.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Value("$(name)")
    private String name;
    @Value("$(description)")
    private String description;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!111   </br>"+name+"   "+description;
    }
}