package com.huawei.hms.locationSdk;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import bs.C1275b;
import bs.C1283j;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LogConfig;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.riemann.location.common.utils.Constant;
import es.C9536a;
import es.C9548m;
import hu.C10343b;
import java.io.File;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* renamed from: com.huawei.hms.locationSdk.x1 */
/* loaded from: classes8.dex */
public class C5769x1 {
    /* renamed from: a */
    public static String m33205a(Context context) {
        StringBuilder sb2 = new StringBuilder();
        String packageName = context.getPackageName();
        String strValueOf = String.valueOf(C9536a.m59551k(context.getPackageName()));
        String strValueOf2 = String.valueOf(61403300);
        String strValueOf3 = String.valueOf(C9536a.m59551k("com.huawei.hwid"));
        sb2.append(packageName);
        sb2.append(":");
        sb2.append(strValueOf);
        sb2.append(",");
        sb2.append("locationSdkVersion");
        sb2.append(":");
        sb2.append(strValueOf2);
        sb2.append(",");
        sb2.append("com.huawei.hwid");
        sb2.append(":");
        sb2.append(strValueOf3);
        return sb2.toString();
    }

    /* renamed from: b */
    public static boolean m33210b() {
        return false;
    }

    /* renamed from: a */
    public static boolean m33208a(String str) throws PatternSyntaxException {
        return !Pattern.compile("^[-a-zA-Z0-9_/.]+$").matcher(str).find();
    }

    /* renamed from: b */
    public static void m33209b(Context context, String str, String str2) throws ApiException {
        if (TextUtils.isEmpty(str)) {
            throw new ApiException(new Status(LocationStatusCode.ARGUMENTS_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.ARGUMENTS_EMPTY)));
        }
        if (!str.startsWith("data/data/") && !str.startsWith(BackupRestoreConstans.DATA_PATH) && !str.startsWith("/data/user") && !str.startsWith("data/user") && !str.startsWith("/storage/emulated") && !str.startsWith("storage/emulated") && !str.startsWith("/storage/B3E4-1711") && !str.startsWith("storage/B3E4-1711") && !str.startsWith("/storage/sdcard") && !str.startsWith("storage/sdcard") && !str.startsWith("/mnt/sdcard/") && !str.startsWith("mnt/sdcard/") && !"com.huawei.maps.auto.app".equals(context.getPackageName())) {
            throw new ApiException(new Status(10101, LocationStatusCode.getStatusCodeString(10101)));
        }
        if (m33208a(str)) {
            throw new ApiException(new Status(10101, LocationStatusCode.getStatusCodeString(10101)));
        }
        File file = new File(str);
        try {
            if (file.exists()) {
                return;
            }
            if (file.mkdirs()) {
                HMSLocationLog.m36662i("WriteLocationResultUtil", str2, "createFolder success");
            } else {
                HMSLocationLog.m36660e("WriteLocationResultUtil", str2, "createFolder fail");
                throw new ApiException(new Status(10101, LocationStatusCode.getStatusCodeString(10101)));
            }
        } catch (SecurityException e10) {
            HMSLocationLog.m36660e("WriteLocationResultUtil", str2, "createFolder SecurityException:" + e10.getMessage());
        }
    }

    /* renamed from: a */
    private static String m33204a() {
        return C1275b.m7550a(Calendar.getInstance().getTime(), "yy-MM-dd HH:mm:ss.SSS");
    }

    /* renamed from: a */
    public static C1283j m33203a(LogConfig logConfig) {
        C1283j c1283j = new C1283j();
        c1283j.m7613e(logConfig.getFileExpiredTime());
        c1283j.m7614f(logConfig.getFileNum());
        c1283j.m7615g(logConfig.getFileSize());
        c1283j.m7616h(logConfig.getLogPath());
        return c1283j;
    }

    /* renamed from: a */
    public static void m33207a(Context context, String str, String str2) throws ApiException {
        String str3;
        if (TextUtils.isEmpty(str)) {
            throw new ApiException(new Status(LocationStatusCode.ARGUMENTS_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.ARGUMENTS_EMPTY)));
        }
        if (str.startsWith("data/user") || str.startsWith(BackupRestoreConstans.DATA_PATH) || str.startsWith("data/data/") || str.startsWith("/data/user")) {
            str3 = "setLogConfig internal storage - read and write permissions not need to be verified";
        } else {
            HMSLocationLog.m36662i("WriteLocationResultUtil", str2, "setLogConfig Non-internal storage - read and write permissions need to be verified");
            if (!C9548m.m59619b(context, "android.permission.READ_EXTERNAL_STORAGE")) {
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            }
            if (!C9548m.m59619b(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            }
            str3 = "setLogConfig Permission check pass";
        }
        HMSLocationLog.m36662i("WriteLocationResultUtil", str2, str3);
    }

    /* renamed from: a */
    public static String m33206a(String str, LocationResult locationResult) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\t");
        sb2.append(m33204a());
        sb2.append(",");
        sb2.append(str);
        sb2.append(",");
        Location location = locationResult.getLocations().get(0);
        if (location != null) {
            sb2.append(location.getProvider());
            sb2.append(",");
            sb2.append("\t");
            sb2.append(location.getLatitude());
            sb2.append(",");
            sb2.append("\t");
            sb2.append(location.getLongitude());
            sb2.append(",");
            sb2.append(location.getAccuracy());
            sb2.append(",");
            sb2.append("\t");
            sb2.append(location.getTime());
            sb2.append(",");
            sb2.append(location.getSpeed());
            sb2.append(",");
            Bundle extras = location.getExtras();
            C10343b c10343b = new C10343b(extras);
            if (extras != null) {
                sb2.append(c10343b.m63694p("session_id"));
                sb2.append(",");
                int iM63687i = c10343b.m63687i(Constant.LOCATION_SOURCE_TYPE, Integer.MIN_VALUE);
                if (iM63687i == Integer.MIN_VALUE) {
                    sb2.append("null");
                } else {
                    sb2.append(iM63687i);
                }
                sb2.append(",");
                sb2.append(c10343b.m63694p("locateType"));
                sb2.append(",");
                sb2.append(c10343b.m63686h("vendorType"));
                sb2.append(",");
                sb2.append(c10343b.m63694p("src"));
                sb2.append(",");
                sb2.append(c10343b.m63686h("switchHd"));
                sb2.append(",");
                sb2.append(c10343b.m63686h("floor"));
                sb2.append(",");
                sb2.append(c10343b.m63686h("floorAcc"));
                sb2.append(",");
                sb2.append(c10343b.m63694p("buildingId"));
            }
        }
        return sb2.toString();
    }
}
