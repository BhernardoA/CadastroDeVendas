/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

public class Vendas {
   
    public int data;
    public String material;
    public double quantidade;
    public double preco;
    
    public Vendas() {
    }
    
    public Vendas(int data, String material, double quantidade, double preco) {
        
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
 
}
