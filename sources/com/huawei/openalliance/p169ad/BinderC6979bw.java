package com.huawei.openalliance.p169ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.ISplashApi;
import com.huawei.openalliance.p169ad.activity.SplashFeedbackActivity;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.bw */
/* loaded from: classes8.dex */
public class BinderC6979bw extends ISplashApi.AbstractBinderC5105a {

    /* renamed from: a */
    protected InterfaceC7615qq f32082a;

    /* renamed from: b */
    private InterfaceC7328jb f32083b;

    /* renamed from: c */
    private ContentRecord f32084c;

    /* renamed from: d */
    private Context f32085d;

    /* renamed from: e */
    private WeakReference<Context> f32086e;

    /* renamed from: f */
    private String f32087f;

    /* renamed from: g */
    private C6922c f32088g;

    public BinderC6979bw(Context context, InterfaceC7328jb interfaceC7328jb, ContentRecord contentRecord) {
        this.f32085d = context.getApplicationContext();
        this.f32086e = new WeakReference<>(context);
        this.f32083b = interfaceC7328jb;
        this.f32084c = contentRecord;
        this.f32082a = new C7560ou(context, new C7668sq(context, 1), contentRecord);
        this.f32088g = new C6922c(this.f32085d);
    }

    /* renamed from: a */
    private void m41127a(Bundle bundle) {
        try {
            this.f32082a.mo46615b(bundle.getBoolean("isMute"));
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("SplashProxy", "reportSoundClickEvent err: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    private void m41128b(Bundle bundle) {
        this.f32082a.mo46616c();
    }

    /* renamed from: c */
    private void m41129c(Bundle bundle) {
        try {
            this.f32082a.mo46617c(bundle.getLong("startTime"), bundle.getLong("endTime"), (int) bundle.getLong(ParamConstants.Param.START_PROGRESS), (int) bundle.getLong(ParamConstants.Param.END_PROGRESS));
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("SplashProxy", "reportPlayEnd err: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: d */
    private void m41130d(Bundle bundle) {
        ContentRecord contentRecord = this.f32084c;
        if (contentRecord == null || this.f32082a == null) {
            AbstractC7185ho.m43820b("SplashProxy", "contentRecord or eventProcessor is null");
            return;
        }
        if (bundle != null) {
            try {
                if (contentRecord.m41577k() != null && this.f32084c.m41577k().equals(this.f32087f)) {
                    AbstractC7185ho.m43821b("SplashProxy", "Duplicate escalation videoTime event for %s", this.f32084c.m41577k());
                } else {
                    this.f32082a.mo46580a(bundle.getLong(ParamConstants.Param.VIDEO_PLAY_TIME));
                    this.f32087f = this.f32084c.m41577k();
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("SplashProxy", "reportPlayTime err: %s", th2.getClass().getSimpleName());
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AbstractC7185ho.m43821b("SplashProxy", "callMethod: %s", str);
        str.hashCode();
        if (str.equals("reportCommonEvent")) {
            new C6972bp(this.f32085d).m41058a(bundle, this.f32084c, this.f32082a);
        } else if (str.equals("onCommonAnalysis")) {
            new C6971bo(this.f32085d).m41054a(bundle, this.f32084c, this.f32082a);
        } else {
            AbstractC7185ho.m43820b("SplashProxy", "call method fall to default.");
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public Bundle callMethodForResult(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        return null;
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean isDestroyed() {
        if (this.f32086e.get() instanceof Activity) {
            return ((Activity) this.f32086e.get()).isDestroyed();
        }
        return false;
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean isFinishing() {
        if (this.f32086e.get() instanceof Activity) {
            return ((Activity) this.f32086e.get()).isFinishing();
        }
        return false;
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void notifyAdDismissed() {
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45183j();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void notifyAdFailedToLoad(int i10) {
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45168c(i10);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public String notifyAdLoaded() {
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb == null) {
            return null;
        }
        interfaceC7328jb.mo45152a(this.f32084c);
        return this.f32083b.mo45198y();
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onAdFailToDisplay() {
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45209B();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onAdShowEnd(long j10, int i10) {
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45153a(this.f32084c, j10, i10);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onDisplayTimeUp() {
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45194u();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onEasterEggPrepare() {
        AbstractC7185ho.m43817a("SplashProxy", "onEasterEggPrepare");
        C7582pp.m46808a(this.f32085d).m46815a(this.f32084c.m41478ab());
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onFeedback(int i10) {
        AbstractC7185ho.m43820b("SplashProxy", "onFeedback");
        new C6928i(this.f32085d).m39208a("145", "", "", "");
        Intent intent = new Intent(this.f32085d, (Class<?>) SplashFeedbackActivity.class);
        intent.setPackage(this.f32085d.getPackageName());
        intent.putExtra(MapKeyNames.SPLASH_CLICKABLE_TYPE, i10);
        if (!(this.f32085d instanceof Activity)) {
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
        AbstractC7811dd.m48294a(this.f32085d, intent);
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45176f();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onMaterialLoadFailed() {
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45178f(this.f32084c);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onMaterialLoaded() {
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45192s();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onSkipAd(int i10, int i11) {
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45150a(i10, i11);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onStartEasterEggFailed(Bundle bundle) {
        AbstractC7185ho.m43817a("SplashProxy", "onStartEasterEggFailed");
        C7582pp.m46808a(this.f32085d).m46817a(this.f32084c.m41478ab(), bundle);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean onTouch(int i10, int i11, long j10, String str, int i12) {
        AbstractC7185ho.m43820b("SplashProxy", "onTouch");
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb != null) {
            return interfaceC7328jb.mo45162a(i10, i11, this.f32084c, Long.valueOf(j10), (MaterialClickInfo) AbstractC7758be.m47739b(str, MaterialClickInfo.class, new Class[0]), i12);
        }
        return false;
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean processWhyEventUnified() {
        return AbstractC7741ao.m47548a(this.f32085d, this.f32084c);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void removeExSplashBlock() {
        AbstractC7741ao.m47585i(this.f32085d);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void reportEvents(String str, Bundle bundle) {
        if (AbstractC7806cz.m48165b(str)) {
        }
        str.hashCode();
        switch (str) {
            case "playStart":
                m41128b(bundle);
                break;
            case "playEnd":
                m41129c(bundle);
                break;
            case "rptSoundBtnEvent":
                m41127a(bundle);
                break;
            case "playTime":
                m41130d(bundle);
                break;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void reportShowStartEvent() {
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45182i();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void reportSplashEvent(Bundle bundle) {
        C6922c c6922c = this.f32088g;
        if (c6922c != null) {
            c6922c.m39063a(bundle, this.f32084c);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void toShowSpare(int i10) {
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45164b(i10);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void updatePhyShowStart(long j10) {
        InterfaceC7328jb interfaceC7328jb = this.f32083b;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45151a(j10);
        }
    }
}
