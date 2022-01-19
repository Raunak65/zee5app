package com.zee.zee5app.service;

import com.zee.zee5app.dto.Subscription;

public interface SubscriberService2 {

	public String addSubscriber(Subscription subscriber);
	public String updateSubscriber(String id, Subscription subscriber);
	public Subscription getSubscriberById(String id);
	public Subscription[] getAllSubscribers();
	public String deleteSubscriberById(String id);
}
