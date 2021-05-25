package com.koreait.board7.board;

public class BoardDTO {
	private int stratIdx;
	private int recordCnt;
	private int searchType;
	private String searchText;
	private int iboard;
	
	public int getIboard() {
		return iboard;
	}
	public void setIboard(int iboard) {
		this.iboard = iboard;
	}
	public int getSearchType() {
		return searchType;
	}
	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public int getStratIdx() {
		return stratIdx;
	}
	public void setStratIdx(int stratIdx) {
		this.stratIdx = stratIdx;
	}
	public int getRecordCnt() {
		return recordCnt;
	}
	public void setRecordCnt(int recordCnt) {
		this.recordCnt = recordCnt;
	}
	
}
