package sun.io.readwrite;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReadFile {
	
	
	// Throw exceptions to console:
	public static String
	read(String filename) throws IOException {
	// Reading input by lines:
	BufferedReader in = new BufferedReader(
	new FileReader(filename));
	String s;
	StringBuilder sb = new StringBuilder();
	while((s = in.readLine())!= null)
	sb.append(s + "\n");
	in.close();
	return sb.toString();
	}
	
	public static String readBytes(String filename) throws IOException{
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
	
		StringBuilder sb = new StringBuilder();
		while(in.available()>0){
			byte[] b = new byte[64];
			in.read(b, 0, b.length);
//			in.read(b);
			sb.append(new String(b) + "\n");
		}
		in.close();
		return sb.toString();
	}
	
	public static String readBytes_v2(String filename) throws IOException{
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
		DataInputStream data = new DataInputStream(in);
		StringBuilder sb = new StringBuilder();
		String s;
		while((s =data.readLine())!=null){
			sb.append(s+ "\n");
		}
		in.close();
		return sb.toString();
	}
	
	
	// Throw exceptions to console:
	public static String
	readReverse(String filename) throws IOException {
	// Reading input by lines:
	BufferedReader in = new BufferedReader(
	new FileReader(filename));
	String s;
	LinkedList<String> list = new LinkedList<String>();
	StringBuilder sb = new StringBuilder();
	while((s = in.readLine())!= null){
	list.add(s);
	}
	in.close();
Collections.reverse(list);
list.stream().forEach(s1->sb.append(s1+"\n"));
	return sb.toString();
	}
	
	// Throw exceptions to console:
	public static List<String>
	readAsList(String filename) throws IOException {
	// Reading input by lines:
	BufferedReader in = new BufferedReader(
	new FileReader(filename));
	String s;
	LinkedList<String> list = new LinkedList<String>();
	StringBuilder sb = new StringBuilder();
	while((s = in.readLine())!= null){
	list.add(s);
	}
	in.close();
	return new ArrayList<String>(list);
	}
	
	public static List<Character> readOneCharacter(String filename) throws IOException{
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
		List<Character> list = new ArrayList<Character>();
		int c =0; 
		while((c=in.read())!=-1){
			list.add((char)c);
		}
		in.close();
		return list;
	}
	
	public static List<String> readBySplit(String filename, String regex) throws IOException{
		return Arrays.asList(read(filename).split(regex));
	}
	
	public static Map<Character,Integer> readByCharacterCount(String filename) throws IOException{
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		List<Character> list = readOneCharacter(filename);
		
		for(Character c : list){
			if(!map.containsKey(c)){
				map.put(c, 1);
				continue;
			}
			map.put(c, map.get(c)+1);
		}
		return map;
	}
	
	public static byte[] readBinary(String filename) throws IOException{
		
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
		byte [] binary = new byte[in.available()];
		in.read(binary);
		
		return binary;
	}

}
