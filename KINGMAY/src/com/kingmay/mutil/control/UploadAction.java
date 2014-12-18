package com.kingmay.mutil.control;

import com.opensymphony.xwork2.ActionSupport;
import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


public class UploadAction  extends ActionSupport{
	private File upload;
	private String uploadFileName;
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public UploadAction(){
		
	}
	//�ļ��ϴ�����(����)
	public void uploadFile(File source,File target){
		try{
			//����������
			FileInputStream fis=new FileInputStream(source);
			DataInputStream dis=new DataInputStream(fis);
			//���������
			FileOutputStream fos=new FileOutputStream(target);
			DataOutputStream dos=new DataOutputStream(fos);
			int temp=0;
			while((temp=dis.read())!=-1){
				dos.write(temp);
			}
			//�ر���
			dis.close();
			fis.close();
			dos.close();
			fos.close();	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	public String execute() throws Exception{
		//Ŀ��·��
		String filePath=ServletActionContext.getServletContext().getRealPath("upload")+"\\"+uploadFileName;
		File target=new File(filePath);
		//uploadFile(getUpload(),target);
		uploadFile(upload,target);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("file", uploadFileName);
		return SUCCESS;
	}
}
