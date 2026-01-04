package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class UrgencyTop {

    @SerializedName("content")
    private String content;

    @SerializedName("showPages")
    private List<String> showPages;

    /* renamed from: to */
    @SerializedName("goto")
    private UrgencyGoto f22665to;

    public String getContent() {
        return this.content;
    }

    public List<String> getShowPages() {
        return this.showPages;
    }

    public UrgencyGoto getTo() {
        return this.f22665to;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setShowPages(List<String> list) {
        this.showPages = list;
    }

    public void setTo(UrgencyGoto urgencyGoto) {
        this.f22665to = urgencyGoto;
    }
}
