package com.huawei.hms.ads.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class SearchInfo {

    @InterfaceC6932d(m39225a = "chnl")
    private String channel;

    @InterfaceC6932d(m39225a = "kws")
    private List<Keyword> keywords;

    @InterfaceC6932d(m39225a = "qry")
    private String query;

    @OuterVisible
    public SearchInfo() {
    }

    @OuterVisible
    public SearchInfo(String str, List<Keyword> list, String str2) {
        this.query = str;
        this.keywords = list;
        this.channel = str2;
    }

    @OuterVisible
    public String getChannel() {
        return this.channel;
    }

    @OuterVisible
    public List<Keyword> getKeywords() {
        return this.keywords;
    }

    @OuterVisible
    public String getQuery() {
        return this.query;
    }

    @OuterVisible
    public void setChannel(String str) {
        this.channel = str;
    }

    @OuterVisible
    public void setKeywords(List<Keyword> list) {
        this.keywords = list;
    }

    @OuterVisible
    public void setQuery(String str) {
        this.query = str;
    }
}
