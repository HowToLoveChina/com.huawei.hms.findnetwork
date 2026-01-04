package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes5.dex */
public final class Reply extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private User creator;

    @InterfaceC4648p
    private Boolean deleted;

    @InterfaceC4648p
    private String description;

    @InterfaceC4648p
    private C4644l editedTime;

    @InterfaceC4648p
    private String htmlDescription;

    /* renamed from: id */
    @InterfaceC4648p
    private String f21493id;

    @InterfaceC4648p
    private String operate;

    public String getCategory() {
        return this.category;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public User getCreator() {
        return this.creator;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public String getDescription() {
        return this.description;
    }

    public C4644l getEditedTime() {
        return this.editedTime;
    }

    public String getHtmlDescription() {
        return this.htmlDescription;
    }

    public String getId() {
        return this.f21493id;
    }

    public String getOperate() {
        return this.operate;
    }

    public Reply setCategory(String str) {
        this.category = str;
        return this;
    }

    public Reply setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
        return this;
    }

    public Reply setCreator(User user) {
        this.creator = user;
        return this;
    }

    public Reply setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Reply setDescription(String str) {
        this.description = str;
        return this;
    }

    public Reply setEditedTime(C4644l c4644l) {
        this.editedTime = c4644l;
        return this;
    }

    public Reply setHtmlDescription(String str) {
        this.htmlDescription = str;
        return this;
    }

    public Reply setId(String str) {
        this.f21493id = str;
        return this;
    }

    public Reply setOperate(String str) {
        this.operate = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Reply set(String str, Object obj) {
        return (Reply) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public Reply clone() {
        return (Reply) super.clone();
    }
}
