package p279f6;

import android.content.ContentValues;
import android.net.Uri;
import java.util.Set;

/* renamed from: f6.c */
/* loaded from: classes.dex */
public class C9660c {

    /* renamed from: a */
    public ContentValues f47821a;

    /* renamed from: b */
    public Set<ContentValues> f47822b;

    /* renamed from: c */
    public Uri f47823c;

    /* renamed from: d */
    public ContentValues f47824d;

    public C9660c(ContentValues contentValues, Set<ContentValues> set) {
        this.f47823c = null;
        this.f47824d = null;
        this.f47821a = contentValues;
        this.f47822b = set;
    }

    /* renamed from: a */
    public Uri m60324a() {
        return this.f47823c;
    }

    /* renamed from: b */
    public Set<ContentValues> m60325b() {
        return this.f47822b;
    }

    /* renamed from: c */
    public Integer m60326c() {
        ContentValues contentValues = this.f47821a;
        if (contentValues != null) {
            return contentValues.getAsInteger("aggregation_mode");
        }
        return 0;
    }

    /* renamed from: d */
    public Long m60327d() {
        ContentValues contentValues = this.f47821a;
        if (contentValues != null) {
            return contentValues.getAsLong("_id");
        }
        return 0L;
    }

    /* renamed from: e */
    public ContentValues m60328e() {
        return this.f47821a;
    }

    /* renamed from: f */
    public ContentValues m60329f() {
        return this.f47824d;
    }

    public C9660c(Uri uri, ContentValues contentValues) {
        this.f47821a = null;
        this.f47822b = null;
        this.f47823c = uri;
        this.f47824d = contentValues;
    }
}
