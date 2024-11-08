/*
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para alterar esta licença
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este modelo
 */
package com.mycompany.command;

import com.mycompany.editor.Editor;

/**
 * Comando que representa a ação de cortar (remover e copiar para o clipboard)
 * o texto selecionado no editor de texto.
 */
public class CutCommand extends Command {

    /**
     * Construtor que inicializa o comando de cortar com o editor fornecido.
     * 
     * @param editor O editor onde a ação de cortar será executada.
     */
    public CutCommand(Editor editor) {
        super(editor); // Chama o construtor da classe base Command passando o editor
    }

    /**
     * Executa a ação de cortar (remover e copiar para o clipboard) o texto selecionado.
     * Antes de cortar, faz um backup do texto atual para permitir um possível "undo".
     * 
     * @return true se a operação de cortar foi bem-sucedida, ou false se nenhum texto foi selecionado.
     */
    @Override
    public boolean execute() {
        // Verifica se o texto selecionado não está vazio. Se estiver, retorna false.
        if (editor.textField.getSelectedText().isEmpty()) return false;

        // Faz o backup do texto atual no editor antes de realizar a operação de cortar.
        backup();

        // Armazena o texto selecionado no clipboard (área de transferência).
        String source = editor.textField.getText();
        editor.clipboard = editor.textField.getSelectedText();
        
        // Modifica o texto no campo de texto, removendo a seleção cortada.
        editor.textField.setText(cutString(source));

        // Retorna true indicando que a operação foi bem-sucedida.
        return true;
    }

    /**
     * Método auxiliar que realiza a operação de cortar o texto da seleção.
     * Remove o texto selecionado, mantendo o texto antes e depois da seleção.
     * 
     * @param source O texto original do editor.
     * @return O novo texto, com a seleção cortada.
     */
    private String cutString(String source) {
        // Extrai a parte do texto antes da seleção
        String start = source.substring(0, editor.textField.getSelectionStart());
        
        // Extrai a parte do texto depois da seleção
        String end = source.substring(editor.textField.getSelectionEnd());
        
        // Retorna o texto com a seleção cortada (a parte selecionada é removida)
        return start + end;
    }
}
