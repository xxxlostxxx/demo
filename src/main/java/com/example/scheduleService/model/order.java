package com.example.scheduleService.model;

import java.math.BigDecimal;

public class order {
    private String orderid;

    private String channelid;

    private String channelname;

    private String itemid;

    private String itemname;

    private String userid;

    private String username;

    private String user_idcard;

    private String productid;

    private String productname;

    private BigDecimal applyamount;

    private BigDecimal loanamount;

    private BigDecimal limitamount;

    private BigDecimal year_rate;

    private Long begdate;

    private Long enddate;

    private String repaytype;

    private Integer cycle;

    private String purpose;

    private String loantype;

    private String loanstate;

    private Integer gpsfeeid;

    private String gpsfee_name;

    private BigDecimal total_prefee;

    private BigDecimal servicefee;

    private BigDecimal ensurefee;

    private BigDecimal gpsfee;

    private BigDecimal unpay_finalfee;

    private BigDecimal pledge_fee;

    private BigDecimal other_prefee;

    private BigDecimal each_repay;

    private Integer repay_num;

    private String repay_unit;

    private String periodflag;

    private BigDecimal each_baseamount;

    private Long first_repay_date;

    private Long last_repay_date;

    private Integer node;

    private String lastcheckuser;

    private String bondsmanfalg;

    private String asset;

    private String state;

    private Long createdate;

    private Long lastmodifydate;

    private String createuser;

    private String lastmodifyuser;

    private String reserve;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid == null ? null : channelid.trim();
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname == null ? null : channelname.trim();
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid == null ? null : itemid.trim();
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUser_idcard() {
        return user_idcard;
    }

    public void setUser_idcard(String user_idcard) {
        this.user_idcard = user_idcard == null ? null : user_idcard.trim();
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public BigDecimal getApplyamount() {
        return applyamount;
    }

    public void setApplyamount(BigDecimal applyamount) {
        this.applyamount = applyamount;
    }

    public BigDecimal getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(BigDecimal loanamount) {
        this.loanamount = loanamount;
    }

    public BigDecimal getLimitamount() {
        return limitamount;
    }

    public void setLimitamount(BigDecimal limitamount) {
        this.limitamount = limitamount;
    }

    public BigDecimal getYear_rate() {
        return year_rate;
    }

    public void setYear_rate(BigDecimal year_rate) {
        this.year_rate = year_rate;
    }

    public Long getBegdate() {
        return begdate;
    }

    public void setBegdate(Long begdate) {
        this.begdate = begdate;
    }

    public Long getEnddate() {
        return enddate;
    }

    public void setEnddate(Long enddate) {
        this.enddate = enddate;
    }

    public String getRepaytype() {
        return repaytype;
    }

    public void setRepaytype(String repaytype) {
        this.repaytype = repaytype == null ? null : repaytype.trim();
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getLoantype() {
        return loantype;
    }

    public void setLoantype(String loantype) {
        this.loantype = loantype == null ? null : loantype.trim();
    }

    public String getLoanstate() {
        return loanstate;
    }

    public void setLoanstate(String loanstate) {
        this.loanstate = loanstate == null ? null : loanstate.trim();
    }

    public Integer getGpsfeeid() {
        return gpsfeeid;
    }

    public void setGpsfeeid(Integer gpsfeeid) {
        this.gpsfeeid = gpsfeeid;
    }

    public String getGpsfee_name() {
        return gpsfee_name;
    }

    public void setGpsfee_name(String gpsfee_name) {
        this.gpsfee_name = gpsfee_name == null ? null : gpsfee_name.trim();
    }

    public BigDecimal getTotal_prefee() {
        return total_prefee;
    }

    public void setTotal_prefee(BigDecimal total_prefee) {
        this.total_prefee = total_prefee;
    }

    public BigDecimal getServicefee() {
        return servicefee;
    }

    public void setServicefee(BigDecimal servicefee) {
        this.servicefee = servicefee;
    }

    public BigDecimal getEnsurefee() {
        return ensurefee;
    }

    public void setEnsurefee(BigDecimal ensurefee) {
        this.ensurefee = ensurefee;
    }

    public BigDecimal getGpsfee() {
        return gpsfee;
    }

    public void setGpsfee(BigDecimal gpsfee) {
        this.gpsfee = gpsfee;
    }

    public BigDecimal getUnpay_finalfee() {
        return unpay_finalfee;
    }

    public void setUnpay_finalfee(BigDecimal unpay_finalfee) {
        this.unpay_finalfee = unpay_finalfee;
    }

    public BigDecimal getPledge_fee() {
        return pledge_fee;
    }

    public void setPledge_fee(BigDecimal pledge_fee) {
        this.pledge_fee = pledge_fee;
    }

    public BigDecimal getOther_prefee() {
        return other_prefee;
    }

    public void setOther_prefee(BigDecimal other_prefee) {
        this.other_prefee = other_prefee;
    }

    public BigDecimal getEach_repay() {
        return each_repay;
    }

    public void setEach_repay(BigDecimal each_repay) {
        this.each_repay = each_repay;
    }

    public Integer getRepay_num() {
        return repay_num;
    }

    public void setRepay_num(Integer repay_num) {
        this.repay_num = repay_num;
    }

    public String getRepay_unit() {
        return repay_unit;
    }

    public void setRepay_unit(String repay_unit) {
        this.repay_unit = repay_unit == null ? null : repay_unit.trim();
    }

    public String getPeriodflag() {
        return periodflag;
    }

    public void setPeriodflag(String periodflag) {
        this.periodflag = periodflag == null ? null : periodflag.trim();
    }

    public BigDecimal getEach_baseamount() {
        return each_baseamount;
    }

    public void setEach_baseamount(BigDecimal each_baseamount) {
        this.each_baseamount = each_baseamount;
    }

    public Long getFirst_repay_date() {
        return first_repay_date;
    }

    public void setFirst_repay_date(Long first_repay_date) {
        this.first_repay_date = first_repay_date;
    }

    public Long getLast_repay_date() {
        return last_repay_date;
    }

    public void setLast_repay_date(Long last_repay_date) {
        this.last_repay_date = last_repay_date;
    }

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }

    public String getLastcheckuser() {
        return lastcheckuser;
    }

    public void setLastcheckuser(String lastcheckuser) {
        this.lastcheckuser = lastcheckuser == null ? null : lastcheckuser.trim();
    }

    public String getBondsmanfalg() {
        return bondsmanfalg;
    }

    public void setBondsmanfalg(String bondsmanfalg) {
        this.bondsmanfalg = bondsmanfalg == null ? null : bondsmanfalg.trim();
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset == null ? null : asset.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public String getLastmodifyuser() {
        return lastmodifyuser;
    }

    public void setLastmodifyuser(String lastmodifyuser) {
        this.lastmodifyuser = lastmodifyuser == null ? null : lastmodifyuser.trim();
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }
}