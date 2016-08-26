
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Edilva
 */
public class Usuario implements Comparable<Usuario>, Serializable{
    private String cpf;
    private String nome;
    private String rg;
    private LocalDate dataNasc;
    private String email;
    private TipoUsuario tipo;
    private String senha;
    private Endereco endereco;
    private List<String> telefones = new ArrayList<>();
    private String foto;

    public Usuario(String cpf, String nome, String rg, LocalDate dataNasc, String email, TipoUsuario tipo, String senha, Endereco endereco, List<String> telefones, String foto) {
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.email = email;
        this.tipo = tipo;
        this.senha = senha;
        this.endereco = endereco;
        this.telefones = telefones;
        this.foto = foto;
    }

    public Usuario() {
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the dataNasc
     */
    public LocalDate getDataNasc() {
        return dataNasc;
    }

    /**
     * @param dataNasc the dataNasc to set
     */
    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tipo
     */
    public TipoUsuario getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefones
     */
    public List<String> getTelefones() {
        return telefones;
    }
    
    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.cpf);
        hash = 41 * hash + Objects.hashCode(this.rg);
        hash = 41 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Usuario o) {
        return this.getEmail().compareTo(o.getEmail());
    }

    @Override
    public String toString() {
        return "Usuario{" + "cpf=" + cpf + ", nome=" + nome + ", rg=" + rg + ", dataNasc=" + dataNasc + ", email=" + email + ", tipo=" + tipo + ", senha=" + senha + ", endereco=" + endereco + ", telefones=" + telefones + ", foto=" + foto + '}';
    }
   
}
