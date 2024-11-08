/*
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para alterar esta licença
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este modelo
 */
package com.mycompany.command;

import com.mycompany.editor.Editor;

/**
 * Classe abstrata que representa um comando no editor de texto.
 * Esta classe serve como base para outros comandos (como copiar, colar, desfazer, etc.)
 * e define a estrutura básica para as operações que podem ser executadas.
 */
public abstract class Command {

    // Referência ao editor no qual o comando será executado
    public Editor editor;

    // Variável que armazena o estado do texto antes de uma operação (para permitir o "undo")
    private String backup;

    /**
     * Construtor que inicializa o comando com o editor em que ele irá operar.
     * 
     * @param editor O editor sobre o qual o comando irá agir.
     */
    Command(Editor editor) {
        this.editor = editor; // Armazena a referência do editor passado como parâmetro
    }

    /**
     * Faz o backup do texto atual no campo de texto do editor.
     * Este método é utilizado para armazenar o estado do texto antes de realizar uma operação,
     * permitindo que a operação seja desfeita posteriormente.
     */
    void backup() {
        backup = editor.textField.getText(); // Armazena o texto atual no backup
    }

    /**
     * Desfaz a última operação realizada, restaurando o texto para o estado armazenado no backup.
     * Este método pode ser chamado quando a operação precisar ser desfeita (por exemplo, um "undo").
     */
    public void undo() {
        editor.textField.setText(backup); // Restaura o texto a partir do backup
    }

    /**
     * Método abstrato que deve ser implementado pelas subclasses para realizar a ação do comando.
     * Cada comando específico (como CopyCommand, PasteCommand, etc.) implementará a lógica própria
     * para a execução do comando.
     * 
     * @return Retorna um valor booleano, que pode indicar o sucesso ou falha da execução do comando.
     */
    public abstract boolean execute();
}
