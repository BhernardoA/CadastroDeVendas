/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author marco
 */


public class Venda extends Cadastro {
    
    private int idCliente;
    private String dataVenda;
    private String pagamento;
    private int parcelas;
    private String material;
    private int quantidade;
    private String unidade;
    private double preco;

    public Venda(int idCliente, String dataVenda, String pagamento, int parcelas, String material, int quantidade, String unidade, double preco, String dataCadastro) {
        super(dataCadastro);
        this.idCliente = idCliente;
        this.dataVenda = dataVenda;
        this.pagamento = pagamento;
        this.parcelas = parcelas;
        this.material = material;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.preco = preco;
    }
    
    @Override
    public void salvar() {
       
        System.out.println("Salvando venda para o cliente ID: " + idCliente);
    }

    
    public int getIdCliente() { return idCliente; 
    }
    
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; 
    }

    public String getDataVenda() { return dataVenda; 
    }
    
    public void setDataVenda(String dataVenda) { this.dataVenda = dataVenda; 
    }

    public String getPagamento() { return pagamento; 
    }
    
    public void setPagamento(String pagamento) { this.pagamento = pagamento; 
    }

    public int getParcelas() { return parcelas; 
    }
    
    public void setParcelas(int parcelas) { this.parcelas = parcelas; 
    }

    public String getMaterial() { return material; 
    }
    
    public void setMaterial(String material) { this.material = material; 
    }

    public int getQuantidade() { return quantidade; 
    }
    
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; 
    }

    public String getUnidade() { return unidade; 
    }
    
    public void setUnidade(String unidade) { this.unidade = unidade; 
    }

    public double getPreco() { return preco; 
    }
    
    public void setPreco(double preco) { this.preco = preco; 
    }
    
}
