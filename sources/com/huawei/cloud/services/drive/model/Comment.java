package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes5.dex */
public final class Comment extends C11707b {

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
    private String f21489id;

    @InterfaceC4648p
    private String position;

    @InterfaceC4648p
    private QuotedContent quotedContent;

    @InterfaceC4648p
    private List<Reply> replies;

    @InterfaceC4648p
    private Boolean resolved;

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
        return this.f21489id;
    }

    public String getPosition() {
        return this.position;
    }

    public QuotedContent getQuotedContent() {
        return this.quotedContent;
    }

    public List<Reply> getReplies() {
        return this.replies;
    }

    public Boolean getResolved() {
        return this.resolved;
    }

    public Comment setCategory(String str) {
        this.category = str;
        return this;
    }

    public Comment setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
        return this;
    }

    public Comment setCreator(User user) {
        this.creator = user;
        return this;
    }

    public Comment setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Comment setDescription(String str) {
        this.description = str;
        return this;
    }

    public Comment setEditedTime(C4644l c4644l) {
        this.editedTime = c4644l;
        return this;
    }

    public Comment setHtmlDescription(String str) {
        this.htmlDescription = str;
        return this;
    }

    public Comment setId(String str) {
        this.f21489id = str;
        return this;
    }

    public Comment setPosition(String str) {
        this.position = str;
        return this;
    }

    public Comment setQuotedContent(QuotedContent quotedContent) {
        this.quotedContent = quotedContent;
        return this;
    }

    public Comment setReplies(List<Reply> list) {
        this.replies = list;
        return this;
    }

    public Comment setResolved(Boolean bool) {
        this.resolved = bool;
        return this;
    }

    public static final class QuotedContent extends C11707b {

        @InterfaceC4648p
        private String content;

        @InterfaceC4648p
        private String mimeType;

        public String getContent() {
            return this.content;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public QuotedContent setContent(String str) {
            this.content = str;
            return this;
        }

        public QuotedContent setMimeType(String str) {
            this.mimeType = str;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public QuotedContent set(String str, Object obj) {
            return (QuotedContent) super.set(str, obj);
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
        public QuotedContent clone() {
            return (QuotedContent) super.clone();
        }
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Comment set(String str, Object obj) {
        return (Comment) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public Comment clone() {
        return (Comment) super.clone();
    }
}
