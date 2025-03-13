package bingogenerator.utils;

import bingogenerator.model.BingoCard;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.FileNotFoundException;
import java.util.List;

public class PDFExporter {

    public static void exportarParaPdf(List<BingoCard> cartelas, String caminho) {
        try {
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(caminho));
            Document document = new Document(pdfDoc);

            document.add(new Paragraph("Cartela de Bingo").setBold().setFontSize(18));

            int contador = 1;

            for (BingoCard cartela : cartelas) {
                document.add(new Paragraph("Cartela #" + contador).setBold().setFontSize(14));
                document.add(gerarTabelaBingo(cartela));
                document.add(new Paragraph("\n"));
                contador++;
            }

            document.close();
            System.out.println("PDF gerado: " + caminho);
        } catch(FileNotFoundException e) {
            System.err.println("Erro ao gerar PDF: " + e.getMessage());
        }
    }

    private static Table gerarTabelaBingo(BingoCard cartela) {
        Table table = new Table(5);

        String[] headers = {"B", "I", "N", "G", "O"};
        for (String header : headers) {
            table.addHeaderCell(new Cell().add(new Paragraph(header).setBold()));
        }

        int[][] numbers = cartela.getNumeros();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String text = (numbers[i][j] == 0) ? "FREE" : String.valueOf(numbers[i][j]);
                table.addCell(new Cell().add(new Paragraph(text)));
            }
        }

        return table;
    }
}
