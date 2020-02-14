package fi.utu.tech.gui.javafx.zipper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import fi.utu.tech.gui.javafx.zipper.ZipperController.NameLoader;
import javafx.concurrent.Task;

public class Zipper extends Task<Void>{
	
	String sourceDir;
	String destinationFile;
	String fileName;
	
	
	public Zipper(String source, String destination) {
		this.sourceDir = source;
		this.destinationFile = destination;
	}
	
	
	@Override public Void call() throws IOException{
		

        try (FileOutputStream fos = new FileOutputStream(destinationFile);
                ZipOutputStream zipOut = new ZipOutputStream(fos)) {

               File fileToZip = new File(sourceDir);

               zipFile(fileToZip, fileToZip.getName(), zipOut);
               
               
           }
	
		return null;
	}
	
	

	
    public void zip(String sourceDir, String destinationFile) throws IOException {
	
        try (FileOutputStream fos = new FileOutputStream(destinationFile);
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {

            File fileToZip = new File(sourceDir);

            zipFile(fileToZip, fileToZip.getName(), zipOut);
            
            
        }

    }
    private void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            File[] children = fileToZip.listFiles();

            for (File childFile : children) {
                if(isCancelled()) {
                	break;
                }
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
                ZipperController z = new ZipperController();
                NameLoader nl = z.new NameLoader();
                nl.labelName(childFile.getName());
                
            }
            return;
        }
        try (FileInputStream fis = new FileInputStream(fileToZip)) {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
        }
    }

	}
