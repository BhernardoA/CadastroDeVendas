/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

/**
 *
 * @author admin
 */
public enum Unidade {
    QUILOS("quilos"),
    TONELADAS("toneladas");

    private final String valor;

    Unidade(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
