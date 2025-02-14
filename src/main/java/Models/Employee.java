package Models;
//Même package que Department, ce qui permet aux classes d’interagir facilement.
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

//@Entity → Indique que cette classe est une table en base de données
@Entity
public class Employee {
    private Long id;

    private String name;

   // department stocke une référence vers le département auquel l'employé appartient.
    private Department department;

    public Employee() {
    }

   // Constructeur par défaut requis par JPA.
    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    //Constructeur pour créer un employé avec un nom et un département.
    public Employee(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Gestion de la relation ManyToOne avec Department
    //@ManyToOne → Plusieurs employés peuvent appartenir au même département (relation N-1).

    @ManyToOne
    public Department getDepartment() {
        return department;
    }

    //Setter pour définir le département de l’employé.
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
   // Méthode toString() Cette méthode permet d’afficher un employé sous forme lisible.
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department="
                + department.getName() + "]";
    }

}
