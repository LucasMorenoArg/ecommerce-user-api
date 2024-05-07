package com.ecommerceuserapi.repository;

import com.ecommerceuserapi.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends CrudRepository<Usuario,Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.nroDocumento = :nro_documento")
    Usuario findByDni(@Param("nro_documento") Integer nro_documento);

}
