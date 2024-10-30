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
        setSize(700, 500); // Tamanho aumentado
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.decode("#1C1C1C")); // Cor de fundo escura

        // Título
        JLabel titleLabel = new JLabel("Reciclagem L.M. Fernandes LTDA", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 26)); // Fonte diferenciada e escura
        titleLabel.setForeground(Color.decode("#F1C40F")); // Cor do texto dourada
        panel.add(titleLabel, createGbc(0, 0, 1, 0)); // Adiciona o título ao painel

        // Espaço entre o título e os botões
        panel.add(Box.createRigidArea(new Dimension(0, 20)), createGbc(0, 1, 1, 0));

        // Botão Cadastrar Cliente
        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        styleButton(btnCadastrarCliente);
        btnCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClienteApp(); // Abre a tela de cadastro de cliente
                dispose(); // Fecha a tela inicial
            }
        });
        panel.add(btnCadastrarCliente, createGbc(0, 2, 1, 0)); // Adiciona o botão ao painel

        // Espaço entre os botões
        panel.add(Box.createRigidArea(new Dimension(0, 10)), createGbc(0, 3, 1, 0));

        // Botão Cadastrar Venda
        JButton btnCadastrarVenda = new JButton("Cadastrar Venda");
        styleButton(btnCadastrarVenda);
        btnCadastrarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode abrir a tela de cadastro de vendas
                VendaApp vendaApp = new VendaApp(new ClienteControle()); // Adicione a instância de ClienteControle se necessário
                vendaApp.setVisible(true); // Torna a nova tela visível
                dispose(); // Fecha a tela inicial
            }
        });
        panel.add(btnCadastrarVenda, createGbc(0, 4, 1, 0)); // Adiciona o botão ao painel

        // Adiciona o painel principal à janela
        add(panel);
        setVisible(true); // Torna a janela visível
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.decode("#34495E")); // Cor de fundo escura
        button.setForeground(Color.WHITE); // Cor do texto
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Fonte do botão
        button.setBorder(BorderFactory.createLineBorder(Color.decode("#2C3E50"), 2)); // Borda do botão
        button.setPreferredSize(new Dimension(200, 40)); // Tamanho do botão
        button.setFocusPainted(false); // Remove o contorno quando clicado
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor de mão ao passar o mouse
    }

    private GridBagConstraints createGbc(int gridx, int gridy, int weightx, int weighty) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Margens
        return gbc;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home());
    }
}

