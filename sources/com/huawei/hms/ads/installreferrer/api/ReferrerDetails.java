package com.huawei.hms.ads.installreferrer.api;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.huawei.hms.ads.installreferrer.commons.LogUtil;

@Keep
/* loaded from: classes8.dex */
public class ReferrerDetails {
    public static final String KEY_GRS_COUNTRY_CODE = "grs_country_code";
    public static final String KEY_INSTALL_BEGIN_TIMESTAMP = "install_begin_timestamp_seconds";
    private static final String KEY_INSTALL_CHANNEL = "install_channel";
    public static final String KEY_INSTALL_REFERRER = "install_referrer";
    public static final String KEY_REFERRER_CLICK_TIMESTAMP = "referrer_click_timestamp_seconds";
    private static final long MILLISECOND_IN_SECONDE = 1000;
    private static final int MILLISECOND_MIN_LEN = 13;
    private static final String TAG = "ReferrerDetails";
    private final Bundle mOriginalBundle;

    @Keep
    public ReferrerDetails(Bundle bundle) {
        this.mOriginalBundle = bundle;
    }

    private long getMilliseconds(long j10) {
        return String.valueOf(j10).length() < 13 ? j10 * 1000 : j10;
    }

    private long getSeconds(long j10) {
        return String.valueOf(j10).length() >= 13 ? j10 / 1000 : j10;
    }

    @Keep
    public String getGrsCountryCode() {
        try {
            return this.mOriginalBundle.getString(KEY_GRS_COUNTRY_CODE);
        } catch (Throwable th2) {
            LogUtil.logWarn(TAG, "get grs cou err: " + th2.getClass().getSimpleName());
            return "";
        }
    }

    @Keep
    public long getInstallBeginTimestampMillisecond() {
        try {
            return getMilliseconds(this.mOriginalBundle.getLong(KEY_INSTALL_BEGIN_TIMESTAMP));
        } catch (Throwable th2) {
            LogUtil.logWarn(TAG, "getInstallBeginTimes err: " + th2.getClass().getSimpleName());
            return 0L;
        }
    }

    @Keep
    public long getInstallBeginTimestampSeconds() {
        try {
            return getSeconds(this.mOriginalBundle.getLong(KEY_INSTALL_BEGIN_TIMESTAMP));
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @Keep
    public String getInstallChannel() {
        try {
            return this.mOriginalBundle.getString(KEY_INSTALL_CHANNEL);
        } catch (Throwable th2) {
            LogUtil.logWarn(TAG, "getInstallChannel err: " + th2.getClass().getSimpleName());
            return "";
        }
    }

    @Keep
    public String getInstallReferrer() {
        try {
            return this.mOriginalBundle.getString(KEY_INSTALL_REFERRER);
        } catch (Throwable th2) {
            LogUtil.logWarn(TAG, "getInstallReferrer err: " + th2.getClass().getSimpleName());
            return "";
        }
    }

    @Keep
    public long getReferrerClickTimestampMillisecond() {
        try {
            return getMilliseconds(this.mOriginalBundle.getLong(KEY_REFERRER_CLICK_TIMESTAMP));
        } catch (Throwable th2) {
            LogUtil.logWarn(TAG, "getReferrerClick err: " + th2.getClass().getSimpleName());
            return 0L;
        }
    }

    @Keep
    public long getReferrerClickTimestampSeconds() {
        try {
            return getSeconds(this.mOriginalBundle.getLong(KEY_REFERRER_CLICK_TIMESTAMP));
        } catch (Throwable th2) {
            LogUtil.logWarn(TAG, "getReferrerClickTimestampSeconds err: " + th2.getClass().getSimpleName());
            return 0L;
        }
    }

    public void setGrsCountryCode(String str) {
        this.mOriginalBundle.putString(KEY_GRS_COUNTRY_CODE, str);
    }

    public void setInstallChannel(String str) {
        this.mOriginalBundle.putString(KEY_INSTALL_CHANNEL, str);
    }

    @Keep
    public ReferrerDetails(String str, long j10, long j11) {
        Bundle bundle = new Bundle();
        this.mOriginalBundle = bundle;
        bundle.putString(KEY_INSTALL_REFERRER, str);
        bundle.putLong(KEY_REFERRER_CLICK_TIMESTAMP, j10);
        bundle.putLong(KEY_INSTALL_BEGIN_TIMESTAMP, j11);
    }
}
