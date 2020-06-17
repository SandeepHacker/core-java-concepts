package sun.io.nio.channel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.List;

public class TestReadWrite {
	
	
	public static class StreamRead extends IOTest{
		private String location;
		public StreamRead(String testName, String location) {
			super(testName);
			this.location=location;
		}
		@Override
		public void test() {
			try {
				DataInputStream fis = new DataInputStream(new FileInputStream(location));
				while(fis.available()!=0)
				fis.readInt();
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
		}
	}
	public static class BufferedStreamRead extends IOTest{
		private String location;
		public BufferedStreamRead(String testName, String location) {
			super(testName);
			this.location=location;
		}
		@Override
		public void test() {
			try {
				DataInputStream fis = new DataInputStream(new BufferedInputStream (new FileInputStream(location)));
				while(fis.available()!=0)
			fis.readInt();
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
		}
	}
	public static class StreamWrite extends IOTest{
		private String location;
		public StreamWrite(String testName, String location) {
			super(testName);
			this.location=location;
		}
		@Override
		public void test() {
			try {
				DataOutputStream fis = new DataOutputStream(new FileOutputStream(location));
				
				for(int i=0;i<=Num;i++)
					fis.writeInt(i);
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
		}
	}
	
	public static class BufferedStreamWrite extends IOTest{
		private String location;
		public BufferedStreamWrite(String testName, String location) {
			super(testName);
			this.location=location;
		}
		@Override
		public void test() {
			try {
				DataOutputStream fis = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(location)));
				for(int i=0;i<=Num;i++)
					fis.writeInt(i);
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
		}
	}
	
	public static class RandomAccessWrite extends IOTest{
		private String location;
		public RandomAccessWrite(String testName, String location) {
			super(testName);
			this.location=location;
		}
		@Override
		public void test() {
			try {
				RandomAccessFile fis = new RandomAccessFile(location, "rw");
				for(int i=0;i<=Num;i++)
					fis.writeInt(i);
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
		}
	}
	
	public static class RandomAccessRead extends IOTest{
		private String location;
		public RandomAccessRead(String testName, String location) {
			super(testName);
			this.location=location;
		}
		@Override
		public void test() {
			try {
				RandomAccessFile fis = new RandomAccessFile(location, "r");
				for(int i=0;i<=Num;i++)
					fis.readInt();
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
		}
	}
	
	
	public static class FileChannelWrite extends IOTest{
		private String location;
		public FileChannelWrite(String testName, String location) {
			super(testName);
			this.location=location;
		}
		@Override
		public void test() {
			try {
				FileChannel fis =new FileOutputStream(location).getChannel();
				ByteBuffer bb = ByteBuffer.allocate(Num*4);
				int [] arr = new int[Num];
				for(int i=0;i<Num;i++)
					arr[i]=i;
				bb.asIntBuffer().put(arr);
				fis.write(bb);
				
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
		}
	}
	
	public static class FileChannelRead extends IOTest{
		private String location;
		public FileChannelRead(String testName, String location) {
			super(testName);
			this.location=location;
		}
		@Override
		public void test() {
			try {
			FileInputStream fis = 	new FileInputStream(location);
				FileChannel fs = fis.getChannel();
				ByteBuffer bb = ByteBuffer.allocate(fis.available());	
				fs.read(bb);
			bb.flip();
				IntBuffer ib = bb.asIntBuffer();
			while(ib.hasRemaining()){
					ib.get();
			}
			fs.close();
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
		}
	}
	
