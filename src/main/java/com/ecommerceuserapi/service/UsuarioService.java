package com.ecommerceuserapi.service;

import com.ecommerceuserapi.entities.AccountRequest;
import com.ecommerceuserapi.entities.Status;
import com.ecommerceuserapi.entities.Usuario;
import com.ecommerceuserapi.repository.UsuarioRepo;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;

import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private  UsuarioRepo usuarioRepo;

    private  RestTemplate restTemplate;

    public UsuarioService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public Iterable<Usuario> getAll() {
        System.out.println(usuarioRepo);
        return usuarioRepo.findAll();
    }

    public Optional<Usuario> byId(int id) {
        return usuarioRepo.findById(id);
    }

    public Usuario save(Usuario usuario) throws ResourceAccessException{

        usuario.setEstado(Status.ACTIVE);
        Usuario usuarioResponse= usuarioRepo.save(usuario);
        System.out.println(usuario);
        String url = "http://localhost:8081/Account/create";
        LocalDate localDate = LocalDate.now();
        AccountRequest accountRequest = new AccountRequest("activo", localDate, 2000, usuario.getId());
        try {
            restTemplate.postForObject(url, accountRequest, String.class);
        } catch (ResourceAccessException e) {
            usuarioResponse.setEstado(Status.PENDING_CHARGE);
            usuarioRepo.save(usuarioResponse);

        }

        return usuarioResponse;
    }

    public boolean delete(int id){

            if (usuarioRepo.existsById(id)) {
                usuarioRepo.deleteById(id);
                System.out.println(byId(id));
                return true;

            } else return false;
    }
}
