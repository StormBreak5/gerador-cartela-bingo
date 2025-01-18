package bingogenerator.view;

import bingogenerator.model.BingoCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BingoView extends JFrame {
    private JPanel cardPanel;

    public BingoView() {
        setTitle("Gerador de Folha de Bingo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setLayout(new BorderLayout());

        JButton botaoGerar = new JButton("Gerar Folha de Bingo");
        botaoGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarCartaoBingo();
            }
        });

        cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(0, 1));
        JScrollPane scrollPane = new JScrollPane(cardPanel);

        add(botaoGerar, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void gerarCartaoBingo() {
        cardPanel.removeAll();

        for(int i = 0; i < 5; i++) {
            BingoCard cartao = new BingoCard();
            JPanel cartaoUI = criarCardPanel(cartao);
            cardPanel.add(cartaoUI);
        }

        cardPanel.revalidate();
        cardPanel.repaint();
    }

    private JPanel criarCardPanel(BingoCard card) {
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 5));
        int[][] numeros = card.getNumeros();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String texto = numeros[i][j] == 0 ? "FREE" : String.valueOf(numeros[i][j]);
                JLabel label = new JLabel(texto, SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                painel.add(label);
            }
        }

        painel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        return painel;
    };
}
