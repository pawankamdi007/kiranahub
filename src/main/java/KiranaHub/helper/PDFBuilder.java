package KiranaHub.helper;

import java.io.FileOutputStream;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import KiranaHub.entity.Transaction;




/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Transaction transaction=(Transaction) model.get("transaction");
		
		doc.add(new Paragraph("Bill Invoice"));
		
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {1f, 1f, 1.5f, 1.5f, 1.5f,1f});
		table.setSpacingBefore(10);
		
		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		
		// write table header 
		cell.setPhrase(new Phrase("First Name", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Last Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Total Amount", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Paid Amount", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Balance Amount", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Status", font));
		table.addCell(cell);
		
		// write table row data
			
				String str=String.valueOf(transaction.getBalanceAmount());
			
				table.addCell(transaction.getCustomer().getFirstName());
			table.addCell(transaction.getCustomer().getLastName());
			table.addCell(transaction.getTotalAmount());
			table.addCell(transaction.getPaidAmount());
			table.addCell(str);
			table.addCell(transaction.getStatus());
			
		
		doc.add(table);
		
	}
	

			
	}
	
	
