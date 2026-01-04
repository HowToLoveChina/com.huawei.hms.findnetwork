package com.huawei.android.hicloud.clouddisk.logic.sms;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p015ak.C0209d;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public final class SmsThreadsHandle {
    public static final int BROADCAST_THREAD = 1;
    public static final int COMMON_THREAD = 0;
    public static final Uri CONTENT_URI;
    public static final int GROUP_VALUE = 2;
    private static final String[] ID_PROJECTION;
    private static final Pattern NAME_ADDR_EMAIL_PATTERN;
    public static final Uri OBSOLETE_THREADS_URI;
    private static final String TAG = "SmsThreadsHandle";
    private static final Uri THREAD_ID_CONTENT_URI;

    static {
        Uri uriWithAppendedPath = Uri.withAppendedPath(Uri.parse("content://mms-sms/"), "conversations");
        CONTENT_URI = uriWithAppendedPath;
        OBSOLETE_THREADS_URI = Uri.withAppendedPath(uriWithAppendedPath, "obsolete");
        NAME_ADDR_EMAIL_PATTERN = Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");
        ID_PROJECTION = new String[]{"_id"};
        THREAD_ID_CONTENT_URI = Uri.parse("content://mms-sms/threadID");
    }

    private SmsThreadsHandle() {
    }

    private static String extractAddrSpec(String str) {
        Matcher matcher = NAME_ADDR_EMAIL_PATTERN.matcher(str);
        return matcher.matches() ? matcher.group(2) : str;
    }

    public static long getOrCreateThreadId(Context context, String str) {
        Uri.Builder builderBuildUpon = THREAD_ID_CONTENT_URI.buildUpon();
        if (isEmailAddress(str)) {
            str = extractAddrSpec(str);
        }
        builderBuildUpon.appendQueryParameter("recipient", str);
        Uri uriBuild = builderBuildUpon.build();
        if (!C0209d.m1227Y1(context, uriBuild)) {
            C11839m.m70687e(TAG, "TargetApp is not SystemApp");
            throw new IllegalArgumentException("TargetApp is not SystemApp");
        }
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(uriBuild, ID_PROJECTION, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    throw new IllegalArgumentException("Unable to find or allocate a thread ID.");
                }
                long j10 = cursorQuery.getLong(0);
                cursorQuery.close();
                return j10;
            } catch (Exception unused) {
                throw new IllegalArgumentException("Unable to find or allocate a thread ID.");
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    private static boolean isEmailAddress(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(extractAddrSpec(str)).matches();
    }
}
