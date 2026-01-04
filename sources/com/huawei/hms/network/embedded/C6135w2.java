package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.huawei.hms.network.embedded.w2 */
/* loaded from: classes8.dex */
public class C6135w2 {

    /* renamed from: a */
    public static final String f28832a = "FileRecordManager";

    /* renamed from: b */
    public static final C6135w2 f28833b = new C6135w2();

    public static C6135w2 getInstance() {
        return f28833b;
    }

    public String getDate() {
        String str = new SimpleDateFormat("yyyy-MM-dd&&HH:mm:ss:SSSS", Locale.ENGLISH).format(new Date());
        Logger.m32144v(f28832a, "the time is : %s", str);
        return str;
    }

    public void saveToLocalFile(String str) {
    }
}
