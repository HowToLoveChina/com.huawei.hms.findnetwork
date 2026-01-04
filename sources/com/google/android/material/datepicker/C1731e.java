package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.google.android.material.datepicker.e */
/* loaded from: classes.dex */
public class C1731e extends BaseAdapter {

    /* renamed from: d */
    public static final int f7945d = 4;

    /* renamed from: a */
    public final Calendar f7946a;

    /* renamed from: b */
    public final int f7947b;

    /* renamed from: c */
    public final int f7948c;

    public C1731e() {
        Calendar calendarM10385l = C1742p.m10385l();
        this.f7946a = calendarM10385l;
        this.f7947b = calendarM10385l.getMaximum(7);
        this.f7948c = calendarM10385l.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i10) {
        if (i10 >= this.f7947b) {
            return null;
        }
        return Integer.valueOf(m10300b(i10));
    }

    /* renamed from: b */
    public final int m10300b(int i10) {
        int i11 = i10 + this.f7948c;
        int i12 = this.f7947b;
        return i11 > i12 ? i11 - i12 : i11;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7947b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f7946a.set(7, m10300b(i10));
        textView.setText(this.f7946a.getDisplayName(7, f7945d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.mtrl_picker_day_of_week_column_header), this.f7946a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
