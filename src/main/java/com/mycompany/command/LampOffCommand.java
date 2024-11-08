/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.command;

// LampOffCommand.java
public class LampOffCommand implements Command {
    private Lamp lamp;  // Referência ao objeto Lamp

    // Construtor que recebe o objeto Lamp
    public LampOffCommand(Lamp lamp) {
        this.lamp = lamp;
    }

    // Método que executa a ação de desligar a lâmpada
    @Override
    public void execute() {
        lamp.off();  // Chama o método off() do objeto Lamp
    }

    // Método para desfazer a ação, ou seja, ligar a lâmpada
    @Override
    public void undo() {
        lamp.on();  // Chama o método on() do objeto Lamp
    }
}

