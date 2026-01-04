package com.huawei.uikit.hwalphaindexerlistview.widget;

import android.widget.SectionIndexer;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class HwSectionIndexer implements SectionIndexer {

    /* renamed from: d */
    private static final int f41397d = 2;

    /* renamed from: e */
    private static final int f41398e = -1;

    /* renamed from: a */
    private String[] f41399a;

    /* renamed from: b */
    private int[] f41400b;

    /* renamed from: c */
    private int f41401c;

    public HwSectionIndexer(String[] strArr, int[] iArr, boolean z10) {
        if (strArr == null || iArr == null || strArr.length != iArr.length) {
            return;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        this.f41399a = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, length);
        this.f41400b = new int[length];
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            String[] strArr3 = this.f41399a;
            String str = strArr3[i11];
            if (str == null) {
                strArr3[i11] = "";
            } else {
                strArr3[i11] = str.trim();
            }
            this.f41400b[i11] = i10;
            i10 += iArr[i11];
        }
        this.f41401c = i10;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i10) {
        if (i10 < 0 || i10 >= this.f41399a.length) {
            return -1;
        }
        return this.f41400b[i10];
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i10) {
        if (i10 < 0 || i10 >= this.f41401c) {
            return -1;
        }
        int iBinarySearch = Arrays.binarySearch(this.f41400b, i10);
        return iBinarySearch >= 0 ? iBinarySearch : (-iBinarySearch) - 2;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        String[] strArr = this.f41399a;
        if (strArr == null || strArr.length == 0) {
            return new String[0];
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        return strArr2;
    }

    public HwSectionIndexer(String[] strArr, int[] iArr) {
        this(strArr, iArr, false);
    }
}
