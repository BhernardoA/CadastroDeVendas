package Classes;

import Enums.Parcelas;
import Enums.Unidade;
import java.time.LocalDate;
import Enums.TipoPagamento;

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

    // Getter para id
    public int getId() {
        return id;
    }

    // Getter para idCliente
    public int getIdCliente() {
        return idCliente;
    }

    // Getter para dataVenda
    public LocalDate getDataVenda() { 
        return dataVenda; 
    }

    // Getter para material
    public String getMaterial() {
        return material;
    }

    // Getter para quantidade
    public int getQuantidade() {
        return quantidade;
    }

    // Getter para unidade
    public Unidade getUnidade() {
        return unidade;
    }

    // Getter para preco
    public double getPreco() {
        return preco;
    }

    // Getter para pagamento
    public TipoPagamento getPagamento() { 
        return pagamento; 
    }

    // Getter para parcelas
    public Parcelas getParcelas() {
        return parcelas;
    }

    // Método para obter o tipo de pagamento (retorna um TipoPagamento)
    public TipoPagamento getTipoPagamento() {
        return this.pagamento;
    }

    // Método para obter a data de venda (retorna LocalDate)
    public LocalDate getData() {
        return this.dataVenda;
    }
}
