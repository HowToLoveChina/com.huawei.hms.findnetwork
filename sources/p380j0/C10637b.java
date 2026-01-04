package p380j0;

import android.database.Cursor;
import android.widget.Filter;

/* renamed from: j0.b */
/* loaded from: classes.dex */
public class C10637b extends Filter {

    /* renamed from: a */
    public a f51109a;

    /* renamed from: j0.b$a */
    public interface a {
        /* renamed from: a */
        void mo3193a(Cursor cursor);

        /* renamed from: b */
        Cursor mo65134b();

        /* renamed from: c */
        CharSequence mo3194c(Cursor cursor);

        /* renamed from: d */
        Cursor mo3195d(CharSequence charSequence);
    }

    public C10637b(a aVar) {
        this.f51109a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f51109a.mo3194c((Cursor) obj);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorMo3195d = this.f51109a.mo3195d(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorMo3195d != null) {
            filterResults.count = cursorMo3195d.getCount();
            filterResults.values = cursorMo3195d;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorMo65134b = this.f51109a.mo65134b();
        Object obj = filterResults.values;
        if (obj == null || obj == cursorMo65134b) {
            return;
        }
        this.f51109a.mo3193a((Cursor) obj);
    }
}
