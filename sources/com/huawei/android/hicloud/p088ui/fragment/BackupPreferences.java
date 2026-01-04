package com.huawei.android.hicloud.p088ui.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import p015ak.C0214f0;

/* loaded from: classes3.dex */
public class BackupPreferences {

    /* renamed from: a */
    public SharedPreferences f18066a;

    public static class ConfigInfoPreferences extends BackupPreferences {
        public ConfigInfoPreferences(Context context) {
            super(context, "config_info");
        }
    }

    public BackupPreferences(Context context, String str) {
        if (context == null) {
            throw new NullPointerException("context is null!");
        }
        this.f18066a = C0214f0.m1382b(context, str, 0);
    }
}
