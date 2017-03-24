package lkwid.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lkwid.model.Picture;

@Controller
public class ProfilePictureController {	
	private Picture picture;
	
	@Autowired
	public ProfilePictureController(Picture picture) {
		this.picture = picture;
	}

	@RequestMapping("/picture")
	public String uploadPicture(Model model) {
		return "form/picture";		
	}
	
	@RequestMapping("/userPicture")
	public void userPicture(HttpServletResponse response) throws IOException {
		Resource picturePath = picture.getPicturePath();		
		response.setHeader("Content-Type", URLConnection.guessContentTypeFromName(picturePath.getFilename()));
		IOUtils.copy(picturePath.getInputStream(), response.getOutputStream());
	}
	
	@PostMapping("/upload")
	public String onUpload(MultipartFile file, RedirectAttributes redirectAttrs, Model model) throws IOException {
		if (file.isEmpty() || !isImage(file)) {
			redirectAttrs.addFlashAttribute("error", "Plik nie jest obrazem");
			return "redirect:/upload";
		}
		Resource picturePath = copyToPictures(file);
		picture.setPicturePath(picturePath);
		return "redirect:/resume";
	}

	private Resource copyToPictures(MultipartFile file) throws IOException, FileNotFoundException {		
		File tempFile = File.createTempFile("pic", getFileExtension(file.getOriginalFilename()));
		try (InputStream in = file.getInputStream();
				OutputStream out = new FileOutputStream(tempFile)) {
			IOUtils.copy(in, out);
		}
		return new FileSystemResource(tempFile);
	}

	private boolean isImage(MultipartFile file) {		
		return file.getContentType().startsWith("image");
	}

	private String getFileExtension(String filename) {
		return filename.substring(filename.lastIndexOf("."));
	}	

}
