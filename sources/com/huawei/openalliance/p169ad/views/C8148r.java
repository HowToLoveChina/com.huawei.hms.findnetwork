package com.huawei.openalliance.p169ad.views;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.uiengine.C5111f;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.common.IInterstitialView;
import com.huawei.hms.ads.uiengine.common.InterstitialApi;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7687ti;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7084e;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7154gk;
import com.huawei.openalliance.p169ad.C7405lo;
import com.huawei.openalliance.p169ad.C7495nc;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7563ox;
import com.huawei.openalliance.p169ad.C7686th;
import com.huawei.openalliance.p169ad.EnumC7480mo;
import com.huawei.openalliance.p169ad.InterfaceC7416lz;
import com.huawei.openalliance.p169ad.RunnableC7714ui;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.inner.AdContentData;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.constant.InterstitialMethods;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.views.PPSInterstitialView;
import java.util.HashMap;

/* renamed from: com.huawei.openalliance.ad.views.r */
/* loaded from: classes2.dex */
public class C8148r extends AutoScaleSizeRelativeLayout implements IInterstitialView {

    /* renamed from: a */
    private Context f38078a;

    /* renamed from: b */
    private ContentRecord f38079b;

    /* renamed from: c */
    private InterstitialApi f38080c;

    /* renamed from: d */
    private IInterstitialView f38081d;

    /* renamed from: e */
    private IRemoteCreator f38082e;

    /* renamed from: f */
    private C7495nc f38083f;

    /* renamed from: g */
    private C7560ou f38084g;

    /* renamed from: h */
    private PPSInterstitialView.InterfaceC7956b f38085h;

    /* renamed from: i */
    private InterfaceC7311a f38086i;

    /* renamed from: j */
    private C7301d f38087j;

    /* renamed from: k */
    private int f38088k;

    /* renamed from: l */
    private int f38089l;

    /* renamed from: m */
    private String f38090m;

    /* renamed from: n */
    private Dialog f38091n;

    /* renamed from: o */
    private InterfaceC7416lz f38092o;

    /* renamed from: p */
    private boolean f38093p;

    public C8148r(Context context) {
        super(context);
        this.f38089l = 0;
        this.f38092o = new C7405lo();
        this.f38093p = false;
        m50461a(context, (AttributeSet) null);
    }

    /* renamed from: i */
    private boolean m50464i() {
        ContentRecord contentRecord = this.f38079b;
        return contentRecord != null && contentRecord.m41464aP() == 3;
    }

    /* renamed from: j */
    private IInterstitialView m50465j() {
        int iMo43390bQ = C7124fh.m43316b(this.f38078a).mo43390bQ();
        AbstractC7185ho.m43821b("PPSInterstitialViewContainer", "ite is %s", Integer.valueOf(iMo43390bQ));
        PPSInterstitialView pPSInterstitialView = new PPSInterstitialView(this.f38078a);
        pPSInterstitialView.setFullScreen(iMo43390bQ);
        pPSInterstitialView.setOnCloseListener(this.f38085h);
        pPSInterstitialView.addInterstitialAdStatusListener(this.f38086i);
        pPSInterstitialView.m49192a(this.f38087j, this.f38088k, this.f38090m);
        return pPSInterstitialView;
    }

