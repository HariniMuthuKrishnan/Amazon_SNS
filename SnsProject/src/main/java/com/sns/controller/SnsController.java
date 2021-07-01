package com.sns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@RestController
public class SnsController {
	@Autowired
	private AmazonSNSClient snsClient;

	String TOPIC_ARN = "arn:aws:sns:ap-south-1:702462109823:tran-topic";

	@GetMapping("/addSubscription/{emailId}")
	public String addSubscription(@PathVariable String emailId) {
		SubscribeRequest request = new SubscribeRequest(TOPIC_ARN, "email", emailId);
		snsClient.subscribe(request);
		return "Subscription request is pending. To confirm the subscription, check your email : " + emailId;
	}

	@GetMapping("/sendNotification")
	public String publishMessageToTopic() {
		PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, buildEmailBody(),
				"Notification: Network connectivity issue");
		snsClient.publish(publishRequest);
		return "Notification sent successfully !!";
	}

	private String buildEmailBody() {
		return "Dear Employee ,\n" + "\n" + "\n" + "Issue Exist Please Wait for a While.....";
	}
}
