/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.individual.wallison;

/**
 *
 * @author wquero
 */
public class App {
    public static void main(String[] args) {
        Utilitarios util = new Utilitarios();
        
        util.boasVindas();
        
        System.out.println("Para começar, digite o nome do seu time");
        
        String time = util.receberNome();
        System.out.println(String.format("O nome do seu time é: %s", time));
        
        util.exibirMenu();
        util.escolherItem();
    }
}
