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
        System.out.println("(3) Para apostar");
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
        } else {
            System.out.println("Digite 1 ou 0!");
            voltarParaMenu(timeUsuario);
        }

    }

    Double calcularPercentualVitorias() {
        System.out.println("===== PERCENTUAL DE VITORIAS =====");
        Double percentual;

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

    String sorteioTime() {

        String time = "";
        for (Integer i = 0; i < 30; i++) {
            Integer numeroTime = ThreadLocalRandom.current().nextInt(1, 31);

            switch (numeroTime) {
                case 1:
                    time = "Atlanta Hawks";
                    break;
                case 2:
                    time = "Brooklyn Nets";
                    break;
                case 3:
                    time = "Charlotte Hornets";
                    break;
                case 4:
                    time = "Toronto Raptors";
                    break;
                case 5:
                    time = "Miami Heat";
                    break;
                case 6:
                    time = "Philadelphia Sixers";
                    break;
                case 7:
                    time = "Orlando Magic";
                    break;
                case 8:
                    time = "Chicago Bulls";
                    break;
                case 9:
                    time = "Milwaukee Bucks";
                    break;
                case 10:
                    time = "Cleveland Cavaliers";
                    break;
                case 11:
                    time = "Indiana Pacers";
                    break;
                case 12:
                    time = "New York Knicks";
                    break;
                case 13:
                    time = "Boston Celtics";
                    break;
                case 14:
                    time = "Detroit Pistons";
                    break;
                case 15:
                    time = "Washington Wizards";
                    break;
                case 16:
                    time = "Los Angeles Lakers";
                    break;
                case 17:
                    time = "Los Angeles Clippers";
                    break;
                case 18:
                    time = "Memphis Grizzles";
                    break;
                case 19:
                    time = "Golden State Warriors";
                    break;
                case 20:
                    time = "Utah Jazz";
                    break;
                case 21:
                    time = "Minesotta Timberwolves";
                    break;
                case 22:
                    time = "Phoenix Suns";
                    break;
                case 23:
                    time = "Dallas Mavericks";
                    break;
                case 24:
                    time = "Denver Nuggets";
                    break;
                case 25:
                    time = "New Orleans Pelicans";
                    break;
                case 26:
                    time = "Sacramento Kings";
                    break;
                case 27:
                    time = "Houston Rockets";
                    break;
                case 28:
                    time = "San Antonio Spurs";
                    break;
                case 29:
                    time = "Oklahoma City Thunder";
                    break;
                case 30:
                    time = "Portland Trail Blazers";
                    break;
                default:
                    System.out.println("Erro");
                    break;

            }
        }
        return time;

    }

    Boolean resultadoAposta(Integer escolha, String timeSorteado, String timeUsuario) {

        Boolean ganhou = false;
        Integer sorteio = ThreadLocalRandom.current().nextInt(1, 2);

        if (Objects.equals(sorteio, escolha)) {
            ganhou = true;

        } else {
            System.out.println("Não foi dessa vez");
        }

        return ganhou;
    }

    void apostas(String time, Double saldo) {

        String timeUsuario = time;

        Integer pontuacao;

        Integer escolha;
        Scanner leitor = new Scanner(System.in);
        String timeSorteado = sorteioTime();

        if (timeSorteado.equals(timeUsuario)) {
            sorteioTime();
        } else {
            System.out.println("Aposte no vencedor");
            System.out.println(String.format("Saldo: R$ %.2f", saldo));
            System.out.println(String.format("%s versus. %s", timeSorteado, timeUsuario));
            System.out.println(String.format("Digite (1) para %s e (2) para %s", timeSorteado, timeUsuario));

            escolha = leitor.nextInt();

            System.out.println("Digite o valor da aposta (limitado a R$100)");
            Double valorAposta = leitor.nextDouble();

            if (valorAposta < saldo) {
                if (valorAposta <= 0 || valorAposta > 100) {
                    System.out.println("Digite um valor válido");
                    apostas(timeUsuario, saldo);
                }
            }
            else{
                System.out.println(String.format("Saldo insuficiente. Saldo atual %.2f: ", saldo));
                System.out.println("Para depositar: (1)");
                System.out.println("Para sair: (0)");
                
                Integer escolhaUsuario = leitor.nextInt();
                
                if (escolhaUsuario == 0){
                    voltarParaMenu(timeUsuario);
                    
                }
                else{
                    System.out.println("Digite o valor que deseja depositar");
                    saldo+=leitor.nextDouble();
                    apostas(timeUsuario, saldo);
                    
                }
            }

            Boolean resultado = resultadoAposta(escolha, timeSorteado, timeUsuario);

            if (resultado == true) {
                pontuacao = 2;
                saldo += pontuacao*valorAposta;
                System.out.println(String.format("Você acertou! Saldo: R$ %.2f", saldo));
            } else {
                saldo-= valorAposta;
                System.out.println(String.format("Errou! Saldo: R$ %.2f", saldo));
            }
            
            System.out.println("Deseja apostar mais?");
            System.out.println("Digite 1 para sim e 0 para não");
            Integer apostarMais = leitor.nextInt();
            if (apostarMais == 0){
                voltarParaMenu(timeUsuario);
            }
            else{
                apostas(timeUsuario, saldo);
            }
        }
        
    }

    void escolherItem(String time) {
        Double saldo = 5.0;
        exibirMenu();
        String timeUsuario = time;
        Scanner leitor = new Scanner(System.in);
        Integer escolha = leitor.nextInt();

        switch (escolha) {
            case 1:
                Double percentual = calcularPercentualVitorias();
                System.out.println(String.format("O percentual de vitorias"
                        + "por jogo do %s é: %.3f", timeUsuario, percentual));
                voltarParaMenu(timeUsuario);
                break;
            case 2:
                sortearCamisetas(timeUsuario);
                break;
            case 3:
                apostas(timeUsuario, saldo);
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
