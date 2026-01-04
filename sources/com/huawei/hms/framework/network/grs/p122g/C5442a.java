package com.huawei.hms.framework.network.grs.p122g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p120e.C5436c;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.hms.framework.network.grs.g.a */
/* loaded from: classes8.dex */
public class C5442a {

    /* renamed from: a */
    protected C5445d f24934a;

    /* renamed from: b */
    private final String f24935b;

    /* renamed from: c */
    private final C5444c f24936c;

    /* renamed from: d */
    private final int f24937d;

    /* renamed from: e */
    private final Context f24938e;

    /* renamed from: f */
    private final String f24939f;

    /* renamed from: g */
    private final GrsBaseInfo f24940g;

    /* renamed from: h */
    private final C5436c f24941h;

    public C5442a(String str, int i10, C5444c c5444c, Context context, String str2, GrsBaseInfo grsBaseInfo, C5436c c5436c) {
        this.f24935b = str;
        this.f24936c = c5444c;
        this.f24937d = i10;
        this.f24938e = context;
        this.f24939f = str2;
        this.f24940g = grsBaseInfo;
        this.f24941h = c5436c;
    }

    /* renamed from: a */
    public Context m32238a() {
        return this.f24938e;
    }

    /* renamed from: b */
    public C5444c m32239b() {
        return this.f24936c;
    }

    /* renamed from: c */
    public String m32240c() {
        return this.f24935b;
    }

    /* renamed from: d */
    public int m32241d() {
        return this.f24937d;
    }

    /* renamed from: e */
    public String m32242e() {
        return this.f24939f;
    }

    /* renamed from: f */
    public C5436c m32243f() {
        return this.f24941h;
    }

    /* renamed from: g */
    public Callable<C5445d> m32244g() {
        return new CallableC5447f(this.f24935b, this.f24937d, this.f24936c, this.f24938e, this.f24939f, this.f24940g, this.f24941h);
    }
}
