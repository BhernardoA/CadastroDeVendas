/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author marco
 */

import entities.Cliente;
import entities.Venda;
import java.util.ArrayList;

public class Database {
    
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static ArrayList<Venda> listaVendas = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public static void adicionarVenda(Venda venda) {
        listaVendas.add(venda);
    }

    public static ArrayList<Cliente> getClientes() {
        return listaClientes;
    }

    public static ArrayList<Venda> getVendas() {
        return listaVendas;
    }
    
}
