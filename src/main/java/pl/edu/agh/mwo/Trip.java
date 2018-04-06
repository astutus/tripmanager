package pl.edu.agh.mwo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Trip {

	String name;
	String description;
	List<Photo> photos;

	public Trip(String string, String string2) {
		this.name=string;
		this.description=string2;
		photos=new ArrayList<Photo>();
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}


	public boolean addPhoto(String filePath) {
		boolean isItOk=false;
		try {
			Photo photo=new Photo(filePath);
			photos.add(photo);
			isItOk=true;
		}
		catch (NotJpgException e) {
			e.printStackTrace();
		}
		return isItOk;
	}

}
