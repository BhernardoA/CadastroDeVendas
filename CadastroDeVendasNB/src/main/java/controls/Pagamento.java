/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author marco
 */
public abstract class Pagamento {

    // atributo
    protected double valor;

    // construtor
    public Pagamento(double valor) {
        this.valor = valor;
    }

    // metodo getter
    public double getValor() {
        return valor;
    }

    // metodo abstrato
    public abstract String tipoPagamento();
}
    
}
