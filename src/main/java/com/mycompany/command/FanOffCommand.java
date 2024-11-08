/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.command;

// FanOffCommand.java
public class FanOffCommand implements Command {
    private Fan fan;  // Referência ao objeto Fan

    // Construtor que recebe o objeto Fan
    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    // Método que executa a ação de desligar o ventilador
    @Override
    public void execute() {
        fan.off();  // Chama o método off() do objeto Fan
    }

    // Método para desfazer a ação, ou seja, ligar o ventilador
    @Override
    public void undo() {
        fan.on();  // Chama o método on() do objeto Fan
    }
}

