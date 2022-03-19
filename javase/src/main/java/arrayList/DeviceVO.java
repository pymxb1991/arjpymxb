package arrayList;

import java.util.Date;

/**
 * 页面交互数据用类
 *
 * @author: sun lianshou
 * @create: 2019-09-26 14:10
 */
public class DeviceVO  {

    private String name;

    private String ip;

    private String deviceNo;

    private String statusId;

    private String statusName;

    private String typeId;

    private String typeName;

    private String areaId;

    private String areaName;

    private String ownerId;

    private String ownerName;

    private String brandId;

    private String brandName;

    private String deviceModel;

    private String deviceModelName;

    private String bandWidth;

    private String version;

    private String serverId;

    private String serverName;

    private Integer port;

    private String location;
    private String locationName;

    private String account;

    private String password;

    private String configStatus;

    private String configStatusName;

    private String barCode;
    
    private String alertLevel;
    
    private String alertLevelName;
    
    private String extra;
    /**
     * 分期id
     */
    private String periodizationId;
    private String periodizationName;


    /**
     *品牌
     */
    private String brand;
    private String deviceBrandName;

    /**
     *资产状态
     */
    private String status;
    private String deviceStatusName;
    /**
     * 审核标记
     */
    private Integer auditFlag;
    private String auditFlagName;

    /**
     * 同步的标识字段
     */
    private Integer sync;

    /**
     * 维保到期时间
     */
    private Date maintenanceEndTime;
    /**
     * 维保到期时间
     */
    private String maintenanceEndTimeStr;
    /**
     * 备件库存数量
     */
    private Integer sparesStock;

    /**
     * 设备库存和维保到期提醒标志 （默认0提醒  1 维保不提醒）
     */
    private Integer remindFlag;

    /**
     * 重点关注标志(0关注 1不关注)
     */
    private Integer focusFlag;

    /**
     * 是否为角色控制的状态 是的话选中 （0是 1否）
     */
    private Integer hasChecked;

    /**
     * 系统类型
     */
    private String systemTypeId;
    private String systemTypeName;
    //控制态势感知
    private String isShow;

    //电线杆上的位置
    private String poleNumber;
    private String poleNumberName;

    /**
     * 备品备件Id
     */
    private String sparePartId;
    /**
     * 备品备件Id
     */
    private String networkType;
    private String networkTypeName;


    /**
     * 所属组织机构id
     */
    private String orgId;

    /**
     * 摄像机类型 类型为摄像机时才有用
     */
    private String cameraTypeId;
    private String cameraTypeName;

    /**
     * 3d 机房
     */
    // 是否显示跳转机房按钮 0 不显示 1 显示
    private String machineRoomFlag;
    // 所在机房Id
    private String machineRoomId;

    /**
     * 是否全字段 0是 1不是
     */
    private Integer isAllFields;

    /**
     * 服务器使用寿命
     */
    private Integer serveLife;
    /**
     * 磁盘使用寿命
     */
    private Integer diskLife;
    /**
     * 磁盘使用寿命
     */
    private Integer totalComputingPower;
    private Integer currentComputingPower;
    private Integer availableComputingPower;

    /**
     * id
     */
    private String id;
    /**
     * 创建者id
     */
    private String createUserID;
    /**
     * 创建者名字
     */
    private String createUserName;
    /**
     * 创建数据时间
     */
    private Date createDateTime;
    /**
     * 数据更新人id
     */
    private String updateUserID;
    /**
     * 更新人名字
     */
    private String updateUserName;
    /**
     * 数据更新时间
     */
    private Date updateDateTime;
    /**
     * 备注
     */
    private String remarks;

    private String extraFrom;

    public DeviceVO() {
    }

