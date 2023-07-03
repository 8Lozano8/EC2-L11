package com.example.EC2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cursos {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private String  nombre;
  private Integer creditos;
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public Integer getCreditos() {
    return creditos;
  }

  public void setCreditos(String creditos){
    this.creditos = creditos;
  }



}