/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.DTO;

import br.vianna.aula.jsf.model.ENUM.ETipoUsuario;

/**
 *
 * @author cesar
 */
public class UsuarioLogDTO {
    
    private int id;
   
    private ETipoUsuario tipoUsuario;

    private String nome, email;

    public UsuarioLogDTO() {
    }

    public UsuarioLogDTO(int id, ETipoUsuario tipoUsuario, String nome, String email) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ETipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(ETipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
