/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.command;


// LampOnCommand.java
public class LampOnCommand implements Command {
    private Lamp lamp;  // Referência ao objeto Lamp

    // Construtor que recebe o objeto Lamp
    public LampOnCommand(Lamp lamp) {
        this.lamp = lamp;
    }

    // Método que executa a ação de ligar a lâmpada
    @Override
    public void execute() {
        lamp.on();  // Chama o método on() do objeto Lamp
    }

    // Método para desfazer a ação, ou seja, desligar a lâmpada
    @Override
    public void undo() {
        lamp.off();  // Chama o método off() do objeto Lamp
    }
}

