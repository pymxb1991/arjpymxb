package arrayList;


import java.util.Date;

public class DeviceFocus  {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 设备ID
     */
    private String deviceId;
    /**
     * id
     */
    private String id;
    /**
     * 删除标志
     */
    private Integer deleteFlag= 0;
    /**
     * 创建者id
     */
    private String createUserID;
    /**
     * 创建数据时间
     */
    private Date createDateTime;
    /**
     * 数据更新人id
     */
    private String updateUserID;
    /**
     * 数据更新时间
     */

    private Date updateDateTime;
    /**
     * 备注
     */
    private String remarks;

    public DeviceFocus() {
    }

    public DeviceFocus(String userId, String deviceId, String id) {
        this.userId = userId;
        this.deviceId = deviceId;
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCreateUserID() {
        return createUserID;
    }

    public void setCreateUserID(String createUserID) {
        this.createUserID = createUserID;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getUpdateUserID() {
        return updateUserID;
    }

    public void setUpdateUserID(String updateUserID) {
        this.updateUserID = updateUserID;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
