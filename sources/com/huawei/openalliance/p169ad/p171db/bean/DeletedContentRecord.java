package com.huawei.openalliance.p169ad.p171db.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes2.dex */
public class DeletedContentRecord extends C7013a implements Serializable {
    public static final String CONTENT_ID = "contentId";
    public static final String DELETE_TIMSTAMP = "deleteTimestamp";
    private static final long serialVersionUID = 30424300;
    private String contentId;
    private long deleteTimestamp;

    public DeletedContentRecord() {
    }

    /* renamed from: a */
    public String m41651a() {
        return this.contentId;
    }

    public DeletedContentRecord(String str, long j10) {
        this.contentId = str;
        this.deleteTimestamp = j10;
    }
}
