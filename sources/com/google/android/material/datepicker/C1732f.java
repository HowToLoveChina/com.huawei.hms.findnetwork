package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.C0876o;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;
import p243e0.C9369d;
import p273f0.C9582a;
import p273f0.C9603h0;
import p304g0.C9832l;

/* renamed from: com.google.android.material.datepicker.f */
/* loaded from: classes.dex */
public final class C1732f<S> extends AbstractC1739m<S> {

    /* renamed from: n0 */
    public static final Object f7949n0 = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: o0 */
    public static final Object f7950o0 = "NAVIGATION_PREV_TAG";

    /* renamed from: p0 */
    public static final Object f7951p0 = "NAVIGATION_NEXT_TAG";

    /* renamed from: q0 */
    public static final Object f7952q0 = "SELECTOR_TOGGLE_TAG";

    /* renamed from: d0 */
    public int f7953d0;

    /* renamed from: e0 */
    public DateSelector<S> f7954e0;

    /* renamed from: f0 */
    public CalendarConstraints f7955f0;

    /* renamed from: g0 */
    public Month f7956g0;

    /* renamed from: h0 */
    public k f7957h0;

    /* renamed from: i0 */
    public C1728b f7958i0;

    /* renamed from: j0 */
    public RecyclerView f7959j0;

    /* renamed from: k0 */
    public RecyclerView f7960k0;

    /* renamed from: l0 */
    public View f7961l0;

    /* renamed from: m0 */
    public View f7962m0;

    /* renamed from: com.google.android.material.datepicker.f$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f7963a;

        public a(int i10) {
            this.f7963a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1732f.this.f7960k0.smoothScrollToPosition(this.f7963a);
        }
    }

    /* renamed from: com.google.android.material.datepicker.f$b */
    public class b extends C9582a {
        public b() {
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            c9832l.m61067W(null);
        }
    }

    /* renamed from: com.google.android.material.datepicker.f$c */
    public class c extends C1740n {

