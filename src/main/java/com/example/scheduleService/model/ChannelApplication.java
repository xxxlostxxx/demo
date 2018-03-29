package com.example.scheduleService.model;

public class ChannelApplication {
    private String id;

    private String demand;

    private String company;

    private String linkman;

    private String contact_number;

    private String status;

    private Long createdate;

    private Long lastmodifydate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand == null ? null : demand.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number == null ? null : contact_number.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    public Long getLastmodifydate() {
        return lastmodifydate;
    }

    public void setLastmodifydate(Long lastmodifydate) {
        this.lastmodifydate = lastmodifydate;
    }
}