package com.huawei.android.hicloud.cloudspace.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class ConfigResponse {
    private String cacheControl;
    private String configStr;
    private String content;
    private String contentType;
    private String etag;
    private List<FileInfo> fileInfos;
    private boolean modified = true;
    private int respCode;
    private String resultType;

    public String getCacheControl() {
        return this.cacheControl;
    }

    public String getConfigStr() {
        return this.configStr;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getEtag() {
        return this.etag;
    }

    public List<FileInfo> getFileInfos() {
        return this.fileInfos;
    }

    public int getRespCode() {
        return this.respCode;
    }

    public String getResultType() {
        return this.resultType;
    }

    public boolean isModified() {
        return this.modified;
    }

    public void setCacheControl(String str) {
        this.cacheControl = str;
    }

    public void setConfigStr(String str) {
        this.configStr = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setFileInfos(List<FileInfo> list) {
        this.fileInfos = list;
    }

    public void setModified(boolean z10) {
        this.modified = z10;
    }

    public void setRespCode(int i10) {
        this.respCode = i10;
    }

    public void setResultType(String str) {
        this.resultType = str;
    }
}
