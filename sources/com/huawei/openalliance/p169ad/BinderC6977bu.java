package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.inner.C5077a;
import com.huawei.hms.ads.template.downloadbuttonstyle.AbstractC5096a;
import com.huawei.hms.ads.template.downloadbuttonstyle.RemoteButtonStyleAttr;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.InterfaceC5108c;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.constant.StatusChangeMethods;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.download.app.C7045d;
import com.huawei.openalliance.p169ad.download.app.C7049h;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7753b;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.utils.C7831j;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.PPSNativeView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import p208cq.InterfaceC8939g;

/* renamed from: com.huawei.openalliance.ad.bu */
/* loaded from: classes8.dex */
public class BinderC6977bu extends InterfaceC5108c.a {

    /* renamed from: a */
    AbstractC5096a f32043a;

    /* renamed from: b */
    private Context f32044b;

    /* renamed from: c */
    private WeakReference<PPSNativeView> f32045c;

    /* renamed from: d */
    private ContentRecord f32046d;

    /* renamed from: e */
    private InterfaceC7615qq f32047e;

    /* renamed from: f */
    private C7302e f32048f;

    /* renamed from: g */
    private IPPSUiEngineCallback f32049g;

    /* renamed from: h */
    private String f32050h;

    /* renamed from: i */
    private b f32051i;

    /* renamed from: com.huawei.openalliance.ad.bu$1 */
    public class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ PPSNativeView f32052a;

        /* renamed from: b */
        final /* synthetic */ AppDownloadButton f32053b;

