package p583qm;

import java.util.ArrayList;
import java.util.List;

/* renamed from: qm.b */
/* loaded from: classes6.dex */
public class C12374b {

    /* renamed from: a */
    public static final Object f57181a = new Object();

    /* renamed from: b */
    public static final List<String> f57182b = new a();

    /* renamed from: qm.b$a */
    public class a extends ArrayList<String> {
        public a() {
            add("Backup.device.file.delete");
        }
    }

    /* renamed from: a */
    public static List<String> m74430a() {
        List<String> list;
        synchronized (f57181a) {
            list = f57182b;
        }
        return list;
    }
}
