package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.SeriesRepository2;

public class SeriesRepositoryImpl implements SeriesRepository2 {

	private Series [] series = new Series[10];
	private SeriesRepositoryImpl() {
			
	}
	
	private static SeriesRepository2 seriesrepository;
		
	public static SeriesRepository2 getInstance() {
		if(seriesrepository==null)
			{
			seriesrepository = new SeriesRepositoryImpl();
			}
		return seriesrepository;
		}
	private static int count = -1;
	@Override
	public String addSeries(Series register) {
		if(count == series.length-1) {
			Series temp[] = new Series[2*series.length];
			System.arraycopy(series, 0, temp,0, series.length);
			series = temp;
			series[++count] = register;
			return "Successfully added User";
		}
		series[++count] = register;
		return "Successfully added User";
	}
	@Override
	public String updateSeries(String id,Series movie) {
		for (Series currSeries : series) {
			if (currSeries!=null) {
				if (currSeries.getId().equals(id)) {
					currSeries.setCast(movie.getCast());
					currSeries.setLanguage(movie.getLanguage());
					currSeries.setTrailer(movie.getTrailer());
					currSeries.setLength(movie.getLength());
					currSeries.setReleaseDate(movie.getReleaseDate());
					currSeries.setSeriesName(movie.getSeriesName());
					currSeries.setCat(movie.getCat());
					return "updated";
				}
			}	
		}
		return null;
	}

	@Override
	public Series getSeriesById(String id) {
		for (Series register : series) {
			if(register!=null) {
				
				if(register.getId().equals(id)) {
					return register;
				}
			}
		}
		return null;
	}

	@Override
	public Series[] getAllSeries() {
		return series;
	}

	@Override
	public String deleteSeriesById(String id) {
		Series temp[] = new Series[series.length];
		int i = 0;
		int j = 0;
		for (Series currRegister : series) {
			if (currRegister!=null) {
				if (currRegister.getId().equals(id)) {
					j++;
				}
				else {
					temp[i] = series[j];
					i++;
					j++;
				}
			}	
		}
		series = temp;
		return "success";
	}

}
