package com.gpower.common.entity;


public class Property {

	public static final String SMS_REVIEW_MOBILE = "smsReviewMobile";
	public static final String SMS_REVIEW_SEND_FLAG = "smsReviewSendFlag";
	public static final String WORK_TIME_START = "workTimeStart";
	public static final String WORK_TIME_END = "workTimeEnd";
	public static final String CONTENT_SENSITIVE_WORD_LIST = "contentSensitiveWordList";
	public static final String NICKNAME_SENSITIVE_WORD_LIST = "nicknameSensitiveWordList";
	public static final String OPERATION_MOBILE = "operationMobile";
	public static final String OPERATION_EMAIL = "operationEmail";
	public static final String TRUST_REVIEW_USER_ID = "trustReviewUserId";
	public static final String SLEEP_TIME_START = "sleepTimeStart";
	public static final String SLEEP_TIME_END = "sleepTimeEnd";
	
	public static final String CHINATELECOM_SMS_CHANNEL = "chinatelecomSmsChannel";
	public static final String CHINATELECOM_SMS_REGEX = "chinatelecomSmsRegex";
	public static final String CHINAMOBILE_SMS_CHANNEL = "chinamobileSmsChannel";
	public static final String CHINAMOBILE_SMS_REGEX = "chinamobileSmsRegex";
	public static final String CHINAUNICOM_SMS_CHANNEL = "chinaunicomSmsChannel";
	public static final String CHINAUNICOM_SMS_REGEX = "chinaunicomSmsRegex";
	public static final String DEFAULT_SMS_CHANNEL = "defaultSmsChannel";
	
	public final static String SCORE_DMONEY_EXCHANGE_RATE = "scoreDmoneyExchange";
	public final static String ACTIVITY_NUMBER = "activity_number";
	public final static String HELP_SWITCH = "help_switch";
	public final static String MUCDOMAIN = "mucDomain";
	public final static String IMPRESSION_BLOCK_LIST = "impression_block_list";


	private String name;


	private String propValue;

	public Property() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPropValue() {
		return propValue;
	}

	public void setPropValue(String propValue) {
		this.propValue = propValue;
	}

}
