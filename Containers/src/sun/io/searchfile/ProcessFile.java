package sun.io.searchfile;

import java.io.File;

import sun.io.searchfile.FileGenerator.FolderInfo;

public class ProcessFile {
	
	public  interface Statergy{
		public void processFile(File file);
	}
	
	private Statergy statergy;
	private String regex;
	private String [] paths;
	public ProcessFile(String... paths) {
			this.paths=paths;
			this.regex=".*";
			this.statergy=new PrintFileName();
	}
	public ProcessFile(  String regex,String[] paths) {
		this(paths);
		this.regex = regex;
	}
	public ProcessFile(Statergy statergy, String... paths) {
		this(paths);
		this.statergy = statergy;
	}
	public ProcessFile(String regex,Statergy statergy,  String... paths) {
		this(regex,paths);
		this.statergy = statergy;
	}
	
	
	
	void process(){
	
		for(String path : paths){
		FolderInfo info = FileGenerator.loadFilesAndDirectories(path, ".*", regex);
		for(File file:info){
			statergy.processFile(file);
		}
		}
	}
	
	
	private static class PrintFileName implements Statergy{

		@Override
		public void processFile(File file) {
			System.out.println(file.getName());
		}
		
	}
	

}
