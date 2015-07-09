package com.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.WindowManager;

public class Utils {

	// shared methods
	public static void setShared(Context context, String name, String value) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		Editor editor = prefs.edit();
		editor.putString(name, value);
		editor.commit();
	}

	public static String getShared(Context context, String name) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		return prefs.getString(name, "");

	}

	@SuppressWarnings("deprecation")
	public static int getImageHeight(Context context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display d = wm.getDefaultDisplay();

		return (int) ((d.getWidth() * ASPECT_RATIO_HEIGHT) / ASPECT_RATIO_WIDTH);
	}

	public static int ASPECT_RATIO_HEIGHT = 1;
	public static int ASPECT_RATIO_WIDTH = 1;

}
