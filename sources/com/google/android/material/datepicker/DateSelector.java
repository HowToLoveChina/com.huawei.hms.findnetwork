package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collection;
import p243e0.C9369d;

/* loaded from: classes.dex */
public interface DateSelector<S> extends Parcelable {
    /* renamed from: C */
    View mo10226C(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, AbstractC1738l<S> abstractC1738l);

    /* renamed from: G */
    int mo10227G(Context context);

    /* renamed from: J */
    boolean mo10228J();

    /* renamed from: X */
    Collection<Long> mo10229X();

    /* renamed from: b */
    String mo10230b(Context context);

    /* renamed from: i0 */
    S mo10231i0();

    /* renamed from: q0 */
    void mo10232q0(long j10);

    /* renamed from: u */
    Collection<C9369d<Long, Long>> mo10233u();
}
