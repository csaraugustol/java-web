/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author daves
 */
@Entity
@Table(catalog = "pooa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Jogador.findAll", query = "SELECT j FROM Jogador j"),
    @NamedQuery(name = "Jogador.findByIdJogador", query = "SELECT j FROM Jogador j WHERE j.idJogador = :idJogador"),
    @NamedQuery(name = "Jogador.findByNome", query = "SELECT j FROM Jogador j WHERE j.nome = :nome"),
    @NamedQuery(name = "Jogador.findByNumeroGols", query = "SELECT j FROM Jogador j WHERE j.numeroGols = :numeroGols")})
public class Jogador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idJogador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_gols", nullable = false)
    private int numeroGols;
    @JoinColumn(name = "time", referencedColumnName = "idtime", nullable = false)
    @ManyToOne(optional = false)
    private Time time;

    public Jogador() {
    }

    public Jogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public Jogador(Integer idJogador, String nome, int numeroGols) {
        this.idJogador = idJogador;
        this.nome = nome;
        this.numeroGols = numeroGols;
    }

    public Jogador(Integer idJogador, String nome, int numeroGols, Time time) {
        this.idJogador = idJogador;
        this.nome = nome;
        this.numeroGols = numeroGols;
        this.time = time;
    }
    
    

    public Integer getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroGols() {
        return numeroGols;
    }

    public void setNumeroGols(int numeroGols) {
        this.numeroGols = numeroGols;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJogador != null ? idJogador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogador)) {
            return false;
        }
        Jogador other = (Jogador) object;
        if ((this.idJogador == null && other.idJogador != null) || (this.idJogador != null && !this.idJogador.equals(other.idJogador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.vianna.aula.matadorweb.model.Jogador[ idJogador=" + idJogador + " ]";
    }
    
}
