package com.huawei.feedback;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.feedback.FeedbackSdkListener;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.entity.Builder;
import com.huawei.phoneservice.faq.base.util.FaqDeviceUtils;
import com.huawei.phoneservice.faq.base.util.Sdk;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.feedback.utils.SdkFeedbackProblemManager;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.UUID;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;

/* loaded from: classes5.dex */
public class FeedbackSdkProcessor {
    private static final String DEFAULT_LANGUAGE_EN = "en-US";
    private static final String DEFAULT_LANGUAGE_ZH = "zh-CN";
    private static final String FEEDBACK_NOT_VISIBLE = "0";
    public static final int FEEDBACK_SCENE_FAQ = 1;
    public static final int FEEDBACK_SCENE_INIT = 0;
    public static final int FEEDBACK_SCENE_LOG = 2;
    private static final String FEEDBACK_VISIBLE = "1";
    public static final String TAG = "FeedbackSdkProcessor";
    private static volatile FeedbackSdkProcessor sInstance;
    private boolean lastLoginStatus;
    private WeakReference<Activity> mActivity;
    private String mCountryCode;
    private String mDefaultLang;
    private Handler mHandler;
    private String mLanguage;
    private FeedbackSdkListener mListener;
    private IAccessTokenProxy mProxy;
    private boolean isLoginChanged = false;
    private boolean isCloudInitChannel = true;
    private int feedbackScene = 1;

    private FeedbackSdkProcessor() {
    }

    private void doInit(Activity activity) {
        this.mActivity = new WeakReference<>(activity);
        this.mLanguage = C0209d.m1204R();
        this.mCountryCode = getContryCode();
        this.lastLoginStatus = this.mProxy.isLogin();
        this.isLoginChanged = false;
        initDefaultLang();
        SdkFaqManager.getSdk().init(activity.getApplication(), new Builder().set(FaqConstants.FAQ_CHANNEL, this.isCloudInitChannel ? FeedbackConst.SDK.CHANNEL_CLOUD : FeedbackConst.SDK.CHANNEL_SLAVE).set("country", this.mCountryCode).set(FaqConstants.FAQ_EMUI_LANGUAGE, this.mLanguage).set(FaqConstants.FAQ_UPLOAD_FLAG, "2").set("appVersion", "16.0.0.300").set(FaqConstants.FAQ_LOG_SERVER_APPID, this.isCloudInitChannel ? FeedbackConst.SDK.CLOUD_FEEDBACK_UPLOAD_LOG_ID : FeedbackConst.SDK.SLAVE_FEEDBACK_UPLOAD_LOG_ID).set(FaqConstants.FAQ_LOG_SERVER_LOG_PATH, "hicloud").set(FaqConstants.FAQ_SHASN, getUdid()).set(FaqConstants.FAQ_ROMVERSION, FaqDeviceUtils.getSpecialEmuiVersion()).set(FaqConstants.FAQ_OSVERSION, FaqDeviceUtils.getAndroidVersion()).set(FaqConstants.FAQ_DEFAULT_LANGUAGE, this.mDefaultLang).set(FaqConstants.FAQ_DISABLE_HA_REPORT, FaqConstants.DISABLE_HA_REPORT).set(FaqConstants.FAQ_FEEDBACK_ISVISIBLE, "1").set(FaqConstants.FAQ_PERMISSION_CHECK_TYPE, FaqConstants.CHECK_TYPE_SIMPLE).set(FaqConstants.FAQ_USE_OLD_DOMAIN, "Y").set(FaqConstants.FAQ_TYPECODE, this.isCloudInitChannel ? FeedbackConst.SDK.CLOUD_FAQ_TYPE_CODE : FeedbackConst.SDK.SLAVE_FAQ_TYPE_CODE), this.mListener);
    }

    private String getContryCode() {
        IAccessTokenProxy iAccessTokenProxy = this.mProxy;
        return (iAccessTokenProxy != null && iAccessTokenProxy.isLogin()) ? this.mProxy.getContryCode() : "";
    }

