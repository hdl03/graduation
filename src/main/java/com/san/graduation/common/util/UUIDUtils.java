package com.san.graduation.common.util;

import java.util.UUID;

public final class UUIDUtils {

	private static UUIDUtils INSTANCE = new UUIDUtils();

	public static UUIDUtils getInstance() {
		return INSTANCE;
	}

	public String getUniqueId() {

		return UUID.randomUUID().toString().replace("-", "");

	}

}
