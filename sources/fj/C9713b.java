package fj;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.Filter;
import dj.C9158a;
import java.util.List;
import p015ak.C0213f;
import p054cj.C1442a;
import p429kk.C11060c;
import p846zj.C14306d;

/* renamed from: fj.b */
/* loaded from: classes5.dex */
public class C9713b {

    /* renamed from: a */
    public static C9713b f47924a = new C9713b();

    /* renamed from: fj.b$a */
    public static class a {

        /* renamed from: a */
        public String f47925a;

        /* renamed from: b */
        public Handler f47926b;

        /* renamed from: c */
        public C11060c f47927c;

        /* renamed from: d */
        public Filter f47928d;

        /* renamed from: e */
        public String f47929e;

        /* renamed from: f */
        public List<Integer> f47930f;

        /* renamed from: g */
        public int f47931g;

        /* renamed from: h */
        public ChannelInfo f47932h;

        /* renamed from: i */
        public int f47933i;

        public a(String str) {
            this.f47925a = str;
        }

        /* renamed from: a */
        public List<Integer> m60572a() {
            return this.f47930f;
        }

        /* renamed from: b */
        public int m60573b() {
            return this.f47931g;
        }

        /* renamed from: c */
        public ChannelInfo m60574c() {
            return this.f47932h;
        }

        /* renamed from: d */
        public String m60575d() {
            return this.f47925a;
        }

        /* renamed from: e */
        public String m60576e() {
            return this.f47929e;
        }

        /* renamed from: f */
        public Filter m60577f() {
            return this.f47928d;
        }

        /* renamed from: g */
        public Handler m60578g() {
            return this.f47926b;
        }

        /* renamed from: h */
        public C11060c m60579h() {
            return this.f47927c;
        }

        /* renamed from: i */
        public int m60580i() {
            return this.f47933i;
        }

        /* renamed from: j */
        public void m60581j(List<Integer> list) {
            this.f47930f = list;
        }

        /* renamed from: k */
        public void m60582k(int i10) {
            this.f47931g = i10;
        }

        /* renamed from: l */
        public void m60583l(ChannelInfo channelInfo) {
            this.f47932h = channelInfo;
        }

        /* renamed from: m */
        public void m60584m(String str) {
            this.f47929e = str;
        }

        /* renamed from: n */
        public void m60585n(Filter filter) {
            this.f47928d = filter;
        }

        /* renamed from: o */
        public void m60586o(Handler handler) {
            this.f47926b = handler;
        }

        /* renamed from: p */
        public void m60587p(C11060c c11060c) {
            this.f47927c = c11060c;
        }

        /* renamed from: q */
        public void m60588q(int i10) {
            this.f47933i = i10;
        }
    }

    /* renamed from: c */
    public static synchronized C9713b m60566c() {
        return f47924a;
    }

    /* renamed from: a */
    public void m60567a(Handler handler, Filter filter, String str, boolean z10, ChannelInfo channelInfo) {
        if (!z10) {
            C9158a.m57503F().m57557v(handler, filter, str, channelInfo, false);
            return;
        }
        a aVar = new a("getAvailableGradePackages");
        aVar.m60586o(handler);
        aVar.m60585n(filter);
        aVar.m60584m(str);
        aVar.m60583l(channelInfo);
        C14306d.m85217r(C0213f.m1377a(), new b(aVar), false);
    }

    /* renamed from: b */
    public void m60568b(Handler handler, boolean z10) {
        if (!z10) {
            C9158a.m57503F().m57507D(handler);
            return;
        }
        a aVar = new a("getFreePackage");
        aVar.m60586o(handler);
        C14306d.m85217r(C0213f.m1377a(), new b(aVar), true);
    }

    /* renamed from: d */
    public void m60569d(Handler handler, List<Integer> list, int i10, boolean z10) {
        if (!z10) {
            C9158a.m57503F().m57514L(handler, list, i10);
            return;
        }
        a aVar = new a("getRecommendActivity");
        aVar.m60586o(handler);
        aVar.m60581j(list);
        aVar.m60582k(i10);
        C14306d.m85217r(C0213f.m1377a(), new b(aVar), true);
    }

