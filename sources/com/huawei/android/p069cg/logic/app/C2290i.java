package com.huawei.android.p069cg.logic.app;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import p015ak.C0209d;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1125f;

/* renamed from: com.huawei.android.cg.logic.app.i */
/* loaded from: classes2.dex */
public final class C2290i {
    /* renamed from: e */
    public static boolean m14440e(Context context) {
        return C1122c.m6742V(context, "com.fyusion.sdk") != null;
    }

    /* renamed from: a */
    public final void m14441a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e10) {
                C1120a.m6676e("Photo3DApp", "closeCursor error, error message:" + e10.getMessage());
            }
        }
    }

    /* renamed from: b */
    public void m14442b(ParcelFileDescriptor parcelFileDescriptor) {
        C1120a.m6675d("Photo3DApp", "closeParcelFileDescriptor start!");
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e10) {
                C1120a.m6676e("Photo3DApp", "close ParcelFileDescriptor error,error message:" + e10.getMessage());
            }
        }
    }

    /* renamed from: c */
    public ParcelFileDescriptor m14443c(Context context, String str, boolean z10) throws Throwable {
        String strM14444d = m14444d(context, str);
        if (TextUtils.isEmpty(strM14444d)) {
            return null;
        }
        C1120a.m6677i("Photo3DApp", "getFyuseDataStream URI:" + C1122c.m6818p0(strM14444d));
        try {
            Uri uri = Uri.parse(strM14444d);
            String str2 = z10 ? "w" : "r";
            if (C0209d.m1227Y1(context, uri)) {
                return context.getContentResolver().openFileDescriptor(uri, str2);
            }
            return null;
        } catch (FileNotFoundException unused) {
            C1120a.m6676e("Photo3DApp", "getFileDataStream error");
            return null;
        }
    }

    /* renamed from: d */
    public final String m14444d(Context context, String str) throws Throwable {
        if (!m14440e(context)) {
            return null;
        }
        String strM6882c = C1125f.m6882c(str);
        if (TextUtils.isEmpty(strM6882c)) {
            return null;
        }
        return "content://com.fyusion.fyuse.contentprovider/" + strM6882c;
    }

    /* renamed from: f */
    public void m14445f(Context context, String str) {
        Uri uri;
        String strM14444d = m14444d(context, str);
        if (TextUtils.isEmpty(strM14444d)) {
            return;
        }
        C1120a.m6677i("Photo3DApp", "queryFyuseData URI:" + C1122c.m6818p0(strM14444d));
        Cursor cursorQuery = null;
        try {
            try {
                uri = Uri.parse(strM14444d);
            } catch (Exception e10) {
                C1120a.m6676e("Photo3DApp", "queryFyuseData error,message:" + e10.getMessage());
            }
            if (uri == null) {
                return;
            }
            if (C0209d.m1227Y1(context, uri)) {
                cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            }
        } finally {
            m14441a(cursorQuery);
        }
    }

    /* renamed from: g */
    public boolean m14446g(Context context, String str) throws Throwable {
        Uri uri;
        String strM6882c = C1125f.m6882c(str);
        if (TextUtils.isEmpty(strM6882c)) {
            return false;
        }
        String str2 = "content://com.fyusion.fyuse.contentprovider/" + strM6882c;
        C1120a.m6677i("Photo3DApp", "queryFyuseData URI:" + C1122c.m6818p0(str2));
        try {
            try {
                uri = Uri.parse(str2);
            } catch (Exception e10) {
                C1120a.m6676e("Photo3DApp", "queryFyuseData error,message:" + e10.getMessage());
            }
            if (uri == null) {
                m14441a(null);
                return false;
            }
            cursorQuery = C0209d.m1227Y1(context, uri) ? context.getContentResolver().query(uri, null, strM6882c, null, null) : null;
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                C1120a.m6677i("Photo3DApp", "queryFyuseData URI result:true!");
                m14441a(cursorQuery);
                return true;
            }
            m14441a(cursorQuery);
            C1120a.m6677i("Photo3DApp", "queryFyuseData URI result:false!");
            return false;
        } catch (Throwable th2) {
            m14441a(cursorQuery);
            throw th2;
        }
    }
}
