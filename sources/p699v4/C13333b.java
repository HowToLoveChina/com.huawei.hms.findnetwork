package p699v4;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.huawei.android.backup.filelogic.utils.C2111d;

/* renamed from: v4.b */
/* loaded from: classes.dex */
public class C13333b {
    /* renamed from: a */
    public static boolean m79953a(ContentProviderClient contentProviderClient, Uri uri, ContentValues contentValues) {
        if (contentProviderClient == null) {
            C2111d.m12648d("ContentProviderHelper", "providerClient is null");
            return false;
        }
        if (uri == null) {
            C2111d.m12648d("ContentProviderHelper", "url is null");
            return false;
        }
        if (contentValues == null) {
            C2111d.m12648d("ContentProviderHelper", "values is null");
            return false;
        }
        try {
            return contentProviderClient.insert(uri, contentValues) != null;
        } catch (IllegalStateException unused) {
            C2111d.m12648d("ContentProviderHelper", "ContentProviderHelper insert IllegalStateException");
            return false;
        } catch (Exception unused2) {
            C2111d.m12648d("ContentProviderHelper", "ContentProviderHelper insert Exception");
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m79954b(Context context, Uri uri, ContentValues contentValues) {
        if (context == null || context.getContentResolver() == null) {
            C2111d.m12648d("ContentProviderHelper", "context or context.getContentResolver() is null");
            return false;
        }
        if (uri == null) {
            C2111d.m12648d("ContentProviderHelper", "url is null");
            return false;
        }
        if (contentValues == null) {
            C2111d.m12648d("ContentProviderHelper", "values is null");
            return false;
        }
        try {
            return context.getContentResolver().insert(uri, contentValues) != null;
        } catch (IllegalStateException unused) {
            C2111d.m12648d("ContentProviderHelper", "ContentProviderHelper insert IllegalStateException");
            return false;
        } catch (Exception unused2) {
            C2111d.m12648d("ContentProviderHelper", "ContentProviderHelper insert Exception");
            return false;
        }
    }

    /* renamed from: c */
    public static Uri m79955c(Context context, Uri uri, ContentValues contentValues) {
        if (context == null || context.getContentResolver() == null) {
            C2111d.m12648d("ContentProviderHelper", "context or context.getContentResolver() is null");
            return null;
        }
        if (uri == null) {
            C2111d.m12648d("ContentProviderHelper", "url is null");
            return null;
        }
        if (contentValues == null) {
            C2111d.m12648d("ContentProviderHelper", "values is null");
            return null;
        }
        try {
            return context.getContentResolver().insert(uri, contentValues);
        } catch (IllegalStateException unused) {
            C2111d.m12648d("ContentProviderHelper", "ContentProviderHelper insertReturnUri insert IllegalStateException");
            return null;
        } catch (Exception unused2) {
            C2111d.m12648d("ContentProviderHelper", "ContentProviderHelper insertReturnUri insert Exception");
            return null;
        }
    }

    /* renamed from: d */
    public static boolean m79956d(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (context == null || context.getContentResolver() == null) {
            C2111d.m12648d("ContentProviderHelper", "context or context.getContentResolver() is null");
            return false;
        }
        if (uri == null) {
            C2111d.m12648d("ContentProviderHelper", "url is null");
            return false;
        }
        if (contentValues == null) {
            C2111d.m12648d("ContentProviderHelper", "values is null");
            return false;
        }
        try {
            return context.getContentResolver().update(uri, contentValues, str, strArr) >= 1;
        } catch (IllegalStateException unused) {
            C2111d.m12648d("ContentProviderHelper", "ContentProviderHelper insert IllegalStateException");
            return false;
        } catch (Exception unused2) {
            C2111d.m12648d("ContentProviderHelper", "ContentProviderHelper insert Exception");
            return false;
        }
    }
}
