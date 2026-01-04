package p029b5;

import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;
import java.util.Map;

/* renamed from: b5.f */
/* loaded from: classes.dex */
public class C1113f extends AbstractC1108a<a> {

    /* renamed from: c */
    public String f5297c;

    /* renamed from: d */
    public a f5298d;

    /* renamed from: e */
    public b f5299e;

    /* renamed from: b5.f$a */
    public static class a {

        /* renamed from: a */
        public List<b> f5300a;
    }

    /* renamed from: b5.f$b */
    public static class b {

        /* renamed from: a */
        public String f5301a;

        /* renamed from: b */
        public boolean f5302b;

        /* renamed from: c */
        public boolean f5303c;
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: b */
    public void mo6626b(String str) {
        if ("is-support-32-to-64".equals(this.f5297c)) {
            if (FaqConstants.DISABLE_HA_REPORT.equals(str)) {
                this.f5299e.f5302b = true;
            }
        } else if (!"is-support-64-to-32".equals(this.f5297c)) {
            C2111d.m12646b("DependsOnCpuListParserImpl", "unKnow Element");
        } else if (FaqConstants.DISABLE_HA_REPORT.equals(str)) {
            this.f5299e.f5303c = true;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: c */
    public void mo6627c(String str) {
        this.f5297c = str;
        if ("package".equals(str)) {
            this.f5299e = new b();
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: d */
    public void mo6628d(String str) {
        if ("package".equals(str) && !TextUtils.isEmpty(this.f5299e.f5301a)) {
            this.f5298d.f5300a.add(this.f5299e);
            this.f5299e = null;
            return;
        }
        String str2 = this.f5280b;
        if (str2 == null || !str2.equals(str)) {
            C2111d.m12646b("DependsOnCpuListParserImpl", "unKnow Element");
        } else {
            this.f5279a = false;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: g */
    public void mo6630g(Map<String, String> map) {
        if (!"package".equals(this.f5297c) || map == null) {
            return;
        }
        this.f5299e.f5301a = map.get("name");
    }

    @Override // p029b5.AbstractC1108a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void mo6618j(a aVar, String str) {
        this.f5298d = aVar;
        this.f5279a = true;
        this.f5280b = str;
    }
}
