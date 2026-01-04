package com.huawei.phoneservice.feedbackcommon.utils;

import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mx.C11557q;
import org.json.JSONException;
import org.json.JSONObject;
import p269ex.C9571a;
import p376ix.C10631a;
import p502nx.EnumC11763c;
import p502nx.EnumC11764d;

/* loaded from: classes5.dex */
public class ZipUtil {
    public static final int DEFAULT_SPLIT_VOLUME_SIZE = 33554432;
    private static final int FILE_MIN_NUMBER = 1;
    private static final int INITIAL_CAPACITY = 16;
    private static final String TAG = "ZipUtil";
    private static long size;

    public static boolean deleteFile(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            deleteFile(file2);
        }
        return file.delete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String fileSha256(java.io.File r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "ZipUtil"
            boolean r1 = isValidFile(r8)
            java.lang.String r2 = "FileSHA256"
            if (r1 != 0) goto L12
            java.lang.String r8 = "file is not valid"
            com.huawei.phoneservice.faq.base.util.FaqLogger.print(r2, r8)
            java.lang.String r8 = ""
            return r8
        L12:
            r1 = 0
            java.lang.String r3 = "SHA-256"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48 java.security.NoSuchAlgorithmException -> L4a
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48 java.security.NoSuchAlgorithmException -> L4a
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48 java.security.NoSuchAlgorithmException -> L4a
            r8 = 8192(0x2000, float:1.148E-41)
            byte[] r8 = new byte[r8]     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.security.NoSuchAlgorithmException -> L34
            r5 = 0
            r6 = r5
        L24:
            int r7 = r4.read(r8)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.security.NoSuchAlgorithmException -> L34
            if (r7 <= 0) goto L36
            r3.update(r8, r5, r7)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.security.NoSuchAlgorithmException -> L34
            r6 = 1
            goto L24
        L2f:
            r8 = move-exception
            goto L90
        L32:
            r8 = move-exception
            goto L4d
        L34:
            r8 = move-exception
            goto L6c
        L36:
            if (r6 == 0) goto L40
            byte[] r8 = r3.digest()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.security.NoSuchAlgorithmException -> L34
            java.lang.String r1 = lu.C11343b.m68146a(r8)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.security.NoSuchAlgorithmException -> L34
        L40:
            r4.close()     // Catch: java.io.IOException -> L44
            goto L8e
        L44:
            r8 = move-exception
            goto L87
        L46:
            r8 = move-exception
            goto L8f
        L48:
            r8 = move-exception
            goto L4c
        L4a:
            r8 = move-exception
            goto L6b
        L4c:
            r4 = r1
        L4d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68
            r3.<init>()     // Catch: java.lang.Throwable -> L68
            java.lang.String r5 = "IOException"
            r3.append(r5)     // Catch: java.lang.Throwable -> L68
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L68
            r3.append(r8)     // Catch: java.lang.Throwable -> L68
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> L68
            com.huawei.phoneservice.faq.base.util.FaqLogger.print(r2, r8)     // Catch: java.lang.Throwable -> L68
            if (r4 == 0) goto L8e
            goto L40
        L68:
            r8 = move-exception
            r1 = r4
            goto L8f
        L6b:
            r4 = r1
        L6c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68
            r3.<init>()     // Catch: java.lang.Throwable -> L68
            java.lang.String r5 = "NoSuchAlgorithmException"
            r3.append(r5)     // Catch: java.lang.Throwable -> L68
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L68
            r3.append(r8)     // Catch: java.lang.Throwable -> L68
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> L68
            com.huawei.phoneservice.faq.base.util.FaqLogger.print(r2, r8)     // Catch: java.lang.Throwable -> L68
            if (r4 == 0) goto L8e
            goto L40
        L87:
            java.lang.String r8 = r8.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r8)
        L8e:
            return r1
        L8f:
            r4 = r1
        L90:
            if (r4 == 0) goto L9e
            r4.close()     // Catch: java.io.IOException -> L96
            goto L9e
        L96:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r1)
        L9e:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedbackcommon.utils.ZipUtil.fileSha256(java.io.File):java.lang.String");
    }

    public static int fileToZip(String str, String str2, String str3, long j10) throws Throwable {
        String message;
        String str4;
        try {
            File canonicalFile = new File(str).getCanonicalFile();
            if (canonicalFile.exists()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                String str5 = File.separator;
                sb2.append(str5);
                sb2.append(str3);
                sb2.append(FeedbackWebConstants.SUFFIX);
                File canonicalFile2 = new File(sb2.toString()).getCanonicalFile();
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (canonicalFile2.exists()) {
                    canonicalFile2.delete();
                }
                File[] fileArrListFiles = canonicalFile.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length >= 1) {
                    return isZipSplitVolumeKeepFolder(str, str2 + str5 + str3 + FeedbackWebConstants.SUFFIX, j10);
                }
                str4 = "SOURCE_FOLDER IS EMPTY";
            } else {
                str4 = "SOURCE_FILE NOT EXISTS";
            }
            FaqLogger.print(TAG, str4);
        } catch (FileNotFoundException unused) {
            message = "FileNotFoundException Exception";
            FaqLogger.m51840e(TAG, message);
            return 0;
        } catch (IOException | Exception e10) {
            message = e10.getMessage();
            FaqLogger.m51840e(TAG, message);
            return 0;
        }
        return 0;
    }

    public static Map<String, String> getCommonHeaderParameter(String str) {
        HashMap map = new HashMap(16);
        map.put(FeedbackWebConstants.HEAD_CONTENT_TYPE_KEY, FeedbackWebConstants.HEAD_CONTENT_TYPE_VALUE);
        if (str != null) {
            map.put(FeedbackWebConstants.AUTHORIZATION, str);
        }
        return map;
    }

    private static Map<String, Object> getMap(String str) throws Throwable {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            HashMap map = new HashMap(16);
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.get(next));
            }
            return map;
        } catch (JSONException e10) {
            FaqLogger.m51840e(TAG, e10.getMessage());
            return null;
        }
    }

    public static long getSize() {
        return size;
    }

    private static boolean isValidFile(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static int isZipSplitVolumeKeepFolder(String str, String str2, long j10) throws Throwable {
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file2.exists()) {
                file2.delete();
            }
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            C9571a c9571a = new C9571a(file2);
            C11557q c11557q = new C11557q();
            c11557q.m68987D(false);
            c11557q.m69012w(EnumC11764d.DEFLATE);
            c11557q.m69011v(EnumC11763c.MAXIMUM);
            if (0 == j10) {
                c9571a.m59751v(file, c11557q, true, 33554432L);
            } else {
                c9571a.m59751v(file, c11557q, true, j10);
            }
            return 2;
        } catch (C10631a | Exception e10) {
            FaqLogger.m51840e(TAG, e10.getMessage());
            return 1;
        }
    }

    public static String mapToString(String str) {
        Set<Map.Entry<String, Object>> setEntrySet = getMap(str).entrySet();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, Object> entry : setEntrySet) {
            sb2.append(entry.getKey());
            sb2.append("=");
            sb2.append(entry.getValue());
            sb2.append("&");
        }
        return sb2.length() != 0 ? sb2.substring(0, sb2.length() - 1) : "";
    }

    public static void setSize(long j10) {
        size = j10;
    }

    public static void getSize(File[] fileArr) {
        if (fileArr == null || fileArr.length <= 0) {
            return;
        }
        for (File file : fileArr) {
            if (file.isFile()) {
                size += file.length();
            }
            if (file.isDirectory()) {
                getSize(file.listFiles());
            }
        }
    }
}
