

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

public class Files {

	public static void main(String[] args) {
		Files s = new Files();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * @return
	 */
	public String solution() {
		
		
		 try {
         	 File f = new File("C:\\alfresco\\923523_Manifests.pdf");
             byte[] bytes = new byte[(int) f.length()];

             FileInputStream fis = null;
             try {

                 fis = new FileInputStream(f);

                 //read file into bytes[]
                 fis.read(bytes);

             } finally {
            	 System.out.println("FINAL");
                 if (fis != null) {
                     fis.close();
                 }
             }
             System.out.println("bytes: "+ bytes.length);
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		
		
		
		File file = new File("C:\\alfresco");
        File[] files = file.listFiles();
        String fileName = "";
        Long customerPaperRequestID = null;
        
        Arrays.sort(files, new Comparator<File>(){
        	public int compare(File f1,File f2){
        		return f1.lastModified() > f2.lastModified()?-1:1;
        	}
        });
        for (File tmpFile : files) {
        	System.out.println("FILE Path : "+tmpFile.getPath());
            fileName = tmpFile.getName();
            System.out.println("FILE NAME : "+fileName);
            
            
           
            
            
            System.out.println("Before Format : " + tmpFile.lastModified());

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

            System.out.println("After Format : " + sdf.format(tmpFile.lastModified()));
            
            Long requestId = extractCustomerPaperIDFromANYCustomerPaperFilename(fileName);
            System.out.println("requestId " + requestId );
            break;
        }
		return "END";
    }
	
	
	private static Long extractCustomerPaperIDFromANYCustomerPaperFilename(String anyCustomerPaperFilename){
        try {
            String custPaperId = anyCustomerPaperFilename.substring(0, anyCustomerPaperFilename.indexOf("_"));
            return Long.valueOf(custPaperId);
        } catch (RuntimeException re) {
            return null;
        }

	}
	
}
 