    public DeviceVO(String name, String ip, String id) {
        this.name = name;
        this.ip = ip;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceModelName() {
        return deviceModelName;
    }

    public void setDeviceModelName(String deviceModelName) {
        this.deviceModelName = deviceModelName;
    }

    public String getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(String bandWidth) {
        this.bandWidth = bandWidth;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfigStatus() {
        return configStatus;
    }

    public void setConfigStatus(String configStatus) {
        this.configStatus = configStatus;
    }

    public String getConfigStatusName() {
        return configStatusName;
    }

    public void setConfigStatusName(String configStatusName) {
        this.configStatusName = configStatusName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    public String getAlertLevelName() {
        return alertLevelName;
    }

    public void setAlertLevelName(String alertLevelName) {
        this.alertLevelName = alertLevelName;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getPeriodizationId() {
        return periodizationId;
    }

    public void setPeriodizationId(String periodizationId) {
        this.periodizationId = periodizationId;
    }

    public String getPeriodizationName() {
        return periodizationName;
    }

    public void setPeriodizationName(String periodizationName) {
        this.periodizationName = periodizationName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDeviceBrandName() {
        return deviceBrandName;
    }

    public void setDeviceBrandName(String deviceBrandName) {
        this.deviceBrandName = deviceBrandName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeviceStatusName() {
        return deviceStatusName;
    }

    public void setDeviceStatusName(String deviceStatusName) {
        this.deviceStatusName = deviceStatusName;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public String getAuditFlagName() {
        return auditFlagName;
    }

    public void setAuditFlagName(String auditFlagName) {
        this.auditFlagName = auditFlagName;
    }

    public Integer getSync() {
        return sync;
    }

    public void setSync(Integer sync) {
        this.sync = sync;
    }

    public Date getMaintenanceEndTime() {
        return maintenanceEndTime;
    }

    public void setMaintenanceEndTime(Date maintenanceEndTime) {
        this.maintenanceEndTime = maintenanceEndTime;
    }

    public String getMaintenanceEndTimeStr() {
        return maintenanceEndTimeStr;
    }

    public void setMaintenanceEndTimeStr(String maintenanceEndTimeStr) {
        this.maintenanceEndTimeStr = maintenanceEndTimeStr;
    }

    public Integer getSparesStock() {
        return sparesStock;
    }

    public void setSparesStock(Integer sparesStock) {
        this.sparesStock = sparesStock;
    }

    public Integer getRemindFlag() {
        return remindFlag;
    }

    public void setRemindFlag(Integer remindFlag) {
        this.remindFlag = remindFlag;
    }

    public Integer getFocusFlag() {
        return focusFlag;
    }

    public void setFocusFlag(Integer focusFlag) {
        this.focusFlag = focusFlag;
    }

    public Integer getHasChecked() {
        return hasChecked;
    }

    public void setHasChecked(Integer hasChecked) {
        this.hasChecked = hasChecked;
    }

    public String getSystemTypeId() {
        return systemTypeId;
    }

    public void setSystemTypeId(String systemTypeId) {
        this.systemTypeId = systemTypeId;
    }

    public String getSystemTypeName() {
        return systemTypeName;
    }

    public void setSystemTypeName(String systemTypeName) {
        this.systemTypeName = systemTypeName;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getPoleNumber() {
        return poleNumber;
    }

    public void setPoleNumber(String poleNumber) {
        this.poleNumber = poleNumber;
    }

    public String getPoleNumberName() {
        return poleNumberName;
    }

    public void setPoleNumberName(String poleNumberName) {
        this.poleNumberName = poleNumberName;
    }

    public String getSparePartId() {
        return sparePartId;
    }

    public void setSparePartId(String sparePartId) {
        this.sparePartId = sparePartId;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getNetworkTypeName() {
        return networkTypeName;
    }

    public void setNetworkTypeName(String networkTypeName) {
        this.networkTypeName = networkTypeName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getCameraTypeId() {
        return cameraTypeId;
    }

    public void setCameraTypeId(String cameraTypeId) {
        this.cameraTypeId = cameraTypeId;
    }

    public String getCameraTypeName() {
        return cameraTypeName;
    }

    public void setCameraTypeName(String cameraTypeName) {
        this.cameraTypeName = cameraTypeName;
    }

    public String getMachineRoomFlag() {
        return machineRoomFlag;
    }

    public void setMachineRoomFlag(String machineRoomFlag) {
        this.machineRoomFlag = machineRoomFlag;
    }

    public String getMachineRoomId() {
        return machineRoomId;
    }

    public void setMachineRoomId(String machineRoomId) {
        this.machineRoomId = machineRoomId;
    }

    public Integer getIsAllFields() {
        return isAllFields;
    }

    public void setIsAllFields(Integer isAllFields) {
        this.isAllFields = isAllFields;
    }

    public Integer getServeLife() {
        return serveLife;
    }

    public void setServeLife(Integer serveLife) {
        this.serveLife = serveLife;
    }

    public Integer getDiskLife() {
        return diskLife;
    }

    public void setDiskLife(Integer diskLife) {
        this.diskLife = diskLife;
    }

    public Integer getTotalComputingPower() {
        return totalComputingPower;
    }

    public void setTotalComputingPower(Integer totalComputingPower) {
        this.totalComputingPower = totalComputingPower;
    }

    public Integer getCurrentComputingPower() {
        return currentComputingPower;
    }

    public void setCurrentComputingPower(Integer currentComputingPower) {
        this.currentComputingPower = currentComputingPower;
    }

    public Integer getAvailableComputingPower() {
        return availableComputingPower;
    }

    public void setAvailableComputingPower(Integer availableComputingPower) {
        this.availableComputingPower = availableComputingPower;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateUserID() {
        return createUserID;
    }

    public void setCreateUserID(String createUserID) {
        this.createUserID = createUserID;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
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

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
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

    public String getExtraFrom() {
        return extraFrom;
    }

    public void setExtraFrom(String extraFrom) {
        this.extraFrom = extraFrom;
    }

    @Override
    public String toString() {
        return "DeviceVO{" +
                "name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
