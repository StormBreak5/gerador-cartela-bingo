package bingogenerator;

import bingogenerator.view.BingoView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BingoView view = new BingoView();
            view.setVisible(true);
        });
    }
}
