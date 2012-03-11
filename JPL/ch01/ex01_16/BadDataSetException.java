package ex01_16;

import java.io.IOException;

public class BadDataSetException extends Exception {
	private IOException exception;
	private String fileName;

	public BadDataSetException(String fileName, IOException exception) {
		this.fileName = fileName;
		this.exception = exception;
	}

	public String getFileName(){
		return fileName;
	}


	public IOException getIOException(){
		return exception;
	}

}
