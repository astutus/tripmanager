package pl.edu.agh.mwo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.imageio.ImageIO;

class Photo {
	protected BufferedImage image;
	protected String comment;

	protected Photo(String imagePath) throws NotJpgException {
		checkIsJpg(imagePath);
		try {
			image = ImageIO.read(new File(imagePath));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public boolean loadImage(String filePath) throws NotJpgException {
		checkIsJpg(filePath);
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return true;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void checkIsJpg(String path) throws NotJpgException {
		boolean isFormatOk = false;
		File file = new File(path);
		try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
			// sprawdzanie kodu, powinno byc: 0x ff d8
			/*
			 * hexdump -C ./success.jpg | head 
			 * 00000000 ff d8 ff e0 00 10 4a 46 49 46 00 01
			 * 01 00 00 01 |......JFIF......|
			 */
			byte[] buffer = new byte[2];
			raf.read(buffer, 0, 2);
			int first = buffer[0] & 0xff;
			String hex_first = Integer.toHexString(first);
			int second = buffer[1] & 0xff;
			String hex_second = Integer.toHexString(second);
			if (hex_first.equals("ff") && hex_second.equals("d8")) {
				isFormatOk = true;
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		if (isFormatOk != true) {
			throw new NotJpgException();
		}
	}

}
