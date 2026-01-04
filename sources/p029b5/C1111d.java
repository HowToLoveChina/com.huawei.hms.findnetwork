package p029b5;

import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;
import java.util.Map;

/* renamed from: b5.d */
/* loaded from: classes.dex */
public class C1111d extends AbstractC1108a<a> {

    /* renamed from: c */
    public String f5291c;

    /* renamed from: d */
    public a f5292d;

    /* renamed from: e */
    public b f5293e;

    /* renamed from: b5.d$a */
    public static class a {

        /* renamed from: a */
        public List<b> f5294a;
    }

    /* renamed from: b5.d$b */
    public static class b {

        /* renamed from: a */
        public String f5295a;

        /* renamed from: b */
        public boolean f5296b;
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: b */
    public void mo6626b(String str) {
        if ("is-display".equals(this.f5291c) && FaqConstants.DISABLE_HA_REPORT.equals(str)) {
            this.f5293e.f5296b = true;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: c */
    public void mo6627c(String str) {
        this.f5291c = str;
        if ("package".equals(str)) {
            b bVar = new b();
            this.f5293e = bVar;
            bVar.f5296b = false;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: d */
    public void mo6628d(String str) {
        if ("package".equals(str) && !TextUtils.isEmpty(this.f5293e.f5295a)) {
            this.f5292d.f5294a.add(this.f5293e);
            this.f5293e = null;
            return;
        }
        String str2 = this.f5280b;
        if (str2 == null || !str2.equals(str)) {
            C2111d.m12646b("BlockListParserImpl", "unKnow Element");
        } else {
            this.f5279a = false;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: g */
    public void mo6630g(Map<String, String> map) {
        if (!"package".equals(this.f5291c) || map == null) {
            return;
        }
        this.f5293e.f5295a = map.get("name");
    }

    @Override // p029b5.AbstractC1108a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void mo6618j(a aVar, String str) {
        this.f5292d = aVar;
        this.f5279a = true;
        this.f5280b = str;
    }
}
