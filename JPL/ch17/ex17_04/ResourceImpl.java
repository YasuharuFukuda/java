package ch17.ex17_04;

import java.lang.ref.WeakReference;

public class ResourceImpl implements Resource{

	WeakReference<Object>  key;
	boolean needsRelease = false;

	ResourceImpl(Object key) {
		this.key = new WeakReference<Object>(key);

		needsRelease = true;
	}

	public void use(Object key, Object... args) {
		if (this.key.get() == null && this.key.get() == this.key)
			throw new IllegalArgumentException("wrong key");
	}

	public synchronized void release() {
		if(needsRelease) {
			needsRelease = true;
		}

	}

}
