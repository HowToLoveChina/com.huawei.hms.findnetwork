package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class Channel extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private C4644l expirationTime;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22586id;

    @InterfaceC4648p
    private String resourceId;

    @InterfaceC4648p
    private String resourceUri;

    @InterfaceC4648p
    private String type;

    @InterfaceC4648p
    private String url;

    @InterfaceC4648p
    private String userToken;

    public String getCategory() {
        return this.category;
    }

    public C4644l getExpirationTime() {
        return this.expirationTime;
    }

    public String getId() {
        return this.f22586id;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public String getResourceUri() {
        return this.resourceUri;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserToken() {
        return this.userToken;
    }

    public Channel setCategory(String str) {
        this.category = str;
        return this;
    }

    public Channel setExpirationTime(C4644l c4644l) {
        this.expirationTime = c4644l;
        return this;
    }

    public Channel setId(String str) {
        this.f22586id = str;
        return this;
    }

    public Channel setResourceId(String str) {
        this.resourceId = str;
        return this;
    }

    public Channel setResourceUri(String str) {
        this.resourceUri = str;
        return this;
    }

    public Channel setType(String str) {
        this.type = str;
        return this;
    }

    public Channel setUrl(String str) {
        this.url = str;
        return this;
    }

    public Channel setUserToken(String str) {
        this.userToken = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Channel set(String str, Object obj) {
        return (Channel) super.set(str, obj);
    }
}
