package com.ecommerceuserapi.service;

import com.ecommerceuserapi.entities.Usuario;
import com.ecommerceuserapi.repository.UsuarioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepo usuarioRepo;

    public Iterable<Usuario> getAll() {
        return usuarioRepo.findAll();
    }

    public Optional<Usuario> byId(int id) {
        return usuarioRepo.findById(id);
    }

    public Usuario save(Usuario usuario) {return usuarioRepo.save(usuario);}

    public boolean delete(int id){

            if (usuarioRepo.existsById(id)) {
                usuarioRepo.deleteById(id);
                return true;

            } else return false;
    }
}
