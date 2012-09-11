package ch17.ex17_02;

import java.io.File;
import java.lang.ref.WeakReference;

class  DataHandler {

	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;

	byte[] readFile(File file) {
		byte[] data;

		if(lastFile.get() != null && file.equals(lastFile)) {
			data = lastData.get();
			if (data != null)
				return data;
		}

		data = readBytesFormFile(file);
		lastFile = new WeakReference<File>(file);;
		lastData = new WeakReference<byte[]>(data);
		return data;
	}

	// コンパイルを通すだけの目的
	byte[] readBytesFormFile(File file) {
		return null;
	}
}
