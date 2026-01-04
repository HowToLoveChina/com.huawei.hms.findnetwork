package com.huawei.hwcloudjs.api;

import android.app.Dialog;
import android.content.Context;
import com.huawei.hwcloudjs.core.extkit.IExtKit;
import com.huawei.hwcloudjs.support.enables.NoProguard;

/* loaded from: classes8.dex */
public interface ILocDialog extends IExtKit {

    @NoProguard
    public interface DialogResult {
        void onNeg();

        void onPos();
    }

    Dialog genDialog(Context context, String str, DialogResult dialogResult);
}
