package com.ecommerceuserapi.controller;

import com.ecommerceuserapi.entities.Usuario;
import com.ecommerceuserapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("getAll")
    public Iterable<Usuario> getAll(){
        return usuarioService.getAll();
    }
    @GetMapping("getId/{id}")
    public Usuario getId(@PathVariable int id){
      return usuarioService.byId(id).get();
    }
    @PostMapping("save")
    public void save(@RequestBody Usuario usuario){
        Optional<Usuario> usuario1= Optional.of(usuario);
        if (usuario1.isPresent()) {
            usuarioService.save(usuario);
        }
    }
    @DeleteMapping("deleteId/{id}")
    public void delete(@PathVariable int id) throws Exception {
        usuarioService.deleteById(id);
    }

}
