package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.ads.jsb.inner.data.AppDownloadInfo;
import com.huawei.openalliance.p169ad.AbstractC6919an;
import com.huawei.openalliance.p169ad.download.InterfaceC7068k;
import com.huawei.openalliance.p169ad.download.p172ag.C7037e;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.aj */
/* loaded from: classes8.dex */
public class C6915aj extends AbstractC6912ag {

    /* renamed from: com.huawei.openalliance.ad.aj$a */
    public static class a implements InterfaceC7068k {

        /* renamed from: a */
        private static final byte[] f31815a = new byte[0];

        /* renamed from: b */
        private static a f31816b;

        /* renamed from: c */
        private String f31817c;

        /* renamed from: d */
        private Map<String, RemoteCallResultCallback<String>> f31818d = Collections.synchronizedMap(new AbstractC6919an.e(5));

        private a(Context context) {
            AbstractC7185ho.m43820b("JsbOnAgReserveStatusChange", "listener init");
            C7037e.m42187a(context).m42197a(this);
        }

        /* renamed from: a */
        public static a m38797a(Context context) {
            a aVar;
            synchronized (f31815a) {
                try {
                    if (f31816b == null) {
                        f31816b = new a(context);
                    }
                    aVar = f31816b;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return aVar;
        }

        /* renamed from: a */
        public void m38798a(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.f31818d.put(str2, remoteCallResultCallback);
            this.f31817c = str;
        }

        @Override // com.huawei.openalliance.p169ad.download.InterfaceC7068k
        /* renamed from: a */
        public void mo38799a(String str, int i10) {
            Map<String, RemoteCallResultCallback<String>> map = this.f31818d;
            if (map == null || map.size() <= 0) {
                return;
            }
            Iterator<RemoteCallResultCallback<String>> it = this.f31818d.values().iterator();
            while (it.hasNext()) {
                AbstractC7326j.m45216a(it.next(), this.f31817c, 1000, AbstractC7758be.m47742b(new AppDownloadInfo(str, i10)), false);
            }
        }
    }

    public C6915aj() {
        super("pps.listener.appreservestatus");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        a.m38797a(context).m38798a(remoteCallResultCallback, this.f34112a, this.f34114c);
    }
}
