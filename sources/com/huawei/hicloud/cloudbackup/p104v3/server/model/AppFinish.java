package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class AppFinish extends C11707b {

    @InterfaceC4648p
    private Long appTotalSize;

    @InterfaceC4648p
    private Long attachmentsSize;

    @InterfaceC4648p
    private String bloomFilter;

    @InterfaceC4648p
    private Integer fileCount;

    @InterfaceC4648p
    private String fileIdList;

    @InterfaceC4648p
    private Integer fileIdNum;

    @InterfaceC4648p
    private String packageVersion;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private Integer runtimeType;

    @InterfaceC4648p
    private C4644l updateTime;

    public Long getAppTotalSize() {
        return this.appTotalSize;
    }

    public String getBloomFilter() {
        return this.bloomFilter;
    }

    public Integer getFileCount() {
        return this.fileCount;
    }

    public String getFileIdList() {
        return this.fileIdList;
    }

    public Integer getFileIdNum() {
        return this.fileIdNum;
    }

    public String getPackageVersion() {
        return this.packageVersion;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public Integer getRuntimeType() {
        return this.runtimeType;
    }

    public C4644l getUpdateTime() {
        return this.updateTime;
    }

    public AppFinish setAppTotalSize(Long l10) {
        this.appTotalSize = l10;
        return this;
    }

    public AppFinish setAttachmentsSize(Long l10) {
        this.attachmentsSize = l10;
        return this;
    }

    public AppFinish setBloomFilter(String str) {
        this.bloomFilter = str;
        return this;
    }

    public AppFinish setFileCount(Integer num) {
        this.fileCount = num;
        return this;
    }

    public void setFileIdList(String str) {
        this.fileIdList = str;
    }

    public void setFileIdNum(Integer num) {
        this.fileIdNum = num;
    }

    public AppFinish setPackageVersion(String str) {
        this.packageVersion = str;
        return this;
    }

    public AppFinish setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public AppFinish setRuntimeType(Integer num) {
        this.runtimeType = num;
        return this;
    }

    public AppFinish setUpdateTime(C4644l c4644l) {
        this.updateTime = c4644l;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public AppFinish set(String str, Object obj) {
        return (AppFinish) super.set(str, obj);
    }
}
