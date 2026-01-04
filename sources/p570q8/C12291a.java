package p570q8;

import android.net.Uri;
import java.util.HashMap;

/* renamed from: q8.a */
/* loaded from: classes2.dex */
public class C12291a {

    /* renamed from: a */
    public static final Uri f56937a = Uri.parse("content://com.google.provider.NotePad/notes");

    /* renamed from: b */
    public static final Uri f56938b = Uri.parse("content://com.example.notepad.provider.NotePad/notes");

    /* renamed from: c */
    public static final Uri f56939c = Uri.parse("content://com.huawei.provider.NotePad.backup/note_backup");

    /* renamed from: d */
    public static final Uri f56940d = Uri.parse("content://com.huawei.provider.NotePad.backup/note_restore");

    /* renamed from: e */
    public static final HashMap<String, Integer> f56941e = new a();

    /* renamed from: q8.a$a */
    public class a extends HashMap<String, Integer> {
        public a() {
            put("title", 1);
            put("created", 3);
            put("modified", 3);
            put("tmo_sync_dirty", 2);
            put("tmo_sync_mark", 2);
            put("content", 1);
            put("favorite", 3);
            put("has_attachment", 3);
        }
    }

    /* renamed from: a */
    public static HashMap<String, Integer> m73845a() {
        return f56941e;
    }
}
