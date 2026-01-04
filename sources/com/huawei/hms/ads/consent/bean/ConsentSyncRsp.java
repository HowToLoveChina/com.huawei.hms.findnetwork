package com.huawei.hms.ads.consent.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class ConsentSyncRsp extends ConsentSyncBase {
    private int retcode;
    private Long timestamp;

    @OuterVisible
    public ConsentSyncRsp() {
    }

    @OuterVisible
    public int getRetcode() {
        return this.retcode;
    }

    @OuterVisible
    public Long getTimestamp() {
        return this.timestamp;
    }

    @OuterVisible
    public void setRetcode(int i10) {
        this.retcode = i10;
    }

    @OuterVisible
    public void setTimestamp(Long l10) {
        this.timestamp = l10;
    }

    @OuterVisible
    public ConsentSyncRsp(List<String> list, int i10) {
        super(list, i10);
    }
}
