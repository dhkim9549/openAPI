package com.example.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Body {

	private Long pageNo;

	public Body() {
	}

	public Long getPageNo() {
		return this.pageNo;
	}

	public void setPageNo(Long pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		return "Body{" +
				"pageNo=" + pageNo +
				'}';
	}
}
