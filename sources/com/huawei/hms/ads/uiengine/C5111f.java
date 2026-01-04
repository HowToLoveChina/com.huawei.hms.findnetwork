package com.huawei.hms.ads.uiengine;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.template.downloadbuttonstyle.RemoteButtonStyleAttr;
import com.huawei.hms.ads.uiengine.common.InterstitialApi;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6971bo;
import com.huawei.openalliance.p169ad.C6972bp;
import com.huawei.openalliance.p169ad.C6974br;
import com.huawei.openalliance.p169ad.C7154gk;
import com.huawei.openalliance.p169ad.C7211ie;
import com.huawei.openalliance.p169ad.C7559ot;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7663sl;
import com.huawei.openalliance.p169ad.InterfaceC7316iq;
import com.huawei.openalliance.p169ad.constant.InterstitialKeys;
import com.huawei.openalliance.p169ad.constant.InterstitialMethods;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.download.app.C7049h;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7831j;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.C8148r;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.hms.ads.uiengine.f */
/* loaded from: classes8.dex */
public class C5111f implements InterstitialApi {

    /* renamed from: a */
    private String f23310a = "";

    /* renamed from: b */
    private Context f23311b;

    /* renamed from: c */
    private ContentRecord f23312c;

    /* renamed from: d */
    private C7560ou f23313d;

    /* renamed from: e */
    private C7301d f23314e;

    /* renamed from: f */
    private WeakReference<C8148r> f23315f;

    /* renamed from: g */
    private AppDownloadButton f23316g;

    /* renamed from: com.huawei.hms.ads.uiengine.f$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C5111f c5111f = C5111f.this;
            c5111f.m30538a(c5111f.f23316g, false);
        }
    }

    /* renamed from: com.huawei.hms.ads.uiengine.f$2 */
    public class AnonymousClass2 implements AppDownloadButton.InterfaceC7878e {

        /* renamed from: a */
        final /* synthetic */ String f23318a;

        public AnonymousClass2(String str) {
            str = str;
        }

        @Override // com.huawei.openalliance.p169ad.views.AppDownloadButton.InterfaceC7878e
        /* renamed from: a */
        public CharSequence mo30554a(CharSequence charSequence, AppStatus appStatus) {
            return C7831j.m48456a(str, C5111f.this.f23311b.getString(C6849R.string.hiad_detail));
        }
    }

