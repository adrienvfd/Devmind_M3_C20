package devmind.c20.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String lastname;
    private String firstname;
    private String cnp;

    @ManyToOne(fetch = FetchType.EAGER)
    private Address address;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Course> courses;
}
