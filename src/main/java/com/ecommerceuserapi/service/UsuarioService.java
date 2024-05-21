package com.ecommerceuserapi.service;

import com.ecommerceuserapi.entities.AccountRequest;
import com.ecommerceuserapi.entities.Usuario;
import com.ecommerceuserapi.repository.UsuarioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepo usuarioRepo;
    private final RestTemplate restTemplate;

    public Iterable<Usuario> getAll() {
        return usuarioRepo.findAll();
    }

    public Optional<Usuario> byId(int id) {
        return usuarioRepo.findById(id);
    }

    public Usuario save(Usuario usuario) {

        Usuario usuarioResponse = usuarioRepo.save(usuario);
        String url = "http://localhost:8081/Account/create";
        LocalDate localDate = LocalDate.now();
        AccountRequest accountRequest = new AccountRequest("activo", localDate, 2000, usuario.getId());
        restTemplate.postForObject(url, accountRequest, String.class);
        return usuarioResponse ;
    }

    public boolean delete(int id){

            if (usuarioRepo.existsById(id)) {
                usuarioRepo.deleteById(id);
                return true;

            } else return false;
    }
}
