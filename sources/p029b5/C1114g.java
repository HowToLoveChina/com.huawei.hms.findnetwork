package p029b5;

import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;
import java.util.Map;

/* renamed from: b5.g */
/* loaded from: classes.dex */
public class C1114g extends AbstractC1108a<a> {

    /* renamed from: c */
    public String f5304c;

    /* renamed from: d */
    public a f5305d;

    /* renamed from: e */
    public b f5306e;

    /* renamed from: b5.g$a */
    public static class a {

        /* renamed from: a */
        public List<b> f5307a;
    }

    /* renamed from: b5.g$b */
    public static class b {

        /* renamed from: a */
        public String f5308a;

        /* renamed from: b */
        public boolean f5309b;
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: b */
    public void mo6626b(String str) {
        if ("is-display".equals(this.f5304c) && FaqConstants.DISABLE_HA_REPORT.equals(str)) {
            this.f5306e.f5309b = true;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: c */
    public void mo6627c(String str) {
        this.f5304c = str;
        if ("package".equals(str)) {
            b bVar = new b();
            this.f5306e = bVar;
            bVar.f5309b = false;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: d */
    public void mo6628d(String str) {
        if ("package".equals(str) && !TextUtils.isEmpty(this.f5306e.f5308a)) {
            this.f5305d.f5307a.add(this.f5306e);
            this.f5306e = null;
        } else if (this.f5280b.equals(str)) {
            this.f5279a = false;
        } else {
            C2111d.m12646b("GmsAppListParserImpl", "unKnow Element");
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: g */
    public void mo6630g(Map<String, String> map) {
        if (!"package".equals(this.f5304c) || map == null) {
            return;
        }
        this.f5306e.f5308a = map.get("name");
    }

    @Override // p029b5.AbstractC1108a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void mo6618j(a aVar, String str) {
        this.f5305d = aVar;
        this.f5279a = true;
        this.f5280b = str;
    }
}
