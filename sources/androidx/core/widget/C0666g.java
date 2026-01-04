package androidx.core.widget;

import android.widget.ListView;

/* renamed from: androidx.core.widget.g */
/* loaded from: classes.dex */
public class C0666g extends AbstractViewOnTouchListenerC0660a {

    /* renamed from: s */
    public final ListView f3517s;

    public C0666g(ListView listView) {
        super(listView);
        this.f3517s = listView;
    }

    @Override // androidx.core.widget.AbstractViewOnTouchListenerC0660a
    /* renamed from: a */
    public boolean mo4000a(int i10) {
        return false;
    }

    @Override // androidx.core.widget.AbstractViewOnTouchListenerC0660a
    /* renamed from: b */
    public boolean mo4001b(int i10) {
        ListView listView = this.f3517s;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i11 = firstVisiblePosition + childCount;
        if (i10 > 0) {
            if (i11 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i10 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.widget.AbstractViewOnTouchListenerC0660a
    /* renamed from: j */
    public void mo4007j(int i10, int i11) {
        C0667h.m4056a(this.f3517s, i11);
    }
}
