package com.neoniou.blog.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

/**
 * Get request ip
 *
 * @author neo.zzj
 */
public class IpUtil {

	public static String getIpAddress(HttpServletRequest request) {
		final String localhost = "127.0.0.1";
		final String unknownIpAddress = "unknown";

		String ipAddress = null;
		try {
			ipAddress = request.getHeader("x-forwarded-for");
			if (ipAddress == null || ipAddress.length() == 0 || unknownIpAddress.equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getHeader("Proxy-Client-IP");
			}
			if (ipAddress == null || ipAddress.length() == 0 || unknownIpAddress.equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ipAddress == null || ipAddress.length() == 0 || unknownIpAddress.equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getRemoteAddr();
				if (localhost.equals(ipAddress)) {
					InetAddress inet = null;
					try {
						inet = InetAddress.getLocalHost();
					} catch (UnknownHostException e) {
						e.printStackTrace();
					}
					assert inet != null;
					ipAddress = inet.getHostAddress();
				}
			}
			if (ipAddress != null && ipAddress.length() > 15) {
				if (ipAddress.indexOf(",") > 0) {
					ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
				}
			}
		} catch (Exception e) {
			ipAddress = "";
		}
		return ipAddress;
	}
}