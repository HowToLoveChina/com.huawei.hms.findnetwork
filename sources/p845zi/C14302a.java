package p845zi;

import com.huawei.cloud.pay.model.TransactionItem;
import java.util.ArrayList;
import java.util.List;

/* renamed from: zi.a */
/* loaded from: classes5.dex */
public class C14302a {

    /* renamed from: e */
    public static C14302a f63556e = new C14302a();

    /* renamed from: b */
    public String f63558b;

    /* renamed from: c */
    public long f63559c;

    /* renamed from: a */
    public boolean f63557a = true;

    /* renamed from: d */
    public List<TransactionItem> f63560d = new ArrayList();

    /* renamed from: d */
    public static synchronized C14302a m85176d() {
        return f63556e;
    }

    /* renamed from: a */
    public void m85177a(List<TransactionItem> list) {
        this.f63560d.addAll(list);
    }

    /* renamed from: b */
    public void m85178b() {
        this.f63558b = "";
        this.f63559c = 0L;
        this.f63560d.clear();
        this.f63557a = true;
    }

    /* renamed from: c */
    public void m85179c() {
        this.f63560d.clear();
    }

    /* renamed from: e */
    public List<TransactionItem> m85180e() {
        return this.f63560d;
    }

    /* renamed from: f */
    public String m85181f() {
        return this.f63558b;
    }

    /* renamed from: g */
    public boolean m85182g() {
        return this.f63557a;
    }

    /* renamed from: h */
    public void m85183h(boolean z10) {
        this.f63557a = z10;
    }

    /* renamed from: i */
    public void m85184i(String str) {
        this.f63558b = str;
    }
}
