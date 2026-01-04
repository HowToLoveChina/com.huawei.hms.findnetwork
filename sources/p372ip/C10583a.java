package p372ip;

import android.content.Context;
import fk.C9721b;
import p015ak.C0209d;
import p399jk.AbstractC10896a;
import p581qk.AbstractC12367d;

/* renamed from: ip.a */
/* loaded from: classes7.dex */
public class C10583a extends AbstractC12367d {

    /* renamed from: a */
    public Context f50931a;

    /* renamed from: b */
    public String f50932b;

    /* renamed from: c */
    public int f50933c;

    public C10583a(Context context, String str, int i10) {
        this.f50931a = context;
        this.f50932b = str;
        this.f50933c = i10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        AbstractC10896a.m65887i("CommitSettingsNewTask", "call key =" + this.f50932b + ";switchStatus =" + this.f50933c);
        Context context = this.f50931a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("hicloud_sync_");
        sb2.append(this.f50932b);
        C0209d.m1334z2(context, sb2.toString(), this.f50933c);
    }
}
