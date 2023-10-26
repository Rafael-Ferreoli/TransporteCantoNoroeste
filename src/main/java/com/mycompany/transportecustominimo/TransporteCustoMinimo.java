/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.transportecustominimo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rafae
 */
public class TransporteCustoMinimo {

    static class Elemento {

        private int peso;
        private String loja;
        private String fabrica;

        public Elemento(int peso, String fabrica, String loja) {
            this.peso = peso;
            this.loja = loja;
            this.fabrica = fabrica;
        }

        // Getters e Setters (ou métodos para acessar esses valores)
    }

    public static int[] encontrarMenorPeso(Elemento[][] matriz, int qtdOfertaLinhas, int qtdProcuraColunas) {
        int menorPeso = matriz[0][0].peso;
        int indiceMenorPesoI = 0;
        int indiceMenorPesoJ = 0;

        for (int i = 0; i < qtdOfertaLinhas; i++) {
            for (int j = 0; j < qtdProcuraColunas; j++) {
                if (matriz[i][j].peso < menorPeso) {
                    menorPeso = matriz[i][j].peso;
                    indiceMenorPesoI = i;
                    indiceMenorPesoJ = j;
                }
            }
        }

        int[] resultado = {indiceMenorPesoI, indiceMenorPesoJ};
        return resultado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.print("DIGITE A QUANTIDADE DE UNIDADES DE OFERTA: ");
        int qtdOfertaLinhas = 3;//sc.nextInt();
        List<Integer> listaOferta = new ArrayList<>(qtdOfertaLinhas);
        //sc.nextLine();
        //System.out.println("DIGITE A CAPACIDADE DE CADA UNIDADE DE OFERTA: ");
        //for (int i = 0; i < qtdOfertaLinhas; i++) {
        //System.out.print("DIGITE O VALOR " + (i + 1) + ": ");
        //int valor = sc.nextInt();
        //listaOferta.add(valor);
        //}
        listaOferta.add(6);
        listaOferta.add(8);
        listaOferta.add(10);
        //System.out.print("DIGITE A QUANTIDADE DE UNIDADES DE PROCURA: ");
        int qtdProcuraColunas = 4;//sc.nextInt();
        List<Integer> listaProcura = new ArrayList<>(qtdProcuraColunas);
        //sc.nextLine();
        //System.out.println("DIGITE A CAPACIDADE DE CADA UNIDADE DE PROCURA: ");
        //for (int i = 0; i < qtdProcuraColunas; i++) {
        //    System.out.print("DIGITE O VALOR " + (i + 1) + ": ");
        //    int valor = sc.nextInt();
        //    listaProcura.add(valor);
        //}
        listaProcura.add(4);
        listaProcura.add(7);
        listaProcura.add(6);
        listaProcura.add(7);
        int somaOferta = 0, somaProcura = 0;
        for (int numero : listaOferta) {
            somaOferta += numero;
        }
        for (int numero : listaProcura) {
            somaProcura += numero;
        }
        if (somaOferta == somaProcura) {
            System.out.println("O PROBLEMA É EQUILIBRADO: " + somaOferta + " = " + somaProcura);
            Elemento[][] matriz = new Elemento[qtdOfertaLinhas][qtdProcuraColunas];
            //int[][] matrizCustos = new int[qtdOfertaLinhas][qtdProcuraColunas];
            int[][] matrizCustos = {
                {1, 2, 3, 4},
                {4, 3, 2, 4},
                {0, 2, 2, 1}
            };
            // Preencher a matriz
            for (int i = 0; i < qtdOfertaLinhas; i++) {
                //System.out.print("NOME DA UNIDADE DE OFERTA: ");
                //String oferta = sc.nextLine();
                for (int j = 0; j < qtdProcuraColunas; j++) {
                    //System.out.printf("PREENCHA OS DADOS PARA A POSIÇÃO (%d, %d):\n", i + 1, j + 1);
                    // System.out.print("NOME DA UNIDADE DE PROCURA: ");
                    // String procura = sc.nextLine();
                    // System.out.print("PESO: ");
                    // int peso = sc.nextInt();
                    //matrizCustos[i][j] = peso;                   
                    //sc.nextLine();
                    //matriz[i][j] = new Elemento(peso, oferta, procura);
                    matriz[0][0] = new Elemento(1, "A", "X");
                    matriz[0][1] = new Elemento(2, "A", "Y");
                    matriz[0][2] = new Elemento(3, "A", "K");
                    matriz[0][3] = new Elemento(4, "A", "Z");
                    matriz[1][0] = new Elemento(4, "B", "X");
                    matriz[1][1] = new Elemento(3, "B", "Y");
                    matriz[1][2] = new Elemento(2, "B", "K");
                    matriz[1][3] = new Elemento(4, "B", "Z");
                    matriz[2][0] = new Elemento(0, "C", "X");
                    matriz[2][1] = new Elemento(2, "C", "Y");
                    matriz[2][2] = new Elemento(2, "C", "K");
                    matriz[2][3] = new Elemento(1, "C", "Z");

                }
            }
            int[] menorPesoIndices = encontrarMenorPeso(matriz, qtdOfertaLinhas, qtdProcuraColunas);
            int menorPesoI = menorPesoIndices[0];
            int menorPesoJ = menorPesoIndices[1];
            System.out.println("O MENOR PESO ESTÁ NA POSIÇÃO: (" + menorPesoI + ", " + menorPesoJ + ")");
            // Suponha que matrizCustos seja uma matriz de inteiros que contém os custos associados às células.
            int custoMenorPeso = matrizCustos[menorPesoI][menorPesoJ];
            System.out.println("CUSTO DA CÉLULA DE MENOR PESO: " + custoMenorPeso);
            int quantidadeAlocada = Math.min(listaOferta.get(menorPesoI), listaProcura.get(menorPesoJ)); //retorna o menor valor entre as listas de oferta e demanda
            listaOferta.set(menorPesoI, listaOferta.get(menorPesoI) - quantidadeAlocada);
            listaProcura.set(menorPesoJ, listaProcura.get(menorPesoJ) - quantidadeAlocada);

            /*
            for (int i = 0; i < qtdOfertaLinhas; i++) {
                System.out.println("VALOR DA LINHA " + i + ": " + listaOferta.get(i));
                for (int j = 0; j < qtdProcuraColunas; j++) {
                    Elemento elemento = matriz[i][j];
                    System.out.println("VALOR DA COLUNA " + j + ": " + listaProcura.get(j));
                    System.out.println("POSICAO (" + i + ", " + j + "):");
                    System.out.println("PESO: " + elemento.peso);
                    System.out.println("NOME DA UNIDADE DE OFERTA: " + elemento.loja);
                    System.out.println("NOME DA UNIDADE DE PROCURA: " + elemento.fabrica);
                    System.out.println();
                }
            }
             */
        } else {
            System.out.println("O PROBLEMA NÃO É EQUILIBRADO" + somaOferta + " != " + somaProcura);
        }
    }
}
