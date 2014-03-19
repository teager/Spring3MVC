/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */

package com.gpower.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FreePeriodUtils {

	public static Boolean isFreePeriod(String freePeriodStr) {
		if (freePeriodStr == null) {
			return false;
		}
		String[] periods = freePeriodStr.split(";");
		if (periods == null || periods.length < 1) {
			return false;
		}
		for (String period : periods) {
			String[] couple = period.split("to");
			if (couple == null || periods.length != 2) {
				return false;
			}
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar freeBeginTime = Calendar.getInstance();
				freeBeginTime.setTime(sdf.parse(couple[0].trim()));

				Calendar freeEndTime = Calendar.getInstance();
				freeBeginTime.setTime(sdf.parse(couple[1].trim()));

				Calendar current = Calendar.getInstance();
				if (freeBeginTime.getTimeInMillis() < current.getTimeInMillis()
						&& freeEndTime.getTimeInMillis() > current.getTimeInMillis()) {
					return true;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}
