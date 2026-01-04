package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSbkFlowHead {
    public static final String BKMODE_AUTO = "auto";
    public static final String BKMODE_MANUAL = "manual";
    public static final String CHARGE_MODE_NONE = "none";
    public static final String CHARGE_MODE_WIRE = "wire";
    public static final String CHARGE_MODE_WIRELESS = "wireless";
    public static final int FLOW_CONTROL_BACKUPRECORD_NOTEXIST_CODE = 601;
    public static final int FLOW_CONTROL_ERR_CODE = 506;
    public static final String FLOW_CONTROL_PATH = "/CloudBackup/clientService/keepLock";
    public static final int FLOW_CONTROL_SERVER_ERR_CODE = 503;
    private int backupkTimes;
    private boolean fullBK;
    private String flowControlCnt = "";
    private String bkStartDays = "";
    private String lastbkCompleteDays = "";
    private String packageByte = "";
    private String bkByte = "";
    private String chargeMode = "none";
    private String traceID = "";
    private String accessToken = "";
    private String bkmode = "";
    private String bkNeedSpace = "";
    private String network = "";

    public String getAccessToken() {
        return this.accessToken;
    }

    public int getBackupkTimes() {
        return this.backupkTimes;
    }

    public String getBkByte() {
        String str = this.bkByte;
        return str == null ? "" : str;
    }

    public String getBkNeedSpace() {
        String str = this.bkNeedSpace;
        return str == null ? "" : str;
    }

    public String getBkStartDays() {
        String str = this.bkStartDays;
        return str == null ? "" : str;
    }

    public String getBkmode() {
        String str = this.bkmode;
        return str == null ? "" : str;
    }

    public String getChargeMode() {
        String str = this.chargeMode;
        return str == null ? "none" : str;
    }

    public String getFlowControlCnt() {
        String str = this.flowControlCnt;
        return str == null ? "" : str;
    }

    public String getLastbkCompleteDays() {
        String str = this.lastbkCompleteDays;
        return str == null ? "" : str;
    }

    public String getNetwork() {
        String str = this.network;
        return str == null ? "" : str;
    }

    public String getPackageByte() {
        String str = this.packageByte;
        return str == null ? "" : str;
    }

    public String getTraceID() {
        return this.traceID;
    }

    public boolean isFullBK() {
        return this.fullBK;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setBackupkTimes(int i10) {
        this.backupkTimes = i10;
    }

    public void setBkByte(String str) {
        this.bkByte = str;
    }

    public void setBkNeedSpace(String str) {
        this.bkNeedSpace = str;
    }

    public void setBkStartDays(String str) {
        this.bkStartDays = str;
    }

    public void setBkmode(String str) {
        this.bkmode = str;
    }

    public void setChargeMode(String str) {
        this.chargeMode = str;
    }

    public void setFlowControlCnt(String str) {
        this.flowControlCnt = str;
    }

    public void setFullBK(boolean z10) {
        this.fullBK = z10;
    }

    public void setLastbkCompleteDays(String str) {
        this.lastbkCompleteDays = str;
    }

    public void setNetwork(String str) {
        this.network = str;
    }

    public void setPackageByte(String str) {
        this.packageByte = str;
    }

    public void setTraceID(String str) {
        this.traceID = str;
    }

    public String toString() {
        return "CBSbkFlowHead{flowControlCnt='" + this.flowControlCnt + "', bkStartDays='" + this.bkStartDays + "', lastbkCompleteDays='" + this.lastbkCompleteDays + "', packageByte='" + this.packageByte + "', bkByte='" + this.bkByte + "', backupkTimes=" + this.backupkTimes + ", fullBK=" + this.fullBK + ", chargeMode='" + this.chargeMode + "', traceID='" + this.traceID + "', bkmode='" + this.bkmode + "', bkNeedSpace='" + this.bkNeedSpace + "', network='" + this.network + "'}";
    }
}
