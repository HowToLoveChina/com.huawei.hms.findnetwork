package bs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: bs.b */
/* loaded from: classes8.dex */
public class C1275b {

    /* renamed from: a */
    public static ThreadLocal<Map<String, SimpleDateFormat>> f5719a = new a();

    /* renamed from: bs.b$a */
    public class a extends ThreadLocal<Map<String, SimpleDateFormat>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<String, SimpleDateFormat> initialValue() {
            return new HashMap(0);
        }
    }

    /* renamed from: a */
    public static String m7550a(Date date, String str) {
        return m7551b(str).format(date);
    }

    /* renamed from: b */
    public static SimpleDateFormat m7551b(String str) {
        Map<String, SimpleDateFormat> map = f5719a.get();
        SimpleDateFormat simpleDateFormat = map.get(str);
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str, Locale.getDefault());
        map.put(str, simpleDateFormat2);
        return simpleDateFormat2;
    }
}
