package bingogenerator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoCard {
    private static final int LINHAS = 5;
    private static final int COLUNAS = 5;
    private final int[][] numeros;

    public BingoCard() {
        numeros = new int[LINHAS][COLUNAS];
        gerarNumeros();
    }

    private void gerarNumeros() {
        List<Integer> pool = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            pool.add(i);
        }
        Collections.shuffle(pool);

        int index = 0;
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if(i == 2 && j == 2){
                    numeros[i][j] = 0; //Posição no meio da cartela zerada.
                } else {
                    numeros[i][j] = pool.get(index++);
                }
            }
        }
    }

    public int[][] getNumeros() {
        return numeros;
    }
}