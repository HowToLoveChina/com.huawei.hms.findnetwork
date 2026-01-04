package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4627a0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* renamed from: com.huawei.cloud.base.http.e */
/* loaded from: classes.dex */
public class C4602e extends AbstractC4596b {

    /* renamed from: c */
    public final File f21153c;

    public C4602e(String str, File file) {
        super(str);
        this.f21153c = (File) C4627a0.m28391d(file);
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h
    /* renamed from: b */
    public boolean mo28153b() {
        return true;
    }

    @Override // com.huawei.cloud.base.http.AbstractC4596b
    /* renamed from: c */
    public InputStream mo28163c() throws FileNotFoundException {
        return new FileInputStream(this.f21153c);
    }

    /* renamed from: f */
    public File m28187f() {
        return this.f21153c;
    }

    @Override // com.huawei.cloud.base.http.AbstractC4596b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C4602e mo28165e(String str) {
        return (C4602e) super.mo28165e(str);
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h
    public long getLength() {
        return this.f21153c.length();
    }
}
