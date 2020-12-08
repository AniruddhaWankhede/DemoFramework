package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import constant.Constant;

public class LogsManager extends AppenderSkeleton {

	private final ConcurrentHashMap<String, Path> threadMap = new ConcurrentHashMap<String, Path>();
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean requiresLayout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void append(LoggingEvent event) {
		// TODO Auto-generated method stub
		String thread = Thread.currentThread().getName();
		Path path = threadMap.get(thread);
		if(path == null) {
			path = Paths.get(getFileNameFromThread(thread));
			threadMap.put(thread, path);
		}
		
		byte[] bytes = getLayout().format(event).getBytes();
		FileOutputStream outStream;
		try {
			outStream = new FileOutputStream(path.toFile(), true);
			outStream.write(bytes);
			outStream.close();
		}catch (IOException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	private String getFileNameFromThread(String name) {
		return String.format("%s%s-%s", Constant.logsFileDir, name, Constant.logsFileName);
	}

}
