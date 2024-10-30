/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

/**
 *
 * @author admin
 */
public enum TipoPagamento {
    DINHEIRO("dinheiro"),
    CARTAO("cartao"),
    TRANSFERENCIA("transferencia");

    private final String valor;

    TipoPagamento(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
        
    }

    public static TipoPagamento getDINHEIRO() {
        return DINHEIRO;
    }

    public static TipoPagamento getCARTAO() {
        return CARTAO;
    }

    public static TipoPagamento getTRANSFERENCIA() {
        return TRANSFERENCIA;
    }
} 
