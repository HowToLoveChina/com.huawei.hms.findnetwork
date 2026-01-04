package p700v5;

import android.net.Uri;
import java.util.HashMap;
import p699v4.C13347p;

/* renamed from: v5.c */
/* loaded from: classes.dex */
public class C13353c {

    /* renamed from: a */
    public static final Uri f60182a = C13347p.m80079b("content://com.google.provider.NotePad/notes");

    /* renamed from: b */
    public static final Uri f60183b = C13347p.m80079b("content://com.example.notepad.provider.NotePad/notes");

    /* renamed from: c */
    public static final HashMap<String, Integer> f60184c;

    static {
        HashMap<String, Integer> map = new HashMap<>();
        f60184c = map;
        map.put("title", 1);
        map.put("note", 1);
        map.put("created", 3);
        map.put("modified", 3);
        map.put("tmo_sync_dirty", 2);
        map.put("tmo_sync_mark", 2);
    }

    /* renamed from: a */
    public static boolean m80101a(String str) {
        return f60184c.containsKey(str);
    }

    /* renamed from: b */
    public static HashMap<String, Integer> m80102b() {
        return f60184c;
    }
}
