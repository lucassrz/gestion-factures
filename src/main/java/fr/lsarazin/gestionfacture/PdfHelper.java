package fr.lsarazin.gestionfacture;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

public class PdfHelper {
    private final Map<String, String> content;

    public PdfHelper(Map<String, String> content) {
        this.content = content;
    }

    public void create() {
        try {
            Random rand = new Random();
            String chiffre = "1234567890";
            String finalName = "";
            for(int i = 0; i < 10; i++) {
                finalName  += chiffre.charAt(rand.nextInt(chiffre.length()));
            }

            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(50, 700);
            contentStream.showText(this.content.get("entreprise"));
            contentStream.newLine();
            contentStream.showText(this.content.get("adresse"));
            contentStream.newLine();
            contentStream.newLine();
            contentStream.showText("Date: " + this.content.get("date"));
            contentStream.newLine();
            contentStream.showText("Paiement: " + this.content.get("paiement") + " jours");
            contentStream.newLine();
            contentStream.newLine();
            contentStream.showText("Informations supplémentaires:");
            contentStream.newLine();
            contentStream.showText(this.content.get("infos"));
            contentStream.newLine();
            contentStream.newLine();
            contentStream.showText("Description: " + this.content.get("description"));
            contentStream.newLine();
            contentStream.showText("Quantité: " + this.content.get("quantite"));
            contentStream.newLine();
            contentStream.showText("Prix: " + this.content.get("prix") + "€");
            contentStream.endText();

            contentStream.close();
            document.save("src/main/resources/invoice/" + finalName + ".pdf");
            document.close();

            System.out.println("PDF created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}