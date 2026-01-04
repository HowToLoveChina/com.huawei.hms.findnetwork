package com.huawei.fastengine.fastview.startfastappengine.storage;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes5.dex */
public class FastAppPreferences {
    private static final String FASTAPP_PREFERENCES_NAME = "FastAppPrefs";
    public static final String KEY_ACTIONBAR_LOCK_CUSTOMIZE = "actionbar_lock_customize";
    public static final String KEY_ACTIONBAR_LOCK_STATUS = "actionbar_lock_status";
    public static final String KEY_AGREEMENT_VERSION = "agreement_version";
    public static final String KEY_CREATESHORTCUT = "creat_shortcut";
    private static final byte[] SYNC_LOCK = new byte[0];
    private static volatile FastAppPreferences instance;

    /* renamed from: sp */
    private SharedPreferences f21613sp;

    private FastAppPreferences(Context context) {
        this.f21613sp = null;
        this.f21613sp = context.getApplicationContext().getSharedPreferences(FASTAPP_PREFERENCES_NAME, 0);
    }

    public static FastAppPreferences getInstance(Context context) {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                try {
                    if (instance == null) {
                        instance = new FastAppPreferences(context);
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public boolean getBoolean(String str, boolean z10) {
        return this.f21613sp.getBoolean(str, z10);
    }

    public int getInt(String str, int i10) {
        return this.f21613sp.getInt(str, i10);
    }

    public Long getLong(String str, Long l10) {
        return Long.valueOf(this.f21613sp.getLong(str, l10.longValue()));
    }

    public String getString(String str, String str2) {
        return this.f21613sp.getString(str, str2);
    }

    public boolean putBoolean(String str, boolean z10) {
        return this.f21613sp.edit().putBoolean(str, z10).commit();
    }

    public boolean putInt(String str, int i10) {
        return this.f21613sp.edit().putInt(str, i10).commit();
    }

    public boolean putLong(String str, Long l10) {
        return this.f21613sp.edit().putLong(str, l10.longValue()).commit();
    }

    public boolean putString(String str, String str2) {
        return this.f21613sp.edit().putString(str, str2).commit();
    }

    public boolean remove(String str) {
        return this.f21613sp.edit().remove(str).commit();
    }
}
