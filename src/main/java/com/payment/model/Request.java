package com.payment.model;

public class Request {
	private double loanAmount;
	private double nominalRate;
	private int duration;
	private String startDate;

	public Request() {
	}

	public Request(final double loanAmount, final double nominalRate, final int duration, final String startDate) {
		this.loanAmount = loanAmount;
		this.nominalRate = nominalRate;
		this.duration = duration;
		this.startDate = startDate;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public double getNominalRate() {
		return nominalRate;
	}

	public int getDuration() {
		return duration;
	}

	public String getStartDate() {
		return startDate;
	}

	public void validate() throws Exception {
		if (this.loanAmount <= 0)
			throw new Exception("loanAmount <= 0");

		if (this.nominalRate <= 0)
			throw new Exception("nominalRate <= 0");

		if (this.duration <= 0)
			throw new Exception("duration <= 0");

		if (this.startDate == null || this.startDate.isEmpty())
			throw new Exception("startDate == null");
	}
}
