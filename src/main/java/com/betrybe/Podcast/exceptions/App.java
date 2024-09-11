package com.betrybe.Podcast.exceptions;

import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Pra finalizar a compra, é necessário ser maior de idade. Informe sua idade: ");
        Scanner entrada = new Scanner(System.in);
        int idade = entrada.nextInt();

        try{
            ehMaiorDeIdade(idade);
            System.out.println("Compra confirmada!");
        } catch (MenorDeIdadeException e) {
            System.out.println("Compra recusada, pessoa menor de idade!");
        } finally {
            entrada.close();
        }
    }

    private static boolean ehMaiorDeIdade(int idade) throws MenorDeIdadeException {
        if (idade < 18) {
            throw new MenorDeIdadeException();
        }else {
            return true;
        }
    }
}
