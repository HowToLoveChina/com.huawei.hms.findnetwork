package com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class Title implements Serializable {
    private static final long serialVersionUID = -6451040467314102476L;
    private int len;
    private String text;

    /* renamed from: a */
    public String m40591a() {
        return this.text;
    }

    /* renamed from: b */
    public int m40594b() {
        return this.len;
    }

    /* renamed from: a */
    public void m40592a(int i10) {
        this.len = i10;
    }

    /* renamed from: a */
    public void m40593a(String str) {
        this.text = str;
    }
}
