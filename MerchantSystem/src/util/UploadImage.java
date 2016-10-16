package util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

public class UploadImage {
	public static String uploadLogo(FileItem fi, String userName, ServletContext servletContext)throws Exception
	{
		String fileRealPath = null;
		String fileRelativePath = null;
		
		try {
			String fileName = fi.getName();
			int index = fileName.lastIndexOf(".");
			if(index <= 0)
				throw new IOException();
			String extension = fileName.substring(index+1);
			fileRealPath = servletContext.getRealPath("/img/logo/" + userName + "." + extension);
			fileRelativePath = servletContext.getContextPath() + "/img/logo/" + userName + "." + extension;
			
			
			InputStream in = fi.getInputStream();
			byte[] bs = new byte[in.available()];
			in.read(bs);
			File storeFile = new File(fileRealPath);
			fi.write(storeFile);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		System.out.println(fileRelativePath);
		return fileRelativePath;
		
	}
	
	public static void uploadDishImage(FileItem fi, String fileFolderPath)throws Exception
	{
	
		File theDir = new File(fileFolderPath);
		if (!theDir.exists())
		{
			theDir.mkdir();
		}
		
		InputStream in = fi.getInputStream();
		byte[] bs = new byte[in.available()];
		in.read(bs);
		File storeFile = new File(fileFolderPath + "/" +fi.getName());
		fi.write(storeFile);	
	}
	
	public static void deleteImage(String fileFolderPath)
	{
		File folder = new File(fileFolderPath);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  listOfFiles[i].delete();
		      } 
		    }
	}
	
	public static ArrayList<String> getdishPath(ServletContext servletContext, String fileFolderPath)
	{
		ArrayList<String> result = new ArrayList<String>();
		
		File folder = new File(servletContext.getRealPath(fileFolderPath));
		File[] listOfFiles = folder.listFiles();
		if(listOfFiles != null){
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  result.add(servletContext.getContextPath()+ fileFolderPath + "/"+listOfFiles[i].getName());
		      } 
		    }
		}
		return result;
		
	}


}
