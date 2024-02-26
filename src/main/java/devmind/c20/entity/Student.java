package devmind.c20.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String cnp;
    private String email;
    private String phone;

    @OneToOne(fetch = FetchType.EAGER, cascade = PERSIST)
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER, cascade = PERSIST)
    @JoinTable(
            name = "students_to_courses",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_course"))
    private Set<Course> enrolledCourses;
}
