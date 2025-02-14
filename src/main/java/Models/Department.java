package Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {

    private Long id;

    private String name;

    private List<Employee> employees = new ArrayList<Employee>();
// CONTRUCTEUR
    public Department() {
        super();
    }

    public Department(String name) {
        this.name = name;
    }
//    Un constructeur par défaut nécessaire pour JPA.

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
    } //    Getter qui retourne le nom du département.

    public void setName(String name) {
        this.name = name;
    }//    Setter qui modifie le nom du département.

//    Gestion de la relation OneToMany avec Employee
//    @OneToMany → Un département peut contenir plusieurs employés (relation 1-N)
//    mappedBy = "department" → Indique que l’attribut department dans Employee est responsable de la relation.
//    cascade = CascadeType.PERSIST → Si on ajoute un département, ses employés seront enregistrés automatiquement en base.

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
