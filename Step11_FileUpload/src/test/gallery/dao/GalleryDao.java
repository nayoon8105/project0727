package test.gallery.dao;

import java.util.List;

import test.gallery.dto.GalleryDto;

public class GalleryDao {
	private static GalleryDao dao;
	private GalleryDao() {}
	public static GalleryDao getInstance() {
		if(dao==null) {
			dao=new GalleryDao();
		}
		return dao;
	}
	
	public boolean insert(GalleryDto dto) {
		return false;
	}
	public List<GalleryDto> getList(){
		return null;
	}
}





