package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Subscription;

public interface SubscriberRepository2 {
	public String addSubscriber(Subscription subscriber);
	public String updateSubscriber(String id, Subscription subscriber);
	public Subscription getSubscriberById(String id);
	public Subscription[] getAllSubscribers();
	public String deleteSubscriberById(String id); 

}
