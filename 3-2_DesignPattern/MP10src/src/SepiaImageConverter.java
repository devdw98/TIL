import java.awt.image.*;
//import java.awt.Image.BufferedImage;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

//import java.imageio.*;

class SepiaImageConverter extends ImageConverter {
    public SepiaImageConverter(String imageFormat) {
        super(imageFormat);
    }

    @Override
    public Color convertColor(Color color) {
        int grey = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        int outputRed = 230 * grey / 255;
        int outputGreen = 180 * grey / 255;
        int outputBlue =  150 * grey / 255;
        return new Color(outputRed, outputGreen, outputBlue);
    }

}