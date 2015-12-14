package com.main.user.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.main.common.bean.Page;
import com.main.common.bean.PageBean;
import com.main.common.bean.Result;
import com.main.common.util.DateUtil;
import com.main.common.util.RandomStrUtil;
import com.main.user.bean.StudentBean;
import com.main.user.model.Student;
import com.main.user.service.IStudentService;

/**
 * �û�������
 * @author zhangwu
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IStudentService studentServiceImpl;
	
	
	@RequestMapping(value = "/uploadimg.do", method = RequestMethod.POST)
	@ResponseBody
	public HttpEntity<Result> handleFormUpload(
			MultipartFile file, Model model) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_HTML);
		try {
			if (!file.isEmpty()) {
				String suffix = null;
				int index = file.getOriginalFilename().lastIndexOf(".");
				if (index != -1
						&& index != file.getOriginalFilename().length() - 1) {
					suffix = file.getOriginalFilename().substring(index + 1);
				}
				if (suffix == null || "png|jpg|bmp".indexOf(suffix) == -1) {
					Result result = new Result();
					result.setMessage("���ϴ�ͼƬ�ļ�");
					result.setResultCode("1001"); // 1001Ϊ �ļ���ʽ����ȷ
					HttpEntity<Result> httpEntity = new HttpEntity<Result>(
							result, headers);
					return httpEntity;
				}
				Result result = new Result();
				InputStream is = file.getInputStream();
				BufferedImage src = ImageIO.read(is);
				if (src.getWidth() != 222 || src.getHeight() != 192) {
					result.setMessage("ͼƬ��С�����Ϲ淶");
					result.setResultCode("1002"); // 1002ΪͼƬ��С�����Ϲ淶
					HttpEntity<Result> httpEntity = new HttpEntity<Result>(
							result, headers);
					return httpEntity;
				} else {
					String remoteFileName = SaveFileFromInputStream(file.getInputStream(),"D:"+File.separatorChar+File.separatorChar+"image",suffix);

					result.setMessage(remoteFileName);
					result.setResultCode("1000"); // 1000�ϴ��ɹ�
					HttpEntity<Result> httpEntity = new HttpEntity<Result>(
							result, headers);
					return httpEntity;
				}
			}
		} catch (Exception e) {
			Result result = new Result();
			result.setMessage("�ϴ�ʧ��"+e.getMessage());
			result.setResultCode("1003"); // 1000�ϴ�ʧ��
			HttpEntity<Result> httpEntity = new HttpEntity<Result>(
					result, headers);
			return httpEntity;
		}
		return null;

	}
	
	
	
	
    public String SaveFileFromInputStream(InputStream stream,String path,String suffix) throws IOException   
    {   
    	String fileName = DateUtil.format(new Date(), DateUtil.DATE)+RandomStrUtil.getCharAndNumr(5);
        String folderName = DateUtil.format(new Date(), DateUtil.DATE);
    	String savePath = path + File.separatorChar+File.separatorChar + folderName + File.separatorChar+File.separatorChar + fileName +"."+suffix;
    	String folderPath =path + File.separatorChar + folderName; 
        File file = new File(folderPath);
    	if(!file .exists() && !file .isDirectory())      
		{       
		    System.out.println("//������");  
		    file .mkdir();    
		} else   
		{  
		    System.out.println("//Ŀ¼����");  
		}  
    	FileOutputStream fs=new FileOutputStream(savePath);   
        byte[] buffer =new byte[1024*1024];   
        int bytesum = 0;   
        int byteread = 0;    
        while ((byteread=stream.read(buffer))!=-1)   
        {   
           bytesum+=byteread;   
           fs.write(buffer,0,byteread);   
           fs.flush();   
        }    
        fs.close();   
        stream.close();
		return savePath;         
   }         
	
	@RequestMapping("/addUser.do")
	public String addUser(Student student){
		studentServiceImpl.saveStudent(student);		
		return "redirect:/user/listUser.do";
		
	}
	
	@RequestMapping("/listUser.do")
	public String listUser(StudentBean queryBean,PageBean pageBean,ModelMap map){
		Page<Student> page = studentServiceImpl.findStudents(queryBean,pageBean);
		map.put("page", page);
		map.put("pageBean", page.getPageBean());
		map.put("queryBean", queryBean);
		return "jsp/listStudent";
	}
	
	
	@RequestMapping("/queryUser.do")
	public String queryUser(String sid,ModelMap map){
		Student student = studentServiceImpl.queryStident(sid);
		map.put("s", student);
		return "jsp/addStudent";
	}
	
	
	@RequestMapping("/deleteUser.do")
	public String deleteUser(String sid){
		studentServiceImpl.deleteStudent(sid);
		return "redirect:/user/listUser.do";
	}
	
	@RequestMapping("/updateUser.do")
	public String updateUser(Student student){
		studentServiceImpl.updateStudent(student);
		return "redirect:/user/listUser.do";
	}
}