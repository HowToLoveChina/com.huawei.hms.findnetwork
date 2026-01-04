package com.huawei.hianalytics.core.transport;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.transport.net.Response;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes5.dex */
public class Utils {
    public static final String TAG = "Utils";

    public static Response handlerException(Exception exc) {
        String str;
        if (exc instanceof SecurityException) {
            HiLog.m28808e(TAG, HiLog.ErrorCode.NE003);
            return new Response(Response.Code.INTERNET_PERMISSION_ERROR, "");
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            HiLog.m28808e(TAG, HiLog.ErrorCode.NE002);
            return new Response(Response.Code.SSL_VALIDATION_ERROR, "");
        }
        if (exc instanceof SSLHandshakeException) {
            HiLog.m28808e(TAG, HiLog.ErrorCode.NE002);
            return new Response(Response.Code.SSL_VALIDATION_ERROR, "");
        }
        if (exc instanceof ConnectException) {
            HiLog.m28808e(TAG, HiLog.ErrorCode.NE005);
            return new Response(Response.Code.CONNECTION_ERROR, "");
        }
        if (exc instanceof UnknownHostException) {
            HiLog.m28808e(TAG, HiLog.ErrorCode.NE006);
            return new Response(Response.Code.HOST_ERROR, "");
        }
        if (exc instanceof IOException) {
            str = HiLog.ErrorCode.NE004;
        } else {
            str = "other Exception:" + exc.getMessage();
        }
        HiLog.m28808e(TAG, str);
        return new Response(Response.Code.TIMEOUT_OR_OTHER_ERROR, "");
    }

    public static long parseStringToLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }
}
