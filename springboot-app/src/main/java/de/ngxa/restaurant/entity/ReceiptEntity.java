package de.ngxa.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "receipt_seq", allocationSize = 1)
public class ReceiptEntity extends BaseEntity {

	private static final long serialVersionUID = -4868889528672407932L;
	private String mainImgUrl;
	private String title;

	@Column(columnDefinition = "TEXT")
	private String htmlContent;
	private String tags;
	private String nextReceiptUrl;
	private String previousReceiptUrl;

	private String facebookUrl;
	private String twitterUrl;
	private String instagramUrl;

	private Long totalHits;
	private Long likes;

	public String getMainImgUrl() {
		return mainImgUrl;
	}

	public void setMainImgUrl(String mainImgUrl) {
		this.mainImgUrl = mainImgUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getNextReceiptUrl() {
		return nextReceiptUrl;
	}

	public void setNextReceiptUrl(String nextReceiptUrl) {
		this.nextReceiptUrl = nextReceiptUrl;
	}

	public String getPreviousReceiptUrl() {
		return previousReceiptUrl;
	}

	public void setPreviousReceiptUrl(String previousReceiptUrl) {
		this.previousReceiptUrl = previousReceiptUrl;
	}

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	public String getInstagramUrl() {
		return instagramUrl;
	}

	public void setInstagramUrl(String instagramUrl) {
		this.instagramUrl = instagramUrl;
	}

	public Long getTotalHits() {
		return totalHits;
	}

	public void setTotalHits(Long totalHits) {
		this.totalHits = totalHits;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

}
