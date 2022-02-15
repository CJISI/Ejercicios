package Hello.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String core;

    public Laptop() {
    }

    public Laptop(Long id, String brand, String core) {
        this.id = id;
        this.brand = brand;
        this.core = core;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }
}
