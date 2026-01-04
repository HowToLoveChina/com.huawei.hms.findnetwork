package com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class ImageExt implements Serializable {
    private static final long serialVersionUID = 687537555709319441L;
    private int checkSHA256Flag;
    private String format;
    private String sha256;
    private long size;

    /* renamed from: a */
    public long m40583a() {
        return this.size;
    }

    /* renamed from: b */
    public String m40587b() {
        return this.sha256;
    }

    /* renamed from: c */
    public String m40589c() {
        return this.format;
    }

    /* renamed from: d */
    public int m40590d() {
        return this.checkSHA256Flag;
    }

    /* renamed from: a */
    public void m40584a(int i10) {
        this.checkSHA256Flag = i10;
    }

    /* renamed from: b */
    public void m40588b(String str) {
        this.format = str;
    }

    /* renamed from: a */
    public void m40585a(long j10) {
        this.size = j10;
    }

    /* renamed from: a */
    public void m40586a(String str) {
        this.sha256 = str;
    }
}
