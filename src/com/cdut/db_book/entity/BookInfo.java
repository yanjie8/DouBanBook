package com.cdut.db_book.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTML.Tag;

public class BookInfo {
	private String id;
	private String isbn10;
	private String isbn13;
	private String title;
	private String origin_title;
	private String alt_title;
	private String subtitle;
	private String url;
	private String alt;
	private String image;
	private Map<String, String> images = new HashMap<String, String>();
	private List<String> author;
	private List<String> translator;
	private String publisher = "中国友谊出版公司";
	private String pubdate = "2000-9-1";
	private Map<String, String> rating = new HashMap<String, String>();
	// {"max=10;"numRaters=9438;"average="9.1";"min=0};
	private List<Tag> tags = new ArrayList<Tag>();
	// {"count=2416;"name="小王子"};
	// {"count=1914;"name="童话"};
	// {"count=1185;"name="圣埃克苏佩里"};
	// {"count=863;"name="法国"};
	// {"count=647;"name="经典"};
	// {"count=597;"name="外国文学"};
	// {"count=495;"name="感动"};
	// {"count=368;"name="寓言"}
	// ];
	private String binding = "";
	private String price = "";
	private String pages = "";
	private String author_intro = "";
	private String summary = "";

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsbn10() {
		return isbn10;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOrigin_title() {
		return origin_title;
	}

	public void setOrigin_title(String origin_title) {
		this.origin_title = origin_title;
	}

	public String getAlt_title() {
		return alt_title;
	}

	public void setAlt_title(String alt_title) {
		this.alt_title = alt_title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Map<String, String> getImages() {
		return images;
	}

	public void setImages(Map<String, String> images) {
		this.images = images;
	}

	public List<String> getAuthor() {
		return author;
	}

	public void setAuthor(List<String> author) {
		this.author = author;
	}

	public List<String> getTranslator() {
		return translator;
	}

	public void setTranslator(List<String> translator) {
		this.translator = translator;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public Map<String, String> getRating() {
		return rating;
	}

	public void setRating(Map<String, String> rating) {
		this.rating = rating;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getAuthor_intro() {
		return author_intro;
	}

	public void setAuthor_intro(String author_intro) {
		this.author_intro = author_intro;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}
