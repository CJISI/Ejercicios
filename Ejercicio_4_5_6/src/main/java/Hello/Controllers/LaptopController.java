package Hello.Controllers;

import Hello.Entities.Laptop;
import Hello.Repository.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository repository) {
        this.laptopRepository = repository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @PostMapping("/api/laptop")
    public Laptop create(@RequestBody Laptop laptop) {
        return laptopRepository.save(laptop);
    }
}
