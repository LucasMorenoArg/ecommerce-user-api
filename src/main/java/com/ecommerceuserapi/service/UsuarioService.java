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

    public boolean save(Usuario usuario) {
        usuarioRepo.save(usuario);
        return true;
    }

    public String deleteById(int id) throws Exception {
        try {
            if (byId(id).isPresent()) {
                Usuario usuario = byId(id).get();
                usuarioRepo.delete(usuario);
                return "El registro se eliminó correctamente";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
