package com.huawei.android.hicloud.sync.bean;

import com.google.gson.Gson;
import java.util.List;

/* loaded from: classes3.dex */
public class ReportSyncEndInfo {
    private List<ReportDataTypeDetail> dataTypeDetail;
    private long endTime;
    private String errorReason;
    private long firstStartTime;
    private String gradeCode;
    private String prepareTraceId;
    private long startTime;
    private String syncType;
    private String thirdAppId;
    private String thirdAppPkgName;
    private String thirdAppVersion;
    private String traceId;
    private String errorCode = String.valueOf(0);
    private int startPlugged = -1;
    private int endPlugged = -1;
    private int startNetworkType = -1;
    private int endNetworkType = -1;
    private int startForground = -1;
    private int endForground = -1;
    private int incFlag = -1;
    private int hasAssets = 0;
    private int source = -1;
    private int prepareTimes = -1;

    public ReportSyncEndInfo() {
    }

    public String getAppVersion() {
        return this.thirdAppVersion;
    }

    public List<ReportDataTypeDetail> getDataTypeDetail() {
        return this.dataTypeDetail;
    }

    public int getEndForground() {
        return this.endForground;
    }

    public int getEndNetworkType() {
        return this.endNetworkType;
    }

    public int getEndPlugged() {
        return this.endPlugged;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorReason() {
        return this.errorReason;
    }

    public long getFirstStartTime() {
        return this.firstStartTime;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public int getHasAssets() {
        return this.hasAssets;
    }

    public int getIncFlag() {
        return this.incFlag;
    }

    public int getPrepareTimes() {
        return this.prepareTimes;
    }

    public String getPrepareTraceId() {
        return this.prepareTraceId;
    }

    public int getSource() {
        return this.source;
    }

    public int getStartForground() {
        return this.startForground;
    }

    public int getStartNetworkType() {
        return this.startNetworkType;
    }

    public int getStartPlugged() {
        return this.startPlugged;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getSyncType() {
        return this.syncType;
    }

    public String getThirdAppId() {
        return this.thirdAppId;
    }

    public String getThirdAppPkgName() {
        return this.thirdAppPkgName;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setDataTypeDetail(List<ReportDataTypeDetail> list) {
        this.dataTypeDetail = list;
    }

    public void setEndForground(int i10) {
        this.endForground = i10;
    }

    public void setEndNetworkType(int i10) {
        this.endNetworkType = i10;
    }

    public void setEndPlugged(int i10) {
        this.endPlugged = i10;
    }

    public void setEndTime(long j10) {
        this.endTime = j10;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorReason(String str) {
        this.errorReason = str;
    }

    public void setFirstStartTime(long j10) {
        this.firstStartTime = j10;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setHasAssets(int i10) {
        this.hasAssets = i10;
    }

    public void setIncFlag(int i10) {
        this.incFlag = i10;
    }

    public void setPrepareTimes(int i10) {
        this.prepareTimes = i10;
    }

    public void setPrepareTraceId(String str) {
        this.prepareTraceId = str;
    }

    public void setSource(int i10) {
        this.source = i10;
    }

    public void setStartForground(int i10) {
        this.startForground = i10;
    }

    public void setStartNetworkType(int i10) {
        this.startNetworkType = i10;
    }

    public void setStartPlugged(int i10) {
        this.startPlugged = i10;
    }

    public void setStartTime(long j10) {
        this.startTime = j10;
    }

    public void setSyncType(String str) {
        this.syncType = str;
    }

    public void setThirdAppId(String str) {
        this.thirdAppId = str;
    }

    public void setThirdAppPkgName(String str) {
        this.thirdAppPkgName = str;
    }

    public void setThirdAppVersion(String str) {
        this.thirdAppVersion = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public ReportSyncEndInfo(String str) {
        this.syncType = str;
    }
}
