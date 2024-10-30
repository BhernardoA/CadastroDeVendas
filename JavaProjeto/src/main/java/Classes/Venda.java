package Classes;

import Enums.Parcelas;
import Enums.Unidade;
import java.time.LocalDate;
import Enums.TipoPagamento;
import java.util.Date;

public class Venda {
    private final int id;
    private final int idCliente;
    private final LocalDate dataVenda; 
    private final String material;
    private final int quantidade;
    private final Unidade unidade;
    private final double preco;
    private final TipoPagamento pagamento; 
    private final Parcelas parcelas;

    // Construtor principal
    public Venda(int id, int idCliente, LocalDate dataVenda, String material, int quantidade, Unidade unidade, double preco, TipoPagamento pagamento, Parcelas parcelas) {
        this.id = id;
        this.idCliente = idCliente;
        this.dataVenda = dataVenda; 
        this.material = material;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.preco = preco;
        this.pagamento = pagamento; 
        this.parcelas = parcelas;
    }

    public Venda(int i, int idCliente, Date dataVenda, String material, int quantidade, Unidade unidade, double preco, TipoPagamento pagamento, Parcelas parcelas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public LocalDate getDataVenda() { 
        return dataVenda; 
    }

    public String getMaterial() {
        return material;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public double getPreco() {
        return preco;
    }

    public TipoPagamento getPagamento() { 
        return pagamento; 
    }

    public Parcelas getParcelas() {
        return parcelas;
    }

    public Object getTipoPagamento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
