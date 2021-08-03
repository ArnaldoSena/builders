package com.platform.adapter.id_generator;

import java.util.UUID;

public class UuidGenerator {
	public static Long createId() {
		Long key = UUID.randomUUID().getLeastSignificantBits();
		return key;
	}
}
