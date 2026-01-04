package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.view.View;
import cn.com.miaozhen.mobile.tracking.api.MzCountly;
import cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.jl */
/* loaded from: classes8.dex */
public enum EnumC7338jl {
    INSTANCE;


    /* renamed from: b */
    private boolean f34197b;

    /* renamed from: c */
    private Context f34198c;

    /* renamed from: com.huawei.openalliance.ad.jl$1 */
    public class AnonymousClass1 implements MzCallBack {

        /* renamed from: a */
        final /* synthetic */ String f34199a;

        /* renamed from: b */
        final /* synthetic */ ContentRecord f34200b;

        public AnonymousClass1(String str, ContentRecord contentRecord) {
            str = str;
            contentRecord = contentRecord;
        }

        @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack
        public void onFailed(String str) {
            AbstractC7185ho.m43821b("MZSdkManager", "displayImp onError: %s, url is %s", str, AbstractC7819dl.m48375a(str));
            EnumC7338jl enumC7338jl = EnumC7338jl.this;
            enumC7338jl.m45328a(2, "displayImp", enumC7338jl.m45327a(str), str, contentRecord, "");
        }

        @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack
        public void onSuccess(String str) {
            AbstractC7185ho.m43821b("MZSdkManager", "displayImp onSuccess: %s, url is %s", str, AbstractC7819dl.m48375a(str));
            EnumC7338jl enumC7338jl = EnumC7338jl.this;
            enumC7338jl.m45328a(1, "displayImp", enumC7338jl.m45327a(str), null, contentRecord, str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.jl$2 */
    public class AnonymousClass2 implements MzCallBack {

        /* renamed from: a */
        final /* synthetic */ String f34202a;

        /* renamed from: b */
        final /* synthetic */ ContentRecord f34203b;

        public AnonymousClass2(String str, ContentRecord contentRecord) {
            str = str;
            contentRecord = contentRecord;
        }

        @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack
        public void onFailed(String str) {
            AbstractC7185ho.m43821b("MZSdkManager", "videoImp failed: %s, url is %s", str, AbstractC7819dl.m48375a(str));
            EnumC7338jl enumC7338jl = EnumC7338jl.this;
            enumC7338jl.m45328a(2, "videoImp", enumC7338jl.m45327a(str), str, contentRecord, "");
        }

        @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack
        public void onSuccess(String str) {
            AbstractC7185ho.m43821b("MZSdkManager", "videoImp onSuccess. %s, url is %s", str, AbstractC7819dl.m48375a(str));
            EnumC7338jl enumC7338jl = EnumC7338jl.this;
            enumC7338jl.m45328a(1, "videoImp", enumC7338jl.m45327a(str), null, contentRecord, str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.jl$3 */
    public class AnonymousClass3 implements MzCallBack {

        /* renamed from: a */
        final /* synthetic */ String f34205a;

        /* renamed from: b */
        final /* synthetic */ ContentRecord f34206b;

        public AnonymousClass3(String str, ContentRecord contentRecord) {
            str = str;
            contentRecord = contentRecord;
        }

        @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack
        public void onFailed(String str) {
            AbstractC7185ho.m43821b("MZSdkManager", "onClick failed: %s, url is %s", str, AbstractC7819dl.m48375a(str));
            EnumC7338jl enumC7338jl = EnumC7338jl.this;
            enumC7338jl.m45328a(2, "click", enumC7338jl.m45327a(str), str, contentRecord, "");
        }

        @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack
        public void onSuccess(String str) {
            AbstractC7185ho.m43821b("MZSdkManager", "onClick onSuccess. %s, url is %s", str, AbstractC7819dl.m48375a(str));
            EnumC7338jl enumC7338jl = EnumC7338jl.this;
            enumC7338jl.m45328a(1, "click", enumC7338jl.m45327a(str), null, contentRecord, str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.jl$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f34208a;

        /* renamed from: b */
        final /* synthetic */ String f34209b;

        /* renamed from: c */
        final /* synthetic */ String f34210c;

        /* renamed from: d */
        final /* synthetic */ String f34211d;

        /* renamed from: e */
        final /* synthetic */ ContentRecord f34212e;

        /* renamed from: f */
        final /* synthetic */ String f34213f;

        public AnonymousClass4(int i10, String str, String str2, String str3, ContentRecord contentRecord, String str4) {
            i = i10;
            str = str;
            str = str2;
            str = str3;
            contentRecord = contentRecord;
            str = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            new C6922c(EnumC7338jl.this.f34198c).mo39060a(i, str, str, str, contentRecord, str);
        }
    }

    /* renamed from: b */
    private String m45331b(List<String> list) {
        StringBuilder sb2 = new StringBuilder("monitorUrls:");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            sb2.append(",");
        }
        return sb2.toString();
    }

    /* renamed from: a */
    public static EnumC7338jl m45325a() {
        return INSTANCE;
    }

    /* renamed from: b */
    public boolean m45337b() {
        return this.f34197b;
    }

    /* renamed from: a */
    public String m45327a(String str) {
        return "monitorUrl:" + str;
    }

    /* renamed from: a */
    public void m45328a(int i10, String str, String str2, String str3, ContentRecord contentRecord, String str4) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.jl.4

            /* renamed from: a */
            final /* synthetic */ int f34208a;

            /* renamed from: b */
            final /* synthetic */ String f34209b;

            /* renamed from: c */
            final /* synthetic */ String f34210c;

            /* renamed from: d */
            final /* synthetic */ String f34211d;

            /* renamed from: e */
            final /* synthetic */ ContentRecord f34212e;

            /* renamed from: f */
            final /* synthetic */ String f34213f;

            public AnonymousClass4(int i102, String str5, String str22, String str32, ContentRecord contentRecord2, String str42) {
                i = i102;
                str = str5;
                str = str22;
                str = str32;
                contentRecord = contentRecord2;
                str = str42;
            }

            @Override // java.lang.Runnable
            public void run() {
                new C6922c(EnumC7338jl.this.f34198c).mo39060a(i, str, str, str, contentRecord, str);
            }
        });
    }

    /* renamed from: a */
    public void m45332a(int i10, List<String> list, View view, ContentRecord contentRecord) {
        if (m45330a("videoImp", list)) {
            AbstractC7185ho.m43820b("MZSdkManager", "invoke videoImp");
            m45328a(0, "videoImp", m45331b(list), null, contentRecord, "");
            for (String str : list) {
                MzCountly.sharedInstance().videoImp(str, view, 1, i10, new MzCallBack() { // from class: com.huawei.openalliance.ad.jl.2

                    /* renamed from: a */
                    final /* synthetic */ String f34202a;

                    /* renamed from: b */
                    final /* synthetic */ ContentRecord f34203b;

                    public AnonymousClass2(String str2, ContentRecord contentRecord2) {
                        str = str2;
                        contentRecord = contentRecord2;
                    }

                    @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack
                    public void onFailed(String str2) {
                        AbstractC7185ho.m43821b("MZSdkManager", "videoImp failed: %s, url is %s", str2, AbstractC7819dl.m48375a(str));
                        EnumC7338jl enumC7338jl = EnumC7338jl.this;
                        enumC7338jl.m45328a(2, "videoImp", enumC7338jl.m45327a(str), str2, contentRecord, "");
                    }

                    @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack
                    public void onSuccess(String str2) {
                        AbstractC7185ho.m43821b("MZSdkManager", "videoImp onSuccess. %s, url is %s", str2, AbstractC7819dl.m48375a(str));
                        EnumC7338jl enumC7338jl = EnumC7338jl.this;
                        enumC7338jl.m45328a(1, "videoImp", enumC7338jl.m45327a(str), null, contentRecord, str2);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public void m45333a(Context context) {
        this.f34198c = context.getApplicationContext();
        try {
            MzCountly.sharedInstance().setLogState(AbstractC7185ho.m43819a());
            MzCountly.sharedInstance().init(context, "");
            AbstractC7185ho.m43820b("MZSdkManager", "init mz sdk success");
            this.f34197b = true;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("MZSdkManager", "init mz sdk, err %s", th2.getClass().getSimpleName());
            this.f34197b = false;
        }
    }

    /* renamed from: a */
    public void m45334a(List<String> list) {
        if (!m45337b()) {
            AbstractC7185ho.m43820b("MZSdkManager", "stopMz, not support mz");
            return;
        }
        AbstractC7185ho.m43820b("MZSdkManager", "stop mz monitor.");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            MzCountly.sharedInstance().stop(it.next());
        }
    }

    /* renamed from: a */
    public void m45335a(List<String> list, View view, ContentRecord contentRecord) {
        if (m45330a("displayImp", list)) {
            AbstractC7185ho.m43820b("MZSdkManager", "invoke displayImp");
            m45328a(0, "displayImp", m45331b(list), null, contentRecord, "");
            for (String str : list) {
                MzCountly.sharedInstance().disPlayImp(str, view, 1, new MzCallBack() { // from class: com.huawei.openalliance.ad.jl.1

                    /* renamed from: a */
                    final /* synthetic */ String f34199a;

                    /* renamed from: b */
                    final /* synthetic */ ContentRecord f34200b;

                    public AnonymousClass1(String str2, ContentRecord contentRecord2) {
                        str = str2;
                        contentRecord = contentRecord2;
                    }

                    @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack
                    public void onFailed(String str2) {
                        AbstractC7185ho.m43821b("MZSdkManager", "displayImp onError: %s, url is %s", str2, AbstractC7819dl.m48375a(str));
                        EnumC7338jl enumC7338jl = EnumC7338jl.this;
                        enumC7338jl.m45328a(2, "displayImp", enumC7338jl.m45327a(str), str2, contentRecord, "");
                    }

                    @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack
                    public void onSuccess(String str2) {
                        AbstractC7185ho.m43821b("MZSdkManager", "displayImp onSuccess: %s, url is %s", str2, AbstractC7819dl.m48375a(str));
                        EnumC7338jl enumC7338jl = EnumC7338jl.this;
                        enumC7338jl.m45328a(1, "displayImp", enumC7338jl.m45327a(str), null, contentRecord, str2);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public void m45336a(List<String> list, ContentRecord contentRecord) {
        if (m45330a("click", list)) {
            AbstractC7185ho.m43820b("MZSdkManager", "invoke onClick");
            m45328a(0, "click", m45331b(list), null, contentRecord, "");
            for (String str : list) {
                MzCountly.sharedInstance().onClick(str, new MzCallBack() { // from class: com.huawei.openalliance.ad.jl.3

                    /* renamed from: a */
                    final /* synthetic */ String f34205a;

                    /* renamed from: b */
                    final /* synthetic */ ContentRecord f34206b;

                    public AnonymousClass3(String str2, ContentRecord contentRecord2) {
                        str = str2;
                        contentRecord = contentRecord2;
                    }

                    @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack
                    public void onFailed(String str2) {
                        AbstractC7185ho.m43821b("MZSdkManager", "onClick failed: %s, url is %s", str2, AbstractC7819dl.m48375a(str));
                        EnumC7338jl enumC7338jl = EnumC7338jl.this;
                        enumC7338jl.m45328a(2, "click", enumC7338jl.m45327a(str), str2, contentRecord, "");
                    }

                    @Override // cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack
                    public void onSuccess(String str2) {
                        AbstractC7185ho.m43821b("MZSdkManager", "onClick onSuccess. %s, url is %s", str2, AbstractC7819dl.m48375a(str));
                        EnumC7338jl enumC7338jl = EnumC7338jl.this;
                        enumC7338jl.m45328a(1, "click", enumC7338jl.m45327a(str), null, contentRecord, str2);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private boolean m45330a(String str, List<String> list) {
        if (!m45337b()) {
            AbstractC7185ho.m43821b("MZSdkManager", "invoke %s, not support mz", str);
            return false;
        }
        if (!AbstractC7760bg.m47767a(list)) {
            return true;
        }
        AbstractC7185ho.m43821b("MZSdkManager", "invoke %s, url is blank", str);
        return false;
    }
}