    /* renamed from: k */
    private void m50466k() {
        C7154gk c7154gk = new C7154gk();
        int iMo43392bS = C7124fh.m43316b(this.f38078a).mo43392bS();
        int iMo43389bP = C7124fh.m43316b(this.f38078a).mo43389bP();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSInterstitialViewContainer", "iteAdCa is %s, iteAdCloseTm is %s", Integer.valueOf(iMo43392bS), Integer.valueOf(iMo43389bP));
        }
        c7154gk.m43583b("ite_ad_ca", iMo43392bS);
        c7154gk.m43583b("ite_ad_close_tm", iMo43389bP);
        IInterstitialView iInterstitialView = this.f38081d;
        if (iInterstitialView != null) {
            iInterstitialView.onCallBack(InterstitialMethods.SEND_INIT_INFO, c7154gk.m43577a());
        }
    }

    /* renamed from: l */
    private Bundle m50467l() {
        C7154gk c7154gk = new C7154gk();
        c7154gk.m43585b("content", AbstractC7758be.m47742b(AdContentData.m39271a(this.f38078a, this.f38079b)));
        c7154gk.m43583b(ParamConstants.Param.SDK_VERSION, 30476300);
        boolean zM48340p = AbstractC7811dd.m48340p(this.f38078a);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSInterstitialViewContainer", "emui9Dark %s", Boolean.valueOf(zM48340p));
        }
        c7154gk.m43586b(ParamConstants.Param.EMUI9_DARK_MODE, zM48340p);
        c7154gk.m43578a(ParamConstants.Param.CONTEXT, (IBinder) ObjectWrapper.wrap(this.f38078a));
        c7154gk.m43586b("isMute", this.f38087j.m44714U());
        c7154gk.m43586b("alertSwitch", this.f38087j.m44729ae());
        return c7154gk.m43577a();
    }

    /* renamed from: a */
    public void m50468a() {
        this.f38086i = null;
    }

    /* renamed from: b */
    public void m50474b() {
        AbstractC7817dj.m48363a(new RunnableC7714ui(this));
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void bindData(String str) {
    }

    /* renamed from: c */
    public void m50475c() {
        setNonwifiDialog(null);
        IInterstitialView iInterstitialView = this.f38081d;
        if (iInterstitialView != null) {
            iInterstitialView.setIsNeedRemindData(false);
        }
        resumeVideoView();
    }

    /* renamed from: d */
    public void m50476d() {
        setNonwifiDialog(null);
        m50477e();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void destroyView() {
        IInterstitialView iInterstitialView = this.f38081d;
        if (iInterstitialView != null) {
            iInterstitialView.destroyView();
        }
    }

    /* renamed from: e */
    public void m50477e() {
        PPSInterstitialView.InterfaceC7956b interfaceC7956b = this.f38085h;
        if (interfaceC7956b != null) {
            interfaceC7956b.mo38736b();
        }
        C7495nc c7495nc = this.f38083f;
        if (c7495nc != null) {
            c7495nc.m45930b();
        }
        m50473a((Integer) 3);
        m50478f();
        m50469a(4, (Bundle) null);
    }

    /* renamed from: f */
    public void m50478f() {
        InterfaceC7416lz interfaceC7416lz = this.f38092o;
        if (interfaceC7416lz != null) {
            interfaceC7416lz.mo45618e();
        }
    }

    /* renamed from: g */
    public Bundle m50479g() {
        m50469a(2, (Bundle) null);
        m50478f();
        return m50480h();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public ViewGroup getContentContainer() {
        return null;
    }

    public Dialog getNonwifiDialog() {
        return this.f38091n;
    }

    /* renamed from: h */
    public Bundle m50480h() {
        HashMap map = new HashMap();
        C7301d c7301d = this.f38087j;
        if (c7301d != null) {
            map.put("appId", c7301d.m44696J());
            map.put("thirdId", this.f38087j.m44694I());
        }
        AbstractC7687ti abstractC7687tiM47245a = C7686th.m47245a(this.f38078a, this.f38079b, map);
        if (!abstractC7687tiM47245a.mo47233a()) {
            return null;
        }
        m50469a(7, (Bundle) null);
        C7154gk c7154gk = new C7154gk();
        c7154gk.m43585b("click_destination", abstractC7687tiM47245a.m47250c());
        m50473a((Integer) 1);
        return c7154gk.m43577a();
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void onAppStatusChanged(String str) {
        IInterstitialView iInterstitialView = this.f38081d;
        if (iInterstitialView != null) {
            iInterstitialView.onAppStatusChanged(str);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void onBtnClick(Bundle bundle) {
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void onCallBack(String str, Bundle bundle) {
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void pauseView() {
        IInterstitialView iInterstitialView = this.f38081d;
        if (iInterstitialView != null) {
            iInterstitialView.pauseView();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void resumeVideoView() {
        IInterstitialView iInterstitialView = this.f38081d;
        if (iInterstitialView != null) {
            iInterstitialView.resumeVideoView();
        }
    }

    public void setCompleted(boolean z10) {
        this.f38093p = z10;
        if (z10) {
            m50469a(3, (Bundle) null);
        }
    }

    public void setEventProcessor(C7560ou c7560ou) {
        this.f38084g = c7560ou;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void setIsNeedRemindData(boolean z10) {
    }

    public void setNonwifiDialog(Dialog dialog) {
        this.f38091n = dialog;
    }

    public void setOnCloseListener(PPSInterstitialView.InterfaceC7956b interfaceC7956b) {
        if (interfaceC7956b == null) {
            return;
        }
        this.f38085h = interfaceC7956b;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void setProxy(InterstitialApi interstitialApi) {
    }

    /* renamed from: a */
    public void m50469a(int i10, Bundle bundle) {
        int iM43575a;
        if (this.f38086i == null) {
            AbstractC7185ho.m43820b("PPSInterstitialViewContainer", "onStatusChange listener is null.");
        }
        AbstractC7185ho.m43821b("PPSInterstitialViewContainer", "status is: %s.", Integer.valueOf(i10));
        switch (i10) {
            case 1:
                this.f38086i.mo38577a();
                break;
            case 2:
                this.f38086i.mo38579b();
                break;
            case 3:
                this.f38086i.mo38580c();
                break;
            case 4:
                this.f38086i.mo38581d();
                break;
            case 5:
                int i11 = -1;
                if (bundle != null) {
                    C7154gk c7154gk = new C7154gk(bundle);
                    int iM43575a2 = c7154gk.m43575a("error_code", -1);
                    iM43575a = c7154gk.m43575a("error_extra", -1);
                    i11 = iM43575a2;
                } else {
                    iM43575a = -1;
                }
                this.f38086i.mo38578a(i11, iM43575a);
                break;
            case 6:
            default:
                AbstractC7185ho.m43820b("PPSInterstitialViewContainer", "on status change, fall to default.");
                break;
            case 7:
                this.f38086i.mo38582e();
                break;
            case 8:
                this.f38086i.mo38583f();
                break;
        }
    }

    /* renamed from: a */
    private void m50461a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        if (attributeSet != null && (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.ViewFullScreen)) != null) {
            try {
                int integer = typedArrayObtainStyledAttributes.getInteger(C6849R.styleable.ViewFullScreen_fullScreen, 0);
                this.f38089l = integer;
                AbstractC7185ho.m43821b("PPSInterstitialViewContainer", "mFullScreen %d", Integer.valueOf(integer));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f38078a = context;
    }

    /* renamed from: a */
    public void m50470a(Bundle bundle) {
        IInterstitialView iInterstitialView = this.f38081d;
        if (iInterstitialView != null) {
            iInterstitialView.onBtnClick(bundle);
        }
    }

    /* renamed from: a */
    private void m50462a(IObjectWrapper iObjectWrapper) {
        String str;
        if (iObjectWrapper == null) {
            str = "wrapper from uiengine is null.";
        } else {
            KeyEvent.Callback callback = (View) ObjectWrapper.unwrap(iObjectWrapper);
            if (callback != null) {
                if (!(callback instanceof IInterstitialView)) {
                    AbstractC7185ho.m43821b("PPSInterstitialViewContainer", "unwrap view from uiengine is %s", callback.getClass().getSimpleName());
                    return;
                }
                this.f38081d = (IInterstitialView) callback;
                m50466k();
                C5111f c5111f = new C5111f(this.f38078a, this, this.f38079b, this.f38087j);
                this.f38080c = c5111f;
                this.f38081d.setProxy(c5111f);
                this.f38081d.bindData(AbstractC7758be.m47742b(AdContentData.m39271a(this.f38078a, this.f38079b)));
                return;
            }
            str = "template view is null.";
        }
        AbstractC7185ho.m43823c("PPSInterstitialViewContainer", str);
    }

    /* renamed from: a */
    public void m50471a(C7301d c7301d, int i10, String str) {
        this.f38087j = c7301d;
        this.f38088k = i10;
        this.f38079b = C7563ox.m46653a(c7301d);
        this.f38090m = str;
        if (m50464i()) {
            Bundle bundleM50467l = m50467l();
            IRemoteCreator iRemoteCreatorM42835a = C7084e.m42835a(this.f38078a.getApplicationContext());
            this.f38082e = iRemoteCreatorM42835a;
            if (iRemoteCreatorM42835a == null) {
                AbstractC7185ho.m43823c("PPSInterstitialViewContainer", "remoteCreator is null.");
                return;
            }
            m50462a(iRemoteCreatorM42835a.newInterstitialTemplateView(bundleM50467l));
        } else {
            this.f38081d = m50465j();
        }
        if (this.f38081d != null) {
            if (m50464i()) {
                m50463a("0");
            }
            AbstractC7185ho.m43821b("PPSInterstitialViewContainer", "mInterstitialView is %s", this.f38081d.getClass().getSimpleName());
            C7495nc c7495nc = new C7495nc(this.f38078a, this.f38081d);
            this.f38083f = c7495nc;
            c7495nc.m45927a(this.f38087j);
            addView((View) this.f38081d);
            m50469a(1, (Bundle) null);
            return;
        }
        if (m50464i()) {
            m50463a("1");
        }
        AbstractC7185ho.m43820b("PPSInterstitialViewContainer", "mInterstitialView is null, finish activity.");
        InterfaceC7311a interfaceC7311a = this.f38086i;
        if (interfaceC7311a != null) {
            interfaceC7311a.mo38578a(ErrorCode.ERROR_CODE_NULL_AD_VIEW, ErrorCode.ERROR_CODE_NULL_AD_VIEW);
        }
        PPSInterstitialView.InterfaceC7956b interfaceC7956b = this.f38085h;
        if (interfaceC7956b != null) {
            interfaceC7956b.mo38736b();
        }
    }

    /* renamed from: a */
    public void m50472a(InterfaceC7311a interfaceC7311a) {
        if (interfaceC7311a == null) {
            return;
        }
        this.f38086i = interfaceC7311a;
    }

    /* renamed from: a */
    public void m50473a(Integer num) {
        if (this.f38092o == null || num == null) {
            AbstractC7185ho.m43823c("PPSInterstitialViewContainer", "omPresent or impSource is null.");
            return;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 1) {
            this.f38092o.mo45610a(EnumC7480mo.CLICK);
        } else if (iIntValue == 3 && !this.f38093p) {
            this.f38092o.mo45623j();
            this.f38092o.mo45613b();
        }
    }

    /* renamed from: a */
    private void m50463a(String str) {
        new C6922c(this.f38078a).mo39104a(str, C7084e.m42836a(), this.f38079b);
    }
}
