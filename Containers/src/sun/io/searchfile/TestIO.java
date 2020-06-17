package sun.io.searchfile;

import java.io.File;
import java.util.Date;

public class TestIO {

	
	public static void main(String[] args) {
		
		//Process all the files of the given path and use default statergy for process.
	/*	ProcessFile file = new ProcessFile("src\\sun\\io\\");
		file.process();*/
		
//		Process files which are matched with the given regex
/*		ProcessFile file1 = new ProcessFile("E.*",new String[]{"src\\"});
		file1.process();*/
		
//		System.out.println("TestIO.main()"+new File("D:\\FileIO\\").exists());
		File fv = new File("D:\\FileIO\\New folder - Copy\\A - Copy (2).txt");
		FileUtils f = new FileUtils();
//		f.details(fv);
		
				ProcessFile file1 = new ProcessFile(new FileModified(new Date(120, 4, 16)),"src\\");
				
						file1.process();
		
		
/*		ProcessFile file2= new ProcessFile("D:\\FileIO\\");
		file2.process();*/
//f.deleteFile("D:\\FileIO\\New folder - Copy\\", "B.*");
//f.rename("D:\\FileIO\\New folder - Copy\\", "B - Renamed", "B.*");
		
		
		
		
		
		
/*		File f = new File(".");
		System.out.println("TestIO.main()"+Arrays.toString(f.listFiles(new RegexFilter(".*"))));*/
	}
	
	/*find all the  files in  a particular directory subtree that have been modified after a 
	* particular date.*/
	static class FileModified implements ProcessFile.Statergy{
 
		private Date d;
		
		public FileModified(Date da) {
			d=da;
		}
		
		@Override
		public void processFile(File file) {
			if(new Date(file.lastModified()).after(d))
					System.out.println("TestIO.FileModified.processFile()"+file);
			
		}
		
	}
	
	
}