    /* renamed from: com.huawei.hms.ads.uiengine.f$3 */
    public class AnonymousClass3 implements InterfaceC8131x {
        public AnonymousClass3() {
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
        /* renamed from: a */
        public void mo30555a(AppDownloadButton appDownloadButton) {
            C5111f.this.m30538a(appDownloadButton, false);
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
        /* renamed from: b */
        public void mo30556b(AppDownloadButton appDownloadButton) {
            AbstractC7185ho.m43820b("InterstitialProxy", "DownloadButton onClickActionValid.");
            C5111f.this.m30538a(appDownloadButton, true);
        }
    }

    /* renamed from: com.huawei.hms.ads.uiengine.f$4 */
    public class AnonymousClass4 implements AppDownloadButton.InterfaceC7875b {
        public AnonymousClass4() {
        }

        @Override // com.huawei.openalliance.p169ad.views.AppDownloadButton.InterfaceC7875b
        /* renamed from: a */
        public void mo30557a() {
            C8148r c8148r = (C8148r) C5111f.this.f23315f.get();
            if (c8148r != null) {
                c8148r.m50469a(2, (Bundle) null);
            }
        }
    }

    /* renamed from: com.huawei.hms.ads.uiengine.f$5 */
    public class AnonymousClass5 implements AppDownloadButton.OnDownloadStatusChangedListener {
        public AnonymousClass5() {
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
        public void onStatusChanged(AppStatus appStatus) {
            if (appStatus == null || C5111f.this.f23315f.get() == null) {
                return;
            }
            AbstractC7185ho.m43818a("InterstitialProxy", "onStatusChanged, status:%s", appStatus.toString());
            ((C8148r) C5111f.this.f23315f.get()).onAppStatusChanged(appStatus.toString());
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
        public void onUserCancel(AppInfo appInfo) {
        }
    }

    /* renamed from: com.huawei.hms.ads.uiengine.f$a */
    public static class a implements InterfaceC7316iq {

        /* renamed from: a */
        private WeakReference<C5111f> f23323a;

        /* renamed from: b */
        private VideoInfo f23324b;

        public a(C5111f c5111f, VideoInfo videoInfo) {
            this.f23323a = new WeakReference<>(c5111f);
            this.f23324b = videoInfo;
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC7316iq
        /* renamed from: a */
        public void mo30558a(int i10) {
            AbstractC7185ho.m43824c("InterstitialProxy", "InterstitialStreamListener onError, code is %s.", Integer.valueOf(i10));
            C5111f c5111f = this.f23323a.get();
            if (c5111f == null) {
                AbstractC7185ho.m43823c("InterstitialProxy", "proxy is null.");
                return;
            }
            C7154gk c7154gk = new C7154gk();
            c7154gk.m43583b(InterstitialKeys.STREAM_ERROR_CODE, i10);
            VideoInfo videoInfo = this.f23324b;
            if (videoInfo != null && !TextUtils.isEmpty(videoInfo.m44586g())) {
                c7154gk.m43584b(InterstitialKeys.STREAM_DATA_CONSUME, C7211ie.m43919a().m43922a(this.f23324b.m44586g()));
            }
            c5111f.m30553a(InterstitialMethods.NOTIFY_STREAM_ERROR, c7154gk.m43577a());
        }
    }

    public C5111f(Context context, C8148r c8148r, ContentRecord contentRecord, C7301d c7301d) {
        this.f23311b = context;
        this.f23315f = new WeakReference<>(c8148r);
        this.f23312c = contentRecord;
        this.f23314e = c7301d;
        C7560ou c7560ou = new C7560ou(context, new C7663sl(context));
        this.f23313d = c7560ou;
        c7560ou.mo46590a(contentRecord);
    }

    /* renamed from: a */
    private Bundle m30532a() {
        C8148r c8148r = this.f23315f.get();
        if (c8148r != null) {
            return c8148r.m50479g();
        }
        AbstractC7185ho.m43823c("InterstitialProxy", "handleVideoClick, container is null.");
        return null;
    }

    /* renamed from: d */
    private void m30547d(Bundle bundle) {
        if (bundle == null) {
            AbstractC7185ho.m43823c("InterstitialProxy", "reportSoundClick, param is null.");
        } else {
            this.f23313d.mo46615b(new C7154gk(bundle).m43580a("is_mute"));
        }
    }

    /* renamed from: e */
    private void m30548e(Bundle bundle) {
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
        this.f23313d.mo46593a(aVar.m46877a());
    }

    /* renamed from: f */
    private void m30549f(Bundle bundle) {
        String str;
        if (this.f23316g == null || bundle == null) {
            str = "null btn or param";
        } else {
            C7154gk c7154gk = new C7154gk(bundle);
            AbstractC7185ho.m43820b("InterstitialProxy", "update btn");
            int iM43582b = c7154gk.m43582b(ParamConstants.BtnParams.DOWNLOAD_BUTTON_STYLE);
            if (4 != iM43582b) {
                return;
            }
            RemoteButtonStyleAttr remoteButtonStyleAttrM41065a = C6974br.m41065a(bundle);
            if (remoteButtonStyleAttrM41065a != null) {
                C6974br.m41066a(this.f23311b, this.f23316g, iM43582b, remoteButtonStyleAttrM41065a);
                return;
            }
            str = "attr null";
        }
        AbstractC7185ho.m43823c("InterstitialProxy", str);
    }

    /* renamed from: g */
    private void m30550g(Bundle bundle) {
        MaterialClickInfo materialClickInfo = (MaterialClickInfo) AbstractC7758be.m47737b(this.f23311b, new C7154gk(bundle).m43588d("click_info"), MaterialClickInfo.class, new Class[0]);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("InterstitialProxy", "updateBtnClickInfo, clickInfo is %s.", materialClickInfo);
        }
        AppDownloadButton appDownloadButton = this.f23316g;
        if (appDownloadButton != null) {
            appDownloadButton.m48702a(materialClickInfo);
        }
    }

    /* renamed from: h */
    private void m30551h(Bundle bundle) {
        if (this.f23315f.get() == null || this.f23314e == null) {
            AbstractC7185ho.m43823c("InterstitialProxy", "showAppDesc, container or interstitial is null.");
            return;
        }
        MaterialClickInfo materialClickInfo = (MaterialClickInfo) AbstractC7758be.m47737b(this.f23311b, new C7154gk(bundle).m43588d("click_info"), MaterialClickInfo.class, new Class[0]);
        if (materialClickInfo == null || !AbstractC7806cz.m48187p(materialClickInfo.m44508c()) || materialClickInfo.m44501a() == null) {
            this.f23314e.showAppDetailPage(this.f23311b);
        } else {
            AbstractC7185ho.m43817a("InterstitialProxy", "showAppDesc with clickInfo.");
            this.f23314e.m44605a(this.f23311b, materialClickInfo);
        }
    }

    /* renamed from: i */
    private Bundle m30552i(Bundle bundle) {
        if (bundle == null) {
            AbstractC7185ho.m43823c("InterstitialProxy", "getProxyUrl, param is null");
            return null;
        }
        C7154gk c7154gk = new C7154gk(bundle);
        String strM43588d = c7154gk.m43588d(InterstitialKeys.ORI_URL);
        String strM43588d2 = c7154gk.m43588d("sha256");
        AbstractC7185ho.m43821b("InterstitialProxy", "getProxyUrl, videoUrl is %s, sha256 is %s.", strM43588d, strM43588d2);
        if (!AbstractC7806cz.m48181j(strM43588d) || AbstractC7806cz.m48165b(strM43588d2)) {
            AbstractC7185ho.m43820b("InterstitialProxy", "videoUrl or sha256 is invalid.");
            return null;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.m44584f(strM43588d);
        videoInfo.m44577d(strM43588d2);
        String strM47541a = AbstractC7741ao.m47541a(this.f23311b, videoInfo, new a(this, videoInfo));
        AbstractC7185ho.m43821b("InterstitialProxy", "proxyUrl is %s.", strM47541a);
        C7154gk c7154gk2 = new C7154gk();
        c7154gk2.m43585b(InterstitialKeys.PROXY_URL, strM47541a);
        return c7154gk2.m43577a();
    }

    @Override // com.huawei.hms.ads.uiengine.common.InterstitialApi
    public Bundle callMethod(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AbstractC7185ho.m43821b("InterstitialProxy", "callMethod: %s", str);
        str.hashCode();
        switch (str) {
            case "reportCommonEvent":
                new C6972bp(this.f23311b).m41058a(bundle, this.f23312c, this.f23313d);
                return null;
            case "showNonWifiPlay":
                m30544c();
                return null;
            case "showAppDesc":
            case "showPrivacy":
            case "showPermission":
                m30546c(str, bundle);
                return null;
            case "onAdClick":
                return m30532a();
            case "update_btn_style":
                m30549f(bundle);
                return null;
            case "updateBtnClickInfo":
                m30550g(bundle);
                return null;
            case "queryProxyUrl":
                return m30552i(bundle);
            case "handleClose":
                m30540b();
                return null;
            default:
                AbstractC7185ho.m43820b("InterstitialProxy", "call method default.");
                return null;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.InterstitialApi
    public void onAnalysis(String str, Bundle bundle) {
        new C6971bo(this.f23311b).m41055a(str, bundle, this.f23312c, this.f23313d);
    }

    @Override // com.huawei.hms.ads.uiengine.common.InterstitialApi
    public boolean processWhyEventUnified() {
        return AbstractC7741ao.m47548a(this.f23311b, this.f23312c);
    }

    @Override // com.huawei.hms.ads.uiengine.common.InterstitialApi
    public void registerBtn(View view, Bundle bundle) {
        int i10;
        String str;
        if (view == null || bundle == null) {
            AbstractC7185ho.m43823c("InterstitialProxy", "btn or param is null.");
            return;
        }
        C7154gk c7154gk = new C7154gk(bundle);
        int iM43582b = c7154gk.m43582b(ParamConstants.BtnParams.DOWNLOAD_BUTTON_STYLE);
        boolean zM43581a = c7154gk.m43581a(ParamConstants.BtnParams.APP_RELATED, false);
        String strM43579a = c7154gk.m43579a("download_text", (String) null);
        String strM43579a2 = c7154gk.m43579a("installed_text", (String) null);
        String strM43579a3 = c7154gk.m43579a(InterstitialKeys.BTN_TEXT, "");
        int iM43575a = c7154gk.m43575a("btn_source", 5);
        RemoteButtonStyleAttr remoteButtonStyleAttrM41065a = 4 == iM43582b ? C6974br.m41065a(bundle) : null;
        if (remoteButtonStyleAttrM41065a == null) {
            iM43582b = 2;
        }
        if (AbstractC7185ho.m43819a()) {
            Integer numValueOf = Integer.valueOf(iM43582b);
            Boolean boolValueOf = Boolean.valueOf(zM43581a);
            Integer numValueOf2 = Integer.valueOf(iM43575a);
            i10 = iM43575a;
            str = strM43579a3;
            AbstractC7185ho.m43818a("InterstitialProxy", "btnStyle is %s, isAppRelated is %s, downloadText is %s, installedText is %s, btnText is %s, btnSource is %s.", numValueOf, boolValueOf, strM43579a, strM43579a2, strM43579a3, numValueOf2);
        } else {
            i10 = iM43575a;
            str = strM43579a3;
        }
        if (!(view instanceof AppDownloadButton)) {
            AbstractC7185ho.m43821b("InterstitialProxy", "btn is %s, not AppDownloadButton.", view.getClass().getSimpleName());
            return;
        }
        ContentRecord contentRecord = this.f23312c;
        if (contentRecord != null && contentRecord.m41388C() == 0) {
            view.setVisibility(8);
            return;
        }
        if (this.f23315f.get() == null) {
            AbstractC7185ho.m43823c("InterstitialProxy", "register button, interstitial container is null.");
            return;
        }
        AbstractC7185ho.m43820b("InterstitialProxy", "registerDownloadBtn");
        AppDownloadButton appDownloadButton = (AppDownloadButton) view;
        this.f23316g = appDownloadButton;
        C6974br.m41067b(this.f23311b, appDownloadButton, iM43582b, remoteButtonStyleAttrM41065a);
        if (zM43581a) {
            AbstractC7185ho.m43820b("InterstitialProxy", "register btn");
            this.f23316g.setAdLandingPageData(new AdLandingPageData(this.f23312c, this.f23311b, true));
            if (!TextUtils.isEmpty(strM43579a2)) {
                this.f23316g.setAfDlBtnText(strM43579a2);
            }
            if (!TextUtils.isEmpty(strM43579a)) {
                this.f23316g.setDlBtnText(strM43579a);
            }
            m30537a(this.f23316g);
        } else {
            AbstractC7185ho.m43817a("InterstitialProxy", "show btn.");
            this.f23316g.m49965a(new View.OnClickListener() { // from class: com.huawei.hms.ads.uiengine.f.1
                public AnonymousClass1() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    C5111f c5111f = C5111f.this;
                    c5111f.m30538a(c5111f.f23316g, false);
                }
            });
            this.f23316g.setButtonTextWatcherInner(new AppDownloadButton.InterfaceC7878e() { // from class: com.huawei.hms.ads.uiengine.f.2

                /* renamed from: a */
                final /* synthetic */ String f23318a;

                public AnonymousClass2(String str2) {
                    str = str2;
                }

                @Override // com.huawei.openalliance.p169ad.views.AppDownloadButton.InterfaceC7878e
                /* renamed from: a */
                public CharSequence mo30554a(CharSequence charSequence, AppStatus appStatus) {
                    return C7831j.m48456a(str, C5111f.this.f23311b.getString(C6849R.string.hiad_detail));
                }
            });
        }
        this.f23316g.setSource(i10);
    }

    @Override // com.huawei.hms.ads.uiengine.common.InterstitialApi
    public void reportEvent(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || this.f23313d == null) {
            AbstractC7185ho.m43823c("InterstitialProxy", "eventType or eventProcessor is null.");
            return;
        }
        AbstractC7185ho.m43821b("InterstitialProxy", "reportEvent, type: %s", str);
        str.hashCode();
        switch (str) {
            case "playPause":
            case "playEnd":
                m30542b(str, bundle);
                break;
            case "playStart":
                this.f23313d.mo46616c();
                break;
            case "showstart":
                this.f23313d.mo46606b();
                break;
            case "onSoundClick":
                m30547d(bundle);
                break;
            case "phyImp":
                m30541b(bundle);
                break;
            case "imp":
                m30548e(bundle);
                break;
            case "click":
                m30545c(bundle);
                break;
            case "playResume":
                this.f23313d.mo46623f();
                break;
            case "playTime":
                m30534a(bundle);
                break;
            default:
                AbstractC7185ho.m43820b("InterstitialProxy", "reportEvent, fail to default");
                break;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.InterstitialApi
    public void setIsVideoCompleted(boolean z10) {
        C8148r c8148r = this.f23315f.get();
        if (c8148r != null) {
            c8148r.setCompleted(z10);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.InterstitialApi
    public void updateShowId(long j10) {
        if (this.f23312c == null || this.f23313d == null) {
            AbstractC7185ho.m43820b("InterstitialProxy", "updateShowId, contentRecord or eventProcessor is null");
            return;
        }
        AbstractC7185ho.m43817a("InterstitialProxy", "updateShowId");
        C7301d c7301d = this.f23314e;
        if (c7301d != null) {
            c7301d.m44622c(j10);
            this.f23314e.m44642h(String.valueOf(j10));
        }
        this.f23312c.m41560g(j10);
        this.f23312c.m41536c(String.valueOf(j10));
        this.f23313d.mo46590a(this.f23312c);
        AppDownloadButton appDownloadButton = this.f23316g;
        if (appDownloadButton != null) {
            appDownloadButton.updateStartShowTime(j10);
            this.f23316g.updateContent(String.valueOf(j10));
        }
    }

    /* renamed from: b */
    private void m30540b() {
        C8148r c8148r = this.f23315f.get();
        if (c8148r == null) {
            AbstractC7185ho.m43823c("InterstitialProxy", "handleClose, container is null.");
        } else {
            c8148r.m50477e();
        }
    }

    /* renamed from: c */
    private void m30544c() {
        C8148r c8148r = this.f23315f.get();
        if (c8148r != null) {
            c8148r.pauseView();
            c8148r.m50474b();
        }
    }

    /* renamed from: a */
    private void m30534a(Bundle bundle) {
        if (bundle == null || this.f23312c == null) {
            AbstractC7185ho.m43823c("InterstitialProxy", "param or contentRecord is null.");
            return;
        }
        C7154gk c7154gk = new C7154gk(bundle);
        String str = this.f23310a;
        if (str != null && str.equals(this.f23312c.m41577k())) {
            AbstractC7185ho.m43821b("InterstitialProxy", "Duplicate escalation videoTime event for %s", this.f23312c.m41577k());
            return;
        }
        this.f23313d.mo46580a(c7154gk.m43587c(ParamConstants.Param.VIDEO_PLAY_TIME));
        this.f23310a = this.f23312c.m41577k();
    }

    /* renamed from: b */
    private void m30541b(Bundle bundle) {
        if (bundle == null) {
            AbstractC7185ho.m43823c("InterstitialProxy", "reportPhyShow, param is null.");
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
        this.f23313d.mo46582a(jM43587c, iM43582b, c7559ot);
    }

    /* renamed from: c */
    private void m30545c(Bundle bundle) {
        if (bundle == null) {
            AbstractC7185ho.m43823c("InterstitialProxy", "reportClickEvent, param is null.");
            return;
        }
        C7154gk c7154gk = new C7154gk(bundle);
        int iM43582b = c7154gk.m43582b("click_source");
        String strM43588d = c7154gk.m43588d("click_destination");
        String strM43588d2 = c7154gk.m43588d("click_info");
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("InterstitialProxy", "reportClickEvent, clickSource is %s, clickDestination is %s, materialClickInfoStr is %s.", Integer.valueOf(iM43582b), strM43588d, strM43588d2);
        }
        C7587b.a aVar = new C7587b.a();
        aVar.m46915a(Integer.valueOf(iM43582b)).m46920b(strM43588d).m46914a((MaterialClickInfo) AbstractC7758be.m47739b(strM43588d2, MaterialClickInfo.class, new Class[0]));
        this.f23313d.mo46594a(aVar.m46918a());
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x004d  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m30542b(java.lang.String r10, android.os.Bundle r11) {
        /*
            r9 = this;
            java.lang.String r0 = "InterstitialProxy"
            if (r11 == 0) goto L76
            com.huawei.openalliance.ad.ou r1 = r9.f23313d
            if (r1 != 0) goto La
            goto L76
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
            com.huawei.openalliance.ad.ou r2 = r9.f23313d     // Catch: java.lang.Throwable -> L41
            r2.mo46608b(r3, r5, r7, r8)     // Catch: java.lang.Throwable -> L41
            goto L75
        L5e:
            com.huawei.openalliance.ad.ou r2 = r9.f23313d     // Catch: java.lang.Throwable -> L41
            r2.mo46617c(r3, r5, r7, r8)     // Catch: java.lang.Throwable -> L41
            goto L75
        L64:
            java.lang.Class r9 = r9.getClass()
            java.lang.String r9 = r9.getSimpleName()
            java.lang.Object[] r9 = new java.lang.Object[]{r9}
            java.lang.String r10 = "report pause or end err: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43824c(r0, r10, r9)
        L75:
            return
        L76:
            java.lang.String r9 = "param or process is null, can't report pause or end"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43823c(r0, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengine.C5111f.m30542b(java.lang.String, android.os.Bundle):void");
    }

    /* renamed from: c */
    private void m30546c(String str, Bundle bundle) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "method is null.";
        } else {
            AppInfo appInfo = this.f23314e.getAppInfo();
            if (appInfo != null) {
                AbstractC7185ho.m43821b("InterstitialProxy", "handleAppElementClick, method is %s.", str);
                str.hashCode();
                switch (str) {
                    case "showAppDesc":
                        m30551h(bundle);
                        break;
                    case "showPrivacy":
                        appInfo.showPrivacyPolicy(this.f23311b);
                        break;
                    case "showPermission":
                        m30536a(appInfo);
                        break;
                    default:
                        AbstractC7185ho.m43820b("InterstitialProxy", "handleAppElementClick, fail to default");
                        break;
                }
            }
            str2 = "appInfo is null.";
        }
        AbstractC7185ho.m43823c("InterstitialProxy", str2);
    }

    /* renamed from: a */
    private void m30536a(AppInfo appInfo) {
        boolean zIsEmpty = TextUtils.isEmpty(appInfo.getPermissionUrl());
        Context context = this.f23311b;
        if (zIsEmpty) {
            C7049h.m42419a(context, appInfo);
        } else {
            appInfo.showPermissionPage(context);
        }
    }

    /* renamed from: a */
    private void m30537a(AppDownloadButton appDownloadButton) {
        appDownloadButton.setClickActionListener(new InterfaceC8131x() { // from class: com.huawei.hms.ads.uiengine.f.3
            public AnonymousClass3() {
            }

            @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
            /* renamed from: a */
            public void mo30555a(AppDownloadButton appDownloadButton2) {
                C5111f.this.m30538a(appDownloadButton2, false);
            }

            @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8131x
            /* renamed from: b */
            public void mo30556b(AppDownloadButton appDownloadButton2) {
                AbstractC7185ho.m43820b("InterstitialProxy", "DownloadButton onClickActionValid.");
                C5111f.this.m30538a(appDownloadButton2, true);
            }
        });
        appDownloadButton.m48703a(new AppDownloadButton.InterfaceC7875b() { // from class: com.huawei.hms.ads.uiengine.f.4
            public AnonymousClass4() {
            }

            @Override // com.huawei.openalliance.p169ad.views.AppDownloadButton.InterfaceC7875b
            /* renamed from: a */
            public void mo30557a() {
                C8148r c8148r = (C8148r) C5111f.this.f23315f.get();
                if (c8148r != null) {
                    c8148r.m50469a(2, (Bundle) null);
                }
            }
        });
        appDownloadButton.setOnDownloadStatusChangedListener(new AppDownloadButton.OnDownloadStatusChangedListener() { // from class: com.huawei.hms.ads.uiengine.f.5
            public AnonymousClass5() {
            }

            @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
            public void onStatusChanged(AppStatus appStatus) {
                if (appStatus == null || C5111f.this.f23315f.get() == null) {
                    return;
                }
                AbstractC7185ho.m43818a("InterstitialProxy", "onStatusChanged, status:%s", appStatus.toString());
                ((C8148r) C5111f.this.f23315f.get()).onAppStatusChanged(appStatus.toString());
            }

            @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
            public void onUserCancel(AppInfo appInfo) {
            }
        });
    }

    /* renamed from: a */
    public void m30538a(AppDownloadButton appDownloadButton, boolean z10) {
        C8148r c8148r = this.f23315f.get();
        if (c8148r == null) {
            AbstractC7185ho.m43823c("InterstitialProxy", "handleBtnClick, container is null.");
            return;
        }
        String strM43588d = AppStatus.INSTALLED == appDownloadButton.getStatus() ? "app" : "";
        C7154gk c7154gk = new C7154gk();
        c7154gk.m43586b(InterstitialKeys.IS_BTN_HANDLED, z10);
        if (!z10) {
            strM43588d = new C7154gk(c8148r.m50480h()).m43588d("click_destination");
        }
        if (AbstractC7806cz.m48165b(strM43588d)) {
            c8148r.m50470a((Bundle) null);
        } else {
            c7154gk.m43585b("click_destination", strM43588d);
            c8148r.m50470a(c7154gk.m43577a());
        }
    }

    /* renamed from: a */
    public void m30553a(String str, Bundle bundle) {
        C8148r c8148r = this.f23315f.get();
        if (c8148r != null) {
            c8148r.onCallBack(str, bundle);
        }
    }
}
