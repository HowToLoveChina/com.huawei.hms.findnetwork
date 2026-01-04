package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.R$string;
import com.google.android.material.internal.C1783n;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* renamed from: com.google.android.material.datepicker.c */
/* loaded from: classes.dex */
public abstract class AbstractC1729c extends C1783n {

    /* renamed from: a */
    public final TextInputLayout f7935a;

    /* renamed from: b */
    public final DateFormat f7936b;

    /* renamed from: c */
    public final CalendarConstraints f7937c;

    /* renamed from: d */
    public final String f7938d;

    /* renamed from: e */
    public final Runnable f7939e;

    /* renamed from: f */
    public Runnable f7940f;

    /* renamed from: com.google.android.material.datepicker.c$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f7941a;

        public a(String str) {
            this.f7941a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout textInputLayout = AbstractC1729c.this.f7935a;
            DateFormat dateFormat = AbstractC1729c.this.f7936b;
            Context context = textInputLayout.getContext();
            textInputLayout.setError(context.getString(R$string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_use), this.f7941a) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(C1742p.m10383j().getTimeInMillis()))));
            AbstractC1729c.this.mo10267e();
        }
    }

    /* renamed from: com.google.android.material.datepicker.c$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ long f7943a;

        public b(long j10) {
            this.f7943a = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC1729c.this.f7935a.setError(String.format(AbstractC1729c.this.f7938d, C1730d.m10288c(this.f7943a)));
            AbstractC1729c.this.mo10267e();
        }
    }

    public AbstractC1729c(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f7936b = dateFormat;
        this.f7935a = textInputLayout;
        this.f7937c = calendarConstraints;
        this.f7938d = textInputLayout.getContext().getString(R$string.mtrl_picker_out_of_range);
        this.f7939e = new a(str);
    }

    /* renamed from: d */
    public final Runnable m10284d(long j10) {
        return new b(j10);
    }

    /* renamed from: e */
    public abstract void mo10267e();

    /* renamed from: f */
    public abstract void mo10268f(Long l10);

    /* renamed from: g */
    public void m10285g(View view, Runnable runnable) {
        view.postDelayed(runnable, 1000L);
    }

    @Override // com.google.android.material.internal.C1783n, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) throws ParseException {
        this.f7935a.removeCallbacks(this.f7939e);
        this.f7935a.removeCallbacks(this.f7940f);
        this.f7935a.setError(null);
        mo10268f(null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date date = this.f7936b.parse(charSequence.toString());
            this.f7935a.setError(null);
            long time = date.getTime();
            if (this.f7937c.m10209g().mo10216k(time) && this.f7937c.m10215n(time)) {
                mo10268f(Long.valueOf(date.getTime()));
                return;
            }
            Runnable runnableM10284d = m10284d(time);
            this.f7940f = runnableM10284d;
            m10285g(this.f7935a, runnableM10284d);
        } catch (ParseException unused) {
            m10285g(this.f7935a, this.f7939e);
        }
    }
}
