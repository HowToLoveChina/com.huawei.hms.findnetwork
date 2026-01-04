package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class About extends C11707b {

    @InterfaceC4648p
    private String dataVersion;

    @InterfaceC4648p
    private String domain;

    @InterfaceC4648p
    private List<String> kinds;

    @InterfaceC4648p
    private Map<String, Long> kindsUpperLimits;

    @InterfaceC4648p
    private String maxAttachmentUploadSize;

    @InterfaceC4648p
    private Integer maxBatchNumber;

    @InterfaceC4648p
    private Integer serverTime;

    @InterfaceC4648p
    private Status status;

    public static final class Status extends C11707b {

        @InterfaceC4648p
        private Integer v2cut;

        public Integer getV2cut() {
            return this.v2cut;
        }

        public void setV2cut(Integer num) {
            this.v2cut = num;
        }
    }

    public String getDataVersion() {
        return this.dataVersion;
    }

    public String getDomain() {
        return this.domain;
    }

    public List<String> getKinds() {
        return this.kinds;
    }

    public Map<String, Long> getKindsUpperLimits() {
        return this.kindsUpperLimits;
    }

    public String getMaxAttachmentUploadSize() {
        return this.maxAttachmentUploadSize;
    }

    public Integer getMaxBatchNumber() {
        return this.maxBatchNumber;
    }

    public Integer getServerTime() {
        return this.serverTime;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setDataVersion(String str) {
        this.dataVersion = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setKinds(List<String> list) {
        this.kinds = list;
    }

    public void setKindsUpperLimits(Map<String, Long> map) {
        this.kindsUpperLimits = map;
    }

    public void setMaxAttachmentUploadSize(String str) {
        this.maxAttachmentUploadSize = str;
    }

    public void setMaxBatchNumber(Integer num) {
        this.maxBatchNumber = num;
    }

    public void setServerTime(Integer num) {
        this.serverTime = num;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
