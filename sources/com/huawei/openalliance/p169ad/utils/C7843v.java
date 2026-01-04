package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.restclient.dnkeeper.DNKeeperManager;
import com.huawei.hms.framework.network.restclient.dnkeeper.RequestHost;
import com.huawei.hms.framework.network.restclient.hwhttp.dns.DnsResult;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* renamed from: com.huawei.openalliance.ad.utils.v */
/* loaded from: classes2.dex */
public class C7843v {
    /* renamed from: a */
    public static List<InetAddress> m48508a(Context context, String str) throws JSONException {
        List<DnsResult.Address> addressList;
        AbstractC7185ho.m43820b("DNSUtil", "lookup:" + AbstractC7819dl.m48375a(str));
        ArrayList arrayList = new ArrayList();
        DnsResult dnsResultQueryIpsSync = DNKeeperManager.getInstance().queryIpsSync(new RequestHost(str));
        if (dnsResultQueryIpsSync != null && (addressList = dnsResultQueryIpsSync.getAddressList()) != null && !addressList.isEmpty()) {
            Iterator<DnsResult.Address> it = addressList.iterator();
            while (it.hasNext()) {
                String value = it.next().getValue();
                if (!TextUtils.isEmpty(value)) {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("DNSUtil", "ip:%s", value);
                    }
                    arrayList.add(InetAddress.getByName(value));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m48509a(Context context) {
        if (m48511a()) {
            AbstractC7185ho.m43820b("DNSUtil", "init dnkeeper");
            DNKeeperManager.getInstance().init(context.getApplicationContext());
        }
    }

    /* renamed from: a */
    public static void m48510a(String str) {
        if (m48511a()) {
            DNKeeperManager.getInstance().removeCache(str);
        }
    }

    /* renamed from: a */
    public static boolean m48511a() {
        try {
            int i10 = DNKeeperManager.f25027r;
            return true;
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("DNSUtil", "check DNKeeperManager available error");
            return false;
        }
    }
}
