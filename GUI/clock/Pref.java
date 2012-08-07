package clock;

import java.awt.Font;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Pref {
	private static Preferences prefs = Preferences.userNodeForPackage(new Pref().getClass());
	private static String flameColor = "flameColor";
	private static String canvasColor = "canvasColor";
	private static String canvasFont = "canvasFont";
	private static String canvasFontSize = "canvasFontSize";
	private static String finishX = "finishX";
	private static String finishY = "finishY";

	public static void save(String fColor, String cColor, String cFont, String cFontSize) {
		prefs.put(flameColor, fColor);
		prefs.put(canvasColor, cColor);
		prefs.put(canvasFont, cFont);
		prefs.put(canvasFontSize, cFontSize);
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void saveLayout(int x, int y) {
		prefs.put(finishX, String.valueOf(x));
		prefs.put(finishY, String.valueOf(y));
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}


	public static String getFlameColor() {
		return prefs.get(flameColor, "BLACK");
	}

	public static String getCanvasColor(){
		return prefs.get(canvasColor, "WHITE");
	}

	public static String getCanvasFont(){
		return prefs.get(canvasFont, Font.SERIF);
	}

	public static String getCanvasFontSize(){
		return prefs.get(canvasFontSize, "30");
	}

	public static int getFinishX() {
		return Integer.parseInt(prefs.get(finishX, "0"));
	}

	public static int getFinishY() {
		return Integer.parseInt(prefs.get(finishY, "0"));
	}

}
