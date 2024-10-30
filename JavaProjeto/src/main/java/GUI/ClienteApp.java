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
import Classes.Cliente;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;

public class ClienteApp extends JFrame {
    private final ClienteControle clienteControle;
    private JTextField nomeField, emailField, pesquisaField;
    private JFormattedTextField cpfField, telefoneField;
    private JTable clienteTable;
    private DefaultTableModel tableModel;

    public ClienteApp() {
        clienteControle = new ClienteControle(); // Inicializa o controle de clientes
        initComponents(); // Chama o método para inicializar os componentes da interface
    }

    private void initComponents() {
        setTitle("Gerenciamento de Clientes");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de Entrada
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        inputPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        nomeField.setFont(new Font("Verdana", Font.PLAIN, 12));
        inputPanel.add(nomeField);

        inputPanel.add(new JLabel("CPF:"));
        cpfField = createCpfField(); // Cria o campo formatado para CPF
        cpfField.setFont(new Font("Verdana", Font.PLAIN, 12));
        inputPanel.add(cpfField);

        inputPanel.add(new JLabel("Telefone:"));
        telefoneField = createTelefoneField(); // Cria o campo formatado para Telefone
        telefoneField.setFont(new Font("Verdana", Font.PLAIN, 12));
        inputPanel.add(telefoneField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        emailField.setFont(new Font("Verdana", Font.PLAIN, 12));
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Pesquisar por Nome:"));
        pesquisaField = new JTextField();
        pesquisaField.setFont(new Font("Verdana", Font.PLAIN, 12));
        inputPanel.add(pesquisaField);

        add(inputPanel, BorderLayout.NORTH); // Adiciona o painel de entrada ao topo

        // Painel de Botões
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Cria os botões e adiciona os listeners
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(new HomeActionListener());
        buttonPanel.add(homeButton);

        JButton cadastrarButton = new JButton("Cadastrar Cliente");
        cadastrarButton.addActionListener(new CadastrarActionListener());
        buttonPanel.add(cadastrarButton);

        JButton editarButton = new JButton("Editar Cliente");
        editarButton.addActionListener(new EditarActionListener());
        buttonPanel.add(editarButton);

        JButton removerButton = new JButton("Remover Cliente");
        removerButton.addActionListener(new RemoverActionListener());
        buttonPanel.add(removerButton);

        JButton listarButton = new JButton("Listar Clientes");
        listarButton.addActionListener(new ListarActionListener());
        buttonPanel.add(listarButton);

        JButton pesquisarButton = new JButton("Pesquisar");
        pesquisarButton.addActionListener(new PesquisarActionListener());
        buttonPanel.add(pesquisarButton);

        add(buttonPanel, BorderLayout.CENTER); // Adiciona o painel de botões ao centro

        // Tabela para exibir os clientes
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "CPF", "Telefone", "Email"}, 0);
        clienteTable = new JTable(tableModel);
        clienteTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        clienteTable.addMouseListener(new ClienteTableMouseListener());

        JScrollPane scrollPane = new JScrollPane(clienteTable);
        add(scrollPane, BorderLayout.SOUTH); // Adiciona a tabela ao fundo

        setVisible(true); // Torna a tela visível
    }

    private JFormattedTextField createCpfField() {
        try {
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.setPlaceholderCharacter('_');
            return new JFormattedTextField(cpfMask);
        } catch (ParseException e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }

    private JFormattedTextField createTelefoneField() {
        try {
            MaskFormatter telefoneMask = new MaskFormatter("(##) #####-####");
            telefoneMask.setPlaceholderCharacter('_');
            return new JFormattedTextField(telefoneMask);
        } catch (ParseException e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa a tabela antes de atualizar
        for (Cliente cliente : clienteControle.listarClientes()) {
            tableModel.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getEmail()});
        }
    }

    private class HomeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Home(); // Abre a tela inicial
            dispose(); // Fecha a tela de gerenciamento de clientes
        }
    }

    private class CadastrarActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText().trim();
            String cpf = cpfField.getText().trim();
            String telefone = telefoneField.getText().trim();
            String email = emailField.getText().trim();

            // Validações de campos obrigatórios
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(ClienteApp.this, "O Nome é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cpf.isEmpty() || cpf.contains("_")) {
                JOptionPane.showMessageDialog(ClienteApp.this, "O CPF é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean isTelefoneEmpty = telefone.isEmpty();
            boolean isEmailEmpty = email.isEmpty();

            if (isTelefoneEmpty && isEmailEmpty) {
                JOptionPane.showMessageDialog(ClienteApp.this, "Pelo menos um dos campos 'Telefone' ou 'Email' deve ser preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isTelefoneEmpty) {
                String telefoneNumeros = telefone.replaceAll("[^0-9]", "");
                if (telefoneNumeros.length() != 11) {
                    JOptionPane.showMessageDialog(ClienteApp.this, "O Telefone deve conter exatamente 11 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Cadastra o cliente e atualiza a tabela
            clienteControle.cadastrarCliente(nome, cpf, telefone, email);
            atualizarTabela();
            limparCampos();
        }
    }

    private class EditarActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = clienteTable.getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                String novoNome = nomeField.getText();
                String novoTelefone = telefoneField.getText();
                String novoEmail = emailField.getText();

                String cpfAtual = (String) tableModel.getValueAt(selectedRow, 2);
                if (!cpfAtual.equals(cpfField.getText().trim())) {
                    JOptionPane.showMessageDialog(ClienteApp.this, "A edição do CPF não é permitida. Apenas Nome, Telefone e Email podem ser alterados.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Cliente clienteSelecionado = clienteControle.buscarClientePorId(id);
                if (clienteSelecionado != null) {
                    clienteControle.editarCliente(clienteSelecionado, novoNome, novoTelefone, novoEmail);
                    atualizarTabela();
                    limparCampos();
                }
            } else {
                JOptionPane.showMessageDialog(ClienteApp.this, "Selecione um cliente na tabela para editar.");
            }
        }
    }

    private class RemoverActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = clienteTable.getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                clienteControle.removerClientePorId(id);
                atualizarTabela();
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(ClienteApp.this, "Selecione um cliente na tabela para remover.");
            }
        }
    }

    private class ListarActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            atualizarTabela(); // Atualiza a tabela para listar todos os clientes
        }
    }

    private class PesquisarActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nomePesquisa = pesquisaField.getText().trim();
            if (!nomePesquisa.isEmpty()) {
                tableModel.setRowCount(0); // Limpa a tabela antes de pesquisar
                for (Cliente cliente : clienteControle.pesquisarClientesPorNome(nomePesquisa)) {
                    tableModel.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getEmail()});
                }
            }
        }
    }

    private class ClienteTableMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int selectedRow = clienteTable.getSelectedRow();
            if (selectedRow != -1) {
                nomeField.setText((String) tableModel.getValueAt(selectedRow, 1));
                cpfField.setText((String) tableModel.getValueAt(selectedRow, 2));
                telefoneField.setText((String) tableModel.getValueAt(selectedRow, 3));
                emailField.setText((String) tableModel.getValueAt(selectedRow, 4));
            }
        }
    }

    private void limparCampos() {
        nomeField.setText("");
        cpfField.setText("");
        telefoneField.setText("");
        emailField.setText("");
        pesquisaField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClienteApp::new); // Executa a aplicação na thread do Swing
    }
}

