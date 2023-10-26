package com.calculator.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MinMaxResponse {
	@JsonProperty("max")
	private int max;
	@JsonProperty("min")
	private int min;
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}

	
}
