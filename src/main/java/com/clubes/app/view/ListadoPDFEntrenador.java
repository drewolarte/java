package com.clubes.app.view;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.clubes.app.entity.Entrenador;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("entrenador/listarEntrenador")

public class ListadoPDFEntrenador extends AbstractPdfView {

	private static final String[] header = { "ID", "NOMBRE", "APELLIDO", "EDAD", "NACIONALIDAD"};

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Entrenador> listadoEntrenador = (List<Entrenador>) model.get("entrenador");

		document.setPageSize(PageSize.LETTER.rotate());
		document.open();

		PdfPTable tablaTitulo = new PdfPTable(1);
		PdfPCell celda = null;
		celda = new PdfPCell(new Phrase("Listado Entrenadores"));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);

		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);

		PdfPTable tablaEntrenador = new PdfPTable(5);

		for (int i = 0; i < header.length; i++) {
			tablaEntrenador.addCell(header[i]);
		}

		listadoEntrenador.forEach(entrenador -> {

			tablaEntrenador.addCell(Integer.toString(entrenador.getId()));
			tablaEntrenador.addCell(entrenador.getNombre().toString());
			tablaEntrenador.addCell(entrenador.getApellido().toString());
			tablaEntrenador.addCell(Integer.toString(entrenador.getEdad()));
			tablaEntrenador.addCell(entrenador.getNacionalidad().toString());

		});

		document.add(tablaTitulo);
		document.add(tablaEntrenador);

	}
}