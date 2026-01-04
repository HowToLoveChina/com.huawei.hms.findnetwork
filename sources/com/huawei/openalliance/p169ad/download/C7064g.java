package com.huawei.openalliance.p169ad.download;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.location.base.activity.constant.ActivityRecognitionConstants;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.beans.inner.HttpConnection;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import java.io.File;

/* renamed from: com.huawei.openalliance.ad.download.g */
/* loaded from: classes2.dex */
public class C7064g {

    /* renamed from: com.huawei.openalliance.ad.download.g$a */
    public static class a extends Exception {

        /* renamed from: a */
        private String f32531a;

        public a(String str) {
            super("Url is redirected!");
            this.f32531a = str;
        }

        /* renamed from: a */
        public String m42603a() {
            return this.f32531a;
        }
    }

    /* renamed from: a */
    public static long m42597a(AbstractC7060c abstractC7060c) {
        int iMo42578b = abstractC7060c.mo42578b();
        AbstractC7185ho.m43818a("DownloadUtil", "responseCode:%d", Integer.valueOf(iMo42578b));
        if (206 == iMo42578b) {
            return m42598a(abstractC7060c.mo42577a("Content-Range"));
        }
        if (200 == iMo42578b) {
            return abstractC7060c.mo42579c();
        }
        if (302 != iMo42578b) {
            return 0L;
        }
        throw new a(abstractC7060c.mo42577a(ActivityRecognitionConstants.LOCATION_MODULE));
    }

    /* renamed from: b */
    public static HttpConnection m42602b(AbstractC7060c abstractC7060c) {
        if (abstractC7060c == null) {
            return null;
        }
        HttpConnection httpConnectionMo42580d = abstractC7060c.mo42580d();
        httpConnectionMo42580d.m39404a("dl-from", abstractC7060c.mo42577a("dl-from"));
        return httpConnectionMo42580d;
    }

    /* renamed from: a */
    public static long m42598a(String str) throws NumberFormatException {
        String str2;
        long j10 = -1;
        if (!AbstractC7806cz.m48165b(str) && str.startsWith("bytes")) {
            int iIndexOf = str.indexOf(47);
            if (-1 != iIndexOf) {
                try {
                    j10 = Long.parseLong(str.substring(iIndexOf + 1));
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("DownloadUtil", "get new filelength by Content-Range:%d", Long.valueOf(j10));
                    }
                } catch (NumberFormatException unused) {
                    str2 = "getEntityLegth NumberFormatException";
                }
            } else {
                str2 = "getEntityLegth failed Content-Range";
            }
            AbstractC7185ho.m43826d("DownloadUtil", str2);
        }
        return j10;
    }

    /* renamed from: a */
    private static void m42599a(Context context, String str) throws Throwable {
        if (C7022dk.m41954i(str)) {
            C7019dh.m41937a(context, Constants.NORMAL_CACHE).m41975h(str);
        } else {
            AbstractC7731ae.m47461c(new File(str));
        }
    }

    /* renamed from: a */
    public static boolean m42600a(Context context, DownloadTask downloadTask) throws Throwable {
        String str;
        String str2;
        AbstractC7185ho.m43820b("DownloadUtil", "isDownloadedFileValid " + AbstractC7819dl.m48375a(downloadTask.mo42082n()));
        String strM42068d = downloadTask.m42068d();
        String strM41968c = C7022dk.m41954i(strM42068d) ? C7019dh.m41937a(context, Constants.NORMAL_CACHE).m41968c(strM42068d) : strM42068d;
        if (TextUtils.isEmpty(strM41968c)) {
            str = "isDownloadedFileValid - real path is empty";
        } else {
            if (m42601a(downloadTask, strM41968c)) {
                m42599a(context, strM42068d);
                return true;
            }
            str = "isDownloadedFileValid - real file is invalid";
        }
        AbstractC7185ho.m43820b("DownloadUtil", str);
        AbstractC7185ho.m43820b("DownloadUtil", "check tmp file");
        String strM42071e = downloadTask.m42071e();
        if (!TextUtils.isEmpty(strM42071e)) {
            File file = new File(strM42071e);
            if (!m42601a(downloadTask, strM42071e)) {
                str2 = (file.length() >= downloadTask.m42073f() && downloadTask.m42073f() > 0) ? "isDownloadedFileValid - tmp file invalid" : "isDownloadedFileValid - tmp file rename failed";
            } else if (AbstractC7731ae.m47447a(context, file, strM42068d, downloadTask.m42043A(), Constants.NORMAL_CACHE)) {
                return true;
            }
            AbstractC7185ho.m43820b("DownloadUtil", str2);
            AbstractC7731ae.m47440a(context, strM42071e);
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m42601a(DownloadTask downloadTask, String str) {
        String str2;
        File file = new File(str);
        if (!AbstractC7731ae.m47464d(file)) {
            str2 = "isFileValid - dst file not exist";
        } else {
            if (!downloadTask.m42094z() || AbstractC7731ae.m47452a(downloadTask.m42063c(), file)) {
                return true;
            }
            str2 = "isFileValid - dst file not valid";
        }
        AbstractC7185ho.m43823c("DownloadUtil", str2);
        return false;
    }
}
