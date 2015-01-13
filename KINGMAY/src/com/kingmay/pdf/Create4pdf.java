package com.kingmay.pdf;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.Age2;
import com.kingmay.beans.Age4;
import com.kingmay.beans.Child;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfLayer;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

public class Create4pdf {
	public String ImagePath =ServletActionContext.getServletContext().getRealPath("image")+"\\";
	public static java.text.DecimalFormat   df=new   java.text.DecimalFormat("#0.00"); 
	public String path = ServletActionContext.getServletContext().getRealPath("pdfFile")+"\\"+"temp";
	public Child c;
	public static String bjjc = "ȫ����";
	
	//set the  color
    //ǳ��
	public static Color Cambridge_blue = new Color(230,242,246);
    //��ɫ
	public static Color Blue = new Color(30,196,250);
    //������ɫ
	public static Color NormalBlue = new Color(30,166,196);
    //Բ��ר����ɫ
    //Color CirBlue = new Color(184,230,240);
	public static Color CirBlue = new Color(44,200,230);
    //��ɫ
	public static Color Deepblue = new Color(125,196,250);
    //��ɫ2
	public static Color Deepblue2 = new Color(0,137,174);
    //��ɫ
	public static Color White = new Color(255,255,255);
    //��ɫ
	public static Color Black = new Color(0,0,0);
    //��ɫ
	public static Color Glod = new Color(230, 203, 100);
    //��ɫ
	public static Color Cambridge_red = new Color(150,5,37);
    
    //red
	public static Color red = new Color(225,0,44);
    //light_red
	public static Color light_red = new Color(254,236,229);
    //weigh_red
	public static Color weigh_red = new Color(248,218,205);
    //red_100
	public static Color red_100 = new Color(223,30,54);
	//drak_red
	public static Color drak_red = new Color(129,5,22);
	
	public synchronized String Create4pdf(Age4 a,Child c){
		if(a.getBjjc()==1){
			bjjc = "����ˮƽ����";
		}else{
			bjjc = "ȫ����";
		}
		this.c = c;
		if( path == "" )
		{
			path = ServletActionContext.getServletContext().getRealPath("pdfFile")+"\\"+"temp";
			
		}
		File dirname = new File(path);   
		if (!dirname.exists())   //Ŀ¼������   
		{   
		  dirname.mkdirs();//����Ŀ¼ 
		}
		
		String time = setlast(new Date());
		String FileName = path+ "/"+c.getCid()+".pdf" ;
//		String FileName = path+ "/test.pdf" ;
		String Name = "/pdfFile/temp/"+c.getCid()+".pdf";
		Document document = new Document(PageSize.A4);
		
		try{
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FileName));

            //��������ľ���
            float gutter = 30;
            //����
            float space_between = 10;
            int numColumns = 2;
            float fullWidth = document.right() - document.left();
            float columnWidth = (fullWidth - (numColumns - 1) * gutter) / numColumns;
            float allColumns[] = new float[numColumns]; // left
            for (int k = 0; k < numColumns; ++k) {
                allColumns[k] = document.left() + (columnWidth + gutter) * k;
            }
	        
	        // set the fonts
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font FontChinese = new Font(bfChinese, 12, Font.BOLD,Color.black);
			Font FontChinese1 = new Font(bfChinese, 8, Font.NORMAL,Color.black);
			Font FontChinese2 = new Font(bfChinese, 24,Font.BOLD,new Color(225,0,44));
			Font FontChinese3 = new Font(bfChinese, 12,Font.BOLD,Color.black);
			
			
            Font SmallFontChinese = new Font(bfChinese, 6, Font.NORMAL);
            Font BestFontChinese = new Font(bfChinese, 8, Font.NORMAL);
            Font BestFontChinese10 = new Font(bfChinese, 10, Font.NORMAL);
            Font BestFontChinese_BOLD = new Font(bfChinese, 8, Font.BOLD);
            Font BlackFontChinese = new Font(bfChinese, 18, Font.BOLD,Black);
            Font BlackLeadFontChinese = new Font(bfChinese, 15);
            Font BlueFontChinese = new Font(bfChinese, 10, Font.BOLD,Black);
            Font BigBlueFontChinese = new Font(bfChinese, 15, Font.BOLD,Deepblue2);
            Font SmallBlueFontChinese = new Font(bfChinese, 5, Font.BOLD,CirBlue);
            Font WhiteFontChinese = new Font(bfChinese, 10, Font.BOLD,White);
            Font WhiteFontChinese8 = new Font(bfChinese, 8, Font.BOLD,White);
            Font JiFenCeFontChinese = new Font(bfChinese, 20, Font.BOLD,White);
            Font ButtomFontChinese = new Font(bfChinese, 6, Font.BOLD);
            Font RedFontChinese = new Font(bfChinese, 8, Font.NORMAL,Black);
            Font BlueCriFontChinese = new Font(bfChinese, 4, Font.BOLD,drak_red);
            Font RedFont = new Font(bfChinese,8,Font.BOLD,red);
            
