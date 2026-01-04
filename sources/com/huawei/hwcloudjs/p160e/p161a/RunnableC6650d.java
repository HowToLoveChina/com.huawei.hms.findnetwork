package com.huawei.hwcloudjs.p160e.p161a;

import android.content.Context;
import com.huawei.hwcloudjs.p154d.p156b.C6640b;
import com.huawei.hwcloudjs.p160e.p161a.p162a.C6646a;
import com.huawei.hwcloudjs.p160e.p161a.p162a.C6647b;
import com.huawei.hwcloudjs.p164f.C6659d;

/* renamed from: com.huawei.hwcloudjs.e.a.d */
/* loaded from: classes8.dex */
public class RunnableC6650d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String[] f30869a;

    /* renamed from: b */
    final /* synthetic */ Context f30870b;

    /* renamed from: c */
    final /* synthetic */ int f30871c;

    public RunnableC6650d(String[] strArr, Context context, int i10) {
        this.f30869a = strArr;
        this.f30870b = context;
        this.f30871c = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (String str : this.f30869a) {
            if (C6649c.m37855d().m37864d(str) == null) {
                C6659d.m37882c("CacheRequestManager", "enter into preload requestBean " + str, false);
                C6647b c6647b = (C6647b) C6640b.m37823a(new C6646a(str), this.f30870b);
                if (c6647b.mo37822c() == 1) {
                    C6659d.m37882c("CacheRequestManager", "getcache url success:" + str, false);
                    C6649c.m37855d().m37859a(str, new C6645a(str, c6647b.m37854d(), c6647b.m37854d().length(), this.f30871c));
                } else {
                    C6659d.m37881b("CacheRequestManager", "getcache url failed!", true);
                }
            }
        }
    }
}
