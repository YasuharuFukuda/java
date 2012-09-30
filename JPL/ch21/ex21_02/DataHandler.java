package ch21.ex21_02;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class DataHandler {
	private WeakHashMap<File, byte[]> lastData;

	byte[] readFile(File file) {
		byte[] data;
		if (lastData.containsKey(file)) {
			data = lastData.get(file);
			if (data != null)
				return data;
		}

		data = readBytesFromFile(file);
		lastData.put(file, data);
		return data;
	}

	byte[] readBytesFromFile(File file) {
		return null;
	}
}
