package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriberRepository2;
import com.zee.zee5app.repository.impl.SubscriberRepositoryImpl;
import com.zee.zee5app.service.SubscriberService2;

public class SubscriberServiceImpl implements SubscriberService2 {

	private SubscriberRepository2 repository = SubscriberRepositoryImpl.getInstance();
	private SubscriberServiceImpl() {
		
	}
	private static SubscriberService2 subscriberservice;
	
	public static SubscriberService2 getInstance() {
		if(subscriberservice == null) {
			subscriberservice = new SubscriberServiceImpl();
		}
		return subscriberservice;
	}
	
	@Override
	public String addSubscriber(Subscription subscriber) {
		return this.repository.addSubscriber(subscriber);
	}

	@Override
	public String updateSubscriber(String id,Subscription subscriber) {
		return this.repository.updateSubscriber(id,subscriber);
	}

	@Override
	public Subscription getSubscriberById(String id) {
		return this.repository.getSubscriberById(id);
	}

	@Override
	public Subscription[] getAllSubscribers() {
		return this.repository.getAllSubscribers();
	}
	@Override
	public String deleteSubscriberById(String id) {
		return this.repository.deleteSubscriberById(id);
	}

}
