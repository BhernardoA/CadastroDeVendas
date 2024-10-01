/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Vendas {
    
    // atributos
    private Cliente cliente;
    private LocalDate data;
    private String material;
    private double quantidade;
    private String unidade; // Quilos ou Toneladas
    private double preco;
    private Pagamento pagamento;

    //construtores
    public Vendas(){
        
    }
    
    public Vendas(Cliente cliente, LocalDate data, String material, double quantidade, String unidade, double preco, Pagamento pagamento) {
        this.cliente = cliente;
        this.data = data;
        this.material = material;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.preco = preco;
        this.pagamento = pagamento;
        
    }
    
    // metodos getters e setters    
        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public LocalDate getData() {
            return data;
        }

        public void setData(LocalDate data) {
            this.data = data;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public double getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(double quantidade) {
            this.quantidade = quantidade;
        }

        public String getUnidade() {
            return unidade;
        }

        public void setUnidade(String unidade) {
            this.unidade = unidade;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        public Pagamento getPagamento() {
            return pagamento;
        }

        public void setPagamento(Pagamento pagamento) {
            this.pagamento = pagamento;
        }
}