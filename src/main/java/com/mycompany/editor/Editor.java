/*
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para alterar esta licença
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este modelo
 */
package com.mycompany.editor;

import com.mycompany.command.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que representa um editor de texto simples, com funcionalidades de copiar, cortar, colar e desfazer (undo).
 * Ela usa a interface gráfica Swing para criar a interface do editor e gerenciar eventos de botões.
 */
public class Editor {
    
    // O campo de texto onde o usuário digita.
    public JTextArea textField;
    
    // A área de transferência (clipboard), usada para armazenar o texto copiado ou cortado.
    public String clipboard;
    
    // Histórico de comandos realizados no editor, utilizado para implementar o undo.
    private CommandHistory history = new CommandHistory();

    /**
     * Método de inicialização do editor.
     * Aqui são configurados os componentes da interface gráfica e os listeners dos botões.
     */
    public void init() {
        // Criação da janela principal do editor com título.
        JFrame frame = new JFrame("Text editor (type & use buttons, Luke!)");
        
        // Painel principal que vai conter todos os componentes.
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // Layout vertical para o conteúdo (o campo de texto e os botões).
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        // Campo de texto onde o usuário pode digitar.
        textField = new JTextArea();
        textField.setLineWrap(true);  // Habilita a quebra automática de linha.
        
        // Adiciona o campo de texto ao painel principal.
        content.add(textField);
        
        // Painel para os botões.
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        // Botões para os comandos de copiar, cortar, colar e desfazer.
        JButton ctrlC = new JButton("Ctrl+C");
        JButton ctrlX = new JButton("Ctrl+X");
        JButton ctrlV = new JButton("Ctrl+V");
        JButton ctrlZ = new JButton("Ctrl+Z");
        
        // "Editor" refere-se ao objeto atual da classe Editor.
        Editor editor = this;

        // Ação do botão Ctrl+C (Copiar)
        ctrlC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CopyCommand(editor));  // Executa o comando de copiar.
            }
        });
        
        // Ação do botão Ctrl+X (Cortar)
        ctrlX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CutCommand(editor));  // Executa o comando de cortar.
            }
        });
        
        // Ação do botão Ctrl+V (Colar)
        ctrlV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new PasteCommand(editor));  // Executa o comando de colar.
            }
        });
        
        // Ação do botão Ctrl+Z (Desfazer)
        ctrlZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undo();  // Executa o comando de desfazer (undo).
            }
        });
        
        // Adiciona os botões ao painel de botões.
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        
        // Adiciona o painel de botões ao painel principal.
        content.add(buttons);
        
        // Configura o tamanho da janela e a exibe no centro da tela.
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Método para executar um comando e adicionar ao histórico, caso a execução seja bem-sucedida.
     * 
     * @param command O comando a ser executado.
     */
    private void executeCommand(Command command) {
        if (command.execute()) {  // Executa o comando, se bem-sucedido
            history.push(command);  // Adiciona o comando ao histórico
        }
    }

    /**
     * Método para desfazer a última ação executada.
     * Ele utiliza o histórico de comandos e chama o método de undo do comando mais recente.
     */
    private void undo() {
        if (history.isEmpty()) return;  // Se não houver comandos no histórico, não faz nada.

        Command command = history.pop();  // Remove o último comando do histórico
        if (command != null) {
            command.undo();  // Executa o undo do comando removido
        }
    }
}
