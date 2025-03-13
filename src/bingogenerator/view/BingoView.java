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
        setSize(800, 600);
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
        cardPanel.setLayout(new GridLayout(0, 2, 10, 10));
        JScrollPane scrollPane = new JScrollPane(cardPanel);

        add(botaoGerar, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void gerarCartaoBingo() {
        cardPanel.removeAll();

        for(int i = 0; i < 5; i++) {
            BingoCard cartao = new BingoCard();
            BingoCardPanel cartaoUI = new BingoCardPanel(cartao);
            cardPanel.add(cartaoUI);
        }

        cardPanel.revalidate();
        cardPanel.repaint();
    }
}
