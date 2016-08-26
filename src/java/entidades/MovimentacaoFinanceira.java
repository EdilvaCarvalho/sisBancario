
package entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Edilva
 */
public class MovimentacaoFinanceira {
    private int id;
    private LocalDate data;
    private LocalTime hora;
    private TipoMovimentacao tipo;
    private BigDecimal valor;
    private Conta conta;
    private Usuario titular;

    public MovimentacaoFinanceira(int id, LocalDate data, LocalTime hora, TipoMovimentacao tipo, BigDecimal valor, Conta conta, Usuario titular) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.tipo = tipo;
        this.valor = valor;
        this.conta = conta;
        this.titular = titular;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the data
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * @return the hora
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * @return the tipo
     */
    public TipoMovimentacao getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * @return the titular
     */
    public Usuario getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(Usuario titular) {
        this.titular = titular;
    }

    /**
     * @return the conta
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    
}
