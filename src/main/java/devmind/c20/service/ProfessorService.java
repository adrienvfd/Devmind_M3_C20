package devmind.c20.service;

import devmind.c20.entity.Professor;
import devmind.c20.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public Professor findById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }
}
