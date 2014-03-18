/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */

package com.gpower.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import com.gpower.common.entity.Anonymity;

public class SessionUtils {

	public static String createAnonymitySessionToken(Anonymity anonymity) {
		return Base64
				.encodeBase64URLSafeString((anonymity.getId().toString() + ";" + anonymity.getClientDeviceId() + ";")
						.getBytes());
	}

	public static String[] decodeSession(String session) {
		String token = new String(Base64.decodeBase64(session));
		return token.split(";");
	}

	public static Long getAnonymityId(String session) {
		String token = new String(Base64.decodeBase64(session));
		String[] tokens = token.split(";");
		if (tokens == null || tokens.length < 1) {
			return null;
		}
		if(!StringUtils.isNumeric(tokens[0])){
			return null;
		}
		return Long.valueOf(tokens[0]);
	}
}
