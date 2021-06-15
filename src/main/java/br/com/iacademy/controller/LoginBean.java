/*package br.com.iacademy.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.glassfish.jersey.process.internal.RequestScoped;

import br.com.iacademy.model.UsuarioLogado;

@Named
@RequestScoped // controller em escopo de request
public class LoginBean {

    // outros atributos

    @Inject
    private UsuarioLogado usuarioLogado;

    public String logar() {
        Usuario usuario = autenticador.autentica(login, senha);
        if (usuario != null) {
            this.usuarioLogado.setUsuario(usuario); // preenche usuário na sessão
            return "/pages/home?faces-redirect=true";
        }
        facesUtils.erro("Login ou senha inválido.");
        return null;
    }
}*/