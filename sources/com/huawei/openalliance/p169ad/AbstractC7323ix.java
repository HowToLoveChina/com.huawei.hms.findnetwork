package com.huawei.openalliance.p169ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.InterfaceC5110e;
import com.huawei.hms.ads.uiengine.common.IMediaStateApiTransfer;
import com.huawei.openalliance.p169ad.analysis.C6920a;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.analysis.C6923d;
import com.huawei.openalliance.p169ad.analysis.C6927h;
import com.huawei.openalliance.p169ad.beans.inner.AdContentData;
import com.huawei.openalliance.p169ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.AdLoadState;
import com.huawei.openalliance.p169ad.constant.AdShowExtras;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.constant.Scheme;
import com.huawei.openalliance.p169ad.inter.C7288c;
import com.huawei.openalliance.p169ad.inter.HiAdSplash;
import com.huawei.openalliance.p169ad.inter.IHiAdSplash;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.RewardVerifyConfig;
import com.huawei.openalliance.p169ad.inter.listeners.AdActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.AdListener;
import com.huawei.openalliance.p169ad.inter.listeners.AdShowListener;
import com.huawei.openalliance.p169ad.inter.listeners.LinkedAdListener;
import com.huawei.openalliance.p169ad.opendeviceidentifier.OAIDServiceManager;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7802cv;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7753b;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.views.PPSSplashView;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.openalliance.ad.ix */
/* loaded from: classes8.dex */
public abstract class AbstractC7323ix implements InterfaceC7328jb, InterfaceC7621qw {

    /* renamed from: M */
    private static long f34029M;

    /* renamed from: A */
    private AdActionListener f34030A;

    /* renamed from: B */
    private AdShowListener f34031B;

    /* renamed from: C */
    private String f34032C;

    /* renamed from: D */
    private ContentRecord f34033D;

    /* renamed from: K */
    private C7640rp f34040K;

    /* renamed from: L */
    private InterfaceC7615qq f34041L;

    /* renamed from: O */
    private int f34043O;

    /* renamed from: P */
    private C6922c f34044P;

    /* renamed from: a */
    protected WeakReference<InterfaceC8121n> f34046a;

    /* renamed from: b */
    protected AdLoadState f34047b;

    /* renamed from: c */
    protected InterfaceC7146gc f34048c;

    /* renamed from: d */
    protected InterfaceC7135fs f34049d;

    /* renamed from: e */
    protected InterfaceC7615qq f34050e;

    /* renamed from: k */
    protected ContentRecord f34056k;

    /* renamed from: m */
    protected RewardVerifyConfig f34058m;

    /* renamed from: n */
    protected int f34059n;

    /* renamed from: o */
    protected Context f34060o;

    /* renamed from: p */
    private WeakReference<InterfaceC8119l> f34061p;

    /* renamed from: r */
    private AdListener f34063r;

    /* renamed from: s */
    private InterfaceC7610ql f34064s;

    /* renamed from: t */
    private CountDownTimer f34065t;

    /* renamed from: q */
    private InterfaceC7416lz f34062q = new C7405lo();

    /* renamed from: f */
    protected boolean f34051f = false;

    /* renamed from: u */
    private boolean f34066u = false;

    /* renamed from: v */
    private boolean f34067v = false;

    /* renamed from: g */
    protected boolean f34052g = false;

    /* renamed from: w */
    private boolean f34068w = false;

    /* renamed from: h */
    protected final String f34053h = "load_timeout_" + hashCode();

    /* renamed from: x */
    private boolean f34069x = false;

    /* renamed from: y */
    private boolean f34070y = false;

    /* renamed from: z */
    private boolean f34071z = false;

    /* renamed from: i */
    protected long f34054i = 0;

    /* renamed from: E */
    private int f34034E = 0;

    /* renamed from: F */
    private long f34035F = -1;

    /* renamed from: j */
    protected boolean f34055j = false;

    /* renamed from: l */
    protected DelayInfo f34057l = new DelayInfo();

    /* renamed from: G */
    private boolean f34036G = false;

    /* renamed from: H */
    private boolean f34037H = false;

    /* renamed from: I */
    private boolean f34038I = false;

    /* renamed from: J */
    private boolean f34039J = false;

    /* renamed from: N */
    private long f34042N = 0;

    /* renamed from: Q */
    private long f34045Q = 0;

    /* renamed from: com.huawei.openalliance.ad.ix$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AbstractC7323ix abstractC7323ix = AbstractC7323ix.this;
                abstractC7323ix.f34040K = new C7640rp(abstractC7323ix.f34060o);
                AbstractC7323ix.this.f34040K.m47107a();
                InterfaceC5110e interfaceC5110eM42838b = C7084e.m42838b();
                if (interfaceC5110eM42838b != null) {
                    interfaceC5110eM42838b.mo30522a(AbstractC7323ix.this.f34059n, (Bundle) null);
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43821b(AbstractC7323ix.this.mo45199z(), "inform err: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ix$10 */
    public class AnonymousClass10 extends OAIDServiceManager.OaidResultCallback {

        /* renamed from: a */
        final /* synthetic */ AdSlotParam f34073a;

        /* renamed from: b */
        final /* synthetic */ Context f34074b;

