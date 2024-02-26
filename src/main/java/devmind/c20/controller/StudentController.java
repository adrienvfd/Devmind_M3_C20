package devmind.c20.controller;

import devmind.c20.entity.Address;
import devmind.c20.entity.Student;
import devmind.c20.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{studentId}")
    public Optional<Student> getStudent(@PathVariable Long studentId) {
        return Optional.ofNullable(studentService.getStudent(studentId));
    }

    @PostMapping("/enroll")
    public Optional<Student> enroll(@RequestParam Long studentId, @RequestParam Long courseId) {
        return Optional.ofNullable(studentService.enroll(studentId, courseId));
    }

    @PostMapping("/")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{studentId}/address")
    public Optional<Student> updateAddress(@PathVariable Long studentId, @RequestBody Address address) {
        return Optional.ofNullable(studentService.updateAddress(studentId, address));
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }


//    Adaugă o metodă în cadrul StudentController care să răspundă request-urilor POST venite pe ruta /student, având un request body de forma:
//    {
//        "nume": "Cristi",
//            "prenume": "Popescu",
//            "cnp": "12345",
//            "adresa": {
//        "strada": "Iuliu Maniu",
//                "numar": "23",
//                "localitate": "Oradea"
//    }
//    }
//    Metoda trebuie să creeze un nou student pe care să îl salveze în baza de date împreună cu adresa acestuia.

//    Adaugă o metodă în cadrul StudentController care să răspundă request-urilor PUT venite pe ruta /student/{studentId}/adresa,
//    având un request body de forma:
//    {
//        "strada": "Iuliu Maniu",
//            "numar": "23",
//            "localitate": "Oradea"
//    }


}

