package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.template.downloadbuttonstyle.RemoteButtonStyleAttr;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.InterfaceC5109d;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.constant.RewardKeys;
import com.huawei.openalliance.p169ad.constant.RewardMethods;
import com.huawei.openalliance.p169ad.constant.StatusChangeMethods;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.download.app.C7045d;
import com.huawei.openalliance.p169ad.download.app.C7049h;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.RewardItem;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7831j;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.bv */
/* loaded from: classes8.dex */
public class BinderC6978bv extends InterfaceC5109d.a {

    /* renamed from: a */
    private a f32062a;

    /* renamed from: b */
    private Context f32063b;

    /* renamed from: c */
    private ContentRecord f32064c;

    /* renamed from: d */
    private C7305h f32065d;

    /* renamed from: e */
    private C7560ou f32066e;

    /* renamed from: f */
    private WeakReference<InterfaceC8117j> f32067f;

    /* renamed from: g */
    private IPPSUiEngineCallback f32068g;

    /* renamed from: h */
    private MaterialClickInfo f32069h;

    /* renamed from: i */
    private String f32070i;

    /* renamed from: com.huawei.openalliance.ad.bv$a */
    public static class a implements AppDownloadListener {

        /* renamed from: a */
        private WeakReference<BinderC6978bv> f32081a;

