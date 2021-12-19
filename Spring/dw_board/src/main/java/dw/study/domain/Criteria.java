package dw.study.domain;

public class Criteria {//검색의 기준
	private int pageNum;
	private int amount;
	private int result;
	
	public Criteria() {
		this(0,0);
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.result = (this.pageNum-1) * this.amount;
	}
	public int getResult() {
		return result;
	}
	public void setResult() {
		this.result = (this.pageNum-1) * this.amount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		if(this.amount != 0)
			setResult();
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
		if(this.pageNum != 0)
			setResult();
	}
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + "]";
	}
	
}
