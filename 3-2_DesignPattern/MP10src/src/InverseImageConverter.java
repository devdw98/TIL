import java.awt.image.*;
//import java.awt.Image.BufferedImage;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

//import java.imageio.*;

class InverseImageConverter extends ImageConverter {
    public InverseImageConverter(String imageFormat) {
        super(imageFormat);
    }
    @Override
    public Color convertColor(Color color) {
        int outputRed = 255 - color.getRed();
        int outputGreen = 255 - color.getGreen();
        int outputBlue = 255 - color.getBlue();
        return new Color(outputRed, outputGreen, outputBlue);
    }

}