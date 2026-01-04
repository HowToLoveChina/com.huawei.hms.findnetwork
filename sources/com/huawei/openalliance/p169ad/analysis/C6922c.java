package com.huawei.openalliance.p169ad.analysis;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7154gk;
import com.huawei.openalliance.p169ad.C7211ie;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7653sb;
import com.huawei.openalliance.p169ad.C7655sd;
import com.huawei.openalliance.p169ad.C7662sk;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.InterfaceC7002cs;
import com.huawei.openalliance.p169ad.beans.inner.ApiStatisticsReq;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.C7306i;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.AbstractC7836o;
import com.huawei.openalliance.p169ad.utils.C7831j;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p247e4.C9407c;

/* renamed from: com.huawei.openalliance.ad.analysis.c */
/* loaded from: classes8.dex */
public class C6922c extends AbstractC6925f implements InterfaceC7002cs {

    /* renamed from: com.huawei.openalliance.ad.analysis.c$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f31933a;

        /* renamed from: b */
        final /* synthetic */ Integer f31934b;

        /* renamed from: c */
        final /* synthetic */ Integer f31935c;

        public AnonymousClass1(int i10, Integer num, Integer num2) {
            i = i10;
            num = num;
            num = num2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C6922c c6922c = C6922c.this;
            C6921b c6921bM39158a = c6922c.m39158a(c6922c.f31973a.getPackageName(), true);
            try {
                c6921bM39158a.m38827ak("2100008");
                c6921bM39158a.m38828al(String.valueOf(i));
                c6921bM39158a.m38829am(String.valueOf(num));
                c6921bM39158a.m38830an(String.valueOf(num));
                c6921bM39158a.m38851d(System.currentTimeMillis());
                Context context = C6922c.this.f31973a;
                new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39158a, false, false);
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("AnalysisReport", "report update uiengine error: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.analysis.c$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C7692tn f31937a;

        /* renamed from: b */
        final /* synthetic */ String f31938b;

        public AnonymousClass2(C7692tn c7692tn, String str) {
            c7692tn = c7692tn;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C6922c c6922c = C6922c.this;
                C6921b c6921bM39157a = c6922c.m39157a(c6922c.f31973a.getPackageName());
                c6921bM39157a.m38827ak("180");
                c6921bM39157a.m38898H(c7692tn.m47263c());
                c6921bM39157a.m39033p(c7692tn.m47261b());
                c6921bM39157a.m38936a(c7692tn.m47258a());
                c6921bM39157a.m38828al(c7692tn.m47264d());
                c6921bM39157a.m38829am(c7692tn.m47265e());
                c6921bM39157a.m38830an(str);
                AbstractC7185ho.m43824c("AnalysisReport", "start activity error %s", str);
                Context context = C6922c.this.f31973a;
                new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39157a, false, false);
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("AnalysisReport", "onStartActivityException ex: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.analysis.c$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f31940a;

        /* renamed from: b */
        final /* synthetic */ String f31941b;

        /* renamed from: c */
        final /* synthetic */ int f31942c;

        /* renamed from: d */
        final /* synthetic */ int f31943d;

        /* renamed from: e */
        final /* synthetic */ int f31944e;

        public AnonymousClass3(String str, String str2, int i10, int i11, int i12) {
            str = str;
            str = str2;
            i = i10;
            i = i11;
            i = i12;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C6922c c6922c = C6922c.this;
                C6921b c6921bM39158a = c6922c.m39158a(c6922c.f31973a.getPackageName(), true);
                c6921bM39158a.m38827ak(str);
                c6921bM39158a.m38828al(String.valueOf(str));
                c6921bM39158a.m38829am(String.valueOf(i));
                c6921bM39158a.m38830an(String.valueOf(i));
                c6921bM39158a.m38831ao(String.valueOf(i));
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("AnalysisReport", "update database name is %s, exception type is %s, oldVersion is %s, newVersion is %s, upgradeFlag is %s", str, str, Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i));
                }
                Context context = C6922c.this.f31973a;
                new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39158a, false, false);
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("AnalysisReport", "update database exception: %s", th2.getClass().getSimpleName());
            }
        }
    }

    public C6922c(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void m39057a(int i10, long j10, long j11, ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            if (i10 == 1) {
                c6921bM39167f.m38827ak("2100037");
                c6921bM39167f.m38829am(String.valueOf(j11));
            } else {
                c6921bM39167f.m38827ak("2100038");
            }
            c6921bM39167f.m38830an(String.valueOf(j10));
            AbstractC7185ho.m43818a("AnalysisReport", "reportSplashStartMode, mode: %s, timeInterval: %s, adStartLoadTime: %s", Integer.valueOf(i10), c6921bM39167f.m38815aO(), c6921bM39167f.m38816aP());
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39167f, true, true);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "reportSplashStartMode ex: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    public void m39112b(ContentRecord contentRecord) {
        StringBuilder sb2;
        String str;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onVideoNotDownloadInNonWifi, contentRecord is null");
                return;
            }
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("121");
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onVideoNotDownloadInNonWifi RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "onVideoNotDownloadInNonWifi Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: c */
    public void m39120c(ContentRecord contentRecord) {
        StringBuilder sb2;
        String str;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onImageNotPreDownloadInNonWifi, contentRecord is null");
                return;
            }
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("2100032");
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onImageNotPreDownloadInNonWifi RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "onImageNotPreDownloadInNonWifi Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: d */
    public void mo39122d(ContentRecord contentRecord) {
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onSplashIconShow, contentRecord is null.");
                return;
            }
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("137");
            c6921bM39159a.m39039s(contentRecord.m41486ah());
            c6921bM39159a.m38936a(contentRecord.m41552f());
            c6921bM39159a.m39031o(contentRecord.m41585m());
            c6921bM39159a.m39033p(contentRecord.m41588n());
            c6921bM39159a.m38898H(contentRecord.m41591o());
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f())).mo46609b(c6921bM39159a, false, false);
        } catch (Exception e10) {
            AbstractC7185ho.m43823c("AnalysisReport", "onSplashIconShow Exception:" + e10.getClass().getSimpleName());
        }
    }

    /* renamed from: e */
    public void m39124e(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("166");
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, true, false);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "onNotifyReward ex: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39058a(int i10, ContentRecord contentRecord) {
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m39039s(contentRecord.m41486ah());
            c6921bM39167f.m38827ak("2100025");
            c6921bM39167f.m38828al(AbstractC7806cz.m48153a(Integer.valueOf(i10)));
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39167f, false, true);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "reportSdkMonitors err: %s.", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: b */
    public void mo39113b(ContentRecord contentRecord, int i10) {
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onSplashIconNotCached, contentRecord is null.");
                return;
            }
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("140");
            c6921bM39159a.m39039s(contentRecord.m41486ah());
            if (contentRecord.m41529bp() != null) {
                c6921bM39159a.m38973aj(contentRecord.m41529bp());
            }
            c6921bM39159a.m38936a(contentRecord.m41552f());
            c6921bM39159a.m39031o(contentRecord.m41585m());
            c6921bM39159a.m39033p(contentRecord.m41588n());
            c6921bM39159a.m38898H(contentRecord.m41591o());
            c6921bM39159a.m38998c(i10);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f())).mo46609b(c6921bM39159a, false, false);
        } catch (Exception e10) {
            AbstractC7185ho.m43823c("AnalysisReport", "onSplashIconNotCached Exception:" + e10.getClass().getSimpleName());
        }
    }

    /* renamed from: c */
    public void m39121c(ContentRecord contentRecord, int i10) {
        if (contentRecord == null) {
            return;
        }
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("175");
            c6921bM39167f.m38828al(String.valueOf(i10));
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, false);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "OnlinePlayInCacheMode ex: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: d */
    public void mo39123d(ContentRecord contentRecord, int i10) {
        if (contentRecord == null) {
            return;
        }
        try {
            AbstractC7185ho.m43818a("AnalysisReport", "on preload hit report: %d", Integer.valueOf(i10));
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("177");
            c6921bM39167f.m38828al(String.valueOf(i10));
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, false);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "onPreloadHitReport ex: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39059a(int i10, Integer num, Integer num2) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.analysis.c.1

            /* renamed from: a */
            final /* synthetic */ int f31933a;

            /* renamed from: b */
            final /* synthetic */ Integer f31934b;

            /* renamed from: c */
            final /* synthetic */ Integer f31935c;

            public AnonymousClass1(int i102, Integer num3, Integer num22) {
                i = i102;
                num = num3;
                num = num22;
            }

            @Override // java.lang.Runnable
            public void run() {
                C6922c c6922c = C6922c.this;
                C6921b c6921bM39158a = c6922c.m39158a(c6922c.f31973a.getPackageName(), true);
                try {
                    c6921bM39158a.m38827ak("2100008");
                    c6921bM39158a.m38828al(String.valueOf(i));
                    c6921bM39158a.m38829am(String.valueOf(num));
                    c6921bM39158a.m38830an(String.valueOf(num));
                    c6921bM39158a.m38851d(System.currentTimeMillis());
                    Context context = C6922c.this.f31973a;
                    new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39158a, false, false);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("AnalysisReport", "report update uiengine error: %s", th2.getClass().getSimpleName());
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: b */
    public void mo39114b(ContentRecord contentRecord, String str) {
        if (contentRecord == null) {
            return;
        }
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("170");
            c6921bM39167f.m38828al(str);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, false);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "onRecallReport ex: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39060a(int i10, String str, String str2, String str3, ContentRecord contentRecord, String str4) {
        String str5;
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m39039s(contentRecord.m41486ah());
            AbstractC7185ho.m43821b("AnalysisReport", "InvokeMZ, type is %s", Integer.valueOf(i10));
            if (i10 == 0) {
                str5 = "2100024";
            } else if (i10 == 1) {
                str5 = "2100022";
            } else if (i10 != 2) {
                return;
            } else {
                str5 = "2100023";
            }
            c6921bM39167f.m38827ak(str5);
            c6921bM39167f.m38828al(str);
            c6921bM39167f.m38829am(str2);
            c6921bM39167f.m38830an(str3);
            c6921bM39167f.m38831ao(str4);
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39167f, false, false);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "invoke MZ SDK err: %s.", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: b */
    public void mo39115b(ContentRecord contentRecord, String str, String str2) {
        String str3;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onMagazineReportExtraData, contentRecord is null");
                return;
            }
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38827ak("178");
            C6921b c6921bM39154a = m39154a(c6921bM39152a, contentRecord);
            c6921bM39154a.m38828al(str);
            c6921bM39154a.m38829am(str2);
            AbstractC7185ho.m43818a("AnalysisReport", "report [TYPE_MAGAZINE_ADDITION_DATA_REPORT],contentId: %s, exception: exception_%s,additionInfo: %s, extraStr1: %s, extraStr2: %s", contentRecord.m41588n(), c6921bM39154a.m38812aL(), c6921bM39154a.m39036r(), c6921bM39154a.m38814aN(), c6921bM39154a.m38815aO());
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39154a.m39040t().intValue()), contentRecord).mo46609b(c6921bM39154a, false, true);
        } catch (RuntimeException unused) {
            str3 = "onMagazineReportExtraData RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str3);
        } catch (Exception unused2) {
            str3 = "onMagazineReportExtraData Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str3);
        }
    }

    /* renamed from: a */
    public void m39061a(Context context, IAd iAd, int i10) {
        String strM41585m;
        boolean z10;
        try {
            if (context == null || iAd == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "param err");
                return;
            }
            strM41585m = "";
            if (iAd instanceof C7302e) {
                strM41585m = ((C7302e) iAd).getSlotId();
            } else {
                if (!(iAd instanceof C7304g)) {
                    if (iAd instanceof C7306i) {
                        strM41585m = ((C7306i) iAd).m44977a() != null ? ((C7306i) iAd).m44977a().m41585m() : "";
                        z10 = true;
                    }
                    C6921b c6921bM39152a = m39152a();
                    c6921bM39152a.m38827ak("2200198");
                    c6921bM39152a.m39031o(strM41585m);
                    c6921bM39152a.m38898H(iAd.getTaskId());
                    c6921bM39152a.m38828al(AbstractC7806cz.m48153a(Integer.valueOf(i10)));
                    c6921bM39152a.m38829am(AbstractC7806cz.m48153a(Boolean.valueOf(z10)));
                    new C7560ou(context, C7662sk.m47225a(context, -1)).mo46609b(c6921bM39152a, false, true);
                }
                strM41585m = ((C7304g) iAd).m44879H();
            }
            z10 = false;
            C6921b c6921bM39152a2 = m39152a();
            c6921bM39152a2.m38827ak("2200198");
            c6921bM39152a2.m39031o(strM41585m);
            c6921bM39152a2.m38898H(iAd.getTaskId());
            c6921bM39152a2.m38828al(AbstractC7806cz.m48153a(Integer.valueOf(i10)));
            c6921bM39152a2.m38829am(AbstractC7806cz.m48153a(Boolean.valueOf(z10)));
            new C7560ou(context, C7662sk.m47225a(context, -1)).mo46609b(c6921bM39152a2, false, true);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("AnalysisReport", "report download inter failed");
        }
    }

    /* renamed from: b */
    public void m39116b(AdLandingPageData adLandingPageData) {
        String str;
        try {
            if (adLandingPageData == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onLandingUrlOverride, data is null");
                return;
            }
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38827ak("60");
            C6921b c6921bM39155a = m39155a(c6921bM39152a, adLandingPageData);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, adLandingPageData.getAdType())).mo46609b(c6921bM39155a, false, true);
        } catch (RuntimeException unused) {
            str = "onLandingUrlOverrideError RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        } catch (Exception unused2) {
            str = "onLandingUrlOverrideError Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        }
    }

    /* renamed from: a */
    public void m39062a(Context context, C7302e c7302e, long j10) {
        try {
            if (context == null || c7302e == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "param err");
                return;
            }
            long minEffectiveShowTime = c7302e.getMinEffectiveShowTime();
            long maxEffectiveShowTime = c7302e.getMaxEffectiveShowTime();
            C6921b c6921bM39152a = m39152a();
            c6921bM39152a.m38827ak("2100041");
            c6921bM39152a.m39031o(c7302e.getSlotId());
            c6921bM39152a.m38898H(c7302e.getTaskId());
            c6921bM39152a.m38829am(Long.toString(minEffectiveShowTime));
            c6921bM39152a.m38830an(Long.toString(maxEffectiveShowTime));
            c6921bM39152a.m38832ap(Long.toString(j10));
            new C7560ou(context, C7662sk.m47225a(context, -1)).mo46609b(c6921bM39152a, false, true);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("AnalysisReport", "report imp discard failed");
        }
    }

    /* renamed from: b */
    public void m39117b(String str, int i10, String str2, String str3, long j10) {
        StringBuilder sb2;
        String str4;
        try {
            AbstractC7185ho.m43817a("AnalysisReport", "onExLinkedShow");
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("84");
            c6921bM39159a.m38936a(i10);
            c6921bM39159a.m39019i(str);
            c6921bM39159a.m39031o(str2);
            c6921bM39159a.m39033p(str3);
            c6921bM39159a.m38851d(j10);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, i10)).mo46609b(c6921bM39159a, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str4 = "onExLinkedShow RuntimeException:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str4 = "onExLinkedShow Exception:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39063a(Bundle bundle, ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            if (bundle != null) {
                C7154gk c7154gk = new C7154gk(bundle);
                c6921bM39167f.m38827ak(c7154gk.m43588d(ParamConstants.Param.EXCEPTION_TYPE));
                c6921bM39167f.m38828al(c7154gk.m43588d(ParamConstants.Param.EXTRA_STR1));
                c6921bM39167f.m38829am(c7154gk.m43588d(ParamConstants.Param.EXTRA_STR2));
                c6921bM39167f.m38830an(c7154gk.m43588d(ParamConstants.Param.EXTRA_STR3));
                c6921bM39167f.m38831ao(c7154gk.m43588d(ParamConstants.Param.EXTRA_STR4));
                c6921bM39167f.m38832ap(c7154gk.m43588d(ParamConstants.Param.EXTRA_STR5));
            }
            c6921bM39167f.m38936a(1);
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39167f, false, false);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "splashEventReport ex: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    public void m39118b(String str, ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("2100009");
            c6921bM39167f.m38829am(str);
            c6921bM39167f.m38830an(this.f31973a.getPackageName());
            c6921bM39167f.m38832ap("FAT_SDK");
            c6921bM39167f.m39033p(contentRecord.m41588n());
            c6921bM39167f.m38898H(contentRecord.m41591o());
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39167f, false, true);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "ExceptionType is %s, reportJumpFastApp, appName is %s.", "2100009", str);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("AnalysisReport", "reportJumpFastApp:" + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m39064a(VideoConfiguration videoConfiguration, boolean z10, boolean z11, int i10) {
        try {
            C6921b c6921bM39157a = m39157a(this.f31973a.getPackageName());
            if (c6921bM39157a == null) {
                return;
            }
            c6921bM39157a.m38827ak("2200195");
            c6921bM39157a.m38828al(this.f31973a.getPackageName());
            c6921bM39157a.m38833aq(String.valueOf(i10));
            if (videoConfiguration == null) {
                return;
            }
            c6921bM39157a.m38829am(String.valueOf(z10));
            c6921bM39157a.m38830an(String.valueOf(videoConfiguration.getAutoPlayNetwork()));
            c6921bM39157a.m38831ao(String.valueOf(z11));
            c6921bM39157a.m38832ap(String.valueOf(videoConfiguration.isMute()));
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39157a, false, true);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "ExceptionType is %s, Media pkgName is %s, AdType is %s, ServerFirst is %s, AutoPlay is %s, ServerFirst is %s, isMute is %s", "2200195", this.f31973a.getPackageName(), Integer.valueOf(i10), Boolean.valueOf(z10), Integer.valueOf(videoConfiguration.getAutoPlayNetwork()), Boolean.valueOf(z11), Boolean.valueOf(videoConfiguration.isMute()));
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "onSetVideoConfigMedia err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: b */
    public void mo39119b(String str, String str2, ContentRecord contentRecord) {
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m39039s(contentRecord.m41486ah());
            c6921bM39167f.m38827ak("2100027");
            c6921bM39167f.m38828al(str);
            c6921bM39167f.m38829am(str2);
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39167f, false, true);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "reportTaskException err: %s.", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39065a(C6920a c6920a, int i10, String str, String str2) {
        StringBuilder sb2;
        String str3;
        try {
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a != null && c6920a != null) {
                c6921bM39159a.m38827ak("107");
                c6921bM39159a.m38936a(c6920a.m38873d());
                c6921bM39159a.m39039s(c6920a.m38866a());
                c6921bM39159a.m39031o(c6920a.m38869b());
                c6921bM39159a.m39033p(c6920a.m38871c());
                c6921bM39159a.m38998c(i10);
                c6921bM39159a.m38828al(str);
                c6921bM39159a.m38829am(str2);
                c6921bM39159a.m38830an(Constants.NORMAL_CACHE);
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("AnalysisReport", "onRecordSpareSplashAdFailed resultCode: %s", Integer.valueOf(i10));
                }
                Context context = this.f31973a;
                new C7560ou(context, C7662sk.m47225a(context, c6920a.m38873d())).mo46609b(c6921bM39159a, false, false);
            }
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str3 = "onRecordSpareAdFailed RuntimeException:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str3 = "onRecordSpareAdFailed Exception:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    private void m39054a(C6921b c6921b, ApiStatisticsReq apiStatisticsReq) {
        c6921b.m38827ak("65");
        c6921b.m38941a(AbstractC7741ao.m47545a("yyyy-MM-dd HH:mm:ss.SSSZ").format(new Date(apiStatisticsReq.m39372e())));
        c6921b.m39037r(AbstractC7806cz.m48170d(apiStatisticsReq.m39374g()));
        c6921b.m38884A(apiStatisticsReq.m39357a());
        c6921b.m38886B(apiStatisticsReq.m39362b());
        c6921b.m38991b(apiStatisticsReq.m39366c());
        c6921b.m38998c(apiStatisticsReq.m39369d());
        c6921b.m39039s(apiStatisticsReq.m39377j());
        c6921b.m39033p(apiStatisticsReq.m39380m());
        int iM39378k = apiStatisticsReq.m39378k();
        c6921b.m38936a(iM39378k);
        c6921b.m38850c(apiStatisticsReq.m39373f());
        m39163a(c6921b, apiStatisticsReq.m39381n());
        c6921b.m38894F(AbstractC7807d.m48241h(this.f31973a));
        c6921b.m38890D(AbstractC7807d.m48208a(this.f31973a, false));
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("AnalysisReport", "onApiStatisticsReport apiName: %s requestId: %s  requestType: %s adType: %s resultCode: %s  e2e: %s", c6921b.m38887C(), c6921b.m39038s(), Integer.valueOf(c6921b.m38909N()), c6921b.m39040t(), Integer.valueOf(c6921b.m38891E()), c6921b.m38953aK());
            AbstractC7185ho.m43818a("AnalysisReport", "onApiStatisticsReport, uuid: %s, uuid: %s", c6921b.m38899I(), c6921b.m38895G());
            AbstractC7185ho.m43818a("AnalysisReport", "rec engine cost time: %s", Long.valueOf(c6921b.m38846bi()));
            AbstractC7185ho.m43818a("AnalysisReport", "hms rec engine cost time: %s", Long.valueOf(c6921b.m38847bj()));
        }
        Context context = this.f31973a;
        new C7560ou(context, C7662sk.m47225a(context, iM39378k)).mo46609b(c6921b, false, true);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39066a(C6924e c6924e) {
        if (c6924e == null) {
            AbstractC7185ho.m43817a("AnalysisReport", "AutoOpenAnalysisData is null");
            return;
        }
        C6921b c6921bM39157a = m39157a(this.f31973a.getPackageName());
        c6921bM39157a.m38827ak("2100033");
        ContentRecord contentRecordM39146c = c6924e.m39146c();
        if (contentRecordM39146c != null) {
            m39154a(c6921bM39157a, contentRecordM39146c);
        }
        c6921bM39157a.m38828al(String.valueOf(c6924e.m39140a()));
        AppInfo appInfoM39145b = c6924e.m39145b();
        int iM39140a = c6924e.m39140a();
        if (iM39140a == 1) {
            m39055a(appInfoM39145b, c6921bM39157a);
        } else if (iM39140a == 2) {
            AppDownloadTask appDownloadTaskM39147d = c6924e.m39147d();
            c6921bM39157a.m38836at(c6924e.m39148e() ? "1" : "0");
            m39056a(appInfoM39145b, appDownloadTaskM39147d, c6921bM39157a, contentRecordM39146c);
        }
        Context context = this.f31973a;
        new C7560ou(context, C7662sk.m47225a(context, contentRecordM39146c.m41552f())).mo46609b(c6921bM39157a, false, true);
    }

    /* renamed from: a */
    public void m39067a(ApiStatisticsReq apiStatisticsReq) {
        StringBuilder sb2;
        String str;
        try {
            if (apiStatisticsReq == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onApiStatisticsReport, apiStatisticsReq is null ");
                return;
            }
            C6921b c6921bM39160a = m39160a(true, apiStatisticsReq.m39379l());
            if (c6921bM39160a == null) {
                return;
            }
            m39054a(c6921bM39160a, apiStatisticsReq);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onApiStatisticsReport RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "onApiStatisticsReport Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39068a(Content content, int i10, int i11) {
        try {
            C6921b c6921bM39158a = m39158a(this.f31973a.getPackageName(), true);
            c6921bM39158a.m38827ak("2100010");
            c6921bM39158a.m38898H(content.m39966h());
            c6921bM39158a.m38936a(i11);
            c6921bM39158a.m39033p(content.m39962g());
            c6921bM39158a.m38828al(String.valueOf(i10));
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39158a, false, false);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "onContentFilterException ex: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m39069a(ContentRecord contentRecord) {
        String str;
        if (contentRecord == null) {
            AbstractC7185ho.m43823c("AnalysisReport", "onPraise, contentRecord is null ");
            return;
        }
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("2100001");
            c6921bM39167f.m38998c(AbstractC7806cz.m48145a(contentRecord.m41450aB(), -1));
            Context context = this.f31973a;
            C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()));
            c7560ou.mo46590a(contentRecord);
            c7560ou.mo46609b(c6921bM39167f, false, true);
        } catch (RuntimeException unused) {
            str = "onPraise RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        } catch (Exception unused2) {
            str = "onPraise Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        }
    }

    /* renamed from: a */
    public void m39070a(ContentRecord contentRecord, int i10) {
        StringBuilder sb2;
        String str;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onStartSpareSplashAd, contentRecord is null.");
                return;
            }
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("105");
            c6921bM39159a.m39039s(contentRecord.m41486ah());
            c6921bM39159a.m38936a(contentRecord.m41552f());
            c6921bM39159a.m39031o(contentRecord.m41585m());
            c6921bM39159a.m39033p(contentRecord.m41588n());
            c6921bM39159a.m38898H(contentRecord.m41591o());
            c6921bM39159a.m38828al(String.valueOf(contentRecord.m41498at()));
            c6921bM39159a.m38998c(i10);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "onStartSpareSplashAd resultCode: %s", Integer.valueOf(i10));
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f())).mo46609b(c6921bM39159a, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onStartSpareSplashAd RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "onStartSpareSplashAd Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39071a(ContentRecord contentRecord, int i10, int i11) {
        StringBuilder sb2;
        String str;
        try {
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("119");
            C6921b c6921bM39154a = m39154a(c6921bM39159a, contentRecord);
            c6921bM39154a.m38998c(i10);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "onSpareSplashMediaPathChecked resultCode: %s", Integer.valueOf(i10));
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, i11), contentRecord).mo46609b(c6921bM39154a, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onSpareSplashMediaPathChecked RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "onSpareSplashMediaPathChecked Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39072a(ContentRecord contentRecord, int i10, int i11, String str) {
        StringBuilder sb2;
        String str2;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onContentOrentationError, contentRecord is null");
                return;
            }
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("108");
            c6921bM39167f.m39039s(str);
            c6921bM39167f.m38828al(String.valueOf(i10));
            c6921bM39167f.m38829am(String.valueOf(contentRecord.m41498at()));
            c6921bM39167f.m38830an(String.valueOf(i11));
            if ((contentRecord.m41419S() != null && contentRecord.m41419S().m40500m() == null) || (contentRecord.m41417R() != null && (contentRecord.m41417R().m40183d() == 0 || contentRecord.m41417R().m40185e() == 0))) {
                c6921bM39167f.m38998c(1);
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "onContentOrrentationError RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "onContentOrrentationError Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39073a(ContentRecord contentRecord, long j10, int i10) {
        String str;
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("142");
            VideoInfo videoInfoM41419S = contentRecord.m41419S();
            if (videoInfoM41419S != null) {
                long jM43922a = C7211ie.m43919a().m43922a(videoInfoM41419S.m40471a());
                c6921bM39167f.m38851d(videoInfoM41419S.m40481c());
                c6921bM39167f.m38852e(jM43922a);
            }
            c6921bM39167f.m38828al(AbstractC7806cz.m48153a(Integer.valueOf(i10)));
            AbstractC7185ho.m43820b("AnalysisReport", "adType is " + c6921bM39167f.m39040t());
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, true, true);
        } catch (RuntimeException unused) {
            str = "onVideoStreamError RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        } catch (Exception unused2) {
            str = "onVideoStreamError Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39074a(ContentRecord contentRecord, long j10, long j11) {
        mo39076a(contentRecord, j10, j11, (C6920a) null);
    }

    /* renamed from: a */
    public void m39075a(ContentRecord contentRecord, long j10, long j11, int i10) {
        if (contentRecord == null) {
            return;
        }
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            AbstractC7185ho.m43821b("AnalysisReport", "onVideoPlayEx, contentId: %s", contentRecord.m41588n());
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "onVideoPlayEx, waitingTime: %s, playedTime: %s", Long.valueOf(j10), Long.valueOf(j11));
            }
            c6921bM39167f.m38827ak("160");
            c6921bM39167f.m38850c(j10);
            c6921bM39167f.m38851d(j11);
            c6921bM39167f.m38828al(String.valueOf(i10));
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, true);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "onVideoPlayException ex: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39076a(ContentRecord contentRecord, long j10, long j11, C6920a c6920a) {
        StringBuilder sb2;
        String str;
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("86");
            c6921bM39167f.m38850c(j10);
            c6921bM39167f.m38851d(j11);
            if (contentRecord != null) {
                c6921bM39167f.m38828al(contentRecord.m41504az());
                c6921bM39167f.m38829am(String.valueOf(contentRecord.m41449aA()));
            }
            if (c6920a != null) {
                c6921bM39167f.m38830an(String.valueOf(c6920a.m38877g()));
                c6921bM39167f.m38831ao(c6920a.m38878h());
            }
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "onVideoStartTimeCost duration: %s, bufferingDuration: %s, fileSize:%s, sequence: %s, playMode: %s", Long.valueOf(c6921bM39167f.m38813aM()), Long.valueOf(c6921bM39167f.m38824aX()), c6921bM39167f.m38814aN(), c6921bM39167f.m38816aP(), c6921bM39167f.m38815aO());
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue())).mo46609b(c6921bM39167f, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onVideoStartTimeCost RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "onVideoStartTimeCost Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39077a(ContentRecord contentRecord, String str) {
        StringBuilder sb2;
        String str2;
        try {
            AbstractC7185ho.m43821b("AnalysisReport", "onPlacementAdDiscarded: %s", str);
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onPlacementAdDiscarded, contentRecord is null");
                return;
            }
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("2100035");
            c6921bM39167f.m39047w(str);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "onPlacementAdDiscarded RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "onPlacementAdDiscarded Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39078a(ContentRecord contentRecord, String str, C6920a c6920a) {
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onFullScreenNotifyAction, contentRecord is null.");
                return;
            }
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "onFullScreenNotifyAction, extraStr1: %s", str);
            }
            if (c6920a != null) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("AnalysisReport", "onFullScreenNotifyAction, extraStr2: %s, extraStr3: %s", c6920a.m38875e(), c6920a.m38876f());
                }
                c6921bM39152a.m38829am(c6920a.m38875e());
                c6921bM39152a.m38830an(c6920a.m38876f());
            }
            c6921bM39152a.m38827ak("126");
            c6921bM39152a.m38936a(contentRecord.m41552f());
            c6921bM39152a.m39031o(contentRecord.m41585m());
            c6921bM39152a.m39033p(contentRecord.m41588n());
            c6921bM39152a.m38898H(contentRecord.m41591o());
            c6921bM39152a.m38828al(str);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f())).mo46609b(c6921bM39152a, false, false);
        } catch (Exception e10) {
            AbstractC7185ho.m43823c("AnalysisReport", "onFullScreenNotifyAction Exception:" + e10.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m39079a(ContentRecord contentRecord, String str, AppDownloadTask appDownloadTask) {
        String str2;
        AppInfo appInfoM42222B;
        if (contentRecord == null) {
            AbstractC7185ho.m43823c("AnalysisReport", "onAppInstalled, contentRecord is null ");
            return;
        }
        try {
            C6921b c6921bM39153a = m39153a(contentRecord.m41492an());
            if (c6921bM39153a == null) {
                return;
            }
            c6921bM39153a.m38827ak("50");
            c6921bM39153a.m39031o(contentRecord.m41585m());
            c6921bM39153a.m39033p(contentRecord.m41588n());
            c6921bM39153a.m38936a(contentRecord.m41552f());
            c6921bM39153a.m39037r(String.valueOf(Process.myPid()));
            if (!TextUtils.isEmpty(str)) {
                c6921bM39153a.m38828al(str);
            }
            if (appDownloadTask != null && (appInfoM42222B = appDownloadTask.m42222B()) != null) {
                m39056a(appInfoM42222B, appDownloadTask, c6921bM39153a, contentRecord);
            }
            Context context = this.f31973a;
            C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()));
            c7560ou.mo46590a(contentRecord);
            c7560ou.mo46609b(c6921bM39153a, false, true);
        } catch (RuntimeException unused) {
            str2 = "onAppInstalled RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        } catch (Exception unused2) {
            str2 = "onAppInstalled Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        }
    }

    /* renamed from: a */
    public void m39080a(ContentRecord contentRecord, String str, String str2) {
        String str3;
        try {
            AbstractC7185ho.m43820b("AnalysisReport", "report write channel info");
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onWriteChannelInfo, contentRecord is null");
                return;
            }
            String strM41585m = contentRecord.m41585m();
            String strM41588n = contentRecord.m41588n();
            int iM41552f = contentRecord.m41552f();
            C6921b c6921bM39153a = m39153a(contentRecord.m41492an());
            if (c6921bM39153a == null) {
                return;
            }
            c6921bM39153a.m38827ak("40");
            c6921bM39153a.m39031o(strM41585m);
            c6921bM39153a.m39033p(strM41588n);
            c6921bM39153a.m38936a(iM41552f);
            c6921bM39153a.m38828al(str2);
            if (!TextUtils.isEmpty(str)) {
                c6921bM39153a.m39037r(str);
            }
            Context context = this.f31973a;
            C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, iM41552f));
            c7560ou.mo46590a(contentRecord);
            c7560ou.mo46609b(c6921bM39153a, true, true);
        } catch (RuntimeException unused) {
            str3 = "reportDialogActionEvent RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str3);
        } catch (Exception unused2) {
            str3 = "reportDialogActionEvent Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str3);
        }
    }

    /* renamed from: a */
    public void m39081a(ContentRecord contentRecord, String str, String str2, String str3) {
        String str4;
        JSONObject jSONObject;
        try {
            AbstractC7185ho.m43820b("AnalysisReport", "report read channel info");
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onReadChannelInfo, contentRecord is null");
                return;
            }
            String strM41585m = contentRecord.m41585m();
            String strM41588n = contentRecord.m41588n();
            int iM41552f = contentRecord.m41552f();
            C6921b c6921bM39153a = m39153a(contentRecord.m41492an());
            if (c6921bM39153a == null) {
                return;
            }
            c6921bM39153a.m38827ak("71");
            c6921bM39153a.m39031o(strM41585m);
            c6921bM39153a.m39033p(strM41588n);
            c6921bM39153a.m38936a(iM41552f);
            c6921bM39153a.m38828al(str3);
            c6921bM39153a.m39051y(AbstractC7807d.m48250m(this.f31973a));
            if (!TextUtils.isEmpty(str)) {
                c6921bM39153a.m39037r(str);
                try {
                    jSONObject = new JSONObject(AbstractC7806cz.m48168c(str));
                } catch (JSONException unused) {
                    AbstractC7185ho.m43823c("AnalysisReport", "transfer channel info to json error");
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    c6921bM39153a.m38829am(AbstractC7806cz.m48170d(jSONObject.optString("channelId")));
                }
            }
            c6921bM39153a.m38830an(AbstractC7806cz.m48170d(str2));
            Context context = this.f31973a;
            C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, iM41552f));
            c7560ou.mo46590a(contentRecord);
            c7560ou.mo46609b(c6921bM39153a, true, true);
        } catch (RuntimeException unused2) {
            str4 = "onReadChannelInfo RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str4);
        } catch (Exception unused3) {
            str4 = "onReadChannelInfo Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str4);
        }
    }

    /* renamed from: a */
    public void m39082a(AdLandingPageData adLandingPageData) {
        String str;
        try {
            if (adLandingPageData == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onLandingPageBlocked, data is null");
                return;
            }
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38827ak("34");
            C6921b c6921bM39155a = m39155a(c6921bM39152a, adLandingPageData);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, adLandingPageData.getAdType())).mo46609b(c6921bM39155a, false, true);
        } catch (RuntimeException unused) {
            str = "onPlacementPlayError RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        } catch (Exception unused2) {
            str = "onPlacementPlayError Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        }
    }

    /* renamed from: a */
    private void m39055a(AppInfo appInfo, C6921b c6921b) {
        if (appInfo != null) {
            c6921b.m38829am(appInfo.getPriorInstallWay());
            c6921b.m38830an(appInfo.m44432v());
        }
        c6921b.m38832ap(C7124fh.m43316b(this.f31973a).mo43397bX() ? "1" : "0");
    }

    /* renamed from: a */
    private void m39056a(AppInfo appInfo, AppDownloadTask appDownloadTask, C6921b c6921b, ContentRecord contentRecord) {
        if (appInfo != null) {
            c6921b.m38829am(String.valueOf(appInfo.m44383c()));
            c6921b.m38832ap(C7124fh.m43316b(this.f31973a).mo43397bX() ? "1" : "0");
        }
        if (appDownloadTask != null) {
            c6921b.m38830an(appDownloadTask.m42242V() ? "1" : "0");
            c6921b.m38831ao(appDownloadTask.m42231K() ? "1" : "0");
            String strM42235O = appDownloadTask.m42235O();
            if (strM42235O == null && contentRecord != null) {
                strM42235O = contentRecord.m41577k();
            }
            c6921b.m38833aq(strM42235O);
            c6921b.m38834ar(appDownloadTask.mo42082n());
            c6921b.m38835as(C7831j.m48459a(appInfo, Boolean.valueOf(appDownloadTask.m42242V())) ? "1" : "0");
        }
    }

    /* renamed from: a */
    public void m39083a(C7587b c7587b, ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("2100004");
            c6921bM39167f.m38828al(c7587b.m46888b());
            c6921bM39167f.m38829am(AbstractC7758be.m47742b(c7587b));
            MaterialClickInfo materialClickInfoM46894h = c7587b.m46894h();
            if (materialClickInfoM46894h != null && materialClickInfoM46894h.m44517h() != null && materialClickInfoM46894h.m44518i() != null) {
                c6921bM39167f.m38850c(materialClickInfoM46894h.m44517h().longValue() - materialClickInfoM46894h.m44518i().longValue());
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, false);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "onInvlidClickReport ex: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39084a(C7653sb c7653sb) {
        if (c7653sb != null) {
            try {
                if (c7653sb.m47197l() != null) {
                    ContentRecord contentRecordM47197l = c7653sb.m47197l();
                    C6921b c6921bM39167f = m39167f(contentRecordM47197l);
                    if (c6921bM39167f == null) {
                        AbstractC7185ho.m43820b("AnalysisReport", "reportNetHandlerDownloadSourceFail, AnalysisInfo is null");
                        return;
                    }
                    c6921bM39167f.m38827ak("2100030");
                    AbstractC7185ho.m43821b("AnalysisReport", "fail to download Source, failReason: %s", c7653sb.m47182c());
                    c6921bM39167f.m38998c(c7653sb.m47175b().intValue());
                    c6921bM39167f.m39047w(c7653sb.m47182c());
                    c6921bM39167f.m38828al(c7653sb.m47194i());
                    c6921bM39167f.m38829am(c7653sb.m47189e());
                    c6921bM39167f.m38851d(System.currentTimeMillis());
                    Context context = this.f31973a;
                    new C7560ou(context, C7662sk.m47225a(context, contentRecordM47197l.m41552f()), contentRecordM47197l).mo46609b(c6921bM39167f, false, false);
                    return;
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("AnalysisReport", "reportNetHandlerDownloadSourceFail err: %s.", th2.getClass().getSimpleName());
                return;
            }
        }
        AbstractC7185ho.m43820b("AnalysisReport", "reportNetHandlerDownloadSourceFail, params invalid");
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39085a(C7692tn c7692tn, String str) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.analysis.c.2

            /* renamed from: a */
            final /* synthetic */ C7692tn f31937a;

            /* renamed from: b */
            final /* synthetic */ String f31938b;

            public AnonymousClass2(C7692tn c7692tn2, String str2) {
                c7692tn = c7692tn2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    C6922c c6922c = C6922c.this;
                    C6921b c6921bM39157a = c6922c.m39157a(c6922c.f31973a.getPackageName());
                    c6921bM39157a.m38827ak("180");
                    c6921bM39157a.m38898H(c7692tn.m47263c());
                    c6921bM39157a.m39033p(c7692tn.m47261b());
                    c6921bM39157a.m38936a(c7692tn.m47258a());
                    c6921bM39157a.m38828al(c7692tn.m47264d());
                    c6921bM39157a.m38829am(c7692tn.m47265e());
                    c6921bM39157a.m38830an(str);
                    AbstractC7185ho.m43824c("AnalysisReport", "start activity error %s", str);
                    Context context = C6922c.this.f31973a;
                    new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39157a, false, false);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("AnalysisReport", "onStartActivityException ex: %s", th2.getClass().getSimpleName());
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39086a(C9407c c9407c) {
        if (c9407c == null) {
            return;
        }
        try {
            C6921b c6921bM39158a = m39158a(c9407c.m59006v(), true);
            c6921bM39158a.m38827ak(c9407c.m58995k());
            c6921bM39158a.m38828al(c9407c.m58996l());
            c6921bM39158a.m38829am(c9407c.m58998n());
            c6921bM39158a.m38830an(c9407c.m58999o());
            c6921bM39158a.m38831ao(c9407c.m59000p());
            c6921bM39158a.m38832ap(c9407c.m59001q());
            c6921bM39158a.m38833aq(c9407c.m59002r());
            c6921bM39158a.m38834ar(c9407c.m59003s());
            c6921bM39158a.m38835as(c9407c.m59004t());
            c6921bM39158a.m38836at(c9407c.m59005u());
            c6921bM39158a.m38837au(c9407c.m58997m());
            c6921bM39158a.m38936a(c9407c.m58994j());
            c6921bM39158a.m39003d(c9407c.m59007w());
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39158a, false, false);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "onEventProcessCallBackFromRecEngine ex: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m39087a(String str, int i10) {
        StringBuilder sb2;
        String str2;
        try {
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38936a(i10);
            c6921bM39159a.m38827ak("85");
            c6921bM39159a.m39031o(str);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, i10)).mo46609b(c6921bM39159a, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "onSplashDismissForExSplash RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "onSplashDismissForExSplash Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39088a(String str, int i10, int i11, int i12, String str2) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.analysis.c.3

            /* renamed from: a */
            final /* synthetic */ String f31940a;

            /* renamed from: b */
            final /* synthetic */ String f31941b;

            /* renamed from: c */
            final /* synthetic */ int f31942c;

            /* renamed from: d */
            final /* synthetic */ int f31943d;

            /* renamed from: e */
            final /* synthetic */ int f31944e;

            public AnonymousClass3(String str22, String str3, int i102, int i112, int i122) {
                str = str22;
                str = str3;
                i = i102;
                i = i112;
                i = i122;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    C6922c c6922c = C6922c.this;
                    C6921b c6921bM39158a = c6922c.m39158a(c6922c.f31973a.getPackageName(), true);
                    c6921bM39158a.m38827ak(str);
                    c6921bM39158a.m38828al(String.valueOf(str));
                    c6921bM39158a.m38829am(String.valueOf(i));
                    c6921bM39158a.m38830an(String.valueOf(i));
                    c6921bM39158a.m38831ao(String.valueOf(i));
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("AnalysisReport", "update database name is %s, exception type is %s, oldVersion is %s, newVersion is %s, upgradeFlag is %s", str, str, Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i));
                    }
                    Context context = C6922c.this.f31973a;
                    new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39158a, false, false);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("AnalysisReport", "update database exception: %s", th2.getClass().getSimpleName());
                }
            }
        });
    }

    /* renamed from: a */
    public void m39089a(String str, int i10, int i11, ContentRecord contentRecord) {
        String str2;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onPlacementPlayError, contentRecord is null");
                return;
            }
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38827ak("11");
            C6921b c6921bM39154a = m39154a(c6921bM39152a, contentRecord);
            c6921bM39154a.m39035q(str);
            c6921bM39154a.m39037r("errorcode:" + i10 + ", extra:" + i11);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39154a.m39040t().intValue()), contentRecord).mo46609b(c6921bM39154a, false, true);
        } catch (RuntimeException unused) {
            str2 = "onPlacementPlayError RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        } catch (Exception unused2) {
            str2 = "onPlacementPlayError Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39090a(String str, int i10, ContentRecord contentRecord) {
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m39039s(contentRecord.m41486ah());
            c6921bM39167f.m38827ak("2100026");
            c6921bM39167f.m38828al(str);
            c6921bM39167f.m38829am(AbstractC7806cz.m48153a(Integer.valueOf(i10)));
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39167f, false, true);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "reportNoMzUrl err: %s.", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m39091a(String str, int i10, String str2, ContentRecord contentRecord, boolean z10) {
        StringBuilder sb2;
        String str3;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onImageLoadFailed, contentRecord is null");
                return;
            }
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("104");
            c6921bM39167f.m39035q(str);
            c6921bM39167f.m38998c(i10);
            c6921bM39167f.m39037r(str2);
            c6921bM39167f.m38828al(str2);
            c6921bM39167f.m38829am(Constants.NORMAL_CACHE);
            c6921bM39167f.m38830an(String.valueOf(z10));
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str3 = "onImageLoadFailed RuntimeException:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str3 = "onImageLoadFailed Exception:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39092a(String str, int i10, String str2, String str3) {
        StringBuilder sb2;
        String str4;
        try {
            AbstractC7185ho.m43817a("AnalysisReport", "onExLinkedNotShow");
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("82");
            c6921bM39159a.m38936a(i10);
            c6921bM39159a.m39019i(str);
            c6921bM39159a.m39031o(str2);
            c6921bM39159a.m39033p(str3);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, i10)).mo46609b(c6921bM39159a, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str4 = "onExLinkedNotShow RuntimeException:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str4 = "onExLinkedNotShow Exception:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39093a(String str, int i10, String str2, String str3, long j10) {
        StringBuilder sb2;
        String str4;
        try {
            AbstractC7185ho.m43817a("AnalysisReport", "onExLinkedOvertime");
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("83");
            c6921bM39159a.m38936a(i10);
            c6921bM39159a.m39019i(str);
            c6921bM39159a.m39031o(str2);
            c6921bM39159a.m39033p(str3);
            c6921bM39159a.m38851d(j10);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, i10)).mo46609b(c6921bM39159a, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str4 = "onExLinkedOvertime RuntimeException:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str4 = "onExLinkedOvertime Exception:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39094a(String str, int i10, String str2, String str3, String str4, boolean z10) {
        StringBuilder sb2;
        String str5;
        try {
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("101");
            c6921bM39159a.m38936a(i10);
            c6921bM39159a.m39033p(str4);
            c6921bM39159a.m38828al(str);
            c6921bM39159a.m39039s(str2);
            c6921bM39159a.m38831ao(str3);
            c6921bM39159a.m38991b(z10 ? 1 : 0);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "rptEvent, eventType: %s, result: %s", str, Integer.valueOf(c6921bM39159a.m38889D()));
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, i10)).mo46609b(c6921bM39159a, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str5 = "onAdEventUpload RuntimeException:";
            sb2.append(str5);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str5 = "onAdEventUpload Exception:";
            sb2.append(str5);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39095a(String str, long j10) {
        try {
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("143");
            c6921bM39159a.m38828al(String.valueOf(j10));
            c6921bM39159a.m38830an(str);
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39159a, false, false);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "onDbSizeReport ex: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m39096a(String str, long j10, String str2, String str3, int i10) {
        String str4;
        try {
            AbstractC7185ho.m43820b("AnalysisReport", "onAidlCalledResult:" + str);
            if (TextUtils.isEmpty(str)) {
                AbstractC7185ho.m43823c("AnalysisReport", "onAidlCalledResult, exceptionType is null");
                return;
            }
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38827ak(str);
            c6921bM39152a.m38850c(j10);
            c6921bM39152a.m39047w(str2);
            c6921bM39152a.m39037r(str3);
            c6921bM39152a.m39051y(AbstractC7807d.m48250m(this.f31973a));
            c6921bM39152a.m38936a(i10);
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39152a, false, true);
        } catch (RuntimeException unused) {
            str4 = "onAidlCalledResult RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str4);
        } catch (Exception unused2) {
            str4 = "onAidlCalledResult Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str4);
        }
    }

    /* renamed from: a */
    public void m39097a(String str, C6921b c6921b) {
        try {
            C6921b c6921bM39158a = m39158a("", true);
            if (c6921bM39158a == null) {
                return;
            }
            c6921bM39158a.m38827ak("2100002");
            c6921bM39158a.m38828al(c6921b.m38814aN());
            c6921bM39158a.m38829am(c6921b.m38815aO());
            c6921bM39158a.m38830an(c6921b.m38816aP());
            c6921bM39158a.m38831ao(c6921b.m38817aQ());
            c6921bM39158a.m38832ap(c6921b.m38818aR());
            c6921bM39158a.m38833aq(c6921b.m38819aS());
            c6921bM39158a.m38834ar(c6921b.m38820aT());
            c6921bM39158a.m38835as(c6921b.m38821aU());
            c6921bM39158a.m38836at(c6921b.m38822aV());
            AbstractC7185ho.m43818a("AnalysisReport", "remaining app data: %s", c6921b.m38816aP());
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).m46586a(c6921bM39158a);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "onCacheRecordCollected ex: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m39098a(String str, ApiStatisticsReq apiStatisticsReq) {
        StringBuilder sb2;
        String str2;
        try {
            if (apiStatisticsReq == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onApiStatisticsReport, apiStatisticsReq is null ");
                return;
            }
            C6921b c6921bM39158a = m39158a(str, true);
            if (c6921bM39158a == null) {
                return;
            }
            c6921bM39158a.m39003d(apiStatisticsReq.m39379l());
            m39054a(c6921bM39158a, apiStatisticsReq);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "onApiStatisticsReport RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "onApiStatisticsReport Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39099a(String str, ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("2100003");
            c6921bM39167f.m38828al(str);
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39167f, false, false);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "onShareClickReport ex: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m39100a(String str, ContentRecord contentRecord, int i10, String str2, String str3) {
        StringBuilder sb2;
        String str4;
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("88");
            c6921bM39167f.m38886B(str2);
            c6921bM39167f.m39037r(str3);
            c6921bM39167f.m38998c(i10);
            c6921bM39167f.m38828al(AbstractC7807d.m48251n(this.f31973a));
            c6921bM39167f.m38829am(AbstractC7807d.m48252o(this.f31973a));
            c6921bM39167f.m38830an(str);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "onAgApiCalled additionInfo: %s apiName: %s, statusCode: %s, exception: %s, trackVersion: %s", str3, str2, Integer.valueOf(i10), "88", c6921bM39167f.m38951aI());
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str4 = "onAgApiCalled RuntimeException:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str4 = "onAgApiCalled Exception:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39101a(String str, ContentRecord contentRecord, boolean z10) {
        StringBuilder sb2;
        String str2;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onAdEventAddToCache, contentRecord is null.");
                return;
            }
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("100");
            int iM41552f = contentRecord.m41552f();
            c6921bM39159a.m38936a(iM41552f);
            c6921bM39159a.m39033p(contentRecord.m41588n());
            c6921bM39159a.m39039s(contentRecord.m41486ah());
            if (contentRecord.m41529bp() != null) {
                c6921bM39159a.m38973aj(contentRecord.m41529bp());
            }
            c6921bM39159a.m39003d(contentRecord.m41492an());
            c6921bM39159a.m38828al(str);
            c6921bM39159a.m38831ao(contentRecord.m41577k());
            c6921bM39159a.m38991b(z10 ? 1 : 0);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "cacheEvent, eventType: %s, result: %s", str, Integer.valueOf(c6921bM39159a.m38889D()));
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, iM41552f)).mo46609b(c6921bM39159a, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "onAdEventAddToCache RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "onAdEventAddToCache Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39102a(String str, Integer num, String str2, ContentRecord contentRecord, boolean z10) {
        StringBuilder sb2;
        String str3;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onAdEventFilter, contentRecord is null.");
                return;
            }
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("99");
            int iM41552f = contentRecord.m41552f();
            c6921bM39159a.m38936a(iM41552f);
            c6921bM39159a.m39033p(contentRecord.m41588n());
            c6921bM39159a.m39039s(contentRecord.m41486ah());
            if (contentRecord.m41529bp() != null) {
                c6921bM39159a.m38973aj(contentRecord.m41529bp());
            }
            c6921bM39159a.m39003d(contentRecord.m41492an());
            c6921bM39159a.m38828al(str);
            if (num != null) {
                c6921bM39159a.m38829am(num.toString());
            }
            c6921bM39159a.m38830an(str2);
            c6921bM39159a.m38831ao(contentRecord.m41577k());
            c6921bM39159a.m38991b(z10 ? 1 : 0);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "filterEvent eventType: %s, result: %s", str, Integer.valueOf(c6921bM39159a.m38889D()));
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, iM41552f)).mo46609b(c6921bM39159a, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str3 = "onAdEventFilter RuntimeException:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str3 = "onAdEventFilter Exception:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39103a(String str, String str2, DelayInfo delayInfo, int i10, int i11) {
        ApiStatisticsReq apiStatisticsReq = new ApiStatisticsReq();
        apiStatisticsReq.m39365b(str);
        apiStatisticsReq.m39371d(str2);
        apiStatisticsReq.m39360a(delayInfo);
        apiStatisticsReq.m39363b(i11);
        apiStatisticsReq.m39367c(i10);
        if (delayInfo != null && delayInfo.m40025F() != null) {
            apiStatisticsReq.m39370d(delayInfo.m40025F().intValue());
        }
        m39067a(apiStatisticsReq);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39104a(String str, String str2, ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        try {
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("2100013");
            c6921bM39167f.m38828al(str);
            c6921bM39167f.m38829am(str2);
            c6921bM39167f.m38830an(contentRecord.m41463aO());
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39167f, false, true);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "loadInterstitialTemplate err: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m39105a(String str, String str2, String str3, long j10, ContentRecord contentRecord) {
        StringBuilder sb2;
        String str4;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onUploadThirdPartyEventSuccess, contentRecord is null");
                return;
            }
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("19");
            c6921bM39167f.m39045v(new URL(str2).getHost());
            c6921bM39167f.m39039s(str3);
            if (contentRecord.m41529bp() != null) {
                c6921bM39167f.m38973aj(contentRecord.m41529bp());
            }
            c6921bM39167f.m38850c(j10);
            c6921bM39167f.m38828al(str);
            c6921bM39167f.m39033p(contentRecord.m41588n());
            c6921bM39167f.m38898H(contentRecord.m41591o());
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f())).m46587a(c6921bM39167f, true, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str4 = "onUploadThirdPartyEventSuccess RuntimeException:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str4 = "onUploadThirdPartyEventSuccess Exception:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39106a(String str, String str2, String str3, AdLandingPageData adLandingPageData) {
        StringBuilder sb2;
        String str4;
        try {
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38827ak("22");
            c6921bM39152a.m39037r(str3);
            c6921bM39152a.m39047w(str2);
            c6921bM39152a.m39035q(str);
            C6921b c6921bM39155a = m39155a(c6921bM39152a, adLandingPageData);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39155a.m39040t().intValue())).mo46609b(c6921bM39155a, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str4 = "onLandPageOpenFail RuntimeException:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str4 = "onLandPageOpenFail Exception:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39107a(String str, String str2, String str3, String str4, long j10, ContentRecord contentRecord) {
        StringBuilder sb2;
        String str5;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onUploadThirdPartyEventFail, contentRecord is null");
                return;
            }
            C6921b c6921bM39160a = m39160a(true, contentRecord.m41492an());
            if (c6921bM39160a == null) {
                return;
            }
            String strM41585m = contentRecord.m41585m();
            String strM41588n = contentRecord.m41588n();
            int iM41552f = contentRecord.m41552f();
            c6921bM39160a.m39031o(strM41585m);
            c6921bM39160a.m39033p(strM41588n);
            c6921bM39160a.m38936a(iM41552f);
            c6921bM39160a.m38827ak("9");
            c6921bM39160a.m39047w(str3);
            c6921bM39160a.m39045v(new URL(str2).getHost());
            c6921bM39160a.m39039s(str4);
            if (contentRecord.m41529bp() != null) {
                c6921bM39160a.m38973aj(contentRecord.m41529bp());
            }
            c6921bM39160a.m38850c(j10);
            c6921bM39160a.m38828al(str);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, iM41552f)).m46587a(c6921bM39160a, true, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str5 = "onUploadThirdPartyEventFail RuntimeException:";
            sb2.append(str5);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str5 = "onUploadThirdPartyEventFail Exception:";
            sb2.append(str5);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39108a(String str, String str2, boolean z10) {
        String str3;
        try {
            AbstractC7185ho.m43817a("AnalysisReport", "onDownloadImg, contentId:" + str2 + ", succ:" + z10);
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38827ak("10");
            c6921bM39152a.m39037r("download success:" + z10);
            c6921bM39152a.m39033p(str2);
            c6921bM39152a.m39031o(str);
            c6921bM39152a.m38936a(2);
            c6921bM39152a.m38828al(z10 ? "1" : "0");
            AbstractC7185ho.m43818a("AnalysisReport", "report [TYPE_DOWNLOAD_IMG],contentId: %s, exception: exception_%s,additionInfo: %s, extraStr1: %s", str2, c6921bM39152a.m38812aL(), c6921bM39152a.m39036r(), c6921bM39152a.m38814aN());
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39152a.m39040t().intValue())).mo46609b(c6921bM39152a, true, false);
        } catch (RuntimeException unused) {
            str3 = "onDownloadImg RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str3);
        } catch (Exception unused2) {
            str3 = "onException Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str3);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39109a(String str, List<String> list, List<String> list2, Map<String, String> map, String str2) {
        try {
            C6921b c6921bM39158a = m39158a(str, true);
            c6921bM39158a.m39039s(str2);
            c6921bM39158a.m38827ak("2100006");
            c6921bM39158a.m38828al(AbstractC7806cz.m48156a(list, ","));
            c6921bM39158a.m38829am(AbstractC7806cz.m48156a(list2, ","));
            c6921bM39158a.m38830an(AbstractC7836o.m48492a(AbstractC7758be.m47742b(map).getBytes(Constants.UTF_8)));
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39158a, false, false);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "onTagReport ex: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39110a(Throwable th2) {
        StringBuilder sb2;
        String str;
        try {
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38827ak("1");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(th2.getClass().getSimpleName());
            sb3.append(",");
            sb3.append(th2.getMessage());
            sb3.append(",");
            for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                sb3.append(stackTraceElement.toString());
                sb3.append(",");
            }
            c6921bM39152a.m39037r(sb3.toString());
            c6921bM39152a.m38936a(-1);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, -1)).mo46609b(c6921bM39152a, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onAnalysis RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "onAnalysis Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7002cs
    /* renamed from: a */
    public void mo39111a(List<ContentRecord> list) {
        if (AbstractC7760bg.m47767a(list)) {
            AbstractC7185ho.m43817a("AnalysisReport", "recall records empty");
            return;
        }
        int size = list.size();
        AbstractC7185ho.m43821b("AnalysisReport", "report client recall, size: %s", Integer.valueOf(size));
        int i10 = 0;
        while (i10 < size) {
            try {
                ContentRecord contentRecord = list.get(i10);
                C6921b c6921bM39167f = m39167f(contentRecord);
                if (c6921bM39167f != null) {
                    c6921bM39167f.m38827ak("170");
                    c6921bM39167f.m38828al(Constants.EXTRA_CLIENT_RECALL);
                    Context context = this.f31973a;
                    new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, i10 == size + (-1), false);
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("AnalysisReport", "onRecallContentReport ex: %s", th2.getClass().getSimpleName());
            }
            i10++;
        }
    }
}
