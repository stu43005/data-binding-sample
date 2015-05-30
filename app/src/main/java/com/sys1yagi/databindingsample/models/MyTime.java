package com.sys1yagi.databindingsample.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.sys1yagi.databindingsample.BR;

import java.text.DateFormat;
import java.util.Date;

public class MyTime extends BaseObservable {

	private String time;

	private final DateFormat format = DateFormat.getDateTimeInstance();

	public MyTime(Date date) {
		time = format.format(date);
	}

	public void setTime(Date date) {
		time = format.format(date);
		notifyPropertyChanged(BR.time);
	}

	@Bindable
	public String getTime() {
		return time;
	}
}
