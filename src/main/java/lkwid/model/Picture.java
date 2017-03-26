package lkwid.model;

import java.io.IOException;
import java.net.URL;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class Picture {
	private URL picturePath;	
	
	public Resource getPicturePath() {
		return picturePath == null ? null : new UrlResource(picturePath);
	}

	public void setPicturePath(Resource picturePath) throws IOException {
		this.picturePath = picturePath.getURL();
	}

}
