package devmind.c20.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private Professor professor;

    @OneToMany
    @JsonIgnore
    private Set<Student> students;
}
