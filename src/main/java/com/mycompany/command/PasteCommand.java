/*
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para alterar esta licença
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este modelo
 */
package com.mycompany.command;

import com.mycompany.editor.Editor;

/**
 * Comando que representa a ação de colar o conteúdo do clipboard
 * no editor de texto, na posição do cursor (caret).
 */
public class PasteCommand extends Command {

    /**
     * Construtor que inicializa o comando de colar com o editor fornecido.
     * 
     * @param editor O editor onde a ação de colar será executada.
     */
    public PasteCommand(Editor editor) {
        super(editor); // Chama o construtor da classe base Command passando o editor
    }

    /**
     * Executa a ação de colar o conteúdo do clipboard na posição atual do cursor.
     * Antes de colar, faz um backup do texto atual para permitir um possível "undo".
     * 
     * @return true se a operação de colar foi bem-sucedida, ou false se o clipboard estiver vazio ou nulo.
     */
    @Override
    public boolean execute() {
        // Verifica se o clipboard está vazio ou nulo. Se estiver, retorna false.
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return false;

        // Faz o backup do texto atual no editor antes de realizar a operação de colar.
        backup();
        
        // Insere o conteúdo do clipboard na posição atual do cursor no campo de texto do editor.
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        
        // Retorna true indicando que o comando foi executado com sucesso.
        return true;
    }
}
