package com.huawei.openalliance.p169ad.inter.data;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.io.Serializable;

@DataKeep
@OuterVisible
/* loaded from: classes2.dex */
public class FeedbackInfo implements Serializable {
    private static final long serialVersionUID = 30456300;

    /* renamed from: id */
    private long f33618id;
    private String label;
    private int type;

    /* renamed from: a */
    public long m44464a() {
        return this.f33618id;
    }

    /* renamed from: b */
    public boolean m44468b() {
        int i10;
        return !TextUtils.isEmpty(this.label) && ((i10 = this.type) == 1 || i10 == 2 || i10 == 3);
    }

    @OuterVisible
    public String getLabel() {
        return this.label;
    }

    @OuterVisible
    public int getType() {
        return this.type;
    }

    /* renamed from: a */
    public void m44465a(int i10) {
        this.type = i10;
    }

    /* renamed from: a */
    public void m44466a(long j10) {
        this.f33618id = j10;
    }

    /* renamed from: a */
    public void m44467a(String str) {
        this.label = str;
    }
}
