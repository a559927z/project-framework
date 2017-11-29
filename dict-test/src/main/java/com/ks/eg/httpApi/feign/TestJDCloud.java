package com.ks.eg.httpApi.feign;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class TestJDCloud {

	public static void main(String... args) {
		JDCloud github = Feign.builder().encoder(new GsonEncoder()).decoder(new GsonDecoder()).target(JDCloud.class,
				"https://api.github.com");

	}
}
