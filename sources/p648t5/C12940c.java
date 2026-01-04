package p648t5;

import android.content.ContentValues;
import android.content.Context;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import p229di.C9142g;
import p699v4.C13347p;

/* renamed from: t5.c */
/* loaded from: classes.dex */
public class C12940c {

    /* renamed from: a */
    public static final String f58993a;

    /* renamed from: b */
    public static final String f58994b;

    static {
        f58993a = C9142g.m57463b() ? "content://com.hihonor.provider.NotePad.backup/note_backup" : "content://com.huawei.provider.NotePad.backup/note_backup";
        f58994b = C9142g.m57463b() ? "content://com.hihonor.provider.NotePad.backup/note_restore" : "content://com.huawei.provider.NotePad.backup/note_restore";
    }

    /* renamed from: a */
    public static InputStream m77723a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getContentResolver().openInputStream(C13347p.m80079b(f58993a));
        } catch (FileNotFoundException unused) {
            C2111d.m12648d("MemoProtocol", "openAttachmentInputStream error FileNotFoundException.");
            return null;
        } catch (Exception unused2) {
            C2111d.m12648d("MemoProtocol", "openAttachmentInputStream error.");
            return null;
        }
    }

    /* renamed from: b */
    public static OutputStream m77724b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getContentResolver().openOutputStream(C13347p.m80079b(f58994b));
        } catch (FileNotFoundException unused) {
            C2111d.m12648d("MemoProtocol", "openAttachmentOutputStream error FileNotFoundException.");
            return null;
        } catch (Exception unused2) {
            C2111d.m12648d("MemoProtocol", "openAttachmentOutputStream error.");
            return null;
        }
    }

    /* renamed from: c */
    public static void m77725c(Context context) {
        if (context == null) {
            return;
        }
        try {
            context.getContentResolver().update(C13347p.m80079b(f58994b), new ContentValues(), null, null);
        } catch (IllegalArgumentException unused) {
            C2111d.m12648d("MemoProtocol", "updateAttachment IllegalArgumentException error.");
        } catch (Exception unused2) {
            C2111d.m12648d("MemoProtocol", "updateAttachment error.");
        }
    }
}
