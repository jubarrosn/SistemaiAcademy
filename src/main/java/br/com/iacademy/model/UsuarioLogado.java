/*package br.com.iacademy.model;

import java.io.Serializable;

import javax.inject.Named;

@Named
//@SessionScoped
public class UsuarioLogado implements Serializable {

    private Usuario usuario; // dados do usuário

    public void loga(Usuario usuario) {
        this.usuario = usuario;
        // poderia notificar outros sistemas sobre o login
    }

    public void desloga() {
        this.usuario = null;
        // poderia notificar outros sistemas sobre o logout
    }

    public boolean isLogado() {
        return this.usuario != null;
    }

    public boolean isAdmin() {
        return this.usuarios.pertenceAoGrupo("ADMIN");
    }
    
    // getter e setter
}*/