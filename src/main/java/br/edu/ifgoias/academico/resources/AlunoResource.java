package br.edu.ifgoias.academico.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.services.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;
	
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(){
		
		List<Aluno> listaAluno = service.findAll();
		
		return ResponseEntity.ok().body(listaAluno);
		
	}
	
	@GetMapping( value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id){
		Aluno aluno =service.findById(id);
		return ResponseEntity.ok().body(aluno);
	}
	
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno){
		Aluno alunoRes = service.insert(aluno);
		return ResponseEntity.ok().body(aluno);
		
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@PutMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Aluno> update(@PathVariable Integer id,@RequestBody Aluno aluno) {
		Aluno alunoRes = service.update(id, aluno);
		return ResponseEntity.ok().body(alunoRes);
	
	}
}
