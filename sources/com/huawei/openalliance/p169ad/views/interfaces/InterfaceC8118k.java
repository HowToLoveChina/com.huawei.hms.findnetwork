package com.huawei.openalliance.p169ad.views.interfaces;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.webkit.WebSettings;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.inter.data.IRewardAd;
import com.huawei.openalliance.p169ad.inter.data.RewardEvent;
import com.huawei.openalliance.p169ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.C7748av;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.C8150t;

/* renamed from: com.huawei.openalliance.ad.views.interfaces.k */
/* loaded from: classes2.dex */
public interface InterfaceC8118k extends InterfaceC7337jk {
    /* renamed from: a */
    void mo49479a(IRewardAd iRewardAd, boolean z10);

    /* renamed from: a */
    void mo49481a(Integer num);

    /* renamed from: a */
    void mo49482a(String str);

    /* renamed from: a */
    void mo49484a(boolean z10);

    /* renamed from: a */
    void mo49485a(boolean z10, String str);

    void addNonwifiActionListener(INonwifiActionListener iNonwifiActionListener);

    void addRewardAdStatusListener(IRewardAdStatusListener iRewardAdStatusListener);

    /* renamed from: b */
    void mo49488b(boolean z10);

    /* renamed from: c */
    void mo49489c();

    /* renamed from: c */
    boolean mo49491c(boolean z10);

    void destroyView();

    /* renamed from: e */
    void mo49493e();

    /* renamed from: f */
    void mo49494f();

    /* renamed from: g */
    void mo49495g();

    AppDownloadButton getAppDownloadButton();

    C7748av getAppointJs();

    Context getContext();

    Dialog getNonwifiDialog();

    C8150t getPopUpView();

    Resources getResources();

    WebSettings getWebViewSettings();

    /* renamed from: h */
    boolean mo49496h();

    /* renamed from: l */
    void mo49500l();

    /* renamed from: m */
    void mo49501m();

    void onEvent(RewardEvent rewardEvent);

    void pauseView();

    void removeRewardAdStatusListener();

    void resumeView();

    void setContentRecord(ContentRecord contentRecord);

    void setNonwifiDialog(Dialog dialog);

    void setOrientation(int i10);

    void setTemplateErrorListener(InterfaceC8108ab interfaceC8108ab);

    void setVisibility(int i10);
}
