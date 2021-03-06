package com.library.http;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author puzhenwei
 * @version 1.0
 */
public class SimpleCookieJar implements CookieJar {

	private final List<Cookie> allCookies = new ArrayList<>();

	@Override
	public synchronized void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
		allCookies.addAll(cookies);
	}

	@Override
	public synchronized List<Cookie> loadForRequest(HttpUrl url) {
		List<Cookie> result = new ArrayList<>();
		for (Cookie cookie : allCookies) {
			if (cookie.matches(url)) {
				result.add(cookie);
			}
		}
		return result;
	}
}
