package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes5.dex */
public final class CommentList extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private List<Comment> comments;

    @InterfaceC4648p
    private String nextCursor;

    public String getCategory() {
        return this.category;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public CommentList setCategory(String str) {
        this.category = str;
        return this;
    }

    public CommentList setComments(List<Comment> list) {
        this.comments = list;
        return this;
    }

    public CommentList setNextCursor(String str) {
        this.nextCursor = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public CommentList set(String str, Object obj) {
        return (CommentList) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public CommentList clone() {
        return (CommentList) super.clone();
    }
}
