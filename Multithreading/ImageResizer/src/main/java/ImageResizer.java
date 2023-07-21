import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

public class ImageResizer extends Thread{
    private File[] files;
    private int newWidth;
    private String dstFolder;
    private long start;
    private int threadNumber;
    public ImageResizer(File[] files, int newWidth, String dstFolder, long start, int threadNumber) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
        this.threadNumber = threadNumber;
    }
    @Override
    public void run() {
//        try {
            for (File file : files) {
                BufferedImage image = null;
                try {
                    image = ImageIO.read(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (image == null) {
                    continue;
                }
                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );
                BufferedImage newImage = resize(image, newWidth, newHeight);
                File newFile = new File(dstFolder + "/" + file.getName());
                try {
                    ImageIO.write(newImage, "jpg", newFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        System.out.println("Поток номер " + threadNumber + " завершил свою работу за: " + (System.currentTimeMillis() - start) + "ms");
    }
    public static BufferedImage resize(BufferedImage image, int targetWidth, int targetHeight) {
        return Scalr.resize(
                image,
                Scalr.Method.AUTOMATIC,
                Scalr.Mode.FIT_EXACT,
                targetWidth,
                targetHeight,
                Scalr.OP_ANTIALIAS);
    }
}