        public AnonymousClass10(AdSlotParam adSlotParam, Context context) {
            adSlotParam = adSlotParam;
            context = context;
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: a */
        public void mo44091a() {
            AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "onOaidAcquireFailed");
            AbstractC7323ix.this.m45123a(adSlotParam);
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: b */
        public int mo44093b() {
            return AbstractC7323ix.this.f34059n;
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: a */
        public void mo44092a(String str, boolean z10) {
            AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "onOaidAcquired");
            adSlotParam.m40635a(str);
            adSlotParam.m40633a(Boolean.valueOf(z10));
            AbstractC7323ix.this.m45123a(adSlotParam);
            AbstractC7807d.m48211a(context, str, z10);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ix$11 */
    public class AnonymousClass11 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f34076a;

        /* renamed from: b */
        final /* synthetic */ AdSlotParam f34077b;

        public AnonymousClass11(long j10, AdSlotParam adSlotParam) {
            j = j10;
            adSlotParam = adSlotParam;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "doAdRequest " + jCurrentTimeMillis);
            AbstractC7323ix.this.f34057l.m40045d(jCurrentTimeMillis - j);
            AbstractC7323ix.this.f34032C = AbstractC7741ao.m47539a();
            adSlotParam.m40642b(AbstractC7323ix.this.f34032C);
            InterfaceC7610ql interfaceC7610ql = AbstractC7323ix.this.f34064s;
            AbstractC7323ix abstractC7323ix = AbstractC7323ix.this;
            AbstractC7323ix.this.m45125a(interfaceC7610ql.mo46329a(abstractC7323ix.f34060o, adSlotParam, abstractC7323ix.f34059n), jCurrentTimeMillis);
            AbstractC7323ix.this.m45112G();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ix$12 */
    public class AnonymousClass12 implements Runnable {
        public AnonymousClass12() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IHiAdSplash hiAdSplash = HiAdSplash.getInstance(AbstractC7323ix.this.f34060o);
            if (hiAdSplash instanceof HiAdSplash) {
                HiAdSplash hiAdSplash2 = (HiAdSplash) hiAdSplash;
                long jMo43414bo = AbstractC7323ix.this.f34048c.mo43414bo();
                long jM44088a = hiAdSplash2.m44088a();
                long jCurrentTimeMillis = System.currentTimeMillis() - jM44088a;
                AbstractC7323ix abstractC7323ix = AbstractC7323ix.this;
                if (jCurrentTimeMillis >= jMo43414bo) {
                    if (abstractC7323ix.f34059n == 1) {
                        hiAdSplash2.preloadAd();
                        return;
                    } else {
                        hiAdSplash2.preloadSmartScreenAd();
                        return;
                    }
                }
                AbstractC7185ho.m43820b(abstractC7323ix.mo45199z(), "request time limit, timeInter=" + jMo43414bo + ", lastTime=" + jM44088a);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ix$13 */
    public class AnonymousClass13 implements InterfaceC7609qk {

        /* renamed from: com.huawei.openalliance.ad.ix$13$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ long f34081a;

            /* renamed from: b */
            final /* synthetic */ ContentRecord f34082b;

            public AnonymousClass1(long j10, ContentRecord contentRecord) {
                j = j10;
                contentRecord = contentRecord;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7323ix abstractC7323ix;
                AbstractC7323ix.this.f34057l.m40054g(AbstractC7741ao.m47566c() - j);
                ContentRecord contentRecord = contentRecord;
                if (contentRecord != null) {
                    abstractC7323ix = AbstractC7323ix.this;
                    abstractC7323ix.f34051f = true;
                } else {
                    if (AbstractC7323ix.this.m45172d(ErrorCode.ERROR_CODE_NO_AD_RECORD)) {
                        return;
                    }
                    abstractC7323ix = AbstractC7323ix.this;
                    contentRecord = null;
                }
                abstractC7323ix.mo45171d(contentRecord);
            }
        }

        public AnonymousClass13() {
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC7609qk
        /* renamed from: a */
        public void mo45200a(ContentRecord contentRecord) {
            AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "onDownloaded");
            AbstractC7323ix.this.f34057l.m40070u().m39575j(AbstractC7741ao.m47566c());
            synchronized (AbstractC7323ix.this) {
                try {
                    AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "onDownloaded, loadingTimeout:" + AbstractC7323ix.this.f34051f);
                    AbstractC7323ix abstractC7323ix = AbstractC7323ix.this;
                    abstractC7323ix.f34052g = true;
                    if (abstractC7323ix.f34051f) {
                        abstractC7323ix.f34057l.m40027a(-2);
                        AbstractC7323ix.this.f34068w = true;
                    } else {
                        AbstractC7817dj.m48366a(abstractC7323ix.f34053h);
                        AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "cancel loadTimeoutTask");
                        AbstractC7323ix.this.f34057l.m40051f(AbstractC7741ao.m47566c());
                        if (contentRecord == null || 12 != contentRecord.m41392E()) {
                            AbstractC7802cv.m48128a(AbstractC7323ix.this.f34060o, new Runnable() { // from class: com.huawei.openalliance.ad.ix.13.1

                                /* renamed from: a */
                                final /* synthetic */ long f34081a;

                                /* renamed from: b */
                                final /* synthetic */ ContentRecord f34082b;

                                public AnonymousClass1(long j10, ContentRecord contentRecord2) {
                                    j = j10;
                                    contentRecord = contentRecord2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    AbstractC7323ix abstractC7323ix2;
                                    AbstractC7323ix.this.f34057l.m40054g(AbstractC7741ao.m47566c() - j);
                                    ContentRecord contentRecord2 = contentRecord;
                                    if (contentRecord2 != null) {
                                        abstractC7323ix2 = AbstractC7323ix.this;
                                        abstractC7323ix2.f34051f = true;
                                    } else {
                                        if (AbstractC7323ix.this.m45172d(ErrorCode.ERROR_CODE_NO_AD_RECORD)) {
                                            return;
                                        }
                                        abstractC7323ix2 = AbstractC7323ix.this;
                                        contentRecord2 = null;
                                    }
                                    abstractC7323ix2.mo45171d(contentRecord2);
                                }
                            });
                        } else {
                            AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "notify linked ad on current thread");
                            AbstractC7323ix abstractC7323ix2 = AbstractC7323ix.this;
                            abstractC7323ix2.f34051f = true;
                            abstractC7323ix2.mo45171d(contentRecord2);
                        }
                    }
                    AbstractC7323ix.this.m45148j(contentRecord2);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ix$14 */
    public class AnonymousClass14 implements Runnable {
        public AnonymousClass14() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (AbstractC7323ix.this) {
                try {
                    AbstractC7185ho.m43821b(AbstractC7323ix.this.mo45199z(), "on load task timeout, loadingTimeout: %s", Boolean.valueOf(AbstractC7323ix.this.f34051f));
                    AbstractC7323ix abstractC7323ix = AbstractC7323ix.this;
                    if (!abstractC7323ix.f34051f && !abstractC7323ix.m45172d(-2)) {
                        AbstractC7323ix.this.mo45168c(-2);
                        AbstractC7323ix.this.m45188o();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ix$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f34085a;

        /* renamed from: b */
        final /* synthetic */ int f34086b;

        public AnonymousClass2(ContentRecord contentRecord, int i10) {
            contentRecord = contentRecord;
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "start report");
            Context context = AbstractC7323ix.this.f34060o;
            if (context == null) {
                return;
            }
            new C6922c(context).m39070a(contentRecord, i);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ix$3 */
    public class AnonymousClass3 extends CountDownTimer {
        public AnonymousClass3(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "onFinish");
            AbstractC7323ix abstractC7323ix = AbstractC7323ix.this;
            if (abstractC7323ix.f34047b != AdLoadState.LOADED) {
                abstractC7323ix.mo45168c(-10);
                AbstractC7323ix.this.mo45209B();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            AbstractC7185ho.m43818a(AbstractC7323ix.this.mo45199z(), "onTick = %s", Long.valueOf(j10));
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ix$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f34089a;

        /* renamed from: b */
        final /* synthetic */ int f34090b;

        /* renamed from: c */
        final /* synthetic */ int f34091c;

        public AnonymousClass4(List list, int i10, int i11) {
            list = list;
            i = i10;
            i = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            if (list == null || (context = AbstractC7323ix.this.f34060o) == null) {
                return;
            }
            C6922c c6922c = new C6922c(context);
            for (ContentRecord contentRecord : list) {
                if (contentRecord != null) {
                    if (contentRecord.m41417R() != null) {
                        if ((i == 0 && contentRecord.m41417R().m40185e() >= contentRecord.m41417R().m40183d()) || (i == 1 && contentRecord.m41417R().m40185e() < contentRecord.m41417R().m40183d())) {
                            c6922c.mo39072a(contentRecord, i, i, AbstractC7323ix.this.f34032C);
                        }
                    } else if (contentRecord.m41419S() != null) {
                        if (AbstractC7323ix.this.m45134a(contentRecord, contentRecord.m41419S().m40500m(), i)) {
                            c6922c.mo39072a(contentRecord, i, i, AbstractC7323ix.this.f34032C);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ix$5 */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f34093a;

        public AnonymousClass5(ContentRecord contentRecord) {
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (contentRecord.m41464aP() == 3) {
                C7104et.m43127b(AbstractC7323ix.this.f34060o).mo43111a(contentRecord.m41588n(), contentRecord.m41463aO(), contentRecord.m41585m(), "load failed");
                return;
            }
            String strM41619z = contentRecord.m41619z();
            if (!AbstractC7806cz.m48165b(strM41619z)) {
                AbstractC7731ae.m47440a(AbstractC7323ix.this.f34060o, strM41619z);
            }
            C7103es.m43094a(AbstractC7323ix.this.f34060o).mo43119b(contentRecord.m41588n(), contentRecord.m41585m());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ix$6 */
    public class AnonymousClass6 implements Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "onDoActionSucc pauseView");
            if (AbstractC7323ix.this.m45190q() != null) {
                AbstractC7323ix.this.m45190q().pauseView();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ix$7 */
    public class AnonymousClass7 implements Callable<String> {

        /* renamed from: a */
        final /* synthetic */ Context f34096a;

        /* renamed from: b */
        final /* synthetic */ String f34097b;

        /* renamed from: c */
        final /* synthetic */ String f34098c;

        /* renamed from: d */
        final /* synthetic */ String f34099d;

        /* renamed from: com.huawei.openalliance.ad.ix$7$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Context context = context;
                if (context != null) {
                    C7103es c7103esM43094a = C7103es.m43094a(context);
                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                    c7103esM43094a.mo43119b(str, str);
                }
                AnonymousClass7 anonymousClass72 = AnonymousClass7.this;
                AbstractC7731ae.m47440a(context, str);
            }
        }

        public AnonymousClass7(Context context, String str, String str2, String str3) {
            context = context;
            str = str;
            str = str2;
            str = str3;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() {
            String strM41968c = C7019dh.m41937a(context, Constants.NORMAL_CACHE).m41968c(str);
            if (AbstractC7731ae.m47462c(context, strM41968c, Constants.NORMAL_CACHE)) {
                return strM41968c;
            }
            AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.ix.7.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Context context = context;
                    if (context != null) {
                        C7103es c7103esM43094a = C7103es.m43094a(context);
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        c7103esM43094a.mo43119b(str, str);
                    }
                    AnonymousClass7 anonymousClass72 = AnonymousClass7.this;
                    AbstractC7731ae.m47440a(context, str);
                }
            }, AbstractC7834m.a.DISK_CACHE, false);
            return "";
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ix$8 */
    public class AnonymousClass8 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f34102a;

        public AnonymousClass8(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43821b(AbstractC7323ix.this.mo45199z(), "%s pauseView", str);
            if (AbstractC7323ix.this.m45190q() != null) {
                AbstractC7323ix.this.m45190q().pauseView();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ix$9 */
    public class AnonymousClass9 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f34104a;

        public AnonymousClass9(ContentRecord contentRecord) {
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7323ix.this.m45145h(contentRecord);
            if (!AbstractC7323ix.this.f34038I || 3 == contentRecord.m41464aP()) {
                return;
            }
            C7129fm.m43536a(AbstractC7323ix.this.f34060o).mo43542a(contentRecord.m41585m(), System.currentTimeMillis());
        }
    }

    public AbstractC7323ix(InterfaceC8119l interfaceC8119l) {
        this.f34061p = new WeakReference<>(interfaceC8119l);
        this.f34059n = interfaceC8119l.getAdType();
        Context applicationContext = interfaceC8119l.getContext().getApplicationContext();
        this.f34060o = applicationContext;
        this.f34048c = C7124fh.m43316b(applicationContext);
        this.f34049d = C7103es.m43094a(this.f34060o);
        Context context = this.f34060o;
        this.f34050e = new C7560ou(context, new C7668sq(context, this.f34059n));
        this.f34064s = new C7544ol(this.f34060o);
        this.f34044P = new C6922c(this.f34060o);
        this.f34064s.mo46335a(this.f34057l);
        m45108C();
    }

    /* renamed from: C */
    private void m45108C() {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ix.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AbstractC7323ix abstractC7323ix = AbstractC7323ix.this;
                    abstractC7323ix.f34040K = new C7640rp(abstractC7323ix.f34060o);
                    AbstractC7323ix.this.f34040K.m47107a();
                    InterfaceC5110e interfaceC5110eM42838b = C7084e.m42838b();
                    if (interfaceC5110eM42838b != null) {
                        interfaceC5110eM42838b.mo30522a(AbstractC7323ix.this.f34059n, (Bundle) null);
                    }
                } catch (Throwable th2) {
                    AbstractC7185ho.m43821b(AbstractC7323ix.this.mo45199z(), "inform err: %s", th2.getClass().getSimpleName());
                }
            }
        });
    }

    /* renamed from: D */
    private void m45109D() {
        ContentRecord contentRecord = this.f34033D;
        if (contentRecord == null || contentRecord.m41448a()) {
            return;
        }
        long jM47566c = this.f34035F;
        if (jM47566c <= 0) {
            jM47566c = AbstractC7741ao.m47566c();
        }
        AbstractC7185ho.m43818a(mo45199z(), "recordShowStartTime: %s", Long.valueOf(jM47566c));
        this.f34033D.m41536c(String.valueOf(jM47566c));
        this.f34033D.m41560g(jM47566c);
        this.f34050e.mo46590a(this.f34033D);
    }

    /* renamed from: E */
    private String m45110E() {
        return AbstractC7811dd.m48288a(m45189p());
    }

    /* renamed from: F */
    private String m45111F() {
        ContentRecord contentRecord;
        if (!this.f34038I || (contentRecord = this.f34033D) == null || 3 == contentRecord.m41464aP() || this.f34033D.m41470aV() == null) {
            return null;
        }
        return this.f34033D.m41470aV().m40014a();
    }

    /* renamed from: G */
    public void m45112G() {
        AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.ix.12
            public AnonymousClass12() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IHiAdSplash hiAdSplash = HiAdSplash.getInstance(AbstractC7323ix.this.f34060o);
                if (hiAdSplash instanceof HiAdSplash) {
                    HiAdSplash hiAdSplash2 = (HiAdSplash) hiAdSplash;
                    long jMo43414bo = AbstractC7323ix.this.f34048c.mo43414bo();
                    long jM44088a = hiAdSplash2.m44088a();
                    long jCurrentTimeMillis = System.currentTimeMillis() - jM44088a;
                    AbstractC7323ix abstractC7323ix = AbstractC7323ix.this;
                    if (jCurrentTimeMillis >= jMo43414bo) {
                        if (abstractC7323ix.f34059n == 1) {
                            hiAdSplash2.preloadAd();
                            return;
                        } else {
                            hiAdSplash2.preloadSmartScreenAd();
                            return;
                        }
                    }
                    AbstractC7185ho.m43820b(abstractC7323ix.mo45199z(), "request time limit, timeInter=" + jMo43414bo + ", lastTime=" + jM44088a);
                }
            }
        }, (this.f34048c.mo43366ax() * 3) + 1000);
    }

    /* renamed from: H */
    private void m45113H() {
        AnonymousClass3 anonymousClass3 = new CountDownTimer(RippleView.SINGLE_RIPPLE_TIME, 500L) { // from class: com.huawei.openalliance.ad.ix.3
            public AnonymousClass3(long j10, long j11) {
                super(j10, j11);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "onFinish");
                AbstractC7323ix abstractC7323ix = AbstractC7323ix.this;
                if (abstractC7323ix.f34047b != AdLoadState.LOADED) {
                    abstractC7323ix.mo45168c(-10);
                    AbstractC7323ix.this.mo45209B();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j10) {
                AbstractC7185ho.m43818a(AbstractC7323ix.this.mo45199z(), "onTick = %s", Long.valueOf(j10));
            }
        };
        this.f34065t = anonymousClass3;
        anonymousClass3.start();
    }

    /* renamed from: I */
    private boolean m45114I() {
        return this.f34069x;
    }

    /* renamed from: J */
    private void m45115J() {
        try {
            if (this.f34039J) {
                AbstractC7185ho.m43820b(mo45199z(), "already end");
                return;
            }
            InterfaceC8119l interfaceC8119lM45189p = m45189p();
            if (interfaceC8119lM45189p != null) {
                interfaceC8119lM45189p.mo49716b();
            }
            AbstractC7185ho.m43820b(mo45199z(), "onAdEnd");
            this.f34039J = true;
            C7640rp c7640rp = this.f34040K;
            if (c7640rp != null) {
                c7640rp.m47109b();
            }
            InterfaceC5110e interfaceC5110eM42838b = C7084e.m42838b();
            if (interfaceC5110eM42838b != null) {
                interfaceC5110eM42838b.mo30526b(this.f34059n, (Bundle) null);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b(mo45199z(), "end err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: b */
    public AdLoadState mo45163b() {
        return this.f34047b;
    }

    /* renamed from: c */
    public AdListener m45167c() {
        return this.f34063r;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: d */
    public int mo45170d() {
        return this.f34034E;
    }

    /* renamed from: d */
    public abstract void mo45171d(ContentRecord contentRecord);

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: e */
    public void mo45173e() {
        m45122a(10, "onWhyThisAd hasShowFinish", Long.valueOf(this.f34054i));
        InterfaceC8121n interfaceC8121nM45190q = m45190q();
        if (interfaceC8121nM45190q != null) {
            interfaceC8121nM45190q.mo50318g();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: f */
    public void mo45176f() {
        m45122a(11, "feedback hasShowFinish", Long.valueOf(this.f34054i));
        InterfaceC8121n interfaceC8121nM45190q = m45190q();
        if (interfaceC8121nM45190q != null) {
            interfaceC8121nM45190q.mo50319h();
        }
    }

    /* renamed from: g */
    public void m45179g() {
        AdActionListener adActionListener = this.f34030A;
        if (adActionListener != null) {
            adActionListener.onAdClick();
        }
        AbstractC7741ao.m47585i(this.f34060o);
    }

    /* renamed from: h */
    public void m45181h() {
        this.f34049d.mo43115b();
        C7104et.m43127b(this.f34060o).mo43115b();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: i */
    public void mo45182i() {
        if (this.f34071z) {
            return;
        }
        this.f34071z = true;
        if (this.f34035F < 0) {
            this.f34035F = AbstractC7741ao.m47566c();
        }
        m45109D();
        this.f34050e.mo46606b();
        InterfaceC7416lz interfaceC7416lz = this.f34062q;
        if (interfaceC7416lz != null) {
            interfaceC7416lz.mo45619f();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: j */
    public void mo45183j() {
        AbstractC7185ho.m43820b(mo45199z(), "notifyAdDismissed");
        if (this.f34066u) {
            AbstractC7185ho.m43820b(mo45199z(), "ad already dismissed");
            return;
        }
        this.f34066u = true;
        AdListener adListener = this.f34063r;
        if (adListener != null) {
            adListener.onAdDismissed();
        }
        ContentRecord contentRecord = this.f34033D;
        if (contentRecord != null && contentRecord.m41464aP() != 3) {
            C7582pp.m46808a(this.f34060o).m46816a(this.f34033D.m41478ab(), -10);
        }
        InterfaceC8121n interfaceC8121nM45190q = m45190q();
        if (interfaceC8121nM45190q != null) {
            interfaceC8121nM45190q.destroyView();
        }
        InterfaceC8119l interfaceC8119lM45189p = m45189p();
        if (interfaceC8119lM45189p != null) {
            interfaceC8119lM45189p.mo49716b();
        }
    }

    /* renamed from: k */
    public AdSlotParam m45184k() {
        InterfaceC8119l interfaceC8119lM45189p = m45189p();
        if (interfaceC8119lM45189p == null) {
            return null;
        }
        AdSlotParam adSlotParam = interfaceC8119lM45189p.getAdSlotParam();
        if (adSlotParam != null) {
            this.f34057l.m40031a(adSlotParam.m40627a());
        }
        return adSlotParam;
    }

    /* renamed from: l */
    public Context m45185l() {
        InterfaceC8119l interfaceC8119lM45189p = m45189p();
        if (interfaceC8119lM45189p == null) {
            return null;
        }
        return interfaceC8119lM45189p.getContext();
    }

    /* renamed from: m */
    public void m45186m() {
        Context context;
        AdSlotParam adSlotParamM45184k = m45184k();
        if (adSlotParamM45184k == null) {
            mo45171d((ContentRecord) null);
            return;
        }
        Pair<String, Boolean> pairM48217b = AbstractC7807d.m48217b(this.f34060o, true);
        if (pairM48217b == null && this.f34048c.mo43404be() && (context = this.f34060o) != null && C6982bz.m41158h(context)) {
            AbstractC7185ho.m43820b(mo45199z(), "start to request oaid");
            m45124a(adSlotParamM45184k, this.f34060o);
            return;
        }
        if (pairM48217b != null) {
            AbstractC7185ho.m43820b(mo45199z(), "use cached oaid ");
            adSlotParamM45184k.m40635a((String) pairM48217b.first);
            adSlotParamM45184k.m40633a((Boolean) pairM48217b.second);
        }
        m45123a(adSlotParamM45184k);
    }

    /* renamed from: n */
    public void m45187n() {
        int iMo43339aF = this.f34048c.mo43339aF();
        AbstractC7185ho.m43821b(mo45199z(), "startAdLoadTimeoutTask - max load time: %d", Integer.valueOf(iMo43339aF));
        AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.ix.14
            public AnonymousClass14() {
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (AbstractC7323ix.this) {
                    try {
                        AbstractC7185ho.m43821b(AbstractC7323ix.this.mo45199z(), "on load task timeout, loadingTimeout: %s", Boolean.valueOf(AbstractC7323ix.this.f34051f));
                        AbstractC7323ix abstractC7323ix = AbstractC7323ix.this;
                        if (!abstractC7323ix.f34051f && !abstractC7323ix.m45172d(-2)) {
                            AbstractC7323ix.this.mo45168c(-2);
                            AbstractC7323ix.this.m45188o();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }, this.f34053h, iMo43339aF);
    }

    /* renamed from: o */
    public void m45188o() {
        mo45183j();
    }

    /* renamed from: p */
    public InterfaceC8119l m45189p() {
        return this.f34061p.get();
    }

    /* renamed from: q */
    public InterfaceC8121n m45190q() {
        WeakReference<InterfaceC8121n> weakReference = this.f34046a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* renamed from: r */
    public abstract String mo45191r();

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: s */
    public void mo45192s() {
        this.f34057l.m40070u().m39576k(System.currentTimeMillis());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: t */
    public boolean mo45193t() {
        return this.f34055j;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: u */
    public void mo45194u() {
        AbstractC7185ho.m43821b(mo45199z(), "onDisplayTimeUp hasShowFinish: %s", Boolean.valueOf(this.f34036G));
        if (this.f34036G) {
            return;
        }
        this.f34036G = true;
        mo45195v();
        mo45183j();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: v */
    public void mo45195v() {
        if (this.f34037H) {
            AbstractC7185ho.m43820b(mo45199z(), "already reset");
            return;
        }
        this.f34037H = true;
        if (m45190q() != null) {
            m45190q().destroyView();
            if (!m45190q().mo50320i()) {
                AbstractC7185ho.m43820b(mo45199z(), "not show Icon");
                AbstractC7014dc.m41880c(null);
                AbstractC7014dc.m41867a((Drawable) null);
                AbstractC7014dc.m41866a((Bitmap) null);
            }
        }
        InterfaceC8119l interfaceC8119lM45189p = m45189p();
        if (interfaceC8119lM45189p != null) {
            interfaceC8119lM45189p.mo49716b();
        }
        AbstractC7014dc.m41868a((ContentRecord) null);
        AbstractC7014dc.m41877b((ContentRecord) null);
        AbstractC7741ao.m47585i(this.f34060o);
        C7288c.m44224a(this.f34060o).m44229a(false);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: w */
    public String mo45196w() {
        ContentRecord contentRecord = this.f34033D;
        if (contentRecord != null) {
            return contentRecord.m41478ab();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.openalliance.p169ad.inter.data.BiddingInfo mo45197x() {
        /*
            r3 = this;
            com.huawei.openalliance.ad.db.bean.ContentRecord r0 = r3.f34033D
            if (r0 == 0) goto L4c
            com.huawei.openalliance.ad.inter.data.BiddingInfo$a r0 = new com.huawei.openalliance.ad.inter.data.BiddingInfo$a
            r0.<init>()
            com.huawei.openalliance.ad.db.bean.ContentRecord r1 = r3.f34033D
            java.lang.String r1 = r1.m41522bi()
            com.huawei.openalliance.ad.inter.data.BiddingInfo$a r1 = r0.m44455a(r1)
            com.huawei.openalliance.ad.db.bean.ContentRecord r2 = r3.f34033D
            java.lang.String r2 = r2.m41524bk()
            com.huawei.openalliance.ad.inter.data.BiddingInfo$a r1 = r1.m44457b(r2)
            com.huawei.openalliance.ad.db.bean.ContentRecord r2 = r3.f34033D
            java.lang.String r2 = r2.m41525bl()
            r1.setLurl(r2)
            com.huawei.openalliance.ad.db.bean.ContentRecord r1 = r3.f34033D
            com.huawei.openalliance.ad.db.bean.EncryptionField r1 = r1.m41523bj()
            if (r1 == 0) goto L43
            android.content.Context r3 = r3.m45185l()
            java.lang.Object r3 = r1.m41652a(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto L43
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            goto L44
        L43:
            r3 = 0
        L44:
            r0.m44454a(r3)
            com.huawei.openalliance.ad.inter.data.BiddingInfo r3 = r0.m44456a()
            return r3
        L4c:
            com.huawei.openalliance.ad.inter.data.BiddingInfo r3 = new com.huawei.openalliance.ad.inter.data.BiddingInfo
            r3.<init>()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.AbstractC7323ix.mo45197x():com.huawei.openalliance.ad.inter.data.BiddingInfo");
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: y */
    public String mo45198y() {
        ContentRecord contentRecord = this.f34033D;
        if (contentRecord != null) {
            return contentRecord.m41577k();
        }
        return null;
    }

    /* renamed from: z */
    public abstract String mo45199z();

    /* renamed from: h */
    private void m45144h(int i10) {
        String strMo45191r;
        ContentRecord contentRecord;
        List<String> listM40627a;
        Context context = this.f34060o;
        if (context != null) {
            C6927h c6927h = new C6927h(context);
            C6920a c6920a = new C6920a(this.f34032C, (m45184k() == null || (listM40627a = m45184k().m40627a()) == null || listM40627a.isEmpty()) ? null : listM40627a.get(0), this.f34059n);
            if (i10 == -6) {
                strMo45191r = mo45191r();
                contentRecord = this.f34056k;
            } else {
                strMo45191r = mo45191r();
                contentRecord = this.f34033D;
            }
            c6927h.m39177a(i10, c6920a, strMo45191r, contentRecord);
        }
        m45180g(i10);
    }

    /* renamed from: i */
    private void m45146i(int i10) {
        Context context;
        List<String> listM40627a;
        if (this.f34056k == null || (context = this.f34060o) == null) {
            return;
        }
        new C6927h(context).m39177a(i10, new C6920a(this.f34032C, (m45184k() == null || (listM40627a = m45184k().m40627a()) == null || listM40627a.isEmpty()) ? null : listM40627a.get(0), this.f34059n), mo45191r(), this.f34056k);
    }

    /* renamed from: j */
    public void m45148j(ContentRecord contentRecord) {
        if (!this.f34052g || !this.f34068w || this.f34060o == null || this.f34057l.m40026a() <= 0) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43820b(mo45199z(), "reportSplashCostTime");
        }
        this.f34068w = false;
        C6923d.m39133a(this.f34060o, mo45191r(), this.f34057l, this.f34032C, contentRecord, this.f34059n);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: b */
    public void mo45164b(int i10) {
        ContentRecord contentRecordM41885h;
        AbstractC7185ho.m43820b(mo45199z(), "toShowSpare");
        if (!this.f34033D.m41498at() && (contentRecordM41885h = AbstractC7014dc.m41885h()) != null && m45143g(contentRecordM41885h)) {
            this.f34057l.m40035b(System.currentTimeMillis());
            this.f34054i = System.currentTimeMillis();
            m45144h(i10);
            this.f34033D = contentRecordM41885h;
            this.f34050e.mo46590a(contentRecordM41885h);
            m45126a(contentRecordM41885h, i10);
            if (mo45169c(contentRecordM41885h)) {
                return;
            } else {
                i10 = ErrorCode.ERROR_CODE_NULL_AD_VIEW;
            }
        }
        mo45168c(i10);
        mo45209B();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: e */
    public void mo45174e(int i10) {
        m45146i(i10);
        AdListener adListener = this.f34063r;
        if (adListener instanceof LinkedAdListener) {
            adListener.onAdFailedToLoad(-6);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: f */
    public void mo45177f(int i10) {
        InterfaceC8119l interfaceC8119lM45189p = m45189p();
        if (interfaceC8119lM45189p != null) {
            interfaceC8119lM45189p.mo49717b(i10);
        }
    }

    /* renamed from: g */
    public void m45180g(int i10) {
        this.f34068w = true;
        this.f34057l.m40027a(i10);
        m45148j(this.f34033D);
    }

    /* renamed from: a */
    private InterfaceC8121n m45118a(ContentRecord contentRecord, InterfaceC8119l interfaceC8119l) {
        if (contentRecord == null) {
            return null;
        }
        InterfaceC8121n interfaceC8121nMo49705a = interfaceC8119l.mo49705a(contentRecord.m41392E());
        if (interfaceC8121nMo49705a == null) {
            return interfaceC8121nMo49705a;
        }
        interfaceC8121nMo49705a.setAdContent(contentRecord);
        interfaceC8121nMo49705a.setAdMediator(this);
        if (2 == contentRecord.m41392E() || 4 == contentRecord.m41392E()) {
            interfaceC8121nMo49705a.setDisplayDuration((contentRecord.m41499au() > 0 ? contentRecord.m41499au() : 0) + (contentRecord.m41500av() >= 2000 ? contentRecord.m41500av() : this.f34048c.mo43366ax()));
        }
        m45127a(contentRecord, interfaceC8119l, interfaceC8121nMo49705a);
        return interfaceC8121nMo49705a;
    }

    /* renamed from: g */
    private boolean m45143g(ContentRecord contentRecord) {
        String strM41953d;
        Context context;
        int i10;
        AbstractC7185ho.m43820b(mo45199z(), "checkMediaPath.");
        if (contentRecord.m41464aP() == 3) {
            return true;
        }
        if (TextUtils.isEmpty(contentRecord.m41384A())) {
            String strM41619z = contentRecord.m41619z();
            if (TextUtils.isEmpty(strM41619z)) {
                context = this.f34060o;
                i10 = -1;
            } else {
                if (!AbstractC7806cz.m48181j(strM41619z)) {
                    strM41953d = strM41619z;
                } else {
                    if (m45133a(contentRecord, this.f34060o)) {
                        return false;
                    }
                    strM41953d = C7022dk.m41953d(strM41619z);
                }
                if (!strM41619z.startsWith(Scheme.CONTENT.toString())) {
                    String strM45119a = m45119a(this.f34060o, strM41953d, contentRecord.m41588n(), contentRecord.m41585m());
                    if (TextUtils.isEmpty(strM45119a)) {
                        context = this.f34060o;
                        i10 = 4;
                    } else {
                        contentRecord.m41575j(strM45119a);
                        contentRecord.m41571i(strM41953d);
                    }
                }
            }
            C6923d.m39132a(context, contentRecord, i10, this.f34059n);
            return false;
        }
        AbstractC7185ho.m43820b(mo45199z(), "Spare splash is valid.");
        C6923d.m39132a(this.f34060o, contentRecord, 200, this.f34059n);
        return true;
    }

    /* renamed from: h */
    public void m45145h(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        contentRecord.m41399I();
        ArrayList arrayList = new ArrayList();
        arrayList.add("priority");
        arrayList.add(ContentRecord.LAST_SHOW_TIME);
        arrayList.add(ContentRecord.DISPLAY_COUNT);
        this.f34049d.mo43108a(contentRecord, arrayList);
        this.f34049d.mo43110a(contentRecord.m41591o(), AbstractC7741ao.m47566c());
    }

    /* renamed from: i */
    private void m45147i(ContentRecord contentRecord) {
        if (this.f34062q == null) {
            return;
        }
        if (contentRecord != null && contentRecord.m41392E() == 9) {
            this.f34062q.mo45611a(C7482mq.m45849a(0.0f, true, EnumC7481mp.STANDALONE));
        } else if (contentRecord != null) {
            if (contentRecord.m41392E() == 4 || contentRecord.m41392E() == 2) {
                this.f34062q.mo45619f();
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: b */
    public void mo45165b(long j10) {
        this.f34045Q = j10;
        this.f34057l.m40028a(j10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: c */
    public void mo45168c(int i10) {
        AbstractC7185ho.m43820b(mo45199z(), "ad failed:" + i10);
        if (this.f34067v) {
            AbstractC7185ho.m43820b(mo45199z(), "ad is already failed");
            return;
        }
        this.f34067v = true;
        this.f34054i = System.currentTimeMillis();
        this.f34057l.m40035b(System.currentTimeMillis());
        AdListener adListener = this.f34063r;
        if (adListener != null) {
            adListener.onAdFailedToLoad(i10);
        }
        m45166b(this.f34033D);
        AbstractC7741ao.m47585i(this.f34060o);
        m45115J();
        m45144h(i10);
        C7019dh.m41939b();
    }

    /* renamed from: d */
    public boolean m45172d(int i10) {
        AbstractC7185ho.m43820b(mo45199z(), "showSpare");
        ContentRecord contentRecordM41885h = AbstractC7014dc.m41885h();
        String strMo45199z = mo45199z();
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.f34051f);
        objArr[1] = Boolean.valueOf(contentRecordM41885h == null);
        AbstractC7185ho.m43821b(strMo45199z, "showSpare, loadingTimeout: %s %s", objArr);
        if (this.f34051f || contentRecordM41885h == null || !m45143g(contentRecordM41885h)) {
            this.f34051f = true;
            return false;
        }
        AbstractC7185ho.m43820b(mo45199z(), "show spare splash");
        AbstractC7817dj.m48366a(this.f34053h);
        this.f34051f = true;
        this.f34052g = true;
        contentRecordM41885h.m41538c(true);
        this.f34054i = System.currentTimeMillis();
        this.f34057l.m40035b(System.currentTimeMillis());
        m45144h(i10);
        m45126a(contentRecordM41885h, i10);
        mo45171d(contentRecordM41885h);
        return true;
    }

    /* renamed from: e */
    public void m45175e(ContentRecord contentRecord) {
        this.f34033D = contentRecord;
        if (contentRecord == null || contentRecord.m41464aP() != 3) {
            return;
        }
        this.f34049d = C7104et.m43127b(this.f34060o);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: f */
    public void mo45178f(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ix.5

            /* renamed from: a */
            final /* synthetic */ ContentRecord f34093a;

            public AnonymousClass5(ContentRecord contentRecord2) {
                contentRecord = contentRecord2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (contentRecord.m41464aP() == 3) {
                    C7104et.m43127b(AbstractC7323ix.this.f34060o).mo43111a(contentRecord.m41588n(), contentRecord.m41463aO(), contentRecord.m41585m(), "load failed");
                    return;
                }
                String strM41619z = contentRecord.m41619z();
                if (!AbstractC7806cz.m48165b(strM41619z)) {
                    AbstractC7731ae.m47440a(AbstractC7323ix.this.f34060o, strM41619z);
                }
                C7103es.m43094a(AbstractC7323ix.this.f34060o).mo43119b(contentRecord.m41588n(), contentRecord.m41585m());
            }
        });
    }

    /* renamed from: a */
    private String m45119a(Context context, String str, String str2, String str3) {
        try {
            return (String) AbstractC7810dc.m48273c(new Callable<String>() { // from class: com.huawei.openalliance.ad.ix.7

                /* renamed from: a */
                final /* synthetic */ Context f34096a;

                /* renamed from: b */
                final /* synthetic */ String f34097b;

                /* renamed from: c */
                final /* synthetic */ String f34098c;

                /* renamed from: d */
                final /* synthetic */ String f34099d;

                /* renamed from: com.huawei.openalliance.ad.ix$7$1 */
                public class AnonymousClass1 implements Runnable {
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Context context = context;
                        if (context != null) {
                            C7103es c7103esM43094a = C7103es.m43094a(context);
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            c7103esM43094a.mo43119b(str, str);
                        }
                        AnonymousClass7 anonymousClass72 = AnonymousClass7.this;
                        AbstractC7731ae.m47440a(context, str);
                    }
                }

                public AnonymousClass7(Context context2, String str4, String str22, String str32) {
                    context = context2;
                    str = str4;
                    str = str22;
                    str = str32;
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public String call() {
                    String strM41968c = C7019dh.m41937a(context, Constants.NORMAL_CACHE).m41968c(str);
                    if (AbstractC7731ae.m47462c(context, strM41968c, Constants.NORMAL_CACHE)) {
                        return strM41968c;
                    }
                    AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.ix.7.1
                        public AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Context context2 = context;
                            if (context2 != null) {
                                C7103es c7103esM43094a = C7103es.m43094a(context2);
                                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                c7103esM43094a.mo43119b(str, str);
                            }
                            AnonymousClass7 anonymousClass72 = AnonymousClass7.this;
                            AbstractC7731ae.m47440a(context, str);
                        }
                    }, AbstractC7834m.a.DISK_CACHE, false);
                    return "";
                }
            });
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c(mo45199z(), "get media local path exception");
            return "";
        }
    }

    /* renamed from: b */
    public void m45166b(ContentRecord contentRecord) {
        int iM41893p = AbstractC7014dc.m41893p();
        this.f34043O = iM41893p;
        if (iM41893p == 0) {
            this.f34044P.m39057a(0, this.f34045Q, this.f34042N, contentRecord);
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j10 = f34029M;
            if (j10 != 0) {
                this.f34042N = jCurrentTimeMillis - j10;
            }
            f34029M = jCurrentTimeMillis;
            this.f34044P.m39057a(1, this.f34045Q, this.f34042N, contentRecord);
        }
        AbstractC7185ho.m43821b(mo45199z(), "rptSplStaPatten, mode: %s, adStartLoadTime: %s, timeInterval: %s", Integer.valueOf(this.f34043O), Long.valueOf(this.f34045Q), Long.valueOf(this.f34042N));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: c */
    public boolean mo45169c(ContentRecord contentRecord) {
        AbstractC7185ho.m43820b(mo45199z(), "showAdContent");
        this.f34055j = true;
        if (this.f34058m != null) {
            AbstractC7185ho.m43820b(mo45199z(), "set verifyConfig.");
            contentRecord.m41396G(AbstractC7806cz.m48170d(this.f34058m.getData()));
            contentRecord.m41398H(AbstractC7806cz.m48170d(this.f34058m.getUserId()));
        }
        this.f34050e.mo46590a(contentRecord);
        InterfaceC8119l interfaceC8119lM45189p = m45189p();
        if (interfaceC8119lM45189p == null) {
            return false;
        }
        AbstractC7185ho.m43821b(mo45199z(), "showAdContent, getTemplateIdV3 = %s, sdkMonitor %s", contentRecord.m41463aO(), Integer.valueOf(contentRecord.m41505b()));
        if (!AbstractC7806cz.m48165b(contentRecord.m41463aO()) || C7780c.m47863a(this.f34060o, contentRecord.m41470aV(), contentRecord.m41585m(), 1)) {
            this.f34038I = true;
            if (!(interfaceC8119lM45189p instanceof PPSSplashView)) {
                AbstractC7185ho.m43823c(mo45199z(), "not PPSSplashView");
                return false;
            }
            IRemoteCreator iRemoteCreatorM42835a = C7084e.m42835a(this.f34060o);
            if (iRemoteCreatorM42835a == null) {
                AbstractC7185ho.m43820b(mo45199z(), "Creator is null");
                return false;
            }
            BinderC6979bw binderC6979bw = new BinderC6979bw(interfaceC8119lM45189p.getContext(), this, contentRecord);
            String strM47742b = AbstractC7758be.m47742b(AdContentData.m39271a(this.f34060o, contentRecord));
            Bundle bundle = new Bundle();
            bundle.putInt("audioFocusType", interfaceC8119lM45189p.getAudioFocusType());
            PPSSplashView pPSSplashView = (PPSSplashView) interfaceC8119lM45189p;
            bundle.putInt(ParamConstants.Param.MEDIA_NAME_RES_ID, pPSSplashView.getMediaNameResId());
            bundle.putInt(ParamConstants.Param.LOGO_RES_ID, pPSSplashView.getLogoResId());
            bundle.putString("content", strM47742b);
            AbstractC7185ho.m43818a(mo45199z(), "contentJson : %s", strM47742b);
            AdSlotParam adSlotParamM45184k = m45184k();
            if (adSlotParamM45184k != null) {
                bundle.putInt(ParamConstants.Param.ORIENTATION, adSlotParamM45184k.m40639b());
                bundle.putInt(ParamConstants.Param.END_MODE, adSlotParamM45184k.m40622F() != null ? adSlotParamM45184k.m40622F().intValue() : 1);
            }
            try {
                View view = (View) ObjectWrapper.unwrap(iRemoteCreatorM42835a.newSplashTemplateView(bundle, binderC6979bw));
                if (view == 0) {
                    AbstractC7185ho.m43823c(mo45199z(), "templateView is null");
                    return false;
                }
                this.f34062q = null;
                interfaceC8119lM45189p.mo49709a(view, contentRecord);
                this.f34041L = interfaceC8119lM45189p.getMonitorEp();
                iRemoteCreatorM42835a.bindData(ObjectWrapper.wrap(view), strM47742b);
                if (view instanceof IMediaStateApiTransfer) {
                    ((IMediaStateApiTransfer) view).setProxy(interfaceC8119lM45189p.getMediaProxy());
                } else {
                    AbstractC7185ho.m43823c(mo45199z(), "splash template view is not a IMediaStateApiTransfer instance");
                }
                m45113H();
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c(mo45199z(), "create splashTemplateView err: %s", th2.getClass().getSimpleName());
                return false;
            }
        } else {
            InterfaceC8121n interfaceC8121nM45118a = m45118a(contentRecord, interfaceC8119lM45189p);
            if (interfaceC8121nM45118a == null) {
                return false;
            }
            InterfaceC7416lz interfaceC7416lz = this.f34062q;
            if (interfaceC7416lz != null) {
                interfaceC7416lz.mo45616c();
            }
            m45147i(contentRecord);
            this.f34046a = new WeakReference<>(interfaceC8121nM45118a);
            interfaceC8119lM45189p.mo49714a(interfaceC8121nM45118a, contentRecord);
            this.f34041L = interfaceC8119lM45189p.getMonitorEp();
            interfaceC8121nM45118a.mo50313b();
        }
        return true;
    }

    /* renamed from: b */
    private void m45138b(boolean z10) {
        this.f34069x = z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: a */
    public void mo45149a(int i10) {
        this.f34034E = i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: a */
    public void mo45150a(int i10, int i11) {
        InterfaceC8121n interfaceC8121nM45190q = m45190q();
        if (interfaceC8121nM45190q != null) {
            interfaceC8121nM45190q.mo50310a(i10, i11);
        }
        this.f34050e.mo46607b(i10, i11);
        m45132a(Long.valueOf(this.f34054i), 3);
        mo45183j();
        mo45195v();
    }

    /* renamed from: a */
    private void m45121a(int i10, int i11, AbstractC7687ti abstractC7687ti, Long l10, MaterialClickInfo materialClickInfo, int i12) {
        m45132a(l10, 1);
        C7587b.a aVar = new C7587b.a();
        aVar.m46912a(i10).m46919b(i11).m46920b(abstractC7687ti.m47250c()).m46915a(Integer.valueOf(i12)).m46914a(materialClickInfo).m46923d(C7753b.m47700a(m45189p())).m46924e(m45111F());
        this.f34050e.mo46594a(aVar.m46918a());
        InterfaceC7615qq interfaceC7615qq = this.f34041L;
        if (interfaceC7615qq != null) {
            interfaceC7615qq.mo46594a(aVar.m46918a());
        }
        InterfaceC8119l interfaceC8119lM45189p = m45189p();
        if (interfaceC8119lM45189p != null) {
            interfaceC8119lM45189p.mo49706a();
        }
        if (this.f34036G) {
            AbstractC7185ho.m43820b(mo45199z(), "onDoActionSucc hasShowFinish");
            return;
        }
        this.f34036G = true;
        m45179g();
        if (mo45170d() == 1) {
            AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.ix.6
                public AnonymousClass6() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "onDoActionSucc pauseView");
                    if (AbstractC7323ix.this.m45190q() != null) {
                        AbstractC7323ix.this.m45190q().pauseView();
                    }
                }
            }, 150L);
        }
        mo45195v();
    }

    /* renamed from: a */
    private void m45122a(int i10, String str, Long l10) {
        m45132a(l10, i10);
        if (this.f34036G) {
            AbstractC7185ho.m43820b(mo45199z(), str);
            return;
        }
        this.f34036G = true;
        mo45195v();
        if (mo45170d() == 1) {
            AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.ix.8

                /* renamed from: a */
                final /* synthetic */ String f34102a;

                public AnonymousClass8(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7185ho.m43821b(AbstractC7323ix.this.mo45199z(), "%s pauseView", str);
                    if (AbstractC7323ix.this.m45190q() != null) {
                        AbstractC7323ix.this.m45190q().pauseView();
                    }
                }
            }, 150L);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: a */
    public void mo45151a(long j10) {
        if (this.f34035F < 0) {
            this.f34035F = j10;
        }
    }

    /* renamed from: a */
    public void m45123a(AdSlotParam adSlotParam) {
        AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.ix.11

            /* renamed from: a */
            final /* synthetic */ long f34076a;

            /* renamed from: b */
            final /* synthetic */ AdSlotParam f34077b;

            public AnonymousClass11(long j10, AdSlotParam adSlotParam2) {
                j = j10;
                adSlotParam = adSlotParam2;
            }

            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "doAdRequest " + jCurrentTimeMillis);
                AbstractC7323ix.this.f34057l.m40045d(jCurrentTimeMillis - j);
                AbstractC7323ix.this.f34032C = AbstractC7741ao.m47539a();
                adSlotParam.m40642b(AbstractC7323ix.this.f34032C);
                InterfaceC7610ql interfaceC7610ql = AbstractC7323ix.this.f34064s;
                AbstractC7323ix abstractC7323ix = AbstractC7323ix.this;
                AbstractC7323ix.this.m45125a(interfaceC7610ql.mo46329a(abstractC7323ix.f34060o, adSlotParam, abstractC7323ix.f34059n), jCurrentTimeMillis);
                AbstractC7323ix.this.m45112G();
            }
        }, AbstractC7834m.a.SPLASH_NET, false);
    }

    /* renamed from: a */
    private void m45124a(AdSlotParam adSlotParam, Context context) {
        OAIDServiceManager.getInstance(context).requireOaid(new OAIDServiceManager.OaidResultCallback() { // from class: com.huawei.openalliance.ad.ix.10

            /* renamed from: a */
            final /* synthetic */ AdSlotParam f34073a;

            /* renamed from: b */
            final /* synthetic */ Context f34074b;

            public AnonymousClass10(AdSlotParam adSlotParam2, Context context2) {
                adSlotParam = adSlotParam2;
                context = context2;
            }

            @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
            /* renamed from: a */
            public void mo44091a() {
                AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "onOaidAcquireFailed");
                AbstractC7323ix.this.m45123a(adSlotParam);
            }

            @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
            /* renamed from: b */
            public int mo44093b() {
                return AbstractC7323ix.this.f34059n;
            }

            @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
            /* renamed from: a */
            public void mo44092a(String str, boolean z10) {
                AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "onOaidAcquired");
                adSlotParam.m40635a(str);
                adSlotParam.m40633a(Boolean.valueOf(z10));
                AbstractC7323ix.this.m45123a(adSlotParam);
                AbstractC7807d.m48211a(context, str, z10);
            }
        });
    }

    /* renamed from: a */
    public void m45125a(AdContentRsp adContentRsp, long j10) {
        AdSlotParam adSlotParamM45184k = m45184k();
        if (adSlotParamM45184k == null) {
            AbstractC7185ho.m43823c(mo45199z(), "onPostAdRequest adSlotParam is null");
        } else {
            this.f34064s.mo46336a(adContentRsp, adSlotParamM45184k, this, new InterfaceC7609qk() { // from class: com.huawei.openalliance.ad.ix.13

                /* renamed from: com.huawei.openalliance.ad.ix$13$1 */
                public class AnonymousClass1 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ long f34081a;

                    /* renamed from: b */
                    final /* synthetic */ ContentRecord f34082b;

                    public AnonymousClass1(long j10, ContentRecord contentRecord2) {
                        j = j10;
                        contentRecord = contentRecord2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractC7323ix abstractC7323ix2;
                        AbstractC7323ix.this.f34057l.m40054g(AbstractC7741ao.m47566c() - j);
                        ContentRecord contentRecord2 = contentRecord;
                        if (contentRecord2 != null) {
                            abstractC7323ix2 = AbstractC7323ix.this;
                            abstractC7323ix2.f34051f = true;
                        } else {
                            if (AbstractC7323ix.this.m45172d(ErrorCode.ERROR_CODE_NO_AD_RECORD)) {
                                return;
                            }
                            abstractC7323ix2 = AbstractC7323ix.this;
                            contentRecord2 = null;
                        }
                        abstractC7323ix2.mo45171d(contentRecord2);
                    }
                }

                public AnonymousClass13() {
                }

                @Override // com.huawei.openalliance.p169ad.InterfaceC7609qk
                /* renamed from: a */
                public void mo45200a(ContentRecord contentRecord2) {
                    AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "onDownloaded");
                    AbstractC7323ix.this.f34057l.m40070u().m39575j(AbstractC7741ao.m47566c());
                    synchronized (AbstractC7323ix.this) {
                        try {
                            AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "onDownloaded, loadingTimeout:" + AbstractC7323ix.this.f34051f);
                            AbstractC7323ix abstractC7323ix = AbstractC7323ix.this;
                            abstractC7323ix.f34052g = true;
                            if (abstractC7323ix.f34051f) {
                                abstractC7323ix.f34057l.m40027a(-2);
                                AbstractC7323ix.this.f34068w = true;
                            } else {
                                AbstractC7817dj.m48366a(abstractC7323ix.f34053h);
                                AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "cancel loadTimeoutTask");
                                AbstractC7323ix.this.f34057l.m40051f(AbstractC7741ao.m47566c());
                                if (contentRecord2 == null || 12 != contentRecord2.m41392E()) {
                                    AbstractC7802cv.m48128a(AbstractC7323ix.this.f34060o, new Runnable() { // from class: com.huawei.openalliance.ad.ix.13.1

                                        /* renamed from: a */
                                        final /* synthetic */ long f34081a;

                                        /* renamed from: b */
                                        final /* synthetic */ ContentRecord f34082b;

                                        public AnonymousClass1(long j102, ContentRecord contentRecord22) {
                                            j = j102;
                                            contentRecord = contentRecord22;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AbstractC7323ix abstractC7323ix2;
                                            AbstractC7323ix.this.f34057l.m40054g(AbstractC7741ao.m47566c() - j);
                                            ContentRecord contentRecord22 = contentRecord;
                                            if (contentRecord22 != null) {
                                                abstractC7323ix2 = AbstractC7323ix.this;
                                                abstractC7323ix2.f34051f = true;
                                            } else {
                                                if (AbstractC7323ix.this.m45172d(ErrorCode.ERROR_CODE_NO_AD_RECORD)) {
                                                    return;
                                                }
                                                abstractC7323ix2 = AbstractC7323ix.this;
                                                contentRecord22 = null;
                                            }
                                            abstractC7323ix2.mo45171d(contentRecord22);
                                        }
                                    });
                                } else {
                                    AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "notify linked ad on current thread");
                                    AbstractC7323ix abstractC7323ix2 = AbstractC7323ix.this;
                                    abstractC7323ix2.f34051f = true;
                                    abstractC7323ix2.mo45171d(contentRecord22);
                                }
                            }
                            AbstractC7323ix.this.m45148j(contentRecord22);
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            }, j10, 0);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: a */
    public void mo45152a(ContentRecord contentRecord) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ix.9

            /* renamed from: a */
            final /* synthetic */ ContentRecord f34104a;

            public AnonymousClass9(ContentRecord contentRecord2) {
                contentRecord = contentRecord2;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7323ix.this.m45145h(contentRecord);
                if (!AbstractC7323ix.this.f34038I || 3 == contentRecord.m41464aP()) {
                    return;
                }
                C7129fm.m43536a(AbstractC7323ix.this.f34060o).mo43542a(contentRecord.m41585m(), System.currentTimeMillis());
            }
        });
        InterfaceC8119l interfaceC8119lM45189p = m45189p();
        if (interfaceC8119lM45189p != null) {
            int iM41594p = contentRecord2.m41594p();
            interfaceC8119lM45189p.mo49708a(iM41594p, !this.f34038I);
            interfaceC8119lM45189p.mo49718c();
            if (!this.f34038I) {
                interfaceC8119lM45189p.mo49712a(contentRecord2, this.f34048c.mo43368az());
                interfaceC8119lM45189p.mo49707a(AbstractC7558os.m46475n(contentRecord2.m41427W()), AbstractC7558os.m46481t(contentRecord2.m41427W()), contentRecord2.m41503ay(), 1 == iM41594p, interfaceC8119lM45189p.mo49715b(contentRecord2));
            }
            interfaceC8119lM45189p.mo49711a(contentRecord2);
        }
        this.f34047b = AdLoadState.LOADED;
        CountDownTimer countDownTimer = this.f34065t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        AbstractC7185ho.m43820b(mo45199z(), "ad loaded");
        this.f34054i = System.currentTimeMillis();
        this.f34057l.m40035b(System.currentTimeMillis());
        AbstractC7014dc.m41880c(contentRecord2);
        AdListener adListener = this.f34063r;
        if (adListener != null) {
            adListener.onAdLoaded();
        }
        if (this.f34031B != null && this.f34059n == 1 && contentRecord2 != null) {
            HashMap map = new HashMap();
            map.put(AdShowExtras.PRELOAD_MODE, String.valueOf(C7120fd.m43288a(this.f34060o).mo43290a(contentRecord2.m41585m())));
            map.put(AdShowExtras.DOWNLOAD_SOURCE, AbstractC7807d.m48210a(contentRecord2.m41423U()));
            this.f34031B.onAdShowed(map);
        }
        m45166b(contentRecord2);
        m45180g(200);
        m45109D();
        mo45182i();
        if (!this.f34048c.mo43401bb()) {
            m45158a((Long) null, (Integer) null, (Integer) null, interfaceC8119lM45189p);
        }
        C7019dh.m41939b();
    }

    /* renamed from: a */
    private void m45126a(ContentRecord contentRecord, int i10) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ix.2

            /* renamed from: a */
            final /* synthetic */ ContentRecord f34085a;

            /* renamed from: b */
            final /* synthetic */ int f34086b;

            public AnonymousClass2(ContentRecord contentRecord2, int i102) {
                contentRecord = contentRecord2;
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b(AbstractC7323ix.this.mo45199z(), "start report");
                Context context = AbstractC7323ix.this.f34060o;
                if (context == null) {
                    return;
                }
                new C6922c(context).m39070a(contentRecord, i);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: a */
    public void mo45153a(ContentRecord contentRecord, long j10, int i10) {
        String strMo45199z;
        String str;
        m45115J();
        if (!this.f34048c.mo43401bb()) {
            AbstractC7185ho.m43823c(mo45199z(), "onAdShowEnd - use old adshow event");
            return;
        }
        AbstractC7185ho.m43821b(mo45199z(), "onAdShowEnd duration: %d showRatio: %d", Long.valueOf(j10), Integer.valueOf(i10));
        this.f34050e.mo46581a(j10, i10);
        if (contentRecord != null) {
            MetaData metaDataM41568i = contentRecord.m41568i();
            if (metaDataM41568i != null) {
                if (j10 < metaDataM41568i.m40320i() || i10 < metaDataM41568i.m40324k()) {
                    AbstractC7185ho.m43824c(mo45199z(), "duration or show ratio is invalid for showId %s", contentRecord.m41577k());
                    return;
                } else {
                    m45158a(Long.valueOf(j10), Integer.valueOf(i10), (Integer) null, m45190q());
                    return;
                }
            }
            strMo45199z = mo45199z();
            str = "onAdShowEnd - metaData is null";
        } else {
            strMo45199z = mo45199z();
            str = "onAdShowEnd - content record is null";
        }
        AbstractC7185ho.m43823c(strMo45199z, str);
    }

    /* renamed from: a */
    private void m45127a(ContentRecord contentRecord, InterfaceC8119l interfaceC8119l, InterfaceC8121n interfaceC8121n) {
        if (contentRecord == null || interfaceC8121n == null || this.f34062q == null) {
            AbstractC7185ho.m43823c(mo45199z(), "there is no splash ad or adView is null");
            return;
        }
        AbstractC7185ho.m43820b(mo45199z(), "initOmsdkResource");
        this.f34062q.mo45607a(m45185l(), contentRecord, interfaceC8119l, true);
        interfaceC8121n.mo50312a(this.f34062q);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: a */
    public void mo45154a(RewardVerifyConfig rewardVerifyConfig) {
        this.f34058m = rewardVerifyConfig;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: a */
    public void mo45155a(AdActionListener adActionListener) {
        this.f34030A = adActionListener;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: a */
    public void mo45156a(AdListener adListener) {
        this.f34063r = adListener;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: a */
    public void mo45157a(AdShowListener adShowListener) {
        this.f34031B = adShowListener;
    }

    /* renamed from: a */
    private void m45131a(C7586a.a aVar) {
        Object objM45189p = m45189p();
        if (!(objM45189p instanceof View) || aVar == null) {
            return;
        }
        aVar.m46885e(C8190vl.m50727b((View) objM45189p));
    }

    /* renamed from: a */
    private void m45132a(Long l10, int i10) {
        m45158a(l10 != null ? Long.valueOf(System.currentTimeMillis() - l10.longValue()) : null, (Integer) 100, Integer.valueOf(i10), (InterfaceC7337jk) m45190q());
    }

    /* renamed from: a */
    public void m45158a(Long l10, Integer num, Integer num2, InterfaceC7337jk interfaceC7337jk) {
        ContentRecord contentRecord = this.f34033D;
        boolean zM47867a = C7780c.m47867a(contentRecord != null ? contentRecord.m41514ba() : null, num2);
        if (m45114I() && (!zM47867a || m45161a())) {
            AbstractC7185ho.m43823c(mo45199z(), "show event already reported before, ignore this");
            return;
        }
        String strM45110E = m45110E();
        if (this.f34033D != null) {
            AbstractC7185ho.m43818a(mo45199z(), "slotId: %s, contentId: %s, slot pos: %s", this.f34033D.m41585m(), this.f34033D.m41588n(), strM45110E);
        }
        C7586a.a aVar = new C7586a.a();
        if (!AbstractC7806cz.m48165b(strM45110E)) {
            aVar.m46884d(strM45110E);
        }
        aVar.m46874a(l10).m46873a(num).m46878b(num2).m46875a(C7753b.m47700a(interfaceC7337jk)).m46882c(m45111F());
        m45131a(aVar);
        this.f34050e.mo46593a(aVar.m46877a());
        if (zM47867a) {
            m45160a(true);
        }
        if (m45114I()) {
            return;
        }
        m45138b(true);
        AdActionListener adActionListener = this.f34030A;
        if (adActionListener != null) {
            adActionListener.onAdShowed();
        }
        InterfaceC7416lz interfaceC7416lz = this.f34062q;
        if (interfaceC7416lz != null) {
            interfaceC7416lz.mo45618e();
        }
    }

    /* renamed from: a */
    public void m45159a(List<ContentRecord> list, int i10, int i11) {
        AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.ix.4

            /* renamed from: a */
            final /* synthetic */ List f34089a;

            /* renamed from: b */
            final /* synthetic */ int f34090b;

            /* renamed from: c */
            final /* synthetic */ int f34091c;

            public AnonymousClass4(List list2, int i102, int i112) {
                list = list2;
                i = i102;
                i = i112;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context context;
                if (list == null || (context = AbstractC7323ix.this.f34060o) == null) {
                    return;
                }
                C6922c c6922c = new C6922c(context);
                for (ContentRecord contentRecord : list) {
                    if (contentRecord != null) {
                        if (contentRecord.m41417R() != null) {
                            if ((i == 0 && contentRecord.m41417R().m40185e() >= contentRecord.m41417R().m40183d()) || (i == 1 && contentRecord.m41417R().m40185e() < contentRecord.m41417R().m40183d())) {
                                c6922c.mo39072a(contentRecord, i, i, AbstractC7323ix.this.f34032C);
                            }
                        } else if (contentRecord.m41419S() != null) {
                            if (AbstractC7323ix.this.m45134a(contentRecord, contentRecord.m41419S().m40500m(), i)) {
                                c6922c.mo39072a(contentRecord, i, i, AbstractC7323ix.this.f34032C);
                            }
                        }
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void m45160a(boolean z10) {
        this.f34070y = z10;
    }

    /* renamed from: a */
    public boolean m45161a() {
        return this.f34070y;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: a */
    public boolean mo45162a(int i10, int i11, ContentRecord contentRecord, Long l10, MaterialClickInfo materialClickInfo, int i12) {
        boolean z10;
        AbstractC7185ho.m43820b(mo45199z(), "onTouch");
        AbstractC7687ti abstractC7687tiM47245a = C7686th.m47245a(this.f34060o, contentRecord, new HashMap(0));
        if (abstractC7687tiM47245a.mo47233a()) {
            if (18 == i12 && (m45185l() instanceof Activity)) {
                ((Activity) m45185l()).overridePendingTransition(C6849R.anim.hiad_open, C6849R.anim.hiad_close);
            }
            m45121a(i10, i11, abstractC7687tiM47245a, l10, materialClickInfo, i12);
            z10 = true;
        } else {
            z10 = false;
        }
        C7288c.m44224a(this.f34060o).m44229a(false);
        return z10;
    }

    /* renamed from: a */
    private boolean m45133a(ContentRecord contentRecord, Context context) {
        AdSlotParam adSlotParamM45184k = m45184k();
        if (adSlotParamM45184k == null) {
            return true;
        }
        int iM40639b = adSlotParamM45184k.m40639b();
        int iM41609u = contentRecord.m41609u();
        int iM41606t = contentRecord.m41606t();
        if (iM40639b == 0 && (contentRecord.m41392E() == 12 || iM41606t <= iM41609u)) {
            C6923d.m39132a(context, contentRecord, 2, this.f34059n);
            return true;
        }
        if (iM40639b == 1 && contentRecord.m41392E() != 12 && iM41606t > iM41609u) {
            C6923d.m39132a(context, contentRecord, 3, this.f34059n);
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis >= contentRecord.m41603s() && jCurrentTimeMillis <= contentRecord.m41600r()) {
            return false;
        }
        C6923d.m39132a(context, contentRecord, 1, this.f34059n);
        return true;
    }

    /* renamed from: a */
    public boolean m45134a(ContentRecord contentRecord, Float f10, int i10) {
        if (f10 == null) {
            return i10 == 0;
        }
        if (i10 != 0 || f10.floatValue() >= 1.0f) {
            return contentRecord.m41392E() == 12 ? i10 == 0 : i10 == 1 && f10.floatValue() > 1.0f;
        }
        return true;
    }
}
