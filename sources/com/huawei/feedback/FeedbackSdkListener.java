package com.huawei.feedback;

import android.os.Handler;
import android.util.Log;
import com.huawei.phoneservice.faq.base.util.SdkListener;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;

/* loaded from: classes5.dex */
public class FeedbackSdkListener implements SdkListener {
    private static final int SDK_INIT_CODE_SUCCESS = 0;
    public static final String TAG = "FeedbackSdkListener";
    private boolean isInit;
    private boolean isInitSuccess;
    private Handler mHandler;
    private IAccessTokenProxy mProxy;

    public static class AccessTokenListener implements GetAccessTokenListener {
        @Override // com.huawei.feedback.GetAccessTokenListener
        public void getAccessToken(String str) {
            SdkProblemManager.getSdk().saveSdk("accessToken", str);
        }
    }

    public FeedbackSdkListener(Handler handler, IAccessTokenProxy iAccessTokenProxy) {
        this.mProxy = iAccessTokenProxy;
        this.mHandler = handler;
    }

    @Override // com.huawei.phoneservice.faq.base.util.SdkListener
    public boolean haveSdkErr(String str) {
        Log.e(TAG, "haveSdkErr, key: " + str);
        return "accessToken".equals(str);
    }

    public boolean isInit() {
        return this.isInit;
    }

    public boolean isInitSuccess() {
        return this.isInitSuccess;
    }

    public boolean isLogin() {
        IAccessTokenProxy iAccessTokenProxy = this.mProxy;
        if (iAccessTokenProxy != null) {
            return iAccessTokenProxy.isLogin();
        }
        return false;
    }

    @Override // com.huawei.phoneservice.faq.base.util.SdkListener
    public void onSdkErr(String str, String str2) {
        Log.e(TAG, "init error, key: " + str + ", value: " + str2);
        if (this.mProxy != null && isLogin()) {
            this.mProxy.getAccessToken(new AccessTokenListener());
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
    }

    @Override // com.huawei.phoneservice.faq.base.util.SdkListener
    public void onSdkInit(int i10, int i11, String str) {
        Log.i(TAG, "init result: " + i10 + ", code: " + i11 + ", msg: " + str);
        this.isInit = true;
        this.isInitSuccess = i10 == 0;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    public void setInit(boolean z10) {
        this.isInit = z10;
    }
}
