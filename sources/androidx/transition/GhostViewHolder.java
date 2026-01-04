package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class GhostViewHolder extends FrameLayout {

    /* renamed from: a */
    public ViewGroup f4741a;

    /* renamed from: b */
    public boolean f4742b;

    public GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f4741a = viewGroup;
        viewGroup.setTag(R$id.ghost_view_holder, this);
        C0964y.m5845b(this.f4741a).mo5842c(this);
        this.f4742b = true;
    }

    /* renamed from: b */
    public static GhostViewHolder m5679b(ViewGroup viewGroup) {
        return (GhostViewHolder) viewGroup.getTag(R$id.ghost_view_holder);
    }

    /* renamed from: d */
    public static void m5680d(View view, ArrayList<View> arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            m5680d((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    /* renamed from: e */
    public static boolean m5681e(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(C0964y.m5844a(viewGroup, i10));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                break;
            }
        }
        return true;
    }

    /* renamed from: f */
    public static boolean m5682f(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int iMin = Math.min(arrayList.size(), arrayList2.size());
        for (int i10 = 1; i10 < iMin; i10++) {
            View view = arrayList.get(i10);
            View view2 = arrayList2.get(i10);
            if (view != view2) {
                return m5681e(view, view2);
            }
        }
        return arrayList2.size() == iMin;
    }

    /* renamed from: a */
    public void m5683a(GhostViewPort ghostViewPort) {
        ArrayList<View> arrayList = new ArrayList<>();
        m5680d(ghostViewPort.f4745c, arrayList);
        int iM5684c = m5684c(arrayList);
        if (iM5684c < 0 || iM5684c >= getChildCount()) {
            addView(ghostViewPort);
        } else {
            addView(ghostViewPort, iM5684c);
        }
    }

    /* renamed from: c */
    public final int m5684c(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i10 = 0;
        while (i10 <= childCount) {
            int i11 = (i10 + childCount) / 2;
            m5680d(((GhostViewPort) getChildAt(i11)).f4745c, arrayList2);
            if (m5682f(arrayList, arrayList2)) {
                i10 = i11 + 1;
            } else {
                childCount = i11 - 1;
            }
            arrayList2.clear();
        }
        return i10;
    }

    /* renamed from: g */
    public void m5685g() {
        if (!this.f4742b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        C0964y.m5845b(this.f4741a).mo5843d(this);
        C0964y.m5845b(this.f4741a).mo5842c(this);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.f4742b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f4741a.setTag(R$id.ghost_view_holder, null);
            C0964y.m5845b(this.f4741a).mo5843d(this);
            this.f4742b = false;
        }
    }
}
