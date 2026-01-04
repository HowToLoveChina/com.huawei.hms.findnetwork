package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public interface DialogCallback {
    void onCanceled(String str, int i10);

    void onConfirmed(String str, String str2, int i10);

    void onConfirmed(String str, String str2, ArrayList<String> arrayList, int i10);
}
