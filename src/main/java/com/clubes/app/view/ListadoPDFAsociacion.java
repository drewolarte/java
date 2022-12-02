package com.clubes.app.view;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.clubes.app.entity.Asociacion;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("asociacion/listarAsociacion")

public class ListadoPDFAsociacion extends AbstractPdfView {

	private static final String[] header = { "ID", "NOMBRE", "PAIS", "PRESIDENTE", "SIGLAS"};

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Asociacion> listadoAsociacion = (List<Asociacion>) model.get("asociacion");

		document.setPageSize(PageSize.LETTER.rotate());
		document.open();

		PdfPTable tablaTitulo = new PdfPTable(1);
		PdfPCell celda = null;
		celda = new PdfPCell(new Phrase("Listado Asociaciones"));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);

		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);

		PdfPTable tablaAsociacion = new PdfPTable(5);

		for (int i = 0; i < header.length; i++) {
			tablaAsociacion.addCell(header[i]);
		}

		listadoAsociacion.forEach(asociacion -> {

			tablaAsociacion.addCell(Integer.toString(asociacion.getId()));
			tablaAsociacion.addCell(asociacion.getNombre().toString());
			tablaAsociacion.addCell(asociacion.getPais().toString());
			tablaAsociacion.addCell(asociacion.getPresidente().toString());
			tablaAsociacion.addCell(asociacion.getSiglas().toString());

		});

		document.add(tablaTitulo);
		document.add(tablaAsociacion);

	}
}