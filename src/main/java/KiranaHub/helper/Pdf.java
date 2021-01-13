package KiranaHub.helper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf {

	public static void main(String[] args) {
		Document document=new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\pawan\\Desktop\\pdf1.pdf"));
			document.open();
			document.add(new Paragraph("Example"));
			document.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
