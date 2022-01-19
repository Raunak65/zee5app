package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Movies {
	private String movieName;
	private String cat;
	private String releaseDate;
	private String trailer;
	private String language;
	private float length;
	private String id;
	private String cast[];
	
	public Movies() {
		
	}
}
