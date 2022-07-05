
package com.example.plan.util.reportes;

import com.example.plan.entity.Libro;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class LibroExporterPDF {

    private List<Libro> listaLibros;

    public LibroExporterPDF(List<Libro> listaLibros) {
        super();
        this.listaLibros = listaLibros;
    }

    private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
        PdfPCell celda = new PdfPCell();

        celda.setBackgroundColor(Color.BLUE);
        celda.setPadding(5);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.WHITE);

        celda.setPhrase(new Phrase("ID", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Título", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Año", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Edición", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Editorial", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Autor", fuente));
        tabla.addCell(celda);
    }

    private void escribirDatosDeLaTabla(PdfPTable tabla) {
        for (Libro libro : listaLibros) {
            tabla.addCell(String.valueOf(libro.getId()));
            tabla.addCell(libro.getTitulo());
            tabla.addCell(String.valueOf(libro.getAnos()));
            tabla.addCell(libro.getEdicion());
            tabla.addCell(libro.getEditorial().getNombre());
            tabla.addCell(String.valueOf(libro.getAutor().getNombres() + " " + libro.getAutor().getApellidos()));
        }
    }

    public void exportar(HttpServletResponse response) throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.BLUE);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de Libros", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        PdfPTable tabla = new PdfPTable(6);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[]{1f, 2.3f, 2.3f, 6f, 2.9f, 3.5f});
        tabla.setWidthPercentage(110);

        escribirCabeceraDeLaTabla(tabla);
        escribirDatosDeLaTabla(tabla);

        documento.add(tabla);
        documento.close();
    }
}
