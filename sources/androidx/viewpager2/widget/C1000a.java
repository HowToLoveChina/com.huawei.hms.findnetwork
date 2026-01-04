package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: androidx.viewpager2.widget.a */
/* loaded from: classes.dex */
public final class C1000a {

    /* renamed from: b */
    public static final ViewGroup.MarginLayoutParams f5007b;

    /* renamed from: a */
    public LinearLayoutManager f5008a;

    /* renamed from: androidx.viewpager2.widget.a$a */
    public class a implements Comparator<int[]> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f5007b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public C1000a(LinearLayoutManager linearLayoutManager) {
        this.f5008a = linearLayoutManager;
    }

    /* renamed from: c */
    public static boolean m5905c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (m5905c(viewGroup.getChildAt(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public final boolean m5906a() {
        int top;
        int i10;
        int bottom;
        int i11;
        int childCount = this.f5008a.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z10 = this.f5008a.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, childCount, 2);
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = this.f5008a.getChildAt(i12);
            if (childAt == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f5007b;
            int[] iArr2 = iArr[i12];
            if (z10) {
                top = childAt.getLeft();
                i10 = marginLayoutParams.leftMargin;
            } else {
                top = childAt.getTop();
                i10 = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i10;
            int[] iArr3 = iArr[i12];
            if (z10) {
                bottom = childAt.getRight();
                i11 = marginLayoutParams.rightMargin;
            } else {
                bottom = childAt.getBottom();
                i11 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i11;
        }
        Arrays.sort(iArr, new a());
        for (int i13 = 1; i13 < childCount; i13++) {
            if (iArr[i13 - 1][1] != iArr[i13][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i14 = iArr4[1];
        int i15 = iArr4[0];
        return i15 <= 0 && iArr[childCount - 1][1] >= i14 - i15;
    }

    /* renamed from: b */
    public final boolean m5907b() {
        int childCount = this.f5008a.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (m5905c(this.f5008a.getChildAt(i10))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public boolean m5908d() {
        return (!m5906a() || this.f5008a.getChildCount() <= 1) && m5907b();
    }
}
