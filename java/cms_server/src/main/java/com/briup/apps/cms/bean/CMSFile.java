package com.briup.apps.cms.bean;

public class CMSFile {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_file.id
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_file.fileName
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    private String filename;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_file.groupName
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    private String groupname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_file.uploadTime
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    private String uploadtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_file.fileSize
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    private Long filesize;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_file.id
     *
     * @return the value of cms_file.id
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_file.id
     *
     * @param id the value for cms_file.id
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_file.fileName
     *
     * @return the value of cms_file.fileName
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    public String getFilename() {
        return filename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_file.fileName
     *
     * @param filename the value for cms_file.fileName
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_file.groupName
     *
     * @return the value of cms_file.groupName
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_file.groupName
     *
     * @param groupname the value for cms_file.groupName
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_file.uploadTime
     *
     * @return the value of cms_file.uploadTime
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    public String getUploadtime() {
        return uploadtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_file.uploadTime
     *
     * @param uploadtime the value for cms_file.uploadTime
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    public void setUploadtime(String uploadtime) {
        this.uploadtime = uploadtime == null ? null : uploadtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_file.fileSize
     *
     * @return the value of cms_file.fileSize
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    public Long getFilesize() {
        return filesize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_file.fileSize
     *
     * @param filesize the value for cms_file.fileSize
     *
     * @mbg.generated Thu Sep 27 07:45:26 CST 2018
     */
    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }
}