package com.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Project {
	
	@Value("101")
	int p_id;
	
	@Value("Agrisync")
	String p_name;
	
	@Value("Java Fullstack")
	String stack;
	
	public Project() {
	}

	public Project(int p_id, String p_name, String stack) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.stack = stack;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	@Override
	public String toString() {
		return "Project [p_id=" + p_id + ", p_name=" + p_name + ", stack=" + stack + "]";
	}
	
	

}
