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
	public static String bjjc = "全样本";
	
	//set the  color
    //浅蓝
	public static Color Cambridge_blue = new Color(230,242,246);
    //蓝色
	public static Color Blue = new Color(30,196,250);
    //标题蓝色
	public static Color NormalBlue = new Color(30,166,196);
    //圆心专用蓝色
    //Color CirBlue = new Color(184,230,240);
	public static Color CirBlue = new Color(44,200,230);
    //深色
	public static Color Deepblue = new Color(125,196,250);
    //深色2
	public static Color Deepblue2 = new Color(0,137,174);
    //白色
	public static Color White = new Color(255,255,255);
    //黑色
	public static Color Black = new Color(0,0,0);
    //金色
	public static Color Glod = new Color(230, 203, 100);
    //红色
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
			bjjc = "能力水平样本";
		}else{
			bjjc = "全样本";
		}
		this.c = c;
		if( path == "" )
		{
			path = ServletActionContext.getServletContext().getRealPath("pdfFile")+"\\"+"temp";
			
		}
		File dirname = new File(path);   
		if (!dirname.exists())   //目录不存在   
		{   
		  dirname.mkdirs();//创建目录 
		}
		
		String time = setlast(new Date());
		String FileName = path+ "/"+c.getCid()+".pdf" ;
//		String FileName = path+ "/test.pdf" ;
		String Name = "/pdfFile/temp/"+c.getCid()+".pdf";
		Document document = new Document(PageSize.A4);
		
		try{
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FileName));

            //左右两侧的距离
            float gutter = 30;
            //表间距
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
            document.addAuthor("京美心理测量技术开发有限公司");
            document.addCreator("京美心理测量技术开发有限公司(by king-may.com.cn)");
            document.addCreationDate();
            document.addCreator("京美心理测量技术开发有限公司");
            document.addTitle("韦氏幼儿智力量表WPPSI-IV第四版中文版");
            
            PdfTemplate template = null;//用于生成浮动所依赖的类
            
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
            
            ct.setLeading(10);//字间距
            ct.go();//换行
            currentY = ct.getYLine();//currenY用作间距
            
            currentY += 30;
            float topColumn = currentY;
            
          //刻度尺
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
            
            
            //logo 表格
            PdfPTable Logo = CreateLogo(BlueFontChinese,150,Deepblue2);
            currentY = Logo.writeSelectedRows(0, -1, document.left(), currentY-18, cb);
            
            //Title 表格
            PdfPTable JiHui = CreateTitle(FontChinese,FontChinese2,FontChinese3,200,Color.black);
            JiHui.writeSelectedRows(0, -1, (document.left()+document.right())/2-100, document.top()+23, cb);
            
            //儿童姓名、主试姓名表
            PdfPTable aTable1 = CreateTableChildInfo(BestFontChinese,BestFontChinese10,150,Cambridge_blue,15,a,c);
            currentY = aTable1.writeSelectedRows(0, -1, document.left(), currentY, cb)-space_between-10;
            
            //儿童年龄表
            PdfPTable ChildAge = CreateTime(FontChinese1, WhiteFontChinese, 160, light_red, 15,c);
	        ChildAge.writeSelectedRows(0, -1, (document.left()+document.right())/2+120, document.top(), cb);
            
	        //原始分数与量表分数转换表
	        PdfPTable Yuan = CreateYuan(BestFontChinese,BlueFontChinese,WhiteFontChinese8,RedFont,columnWidth,White,light_red,a,SmallFontChinese,cb,writer);
	        currentY = Yuan.writeSelectedRows(0, -1, document.left(), currentY, cb)-space_between - 50;
	        
	        //量表分数总和与合成分数转换表
	        PdfPTable HeCheng = CreateHeCheng(BestFontChinese,BlueFontChinese,SmallFontChinese,columnWidth,light_red,15,a,cb,writer);
	        currentY = HeCheng.writeSelectedRows(0, -1,  document.left(), currentY + 30, cb) -space_between - 50;
	        
	        //地下logo
	        PdfPTable ButtomLogo = CreateButtomLogo(ButtomFontChinese,font9, columnWidth+20, White);
	        currentY = ButtomLogo.writeSelectedRows(0, -1, document.left(), currentY-10, cb)-space_between-10;
	        
	        //右边表
	        //分测验量表分数剖析图
	        PdfPTable FeiPo = CreateFenPo(BestFontChinese,BlueFontChinese,BlueCriFontChinese,RedFontChinese,columnWidth,White,light_red,a);
	        currentY = FeiPo.writeSelectedRows(0, -1, 320, document.top()-90, cb)-space_between;
	        
	        //合成分数解剖图
	        PdfPTable Fei = CreateFen(BestFontChinese,BlueFontChinese,columnWidth-30,White,a,
					bfChinese, cb, template, Black);
	        currentY = Fei.writeSelectedRows(0, -1, 320+20, document.top()-415-13, cb)-space_between;
	        
	        
	        //游标数值
	        CreateRulerNumber(100,100,100,cb,writer);
	        CreateFloatText(cb, template, bfChinese,"第 1 页", 100,-160,4,Black);
	        
	        //新一页：第二页
            document.newPage();
            float currentY_Page2 = document.top();
            
            //指数水平 强弱项表
            PdfPTable Zhi3 = CreateZszf5(BestFontChinese,WhiteFontChinese,SmallFontChinese,WhiteFontChinese8,BlackFontChinese,fullWidth,red,weigh_red,a);
            currentY_Page2 = Zhi3.writeSelectedRows(0, -1, document.left(), currentY_Page2, cb)-space_between;
            
            //分测验水平 强弱项表
            PdfPTable Fen6 = CreateZszf10(BestFontChinese,WhiteFontChinese,SmallFontChinese,WhiteFontChinese8,BlackFontChinese,fullWidth,red,weigh_red,a);
            currentY_Page2 = Fen6.writeSelectedRows(0, -1, document.left(), currentY_Page2, cb)-space_between;
            
            CreateFloatText(cb, template, bfChinese,"第 2 页", 100,-160,4,Black);
            
            
            //新一页：第三页
            document.newPage();
            float currentY_Page3 = document.top();
            
            PdfPTable Xu = CreateXu(BlackFontChinese,fullWidth);
            currentY_Page3 = Xu.writeSelectedRows(0, -1, document.left(), currentY_Page3, cb) - space_between;
            
            //分测验水平 强弱项表 6个
            PdfPTable Fen5 = CreateZszf6(BestFontChinese,WhiteFontChinese,SmallFontChinese,WhiteFontChinese8,BlackFontChinese,fullWidth,red,weigh_red,a);
            currentY_Page3 = Fen5.writeSelectedRows(0, -1, document.left(), currentY_Page3, cb)-space_between;
            
            //差异比较表
            PdfPTable Cha = CreateCha(BestFontChinese,WhiteFontChinese,SmallFontChinese,WhiteFontChinese8,BlackFontChinese,fullWidth,red,weigh_red,a);
            currentY_Page3 = Cha.writeSelectedRows(0, -1, document.left(), currentY_Page3, cb)-space_between;
            
            CreateFloatText(cb, template, bfChinese,"第 3 页", 100,-160,4,Black);
            
            //新一页：第四页
            document.newPage();
            float currentY_Page4 = document.top();
            PdfPTable Fuzhu = CreateFuzhu(BlackFontChinese,fullWidth);
            currentY_Page4 = Fuzhu.writeSelectedRows(0, -1, document.left(), currentY_Page4, cb)-space_between;
            
            //辅助原始分
            PdfPTable YuanFu = CreateYuanFu(BestFontChinese,BlueFontChinese,columnWidth,White,light_red,a,SmallFontChinese,cb,writer);
            currentY_Page4 = YuanFu.writeSelectedRows(0, -1, document.left(), currentY_Page4, cb)-space_between - 50;
            
            //辅助页成绩
            PdfPTable HeChengFU = CreateHeChengFu(BestFontChinese,BlueFontChinese,SmallFontChinese,columnWidth,light_red,15,a,cb,writer);
            currentY_Page4 = HeChengFU.writeSelectedRows(0, -1,  document.left(), currentY_Page4 + 30, cb) -space_between - 50;
            
            //辅助差异表
            PdfPTable ChaFU = CreateChaFu(BestFontChinese,WhiteFontChinese,SmallFontChinese,WhiteFontChinese8,BlackFontChinese,fullWidth,red,weigh_red,a);
            currentY_Page4 = ChaFU.writeSelectedRows(0, -1, document.left(), currentY_Page4 +40, cb)-space_between;
            
            //辅助指数分数剖析图
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
            
            
            CreateFloatText(cb, template, bfChinese,"第 4 页", 100,-160,4,Black);
            
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
//    	Image im = Image.getInstance(ImagePath+"/WPPSI-IV中文版 LOGO.png");
    	Image im = Image.getInstance(ImagePath+"/logo.png");

		//im.setRotationDegrees(30);//倾斜30度
		PdfPCell cell = new PdfPCell(im, true);
		cell.setBorderWidth(0);
		aTable.addCell(cell);
		
