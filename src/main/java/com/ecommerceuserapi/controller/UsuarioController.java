package com.ecommerceuserapi.controller;

import com.ecommerceuserapi.entities.Usuario;
import com.ecommerceuserapi.repository.UsuarioRepo;
import com.ecommerceuserapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UsuarioController {


    private final UsuarioRepo usuarioRepo;
    private final UsuarioService usuarioService;

    @GetMapping("getAll")
    public Iterable<Usuario> getAll(){
        return usuarioService.getAll();
    }
    @GetMapping("getId/{id}")
    public Usuario getId(@PathVariable int id){
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
        Optional<Usuario> usuario1= Optional.of(usuario);
        if (usuario1.isPresent()) {
            usuarioService.save(usuario);
        }
        return usuario1.get();
    }
    @DeleteMapping("deleteId/{id}")
    public void delete(@PathVariable int id) throws Exception {
        usuarioService.delete(id);
    }

}
