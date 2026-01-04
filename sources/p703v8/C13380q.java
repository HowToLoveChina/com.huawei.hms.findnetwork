package p703v8;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import p514o9.C11839m;

/* renamed from: v8.q */
/* loaded from: classes2.dex */
public class C13380q {

    /* renamed from: a */
    public String f60299a = null;

    /* renamed from: b */
    public Drawable f60300b = null;

    /* renamed from: c */
    public String f60301c = null;

    /* renamed from: d */
    public String f60302d = null;

    /* renamed from: e */
    public int f60303e = 0;

    /* renamed from: f */
    public String f60304f = null;

    /* renamed from: g */
    public long f60305g = 0;

    /* renamed from: h */
    public Intent f60306h = null;

    /* renamed from: i */
    public Object f60307i = null;

    /* renamed from: j */
    public boolean f60308j = false;

    /* renamed from: k */
    public boolean f60309k = false;

    /* renamed from: l */
    public boolean f60310l = false;

    /* renamed from: m */
    public boolean f60311m = true;

    /* renamed from: n */
    public boolean f60312n = false;

    /* renamed from: o */
    public boolean f60313o = false;

    /* renamed from: p */
    public String f60314p;

    /* renamed from: q */
    public String f60315q;

    /* renamed from: r */
    public String f60316r;

    /* renamed from: s */
    public String f60317s;

    /* renamed from: t */
    public String f60318t;

    /* renamed from: u */
    public int f60319u;

    /* renamed from: v */
    public boolean f60320v;

    /* renamed from: w */
    public int f60321w;

    /* renamed from: x */
    public String f60322x;

    /* renamed from: A */
    public void m80318A(boolean z10) {
        this.f60320v = z10;
    }

    /* renamed from: B */
    public void m80319B(int i10) {
        this.f60321w = i10;
    }

    /* renamed from: C */
    public void m80320C(int i10) {
        this.f60319u = i10;
    }

    /* renamed from: D */
    public void m80321D(boolean z10) {
        this.f60311m = z10;
    }

    /* renamed from: E */
    public void m80322E(boolean z10) {
        this.f60309k = z10;
    }

    /* renamed from: F */
    public void m80323F(String str) {
        this.f60304f = str;
    }

    /* renamed from: G */
    public void m80324G(long j10) {
        this.f60305g = j10;
    }

    /* renamed from: H */
    public void m80325H(String str) {
        this.f60318t = str;
    }

    /* renamed from: I */
    public void m80326I(String str) {
        this.f60301c = str;
    }

    /* renamed from: J */
    public void m80327J(String str) {
        this.f60317s = str;
    }

    /* renamed from: K */
    public void m80328K(String str) {
        this.f60316r = str;
    }

    /* renamed from: L */
    public void m80329L(boolean z10) {
        this.f60308j = z10;
    }

    /* renamed from: a */
    public int m80330a() {
        return this.f60303e;
    }

    /* renamed from: b */
    public Drawable m80331b() {
        return this.f60300b;
    }

    /* renamed from: c */
    public Intent m80332c() {
        return this.f60306h;
    }

    /* renamed from: d */
    public String m80333d() {
        return this.f60299a;
    }

    /* renamed from: e */
    public String m80334e() {
        return this.f60322x;
    }

    /* renamed from: f */
    public String m80335f() {
        return this.f60304f;
    }

    /* renamed from: g */
    public long m80336g() {
        return this.f60305g;
    }

    /* renamed from: h */
    public String m80337h() {
        return this.f60301c;
    }

    /* renamed from: i */
    public boolean m80338i() {
        return this.f60310l;
    }

    /* renamed from: j */
    public boolean m80339j() {
        return this.f60313o;
    }

    /* renamed from: k */
    public boolean m80340k() {
        return this.f60312n;
    }

    /* renamed from: l */
    public boolean m80341l() {
        return this.f60311m;
    }

    /* renamed from: m */
    public boolean m80342m() {
        return this.f60309k;
    }

    /* renamed from: n */
    public boolean m80343n() {
        return this.f60308j;
    }

    /* renamed from: o */
    public void m80344o(int i10) {
        this.f60303e = i10;
    }

    /* renamed from: p */
    public void m80345p(boolean z10) {
        this.f60310l = z10;
    }

    /* renamed from: q */
    public void m80346q(boolean z10) {
        this.f60313o = z10;
    }

    /* renamed from: r */
    public void m80347r(boolean z10) {
        this.f60312n = z10;
    }

    /* renamed from: s */
    public void m80348s(String str) {
        this.f60314p = str;
    }

    /* renamed from: t */
    public void m80349t(Drawable drawable) {
        this.f60300b = drawable;
    }

    /* renamed from: u */
    public void m80350u(Intent intent) {
        this.f60306h = intent;
    }

    /* renamed from: v */
    public void m80351v() {
        Intent intent = this.f60306h;
        if (intent == null) {
            C11839m.m70688i("StorageManageItem", "setIntentParam intent null");
            return;
        }
        intent.putExtra("detail_size", this.f60304f);
        this.f60306h.putExtra("detail_size_long", this.f60305g);
        this.f60306h.putExtra("detail_num", this.f60303e);
        if (m80340k()) {
            this.f60306h.putExtra("moduleName", this.f60299a);
            this.f60306h.putExtra("title_text", this.f60301c);
            this.f60306h.putExtra("icon_path", this.f60314p);
            this.f60306h.putExtra(MapKeyNames.PACKAGE_NAME, this.f60315q);
            this.f60306h.putExtra("data_type_name", this.f60316r);
            this.f60306h.putExtra("data_type_name_id", this.f60317s);
            this.f60306h.putExtra("data_type_num", this.f60318t);
            this.f60306h.putExtra("data_recycle_num", this.f60319u);
            this.f60306h.putExtra("sync_config_record", this.f60320v);
            this.f60306h.putExtra("sync_config_record_index", this.f60321w);
            this.f60306h.putExtra("sync_config_text_name_id", this.f60322x);
        }
        if (m80339j()) {
            this.f60306h.putExtra("moduleName", this.f60299a);
            this.f60306h.putExtra("title_text", this.f60301c);
            this.f60306h.putExtra("icon_path", this.f60314p);
            this.f60306h.putExtra(MapKeyNames.PACKAGE_NAME, this.f60315q);
            this.f60306h.putExtra("sync_config_record", this.f60320v);
            this.f60306h.putExtra("sync_config_record_index", this.f60321w);
            this.f60306h.putExtra("sync_config_text_name_id", this.f60322x);
        }
    }

    /* renamed from: w */
    public void m80352w(String str) {
        this.f60299a = str;
    }

    /* renamed from: x */
    public void m80353x(String str) {
        this.f60322x = str;
    }

    /* renamed from: y */
    public void m80354y(String str) {
        this.f60302d = str;
    }

    /* renamed from: z */
    public void m80355z(String str) {
        this.f60315q = str;
    }
}
