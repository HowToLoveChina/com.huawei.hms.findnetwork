package com.huawei.openalliance.p169ad.ipc;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;

/* renamed from: com.huawei.openalliance.ad.ipc.a */
/* loaded from: classes2.dex */
public class C7314a {

    /* renamed from: a */
    private a f33990a;

    /* renamed from: b */
    private final String f33991b = "unbindTask" + hashCode();

    /* renamed from: c */
    private int f33992c = 0;

    /* renamed from: d */
    private String f33993d;

    /* renamed from: e */
    private Context f33994e;

    /* renamed from: com.huawei.openalliance.ad.ipc.a$a */
    public interface a {
        /* renamed from: a */
        void mo45064a();
    }

    public C7314a(Context context, String str, a aVar) {
        this.f33994e = context.getApplicationContext();
        this.f33993d = str;
        this.f33990a = aVar;
    }

    /* renamed from: c */
    private String m45059c() {
        return "Monitor_" + this.f33993d;
    }

    /* renamed from: d */
    private int m45060d() {
        return TextUtils.equals(Constants.HW_INTELLIEGNT_PACKAGE, this.f33994e.getPackageName()) ? 0 : 60000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m45061e() {
        AbstractC7185ho.m43820b(m45059c(), "unbindService");
        this.f33990a.mo45064a();
    }

    /* renamed from: a */
    public synchronized void m45062a() {
        this.f33992c++;
        AbstractC7817dj.m48366a(this.f33991b);
        AbstractC7185ho.m43820b(m45059c(), "inc count: " + this.f33992c);
    }

    /* renamed from: b */
    public synchronized void m45063b() {
        try {
            int i10 = this.f33992c - 1;
            this.f33992c = i10;
            if (i10 < 0) {
                this.f33992c = 0;
            }
            AbstractC7185ho.m43818a(m45059c(), "dec count: %d", Integer.valueOf(this.f33992c));
            if (this.f33992c <= 0) {
                AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C7314a.this.m45061e();
                    }
                }, this.f33991b, m45060d());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
