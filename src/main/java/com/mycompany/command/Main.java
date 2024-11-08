/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.command;

// Main.java
public class Main {
    public static void main(String[] args) {
        // Criando os dispositivos
        Lamp lamp = new Lamp();
        Fan fan = new Fan();

        // Criando os comandos
        Command lampOn = new LampOnCommand(lamp);
        Command lampOff = new LampOffCommand(lamp);
        Command fanOn = new FanOnCommand(fan);
        Command fanOff = new FanOffCommand(fan);

        // Criando o controle remoto
        RemoteControl remote = new RemoteControl();

        // Pressionando botões
        System.out.println("Pressing button to turn on the lamp");
        remote.pressButton(lampOn);  // Liga a lâmpada

        System.out.println("\nPressing button to turn off the lamp");
        remote.pressButton(lampOff); // Desliga a lâmpada

        System.out.println("\nPressing button to turn on the fan");
        remote.pressButton(fanOn);   // Liga o ventilador

        System.out.println("\nPressing button to turn off the fan");
        remote.pressButton(fanOff);  // Desliga o ventilador

        System.out.println("\nPressing Undo button:");
        remote.pressUndo(); // Desfaz a última ação (desliga o ventilador)

        System.out.println("\nPressing Undo button again:");
        remote.pressUndo(); // Desfaz a ação anterior (desliga a lâmpada)
    }
}

