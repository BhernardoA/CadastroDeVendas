/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

public class Vendas {
    
    private int data;
    private int material;
    private int quantidade;
    private int preco;
    
    public Vendas() {
    }
    
    public Vendas(int data, int material, int quantidade, int preco) {
        
        this.data = data;
        this.material = material;
        this.quantidade = quantidade;
        this.preco = preco;
        
        }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
    
 
}
