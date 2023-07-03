package com.example.EC2;
import javax.management.ConstructorParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;
import java.lang.String;
import java.lang.Object;

@Controller 
@RequestMapping(path="/cursos") 
public class MainController {
  @Autowired 
  private CursosRepository cursosRepository;

  @Autowired
  private JdbcTemplate jdbcTemplate;



  @PostMapping(path="/add") // POST http://localhost:8080/demo/add
  public @ResponseBody String addNewCursos (@RequestParam String nombre, @RequestParam Integer creditos) {

    Cursos n = new Cursos();
    n.setNombre(nombre);
    n.setCreditos(creditos);
    cursosRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all") // GET http://localhost:8080/demo/all
  public @ResponseBody Iterable<Cursos> getAllCursos() {
    return cursosRepository.findAll();
  }

  @GetMapping(path="/ver/{id}") // GET http://localhost:8080/demo/all
  public @ResponseBody Cursos getCursos(@PathVariable("id") Integer id) {
    return cursosRepository.findById(id).orElse(null);
  }

  @DeleteMapping(path="/del")
  public @ResponseBody String deleteCursos(@RequestParam Integer id) {
    Cursos cursos = cursosRepository.findById(id).orElse(null);
    if (cursos != null) {
      cursosRepository.delete(cursos);
      return "Deleted";
    }
    return "Not found";
  }





}