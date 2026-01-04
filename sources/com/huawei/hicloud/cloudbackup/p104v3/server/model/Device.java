package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class Device extends C11707b {

    @InterfaceC4648p
    private String app;

    @InterfaceC4648p
    private List<Bak> baks;

    @InterfaceC4648p
    private Long classicSize;

    @InterfaceC4648p
    private C4644l createTime;

    @InterfaceC4648p
    private String deviceCategory;

    @InterfaceC4648p
    private String deviceDisplayName;

    @InterfaceC4648p
    private String deviceIconUrl;

    @InterfaceC4648p
    private String devicePathName;

    @InterfaceC4648p
    private C4644l dirtyClearEndTime;

    @InterfaceC4648p
    private Long dirtyClearFileSize;

    @InterfaceC4648p
    private Long dirtyClearFileSpace;

    @InterfaceC4648p
    private C4644l dirtyClearStartTime;

    @InterfaceC4648p
    private Integer dirtyClearStatus;

    @InterfaceC4648p
    private String dirtyClearTaskId;

    @InterfaceC4648p
    private Integer dirtyType;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22592id;

    @InterfaceC4648p
    private Long interimSize;

    @InterfaceC4648p
    private Integer occupySpaceType;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String source;

    @InterfaceC4648p
    private String terminalOS;

    @InterfaceC4648p
    private String terminalType;

    @InterfaceC4648p
    private C4644l updateTime;

    public String getApp() {
        return this.app;
    }

    public List<Bak> getBaks() {
        return this.baks;
    }

    public Long getClassicSize() {
        return this.classicSize;
    }

    public C4644l getCreateTime() {
        return this.createTime;
    }

    public String getDeviceCategory() {
        return this.deviceCategory;
    }

    public String getDeviceDisplayName() {
        return this.deviceDisplayName;
    }

    public String getDeviceIconUrl() {
        return this.deviceIconUrl;
    }

    public String getDevicePathName() {
        return this.devicePathName;
    }

    public C4644l getDirtyClearEndTime() {
        return this.dirtyClearEndTime;
    }

    public Long getDirtyClearFileSize() {
        return this.dirtyClearFileSize;
    }

    public Long getDirtyClearFileSpace() {
        return this.dirtyClearFileSpace;
    }

    public C4644l getDirtyClearStartTime() {
        return this.dirtyClearStartTime;
    }

    public Integer getDirtyClearStatus() {
        return this.dirtyClearStatus;
    }

    public String getDirtyClearTaskId() {
        return this.dirtyClearTaskId;
    }

    public Integer getDirtyType() {
        return this.dirtyType;
    }

    public String getId() {
        return this.f22592id;
    }

    public Long getInterimSize() {
        return this.interimSize;
    }

    public Integer getOccupySpaceType() {
        return this.occupySpaceType;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String getSource() {
        return this.source;
    }

    public String getTerminalOS() {
        return this.terminalOS;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public C4644l getUpdateTime() {
        return this.updateTime;
    }

    public Device setApp(String str) {
        this.app = str;
        return this;
    }

    public Device setBaks(List<Bak> list) {
        this.baks = list;
        return this;
    }

    public void setClassicSize(Long l10) {
        this.classicSize = l10;
    }

    public Device setCreateTime(C4644l c4644l) {
        this.createTime = c4644l;
        return this;
    }

    public Device setDeviceCategory(String str) {
        this.deviceCategory = str;
        return this;
    }

    public Device setDeviceDisplayName(String str) {
        this.deviceDisplayName = str;
        return this;
    }

    public Device setDeviceIconUrl(String str) {
        this.deviceIconUrl = str;
        return this;
    }

    public Device setDevicePathName(String str) {
        this.devicePathName = str;
        return this;
    }

    public Device setDirtyClearEndTime(C4644l c4644l) {
        this.dirtyClearEndTime = c4644l;
        return this;
    }

    public Device setDirtyClearFileSize(Long l10) {
        this.dirtyClearFileSize = l10;
        return this;
    }

    public Device setDirtyClearFileSpace(Long l10) {
        this.dirtyClearFileSpace = l10;
        return this;
    }

    public Device setDirtyClearStartTime(C4644l c4644l) {
        this.dirtyClearStartTime = c4644l;
        return this;
    }

    public Device setDirtyClearStatus(Integer num) {
        this.dirtyClearStatus = num;
        return this;
    }

    public Device setDirtyClearTaskId(String str) {
        this.dirtyClearTaskId = str;
        return this;
    }

    public Device setDirtyType(Integer num) {
        this.dirtyType = num;
        return this;
    }

    public Device setId(String str) {
        this.f22592id = str;
        return this;
    }

    public void setInterimSize(Long l10) {
        this.interimSize = l10;
    }

    public void setOccupySpaceType(Integer num) {
        this.occupySpaceType = num;
    }

    public Device setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public Device setSource(String str) {
        this.source = str;
        return this;
    }

    public Device setTerminalOS(String str) {
        this.terminalOS = str;
        return this;
    }

    public Device setTerminalType(String str) {
        this.terminalType = str;
        return this;
    }

    public Device setUpdateTime(C4644l c4644l) {
        this.updateTime = c4644l;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Device set(String str, Object obj) {
        return (Device) super.set(str, obj);
    }
}
