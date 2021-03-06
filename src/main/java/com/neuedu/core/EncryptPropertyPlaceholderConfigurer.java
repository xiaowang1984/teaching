package com.neuedu.core;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	private String[] encryptPropNames = { "username", "password" };

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		
		if (isEncryptProp(propertyName)) {
			return DESUtils.getDecryptString(propertyValue);
		} else {
			return propertyValue;
		}
		
	}

	/**
	 * 判断是否是加密
	 * 
	 * @param propertyName
	 * @return
	 */
	private boolean isEncryptProp(String propertyName) {
		for (String encryptPropName : encryptPropNames) {
			if (encryptPropName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}
