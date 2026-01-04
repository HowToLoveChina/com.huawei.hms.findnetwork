package com.huawei.hianalytics;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hianalytics.core.log.LogAdapter;

/* renamed from: com.huawei.hianalytics.z0 */
/* loaded from: classes5.dex */
public class C4818z0 implements LogAdapter {

    /* renamed from: a */
    public boolean f22013a = false;

    /* renamed from: a */
    public int f22011a = 4;

    /* renamed from: a */
    public String f22012a = "FormalHASDK";

    /* renamed from: a */
    public final void m29064a(int i10, String str, String str2) {
        int length = str2.length();
        int i11 = 3000;
        int i12 = 0;
        for (int i13 = 0; i13 < (length / 3000) + 1; i13++) {
            if (length > i11) {
                if (i10 != 3) {
                    String strSubstring = str2.substring(i12, i11);
                    if (i10 == 5) {
                        Log.w(str, strSubstring);
                    } else if (i10 != 6) {
                        Log.i(str, strSubstring);
                    } else {
                        Log.e(str, strSubstring);
                    }
                } else {
                    Log.d(str, str2.substring(i12, i11));
                }
                int i14 = i11;
                i11 += 3000;
                i12 = i14;
            } else if (i10 == 3) {
                Log.d(str, str2.substring(i12, length));
            } else if (i10 == 5) {
                Log.w(str, str2.substring(i12, length));
            } else if (i10 != 6) {
                Log.i(str, str2.substring(i12, length));
            } else {
                Log.e(str, str2.substring(i12, length));
            }
        }
    }

    @Override // com.huawei.hianalytics.core.log.LogAdapter
    public void init(int i10, String str) {
        if (this.f22013a) {
            return;
        }
        this.f22011a = i10;
        this.f22013a = true;
        this.f22012a = str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.lineSeparator());
        sb2.append("======================================= ");
        sb2.append(System.lineSeparator());
        sb2.append(this.f22012a + "_3.2.13.500");
        sb2.append(System.lineSeparator());
        sb2.append("=======================================");
        Log.i(str, sb2.toString());
    }

    @Override // com.huawei.hianalytics.core.log.LogAdapter
    public boolean isLoggable(int i10) {
        return this.f22013a && i10 >= this.f22011a;
    }

    @Override // com.huawei.hianalytics.core.log.LogAdapter
    public void println(int i10, String str, String str2) {
        m29064a(i10, TextUtils.isEmpty(this.f22012a) ? "FormalHASDK" : this.f22012a, str + "==> " + str2);
    }
}
