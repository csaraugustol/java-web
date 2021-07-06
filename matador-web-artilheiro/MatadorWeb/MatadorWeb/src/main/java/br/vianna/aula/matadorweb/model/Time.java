/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author daves 
 */
@Entity
@Table(catalog = "pooa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Time.findAll", query = "SELECT t FROM Time t"),
    @NamedQuery(name = "Time.findByIdtime", query = "SELECT t FROM Time t WHERE t.idtime = :idtime"),
    @NamedQuery(name = "Time.findByNome", query = "SELECT t FROM Time t WHERE t.nome = :nome"),
    @NamedQuery(name = "Time.findByDataFundacao", query = "SELECT t FROM Time t WHERE t.dataFundacao = :dataFundacao")})
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idtime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_fundacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataFundacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "time")
    private List<Jogador> jogadorList;
   
    @JoinColumn(name = "usuario", referencedColumnName = "idusuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Time() {
    }

    public Time(Integer idtime) {
        this.idtime = idtime;
    }

    public Time(Integer idtime, String nome, Date dataFundacao) {
        this.idtime = idtime;
        this.nome = nome;
        this.dataFundacao = dataFundacao;
    }

    public Time(Integer idtime, String nome, Date dataFundacao, Usuario usuario) {
        this.idtime = idtime;
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.usuario = usuario;
    }
    
    public String dataAmericana(){
    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        return sdf.format(dataFundacao);
        
    }
    

    public Integer getIdtime() {
        return idtime;
    }

    public void setIdtime(Integer idtime) {
        this.idtime = idtime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public List<Jogador> getJogadorList() {
        return jogadorList;
    }

    public void setJogadorList(List<Jogador> jogadorList) {
        this.jogadorList = jogadorList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtime != null ? idtime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Time)) {
            return false;
        }
        Time other = (Time) object;
        if ((this.idtime == null && other.idtime != null) || (this.idtime != null && !this.idtime.equals(other.idtime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.vianna.aula.matadorweb.model.Time[ idtime=" + idtime + " ]";
    }
    
}
