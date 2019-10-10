package springBoot.pojo;


/**
 * 任务关联信息bean
 */
public class TaskInitiateAssociation {
    private String  initateUid;
    //付息通知书附件ID
    private  String fxtzszzjbFjid;
    //投资收益经办附件ID
    private  String tzsyjsjbFjid;
    //计算可分配收益附件ID
    private  String jskfpsyFjid;
    private  String jskfpsyDocId;


    public String getInitateUid() {
        return initateUid;
    }

    public void setInitateUid(String initateUid) {
        this.initateUid = initateUid;
    }

    public String getFxtzszzjbFjid() {
        return fxtzszzjbFjid;
    }

    public String getTzsyjsjbFjid() {
        return tzsyjsjbFjid;
    }

    public void setTzsyjsjbFjid(String tzsyjsjbFjid) {
        this.tzsyjsjbFjid = tzsyjsjbFjid;
    }

    public void setFxtzszzjbFjid(String fxtzszzjbFjid) {
        this.fxtzszzjbFjid = fxtzszzjbFjid;
    }


    public String getJskfpsyFjid() {
        return jskfpsyFjid;
    }

    public void setJskfpsyFjid(String jskfpsyFjid) {
        this.jskfpsyFjid = jskfpsyFjid;
    }


    public String getJskfpsyDocId() {
        return jskfpsyDocId;
    }

    public void setJskfpsyDocId(String jskfpsyDocId) {
        this.jskfpsyDocId = jskfpsyDocId;
    }
}
