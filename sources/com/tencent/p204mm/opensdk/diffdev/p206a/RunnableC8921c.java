package com.tencent.p204mm.opensdk.diffdev.p206a;

import com.tencent.p204mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.c */
/* loaded from: classes9.dex */
final class RunnableC8921c implements Runnable {

    /* renamed from: g */
    final /* synthetic */ C8920b f45403g;

    public RunnableC8921c(C8920b c8920b) {
        this.f45403g = c8920b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f45403g.f45402f.f45399c);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((OAuthListener) it.next()).onQrcodeScanned();
        }
    }
}
