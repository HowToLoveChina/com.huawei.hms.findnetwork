package com.huawei.android.backup.filelogic.utils;

import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.android.backup.filelogic.utils.g */
/* loaded from: classes.dex */
public class C2114g {

    /* renamed from: a */
    public static final Map<Integer, String> f9544a;

    /* renamed from: b */
    public static final Map<String, Long> f9545b;

    /* renamed from: c */
    public static long f9546c;

    /* renamed from: d */
    public static long f9547d;

    /* renamed from: e */
    public static long f9548e;

    /* renamed from: f */
    public static long f9549f;

    static {
        HashMap map = new HashMap(3);
        f9544a = map;
        f9545b = new HashMap(11);
        f9546c = 0L;
        f9547d = 0L;
        f9548e = 0L;
        f9549f = 0L;
        map.put(0, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        map.put(1, "restore");
        map.put(2, "transfer");
    }

    /* renamed from: a */
    public static String m12662a(long j10) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j10 < ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
            return j10 + CloudBackupConstant.UserPackageInfo.ONE_T_MEMBER;
        }
        if (j10 < 1048576) {
            return decimalFormat.format(j10 / 1024.0f) + "KB";
        }
        if (j10 < Constants.ONE_GB_SIZE) {
            return decimalFormat.format(j10 / 1048576.0f) + "MB";
        }
        return decimalFormat.format(j10 / 1.0737418E9f) + "GB";
    }

    /* renamed from: b */
    public static String m12663b(long j10) {
        if (j10 > 1000) {
            return String.valueOf(j10 / 1000) + "s";
        }
        return j10 + "ms";
    }

    /* renamed from: c */
    public static void m12664c(String str, long j10, long j11) {
        C2111d.m12654j("Performance_Testing", "end pms tar appName = ", str, ";totalTime = ", m12663b(j11 - j10));
    }

    /* renamed from: d */
    public static void m12665d(String str, long j10, long j11, long j12) {
        C2111d.m12653i("Performance_Testing", "end pms tar appName = " + str + ";totalTime = " + m12663b(j11 - j10) + ";tarSize = " + j12);
    }

    /* renamed from: e */
    public static void m12666e(String str, long j10) {
        C2111d.m12653i("Performance_Testing", "start pms tar appName = " + str + ";startTime = " + j10);
    }
}
