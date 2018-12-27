package com.example.scheduleService.model;

import java.util.Date;

public class AlarmEventDO {
    private Integer id;

    private Integer type;

    private Date alarmBegin;

    private Date alarmEnd;

    private Integer alarmDuration;

    private Integer priority;

    private Integer allClearMethod;

    private Integer targetId;

    private Integer targetType;

    private Integer bdId;

    private String bdName;

    private Integer cmId;

    private String cmName;

    private Integer bdmId;

    private String bdmName;

    private Integer dmId;

    private String dmName;

    private Integer allClearUser;

    private Date allClearTime;

    private String clearReason;

    private Date alarmUpdateTime;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getAlarmBegin() {
        return alarmBegin;
    }

    public void setAlarmBegin(Date alarmBegin) {
        this.alarmBegin = alarmBegin;
    }

    public Date getAlarmEnd() {
        return alarmEnd;
    }

    public void setAlarmEnd(Date alarmEnd) {
        this.alarmEnd = alarmEnd;
    }

    public Integer getAlarmDuration() {
        return alarmDuration;
    }

    public void setAlarmDuration(Integer alarmDuration) {
        this.alarmDuration = alarmDuration;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getAllClearMethod() {
        return allClearMethod;
    }

    public void setAllClearMethod(Integer allClearMethod) {
        this.allClearMethod = allClearMethod;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public Integer getBdId() {
        return bdId;
    }

    public void setBdId(Integer bdId) {
        this.bdId = bdId;
    }

    public String getBdName() {
        return bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName == null ? null : bdName.trim();
    }

    public Integer getCmId() {
        return cmId;
    }

    public void setCmId(Integer cmId) {
        this.cmId = cmId;
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName == null ? null : cmName.trim();
    }

    public Integer getBdmId() {
        return bdmId;
    }

    public void setBdmId(Integer bdmId) {
        this.bdmId = bdmId;
    }

    public String getBdmName() {
        return bdmName;
    }

    public void setBdmName(String bdmName) {
        this.bdmName = bdmName == null ? null : bdmName.trim();
    }

    public Integer getDmId() {
        return dmId;
    }

    public void setDmId(Integer dmId) {
        this.dmId = dmId;
    }

    public String getDmName() {
        return dmName;
    }

    public void setDmName(String dmName) {
        this.dmName = dmName == null ? null : dmName.trim();
    }

    public Integer getAllClearUser() {
        return allClearUser;
    }

    public void setAllClearUser(Integer allClearUser) {
        this.allClearUser = allClearUser;
    }

    public Date getAllClearTime() {
        return allClearTime;
    }

    public void setAllClearTime(Date allClearTime) {
        this.allClearTime = allClearTime;
    }

    public String getClearReason() {
        return clearReason;
    }

    public void setClearReason(String clearReason) {
        this.clearReason = clearReason == null ? null : clearReason.trim();
    }

    public Date getAlarmUpdateTime() {
        return alarmUpdateTime;
    }

    public void setAlarmUpdateTime(Date alarmUpdateTime) {
        this.alarmUpdateTime = alarmUpdateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}