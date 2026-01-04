package p304g0;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hms.network.embedded.C5914f2;
import com.huawei.hms.network.embedded.C5976k;
import com.huawei.hms.network.embedded.C6051p9;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p024b0.C1085a;
import p304g0.InterfaceC9835o;

/* renamed from: g0.l */
/* loaded from: classes.dex */
public class C9832l {

    /* renamed from: a */
    public final AccessibilityNodeInfo f48271a;

    /* renamed from: b */
    public int f48272b = -1;

    /* renamed from: c */
    public int f48273c = -1;

    /* renamed from: g0.l$b */
    public static class b {

        /* renamed from: a */
        public final Object f48321a;

        public b(Object obj) {
            this.f48321a = obj;
        }

        /* renamed from: a */
        public static b m61125a(int i10, int i11, boolean z10) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10));
        }

        /* renamed from: b */
        public static b m61126b(int i10, int i11, boolean z10, int i12) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10, i12));
        }
    }

    /* renamed from: g0.l$c */
    public static class c {

        /* renamed from: a */
        public final Object f48322a;

        public c(Object obj) {
            this.f48322a = obj;
        }

        /* renamed from: a */
        public static c m61127a(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
            return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10, z11));
        }
    }

    /* renamed from: g0.l$d */
    public static class d {

        /* renamed from: a */
        public final Object f48323a;

        public d(Object obj) {
            this.f48323a = obj;
        }

        /* renamed from: a */
        public static d m61128a(int i10, float f10, float f11, float f12) {
            return new d(AccessibilityNodeInfo.RangeInfo.obtain(i10, f10, f11, f12));
        }
    }

    public C9832l(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f48271a = accessibilityNodeInfo;
    }

    /* renamed from: A0 */
    public static C9832l m61042A0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C9832l(accessibilityNodeInfo);
    }

    /* renamed from: I */
    public static C9832l m61043I() {
        return m61042A0(AccessibilityNodeInfo.obtain());
    }

    /* renamed from: J */
    public static C9832l m61044J(View view) {
        return m61042A0(AccessibilityNodeInfo.obtain(view));
    }

    /* renamed from: K */
    public static C9832l m61045K(C9832l c9832l) {
        return m61042A0(AccessibilityNodeInfo.obtain(c9832l.f48271a));
    }

    /* renamed from: h */
    public static String m61046h(int i10) {
        if (i10 == 1) {
            return "ACTION_FOCUS";
        }
        if (i10 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i10) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case C5914f2.f26733f /* 32768 */:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /* 131072 */:
                return "ACTION_SET_SELECTION";
            case C6051p9.f27764p /* 262144 */:
                return "ACTION_EXPAND";
            case ARImageMetadata.LENS_APERTURE /* 524288 */:
                return "ACTION_COLLAPSE";
            case C5976k.e.f27211b /* 2097152 */:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i10) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i10) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i10) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    /* renamed from: n */
    public static ClickableSpan[] m61047n(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    /* renamed from: A */
    public boolean m61048A() {
        return this.f48271a.isFocusable();
    }

    /* renamed from: B */
    public boolean m61049B() {
        return this.f48271a.isFocused();
    }

    /* renamed from: C */
    public boolean m61050C() {
        return this.f48271a.isLongClickable();
    }

    /* renamed from: D */
    public boolean m61051D() {
        return this.f48271a.isPassword();
    }

    /* renamed from: E */
    public boolean m61052E() {
        return this.f48271a.isScrollable();
    }

    /* renamed from: F */
    public boolean m61053F() {
        return this.f48271a.isSelected();
    }

    /* renamed from: G */
    public boolean m61054G() {
        return this.f48271a.isShowingHintText();
    }

    /* renamed from: H */
    public boolean m61055H() {
        return this.f48271a.isVisibleToUser();
    }

    /* renamed from: L */
    public boolean m61056L(int i10, Bundle bundle) {
        return this.f48271a.performAction(i10, bundle);
    }

    /* renamed from: M */
    public void m61057M() {
        this.f48271a.recycle();
    }

    /* renamed from: N */
    public boolean m61058N(a aVar) {
        return this.f48271a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f48317a);
    }

    /* renamed from: O */
    public void m61059O(boolean z10) {
        this.f48271a.setAccessibilityFocused(z10);
    }

    @Deprecated
    /* renamed from: P */
    public void m61060P(Rect rect) {
        this.f48271a.setBoundsInParent(rect);
    }

    /* renamed from: Q */
    public void m61061Q(Rect rect) {
        this.f48271a.setBoundsInScreen(rect);
    }

    /* renamed from: R */
    public void m61062R(boolean z10) {
        this.f48271a.setCanOpenPopup(z10);
    }

    /* renamed from: S */
    public void m61063S(boolean z10) {
        this.f48271a.setCheckable(z10);
    }

    /* renamed from: T */
    public void m61064T(boolean z10) {
        this.f48271a.setChecked(z10);
    }

    /* renamed from: U */
    public void m61065U(CharSequence charSequence) {
        this.f48271a.setClassName(charSequence);
    }

    /* renamed from: V */
    public void m61066V(boolean z10) {
        this.f48271a.setClickable(z10);
    }

    /* renamed from: W */
    public void m61067W(Object obj) {
        this.f48271a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f48321a);
    }

    /* renamed from: X */
    public void m61068X(Object obj) {
        this.f48271a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f48322a);
    }

    /* renamed from: Y */
    public void m61069Y(CharSequence charSequence) {
        this.f48271a.setContentDescription(charSequence);
    }

    /* renamed from: Z */
    public void m61070Z(boolean z10) {
        this.f48271a.setContentInvalid(z10);
    }

    /* renamed from: a */
    public void m61071a(int i10) {
        this.f48271a.addAction(i10);
    }

    /* renamed from: a0 */
    public void m61072a0(boolean z10) {
        this.f48271a.setDismissable(z10);
    }

    /* renamed from: b */
    public void m61073b(a aVar) {
        this.f48271a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f48317a);
    }

    /* renamed from: b0 */
    public void m61074b0(boolean z10) {
        this.f48271a.setEnabled(z10);
    }

    /* renamed from: c */
    public void m61075c(View view) {
        this.f48271a.addChild(view);
    }

    /* renamed from: c0 */
    public void m61076c0(CharSequence charSequence) {
        this.f48271a.setError(charSequence);
    }

    /* renamed from: d */
    public void m61077d(View view, int i10) {
        this.f48271a.addChild(view, i10);
    }

    /* renamed from: d0 */
    public void m61078d0(boolean z10) {
        this.f48271a.setFocusable(z10);
    }

    /* renamed from: e */
    public void m61079e(CharSequence charSequence, View view) {
    }

    /* renamed from: e0 */
    public void m61080e0(boolean z10) {
        this.f48271a.setFocused(z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C9832l)) {
            return false;
        }
        C9832l c9832l = (C9832l) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f48271a;
        if (accessibilityNodeInfo == null) {
            if (c9832l.f48271a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(c9832l.f48271a)) {
            return false;
        }
        return this.f48273c == c9832l.f48273c && this.f48272b == c9832l.f48272b;
    }

    /* renamed from: f */
    public final List<Integer> m61081f(String str) {
        ArrayList<Integer> integerArrayList = this.f48271a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f48271a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    /* renamed from: f0 */
    public void m61082f0(boolean z10) {
        this.f48271a.setHeading(z10);
    }

    /* renamed from: g */
    public List<a> m61083g() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f48271a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(actionList.get(i10)));
        }
        return arrayList;
    }

    /* renamed from: g0 */
    public void m61084g0(CharSequence charSequence) {
        this.f48271a.setHintText(charSequence);
    }

    /* renamed from: h0 */
    public void m61085h0(View view) {
        this.f48271a.setLabelFor(view);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f48271a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    @Deprecated
    /* renamed from: i */
    public int m61086i() {
        return this.f48271a.getActions();
    }

    /* renamed from: i0 */
    public void m61087i0(int i10) {
        this.f48271a.setMaxTextLength(i10);
    }

    @Deprecated
    /* renamed from: j */
    public void m61088j(Rect rect) {
        this.f48271a.getBoundsInParent(rect);
    }

    /* renamed from: j0 */
    public void m61089j0(CharSequence charSequence) {
        this.f48271a.setPackageName(charSequence);
    }

    /* renamed from: k */
    public void m61090k(Rect rect) {
        this.f48271a.getBoundsInScreen(rect);
    }

    /* renamed from: k0 */
    public void m61091k0(CharSequence charSequence) {
        this.f48271a.setPaneTitle(charSequence);
    }

    /* renamed from: l */
    public int m61092l() {
        return this.f48271a.getChildCount();
    }

    /* renamed from: l0 */
    public void m61093l0(View view) {
        this.f48272b = -1;
        this.f48271a.setParent(view);
    }

    /* renamed from: m */
    public CharSequence m61094m() {
        return this.f48271a.getClassName();
    }

    /* renamed from: m0 */
    public void m61095m0(View view, int i10) {
        this.f48272b = i10;
        this.f48271a.setParent(view, i10);
    }

    /* renamed from: n0 */
    public void m61096n0(d dVar) {
        this.f48271a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) dVar.f48323a);
    }

    /* renamed from: o */
    public CharSequence m61097o() {
        return this.f48271a.getContentDescription();
    }

    /* renamed from: o0 */
    public void m61098o0(CharSequence charSequence) {
        this.f48271a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    /* renamed from: p */
    public Bundle m61099p() {
        return this.f48271a.getExtras();
    }

    /* renamed from: p0 */
    public void m61100p0(boolean z10) {
        this.f48271a.setScreenReaderFocusable(z10);
    }

    /* renamed from: q */
    public CharSequence m61101q() {
        return this.f48271a.getPackageName();
    }

    /* renamed from: q0 */
    public void m61102q0(boolean z10) {
        this.f48271a.setScrollable(z10);
    }

    /* renamed from: r */
    public CharSequence m61103r() {
        if (!m61109u()) {
            return this.f48271a.getText();
        }
        List<Integer> listM61081f = m61081f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> listM61081f2 = m61081f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> listM61081f3 = m61081f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> listM61081f4 = m61081f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f48271a.getText(), 0, this.f48271a.getText().length()));
        for (int i10 = 0; i10 < listM61081f.size(); i10++) {
            spannableString.setSpan(new C9821a(listM61081f4.get(i10).intValue(), this, m61099p().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), listM61081f.get(i10).intValue(), listM61081f2.get(i10).intValue(), listM61081f3.get(i10).intValue());
        }
        return spannableString;
    }

    /* renamed from: r0 */
    public void m61104r0(boolean z10) {
        this.f48271a.setSelected(z10);
    }

    /* renamed from: s */
    public String m61105s() {
        return C1085a.m6463c() ? this.f48271a.getUniqueId() : this.f48271a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    /* renamed from: s0 */
    public void m61106s0(boolean z10) {
        this.f48271a.setShowingHintText(z10);
    }

    /* renamed from: t */
    public String m61107t() {
        return this.f48271a.getViewIdResourceName();
    }

    /* renamed from: t0 */
    public void m61108t0(View view) {
        this.f48273c = -1;
        this.f48271a.setSource(view);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        Rect rect = new Rect();
        m61088j(rect);
        sb2.append("; boundsInParent: " + rect);
        m61090k(rect);
        sb2.append("; boundsInScreen: " + rect);
        sb2.append("; packageName: ");
        sb2.append(m61101q());
        sb2.append("; className: ");
        sb2.append(m61094m());
        sb2.append("; text: ");
        sb2.append(m61103r());
        sb2.append("; contentDescription: ");
        sb2.append(m61097o());
        sb2.append("; viewId: ");
        sb2.append(m61107t());
        sb2.append("; uniqueId: ");
        sb2.append(m61105s());
        sb2.append("; checkable: ");
        sb2.append(m61113w());
        sb2.append("; checked: ");
        sb2.append(m61115x());
        sb2.append("; focusable: ");
        sb2.append(m61048A());
        sb2.append("; focused: ");
        sb2.append(m61049B());
        sb2.append("; selected: ");
        sb2.append(m61053F());
        sb2.append("; clickable: ");
        sb2.append(m61117y());
        sb2.append("; longClickable: ");
        sb2.append(m61050C());
        sb2.append("; enabled: ");
        sb2.append(m61119z());
        sb2.append("; password: ");
        sb2.append(m61051D());
        sb2.append("; scrollable: " + m61052E());
        sb2.append("; [");
        List<a> listM61083g = m61083g();
        for (int i10 = 0; i10 < listM61083g.size(); i10++) {
            a aVar = listM61083g.get(i10);
            String strM61046h = m61046h(aVar.m61122b());
            if (strM61046h.equals("ACTION_UNKNOWN") && aVar.m61123c() != null) {
                strM61046h = aVar.m61123c().toString();
            }
            sb2.append(strM61046h);
            if (i10 != listM61083g.size() - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* renamed from: u */
    public final boolean m61109u() {
        return !m61081f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    /* renamed from: u0 */
    public void m61110u0(View view, int i10) {
        this.f48273c = i10;
        this.f48271a.setSource(view, i10);
    }

    /* renamed from: v */
    public boolean m61111v() {
        return this.f48271a.isAccessibilityFocused();
    }

    /* renamed from: v0 */
    public void m61112v0(CharSequence charSequence) {
        if (C1085a.m6462b()) {
            this.f48271a.setStateDescription(charSequence);
        } else {
            this.f48271a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    /* renamed from: w */
    public boolean m61113w() {
        return this.f48271a.isCheckable();
    }

    /* renamed from: w0 */
    public void m61114w0(CharSequence charSequence) {
        this.f48271a.setText(charSequence);
    }

    /* renamed from: x */
    public boolean m61115x() {
        return this.f48271a.isChecked();
    }

    /* renamed from: x0 */
    public void m61116x0(View view) {
        this.f48271a.setTraversalAfter(view);
    }

    /* renamed from: y */
    public boolean m61117y() {
        return this.f48271a.isClickable();
    }

    /* renamed from: y0 */
    public void m61118y0(boolean z10) {
        this.f48271a.setVisibleToUser(z10);
    }

    /* renamed from: z */
    public boolean m61119z() {
        return this.f48271a.isEnabled();
    }

    /* renamed from: z0 */
    public AccessibilityNodeInfo m61120z0() {
        return this.f48271a;
    }

    /* renamed from: g0.l$a */
    public static class a {

        /* renamed from: A */
        public static final a f48274A;

        /* renamed from: B */
        public static final a f48275B;

        /* renamed from: C */
        public static final a f48276C;

        /* renamed from: D */
        public static final a f48277D;

        /* renamed from: E */
        public static final a f48278E;

        /* renamed from: F */
        public static final a f48279F;

        /* renamed from: G */
        public static final a f48280G;

        /* renamed from: H */
        public static final a f48281H;

        /* renamed from: I */
        public static final a f48282I;

        /* renamed from: J */
        public static final a f48283J;

        /* renamed from: K */
        public static final a f48284K;

        /* renamed from: L */
        public static final a f48285L;

        /* renamed from: M */
        public static final a f48286M;

        /* renamed from: N */
        public static final a f48287N;

        /* renamed from: O */
        public static final a f48288O;

        /* renamed from: P */
        public static final a f48289P;

        /* renamed from: Q */
        public static final a f48290Q;

        /* renamed from: R */
        public static final a f48291R;

        /* renamed from: S */
        public static final a f48292S;

        /* renamed from: T */
        public static final a f48293T;

        /* renamed from: U */
        public static final a f48294U;

        /* renamed from: e */
        public static final a f48295e = new a(1, null);

        /* renamed from: f */
        public static final a f48296f = new a(2, null);

        /* renamed from: g */
        public static final a f48297g = new a(4, null);

        /* renamed from: h */
        public static final a f48298h = new a(8, null);

        /* renamed from: i */
        public static final a f48299i = new a(16, null);

        /* renamed from: j */
        public static final a f48300j = new a(32, null);

        /* renamed from: k */
        public static final a f48301k = new a(64, null);

        /* renamed from: l */
        public static final a f48302l = new a(128, null);

        /* renamed from: m */
        public static final a f48303m = new a(256, (CharSequence) null, (Class<? extends InterfaceC9835o.a>) InterfaceC9835o.b.class);

        /* renamed from: n */
        public static final a f48304n = new a(512, (CharSequence) null, (Class<? extends InterfaceC9835o.a>) InterfaceC9835o.b.class);

        /* renamed from: o */
        public static final a f48305o = new a(1024, (CharSequence) null, (Class<? extends InterfaceC9835o.a>) InterfaceC9835o.c.class);

        /* renamed from: p */
        public static final a f48306p = new a(2048, (CharSequence) null, (Class<? extends InterfaceC9835o.a>) InterfaceC9835o.c.class);

        /* renamed from: q */
        public static final a f48307q = new a(4096, null);

        /* renamed from: r */
        public static final a f48308r = new a(8192, null);

        /* renamed from: s */
        public static final a f48309s = new a(16384, null);

        /* renamed from: t */
        public static final a f48310t = new a(C5914f2.f26733f, null);

        /* renamed from: u */
        public static final a f48311u = new a(65536, null);

        /* renamed from: v */
        public static final a f48312v = new a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, (CharSequence) null, (Class<? extends InterfaceC9835o.a>) InterfaceC9835o.g.class);

        /* renamed from: w */
        public static final a f48313w = new a(C6051p9.f27764p, null);

        /* renamed from: x */
        public static final a f48314x = new a(ARImageMetadata.LENS_APERTURE, null);

        /* renamed from: y */
        public static final a f48315y = new a(ARImageMetadata.SHADING_MODE, null);

        /* renamed from: z */
        public static final a f48316z = new a(C5976k.e.f27211b, (CharSequence) null, (Class<? extends InterfaceC9835o.a>) InterfaceC9835o.h.class);

        /* renamed from: a */
        public final Object f48317a;

        /* renamed from: b */
        public final int f48318b;

        /* renamed from: c */
        public final Class<? extends InterfaceC9835o.a> f48319c;

        /* renamed from: d */
        public final InterfaceC9835o f48320d;

        static {
            int i10 = Build.VERSION.SDK_INT;
            f48274A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            f48275B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, InterfaceC9835o.e.class);
            f48276C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            f48277D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            f48278E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            f48279F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            f48280G = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, R.id.accessibilityActionPageUp, null, null, null);
            f48281H = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, R.id.accessibilityActionPageDown, null, null, null);
            f48282I = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, R.id.accessibilityActionPageLeft, null, null, null);
            f48283J = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, R.id.accessibilityActionPageRight, null, null, null);
            f48284K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            f48285L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, InterfaceC9835o.f.class);
            f48286M = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, InterfaceC9835o.d.class);
            f48287N = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);
            f48288O = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);
            f48289P = new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            f48290Q = new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            f48291R = new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            f48292S = new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            f48293T = new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            f48294U = new a(i10 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        }

        public a(int i10, CharSequence charSequence) {
            this(null, i10, charSequence, null, null);
        }

        /* renamed from: a */
        public a m61121a(CharSequence charSequence, InterfaceC9835o interfaceC9835o) {
            return new a(null, this.f48318b, charSequence, interfaceC9835o, this.f48319c);
        }

        /* renamed from: b */
        public int m61122b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f48317a).getId();
        }

        /* renamed from: c */
        public CharSequence m61123c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f48317a).getLabel();
        }

        /* renamed from: d */
        public boolean m61124d(View view, Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            if (this.f48320d == null) {
                return false;
            }
            Class<? extends InterfaceC9835o.a> cls = this.f48319c;
            InterfaceC9835o.a aVar = null;
            if (cls != null) {
                try {
                    InterfaceC9835o.a aVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        aVarNewInstance.m61143a(bundle);
                        aVar = aVarNewInstance;
                    } catch (Exception e10) {
                        e = e10;
                        aVar = aVarNewInstance;
                        Class<? extends InterfaceC9835o.a> cls2 = this.f48319c;
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                        return this.f48320d.mo4167a(view, aVar);
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            }
            return this.f48320d.mo4167a(view, aVar);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f48317a;
            return obj2 == null ? aVar.f48317a == null : obj2.equals(aVar.f48317a);
        }

        public int hashCode() {
            Object obj = this.f48317a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public a(int i10, CharSequence charSequence, InterfaceC9835o interfaceC9835o) {
            this(null, i10, charSequence, interfaceC9835o, null);
        }

        public a(int i10, CharSequence charSequence, Class<? extends InterfaceC9835o.a> cls) {
            this(null, i10, charSequence, null, cls);
        }

        public a(Object obj) {
            this(obj, 0, null, null, null);
        }

        public a(Object obj, int i10, CharSequence charSequence, InterfaceC9835o interfaceC9835o, Class<? extends InterfaceC9835o.a> cls) {
            this.f48318b = i10;
            this.f48320d = interfaceC9835o;
            if (obj == null) {
                this.f48317a = new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence);
            } else {
                this.f48317a = obj;
            }
            this.f48319c = cls;
        }
    }
}
