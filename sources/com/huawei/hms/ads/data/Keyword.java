package com.huawei.hms.ads.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@DataKeep
/* loaded from: classes8.dex */
public class Keyword {

    @InterfaceC6932d(m39225a = "kw")
    private String keyword;
    private Integer type;

    @OuterVisible
    public Keyword() {
    }

    @OuterVisible
    public Keyword(Integer num, String str) {
        this.type = num;
        this.keyword = str;
    }

    @OuterVisible
    public String getKeyword() {
        return this.keyword;
    }

    @OuterVisible
    public Integer getType() {
        return this.type;
    }

    @OuterVisible
    public void setKeyword(String str) {
        this.keyword = str;
    }

    @OuterVisible
    public void setType(Integer num) {
        this.type = num;
    }
}