        /* renamed from: V */
        public final /* synthetic */ int f7966V;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, int i10, boolean z10, int i11) {
            super(context, i10, z10);
            this.f7966V = i11;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.C0856z c0856z, int[] iArr) {
            if (this.f7966V == 0) {
                iArr[0] = C1732f.this.f7960k0.getWidth();
                iArr[1] = C1732f.this.f7960k0.getWidth();
            } else {
                iArr[0] = C1732f.this.f7960k0.getHeight();
                iArr[1] = C1732f.this.f7960k0.getHeight();
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.f$d */
    public class d implements l {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.C1732f.l
        /* renamed from: a */
        public void mo10323a(long j10) {
            if (C1732f.this.f7955f0.m10209g().mo10216k(j10)) {
                C1732f.this.f7954e0.mo10232q0(j10);
                Iterator<AbstractC1738l<S>> it = C1732f.this.f8035c0.iterator();
                while (it.hasNext()) {
                    it.next().mo10347b(C1732f.this.f7954e0.mo10231i0());
                }
                C1732f.this.f7960k0.getAdapter().m5213j();
                if (C1732f.this.f7959j0 != null) {
                    C1732f.this.f7959j0.getAdapter().m5213j();
                }
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.f$e */
    public class e extends RecyclerView.AbstractC0845o {

        /* renamed from: h0 */
        public final Calendar f7969h0 = C1742p.m10385l();

        /* renamed from: i0 */
        public final Calendar f7970i0 = C1742p.m10385l();

        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
            if ((recyclerView.getAdapter() instanceof C1743q) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                C1743q c1743q = (C1743q) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (C9369d<Long, Long> c9369d : C1732f.this.f7954e0.mo10233u()) {
                    Long l10 = c9369d.f46769a;
                    if (l10 != null && c9369d.f46770b != null) {
                        this.f7969h0.setTimeInMillis(l10.longValue());
                        this.f7970i0.setTimeInMillis(c9369d.f46770b.longValue());
                        int iM10391F = c1743q.m10391F(this.f7969h0.get(1));
                        int iM10391F2 = c1743q.m10391F(this.f7970i0.get(1));
                        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iM10391F);
                        View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(iM10391F2);
                        int spanCount = iM10391F / gridLayoutManager.getSpanCount();
                        int spanCount2 = iM10391F2 / gridLayoutManager.getSpanCount();
                        int i10 = spanCount;
                        while (i10 <= spanCount2) {
                            if (gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i10) != null) {
                                canvas.drawRect(i10 == spanCount ? viewFindViewByPosition.getLeft() + (viewFindViewByPosition.getWidth() / 2) : 0, r9.getTop() + C1732f.this.f7958i0.f7930d.m10279c(), i10 == spanCount2 ? viewFindViewByPosition2.getLeft() + (viewFindViewByPosition2.getWidth() / 2) : recyclerView.getWidth(), r9.getBottom() - C1732f.this.f7958i0.f7930d.m10278b(), C1732f.this.f7958i0.f7934h);
                            }
                            i10++;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.f$f */
    public class f extends C9582a {
        public f() {
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            c9832l.m61084g0(C1732f.this.f7962m0.getVisibility() == 0 ? C1732f.this.m4366Q(R$string.mtrl_picker_toggle_to_year_selection) : C1732f.this.m4366Q(R$string.mtrl_picker_toggle_to_day_selection));
        }
    }

    /* renamed from: com.google.android.material.datepicker.f$g */
    public class g extends RecyclerView.AbstractC0850t {

        /* renamed from: c0 */
        public final /* synthetic */ C1737k f7973c0;

        /* renamed from: d0 */
        public final /* synthetic */ MaterialButton f7974d0;

        public g(C1737k c1737k, MaterialButton materialButton) {
            this.f7973c0 = c1737k;
            this.f7974d0 = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            if (i10 == 0) {
                recyclerView.announceForAccessibility(this.f7974d0.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            int iFindFirstVisibleItemPosition = i10 < 0 ? C1732f.this.m10318T1().findFirstVisibleItemPosition() : C1732f.this.m10318T1().findLastVisibleItemPosition();
            C1732f.this.f7956g0 = this.f7973c0.m10365E(iFindFirstVisibleItemPosition);
            this.f7974d0.setText(this.f7973c0.m10366F(iFindFirstVisibleItemPosition));
        }
    }

    /* renamed from: com.google.android.material.datepicker.f$h */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1732f.this.m10322Y1();
        }
    }

    /* renamed from: com.google.android.material.datepicker.f$i */
    public class i implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ C1737k f7977a;

        public i(C1737k c1737k) {
            this.f7977a = c1737k;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iFindFirstVisibleItemPosition = C1732f.this.m10318T1().findFirstVisibleItemPosition() + 1;
            if (iFindFirstVisibleItemPosition < C1732f.this.f7960k0.getAdapter().mo721e()) {
                C1732f.this.m10320W1(this.f7977a.m10365E(iFindFirstVisibleItemPosition));
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.f$j */
    public class j implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ C1737k f7979a;

        public j(C1737k c1737k) {
            this.f7979a = c1737k;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iFindLastVisibleItemPosition = C1732f.this.m10318T1().findLastVisibleItemPosition() - 1;
            if (iFindLastVisibleItemPosition >= 0) {
                C1732f.this.m10320W1(this.f7979a.m10365E(iFindLastVisibleItemPosition));
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.f$k */
    public enum k {
        DAY,
        YEAR
    }

    /* renamed from: com.google.android.material.datepicker.f$l */
    public interface l {
        /* renamed from: a */
        void mo10323a(long j10);
    }

    /* renamed from: R1 */
    public static int m10308R1(Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height);
    }

    /* renamed from: S1 */
    public static int m10309S1(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height);
        int i10 = C1736j.f8021f;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding);
    }

    /* renamed from: U1 */
    public static <T> C1732f<T> m10310U1(DateSelector<T> dateSelector, int i10, CalendarConstraints calendarConstraints) {
        C1732f<T> c1732f = new C1732f<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.m10212j());
        c1732f.m4437s1(bundle);
        return c1732f;
    }

    @Override // com.google.android.material.datepicker.AbstractC1739m
    /* renamed from: C1 */
    public boolean mo10311C1(AbstractC1738l<S> abstractC1738l) {
        return super.mo10311C1(abstractC1738l);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: H0 */
    public void mo4350H0(Bundle bundle) {
        super.mo4350H0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f7953d0);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f7954e0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f7955f0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f7956g0);
    }

    /* renamed from: L1 */
    public final void m10312L1(View view, C1737k c1737k) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.month_navigation_fragment_toggle);
        materialButton.setTag(f7952q0);
        C9603h0.m59902p0(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.month_navigation_previous);
        materialButton2.setTag(f7950o0);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R$id.month_navigation_next);
        materialButton3.setTag(f7951p0);
        this.f7961l0 = view.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f7962m0 = view.findViewById(R$id.mtrl_calendar_day_selector_frame);
        m10321X1(k.DAY);
        materialButton.setText(this.f7956g0.m10251r());
        this.f7960k0.addOnScrollListener(new g(c1737k, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(c1737k));
        materialButton2.setOnClickListener(new j(c1737k));
    }

    /* renamed from: M1 */
    public final RecyclerView.AbstractC0845o m10313M1() {
        return new e();
    }

    /* renamed from: N1 */
    public CalendarConstraints m10314N1() {
        return this.f7955f0;
    }

    /* renamed from: O1 */
    public C1728b m10315O1() {
        return this.f7958i0;
    }

    /* renamed from: P1 */
    public Month m10316P1() {
        return this.f7956g0;
    }

    /* renamed from: Q1 */
    public DateSelector<S> m10317Q1() {
        return this.f7954e0;
    }

    /* renamed from: T1 */
    public LinearLayoutManager m10318T1() {
        return (LinearLayoutManager) this.f7960k0.getLayoutManager();
    }

    /* renamed from: V1 */
    public final void m10319V1(int i10) {
        this.f7960k0.post(new a(i10));
    }

    /* renamed from: W1 */
    public void m10320W1(Month month) {
        C1737k c1737k = (C1737k) this.f7960k0.getAdapter();
        int iM10367G = c1737k.m10367G(month);
        int iM10367G2 = iM10367G - c1737k.m10367G(this.f7956g0);
        boolean z10 = Math.abs(iM10367G2) > 3;
        boolean z11 = iM10367G2 > 0;
        this.f7956g0 = month;
        if (z10 && z11) {
            this.f7960k0.scrollToPosition(iM10367G - 3);
            m10319V1(iM10367G);
        } else if (!z10) {
            m10319V1(iM10367G);
        } else {
            this.f7960k0.scrollToPosition(iM10367G + 3);
            m10319V1(iM10367G);
        }
    }

    /* renamed from: X1 */
    public void m10321X1(k kVar) {
        this.f7957h0 = kVar;
        if (kVar == k.YEAR) {
            this.f7959j0.getLayoutManager().scrollToPosition(((C1743q) this.f7959j0.getAdapter()).m10391F(this.f7956g0.f7899c));
            this.f7961l0.setVisibility(0);
            this.f7962m0.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.f7961l0.setVisibility(8);
            this.f7962m0.setVisibility(0);
            m10320W1(this.f7956g0);
        }
    }

    /* renamed from: Y1 */
    public void m10322Y1() {
        k kVar = this.f7957h0;
        k kVar2 = k.YEAR;
        if (kVar == kVar2) {
            m10321X1(k.DAY);
        } else if (kVar == k.DAY) {
            m10321X1(kVar2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: l0 */
    public void mo4415l0(Bundle bundle) {
        super.mo4415l0(bundle);
        if (bundle == null) {
            bundle = m4420n();
        }
        this.f7953d0 = bundle.getInt("THEME_RES_ID_KEY");
        this.f7954e0 = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f7955f0 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f7956g0 = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: p0 */
    public View mo4427p0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws IllegalStateException, Resources.NotFoundException {
        int i10;
        int i11;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(m4426p(), this.f7953d0);
        this.f7958i0 = new C1728b(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month monthM10213l = this.f7955f0.m10213l();
        if (C1733g.m10335g2(contextThemeWrapper)) {
            i10 = R$layout.mtrl_calendar_vertical;
            i11 = 1;
        } else {
            i10 = R$layout.mtrl_calendar_horizontal;
            i11 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i10, viewGroup, false);
        viewInflate.setMinimumHeight(m10309S1(m4419m1()));
        GridView gridView = (GridView) viewInflate.findViewById(R$id.mtrl_calendar_days_of_week);
        C9603h0.m59902p0(gridView, new b());
        gridView.setAdapter((ListAdapter) new C1731e());
        gridView.setNumColumns(monthM10213l.f7900d);
        gridView.setEnabled(false);
        this.f7960k0 = (RecyclerView) viewInflate.findViewById(R$id.mtrl_calendar_months);
        this.f7960k0.setLayoutManager(new c(m4426p(), i11, false, i11));
        this.f7960k0.setTag(f7949n0);
        C1737k c1737k = new C1737k(contextThemeWrapper, this.f7954e0, this.f7955f0, new d());
        this.f7960k0.setAdapter(c1737k);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f7959j0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f7959j0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f7959j0.setAdapter(new C1743q(this));
            this.f7959j0.addItemDecoration(m10313M1());
        }
        if (viewInflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            m10312L1(viewInflate, c1737k);
        }
        if (!C1733g.m10335g2(contextThemeWrapper)) {
            new C0876o().attachToRecyclerView(this.f7960k0);
        }
        this.f7960k0.scrollToPosition(c1737k.m10367G(this.f7956g0));
        return viewInflate;
    }
}
