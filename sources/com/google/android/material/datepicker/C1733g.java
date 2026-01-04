package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.AbstractC0735a0;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.C1774e;
import com.google.android.material.internal.C1788s;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p211d.C8968a;
import p273f0.C9603h0;
import p273f0.C9625s0;
import p273f0.InterfaceC9586b0;
import p276f3.C9648b;
import p356i3.C10427h;
import p796y2.ViewOnTouchListenerC13906a;

/* renamed from: com.google.android.material.datepicker.g */
/* loaded from: classes.dex */
public final class C1733g<S> extends DialogInterfaceOnCancelListenerC0738c {

    /* renamed from: O0 */
    public static final Object f7984O0 = "CONFIRM_BUTTON_TAG";

    /* renamed from: P0 */
    public static final Object f7985P0 = "CANCEL_BUTTON_TAG";

    /* renamed from: Q0 */
    public static final Object f7986Q0 = "TOGGLE_BUTTON_TAG";

    /* renamed from: A0 */
    public C1732f<S> f7987A0;

    /* renamed from: B0 */
    public int f7988B0;

    /* renamed from: C0 */
    public CharSequence f7989C0;

    /* renamed from: D0 */
    public boolean f7990D0;

    /* renamed from: E0 */
    public int f7991E0;

    /* renamed from: F0 */
    public int f7992F0;

    /* renamed from: G0 */
    public CharSequence f7993G0;

    /* renamed from: H0 */
    public int f7994H0;

    /* renamed from: I0 */
    public CharSequence f7995I0;

    /* renamed from: J0 */
    public TextView f7996J0;

    /* renamed from: K0 */
    public CheckableImageButton f7997K0;

    /* renamed from: L0 */
    public C10427h f7998L0;

    /* renamed from: M0 */
    public Button f7999M0;

    /* renamed from: N0 */
    public boolean f8000N0;

    /* renamed from: s0 */
    public final LinkedHashSet<InterfaceC1734h<? super S>> f8001s0 = new LinkedHashSet<>();

    /* renamed from: t0 */
    public final LinkedHashSet<View.OnClickListener> f8002t0 = new LinkedHashSet<>();

    /* renamed from: u0 */
    public final LinkedHashSet<DialogInterface.OnCancelListener> f8003u0 = new LinkedHashSet<>();

    /* renamed from: v0 */
    public final LinkedHashSet<DialogInterface.OnDismissListener> f8004v0 = new LinkedHashSet<>();

    /* renamed from: w0 */
    public int f8005w0;

    /* renamed from: x0 */
    public DateSelector<S> f8006x0;

    /* renamed from: y0 */
    public AbstractC1739m<S> f8007y0;

    /* renamed from: z0 */
    public CalendarConstraints f8008z0;

