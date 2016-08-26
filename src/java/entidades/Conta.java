
package entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class Conta {
    private String numero;
    private LocalDate dataAbertura;
    private double saldo;
    private Agencia agencia;
    private List<Usuario> titulares;

    public Conta(String numero, LocalDate dataAbertura, double saldo, Agencia agencia, List<Usuario> titulares) {
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.saldo = saldo;
        this.agencia = agencia;
        this.titulares = titulares;
    }
    
    public Conta(String numero, LocalDate dataAbertura, double saldo) {
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.saldo = saldo;
    }

    public Conta() {
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
     * @return the dataAbertura
     */
    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    /**
     * @param dataAbertura the dataAbertura to set
     */
    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the agencia
     */
    public Agencia getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the titulares
     */
    public List<Usuario> getTitulares() {
        return titulares;
    }

    /**
     * @param titulares the titulares to set
     */
    public void setTitulares(List<Usuario> titulares) {
        this.titulares = titulares;
    }
    
    
}
