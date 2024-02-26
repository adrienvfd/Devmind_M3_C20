package devmind.c20.service;

import devmind.c20.entity.Course;
import devmind.c20.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

}
