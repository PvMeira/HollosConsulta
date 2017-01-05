package com.pvmeira.hollos.enums;

public enum ActionHistory {
SAVE_HISTORY("save"),
ALTER_HISTORY("alter"),
DELETE_HISTORY("delete");
	
private String action;

 ActionHistory(String action) {
	this.action = action;
}

public String getAction() {
	return action;
}

}
