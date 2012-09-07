package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Usuario;


public interface UsuarioService {
    public List<Usuario> findAll();

    public void save(Usuario usuario);

    public void remove(int id);

    public Usuario find(int id);
    
    public Usuario login(String usuario, String password);
    
    
}
