package com.huawei.hianalytics;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.g1 */
/* loaded from: classes5.dex */
public class C4778g1 {
    /* renamed from: a */
    public static synchronized JSONObject m28886a(LinkedHashMap<String, String> linkedHashMap) {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception unused) {
            HiLog.m28808e("HASU", "map to json error");
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m28887a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                HiLog.m28812w("HASU", "close error");
            }
        }
    }

    /* renamed from: a */
    public static void m28888a(File file, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.flush();
                } catch (Exception unused) {
                    fileOutputStream2 = fileOutputStream;
                    HiLog.m28808e("HASU", "save file error");
                    fileOutputStream = fileOutputStream2;
                    m28887a(fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    m28887a(fileOutputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception unused2) {
        }
        m28887a(fileOutputStream);
    }
}
