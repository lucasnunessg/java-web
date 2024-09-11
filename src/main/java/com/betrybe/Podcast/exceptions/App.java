package com.betrybe.Podcast.exceptions;

public class App {
    public static void main(String[] args) {
        try {
            Integer resultado = 2 / 0;
            System.out.println("Será q deu certo?");
            System.out.println(resultado);

        }catch (ArithmeticException e) {
            System.out.println("Ops! não é possível realizar divisão por zero(0).");
        }

    }
}
