package com.huawei.hms.support.picker.activity;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.support.api.entity.hwid.AccountPickerSignInRequest;
import com.huawei.hwidauth.p167ui.AbstractC6717b;
import org.json.JSONException;

/* loaded from: classes8.dex */
public interface AccountPickerSignInHubContract {

    public static abstract class Presenter extends AbstractC6717b {
        public abstract void checkMinVersion();

        public abstract void doSilentTokenRequest();

        public abstract void doTokenRequest(String str);

        public abstract AccountPickerSignInRequest getSignInRequest();

        public abstract boolean initIntent(Intent intent);

        public abstract boolean isNeedRequestToken(String str);

        public abstract void onSaveInstanceState(Bundle bundle);

        public abstract void onSignInFailed(int i10);

        public abstract void onSignInSuccess(String str) throws JSONException;

        public abstract void report(int i10);

        public abstract void restoreInstanceState(Bundle bundle);

        public abstract void startWebViewActivity();
    }

    public interface View {
        void exit(int i10, Intent intent);

        void startSignInActivity(Intent intent, int i10);
    }
}
