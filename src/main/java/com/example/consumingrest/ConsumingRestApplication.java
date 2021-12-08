package com.example.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.*;
import org.springframework.http.*;
import org.springframework.web.reactive.function.client.*;
import org.springframework.web.util.*;
import reactor.core.publisher.*;
import java.util.*;
import java.net.*;

@SpringBootApplication
public class ConsumingRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	private static final String API_KEY = "6ESlzwjwUPd3w56tc4CmFuGtXEmlRhYiIpC1SljwhKU3iyaDjaVWHtgzNcyfHmt3EytO2cPE%2BrFNA3E6BA6XpA%3D%3D";
	private static final String API_KEY_DEC = "6ESlzwjwUPd3w56tc4CmFuGtXEmlRhYiIpC1SljwhKU3iyaDjaVWHtgzNcyfHmt3EytO2cPE+rFNA3E6BA6XpA==";
	private static final String API_URL = "http://apis.data.go.kr/B551408/rg-mon-pmt-amt/pmt-info";

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			for(int i = 0; i < 100; i++) {
				final String reqUrl = UriComponentsBuilder.fromUriString(API_URL)
					.queryParam("serviceKey", API_KEY)
					.queryParam("pageNo", "1")
					.queryParam("numOfRows", "10")
					.queryParam("housePrc", "100000000")
					.queryParam("houseDvcd", "01")
					.queryParam("pnsnPayMthdDvcd", "01")
					.queryParam("mmPayAmtIndcDvcd", "01")
					.queryParam("joinPersBrthDy", "19511201")
					.queryParam("sposBrthDy", "19511201")
					.queryParam("payTermCd", "01")
					.queryParam("wdrwLmtSetpAmt", "0")
					.queryParam("dataType", "JSON")
					.build()
					.toUriString();

				log.info("reqUrl = " + reqUrl);

				ResponseEntity<String> re = restTemplate.getForEntity(new URI(reqUrl), String.class);
				String res = re.getBody();

				log.info("res = " + res);

				/*
        			WebClient client = WebClient.create();
        			Mono<String> mono = client.get()
					.uri(reqUrl)
					.retrieve()
					.bodyToMono(String.class);
				log.info(mono.block());*/
			}
		};
	}
}
