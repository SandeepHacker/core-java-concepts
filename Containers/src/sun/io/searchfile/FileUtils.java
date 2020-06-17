package sun.io.searchfile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileUtils {
	
	
	void details(File file){
		System.out.println(
				"Absolute path: " + file.getAbsolutePath() +
				"\n Can read: " + file.canRead() +
				"\n Can write: " + file.canWrite() +
				"\n getName: " + file.getName() +
				"\n getParent: " + file.getParent() +
				"\n getPath: " + file.getPath() +
				"\n length: " + file.length() +
				"\n lastModified: " + file.lastModified());
	}
	
	
	boolean rename(String original, String newName){
	File org = 	new File(original);
		return org.renameTo(new File(newName));
	}
	
	boolean deleteFile(String path){
			return new File(path).delete();
	}
	
	boolean deleteFile(String path,String regex){
		List<File> list = FileGenerator.loadFilesAndDirectories(path, ".*", regex).files;
		if(list.size()==0)
			return false;
		list.stream().forEach(f->f.delete());
		return true;
		
}
	boolean rename(String path, String newName, String regex){
		List<File> list = FileGenerator.loadFilesAndDirectories(path, ".*", regex).files;
		if(list.size()==0)
			return false;
		list.stream().forEach(f->{
			String original = f.getAbsolutePath();
			System.out.println("FileUtils.rename()"+original);
			Pattern p = Pattern.compile("B - Copy.*");
			Matcher  m = p.matcher(original);
			while(m.find()){
				System.out.println("FileUtils.rename()"+m.start()+"  "+m.end());
			}

	/*		matcher.replaceAll(newName);
			System.out.println("FileUtils.rename(2)"+original);
			f.renameTo(new File(original));*/
		});
		return true;
	}
	
	boolean createFile(String path) {
		try {
			return  new File(path).createNewFile();
		} catch (IOException e) {
			System.out.println("FileUtils.createFile()"+e);
		return false;
		}
	}
	

}
