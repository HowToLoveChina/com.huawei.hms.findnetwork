package p669u5;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import p386j6.InterfaceC10714d;
import p699v4.C13347p;

/* renamed from: u5.d */
/* loaded from: classes.dex */
public class C13126d {
    /* renamed from: a */
    public static InputStream m78957a(Context context, String str, InterfaceC10714d<Uri, Uri> interfaceC10714d) {
        Uri uriM80079b;
        if (context == null || context.getContentResolver() == null || TextUtils.isEmpty(str) || (uriM80079b = C13347p.m80079b(str)) == null) {
            return null;
        }
        if (interfaceC10714d != null) {
            uriM80079b = interfaceC10714d.apply(uriM80079b);
        }
        try {
            return context.getContentResolver().openInputStream(uriM80079b);
        } catch (FileNotFoundException unused) {
            C2111d.m12648d("ModuleProtocol", "openAttachmentInputStream fail.");
            return null;
        }
    }

    /* renamed from: b */
    public static OutputStream m78958b(Context context, String str, InterfaceC10714d<Uri, Uri> interfaceC10714d) {
        Uri uriM80079b;
        if (context == null || context.getContentResolver() == null || TextUtils.isEmpty(str) || (uriM80079b = C13347p.m80079b(str)) == null) {
            return null;
        }
        if (interfaceC10714d != null) {
            try {
                uriM80079b = interfaceC10714d.apply(uriM80079b);
            } catch (FileNotFoundException unused) {
                C2111d.m12648d("ModuleProtocol", "openAttachmentOutputStream fail.");
                return null;
            } catch (Exception unused2) {
                C2111d.m12648d("ModuleProtocol", "openAttachmentOutputStream error.");
                return null;
            }
        }
        return context.getContentResolver().openOutputStream(uriM80079b);
    }

    /* renamed from: c */
    public static void m78959c(Context context, String str) {
        if (context == null || context.getContentResolver() == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            context.getContentResolver().update(C13347p.m80079b(str), new ContentValues(), null, null);
        } catch (SQLiteException unused) {
            C2111d.m12648d("ModuleProtocol", "updateAttachment SQLiteException.");
        } catch (IllegalStateException unused2) {
            C2111d.m12648d("ModuleProtocol", "updateAttachment IllegalStateException.");
        } catch (Exception unused3) {
            C2111d.m12648d("ModuleProtocol", "updateAttachment Exception.");
        }
    }
}
