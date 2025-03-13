package bingogenerator.view;

import bingogenerator.model.BingoCard;
import bingogenerator.utils.PDFExporter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BingoView extends JFrame {
    private JPanel cardPanel;
    private List<BingoCard> cartelasGeradas;

    public BingoView() {
        setTitle("Gerador de Folha de Bingo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel();

        JButton botaoGerar = new JButton("Gerar Folha de Bingo");
        botaoGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarCartaoBingo();
            }
        });

        JButton botaoExportarPdf = new JButton("Exportar PDF");
        botaoExportarPdf.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               exportarCartelaPdf();
           }
        });

        buttonsPanel.add(botaoGerar);
        buttonsPanel.add(botaoExportarPdf);

        cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(0, 2, 10, 10));
        JScrollPane scrollPane = new JScrollPane(cardPanel);

        add(buttonsPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        cartelasGeradas = new ArrayList<>();
    }

    private void gerarCartaoBingo() {
        cardPanel.removeAll();
        cartelasGeradas.clear();

        for(int i = 0; i < 5; i++) {
            BingoCard cartao = new BingoCard();
            cartelasGeradas.add(cartao);
            BingoCardPanel cartaoUI = new BingoCardPanel(cartao);
            cardPanel.add(cartaoUI);
        }

        cardPanel.revalidate();
        cardPanel.repaint();
    }

    private void exportarCartelaPdf() {
        if(cartelasGeradas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhuma cartela gerada ainda", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar cartela de bingo.");
        fileChooser.setSelectedFile(new File("cartela_bingo.pdf"));

        int userSelection = fileChooser.showSaveDialog(this);
        if(userSelection == JFileChooser.APPROVE_OPTION) {
            String caminho = fileChooser.getSelectedFile().getAbsolutePath();
            if(!caminho.endsWith(".pdf")) {
                caminho += ".pdf";
            }

            PDFExporter.exportarParaPdf(cartelasGeradas, caminho);
            JOptionPane.showMessageDialog(this, "PDF salvo em: \n " + caminho, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
