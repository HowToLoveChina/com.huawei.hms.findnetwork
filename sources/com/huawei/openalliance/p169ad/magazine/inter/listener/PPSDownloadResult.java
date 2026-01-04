package com.huawei.openalliance.p169ad.magazine.inter.listener;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@DataKeep
/* loaded from: classes2.dex */
public class PPSDownloadResult {
    private String contentId;
    private String path;
    private boolean result;

    @OuterVisible
    public PPSDownloadResult() {
    }

    @OuterVisible
    public PPSDownloadResult(String str, boolean z10, String str2) {
        this.contentId = str;
        this.result = z10;
        this.path = str2;
    }

    @OuterVisible
    public String getContentId() {
        return this.contentId;
    }

    @OuterVisible
    public String getPath() {
        return this.path;
    }

    @OuterVisible
    public boolean isResult() {
        return this.result;
    }

    @OuterVisible
    public void setContentId(String str) {
        this.contentId = str;
    }

    @OuterVisible
    public void setPath(String str) {
        this.path = str;
    }

    @OuterVisible
    public void setResult(boolean z10) {
        this.result = z10;
    }
}
