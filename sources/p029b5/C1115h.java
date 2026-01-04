package p029b5;

import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.util.List;
import java.util.Map;

/* renamed from: b5.h */
/* loaded from: classes.dex */
public class C1115h extends AbstractC1108a<a> {

    /* renamed from: c */
    public String f5310c;

    /* renamed from: d */
    public a f5311d;

    /* renamed from: e */
    public b f5312e;

    /* renamed from: b5.h$a */
    public static class a {

        /* renamed from: a */
        public List<b> f5313a;
    }

    /* renamed from: b5.h$b */
    public static class b {

        /* renamed from: a */
        public String f5314a;
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: b */
    public void mo6626b(String str) {
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: c */
    public void mo6627c(String str) {
        this.f5310c = str;
        if ("package".equals(str)) {
            this.f5312e = new b();
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: d */
    public void mo6628d(String str) {
        if ("package".equals(str) && !TextUtils.isEmpty(this.f5312e.f5314a)) {
            this.f5311d.f5313a.add(this.f5312e);
            this.f5312e = null;
            return;
        }
        String str2 = this.f5280b;
        if (str2 == null || !str2.equals(str)) {
            C2111d.m12646b("GrayListParserImpl", "unKnow Element");
        } else {
            this.f5279a = false;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: g */
    public void mo6630g(Map<String, String> map) {
        if (!"package".equals(this.f5310c) || map == null) {
            return;
        }
        this.f5312e.f5314a = map.get("name");
    }

    @Override // p029b5.AbstractC1108a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void mo6618j(a aVar, String str) {
        this.f5311d = aVar;
        this.f5279a = true;
        this.f5280b = str;
    }
}
