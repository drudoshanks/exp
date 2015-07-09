package com.model;

import java.util.ArrayList;

public class ParentModel {

	private String imageUrl = "";
	private String orgName = "";
	private int totalScore = 0;

	ArrayList<ChildModel> childmodel = new ArrayList<ChildModel>();

	public ArrayList<ChildModel> getChildmodel() {
		return childmodel;
	}

	public void setChildmodel(ArrayList<ChildModel> childmodel) {
		this.childmodel = childmodel;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

}
