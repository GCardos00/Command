/*
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para alterar esta licença
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este modelo
 */
package com.mycompany.command;

import com.mycompany.editor.Editor;

/**
 * Classe que representa o comando de "Copiar" em um editor de texto.
 * Este comando copia o texto selecionado no campo de texto do editor para o clipboard.
 */
public class CopyCommand extends Command {

    /**
     * Construtor da classe CopyCommand.
     * Inicializa o comando de copiar com o editor fornecido.
     * 
     * @param editor O editor sobre o qual o comando irá operar.
     */
    public CopyCommand(Editor editor) {
        super(editor); // Chama o construtor da classe base Command, passando o editor
    }

    /**
     * Executa a ação de copiar o texto selecionado no editor para o clipboard.
     * 
     * @return false, pois não há necessidade de uma operação de "desfazer" para este comando.
     */
    @Override
    public boolean execute() {
        // Copia o texto selecionado no campo de texto do editor para o clipboard
        editor.clipboard = editor.textField.getSelectedText();
        
        // Retorna false indicando que não há necessidade de desfazer esta ação
        return false;
    }
}
