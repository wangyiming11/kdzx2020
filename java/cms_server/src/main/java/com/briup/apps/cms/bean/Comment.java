package com.briup.apps.cms.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="评论")
public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_comment.id
     *
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
     */
	@ApiModelProperty(value="编号")
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_comment.commentTime
     *
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
     */
	@ApiModelProperty(value="评论时间")
    private String commenttime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_comment.status
     *
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
     */
	@ApiModelProperty(value="审核状态")
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_comment.article_id
     *
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
     */
	@ApiModelProperty(value="文章编号",required=true)
    private Long articleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_comment.customer_id
     *
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
     */
	@ApiModelProperty(value="用户编号")
    private String customerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_comment.content
     *
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
     */
	@ApiModelProperty(value="评论内容",required=true)
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_comment.id
     *
     * @return the value of cms_comment.id
     *
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
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
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
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
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
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
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
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
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
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
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
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
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
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
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
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
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_comment.customer_id
     *
     * @param customerId the value for cms_comment.customer_id
     *
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_comment.content
     *
     * @return the value of cms_comment.content
     *
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
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
     * @mbg.generated Wed Sep 19 10:22:50 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}