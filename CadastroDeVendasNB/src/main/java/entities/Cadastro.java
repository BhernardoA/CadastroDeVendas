/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author marco
 */
public abstract class Cadastro {
    
    protected String dataCadastro;
   
    
public Cadastro(String dataCadastro) {

        this.dataCadastro = dataCadastro;
    }
    
    public abstract void salvar();

    public void salvar(Cadastro cadastro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
