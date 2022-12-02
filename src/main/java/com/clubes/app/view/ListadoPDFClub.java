package com.clubes.app.view;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.clubes.app.entity.Club;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("club/listarClub")

public class ListadoPDFClub extends AbstractPdfView {

	private static final String[] header = { "ID", "NOMBRE", "ENTRENADOR", "JUGADORES", "ASOCIACION", "COMPETICIONES"};

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Club> listadoClub = (List<Club>) model.get("club");

		document.setPageSize(PageSize.LETTER.rotate());
		document.open();

		PdfPTable tablaTitulo = new PdfPTable(1);
		PdfPCell celda = null;
		celda = new PdfPCell(new Phrase("Listado Clubes"));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);

		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);

		PdfPTable tablaClub = new PdfPTable(6);

		for (int i = 0; i < header.length; i++) {
			tablaClub.addCell(header[i]);
		}

		listadoClub.forEach(club -> {
			
			String jugadores = "";
			for (int i = 0; i < club.getJugadores().size(); i++) {
				jugadores=jugadores+club.getJugadores().get(i).getNombre()+" "+club.getJugadores().get(i).getApellido()+"\n";
			}
			
			String competiciones = "";
			for (int i = 0; i < club.getCompeticiones().size(); i++) {
				competiciones=competiciones+club.getCompeticiones().get(i).getNombre()+"\n";
			}

			tablaClub.addCell(Integer.toString(club.getId()));
			tablaClub.addCell(club.getNombre().toString());
			tablaClub.addCell(club.getEntrenador().getNombre().toString()+" "+club.getEntrenador().getApellido().toString());
			tablaClub.addCell(jugadores);
			tablaClub.addCell(club.getAsociacion().getNombre().toString());
			tablaClub.addCell(competiciones);
			

		});

		document.add(tablaTitulo);
		document.add(tablaClub);

	}
}