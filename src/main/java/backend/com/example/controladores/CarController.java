package backend.com.example.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CarController {

    @GetMapping("/marcas")
    public List<String> obtenerMarcasDeCarros() {
        List<String> marcas = Arrays.asList("Toyota", "Honda", "Ford", "Chevrolet", "BMW");
        return marcas;
    }
}