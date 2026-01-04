package com.huawei.hicloud.router.data;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes.dex */
public class FamilySharePageParams {

    @SerializedName("start1_more_uri")
    private String start1MoreUri;

    @SerializedName("start1_show_more")
    private String start1ShowMore;

    @SerializedName("start2_more_uri")
    private String start2MoreUri;

    @SerializedName("start2_show_more")
    private String start2ShowMore;

    public String getStart1MoreUri() {
        return this.start1MoreUri;
    }

    public String getStart1ShowMore() {
        return this.start1ShowMore;
    }

    public String getStart2MoreUri() {
        return this.start2MoreUri;
    }

    public String getStart2ShowMore() {
        return this.start2ShowMore;
    }

    public void setStart1MoreUri(String str) {
        this.start1MoreUri = str;
    }

    public void setStart1ShowMore(String str) {
        this.start1ShowMore = str;
    }

    public void setStart2MoreUri(String str) {
        this.start2MoreUri = str;
    }

    public void setStart2ShowMore(String str) {
        this.start2ShowMore = str;
    }
}
