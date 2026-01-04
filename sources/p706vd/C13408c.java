package p706vd;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import p015ak.C0213f;
import p514o9.C11842p;

/* renamed from: vd.c */
/* loaded from: classes3.dex */
public class C13408c extends RecyclerView.AbstractC0845o {
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        super.getItemOffsets(rect, view, recyclerView, c0856z);
        rect.right = (int) C11842p.m70844o(C0213f.m1377a(), 8);
    }
}
