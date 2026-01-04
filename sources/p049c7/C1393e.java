package p049c7;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p069cg.utils.scrollbar.FMScrollBar;
import java.lang.reflect.InvocationTargetException;

/* renamed from: c7.e */
/* loaded from: classes2.dex */
public class C1393e extends C1394f {
    @Override // p049c7.InterfaceC1391c
    /* renamed from: a */
    public void mo7964a(RecyclerView recyclerView, FMScrollBar fMScrollBar, boolean z10) {
        m7967c(recyclerView, fMScrollBar, z10);
    }

    /* renamed from: c */
    public final void m7967c(View view, final FMScrollBar fMScrollBar, boolean z10) {
        if (view == null || fMScrollBar == null) {
            return;
        }
        fMScrollBar.m14928G(view, z10);
        view.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: c7.d
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view2, int i10, int i11, int i12, int i13) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                fMScrollBar.m14952x(view2, i10, i11, i12, i13);
            }
        });
    }
}
