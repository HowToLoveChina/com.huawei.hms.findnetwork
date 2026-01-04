package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes5.dex */
public final class ReplyList extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private String nextCursor;

    @InterfaceC4648p
    private List<Reply> replies;

    public String getCategory() {
        return this.category;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public List<Reply> getReplies() {
        return this.replies;
    }

    public ReplyList setCategory(String str) {
        this.category = str;
        return this;
    }

    public ReplyList setNextCursor(String str) {
        this.nextCursor = str;
        return this;
    }

    public ReplyList setReplies(List<Reply> list) {
        this.replies = list;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public ReplyList set(String str, Object obj) {
        return (ReplyList) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public ReplyList clone() {
        return (ReplyList) super.clone();
    }
}
