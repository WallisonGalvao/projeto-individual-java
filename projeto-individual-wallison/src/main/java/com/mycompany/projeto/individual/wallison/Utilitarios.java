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

    // print de boas vindas
    void boasVindas() {
        System.out.println("Seja vem vindo a Central de Basquete SPTECH!");
    }

    // função para receber o nome do time do usuário
    String receberNome() {
        Scanner leitor = new Scanner(System.in);
        String nomeDoTime = leitor.nextLine();
        return nomeDoTime;
    }

    // função para exibir os itens do menu
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

    //função de decisão para voltar ao menu
    void voltarParaMenu(String timeUsuario) {
        Scanner leitorNum = new Scanner(System.in);
        System.out.println("Deseja voltar ao menu principal?");
        System.out.println("Digite (1) para sim e (0) para não");
        Integer escolha = leitorNum.nextInt();

        if (escolha.equals(1)) {
            escolherItem(timeUsuario);
        } else if (escolha.equals(0)) {
            System.out.println("Obrigado! Até logo.");
        } else {
            System.out.println("Digite um valor válido");
            voltarParaMenu(timeUsuario);
        }
    }

    // função para calcular pct de vitoria do time do usuario
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

    //função de sorteio simples
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

    // função para atribuir nomes de times da NBA ao numero gerado aleatoriamente
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

    void apostarDeNovo(String timeUsuario, Double saldo) {
        System.out.println("Deseja apostar mais?");
        System.out.println("(1) - SIM");
        System.out.println("(0) - NÃO");
        Scanner leitor = new Scanner(System.in);
        Integer escolha = leitor.nextInt();

        if (escolha.equals(1)) {
            apostar(timeUsuario, saldo);
        } else {
            escolherItem(timeUsuario);
        }
    }

    
    Double resultadoAposta(String timeUsuario,
            String timeSorteado, Integer escolha, Double aposta, Double saldo) {

        Integer timeVencedor = ThreadLocalRandom.current().nextInt(0, 2);
        Double pontuacao;
        Double premio;

        if (timeVencedor.equals(escolha)) {
            System.out.println("Parabéns! Você acertou!");
            pontuacao = 0.6;
            premio = pontuacao * aposta;
            saldo += premio;
            System.out.println(String.format("Saldo: R$ %.2f", saldo));
            apostarDeNovo(timeUsuario, saldo);

        } else {
            System.out.println("Errou!");
            saldo -= aposta;
            System.out.println(String.format("Saldo: R$ %.2f", saldo));
            apostarDeNovo(timeUsuario, saldo);
        }

        System.out.println(timeVencedor);
        return saldo;
    }

//    apostar
    void apostar(String timeUsuario, Double saldo) {
        Scanner leitorEscolha = new Scanner(System.in);
        if (saldo <= 0) {
            System.out.println("Saldo insuficiente para apostas");
            System.out.println(String.format("Saldo: R$ %.2f", saldo));
            System.out.println("Deseja depositar um valor?");
            System.out.println("(1) - SIM");
            System.out.println("(2) - NÃO");

            Integer escolhaDeposito = leitorEscolha.nextInt();

            if (escolhaDeposito.equals(1)) {
                depositar(saldo);
            } else {
                System.out.println("Redirecionando para menu");
                escolherItem(timeUsuario);
            }
        }

        String timeSorteado = sorteioTime();
        if (timeSorteado.equals(timeUsuario)) {
            timeSorteado = sorteioTime();
        }

        System.out.println("Escolha com (1) ou (0)");
        System.out.println(String.format("(1) %s vs. (0) %s", timeUsuario, timeSorteado));

        Integer escolha = leitorEscolha.nextInt();

        if (escolha < 0 || escolha > 1) {
            System.out.println("Digite entre 1 ou 0!");
            System.out.println("Uma nova aposta será feita");
            apostar(timeUsuario, saldo);
        }

        System.out.println("Digite o valor da aposta");
        Double valorAposta = leitorEscolha.nextDouble();

        if (saldo < valorAposta) {
            System.out.println(String.format("Saldo insuficiente. Saldo: R$ %.2f", saldo));
            saldo += depositar(saldo);
            System.out.println("Uma nova aposta será feita");
            apostar(timeUsuario, saldo);
        }
        resultadoAposta(timeUsuario, timeSorteado, escolha, valorAposta, saldo);
    }

//    função para depositar
    Double depositar(Double saldo) {
        System.out.println("Digite o valor para depósito");
        Scanner leitor = new Scanner(System.in);
        Double deposito = leitor.nextDouble();

        verificaDeposito(deposito);

        saldo += deposito;
        return saldo;

    }

//    verificação de deposito
    Boolean verificaDeposito(Double deposito) {
        Scanner leitor = new Scanner(System.in);
        Boolean depositoCorreto = false;
        if (deposito > 100) {
            System.out.println("Digite um valor até R$100,00");
            deposito = leitor.nextDouble();
            verificaDeposito(deposito);
        } else {
            System.out.println("Depósito feito com sucesso");
            depositoCorreto = true;
        }
        return depositoCorreto;
    }

    //info sobre as apostas e deposito
    void infoAposta(String time) {
        String timeUsuario = time;
        Double saldo = 0.0;
        System.out.println("======= APOSTAS =======");
        System.out.println("Aposte no time que irá vencer");
        System.out.println("Será seu time contra os times da NBA (aleatórios)");

        Scanner leitor = new Scanner(System.in);

        System.out.println("Primeiro, deposite um valor para realizar suas apostas");
        System.out.println("Limite: R$100");
        System.out.println(String.format("Saldo: R$ %.2f", saldo));

        saldo += depositar(saldo);
        apostar(timeUsuario, saldo);

    }

//    função para escolher algum item do menu
    void escolherItem(String time) {

        exibirMenu();
        String timeUsuario = time;
        Scanner leitor = new Scanner(System.in);
        Integer escolha = leitor.nextInt();

        switch (escolha) {
            case 1:
                Double percentual = calcularPercentualVitorias();
                System.out.println(String.format("O percentual de vitorias"
                        + " por jogo do %s é: %.3f", timeUsuario, percentual));
                voltarParaMenu(timeUsuario);
                break;
            case 2:
                sortearCamisetas(timeUsuario);
                break;
            case 3:
                infoAposta(timeUsuario);
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
