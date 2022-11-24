package types;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UncheckedIOException;
import java.util.Base64;

import javax.imageio.ImageIO;

public class Image implements Infos, Serializable {

	private String image;
	
	public Image (BufferedImage img, String formatName) {
		image = imgToBase64String(img, formatName);
	}
	
	public BufferedImage getImage() {
		
		byte[] decodedBytes = Base64.getDecoder().decode(image);
		BufferedImage bufferedimage = null;
		try {
			 bufferedimage = ImageIO.read(new ByteArrayInputStream(decodedBytes));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bufferedimage;
	}
	
	public static String imgToBase64String(final RenderedImage img, final String formatName)
	{
	  final ByteArrayOutputStream os = new ByteArrayOutputStream();

	  try
	  {
	    ImageIO.write(img, formatName, os);
	    return Base64.getEncoder().encodeToString(os.toByteArray());
	  }
	  catch (final IOException ioe)
	  {
	    throw new UncheckedIOException(ioe);
	  }
	}
	
}
