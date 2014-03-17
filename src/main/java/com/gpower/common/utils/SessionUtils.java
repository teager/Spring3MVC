/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */

package com.gpower.common.utils;

import org.apache.commons.codec.binary.Base64;

import com.gpower.common.entity.Anonymity;


public class SessionUtils {

	public static String createAnonymitySessionToken(Anonymity anonymity) {
		return Base64.encodeBase64URLSafeString((anonymity.getId().toString() + ";" + anonymity.getClientDeviceId() + ";" ).getBytes());
	}

	public static String[] decodeSession(String session) {
		String token = new String(Base64.decodeBase64(session));
		return token.split(";");
	}
}
