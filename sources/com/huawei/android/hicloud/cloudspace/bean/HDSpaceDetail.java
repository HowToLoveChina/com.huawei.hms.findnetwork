package com.huawei.android.hicloud.cloudspace.bean;

import com.huawei.hms.support.api.entity.sns.SNSCode;
import dk.C9160a;
import fk.C9721b;
import java.util.Map;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class HDSpaceDetail implements Comparable<HDSpaceDetail> {
    private int dcount;
    private boolean delete;
    private int fcount;
    private long fsize;
    private boolean hasHistoryData;
    private boolean hasSyncData;
    private boolean isFromDriveConfig;
    private boolean isFromSyncConfig;
    private String moduleName;
    private String path;
    private String serviceId;

    public static HDSpaceDetail buildHDSpaceDetail(Map<String, Object> map, String str, HDSpaceDetail hDSpaceDetail) throws C9721b {
        if (hDSpaceDetail == null) {
            hDSpaceDetail = new HDSpaceDetail();
            hDSpaceDetail.setModuleName(str);
            if (C9160a.m57579c().contains(str)) {
                hDSpaceDetail.setDelete(true);
            }
        }
        try {
            String str2 = (String) map.get("space");
            String str3 = (String) map.get("size");
            String str4 = (String) map.get("fileCount");
            String str5 = (String) map.get("dirCount");
            if (str2 != null) {
                hDSpaceDetail.setFsize(hDSpaceDetail.getFsize() + Long.parseLong(str2));
            }
            if (str3 != null) {
                hDSpaceDetail.setFsize(hDSpaceDetail.getFsize() + Long.parseLong(str3));
            }
            if (str4 != null) {
                hDSpaceDetail.setFcount(hDSpaceDetail.getFcount() + Integer.parseInt(str4));
            }
            if (str5 != null) {
                hDSpaceDetail.setDcount(hDSpaceDetail.getDcount() + Integer.parseInt(str5));
            }
            return hDSpaceDetail;
        } catch (ClassCastException unused) {
            C11839m.m70689w("HDSpaceDetail", "buildHDSpaceDetail cast error.");
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "buildHDSpaceDetail cast error", "checkUserSpace");
        } catch (NumberFormatException unused2) {
            C11839m.m70689w("HDSpaceDetail", "buildHDSpaceDetail format error.");
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "buildHDSpaceDetail format error", "checkUserSpace");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HDSpaceDetail hDSpaceDetail = (HDSpaceDetail) obj;
        if (this.dcount != hDSpaceDetail.dcount || this.delete != hDSpaceDetail.delete || this.fcount != hDSpaceDetail.fcount || this.fsize != hDSpaceDetail.fsize) {
            return false;
        }
        String str = this.moduleName;
        if (str == null) {
            if (hDSpaceDetail.moduleName != null) {
                return false;
            }
        } else if (!str.equals(hDSpaceDetail.moduleName)) {
            return false;
        }
        return true;
    }

    public int getDcount() {
        return this.dcount;
    }

    public int getFcount() {
        return this.fcount;
    }

    public long getFsize() {
        return this.fsize;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public String getPath() {
        return this.path;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public int hashCode() {
        int i10 = (((((this.dcount + 31) * 31) + (this.delete ? 1231 : 1237)) * 31) + this.fcount) * 31;
        long j10 = this.fsize;
        int i11 = (i10 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        String str = this.moduleName;
        return i11 + (str == null ? 0 : str.hashCode());
    }

    public boolean isDelete() {
        return this.delete;
    }

    public boolean isFromDriveConfig() {
        return this.isFromDriveConfig;
    }

    public boolean isFromSyncConfig() {
        return this.isFromSyncConfig;
    }

    public boolean isHasHistoryData() {
        return this.hasHistoryData;
    }

    public boolean isHasSyncData() {
        return this.hasSyncData;
    }

    public void setDcount(int i10) {
        this.dcount = i10;
    }

    public void setDelete(boolean z10) {
        this.delete = z10;
    }

    public void setFcount(int i10) {
        this.fcount = i10;
    }

    public void setFromDriveConfig(boolean z10) {
        this.isFromDriveConfig = z10;
    }

    public void setFromSyncConfig(boolean z10) {
        this.isFromSyncConfig = z10;
    }

    public void setFsize(long j10) {
        this.fsize = j10;
    }

    public void setHasHistoryData(boolean z10) {
        this.hasHistoryData = z10;
    }

    public void setHasSyncData(boolean z10) {
        this.hasSyncData = z10;
    }

    public void setHistoryData() {
        setHasSyncData(false);
        setHasHistoryData(true);
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }

    public void setSyncData(long j10, boolean z10) {
        setModuleName("notepad");
        setHasSyncData(true);
        setFsize(j10);
        setHasHistoryData(z10);
    }

    @Override // java.lang.Comparable
    public int compareTo(HDSpaceDetail hDSpaceDetail) {
        long j10 = this.fsize;
        long j11 = hDSpaceDetail.fsize;
        if (j10 < j11) {
            return 1;
        }
        return j10 > j11 ? -1 : 0;
    }
}
