
package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class Agencia {
    private String numero;
    private String nome;
    private Endereco endereco;
    private List<String> telefones;
    private List<Usuario> gerentes;

    public Agencia(String numero, String nome, Endereco endereco, List<String> telefones) {
        this.numero = numero;
        this.nome = nome;
        this.endereco = endereco;
        this.telefones = new ArrayList<>();
        this.gerentes = new ArrayList<>();
    }

    public Agencia() {
    }

    
    
    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
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
     * @param telefones the telefones to set
     */
    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    /**
     * @return the gerentes
     */
    public List<Usuario> getGerentes() {
        return gerentes;
    }

    /**
     * @param gerentes the gerentes to set
     */
    public void setGerentes(List<Usuario> gerentes) {
        this.gerentes = gerentes;
    }
    
}