        public a(BinderC6978bv binderC6978bv) {
            this.f32081a = new WeakReference<>(binderC6978bv);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onAppOpen(AppInfo appInfo) {
            BinderC6978bv binderC6978bv = this.f32081a.get();
            if (binderC6978bv == null) {
                return;
            }
            binderC6978bv.m41109a(StatusChangeMethods.APP_OPEN, (String) null);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onDownloadProgress(AppInfo appInfo, int i10) {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onStatusChanged(AppStatus appStatus, AppInfo appInfo) {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onUserCancel(AppInfo appInfo) {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onAppOpen(String str) {
        }
    }

    public BinderC6978bv(Context context, C7305h c7305h, InterfaceC8117j interfaceC8117j) {
        this.f32063b = context;
        this.f32065d = c7305h;
        this.f32064c = C7580pn.m46793a(c7305h);
        this.f32067f = new WeakReference<>(interfaceC8117j);
        Context context2 = this.f32063b;
        C7560ou c7560ou = new C7560ou(context2, new C7667sp(context2));
        this.f32066e = c7560ou;
        c7560ou.mo46590a(this.f32064c);
        if (c7305h == null || c7305h.getAppInfo() == null) {
            return;
        }
        this.f32062a = new a(this);
        C7045d.m42344a().m42350b(this.f32062a);
    }

    /* renamed from: c */
    private void m41112c(Bundle bundle) {
        ContentRecord contentRecord = this.f32064c;
        if (contentRecord == null || this.f32066e == null) {
            AbstractC7185ho.m43820b("RewardProxy", "contentRecord or eventProcessor is null");
            return;
        }
        if (bundle != null) {
            try {
                if (contentRecord.m41577k() != null && this.f32064c.m41577k().equals(this.f32070i)) {
                    AbstractC7185ho.m43821b("RewardProxy", "Duplicate escalation videoTime event for %s", this.f32064c.m41577k());
                } else {
                    this.f32066e.mo46580a(bundle.getLong(ParamConstants.Param.VIDEO_PLAY_TIME));
                    this.f32070i = this.f32064c.m41577k();
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("RewardProxy", "reportPlayTime err: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: d */
    private void m41114d() {
        this.f32066e.mo46606b();
    }

    /* renamed from: e */
    private void m41116e() {
        InterfaceC8117j interfaceC8117j = this.f32067f.get();
        if (interfaceC8117j == null) {
            AbstractC7185ho.m43823c("RewardProxy", "handle show nonWifi, view is null.");
        } else {
            interfaceC8117j.mo49497i();
            m41124a("showNonWifiPlay", true, (String) null);
        }
    }

    /* renamed from: f */
    private void m41118f() {
        InterfaceC8117j interfaceC8117j = this.f32067f.get();
        if (interfaceC8117j != null) {
            m41124a(RewardMethods.SHOW_DOWNLOAD_CONFIRM, interfaceC8117j.mo49491c(false), (String) null);
        } else {
            AbstractC7185ho.m43823c("RewardProxy", "handle download confirm, view is null");
        }
    }

    /* renamed from: g */
    private void m41120g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        C7154gk c7154gk = new C7154gk(bundle);
        C7586a.a aVar = new C7586a.a();
        aVar.m46874a(Long.valueOf(c7154gk.m43587c("show_duration"))).m46873a(Integer.valueOf(c7154gk.m43582b("show_ratio"))).m46885e(c7154gk.m43588d(MapKeyNames.CREATIVE_SIZE)).m46884d(c7154gk.m43588d("show_position")).m46883c(c7154gk.m43580a("isInteractiveImp"));
        int iM43582b = c7154gk.m43582b("imp_source");
        if (-1 != iM43582b) {
            aVar.m46878b(Integer.valueOf(iM43582b));
        }
        this.f32066e.mo46593a(aVar.m46877a());
    }

    /* renamed from: h */
    private void m41122h(Bundle bundle) {
        InterfaceC8117j interfaceC8117j = this.f32067f.get();
        int iM43575a = bundle != null ? new C7154gk(bundle).m43575a(RewardKeys.RWD_GN_TIME, -1) : -1;
        if (interfaceC8117j == null) {
            AbstractC7185ho.m43823c("RewardProxy", "handle close confirm, view is null.");
        } else {
            interfaceC8117j.mo49477a(iM43575a);
            m41124a(RewardMethods.SHOW_CLOSE_CONFIRM, true, (String) null);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
    /* renamed from: b */
    public Bundle mo30512b(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        return null;
    }

    /* renamed from: c */
    private void m41113c(AppDownloadButton appDownloadButton, Bundle bundle) {
        if (appDownloadButton == null || bundle == null) {
            return;
        }
        AbstractC7185ho.m43817a("RewardProxy", "update btn clickInfo start");
        String strM43588d = new C7154gk(bundle).m43588d("click_info");
        if (AbstractC7806cz.m48165b(strM43588d)) {
            AbstractC7185ho.m43823c("RewardProxy", "update btn clickInfo failed:  clickInfoStr is empty");
            return;
        }
        MaterialClickInfo materialClickInfo = (MaterialClickInfo) AbstractC7758be.m47739b(strM43588d, MaterialClickInfo.class, new Class[0]);
        if (materialClickInfo == null) {
            AbstractC7185ho.m43823c("RewardProxy", "update btn clickInfo failed:  clickInfo Object is null");
        } else {
            this.f32069h = materialClickInfo;
            appDownloadButton.m48702a(materialClickInfo);
        }
    }

    /* renamed from: d */
    private void m41115d(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        C7154gk c7154gk = new C7154gk(bundle);
        long jM43587c = c7154gk.m43587c("show_duration");
        int iM43582b = c7154gk.m43582b("show_ratio");
        int iM43582b2 = c7154gk.m43582b("video_played_time");
        int iM43582b3 = c7154gk.m43582b("video_progress");
        C7559ot c7559ot = new C7559ot();
        c7559ot.m46491b(Integer.valueOf(iM43582b2));
        c7559ot.m46489a(Integer.valueOf(iM43582b3));
        this.f32066e.mo46582a(jM43587c, iM43582b, c7559ot);
    }

    /* renamed from: e */
    private void m41117e(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        C7154gk c7154gk = new C7154gk(bundle);
        int iM43582b = c7154gk.m43582b("click_source");
        String strM43588d = c7154gk.m43588d("click_destination");
        String strM43588d2 = c7154gk.m43588d("click_info");
        AbstractC7185ho.m43820b("RewardProxy", "reportClickEvent.");
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("RewardProxy", "materiaClickInfo: %s", strM43588d2);
        }
        C7587b.a aVar = new C7587b.a();
        aVar.m46920b(strM43588d).m46915a(Integer.valueOf(iM43582b)).m46914a((MaterialClickInfo) AbstractC7758be.m47739b(strM43588d2, MaterialClickInfo.class, new Class[0]));
        this.f32066e.mo46594a(aVar.m46918a());
    }

    /* renamed from: f */
    private void m41119f(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.f32066e.mo46615b(new C7154gk(bundle).m43580a("is_mute"));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m41121g(java.lang.String r10, android.os.Bundle r11) {
        /*
            r9 = this;
            java.lang.String r0 = "RewardProxy"
            if (r11 == 0) goto L75
            com.huawei.openalliance.ad.ou r1 = r9.f32066e
            if (r1 != 0) goto La
            goto L75
        La:
            com.huawei.openalliance.ad.gk r1 = new com.huawei.openalliance.ad.gk     // Catch: java.lang.Throwable -> L41
            r1.<init>(r11)     // Catch: java.lang.Throwable -> L41
            java.lang.String r11 = "video_start_ts"
            long r3 = r1.m43587c(r11)     // Catch: java.lang.Throwable -> L41
            java.lang.String r11 = "video_end_ts"
            long r5 = r1.m43587c(r11)     // Catch: java.lang.Throwable -> L41
            java.lang.String r11 = "video_start_time"
            int r7 = r1.m43582b(r11)     // Catch: java.lang.Throwable -> L41
            java.lang.String r11 = "video_end_time"
            int r8 = r1.m43582b(r11)     // Catch: java.lang.Throwable -> L41
            int r11 = r10.hashCode()     // Catch: java.lang.Throwable -> L41
            r1 = -1891923166(0xffffffff8f3b8b22, float:-9.246608E-30)
            r2 = 1
            if (r11 == r1) goto L43
            r1 = -493598457(0xffffffffe2944907, float:-1.3676901E21)
            if (r11 == r1) goto L37
            goto L4d
        L37:
            java.lang.String r11 = "playEnd"
            boolean r10 = r10.equals(r11)     // Catch: java.lang.Throwable -> L41
            if (r10 == 0) goto L4d
            r10 = 0
            goto L4e
        L41:
            r9 = move-exception
            goto L64
        L43:
            java.lang.String r11 = "playPause"
            boolean r10 = r10.equals(r11)     // Catch: java.lang.Throwable -> L41
            if (r10 == 0) goto L4d
            r10 = r2
            goto L4e
        L4d:
            r10 = -1
        L4e:
            if (r10 == 0) goto L5e
            if (r10 == r2) goto L58
            java.lang.String r9 = "report end or pause fall to default."
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r0, r9)     // Catch: java.lang.Throwable -> L41
            goto L75
        L58:
            com.huawei.openalliance.ad.ou r2 = r9.f32066e     // Catch: java.lang.Throwable -> L41
            r2.mo46608b(r3, r5, r7, r8)     // Catch: java.lang.Throwable -> L41
            goto L75
        L5e:
            com.huawei.openalliance.ad.ou r2 = r9.f32066e     // Catch: java.lang.Throwable -> L41
            r2.mo46617c(r3, r5, r7, r8)     // Catch: java.lang.Throwable -> L41
            goto L75
        L64:
            java.lang.Class r9 = r9.getClass()
            java.lang.String r9 = r9.getSimpleName()
            java.lang.Object[] r9 = new java.lang.Object[]{r9}
            java.lang.String r10 = "reportPauseOrEnd err: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43824c(r0, r10, r9)
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.BinderC6978bv.m41121g(java.lang.String, android.os.Bundle):void");
    }

    /* renamed from: a */
    public void m41123a(long j10) {
        ContentRecord contentRecord;
        C7305h c7305h = this.f32065d;
        if (c7305h != null) {
            c7305h.m44622c(j10);
            this.f32065d.m44642h(String.valueOf(j10));
        }
        if (this.f32066e == null || (contentRecord = this.f32064c) == null) {
            return;
        }
        contentRecord.m41536c(String.valueOf(j10));
        this.f32064c.m41560g(j10);
        this.f32066e.mo46590a(this.f32064c);
    }

    /* renamed from: b */
    public void m41125b() {
        C7045d.m42344a().m42352c(this.f32062a);
    }

    /* renamed from: b */
    private void m41110b(IObjectWrapper iObjectWrapper, Bundle bundle) {
        if (iObjectWrapper == null || bundle == null) {
            return;
        }
        AbstractC7185ho.m43820b("RewardProxy", "update btn style");
        int iM43582b = new C7154gk(bundle).m43582b(ParamConstants.BtnParams.DOWNLOAD_BUTTON_STYLE);
        if (4 == iM43582b) {
            RemoteButtonStyleAttr remoteButtonStyleAttrM41065a = C6974br.m41065a(bundle);
            if (remoteButtonStyleAttrM41065a == null) {
                AbstractC7185ho.m43823c("RewardProxy", "attr null");
            } else {
                m41101a(iObjectWrapper, iM43582b, remoteButtonStyleAttrM41065a);
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
    /* renamed from: a */
    public void mo30506a(Bundle bundle) {
        InterfaceC8117j interfaceC8117j = this.f32067f.get();
        if (interfaceC8117j != null) {
            interfaceC8117j.mo49498j();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
    /* renamed from: c */
    public void mo30515c(String str, Bundle bundle) {
        InterfaceC8117j interfaceC8117j = this.f32067f.get();
        if (interfaceC8117j != null) {
            interfaceC8117j.mo49483a(str, (RewardItem) AbstractC7758be.m47739b(new C7154gk(bundle).m43588d(RewardKeys.REWARD_ITEM), RewardItem.class, new Class[0]));
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
    /* renamed from: d */
    public void mo30516d(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
        }
        AbstractC7185ho.m43821b("RewardProxy", "showDialog, type: %s", str);
        str.hashCode();
        switch (str) {
            case "showCloseConfirm":
                m41122h(bundle);
                break;
            case "showNonWifiPlay":
                m41116e();
                break;
            case "showDownloadConfirm":
                m41118f();
                break;
            default:
                AbstractC7185ho.m43820b("RewardProxy", "showDialog, fall to default.");
                break;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
    /* renamed from: e */
    public void mo30517e(String str, Bundle bundle) {
        Integer numM48178h = AbstractC7806cz.m48178h(str);
        if (numM48178h == null) {
            AbstractC7185ho.m43823c("RewardProxy", "invalid status, skip handle.");
            return;
        }
        InterfaceC8117j interfaceC8117j = this.f32067f.get();
        if (interfaceC8117j == null) {
            AbstractC7185ho.m43823c("RewardProxy", "rewardView is null, skip status handle.");
        } else {
            interfaceC8117j.mo49478a(numM48178h.intValue(), bundle);
        }
    }

    /* renamed from: f */
    public void m41126f(String str, Bundle bundle) {
        if (this.f32068g == null) {
            AbstractC7185ho.m43823c("RewardProxy", "on call back, call back is null");
            return;
        }
        AbstractC7185ho.m43821b("RewardProxy", "onCallback, method: %s", str);
        try {
            this.f32068g.onCallResult(str, bundle);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("RewardProxy", "onCallback ex: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m41101a(IObjectWrapper iObjectWrapper, int i10, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        if (iObjectWrapper == null) {
            return;
        }
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        if (view instanceof AppDownloadButton) {
            AbstractC7185ho.m43820b("RewardProxy", "update btn start");
            AppDownloadButton appDownloadButton = (AppDownloadButton) view;
            if (this.f32067f.get() == null) {
                return;
            }
            C6974br.m41066a(this.f32063b, appDownloadButton, i10, remoteButtonStyleAttr);
        }
    }

    /* renamed from: b */
    private void m41111b(AppDownloadButton appDownloadButton, Bundle bundle) {
        if (appDownloadButton == null || bundle == null) {
            return;
        }
        AbstractC7185ho.m43817a("RewardProxy", "update btn content start");
        long jM43587c = new C7154gk(bundle).m43587c(RewardKeys.SHOW_TIME);
        Long lValueOf = Long.valueOf(jM43587c);
        if (jM43587c == 0) {
            AbstractC7185ho.m43823c("RewardProxy", "update btn content failed: showTime is empty");
        } else {
            appDownloadButton.updateStartShowTime(jM43587c);
            appDownloadButton.updateContent(String.valueOf(lValueOf));
        }
    }

    /* renamed from: a */
    private void m41102a(IObjectWrapper iObjectWrapper, Bundle bundle) {
        AbstractC7185ho.m43820b("RewardProxy", "update btn data start");
        if (iObjectWrapper == null || bundle == null) {
            return;
        }
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        if (!(view instanceof AppDownloadButton)) {
            AbstractC7185ho.m43823c("RewardProxy", "update btn data failed: btn's type is not AppDownloadButton");
            return;
        }
        AppDownloadButton appDownloadButton = (AppDownloadButton) view;
        m41111b(appDownloadButton, bundle);
        m41113c(appDownloadButton, bundle);
        m41106a(appDownloadButton, bundle);
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
    /* renamed from: b */
    public void mo30513b(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
        }
        AbstractC7185ho.m43821b("RewardProxy", "reportEvent, type: %s", str);
        str.hashCode();
        switch (str) {
            case "playPause":
            case "playEnd":
                m41121g(str, bundle);
                break;
            case "playStart":
                this.f32066e.mo46616c();
                break;
            case "showstart":
                m41114d();
                break;
            case "onSoundClick":
                m41119f(bundle);
                break;
            case "phyImp":
                m41115d(bundle);
                break;
            case "imp":
                m41120g(bundle);
                break;
            case "click":
                m41117e(bundle);
                break;
            case "playResume":
                this.f32066e.mo46623f();
                break;
            case "playTime":
                m41112c(bundle);
                break;
            default:
                AbstractC7185ho.m43820b("RewardProxy", "reportEvent, fall to default");
                break;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
    /* renamed from: a */
    public void mo30507a(IObjectWrapper iObjectWrapper, final String str, Bundle bundle) {
        if (iObjectWrapper == null || bundle == null) {
            return;
        }
        C7154gk c7154gk = new C7154gk(bundle);
        int iM43582b = c7154gk.m43582b(ParamConstants.BtnParams.DOWNLOAD_BUTTON_STYLE);
        boolean zM43581a = c7154gk.m43581a(ParamConstants.BtnParams.APP_RELATED, false);
        String strM43579a = c7154gk.m43579a("download_text", (String) null);
        String strM43579a2 = c7154gk.m43579a("installed_text", (String) null);
        final int iM43575a = c7154gk.m43575a("btn_source", 5);
        RemoteButtonStyleAttr remoteButtonStyleAttrM41065a = 4 == iM43582b ? C6974br.m41065a(bundle) : null;
        if (remoteButtonStyleAttrM41065a == null) {
            iM43582b = 2;
        }
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        if (view instanceof AppDownloadButton) {
            if (this.f32064c.m41388C() == 0) {
                view.setVisibility(8);
                return;
            }
            final InterfaceC8117j interfaceC8117j = this.f32067f.get();
            if (interfaceC8117j == null) {
                AbstractC7185ho.m43823c("RewardProxy", "regBtn, rewardView ref is null.");
                return;
            }
            AbstractC7185ho.m43820b("RewardProxy", "registerDownloadBtn");
            final AppDownloadButton appDownloadButton = (AppDownloadButton) view;
            C6974br.m41067b(this.f32063b, appDownloadButton, iM43582b, remoteButtonStyleAttrM41065a);
            if (zM43581a) {
                AbstractC7185ho.m43820b("RewardProxy", "register btn");
                appDownloadButton.setAdLandingPageData(new AdLandingPageData(this.f32064c, this.f32063b, true));
                if (!TextUtils.isEmpty(strM43579a2)) {
                    appDownloadButton.setAfDlBtnText(strM43579a2);
                }
                if (!TextUtils.isEmpty(strM43579a)) {
                    appDownloadButton.setDlBtnText(strM43579a);
                }
                m41107a(appDownloadButton, interfaceC8117j);
            } else {
                AbstractC7185ho.m43817a("RewardProxy", "show btn");
                appDownloadButton.m49965a(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.bv.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        BinderC6978bv.this.m41105a(appDownloadButton, iM43575a, false);
                        interfaceC8117j.mo49478a(2, (Bundle) null);
                    }
                });
                appDownloadButton.setButtonTextWatcherInner(new AppDownloadButton.InterfaceC7878e() { // from class: com.huawei.openalliance.ad.bv.2
                    @Override // com.huawei.openalliance.p169ad.views.AppDownloadButton.InterfaceC7878e
                    /* renamed from: a */
                    public CharSequence mo30554a(CharSequence charSequence, AppStatus appStatus) {
                        return C7831j.m48456a(str, BinderC6978bv.this.f32063b.getString(C6849R.string.hiad_detail));
                    }
                });
            }
            appDownloadButton.setSource(iM43575a);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
    /* renamed from: b */
    public boolean mo30514b(Bundle bundle) {
        InterfaceC8117j interfaceC8117j = this.f32067f.get();
        if (interfaceC8117j == null || bundle == null) {
            return false;
        }
        C7154gk c7154gk = new C7154gk(bundle);
        return interfaceC8117j.mo49486a(c7154gk.m43575a("click_source", 7), (MaterialClickInfo) AbstractC7758be.m47739b(c7154gk.m43588d("click_info"), MaterialClickInfo.class, new Class[0]));
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
    /* renamed from: a */
    public void mo30508a(IPPSUiEngineCallback iPPSUiEngineCallback) {
        this.f32068g = iPPSUiEngineCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m41105a(AppDownloadButton appDownloadButton, int i10, boolean z10) {
        String str = AppStatus.INSTALLED == appDownloadButton.getStatus() ? "app" : "";
        Bundle bundle = new Bundle();
        bundle.putInt("btn_source", i10);
        bundle.putBoolean("is_handled", z10);
        bundle.putString("click_destination", str);
        m41126f(RewardMethods.ON_BTN_CLICK, bundle);
    }

    /* renamed from: a */
    private void m41106a(AppDownloadButton appDownloadButton, Bundle bundle) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("RewardProxy", "update btn click source");
        }
        C7154gk c7154gk = new C7154gk(bundle);
        int iM43575a = c7154gk.m43575a("btn_source", -111111);
        boolean zM43581a = c7154gk.m43581a(RewardKeys.IS_BTN_ONCE_SOURCE, false);
        if (iM43575a == -111111) {
            AbstractC7185ho.m43820b("RewardProxy", "no need update source");
        } else if (zM43581a) {
            appDownloadButton.setOnceSource(iM43575a);
        } else {
            appDownloadButton.setSource(iM43575a);
        }
    }

    /* renamed from: a */
    private void m41107a(AppDownloadButton appDownloadButton, final InterfaceC8117j interfaceC8117j) {
        appDownloadButton.setClickActionListener(new InterfaceC8131x() { // from class: com.huawei.openalliance.ad.bv.3
            @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
            /* renamed from: a */
            public void mo30555a(AppDownloadButton appDownloadButton2) {
                BinderC6978bv.this.m41105a(appDownloadButton2, appDownloadButton2.getSource(), false);
            }

            @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
            /* renamed from: b */
            public void mo30556b(AppDownloadButton appDownloadButton2) {
                BinderC6978bv.this.m41105a(appDownloadButton2, appDownloadButton2.getSource(), true);
            }
        });
        appDownloadButton.m48703a(new AppDownloadButton.InterfaceC7875b() { // from class: com.huawei.openalliance.ad.bv.4
            @Override // com.huawei.openalliance.p169ad.views.AppDownloadButton.InterfaceC7875b
            /* renamed from: a */
            public void mo30557a() {
                interfaceC8117j.mo49478a(2, (Bundle) null);
            }
        });
        appDownloadButton.setOnDownloadStatusChangedListener(new AppDownloadButton.OnDownloadStatusChangedListener() { // from class: com.huawei.openalliance.ad.bv.5
            @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
            public void onStatusChanged(AppStatus appStatus) {
                AbstractC7185ho.m43818a("RewardProxy", "onStatusChanged:%s", appStatus);
                BinderC6978bv.this.m41109a(StatusChangeMethods.STATUS_CHANGE, appStatus.name());
            }

            @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
            public void onUserCancel(AppInfo appInfo) {
                BinderC6978bv.this.m41109a(StatusChangeMethods.CANCEL_DOWN, (String) null);
            }
        });
    }

    /* renamed from: a */
    private void m41108a(String str) {
        C7305h c7305h;
        AppInfo appInfo;
        if (TextUtils.isEmpty(str) || (c7305h = this.f32065d) == null || (appInfo = c7305h.getAppInfo()) == null) {
        }
        AbstractC7185ho.m43821b("RewardProxy", "handleAppElementClick, type: %s", str);
        str.hashCode();
        switch (str) {
            case "showAppDesc":
                MaterialClickInfo materialClickInfo = this.f32069h;
                if (materialClickInfo != null && AbstractC7806cz.m48187p(materialClickInfo.m44508c()) && this.f32069h.m44501a() != null) {
                    this.f32065d.m44605a(this.f32063b, this.f32069h);
                    break;
                } else {
                    this.f32065d.showAppDetailPage(this.f32063b);
                    break;
                }
                break;
            case "showPrivacy":
                appInfo.showPrivacyPolicy(this.f32063b);
                break;
            case "showPermission":
                boolean zIsEmpty = TextUtils.isEmpty(appInfo.getPermissionUrl());
                Context context = this.f32063b;
                if (!zIsEmpty) {
                    appInfo.showPermissionPage(context);
                    break;
                } else {
                    C7049h.m42419a(context, appInfo);
                    break;
                }
            default:
                AbstractC7185ho.m43820b("RewardProxy", "handle app element click, fall to default");
                break;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
    /* renamed from: a */
    public void mo30509a(String str, Bundle bundle) {
        new C6971bo(this.f32063b).m41055a(str, bundle, this.f32064c, this.f32066e);
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
    /* renamed from: a */
    public void mo30510a(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
        }
        AbstractC7185ho.m43821b("RewardProxy", "callMethod: %s", str);
        str.hashCode();
        switch (str) {
            case "reportCommonEvent":
                new C6972bp(this.f32063b).m41058a(bundle, this.f32064c, this.f32066e);
                break;
            case "showAppDesc":
            case "showPrivacy":
            case "showPermission":
                m41108a(str);
                break;
            case "update_btn_style":
                m41110b(iObjectWrapper, bundle);
                break;
            case "update_btn_data":
                m41102a(iObjectWrapper, bundle);
                break;
            default:
                AbstractC7185ho.m43820b("RewardProxy", "call method fall to default.");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m41109a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("app_status_method", str);
        if (str2 != null) {
            bundle.putString("app_status", str2);
        }
        m41126f("notifyAppStatus", bundle);
    }

    /* renamed from: a */
    public void m41124a(String str, boolean z10, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(RewardKeys.DIALOG_TYPE, str);
        bundle.putBoolean(RewardKeys.IS_DISPLAYING, z10);
        bundle.putString(RewardKeys.DIALOG_CLICK_TYPE, str2);
        try {
            m41126f(RewardMethods.NOTIFY_DIALOG_STATUS, bundle);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("RewardProxy", "notify dialog status ex: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
    /* renamed from: a */
    public boolean mo30511a() {
        return AbstractC7741ao.m47548a(this.f32063b, this.f32064c);
    }
}
