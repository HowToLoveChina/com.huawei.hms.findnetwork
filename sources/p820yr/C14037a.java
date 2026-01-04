package p820yr;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: yr.a */
/* loaded from: classes8.dex */
public class C14037a {

    /* renamed from: a */
    public a f62807a;

    /* renamed from: yr.a$a */
    public static final class a {

        /* renamed from: a */
        public Map<String, String> f62808a = new HashMap(4);

        /* renamed from: a */
        public C14037a m84198a() {
            return new C14037a(this);
        }

        /* renamed from: b */
        public a m84199b(String str, String str2) {
            this.f62808a.put(str, str2);
            return this;
        }
    }

    public C14037a(a aVar) {
        this.f62807a = aVar;
    }

    /* renamed from: a */
    public String[] m84197a() {
        String[] strArr = new String[2];
        StringBuffer stringBuffer = new StringBuffer("");
        StringBuffer stringBuffer2 = new StringBuffer("");
        for (Map.Entry<String, String> entry : this.f62807a.f62808a.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(entry.getValue());
            stringBuffer.append("&");
            stringBuffer2.append(entry.getKey());
            stringBuffer2.append(";");
        }
        strArr[0] = TextUtils.isEmpty(stringBuffer) ? "" : stringBuffer.substring(0, stringBuffer.length() - 1);
        strArr[1] = TextUtils.isEmpty(stringBuffer2) ? "" : stringBuffer2.substring(0, stringBuffer2.length() - 1);
        return strArr;
    }
}
