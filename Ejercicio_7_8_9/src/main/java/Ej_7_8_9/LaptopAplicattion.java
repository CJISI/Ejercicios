package Ej_7_8_9;

import Ej_7_8_9.Entities.Laptop;
import Ej_7_8_9.Repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LaptopAplicattion {

	public static void main(String[] args) {



		Laptop laptop1 = new Laptop(null, "Asus","i7");
		Laptop laptop2 = new Laptop(null, "HP","i5");
		Laptop laptop3 = new Laptop(null, "Lenovo","i9");
		Laptop laptop4 = new Laptop(null, "Primux","i3");

		ApplicationContext context = SpringApplication.run(LaptopAplicattion.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);
		repository.save(laptop4);




	}

}
