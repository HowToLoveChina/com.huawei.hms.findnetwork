package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import android.text.TextUtils;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import java.util.Map;
import ni.C11707b;
import p815ym.AbstractC14026a;
import p848zl.C14338g;

/* loaded from: classes6.dex */
public class AppSizeInfo extends C11707b {

    @InterfaceC4648p
    private int apkType;

    @InterfaceC4648p
    private long appSize;

    @InterfaceC4648p
    private List<Attachment> attachments;

    @InterfaceC4648p
    private String backupAppName;

    @InterfaceC4648p
    private String backupId;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22583id;

    @InterfaceC4648p
    private Boolean isExistSplit;
    private String name;

    @InterfaceC4648p
    private String oriBackupAppName;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String splitApkType;

    @InterfaceC4648p
    private long totalSize;

    public int getApkType() {
        return this.apkType;
    }

    public long getAppSize() {
        return this.appSize;
    }

    public List<Attachment> getAttachments() {
        return this.attachments;
    }

    public String getBackupAppName() {
        return this.backupAppName;
    }

    public String getBackupId() {
        return this.backupId;
    }

    public Boolean getExistSplit() {
        Boolean bool = this.isExistSplit;
        return bool == null ? Boolean.FALSE : bool;
    }

    public String getId() {
        return this.f22583id;
    }

    public String getName() {
        return this.name;
    }

    public String getOriBackupAppName() {
        return this.oriBackupAppName;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String getSplitApkType() {
        return this.splitApkType;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public boolean isNextSystemModule() {
        Map<String, String> properties = getProperties();
        return TextUtils.equals(properties != null ? properties.getOrDefault("appShowType", null) : null, "2");
    }

    public boolean isSystemData(List<String> list) {
        return (!AbstractC14026a.m84159a(list) && list.contains(getBackupAppName())) || isNextSystemModule();
    }

    public boolean isSystemDataAndBaseData(List<String> list, boolean z10) {
        return z10 ? TextUtils.equals(this.properties.getOrDefault("bmAppDataType", null), "1") : isSystemData(list);
    }

    public boolean isSystemDataOrBaseData(List<String> list, boolean z10) {
        if (!z10) {
            return isSystemData(list);
        }
        Map<String, String> map = this.properties;
        if (map == null) {
            return false;
        }
        String orDefault = map.getOrDefault("bmAppDataType", null);
        String orDefault2 = this.properties.getOrDefault("appShowType", null);
        boolean zEquals = TextUtils.equals(orDefault, "1");
        return orDefault2 != null ? zEquals && !TextUtils.equals(orDefault2, "1") : zEquals && !C14338g.m85501a(this.apkType);
    }

    public AppSizeInfo setApkType(Integer num) {
        this.apkType = num.intValue();
        return this;
    }

    public AppSizeInfo setAppSize(Long l10) {
        this.appSize = l10.longValue();
        return this;
    }

    public AppSizeInfo setAttachments(List<Attachment> list) {
        this.attachments = list;
        return this;
    }

    public AppSizeInfo setBackupAppName(String str) {
        this.backupAppName = str;
        return this;
    }

    public AppSizeInfo setBackupId(String str) {
        this.backupId = str;
        return this;
    }

    public AppSizeInfo setExistSplit(Boolean bool) {
        this.isExistSplit = bool;
        return this;
    }

    public AppSizeInfo setId(String str) {
        this.f22583id = str;
        return this;
    }

    public void setName(String str) {
        this.name = str;
    }

    public AppSizeInfo setOriBackupAppName(String str) {
        this.oriBackupAppName = str;
        return this;
    }

    public AppSizeInfo setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public AppSizeInfo setSplitApkType(String str) {
        this.splitApkType = str;
        return this;
    }

    public AppSizeInfo setTotalSize(long j10) {
        this.totalSize = j10;
        return this;
    }
}
