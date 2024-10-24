/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author marco
 */
public class Pessoa extends Cadastro {
    
    private String nome;
    private String email;
    private String celular;
    private String cpf;
    
        
    public Pessoa(String nome, String email, String celular, String cpf, String dataCadastro) {
        super(dataCadastro); 
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        
    }

   
    
    @Override
    public void salvar() {
        
        System.out.println("Salvando cliente: " + nome);
       
    }
    
    
    public String getNome() { return nome; 
    }
    
    public void setNome(String nome) { this.nome = nome; 
    }

    public String getEmail() { return email; 
    }
    
    public void setEmail(String email) { this.email = email; 
    }

    public String getCelular() { return celular; 
    }
    
    public void setCelular(String celular) { this.celular = celular; 
    }

    public String getCpf() { return cpf; 
    }
    
    public void setCpf(String cpf) { this.cpf = cpf; 
    }
    
}
