package p273f0;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Objects;
import p243e0.C9373h;

/* renamed from: f0.c */
/* loaded from: classes.dex */
public final class C9588c {

    /* renamed from: a */
    public final f f47680a;

    /* renamed from: f0.c$a */
    public static final class a {

        /* renamed from: a */
        public final c f47681a;

        public a(ClipData clipData, int i10) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f47681a = new b(clipData, i10);
            } else {
                this.f47681a = new d(clipData, i10);
            }
        }

        /* renamed from: a */
        public C9588c m59797a() {
            return this.f47681a.build();
        }

        /* renamed from: b */
        public a m59798b(Bundle bundle) {
            this.f47681a.setExtras(bundle);
            return this;
        }

        /* renamed from: c */
        public a m59799c(int i10) {
            this.f47681a.mo59802b(i10);
            return this;
        }

        /* renamed from: d */
        public a m59800d(Uri uri) {
            this.f47681a.mo59801a(uri);
            return this;
        }
    }

    /* renamed from: f0.c$b */
    public static final class b implements c {

        /* renamed from: a */
        public final ContentInfo.Builder f47682a;

        public b(ClipData clipData, int i10) {
            this.f47682a = C9597f.m59823a(clipData, i10);
        }

        @Override // p273f0.C9588c.c
        /* renamed from: a */
        public void mo59801a(Uri uri) {
            this.f47682a.setLinkUri(uri);
        }

        @Override // p273f0.C9588c.c
        /* renamed from: b */
        public void mo59802b(int i10) {
            this.f47682a.setFlags(i10);
        }

        @Override // p273f0.C9588c.c
        public C9588c build() {
            return new C9588c(new e(this.f47682a.build()));
        }

        @Override // p273f0.C9588c.c
        public void setExtras(Bundle bundle) {
            this.f47682a.setExtras(bundle);
        }
    }

    /* renamed from: f0.c$c */
    public interface c {
        /* renamed from: a */
        void mo59801a(Uri uri);

        /* renamed from: b */
        void mo59802b(int i10);

        C9588c build();

        void setExtras(Bundle bundle);
    }

    /* renamed from: f0.c$d */
    public static final class d implements c {

        /* renamed from: a */
        public ClipData f47683a;

        /* renamed from: b */
        public int f47684b;

        /* renamed from: c */
        public int f47685c;

        /* renamed from: d */
        public Uri f47686d;

        /* renamed from: e */
        public Bundle f47687e;

        public d(ClipData clipData, int i10) {
            this.f47683a = clipData;
            this.f47684b = i10;
        }

        @Override // p273f0.C9588c.c
        /* renamed from: a */
        public void mo59801a(Uri uri) {
            this.f47686d = uri;
        }

        @Override // p273f0.C9588c.c
        /* renamed from: b */
        public void mo59802b(int i10) {
            this.f47685c = i10;
        }

        @Override // p273f0.C9588c.c
        public C9588c build() {
            return new C9588c(new g(this));
        }

        @Override // p273f0.C9588c.c
        public void setExtras(Bundle bundle) {
            this.f47687e = bundle;
        }
    }

    /* renamed from: f0.c$e */
    public static final class e implements f {

        /* renamed from: a */
        public final ContentInfo f47688a;

        public e(ContentInfo contentInfo) {
            this.f47688a = C9585b.m59788a(C9373h.m58745f(contentInfo));
        }

        @Override // p273f0.C9588c.f
        /* renamed from: a */
        public ClipData mo59803a() {
            return this.f47688a.getClip();
        }

        @Override // p273f0.C9588c.f
        /* renamed from: b */
        public int mo59804b() {
            return this.f47688a.getFlags();
        }

        @Override // p273f0.C9588c.f
        /* renamed from: c */
        public ContentInfo mo59805c() {
            return this.f47688a;
        }

        @Override // p273f0.C9588c.f
        /* renamed from: d */
        public int mo59806d() {
            return this.f47688a.getSource();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f47688a + "}";
        }
    }

    /* renamed from: f0.c$f */
    public interface f {
        /* renamed from: a */
        ClipData mo59803a();

        /* renamed from: b */
        int mo59804b();

        /* renamed from: c */
        ContentInfo mo59805c();

        /* renamed from: d */
        int mo59806d();
    }

    /* renamed from: f0.c$g */
    public static final class g implements f {

        /* renamed from: a */
        public final ClipData f47689a;

        /* renamed from: b */
        public final int f47690b;

        /* renamed from: c */
        public final int f47691c;

        /* renamed from: d */
        public final Uri f47692d;

        /* renamed from: e */
        public final Bundle f47693e;

        public g(d dVar) {
            this.f47689a = (ClipData) C9373h.m58745f(dVar.f47683a);
            this.f47690b = C9373h.m58741b(dVar.f47684b, 0, 5, "source");
            this.f47691c = C9373h.m58744e(dVar.f47685c, 1);
            this.f47692d = dVar.f47686d;
            this.f47693e = dVar.f47687e;
        }

        @Override // p273f0.C9588c.f
        /* renamed from: a */
        public ClipData mo59803a() {
            return this.f47689a;
        }

        @Override // p273f0.C9588c.f
        /* renamed from: b */
        public int mo59804b() {
            return this.f47691c;
        }

        @Override // p273f0.C9588c.f
        /* renamed from: c */
        public ContentInfo mo59805c() {
            return null;
        }

        @Override // p273f0.C9588c.f
        /* renamed from: d */
        public int mo59806d() {
            return this.f47690b;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ContentInfoCompat{clip=");
            sb2.append(this.f47689a.getDescription());
            sb2.append(", source=");
            sb2.append(C9588c.m59791e(this.f47690b));
            sb2.append(", flags=");
            sb2.append(C9588c.m59790a(this.f47691c));
            if (this.f47692d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f47692d.toString().length() + ")";
            }
            sb2.append(str);
            sb2.append(this.f47693e != null ? ", hasExtras" : "");
            sb2.append("}");
            return sb2.toString();
        }
    }

    public C9588c(f fVar) {
        this.f47680a = fVar;
    }

    /* renamed from: a */
    public static String m59790a(int i10) {
        return (i10 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i10);
    }

    /* renamed from: e */
    public static String m59791e(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? String.valueOf(i10) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    /* renamed from: g */
    public static C9588c m59792g(ContentInfo contentInfo) {
        return new C9588c(new e(contentInfo));
    }

    /* renamed from: b */
    public ClipData m59793b() {
        return this.f47680a.mo59803a();
    }

    /* renamed from: c */
    public int m59794c() {
        return this.f47680a.mo59804b();
    }

    /* renamed from: d */
    public int m59795d() {
        return this.f47680a.mo59806d();
    }

    /* renamed from: f */
    public ContentInfo m59796f() {
        ContentInfo contentInfoMo59805c = this.f47680a.mo59805c();
        Objects.requireNonNull(contentInfoMo59805c);
        return C9585b.m59788a(contentInfoMo59805c);
    }

    public String toString() {
        return this.f47680a.toString();
    }
}
