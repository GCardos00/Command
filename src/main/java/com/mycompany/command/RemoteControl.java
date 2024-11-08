/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.command;

// RemoteControl.java
public class RemoteControl {
    private CommandHistory history = new CommandHistory();  // Histórico de comandos

    // Método para pressionar um botão (executar um comando)
    public void pressButton(Command command) {
        command.execute();  // Executa o comando
        history.push(command);  // Adiciona o comando ao histórico
    }

    // Método para pressionar o botão de undo
    public void pressUndo() {
        if (!history.isEmpty()) {
            Command command = history.pop();  // Remove o último comando do histórico
            if (command != null) {
                command.undo();  // Desfaz a última ação executada
            }
        }
    }
}

