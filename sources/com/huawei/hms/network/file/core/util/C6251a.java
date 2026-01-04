package com.huawei.hms.network.file.core.util;

import android.app.ActivityManager;
import android.content.Context;
import com.huawei.hms.network.file.p130a.p133k.p134b.C6204f;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/* renamed from: com.huawei.hms.network.file.core.util.a */
/* loaded from: classes8.dex */
public class C6251a {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static int m36356a() throws Throwable {
        InputStreamReader inputStreamReader;
        IOException e10;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3 = null;
        try {
            try {
                inputStreamReader2 = new InputStreamReader(new FileInputStream("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"), Constants.UTF_8);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader2);
                    try {
                        String line = bufferedReader.readLine();
                        i = Utils.isBlank(line) ? 0 : Integer.parseInt(line.trim());
                        C6204f.m36109a((Closeable) inputStreamReader2);
                        C6204f.m36109a((Closeable) bufferedReader);
                    } catch (FileNotFoundException unused) {
                        inputStreamReader3 = bufferedReader;
                        FLogger.m36355w("CpuTool", "getCurCpuFreq exception fileNotFoundException", new Object[0]);
                        C6204f.m36109a((Closeable) inputStreamReader2);
                        C6204f.m36109a((Closeable) inputStreamReader3);
                        return i;
                    } catch (IOException e11) {
                        e10 = e11;
                        inputStreamReader3 = bufferedReader;
                        FLogger.m36355w("CpuTool", "getCurCpuFreq exception", e10);
                        C6204f.m36109a((Closeable) inputStreamReader2);
                        C6204f.m36109a((Closeable) inputStreamReader3);
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader3 = bufferedReader;
                        C6204f.m36109a((Closeable) inputStreamReader2);
                        C6204f.m36109a((Closeable) inputStreamReader3);
                        throw th;
                    }
                } catch (FileNotFoundException unused2) {
                } catch (IOException e12) {
                    e10 = e12;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (FileNotFoundException unused3) {
                inputStreamReader2 = null;
            } catch (IOException e13) {
                e10 = e13;
                inputStreamReader2 = null;
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
                inputStreamReader2 = inputStreamReader3;
                inputStreamReader3 = inputStreamReader;
                C6204f.m36109a((Closeable) inputStreamReader2);
                C6204f.m36109a((Closeable) inputStreamReader3);
                throw th;
            }
            return i;
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = inputStreamReader3;
            inputStreamReader3 = inputStreamReader2;
            inputStreamReader2 = inputStreamReader3;
            inputStreamReader3 = inputStreamReader;
            C6204f.m36109a((Closeable) inputStreamReader2);
            C6204f.m36109a((Closeable) inputStreamReader3);
            throw th;
        }
    }

    /* renamed from: a */
    public static long m36357a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.availMem;
            } catch (Exception e10) {
                FLogger.m36355w("CpuTool", "getAvailableRam exception:", e10);
            }
        }
        return 0L;
    }
}
