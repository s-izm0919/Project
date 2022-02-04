package utility;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import context.RequestContext;

public class ImageUpload {
	Map fields = new HashMap();
	public Map upload(RequestContext reqc){
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String path = req.getServletContext().getRealPath("data");
		System.out.println("ImageUploadManager:path="+path);

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);

		try {
			List list = sfu.parseRequest(req);
			Iterator iterator = list.iterator();

			int count = 1;

			while(iterator.hasNext()){
				FileItem item = (FileItem)iterator.next();

				if (!item.isFormField()){
					String filepath = item.getName();
					int endindex = filepath.lastIndexOf('\\'); // 最後の'/'のインデックスを検索
					String filename = filepath.substring(endindex + 1);
					System.out.println("ファイル名:" + filename);

					if ((filename != null) && (!filename.equals("")) && count==3){
						Date nowdate = new Date();
						SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String date = dateformat.format(nowdate);
						String date2 = date.replace("-", "").replace(":", "").replace(" ", "");
						item.write(new File("C:\\Users\\dai24\\git\\Project\\project\\WebContent\\images\\" + date2 + "_main_image_" + filename));
						filename = "C:\\Users\\dai24\\git\\Project\\project\\WebContent\\images\\" + date2 + "_main_image_" + filename;
						//"C:\\Users\\????\\git\\project\\project\\WebContent\\images\\"  ?の部分に自分のPCのユーザー名を入れて上の二文と入れ替えてください
						//"\\***.**.***.**\\public\\2021\\卒業制作\\mercari\\images\\"  //AWS-version
						fields.put("mainImagePath",filename);
					}else if((filename != null) && (!filename.equals("")) && count==6){
						Date nowdate = new Date();
						SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String date = dateformat.format(nowdate);
						String date2 = date.replace("-", "").replace(":", "").replace(" ", "");
						item.write(new File("C:\\Users\\dai24\\git\\Project\\project\\WebContent\\images\\" + date2 + "_data_" + filename));
						filename = "C:\\Users\\dai24\\git\\project\\Project\\WebContent\\images\\" + date2 + "_data_" + filename;
						//"C:\\Users\\????\\git\\project\\project\\WebContent\\images\\"  ?の部分に自分のPCのユーザー名を入れて上の二文と入れ替えてください
						//"\\***.**.***.**\\public\\2021\\卒業制作\\mercari\\images\\"  //AWS-version
						fields.put("itemDataPath",filename);
					}
				}else if (item.isFormField()) {
					this.setFormField(item);
				}
				count++;
			}
		}catch (FileUploadException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return fields;
	}
	public void setFormField(FileItem item) throws ServletException {
		try {
			String name = item.getFieldName();
			String field = item.getString("UTF8");

			fields.put(name,field);
			System.out.println("ImageUploadManager:name="+name+",field="+field);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public Map getFields() {
		return fields;
	}
}