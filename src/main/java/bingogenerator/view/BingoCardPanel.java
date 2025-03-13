package bingogenerator.view;

import bingogenerator.model.BingoCard;

import javax.swing.*;
import java.awt.*;

public class BingoCardPanel extends JPanel {
    private static final String[] HEADERS = {"B", "I", "N", "G", "O"};

    private final int[][] numbers;

    public BingoCardPanel(BingoCard card) {
        this.numbers = card.getNumeros();
        setLayout(new GridLayout(6, 5, 5,5));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        inicializarTemplate();
    }

    private void inicializarTemplate() {
        for (int col = 0; col < HEADERS.length; col++) {
            JLabel label = new JLabel(HEADERS[col], SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 16));

            if (col == 1) {
                label.setForeground(Color.RED);
            } else {
                label.setForeground(Color.BLUE);
            }

            add(label);
        }

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                JLabel label;

                if(row == 2 && col == 2){
                    label = new JLabel("FREE", SwingConstants.CENTER);
                    label.setFont(new Font("Arial", Font.BOLD, 14));
                    label.setOpaque(true);
                    label.setBackground(Color.LIGHT_GRAY);
                } else {
                    label = new JLabel(String.valueOf(numbers[row][col]), SwingConstants.CENTER);
                    label.setFont(new Font("Arial", Font.BOLD, 14));
                }

                label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                label.setOpaque(true);
                label.setBackground(Color.WHITE);
                add(label);
            }
        }
    }
}
