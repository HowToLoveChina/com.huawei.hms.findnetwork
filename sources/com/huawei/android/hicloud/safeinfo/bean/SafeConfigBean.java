package com.huawei.android.hicloud.safeinfo.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes3.dex */
public class SafeConfigBean {
    private String date;

    /* renamed from: id */
    private String f12724id;

    @SerializedName("link_contents")
    private List<LinkContents> linkContents;
    private String version;

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f12724id;
    }

    public List<LinkContents> getLinkContents() {
        return this.linkContents;
    }

    public String getVersion() {
        return this.version;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f12724id = str;
    }

    public void setLinkContents(List<LinkContents> list) {
        this.linkContents = list;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
