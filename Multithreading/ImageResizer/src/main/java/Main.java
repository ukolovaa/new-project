import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    private static int newWidth = 300;
    public static void main(String[] args) {
        String srcFolder = "/Users/ukolovaaaaa/Desktop/src";
        String dstFolder = "/Users/ukolovaaaaa/Desktop/dst";

        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();
//        int part = files.length / 8;

        File[] files1 = new File[1];
//        System.arraycopy(files, 0, files1, 0, files1.length);
        ImageResizer treadOne = new ImageResizer(files1, newWidth, dstFolder, start,1);
        treadOne.start();

        File[] files2 = new File[1];
//        System.arraycopy(files, 0, files2, 0, files2.length);
        ImageResizer treadTwo = new ImageResizer(files2, newWidth, dstFolder, start,2);
        treadTwo.start();

        File[] files3 = new File[1];
//        System.arraycopy(files, 0, files3, 0, files3.length);
        ImageResizer treadThree = new ImageResizer(files3, newWidth, dstFolder, start,3);
        treadThree.start();

        File[] files4 = new File[1];
//        System.arraycopy(files, 0, files4, 0, files4.length);
        ImageResizer treadFour = new ImageResizer(files4, newWidth, dstFolder, start,4);
        treadFour.start();

        File[] files5 = new File[1];
//        System.arraycopy(files, 0, files5, 0, files5.length);
        ImageResizer treadFive = new ImageResizer(files5, newWidth, dstFolder, start,5);
        treadFive.start();

        File[] files6 = new File[1];
//        System.arraycopy(files, 0, files6, 0, files6.length);
        ImageResizer treadSix = new ImageResizer(files6, newWidth, dstFolder, start, 6);
        treadSix.start();

        File[] files7 = new File[1];
//        System.arraycopy(files, 0, files7, 0, files7.length);
        ImageResizer treadSeven = new ImageResizer(files7, newWidth, dstFolder, start, 7);
        treadSeven.start();

        File[] files8 = new File[1];
//        System.arraycopy(files, 0, files8, 0, files8.length);
        ImageResizer treadEight = new ImageResizer(files4, newWidth, dstFolder, start, 8);
        treadEight.start();
    }
}