	public static class FileChannelRandomWrite extends IOTest{
		private String location;
		public FileChannelRandomWrite(String testName, String location) {
			super(testName);
			this.location=location;
		}
		@Override
		public void test() {
			try {
				FileChannel fis =new RandomAccessFile(location,"rw").getChannel();
				
				ByteBuffer bb = ByteBuffer.allocate(Num*4);
				IntBuffer ib = bb.asIntBuffer();
				for(int i=0;i<Num;i++)
					ib.put(i);

				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
		}
	}
	public static class FileChannelRandomRead extends IOTest{
		private String location;
		public FileChannelRandomRead(String testName, String location) {
			super(testName);
			this.location=location;
		}
		@Override
		public void test() {
			try {
			RandomAccessFile fis = 	new RandomAccessFile(location,"r");
				FileChannel fs = fis.getChannel();
				ByteBuffer bb = ByteBuffer.allocate((int)fis.length());
			fs.read(bb);
			bb.flip();
			IntBuffer ib =bb.asIntBuffer();
			
				while(ib.hasRemaining())
					ib.get();
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
		}
	}
	
	public static class MappedFileChannelWrite extends IOTest{
		private String location;
		public MappedFileChannelWrite(String testName, String location) {
			super(testName);
			this.location=location;
		}
		@Override
		public void test() {
			try {
				FileChannel fis =new RandomAccessFile(location,"rw").getChannel();
				
				ByteBuffer bb = fis.map(MapMode.READ_WRITE, 0, Num*4);
				IntBuffer ib =bb.asIntBuffer();
				for(int i=0;i<Num;i++)
					ib.put(i);
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
		}
	}
	
	public static class MappedFileChannelRead extends IOTest{
		private String location;
		public MappedFileChannelRead(String testName, String location) {
			super(testName);
			this.location=location;
		}
		@Override
		public void test() {
			try {
			RandomAccessFile fis = 	new RandomAccessFile(location,"r");
				FileChannel fs = fis.getChannel();
	
				ByteBuffer bb = fs.map(MapMode.READ_ONLY, 0, fs.size()/4);
				IntBuffer ib =bb.asIntBuffer();
				while(ib.hasRemaining())
				ib.get();
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
		}
	}
	
	
	public static List<IOTest> getAllTest(){
		List<IOTest> list =  new ArrayList<IOTest>();
		list.add(new StreamWrite("StreamWrite", "D:\\FileIO\\New folder - Copy\\A - Copy (2).txt"));
		list.add(new StreamRead("StreamRead", "D:\\FileIO\\New folder - Copy\\A - Copy (2).txt"));
		list.add( new BufferedStreamWrite("BufferedStreamWrite", "D:\\FileIO\\New folder - Copy\\A - Copy (2).txt"));
		list.add(new BufferedStreamRead("BufferedStreamRead", "D:\\FileIO\\New folder - Copy\\A - Copy (2).txt"));
		list.add(new TestReadWrite.RandomAccessWrite("RandomAccessWrite", "D:\\FileIO\\New folder - Copy\\A - Copy (2).txt"));
		list.add(new TestReadWrite.RandomAccessRead("RandomAccessRead", "D:\\FileIO\\New folder - Copy\\A - Copy (2).txt"));
		list.add(new TestReadWrite.FileChannelWrite("FileChannelWrite", "D:\\FileIO\\New folder - Copy\\A - Copy (2).txt"));
		list.add(new TestReadWrite.FileChannelRead("FileChannelRead", "D:\\FileIO\\New folder - Copy\\A - Copy (2).txt"));
		list.add(new TestReadWrite.FileChannelRandomWrite("FileChannelRandomWrite", "D:\\FileIO\\New folder - Copy\\A - Copy (2).txt"));
		list.add(new TestReadWrite.FileChannelRandomRead("FileChannelRandomRead", "D:\\FileIO\\New folder - Copy\\A - Copy (2).txt"));	
		list.add(new TestReadWrite.MappedFileChannelWrite("MappedFileChannelWrite", "D:\\FileIO\\New folder - Copy\\A - Copy (2).txt"));	
		list.add(new TestReadWrite.MappedFileChannelRead("MappedFileChannelRead", "D:\\FileIO\\New folder - Copy\\A - Copy (2).txt"));
return list;
	}

}
