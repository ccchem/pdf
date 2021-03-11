package pdf;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.property.AreaBreakType;


public class ImgTest1
{

    public static void main(String[] args) throws Exception
    {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter("/tmp/dora-1.pdf"));
        
        Document doc = new Document(pdfDoc);

        int len = 38;
        
        for(int i = 1; i <= len; i++)
        {
            String num = String.format("%03d", i);
            String file = "/tmp/dora/" + num + ".jpg";
            addImage(doc, file);
            if(i != len)
            {
                doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
            }
        }
        
        doc.close();
    }

    
    private static void addImage(Document doc, String name) throws Exception
    {
        ImageData imgData = ImageDataFactory.create(name);
        Image img = new Image(imgData);
        doc.add(img);
        
    }
}
