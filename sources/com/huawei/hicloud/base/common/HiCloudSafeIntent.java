package com.huawei.hicloud.base.common;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.secure.android.common.intent.SafeIntent;

/* loaded from: classes6.dex */
public class HiCloudSafeIntent extends SafeIntent {
    public HiCloudSafeIntent(Intent intent) {
        super(intent);
    }

    /* renamed from: i */
    public String m29113i(String str, String str2) {
        String stringExtra = getStringExtra(str);
        return TextUtils.isEmpty(stringExtra) ? str2 : stringExtra;
    }
}
