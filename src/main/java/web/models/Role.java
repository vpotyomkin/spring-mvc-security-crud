package web.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;

    public Role(String name) {
        this.name = name;
    }
    /*@ManyToMany(mappedBy = "roles")
    private Set<User> users;*/

    @Override
    public String toString() {
        return name;
    }

}
