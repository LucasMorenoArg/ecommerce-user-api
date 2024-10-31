package com.ecommerceuserapi.controller;

import com.ecommerceuserapi.entities.Usuario;
import com.ecommerceuserapi.repository.UsuarioRepo;
import com.ecommerceuserapi.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UsuarioController {

    private UsuarioService usuarioService;

    private UsuarioRepo usuarioRepo;

    public UsuarioController(UsuarioService usuarioService, UsuarioRepo usuarioRepo) {
        this.usuarioService = usuarioService;
        this.usuarioRepo = usuarioRepo;
    }

    @GetMapping("getAll")
    public Iterable<Usuario> getAll() {
        System.out.println(usuarioRepo + " Singleton en controller ");
        return usuarioService.getAll();
    }

    @GetMapping("getId/{id}")
    public Usuario getId(@PathVariable int id) {
        return usuarioService.byId(id).get();
    }

    @GetMapping("byDni")
    public Usuario byDni(@RequestParam Integer nro_documento) throws IllegalArgumentException {

        if (nro_documento != null && nro_documento > 0) {

            return usuarioRepo.findByDni(nro_documento);

        } else throw new IllegalArgumentException("Verificar nro de documento");
    }

    @PostMapping("save")
    public Usuario save(@RequestBody Usuario usuario) {
        System.out.println(usuario);
        Optional<Usuario> usuario1= Optional.of(usuario);
        if (usuario1.isPresent()) {
            usuarioService.save(usuario);
        }   return usuario1.get();
    }
    @DeleteMapping("deleteId/{id}")
    public void delete(@PathVariable int id) throws Exception {
        usuarioService.delete(id);
    }
}