    /* renamed from: e */
    public void m60570e(Handler handler, int i10, C11060c c11060c, boolean z10, boolean z11, String str) {
        if (!z10) {
            C9158a.m57503F().m57516N(handler, c11060c, z11, str);
            return;
        }
        a aVar = new a("getUserPackage");
        aVar.m60586o(handler);
        aVar.m60587p(c11060c);
        aVar.m60588q(i10);
        C14306d.m85217r(C0213f.m1377a(), new b(aVar, z11, str), false);
    }

    /* renamed from: f */
    public void m60571f(Handler handler, C11060c c11060c, boolean z10, String str) {
        if (!z10) {
            C9158a.m57503F().m57516N(handler, c11060c, false, str);
            return;
        }
        a aVar = new a("getUserPackage");
        aVar.m60586o(handler);
        aVar.m60587p(c11060c);
        C14306d.m85217r(C0213f.m1377a(), new b(aVar, false, str), false);
    }

    /* renamed from: fj.b$b */
    public static class b extends Handler {

        /* renamed from: a */
        public a f47934a;

        /* renamed from: b */
        public String f47935b;

        /* renamed from: c */
        public boolean f47936c;

        public b(a aVar) {
            super(Looper.getMainLooper());
            this.f47934a = aVar;
        }

        /* renamed from: a */
        public final void m60589a() {
            a aVar = this.f47934a;
            if (aVar == null) {
                C1442a.m8289e("BusinessInterfaceManager", "callbackparams is null");
                return;
            }
            String strM60575d = aVar.m60575d();
            if (TextUtils.isEmpty(strM60575d)) {
                C1442a.m8289e("BusinessInterfaceManager", "cmd is null");
                return;
            }
            C1442a.m8290i("BusinessInterfaceManager", "handleGetAccountFail, cmd is " + strM60575d);
            Handler handlerM60578g = this.f47934a.m60578g();
            if (handlerM60578g == null) {
                C1442a.m8289e("BusinessInterfaceManager", "handler is null");
                return;
            }
            Message messageObtainMessage = handlerM60578g.obtainMessage();
            messageObtainMessage.what = 20000;
            handlerM60578g.sendMessage(messageObtainMessage);
        }

        /* renamed from: b */
        public final void m60590b() {
            C11060c c11060c;
            int iM60580i;
            a aVar = this.f47934a;
            if (aVar == null) {
                C1442a.m8289e("BusinessInterfaceManager", "callbackparams is null");
            }
            String strM60575d = aVar.m60575d();
            if (TextUtils.isEmpty(strM60575d)) {
                C1442a.m8289e("BusinessInterfaceManager", "cmd is null");
                return;
            }
            C1442a.m8290i("BusinessInterfaceManager", "handleGetAccountSuccess, cmd is " + strM60575d);
            Handler handlerM60578g = this.f47934a.m60578g();
            if (handlerM60578g == null) {
                C1442a.m8289e("BusinessInterfaceManager", "handler is null");
                return;
            }
            C11060c c11060cM60579h = this.f47934a.m60579h();
            if (c11060cM60579h == null) {
                c11060cM60579h = new C11060c();
            }
            c11060c = c11060cM60579h;
            iM60580i = this.f47934a.m60580i();
            strM60575d.hashCode();
            switch (strM60575d) {
                case "getUserPackage":
                    C9158a.m57503F().m57515M(handlerM60578g, iM60580i, c11060c, false, this.f47936c, this.f47935b);
                    break;
                case "getFreePackage":
                    C9158a.m57503F().m57507D(handlerM60578g);
                    break;
                case "getRecommendActivity":
                    C9158a.m57503F().m57514L(handlerM60578g, this.f47934a.m60572a(), this.f47934a.m60573b());
                    break;
                case "getAvailableGradePackages":
                    Filter filterM60577f = this.f47934a.m60577f();
                    if (filterM60577f != null) {
                        C9158a.m57503F().m57557v(handlerM60578g, filterM60577f, this.f47934a.m60576e(), this.f47934a.m60574c(), false);
                        break;
                    } else {
                        C1442a.m8289e("BusinessInterfaceManager", "filter is null");
                        break;
                    }
                default:
                    C1442a.m8289e("BusinessInterfaceManager", "not available cmd");
                    break;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 20000) {
                m60589a();
            } else {
                if (i10 != 20001) {
                    return;
                }
                m60590b();
            }
        }

        public b(a aVar, boolean z10, String str) {
            super(Looper.getMainLooper());
            this.f47934a = aVar;
            this.f47936c = z10;
            this.f47935b = str;
        }
    }
}
