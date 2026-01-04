package com.huawei.openalliance.p169ad.beans.metadata;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class DefaultTemplate implements Serializable {
    private static final String INVALID_ID = "-1";
    private static final long serialVersionUID = 3193003283515036853L;
    private String defTptId;
    private Integer tptFcCtl;

    /* renamed from: a */
    public String m40014a() {
        return this.defTptId;
    }

    /* renamed from: b */
    public Integer m40017b() {
        return this.tptFcCtl;
    }

    /* renamed from: c */
    public boolean m40018c() {
        return (TextUtils.isEmpty(this.defTptId) || "-1".equals(this.defTptId)) ? false : true;
    }

    /* renamed from: a */
    public void m40015a(Integer num) {
        this.tptFcCtl = num;
    }

    /* renamed from: a */
    public void m40016a(String str) {
        this.defTptId = str;
    }
}
