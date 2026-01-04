package com.huawei.openplatform.abl.log;

import android.content.Context;
import android.util.Log;
import p405jt.AbstractC10919e;
import p405jt.C10917c;
import p405jt.C10921g;
import p434kt.AbstractC11153g;

/* renamed from: com.huawei.openplatform.abl.log.l */
/* loaded from: classes2.dex */
public class C8266l extends AbstractC10919e {

    /* renamed from: c */
    public boolean f38503c;

    public C8266l(Context context) {
        this.f51803a = context;
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: c */
    public void mo51629c(String str, String str2) {
        C10921g.m66006a().m66008c(str, str2);
        if (this.f38503c) {
            return;
        }
        this.f51804b.m66022g(3, str, str2);
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: d */
    public void mo51640d(C10917c c10917c) {
        if (this.f38503c) {
            m65998h(c10917c);
        } else {
            super.mo51640d(c10917c);
        }
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: e */
    public boolean mo51630e() {
        return (this.f38503c && C10921g.m66006a().m66009d(3)) || this.f51804b.m66021f(3);
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: f */
    public void mo51631f(String str, String str2) {
        C10921g.m66006a().m66010e(str, str2);
        if (this.f38503c) {
            return;
        }
        this.f51804b.m66022g(6, str, str2);
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: g */
    public void mo51632g(String str, String str2, Object... objArr) {
        if (!m51642n() || str2 == null) {
            return;
        }
        C10921g.m66006a().m66011f(str, str2, objArr);
        if (this.f38503c) {
            return;
        }
        this.f51804b.m66022g(6, str, AbstractC11153g.m67072b(str2, objArr));
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: i */
    public void mo51633i(String str, String str2) {
        C10921g.m66006a().m66012g(str, str2);
        if (this.f38503c) {
            return;
        }
        this.f51804b.m66022g(4, str, str2);
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: j */
    public void mo51634j(String str, String str2, Object... objArr) {
        if (!m51643o() || str2 == null) {
            return;
        }
        C10921g.m66006a().m66013h(str, str2, objArr);
        if (this.f38503c) {
            return;
        }
        this.f51804b.m66022g(4, str, AbstractC11153g.m67072b(str2, objArr));
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: k */
    public void mo51635k(String str, String str2) {
        StringBuilder sb2;
        String str3;
        try {
            C10921g.m66006a().m66014i(str, str2);
            if (this.f38503c) {
                return;
            }
            this.f51804b.m66022g(5, str, str2);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str3 = "log w ";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            Log.w("TVLogger", sb2.toString());
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            str3 = "log w ex: ";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            Log.w("TVLogger", sb2.toString());
        }
    }

    @Override // p405jt.AbstractC10919e
    /* renamed from: l */
    public void mo51636l(String str, String str2, Object... objArr) {
        if (!m51644p() || str2 == null) {
            return;
        }
        C10921g.m66006a().m66015j(str, str2, objArr);
        if (this.f38503c) {
            return;
        }
        this.f51804b.m66022g(5, str, AbstractC11153g.m67072b(str2, objArr));
    }

    /* renamed from: m */
    public C8266l m51641m(boolean z10) {
        this.f38503c = z10;
        return this;
    }

    /* renamed from: n */
    public boolean m51642n() {
        return (this.f38503c && C10921g.m66006a().m66009d(6)) || this.f51804b.m66021f(6);
    }

    /* renamed from: o */
    public boolean m51643o() {
        return (this.f38503c && C10921g.m66006a().m66009d(4)) || this.f51804b.m66021f(4);
    }

    /* renamed from: p */
    public boolean m51644p() {
        return (this.f38503c && C10921g.m66006a().m66009d(5)) || this.f51804b.m66021f(5);
    }
}
