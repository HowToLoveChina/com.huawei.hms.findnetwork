package p029b5;

import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: b5.j */
/* loaded from: classes.dex */
public class C1117j extends AbstractC1109b {

    /* renamed from: b */
    public List<a> f5323b = new ArrayList(100);

    /* renamed from: c */
    public a f5324c;

    /* renamed from: d */
    public int f5325d;

    /* renamed from: e */
    public String f5326e;

    /* renamed from: b5.j$a */
    public static class a {

        /* renamed from: a */
        public String f5327a;

        /* renamed from: b */
        public String f5328b;

        /* renamed from: c */
        public String f5329c;

        /* renamed from: d */
        public String f5330d;

        /* renamed from: f */
        public boolean f5332f;

        /* renamed from: g */
        public boolean f5333g;

        /* renamed from: h */
        public boolean f5334h;

        /* renamed from: i */
        public boolean f5335i;

        /* renamed from: j */
        public boolean f5336j;

        /* renamed from: l */
        public boolean f5338l;

        /* renamed from: m */
        public boolean f5339m;

        /* renamed from: e */
        public boolean f5331e = true;

        /* renamed from: k */
        public boolean f5337k = true;

        /* renamed from: a */
        public String m6647a() {
            return this.f5330d;
        }

        /* renamed from: b */
        public String m6648b() {
            return this.f5327a;
        }

        /* renamed from: c */
        public String m6649c() {
            return this.f5328b;
        }

        /* renamed from: d */
        public String m6650d() {
            return this.f5329c;
        }

        /* renamed from: e */
        public boolean m6651e() {
            return this.f5335i;
        }

        /* renamed from: f */
        public boolean m6652f() {
            return this.f5334h;
        }

        /* renamed from: g */
        public boolean m6653g() {
            return this.f5339m;
        }

        /* renamed from: h */
        public boolean m6654h() {
            return this.f5332f;
        }

        /* renamed from: i */
        public boolean m6655i() {
            return this.f5337k;
        }

        /* renamed from: j */
        public boolean m6656j() {
            return this.f5336j;
        }

        /* renamed from: k */
        public boolean m6657k() {
            return this.f5331e;
        }

        /* renamed from: l */
        public void m6658l(boolean z10) {
            this.f5338l = z10;
        }

        /* renamed from: m */
        public void m6659m(String str) {
            this.f5330d = str;
        }

        /* renamed from: n */
        public void m6660n(boolean z10) {
            this.f5335i = z10;
        }

        /* renamed from: o */
        public void m6661o(boolean z10) {
            this.f5334h = z10;
        }

        /* renamed from: p */
        public void m6662p(String str) {
            this.f5327a = str;
        }

        /* renamed from: q */
        public void m6663q(boolean z10) {
            this.f5339m = z10;
        }

        /* renamed from: r */
        public void m6664r(boolean z10) {
            this.f5332f = z10;
        }

        /* renamed from: s */
        public void m6665s(boolean z10) {
            this.f5333g = z10;
        }

        /* renamed from: t */
        public void m6666t(String str) {
            this.f5328b = str;
        }

        /* renamed from: u */
        public void m6667u(String str) {
            this.f5329c = str;
        }

        /* renamed from: v */
        public void m6668v(boolean z10) {
            this.f5337k = z10;
        }

        /* renamed from: w */
        public void m6669w(boolean z10) {
            this.f5336j = z10;
        }

        /* renamed from: x */
        public void m6670x(boolean z10) {
            this.f5331e = z10;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: a */
    public void mo6625a() {
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: b */
    public void mo6626b(String str) {
        if (TextUtils.isEmpty(str)) {
        }
        if (this.f5324c == null) {
            C2111d.m12648d("UncoupleXmlParserImpl", "text module = null");
            return;
        }
        String str2 = this.f5326e;
        str2.hashCode();
        switch (str2) {
            case "need_file_tar":
                this.f5324c.m6661o(FaqConstants.DISABLE_HA_REPORT.equals(str));
                break;
            case "show_name":
                this.f5324c.m6669w(FaqConstants.DISABLE_HA_REPORT.equals(str));
                break;
            case "package_name":
                this.f5324c.m6666t(str);
                break;
            case "is_new_module":
                this.f5324c.m6670x(FaqConstants.DISABLE_HA_REPORT.equals(str));
                break;
            case "provider":
                this.f5324c.m6667u(str);
                break;
            case "name":
                this.f5324c.m6662p(str);
                break;
            case "backup_class":
                this.f5324c.m6659m(str);
                break;
            case "need_notify_start":
                this.f5324c.m6664r(FaqConstants.DISABLE_HA_REPORT.equals(str));
                break;
            case "need_sdk_low":
                this.f5324c.m6663q(FaqConstants.DISABLE_HA_REPORT.equals(str));
                break;
            case "need_copy_file":
                this.f5324c.m6660n(FaqConstants.DISABLE_HA_REPORT.equals(str));
                break;
            case "need_open_file":
                this.f5324c.m6665s(FaqConstants.DISABLE_HA_REPORT.equals(str));
                break;
            case "always_success":
                this.f5324c.m6658l(FaqConstants.DISABLE_HA_REPORT.equals(str));
                break;
            case "is_show":
                this.f5324c.m6668v(FaqConstants.DISABLE_HA_REPORT.equals(str));
                break;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: c */
    public void mo6627c(String str) {
        this.f5326e = str;
        if (FaqConstants.FAQ_MODULE.equals(str)) {
            this.f5324c = new a();
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: d */
    public void mo6628d(String str) {
        if (FaqConstants.FAQ_MODULE.equals(str)) {
            this.f5323b.add(this.f5324c);
            this.f5324c = null;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: e */
    public void mo6629e() {
        C2111d.m12654j("just start parse uncouple list.", new Object[0]);
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: g */
    public void mo6630g(Map<String, String> map) {
        String str;
        if (!"uncouple_modules".equals(this.f5326e) || map == null || (str = map.get("version")) == null) {
            return;
        }
        try {
            this.f5325d = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            C2111d.m12648d("UncoupleXmlParserImpl", "wrong version code.");
        }
    }

    @Override // p029b5.InterfaceC1118k
    public int getVersion() {
        return this.f5325d;
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: h */
    public Object mo6616h() {
        return this.f5323b;
    }
}
