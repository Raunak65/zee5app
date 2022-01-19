package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriberRepository2;

public class SubscriberRepositoryImpl implements SubscriberRepository2 {
	
	private Subscription[] subscribers = new Subscription[10];
	
	private SubscriberRepositoryImpl() {
		
	}
	private static SubscriberRepository2 subscriberrepository;
	
	public static SubscriberRepository2 getInstance() {
		if(subscriberrepository==null)
		{
			subscriberrepository = new SubscriberRepositoryImpl();
		}
		return subscriberrepository;
	}

	private static int count = -1;
	@Override
	public String addSubscriber(Subscription subscriber) {
		if(count == subscribers.length-1) {
			Subscription temp[] = new Subscription[2*subscribers.length];
			System.arraycopy(subscribers, 0, temp,0, subscribers.length);
			subscribers = temp;
			subscribers[++count] = subscriber;
			return "Successfully added User";
		}
		subscribers[++count] = subscriber;
		return "Successfully added subscriber";
	}

	@Override
	public String updateSubscriber(String id,Subscription subscriber) {
		for (Subscription currSubscriber : subscribers) {
			if (currSubscriber!=null) {
				if (currSubscriber.getId().equals(id)) {
					currSubscriber.setAutoRenewal(subscriber.getAutoRenewal());
					currSubscriber.setDateOfPurchase(subscriber.getDateOfPurchase());
					currSubscriber.setExpiryDate(subscriber.getExpiryDate());
					currSubscriber.setPackCountry(subscriber.getPackCountry());
					currSubscriber.setId(subscriber.getId());
					currSubscriber.setStatus(subscriber.getStatus());
					return "updated";
				}
			}	
		}
		return null;
	}

	@Override
	public Subscription getSubscriberById(String id) {
		for (Subscription subscriber : subscribers) {
			if(subscriber!=null) {
				if(subscriber.getId().equals(id)) {
					return subscriber;
				}
			}
		}
		return null;
	}

	@Override
	public Subscription[] getAllSubscribers() {
		return subscribers;
	}

	@Override
	public String deleteSubscriberById(String id) {
		Subscription temp[] = new Subscription[subscribers.length];
		int i = 0;
		int j = 0;
		for (Subscription currSubscriber : subscribers) {
			if (currSubscriber!=null) {
				if (currSubscriber.getId().equals(id)) {
					j++;
				}
				else {
					temp[i] = subscribers[j];
					i++;
					j++;
				}
			}	
		}
		subscribers = temp;
		return "success";
	}

}
