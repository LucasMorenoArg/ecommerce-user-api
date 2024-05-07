package com.ecommerceuserapi.repository;

import com.ecommerceuserapi.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends CrudRepository<Usuario,Integer> {

}
