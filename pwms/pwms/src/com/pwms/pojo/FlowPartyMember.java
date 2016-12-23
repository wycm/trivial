package com.pwms.pojo;

import java.util.Date;

public class FlowPartyMember {
    private Integer id;

    private String name;

    private String sex;

    private String nation;

    private String nativePlace;

    private Date birthday;

    private String culture;

    private String joinDate;

    private String identityId;

    private String contactPhone;

    private String censusAddress;

    private String originalContacts;

    private String originalContactsPhone;

    private String destBranch;

    private Date joinDestDate;

    private String destBranchContacts;

    private String destContactsPhone;

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

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture == null ? null : culture.trim();
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate == null ? null : joinDate.trim();
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId == null ? null : identityId.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getCensusAddress() {
        return censusAddress;
    }

    public void setCensusAddress(String censusAddress) {
        this.censusAddress = censusAddress == null ? null : censusAddress.trim();
    }

    public String getOriginalContacts() {
        return originalContacts;
    }

    public void setOriginalContacts(String originalContacts) {
        this.originalContacts = originalContacts == null ? null : originalContacts.trim();
    }

    public String getOriginalContactsPhone() {
        return originalContactsPhone;
    }

    public void setOriginalContactsPhone(String originalContactsPhone) {
        this.originalContactsPhone = originalContactsPhone == null ? null : originalContactsPhone.trim();
    }

    public String getDestBranch() {
        return destBranch;
    }

    public void setDestBranch(String destBranch) {
        this.destBranch = destBranch == null ? null : destBranch.trim();
    }

    public Date getJoinDestDate() {
        return joinDestDate;
    }

    public void setJoinDestDate(Date joinDestDate) {
        this.joinDestDate = joinDestDate;
    }

    public String getDestBranchContacts() {
        return destBranchContacts;
    }

    public void setDestBranchContacts(String destBranchContacts) {
        this.destBranchContacts = destBranchContacts == null ? null : destBranchContacts.trim();
    }

    public String getDestContactsPhone() {
        return destContactsPhone;
    }

    public void setDestContactsPhone(String destContactsPhone) {
        this.destContactsPhone = destContactsPhone == null ? null : destContactsPhone.trim();
    }
}