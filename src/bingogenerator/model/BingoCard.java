package bingogenerator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoCard {
    private static final int LINHAS = 5;
    private static final int COLUNAS = 5;
    private static final int [][] FAIXA = { //Limite de cada coluna
            {1, 15}, //B
            {16, 30}, // I
            {31, 45}, // N
            {46, 60}, // G
            {61, 75} // O
    };

    private final int[][] numeros;

    public BingoCard() {
        numeros = new int[LINHAS][COLUNAS];
        gerarNumeros();
    }

    private void gerarNumeros() {
        for(int col = 0; col < COLUNAS; col++) {
            // Gera uma lista de números para a coluna atual dentro do intervalo
            List<Integer> numerosColuna = gerarNumerosColuna(FAIXA[col][0], FAIXA[col][1]);

            for(int row = 0; row < LINHAS; row++) {
                if(col == 2 && row == 2) {
                    numeros[row][col] = 0; //Posição no meio da cartela zerada.
                } else {
                    numeros[row][col] = numerosColuna.get(row);
                }
            }
        }

//        List<Integer> pool = new ArrayList<>();
//        for (int i = 1; i <= 75; i++) {
//            pool.add(i);
//        }
//        Collections.shuffle(pool);
//
//        int index = 0;
//        for (int i = 0; i < LINHAS; i++) {
//            for (int j = 0; j < COLUNAS; j++) {
//                if(i == 2 && j == 2){
//                    numeros[i][j] = 0; //Posição no meio da cartela zerada.
//                } else {
//                    numeros[i][j] = pool.get(index++);
//                }
//            }
//        }
    }

    private List<Integer> gerarNumerosColuna(int min, int max) {
        List<Integer> numerosCol = new ArrayList<>();
        for(int i = min; i <= max; i++) {
            numerosCol.add(i);
        }

        //Embaralhando números e pegando os x primeiros baseado na quantidade de linhas.
        Collections.shuffle(numerosCol);
        List<Integer> numerosColuna = numerosCol.subList(0, LINHAS);

        //Ordenando números.
        Collections.sort(numerosColuna);
        return numerosColuna;
    };

    public int[][] getNumeros() {
        return numeros;
    }
}