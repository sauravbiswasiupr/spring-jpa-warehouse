package saurav.springjpa.ziputils;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


/**
 * Created by saurav on 9/20/16.
 */
public class ZipFileUtils {
    private final String BASE_DIR = "GzipOriginal";
    private final String DESTINATION_DIR = "GzipConvertedFromOriginal";
    private final int BUFFER_SIZE = 1024;


    public void copyZipFileToDestination(String sourceGzipFileName, String dest) throws IOException {
        try {
            FileInputStream fs = new FileInputStream(BASE_DIR + "/" + sourceGzipFileName);
            GZIPInputStream gzipInputStream = new GZIPInputStream(fs);
            FileOutputStream fileOutputStream = new FileOutputStream(DESTINATION_DIR + "/" + dest);
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fileOutputStream);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len;

            while ((len = gzipInputStream.read(buffer)) != -1) {
                gzipOutputStream.write(buffer, 0, len);
            }

            gzipOutputStream.close();
            fileOutputStream.close();
            gzipInputStream.close();
            fs.close();
            System.out.println("Saved successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ZipFileUtils zipFileUtils = new ZipFileUtils();
        String sourceFilePath = "correct.100.refGene.vcf.gz";
        String destinationFilePath = "copied.gz";
        zipFileUtils.copyZipFileToDestination(sourceFilePath, destinationFilePath);


    }
}