        public AnonymousClass1(PPSNativeView pPSNativeView, AppDownloadButton appDownloadButton) {
            pPSNativeView = pPSNativeView;
            appDownloadButton = appDownloadButton;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BinderC6977bu.m41084a(pPSNativeView, appDownloadButton);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.bu$2 */
    public class AnonymousClass2 implements AppDownloadButton.InterfaceC7878e {

        /* renamed from: a */
        final /* synthetic */ RemoteButtonStyleAttr f32055a;

        /* renamed from: b */
        final /* synthetic */ String f32056b;

        public AnonymousClass2(RemoteButtonStyleAttr remoteButtonStyleAttr, String str) {
            remoteButtonStyleAttr = remoteButtonStyleAttr;
            str = str;
        }

        @Override // com.huawei.openalliance.p169ad.views.AppDownloadButton.InterfaceC7878e
        /* renamed from: a */
        public CharSequence mo30554a(CharSequence charSequence, AppStatus appStatus) {
            return BinderC6977bu.this.m41074a(remoteButtonStyleAttr != null ? !TextUtils.isEmpty(r1.m30405G()) : false, str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.bu$3 */
    public class AnonymousClass3 implements AppDownloadButton.OnDownloadStatusChangedListener {
        public AnonymousClass3() {
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
        public void onStatusChanged(AppStatus appStatus) {
            AbstractC7185ho.m43818a("NativeProxy", "onStatusChanged: %s", appStatus);
            if (appStatus == null) {
                appStatus = AppStatus.DOWNLOAD;
            }
            BinderC6977bu.this.m41085a(StatusChangeMethods.STATUS_CHANGE, appStatus.name());
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
        public void onUserCancel(AppInfo appInfo) {
            BinderC6977bu.this.m41085a(StatusChangeMethods.CANCEL_DOWN, (String) null);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.bu$a */
    public static class a implements InterfaceC8939g<Boolean> {

        /* renamed from: a */
        private final WeakReference<BinderC6977bu> f32059a;

        /* renamed from: b */
        private final int f32060b;

        public a(BinderC6977bu binderC6977bu, int i10) {
            this.f32059a = new WeakReference<>(binderC6977bu);
            this.f32060b = i10;
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(Boolean bool) {
            AbstractC7185ho.m43821b("NativeProxy", "onSuccess ret: %s.", bool);
            BinderC6977bu binderC6977bu = this.f32059a.get();
            if (binderC6977bu == null) {
                AbstractC7185ho.m43823c("NativeProxy", "proxy is null");
            } else {
                AbstractC7185ho.m43820b("NativeProxy", "proxy adClickSixElementsBtn");
                binderC6977bu.m41090b(this.f32060b);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.bu$b */
    public static class b implements AppDownloadListener {

        /* renamed from: a */
        private final WeakReference<BinderC6977bu> f32061a;

        public b(BinderC6977bu binderC6977bu) {
            this.f32061a = new WeakReference<>(binderC6977bu);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
        public void onAppOpen(AppInfo appInfo) {
            BinderC6977bu binderC6977bu = this.f32061a.get();
            if (binderC6977bu == null) {
                return;
            }
            binderC6977bu.m41085a(StatusChangeMethods.APP_OPEN, (String) null);
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

    public BinderC6977bu(Context context, PPSNativeView pPSNativeView, C7302e c7302e) {
        this.f32044b = context;
        this.f32045c = new WeakReference<>(pPSNativeView);
        this.f32048f = c7302e;
        this.f32046d = C7570pd.m46698a(c7302e);
        this.f32047e = new C7560ou(context, new C7665sn(context, c7302e == null ? 3 : c7302e.m44632e()), this.f32046d);
        if (c7302e == null || c7302e.getAppInfo() == null) {
            return;
        }
        this.f32051i = new b(this);
        C7045d.m42344a().m42350b(this.f32051i);
    }

    /* renamed from: b */
    private RemoteButtonStyleAttr m41088b(Bundle bundle) {
        if (new C7154gk(bundle).m43582b(ParamConstants.BtnParams.DOWNLOAD_BUTTON_STYLE) != 3) {
            return null;
        }
        return C6974br.m41065a(bundle);
    }

    /* renamed from: h */
    private boolean m41094h() {
        return C7084e.m42836a() != null && Integer.parseInt(C7084e.m42836a()) >= 30468100;
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: c */
    public void mo30501c() {
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: d */
    public boolean mo30502d() {
        return this.f32048f.m44790Y();
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: e */
    public boolean mo30503e() throws RemoteException {
        if (C7780c.m47861a()) {
            throw new RemoteException("Use engine down!");
        }
        return C6973bq.m41062a(this.f32044b, this.f32046d);
    }

    /* renamed from: f */
    public void m41098f() {
        AbstractC5096a abstractC5096a = this.f32043a;
        if (abstractC5096a != null) {
            abstractC5096a.m30452b();
            this.f32043a = null;
        }
        C7045d.m42344a().m42352c(this.f32051i);
    }

    /* renamed from: a */
    public String m41074a(boolean z10, String str) {
        return z10 ? str : C7831j.m48456a(str, this.f32044b.getString(C6849R.string.hiad_detail));
    }

    /* renamed from: b */
    private AppDownloadButton m41089b(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        if (!(view instanceof AppDownloadButton)) {
            return null;
        }
        AppDownloadButton appDownloadButton = (AppDownloadButton) view;
        if (this.f32045c.get() == null) {
            return null;
        }
        return appDownloadButton;
    }

    /* renamed from: c */
    private void m41092c(Bundle bundle) {
        ContentRecord contentRecord = this.f32046d;
        if (contentRecord == null || this.f32047e == null) {
            AbstractC7185ho.m43820b("NativeProxy", "contentRecord or eventProcessor is null");
            return;
        }
        if (bundle != null) {
            try {
                if (contentRecord.m41577k() != null && this.f32046d.m41577k().equals(this.f32050h)) {
                    AbstractC7185ho.m43821b("NativeProxy", "Duplicate escalation videoTime event for %s", this.f32046d.m41577k());
                } else {
                    this.f32047e.mo46580a(bundle.getLong(ParamConstants.Param.VIDEO_PLAY_TIME));
                    this.f32050h = this.f32046d.m41577k();
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("NativeProxy", "reportPlayTime err: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: a */
    private String m41075a(boolean z10, String str, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        if (remoteButtonStyleAttr == null) {
            return str;
        }
        if (z10) {
            return remoteButtonStyleAttr.m30403E();
        }
        int interActionType = this.f32048f.getInterActionType();
        return ((interActionType == 1 || interActionType == 3) && !TextUtils.isEmpty(remoteButtonStyleAttr.m30403E())) ? remoteButtonStyleAttr.m30403E() : str;
    }

    /* renamed from: c */
    private void m41093c(IObjectWrapper iObjectWrapper, Bundle bundle) {
        if (iObjectWrapper == null || bundle == null) {
            return;
        }
        AbstractC7185ho.m43820b("NativeProxy", "update btn style");
        RemoteButtonStyleAttr remoteButtonStyleAttrM41088b = m41088b(bundle);
        if (remoteButtonStyleAttrM41088b == null) {
            AbstractC7185ho.m43823c("NativeProxy", "attr null");
        } else {
            m41078a(iObjectWrapper, 3, remoteButtonStyleAttrM41088b);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: b */
    public String mo30498b() {
        ContentRecord contentRecord = this.f32046d;
        if (contentRecord != null) {
            return contentRecord.m41577k();
        }
        return null;
    }

    /* renamed from: b */
    public void m41090b(int i10) {
        if (i10 == 0) {
            AbstractC7185ho.m43820b("NativeProxy", " hiadsdk's AIDL: onAdClickSixElementsBtn: DESC");
            PPSNativeView pPSNativeView = this.f32045c.get();
            if (pPSNativeView == null || pPSNativeView.getClickInfo() == null) {
                this.f32048f.showAppDetailPage(this.f32044b);
                return;
            } else {
                AbstractC7185ho.m43817a("NativeProxy", pPSNativeView.getClickInfo().toString());
                this.f32048f.m44605a(this.f32044b, pPSNativeView.getClickInfo());
                return;
            }
        }
        if (i10 == 1) {
            AbstractC7185ho.m43820b("NativeProxy", " hiadsdk's AIDL: onAdClickSixElementsBtn: PRIVACY");
            this.f32048f.getAppInfo().showPrivacyPolicyInWeb(this.f32044b);
        } else {
            if (i10 != 2) {
                return;
            }
            AbstractC7185ho.m43820b("NativeProxy", " hiadsdk's AIDL: onAdClickSixElementsBtn: PERMISSION");
            if (!TextUtils.isEmpty(this.f32048f.getAppInfo().getPermissionUrl())) {
                this.f32048f.getAppInfo().showPermissionPageInWeb(this.f32044b);
                return;
            }
            PPSNativeView pPSNativeView2 = this.f32045c.get();
            if (pPSNativeView2 != null) {
                C7049h.m42419a(pPSNativeView2.getContext(), this.f32048f.getAppInfo());
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30484a() {
        PPSNativeView pPSNativeView = this.f32045c.get();
        if (pPSNativeView != null) {
            pPSNativeView.m49354g();
        }
    }

    /* renamed from: b */
    private void m41091b(IObjectWrapper iObjectWrapper, Bundle bundle) {
        String str;
        if (iObjectWrapper == null || bundle == null) {
            return;
        }
        AbstractC7185ho.m43820b("NativeProxy", "update btn text");
        RemoteButtonStyleAttr remoteButtonStyleAttrM41088b = m41088b(bundle);
        if (remoteButtonStyleAttrM41088b == null) {
            str = "attr null";
        } else {
            AppDownloadButton appDownloadButtonM41089b = m41089b(iObjectWrapper);
            if (appDownloadButtonM41089b != null) {
                m41080a(remoteButtonStyleAttrM41088b, appDownloadButtonM41089b);
                return;
            }
            str = "btn null";
        }
        AbstractC7185ho.m43823c("NativeProxy", str);
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30485a(int i10) {
        C7302e c7302e = this.f32048f;
        if (c7302e == null || c7302e.getAppInfo() == null) {
            return;
        }
        PPSNativeView pPSNativeView = this.f32045c.get();
        if (!AbstractC7811dd.m48310b(this.f32044b) || pPSNativeView == null) {
            m41090b(i10);
        } else {
            AbstractC7185ho.m43820b("NativeProxy", "screenLocked clickSixElements");
            C5077a.m30321a(pPSNativeView.getContext(), new a(this, i10));
        }
    }

    /* renamed from: a */
    private void m41076a(int i10, String str, VideoInfo videoInfo) {
        if (videoInfo != null) {
            videoInfo.m44588g(Boolean.TRUE.toString());
            videoInfo.m44579e(i10);
            videoInfo.m44580e(str);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: b */
    public void mo30499b(String str, long j10, long j11, int i10, int i11) {
        this.f32047e.mo46584a(j10, j11, i10, i11, str);
    }

    /* renamed from: a */
    public void m41095a(long j10) {
        AbstractC7185ho.m43818a("NativeProxy", "updateStartShowTime: %s", Long.valueOf(j10));
        C7302e c7302e = this.f32048f;
        if (c7302e != null) {
            c7302e.m44603a(j10);
        }
        ContentRecord contentRecord = this.f32046d;
        if (contentRecord == null) {
            return;
        }
        contentRecord.m41560g(j10);
        this.f32047e.mo46590a(this.f32046d);
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: b */
    public void mo30500b(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals("playTime")) {
            m41092c(bundle);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30486a(long j10, long j11) {
        new C6922c(this.f32044b).mo39074a(this.f32046d, j10, j11);
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30487a(Bundle bundle) {
    }

    /* renamed from: a */
    private void m41077a(Bundle bundle, PPSNativeView pPSNativeView, int i10, String str) {
        MetaData metaDataM41568i;
        if (this.f32048f.m44808ad() == null || this.f32048f.m44808ad().intValue() != 3 || (metaDataM41568i = this.f32046d.m41568i()) == null) {
            return;
        }
        try {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("NativeProxy", "video_info: %s, preview_image_info: %s", bundle.getString(MapKeyNames.VIDEO_INFO), bundle.getString(MapKeyNames.PREVIEW_IMAGE_INFO));
            }
            ImageInfo imageInfo = (ImageInfo) AbstractC7758be.m47739b(bundle.getString(MapKeyNames.PREVIEW_IMAGE_INFO), ImageInfo.class, new Class[0]);
            if (imageInfo != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(imageInfo);
                metaDataM41568i.m40298b(arrayList);
            }
            com.huawei.openalliance.p169ad.beans.metadata.VideoInfo videoInfo = (com.huawei.openalliance.p169ad.beans.metadata.VideoInfo) AbstractC7758be.m47739b(bundle.getString(MapKeyNames.VIDEO_INFO), com.huawei.openalliance.p169ad.beans.metadata.VideoInfo.class, new Class[0]);
            if (videoInfo != null) {
                metaDataM41568i.m40289a(videoInfo);
            }
            VideoInfo videoInfo2 = new VideoInfo(videoInfo);
            pPSNativeView.setMetaData(AbstractC7758be.m47742b(metaDataM41568i));
            m41076a(i10, str, videoInfo2);
            pPSNativeView.setVideoInfo(videoInfo2);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("NativeProxy", "resetMetaDataAndProgress ex: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30488a(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            PPSNativeView pPSNativeView = this.f32045c.get();
            if (view == null || pPSNativeView == null) {
                return;
            }
            pPSNativeView.m49348b(view);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30489a(IObjectWrapper iObjectWrapper, int i10) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            PPSNativeView pPSNativeView = this.f32045c.get();
            if (pPSNativeView != null) {
                pPSNativeView.m49344a(view, i10);
            }
        }
    }

    /* renamed from: a */
    private void m41078a(IObjectWrapper iObjectWrapper, int i10, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        AppDownloadButton appDownloadButtonM41089b = m41089b(iObjectWrapper);
        if (appDownloadButtonM41089b == null) {
            AbstractC7185ho.m43823c("NativeProxy", "btn null");
        } else {
            AbstractC7185ho.m43820b("NativeProxy", "update btn style start");
            C6974br.m41066a(this.f32044b, appDownloadButtonM41089b, i10, remoteButtonStyleAttr);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30490a(IObjectWrapper iObjectWrapper, Bundle bundle) {
        AbstractC7185ho.m43820b("NativeProxy", "onAdClickWithParam");
        if (iObjectWrapper == null || this.f32048f == null) {
            return;
        }
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        PPSNativeView pPSNativeView = this.f32045c.get();
        int i10 = bundle.getInt("imp_source");
        String string = bundle.getString("click_info");
        boolean z10 = bundle.getBoolean(ParamConstants.Param.OPEN_LANDING, true);
        int i11 = bundle.getInt(MapKeyNames.LINKED_CUSTOM_VIDEO_PROGRESS);
        String string2 = bundle.getString(MapKeyNames.LINKED_CUSTOM_VIDEO_SOUND_SWITCH, "n");
        m41076a(i11, string2, this.f32048f.getVideoInfo());
        MaterialClickInfo materialClickInfo = (MaterialClickInfo) AbstractC7758be.m47739b(string, MaterialClickInfo.class, new Class[0]);
        if (pPSNativeView != null) {
            m41077a(bundle, pPSNativeView, i11, string2);
            pPSNativeView.setMaterialClickInfo(materialClickInfo);
            pPSNativeView.m49345a(view, i10, z10);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30491a(IObjectWrapper iObjectWrapper, String str) {
        m41079a(iObjectWrapper, str, 0, (RemoteButtonStyleAttr) null);
    }

    /* renamed from: a */
    private void m41079a(IObjectWrapper iObjectWrapper, String str, int i10, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            if (view instanceof AppDownloadButton) {
                AbstractC7185ho.m43820b("NativeProxy", "registerDownloadBtn");
                AppDownloadButton appDownloadButton = (AppDownloadButton) view;
                PPSNativeView pPSNativeView = this.f32045c.get();
                boolean zM41094h = m41094h();
                if (pPSNativeView != null) {
                    if (m41087a(zM41094h, remoteButtonStyleAttr != null && remoteButtonStyleAttr.m30404F())) {
                        if (pPSNativeView.register(appDownloadButton)) {
                            AbstractC7185ho.m43817a("NativeProxy", "register succ");
                            m41086a(zM41094h, remoteButtonStyleAttr, appDownloadButton, str);
                            appDownloadButton.setNeedAppendProgress(true);
                            C6974br.m41067b(this.f32044b, appDownloadButton, i10, remoteButtonStyleAttr);
                        } else {
                            view.setVisibility(8);
                        }
                        m41083a(appDownloadButton);
                        return;
                    }
                    if (this.f32048f.getInterActionType() == 0) {
                        view.setVisibility(8);
                        return;
                    }
                    AbstractC7185ho.m43817a("NativeProxy", "show btn");
                    appDownloadButton.m49965a(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.bu.1

                        /* renamed from: a */
                        final /* synthetic */ PPSNativeView f32052a;

                        /* renamed from: b */
                        final /* synthetic */ AppDownloadButton f32053b;

                        public AnonymousClass1(PPSNativeView pPSNativeView2, AppDownloadButton appDownloadButton2) {
                            pPSNativeView = pPSNativeView2;
                            appDownloadButton = appDownloadButton2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            BinderC6977bu.m41084a(pPSNativeView, appDownloadButton);
                        }
                    });
                    String strM41075a = m41075a(zM41094h, str, remoteButtonStyleAttr);
                    C6974br.m41067b(this.f32044b, appDownloadButton2, i10, remoteButtonStyleAttr);
                    appDownloadButton2.setButtonTextWatcherInner(new AppDownloadButton.InterfaceC7878e() { // from class: com.huawei.openalliance.ad.bu.2

                        /* renamed from: a */
                        final /* synthetic */ RemoteButtonStyleAttr f32055a;

                        /* renamed from: b */
                        final /* synthetic */ String f32056b;

                        public AnonymousClass2(RemoteButtonStyleAttr remoteButtonStyleAttr2, String strM41075a2) {
                            remoteButtonStyleAttr = remoteButtonStyleAttr2;
                            str = strM41075a2;
                        }

                        @Override // com.huawei.openalliance.p169ad.views.AppDownloadButton.InterfaceC7878e
                        /* renamed from: a */
                        public CharSequence mo30554a(CharSequence charSequence, AppStatus appStatus) {
                            return BinderC6977bu.this.m41074a(remoteButtonStyleAttr != null ? !TextUtils.isEmpty(r1.m30405G()) : false, str);
                        }
                    });
                }
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30492a(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
        int i10 = bundle.getInt(ParamConstants.BtnParams.DOWNLOAD_BUTTON_STYLE);
        if (3 == i10) {
            RemoteButtonStyleAttr remoteButtonStyleAttrM41065a = C6974br.m41065a(bundle);
            if (remoteButtonStyleAttrM41065a != null) {
                m41079a(iObjectWrapper, str, i10, remoteButtonStyleAttrM41065a);
                return;
            }
            i10 = 2;
        }
        m41079a(iObjectWrapper, str, i10, (RemoteButtonStyleAttr) null);
    }

    /* renamed from: a */
    private void m41080a(RemoteButtonStyleAttr remoteButtonStyleAttr, AppDownloadButton appDownloadButton) {
        if (remoteButtonStyleAttr == null) {
            AbstractC7185ho.m43823c("NativeProxy", "reset err, attr is null");
            return;
        }
        if (!TextUtils.isEmpty(remoteButtonStyleAttr.m30399A())) {
            appDownloadButton.setBfDlBtnTxt(remoteButtonStyleAttr.m30399A());
        }
        if (!TextUtils.isEmpty(remoteButtonStyleAttr.m30400B())) {
            appDownloadButton.setAfDlBtnText(remoteButtonStyleAttr.m30400B());
        }
        if (!TextUtils.isEmpty(remoteButtonStyleAttr.m30401C())) {
            appDownloadButton.setRemoteBfDlBtnTxt(remoteButtonStyleAttr.m30401C());
        }
        if (TextUtils.isEmpty(remoteButtonStyleAttr.m30402D())) {
            return;
        }
        appDownloadButton.setRemoteAfDlBtnText(remoteButtonStyleAttr.m30402D());
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30493a(IPPSUiEngineCallback iPPSUiEngineCallback) {
        this.f32049g = iPPSUiEngineCallback;
    }

    /* renamed from: a */
    private void m41083a(AppDownloadButton appDownloadButton) {
        appDownloadButton.setOnDownloadStatusChangedListener(new AppDownloadButton.OnDownloadStatusChangedListener() { // from class: com.huawei.openalliance.ad.bu.3
            public AnonymousClass3() {
            }

            @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
            public void onStatusChanged(AppStatus appStatus) {
                AbstractC7185ho.m43818a("NativeProxy", "onStatusChanged: %s", appStatus);
                if (appStatus == null) {
                    appStatus = AppStatus.DOWNLOAD;
                }
                BinderC6977bu.this.m41085a(StatusChangeMethods.STATUS_CHANGE, appStatus.name());
            }

            @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
            public void onUserCancel(AppInfo appInfo) {
                BinderC6977bu.this.m41085a(StatusChangeMethods.CANCEL_DOWN, (String) null);
            }
        });
    }

    /* renamed from: a */
    public static void m41084a(PPSNativeView pPSNativeView, AppDownloadButton appDownloadButton) {
        if (pPSNativeView != null) {
            pPSNativeView.mo49355h();
            pPSNativeView.m49344a(appDownloadButton, 1);
        }
    }

    /* renamed from: a */
    public void m41096a(String str) {
        AbstractC7185ho.m43818a("NativeProxy", "updateShowId: %s", str);
        C7302e c7302e = this.f32048f;
        if (c7302e != null) {
            c7302e.m44642h(str);
        }
        ContentRecord contentRecord = this.f32046d;
        if (contentRecord == null) {
            return;
        }
        contentRecord.m41536c(str);
        this.f32047e.mo46590a(this.f32046d);
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30494a(String str, int i10) {
        PPSNativeView pPSNativeView = this.f32045c.get();
        if (!EventType.INTERACTSHOW.value().equals(str)) {
            if (pPSNativeView != null) {
                pPSNativeView.mo49347a(Integer.valueOf(i10));
                return;
            }
            return;
        }
        C7586a.a aVar = new C7586a.a();
        aVar.m46878b(Integer.valueOf(i10));
        String strM48288a = AbstractC7811dd.m48288a((InterfaceC7337jk) pPSNativeView);
        C7302e c7302e = this.f32048f;
        if (c7302e != null) {
            AbstractC7185ho.m43818a("NativeProxy", "slotId: %s, contentId: %s, slot pos: %s", c7302e.getSlotId(), this.f32048f.getContentId(), strM48288a);
        }
        if (!AbstractC7806cz.m48165b(strM48288a)) {
            aVar.m46884d(strM48288a);
        }
        if (pPSNativeView != null) {
            aVar.m46875a(C7753b.m47700a(pPSNativeView));
        }
        this.f32047e.mo46618c(aVar.m46877a());
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30495a(String str, long j10, long j11, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        switch (str) {
            case "playPause":
                this.f32047e.mo46608b(j10, j11, i10, i11);
                break;
            case "playStart":
                this.f32047e.mo46616c();
                break;
            case "playEnd":
                this.f32047e.mo46617c(j10, j11, i10, i11);
                break;
            case "playResume":
                this.f32047e.mo46623f();
                break;
        }
    }

    /* renamed from: a */
    public void m41097a(String str, Bundle bundle) {
        if (this.f32049g == null) {
            AbstractC7185ho.m43823c("NativeProxy", "on call back, call back is null");
            return;
        }
        AbstractC7185ho.m43821b("NativeProxy", "onCallback, method: %s", str);
        try {
            this.f32049g.onCallResult(str, bundle);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("NativeProxy", "onCallback ex: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30496a(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
        }
        AbstractC7185ho.m43821b("NativeProxy", "callMethod: %s", str);
        str.hashCode();
        switch (str) {
            case "update_btn_txt":
                m41091b(iObjectWrapper, bundle);
                break;
            case "reportCommonEvent":
                new C6972bp(this.f32044b).m41058a(bundle, this.f32046d, this.f32047e);
                break;
            case "onCommonAnalysis":
                new C6971bo(this.f32044b).m41054a(bundle, this.f32046d, this.f32047e);
                break;
            case "update_btn_style":
                m41093c(iObjectWrapper, bundle);
                break;
            default:
                AbstractC7185ho.m43820b("NativeProxy", "call method fall to default.");
                break;
        }
    }

    /* renamed from: a */
    public void m41085a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("app_status_method", str);
        if (str2 != null) {
            bundle.putString("app_status", str2);
        }
        m41097a("notifyAppStatus", bundle);
    }

    @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
    /* renamed from: a */
    public void mo30497a(boolean z10) {
        this.f32047e.mo46615b(z10);
    }

    /* renamed from: a */
    private void m41086a(boolean z10, RemoteButtonStyleAttr remoteButtonStyleAttr, AppDownloadButton appDownloadButton, String str) {
        int interActionType = this.f32048f.getInterActionType();
        if (remoteButtonStyleAttr == null) {
            if (interActionType == 2 || interActionType == 5) {
                return;
            }
            appDownloadButton.setAfDlBtnText(str);
            return;
        }
        if (z10) {
            m41080a(remoteButtonStyleAttr, appDownloadButton);
            return;
        }
        if (!TextUtils.isEmpty(remoteButtonStyleAttr.m30399A())) {
            appDownloadButton.setBfDlBtnTxt(remoteButtonStyleAttr.m30399A());
        }
        if (interActionType != 8 && !TextUtils.isEmpty(remoteButtonStyleAttr.m30400B())) {
            appDownloadButton.setAfDlBtnText(remoteButtonStyleAttr.m30400B());
        } else {
            if (interActionType == 2 || interActionType == 5) {
                return;
            }
            appDownloadButton.setAfDlBtnText(str);
        }
    }

    /* renamed from: a */
    private boolean m41087a(boolean z10, boolean z11) {
        if (z10) {
            return z11;
        }
        int interActionType = this.f32048f.getInterActionType();
        return interActionType == 2 || interActionType == 5 || interActionType == 4 || interActionType == 8 || (interActionType == 3 && this.f32048f.getAppInfo() != null);
    }
}
