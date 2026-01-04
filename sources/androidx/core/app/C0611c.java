package androidx.core.app;

import android.app.Person;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;
import com.huawei.android.backup.service.logic.C2126b;

/* renamed from: androidx.core.app.c */
/* loaded from: classes.dex */
public class C0611c {

    /* renamed from: a */
    public CharSequence f3397a;

    /* renamed from: b */
    public IconCompat f3398b;

    /* renamed from: c */
    public String f3399c;

    /* renamed from: d */
    public String f3400d;

    /* renamed from: e */
    public boolean f3401e;

    /* renamed from: f */
    public boolean f3402f;

    /* renamed from: androidx.core.app.c$a */
    public static class a {
        /* renamed from: a */
        public static C0611c m3862a(PersistableBundle persistableBundle) {
            return new c().m3871f(persistableBundle.getString("name")).m3872g(persistableBundle.getString(C2126b.MODULE_INFO_URI)).m3870e(persistableBundle.getString("key")).m3867b(persistableBundle.getBoolean("isBot")).m3869d(persistableBundle.getBoolean("isImportant")).m3866a();
        }

        /* renamed from: b */
        public static PersistableBundle m3863b(C0611c c0611c) {
            PersistableBundle persistableBundle = new PersistableBundle();
            CharSequence charSequence = c0611c.f3397a;
            persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
            persistableBundle.putString(C2126b.MODULE_INFO_URI, c0611c.f3399c);
            persistableBundle.putString("key", c0611c.f3400d);
            persistableBundle.putBoolean("isBot", c0611c.f3401e);
            persistableBundle.putBoolean("isImportant", c0611c.f3402f);
            return persistableBundle;
        }
    }

    /* renamed from: androidx.core.app.c$b */
    public static class b {
        /* renamed from: a */
        public static C0611c m3864a(Person person) {
            return new c().m3871f(person.getName()).m3868c(person.getIcon() != null ? IconCompat.m3900c(person.getIcon()) : null).m3872g(person.getUri()).m3870e(person.getKey()).m3867b(person.isBot()).m3869d(person.isImportant()).m3866a();
        }

        /* renamed from: b */
        public static Person m3865b(C0611c c0611c) {
            return new Person.Builder().setName(c0611c.m3856d()).setIcon(c0611c.m3854b() != null ? c0611c.m3854b().m3920t() : null).setUri(c0611c.m3857e()).setKey(c0611c.m3855c()).setBot(c0611c.m3858f()).setImportant(c0611c.m3859g()).build();
        }
    }

    /* renamed from: androidx.core.app.c$c */
    public static class c {

        /* renamed from: a */
        public CharSequence f3403a;

        /* renamed from: b */
        public IconCompat f3404b;

        /* renamed from: c */
        public String f3405c;

        /* renamed from: d */
        public String f3406d;

        /* renamed from: e */
        public boolean f3407e;

        /* renamed from: f */
        public boolean f3408f;

        /* renamed from: a */
        public C0611c m3866a() {
            return new C0611c(this);
        }

        /* renamed from: b */
        public c m3867b(boolean z10) {
            this.f3407e = z10;
            return this;
        }

        /* renamed from: c */
        public c m3868c(IconCompat iconCompat) {
            this.f3404b = iconCompat;
            return this;
        }

        /* renamed from: d */
        public c m3869d(boolean z10) {
            this.f3408f = z10;
            return this;
        }

        /* renamed from: e */
        public c m3870e(String str) {
            this.f3406d = str;
            return this;
        }

        /* renamed from: f */
        public c m3871f(CharSequence charSequence) {
            this.f3403a = charSequence;
            return this;
        }

        /* renamed from: g */
        public c m3872g(String str) {
            this.f3405c = str;
            return this;
        }
    }

    public C0611c(c cVar) {
        this.f3397a = cVar.f3403a;
        this.f3398b = cVar.f3404b;
        this.f3399c = cVar.f3405c;
        this.f3400d = cVar.f3406d;
        this.f3401e = cVar.f3407e;
        this.f3402f = cVar.f3408f;
    }

    /* renamed from: a */
    public static C0611c m3853a(PersistableBundle persistableBundle) {
        return a.m3862a(persistableBundle);
    }

    /* renamed from: b */
    public IconCompat m3854b() {
        return this.f3398b;
    }

    /* renamed from: c */
    public String m3855c() {
        return this.f3400d;
    }

    /* renamed from: d */
    public CharSequence m3856d() {
        return this.f3397a;
    }

    /* renamed from: e */
    public String m3857e() {
        return this.f3399c;
    }

    /* renamed from: f */
    public boolean m3858f() {
        return this.f3401e;
    }

    /* renamed from: g */
    public boolean m3859g() {
        return this.f3402f;
    }

    /* renamed from: h */
    public Person m3860h() {
        return b.m3865b(this);
    }

    /* renamed from: i */
    public PersistableBundle m3861i() {
        return a.m3863b(this);
    }
}