    public static FeedbackSdkProcessor getInstance(Activity activity, IAccessTokenProxy iAccessTokenProxy) {
        if (sInstance == null) {
            synchronized (FeedbackSdkProcessor.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new FeedbackSdkProcessor(activity, iAccessTokenProxy);
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private String getUdid() throws NoSuchMethodException, SecurityException {
        String strM1324x0 = C0209d.m1324x0();
        Context contextM1377a = C0213f.m1377a();
        if (!TextUtils.isEmpty(strM1324x0) || contextM1377a == null) {
            return strM1324x0;
        }
        String strM1364n = C0212e0.m1364n(contextM1377a, FeedbackConst.SDK.UUID_SP_NAME, "uuid", "");
        if (!TextUtils.isEmpty(strM1364n)) {
            return strM1364n;
        }
        String string = UUID.randomUUID().toString();
        C0212e0.m1373w(contextM1377a, FeedbackConst.SDK.UUID_SP_NAME, "uuid", string);
        return string;
    }

    private void initHandler(Activity activity) {
        if (activity == null) {
            return;
        }
        this.mHandler = new Handler(activity.getMainLooper()) { // from class: com.huawei.feedback.FeedbackSdkProcessor.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Activity activity2;
                if (1 != message.what || FeedbackSdkProcessor.this.mActivity == null || (activity2 = (Activity) FeedbackSdkProcessor.this.mActivity.get()) == null) {
                    return;
                }
                if (1 == FeedbackSdkProcessor.this.feedbackScene) {
                    FeedbackSdkProcessor.this.jumpToFaqViewInternal(activity2);
                } else if (2 == FeedbackSdkProcessor.this.feedbackScene) {
                    FeedbackSdkProcessor.this.jumpToFeedbackViewInternal(activity2);
                }
            }
        };
    }

    private boolean isChannelChange(boolean z10) {
        if (this.isCloudInitChannel == z10) {
            return false;
        }
        this.isCloudInitChannel = z10;
        return true;
    }

    private boolean isCountryChange() {
        String contryCode = getContryCode();
        return (TextUtils.isEmpty(contryCode) || contryCode.equals(this.mCountryCode)) ? false : true;
    }

    private boolean isLanguageChange() {
        return (TextUtils.isEmpty(this.mLanguage) || this.mLanguage.equals(C0209d.m1204R())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToFaqViewInternal(Activity activity) {
        setAccessToken(SdkFaqManager.getSdk());
        SdkFaqManager.getManager().goToFaqCateActivity(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToFeedbackViewInternal(Activity activity) {
        Sdk sdk = SdkProblemManager.getSdk();
        sdk.saveSdk(FaqConstants.FAQ_LOG_SERVER_APPID, this.isCloudInitChannel ? FeedbackConst.SDK.CLOUD_FEEDBACK_UPLOAD_LOG_ID : FeedbackConst.SDK.SLAVE_FEEDBACK_UPLOAD_LOG_ID);
        sdk.saveSdk(FaqConstants.FAQ_LOG_SERVER_LOG_PATH, "hicloud");
        sdk.saveSdk(FaqConstants.FAQ_SHASN, getUdid());
        sdk.saveSdk(FaqConstants.FAQ_ROMVERSION, FaqDeviceUtils.getSpecialEmuiVersion());
        sdk.saveSdk(FaqConstants.FAQ_OSVERSION, FaqDeviceUtils.getAndroidVersion());
        sdk.saveSdk(FaqConstants.FAQ_DEFAULT_LANGUAGE, this.mDefaultLang);
        setAccessToken(sdk);
        SdkFeedbackProblemManager.getManager().gotoFeedback(activity, null, -1);
    }

    public static void notifyLoginChanged() {
        if (sInstance != null) {
            sInstance.setLoginChanged();
        }
    }

    private void reInit(Activity activity) {
        doInit(activity);
    }

    private void setAccessToken(Sdk sdk) {
        FeedbackSdkListener feedbackSdkListener = this.mListener;
        if (feedbackSdkListener == null) {
            BaseLogger.m28735w(TAG, "listener is null");
            return;
        }
        if (!feedbackSdkListener.isLogin()) {
            BaseLogger.m28735w(TAG, "listener not Login");
            return;
        }
        IAccessTokenProxy iAccessTokenProxy = this.mProxy;
        if (iAccessTokenProxy == null) {
            BaseLogger.m28735w(TAG, "mProxy is null");
        } else if (!TextUtils.isEmpty(iAccessTokenProxy.getAccessTokenCache())) {
            sdk.saveSdk("accessToken", this.mProxy.getAccessTokenCache());
        } else {
            sdk.saveSdk("accessToken", FeedbackConst.SDK.INVALID_ACCESS_TOKEN);
            this.mProxy.getAccessToken(new FeedbackSdkListener.AccessTokenListener());
        }
    }

    private void setLoginChanged() {
        this.isLoginChanged = true;
    }

    public void initDefaultLang() {
        String language = Locale.getDefault().getLanguage();
        this.mDefaultLang = ("zh".equalsIgnoreCase(language) || "bo".equalsIgnoreCase(language) || "ug".equalsIgnoreCase(language)) ? "zh-CN" : "en-US";
    }

    public void jumpToSdkView(Activity activity, int i10, boolean z10) {
        this.feedbackScene = i10;
        FeedbackSdkListener feedbackSdkListener = this.mListener;
        if (feedbackSdkListener == null || !feedbackSdkListener.isInit()) {
            return;
        }
        if (isLanguageChange() || this.isLoginChanged || isCountryChange() || !this.mListener.isInitSuccess() || isChannelChange(z10)) {
            reInit(activity);
            return;
        }
        int i11 = this.feedbackScene;
        if (1 == i11) {
            jumpToFaqViewInternal(activity);
        } else if (2 == i11) {
            jumpToFeedbackViewInternal(activity);
        }
    }

    private FeedbackSdkProcessor(Activity activity, IAccessTokenProxy iAccessTokenProxy) {
        initHandler(activity);
        this.mProxy = iAccessTokenProxy;
        this.mListener = new FeedbackSdkListener(this.mHandler, iAccessTokenProxy);
        doInit(activity);
    }
}