//		PdfPCell cell2 = new PdfPCell(new Phrase("韦氏幼儿智力量表-第四版（中文版）",FontChinese));
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
    	PdfPCell cell = new PdfPCell(new Phrase("韦氏幼儿智力量表-第四版中文版",FontChinese1));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(10);
		cell.setBorderWidth(0);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("记分册.汇总页",FontChinese2));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0);
		cell.setPadding(10);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("适用年龄    4:0~6:11",FontChinese3));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0);
		cell.setPadding(10);
		aTable.addCell(cell);
    	
    	aTable.setTotalWidth(columnWidth);
		return aTable;
    }
	
	/**儿童姓名
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
        table1_cell = new PdfPCell(new Phrase("主试姓名:",FontChinese)); 
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
        
        table1_cell = new PdfPCell(new Phrase("儿童姓名:",FontChinese));
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
        
//        table1_cell = new PdfPCell(new Phrase("儿童代码:",FontChinese));
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
     * 儿童年龄
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
    	
    	cell = new PdfPCell(new Phrase("计算儿童年龄",HeadFont)); 
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//    	cell.setFixedHeight(Height);
    	cell.setColspan(3);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("年",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//    	cell.setFixedHeight(Height);
    	cell.setBackgroundColor(weigh_red);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("月",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//    	cell.setFixedHeight(Height);
    	cell.setBackgroundColor(weigh_red);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("日",FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//    	cell.setFixedHeight(Height);
    	cell.setBackgroundColor(weigh_red);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("测试日期",FontChinese));
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
    	
    	cell = new PdfPCell(new Phrase("出生日期",FontChinese));
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

    	cell = new PdfPCell(new Phrase("实足年龄",FontChinese));
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
     * 生成原始分数与量表分数转换表函数
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
   		String $item_name[] = {"积木","常识","矩阵推理","找虫","图片记忆","类同","图画概念","划消","动物家园","拼图","动物译码","指认图片","图片命名","随机划消","有序划消"};
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
   		
   		cell = new PdfPCell(new Phrase("原始分数与量表分数转换表",HeadFont));
   		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
   		cell.setBorderWidth(0);
   		cell.setColspan(10);
   		cell.setFixedHeight(20);
   		aTable3.addCell(cell);
   		
   		cell = new PdfPCell(new Phrase("分测验",WhiteFont));
   		cell.setFixedHeight(25);
   		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
   		cell.setColspan(2);
   		cell.setPaddingTop(7);
   		cell.setBorderColor(White);
   		cell.setBackgroundColor(red);
    	aTable3.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("原始\n分数",WhiteFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setFixedHeight(25);
    	cell.setBorderColor(White);
   		cell.setBackgroundColor(red);
    	aTable3.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("量表分数",WhiteFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(7);  //占3个格子
    	cell.setFixedHeight(25);
    	cell.setPaddingTop(7);
    	cell.setBorderColor(White);
   		cell.setBackgroundColor(red);
    	aTable3.addCell(cell);
    	
    	//填充专用
    	PdfPCell blue_cell = new PdfPCell();
    	blue_cell.setBackgroundColor(red);
    	blue_cell.setBorderColor(Color.white);
    	blue_cell.setFixedHeight(20);
    	
    	PdfPCell white_cell = new PdfPCell(new Phrase("无效",FontChinese));
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
    			//加名称
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
    			
    			//加英文名称
    			cell = new PdfPCell(new Phrase($item_name1[i-1],BoldFont1));
    			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    			//cell.setPaddingTop(5);
    			cell.setFixedHeight(15);
    			cell.setBorderWidth(0.7f);
    			cell.setBorderWidthLeft(0);
    			cell.setFixedHeight(20);
    			cell.setBorderColor(red);
    			aTable3.addCell(cell);
    			
    			//加原始分
    			if($results[i-1] != -1){
    				cell = new PdfPCell(new Phrase(String.valueOf($results[i-1]),FontChinese));
        			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        			cell.setBorderColor(red);
        			cell.setFixedHeight(15);
    				aTable3.addCell(cell);
    			}else{
    				aTable3.addCell(white_cell);
    			}
    			
    			if($item_name[i-1] == "常识" || $item_name[i-1] == "类同")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//输入的数据
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
    			//    		第二列
    			if($item_name[i-1] == "积木" || $item_name[i-1] == "拼图")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//输入的数据
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
    			//第三列
    			if($item_name[i-1] == "图画概念" || $item_name[i-1] == "矩阵推理")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//输入的数据
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
    			
    			
    			//第四列
    			if($item_name[i-1] == "图片记忆" || $item_name[i-1] == "动物家园")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//输入的数据
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
    			
    			//第五列
    			if($item_name[i-1] == "找虫" || $item_name[i-1] == "划消")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//输入的数据
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
    			
    			//第六列
    			if($item_name[i-1] == "积木" || $item_name[i-1] == "常识" || $item_name[i-1] == "矩阵推理" || $item_name[i-1] == "找虫" || $item_name[i-1] == "图片记忆" || $item_name[i-1] == "类同" 
    				|| $item_name[i-1] == "图画概念" || $item_name[i-1] == "划消" || $item_name[i-1] == "动物家园" || $item_name[i-1] == "拼图"|| $item_name[i-1] == "动物译码"  )
    			{
    				if($results[i-1] != -1){
    					if($item_name[i-1] == "图画概念" || $item_name[i-1] == "划消" || $item_name[i-1] == "动物家园" || $item_name[i-1] == "拼图"|| $item_name[i-1] == "动物译码"){
    						cell = new PdfPCell(new Phrase("("+$result_tally[i-1]+")",FontChinese));//输入的数据
    					}else{
    						cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//输入的数据
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
    			
    			//最后一列
    			//第六列
    			if($item_name[i-1] == "指认图片" || $item_name[i-1] == "图片命名" || $item_name[i-1] == "随机划消" || $item_name[i-1] == "有序划消")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//输入的数据
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
            
            //最后一行
            if(i==16)
            {
            	cell = new PdfPCell(new Phrase("量表分数总和:  ",RedFont));
            	cell.setColspan(3);
            	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            	cell.setBorderWidth(0);
	            aTable3.addCell(cell);

	            //20090530添加*号以作注释
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
	   	
	   	cell = new PdfPCell(new Phrase("言语\n理解",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(1f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
	   	cell = new PdfPCell(new Phrase("视觉\n空间",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(1f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
	   	cell = new PdfPCell(new Phrase("流体\n推理",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(1f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
	   	cell = new PdfPCell(new Phrase("工作\n记忆",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(1f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
	   	cell = new PdfPCell(new Phrase("加工\n速度",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(1f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	
	   	cell = new PdfPCell(new Phrase("全量\n表",SmallFontChinese));
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
     * 生成量表分数总和与合成分数转换表
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
    	
    	
    	//填充用
    	PdfPCell white_cell = new PdfPCell(new Phrase("无效",FontChinese));
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
    	
        cell = new PdfPCell(new Phrase("量表分数总和与合成分数转换表",HeadFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPadding(Padding);
    	cell.setBorderWidth(0);
    	cell.setColspan(5);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("量表",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(5);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("量表分数\n总和",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPadding(Padding);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("合成分数",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(5f);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("百分\n等级",WhiteFontChinese));
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
    	
    	cell = new PdfPCell(new Phrase("置信区间\n"+z,WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPadding(Padding);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    		
    		
    	cell = new PdfPCell(new Phrase("言语理解",FontChinese));
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
    	
    	cell = new PdfPCell(new Phrase("视觉空间",FontChinese));
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
    	
   		cell = new PdfPCell(new Phrase("流体推理",FontChinese));
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
    	
    	
    	cell = new PdfPCell(new Phrase("工作记忆",FontChinese));
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
    	
    	cell = new PdfPCell(new Phrase("加工速度",FontChinese));
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
    	
    	cell = new PdfPCell(new Phrase("全量表",FontChinese));
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
        
        PdfPCell cell = new PdfPCell(new Phrase("备注：",HeadFont));
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
     * 首页下方公司LOGO
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
    	cell = new PdfPCell(new Phrase("WPPSI-IV中文版经NCS Pearson, Inc. 授权，由京美心理测量技术开发有限公司翻译，改编和印制。版权所有，翻版必究。",FontChinese));
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
     * 生成分测验量表分数剖析图
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
    	
    	cell = new PdfPCell(new Phrase("分测验量表分数剖析图",LeadingFont));
    	cell.setBorderWidth(0);
    	cell.setColspan(12);
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	aTable.addCell(cell);
    	
    	//	    	空白
    	cell = new PdfPCell();
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font WhiteFontChinese = new Font(b_f, 8, Font.BOLD,White);
    	
    	cell = new PdfPCell(new Phrase("言语理解",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(2);
    	cell.setBorder(0);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("视觉空间",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(2);
    	cell.setBorder(0);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("流体推理",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(2);
    	cell.setBorder(0);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("工作记忆",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(2);
    	cell.setBorder(0);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("加工速度",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(3);
    	cell.setBorder(0);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	//	    	空白
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	PdfPCell wu = new PdfPCell(new Phrase("无效",FontChinese));
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
    	//	    	空白
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
					cell = new PdfPCell(new Phrase("●",valueFont));//★◆■▲
					cell.setBorderWidth(0);
				}
    			else
    			{
    				cell = new PdfPCell(new Phrase("●",BlueFontChinese));
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
     * 生成合成分数剖析图
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
    	
    	String $item_name[] = {"言语理解", "视觉空间","知觉推理",	"工作记忆", "加工速度" ,"总智商"};
    	int $results0[] = {a.getVci(),a.getVsi(),a.getFri(),a.getWmi(),a.getPsi(),a.getFsiq()};
    	int $results[] = {a.getVcii(),a.getVsii(),a.getFrii(),a.getWmii(),a.getPsii(),a.getFsiqi()};
    	
    	PdfPCell cell = null;
    	
    	cell = new PdfPCell(new Phrase("合成分数剖析图",LeadingFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setColspan(6);
    	aTable.addCell(cell);
    	
    	PdfPCell white_cell = new PdfPCell(new Phrase("无效",FontChinese));
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
    	
    	//当 总智商 大于 160 时出现 提示 2011-03-18
    	if(a.getFsiqi() > 160 || a.getVcii() > 160 || a.getVsii() > 160 ||
    			a.getWmii() > 160 || a.getFrii() >160 || a.getPsii() > 160)
    		CreateFloatText(cb, template, bfChinese,"注：分数高于160分时，便会超出本图显示范围。", 140,-108,3,Black);
        
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    /**
     * 生成左侧尺子的数字 2008-08-28 17:00
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
     * 生成标尺
     * @param xAxis X轴
     * @param yAxis Y轴
     * @param zHeight 每条线的距离
     * @param lineDegree 尺寸的长度默认是120
     * @param cb PdfContentByte对象
     * @param Black 字条条形颜色
     * @param Blue 中间线条颜色
     * @param value 输入值
     * @param bl 判断那一条是第一竖线
     * @param ct ColumnText对象
     * @param FontChinese 字体
     * @throws DocumentException
     * @throws IOException 
     */
    public static void CreateRuler(int xAxis,int yAxis,float zHeight,int lineDegree, PdfContentByte cb, Color Black,Color Blue,float value,boolean bl,ColumnText ct,Font FontChinese,PdfWriter writer) throws DocumentException, IOException
    {
    	int x=xAxis,y=yAxis;
    	float z=zHeight;
    	
        
    	if(bl==true)
    	{
            //中间蓝色线
            cb.setLineWidth(2f);
            cb.setColorStroke(Blue);
            cb.moveTo(x, y+z*60);
            cb.lineTo(x+225, y+z*60);
            cb.stroke();
	    }
        //画图
        cb.setColorStroke(Black);
        cb.setLineWidth(0);
        //cb.setRGBColorFill(230, 203, 100);//黄色
        cb.setRGBColorFill(0,0,0);
        
        if(value == 0)
        {
        	//等于0时不作图,这种情况是没有值时为0
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
        	//不为0时图处于底线
        	cb.circle(x+25, y+z*(value-40), 3.0f);
        }
        
        cb.fillStroke();
        cb.setRGBColorFill(0, 0, 0);
        
        //生成左侧的数字 2008-08-28 
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
	            		//左侧上的数值
		            	//ct.setYLine(y+z*i+6);
		            	//ct.setIndent(280);
		               // ct.addText(new Phrase(""+(40+i)));
		                //ct.addText(new Chunk(String.valueOf(40+i), FontFactory.getFont(FontFactory.defaultEncoding, 8)));
		            	//ct.addElement(new Phrase());
		            	//ct.go();
	            		
	            		//cb.setTextMatrix(280, y+z*i+6);
	                    //cb.showText(String.valueOf(40+i));
	            		
		                //旁边的短线 
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
		                //旁边的短线 
		                cb.moveTo(335, y+z*i);
		                cb.lineTo(340, y+z*i);
		                cb.stroke();
	            	}
            	}
            }
        }
        
        //线颜色cb.setColorStroke(Blue);
        //cb.setLineWidth(1f);
        //竖线            
        cb.moveTo(x+25, y+z*lineDegree-2);
        cb.lineTo(x+25, y+z);
        cb.stroke();
    }
	
    
    /**
     * 生成强项和弱项确定表5个总分
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
    	
    	cell = new PdfPCell(new Phrase("主要分析页",LeadingFont));
    	cell.setFixedHeight(25);
    	cell.setColspan(12);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("指数水平  强弱项确定表",TopFont));
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
    	
    	//空白行
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较选择",TopFont));
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
    	
    	cell = new PdfPCell(new Phrase("指数分数",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("指数分数均值",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("分数差异",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("临界值",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("强项与弱项",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("基础率",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
//    	空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较分数",WhiteFontChinese8));
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
    	cell = new PdfPCell(new Phrase("与五个",BoldFont));
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("言语理解指数",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results1[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results1[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("指数分数\n均值",RedFontChinese));
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
    	
    	cell = new PdfPCell(new Phrase("5个指数总分:"+s3 +"/5=",RedFontChinese));
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
    	
    	cell = new PdfPCell(new Phrase("指数分数均值:"+s3 ,RedFontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row4
    	cell = new PdfPCell(new Phrase("指数的",BoldFont));
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setBorderColor(red);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("视觉空间指数",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results2[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results2[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	cell = new PdfPCell(new Phrase("统计显著性水平\n"+s,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 5
    	cell = new PdfPCell(new Phrase("均值比",BoldFont));
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("流体推理指数",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results3[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results3[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较基础："+bjjc,FontChinese));
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
		
    	cell = new PdfPCell(new Phrase("工作记忆指数",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results4[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results4[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
		
    	cell = new PdfPCell(new Phrase("加工速度指数",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results5[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results5[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	cell.setColspan(12);
    	cell.setFixedHeight(5);
    	aTable.addCell(cell);
    	
    	//与总智商比
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
    	
    	cell = new PdfPCell(new Phrase("指数分数",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("总智商",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("分数差异",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("临界值",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("强项与弱项",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("基础率",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
//    	空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较分数",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthRight(0.3f);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//zzs row 2
    	cell = new PdfPCell(new Phrase("与",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("言语理解指数",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if(Vci_fsiq[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if(Vci_fsiq[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	

    	String s6 = "";
    	if(fsiq != -1){
    		s6 = String.valueOf(fsiqi);
    	}
    	cell = new PdfPCell(new Phrase("总智商  :          "+s6,RedFontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//zzs row 3
    	cell = new PdfPCell(new Phrase("总",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("视觉空间指数",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if(Vsi_fsiq[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if(Vsi_fsiq[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("统计显著性水平\n"+s,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//zzs row 4
    	cell = new PdfPCell(new Phrase("智",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("流体推理指数",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if(Fri_fsiq[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if(Fri_fsiq[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较基础: "+bjjc,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//zzs row 5
    	cell = new PdfPCell(new Phrase("商",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("工作记忆指数",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if(Wmi_fsiq[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if(Wmi_fsiq[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	cell = new PdfPCell(new Phrase("比",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBorderWidthBottom(0.9f);
		cell.setBorderColor(red);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("加工速度指数",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if(Psi_fsiq[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if(Psi_fsiq[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	
    	cell = new PdfPCell(new Phrase("确定指数水平的强项与弱项，请参照WPPSI-IV(CN)指导手册附表B.1和B.2",SmallFont));
    	cell.setFixedHeight(20);
    	cell.setColspan(12);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
	
    /**
     * 生成强项和弱项确定表10个指数总分
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
    	
    	cell = new PdfPCell(new Phrase("分测验水平  强弱项确定表",TopFont));
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
    	
    	//空白行
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较选择",TopFont));
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
    	
    	cell = new PdfPCell(new Phrase("量表分数",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("量表分数均值",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("分数差异",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("临界值",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("强项与弱项",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("基础率",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
//    	空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较分数",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthRight(0.3f);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 3
    	cell = new PdfPCell(new Phrase("与十",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("常识",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results1[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results1[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("分测验均值",RedFontChinese));
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
    	cell = new PdfPCell(new Phrase("10个指数分测验量表分数总和:"+s6 +"/10=",smallred));
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
    	
    	cell = new PdfPCell(new Phrase("分测验量表分数均值:"+s6 ,smallred));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row4
    	cell = new PdfPCell(new Phrase("个分",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("类同",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results2[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results2[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	cell = new PdfPCell(new Phrase("统计显著性水平\n"+s,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 5 6个指数
    	cell = new PdfPCell(new Phrase("测验",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("积木",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results3[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results3[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	String fensandu = "";
    	if(a.getZszf10fsd() != -1){
    		fensandu = String.valueOf(a.getZszf10fsd());
    	}
    	cell = new PdfPCell(new Phrase("10个指数分数分测验量表的分散度：  "+fensandu,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setColspan(3);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	
    	//row 6 6个指数
    	cell = new PdfPCell(new Phrase("量表",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("拼图",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results4[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results4[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 7 6个指数
    	cell = new PdfPCell(new Phrase("分数",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("矩阵推理",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results5[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results5[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 8 6个指数
    	cell = new PdfPCell(new Phrase("均值",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("图画概念",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results6[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results6[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 9 10个指数
    	cell = new PdfPCell(new Phrase("比",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("图片记忆",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results7[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results7[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 10 10个指数
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("动物家园",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results8[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results8[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 11 10个指数
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("找虫",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results9[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results9[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 12 10个指数
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBorderWidthBottom(0.9f);
		cell.setBorderColor(red);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("划消",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
    			    	aTable.addCell(cell);
    				}
    				if($results10[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results10[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	
    	
    	cell = new PdfPCell(new Phrase("确定分测验水平的强项与弱项，请参照WPPSI-IV(CN)指导手册附表B.3和B.4",SmallFont));
    	cell.setFixedHeight(20);
    	cell.setColspan(12);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    /**
     * 生成强项和弱项确定表6个指数总分
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
    	
    	cell = new PdfPCell(new Phrase("分测验水平  强弱项确定表",TopFont));
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
    	
    	//空白行
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较选择",TopFont));
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
    	
    	cell = new PdfPCell(new Phrase("量表分数",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("量表分数均值",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("分数差异",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("临界值",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("强项与弱项",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("基础率",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
//    	空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较分数",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	cell.setBorderWidthRight(0.3f);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 3
    	cell = new PdfPCell(new Phrase("与六",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("常识",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results1[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results1[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("分测验均值",RedFontChinese));
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
    	cell = new PdfPCell(new Phrase("6个总智商分测验量表分数总和:"+s6 +"/6=",smallred));
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
    	cell = new PdfPCell(new Phrase("分测验量表分数均值:"+s6 ,smallred));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row4
    	cell = new PdfPCell(new Phrase("个分",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("类同",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results2[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results2[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	cell = new PdfPCell(new Phrase("统计显著性水平\n"+s,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 5 6个指数
    	cell = new PdfPCell(new Phrase("测验",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("积木",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results3[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results3[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	String fensandu = "";
    	if(a.getZszf6fsd() != -1){
    		fensandu = String.valueOf(a.getZszf6fsd());
    	}
    	cell = new PdfPCell(new Phrase("6个指数分数分测验量表的分散度：  "+fensandu,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 6 6个指数
    	cell = new PdfPCell(new Phrase("量表",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("拼图",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results4[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results4[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 7 6个指数
    	cell = new PdfPCell(new Phrase("分数",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("矩阵推理",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results5[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results5[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 8 6个指数
    	cell = new PdfPCell(new Phrase("均值",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("图画概念",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results6[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results6[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 9 6个指数
    	cell = new PdfPCell(new Phrase("比",BlodFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("图片记忆",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results7[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results7[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	
    	//row 10 6个指数
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("动物家园",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results8[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results8[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 12 6个指数
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("找虫",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results9[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results9[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 13 6个指数
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBorderWidthBottom(0.9f);
		cell.setBorderColor(red);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("划消",FontChinese));
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
    					//空白行
    			    	cell = new PdfPCell();
    			    	cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
    			    	aTable.addCell(cell);
    				}
    				if($results10[i+1].equals("1")){
    					cell = new PdfPCell(new Phrase("强",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results10[i+1].equals("2")){
    					cell = new PdfPCell(new Phrase("弱",RedFontChinese));
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
    	
    	//空白行
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
    	
    	
    	cell = new PdfPCell(new Phrase("确定分测验水平的强项与弱项，请参照WPPSI-IV(CN)指导手册附表B.1,B.2,B.3和B.4",SmallFont));
    	cell.setFixedHeight(20);
    	cell.setColspan(12);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    /**
     * 生成强差异比较表
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
    	
    	cell = new PdfPCell(new Phrase("差异比较表",TopFont));
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
    	
    	//空白行
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较选择",TopFont));
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
    	
    	cell = new PdfPCell(new Phrase("量表分数1",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("量表分数2",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("分数差异",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("临界值",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("显著性差异",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("基础率",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
//    	空白行
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
    	cell = new PdfPCell(new Phrase("统计显著性水平\n"+s,FontChinese));
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
		
		cell = new PdfPCell(new Phrase("言语理解-视觉空间",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results1[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较基础： "+bjjc,FontChinese));
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
		
    	cell = new PdfPCell(new Phrase("言语理解-流体推理",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results2[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 5 6个指数
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("言语理解-工作记忆",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results3[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 6 6个指数
    	cell = new PdfPCell(new Phrase("指",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("言语理解-加工速度",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results4[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 7 6个指数
    	cell = new PdfPCell(new Phrase("数",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("视觉空间-流体推理",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results5[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 8 6个指数
    	cell = new PdfPCell(new Phrase("水",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("视觉空间-工作记忆",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results6[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 9 6个指数
    	cell = new PdfPCell(new Phrase("平",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("视觉空间-加工速度",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results7[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	

    	//row 10 6个指数
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("流体推理-工作记忆",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results8[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 11 6个指数
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("流体推理-加工速度",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results9[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 12 6个指数
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("工作记忆-加工速度",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results10[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	
    	
    	//row 3 分测验
    	cell = new PdfPCell(new Phrase("分",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("常识-类同",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results11[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较选择",TopFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
    	cell.setBackgroundColor(new Color(0,0,0));
    	aTable.addCell(cell);
    	
    	//row 14 6个指数
    	cell = new PdfPCell(new Phrase("测",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("积木-拼图",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results12[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("统计显著性水平："+s , FontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(20);
    	cell.setColspan(3);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	aTable.addCell(cell);
    	
    	//row 15 6个指数
    	cell = new PdfPCell(new Phrase("验",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("矩阵推理-图画概念",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results13[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	
    	
    	//row 16 6个指数
    	cell = new PdfPCell(new Phrase("水",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("图片记忆-动物家园",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results14[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	
    	//row 17 6个指数
    	cell = new PdfPCell(new Phrase("平",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBorderWidthBottom(0.9f);
		cell.setBorderColor(red);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(20);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("找虫-划消",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(20);
        		    	aTable.addCell(cell);
    				}
    				if($results15[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	
    	
    	cell = new PdfPCell(new Phrase("比较指数分数之间或分测验分数之间的差异，请参照WPPSI-IV(CN)指导手册附表B.5,B.6,B.7和B.8",SmallFont));
    	cell.setFixedHeight(20);
    	cell.setColspan(12);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
    
    /**辅助
     * */
    public static PdfPTable CreateFuzhu(Font LeadingFont,float columnWidth) throws DocumentException
    {	
    	PdfPTable aTable = new PdfPTable(1);
        int headerwidths[] = {10};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        
        PdfPCell cell = new PdfPCell(new Phrase("辅助分析页",LeadingFont));
        cell.setBorderWidth(0);
        aTable.addCell(cell);
        aTable.setTotalWidth(columnWidth);
        return aTable;
    }
    
    /**续页
     * */
    public static PdfPTable CreateXu(Font LeadingFont,float columnWidth) throws DocumentException
    {	
    	PdfPTable aTable = new PdfPTable(1);
        int headerwidths[] = {10};
        aTable.setWidths(headerwidths);
        aTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        
        PdfPCell cell = new PdfPCell(new Phrase("主要分析页（续）",LeadingFont));
        cell.setBorderWidth(0);
        aTable.addCell(cell);
        aTable.setTotalWidth(columnWidth);
        return aTable;
    }
    
    
    /**
     * 生成原始分数与量表分数转换表函数
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
   		String $item_name[] = {"积木","常识","矩阵推理","找虫","图片记忆","类同","图画概念","划消","动物家园","拼图","动物译码","指认图片","图片命名","随机划消","有序划消"};
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
   		
   		cell = new PdfPCell(new Phrase("量表分数总和",HeadFont));
   		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
   		cell.setBorderWidth(0);
   		cell.setColspan(7);
   		cell.setFixedHeight(25);
   		aTable3.addCell(cell);
   		
   		cell = new PdfPCell(new Phrase("分测验",WhiteFontChinese));
   		cell.setFixedHeight(25);
   		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
   		cell.setColspan(2);
   		cell.setPaddingTop(7);
   		cell.setBorderColor(White);
   		cell.setBackgroundColor(red);
    	aTable3.addCell(cell);
    	
    	
    	cell = new PdfPCell(new Phrase("量表分数",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setColspan(5);  //占5个格子
    	cell.setFixedHeight(25);
    	cell.setPaddingTop(7);
    	cell.setBorderColor(White);
   		cell.setBackgroundColor(red);
    	aTable3.addCell(cell);
    	
    	//填充专用
    	PdfPCell blue_cell = new PdfPCell();
    	blue_cell.setBackgroundColor(red);
    	blue_cell.setBorderColor(Color.white);
    	blue_cell.setFixedHeight(20);
    	
    	PdfPCell white_cell = new PdfPCell(new Phrase("无效",FontChinese));
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
    			//加名称
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
    			
    			//加英文名称
    			cell = new PdfPCell(new Phrase($item_name1[i-1],BoldFont1));
    			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    			//cell.setPaddingTop(5);
    			cell.setFixedHeight(15);
    			cell.setBorderWidth(0.7f);
    			cell.setBorderWidthLeft(0);
    			cell.setFixedHeight(20);
    			cell.setBorderColor(red);
    			aTable3.addCell(cell);
    			
    			
    			if($item_name[i-1] == "图片命名" || $item_name[i-1] == "指认图片")
    			{
    				if($results[i-1] != -1){
    					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//输入的数据
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
    			
    			//    		第二列
    			if($item_name[i-1] == "积木" || $item_name[i-1] == "矩阵推理"|| $item_name[i-1] == "找虫"|| $item_name[i-1] == "图片记忆"
    				|| $item_name[i-1] == "图画概念" || $item_name[i-1] == "划消" || $item_name[i-1] == "动物家园" || $item_name[i-1] == "拼图" || $item_name[i-1] == "动物译码")
    			{
    				if($results[i-1] != -1){
    					if($item_name[i-1] == "划消" || $item_name[i-1] == "动物家园" || $item_name[i-1] == "拼图" || $item_name[i-1] == "动物译码"){
    						cell = new PdfPCell(new Phrase("("+$result_tally[i-1]+")",FontChinese));//输入的数据
    					}else{
    						cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//输入的数据
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
    			//第三列
    			if( $item_name[i-1] == "积木"|| $item_name[i-1] == "常识" || $item_name[i-1] == "矩阵推理" || $item_name[i-1] == "类同"
    				|| $item_name[i-1] == "图画概念" || $item_name[i-1] == "拼图")
    			{
    				if($results[i-1] != -1){
    					if(  $item_name[i-1] == "图画概念" || $item_name[i-1] == "拼图" ){
    						cell = new PdfPCell(new Phrase("("+$result_tally[i-1]+")",FontChinese));//输入的数据
    					}else{
    						cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//输入的数据
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
    			
    		
    		//第四列
			if( $item_name[i-1] == "找虫"|| $item_name[i-1] == "图片记忆" || $item_name[i-1] == "划消" || $item_name[i-1] == "动物家园"
				|| $item_name[i-1] == "动物译码" )
			{
				if($results[i-1] != -1){
					if( $item_name[i-1] == "动物译码" ){
						cell = new PdfPCell(new Phrase("("+$result_tally[i-1]+")",FontChinese));//输入的数据
					}else{
						cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//输入的数据
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
			
			//第五列
			if( $item_name[i-1] == "随机划消"|| $item_name[i-1] == "有序划消" )
			{
				if($results[i-1] != -1){
					cell = new PdfPCell(new Phrase(""+$result_tally[i-1],FontChinese));//输入的数据
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
            
            //最后一行
            if(i==16)
            {
            	cell = new PdfPCell(new Phrase("量表分数总和:  ",SmallFontChinese));
            	cell.setColspan(2);
            	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            	cell.setBorderWidth(0);
	            aTable3.addCell(cell);

	            //20090530添加*号以作注释
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
	   	cell = new PdfPCell(new Phrase("语言\n接收",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(0.9f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	cell = new PdfPCell(new Phrase("非\n言语",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(0.9f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	cell = new PdfPCell(new Phrase("一般\n能力",SmallFontChinese));
	   	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	   	cell.setBorderWidth(0);
	   	cell.setFixedHeight(20);
	   	cell.setBorderWidthBottom(0.9f);
	   	cell.setBorderColor(red);
	   	aTable3.addCell(cell);
	   	cell = new PdfPCell(new Phrase("认知\n效率",SmallFontChinese));
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
     * 生成量表分数总和与合成分数转换表
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
    	
    	//填充用
    	PdfPCell white_cell = new PdfPCell(new Phrase("无效",FontChinese));
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
    	
        cell = new PdfPCell(new Phrase("量表分数总和与辅助指数分数转换表",HeadFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPadding(Padding);
    	cell.setBorderWidth(0);
    	cell.setColspan(5);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("量表",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(5);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("量表分数\n总和",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPadding(Padding);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("辅助指数\n分数",WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingTop(5f);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("百分\n等级",WhiteFontChinese));
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
    	
    	cell = new PdfPCell(new Phrase("置信区间\n"+z,WhiteFontChinese));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPadding(Padding);
    	cell.setBorderColor(White);
    	cell.setBackgroundColor(red);
    	aTable.addCell(cell);
    		
    		
    	cell = new PdfPCell(new Phrase("语言接收",FontChinese));
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
    	
    	cell = new PdfPCell(new Phrase("非言语",FontChinese));
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
    	
   		cell = new PdfPCell(new Phrase("一般能力",FontChinese));
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
   		
   		cell = new PdfPCell(new Phrase("认知效率",FontChinese));
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
     * 生成强差异比较表辅助
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
    	
    	cell = new PdfPCell(new Phrase("差异比较表",TopFont));
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
    	
    	//空白行
    	cell = new PdfPCell();
		cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较选择",TopFont));
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
    	
    	cell = new PdfPCell(new Phrase("量表分数1",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBorderWidth(0);
    	cell.setBackgroundColor(bgcolor);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("量表分数2",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("分数差异",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("临界值",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("显著性差异",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	cell = new PdfPCell(new Phrase("基础率",WhiteFontChinese8));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setBackgroundColor(bgcolor);
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
//    	空白行
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
    	cell = new PdfPCell(new Phrase("统计显著性水平\n"+s,FontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0);
    	cell.setFixedHeight(25);
    	cell.setBorderWidthBottom(0.9f);
    	cell.setBorderColor(red);
    	cell.setColspan(3);
    	aTable.addCell(cell);
    	
    	//row 3
    	cell = new PdfPCell(new Phrase("指数\n水平",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("一般能力指数-总智商",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results1[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
    	cell = new PdfPCell();
    	cell.setBorderWidth(0);
    	aTable.addCell(cell);
    	
    	cell = new PdfPCell(new Phrase("比较基础："+bjjc,FontChinese));
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
		
		cell = new PdfPCell(new Phrase("一般能力指数-认知效率",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results2[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	cell = new PdfPCell(new Phrase("分测验\n水平",BoldFont));
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    	cell.setBorderWidth(0);
		cell.setBorderWidthBottom(0);
		cell.setBackgroundColor(rowspanColor);
		cell.setFixedHeight(25);
		aTable.addCell(cell);
		
    	cell = new PdfPCell(new Phrase("指认图片-图片命名",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results3[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
		
    	cell = new PdfPCell(new Phrase("随机划消-有序划消",FontChinese));
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
    					cell = new PdfPCell(new Phrase("否",RedFontChinese));
        				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				cell.setBorderWidth(0);
        		    	cell.setBorderWidthBottom(0.9f);
        		    	cell.setBorderColor(red);
        		    	cell.setFixedHeight(25);
        		    	aTable.addCell(cell);
    				}
    				if($results4[i].equals("1")){
    					cell = new PdfPCell(new Phrase("是",RedFontChinese));
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
    	
    	//空白行
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
    	
    	cell = new PdfPCell(new Phrase("指数水平比较，请参照WPPSI-IV(CN)指导手册附表B.10和B.11\n分测验水平比较，参照附表B.7,B.8",SmallFont));
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
    	
    	String $item_name[] = {"语言接收",	"非言语",	"一般能力", "认知效率"};
    	int vai = a.getVai(), nvi = a.getNvi(), gai = a.getGai() ,cpi = a.getCpi();
    	String $results[] = {String.valueOf(a.getVaii()) , String.valueOf(a.getNvii()), String.valueOf(a.getGaii()), String.valueOf(a.getCpii())};
    	
    	BaseFont b_f = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    	Font WhiteFontChinese = new Font(b_f, 7, Font.BOLD,White);
    	
    	PdfPCell cell = null;
    	
    	cell = new PdfPCell(new Phrase("辅助指数分数剖析图",LeadingFont));
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
    	
    	//当 总智商 大于 160 时出现 提示 2011-03-18
    	if(vai > 160 || nvi> 160 || gai > 160)
    		CreateFloatText(cb, template, bfChinese,"注：分数高于160分时，便会超出本图显示范围。", -138,80,3,Black);
    	
    	aTable.setTotalWidth(columnWidth);
    	return aTable;
    }
	
	/**
     * 生成标尺[第四页]
     * @param xAxis X轴
     * @param yAxis Y轴
     * @param zHeight 每条线的距离
     * @param lineDegree 尺寸的长度默认是120
     * @param cb PdfContentByte对象
     * @param Black 字条条形颜色
     * @param Blue 中间线条颜色
     * @param value 输入值
     * @param bl 判断那一条是第一竖线
     * @param ct ColumnText对象
     * @param FontChinese 字体
     * @throws DocumentException
     * @throws IOException 
     */
    public static void CreateRuler_Page4(int xAxis,int yAxis,float zHeight,int lineDegree, PdfContentByte cb, Color Black,Color Blue,float value,boolean bl,ColumnText ct,Font FontChinese,PdfWriter writer) throws DocumentException, IOException
    {
    	int x=xAxis,y=yAxis;
    	float z=zHeight;
    	
        
    	if(bl==true)
    	{
            //中间蓝色线
            cb.setLineWidth(2f);
            cb.setColorStroke(Blue);
            cb.moveTo(x-10, y+z*60);
            cb.lineTo(x+215, y+z*60);
            cb.stroke();
	    }
        //画图 红褐色
        cb.setColorStroke(Black);
        cb.setLineWidth(0);
        //cb.setRGBColorFill(230, 203, 100);//黄色
        cb.setRGBColorFill(0,0,0);
        
        if(value == 0)
        {
        	//等于0时不作图,这种情况是没有值时为0
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
        	//不为0时图处于底线
        	cb.circle(x+25, y+z*(value-40), 3.0f);
        }
        
        cb.fillStroke();
        cb.setRGBColorFill(0, 0, 0);
        
        //生成左侧的数字 2008-08-28 
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
	            		//左侧上的数值
		            	//ct.setYLine(y+z*i+6);
		            	//ct.setIndent(280);
		               // ct.addText(new Phrase(""+(40+i)));
		                //ct.addText(new Chunk(String.valueOf(40+i), FontFactory.getFont(FontFactory.defaultEncoding, 8)));
		            	//ct.addElement(new Phrase());
		            	//ct.go();
	            		
	            		//cb.setTextMatrix(280, y+z*i+6);
	                    //cb.showText(String.valueOf(40+i));
	            		
		                //旁边的短线 
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
		                //旁边的短线
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
        
        //线颜色cb.setColorStroke(Blue);
        //cb.setLineWidth(1f);
        //竖线            
        cb.moveTo(x+25, y+z*lineDegree-2);
        cb.lineTo(x+25, y+z);
        cb.stroke();
    }
    
    /**
     * 生成左侧尺子的数字 2008-08-28 17:00
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
        int i = 735 , j = 335;  //i为y坐标，j为x坐标
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
