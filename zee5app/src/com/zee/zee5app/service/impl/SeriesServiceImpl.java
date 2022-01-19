package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.SeriesRepository2;
import com.zee.zee5app.repository.impl.SeriesRepositoryImpl;
import com.zee.zee5app.service.SeriesService2;

public class SeriesServiceImpl implements SeriesService2 {
	private SeriesRepository2 repository = SeriesRepositoryImpl.getInstance();
	private SeriesServiceImpl() {
		
	}
	private static SeriesService2 seriesservice;
	
	public static SeriesService2 getInstance() {
		if(seriesservice == null) {
			seriesservice = new SeriesServiceImpl();
		}
		return seriesservice;
	}
	
	
	@Override
	public Series getSeriesById(String id) {
		return this.repository.getSeriesById(id);
	}

	@Override
	public String updateSeries(String id,Series series) {
		return this.repository.updateSeries(id,series);
	}

	@Override
	public String deleteSeriesById(String id) {
		return this.repository.deleteSeriesById(id);
	}
	
	@Override
	public String addSeries(Series movie) {
		return this.repository.addSeries(movie);
	}
	@Override
	public Series[] getAllSeries() {
		return this.repository.getAllSeries();
	}
	

}
