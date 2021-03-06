package com.sns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

@Configuration
public class SnsConfig {
	 public static final String SECRET_KEY = "7EafM5VtyOMI+8GdEkqjLbGZRfyOs7fvUlg3TYfy";
	    public static final String ACCESS_KEY = "AKIA2HDQBFB7ZVUFDFE4";

	    @Primary
	    @Bean
	    public AmazonSNSClient getSnsClient() {
	        return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion(Regions.AP_SOUTH_1)
	                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY,
	                        SECRET_KEY)))
	                .build();
	    }
}
