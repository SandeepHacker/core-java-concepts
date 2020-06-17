package sun.io.searchfile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FileGenerator {
	
	private static File[] fileArray(File dir, String regex){
		dir.listFiles(new RegexFilter(regex));
		return null;
	}
	
	
public static File[] loadFileArray(String path, String regex){
	return fileArray(new File(path), regex);
}


static class FolderInfo implements Iterable<File>{

	public List<File> files = new ArrayList<File>();
	public List<File> dirs = new ArrayList<File>();
	
	
	@Override
	public Iterator<File> iterator() {
		// TODO Auto-generated method stub
		return files.iterator();
	}
	
	
	public Iterator<File> directoryiterator() {
		// TODO Auto-generated method stub
		return dirs.iterator();
	}
	
	public FolderInfo addAll(FolderInfo info){
		
		dirs.addAll(info.dirs);
		files.addAll(info.files);
		return this;
	}
	
}

public static FolderInfo loadAllFiles(String path){
	return loadFilesAndDirectories(path, ".*", ".*");
}

public static FolderInfo loadFilesAndDirectories(String path,String folderRegex ,String fileRegex){
	
	return loadFilesAndDirectories(new File(path), folderRegex, fileRegex);
	}

	public static FolderInfo loadFilesAndDirectories(File path, String folderRegex, String fileRegex){
	 
		FolderInfo info = new FolderInfo();		
		File[] all = path.listFiles(new RegexFilter(folderRegex));
		for(File f : all){
			if(f.isDirectory()){
				info.dirs.add(f);
				info.addAll(loadFilesAndDirectories(f, folderRegex,fileRegex));
			}else{
				if(f.getName().matches(fileRegex))
				info.files.add(f);
			}
		}
	return info;
}
}


