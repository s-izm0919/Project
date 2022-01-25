package bean;

import java.io.Serializable;

public class SearchDetail implements Serializable {
	private String searchWord;
	private String sort;
	private int selectCategory;
	private int maxPrice;
	public SearchDetail() {
		super();
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getSelectCategory() {
		return selectCategory;
	}
	public void setSelectCategory(int selectCategory) {
		this.selectCategory = selectCategory;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

}
