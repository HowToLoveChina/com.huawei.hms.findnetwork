package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.views.web.C8179b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.pl */
/* loaded from: classes8.dex */
public class C7578pl {

    /* renamed from: a */
    private Context f35332a;

    /* renamed from: b */
    private ContentRecord f35333b;

    public C7578pl(Context context) {
        this.f35332a = context.getApplicationContext();
    }

    /* renamed from: a */
    public void m46776a() {
        if (!HiAd.m44014a(this.f35332a).mo44060m()) {
            AbstractC7185ho.m43820b("PreloadWebViewProcessor", "app disable preload webView");
            return;
        }
        ContentRecord contentRecord = this.f35333b;
        if (contentRecord == null || contentRecord.m41568i() == null) {
            AbstractC7185ho.m43820b("PreloadWebViewProcessor", "contentRecord or meataData is null");
            return;
        }
        final String strM41386B = this.f35333b.m41386B();
        int iM40271H = this.f35333b.m41568i().m40271H();
        if (iM40271H == 0) {
            AbstractC7185ho.m43821b("PreloadWebViewProcessor", "not preload url. enablePreload: %s", Integer.valueOf(iM40271H));
            return;
        }
        List<Integer> listM41409N = this.f35333b.m41409N();
        if (AbstractC7760bg.m47767a(listM41409N) || m46775a(listM41409N)) {
            AbstractC7185ho.m43820b("PreloadWebViewProcessor", "not preload url. ClickActionList not support");
            return;
        }
        int iMo43086t = C7124fh.m43316b(this.f35332a).mo43086t();
        if (iMo43086t == 1 || (iMo43086t == 0 && C7775bv.m47826a(this.f35332a))) {
            AbstractC7185ho.m43820b("PreloadWebViewProcessor", "preLoad");
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.pl.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C8179b.m50673a(C7578pl.this.f35332a).m50680a(strM41386B);
                    } catch (Throwable unused) {
                        AbstractC7185ho.m43823c("PreloadWebViewProcessor", "preLoad fail");
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m46777a(ContentRecord contentRecord) {
        this.f35333b = contentRecord;
    }

    /* renamed from: a */
    private boolean m46775a(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next()));
        }
        String strMo43087u = C7124fh.m43316b(this.f35332a).mo43087u();
        if (TextUtils.isEmpty(strMo43087u)) {
            return true;
        }
        return Collections.disjoint(Arrays.asList(strMo43087u.split(",")), arrayList);
    }
}
