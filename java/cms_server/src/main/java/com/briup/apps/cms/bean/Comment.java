package com.briup.apps.cms.bean;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_comment.id
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_comment.commentTime
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    private String commenttime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_comment.status
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_comment.article_id
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    private Long articleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_comment.customer_id
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    private Integer customerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_comment.content
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_comment.id
     *
     * @return the value of cms_comment.id
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_comment.id
     *
     * @param id the value for cms_comment.id
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_comment.commentTime
     *
     * @return the value of cms_comment.commentTime
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    public String getCommenttime() {
        return commenttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_comment.commentTime
     *
     * @param commenttime the value for cms_comment.commentTime
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime == null ? null : commenttime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_comment.status
     *
     * @return the value of cms_comment.status
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_comment.status
     *
     * @param status the value for cms_comment.status
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_comment.article_id
     *
     * @return the value of cms_comment.article_id
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_comment.article_id
     *
     * @param articleId the value for cms_comment.article_id
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_comment.customer_id
     *
     * @return the value of cms_comment.customer_id
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_comment.customer_id
     *
     * @param customerId the value for cms_comment.customer_id
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_comment.content
     *
     * @return the value of cms_comment.content
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_comment.content
     *
     * @param content the value for cms_comment.content
     *
     * @mbg.generated Fri Feb 28 13:26:58 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}