package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.ContentResolverCompat;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
import p024b0.C1089e;
import p024b0.C1093i;

/* loaded from: classes.dex */
public class CursorLoader extends AsyncTaskLoader<Cursor> {

    /* renamed from: o */
    public final Loader<Cursor>.C0812a f4231o;

    /* renamed from: p */
    public Uri f4232p;

    /* renamed from: q */
    public String[] f4233q;

    /* renamed from: r */
    public String f4234r;

    /* renamed from: s */
    public String[] f4235s;

    /* renamed from: t */
    public String f4236t;

    /* renamed from: u */
    public Cursor f4237u;

    /* renamed from: v */
    public C1089e f4238v;

    public CursorLoader(Context context) {
        super(context);
        this.f4231o = new Loader.C0812a();
    }

    @Override // androidx.loader.content.Loader
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void mo5027f(Cursor cursor) {
        if (m5039k()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.f4237u;
        this.f4237u = cursor;
        if (m5040l()) {
            super.mo5027f(cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public Cursor mo5013E() {
        synchronized (this) {
            if (m5012D()) {
                throw new C1093i();
            }
            this.f4238v = new C1089e();
        }
        try {
            Cursor cursorQuery = ContentResolverCompat.query(m5037i().getContentResolver(), this.f4232p, this.f4233q, this.f4234r, this.f4235s, this.f4236t, this.f4238v);
            if (cursorQuery != null) {
                try {
                    cursorQuery.getCount();
                    cursorQuery.registerContentObserver(this.f4231o);
                } catch (RuntimeException e10) {
                    cursorQuery.close();
                    throw e10;
                }
            }
            synchronized (this) {
                this.f4238v = null;
            }
            return cursorQuery;
        } catch (Throwable th2) {
            synchronized (this) {
                this.f4238v = null;
                throw th2;
            }
        }
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void mo5014F(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    @Override // androidx.loader.content.AsyncTaskLoader, androidx.loader.content.Loader
    @Deprecated
    /* renamed from: g */
    public void mo5016g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo5016g(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f4232p);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f4233q));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f4234r);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f4235s));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f4236t);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f4237u);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f4245g);
    }

    @Override // androidx.loader.content.Loader
    /* renamed from: q */
    public void mo5028q() {
        super.mo5028q();
        mo5030s();
        Cursor cursor = this.f4237u;
        if (cursor != null && !cursor.isClosed()) {
            this.f4237u.close();
        }
        this.f4237u = null;
    }

    @Override // androidx.loader.content.Loader
    /* renamed from: r */
    public void mo5029r() {
        Cursor cursor = this.f4237u;
        if (cursor != null) {
            mo5027f(cursor);
        }
        if (m5047x() || this.f4237u == null) {
            m5036h();
        }
    }

    @Override // androidx.loader.content.Loader
    /* renamed from: s */
    public void mo5030s() {
        m5032b();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* renamed from: z */
    public void mo5019z() {
        super.mo5019z();
        synchronized (this) {
            try {
                C1089e c1089e = this.f4238v;
                if (c1089e != null) {
                    c1089e.m6468a();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
