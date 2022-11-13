package com.buildingmanager.model.response;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponseModel {
	private String error;
	private List<String> details;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(String ...details) {
		this.details = new ArrayList<>();
		for (String detail : details) {
			this.details.add(detail);
		}
	}
}
