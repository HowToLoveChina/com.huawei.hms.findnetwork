package com.huawei.android.hicloud.commonlib.view;

import android.view.Window;

/* loaded from: classes3.dex */
public interface CommonDialogInterface {
    void customShow();

    void dismiss();

    Window getWindow();

    void setIsOOBE(boolean z10);

    void setMessage(CharSequence charSequence);

    void show();
}
