package p785xr;

import android.text.TextUtils;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import java.util.HashMap;
import java.util.UUID;

/* renamed from: xr.b */
/* loaded from: classes8.dex */
public class C13852b {

    /* renamed from: a */
    public final HashMap<String, String> f62134a;

    public C13852b() {
        this(UUID.randomUUID().toString());
    }

    /* renamed from: a */
    public C13852b m83148a(String str, String str2) {
        if (str != null && str2 != null) {
            this.f62134a.put(str, str2);
        }
        return this;
    }

    /* renamed from: b */
    public C13852b m83149b(HashMap<String, String> map) {
        if (map != null) {
            this.f62134a.putAll(map);
        }
        return this;
    }

    /* renamed from: c */
    public String m83150c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f62134a.get(str);
    }

    /* renamed from: d */
    public HashMap<String, String> m83151d() {
        return this.f62134a;
    }

    /* renamed from: e */
    public String m83152e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f62134a.remove(str);
    }

    /* renamed from: f */
    public C13852b m83153f(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f62134a.put("X-CP-Info", str);
        }
        return this;
    }

    public String toString() {
        return "HeadBuilder{headers=" + this.f62134a + '}';
    }

    public C13852b(String str) {
        HashMap<String, String> map = new HashMap<>(16);
        this.f62134a = map;
        map.put("X-Request-ID", TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str);
        map.put("Content-Type", InterfaceC5483d.f25084j);
    }
}
