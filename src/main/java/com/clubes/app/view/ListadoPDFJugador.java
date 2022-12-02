package com.clubes.app.view;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.clubes.app.entity.Jugador;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("jugador/listarJugador")

public class ListadoPDFJugador extends AbstractPdfView {

	private static final String[] header = { "ID", "NOMBRE", "APELLIDO", "NUMERO", "POSICION"};

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Jugador> listadoJugador = (List<Jugador>) model.get("jugador");

		document.setPageSize(PageSize.LETTER.rotate());
		document.open();

		PdfPTable tablaTitulo = new PdfPTable(1);
		PdfPCell celda = null;
		celda = new PdfPCell(new Phrase("Listado Jugadores"));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);

		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);

		PdfPTable tablaJugador = new PdfPTable(5);

		for (int i = 0; i < header.length; i++) {
			tablaJugador.addCell(header[i]);
		}

		listadoJugador.forEach(jugador -> {

			tablaJugador.addCell(Integer.toString(jugador.getId()));
			tablaJugador.addCell(jugador.getNombre().toString());
			tablaJugador.addCell(jugador.getApellido().toString());
			tablaJugador.addCell(Integer.toString(jugador.getNumero()));
			tablaJugador.addCell(jugador.getPosicion().toString());

		});

		document.add(tablaTitulo);
		document.add(tablaJugador);

	}
}