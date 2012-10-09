package com.tavant.domain;

import java.io.Serializable;

public class Anniversary implements Serializable {

	private static final long serialVersionUID = 1L;
	private int anniversaryId;
	private String title;
	private String date;
	private String people;
	private String repeatCycle;
	private int userId;

	public Anniversary() {

	}

	public Anniversary(int anniversaryId, int userId) {
		this.anniversaryId = anniversaryId;
		this.userId = userId;
	}

	public int getAnniversaryId() {
		return anniversaryId;
	}

	public void setAnniversaryId(int anniversaryId) {
		this.anniversaryId = anniversaryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getRepeatCycle() {
		return repeatCycle;
	}

	public void setRepeatCycle(String repeatCycle) {
		this.repeatCycle = repeatCycle;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Anniversary [anniversaryId=" + anniversaryId + ", title="
				+ title + ", date=" + date + ", people=" + people
				+ ", repeatCycle=" + repeatCycle + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anniversaryId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((people == null) ? 0 : people.hashCode());
		result = prime * result
				+ ((repeatCycle == null) ? 0 : repeatCycle.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anniversary other = (Anniversary) obj;
		if (anniversaryId != other.anniversaryId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (people == null) {
			if (other.people != null)
				return false;
		} else if (!people.equals(other.people))
			return false;
		if (repeatCycle == null) {
			if (other.repeatCycle != null)
				return false;
		} else if (!repeatCycle.equals(other.repeatCycle))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

}
