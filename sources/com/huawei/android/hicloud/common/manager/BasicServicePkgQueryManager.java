package com.huawei.android.hicloud.common.manager;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import dj.C9158a;
import fk.C9721b;
import java.math.BigDecimal;
import java.util.List;
import p015ak.C0213f;
import p015ak.C0214f0;
import p459lp.C11326d;
import p514o9.C11839m;
import p572qb.C12312h0;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class BasicServicePkgQueryManager {

    /* renamed from: a */
    public boolean f11924a;

    /* renamed from: b */
    public boolean f11925b;

    /* renamed from: c */
    public String f11926c;

    /* renamed from: d */
    public SharedPreferences f11927d;

    /* renamed from: e */
    public OnBasicServiceMinPriceRefresh f11928e;

    /* renamed from: f */
    public final Handler f11929f;

    public interface OnBasicServiceMinPriceRefresh {
        /* renamed from: a */
        void mo15595a(String str);
    }

    /* renamed from: com.huawei.android.hicloud.common.manager.BasicServicePkgQueryManager$a */
    public class C2747a extends AbstractC12367d {
        public C2747a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            long jM74028c = C12312h0.m74027b().m74028c();
            long jM15587n = BasicServicePkgQueryManager.this.m15587n("queryServerTime", -1L);
            BasicServicePkgQueryManager basicServicePkgQueryManager = BasicServicePkgQueryManager.this;
            basicServicePkgQueryManager.f11926c = basicServicePkgQueryManager.m15588o("packageMinPrice", basicServicePkgQueryManager.f11926c);
            int iM68049k = C11326d.m68049k() * 1000;
            boolean z10 = jM74028c - jM15587n > ((long) iM68049k);
            C11839m.m70688i("BasicServicePkgQueryManager", "cache:minPrice : " + BasicServicePkgQueryManager.this.f11926c + " ; needQuery :" + z10 + " ; cacheServerTime :" + jM15587n + " ; curServerTime : " + jM74028c + " ; cacheTime :" + iM68049k);
            if (BasicServicePkgQueryManager.this.f11928e != null) {
                BasicServicePkgQueryManager.this.f11928e.mo15595a(BasicServicePkgQueryManager.this.f11926c);
            }
            if (z10) {
                BasicServicePkgQueryManager.this.m15593t();
            }
            BasicServicePkgQueryManager.this.f11925b = false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.common.manager.BasicServicePkgQueryManager$b */
    public class C2748b extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f11931a;

        public C2748b(String str) {
            this.f11931a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            long jM74028c = C12312h0.m74027b().m74028c();
            BasicServicePkgQueryManager.this.m15592s("packageMinPrice", this.f11931a);
            BasicServicePkgQueryManager.this.m15591r("queryServerTime", jM74028c);
            C11839m.m70688i("BasicServicePkgQueryManager", "save : minPrice : " + this.f11931a + " ; serviceTime :" + jM74028c);
        }
    }

    /* renamed from: com.huawei.android.hicloud.common.manager.BasicServicePkgQueryManager$c */
    public static class C2749c {

        /* renamed from: a */
        public static final BasicServicePkgQueryManager f11933a = new BasicServicePkgQueryManager(null);
    }

    /* renamed from: com.huawei.android.hicloud.common.manager.BasicServicePkgQueryManager$d */
    public static class HandlerC2750d extends Handler {

        /* renamed from: a */
        public final BasicServicePkgQueryManager f11934a;

        public HandlerC2750d(BasicServicePkgQueryManager basicServicePkgQueryManager) {
            super(Looper.getMainLooper());
            this.f11934a = basicServicePkgQueryManager;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 == 6019) {
                this.f11934a.m15585k(message.obj);
            } else if (i10 == 6020) {
                this.f11934a.m15584j(message.arg1);
            }
            this.f11934a.f11924a = false;
        }
    }

    public /* synthetic */ BasicServicePkgQueryManager(C2747a c2747a) {
        this();
    }

    /* renamed from: m */
    public static BasicServicePkgQueryManager m15583m() {
        return C2749c.f11933a;
    }

    /* renamed from: j */
    public void m15584j(int i10) {
        C11839m.m70688i("BasicServicePkgQueryManager", "GetAvailableGradePackagesFail :" + i10);
    }

    /* renamed from: k */
    public void m15585k(Object obj) {
        if (!(obj instanceof GetAvailableGradePackagesResp)) {
            C11839m.m70689w("BasicServicePkgQueryManager", "GetAvailableGradePackagesResp cast error");
            return;
        }
        List<CloudPackage> spacePackages = ((GetAvailableGradePackagesResp) obj).getSpacePackages();
        if (spacePackages == null || spacePackages.isEmpty()) {
            C11839m.m70689w("BasicServicePkgQueryManager", "spacePackages is null");
            return;
        }
        BigDecimal bigDecimal = null;
        for (CloudPackage cloudPackage : spacePackages) {
            BigDecimal spPrice = cloudPackage.getSpPrice();
            BigDecimal price = cloudPackage.getPrice();
            if (spPrice == null) {
                spPrice = price;
            }
            if (bigDecimal == null || (spPrice != null && bigDecimal.compareTo(spPrice) > 0)) {
                bigDecimal = spPrice;
            }
        }
        if (bigDecimal == null) {
            return;
        }
        String string = bigDecimal.toString();
        OnBasicServiceMinPriceRefresh onBasicServiceMinPriceRefresh = this.f11928e;
        if (onBasicServiceMinPriceRefresh != null) {
            onBasicServiceMinPriceRefresh.mo15595a(string);
        }
        this.f11926c = string;
        C12515a.m75110o().m75172d(new C2748b(string));
        C11839m.m70688i("BasicServicePkgQueryManager", "minPrice : " + string);
    }

    /* renamed from: l */
    public String m15586l() {
        return this.f11926c;
    }

    /* renamed from: n */
    public long m15587n(String str, long j10) {
        m15589p();
        SharedPreferences sharedPreferences = this.f11927d;
        return sharedPreferences != null ? sharedPreferences.getLong(str, j10) : j10;
    }

    /* renamed from: o */
    public final String m15588o(String str, String str2) {
        m15589p();
        SharedPreferences sharedPreferences = this.f11927d;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    /* renamed from: p */
    public final void m15589p() {
        if (this.f11927d == null) {
            this.f11927d = C0214f0.m1382b(C0213f.m1377a(), "basicServicePackagePrice", 0);
        }
    }

    /* renamed from: q */
    public void m15590q() {
        if (this.f11925b) {
            C11839m.m70689w("BasicServicePkgQueryManager", "loadCache is running.");
        } else {
            this.f11925b = true;
            C12515a.m75110o().m75172d(new C2747a());
        }
    }

    /* renamed from: r */
    public final void m15591r(String str, long j10) {
        m15589p();
        SharedPreferences sharedPreferences = this.f11927d;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str, j10).apply();
        }
    }

    /* renamed from: s */
    public final void m15592s(String str, String str2) {
        m15589p();
        SharedPreferences sharedPreferences = this.f11927d;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    /* renamed from: t */
    public final void m15593t() {
        C11839m.m70688i("BasicServicePkgQueryManager", "queryPackage start");
        if (this.f11924a) {
            C11839m.m70689w("BasicServicePkgQueryManager", "isQuerying is true");
            return;
        }
        Filter filter = new Filter();
        filter.setShowPlace(2);
        C9158a.m57503F().m57560y(this.f11929f, filter, null, true, new ChannelInfo(), true, 0);
        this.f11924a = true;
        C11839m.m70688i("BasicServicePkgQueryManager", "queryPackage end");
    }

    /* renamed from: u */
    public void m15594u(OnBasicServiceMinPriceRefresh onBasicServiceMinPriceRefresh) {
        this.f11928e = onBasicServiceMinPriceRefresh;
    }

    public BasicServicePkgQueryManager() {
        this.f11924a = false;
        this.f11925b = false;
        this.f11926c = null;
        this.f11929f = new HandlerC2750d(this);
    }
}
