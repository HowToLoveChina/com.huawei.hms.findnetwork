package com.huawei.openalliance.p169ad.download.app;

import android.content.Context;
import com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7051a;
import com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7052b;
import com.huawei.openalliance.p169ad.inter.IAppDownloadManager;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.PPSNativeView;
import com.huawei.openalliance.p169ad.views.PPSPlacementView;

/* renamed from: com.huawei.openalliance.ad.download.app.l */
/* loaded from: classes2.dex */
public class C7055l implements InterfaceC7052b, IAppDownloadManager {

    /* renamed from: a */
    private InterfaceC7051a f32469a = new C7056m();

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7052b
    /* renamed from: a */
    public int mo42478a(Context context, IAd iAd) {
        int iMo42464a = this.f32469a.mo42464a(context, iAd);
        m42500a(context, iAd, iMo42464a);
        return iMo42464a;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public void addOnResolutionRequiredListener(AppDownloadButton.OnResolutionRequiredListener onResolutionRequiredListener) {
        if (onResolutionRequiredListener == null) {
            return;
        }
        this.f32469a.mo42469a(onResolutionRequiredListener);
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7052b
    /* renamed from: b */
    public int mo42480b(Context context, IAd iAd) {
        return this.f32469a.mo42472b(context, iAd);
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7052b
    /* renamed from: c */
    public int mo42481c(Context context, IAd iAd) {
        return this.f32469a.mo42474c(context, iAd);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public void cancelDownload(Context context, INativeAd iNativeAd) {
        this.f32469a.mo42475d(context, iNativeAd);
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7052b
    /* renamed from: d */
    public void mo42482d(Context context, IAd iAd) {
        this.f32469a.mo42475d(context, iAd);
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7052b
    /* renamed from: e */
    public AppStatus mo42483e(Context context, IAd iAd) {
        return this.f32469a.mo42477f(context, iAd);
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7052b
    /* renamed from: f */
    public int mo42484f(Context context, IAd iAd) {
        return this.f32469a.mo42476e(context, iAd);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public AppStatus getAppStatus(Context context, INativeAd iNativeAd) {
        return this.f32469a.mo42477f(context, iNativeAd);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public int getDownloadProgress(Context context, INativeAd iNativeAd) {
        return this.f32469a.mo42476e(context, iNativeAd);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public boolean openApp(Context context, INativeAd iNativeAd) {
        return this.f32469a.mo42471a(context, (IAd) iNativeAd, true);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public void pauseDownload(Context context, INativeAd iNativeAd) {
        this.f32469a.mo42474c(context, iNativeAd);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public void removeAllOnResolutionRequiredListener() {
        this.f32469a.mo42473b();
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public void removeOnResolutionRequiredListener() {
        this.f32469a.mo42466a();
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public int resumeDownload(Context context, INativeAd iNativeAd) {
        return this.f32469a.mo42472b(context, iNativeAd);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public void setAgdDownloadSource(int i10) {
        this.f32469a.mo42467a(i10);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public int startDownload(Context context, INativeAd iNativeAd) {
        int iMo42464a = this.f32469a.mo42464a(context, iNativeAd);
        m42500a(context, iNativeAd, iMo42464a);
        return iMo42464a;
    }

    /* renamed from: a */
    public static void m42499a(Context context, AppInfo appInfo) {
        C7056m.m42508a(context, appInfo);
    }

    /* renamed from: b */
    public static void m42501b(Context context, AppInfo appInfo) {
        C7056m.m42521b(context, appInfo);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public void cancelDownload(Context context, IPlacementAd iPlacementAd) {
        this.f32469a.mo42475d(context, iPlacementAd);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public AppStatus getAppStatus(Context context, IPlacementAd iPlacementAd) {
        return this.f32469a.mo42477f(context, iPlacementAd);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public int getDownloadProgress(Context context, IPlacementAd iPlacementAd) {
        return this.f32469a.mo42476e(context, iPlacementAd);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public boolean openApp(Context context, IPlacementAd iPlacementAd) {
        return this.f32469a.mo42471a(context, (IAd) iPlacementAd, true);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public void pauseDownload(Context context, IPlacementAd iPlacementAd) {
        this.f32469a.mo42474c(context, iPlacementAd);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public int resumeDownload(Context context, IPlacementAd iPlacementAd) {
        return this.f32469a.mo42472b(context, iPlacementAd);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public int startDownload(Context context, IPlacementAd iPlacementAd) {
        int iMo42464a = this.f32469a.mo42464a(context, iPlacementAd);
        m42500a(context, iPlacementAd, iMo42464a);
        return iMo42464a;
    }

    /* renamed from: a */
    private void m42500a(Context context, IAd iAd, int i10) {
        this.f32469a.mo42468a(context, iAd, i10);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public int startDownload(Context context, PPSNativeView pPSNativeView, INativeAd iNativeAd) {
        int iMo42465a = this.f32469a.mo42465a(context, pPSNativeView, iNativeAd);
        m42500a(context, iNativeAd, iMo42465a);
        return iMo42465a;
    }

    @Override // com.huawei.openalliance.p169ad.download.app.interfaces.InterfaceC7052b
    /* renamed from: a */
    public void mo42479a(Integer num) {
        this.f32469a.mo42470a(num);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAppDownloadManager
    public int startDownload(Context context, PPSPlacementView pPSPlacementView, IPlacementAd iPlacementAd) {
        int iMo42465a = this.f32469a.mo42465a(context, pPSPlacementView, iPlacementAd);
        m42500a(context, iPlacementAd, iMo42465a);
        return iMo42465a;
    }
}