    /* renamed from: com.google.android.material.datepicker.g$a */
    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = C1733g.this.f8001s0.iterator();
            while (it.hasNext()) {
                ((InterfaceC1734h) it.next()).m10348a(C1733g.this.m10340d2());
            }
            C1733g.this.m4698F1();
        }
    }

    /* renamed from: com.google.android.material.datepicker.g$b */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = C1733g.this.f8002t0.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            C1733g.this.m4698F1();
        }
    }

    /* renamed from: com.google.android.material.datepicker.g$c */
    public class c implements InterfaceC9586b0 {

        /* renamed from: a */
        public final /* synthetic */ int f8011a;

        /* renamed from: b */
        public final /* synthetic */ View f8012b;

        /* renamed from: c */
        public final /* synthetic */ int f8013c;

        public c(int i10, View view, int i11) {
            this.f8011a = i10;
            this.f8012b = view;
            this.f8013c = i11;
        }

        @Override // p273f0.InterfaceC9586b0
        public C9625s0 onApplyWindowInsets(View view, C9625s0 c9625s0) {
            int i10 = c9625s0.m60154f(C9625s0.l.m60205c()).f60771b;
            if (this.f8011a >= 0) {
                this.f8012b.getLayoutParams().height = this.f8011a + i10;
                View view2 = this.f8012b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f8012b;
            view3.setPadding(view3.getPaddingLeft(), this.f8013c + i10, this.f8012b.getPaddingRight(), this.f8012b.getPaddingBottom());
            return c9625s0;
        }
    }

    /* renamed from: com.google.android.material.datepicker.g$d */
    public class d extends AbstractC1738l<S> {
        public d() {
        }

        @Override // com.google.android.material.datepicker.AbstractC1738l
        /* renamed from: a */
        public void mo10346a() {
            C1733g.this.f7999M0.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.AbstractC1738l
        /* renamed from: b */
        public void mo10347b(S s10) {
            C1733g.this.m10344k2();
            C1733g.this.f7999M0.setEnabled(C1733g.this.m10333a2().mo10228J());
        }
    }

    /* renamed from: com.google.android.material.datepicker.g$e */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1733g.this.f7999M0.setEnabled(C1733g.this.m10333a2().mo10228J());
            C1733g.this.f7997K0.toggle();
            C1733g c1733g = C1733g.this;
            c1733g.m10345l2(c1733g.f7997K0);
            C1733g.this.m10343j2();
        }
    }

    /* renamed from: Y1 */
    public static Drawable m10332Y1(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, C8968a.m56743b(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], C8968a.m56743b(context, R$drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    /* renamed from: a2 */
    public DateSelector<S> m10333a2() {
        if (this.f8006x0 == null) {
            this.f8006x0 = (DateSelector) m4420n().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f8006x0;
    }

    /* renamed from: c2 */
    public static int m10334c2(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i10 = Month.m10246h().f7900d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding));
    }

    /* renamed from: g2 */
    public static boolean m10335g2(Context context) {
        return m10337i2(context, R.attr.windowFullscreen);
    }

    /* renamed from: h2 */
    public static boolean m10336h2(Context context) {
        return m10337i2(context, R$attr.nestedScrollable);
    }

    /* renamed from: i2 */
    public static boolean m10337i2(Context context, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(C9648b.m60263d(context, R$attr.materialCalendarStyle, C1732f.class.getCanonicalName()), new int[]{i10});
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z10;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c, androidx.fragment.app.Fragment
    /* renamed from: H0 */
    public final void mo4350H0(Bundle bundle) {
        super.mo4350H0(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f8005w0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f8006x0);
        CalendarConstraints.C1713b c1713b = new CalendarConstraints.C1713b(this.f8008z0);
        if (this.f7987A0.m10316P1() != null) {
            c1713b.m10220b(this.f7987A0.m10316P1().f7902f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", c1713b.m10219a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f7988B0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f7989C0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f7992F0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f7993G0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f7994H0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f7995I0);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c, androidx.fragment.app.Fragment
    /* renamed from: I0 */
    public void mo4352I0() throws Resources.NotFoundException {
        super.mo4352I0();
        Window window = m4706N1().getWindow();
        if (this.f7990D0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f7998L0);
            m10338Z1(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = m4354K().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f7998L0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new ViewOnTouchListenerC13906a(m4706N1(), rect));
        }
        m10343j2();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c, androidx.fragment.app.Fragment
    /* renamed from: J0 */
    public void mo4353J0() {
        this.f8007y0.m10370D1();
        super.mo4353J0();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c
    /* renamed from: J1 */
    public final Dialog mo4702J1(Bundle bundle) {
        Dialog dialog = new Dialog(m4419m1(), m10341e2(m4419m1()));
        Context context = dialog.getContext();
        this.f7990D0 = m10335g2(context);
        int iM60263d = C9648b.m60263d(context, R$attr.colorSurface, C1733g.class.getCanonicalName());
        C10427h c10427h = new C10427h(context, null, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar);
        this.f7998L0 = c10427h;
        c10427h.m63992Q(context);
        this.f7998L0.m64002b0(ColorStateList.valueOf(iM60263d));
        this.f7998L0.m64001a0(C9603h0.m59913v(dialog.getWindow().getDecorView()));
        return dialog;
    }

    /* renamed from: Z1 */
    public final void m10338Z1(Window window) {
        if (this.f8000N0) {
            return;
        }
        View viewFindViewById = m4422n1().findViewById(R$id.fullscreen_header);
        C1774e.m10680a(window, true, C1788s.m10783d(viewFindViewById), null);
        C9603h0.m59837C0(viewFindViewById, new c(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingTop()));
        this.f8000N0 = true;
    }

    /* renamed from: b2 */
    public String m10339b2() {
        return m10333a2().mo10230b(m4426p());
    }

    /* renamed from: d2 */
    public final S m10340d2() {
        return m10333a2().mo10231i0();
    }

    /* renamed from: e2 */
    public final int m10341e2(Context context) {
        int i10 = this.f8005w0;
        return i10 != 0 ? i10 : m10333a2().mo10227G(context);
    }

    /* renamed from: f2 */
    public final void m10342f2(Context context) {
        this.f7997K0.setTag(f7986Q0);
        this.f7997K0.setImageDrawable(m10332Y1(context));
        this.f7997K0.setChecked(this.f7991E0 != 0);
        C9603h0.m59902p0(this.f7997K0, null);
        m10345l2(this.f7997K0);
        this.f7997K0.setOnClickListener(new e());
    }

    /* renamed from: j2 */
    public final void m10343j2() {
        int iM10341e2 = m10341e2(m4419m1());
        this.f7987A0 = C1732f.m10310U1(m10333a2(), iM10341e2, this.f8008z0);
        this.f8007y0 = this.f7997K0.isChecked() ? C1735i.m10349E1(m10333a2(), iM10341e2, this.f8008z0) : this.f7987A0;
        m10344k2();
        AbstractC0735a0 abstractC0735a0M4585o = m4423o().m4585o();
        abstractC0735a0M4585o.m4669r(R$id.mtrl_calendar_frame, this.f8007y0);
        abstractC0735a0M4585o.mo4649j();
        this.f8007y0.mo10311C1(new d());
    }

    /* renamed from: k2 */
    public final void m10344k2() {
        String strM10339b2 = m10339b2();
        this.f7996J0.setContentDescription(String.format(m4366Q(R$string.mtrl_picker_announce_current_selection), strM10339b2));
        this.f7996J0.setText(strM10339b2);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c, androidx.fragment.app.Fragment
    /* renamed from: l0 */
    public final void mo4415l0(Bundle bundle) {
        super.mo4415l0(bundle);
        if (bundle == null) {
            bundle = m4420n();
        }
        this.f8005w0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f8006x0 = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f8008z0 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f7988B0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f7989C0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f7991E0 = bundle.getInt("INPUT_MODE_KEY");
        this.f7992F0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f7993G0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f7994H0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f7995I0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
    }

    /* renamed from: l2 */
    public final void m10345l2(CheckableImageButton checkableImageButton) {
        this.f7997K0.setContentDescription(this.f7997K0.isChecked() ? checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f8003u0.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f8004v0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) m4370S();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: p0 */
    public final View mo4427p0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f7990D0 ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.f7990D0) {
            viewInflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(m10334c2(context), -2));
        } else {
            viewInflate.findViewById(R$id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(m10334c2(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.f7996J0 = textView;
        C9603h0.m59906r0(textView, 1);
        this.f7997K0 = (CheckableImageButton) viewInflate.findViewById(R$id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.mtrl_picker_title_text);
        CharSequence charSequence = this.f7989C0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f7988B0);
        }
        m10342f2(context);
        this.f7999M0 = (Button) viewInflate.findViewById(R$id.confirm_button);
        if (m10333a2().mo10228J()) {
            this.f7999M0.setEnabled(true);
        } else {
            this.f7999M0.setEnabled(false);
        }
        this.f7999M0.setTag(f7984O0);
        CharSequence charSequence2 = this.f7993G0;
        if (charSequence2 != null) {
            this.f7999M0.setText(charSequence2);
        } else {
            int i10 = this.f7992F0;
            if (i10 != 0) {
                this.f7999M0.setText(i10);
            }
        }
        this.f7999M0.setOnClickListener(new a());
        Button button = (Button) viewInflate.findViewById(R$id.cancel_button);
        button.setTag(f7985P0);
        CharSequence charSequence3 = this.f7995I0;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i11 = this.f7994H0;
            if (i11 != 0) {
                button.setText(i11);
            }
        }
        button.setOnClickListener(new b());
        return viewInflate;
    }
}
