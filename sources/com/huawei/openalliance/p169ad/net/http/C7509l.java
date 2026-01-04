package com.huawei.openalliance.p169ad.net.http;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7843v;
import java.net.InetAddress;
import java.util.List;
import okhttp3.InterfaceC11951r;
import org.json.JSONException;

/* renamed from: com.huawei.openalliance.ad.net.http.l */
/* loaded from: classes2.dex */
public class C7509l implements InterfaceC11951r {

    /* renamed from: a */
    private static final InterfaceC11951r f34871a = InterfaceC11951r.f55643d;

    /* renamed from: b */
    private boolean f34872b;

    /* renamed from: c */
    private Context f34873c;

    public C7509l(Context context, boolean z10) {
        this.f34873c = context;
        this.f34872b = z10;
    }

    @Override // okhttp3.InterfaceC11951r
    public List<InetAddress> lookup(String str) throws JSONException {
        AbstractC7185ho.m43820b("OkHttpDNS", "lookup for :" + AbstractC7806cz.m48174f(str) + ",useHuaweiDNS:" + this.f34872b);
        if (this.f34872b && C7843v.m48511a()) {
            List<InetAddress> listM48508a = C7843v.m48508a(this.f34873c, str);
            if (!listM48508a.isEmpty()) {
                return listM48508a;
            }
        }
        return f34871a.lookup(str);
    }
}
