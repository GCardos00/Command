/*
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para alterar esta licença
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este modelo
 */
package com.mycompany.command;

import java.util.Stack;

/**
 * Classe que gerencia o histórico de comandos realizados, permitindo realizar operações
 * de desfazer (undo). Ela armazena os comandos executados em uma pilha e permite acessar
 * o último comando realizado para desfazê-lo.
 */
public class CommandHistory {
    
    // A pilha que armazena os comandos realizados, permitindo o acesso ao comando mais recente.
    private Stack<Command> history = new Stack<>();

    /**
     * Adiciona um comando ao histórico.
     * Este método é chamado para registrar os comandos à medida que são executados.
     * 
     * @param c O comando a ser adicionado ao histórico.
     */
    public void push(Command c) {
        history.push(c); // Adiciona o comando à pilha
    }

    /**
     * Remove e retorna o último comando executado, permitindo desfazê-lo.
     * 
     * @return O comando mais recente adicionado ao histórico, ou null se a pilha estiver vazia.
     */
    public Command pop() {
        return history.pop(); // Remove e retorna o comando mais recente
    }

    /**
     * Verifica se o histórico está vazio.
     * 
     * @return true se a pilha de históricos estiver vazia, ou false caso contrário.
     */
    public boolean isEmpty() {
        return history.isEmpty(); // Retorna verdadeiro se a pilha estiver vazia
    }
}