            Font font24B = FontFactory.getFont(FontFactory.TIMES_ROMAN, 24, Font.BOLD);
            Font font10B = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
            Font font14B = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
            Font font9 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 7);
            Font font11 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11);
            
            document.open();
            document.addAuthor("����������������������޹�˾");
            document.addCreator("����������������������޹�˾(by king-may.com.cn)");
            document.addCreationDate();
            document.addCreator("����������������������޹�˾");
            document.addTitle("Τ���׶���������WPPSI-IV���İ����İ�");
            
            PdfTemplate template = null;//�������ɸ�������������
            
            // step 4:
            // get the stream content`
            PdfContentByte cb = writer.getDirectContent();
            // headers
            Phrase fullTitle = new Phrase("", FontChinese);
            float currentY = document.top();
            float currentX = document.bottom();
            
            ColumnText ct = new ColumnText(cb);
            ct.setSimpleColumn(fullTitle, document.left(), 0, document.right(), document.top(), 24, Element.ALIGN_JUSTIFIED);
            ct.go();
            
            ct.setLeading(10);//�ּ��
            ct.go();//����
            currentY = ct.getYLine();//currenY�������
            
            currentY += 30;
            float topColumn = currentY;
            
          //�̶ȳ�
            if(a.getVci() != -1)
            {
            	CreateRuler(338 -5, 100, 2, 121, cb, Black, red,a.getVcii(),true,ct,FontChinese,writer);
            }else
            {
            	CreateRuler(338 -5, 100, 2, 121, cb, Black, red,0,true,ct,FontChinese,writer);
            }
            if(a.getVsi() != -1 )
            {
            	CreateRuler(332+59 - 20, 100, 2, 121, cb, Black, red,a.getVsii(),false,ct,FontChinese,writer);
            }else
            {
            	CreateRuler(332+59 -20, 100, 2, 121, cb, Black, red,0,false,ct,FontChinese,writer);
            }
            if(a.getFri() != -1 )
            {
            	CreateRuler(332+69+4, 100, 2, 121, cb, Black, red,a.getFrii(),false,ct,FontChinese,writer);
            }else
            {
            	CreateRuler(332+69+4, 100, 2, 121, cb, Black, red,0,false,ct,FontChinese,writer);
            }
            if( a.getWmi() != -1 )
            {
            	CreateRuler(342+100 , 100, 2, 121, cb, Black, red,a.getWmii(),false,ct,FontChinese,writer);
            }else
            {
            	CreateRuler(342+100 , 100, 2, 121, cb, Black, red,0,false,ct,FontChinese,writer);
            }
            if(a.getPsi() != -1 )
            {
            	CreateRuler(342+135 , 100, 2, 121, cb, Black, red,a.getPsii(),false,ct,FontChinese,writer);
            }else
            {
            	CreateRuler(342+135, 100, 2, 121, cb, Black, red,0,false,ct,FontChinese,writer);
            }
            if( a.getFsiq() != -1 )
            {
            	CreateRuler(342+165+7 , 100, 2, 121, cb, Black, weigh_red,a.getFsiqi(),false,ct,FontChinese,writer);
            }else
            {
            	CreateRuler(342+165+7, 100, 2, 121, cb, Black, weigh_red,0,false,ct,FontChinese,writer);
            }
            cb.stroke();
            
            
            //logo ���
            PdfPTable Logo = CreateLogo(BlueFontChinese,150,Deepblue2);
            currentY = Logo.writeSelectedRows(0, -1, document.left(), currentY-18, cb);
            
            //Title ���
            PdfPTable JiHui = CreateTitle(FontChinese,FontChinese2,FontChinese3,200,Color.black);
            JiHui.writeSelectedRows(0, -1, (document.left()+document.right())/2-100, document.top()+23, cb);
            
            //��ͯ����������������
            PdfPTable aTable1 = CreateTableChildInfo(BestFontChinese,BestFontChinese10,150,Cambridge_blue,15,a,c);
            currentY = aTable1.writeSelectedRows(0, -1, document.left(), currentY, cb)-space_between-10;
            
            //��ͯ�����
            PdfPTable ChildAge = CreateTime(FontChinese1, WhiteFontChinese, 160, light_red, 15,c);
	        ChildAge.writeSelectedRows(0, -1, (document.left()+document.right())/2+120, document.top(), cb);
            
	        //ԭʼ�������������ת����
	        PdfPTable Yuan = CreateYuan(BestFontChinese,BlueFontChinese,WhiteFontChinese8,RedFont,columnWidth,White,light_red,a,SmallFontChinese,cb,writer);
	        currentY = Yuan.writeSelectedRows(0, -1, document.left(), currentY, cb)-space_between - 50;
	        
	        //��������ܺ���ϳɷ���ת����
	        PdfPTable HeCheng = CreateHeCheng(BestFontChinese,BlueFontChinese,SmallFontChinese,columnWidth,light_red,15,a,cb,writer);
	        currentY = HeCheng.writeSelectedRows(0, -1,  document.left(), currentY + 30, cb) -space_between - 50;
	        
	        //����logo
	        PdfPTable ButtomLogo = CreateButtomLogo(ButtomFontChinese,font9, columnWidth+20, White);
	        currentY = ButtomLogo.writeSelectedRows(0, -1, document.left(), currentY-10, cb)-space_between-10;
	        
	        //�ұ߱�
	        //�ֲ��������������ͼ
	        PdfPTable FeiPo = CreateFenPo(BestFontChinese,BlueFontChinese,BlueCriFontChinese,RedFontChinese,columnWidth,White,light_red,a);
	        currentY = FeiPo.writeSelectedRows(0, -1, 320, document.top()-90, cb)-space_between;
	        
	        //�ϳɷ�������ͼ
	        PdfPTable Fei = CreateFen(BestFontChinese,BlueFontChinese,columnWidth-30,White,a,
					bfChinese, cb, template, Black);
	        currentY = Fei.writeSelectedRows(0, -1, 320+20, document.top()-415-13, cb)-space_between;
	        
	        
	        //�α���ֵ
	        CreateRulerNumber(100,100,100,cb,writer);
	        CreateFloatText(cb, template, bfChinese,"�� 1 ҳ", 100,-160,4,Black);
	        
	        //��һҳ���ڶ�ҳ
            document.newPage();
            float currentY_Page2 = document.top();
            
            //ָ��ˮƽ ǿ�����
            PdfPTable Zhi3 = CreateZszf5(BestFontChinese,WhiteFontChinese,SmallFontChinese,WhiteFontChinese8,BlackFontChinese,fullWidth,red,weigh_red,a);
            currentY_Page2 = Zhi3.writeSelectedRows(0, -1, document.left(), currentY_Page2, cb)-space_between;
            
            //�ֲ���ˮƽ ǿ�����
            PdfPTable Fen6 = CreateZszf10(BestFontChinese,WhiteFontChinese,SmallFontChinese,WhiteFontChinese8,BlackFontChinese,fullWidth,red,weigh_red,a);
            currentY_Page2 = Fen6.writeSelectedRows(0, -1, document.left(), currentY_Page2, cb)-space_between;
            
            CreateFloatText(cb, template, bfChinese,"�� 2 ҳ", 100,-160,4,Black);
            
            
            //��һҳ������ҳ
            document.newPage();
            float currentY_Page3 = document.top();
            
            PdfPTable Xu = CreateXu(BlackFontChinese,fullWidth);
            currentY_Page3 = Xu.writeSelectedRows(0, -1, document.left(), currentY_Page3, cb) - space_between;
            
            //�ֲ���ˮƽ ǿ����� 6��
            PdfPTable Fen5 = CreateZszf6(BestFontChinese,WhiteFontChinese,SmallFontChinese,WhiteFontChinese8,BlackFontChinese,fullWidth,red,weigh_red,a);
            currentY_Page3 = Fen5.writeSelectedRows(0, -1, document.left(), currentY_Page3, cb)-space_between;
            
            //����Ƚϱ�
            PdfPTable Cha = CreateCha(BestFontChinese,WhiteFontChinese,SmallFontChinese,WhiteFontChinese8,BlackFontChinese,fullWidth,red,weigh_red,a);
            currentY_Page3 = Cha.writeSelectedRows(0, -1, document.left(), currentY_Page3, cb)-space_between;
            
            CreateFloatText(cb, template, bfChinese,"�� 3 ҳ", 100,-160,4,Black);
            
            //��һҳ������ҳ
            document.newPage();
            float currentY_Page4 = document.top();
            PdfPTable Fuzhu = CreateFuzhu(BlackFontChinese,fullWidth);
            currentY_Page4 = Fuzhu.writeSelectedRows(0, -1, document.left(), currentY_Page4, cb)-space_between;
            
            //����ԭʼ��
            PdfPTable YuanFu = CreateYuanFu(BestFontChinese,BlueFontChinese,columnWidth,White,light_red,a,SmallFontChinese,cb,writer);
            currentY_Page4 = YuanFu.writeSelectedRows(0, -1, document.left(), currentY_Page4, cb)-space_between - 50;
            
            //����ҳ�ɼ�
            PdfPTable HeChengFU = CreateHeChengFu(BestFontChinese,BlueFontChinese,SmallFontChinese,columnWidth,light_red,15,a,cb,writer);
            currentY_Page4 = HeChengFU.writeSelectedRows(0, -1,  document.left(), currentY_Page4 + 30, cb) -space_between - 50;
            
            //���������
            PdfPTable ChaFU = CreateChaFu(BestFontChinese,WhiteFontChinese,SmallFontChinese,WhiteFontChinese8,BlackFontChinese,fullWidth,red,weigh_red,a);
            currentY_Page4 = ChaFU.writeSelectedRows(0, -1, document.left(), currentY_Page4 +40, cb)-space_between;
            
            //����ָ����������ͼ
            PdfPTable PFu = CreatePage4(BestFontChinese,BlueFontChinese,columnWidth-30,White,a,bfChinese, cb, template, Black);
            float aa = PFu.writeSelectedRows(0, -1, 360,  document.top()-25, cb)-space_between-20;
            
            if(a.getVai() != -1 )
            {
    			CreateRuler_Page4(363, 500, 2, 121, cb, Black, red,a.getVaii(),true,ct,FontChinese,writer);
            }else
            {
            	CreateRuler_Page4(363, 500, 2, 121, cb, Black, red,0,true,ct,FontChinese,writer);
            }
            if(a.getNvi() != -1)
            {
            	CreateRuler_Page4(365+53, 500, 2, 121, cb, Black, red, a.getNvii() ,false,ct,FontChinese,writer);
            }else
            {
            	CreateRuler_Page4(365+53, 500, 2, 121, cb, Black, red,0,false,ct,FontChinese,writer);
            }
            if( a.getGai() != -1 )
            {
            	CreateRuler_Page4(365+53+53, 500, 2, 121, cb, Black, red, a.getGaii() ,false,ct,FontChinese,writer);
            }else
            {
            	CreateRuler_Page4(365+53+53, 500, 2, 121, cb, Black, red,0,false,ct,FontChinese,writer);
            }
            if( a.getCpi() != -1 )
            {
            	CreateRuler_Page4(365+53+53+53, 500, 2, 121, cb, Black, red, a.getCpii() ,false,ct,FontChinese,writer);
            }else
            {
            	CreateRuler_Page4(365+53+53+53, 500, 2, 121, cb, Black, red,0,false,ct,FontChinese,writer);
            }
          
            CreateRulerNumber_Page4(100, 100, 100 ,cb,writer);
            
            
            CreateFloatText(cb, template, bfChinese,"�� 4 ҳ", 100,-160,4,Black);
            
            document.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return Name;
	}
	
	
	
	
	
	public PdfPTable CreateLogo(Font FontChinese,float columnWidth,Color color) throws DocumentException, MalformedURLException, IOException
    {
    	PdfPTable aTable = new PdfPTable(1);
        int headerwidths[] = {10};//#################
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	aTable.getDefaultCell().setPadding(3);
//    	Image im = Image.getInstance(ImagePath+"/WPPSI-IV���İ� LOGO.png");
    	Image im = Image.getInstance(ImagePath+"/logo.png");

		//im.setRotationDegrees(30);//��б30��
		PdfPCell cell = new PdfPCell(im, true);
		cell.setBorderWidth(0);
		aTable.addCell(cell);
		
//		PdfPCell cell2 = new PdfPCell(new Phrase("Τ���׶���������-���İ棨���İ棩",FontChinese));
//		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell2.setBorderWidth(0);
//		aTable.addCell(cell2);
//		aTable.setTotalWidth(columnWidth);
		aTable.setTotalWidth(columnWidth);
		return aTable;
    }
	
	public PdfPTable CreateTitle(Font FontChinese1,Font FontChinese2,Font FontChinese3,float columnWidth,Color color) throws DocumentException, MalformedURLException, IOException
    {
    	
    	PdfPTable aTable = new PdfPTable(1);
    	int headerwidths[] = {10};
    	aTable.setWidths(headerwidths);
    	aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell cell = new PdfPCell(new Phrase("Τ���׶���������-���İ����İ�",FontChinese1));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(10);
		cell.setBorderWidth(0);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("�Ƿֲ�.����ҳ",FontChinese2));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0);
		cell.setPadding(10);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("��������    4:0~6:11",FontChinese3));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0);
		cell.setPadding(10);
		aTable.addCell(cell);
    	
    	aTable.setTotalWidth(columnWidth);
		return aTable;
    }
	
	/**��ͯ����
     * */
    public static PdfPTable CreateTableChildInfo(Font FontChinese,Font HeadFont,float columnWidth,Color bgColor,float Height,Age4 a, Child c) throws DocumentException
    {
    	PdfPTable table1 = new PdfPTable(2);
        table1.getDefaultCell().setPadding(3);
        int headerwidths[] = {25,40};
        table1.setWidths(headerwidths);
        PdfPCell table1_cell = new PdfPCell();
        table1_cell.setBorderWidthLeft(0);
        table1_cell.setBorderWidthTop(0);
        table1_cell.setBorder(0);
        table1_cell.setBorderWidthBottom(0.8f);
        table1_cell = new PdfPCell(new Phrase("��������:",FontChinese)); 
        table1_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1_cell.setBorder(0);
        table1_cell.setBorderWidthBottom(0.8f);
        table1_cell.setBorderColor(red);
        table1.addCell(table1_cell);
        
        table1_cell = new PdfPCell(new Phrase(""+c.getCtestname(), HeadFont));
        table1_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table1_cell.setBorder(0);
        table1_cell.setBorderWidthBottom(0.8f);
        table1_cell.setBorderColor(red);
        table1_cell.setPaddingLeft(5);
        table1.addCell(table1_cell);
        
        table1_cell = new PdfPCell(new Phrase("��ͯ����:",FontChinese));
        table1_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1_cell.setBorder(0);
        table1_cell.setBorderWidthBottom(0.8f);
        table1_cell.setBorderColor(red);
        table1.addCell(table1_cell);
        
        table1_cell = new PdfPCell(new Phrase(""+c.getCname(), HeadFont));
        table1_cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table1_cell.setBorder(0);
        table1_cell.setBorderWidthBottom(0.8f);
        table1_cell.setPaddingLeft(5);
        table1_cell.setBorderColor(red);
        table1.addCell(table1_cell);
        
//        table1_cell = new PdfPCell(new Phrase("��ͯ����:",FontChinese));
//        table1_cell.setBorder(0);
//        table1_cell.setBorderWidthBottom(0.8f);
//        table1_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table1.addCell(table1_cell);
//        
//        table1_cell = new PdfPCell(new Phrase(a.getCid(), FontChinese));
//        table1_cell.setBorder(0);
//        table1_cell.setBorderWidthBottom(0.8f);
//        table1.addCell(table1_cell);
        
        table1.setTotalWidth(columnWidth);
        return table1;
    	
    }
    
    /**
     * ��ͯ����
     * @param FontChinese
     * @param columnWidth
     * @param color
     * @return
     * @throws DocumentException
     */
    public static PdfPTable CreateTime(Font FontChinese,Font HeadFont,float columnWidth,Color color,float Height,Child c) throws DocumentException
    {
    	PdfPTable aTable = new PdfPTable(4);
//    	aTable.getDefaultCell().setFixedHeight(Height);
    	String $results[] = {String.valueOf(c.getCtyear()),String.valueOf(c.getCtmonth()),String.valueOf(c.getCtday()),String.valueOf(c.getCbyear()),String.valueOf(c.getCbmonth()),String.valueOf(c.getCbday())};
        int headerwidths[] = {24, 24, 24, 24};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	aTable.getDefaultCell().setPadding(5);
    	
        PdfPCell cell = null;
    	
        cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�����ͯ����",HeadFont)); 
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//    	cell.setFixedHeight(Height);
    	cell.setColspan(3);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("��",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//    	cell.setFixedHeight(Height);
    	cell.setBackgroundColor(weigh_red);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("��",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//    	cell.setFixedHeight(Height);
    	cell.setBackgroundColor(weigh_red);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("��",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//    	cell.setFixedHeight(Height);
    	cell.setBackgroundColor(weigh_red);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("��������",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//    	cell.setFixedHeight(Height);
    	cell.setBorder(0);
    	cell.setBorderWidthBottom(0.8f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	for(int i=1;i<4 ; i++)
    	{
    		if($results[i-1].equals("-"))
    		{
    			$results[i-1]="-";
    		}
//    		cell.setFixedHeight(Height);
    		cell = new PdfPCell(new Phrase($results[i-1],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setBackgroundColor(light_red);
        	cell.setBorderColor(red);
    		aTable.addCell(cell);
//    		aTable.addCell(new Phrase($results[i-1],FontChinese));
    	}
    	
    	cell = new PdfPCell(new Phrase("��������",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//    	cell.setFixedHeight(Height);
    	cell.setBorder(0);
    	cell.setBorderWidthBottom(0.8f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	for(int i=1;i<4 ; i++)
    	{
    		if($results[i+2].equals("-"))
    		{
    			$results[i+2]="-";
    		}
//    		cell.setFixedHeight(Height);
    		cell = new PdfPCell(new Phrase($results[i+2],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setBackgroundColor(light_red);
        	cell.setBorderColor(red);
    		aTable.addCell(cell);
//    		aTable.addCell(new Phrase($results[i+2],FontChinese));
    	}

    	cell = new PdfPCell(new Phrase("ʵ������",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//    	cell.setFixedHeight(Height);
    	cell.setBorder(0);
    	cell.setBorderWidthBottom(0.8f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase(""+c.getCyear(),FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(light_red);
    	cell.setBorderColor(red);
//    	cell.setFixedHeight(Height);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase(""+c.getCmonth(),FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(light_red);
    	cell.setBorderColor(red);
//    	cell.setFixedHeight(Height);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase(""+c.getCday(),FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(light_red);
    	cell.setBorderColor(red);
//    	cell.setFixedHeight(Height);
    	aTable.addCell(cell);
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    /**
     * ����ԭʼ�������������ת������
     * @param FontChinese
     * @param columnWidth
     * @param white
     * @return
     * @throws DocumentException
     * @throws IOException 
     */
    public static PdfPTable CreateYuan(Font FontChinese,Font HeadFont,Font WhiteFont,Font RedFont,float columnWidth,Color white,Color LastColor,Age4 a,Font SmallFont,PdfContentByte cb, PdfWriter writer) throws DocumentException, IOException
    {
   		PdfPTable aTable3 = new PdfPTable(10);
   		int headerwidths[] = {11, 6, 7, 7, 7, 7, 7, 7 ,7 ,7};
   		String $item_name[] = {"��ľ","��ʶ","��������","�ҳ�","ͼƬ����","��ͬ","ͼ������","����","�����԰","ƴͼ","��������","ָ��ͼƬ","ͼƬ����","�������","������"};
   		String $item_name1[] = {"BD","IN","MR","BS","PM","SI","PC","CA","ZL","OA","AC","RV","PN","CAR","CAS"};
   		int $results[] = {a.getBd(),a.getInf(),a.getMr(),a.getBs(),a.getPm(),a.getSi(),a.getPc(),a.getCa(),a.getZl(),a.getOa(),a.getAc(),a.getRv(),a.getPn(),a.getCar(),a.getCas()};
   		int $result_tally[] = {a.getBdl(),a.getInfl(),a.getMrl(),a.getBsl(),a.getPml(),a.getSil(),a.getPcl(),a.getCal(),a.getZll(),a.getOal(),a.getAcl(),a.getRvl(),a.getPnl(),a.getCarl(),a.getCasl()};
   		
   		aTable3.setWidths(headerwidths);
   		aTable3.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
   		aTable3.getDefaultCell().setPadding(3);
   		
   		BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font RedFontChinese = new Font(b_f, 7, Font.NORMAL,red);
    	Font WhiteFontChinese = new Font(b_f, 7 ,Font.BOLD,White);
    	Font BoldFont1 = new Font(b_f, 6 , Font.BOLD,Black);
   		
   		PdfPCell cell = null;
   		
   		cell = new PdfPCell(new Phrase("ԭʼ�������������ת����",HeadFont));
   		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
   		cell.setBorderWidth(0);
   		cell.setColspan(10);
   		cell.setFixedHeight(20);
   		aTable3.addCell(cell);
   		
   		cell = new PdfPCell(new Phrase("�ֲ���",WhiteFont));
   		cell.setFixedHeight(25);
   		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
   		cell.setColspan(2);
   		cell.setPaddingTop(7);
   		cell.setBorderColor(White);
   		cell.setBackgroundColor(red);
    	aTable3.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("ԭʼ\n����",WhiteFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setFixedHeight(25);
    	cell.setBorderColor(White);
   		cell.setBackgroundColor(red);
    	aTable3.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�������",WhiteFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(7);  //ռ3������
    	cell.setFixedHeight(25);
    	cell.setPaddingTop(7);
    	cell.setBorderColor(White);
   		cell.setBackgroundColor(red);
    	aTable3.addCell(cell);
    	
    	//���ר��
    	PdfPCell blue_cell = new PdfPCell();
    	blue_cell.setBackgroundColor(red);
    	blue_cell.setBorderColor(Color.white);
    	blue_cell.setFixedHeight(20);
    	
    	PdfPCell white_cell = new PdfPCell(new Phrase("��Ч",FontChinese));
    	white_cell.setBackgroundColor(Color.white);
    	white_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	white_cell.setFixedHeight(20);
    	white_cell.setBorderWidth(0);
    	
    	PdfPCell wu = new PdfPCell(new Phrase("-",FontChinese));
    	wu.setHorizontalAlignment(Element.ALIGN_CENTER);
    	wu.setBackgroundColor(Color.white);
    	wu.setFixedHeight(20);
    	
    	for (int i = 1; i < 17; i++) 
    	{
    		if(i<=15){
    			//������
    			cell = new PdfPCell(new Phrase($item_name[i-1],BoldFont1));
    			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    			cell.setPaddingLeft(10);
    			//cell.setPaddingTop(5);
    			cell.setFixedHeight(15);
    			cell.setBorderWidth(0.7f);
    			cell.setBorderWidthLeft(0);
    	    	cell.setBorderWidthRight(0);
    	    	cell.setFixedHeight(20);
    	    	cell.setBorderColor(red);
    			aTable3.addCell(cell);
    			
    			//��Ӣ������
    			cell = new PdfPCell(new Phrase($item_name1[i-1],BoldFont1));
    			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    			//cell.setPaddingTop(5);
    			cell.setFixedHeight(15);
    			cell.setBorderWidth(0.7f);
    			cell.setBorderWidthLeft(0);
    			cell.setFixedHeight(20);
    			cell.setBorderColor(red);
    			aTable3.addCell(cell);
    			
    			//��ԭʼ��
    			if($results[i-1] != -1){
    				cell = new PdfPCell(new Phrase(String.valueOf($results[i-1]),FontChinese));
        			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        			cell.setBorderColor(red);
        			cell.setFixedHeight(15);
    				aTable3.addCell(cell);
    			}else{
    				aTable3.addCell(white_cell);
    			}
    			
    			if($item_name[i-1] == "��ʶ" || $item_name[i-1] == "��ͬ")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//���������
    					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    					cell.setBackgroundColor(white);
    					cell.setBorderWidth(0);
    					cell.setBorderColor(Color.white);
    					cell.setFixedHeight(20);
    					aTable3.addCell(cell);
    				}else{
    					aTable3.addCell(wu);
    				}
    			}else{
    				aTable3.addCell(blue_cell);
    			}
    			//    		�ڶ���
    			if($item_name[i-1] == "��ľ" || $item_name[i-1] == "ƴͼ")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//���������
    					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    					cell.setBackgroundColor(white);
    					cell.setBorderColor(Color.white);
    					cell.setBorderWidth(0);
    					cell.setFixedHeight(20);
    					aTable3.addCell(cell);
    				}else{
    					aTable3.addCell(wu);
    				}
    			}else{		
    				aTable3.addCell(blue_cell);
    			}
    			//������
    			if($item_name[i-1] == "ͼ������" || $item_name[i-1] == "��������")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//���������
    					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    					cell.setBackgroundColor(white);
    					cell.setBorderColor(Color.white);
    					cell.setBorderWidth(0);
    					cell.setFixedHeight(20);
    					aTable3.addCell(cell);
    				}else{
    					aTable3.addCell(wu);
    				}
    			}else{
    				aTable3.addCell(blue_cell);
    			}
    			
    			
    			//������
    			if($item_name[i-1] == "ͼƬ����" || $item_name[i-1] == "�����԰")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//���������
    					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    					cell.setBackgroundColor(white);
    					cell.setBorderColor(Color.white);
    					cell.setBorderWidth(0);
    					cell.setFixedHeight(20);
    					aTable3.addCell(cell);
    				}else{
    					aTable3.addCell(wu);
    				}
    			}else{
    				aTable3.addCell(blue_cell);
    			}
    			
    			//������
    			if($item_name[i-1] == "�ҳ�" || $item_name[i-1] == "����")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//���������
    					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    					cell.setBackgroundColor(white);
    					cell.setBorderColor(Color.white);
    					cell.setBorderWidth(0);
    					cell.setFixedHeight(20);
    					aTable3.addCell(cell);
    				}else{
    					aTable3.addCell(wu);
    				}
    			}else{
    				aTable3.addCell(blue_cell);
    			}
    			
    			//������
    			if($item_name[i-1] == "��ľ" || $item_name[i-1] == "��ʶ" || $item_name[i-1] == "��������" || $item_name[i-1] == "�ҳ�" || $item_name[i-1] == "ͼƬ����" || $item_name[i-1] == "��ͬ" 
    				|| $item_name[i-1] == "ͼ������" || $item_name[i-1] == "����" || $item_name[i-1] == "�����԰" || $item_name[i-1] == "ƴͼ"|| $item_name[i-1] == "��������"  )
    			{
    				if($results[i-1] != -1){
    					if($item_name[i-1] == "ͼ������" || $item_name[i-1] == "����" || $item_name[i-1] == "�����԰" || $item_name[i-1] == "ƴͼ"|| $item_name[i-1] == "��������"){
    						cell = new PdfPCell(new Phrase("("+$result_tally[i-1]+")",FontChinese));//���������
    					}else{
    						cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//���������
    					}
    					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    					cell.setBackgroundColor(white);
    					cell.setBorderColor(Color.white);
    					cell.setBorderWidth(0);
    					cell.setFixedHeight(20);
    					aTable3.addCell(cell);
    				}else{
    					aTable3.addCell(wu);
    				}
    			}else{
    				aTable3.addCell(blue_cell);
    			}
    			
    			//���һ��
    			//������
    			if($item_name[i-1] == "ָ��ͼƬ" || $item_name[i-1] == "ͼƬ����" || $item_name[i-1] == "�������" || $item_name[i-1] == "������")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//���������
    					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    					cell.setBackgroundColor(white);
    					cell.setBorderColor(red);
    					cell.setBorderWidth(0);
    					cell.setFixedHeight(20);
    					aTable3.addCell(cell);
    				}else{
    					aTable3.addCell(wu);
    				}
    			}else{
    				aTable3.addCell(blue_cell);
    			}
    		}
            
            //���һ��
            if(i==16)
            {
            	cell = new PdfPCell(new Phrase("��������ܺ�:  ",RedFont));
            	cell.setColspan(3);
            	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            	cell.setBorderWidth(0);
	            aTable3.addCell(cell);

	            //20090530���*������ע��
	            int vci = a.getVci();
	            int vsi = a.getVsi();
	            int fri = a.getFri();
	            int wmi = a.getWmi();
	            int psi = a.getPsi();
	            int fsiq = a.getFsiq();
	            
	            if(vci != -1){
	            	cell = new PdfPCell(new Phrase(""+vci,FontChinese));
	            	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            	cell.setBackgroundColor(LastColor);
	            	cell.setFixedHeight(20);
	            	cell.setBorder(0);
	            	aTable3.addCell(cell);
	            }else{
	            	aTable3.addCell(white_cell);
	            }
	            
	            if(vsi != -1){
		            cell = new PdfPCell(new Phrase(""+vsi,FontChinese));
		            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            cell.setBackgroundColor(LastColor);
		            cell.setFixedHeight(20);
		            cell.setBorder(0);
		            aTable3.addCell(cell);
	            }else{
	            	aTable3.addCell(white_cell);
	            }
	            
	            if(fri != -1){
		            cell = new PdfPCell(new Phrase(""+fri,FontChinese));
		            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            cell.setBackgroundColor(LastColor);
		            cell.setFixedHeight(20);
		            cell.setBorder(0);
		            aTable3.addCell(cell);
	            }else{
	            	aTable3.addCell(white_cell);
	            }
	            
	            if(wmi != -1){
		            cell = new PdfPCell(new Phrase(""+wmi,FontChinese));
		            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            cell.setBackgroundColor(LastColor);
		            cell.setFixedHeight(20);
		            cell.setBorder(0);
		            aTable3.addCell(cell);
	            }else{
	            	aTable3.addCell(white_cell);
	            }
	            
	            if(psi != -1){
		            cell = new PdfPCell(new Phrase(""+psi,FontChinese));
		            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            cell.setBackgroundColor(LastColor);
		            cell.setFixedHeight(20);
		            cell.setBorder(0);
		            aTable3.addCell(cell);
	            }else{
	            	aTable3.addCell(white_cell);
	            }
	            
	            if(fsiq != -1){
		            cell = new PdfPCell(new Phrase(""+fsiq,FontChinese));
		            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            cell.setBackgroundColor(LastColor);
		            cell.setFixedHeight(20);
		            cell.setBorder(0);
		            aTable3.addCell(cell);
	            }else{
	            	aTable3.addCell(white_cell);
	            }
	            cell = new PdfPCell();
	    	   	cell.setBorderWidth(0);
	    	   	cell.setFixedHeight(20);
	    	   	aTable3.addCell(cell);
            }
    	}
    		
	   	cell = new PdfPCell();
	   	cell.setColspan(3);
	   	cell.setBorderWidth(0);
	   	cell.setBorderWidthBottom(0.9f);
	   	cell.setBorderColor(red);
	   	cell.setFixedHeight(20);
	   	aTable3.addCell(cell);
	   	
    	Font SmallFontChinese = new Font(b_f, 7, Font.NORMAL,red);
	   	
	   	cell = new PdfPCell(new Phrase("����\n���",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(1f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
	   	cell = new PdfPCell(new Phrase("�Ӿ�\n�ռ�",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(1f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
	   	cell = new PdfPCell(new Phrase("����\n����",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(1f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
	   	cell = new PdfPCell(new Phrase("����\n����",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(1f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
	   	cell = new PdfPCell(new Phrase("�ӹ�\n�ٶ�",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(1f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
	   	cell = new PdfPCell(new Phrase("ȫ��\n��",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(1f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
		cell = new PdfPCell();
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(1f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
	   	aTable3.setTotalWidth(columnWidth);
	   	return aTable3;
    }
    
    /**
     * ������������ܺ���ϳɷ���ת����
     * @param FontChinese
     * @param columnWidth
     * @param color
     * @return
     * @throws DocumentException
     * @throws IOException 
     */
    public static PdfPTable CreateHeCheng(Font FontChinese,Font HeadFont,Font SmallFont,float columnWidth,Color blackgroundcolor,float Height,Age4 a,PdfContentByte cb, PdfWriter writer) throws DocumentException, IOException
    {
    	int Padding = 3;
    	int vci = a.getVci();
    	int vsi = a.getVsi();
    	int fri = a.getFri();
    	int wmi = a.getWmi();
    	int psi = a.getPsi();
    	int fsiq = a.getFsiq();
    	
    	String $result1[] = {String.valueOf(a.getVci()),String.valueOf(a.getVcii()),a.getVcib(),a.getVciz()};
    	String $result2[] = {String.valueOf(a.getVsi()),String.valueOf(a.getVsii()),a.getVsib(),a.getVsiz()};
    	String $result3[] = {String.valueOf(a.getFri()),String.valueOf(a.getFrii()),a.getFrib(),a.getFriz()};
    	String $result4[] = {String.valueOf(a.getWmi()),String.valueOf(a.getWmii()),a.getWmib(),a.getWmiz()};
    	String $result5[] = {String.valueOf(a.getPsi()),String.valueOf(a.getPsii()),a.getPsib(),a.getPsiz()};
    	String $result6[] = {String.valueOf(a.getFsiq()),String.valueOf(a.getFsiqi()),a.getFsiqb(),a.getFsiqz()};
    	
    	
    	//�����
    	PdfPCell white_cell = new PdfPCell(new Phrase("��Ч",FontChinese));
    	white_cell.setBackgroundColor(Color.white);
    	white_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	white_cell.setFixedHeight(20);
    	white_cell.setBorderColor(red);
    	
    	PdfPCell wu = new PdfPCell(new Phrase(" ",FontChinese));
    	wu.setBorder(0);
    	wu.setHorizontalAlignment(Element.ALIGN_CENTER);
    	wu.setBackgroundColor(Color.white);
    	wu.setFixedHeight(20);
    	
    	BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font WhiteFontChinese = new Font(b_f, 8, Font.BOLD,White);
    	
    	//Color white = new Color(150,5,37).white;
    	PdfPTable aTable = new PdfPTable(5);
    	int[] headerwidths = { 20, 15, 17, 15, 17 };
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	aTable.getDefaultCell().setPadding(Padding);
 
        PdfPCell cell = null;
    	
        cell = new PdfPCell(new Phrase("��������ܺ���ϳɷ���ת����",HeadFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPadding(Padding);
    	cell.setBorderWidth(0);
    	cell.setColspan(5);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("����",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(5);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�������\n�ܺ�",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPadding(Padding);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�ϳɷ���",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(5f);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�ٷ�\n�ȼ�",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(2);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	String z = "";
    	if(a.getSp() == 0){
    		z = "90%";
    	}else{
    		z = "95%";
    	}
    	
    	cell = new PdfPCell(new Phrase("��������\n"+z,WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPadding(Padding);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    		
    		
    	cell = new PdfPCell(new Phrase("�������",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setFixedHeight(20);
    	cell.setBorder(0);
    	cell.setPaddingTop(3);
    	cell.setBackgroundColor(Color.white);
    	aTable.addCell(cell);
    		
    	if(vci != -1){
    		cell = new PdfPCell(new Phrase($result1[0],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBackgroundColor(blackgroundcolor);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase("VCI:  " + $result1[1], FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    		cell.setPaddingTop(4);
    		cell.setPaddingLeft(3);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase("" + $result1[2], FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setPaddingLeft(3);
    		cell.setBorder(0);
    		cell.setBackgroundColor(blackgroundcolor);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase("" + $result1[3], FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setPaddingLeft(3);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    	}else{
    		for(int i = 0 ; i< 4 ; i++ ){
    			aTable.addCell(wu);
    		}
    	}
    	
    	cell = new PdfPCell(new Phrase("�Ӿ��ռ�",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(3);
    	cell.setFixedHeight(20);
        cell.setBorder(0);
    	aTable.addCell(cell);
    		
    	if(vsi != -1){
    		cell = new PdfPCell(new Phrase($result2[0],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBackgroundColor(blackgroundcolor);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase("VSI:  " + $result2[1], FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    		cell.setPaddingTop(4);
    		cell.setPaddingLeft(3);
    		cell.setBorder(0);
    		aTable.addCell(cell);

    		cell = new PdfPCell(new Phrase($result2[2],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		cell.setBackgroundColor(blackgroundcolor);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result2[3],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    	}else{
    		for(int i = 0 ; i< 4 ; i++ ){
    			aTable.addCell(wu);
    		}
    	}
    	
   		cell = new PdfPCell(new Phrase("��������",FontChinese));
   		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
   		cell.setPaddingTop(4);
   		cell.setFixedHeight(20);
       	cell.setBorder(0);
   		aTable.addCell(cell);
   		
   		if(fri != -1){
    		cell = new PdfPCell(new Phrase($result3[0],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		cell.setBackgroundColor(blackgroundcolor);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase("FRI:  " + $result3[1], FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    		cell.setPaddingTop(4);
    		cell.setPaddingLeft(3);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result3[2],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		cell.setBackgroundColor(blackgroundcolor);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result3[3],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    	}else{
    		for(int i = 0 ; i< 4 ; i++ ){
    			aTable.addCell(wu);
    		}
    	}
    	
    	
    	cell = new PdfPCell(new Phrase("��������",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(3);
    	cell.setFixedHeight(20);
        cell.setBorder(0);
    	aTable.addCell(cell);
    	
    	if(wmi != -1){	
    		cell = new PdfPCell(new Phrase($result4[0],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBackgroundColor(blackgroundcolor);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase("WMI:  " + $result4[1], FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    		cell.setPaddingTop(4);
    		cell.setPaddingLeft(3);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result4[2],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBackgroundColor(blackgroundcolor);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result4[3],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    	}else{
    		for(int i = 0 ; i< 4 ; i++ ){
    			aTable.addCell(wu);
    		}
    	}
    	
    	cell = new PdfPCell(new Phrase("�ӹ��ٶ�",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(3);
    	cell.setFixedHeight(20);
        cell.setBorder(0);
    	aTable.addCell(cell);
    	
    	if(psi != -1){	
    		cell = new PdfPCell(new Phrase($result5[0],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBackgroundColor(blackgroundcolor);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase("PSI:  " + $result5[1], FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    		cell.setPaddingTop(4);
    		cell.setPaddingLeft(3);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result5[2],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBackgroundColor(blackgroundcolor);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result5[3],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    	}else{
    		for(int i = 0 ; i< 4 ; i++ ){
    			aTable.addCell(wu);
    		}
    	}
    	
    	cell = new PdfPCell(new Phrase("ȫ����",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(3);
    	cell.setFixedHeight(20);
        cell.setBorder(0);
        cell.setBorderWidthBottom(1f);
        cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	if(fsiq != -1){	
    		cell = new PdfPCell(new Phrase($result6[0],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
    		cell.setBackgroundColor(blackgroundcolor);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase("FSIQ:  " + $result6[1], FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    		cell.setPaddingTop(4);
    		cell.setPaddingLeft(3);
    		cell.setBorder(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result6[2],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		cell.setBackgroundColor(blackgroundcolor);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result6[3],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
    		aTable.addCell(cell);
    		
    	}else{
    		for(int i = 0 ; i< 4 ; i++ ){
//    			wu.setBackgroundColor(blackgroundcolor);
    			wu.setBorder(0);
    			wu.setBorderWidthBottom(1f);
    	        wu.setBorderColor(red);
    			aTable.addCell(wu);
    		}
    	}
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    public static PdfPTable CreateBei(int columnWidth , Font HeadFont) throws DocumentException{
    	PdfPTable aTable =  new PdfPTable(1);
    	int[] headerwidths = {10};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        
        PdfPCell cell = new PdfPCell(new Phrase("��ע��",HeadFont));
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	cell.setBorderWidth(1.2f);
    	cell.setColspan(1);
    	cell.setFixedHeight(150);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	aTable.setTotalWidth(columnWidth);    	
		return aTable;
    }
	
    /**
     * ��ҳ�·���˾LOGO
     * @param FontChinese
     * @param columnWidth
     * @param color
     * @return
     * @throws DocumentException
     * @throws IOException 
     * @throws MalformedURLException 
     */
    public PdfPTable CreateButtomLogo(Font FontChinese,Font EnFont , float columnWidth,Color color) throws DocumentException, MalformedURLException, IOException
    {
    	PdfPTable aTable = new PdfPTable(2);
    	aTable.getDefaultCell().setBorderWidth(0);
    	PdfPCell cell = null;
    	int headerwidths[] = {40, 60};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	
    	Image img1 = Image.getInstance(ImagePath+"buttom1.png");
    	aTable.addCell(img1);
    	cell = new PdfPCell(new Phrase("WPPSI-IV���İ澭NCS Pearson, Inc. ��Ȩ���ɾ���������������������޹�˾���룬�ı��ӡ�ơ���Ȩ���У�����ؾ���",FontChinese));
    	cell.setIndent(2);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	Image img2 = Image.getInstance(ImagePath+"buttom2.png");
    	aTable.addCell(img2);
    	cell = new PdfPCell(new Phrase(" ",FontChinese));
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    /**
     * ���ɷֲ��������������ͼ
     * @param FontChinese
     * @param columnWidth
     * @param color
     * @return
     * @throws DocumentException
     * @throws IOException 
     */
    public static PdfPTable CreateFenPo(Font FontChinese,Font LeadingFont,Font BlueFontChinese,Font valueFont,float columnWidth,Color color,Color bgcolor,Age4 a) throws DocumentException, IOException
    {
    	PdfPTable aTable = new PdfPTable(12);
        int headerwidths[] = {7, 9, 9, 9, 9, 9, 9, 9 ,9 ,9 ,9 ,9};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	//aTable.getDefaultCell().setPadding(3);
    	
    	String $item_name[] = {"IN","SI","BD","OA","MR","PC","PM","ZL","BS","CA","AC"};
        int $results[] = {a.getInfl(),a.getSil(),a.getBdl(),a.getOal(),a.getMrl(),a.getPcl(),a.getPml(),a.getZll(),a.getBsl(),a.getCal(),a.getAcl()}; 
        int $results0[] = {a.getInf(),a.getSi(),a.getBd(),a.getOa(),a.getMr(),a.getPc(),a.getPm(),a.getZl(),a.getBs(),a.getCa(),a.getAc()}; 
    	PdfPCell cell = null;
    	
    	cell = new PdfPCell(new Phrase("�ֲ��������������ͼ",LeadingFont));
    	cell.setBorderWidth(0);
    	cell.setColspan(12);
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	aTable.addCell(cell);
    	
    	//	    	�հ�
    	cell = new PdfPCell();
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font WhiteFontChinese = new Font(b_f, 8, Font.BOLD,White);
    	
    	cell = new PdfPCell(new Phrase("�������",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(2);
    	cell.setBorder(0);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�Ӿ��ռ�",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(2);
    	cell.setBorder(0);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("��������",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(2);
    	cell.setBorder(0);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("��������",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(2);
    	cell.setBorder(0);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�ӹ��ٶ�",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(3);
    	cell.setBorder(0);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	//	    	�հ�
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	PdfPCell wu = new PdfPCell(new Phrase("��Ч",FontChinese));
    	wu.setHorizontalAlignment(Element.ALIGN_CENTER);
    	wu.setBorderColor(red);
    	wu.setBackgroundColor(Color.white);
    	
    	for(int i=0 ; i<$item_name.length ; i++)
    	{
    		cell = new PdfPCell(new Phrase($item_name[i],FontChinese));
        	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        	cell.setBorderColor(red);
        	aTable.addCell(cell);
    	}
    	//	    	�հ�
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	for(int i=0 ; i<$results0.length ; i++)
    	{
    		if($results0[i] != -1){
    			cell = new PdfPCell(new Phrase(String.valueOf($results[i]) ,FontChinese));
    			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    			cell.setBorderColor(red);
    			aTable.addCell(cell);
    		}else{
    	    	aTable.addCell(wu);
    		}
    	}
    	
    	int tmp=0;
    	for(int i=19,k=0; i>=1 ; i--)
    	{	
	    	cell = new PdfPCell(new Phrase(""+i,FontChinese));
	    	
	    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	cell.setBorderWidth(0);
	    	if(i==10)
	    	{
	    		cell.setBackgroundColor(weigh_red);
	    	}
	    	aTable.addCell(cell);
	    	
    		for(int j=11 ; j>0; j--)
    		{
    			try
    			{
    				tmp = $results[k];
    			}catch(Exception e)
    			{
    				tmp = 0;
    			}
				if(tmp==i)
				{
					cell = new PdfPCell(new Phrase("��",valueFont));//�������
					cell.setBorderWidth(0);
				}
    			else
    			{
    				cell = new PdfPCell(new Phrase("��",BlueFontChinese));
	    			cell.setBorderWidth(0);
    			}
    			
				if(j==1 || j==4 || j==6 || j==8 || j==10)
				{
					cell.setBorderWidthRight(0.1f);
					cell.setBorderColor(red);
				}
    			if(i==10)
    			{
    				cell.setBackgroundColor(weigh_red);
    			}
    			else if(i==1)
    			{
    				cell.setBorderWidthBottom(0.9f);
    				cell.setBorderColor(red);
    			}
    			//cell.setPadding(4);
    			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    			aTable.addCell(cell);
    			k++;
    		}
    		k=0;
    	}
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    /**
     * ���ɺϳɷ�������ͼ
     * @param FontChinese
     * @param columnWidth
     * @param color
     * @return
     * @throws DocumentException
     * @throws IOException 
     */
    public static PdfPTable CreateFen(Font FontChinese,Font LeadingFont,float columnWidth,Color color,Age4 a
    		, BaseFont bfChinese, PdfContentByte cb, PdfTemplate template, Color Black //2011-03-18
    ) throws DocumentException, IOException
    {
    	PdfPTable aTable = new PdfPTable(6);
        int headerwidths[] = {10, 10, 10, 10, 10, 10};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	//aTable.getDefaultCell().setPadding(3);
    	
    	String $item_name[] = {"�������", "�Ӿ��ռ�","֪������",	"��������", "�ӹ��ٶ�" ,"������"};
    	int $results0[] = {a.getVci(),a.getVsi(),a.getFri(),a.getWmi(),a.getPsi(),a.getFsiq()};
    	int $results[] = {a.getVcii(),a.getVsii(),a.getFrii(),a.getWmii(),a.getPsii(),a.getFsiqi()};
    	
    	PdfPCell cell = null;
    	
    	cell = new PdfPCell(new Phrase("�ϳɷ�������ͼ",LeadingFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setColspan(6);
    	aTable.addCell(cell);
    	
    	PdfPCell white_cell = new PdfPCell(new Phrase("��Ч",FontChinese));
    	white_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	
    	BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font WhiteFontChinese = new Font(b_f, 8, Font.BOLD,White);
    	
    	for(int i=1 ; i<7 ; i++)
    	{
    		cell = new PdfPCell(new Phrase($item_name[i-1],WhiteFontChinese));
        	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        	cell.setBackgroundColor(red);
        	cell.setBorder(0);
        	aTable.addCell(cell);
    	}
    	
    	for(int i=1 ; i<7 ; i++)
    	{
    		if($results0[i-1] != -1){
    			cell = new PdfPCell(new Phrase(String.valueOf($results[i-1]),FontChinese));
    			cell.setBackgroundColor(light_red);
    			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    			cell.setBorder(0);
    			cell.setBorderWidthBottom(0.8f);
    			if(i!=6){
    				cell.setBorderWidthRight(0.8f);
    			}
    			cell.setBorderColor(red);
    			aTable.addCell(cell);
    		}else{
    			aTable.addCell(white_cell);
    		}
    	}
    	
    	for(int i=1 ; i<7 ; i++)
    	{
    		cell = new PdfPCell();
    		cell.setFixedHeight(239);
    		cell.setBorderColor(red);
        	aTable.addCell(cell);
    	}
    	
    	//�� ������ ���� 160 ʱ���� ��ʾ 2011-03-18
    	if(a.getFsiqi() > 160 || a.getVcii() > 160 || a.getVsii() > 160 ||
    			a.getWmii() > 160 || a.getFrii() >160 || a.getPsii() > 160)
    		CreateFloatText(cb, template, bfChinese,"ע����������160��ʱ����ᳬ����ͼ��ʾ��Χ��", 140,-108,3,Black);
        
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    /**
     * ���������ӵ����� 2008-08-28 17:00
     * @param xAxis
     * @param yAxis
     * @param zHeight
     * @param cb
     * @param writer
     */
    public static void CreateRulerNumber(int xAxis, int yAxis, int zHeight,PdfContentByte cb, PdfWriter writer)
    {
    	PdfLayer l1 = new PdfLayer("Layer 1", writer);
        PdfLayer l2 = new PdfLayer("Layer 2", writer);
        PdfLayer l3 = new PdfLayer("Layer 3", writer);
        PdfLayer l4 = new PdfLayer("Layer 4", writer);
        PdfLayer l5 = new PdfLayer("Layer 5", writer);
        PdfLayer l6 = new PdfLayer("Layer 6", writer);
        PdfLayer l7 = new PdfLayer("Layer 7", writer);
        
        Phrase p1 = new Phrase("160");
        Phrase p2 = new Phrase("140");
        Phrase p3 = new Phrase("120");
        Phrase p4 = new Phrase("100");
        Phrase p5 = new Phrase("80");
        Phrase p6 = new Phrase("60");
        Phrase p7 = new Phrase("40");
        
        cb.beginLayer(l1);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p1, 315, 336, 0f);
        cb.endLayer();
        cb.beginLayer(l2);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p2, 315, 296, 0);
        cb.endLayer();
        cb.beginLayer(l3);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p3, 315, 257, 0);
        cb.endLayer();
        cb.beginLayer(l4);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p4, 315, 215, 0);
        cb.endLayer();
        cb.beginLayer(l5);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p5, 320, 177, 0);
        cb.endLayer();
        cb.beginLayer(l6);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p6, 320, 135, 0);
        cb.endLayer();
        cb.beginLayer(l7);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p7, 320, 98, 0);
        cb.endLayer();
        
    }
    
    /**
     * ���ɱ��
     * @param xAxis X��
     * @param yAxis Y��
     * @param zHeight ÿ���ߵľ���
     * @param lineDegree �ߴ�ĳ���Ĭ����120
     * @param cb PdfContentByte����
     * @param Black ����������ɫ
     * @param Blue �м�������ɫ
     * @param value ����ֵ
     * @param bl �ж���һ���ǵ�һ����
     * @param ct ColumnText����
     * @param FontChinese ����
     * @throws DocumentException
     * @throws IOException 
     */
    public static void CreateRuler(int xAxis,int yAxis,float zHeight,int lineDegree, PdfContentByte cb, Color Black,Color Blue,float value,boolean bl,ColumnText ct,Font FontChinese,PdfWriter writer) throws DocumentException, IOException
    {
    	int x=xAxis,y=yAxis;
    	float z=zHeight;
    	
        
    	if(bl==true)
    	{
            //�м���ɫ��
            cb.setLineWidth(2f);
            cb.setColorStroke(Blue);
            cb.moveTo(x, y+z*60);
            cb.lineTo(x+225, y+z*60);
            cb.stroke();
	    }
        //��ͼ
        cb.setColorStroke(Black);
        cb.setLineWidth(0);
        //cb.setRGBColorFill(230, 203, 100);//��ɫ
        cb.setRGBColorFill(0,0,0);
        
        if(value == 0)
        {
        	//����0ʱ����ͼ,���������û��ֵʱΪ0
        }else if(value >= 160)
        {	value = 160;
        	cb.circle(x+25, y+z*(value-40), 3.0f);
        }
        else if(value < 42)
        {
        	value = 42;
        	cb.circle(x+25, y+z*(value-40), 3.0f);
        }else
        {
        	//��Ϊ0ʱͼ���ڵ���
        	cb.circle(x+25, y+z*(value-40), 3.0f);
        }
        
        cb.fillStroke();
        cb.setRGBColorFill(0, 0, 0);
        
        //������������ 2008-08-28 
        //cb.beginText();
        //cb.setFontAndSize(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false), 8);

        
        for(int j=1 ; j<5 ; j++)
        {
            for(int i=1 ; i<lineDegree ; i++)
            {	
            	if(i%5 == 0)
            	{
            		cb.moveTo(x+21, y+z*i);
	            	cb.lineTo(x+29, y+z*i);
	            	if(i%20 == 0)
		            {
	            		//����ϵ���ֵ
		            	//ct.setYLine(y+z*i+6);
		            	//ct.setIndent(280);
		               // ct.addText(new Phrase(""+(40+i)));
		                //ct.addText(new Chunk(String.valueOf(40+i), FontFactory.getFont(FontFactory.defaultEncoding, 8)));
		            	//ct.addElement(new Phrase());
		            	//ct.go();
	            		
	            		//cb.setTextMatrix(280, y+z*i+6);
	                    //cb.showText(String.valueOf(40+i));
	            		
		                //�ԱߵĶ��� 
		                cb.moveTo(335, y+z*i);
		                cb.lineTo(340, y+z*i);
		                cb.stroke();
	            	}
            	}else
            	{
            		cb.moveTo(x+23, y+z*i);
            		cb.lineTo(x+27, y+z*i);
            		
            		if(i==1 || i==lineDegree-1)
		            {
		            	//ct.setYLine(y+z*i+6);
		            	//ct.setIndent(280);
		                //ct.addText(new Phrase(""+(39+i)));
		                //ct.go();
		                //�ԱߵĶ��� 
		                cb.moveTo(335, y+z*i);
		                cb.lineTo(340, y+z*i);
		                cb.stroke();
	            	}
            	}
            }
        }
        
        //����ɫcb.setColorStroke(Blue);
        //cb.setLineWidth(1f);
        //����            
        cb.moveTo(x+25, y+z*lineDegree-2);
        cb.lineTo(x+25, y+z);
        cb.stroke();
    }
	
    
    /**
     * ����ǿ�������ȷ����5���ܷ�
     * @param FontChinese
     * @param columnWidth
     * @param color
     * @return
     * @throws DocumentException
     * @throws IOException 
     */
    public static PdfPTable CreateZszf5(Font FontChinese,Font TopFont,Font SmallFont,Font WhiteFontChinese8,Font LeadingFont,float columnWidth,Color bgcolor,Color rowspanColor,Age4 a) throws DocumentException, IOException
    {	
    	
    	PdfPTable aTable = new PdfPTable(12);
        int headerwidths[] = {8, 16, 12, 14, 10, 10, 12, 10, 3, 10, 10, 10};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	aTable.getDefaultCell().setPadding(3);
    	aTable.getDefaultCell().setFixedHeight(20);
    	
    	int zszf5 = a.getZszf5();
    	float zszf5jz = a.getZszf5jz();
    	String $results1[] = {String.valueOf(a.getVci()),String.valueOf(a.getVcii()),String.valueOf(zszf5jz),String.valueOf(a.getVci5zsfscy()),String.valueOf(a.getVci5zsljz()),String.valueOf(a.getVci5qrx()),String.valueOf(a.getVci5jcl())};
    	String $results2[] = {String.valueOf(a.getVsi()),String.valueOf(a.getVsii()),String.valueOf(zszf5jz),String.valueOf(a.getVsi5zsfscy()),String.valueOf(a.getVsi5zsljz()),String.valueOf(a.getVsi5qrx()),String.valueOf(a.getVsi5jcl())};
    	String $results3[] = {String.valueOf(a.getFri()),String.valueOf(a.getFrii()),String.valueOf(zszf5jz),String.valueOf(a.getFri5zsfscy()),String.valueOf(a.getFri5zsljz()),String.valueOf(a.getFri5qrx()),String.valueOf(a.getFri5jcl())};
    	String $results4[] = {String.valueOf(a.getWmi()),String.valueOf(a.getWmii()),String.valueOf(zszf5jz),String.valueOf(a.getWmi5zsfscy()),String.valueOf(a.getWmi5zsljz()),String.valueOf(a.getWmi5qrx()),String.valueOf(a.getWmi5jcl())};
    	String $results5[] = {String.valueOf(a.getPsi()),String.valueOf(a.getPsii()),String.valueOf(zszf5jz),String.valueOf(a.getPsi5zsfscy()),String.valueOf(a.getPsi5zsljz()),String.valueOf(a.getPsi5qrx()),String.valueOf(a.getPsi5jcl())};
    	
    	PdfPCell cell = null;
    	
    	cell = new PdfPCell(new Phrase("��Ҫ����ҳ",LeadingFont));
    	cell.setFixedHeight(25);
    	cell.setColspan(12);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("ָ��ˮƽ  ǿ����ȷ����",TopFont));
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	cell.setFixedHeight(25);
    	cell.setColspan(6);
    	cell.setBackgroundColor(new Color(0,0,0));
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setColspan(2);
    	aTable.addCell(cell);
    	
    	//�հ���
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�Ƚ�ѡ��",TopFont));
    	cell.setBackgroundColor(new Color(0,0,0));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	//cell.setBorderWidth(0);
    	cell.setColspan(3);
    	cell.setBorderWidthBottom(0);
    	aTable.addCell(cell);
    	
    	//row 2
    	cell = new PdfPCell();
    	cell.setFixedHeight(20);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setColspan(2);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("ָ������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("ָ��������ֵ",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("��������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("�ٽ�ֵ",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("ǿ��������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
//    	�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�ȽϷ���",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthRight(0.3f);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font RedFontChinese = new Font(b_f, 7, Font.NORMAL,red);
    	Font BoldFont = new Font(b_f, 8 , Font.BOLD,Black);
    	
    	//row 3
    	cell = new PdfPCell(new Phrase("�����",BoldFont));
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("�������ָ��",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	
    	if(!$results1[0].equals("-1") && zszf5 != -1){
    		System.out.println("enter create4pdf 1724");
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+$results1[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results1[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results1[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results1[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results1[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results1[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("ָ������\n��ֵ",RedFontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	

    	String s3 = "";
    	if(zszf5 != -1){
    		s3 = String.valueOf(zszf5);
    	}
    	
    	cell = new PdfPCell(new Phrase("5��ָ���ܷ�:"+s3 +"/5=",RedFontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	if(zszf5jz != -1f){
    		s3 = String.valueOf(zszf5jz);
    	}
    	
    	cell = new PdfPCell(new Phrase("ָ��������ֵ:"+s3 ,RedFontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row4
    	cell = new PdfPCell(new Phrase("ָ����",BoldFont));
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setBorderColor(red);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�Ӿ��ռ�ָ��",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results2[0].equals("-1") && zszf5 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+$results2[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results2[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results2[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results2[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results2[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results2[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	String s = "";
    	if(a.getSsp() == 0){
    		s="0.01";
    	}
    	if(a.getSsp() == 1){
    		s="0.05";
    	}
    	if(a.getSsp() == 2){
    		s="0.10";
    	}
    	if(a.getSsp() == 3){
    		s="0.15";
    	}
    	cell = new PdfPCell(new Phrase("ͳ��������ˮƽ\n"+s,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 5
    	cell = new PdfPCell(new Phrase("��ֵ��",BoldFont));
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��������ָ��",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results3[0].equals("-1") && zszf5 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results3[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results3[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results3[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results3[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results3[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results3[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�Ƚϻ�����"+bjjc,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setColspan(3);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 6
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��������ָ��",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results4[0].equals("-1") && zszf5 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results4[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results4[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results4[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results4[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results4[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results4[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 7
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBorderWidthBottom(0.9f);
		cell.setBorderColor(red);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�ӹ��ٶ�ָ��",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results5[0].equals("-1")&& zszf5 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results5[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results5[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results5[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results5[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results5[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results5[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	cell.setColspan(12);
    	cell.setFixedHeight(5);
    	aTable.addCell(cell);
    	
    	//�������̱�
    	int fsiqi = a.getFsiqi();
    	int fsiq = a.getFsiq();
    	String Vci_fsiq[] = new String[]{String.valueOf(a.getVci()) , String.valueOf(a.getVcii()) ,String.valueOf(fsiqi),String.valueOf(a.getVci5zzsfscy()) ,String.valueOf(a.getVci5zzsljz()),String.valueOf(a.getVci5zzsqrx()),a.getVci5zzsjcl()};
    	String Vsi_fsiq[] = new String[]{String.valueOf(a.getVsi()) , String.valueOf(a.getVsii()) ,String.valueOf(fsiqi),String.valueOf(a.getVsi5zzsfscy()) ,String.valueOf(a.getVsi5zzsljz()),String.valueOf(a.getVsi5zzsqrx()),a.getVsi5zzsjcl()};
    	String Fri_fsiq[] = new String[]{String.valueOf(a.getFri()) , String.valueOf(a.getFrii()) ,String.valueOf(fsiqi),String.valueOf(a.getFri5zzsfscy()) ,String.valueOf(a.getFri5zzsljz()),String.valueOf(a.getFri5zzsqrx()),a.getFri5zzsjcl()};
    	String Wmi_fsiq[] = new String[]{String.valueOf(a.getWmi()) , String.valueOf(a.getWmii()) ,String.valueOf(fsiqi),String.valueOf(a.getWmi5zzsfscy()) ,String.valueOf(a.getWmi5zzsljz()),String.valueOf(a.getWmi5zzsqrx()),a.getWmi5zzsjcl()};
    	String Psi_fsiq[] = new String[]{String.valueOf(a.getPsi()) , String.valueOf(a.getPsii()) ,String.valueOf(fsiqi),String.valueOf(a.getPsi5zzsfscy()) ,String.valueOf(a.getPsi5zzsljz()),String.valueOf(a.getPsi5zzsqrx()),a.getPsi5zzsjcl()};
    	
    	
    	
    	
    	cell = new PdfPCell();
    	cell.setFixedHeight(20);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setColspan(2);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("ָ������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("��������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("�ٽ�ֵ",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("ǿ��������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
//    	�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�ȽϷ���",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthRight(0.3f);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//zzs row 2
    	cell = new PdfPCell(new Phrase("��",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("�������ָ��",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!Vci_fsiq[0].equals("-1") && fsiq != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+Vci_fsiq[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if(Vci_fsiq[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if(Vci_fsiq[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if(Vci_fsiq[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+Vci_fsiq[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+Vci_fsiq[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	

    	String s6 = "";
    	if(fsiq != -1){
    		s6 = String.valueOf(fsiqi);
    	}
    	cell = new PdfPCell(new Phrase("������  :          "+s6,RedFontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//zzs row 3
    	cell = new PdfPCell(new Phrase("��",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("�Ӿ��ռ�ָ��",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!Vsi_fsiq[0].equals("-1") && fsiq != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+Vsi_fsiq[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if(Vsi_fsiq[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if(Vsi_fsiq[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if(Vsi_fsiq[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+Vsi_fsiq[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+Vsi_fsiq[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("ͳ��������ˮƽ\n"+s,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//zzs row 4
    	cell = new PdfPCell(new Phrase("��",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("��������ָ��",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!Fri_fsiq[0].equals("-1") && fsiq != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+Fri_fsiq[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if(Fri_fsiq[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if(Fri_fsiq[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if(Fri_fsiq[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+Fri_fsiq[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+Fri_fsiq[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�Ƚϻ���: "+bjjc,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//zzs row 5
    	cell = new PdfPCell(new Phrase("��",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("��������ָ��",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!Wmi_fsiq[0].equals("-1") && fsiq != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+Wmi_fsiq[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if(Wmi_fsiq[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if(Wmi_fsiq[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if(Wmi_fsiq[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+Wmi_fsiq[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+Wmi_fsiq[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//zzs row 6
    	cell = new PdfPCell(new Phrase("��",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBorderWidthBottom(0.9f);
		cell.setBorderColor(red);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("�ӹ��ٶ�ָ��",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!Psi_fsiq[0].equals("-1") && fsiq != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+Psi_fsiq[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if(Psi_fsiq[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if(Psi_fsiq[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if(Psi_fsiq[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+Psi_fsiq[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+Psi_fsiq[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	
    	cell = new PdfPCell(new Phrase("ȷ��ָ��ˮƽ��ǿ������������WPPSI-IV(CN)ָ���ֲḽ��B.1��B.2",SmallFont));
    	cell.setFixedHeight(20);
    	cell.setColspan(12);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
	
    /**
     * ����ǿ�������ȷ����10��ָ���ܷ�
     * @param FontChinese
     * @param columnWidth
     * @param color
     * @return
     * @throws DocumentException
     * @throws IOException 
     */
    public static PdfPTable CreateZszf10(Font FontChinese,Font TopFont,Font SmallFont,Font WhiteFontChinese8,Font LeadingFont,float columnWidth,Color bgcolor,Color rowspanColor,Age4 a) throws DocumentException, IOException
    {	
    	
    	PdfPTable aTable = new PdfPTable(12);
        int headerwidths[] = {8, 16, 12, 14, 10, 10, 12, 10, 3, 10, 10, 10};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	aTable.getDefaultCell().setPadding(3);
    	aTable.getDefaultCell().setFixedHeight(20);
    	
    	int zszf10 = a.getZszf10();
    	float zszf10jz = a.getZszf10jz();
    	String $results1[] = {String.valueOf(a.getInf()),String.valueOf(a.getInfl()),String.valueOf(zszf10jz),String.valueOf(a.getZszf10infscy()),String.valueOf(a.getZszf10inljz()),String.valueOf(a.getZszf10inqrx()),String.valueOf(a.getZszf10injcl())};
    	String $results2[] = {String.valueOf(a.getSi()),String.valueOf(a.getSil()),String.valueOf(zszf10jz),String.valueOf(a.getZszf10sifscy()),String.valueOf(a.getZszf10siljz()),String.valueOf(a.getZszf10siqrx()),String.valueOf(a.getZszf10sijcl())};
    	String $results3[] = {String.valueOf(a.getBd()),String.valueOf(a.getBdl()),String.valueOf(zszf10jz),String.valueOf(a.getZszf10bdfscy()),String.valueOf(a.getZszf10bdljz()),String.valueOf(a.getZszf10bdqrx()),String.valueOf(a.getZszf10bdjcl())};
    	String $results4[] = {String.valueOf(a.getOa()),String.valueOf(a.getOal()),String.valueOf(zszf10jz),String.valueOf(a.getZszf10oafscy()),String.valueOf(a.getZszf10oaljz()),String.valueOf(a.getZszf10oaqrx()),String.valueOf(a.getZszf10oajcl())};
    	String $results5[] = {String.valueOf(a.getMr()),String.valueOf(a.getMrl()),String.valueOf(zszf10jz),String.valueOf(a.getZszf10mrfscy()),String.valueOf(a.getZszf10mrljz()),String.valueOf(a.getZszf10mrqrx()),String.valueOf(a.getZszf10mrjcl())};
    	String $results6[] = {String.valueOf(a.getPc()),String.valueOf(a.getPcl()),String.valueOf(zszf10jz),String.valueOf(a.getZszf10pcfscy()),String.valueOf(a.getZszf10pcljz()),String.valueOf(a.getZszf10pcqrx()),String.valueOf(a.getZszf10pcjcl())};
    	String $results7[] = {String.valueOf(a.getPm()),String.valueOf(a.getPml()),String.valueOf(zszf10jz),String.valueOf(a.getZszf10pmfscy()),String.valueOf(a.getZszf10pmljz()),String.valueOf(a.getZszf10pmqrx()),String.valueOf(a.getZszf10pmjcl())};
    	String $results8[] = {String.valueOf(a.getZl()),String.valueOf(a.getZll()),String.valueOf(zszf10jz),String.valueOf(a.getZszf10zlfscy()),String.valueOf(a.getZszf10zlljz()),String.valueOf(a.getZszf10zlqrx()),String.valueOf(a.getZszf10zljcl())};
    	String $results9[] = {String.valueOf(a.getBs()),String.valueOf(a.getBsl()),String.valueOf(zszf10jz),String.valueOf(a.getZszf10bsfscy()),String.valueOf(a.getZszf10bsljz()),String.valueOf(a.getZszf10bsqrx()),String.valueOf(a.getZszf10bsjcl())};
    	String $results10[] = {String.valueOf(a.getCa()),String.valueOf(a.getCal()),String.valueOf(zszf10jz),String.valueOf(a.getZszf10cafscy()),String.valueOf(a.getZszf10caljz()),String.valueOf(a.getZszf10caqrx()),String.valueOf(a.getZszf10cajcl())};
    	
    	BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font RedFontChinese = new Font(b_f, 7, Font.NORMAL,red);
    	Font BlodFont = new Font(b_f,8,Font.BOLD,Black);
    	Font smallred = new Font(b_f, 5,Font.NORMAL,red);
    	
    	
    	PdfPCell cell = null;
    	
    	cell = new PdfPCell(new Phrase("�ֲ���ˮƽ  ǿ����ȷ����",TopFont));
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	cell.setFixedHeight(25);
    	cell.setColspan(6);
    	cell.setBackgroundColor(new Color(0,0,0));
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setColspan(2);
    	aTable.addCell(cell);
    	
    	//�հ���
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�Ƚ�ѡ��",TopFont));
    	cell.setBackgroundColor(new Color(0,0,0));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	//cell.setBorderWidth(0);
    	cell.setColspan(3);
    	cell.setBorderWidthBottom(0);
    	aTable.addCell(cell);
    	
    	//row 2
    	cell = new PdfPCell();
    	cell.setFixedHeight(20);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setColspan(2);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("���������ֵ",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("��������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("�ٽ�ֵ",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("ǿ��������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
//    	�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�ȽϷ���",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthRight(0.3f);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 3
    	cell = new PdfPCell(new Phrase("��ʮ",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("��ʶ",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results1[0].equals("-1") && zszf10 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+$results1[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results1[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results1[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results1[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results1[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results1[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�ֲ����ֵ",RedFontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	String s6 = "";
    	if(zszf10 != -1){
    		s6 = String.valueOf(zszf10);
    	}
    	cell = new PdfPCell(new Phrase("10��ָ���ֲ�����������ܺ�:"+s6 +"/10=",smallred));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	if(zszf10 != -1){
    		s6 = String.valueOf(zszf10jz);
    	}
    	
    	cell = new PdfPCell(new Phrase("�ֲ������������ֵ:"+s6 ,smallred));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row4
    	cell = new PdfPCell(new Phrase("����",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��ͬ",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results2[0].equals("-1") && zszf10 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+$results2[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results2[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results2[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results2[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results2[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results2[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	String s = "";
    	if(a.getSsp() == 0){
    		s="0.01";
    	}
    	if(a.getSsp() == 1){
    		s="0.05";
    	}
    	if(a.getSsp() == 2){
    		s="0.10";
    	}
    	if(a.getSsp() == 3){
    		s="0.15";
    	}
    	cell = new PdfPCell(new Phrase("ͳ��������ˮƽ\n"+s,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 5 6��ָ��
    	cell = new PdfPCell(new Phrase("����",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��ľ",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results3[0].equals("-1") && zszf10 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results3[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results3[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results3[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results3[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results3[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results3[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	String fensandu = "";
    	if(a.getZszf10fsd() != -1){
    		fensandu = String.valueOf(a.getZszf10fsd());
    	}
    	cell = new PdfPCell(new Phrase("10��ָ�������ֲ�������ķ�ɢ�ȣ�  "+fensandu,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setColspan(3);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	
    	//row 6 6��ָ��
    	cell = new PdfPCell(new Phrase("����",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("ƴͼ",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results4[0].equals("-1")&& zszf10 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results4[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results4[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results4[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results4[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results4[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results4[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 7 6��ָ��
    	cell = new PdfPCell(new Phrase("����",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��������",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results5[0].equals("-1")&& zszf10 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results5[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results5[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results5[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results5[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results5[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results5[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 8 6��ָ��
    	cell = new PdfPCell(new Phrase("��ֵ",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("ͼ������",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results6[0].equals("-1") && zszf10 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results6[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results6[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results6[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results6[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results6[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results6[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 9 10��ָ��
    	cell = new PdfPCell(new Phrase("��",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("ͼƬ����",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results7[0].equals("-1") && zszf10 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results7[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results7[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results7[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results7[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results7[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results7[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 10 10��ָ��
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�����԰",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results8[0].equals("-1") && zszf10 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results8[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results8[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results8[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results8[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results8[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results8[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 11 10��ָ��
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�ҳ�",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results9[0].equals("-1") && zszf10 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results9[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results9[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results9[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results9[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results9[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results9[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 12 10��ָ��
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBorderWidthBottom(0.9f);
		cell.setBorderColor(red);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("����",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(!$results10[0].equals("-1") && zszf10 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results10[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results10[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results10[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results10[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results10[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results10[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	
    	
    	cell = new PdfPCell(new Phrase("ȷ���ֲ���ˮƽ��ǿ������������WPPSI-IV(CN)ָ���ֲḽ��B.3��B.4",SmallFont));
    	cell.setFixedHeight(20);
    	cell.setColspan(12);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    /**
     * ����ǿ�������ȷ����6��ָ���ܷ�
     * @param FontChinese
     * @param columnWidth
     * @param color
     * @return
     * @throws DocumentException
     * @throws IOException 
     */
    public static PdfPTable CreateZszf6(Font FontChinese,Font TopFont,Font SmallFont,Font WhiteFontChinese8,Font LeadingFont,float columnWidth,Color bgcolor,Color rowspanColor,Age4 a) throws DocumentException, IOException
    {	
    	PdfPTable aTable = new PdfPTable(12);
        int headerwidths[] = {8, 16, 12, 14, 10, 10, 12, 10, 3, 10, 10, 10};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	aTable.getDefaultCell().setPadding(3);
    	aTable.getDefaultCell().setFixedHeight(25);
    	
    	int zszf6 = a.getZszf6();
    	float zszf6jz = a.getZszf6jz();
    	String $results1[] = {String.valueOf(a.getInf()),String.valueOf(a.getInfl()),String.valueOf(zszf6jz),String.valueOf(a.getZszf6infscy()),String.valueOf(a.getZszf6inljz()),String.valueOf(a.getZszf6inqrx()),String.valueOf(a.getZszf6injcl())};
    	String $results2[] = {String.valueOf(a.getSi()),String.valueOf(a.getSil()),String.valueOf(zszf6jz),String.valueOf(a.getZszf6sifscy()),String.valueOf(a.getZszf6siljz()),String.valueOf(a.getZszf6siqrx()),String.valueOf(a.getZszf6sijcl())};
    	String $results3[] = {String.valueOf(a.getBd()),String.valueOf(a.getBdl()),String.valueOf(zszf6jz),String.valueOf(a.getZszf6bdfscy()),String.valueOf(a.getZszf6bdljz()),String.valueOf(a.getZszf6bdqrx()),String.valueOf(a.getZszf6bdjcl())};
    	String $results4[] = {String.valueOf(a.getOa()),String.valueOf(a.getOal()),String.valueOf(zszf6jz),String.valueOf(a.getZszf6oafscy()),String.valueOf(a.getZszf6oaljz()),String.valueOf(a.getZszf6oaqrx()),String.valueOf(a.getZszf6oajcl())};
    	String $results5[] = {String.valueOf(a.getMr()),String.valueOf(a.getMrl()),String.valueOf(zszf6jz),String.valueOf(a.getZszf6mrfscy()),String.valueOf(a.getZszf6mrljz()),String.valueOf(a.getZszf6mrqrx()),String.valueOf(a.getZszf6mrjcl())};
    	String $results6[] = {String.valueOf(a.getPc()),String.valueOf(a.getPcl()),String.valueOf(zszf6jz),String.valueOf(a.getZszf6pcfscy()),String.valueOf(a.getZszf6pcljz()),String.valueOf(a.getZszf6pcqrx()),String.valueOf(a.getZszf6pcjcl())};
    	String $results7[] = {String.valueOf(a.getPm()),String.valueOf(a.getPml()),String.valueOf(zszf6jz),String.valueOf(a.getZszf6pmfscy()),String.valueOf(a.getZszf6pmljz()),String.valueOf(a.getZszf6pmqrx()),String.valueOf(a.getZszf6pmjcl())};
    	String $results8[] = {String.valueOf(a.getZl()),String.valueOf(a.getZll()),String.valueOf(zszf6jz),String.valueOf(a.getZszf6zlfscy()),String.valueOf(a.getZszf6zlljz()),String.valueOf(a.getZszf6zlqrx()),String.valueOf(a.getZszf6zljcl())};
    	String $results9[] = {String.valueOf(a.getBs()),String.valueOf(a.getBsl()),String.valueOf(zszf6jz),String.valueOf(a.getZszf6bsfscy()),String.valueOf(a.getZszf6bsljz()),String.valueOf(a.getZszf6bsqrx()),String.valueOf(a.getZszf6bsjcl())};
    	String $results10[] = {String.valueOf(a.getCa()),String.valueOf(a.getCal()),String.valueOf(zszf6jz),String.valueOf(a.getZszf6cafscy()),String.valueOf(a.getZszf6caljz()),String.valueOf(a.getZszf6caqrx()),String.valueOf(a.getZszf6cajcl())};
    	
    	BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font RedFontChinese = new Font(b_f, 7, Font.NORMAL,red);
    	Font BlodFont = new Font(b_f , 8 , Font.BOLD,Black);
    	Font smallred = new Font(b_f, 5 , Font.NORMAL,red);
    	
    	PdfPCell cell = null;
    	
    	cell = new PdfPCell(new Phrase("�ֲ���ˮƽ  ǿ����ȷ����",TopFont));
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	cell.setFixedHeight(20);
    	cell.setColspan(6);
    	cell.setBackgroundColor(new Color(0,0,0));
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setColspan(2);
    	aTable.addCell(cell);
    	
    	//�հ���
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�Ƚ�ѡ��",TopFont));
    	cell.setBackgroundColor(new Color(0,0,0));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	//cell.setBorderWidth(0);
    	cell.setColspan(3);
    	cell.setBorderWidthBottom(0);
    	aTable.addCell(cell);
    	
    	//row 2
    	cell = new PdfPCell();
    	cell.setFixedHeight(20);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setColspan(2);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("���������ֵ",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("��������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("�ٽ�ֵ",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("ǿ��������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
//    	�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�ȽϷ���",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthRight(0.3f);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 3
    	cell = new PdfPCell(new Phrase("����",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("��ʶ",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(!$results1[0].equals("-1") && zszf6 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+$results1[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results1[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results1[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results1[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results1[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results1[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�ֲ����ֵ",RedFontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	String s6 = "";
    	if(zszf6 != -1){
    		s6 = String.valueOf(zszf6);
    	}
    	cell = new PdfPCell(new Phrase("6�������̷ֲ�����������ܺ�:"+s6 +"/6=",smallred));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	if(zszf6jz != -1){
    		s6 = String.valueOf(zszf6jz);
    	}
    	cell = new PdfPCell(new Phrase("�ֲ������������ֵ:"+s6 ,smallred));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row4
    	cell = new PdfPCell(new Phrase("����",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��ͬ",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(!$results2[0].equals("-1") && zszf6 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+$results2[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results2[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results2[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results2[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results2[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results2[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	String s = "";
    	if(a.getSsp() == 0){
    		s="0.01";
    	}
    	if(a.getSsp() == 1){
    		s="0.05";
    	}
    	if(a.getSsp() == 2){
    		s="0.10";
    	}
    	if(a.getSsp() == 3){
    		s="0.15";
    	}
    	cell = new PdfPCell(new Phrase("ͳ��������ˮƽ\n"+s,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 5 6��ָ��
    	cell = new PdfPCell(new Phrase("����",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��ľ",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(!$results3[0].equals("-1") && zszf6 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results3[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results3[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results3[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results3[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results3[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results3[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	String fensandu = "";
    	if(a.getZszf6fsd() != -1){
    		fensandu = String.valueOf(a.getZszf6fsd());
    	}
    	cell = new PdfPCell(new Phrase("6��ָ�������ֲ�������ķ�ɢ�ȣ�  "+fensandu,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 6 6��ָ��
    	cell = new PdfPCell(new Phrase("����",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("ƴͼ",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(!$results4[0].equals("-1") && zszf6 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results4[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results4[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results4[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results4[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results4[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results4[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 7 6��ָ��
    	cell = new PdfPCell(new Phrase("����",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��������",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(!$results5[0].equals("-1") && zszf6 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results5[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results5[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results5[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results5[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results5[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results5[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 8 6��ָ��
    	cell = new PdfPCell(new Phrase("��ֵ",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("ͼ������",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(!$results6[0].equals("-1") && zszf6 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results6[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results6[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results6[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results6[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results6[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results6[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 9 6��ָ��
    	cell = new PdfPCell(new Phrase("��",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("ͼƬ����",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(!$results7[0].equals("-1") && zszf6 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results7[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results7[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results7[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results7[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results7[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results7[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	
    	//row 10 6��ָ��
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�����԰",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(!$results8[0].equals("-1") && zszf6 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results8[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results8[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results8[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results8[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results8[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results8[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 12 6��ָ��
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�ҳ�",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(!$results9[0].equals("-1") && zszf6 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results9[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results9[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results9[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results9[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results9[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results9[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 13 6��ָ��
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBorderWidthBottom(0.9f);
		cell.setBorderColor(red);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("����",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(!$results10[0].equals("-1") && zszf6 != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results10[i+1],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
    				if($results10[i+1].equals("0")){
    					//�հ���
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results10[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("ǿ",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results10[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results10[i+1]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results10[i+1]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	
    	cell = new PdfPCell(new Phrase("ȷ���ֲ���ˮƽ��ǿ������������WPPSI-IV(CN)ָ���ֲḽ��B.1,B.2,B.3��B.4",SmallFont));
    	cell.setFixedHeight(20);
    	cell.setColspan(12);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    /**
     * ����ǿ����Ƚϱ�
     * @param FontChinese
     * @param columnWidth
     * @param color
     * @return
     * @throws DocumentException
     * @throws IOException 
     */
    public static PdfPTable CreateCha(Font FontChinese,Font TopFont,Font SmallFont,Font WhiteFontChinese8,Font LeadingFont,float columnWidth,Color bgcolor,Color rowspanColor,Age4 a) throws DocumentException, IOException
    {	
    	PdfPTable aTable = new PdfPTable(12);
        int headerwidths[] = {8, 21, 11, 10, 10, 10, 12, 10, 3, 10, 10, 10};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	aTable.getDefaultCell().setPadding(3);
    	aTable.getDefaultCell().setFixedHeight(20);
    	
    	int vci = a.getVci() , vsi = a.getVsi() , fri = a.getFri(), wmi = a.getWmi() , psi = a.getPsi();
    	int in = a.getInf(), si = a.getSi(), bd = a.getBd() , oa = a.getOa() ,mr = a.getMr(), pc = a.getPc() ,pm = a.getPm() , zl = a.getZl() ,bs = a.getBs() , ca = a.getCa() ;
    	
    	String $results1[] = {String.valueOf(a.getVcii()),String.valueOf(a.getVsii()),String.valueOf(a.getVci_vsi()),String.valueOf(a.getVci_vsiljz()),String.valueOf(a.getVci_vsiqrx()),String.valueOf(a.getVci_vsijcl())};
    	String $results2[] = {String.valueOf(a.getVcii()),String.valueOf(a.getFrii()),String.valueOf(a.getVci_fri()),String.valueOf(a.getVci_friljz()),String.valueOf(a.getVci_friqrx()),String.valueOf(a.getVci_frijcl())};  
    	String $results3[] = {String.valueOf(a.getVcii()),String.valueOf(a.getWmii()),String.valueOf(a.getVci_wmi()),String.valueOf(a.getVci_wmiljz()),String.valueOf(a.getVci_wmiqrx()),String.valueOf(a.getVci_wmijcl())}; 
    	String $results4[] = {String.valueOf(a.getVcii()),String.valueOf(a.getPsii()),String.valueOf(a.getVci_psi()),String.valueOf(a.getVci_psiljz()),String.valueOf(a.getVci_psiqrx()),String.valueOf(a.getVci_psijcl())};  
    	String $results5[] = {String.valueOf(a.getVsii()),String.valueOf(a.getFrii()),String.valueOf(a.getVsi_fri()),String.valueOf(a.getVsi_friljz()),String.valueOf(a.getVsi_friqrx()),String.valueOf(a.getVsi_frijcl())}; 
    	String $results6[] = {String.valueOf(a.getVsii()),String.valueOf(a.getWmii()),String.valueOf(a.getVsi_wmi()),String.valueOf(a.getVsi_wmiljz()),String.valueOf(a.getVsi_wmiqrx()),String.valueOf(a.getVsi_wmijcl())}; 
    	String $results7[] = {String.valueOf(a.getVsii()),String.valueOf(a.getPsii()),String.valueOf(a.getVsi_psi()),String.valueOf(a.getVsi_psiljz()),String.valueOf(a.getVsi_psiqrx()),String.valueOf(a.getVsi_psijcl())}; 
    	String $results8[] = {String.valueOf(a.getFrii()),String.valueOf(a.getWmii()),String.valueOf(a.getFri_wmi()),String.valueOf(a.getFri_wmiljz()),String.valueOf(a.getFri_wmiqrx()),String.valueOf(a.getFri_wmijcl())}; 
    	String $results9[] = {String.valueOf(a.getFrii()),String.valueOf(a.getPsii()),String.valueOf(a.getFri_psi()),String.valueOf(a.getFri_psiljz()),String.valueOf(a.getFri_psiqrx()),String.valueOf(a.getFri_psijcl())}; 
    	String $results10[] = {String.valueOf(a.getWmii()),String.valueOf(a.getPsii()),String.valueOf(a.getWmi_psi()),String.valueOf(a.getWmi_psiljz()),String.valueOf(a.getWmi_psiqrx()),String.valueOf(a.getWmi_psijcl())}; 
    	
    	String $results11[] = {String.valueOf(a.getInfl()),String.valueOf(a.getSil()),String.valueOf(a.getIn_si()),String.valueOf(a.getIn_siljz()),String.valueOf(a.getIn_sicy()),String.valueOf(a.getIn_sijcl())};
    	String $results12[] = {String.valueOf(a.getBdl()),String.valueOf(a.getOal()),String.valueOf(a.getBd_oa()),String.valueOf(a.getBd_oaljz()),String.valueOf(a.getBd_oacy()),String.valueOf(a.getBd_oajcl())};
    	String $results13[] = {String.valueOf(a.getMrl()),String.valueOf(a.getPcl()),String.valueOf(a.getMr_pc()),String.valueOf(a.getMr_pcljz()),String.valueOf(a.getMr_pccy()),String.valueOf(a.getMr_pcjcl())};
    	String $results14[] = {String.valueOf(a.getPml()),String.valueOf(a.getZll()),String.valueOf(a.getPm_zl()),String.valueOf(a.getPm_zlljz()),String.valueOf(a.getPm_zlcy()),String.valueOf(a.getPm_zljcl())};
    	String $results15[] = {String.valueOf(a.getBsl()),String.valueOf(a.getCal()),String.valueOf(a.getBs_ca()),String.valueOf(a.getBs_caljz()),String.valueOf(a.getBs_cacy()),String.valueOf(a.getBs_cajcl())};
    	
    	BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font RedFontChinese = new Font(b_f, 7, Font.NORMAL,red);
    	Font BoldFont = new Font(b_f , 8 ,Font.BOLD , Black);
    	
    	
    	
    	PdfPCell cell = null;
    	
    	cell = new PdfPCell(new Phrase("����Ƚϱ�",TopFont));
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	cell.setFixedHeight(20);
    	cell.setColspan(6);
    	cell.setBackgroundColor(new Color(0,0,0));
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setColspan(2);
    	aTable.addCell(cell);
    	
    	//�հ���
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�Ƚ�ѡ��",TopFont));
    	cell.setBackgroundColor(new Color(0,0,0));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	//cell.setBorderWidth(0);
    	cell.setColspan(3);
    	cell.setBorderWidthBottom(0);
    	aTable.addCell(cell);
    	
    	//row 2
    	cell = new PdfPCell();
    	cell.setFixedHeight(20);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setColspan(2);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�������1",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�������2",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("��������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("�ٽ�ֵ",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("�����Բ���",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
//    	�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	String s = "";
    	if(a.getSsp() == 0){
    		s="0.01";
    	}
    	if(a.getSsp() == 1){
    		s="0.05";
    	}
    	if(a.getSsp() == 2){
    		s="0.10";
    	}
    	if(a.getSsp() == 3){
    		s="0.15";
    	}
    	cell = new PdfPCell(new Phrase("ͳ��������ˮƽ\n"+s,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 3
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("�������-�Ӿ��ռ�",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(vci != -1 && vsi != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+$results1[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results1[i].equals("0") || $results1[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results1[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results1[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results1[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�Ƚϻ����� "+bjjc,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	
    	//row4
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�������-��������",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(vci != -1 && fri != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+$results2[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results2[i].equals("0") || $results2[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results2[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results2[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results2[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 5 6��ָ��
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�������-��������",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(vci != -1 && wmi != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results3[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results3[i].equals("0") || $results3[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results3[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results3[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results3[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 6 6��ָ��
    	cell = new PdfPCell(new Phrase("ָ",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�������-�ӹ��ٶ�",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(vci != -1 && psi != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results4[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results4[i].equals("0") || $results4[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results4[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results4[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results4[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 7 6��ָ��
    	cell = new PdfPCell(new Phrase("��",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�Ӿ��ռ�-��������",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(vsi != -1 && fri != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results5[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results5[i].equals("0") || $results5[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results5[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results5[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results5[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 8 6��ָ��
    	cell = new PdfPCell(new Phrase("ˮ",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�Ӿ��ռ�-��������",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(vsi != -1 && wmi != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results6[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results6[i].equals("0") || $results6[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results6[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results6[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results6[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 9 6��ָ��
    	cell = new PdfPCell(new Phrase("ƽ",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�Ӿ��ռ�-�ӹ��ٶ�",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(vsi != -1 && psi != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results7[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results7[i].equals("0") || $results7[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results7[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results7[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results7[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	

    	//row 10 6��ָ��
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��������-��������",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(fri != -1 && wmi != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results8[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results8[i].equals("0") || $results8[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results8[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results8[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results8[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 11 6��ָ��
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��������-�ӹ��ٶ�",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(fri != -1 && psi != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results9[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results9[i].equals("0") || $results9[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results9[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results9[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results9[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 12 6��ָ��
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��������-�ӹ��ٶ�",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(wmi != -1 && psi != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results10[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results10[i].equals("0") || $results10[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results10[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results10[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results10[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	
    	//row 3 �ֲ���
    	cell = new PdfPCell(new Phrase("��",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��ʶ-��ͬ",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if(in != -1 && si != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results11[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results11[i].equals("0") || $results11[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results11[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results11[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results11[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�Ƚ�ѡ��",TopFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
    	cell.setBackgroundColor(new Color(0,0,0));
    	aTable.addCell(cell);
    	
    	//row 14 6��ָ��
    	cell = new PdfPCell(new Phrase("��",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��ľ-ƴͼ",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if( bd != -1 && oa != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results12[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results12[i].equals("0")|| $results12[i].equals("2") ){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results12[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results12[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results12[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("ͳ��������ˮƽ��"+s , FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 15 6��ָ��
    	cell = new PdfPCell(new Phrase("��",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("��������-ͼ������",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if( mr != -1 && pc != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results13[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results13[i].equals("0")|| $results13[i].equals("2") ){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results13[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results13[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results13[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	
    	//row 16 6��ָ��
    	cell = new PdfPCell(new Phrase("ˮ",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("ͼƬ����-�����԰",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if( pm != -1 && zl != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results14[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results14[i].equals("0") || $results14[i].equals("2") ){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results14[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results14[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results14[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    		    	
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 17 6��ָ��
    	cell = new PdfPCell(new Phrase("ƽ",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBorderWidthBottom(0.9f);
		cell.setBorderColor(red);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�ҳ�-����",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(20);
    	aTable.addCell(cell);
    	
    	if( bs != -1 && ca != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i!= 0){
    				cell = new PdfPCell(new Phrase(""+$results15[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results15[i].equals("0") || $results15[i].equals("2") ){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results15[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results15[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results15[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(20);
    		    	aTable.addCell(cell);
    		    	
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(20);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase());
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	
    	cell = new PdfPCell(new Phrase("�Ƚ�ָ������֮���ֲ������֮��Ĳ��죬�����WPPSI-IV(CN)ָ���ֲḽ��B.5,B.6,B.7��B.8",SmallFont));
    	cell.setFixedHeight(20);
    	cell.setColspan(12);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    /**����
     * */
    public static PdfPTable CreateFuzhu(Font LeadingFont,float columnWidth) throws DocumentException
    {	
    	PdfPTable aTable = new PdfPTable(1);
        int headerwidths[] = {10};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        
        PdfPCell cell = new PdfPCell(new Phrase("��������ҳ",LeadingFont));
        cell.setBorderWidth(0);
        aTable.addCell(cell);
        aTable.setTotalWidth(columnWidth);
        return aTable;
    }
    
    /**��ҳ
     * */
    public static PdfPTable CreateXu(Font LeadingFont,float columnWidth) throws DocumentException
    {	
    	PdfPTable aTable = new PdfPTable(1);
        int headerwidths[] = {10};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        
        PdfPCell cell = new PdfPCell(new Phrase("��Ҫ����ҳ������",LeadingFont));
        cell.setBorderWidth(0);
        aTable.addCell(cell);
        aTable.setTotalWidth(columnWidth);
        return aTable;
    }
    
    
    /**
     * ����ԭʼ�������������ת������
     * @param FontChinese
     * @param columnWidth
     * @param white
     * @return
     * @throws DocumentException
     * @throws IOException 
     */
    public static PdfPTable CreateYuanFu(Font FontChinese,Font HeadFont,float columnWidth,Color white,Color LastColor,Age4 a,Font SmallFont,PdfContentByte cb, PdfWriter writer) throws DocumentException, IOException
    {
   		PdfPTable aTable3 = new PdfPTable(7);
   		int headerwidths[] = {12, 5, 10, 10, 10 ,10 ,10};
   		String $item_name[] = {"��ľ","��ʶ","��������","�ҳ�","ͼƬ����","��ͬ","ͼ������","����","�����԰","ƴͼ","��������","ָ��ͼƬ","ͼƬ����","�������","������"};
   		String $item_name1[] = {"BD","IN","MR","BS","PM","SI","PC","CA","ZL","OA","AC","RV","PN","CAR","CAS"};
   		int $results[] = {a.getBd(),a.getInf(),a.getMr(),a.getBs(),a.getPm(),a.getSi(),a.getPc(),a.getCa(),a.getZl(),a.getOa(),a.getAc(),a.getRv(),a.getPn(),a.getCar(),a.getCas()};
   		int $result_tally[] = {a.getBdl(),a.getInfl(),a.getMrl(),a.getBsl(),a.getPml(),a.getSil(),a.getPcl(),a.getCal(),a.getZll(),a.getOal(),a.getAcl(),a.getRvl(),a.getPnl(),a.getCarl(),a.getCasl()};
   		
   		BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font SmallFontChinese = new Font(b_f, 7, Font.NORMAL,red);
    	Font WhiteFontChinese = new Font(b_f, 7 ,Font.BOLD,White);
    	Font BoldFont1 = new Font(b_f, 7 , Font.BOLD,Black);
   		
   		aTable3.setWidths(headerwidths);
   		aTable3.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
   		aTable3.getDefaultCell().setPadding(3);
   		
   		PdfPCell cell = null;
   		
   		cell = new PdfPCell(new Phrase("��������ܺ�",HeadFont));
   		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
   		cell.setBorderWidth(0);
   		cell.setColspan(7);
   		cell.setFixedHeight(25);
   		aTable3.addCell(cell);
   		
   		cell = new PdfPCell(new Phrase("�ֲ���",WhiteFontChinese));
   		cell.setFixedHeight(25);
   		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
   		cell.setColspan(2);
   		cell.setPaddingTop(7);
   		cell.setBorderColor(White);
   		cell.setBackgroundColor(red);
    	aTable3.addCell(cell);
    	
    	
    	cell = new PdfPCell(new Phrase("�������",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(5);  //ռ5������
    	cell.setFixedHeight(25);
    	cell.setPaddingTop(7);
    	cell.setBorderColor(White);
   		cell.setBackgroundColor(red);
    	aTable3.addCell(cell);
    	
    	//���ר��
    	PdfPCell blue_cell = new PdfPCell();
    	blue_cell.setBackgroundColor(red);
    	blue_cell.setBorderColor(Color.white);
    	blue_cell.setFixedHeight(20);
    	
    	PdfPCell white_cell = new PdfPCell(new Phrase("��Ч",FontChinese));
    	white_cell.setBackgroundColor(Color.white);
    	white_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	white_cell.setFixedHeight(20);
    	
    	PdfPCell wu = new PdfPCell(new Phrase("-",FontChinese));
    	wu.setHorizontalAlignment(Element.ALIGN_CENTER);
    	wu.setBackgroundColor(Color.white);
    	wu.setFixedHeight(20);
    	
    	for (int i = 1; i < 17; i++) 
    	{
    		if(i<=15){
    			//������
    			cell = new PdfPCell(new Phrase($item_name[i-1],BoldFont1));
    			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    			cell.setPaddingLeft(10);
    			//cell.setPaddingTop(5);
    			cell.setFixedHeight(15);
    			cell.setBorderWidth(0.7f);
    			cell.setBorderWidthLeft(0);
    	    	cell.setBorderWidthRight(0);
    	    	cell.setFixedHeight(20);
    	    	cell.setBorderColor(red);
    			aTable3.addCell(cell);
    			
    			//��Ӣ������
    			cell = new PdfPCell(new Phrase($item_name1[i-1],BoldFont1));
    			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    			//cell.setPaddingTop(5);
    			cell.setFixedHeight(15);
    			cell.setBorderWidth(0.7f);
    			cell.setBorderWidthLeft(0);
    			cell.setFixedHeight(20);
    			cell.setBorderColor(red);
    			aTable3.addCell(cell);
    			
    			
    			if($item_name[i-1] == "ͼƬ����" || $item_name[i-1] == "ָ��ͼƬ")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//���������
    					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    					cell.setBackgroundColor(white);
    					cell.setBorderWidth(0);
    					cell.setBorderColor(Color.white);
    					cell.setFixedHeight(20);
    					aTable3.addCell(cell);
    				}else{
    					aTable3.addCell(wu);
    				}
    			}else{
    				aTable3.addCell(blue_cell);
    			}
    			
    			//    		�ڶ���
    			if($item_name[i-1] == "��ľ" || $item_name[i-1] == "��������"|| $item_name[i-1] == "�ҳ�"|| $item_name[i-1] == "ͼƬ����"
    				|| $item_name[i-1] == "ͼ������" || $item_name[i-1] == "����" || $item_name[i-1] == "�����԰" || $item_name[i-1] == "ƴͼ" || $item_name[i-1] == "��������")
    			{
    				if($results[i-1] != -1){
    					if($item_name[i-1] == "����" || $item_name[i-1] == "�����԰" || $item_name[i-1] == "ƴͼ" || $item_name[i-1] == "��������"){
    						cell = new PdfPCell(new Phrase("("+$result_tally[i-1]+")",FontChinese));//���������
    					}else{
    						cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//���������
    					}
    					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    					cell.setBackgroundColor(white);
    					cell.setBorderColor(Color.white);
    					cell.setBorderWidth(0);
    					cell.setFixedHeight(20);
    					aTable3.addCell(cell);
    				}else{
    					aTable3.addCell(wu);
    				}
    			}else{		
    				aTable3.addCell(blue_cell);
    			}
    			//������
    			if( $item_name[i-1] == "��ľ"|| $item_name[i-1] == "��ʶ" || $item_name[i-1] == "��������" || $item_name[i-1] == "��ͬ"
    				|| $item_name[i-1] == "ͼ������" || $item_name[i-1] == "ƴͼ")
    			{
    				if($results[i-1] != -1){
    					if(  $item_name[i-1] == "ͼ������" || $item_name[i-1] == "ƴͼ" ){
    						cell = new PdfPCell(new Phrase("("+$result_tally[i-1]+")",FontChinese));//���������
    					}else{
    						cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//���������
    					}
    					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    					cell.setBackgroundColor(white);
    					cell.setBorderColor(Color.white);
    					cell.setBorderWidth(0);
    					cell.setFixedHeight(20);
    					aTable3.addCell(cell);
    				}else{
    					aTable3.addCell(wu);
    				}
    			}else{
    				aTable3.addCell(blue_cell);
    			}
    			
    		
    		//������
			if( $item_name[i-1] == "�ҳ�"|| $item_name[i-1] == "ͼƬ����" || $item_name[i-1] == "����" || $item_name[i-1] == "�����԰"
				|| $item_name[i-1] == "��������" )
			{
				if($results[i-1] != -1){
					if( $item_name[i-1] == "��������" ){
						cell = new PdfPCell(new Phrase("("+$result_tally[i-1]+")",FontChinese));//���������
					}else{
						cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//���������
					}
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(white);
					cell.setBorderColor(Color.white);
					cell.setBorderWidth(0);
					cell.setFixedHeight(20);
					aTable3.addCell(cell);
				}else{
					aTable3.addCell(wu);
				}
			}else{
				aTable3.addCell(blue_cell);
			}
			
			//������
			if( $item_name[i-1] == "�������"|| $item_name[i-1] == "������" )
			{
				if($results[i-1] != -1){
					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//���������
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(white);
					cell.setBorderColor(Color.white);
					cell.setBorderWidth(0);
					cell.setFixedHeight(20);
					aTable3.addCell(cell);
				}else{
					aTable3.addCell(wu);
				}
			}else{
				aTable3.addCell(blue_cell);
			}
    	}
            
            //���һ��
            if(i==16)
            {
            	cell = new PdfPCell(new Phrase("��������ܺ�:  ",SmallFontChinese));
            	cell.setColspan(2);
            	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            	cell.setBorderWidth(0);
	            aTable3.addCell(cell);

	            //20090530���*������ע��
	            int vai = a.getVai();
	            int nvi = a.getNvi();
	            int gai = a.getGai();
	            int cpi = a.getCpi();
	            
	            if(vai != -1){
	            	cell = new PdfPCell(new Phrase(""+a.getVai(),FontChinese));
	            	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            	cell.setBackgroundColor(LastColor);
	            	cell.setFixedHeight(20);
	            	cell.setBorder(0);
	            	aTable3.addCell(cell);
	            }else{
	            	aTable3.addCell(white_cell);
	            }
	            
	            if(nvi != -1){
		            cell = new PdfPCell(new Phrase(""+a.getNvi(),FontChinese));
		            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            cell.setBackgroundColor(LastColor);
		            cell.setFixedHeight(20);
		            cell.setBorder(0);
		            aTable3.addCell(cell);
	            }else{
	            	aTable3.addCell(white_cell);
	            }
	            if(gai != -1){
		            cell = new PdfPCell(new Phrase(""+a.getGai(),FontChinese));
		            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            cell.setBackgroundColor(LastColor);
		            cell.setFixedHeight(20);
		            cell.setBorder(0);
		            aTable3.addCell(cell);
	            }else{
	            	aTable3.addCell(white_cell);
	            }
	            if(cpi != -1){
		            cell = new PdfPCell(new Phrase(""+a.getCpi(),FontChinese));
		            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            cell.setBackgroundColor(LastColor);
		            cell.setFixedHeight(20);
		            cell.setBorder(0);
		            aTable3.addCell(cell);
	            }else{
	            	aTable3.addCell(white_cell);
	            }
	            cell = new PdfPCell();
	    	   	cell.setBorderWidth(0);
	    	   	cell.setFixedHeight(20);
	    	   	aTable3.addCell(cell);
            }
    	}
    	
    		
	   	cell = new PdfPCell();
	   	cell.setColspan(2);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(0.9f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	cell = new PdfPCell(new Phrase("����\n����",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(0.9f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	cell = new PdfPCell(new Phrase("��\n����",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(0.9f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	cell = new PdfPCell(new Phrase("һ��\n����",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(0.9f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	cell = new PdfPCell(new Phrase("��֪\nЧ��",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(0.9f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
	   	cell = new PdfPCell();
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(0.9f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
	   	aTable3.setTotalWidth(columnWidth);
	   	return aTable3;
    }
    
    
    /**
     * ������������ܺ���ϳɷ���ת����
     * @param FontChinese
     * @param columnWidth
     * @param color
     * @return
     * @throws DocumentException
     * @throws IOException 
     */
    public static PdfPTable CreateHeChengFu(Font FontChinese,Font HeadFont,Font SmallFont,float columnWidth,Color blackgroundcolor,float Height,Age4 a,PdfContentByte cb, PdfWriter writer) throws DocumentException, IOException
    {
    	int Padding = 3;
    	int vai = a.getVai();
    	int nvi = a.getNvi();
    	int gai = a.getGai();
    	int cpi = a.getCpi();
    	
    	String $result1[] = {String.valueOf(a.getVai()),String.valueOf(a.getVaii()),a.getVaib(),a.getVaiz()};
    	String $result2[] = {String.valueOf(a.getNvi()),String.valueOf(a.getNvii()),a.getNvib(),a.getNviz()};
    	String $result3[] = {String.valueOf(a.getGai()),String.valueOf(a.getGaii()),a.getGaib(),a.getGaiz()};
    	String $result4[] = {String.valueOf(a.getCpi()),String.valueOf(a.getCpii()),a.getCpib(),a.getCpiz()};
    	
    	BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font WhiteFontChinese = new Font(b_f, 7, Font.BOLD,White);
    	
    	//�����
    	PdfPCell white_cell = new PdfPCell(new Phrase("��Ч",FontChinese));
    	white_cell.setBackgroundColor(Color.white);
    	white_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	white_cell.setFixedHeight(20);
    	PdfPCell wu = new PdfPCell(new Phrase(" ",FontChinese));
    	wu.setHorizontalAlignment(Element.ALIGN_CENTER);
    	wu.setBorder(0);
    	wu.setBackgroundColor(Color.white);
    	wu.setFixedHeight(20);
    	
    	
    	//Color white = new Color(150,5,37).white;
    	PdfPTable aTable = new PdfPTable(5);
    	int[] headerwidths = { 24, 15, 15, 15, 15};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	aTable.getDefaultCell().setPadding(Padding);
 
        PdfPCell cell = null;
    	
        cell = new PdfPCell(new Phrase("��������ܺ��븨��ָ������ת����",HeadFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPadding(Padding);
    	cell.setBorderWidth(0);
    	cell.setColspan(5);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("����",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(5);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�������\n�ܺ�",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPadding(Padding);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("����ָ��\n����",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(5f);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�ٷ�\n�ȼ�",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(2);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	String z = "";
    	if(a.getSp() == 0){
    		z = "90%";
    	}else{
    		z = "95%";
    	}
    	
    	cell = new PdfPCell(new Phrase("��������\n"+z,WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPadding(Padding);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    		
    		
    	cell = new PdfPCell(new Phrase("���Խ���",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setFixedHeight(20);
    	cell.setBorder(0);
    	cell.setPaddingTop(3);
    	cell.setBackgroundColor(Color.white);
    	aTable.addCell(cell);
    		
    	if(vai != -1){
    		cell = new PdfPCell(new Phrase($result1[0],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		cell.setBackgroundColor(blackgroundcolor);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase("VAI:  " + $result1[1], FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    		cell.setPaddingTop(4);
    		cell.setPaddingLeft(3);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result1[2],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		cell.setBackgroundColor(blackgroundcolor);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result1[3],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    	}else{
    		for(int i = 0 ; i< 4 ; i++ ){
    			aTable.addCell(wu);
    		}
    	}
    	
    	cell = new PdfPCell(new Phrase("������",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(3);
    	cell.setFixedHeight(20);
        cell.setBorder(0);
    	aTable.addCell(cell);
    		
    	if(nvi != -1){
    		cell = new PdfPCell(new Phrase($result2[0],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBackgroundColor(blackgroundcolor);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase("NVI:  " + $result2[1], FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    		cell.setPaddingTop(4);
    		cell.setPaddingLeft(3);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result2[2],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBackgroundColor(blackgroundcolor);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result2[3],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    	}else{
    		for(int i = 0 ; i< 4 ; i++ ){
    			aTable.addCell(wu);
    		}
    	}
    	
   		cell = new PdfPCell(new Phrase("һ������",FontChinese));
   		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
   		cell.setPaddingTop(4);
   		cell.setFixedHeight(20);
       	cell.setBorder(0);
   		aTable.addCell(cell);
   		
   		if(gai != -1){
    		cell = new PdfPCell(new Phrase($result3[0],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBackgroundColor(blackgroundcolor);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase("GAI:  " + $result3[1], FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    		cell.setPaddingTop(4);
    		cell.setPaddingLeft(3);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result3[2],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBackgroundColor(blackgroundcolor);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result3[3],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
    		aTable.addCell(cell);
    		
    	}else{
    		for(int i = 0 ; i< 4 ; i++ ){
    			aTable.addCell(wu);
    		}
    	}
   		
   		cell = new PdfPCell(new Phrase("��֪Ч��",FontChinese));
   		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
   		cell.setPaddingTop(4);
   		cell.setFixedHeight(20);
       	cell.setBorder(0);
       	cell.setBorderWidthBottom(0.9f);
       	cell.setBorderColor(red);
   		aTable.addCell(cell);
   		
   		if(cpi != -1){
    		cell = new PdfPCell(new Phrase($result4[0],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBackgroundColor(blackgroundcolor);
    		cell.setBorder(0);
           	cell.setBorderWidthBottom(0.9f);
           	cell.setBorderColor(red);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase("CPI:  " + $result4[1], FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    		cell.setPaddingTop(4);
    		cell.setPaddingLeft(3);
    		cell.setBorder(0);
           	cell.setBorderWidthBottom(0.9f);
           	cell.setBorderColor(red);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result4[2],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBackgroundColor(blackgroundcolor);
    		cell.setBorder(0);
           	cell.setBorderWidthBottom(0.9f);
           	cell.setBorderColor(red);
    		aTable.addCell(cell);
    		
    		cell = new PdfPCell(new Phrase($result4[3],FontChinese));
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setPaddingTop(4);
    		cell.setBorder(0);
           	cell.setBorderWidthBottom(0.9f);
           	cell.setBorderColor(red);
    		aTable.addCell(cell);
    		
    	}else{
    		for(int i = 0 ; i< 4 ; i++ ){
    			aTable.addCell(wu);
    		}
    	}
    	
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    
    /**
     * ����ǿ����Ƚϱ���
     * @param FontChinese
     * @param columnWidth
     * @param color
     * @return
     * @throws DocumentException
     * @throws IOException 
     */
    public static PdfPTable CreateChaFu(Font FontChinese,Font TopFont,Font SmallFont,Font WhiteFontChinese8,Font LeadingFont,float columnWidth,Color bgcolor,Color rowspanColor,Age4 a) throws DocumentException, IOException
    {	
    	PdfPTable aTable = new PdfPTable(12);
        int headerwidths[] = {8, 21, 11, 10, 10, 10, 12, 10, 3, 10, 10, 10};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	aTable.getDefaultCell().setPadding(3);
    	aTable.getDefaultCell().setFixedHeight(20);
    	
    	int gai = a.getGai() , fsiq = a.getFsiq(), cpi = a.getCpi(),rv = a.getRv(),pn= a.getPn(), car = a.getCar() ,cas = a.getCas(); 
    	String $results1[] = {String.valueOf(a.getGaii()),String.valueOf(a.getFsiqi()),String.valueOf(a.getGai_fsiq()),String.valueOf(a.getGai_fsiqljz()),String.valueOf(a.getGai_fsiqcy()),String.valueOf(a.getGai_fsiqjcl())};
    	String $results2[] = {String.valueOf(a.getGaii()),String.valueOf(a.getCpii()),String.valueOf(a.getGai_cpi()),String.valueOf(a.getGai_cpiljz()),String.valueOf(a.getGai_cpicy()),String.valueOf(a.getGai_cpijcl())};
    	String $results3[] = {String.valueOf(a.getRvl()),String.valueOf(a.getPnl()),String.valueOf(a.getRv_pn()),String.valueOf(a.getRv_pnljz()),String.valueOf(a.getRv_pncy()),String.valueOf(a.getRv_pnjcl())};  
    	String $results4[] = {String.valueOf(a.getCarl()),String.valueOf(a.getCasl()),String.valueOf(a.getCar_cas()),String.valueOf(a.getCar_casljz()),String.valueOf(a.getCar_cascy()),String.valueOf(a.getCar_casjcl())};  
    	
    	BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font RedFontChinese = new Font(b_f, 7, Font.NORMAL,red);
    	Font BoldFont = new Font(b_f , 8,Font.BOLD,Black);
    	
    	PdfPCell cell = null;
    	
    	cell = new PdfPCell(new Phrase("����Ƚϱ�",TopFont));
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	cell.setFixedHeight(25);
    	cell.setColspan(6);
    	cell.setBackgroundColor(new Color(0,0,0));
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setColspan(2);
    	aTable.addCell(cell);
    	
    	//�հ���
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�Ƚ�ѡ��",TopFont));
    	cell.setBackgroundColor(new Color(0,0,0));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	//cell.setBorderWidth(0);
    	cell.setColspan(3);
    	cell.setBorderWidthBottom(0);
    	aTable.addCell(cell);
    	
    	//row 2
    	cell = new PdfPCell();
    	cell.setFixedHeight(20);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setColspan(2);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�������1",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�������2",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("��������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("�ٽ�ֵ",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("�����Բ���",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("������",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
//    	�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	String s = "";
    	if(a.getSsp() == 0){
    		s="0.01";
    	}
    	if(a.getSsp() == 1){
    		s="0.05";
    	}
    	if(a.getSsp() == 2){
    		s="0.10";
    	}
    	if(a.getSsp() == 3){
    		s="0.15";
    	}
    	cell = new PdfPCell(new Phrase("ͳ��������ˮƽ\n"+s,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 3
    	cell = new PdfPCell(new Phrase("ָ��\nˮƽ",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("һ������ָ��-������",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(gai != -1 && fsiq != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+$results1[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results1[i].equals("0") || $results1[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results1[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results1[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results1[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("�Ƚϻ�����"+bjjc,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 4
    	cell = new PdfPCell(new Phrase(" ",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBorderWidthBottom(0.9f);
		cell.setBorderColor(red);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("һ������ָ��-��֪Ч��",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(gai != -1 && cpi != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+$results2[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results2[i].equals("0") || $results2[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results2[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results2[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results2[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	
    	//row5
    	cell = new PdfPCell(new Phrase("�ֲ���\nˮƽ",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBorderWidthBottom(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("ָ��ͼƬ-ͼƬ����",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(rv != -1 && pn != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+$results3[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results3[i].equals("0") || $results3[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results3[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results3[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results3[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row7
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBorderWidthBottom(0.9f);
		cell.setBorderColor(red);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("�������-������",FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setFixedHeight(25);
    	aTable.addCell(cell);
    	
    	if(car != -1 && cas != -1){
    		for(int i = 0 ; i< 6 ;i++){
    			if(i != 4 && i != 1 && i != 0){
    				cell = new PdfPCell(new Phrase(""+$results4[i],FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 4){
//    				float cy = Float.parseFloat($results1[2]) , ljz = Float.parseFloat($results1[3]);
    				if($results4[i].equals("0") || $results4[i].equals("2")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results4[i].equals("1")){
    					cell = new PdfPCell(new Phrase("��",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    			}else if(i == 1){
    				cell = new PdfPCell(new Phrase(""+$results4[i]+"   =",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}else if(i == 0){
    				cell = new PdfPCell(new Phrase(""+$results4[i]+"      -",FontChinese));
    				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cell.setBorderWidth(0);
    		    	cell.setBorderWidthBottom(0.9f);
    		    	cell.setBorderColor(red);
    		    	cell.setFixedHeight(25);
    		    	aTable.addCell(cell);
    			}
    		}
    	}else{
    		cell = new PdfPCell();
    		cell.setBorderWidth(0);
    		cell.setBorderWidthBottom(0.9f);
    		cell.setBorderColor(red);
	    	cell.setFixedHeight(25);
	    	cell.setColspan(6);
	    	aTable.addCell(cell);
    	}
    	
    	//�հ���
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
//    	cell.setBorderWidthBottom(0.9f);
//    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("ָ��ˮƽ�Ƚϣ������WPPSI-IV(CN)ָ���ֲḽ��B.10��B.11\n�ֲ���ˮƽ�Ƚϣ����ո���B.7,B.8",SmallFont));
    	cell.setFixedHeight(20);
    	cell.setColspan(12);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    
    public static PdfPTable CreatePage4(Font FontChinese,Font LeadingFont,float columnWidth,Color color,Age4 a
			, BaseFont bfChinese, PdfContentByte cb, PdfTemplate template, Color Black //2011-03-18
			) throws DocumentException, IOException
    {
    	PdfPTable aTable = new PdfPTable(4);
        int headerwidths[] = {10, 10, 10 , 10};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	//aTable.getDefaultCell().setPadding(3);
    	
    	String $item_name[] = {"���Խ���",	"������",	"һ������", "��֪Ч��"};
    	int vai = a.getVai(), nvi = a.getNvi(), gai = a.getGai() ,cpi = a.getCpi();
    	String $results[] = {String.valueOf(a.getVaii()) , String.valueOf(a.getNvii()), String.valueOf(a.getGaii()), String.valueOf(a.getCpii())};
    	
    	BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font WhiteFontChinese = new Font(b_f, 7, Font.BOLD,White);
    	
    	PdfPCell cell = null;
    	
    	cell = new PdfPCell(new Phrase("����ָ����������ͼ",LeadingFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setColspan(4);
    	aTable.addCell(cell);
    	
    	for(int i=1 ; i<5 ; i++)
    	{
    		cell = new PdfPCell(new Phrase($item_name[i-1],WhiteFontChinese));
    		cell.setFixedHeight(15);
        	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        	cell.setBorder(0);
        	cell.setBackgroundColor(red);
        	aTable.addCell(cell);
    	}
    	for(int i=1 ; i<5 ; i++)
    	{
    		cell = new PdfPCell(new Phrase($results[i-1],FontChinese));
    		cell.setFixedHeight(12);
    		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    		cell.setBorder(0);
        	cell.setBackgroundColor(light_red);
        	aTable.addCell(cell);
    	}
    	for(int i=1 ; i<5 ; i++)
    	{
    		cell = new PdfPCell();
    		cell.setFixedHeight(239);
    		cell.setBorderColor(red);
        	aTable.addCell(cell);
    	}
    	
    	//�� ������ ���� 160 ʱ���� ��ʾ 2011-03-18
    	if(vai > 160 || nvi> 160 || gai > 160)
    		CreateFloatText(cb, template, bfChinese,"ע����������160��ʱ����ᳬ����ͼ��ʾ��Χ��", -138,80,3,Black);
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
	
	/**
     * ���ɱ��[����ҳ]
     * @param xAxis X��
     * @param yAxis Y��
     * @param zHeight ÿ���ߵľ���
     * @param lineDegree �ߴ�ĳ���Ĭ����120
     * @param cb PdfContentByte����
     * @param Black ����������ɫ
     * @param Blue �м�������ɫ
     * @param value ����ֵ
     * @param bl �ж���һ���ǵ�һ����
     * @param ct ColumnText����
     * @param FontChinese ����
     * @throws DocumentException
     * @throws IOException 
     */
    public static void CreateRuler_Page4(int xAxis,int yAxis,float zHeight,int lineDegree, PdfContentByte cb, Color Black,Color Blue,float value,boolean bl,ColumnText ct,Font FontChinese,PdfWriter writer) throws DocumentException, IOException
    {
    	int x=xAxis,y=yAxis;
    	float z=zHeight;
    	
        
    	if(bl==true)
    	{
            //�м���ɫ��
            cb.setLineWidth(2f);
            cb.setColorStroke(Blue);
            cb.moveTo(x-10, y+z*60);
            cb.lineTo(x+215, y+z*60);
            cb.stroke();
	    }
        //��ͼ ���ɫ
        cb.setColorStroke(Black);
        cb.setLineWidth(0);
        //cb.setRGBColorFill(230, 203, 100);//��ɫ
        cb.setRGBColorFill(0,0,0);
        
        if(value == 0)
        {
        	//����0ʱ����ͼ,���������û��ֵʱΪ0
        }else if(value >= 160)
        {	value = 160;
        	cb.circle(x+25, y+z*(value-40), 3.0f);
        }
        else if(value < 42)
        {
        	value = 42;
        	cb.circle(x+25, y+z*(value-40), 3.0f);
        }else
        {
        	//��Ϊ0ʱͼ���ڵ���
        	cb.circle(x+25, y+z*(value-40), 3.0f);
        }
        
        cb.fillStroke();
        cb.setRGBColorFill(0, 0, 0);
        
        //������������ 2008-08-28 
        //cb.beginText();
        //cb.setFontAndSize(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false), 8);

        
        for(int j=1 ; j<5 ; j++)
        {
            for(int i=1 ; i<lineDegree ; i++)
            {	
            	if(i%5 == 0)
            	{
            		cb.moveTo(x+21, y+z*i);
	            	cb.lineTo(x+29, y+z*i);
	            	if(i%20 == 0)
		            {
	            		//����ϵ���ֵ
		            	//ct.setYLine(y+z*i+6);
		            	//ct.setIndent(280);
		               // ct.addText(new Phrase(""+(40+i)));
		                //ct.addText(new Chunk(String.valueOf(40+i), FontFactory.getFont(FontFactory.defaultEncoding, 8)));
		            	//ct.addElement(new Phrase());
		            	//ct.go();
	            		
	            		//cb.setTextMatrix(280, y+z*i+6);
	                    //cb.showText(String.valueOf(40+i));
	            		
		                //�ԱߵĶ��� 
	            		if(bl==true)
	        	    	{
			                cb.moveTo(x-8, y+z*i);
			                cb.lineTo(x-3, y+z*i);
			                cb.stroke();
	        	    	}
	            	}
            	}else
            	{
            		cb.moveTo(x+23, y+z*i);
            		cb.lineTo(x+27, y+z*i);
            		
            		if(i==1 || i==lineDegree-1)
		            {
		            	//ct.setYLine(y+z*i+6);
		            	//ct.setIndent(280);
		                //ct.addText(new Phrase(""+(39+i)));
		                //ct.go();
		                //�ԱߵĶ���
            			if(bl==true)
	        	    	{
			                cb.moveTo(x-8, y+z*i);
			                cb.lineTo(x-3, y+z*i);
			                cb.stroke();
	        	    	}
	            	}
            	}
            }
        }
        
        //����ɫcb.setColorStroke(Blue);
        //cb.setLineWidth(1f);
        //����            
        cb.moveTo(x+25, y+z*lineDegree-2);
        cb.lineTo(x+25, y+z);
        cb.stroke();
    }
    
    /**
     * ���������ӵ����� 2008-08-28 17:00
     * @param xAxis
     * @param yAxis
     * @param cb
     * @param writer
     */
    public static void CreateRulerNumber_Page4(int xAxis, int yAxis, int zHeight,PdfContentByte cb, PdfWriter writer)
    {
    	PdfLayer l1 = new PdfLayer("Layer 1", writer);
        PdfLayer l2 = new PdfLayer("Layer 2", writer);
        PdfLayer l3 = new PdfLayer("Layer 3", writer);
        PdfLayer l4 = new PdfLayer("Layer 4", writer);
        PdfLayer l5 = new PdfLayer("Layer 5", writer);
        PdfLayer l6 = new PdfLayer("Layer 6", writer);
        PdfLayer l7 = new PdfLayer("Layer 7", writer);
        
        Phrase p1 = new Phrase("160");
        Phrase p2 = new Phrase("140");
        Phrase p3 = new Phrase("120");
        Phrase p4 = new Phrase("100");
        Phrase p5 = new Phrase("80");
        Phrase p6 = new Phrase("60");
        Phrase p7 = new Phrase("40");
        
        cb.beginLayer(l1);
        int i = 735 , j = 335;  //iΪy���꣬jΪx����
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p1, j, i, 0f);
        cb.endLayer();
        cb.beginLayer(l2);
        i -= 40;
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p2, j, i, 0);
        cb.endLayer();
        cb.beginLayer(l3);
        i -= 40;
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p3, j, i, 0);
        cb.endLayer();
        cb.beginLayer(l4);
        i -= 40;
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p4, j, i, 0);
        cb.endLayer();
        cb.beginLayer(l5);
        i -= 40;
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p5, j, i, 0);
        cb.endLayer();
        cb.beginLayer(l6);
        i -= 40;
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p6, j, i, 0);
        cb.endLayer();
        cb.beginLayer(l7);
        i -= 40;
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p7, j, i, 0);
        cb.endLayer();
        
    }
	
    
    public static void CreateFloatText(PdfContentByte cb,PdfTemplate template,BaseFont baseFont,String text,int x,int y,int size,Color color)
    {
    	template = cb.createTemplate(500, 200);
        
        //BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        template.beginText();
        BaseFont bf = baseFont;
		template.setColorFill(color);
        template.setFontAndSize(bf, size);
        template.setTextMatrix(100, 100);
        template.showText(text);
        template.endText();

        cb.addTemplate(template,  2, 0, 0, 2, x, y);
    	
    }
    
	 public String setlast(Date time) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH_mm");
			String last = df.format(time);
			return last;
	}
	 
	public Create4pdf(){}
    public Create4pdf(Child c){
    	this.c = c;
    }
}
