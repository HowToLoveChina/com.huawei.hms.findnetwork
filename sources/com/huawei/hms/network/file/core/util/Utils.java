package com.huawei.hms.network.file.core.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.network.file.api.GlobalRequestConfig;
import com.huawei.hms.network.file.api.Result;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.task.InterfaceC6234e;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Utils {
    public static final String REQUEST_TIME = "requestTime";
    public static final String RESPONSE_TIME = "responseTime";
    private static final String TAG = "Utils";
    public static final String TOTAL_TIME = "totalTime";
    private static final String WARN_MESSAGE = "com.huawei.android.hms:download and com.huawei.android.hms:upload will not receive new requirements in the future. The maintenance deadline is December 31, 2021. You are advised to switch services You are advised to switch services to com.huawei.hms:filemanager before this time point";
    private static final HashMap<String, String> METHOD_MAP = new HashMap<>();
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: com.huawei.hms.network.file.core.util.Utils$a */
    public static /* synthetic */ class C6250a {

        /* renamed from: a */
        static final /* synthetic */ int[] f29508a;

        static {
            int[] iArr = new int[InterfaceC6234e.a.values().length];
            f29508a = iArr;
            try {
                iArr[InterfaceC6234e.a.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29508a[InterfaceC6234e.a.PROCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29508a[InterfaceC6234e.a.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void addNonEmptyMapItem(Map<String, String> map, Map<String, String> map2) {
        if (map == null || map2 == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static String anonymizeMessage(String str) {
        return isBlank(str) ? "" : StringUtils.anonymizeMessage(str);
    }

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i10] = cArr2[(b10 >>> 4) & 15];
            i10 += 2;
            cArr[i11] = cArr2[b10 & BaseType.Obj];
        }
        return new String(cArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj) {
        return obj;
    }

    public static void checkNpParamsWithException(String str, Object obj) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException(str + " can not be null");
    }

    public static boolean checkReadableStream(int i10) {
        return i10 != 304;
    }

    public static void close(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (RuntimeException | Exception e10) {
            FLogger.logException(e10);
        }
    }

    public static String convertToJsonString(GlobalRequestConfig globalRequestConfig) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (globalRequestConfig.getConnectTimeoutMillis() != -100) {
                jSONObject.put(C6148x2.CONNECT_TIMEOUT, globalRequestConfig.getConnectTimeoutMillis());
            }
            if (globalRequestConfig.getReadTimeoutMillis() != -100) {
                jSONObject.put("read_timeout", globalRequestConfig.getReadTimeoutMillis());
            }
            if (globalRequestConfig.getWriteTimeoutMillis() != -100) {
                jSONObject.put(C6148x2.WRITE_TIMEMEOUT, globalRequestConfig.getWriteTimeoutMillis());
            }
            if (globalRequestConfig.getPingIntervalMillis() != -100) {
                jSONObject.put("ping_interval", globalRequestConfig.getPingIntervalMillis());
            }
            if (globalRequestConfig.getCallTimeoutMillis() != -100) {
                jSONObject.put("call_timeout", globalRequestConfig.getCallTimeoutMillis());
            }
            jSONObject.put("retry_time", 0);
        } catch (JSONException e10) {
            FLogger.m36355w("Utils", "convertToJsonString exception", e10);
        }
        return jSONObject.toString();
    }

    public static boolean deleteFile(String str) {
        if (isBlank(str)) {
            return false;
        }
        File fileM36361a = C6253c.m36361a(str);
        if (!fileM36361a.exists()) {
            return false;
        }
        if (fileM36361a.delete()) {
            FLogger.m36354v("Utils", "deleteFile success filePath: " + str);
            return true;
        }
        FLogger.m36354v("Utils", "deleteFile failed filePath: " + str);
        return false;
    }

    public static int getCheckRangeResult(String str, int i10, boolean z10, boolean z11) {
        boolean z12;
        StringBuilder sb2;
        String str2;
        boolean z13;
        StringBuilder sb3;
        String str3;
        HashMap<Pair<Integer, Integer>, Integer> map = Constants.C6222a.f29374i.get(str);
        if (map == null || map.isEmpty()) {
            return 0;
        }
        Iterator<Pair<Integer, Integer>> it = map.keySet().iterator();
        Pair<Integer, Integer> next = null;
        while (it.hasNext()) {
            next = it.next();
        }
        Iterator<Integer> it2 = map.values().iterator();
        int iIntValue = 0;
        while (it2.hasNext()) {
            iIntValue = it2.next().intValue();
        }
        if (next == null) {
            FLogger.m36351e("Utils", "getCheckRangeResult null rangePair for:" + str);
            return iIntValue;
        }
        if (z10) {
            z12 = i10 >= ((Integer) next.first).intValue();
            sb2 = new StringBuilder();
            str2 = "[";
        } else {
            z12 = i10 > ((Integer) next.first).intValue();
            sb2 = new StringBuilder();
            str2 = "(";
        }
        sb2.append(str2);
        sb2.append(next.first);
        sb2.append(",");
        String string = sb2.toString();
        if (z11) {
            z13 = i10 <= ((Integer) next.second).intValue();
            sb3 = new StringBuilder();
            sb3.append(next.second);
            str3 = "]";
        } else {
            z13 = i10 < ((Integer) next.second).intValue();
            sb3 = new StringBuilder();
            sb3.append(next.second);
            str3 = ")";
        }
        sb3.append(str3);
        String string2 = sb3.toString();
        if (z12 && z13) {
            return i10;
        }
        FLogger.m36355w("Utils", str + " range is " + string + string2, new Object[0]);
        return iIntValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:132:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileHashData(java.lang.String r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Close FileInputStream failed!"
            java.lang.String r1 = "Utils"
            r2 = 0
            java.security.MessageDigest r11 = java.security.MessageDigest.getInstance(r11)     // Catch: java.lang.Throwable -> L40 java.lang.IndexOutOfBoundsException -> L42 java.lang.IllegalArgumentException -> L45 java.io.IOException -> L48 java.io.FileNotFoundException -> L4b java.security.NoSuchAlgorithmException -> L4e
            java.io.FileInputStream r10 = com.huawei.hms.network.file.core.util.C6253c.m36363b(r10)     // Catch: java.lang.Throwable -> L40 java.lang.IndexOutOfBoundsException -> L42 java.lang.IllegalArgumentException -> L45 java.io.IOException -> L48 java.io.FileNotFoundException -> L4b java.security.NoSuchAlgorithmException -> L4e
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L22 java.lang.IndexOutOfBoundsException -> L26 java.lang.IllegalArgumentException -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c java.security.NoSuchAlgorithmException -> L2e
            r4 = 0
            r6 = r4
        L14:
            int r8 = r10.read(r3)     // Catch: java.lang.Throwable -> L22 java.lang.IndexOutOfBoundsException -> L26 java.lang.IllegalArgumentException -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c java.security.NoSuchAlgorithmException -> L2e
            r9 = -1
            if (r8 == r9) goto L30
            r9 = 0
            r11.update(r3, r9, r8)     // Catch: java.lang.Throwable -> L22 java.lang.IndexOutOfBoundsException -> L26 java.lang.IllegalArgumentException -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c java.security.NoSuchAlgorithmException -> L2e
            long r8 = (long) r8     // Catch: java.lang.Throwable -> L22 java.lang.IndexOutOfBoundsException -> L26 java.lang.IllegalArgumentException -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c java.security.NoSuchAlgorithmException -> L2e
            long r6 = r6 + r8
            goto L14
        L22:
            r11 = move-exception
            r2 = r10
            goto L7d
        L26:
            r11 = move-exception
            goto L51
        L28:
            r11 = move-exception
            goto L59
        L2a:
            r11 = move-exception
            goto L61
        L2c:
            r11 = move-exception
            goto L69
        L2e:
            r11 = move-exception
            goto L71
        L30:
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L3c
            byte[] r11 = r11.digest()     // Catch: java.lang.Throwable -> L22 java.lang.IndexOutOfBoundsException -> L26 java.lang.IllegalArgumentException -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c java.security.NoSuchAlgorithmException -> L2e
            java.lang.String r2 = byteArrayToHex(r11)     // Catch: java.lang.Throwable -> L22 java.lang.IndexOutOfBoundsException -> L26 java.lang.IllegalArgumentException -> L28 java.io.IOException -> L2a java.io.FileNotFoundException -> L2c java.security.NoSuchAlgorithmException -> L2e
        L3c:
            r10.close()     // Catch: java.io.IOException -> L79
            goto L7c
        L40:
            r11 = move-exception
            goto L7d
        L42:
            r11 = move-exception
            r10 = r2
            goto L51
        L45:
            r11 = move-exception
            r10 = r2
            goto L59
        L48:
            r11 = move-exception
            r10 = r2
            goto L61
        L4b:
            r11 = move-exception
            r10 = r2
            goto L69
        L4e:
            r11 = move-exception
            r10 = r2
            goto L71
        L51:
            java.lang.String r3 = "getFileHashData IndexOutOfBoundsException"
            com.huawei.hms.network.file.core.util.FLogger.m36352e(r1, r3, r11)     // Catch: java.lang.Throwable -> L22
            if (r10 == 0) goto L7c
            goto L3c
        L59:
            java.lang.String r3 = "getFileHashData IllegalArgumentException"
            com.huawei.hms.network.file.core.util.FLogger.m36352e(r1, r3, r11)     // Catch: java.lang.Throwable -> L22
            if (r10 == 0) goto L7c
            goto L3c
        L61:
            java.lang.String r3 = "getFileHashData IOException"
            com.huawei.hms.network.file.core.util.FLogger.m36352e(r1, r3, r11)     // Catch: java.lang.Throwable -> L22
            if (r10 == 0) goto L7c
            goto L3c
        L69:
            java.lang.String r3 = "getFileHashData FileNotFoundException"
            com.huawei.hms.network.file.core.util.FLogger.m36352e(r1, r3, r11)     // Catch: java.lang.Throwable -> L22
            if (r10 == 0) goto L7c
            goto L3c
        L71:
            java.lang.String r3 = "getFileHashData NoSuchAlgorithmException"
            com.huawei.hms.network.file.core.util.FLogger.m36352e(r1, r3, r11)     // Catch: java.lang.Throwable -> L22
            if (r10 == 0) goto L7c
            goto L3c
        L79:
            com.huawei.hms.network.file.core.util.FLogger.m36351e(r1, r0)
        L7c:
            return r2
        L7d:
            if (r2 == 0) goto L86
            r2.close()     // Catch: java.io.IOException -> L83
            goto L86
        L83:
            com.huawei.hms.network.file.core.util.FLogger.m36351e(r1, r0)
        L86:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.file.core.util.Utils.getFileHashData(java.lang.String, java.lang.String):java.lang.String");
    }

    public static long getLongId() {
        return C6255e.m36368b().m36369a();
    }

    public static Result.STATUS getMapedStatus(InterfaceC6234e.a aVar) {
        int i10 = C6250a.f29508a[aVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? Result.STATUS.INVALID : Result.STATUS.PAUSE : Result.STATUS.PROCESS : Result.STATUS.INIT;
    }

    public static String getUrlPath(String str) {
        String path = (isBlank(str) || !str.startsWith("http")) ? "" : Uri.parse(str).getPath();
        return (path == null || path.equals(str)) ? "" : path;
    }

    public static String getValueFromOptions(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str2).getString(str);
        } catch (JSONException unused) {
            FLogger.m36355w("Utils", "get key From options fail, key is " + str, new Object[0]);
            return "";
        }
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isDeepEqual(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isUrlValid(String str) {
        if (isBlank(str)) {
            return false;
        }
        return str.toLowerCase(Locale.ROOT).startsWith("http");
    }

    public static String nullStrToEmpty(String str) {
        return str == null ? "" : str;
    }

    public static void printDeprecatedLogIfNeed() {
        FLogger.m36355w("Utils", WARN_MESSAGE, new Object[0]);
    }

    public static void printDeprecatedMethodLog(String str) {
        HashMap<String, String> map = METHOD_MAP;
        if (map.containsKey(str)) {
            return;
        }
        map.put(str, str);
        FLogger.m36355w("Utils", "the method " + str + " is deprecated and invalid in this version", new Object[0]);
    }

    public static boolean isUrlValid(List<String> list) {
        if (isEmpty(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!isUrlValid(it.next())) {
                return false;
            }
        }
        return true;
    }
}
