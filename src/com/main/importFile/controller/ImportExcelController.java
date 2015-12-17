package com.main.importFile.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.main.common.bean.Result;
import com.main.common.util.ImportExcelHSSFUtil;
import com.main.common.util.ImportExcelXSSFUtil;

@Controller
@RequestMapping("/excelRead")
public class ImportExcelController {

	
	@RequestMapping(value = "/readExcel.do", method = RequestMethod.POST)
	public String readExcel(
			MultipartFile file, Model model) {
		Result result = new Result();
		try {
			if (!file.isEmpty()) {
				String suffix = null;
				int index = file.getOriginalFilename().lastIndexOf(".");
				if (index != -1
						&& index != file.getOriginalFilename().length() - 1) {
					suffix = file.getOriginalFilename().substring(index + 1);					
					if (suffix == null || "xls|xlsx".indexOf(suffix) == -1) {
						result.setMessage("���ϴ�Excel�ļ�");
						result.setResultCode("1001"); // 1001Ϊ �ļ���ʽ����ȷ
					}else{
						
						InputStream is = file.getInputStream();				
						//List<String> results = ImportExcelHSSFUtil.getExcelStringList(is);
						List<String> results = ImportExcelXSSFUtil.getExcelStringList(is);
					    result.setResults(results);
						result.setMessage("��ȡ�ɹ�!");
						result.setResultCode("1000"); // 1000�ϴ��ɹ�										
					}
				}
				
			}
		} catch (Exception e) {
			result.setMessage("�ϴ�ʧ��"+e.getMessage());
			result.setResultCode("1003"); // 1000�ϴ�ʧ��
		}
		model.addAttribute("result", result);
		return "jsp/listExcelContent";

	}
}
