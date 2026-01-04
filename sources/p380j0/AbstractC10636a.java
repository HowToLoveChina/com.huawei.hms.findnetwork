package p380j0;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import p380j0.C10637b;

/* renamed from: j0.a */
/* loaded from: classes.dex */
public abstract class AbstractC10636a extends BaseAdapter implements Filterable, C10637b.a {

    /* renamed from: a */
    public boolean f51099a;

    /* renamed from: b */
    public boolean f51100b;

    /* renamed from: c */
    public Cursor f51101c;

    /* renamed from: d */
    public Context f51102d;

    /* renamed from: e */
    public int f51103e;

    /* renamed from: f */
    public a f51104f;

    /* renamed from: g */
    public DataSetObserver f51105g;

    /* renamed from: h */
    public C10637b f51106h;

    /* renamed from: j0.a$a */
    public class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            AbstractC10636a.this.m65137i();
        }
    }

    /* renamed from: j0.a$b */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AbstractC10636a abstractC10636a = AbstractC10636a.this;
            abstractC10636a.f51099a = true;
            abstractC10636a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AbstractC10636a abstractC10636a = AbstractC10636a.this;
            abstractC10636a.f51099a = false;
            abstractC10636a.notifyDataSetInvalidated();
        }
    }

    public AbstractC10636a(Context context, Cursor cursor, boolean z10) {
        m65135f(context, cursor, z10 ? 1 : 2);
    }

    /* renamed from: a */
    public void mo3193a(Cursor cursor) {
        Cursor cursorM65138j = m65138j(cursor);
        if (cursorM65138j != null) {
            cursorM65138j.close();
        }
    }

    @Override // p380j0.C10637b.a
    /* renamed from: b */
    public Cursor mo65134b() {
        return this.f51101c;
    }

    /* renamed from: c */
    public abstract CharSequence mo3194c(Cursor cursor);

    /* renamed from: e */
    public abstract void mo3196e(View view, Context context, Cursor cursor);

    /* renamed from: f */
    public void m65135f(Context context, Cursor cursor, int i10) {
        if ((i10 & 1) == 1) {
            i10 |= 2;
            this.f51100b = true;
        } else {
            this.f51100b = false;
        }
        boolean z10 = cursor != null;
        this.f51101c = cursor;
        this.f51099a = z10;
        this.f51102d = context;
        this.f51103e = z10 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i10 & 2) == 2) {
            this.f51104f = new a();
            this.f51105g = new b();
        } else {
            this.f51104f = null;
            this.f51105g = null;
        }
        if (z10) {
            a aVar = this.f51104f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f51105g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: g */
    public abstract View mo65136g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f51099a || (cursor = this.f51101c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f51099a) {
            return null;
        }
        this.f51101c.moveToPosition(i10);
        if (view == null) {
            view = mo65136g(this.f51102d, this.f51101c, viewGroup);
        }
        mo3196e(view, this.f51102d, this.f51101c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f51106h == null) {
            this.f51106h = new C10637b(this);
        }
        return this.f51106h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        Cursor cursor;
        if (!this.f51099a || (cursor = this.f51101c) == null) {
            return null;
        }
        cursor.moveToPosition(i10);
        return this.f51101c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        Cursor cursor;
        if (this.f51099a && (cursor = this.f51101c) != null && cursor.moveToPosition(i10)) {
            return this.f51101c.getLong(this.f51103e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f51099a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f51101c.moveToPosition(i10)) {
            if (view == null) {
                view = mo3197h(this.f51102d, this.f51101c, viewGroup);
            }
            mo3196e(view, this.f51102d, this.f51101c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i10);
    }

    /* renamed from: h */
    public abstract View mo3197h(Context context, Cursor cursor, ViewGroup viewGroup);

    /* renamed from: i */
    public void m65137i() {
        Cursor cursor;
        if (!this.f51100b || (cursor = this.f51101c) == null || cursor.isClosed()) {
            return;
        }
        this.f51099a = this.f51101c.requery();
    }

    /* renamed from: j */
    public Cursor m65138j(Cursor cursor) {
        Cursor cursor2 = this.f51101c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            a aVar = this.f51104f;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f51105g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f51101c = cursor;
        if (cursor != null) {
            a aVar2 = this.f51104f;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f51105g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f51103e = cursor.getColumnIndexOrThrow("_id");
            this.f51099a = true;
            notifyDataSetChanged();
        } else {
            this.f51103e = -1;
            this.f51099a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
