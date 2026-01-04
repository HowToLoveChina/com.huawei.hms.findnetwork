package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;

/* renamed from: androidx.recyclerview.widget.j */
/* loaded from: classes.dex */
public interface InterfaceC0871j {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10);

    void onSelected(View view);
}
