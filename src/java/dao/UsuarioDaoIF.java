/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface UsuarioDaoIF {
    
    public void adicionar(Usuario usuario);
    
    public void remover(String cpf);
    
    public Usuario autenticar(String email, String senha);
    
    public List<Usuario> listar();
    
}
