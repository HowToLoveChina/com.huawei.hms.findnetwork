package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.downloadapp.p083ui.uiextend.FrontAppDownloadButtonStyle;
import com.huawei.android.hicloud.downloadapp.p083ui.uiextend.FrontAppDownloadButtonTextWatcher;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.p103ui.uiextend.TextViewWithImage;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.PPSNativeView;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0227m;
import p258ei.C9494c;
import p491nd.C11666d;
import p514o9.C11839m;
import p616rk.C12515a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class FrontAppLayout extends RelativeLayout {
    private static final int[] DOWNLOADING_STRS = {R$string.front_app_btn_downloading, R$string.front_app_btn_downloading_1, R$string.front_app_btn_downloading_2, R$string.front_app_btn_downloading_3};
    private static final String FRONT_APP_ICON_PATH = "/frontappicon/";
    private static final int REFRESH_TIME = 500;
    private static final String TAG = "FrontAppLayout";
    private TextViewWithImage mAppDescTextView;
    private Context mCurrentContext;
    private String mDescStr;
    private AppDownloadButton mDownloadButton;
    int mDownloadingStrIndex;
    private final Handler mHandler;
    private PPSNativeView mNativeView;
    private TextView mPrizeTextView;
    private RefreshTextRunnable mRefreshTextRunnable;
    private TextView mSubTitleTV;
    private FrontAppDownloadButtonTextWatcher mTextWatcher;
    private StatusChangeDownloadBtnListener statusChangeDownloadBtnListener;

    public class DownloadBtnStatusChangeListener implements AppDownloadButton.OnDownloadStatusChangedListener {
        private AppStatus mAppStatus;

        private DownloadBtnStatusChangeListener() {
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
        public void onStatusChanged(AppStatus appStatus) {
            AppStatus appStatus2 = AppStatus.DOWNLOADING;
            if (!appStatus2.equals(this.mAppStatus) && appStatus2.equals(appStatus)) {
                C11839m.m70686d(FrontAppLayout.TAG, "start runnable");
                FrontAppLayout.this.startRunnable();
                if (FrontAppLayout.this.statusChangeDownloadBtnListener != null) {
                    FrontAppLayout.this.statusChangeDownloadBtnListener.startDownloadListener();
                }
            } else if (appStatus2.equals(this.mAppStatus) && !appStatus2.equals(appStatus)) {
                C11839m.m70686d(FrontAppLayout.TAG, "stop runnable");
                FrontAppLayout.this.stopRunnable();
            }
            this.mAppStatus = appStatus;
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
        public void onUserCancel(AppInfo appInfo) {
            if (appInfo != null) {
                C11839m.m70688i(FrontAppLayout.TAG, "onUserCancel: " + appInfo.getPackageName());
            }
        }
    }

    public class RefreshTextRunnable implements Runnable {
        boolean isRunning;

        private RefreshTextRunnable() {
            this.isRunning = false;
        }

        public boolean isRunning() {
            return this.isRunning;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.isRunning) {
                FrontAppLayout.this.refreshDownloading();
                FrontAppLayout.this.mHandler.postDelayed(this, 500L);
            }
        }

        public void start() {
            if (this.isRunning) {
                return;
            }
            this.isRunning = true;
            FrontAppLayout.this.mHandler.removeCallbacks(this);
            FrontAppLayout.this.mHandler.postDelayed(this, 500L);
            C11839m.m70686d(FrontAppLayout.TAG, "Begin To AutoRoll");
        }

        public void stop() {
            if (this.isRunning) {
                FrontAppLayout.this.mHandler.removeCallbacks(this);
                this.isRunning = false;
                C11839m.m70686d(FrontAppLayout.TAG, "Stop To AutoRoll");
            }
        }
    }

    public interface StatusChangeDownloadBtnListener {
        void startDownloadListener();
    }

    public FrontAppLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshTextRunnable = new RefreshTextRunnable();
        this.mDownloadingStrIndex = 0;
        this.mHandler = new Handler() { // from class: com.huawei.android.hicloud.ui.uiextend.FrontAppLayout.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (1 == message.what) {
                    Object obj = message.obj;
                    Bitmap bitmap = obj instanceof Bitmap ? (Bitmap) obj : null;
                    if (FrontAppLayout.this.mAppDescTextView == null || bitmap == null || TextUtils.isEmpty(FrontAppLayout.this.mDescStr)) {
                        return;
                    }
                    FrontAppLayout.this.mAppDescTextView.m29158o(FrontAppLayout.this.mDescStr, bitmap);
                }
            }
        };
        this.mCurrentContext = context;
        initView(context);
    }

    private boolean checkInitCondition(String str, INativeAd iNativeAd) {
        if (this.mCurrentContext == null) {
            return false;
        }
        if (iNativeAd == null) {
            C11839m.m70687e(TAG, "checkInitCondition false, ad is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "checkInitCondition false, display Text is null or empty");
            return false;
        }
        if (iNativeAd.getAppInfo() != null) {
            return true;
        }
        C11839m.m70687e(TAG, "checkInitCondition false, appInfo is null");
        return false;
    }

    public static String getFrontAppIconPath() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return "";
        }
        return contextM1377a.getFilesDir() + FRONT_APP_ICON_PATH;
    }

    private void initView(Context context) {
        float fM1195O = C0209d.m1195O(C0213f.m1377a());
        if (fM1195O >= 2.0f) {
            View.inflate(context, R$layout.space_not_enough_dialog_front_app_2, this);
        } else if (fM1195O >= 1.75f) {
            View.inflate(context, R$layout.space_not_enough_dialog_front_app_1dot75, this);
        } else {
            View.inflate(context, R$layout.space_not_enough_dialog_front_app, this);
        }
        this.mNativeView = (PPSNativeView) C12809f.m76831d(this, R$id.front_app_pps_root_layout);
        this.mPrizeTextView = (TextView) C12809f.m76831d(this, R$id.prize_name);
        this.mSubTitleTV = (TextView) C12809f.m76831d(this, R$id.front_sub_title);
        this.mAppDescTextView = (TextViewWithImage) C12809f.m76831d(this, R$id.front_app_desc);
        AppDownloadButton appDownloadButton = (AppDownloadButton) C12809f.m76831d(this, R$id.pps_download_btn);
        this.mDownloadButton = appDownloadButton;
        try {
            appDownloadButton.setAppDownloadButtonStyle(new FrontAppDownloadButtonStyle(context));
            FrontAppDownloadButtonTextWatcher frontAppDownloadButtonTextWatcher = new FrontAppDownloadButtonTextWatcher(context);
            this.mTextWatcher = frontAppDownloadButtonTextWatcher;
            this.mDownloadButton.setButtonTextWatcher(frontAppDownloadButtonTextWatcher);
            this.mDownloadButton.setOnDownloadStatusChangedListener(new DownloadBtnStatusChangeListener());
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "initView exception: " + e10.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshDownloading() {
        AppDownloadButton appDownloadButton;
        if (this.mCurrentContext == null || (appDownloadButton = this.mDownloadButton) == null || appDownloadButton.getStatus() != AppStatus.DOWNLOADING) {
            return;
        }
        AppDownloadButton appDownloadButton2 = this.mDownloadButton;
        Context context = this.mCurrentContext;
        int[] iArr = DOWNLOADING_STRS;
        appDownloadButton2.setText(context.getString(iArr[this.mDownloadingStrIndex]));
        this.mTextWatcher.m16254a(this.mCurrentContext.getString(iArr[this.mDownloadingStrIndex]));
        int i10 = this.mDownloadingStrIndex;
        if (i10 >= 3) {
            this.mDownloadingStrIndex = 0;
        } else {
            this.mDownloadingStrIndex = i10 + 1;
        }
    }

    private void startDownloadIcon(String str) {
        String str2 = getFrontAppIconPath() + C0227m.m1593f(str);
        C13843a.m83085g(getFrontAppIconPath());
        C12515a.m75110o().m75175e(new C11666d(str, str2, (String) null, this.mHandler), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRunnable() {
        this.mDownloadingStrIndex = 0;
        this.mRefreshTextRunnable.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRunnable() {
        this.mRefreshTextRunnable.stop();
        this.mDownloadingStrIndex = 0;
    }

    public boolean fullInitLayout(String str, String str2, String str3, final INativeAd iNativeAd) throws Resources.NotFoundException {
        if (!checkInitCondition(str, iNativeAd)) {
            return false;
        }
        this.mPrizeTextView.setText(str);
        AppInfo appInfo = iNativeAd.getAppInfo();
        if (appInfo == null) {
            return false;
        }
        String appName = appInfo.getAppName();
        String iconUrl = appInfo.getIconUrl();
        if (this.mSubTitleTV != null) {
            if (TextUtils.isEmpty(str2)) {
                this.mSubTitleTV.setVisibility(8);
            } else {
                this.mSubTitleTV.setText(str2);
                this.mSubTitleTV.setVisibility(0);
            }
        }
        if (TextUtils.isEmpty(str3)) {
            C11839m.m70687e(TAG, "fullInitLayout appDescText is empty.");
            this.mDescStr = "";
        } else {
            String strM1303s = C0209d.m1303s(str3, appName);
            this.mDescStr = strM1303s;
            this.mAppDescTextView.m29156m(strM1303s, R$drawable.ic_front_app);
            startDownloadIcon(iconUrl);
            this.mAppDescTextView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.FrontAppLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    iNativeAd.triggerClick(FrontAppLayout.this.mCurrentContext, null);
                    C9494c.m59390r().m59408V(true);
                    LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                    C13227f.m79492i1().m79591l0("mecloud_front_app_introduction", linkedHashMapM79497A);
                    UBAAnalyze.m29958S("PVC", "mecloud_front_app_introduction", "4", "9", linkedHashMapM79497A);
                }
            });
        }
        this.mNativeView.register(iNativeAd);
        this.mNativeView.setClickable(false);
        this.mNativeView.register(this.mDownloadButton);
        this.mDownloadButton.refreshStatus();
        return true;
    }

    public void setStatusChangeDownloadBtnListener(StatusChangeDownloadBtnListener statusChangeDownloadBtnListener) {
        this.statusChangeDownloadBtnListener = statusChangeDownloadBtnListener;
    }
}
