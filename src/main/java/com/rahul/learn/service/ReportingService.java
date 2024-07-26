/**
 * 
 */
package com.rahul.learn.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rahul.learn.dto.Students;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
   @since  20-Feb-2024 2024 7:11:48 pm
 */
@Service
@Slf4j
public class ReportingService {
	/**
	 * @param string
	 * @param students 
	 * @return
	 */
	public ByteArrayOutputStream generatePDF(String traceId, List<Students> students) {
		Document document = new Document(PageSize.A3);
		float filedSpace = 40f;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		Font smallNormal = new Font(Font.FontFamily.UNDEFINED, 10 , Font.NORMAL);
		try {
			PdfWriter.getInstance(document, byteArrayOutputStream);
			document.open();
			document.newPage();
			
			float[] columnWidth = {4f, 4f, 4f, 4f, 4f};
			Font titleFont = new Font(FontFamily.TIMES_ROMAN,12, Font.BOLD, new BaseColor(0,0,0));
			
			Paragraph title = new Paragraph("Student Details",titleFont);
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);
			
			PdfPTable table = new PdfPTable(5);
			table.setPaddingTop(10);
			table.getDefaultCell().setBorder(20);
			table.setWidths(columnWidth);
			table.setWidthPercentage(100);
			table.setSpacingAfter(10f);
			table.setHorizontalAlignment(Element.ALIGN_CENTER);
			
            pdfInsertCell(table, "Name", Element.ALIGN_CENTER, 1, titleFont);
            pdfInsertCell(table, "School Name", Element.ALIGN_CENTER, 1, titleFont);
            pdfInsertCell(table, "Address", Element.ALIGN_CENTER, 1, titleFont);
            pdfInsertCell(table, "Phone Number", Element.ALIGN_CENTER, 1, titleFont);
            pdfInsertCell(table, "ID Number", Element.ALIGN_CENTER, 1, titleFont);
			table.setHeaderRows(1);
			Font cellFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            for (Students student : students) {
            	table.addCell(createPDFCell(
            			student.getName(),smallNormal,Element.ALIGN_CENTER,Element.ALIGN_CENTER, Rectangle.BOX, filedSpace));
            	table.addCell(createPDFCell(
            			student.getSchoolName(),smallNormal,Element.ALIGN_CENTER,Element.ALIGN_CENTER, Rectangle.BOX, filedSpace));
            	table.addCell(createPDFCell(
            			student.getAddress(),smallNormal,Element.ALIGN_CENTER,Element.ALIGN_CENTER, Rectangle.BOX, filedSpace));
            	table.addCell(createPDFCell(
            			student.getPhoneNumber(),smallNormal,Element.ALIGN_CENTER,Element.ALIGN_CENTER, Rectangle.BOX, filedSpace));
            	table.addCell(createPDFCell(
            			student.getIdNumber(),smallNormal,Element.ALIGN_CENTER,Element.ALIGN_CENTER, Rectangle.BOX, filedSpace));
            }			
			document.add(table);
			document.add(Chunk.NEWLINE);
			document.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byteArrayOutputStream;
	}

	/**
	 * @param f 
	 * @param schoolName
	 * @param alignCenter
	 * @param alignCenter2
	 * @param box
	 * @param filedSpace
	 * @return
	 */
	private PdfPCell createPDFCell(String value, Font f, int horizontalAllignment, int verticalAlignment, int border, float height) {
		
		PdfPCell cell = new PdfPCell(new Paragraph(value, f));
		cell.setHorizontalAlignment(horizontalAllignment);
		cell.setVerticalAlignment(verticalAlignment);
		cell.setBorder(border);
		cell.setPadding(1.5f);
		cell.setFixedHeight(height);
		return cell;
	}

	/**
	 * @param table
	 * @param string
	 * @param alignCenter
	 * @param i
	 * @param Font
	 */
	private static void pdfInsertCell(PdfPTable table, String text, int align, int colspan, Font font) {
		
		// creates a new cell with the specified text and font.
		PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
		//set the cell alignment 
		cell.setHorizontalAlignment(align);
		//set the cell column span in case you want to merge two or more cells
		cell.setColspan(colspan);
		// incase there is no text and we want to create a an empty row
		if(text.trim().equalsIgnoreCase("")){
			cell.setMinimumHeight(10f);
		}
		//add the cell to table
		table.addCell(cell);
	}
	
	

}
