package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.beans.inner.AdContentData;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.constant.AdShowExtras;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7756bc;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.np */
/* loaded from: classes8.dex */
public class C7521np extends C7336jj<InterfaceC8118k> implements InterfaceC7537oe<InterfaceC8118k> {

    /* renamed from: d */
    private Context f34934d;

    /* renamed from: e */
    private C7305h f34935e;

    /* renamed from: f */
    private int f34936f;

    /* renamed from: g */
    private int f34937g;

    /* renamed from: com.huawei.openalliance.ad.np$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7521np.this.mo45320d().mo49489c();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.np$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f34939a;

        /* renamed from: b */
        final /* synthetic */ IRewardAdStatusListener f34940b;

        public AnonymousClass2(ContentRecord contentRecord, IRewardAdStatusListener iRewardAdStatusListener) {
            contentRecord = contentRecord;
            iRewardAdStatusListener = iRewardAdStatusListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            new C6922c(C7521np.this.f34934d).m39124e(contentRecord);
            iRewardAdStatusListener.onRewarded();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.np$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f34942a;

        public AnonymousClass3(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(str);
            if (AbstractC7731ae.m47464d(file)) {
                VideoInfo videoInfoM41419S = C7521np.this.f34189a == null ? null : C7521np.this.f34189a.m41419S();
                if (videoInfoM41419S == null || !AbstractC7731ae.m47452a(videoInfoM41419S.m40493g(), file)) {
                    AbstractC7185ho.m43820b("RewardAdPresenter", "delete invalid cacheFile.");
                    AbstractC7731ae.m47441a(C7521np.this.f34934d, str, Constants.NORMAL_CACHE);
                }
            }
        }
    }

    public C7521np(Context context, InterfaceC8118k interfaceC8118k) {
        this.f34934d = context;
        mo45316a((C7521np) interfaceC8118k);
        this.f34190b = new C7560ou(context, new C7667sp(context));
    }

