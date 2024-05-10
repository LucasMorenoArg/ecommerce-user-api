package com.ecommerceuserapi.service;

import com.ecommerceuserapi.entities.Usuario;
import com.ecommerceuserapi.repository.UsuarioRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepo repoUsuario;
    @InjectMocks
    private UsuarioService serviceUsuario;
    private final Usuario actual = new Usuario();
    private Usuario esperado;
    private final Integer id= 1;


        @Test
        void getAllMethod () {

            List<Usuario> lista = new ArrayList<>();
            when(repoUsuario.findAll()).thenReturn(lista);
            assertNotNull(serviceUsuario.getAll());
        }

        @Test
        void byId () {
            Integer id = 1;
            when(repoUsuario.findById(id)).thenReturn(Optional.of(actual));
            esperado = serviceUsuario.byId(id).get();
            assertEquals(esperado, actual);
        }

        //     Esperado = Repository    ////  Resultado = Service.
        @Test
        void create(){
            //Usuario usuario1 = new Usuario();
            when(repoUsuario.save(actual)).thenReturn(actual);
            esperado = serviceUsuario.save(actual);
            assertEquals(esperado, actual);
            verify(repoUsuario).save(actual);
        }

        @Test
        void delete()  {

            when(repoUsuario.existsById(id)).thenReturn(true);
            assertTrue(serviceUsuario.delete(id));

        }

}