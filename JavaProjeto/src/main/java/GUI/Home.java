/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author admin
 */

import Controle.ClienteControle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    public Home() {
        // Configurações da janela
        setTitle("Home");
        setSize(700, 500); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); 

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.decode("#1C1C1C")); 

        // Título
        JLabel titleLabel = new JLabel("Reciclagem L.M. Fernandes LTDA", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 26)); 
        titleLabel.setForeground(Color.decode("#F1C40F")); 
        panel.add(titleLabel, createGbc(0, 0, 1, 0)); 

        
        panel.add(Box.createRigidArea(new Dimension(0, 20)), createGbc(0, 1, 1, 0));

        
        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        styleButton(btnCadastrarCliente);
        btnCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClienteApp(); 
                dispose(); 
            }
        });
        panel.add(btnCadastrarCliente, createGbc(0, 2, 1, 0)); 

        
        panel.add(Box.createRigidArea(new Dimension(0, 10)), createGbc(0, 3, 1, 0));

        
        JButton btnCadastrarVenda = new JButton("Cadastrar Venda");
        styleButton(btnCadastrarVenda);
        btnCadastrarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                VendaApp vendaApp = new VendaApp(new ClienteControle()); 
                vendaApp.setVisible(true); 
                dispose(); 
            }
        });
        panel.add(btnCadastrarVenda, createGbc(0, 4, 1, 0)); 

        
        add(panel);
        setVisible(true); 
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.decode("#34495E")); 
        button.setForeground(Color.WHITE); 
        button.setFont(new Font("Arial", Font.BOLD, 16)); 
        button.setBorder(BorderFactory.createLineBorder(Color.decode("#2C3E50"), 2)); 
        button.setPreferredSize(new Dimension(200, 40)); 
        button.setFocusPainted(false); 
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
    }

    private GridBagConstraints createGbc(int gridx, int gridy, int weightx, int weighty) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); 
        return gbc;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home());
    }
}

