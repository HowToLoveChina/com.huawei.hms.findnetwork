package com.huawei.hms.network.embedded;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.networkkit.embedded.C6262R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.o0 */
/* loaded from: classes8.dex */
public class C6029o0 {

    /* renamed from: e */
    public static final String f27598e = "HttpDnsHelper";

    /* renamed from: f */
    public static final String f27599f = "httpdns_serviceId";

    /* renamed from: a */
    public String f27600a;

    /* renamed from: b */
    public String f27601b;

    /* renamed from: c */
    public String f27602c;

    /* renamed from: d */
    public List<String> f27603d;

    /* renamed from: com.huawei.hms.network.embedded.o0$b */
    public static class b {

        /* renamed from: a */
        public static final C6029o0 f27604a = new C6029o0();
    }

    public C6029o0() {
    }

    /* renamed from: e */
    public static C6029o0 m34910e() {
        return b.f27604a;
    }

    /* renamed from: a */
    public synchronized List<String> m34911a() {
        try {
            if (this.f27603d == null) {
                this.f27603d = new ArrayList();
                for (String str : ContextHolder.getResourceContext().getResources().getStringArray(C6262R.array.networkkit_httpdns_anycastip_array)) {
                    this.f27603d.add(str);
                }
                if (this.f27603d.isEmpty()) {
                    Logger.m32145w(f27598e, "current anyCastIps have not configured yet!");
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f27603d;
    }

    /* renamed from: b */
    public String m34912b() {
        if (TextUtils.isEmpty(this.f27601b)) {
            this.f27601b = NetworkUtil.getHost(m34913c());
        }
        return this.f27601b;
    }

    /* renamed from: c */
    public String m34913c() {
        if (TextUtils.isEmpty(this.f27600a)) {
            this.f27600a = ContextHolder.getResourceContext().getString(C6262R.string.networkkit_httpdns_domain);
        }
        return this.f27600a;
    }

    /* renamed from: d */
    public String m34914d() throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(this.f27602c)) {
            return this.f27602c;
        }
        try {
            applicationInfo = ContextHolder.getAppContext().getPackageManager().getApplicationInfo(ContextHolder.getAppContext().getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException | RuntimeException e10) {
            Logger.m32146w(f27598e, "NameNotFoundException: ", e10);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            Logger.m32145w(f27598e, "appInfo == null ");
            return "";
        }
        Object obj = applicationInfo.metaData.get(f27599f);
        if (obj == null) {
            return "";
        }
        this.f27602c = obj.toString();
        Logger.m32143v(f27598e, "get serviceId form metaData：" + this.f27602c);
        return this.f27602c;
    }
}
