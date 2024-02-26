package devmind.c20.service;

import devmind.c20.entity.Address;
import devmind.c20.entity.Course;
import devmind.c20.entity.Student;
import devmind.c20.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final CourseService courseService;
    private final StudentRepository studentRepository;

    public Student enroll(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseService.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        student.getEnrolledCourses().add(course);

        return studentRepository.save(student);
    }

    public Student addStudent(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    public Student updateAddress(Long studentId, Address address) {
        address.setId(null);
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setAddress(address);
        return studentRepository.save(student);
    }

    public Student getStudent(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
