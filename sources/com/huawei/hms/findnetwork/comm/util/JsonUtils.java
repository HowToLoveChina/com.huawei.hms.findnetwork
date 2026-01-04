package com.huawei.hms.findnetwork.comm.util;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.huawei.hms.findnetwork.comm.log.HmsFindCommonLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p028b4.C1107a;

/* loaded from: classes8.dex */
public class JsonUtils {
    private static final String TAG = "JsonUtils";
    private static volatile Gson mInstance;

    private static GsonBuilder getGsonBuilder() {
        return new GsonBuilder().enableComplexMapKeySerialization().serializeSpecialFloatingPointValues().disableHtmlEscaping().setLenient();
    }

    public static Gson getInstance() {
        if (mInstance == null) {
            synchronized (JsonUtils.class) {
                try {
                    if (mInstance == null) {
                        mInstance = getGsonBuilder().create();
                    }
                } finally {
                }
            }
        }
        return mInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005f A[Catch: IOException -> 0x0063, TRY_LEAVE, TryCatch #3 {IOException -> 0x0063, blocks: (B:33:0x005a, B:35:0x005f), top: B:44:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.InputStreamReader, java.io.Reader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getJsonFromAssetFile(android.content.Context r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "close inputStream failed"
            java.lang.String r1 = "JsonUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 0
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3c
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3c
            java.io.InputStream r5 = r5.open(r6)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3c
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3c
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3c
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L3d
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L3d
        L1e:
            java.lang.String r6 = r5.readLine()     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L33
            if (r6 == 0) goto L2a
            r2.append(r6)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L33
            goto L1e
        L28:
            r6 = move-exception
            goto L31
        L2a:
            r5.close()     // Catch: java.io.IOException -> L4a
        L2d:
            r4.close()     // Catch: java.io.IOException -> L4a
            goto L4d
        L31:
            r3 = r5
            goto L58
        L33:
            r3 = r5
            goto L3d
        L35:
            r5 = move-exception
            r6 = r5
            goto L58
        L38:
            r5 = move-exception
            r6 = r5
            r5 = r3
            goto L56
        L3c:
            r4 = r3
        L3d:
            java.lang.String r5 = "Get json data from AssetFile failed"
            com.huawei.hms.findnetwork.comm.log.HmsFindCommonLog.m31924e(r1, r5)     // Catch: java.lang.Throwable -> L52
            if (r3 == 0) goto L47
            r3.close()     // Catch: java.io.IOException -> L4a
        L47:
            if (r4 == 0) goto L4d
            goto L2d
        L4a:
            com.huawei.hms.findnetwork.comm.log.HmsFindCommonLog.m31924e(r1, r0)
        L4d:
            java.lang.String r5 = r2.toString()
            return r5
        L52:
            r5 = move-exception
            r6 = r5
            r5 = r3
            r3 = r4
        L56:
            r4 = r3
            goto L31
        L58:
            if (r3 == 0) goto L5d
            r3.close()     // Catch: java.io.IOException -> L63
        L5d:
            if (r4 == 0) goto L66
            r4.close()     // Catch: java.io.IOException -> L63
            goto L66
        L63:
            com.huawei.hms.findnetwork.comm.log.HmsFindCommonLog.m31924e(r1, r0)
        L66:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.findnetwork.comm.util.JsonUtils.getJsonFromAssetFile(android.content.Context, java.lang.String):java.lang.String");
    }

    public static <T> List<T> getObjectList(String str, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        try {
        } catch (Throwable th2) {
            HmsFindCommonLog.m31924e(TAG, "Get Object List failed, " + th2.getMessage());
        }
        if (!isJsonStr(str)) {
            return arrayList;
        }
        Gson gson = new Gson();
        Iterator<JsonElement> it = JsonParser.parseString(C1107a.m6595v(str)).getAsJsonArray().iterator();
        while (it.hasNext()) {
            arrayList.add(gson.fromJson(it.next(), (Class) cls));
        }
        return arrayList;
    }

    public static boolean isJSONArrayStr(String str) {
        if (str == null) {
            return false;
        }
        try {
            new JSONArray(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean isJSONObjectStr(String str) {
        if (str == null) {
            return false;
        }
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean isJsonStr(String str) {
        if (str == null) {
            return false;
        }
        return isJSONArrayStr(str) || isJSONObjectStr(str);
    }

    public static <K, V> Map<K, V> json2Map(String str, Type type) {
        Map<K, V> mapEmptyMap = Collections.emptyMap();
        try {
            if (!isJsonStr(str)) {
                return mapEmptyMap;
            }
            return (Map) getInstance().fromJson(C1107a.m6595v(str), type);
        } catch (Throwable unused) {
            HmsFindCommonLog.m31924e(TAG, "Get Map failed");
            return mapEmptyMap;
        }
    }

    public static <T> T json2Object(String str, Class<T> cls) {
        if (!TextUtils.isEmpty(str) && cls != null) {
            try {
                if (!isJsonStr(str)) {
                    return null;
                }
                return (T) getInstance().fromJson(C1107a.m6595v(str), (Class) cls);
            } catch (Throwable th2) {
                HmsFindCommonLog.m31925i(TAG, "json2Object exception: " + th2.getMessage());
            }
        }
        return null;
    }

    public static String map2Json(Map map) {
        if (map == null) {
            return null;
        }
        try {
            return getInstance().toJson(map);
        } catch (Throwable th2) {
            HmsFindCommonLog.m31924e(TAG, "JsonParseException:" + th2.getMessage());
            return null;
        }
    }

    public static <T> String object2Json(T t10) {
        if (t10 == null) {
            return null;
        }
        try {
            return getInstance().toJson(t10);
        } catch (Exception e10) {
            HmsFindCommonLog.m31924e(TAG, "object2Json exception: " + e10.getMessage());
            return null;
        }
    }

    public static String sanitize(String str) {
        return C1107a.m6595v(str);
    }

    public static String strParser(String str) {
        try {
            return new JsonParser().parse(C1107a.m6595v(str)).getAsJsonObject().toString();
        } catch (Exception unused) {
            HmsFindCommonLog.m31924e(TAG, "strParser failed");
            return null;
        }
    }

    public static <T> T json2Object(String str, Type type) {
        if (!TextUtils.isEmpty(str) && type != null) {
            try {
                if (!isJsonStr(str)) {
                    return null;
                }
                return (T) getInstance().fromJson(C1107a.m6595v(str), type);
            } catch (Throwable th2) {
                HmsFindCommonLog.m31924e(TAG, "json2Object,JsonParseException:" + th2.getMessage());
            }
        }
        return null;
    }
}
