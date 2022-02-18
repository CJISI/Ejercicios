package Ej_7_8_9.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hola")
    public String holaMundo() {
        return "Hola Mundo  !";
    }
}
