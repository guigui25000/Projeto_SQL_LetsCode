package letscode.controller;


import letscode.entity.Professor;
import letscode.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public Iterable<Professor> buscarProfessores(){
        Iterable<Professor> professores = professorRepository.findAll();
        return professores;
    }

    @PostMapping
    public Professor cadastrar(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping()
    public Professor alterar(@RequestBody Professor professor){
        return professorRepository.save(professor);
    }

    @DeleteMapping("/{rp}")
    public ResponseEntity<?> deletar(@PathVariable Integer rp){
        professorRepository.deleteById(rp);
        return ResponseEntity.ok().build();
    }
}
