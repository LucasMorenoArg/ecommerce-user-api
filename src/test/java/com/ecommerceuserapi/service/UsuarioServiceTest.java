package com.ecommerceuserapi.service;

import com.ecommerceuserapi.entities.Usuario;
import com.ecommerceuserapi.repository.UsuarioRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepo usuarioRepo;
    @InjectMocks
    private UsuarioService usuarioService;
    private final Usuario usuario = new Usuario();


        @Test
        void getAllMethod () {

            List<Usuario> lista = new ArrayList<>();
            lista.add(usuario);
            when(usuarioRepo.findAll()).thenReturn(lista);
            assertNotNull(usuarioService.getAll());
        }

        @Test
        void byId () {
            Integer id = 1;
            when(usuarioRepo.findById(id)).thenReturn(Optional.of(usuario));
            Usuario usuario1 = usuarioService.byId(id).get();
            assertEquals(usuario, usuario1);
        }

        @Test
        void create(){


        }
}