package com.pwms.pojo;

import java.util.Date;

public class Userinfo {
    private Integer id;

    private String name;

    private String studentId;

    private Integer userClass;

    private String sex;

    private String nation;

    private String nativePlace;

    private Date birthday;

    private String posttion;

    private Date dateline;

    private String phone;

    private String contacts;

    private String trainEducat;

    private String inspect;

    private Date trainDate;

    private Date activeDate;

    private Integer partyGrade;

    private Date formalDate;

    private Date joinDate;

    private Date readyPartyDate;

    private String address;

    private String email;

    private String note;

    private Integer type;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public Integer getUserClass() {
        return userClass;
    }

    public void setUserClass(Integer userClass) {
        this.userClass = userClass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPosttion() {
        return posttion;
    }

    public void setPosttion(String posttion) {
        this.posttion = posttion == null ? null : posttion.trim();
    }

    public Date getDateline() {
        return dateline;
    }

    public void setDateline(Date dateline) {
        this.dateline = dateline;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getTrainEducat() {
        return trainEducat;
    }

    public void setTrainEducat(String trainEducat) {
        this.trainEducat = trainEducat == null ? null : trainEducat.trim();
    }

    public String getInspect() {
        return inspect;
    }

    public void setInspect(String inspect) {
        this.inspect = inspect == null ? null : inspect.trim();
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public Integer getPartyGrade() {
        return partyGrade;
    }

    public void setPartyGrade(Integer partyGrade) {
        this.partyGrade = partyGrade;
    }

    public Date getFormalDate() {
        return formalDate;
    }

    public void setFormalDate(Date formalDate) {
        this.formalDate = formalDate;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getReadyPartyDate() {
        return readyPartyDate;
    }

    public void setReadyPartyDate(Date readyPartyDate) {
        this.readyPartyDate = readyPartyDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setUserinfoModify(UserinfoModify userinfoModify){
    	this.activeDate = userinfoModify.getActiveDate();
    	this.address = userinfoModify.getAddress();
    	this.birthday = userinfoModify.getBirthday();
    	this.contacts = userinfoModify.getContacts();
    	this.dateline = userinfoModify.getDateline();
    	this.email =userinfoModify.getEmail();
    	this.formalDate = userinfoModify.getFormalDate();
    	this.inspect = userinfoModify.getInspect();
    	this.joinDate= userinfoModify.getJoinDate();
    	this.name = userinfoModify.getName();
    	this.nation = userinfoModify.getNation();
    	this.nativePlace = userinfoModify.getNativePlace();
    	this.note = userinfoModify.getNote();
    	this.partyGrade = userinfoModify.getPartyGrade();
    	this.phone = userinfoModify.getPhone();
    	this.posttion = userinfoModify.getPosttion();
    	this.readyPartyDate = userinfoModify.getReadyPartyDate();
    	this.sex = userinfoModify.getSex();
    	this.studentId =userinfoModify.getStudentId();
    	this.trainDate = userinfoModify.getTrainDate();
    	this.trainEducat = userinfoModify.getTrainEducat();
    	this.type = userinfoModify.getType();
    	this.userClass = userinfoModify.getUserClass();
    	this.userId = userinfoModify.getUserId();
    }
}