package devmind.c20.controller;

import devmind.c20.entity.Course;
import devmind.c20.entity.Professor;
import devmind.c20.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping("/profesor/{id}")
    public Professor getProfessor(@PathVariable Long id) {
        return professorService.findById(id);
    }

    @GetMapping("/profesor/course/{id}")
    public Iterable<Course> getCourses(@PathVariable Long id) {
        return professorService.findById(id).getCourses();
    }


    //Pornind de la structura de clase prezentate în cursul Asocieri în Hibernate și de la cunoștințele din acest capitol, implementează următoarele exerciții:
    //
    //Creează clasa ProfesorController care să servească drept REST Controller pentru următoarele rute:
    ///profesor/{id} - un call de tip GET pe această rută va returna informații despre profesorul cu ID-ul id.
    ///profesor/materii/{id} - un call de tip GET pe această rută va returna informații despre materiile la care predă profesorul cu ID-ul id.
    //Creează clasa StudentController care să servească drept REST Controller pentru ruta /student/enroll?studentId={studentId}&materieId={materieId}. Un call de tip POST pe această rută va insera o intrare corespunzătoare în tabela studenti_to_materii, care va marca faptul că studentul cu ID-ul studentId participă la cursul cu ID-ul materieId.
    //Adaugă o metodă în cadrul StudentController care să răspundă request-urilor POST venite pe ruta /student, având un request body de forma:
    //{
    //    "nume": "Cristi",
    //    "prenume": "Popescu",
    //    "cnp": "12345",
    //    "adresa": {
    //        "strada": "Iuliu Maniu",
    //        "numar": "23",
    //        "localitate": "Oradea"
    //    }
    //}
    //Metoda trebuie să creeze un nou student pe care să îl salveze în baza de date împreună cu adresa acestuia.
    //
    //Adaugă o metodă în cadrul StudentController care să răspundă request-urilor PUT venite pe ruta /student/{studentId}/adresa, având un request body de forma:
    //{
    //    "strada": "Iuliu Maniu",
    //    "numar": "23",
    //    "localitate": "Oradea"
    //}
    //Metoda trebuie să actualizeze adresa studentului cu ID-ul studentId (în cazul în care există), astfel încât aceasta să conțină valorile primite în request body.
    //
    //Adaugă o metodă în cadrul StudentController care să răspundă request-urilor DELETE venite pe ruta /student/{studentId}. Metoda trebuie să șteargă studentul cu ID-ul studentId din baza de date, împreună cu toate entitățile asociate acestuia (adresa, cursuri la care participă, etc.).
    //[Extra] Implementează un sistem de notare în cadrul aplicației tale. O entitate de tip Nota trebuie să conțină, cel puțin, studentul căruia a fost acordată, materia la care a fost acordată și data la care a fost acordată. Creează o clasă CatalogController din care să expui rute pentru:
    //Adăugarea unei note pentru un student la o anumită materie.
    //Aflarea tuturor notelor unui student.
    //Aflarea tuturor notelor unui student la o materie specifică.
    //Aflarea tuturor notelor unui student într-un interval de timp specific.
}
