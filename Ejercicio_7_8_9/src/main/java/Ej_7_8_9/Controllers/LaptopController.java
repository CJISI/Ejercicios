package Ej_7_8_9.Controllers;

import Ej_7_8_9.Entities.Laptop;
import Ej_7_8_9.Repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//   OK    findOneById()
//   OK    create()
//   OK    update()
//        delete()
//        deleteAll()

@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    public LaptopController(LaptopRepository repository) {
        this.laptopRepository = repository;
    }

    // Buscar todos los portatiles
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    //    Buscar portatil por su id
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        if (!laptopOpt.isPresent()) {
            log.warn("Intentado buscar un laptop que no existe");
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(laptopOpt.get());
    }


    // Crear un la laptop
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
        // el id de laptop ya existe entonces
        // no se puede crear por que ya existe
        if (laptop.getId() != null) {
            log.warn("Intentado crear un laptop con un ID ya existente");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);

        return ResponseEntity.ok(result);
    }

    // Actualizar laptop
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
//        System.out.println(laptop.toString());
//        // Compruebo que el id de laptop no exista
        if (laptop.getId() == null) {
            log.warn("Intentado actualizar un laptop sin ID");
            return ResponseEntity.badRequest().build();
        }

        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("Intentado actualizar un laptop que no existe");
            return ResponseEntity.notFound().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    // Metoto delete() : Eliminar laptop
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {

        if (!laptopRepository.existsById(id)) {
            log.warn("Intentado eliminar un laptop que no existe");
            ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    // Metodo deleteAll() : Eliminar todos los libros
    @DeleteMapping("/api/laptops/deleteAll")
    public ResponseEntity<Laptop> deleteAll() {
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
