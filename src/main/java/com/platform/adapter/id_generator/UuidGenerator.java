package com.platform.adapter.id_generator;

import java.util.UUID;

public class UuidGenerator {
	public static Long createId() {
		return (Long) UUID.randomUUID().timestamp();
	}
}
