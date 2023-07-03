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
@RequestMapping(path="/idat/cursos") 
public class MainController {
  @Autowired 
  private CursosRepository cursosRepository;

  @Autowired
  private JdbcTemplate jdbcTemplate;



  @PostMapping(path="/nuevo")
  public @ResponseBody String addNewCursos (@RequestParam String nombre, @RequestParam Integer creditos) {

    Cursos n = new Cursos();
    n.setNombre(nombre);
    n.setCreditos(creditos);
    cursosRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/listar")
  public @ResponseBody Iterable<Cursos> getAllCursos() {
    return cursosRepository.findAll();
  }

  @DeleteMapping(path="/eliminar")
  public @ResponseBody String deleteCursos(@RequestParam Integer id) {
    Cursos cursos = cursosRepository.findById(id).orElse(null);
    if (cursos != null) {
      cursosRepository.delete(cursos);
      return "Deleted";
    }
    return "Not found";
  }

}