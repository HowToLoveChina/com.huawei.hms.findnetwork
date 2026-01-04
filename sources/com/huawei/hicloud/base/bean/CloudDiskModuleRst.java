package com.huawei.hicloud.base.bean;

/* loaded from: classes6.dex */
public class CloudDiskModuleRst {
    public static final int ABORT = 3;
    public static final int DEFAULT = 10;
    public static final int DODOWNLOAD_FAILED_CODE = -20;
    public static final int DONE = 2;
    public static final int FAILED = -1;
    public static final int INITIAL_RET = -10;
    public static final int NOCHANGE = 1;
    public static final int RUNNING = 4;
    public static final int SERVER_STORAGE_LACK = -2;
    public static final int SUCCESS = 0;
    private String moduleName = "";
    private String deviceId = "";
    private int totalNum = 0;
    private int successNum = 0;
    private int failNum = 0;
    private int nochangeNum = 0;
    private long totalSize = 0;
    private long successSize = 0;
    private int retCode = -1;
    private String biCode = "0";
    private String failReason = "";

    private <T> T commonSetFunction(T t10) {
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    public String getBiCode() {
        return this.biCode;
    }

    public String getDeviceID() {
        return this.deviceId;
    }

    public int getFailNum() {
        return this.failNum;
    }

    public String getFailReason() {
        return this.failReason;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public int getNochangeNum() {
        return this.nochangeNum;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public int getSuccessNum() {
        return this.successNum;
    }

    public long getSuccessSize() {
        return this.successSize;
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public void setBiCode(String str) {
        this.biCode = (String) commonSetFunction(str);
    }

    public void setDeviceID(String str) {
        this.deviceId = str;
    }

    public void setFailNum(int i10) {
        this.failNum = i10;
    }

    public void setFailReason(String str) {
        this.failReason = str;
    }

    public void setModuleName(String str) {
        this.moduleName = (String) commonSetFunction(str);
    }

    public void setNochangeNum(int i10) {
        this.nochangeNum = i10;
    }

    public void setNum(int i10, int i11, int i12) {
        this.failNum = i10;
        this.nochangeNum = i11;
        this.successNum = i12;
    }

    public void setRetCode(int i10) {
        this.retCode = ((Integer) commonSetFunction(Integer.valueOf(i10))).intValue();
    }

    public void setSuccessNum(int i10) {
        this.successNum = i10;
    }

    public void setSuccessSize(long j10) {
        this.successSize = j10;
    }

    public void setTotalNum(int i10) {
        this.totalNum = i10;
    }

    public void setTotalSize(long j10) {
        this.totalSize = j10;
    }
}
