/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.command;

// CommandHistory.java
import java.util.Stack;

public class CommandHistory {
    private Stack<Command> history = new Stack<>();  // Pilha para armazenar os comandos executados

    // Método para adicionar um comando ao histórico
    public void push(Command command) {
        history.push(command);
    }

    // Método para remover o último comando do histórico
    public Command pop() {
        return history.isEmpty() ? null : history.pop();
    }

    // Método para verificar se o histórico está vazio
    public boolean isEmpty() {
        return history.isEmpty();
    }
}

