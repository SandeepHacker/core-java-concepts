package sun.io.searchfile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class RegexFilter implements FilenameFilter{

	private Pattern pattern;
	public RegexFilter(String regex) {
	pattern = Pattern.compile(regex);
	}
	
	@Override
	public boolean accept(File dir, String name) {
	
		return pattern.matcher(name).matches();
	}
	


}
