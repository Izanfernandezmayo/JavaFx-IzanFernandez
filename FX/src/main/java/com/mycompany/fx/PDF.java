package com.mycompany.fx;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.chart.BarChart;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;

public class PDF {

    public static void generar(BarChart<String, Number> chart) {
        try {
            WritableImage image = chart.snapshot(null, null);
            File file = new File("grafica.png");
            ImageIO.write(
                    SwingFXUtils.fromFXImage(image, null),
                    "png",
                    file
            );

            Document document = new Document();
            PdfWriter.getInstance(document,
                    new FileOutputStream("reporte.pdf"));

            document.open();
            document.add(new Paragraph("Informe de datos"));

            Image img = Image.getInstance("grafica.png");
            img.scaleToFit(500, 400);
            document.add(img);

            document.close();

            System.out.println("PDF generado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}