    /* renamed from: a */
    public static int m46171a(Context context, int i10) {
        int iMo43388bO = (C7124fh.m43316b(context).mo43388bO() * i10) / 100000;
        if (iMo43388bO <= 0) {
            iMo43388bO = (i10 * 90) / 100000;
        }
        return Math.min(iMo43388bO, 27);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: a */
    public int mo46177a(ContentRecord contentRecord, int i10) {
        boolean zMo46192b = mo46192b(contentRecord);
        int iM40272I = (contentRecord == null || contentRecord.m41568i() == null) ? 2 : contentRecord.m41568i().m40272I();
        if (!zMo46192b || iM40272I < 1 || iM40272I > 5 || ((iM40272I == 1 || iM40272I == 5) && (contentRecord == null || contentRecord.m41484af() == null || TextUtils.isEmpty(contentRecord.m41484af().getIconUrl())))) {
            return 2;
        }
        AbstractC7185ho.m43821b("RewardAdPresenter", "request orientation %s", Integer.valueOf(i10));
        if (AbstractC7811dd.m48298a(i10) || iM40272I == 1) {
            return iM40272I;
        }
        return 2;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: b */
    public void mo46189b() {
        this.f34190b.mo46606b();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: c */
    public void mo46194c(C7305h c7305h) {
        this.f34935e = c7305h;
        this.f34189a = C7580pn.m46793a(c7305h);
        Context context = this.f34934d;
        this.f34190b = new C7560ou(context, new C7667sp(context), this.f34189a);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: b */
    public void mo46190b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.np.3

            /* renamed from: a */
            final /* synthetic */ String f34942a;

            public AnonymousClass3(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                File file = new File(str);
                if (AbstractC7731ae.m47464d(file)) {
                    VideoInfo videoInfoM41419S = C7521np.this.f34189a == null ? null : C7521np.this.f34189a.m41419S();
                    if (videoInfoM41419S == null || !AbstractC7731ae.m47452a(videoInfoM41419S.m40493g(), file)) {
                        AbstractC7185ho.m43820b("RewardAdPresenter", "delete invalid cacheFile.");
                        AbstractC7731ae.m47441a(C7521np.this.f34934d, str, Constants.NORMAL_CACHE);
                    }
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: c */
    public boolean mo46195c() {
        ContentRecord contentRecord;
        if (!AbstractC7811dd.m48330g() || (contentRecord = this.f34189a) == null) {
            return false;
        }
        return "3".equalsIgnoreCase(contentRecord.m41483ae());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: a */
    public View mo46178a(IRemoteCreator iRemoteCreator, BinderC6978bv binderC6978bv, ContentRecord contentRecord, C7305h c7305h) {
        if (iRemoteCreator != null && contentRecord != null) {
            String strM47742b = AbstractC7758be.m47742b(AdContentData.m39271a(this.f34934d, contentRecord));
            Bundle bundle = new Bundle();
            bundle.putBinder(ParamConstants.Param.CONTEXT, (IBinder) ObjectWrapper.wrap(this.f34934d));
            bundle.putString("content", strM47742b);
            bundle.putInt(ParamConstants.Param.SDK_VERSION, 30476300);
            bundle.putBoolean("isMute", c7305h.m44939Y());
            bundle.putBoolean(ParamConstants.RewardCfg.REWARDED, c7305h.m44947ab());
            bundle.putBoolean("alertSwitch", c7305h.m44951af());
            bundle.putInt("audioFocusType", c7305h.m44952ag());
            try {
                View view = (View) ObjectWrapper.unwrap(iRemoteCreator.newRewardTemplateView(bundle, binderC6978bv));
                if (view == null) {
                    AbstractC7185ho.m43823c("RewardAdPresenter", "remote view is null.");
                    return null;
                }
                iRemoteCreator.bindData(ObjectWrapper.wrap(view), strM47742b);
                AbstractC7185ho.m43821b("RewardAdPresenter", "bind data end, contentId: %s", contentRecord.m41588n());
                return view;
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("RewardAdPresenter", "create template view ex: %s", th2.getClass().getSimpleName());
            }
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: b */
    public void mo46191b(String str, C7305h c7305h, IRewardAdStatusListener iRewardAdStatusListener) {
        if (TextUtils.isEmpty(str) || c7305h == null || iRewardAdStatusListener == null) {
            AbstractC7185ho.m43823c("RewardAdPresenter", "directReward, param invalid.");
            return;
        }
        if (c7305h.m44947ab()) {
            AbstractC7185ho.m43820b("RewardAdPresenter", "hasRewarded, skip reward.");
            return;
        }
        c7305h.m44971h(true);
        ContentRecord contentRecordM46793a = C7580pn.m46793a(c7305h);
        mo45320d().setContentRecord(contentRecordM46793a);
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.np.2

            /* renamed from: a */
            final /* synthetic */ ContentRecord f34939a;

            /* renamed from: b */
            final /* synthetic */ IRewardAdStatusListener f34940b;

            public AnonymousClass2(ContentRecord contentRecordM46793a2, IRewardAdStatusListener iRewardAdStatusListener2) {
                contentRecord = contentRecordM46793a2;
                iRewardAdStatusListener = iRewardAdStatusListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                new C6922c(C7521np.this.f34934d).m39124e(contentRecord);
                iRewardAdStatusListener.onRewarded();
            }
        });
        m46183a(str, contentRecordM46793a2, c7305h);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: a */
    public String mo46179a(int i10, int i11, C7305h c7305h) {
        Resources resources = this.f34934d.getResources();
        return c7305h.m44947ab() ? i10 > 0 ? String.format(Locale.ENGLISH, "%s | %s", resources.getQuantityString(C6849R.plurals.hiad_reward_countdown, i10, Integer.valueOf(i10)), resources.getString(C6849R.string.hiad_reward_awarded_success)) : resources.getString(C6849R.string.hiad_reward_awarded_success) : String.format(Locale.ENGLISH, "%s | %s", resources.getQuantityString(C6849R.plurals.hiad_reward_countdown, i10, Integer.valueOf(i10)), resources.getQuantityString(C6849R.plurals.hiad_reward_before_rw_time_countdown, i11, Integer.valueOf(i11)));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: b */
    public boolean mo46192b(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return false;
        }
        return C7756bc.m47706a(contentRecord.m41388C());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: a */
    public void mo46180a() {
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: b */
    public boolean mo46193b(C7305h c7305h) {
        AppInfo appInfo = c7305h.getAppInfo();
        return C7756bc.m47710e(c7305h.m44904D()) && !C7830i.m48419a(this.f34934d, appInfo == null ? "" : appInfo.getPackageName());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: a */
    public void mo46181a(long j10, int i10, Integer num) {
        String strM45322f = m45322f();
        C7305h c7305h = this.f34935e;
        if (c7305h != null) {
            AbstractC7185ho.m43818a("RewardAdPresenter", "slotId: %s, contentId: %s, slot pos: %s", c7305h.m44932R(), this.f34935e.getContentId(), strM45322f);
        }
        C7586a.a aVar = new C7586a.a();
        aVar.m46874a(Long.valueOf(j10)).m46873a(Integer.valueOf(i10)).m46884d(strM45322f).m46885e(m45323g()).m46878b(num);
        this.f34190b.mo46593a(aVar.m46877a());
    }

    /* renamed from: a */
    private void m46173a(AbstractC7687ti abstractC7687ti, int i10, MaterialClickInfo materialClickInfo) {
        C7587b.a aVar = new C7587b.a();
        aVar.m46920b(abstractC7687ti.m47250c()).m46915a(Integer.valueOf(i10)).m46914a(materialClickInfo);
        this.f34190b.mo46594a(aVar.m46918a());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: a */
    public void mo46182a(String str, ContentRecord contentRecord) {
        AbstractC7185ho.m43820b("RewardAdPresenter", "report Type is " + str);
        new C6928i(this.f34934d).m39219d(contentRecord, str);
    }

    /* renamed from: a */
    public void m46183a(String str, ContentRecord contentRecord, C7305h c7305h) {
        Context context = this.f34934d;
        C7560ou c7560ou = new C7560ou(context, new C7667sp(context), contentRecord);
        AbstractC7185ho.m43818a("RewardAdPresenter", "onAdRewarded, createEvent start:%s", str);
        c7560ou.mo46601a(c7305h.m44647k(), c7305h.m44649l(), "");
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: a */
    public void mo46184a(String str, C7305h c7305h, IRewardAdStatusListener iRewardAdStatusListener) {
        if (c7305h == null || TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43823c("RewardAdPresenter", "invalid status");
            return;
        }
        AbstractC7185ho.m43821b("RewardAdPresenter", "notifyReward, condition:%s", str);
        if (c7305h.m44947ab()) {
            return;
        }
        if ("1".equals(str) || str.equals(c7305h.m44946aa()) || "-1".equals(str)) {
            AbstractC7185ho.m43818a("RewardAdPresenter", "onAdRewarded, condition: %s", str);
            mo46191b(str, c7305h, iRewardAdStatusListener);
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.np.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7521np.this.mo45320d().mo49489c();
                }
            });
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: a */
    public void mo46185a(boolean z10) {
        InterfaceC7615qq interfaceC7615qq = this.f34190b;
        if (interfaceC7615qq == null) {
            return;
        }
        interfaceC7615qq.mo46615b(z10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: a */
    public boolean mo46186a(int i10, MaterialClickInfo materialClickInfo) {
        C7305h c7305h = this.f34935e;
        if (c7305h == null) {
            return false;
        }
        c7305h.m44962e(true);
        AbstractC7185ho.m43818a("RewardAdPresenter", "begin to deal click, clickSource: %s", Integer.valueOf(i10));
        HashMap map = new HashMap();
        map.put("appId", this.f34935e.m44916J());
        map.put("thirdId", this.f34935e.m44914I());
        map.put(AdShowExtras.DOWNLOAD_SOURCE, String.valueOf(5));
        AbstractC7687ti abstractC7687tiM47245a = C7686th.m47245a(this.f34934d, this.f34189a, map);
        boolean zMo47233a = abstractC7687tiM47245a.mo47233a();
        if (zMo47233a) {
            m46173a(abstractC7687tiM47245a, i10, materialClickInfo);
        }
        return zMo47233a;
    }

    /* renamed from: a */
    public static boolean m46174a(ContentRecord contentRecord) {
        return contentRecord != null && contentRecord.m41568i() != null && "1".equals(contentRecord.m41483ae()) && "4".equals(contentRecord.m41568i().m40273J());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: a */
    public boolean mo46187a(C7305h c7305h) {
        if (c7305h == null) {
            return false;
        }
        return C7756bc.m47709d(c7305h.m44904D());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7537oe
    /* renamed from: a */
    public boolean mo46188a(String str, int i10) {
        if (TextUtils.isEmpty(str) || AbstractC7806cz.m48181j(str)) {
            this.f34937g = 0;
            return false;
        }
        if (this.f34936f == i10) {
            this.f34937g++;
        } else {
            this.f34937g = 0;
            this.f34936f = i10;
        }
        return this.f34937g > 25;
    }
}
