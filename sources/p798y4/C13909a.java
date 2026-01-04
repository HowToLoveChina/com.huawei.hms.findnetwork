package p798y4;

import android.content.ContentValues;
import com.huawei.android.backup.filelogic.utils.C2111d;
import p762x4.C13694a;

/* renamed from: y4.a */
/* loaded from: classes.dex */
public class C13909a {

    /* renamed from: a */
    public String f62263a;

    /* renamed from: b */
    public String f62264b;

    /* renamed from: c */
    public String f62265c;

    /* renamed from: d */
    public String f62266d;

    /* renamed from: e */
    public String f62267e;

    /* renamed from: f */
    public boolean f62268f;

    /* renamed from: a */
    public ContentValues m83329a() {
        ContentValues contentValues = new ContentValues();
        String strM83331c = m83331c();
        if (strM83331c == null) {
            strM83331c = "";
        }
        contentValues.put("file_path", strM83331c.replace(' ', (char) 127));
        contentValues.put("permission", m83332d());
        contentValues.put("gid", (Integer) 0);
        contentValues.put("uid", (Integer) 0);
        contentValues.putNull("file_link");
        return contentValues;
    }

    /* renamed from: b */
    public String m83330b() {
        return this.f62263a + ";" + this.f62264b + ";" + this.f62267e + ";" + this.f62265c + ";" + this.f62266d;
    }

    /* renamed from: c */
    public String m83331c() {
        return this.f62263a;
    }

    /* renamed from: d */
    public String m83332d() {
        return this.f62264b;
    }

    /* renamed from: e */
    public boolean m83333e() {
        return this.f62268f;
    }

    /* renamed from: f */
    public boolean m83334f() {
        return C13694a.m82332j(m83331c());
    }

    /* renamed from: g */
    public void m83335g(boolean z10) {
        this.f62268f = z10;
    }

    /* renamed from: h */
    public void m83336h(String str) {
        this.f62267e = str;
    }

    /* renamed from: i */
    public void m83337i(String str) {
        this.f62263a = str;
    }

    /* renamed from: j */
    public void m83338j(String str) {
        this.f62265c = str;
    }

    /* renamed from: k */
    public void m83339k(ContentValues contentValues) {
        if (contentValues == null) {
            C2111d.m12653i("AppDataFileAttr", "setInfo appFileInfo is null");
            return;
        }
        String asString = contentValues.getAsString("file_path");
        if (this.f62263a == null) {
            this.f62263a = "";
        }
        String strReplace = asString.replace((char) 127, ' ');
        m83338j("1");
        m83341m("1");
        m83337i(strReplace);
        m83342n(contentValues.getAsString("permission"));
        if (contentValues.getAsInteger("file_index").intValue() != -1) {
            m83336h("0");
        } else {
            m83335g(true);
            m83336h("1");
        }
    }

    /* renamed from: l */
    public void m83340l(String[] strArr) {
        m83337i(strArr[0]);
        m83342n(strArr[1]);
        if ("1".equals(strArr[2])) {
            m83335g(true);
        } else {
            m83335g(false);
        }
        m83338j(strArr[3]);
        m83341m(strArr[4]);
    }

    /* renamed from: m */
    public void m83341m(String str) {
        this.f62266d = str;
    }

    /* renamed from: n */
    public void m83342n(String str) {
        this.f62264b = str;
    }
}
