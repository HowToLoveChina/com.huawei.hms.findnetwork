package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ba.C1147a;
import ba.C1159m;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.base.p103ui.uiextend.TextViewWithImage;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.uikit.hwbutton.widget.HwButton;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p491nd.C11663a;
import p514o9.C11839m;
import p616rk.C12515a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class FrontDoubleAppLayout extends RelativeLayout {
    private static final String FRONT_APP_ICON_PATH = "/frontappicon/";
    private static final long REPORT_DURATION = 1000;
    private static final String TAG = "FrontDoubleAppLayout";
    private HwButton acceptButton;
    private String mFrontAppDescText;
    private TextView mFrontDoubleSubTitle;
    private TextView mFrontDoubleTitle;
    private Handler mHandler;
    private TextViewWithImage mTextViewWithImage;
    private C1159m matchAdsResultInfo;

    public FrontDoubleAppLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler() { // from class: com.huawei.android.hicloud.ui.uiextend.FrontDoubleAppLayout.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                if (3 != i10) {
                    if (4 == i10) {
                        C11839m.m70688i(FrontDoubleAppLayout.TAG, "MSG_LOAD_DOUBLE_ICON_FAIL");
                        return;
                    }
                    C11839m.m70689w(FrontDoubleAppLayout.TAG, "invalid type = " + message.what);
                    return;
                }
                C11839m.m70688i(FrontDoubleAppLayout.TAG, "MSG_LOAD_DOUBLE_ICON_SUCCESS");
                List list = (List) message.obj;
                TextViewWithImage textViewWithImage = FrontDoubleAppLayout.this.mTextViewWithImage;
                String str = FrontDoubleAppLayout.this.mFrontAppDescText;
                FrontDoubleAppLayout frontDoubleAppLayout = FrontDoubleAppLayout.this;
                Bitmap matchBitmap = frontDoubleAppLayout.getMatchBitmap(list, frontDoubleAppLayout.matchAdsResultInfo.m7236a().getAppInfo().getIconUrl());
                FrontDoubleAppLayout frontDoubleAppLayout2 = FrontDoubleAppLayout.this;
                textViewWithImage.m29159p(str, matchBitmap, frontDoubleAppLayout2.getMatchBitmap(list, frontDoubleAppLayout2.matchAdsResultInfo.m7237b().getAppInfo().getIconUrl()));
            }
        };
        initView(context);
    }

    public static String getFrontAppIconPath() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return "";
        }
        return contextM1377a.getFilesDir() + FRONT_APP_ICON_PATH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getMatchBitmap(List<C1147a> list, String str) {
        for (C1147a c1147a : list) {
            if (str.equals(c1147a.m7212c())) {
                return c1147a.m7211b();
            }
        }
        return null;
    }

    private void initView(Context context) {
        if (C0209d.m1195O(C0213f.m1377a()) >= 1.75f) {
            View.inflate(context, R$layout.front_doubal_app_layout_scale, this);
        } else {
            View.inflate(context, R$layout.front_doubal_app_layout, this);
        }
        this.mFrontDoubleTitle = (TextView) C12809f.m76831d(this, R$id.title_text);
        this.mFrontDoubleSubTitle = (TextView) C12809f.m76831d(this, R$id.front_double_subtitle);
        this.mTextViewWithImage = (TextViewWithImage) C12809f.m76831d(this, R$id.front_double_app_desc_tv);
        this.acceptButton = (HwButton) C12809f.m76831d(this, R$id.front_jump_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAppName(String str) {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("dialog_front_double_app_name", str);
        C13225d.m79490f1().m79591l0("mecloud_cloudspacedialog_notenough_double_app_show", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_cloudspacedialog_notenough_double_app_show", "4", "9", linkedHashMapM79499C);
    }

    private void reportPpsShowInfo(final INativeAd iNativeAd, final INativeAd iNativeAd2, final Context context, Handler handler) {
        if (handler != null) {
            if (iNativeAd != null) {
                iNativeAd.recordShowStartEvent(context, null);
            }
            if (iNativeAd2 != null) {
                iNativeAd2.recordShowStartEvent(context, null);
            }
            handler.postDelayed(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.FrontDoubleAppLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    Context context2 = context;
                    if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                        return;
                    }
                    INativeAd iNativeAd3 = iNativeAd;
                    if (iNativeAd3 != null) {
                        iNativeAd3.recordImpressionEvent(context, null);
                        FrontDoubleAppLayout.this.reportAppName(iNativeAd.getAppInfo().getAppName());
                    }
                    INativeAd iNativeAd4 = iNativeAd2;
                    if (iNativeAd4 != null) {
                        iNativeAd4.recordImpressionEvent(context, null);
                        FrontDoubleAppLayout.this.reportAppName(iNativeAd2.getAppInfo().getAppName());
                    }
                }
            }, 1000L);
        }
    }

    private void startDownloadDouble(String str, String str2) {
        C13843a.m83085g(getFrontAppIconPath());
        C12515a.m75110o().m75175e(new C11663a(this.mHandler, getFrontAppIconPath(), str, str2), false);
    }

    public boolean fullInitDoubleLayout(C1159m c1159m, View.OnClickListener onClickListener, Context context, Handler handler) {
        if (c1159m == null) {
            C11839m.m70687e(TAG, "fullInitDoubleLayout matchAdsResult is null.");
            return false;
        }
        this.matchAdsResultInfo = c1159m;
        String strFromDBByResource = NoticeWithActivityUtil.getStrFromDBByResource(c1159m.m7241f(), NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_DOUBLE_TITLE);
        if (TextUtils.isEmpty(strFromDBByResource)) {
            C11839m.m70687e(TAG, "fullInitDoubleLayout doubleTitle is empty.");
            return false;
        }
        this.mFrontDoubleTitle.setText(strFromDBByResource);
        if (this.mFrontDoubleSubTitle != null) {
            String strFromDBByResource2 = NoticeWithActivityUtil.getStrFromDBByResource(c1159m.m7241f(), NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_DOUBLE_TEXT_SECOND);
            if (TextUtils.isEmpty(strFromDBByResource2)) {
                this.mFrontDoubleSubTitle.setVisibility(8);
            } else {
                this.mFrontDoubleSubTitle.setText(strFromDBByResource2);
                this.mFrontDoubleSubTitle.setVisibility(0);
            }
        }
        this.acceptButton.setText(NoticeWithActivityUtil.getStrFromDBByResource(c1159m.m7241f(), NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_DOUBLE_BUTTON));
        this.acceptButton.setOnClickListener(onClickListener);
        AppInfo appInfo = c1159m.m7236a().getAppInfo();
        AppInfo appInfo2 = c1159m.m7237b().getAppInfo();
        if (appInfo == null || appInfo2 == null) {
            C11839m.m70687e(TAG, "fullInitDoubleLayout appInfo is null or appInfoSec is null.");
            return false;
        }
        String strFromDBByResource3 = NoticeWithActivityUtil.getStrFromDBByResource(c1159m.m7241f(), NotifyConstants.H5BackupNotEnoughNoticeKey.FRONTAPP_DOUBLE_TEXT);
        if (TextUtils.isEmpty(strFromDBByResource3)) {
            this.mFrontAppDescText = "";
            C11839m.m70687e(TAG, "fullInitDoubleLayout doubleText is empty.");
        } else {
            String strM1303s = C0209d.m1303s(strFromDBByResource3, appInfo.getAppName(), appInfo2.getAppName());
            this.mFrontAppDescText = strM1303s;
            TextViewWithImage textViewWithImage = this.mTextViewWithImage;
            int i10 = R$drawable.ic_front_app;
            textViewWithImage.m29157n(strM1303s, i10, i10);
            startDownloadDouble(appInfo.getIconUrl(), appInfo2.getIconUrl());
        }
        reportPpsShowInfo(c1159m.m7236a(), c1159m.m7237b(), context, handler);
        return true;
    }
}
