
package entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author Edilva
 */
public class MovimentacaoFinanceira {
    private int id;
    private LocalDate data;
    private LocalTime hora;
    private TipoMovimentacao tipo;
    private double valor;
    private Conta conta;
    private Usuario titular;

    public MovimentacaoFinanceira(LocalDate data, LocalTime hora, TipoMovimentacao tipo, double valor, Conta conta, Usuario titular) {
        this.data = data;
        this.hora = hora;
        this.tipo = tipo;
        this.valor = valor;
        this.conta = conta;
        this.titular = titular;
    }

    public MovimentacaoFinanceira() {
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
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.data);
        hash = 73 * hash + Objects.hashCode(this.hora);
        hash = 73 * hash + Objects.hashCode(this.tipo);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 73 * hash + Objects.hashCode(this.conta);
        hash = 73 * hash + Objects.hashCode(this.titular);
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
        final MovimentacaoFinanceira other = (MovimentacaoFinanceira) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.conta, other.conta)) {
            return false;
        }
        if (!Objects.equals(this.titular, other.titular)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MovimentacaoFinanceira{" + "id=" + id + ", data=" + data + ", hora=" + hora + ", tipo=" + tipo + ", valor=" + valor + ", conta=" + conta + ", titular=" + titular + '}';
    }
    
}
