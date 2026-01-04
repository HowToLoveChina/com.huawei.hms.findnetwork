package androidx.core.widget;

import android.widget.ListView;

/* renamed from: androidx.core.widget.h */
/* loaded from: classes.dex */
public final class C0667h {

    /* renamed from: androidx.core.widget.h$a */
    public static class a {
        /* renamed from: a */
        public static boolean m4057a(ListView listView, int i10) {
            return listView.canScrollList(i10);
        }

        /* renamed from: b */
        public static void m4058b(ListView listView, int i10) {
            listView.scrollListBy(i10);
        }
    }

    /* renamed from: a */
    public static void m4056a(ListView listView, int i10) {
        a.m4058b(listView, i10);
    }
}
