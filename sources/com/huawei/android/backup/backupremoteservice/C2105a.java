package com.huawei.android.backup.backupremoteservice;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;

/* renamed from: com.huawei.android.backup.backupremoteservice.a */
/* loaded from: classes.dex */
public class C2105a {
    /* renamed from: a */
    public static boolean m12585a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ("photo".equals(str) || Constants.VIDEO_SUB_DIR.equals(str)) || ("photo_sd".equals(str) || "video_sd".equals(str)) || "wechat_record".equals(str);
    }

    /* renamed from: b */
    public static boolean m12586b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "photo".equals(str) || "photo_sd".equals(str);
    }
}
