package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class InformRecord extends C11707b {

    @InterfaceC4648p
    private String fileId;

    @InterfaceC4648p
    private String ownerId;

    @InterfaceC4648p
    private String reason;

    @InterfaceC4648p
    private List<String> riskLabels;

    @InterfaceC4648p
    private int scene;

    public String getFileId() {
        return this.fileId;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getReason() {
        return this.reason;
    }

    public List<String> getRiskLabels() {
        return this.riskLabels;
    }

    public int getScene() {
        return this.scene;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setRiskLabels(List<String> list) {
        this.riskLabels = list;
    }

    public void setScene(int i10) {
        this.scene = i10;
    }
}
