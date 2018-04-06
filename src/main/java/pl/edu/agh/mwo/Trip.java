package pl.edu.agh.mwo;

import java.awt.image.BufferedImage;
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


	public boolean addPhoto(String filePath) throws TheSameImageException {
		boolean isItOk=false;
		try {
			Photo photo=new Photo(filePath);
			BufferedImage image1=photo.getImage();
			for (Photo p: photos) {
				BufferedImage bi=p.getImage();
				theSameImage(image1, bi);
			}
			photos.add(photo);
			isItOk=true;
		}
		catch (NotJpgException e) {
			e.printStackTrace();
		}
		return isItOk;
	}
	
	protected void theSameImage(BufferedImage image1, BufferedImage image2) throws TheSameImageException {
		boolean theSame = false;
		if (image1.getWidth() == image2.getWidth() && image1.getHeight() == image2.getHeight()) {
			int width = image1.getWidth();
			int height = image1.getHeight();
			// porownanie rgb
			outer_loop: while (theSame == false) {
				for (int vertical = 0; vertical < height; vertical++) {
					for (int horizontal = 0; horizontal < width; horizontal++) {
						if (image1.getRGB(vertical, horizontal) == image2.getRGB(vertical, horizontal)) {
							theSame = true;
							break outer_loop;
						}
					}
				}
			}
			if (theSame == true) {
				throw new TheSameImageException();
			}

		}

	} 

}
