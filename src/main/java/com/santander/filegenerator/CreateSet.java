package com.santander.filegenerator;

import java.util.ArrayList;
import java.util.List;

public class CreateSet {

	private List<Create> creates = new ArrayList<Create>();

	public List<Create> getCreates() {
		return creates;
	}

	@Override
	public String toString() {
		return "CreateSet [creates=" + creates + "]";
	}
}
