package com.huawei.android.backup.service.logic;

import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import java.io.File;
import p229di.C9142g;

/* renamed from: com.huawei.android.backup.service.logic.m */
/* loaded from: classes.dex */
public class C2154m {
    /* renamed from: a */
    public static String m13096a(String str, boolean z10, int i10) {
        String str2;
        String str3 = "/data/data/com.hicloud.android.clone/files/clone/";
        if (z10) {
            str2 = "backup tar";
            if (i10 == 0) {
                str3 = "/data/data/com.hicloud.android.clone/files/clone/" + str + File.separator;
            } else {
                str3 = "/data/data/com.hicloud.android.clone/files/clone/" + str + "#TwinApp" + File.separator;
            }
        } else {
            str2 = "backup dir";
        }
        return str2 + " " + (BackupRestoreConstans.DATA_USER_PATH + i10 + File.separator + str) + " " + str3;
    }

    /* renamed from: b */
    public static String m13097b(String str, String str2) {
        return "restore tar " + str + " " + (BackupRestoreConstans.DATA_PATH + str2);
    }

    /* renamed from: c */
    public static String m13098c(String str, int i10) {
        return "backup tar " + (BackupRestoreConstans.DATA_USER_PATH + i10 + File.separator + str) + " /data/data/com.hicloud.android.clone/files/clone/" + str + "_CloneDataDataPmsTar";
    }

    /* renamed from: d */
    public static String m13099d(String str, int i10) {
        StringBuilder sb2 = new StringBuilder(BackupRestoreConstans.DATA_USER_PATH);
        sb2.append(i10);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        String string = sb2.toString();
        String str3 = C9142g.m57463b() ? "com.hihonor.notepad" : NextRestoreConstants.PKG_NAME_MEMO;
        if (str.contains(str3)) {
            str = str.replace(str3, "com.example.android.notepad");
        } else if (str.contains("com.hihonor.notepad")) {
            str = str.replace("com.hihonor.notepad", "com.example.android.notepad");
        }
        return "backup tar " + string + " " + ("/data/data/com.huawei.hidisk/files/cloudbackup/.tempFiles" + str2) + str;
    }

    /* renamed from: e */
    public static String m13100e(String str, String str2, String str3) {
        return "restore tar " + str + " " + (str2 + File.separator + str3);
    }

    /* renamed from: f */
    public static String m13101f(String str, boolean z10, String str2, int i10) {
        String str3;
        String str4;
        if (z10) {
            str2 = str2 + File.separator + str + ".tar";
            str3 = "restore tar";
        } else {
            str3 = "restore dir";
        }
        if (i10 == 0) {
            str4 = BackupRestoreConstans.DATA_PATH + str;
        } else {
            str4 = BackupRestoreConstans.DATA_USER_PATH + i10 + File.separator + str;
        }
        if (TextUtils.isEmpty(str2)) {
            return str3 + " /data/data/com.hicloud.android.clone/files/clone/ " + str4;
        }
        return str3 + " " + str2 + " " + str4;
    }

    /* renamed from: g */
    public static String m13102g(String str, String str2, int i10) {
        String str3 = str2 + "/split/" + str + ".tar.txt";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BackupRestoreConstans.DATA_USER_PATH);
        sb2.append(i10);
        String str4 = File.separator;
        sb2.append(str4);
        sb2.append(str);
        sb2.append(str4);
        String string = sb2.toString();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("restore split");
        stringBuffer.append(" ");
        stringBuffer.append(str3);
        stringBuffer.append(" ");
        stringBuffer.append(string);
        return stringBuffer.toString();
    }

    /* renamed from: h */
    public static String m13103h(String str, int i10) {
        if (str == null) {
            return "clear shortcuts temp files";
        }
        StringBuilder sb2 = new StringBuilder("/data/system_ce/");
        sb2.append(i10);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("shortcut_service");
        return "backup dir " + sb2.toString() + " /data/data/com.hicloud.android.clone/files/clone/" + str + str2;
    }

    /* renamed from: i */
    public static String m13104i(String str) {
        return "/data/data/com.hicloud.android.clone/files/clone/" + str + File.separator + "shortcut_service";
    }

    /* renamed from: j */
    public static String m13105j(String str, String str2) {
        if (str == null) {
            return "restore shortcuts";
        }
        StringBuilder sb2 = new StringBuilder(str2);
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str);
        sb2.append(str3);
        sb2.append("shortcut_service");
        return "backup dir " + sb2.toString() + " " + BackupRestoreConstans.DATA_PATH + "android/shortcut_clone";
    }

    /* renamed from: k */
    public static boolean m13106k(int i10) {
        if (i10 != -1 && i10 != -2) {
            return true;
        }
        C2111d.m12654j("PmsConstants", "isValidSessionId false, conversationId:", Integer.valueOf(i10));
        return false;
    }

    /* renamed from: l */
    public static boolean m13107l(int i10) {
        if (i10 != -3 && i10 != -2 && i10 != -1) {
            return true;
        }
        C2111d.m12654j("PmsConstants", "isValidTaskId false, taskId:", Integer.valueOf(i10));
        return false;
    }
}
