package dk;

import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: dk.b */
/* loaded from: classes6.dex */
public class C9161b {

    /* renamed from: a */
    public static final Map<String, String> f45954a = Collections.unmodifiableMap(new a());

    /* renamed from: b */
    public static final Map<String, String> f45955b = Collections.unmodifiableMap(new b());

    /* renamed from: dk.b$a */
    public class a extends HashMap<String, String> {
        public a() {
            put("/Sync/note", "sync");
            put("/Sync/contact", HNConstants.DataType.CONTACT);
            put("/CloudDrive", "clouddrive");
            put("/recording", "record");
            put("/notepad.db", "notepad");
            put("/notepadRes.zip", "notepad");
            put("/phonemanager.db", "phonemanager");
        }
    }

    /* renamed from: dk.b$b */
    public class b extends HashMap<String, String> {
        public b() {
            put("/NoteSync", "sync");
            put("/ContactSync", HNConstants.DataType.CONTACT);
            put("/RecordBackup", "record");
            put("/NoteSync", "notepad");
            put("/NoteBackup", "notepad");
            put("/BlockedBackup", "phonemanager");
        }
    }
}
