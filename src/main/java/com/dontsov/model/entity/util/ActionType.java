package com.dontsov.model.entity.util;

public enum ActionType {
	MEETING("Meeting"), CALL("Call");
	
	 private final String type;

	 private ActionType(String type) {
	     this.type = type;
	 }
	public String getType() {
		return type;
	}
}
