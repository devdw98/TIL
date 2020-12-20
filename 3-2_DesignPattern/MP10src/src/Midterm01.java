import java.awt.*;

public class Midterm01 {
    public static void main(String[] args) {
        final String HOUSE = "house.png";
        final String IMAGE_FORMAT = "png";

//        ImageConverter converter = new ImageConverter(IMAGE_FORMAT, new GreyImageConverter());
//        converter.convert(HOUSE, "g_" + HOUSE);
//
//        converter.setColorConverter(new InverseImageConverter());
//        converter.convert(HOUSE, "i_" + HOUSE);
//
//        converter.setColorConverter(new SepiaImageConverter());
//        converter.convert(HOUSE, "s_" + HOUSE);

        ImageConverter converter = new GreyImageConverter(IMAGE_FORMAT);
        converter.convert(HOUSE, "g_" + HOUSE);

        converter = new InverseImageConverter(IMAGE_FORMAT);
        converter.convert(HOUSE, "i_" + HOUSE);

        converter = new SepiaImageConverter(IMAGE_FORMAT);
        converter.convert(HOUSE, "s_" + HOUSE);

    }
}
