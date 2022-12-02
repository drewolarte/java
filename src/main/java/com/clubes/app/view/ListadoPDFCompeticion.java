package com.clubes.app.view;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.clubes.app.entity.Competicion;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("competicion/listarCompeticion")

public class ListadoPDFCompeticion extends AbstractPdfView {

	private static final String[] header = { "ID", "NOMBRE", "MONTO PREMIO", "FECHA INICIO", "FECHA FIN"};

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Competicion> listadoCompeticion = (List<Competicion>) model.get("competicion");

		document.setPageSize(PageSize.LETTER.rotate());
		document.open();

		PdfPTable tablaTitulo = new PdfPTable(1);
		PdfPCell celda = null;
		celda = new PdfPCell(new Phrase("Listado Competiciones"));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);

		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);

		PdfPTable tablaCompeticion = new PdfPTable(5);

		for (int i = 0; i < header.length; i++) {
			tablaCompeticion.addCell(header[i]);
		}

		listadoCompeticion.forEach(competicion -> {

			tablaCompeticion.addCell(Integer.toString(competicion.getId()));
			tablaCompeticion.addCell(competicion.getNombre().toString());
			tablaCompeticion.addCell(Integer.toString(competicion.getMontoPremio()));
			tablaCompeticion.addCell(competicion.getFechaInicio().toString());
			tablaCompeticion.addCell(competicion.getFechaFin().toString());

		});

		document.add(tablaTitulo);
		document.add(tablaCompeticion);

	}
}
