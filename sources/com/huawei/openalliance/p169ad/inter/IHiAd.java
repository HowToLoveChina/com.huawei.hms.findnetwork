package com.huawei.openalliance.p169ad.inter;

import android.app.Activity;
import android.content.Context;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.download.app.interfaces.AutoOpenListener;
import com.huawei.openalliance.p169ad.dynamictemplate.IImageLoader;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1;
import com.huawei.openalliance.p169ad.inter.listeners.ExtensionActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.IAskForUnlockScreen;
import com.huawei.openalliance.p169ad.inter.listeners.IExSplashCallback;
import com.huawei.openalliance.p169ad.inter.listeners.IPPSWebEventCallback;
import com.huawei.openalliance.p169ad.inter.listeners.LandingPageAction;
import com.huawei.openalliance.p169ad.inter.listeners.LinkedAdListener;
import com.huawei.openalliance.p169ad.magazine.inter.listener.IAdInvalidHandler;
import com.huawei.openalliance.p169ad.magazine.inter.listener.IPPSDownloadService;
import com.huawei.openalliance.p169ad.media.IMultiMediaPlayingManager;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

@OuterVisible
/* loaded from: classes2.dex */
public interface IHiAd {
    void enableSharePd(boolean z10);

    void enableUserInfo(boolean z10);

    void enableVideoCacheWhenPlay(int i10, boolean z10);

    IAdInvalidHandler getAdInvalidHandler();

    int getAppActivateStyle();

    IAppDownloadManager getAppDownloadManager();

    IAskForUnlockScreen getAskForUnlockScreen();

    Activity getCurActivity();

    String getEngineVer();

    ExtensionActionListener getExtensionActionListener();

    IPPSDownloadService getPPSDownloadService();

    RequestOptions getRequestConfiguration();

    Map<String, List<String>> getTemplates(List<String> list);

    void informReady();

    void initGrs(String str);

    void initGrs(String str, String str2);

    void initLog(boolean z10, int i10);

    void initLog(boolean z10, int i10, String str);

    void initOptions(Context context);

    boolean isAppAutoOpenForbidden();

    boolean isAppInstalledNotify();

    boolean isEnableUserInfo();

    boolean isVideoCacheWhenPlay(int i10);

    void notifyUiModeChange(int i10);

    void onBackground();

    void onForeground();

    void placementAdPreCfgReq();

    void requestConfig(String str);

    void setAdInvalidHandler(IAdInvalidHandler iAdInvalidHandler);

    void setAppActivateStyle(int i10);

    void setAppAutoOpenForbidden(boolean z10);

    void setAppDownloadListener(AppDownloadListener appDownloadListener);

    void setAppInstalledNotify(boolean z10);

    void setAppStatusQuery(AppStatusQuery appStatusQuery);

    void setAskForUnlockScreen(IAskForUnlockScreen iAskForUnlockScreen);

    void setAutoOpenListener(AutoOpenListener autoOpenListener);

    void setBrand(int i10);

    void setBrowserAppDownloadListener(AppDownloadListenerV1 appDownloadListenerV1);

    void setConsent(String str);

    void setCountryCode(String str);

    void setCurActivity(Activity activity);

    void setCustomSSLSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager);

    void setExLinkedAdListener(LinkedAdListener linkedAdListener);

    void setExSplashCallback(IExSplashCallback iExSplashCallback, int i10, int i11);

    void setExtensionActionListener(ExtensionActionListener extensionActionListener);

    void setImageLoader(IImageLoader iImageLoader);

    void setIsPreloadWebView(boolean z10);

    void setLandingPageAction(LandingPageAction landingPageAction);

    void setMultiMediaPlayingManager(IMultiMediaPlayingManager iMultiMediaPlayingManager);

    void setOpenLinkStatus(boolean z10);

    void setOpenWebPageByBrowser(boolean z10);

    void setPPSDownloadService(IPPSDownloadService iPPSDownloadService);

    void setPPSWebListener(IPPSWebEventCallback iPPSWebEventCallback);

    void setRequestConfiguration(RequestOptions requestOptions);

    @Deprecated
    void setVideoAutoPlayNet(int i10);

    void syncMediaGrs(String str, String str2);
}
