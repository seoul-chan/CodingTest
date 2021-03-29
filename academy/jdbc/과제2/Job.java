package com.home2.model.vo;

public class Job {

	private String jobCode;
	private String jobName;
	
	public Job() {}

	public Job(String jobCode, String jobName) {
		this.jobCode = jobCode;
		this.jobName = jobName;
	}

	public String getJobCode() {return jobCode;}
	public String getJobName() {return jobName;}

	public void setJobCode(String jobCode) {this.jobCode = jobCode;}
	public void setJobName(String jobName) {this.jobName = jobName;}

	@Override
	public String toString() {
		return "Job [jobCode=" + jobCode + ", jobName=" + jobName + "]";
	}	
}
