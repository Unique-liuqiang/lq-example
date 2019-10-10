package springBoot.pojo;

import java.util.Date;
import java.util.List;

/**
 * Created by linkuan on 2017/5/22.
 */
public class EquityAssets {
    private String pk_id;
    private String zcdm; //资产代码
    private String zqmc; //证券名称
    private String zhmc; //组合名称
    private String reportCode; //证券代码
    private String bookDate; // 登记日期
    private String bookDateInput; // 登记日期
    private String exrightsDate; //除权日期
    private String exrightsDateInput; //除权日期
    private Integer distributeDate; //分红到账日期
    private String distributeDateInput;
    private Double beforeRate; //税前权益比例
    private Double afterRate; //税后权益比例
    private Double exrights; // 除权金额
    private String stockDay; // 交易日
    private List<EquityAssets> zcdmList; // 资产代码
    private String userId; // 登陆人

    private String startDate; // 开始时间
    private String endDate; // 结束时间

    private String Reminder; // 提醒人
    private Date updateTime; // 删除时间
    private String updator; // 删除人

    public String getPk_id() {
        return pk_id;
    }

    public void setPk_id(String pk_id) {
        this.pk_id = pk_id;
    }

    public String getZcdm() {
        return zcdm;
    }

    public void setZcdm(String zcdm) {
        this.zcdm = zcdm;
    }

    public String getZqmc() {
        return zqmc;
    }

    public void setZqmc(String zqmc) {
        this.zqmc = zqmc;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getExrightsDateInput() {
        return exrightsDateInput;
    }

    public void setExrightsDateInput(String exrightsDateInput) {
        this.exrightsDateInput = exrightsDateInput;
    }

    public String getExrightsDate() {
        return exrightsDate;
    }

    public void setExrightsDate(String exrightsDate) {
        this.exrightsDate = exrightsDate;
    }

    public Integer getDistributeDate() {
        return distributeDate;
    }

    public void setDistributeDate(Integer distributeDate) {
        this.distributeDate = distributeDate;
    }

    public Double getBeforeRate() {
        return beforeRate;
    }

    public void setBeforeRate(Double beforeRate) {
        this.beforeRate = beforeRate;
    }

    public Double getAfterRate() {
        return afterRate;
    }

    public void setAfterRate(Double afterRate) {
        this.afterRate = afterRate;
    }

    public Double getExrights() {
        return exrights;
    }

    public void setExrights(Double exrights) {
        this.exrights = exrights;
    }

    public String getStockDay() {
        return stockDay;
    }

    public void setStockDay(String stockDay) {
        this.stockDay = stockDay;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public String getBookDateInput() {
        return bookDateInput;
    }

    public void setBookDateInput(String bookDateInput) {
        this.bookDateInput = bookDateInput;
    }

    public String getDistributeDateInput() {
        return distributeDateInput;
    }

    public void setDistributeDateInput(String distributeDateInput) {
        this.distributeDateInput = distributeDateInput;
    }

    public String getReminder() {
        return Reminder;
    }

    public void setReminder(String reminder) {
        Reminder = reminder;
    }

    public List<EquityAssets> getZcdmList() {
        return zcdmList;
    }

    public void setZcdmList(List<EquityAssets> zcdmList) {
        this.zcdmList = zcdmList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getZhmc() {
        return zhmc;
    }

    public void setZhmc(String zhmc) {
        this.zhmc = zhmc;
    }
}
