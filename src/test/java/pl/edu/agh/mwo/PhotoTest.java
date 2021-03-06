package pl.edu.agh.mwo;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("testyPhoto")
class PhotoTest {

	// skladowe

	String imagePath;
	String imagePath2;
	String notImage;
	Photo photo;
	// AAA Arrange Act Assert

	// preinitialization
	@BeforeEach
	public void init() throws NotJpgException {
		// fixture
		imagePath = "src/main/resources/skillvssalary.jpeg";
		imagePath2 = "src/main/resources/success.jpg";
		notImage = "src/main/resources/dwa";
		photo = new Photo(imagePath);
	}

	@Test
	@DisplayName("zmianaZdjecia")
	// sprawdzanie zmiany zdjecia wczytywania
	void testLoadPhoto() throws NotJpgException {
		boolean theSame = true;
		BufferedImage image1 = photo.getImage();
		photo.loadImage(imagePath2);
		BufferedImage image2;
		image2=photo.getImage();
		if (image1.getWidth() != image2.getWidth() || image1.getHeight() != image2.getHeight()) {
			theSame = false;
		}

		int width = image1.getWidth();
		int height = image1.getHeight();
		// porownanie rgb
		outer_loop: while (theSame == true) {
			for (int vertical = 0; vertical < height; vertical++) {
				for (int horizontal = 0; horizontal < width; horizontal++) {
					if (image1.getRGB(vertical, horizontal) != image2.getRGB(vertical, horizontal)) {
						theSame = false;
						break outer_loop;
					}
				}
			}
		}
		assertFalse(theSame);
	}
	
	// sprawdzanie ustawiania komentarza
	@Test
	@DisplayName("ustawianieKomentarza")
	void testSetComment() {
		String comment="to jest bardzo fajny obrazek";
		photo.setComment(comment);
		assertEquals(photo.getComment(), comment);
	}
	
	// sprawdzanie, czy rzuca exception, jak nie mamy jpg
	@Test 
	@DisplayName("czyToJpg")
	void testExceptionIfNotJpg() {
		Assertions.assertThrows(NotJpgException.class, () -> {photo.loadImage(notImage);});
	}
	
}
