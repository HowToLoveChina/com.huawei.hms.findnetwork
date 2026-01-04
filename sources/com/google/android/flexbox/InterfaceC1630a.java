package com.google.android.flexbox;

import android.view.View;
import java.util.List;

/* renamed from: com.google.android.flexbox.a */
/* loaded from: classes.dex */
public interface InterfaceC1630a {
    /* renamed from: a */
    void mo9273a(View view, int i10, int i11, C1631b c1631b);

    /* renamed from: b */
    void mo9274b(C1631b c1631b);

    /* renamed from: c */
    View mo9275c(int i10);

    /* renamed from: d */
    int mo9276d(int i10, int i11, int i12);

    /* renamed from: e */
    void mo9277e(int i10, View view);

    /* renamed from: f */
    View mo9278f(int i10);

    /* renamed from: g */
    int mo9279g(View view, int i10, int i11);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<C1631b> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    /* renamed from: h */
    int mo9280h(int i10, int i11, int i12);

    /* renamed from: n */
    boolean mo9286n();

    /* renamed from: o */
    int mo9287o(View view);

    void setFlexLines(List<C1631b> list);
}
