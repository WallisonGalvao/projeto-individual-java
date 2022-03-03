/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.individual.wallison;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author wquero
 */
public class Utilitarios {

    void boasVindas() {
        System.out.println("Seja vem vindo a Central de Basquete SPTECH!");
    }

    String receberNome() {
        Scanner leitor = new Scanner(System.in);
        String nomeDoTime = leitor.nextLine();
        return nomeDoTime;
    }

    void exibirMenu() {
        System.out.println("=".repeat(36));
        System.out.println("============== MENU ================");
        System.out.println("=".repeat(36));

        System.out.println("Para escolher, digite o número dentro dos parênteses");
        System.out.println("(1) Calcular percentual de vitórias");
        System.out.println("(2) Para participar do sorteio de uma camiseta");
        System.out.println("(3) Para registrar os jogadores");
        System.out.println("(4) Sair");
    }

    void voltarParaMenu(String timeUsuario) {
        Scanner leitorNum = new Scanner(System.in);
        System.out.println("Deseja voltar ao menu principal?");
        System.out.println("Digite (1) para sim e (0) para não");
        Integer escolha = leitorNum.nextInt();

        if (escolha == 1 || escolha == 0) {
            if (escolha == 1) {
                escolherItem(timeUsuario);
            } else {
                System.out.println("Obrigado! Até logo.");
            }
        }
        else {
            System.out.println("Digite 1 ou 0!");
            voltarParaMenu(timeUsuario);
        }

    }

    Double calcularPercentualVitorias() {
        System.out.println("===== PERCENTUAL DE VITORIAS =====");
        Double percentual = 0.0;

        System.out.println("Digite aqui o número de vitórias do seu time no campeonato");
        Scanner leitor = new Scanner(System.in);

        Double numeroDeVitorias = leitor.nextDouble();

        System.out.println("Agora digite o número de jogos");
        Double numeroDeJogos = leitor.nextDouble();

        percentual = numeroDeVitorias / numeroDeJogos;

        
        return percentual;

    }

    Integer sortearCamisetas(String timeUsuario) {
        String frase = "Infelizmente você não ganhou, mais sorte na próxima";
        Boolean ganhou = false;
        Integer contador = 3;
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("===== SORTEIO =====");
        System.out.println("Serão 3 sorteios");

        System.out.println("Digite um número entre 1 e 30");
        Integer numeroDigitado = leitor.nextInt();

        if (numeroDigitado < 1 || numeroDigitado > 30) {
            System.out.println("Digite um número entre 1 e 30!");
            System.out.println("Digite novamente");
            sortearCamisetas(timeUsuario);
        } else {
            System.out.println(String.format("Seu número da sorte é %d", numeroDigitado));
            while (contador != 0) {
                Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 30);
                System.out.println(String.format("O número sorteado foi: %d", numeroAleatorio));
                if (!Objects.equals(numeroDigitado, numeroAleatorio)) {
                    contador--;
                } else {
                    ganhou = true;
                    System.out.println(ganhou);
                    frase = String.format("Parabéns! Você ganhou uma camiseta do %s", timeUsuario);
                    contador--;
                }
                
            }
        }
        System.out.println(frase);
        voltarParaMenu(timeUsuario);
        return 0;
    }

//    String registrarJogadores() {
//        String [] time = new string [MAXIMO];
//        Integer MAXIMO = 15;
//        Scanner leitor = new Scanner (System.in);
//        for (int i = 0; i < MAXIMO; i++){
//            time[i] = leitor.nextLine();
//        }
//        return
//    }
    void escolherItem(String time) {
        exibirMenu();
        String timeUsuario = time;
        Scanner leitor = new Scanner(System.in);
        Integer escolha = leitor.nextInt();

        switch (escolha) {
            case 1:
                Double percentual = calcularPercentualVitorias();
                System.out.println(String.format("O percentual de vitorias por jogo do %s é: %.3f", timeUsuario, percentual));
                voltarParaMenu(timeUsuario);
                break;
            case 2:
                sortearCamisetas(timeUsuario);
                break;
            case 3:
                //registrarJogadores();
                break;
            case 4:
                System.out.println("Obrigado! Até a próxima :)");
                break;
            default:
                System.out.println("Digite entre 1 e 4!");
                escolherItem(timeUsuario);
                break;
        }
    }
}
