package bingogenerator.utils;

import bingogenerator.model.BingoCard;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFExporter {

    public static void exportarParaPdf(BingoCard card, String caminho) {
        try {
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(caminho));
            Document document = new Document(pdfDoc);

            document.add(new Paragraph("Cartela de Bingo").setBold().setFontSize(18));
        }
    }
}
