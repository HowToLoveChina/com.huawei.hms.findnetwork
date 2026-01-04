package com.huawei.uikit.hwcolumnsystem.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes7.dex */
public class HwColumnSystem {

    /* renamed from: A */
    private static final String f41790A = "^c(\\d+)m(\\d+)g(\\d+)";
    public static final int BOTTOM_SHEET_TYPE = 19;
    public static final int BUBBLE_TYPE = 4;
    public static final int CARD_DOUBLE_BUTTON_TYPE = 18;
    public static final int CARD_SINGLE_BUTTON_TYPE = 17;
    public static final int CARD_TYPE = 3;
    public static final int CONTENT_TYPE = 0;
    public static final int CUSTOM_TYPE = 11;
    public static final int DEFAULT_TYPE = -1;
    public static final int DIALOG_TYPE = 12;
    public static final int DOUBLE_BUTTON_TYPE = 2;
    protected static final int FULL_SCREEN_COLUMN = -2;
    protected static final boolean IS_DEBUG = false;
    public static final int LARGE_BOTTOMTAB_TYPE = 9;
    public static final int LARGE_DIALOG_TYPE = 20;
    public static final int LARGE_TOOLBAR_TYPE = 7;
    public static final int MENU_TYPE = 10;
    public static final int SINGLE_BUTTON_TYPE = 1;
    public static final int SMALL_BOTTOMTAB_TYPE = 8;
    public static final int SMALL_DIALOG_TYPE = 21;
    public static final int SMALL_TOOLBAR_TYPE = 6;
    public static final int TOAST_TYPE = 5;

    /* renamed from: p */
    private static final String f41791p = "HwColumnSystem";

    /* renamed from: q */
    private static final int f41792q = 2;

    /* renamed from: r */
    private static final int f41793r = 4;

    /* renamed from: s */
    private static final int f41794s = -1;

    /* renamed from: t */
    private static final int f41795t = 3;

    /* renamed from: u */
    private static final int f41796u = 3;

    /* renamed from: v */
    private static final float f41797v = 0.5f;

    /* renamed from: w */
    private static final float f41798w = 1.0E-6f;

    /* renamed from: x */
    private static final int f41799x = 1;

    /* renamed from: y */
    private static final int f41800y = 2;

    /* renamed from: z */
    private static final int f41801z = 3;

    /* renamed from: a */
    private List<Integer[]> f41802a;

    /* renamed from: b */
    private int f41803b;

    /* renamed from: c */
    private bqmxo f41804c;

    /* renamed from: d */
    private int f41805d;

    /* renamed from: e */
    private int f41806e;

    /* renamed from: f */
    private float f41807f;

    /* renamed from: g */
    private com.huawei.uikit.hwcolumnsystem.widget.bzrwd f41808g;

    /* renamed from: h */
    private int f41809h;

    /* renamed from: i */
    private akxao f41810i;

    /* renamed from: j */
    private Context f41811j;

    /* renamed from: k */
    private boolean f41812k;

    /* renamed from: l */
    private String[] f41813l;

    /* renamed from: m */
    private boolean f41814m;

    /* renamed from: n */
    private boolean f41815n;

    /* renamed from: o */
    private int f41816o;

    public class bzrwd implements Comparator<Integer[]> {
        public bzrwd() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Integer[] numArr, Integer[] numArr2) {
            return Integer.compare(numArr[0].intValue(), numArr2[0].intValue());
        }
    }

    public HwColumnSystem(Context context) {
        this(context, -1);
    }

    /* renamed from: a */
    private int m54127a(int i10, float f10) {
        return (int) ((i10 * f10) + f41797v);
    }

    /* renamed from: b */
    private int m54133b(int i10, float f10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (getColumnType() == 19) {
            return i10;
        }
        Rect displaySafeInsets = HwDisplaySizeUtil.getDisplaySafeInsets();
        if (this.f41814m || this.f41816o != i10) {
            this.f41815n = m54136b(this.f41811j);
            this.f41816o = i10;
        }
        return this.f41815n ? (displaySafeInsets.left > 0 || displaySafeInsets.right > 0) ? (m54127a(this.f41811j.getResources().getConfiguration().screenWidthDp, f10) - displaySafeInsets.left) - displaySafeInsets.right : i10 : i10;
    }

    /* renamed from: c */
    private void m54137c() {
        this.f41808g = this.f41804c.mo54164g();
    }

    /* renamed from: d */
    private void m54138d() {
        int i10 = this.f41803b;
        if (i10 == 12) {
            this.f41808g = this.f41804c.mo54153a(this.f41809h, this.f41805d, this.f41806e);
            return;
        }
        if (i10 == 20) {
            this.f41808g = this.f41804c.mo54159c(this.f41809h, this.f41805d, this.f41806e);
        } else if (i10 != 21) {
            m54137c();
        } else {
            this.f41808g = this.f41804c.mo54161d(this.f41809h, this.f41805d, this.f41806e);
        }
    }

    /* renamed from: e */
    private void m54139e() {
        m54144j();
        HwColumnSplitManager hwColumnSplitManager = HwColumnSplitManager.getInstance();
        Activity wrapperActivity = hwColumnSplitManager.getWrapperActivity(this.f41811j);
        if (hwColumnSplitManager.isActivityAttributeValid(wrapperActivity) && hwColumnSplitManager.isSplitMode(wrapperActivity) && Float.compare(this.f41807f, 0.0f) != 0) {
            int i10 = wrapperActivity.getWindow().getAttributes().width;
            this.f41805d = i10;
            float f10 = this.f41807f;
            m54129a(i10 / f10, f10);
            Log.d(f41791p, "split mode, mWidthPixel: " + this.f41805d);
        } else {
            this.f41805d = m54133b(this.f41805d, this.f41807f);
            m54140f();
            Log.d(f41791p, "normal mode, mWidthPixel: " + this.f41805d);
        }
        m54143i();
    }

    /* renamed from: f */
    private void m54140f() {
        if (this.f41811j == null) {
            return;
        }
        this.f41809h = this.f41804c.mo54172o();
        m54141g();
    }

    /* renamed from: g */
    private void m54141g() {
        switch (this.f41803b) {
            case -1:
            case 0:
                this.f41808g = this.f41804c.mo54164g();
                break;
            case 1:
            case 2:
            case 17:
            case 18:
                m54134b();
                break;
            case 3:
                this.f41808g = this.f41804c.mo54162e();
                break;
            case 4:
                this.f41808g = this.f41804c.mo54156b();
                break;
            case 5:
                this.f41808g = this.f41804c.mo54171n();
                break;
            case 6:
            case 7:
                m54142h();
                break;
            case 8:
            case 9:
                m54128a();
                break;
            case 10:
                this.f41808g = this.f41804c.mo54168k();
                break;
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            default:
                m54137c();
                break;
            case 12:
            case 20:
            case 21:
                m54138d();
                break;
            case 19:
                this.f41808g = this.f41804c.mo54152a();
                break;
        }
    }

    public static int getSuggestWidth(Context context, int i10) {
        return new HwColumnSystem(context, i10).getSuggestWidth();
    }

    /* renamed from: h */
    private void m54142h() {
        int i10 = this.f41803b;
        if (i10 == 6) {
            this.f41808g = this.f41804c.mo54170m();
        } else if (i10 != 7) {
            m54137c();
        } else {
            this.f41808g = this.f41804c.mo54167j();
        }
    }

    /* renamed from: i */
    private void m54143i() {
        if (this.f41810i == null) {
            this.f41810i = new avpbg();
        }
        this.f41810i.m54178b(this.f41803b);
        this.f41810i.m54175a(this.f41805d, this.f41806e, this.f41807f, this.f41804c instanceof aauaf);
        com.huawei.uikit.hwcolumnsystem.widget.bzrwd bzrwdVar = this.f41808g;
        if (bzrwdVar != null) {
            this.f41810i.m54176a(bzrwdVar, this.f41809h, this.f41804c instanceof aauaf);
        }
    }

    /* renamed from: j */
    private void m54144j() {
        DisplayMetrics displayMetrics = this.f41811j.getResources().getDisplayMetrics();
        int i10 = displayMetrics.widthPixels;
        this.f41805d = i10;
        this.f41806e = displayMetrics.heightPixels;
        float f10 = displayMetrics.density;
        this.f41807f = f10;
        bqmxo bqmxoVar = this.f41804c;
        if (bqmxoVar != null) {
            bqmxoVar.m54192b(i10, f10);
        }
    }

    public int addBreakpoint(int i10, int i11) {
        if (this.f41808g == null) {
            return -1;
        }
        this.f41802a.add(new Integer[]{Integer.valueOf(m54127a(i10, this.f41807f)), Integer.valueOf(i11)});
        Collections.sort(this.f41802a, new bzrwd());
        int iM54193a = this.f41808g.m54193a();
        for (Integer[] numArr : this.f41802a) {
            if (this.f41805d > numArr[0].intValue()) {
                iM54193a = numArr[1].intValue();
            }
        }
        this.f41808g.m54194a(iM54193a);
        akxao akxaoVar = this.f41810i;
        if (akxaoVar == null) {
            return -1;
        }
        akxaoVar.m54180c(this.f41808g.m54193a());
        this.f41810i.mo54182e();
        return (int) (getColumnWidth(iM54193a) + f41797v);
    }

    public int getColumnType() {
        int i10 = this.f41803b;
        if (i10 == 12) {
            bqmxo bqmxoVar = this.f41804c;
            if (bqmxoVar instanceof aauaf) {
                return bqmxoVar.mo54155b(this.f41805d, this.f41806e, this.f41809h);
            }
        }
        return i10;
    }

    public float getColumnWidth(int i10) {
        if (i10 <= 0) {
            return 0.0f;
        }
        return this.f41810i.mo54173a(i10);
    }

    public int getGutter() {
        com.huawei.uikit.hwcolumnsystem.widget.bzrwd bzrwdVar = this.f41808g;
        if (bzrwdVar != null) {
            return bzrwdVar.m54195b();
        }
        return 0;
    }

    public int getMargin() {
        com.huawei.uikit.hwcolumnsystem.widget.bzrwd bzrwdVar = this.f41808g;
        if (bzrwdVar != null) {
            return bzrwdVar.m54197c();
        }
        return 0;
    }

    public int getMaxColumnWidth() {
        return this.f41810i.mo54179c();
    }

    public int getMinColumnWidth() {
        return this.f41810i.mo54181d();
    }

    public float getSingleColumnWidth() {
        return getColumnWidth(1);
    }

    public int getTotalColumnCount() {
        return this.f41809h;
    }

    public boolean isConfigurationChanged() {
        return this.f41814m;
    }

    public void setBreakPoints(int[] iArr) {
        bqmxo bqmxoVar = this.f41804c;
        if (bqmxoVar != null) {
            bqmxoVar.m54190a(iArr);
            m54139e();
        }
    }

    public void setColumnType(int i10) {
        this.f41803b = i10;
        if (this.f41811j == null) {
            return;
        }
        m54139e();
    }

    public void setConfigurationChanged(boolean z10) {
        this.f41814m = z10;
    }

    public int updateConfigation(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String[] strArr;
        if (context == null) {
            return getSuggestWidth();
        }
        this.f41811j = context;
        if (this.f41812k && (strArr = this.f41813l) != null && strArr.length == 3) {
            m54144j();
            m54131a(this.f41805d, true);
        } else {
            m54139e();
        }
        return getSuggestWidth();
    }

    public HwColumnSystem(Context context, int i10) {
        this.f41802a = new ArrayList();
        this.f41803b = -1;
        this.f41808g = new com.huawei.uikit.hwcolumnsystem.widget.bzrwd();
        this.f41809h = 4;
        this.f41814m = true;
        this.f41803b = i10;
        this.f41811j = context;
        this.f41812k = false;
        m54132a(context);
        m54139e();
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0071  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m54131a(int r5, boolean r6) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r4 = this;
            java.lang.String[] r0 = r4.f41813l
            if (r0 != 0) goto L5
            return
        L5:
            com.huawei.uikit.hwcolumnsystem.widget.bqmxo r1 = r4.f41804c
            float r2 = r4.f41807f
            android.util.Pair r0 = r1.mo54151a(r5, r0, r2)
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r4.f41809h = r1
            java.lang.Object r0 = r0.second
            java.lang.String r0 = (java.lang.String) r0
            if (r6 == 0) goto L23
            float r6 = r4.f41807f
            int r5 = r4.m54133b(r5, r6)
        L23:
            java.lang.String r6 = "^c(\\d+)m(\\d+)g(\\d+)"
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)
            java.util.regex.Matcher r6 = r6.matcher(r0)
            boolean r0 = r6.find()
            if (r0 == 0) goto L91
            int r0 = r6.groupCount()
            r1 = 3
            if (r0 != r1) goto L91
            r0 = 2
            r2 = 0
            java.lang.String r0 = r6.group(r0)     // Catch: java.lang.NumberFormatException -> L64
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L64
            float r3 = r4.f41807f     // Catch: java.lang.NumberFormatException -> L64
            int r0 = r4.m54127a(r0, r3)     // Catch: java.lang.NumberFormatException -> L64
            java.lang.String r1 = r6.group(r1)     // Catch: java.lang.NumberFormatException -> L62
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L62
            float r3 = r4.f41807f     // Catch: java.lang.NumberFormatException -> L62
            int r1 = r4.m54127a(r1, r3)     // Catch: java.lang.NumberFormatException -> L62
            r3 = 1
            java.lang.String r6 = r6.group(r3)     // Catch: java.lang.NumberFormatException -> L66
            int r2 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.NumberFormatException -> L66
            goto L6d
        L62:
            r1 = r2
            goto L66
        L64:
            r0 = r2
            r1 = r0
        L66:
            java.lang.String r6 = com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem.f41791p
            java.lang.String r3 = "Set column system input error"
            android.util.Log.e(r6, r3)
        L6d:
            com.huawei.uikit.hwcolumnsystem.widget.bzrwd r6 = r4.f41808g
            if (r6 != 0) goto L78
            com.huawei.uikit.hwcolumnsystem.widget.bzrwd r6 = new com.huawei.uikit.hwcolumnsystem.widget.bzrwd
            r6.<init>()
            r4.f41808g = r6
        L78:
            com.huawei.uikit.hwcolumnsystem.widget.bzrwd r6 = r4.f41808g
            r6.m54198c(r0)
            com.huawei.uikit.hwcolumnsystem.widget.bzrwd r6 = r4.f41808g
            r6.m54196b(r1)
            com.huawei.uikit.hwcolumnsystem.widget.bzrwd r6 = r4.f41808g
            r6.m54194a(r2)
            com.huawei.uikit.hwcolumnsystem.widget.bzrwd r6 = r4.f41808g
            r6.m54200d(r2)
            r4.f41805d = r5
            r4.m54143i()
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem.m54131a(int, boolean):void");
    }

    public int getSuggestWidth() {
        return this.f41810i.mo54177b();
    }

    public void setColumnType(int i10, boolean z10) {
        this.f41803b = i10;
        if (this.f41811j != null && z10) {
            m54139e();
        }
    }

    public int updateConfigation(Context context, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String[] strArr;
        if (context == null) {
            return getSuggestWidth();
        }
        this.f41811j = context;
        if (this.f41812k && (strArr = this.f41813l) != null && strArr.length == 3) {
            m54144j();
            m54131a(this.f41805d, true);
        } else if (z10) {
            m54139e();
        }
        return getSuggestWidth();
    }

    /* renamed from: b */
    private boolean m54136b(Context context) {
        WindowManager windowManager;
        int rotation = (context == null || (windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)) == null) ? 0 : windowManager.getDefaultDisplay().getRotation();
        return rotation == 0 || rotation == 2;
    }

    /* renamed from: b */
    private void m54134b() {
        int i10 = this.f41803b;
        if (i10 == 1) {
            this.f41808g = this.f41804c.mo54158c();
            return;
        }
        if (i10 == 2) {
            this.f41808g = this.f41804c.mo54165h();
            return;
        }
        if (i10 == 17) {
            this.f41808g = this.f41804c.mo54160d();
        } else if (i10 != 18) {
            m54137c();
        } else {
            this.f41808g = this.f41804c.mo54163f();
        }
    }

    public HwColumnSystem(Context context, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f41802a = new ArrayList();
        this.f41803b = -1;
        this.f41808g = new com.huawei.uikit.hwcolumnsystem.widget.bzrwd();
        this.f41809h = 4;
        this.f41812k = false;
        this.f41814m = true;
        this.f41811j = context;
        try {
            String[] strArrSplit = str.split("-");
            this.f41813l = strArrSplit;
            if (strArrSplit.length == 3) {
                this.f41812k = true;
                m54132a(context);
                m54144j();
                m54131a(this.f41805d, true);
                return;
            }
            Log.w(f41791p, "Input rules count error!");
            throw new IllegalArgumentException();
        } catch (PatternSyntaxException unused) {
            Log.w(f41791p, "Input format error!");
            throw new IllegalArgumentException();
        }
    }

    public int updateConfigation(Context context, int i10, int i11, float f10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String[] strArr;
        if (context != null && i10 > 0 && f10 >= 0.0f && !m54135b(f10, 0.0f)) {
            this.f41811j = context;
            this.f41805d = i10;
            this.f41806e = i11;
            this.f41807f = f10;
            if (this.f41812k && (strArr = this.f41813l) != null && strArr.length == 3) {
                m54131a(i10, false);
            } else {
                m54129a(i10 / f10, f10);
                m54143i();
            }
            return getSuggestWidth();
        }
        Log.w(f41791p, "width and density should not below to zero!");
        return getSuggestWidth();
    }

    /* renamed from: b */
    private boolean m54135b(float f10, float f11) {
        return Math.abs(f10 - f11) < f41798w;
    }

    /* renamed from: a */
    private void m54132a(Context context) {
        this.f41804c = HwWidgetInstantiator.getCurrentType(context) == 4 ? new blfhz(context) : new aauaf(context);
    }

    /* renamed from: a */
    private void m54130a(int i10, int i11, float f10) {
        if (!this.f41804c.mo54157b(i10)) {
            i10 = 0;
        }
        this.f41808g = this.f41804c.mo54154a(this.f41809h, new Pair<>(Integer.valueOf(this.f41805d), Integer.valueOf(this.f41806e)), i10, i11, f10);
    }

    /* renamed from: a */
    private void m54129a(float f10, float f11) {
        Pair<Integer, Integer> pairMo54150a = this.f41804c.mo54150a(f10);
        this.f41809h = ((Integer) pairMo54150a.first).intValue();
        m54130a(this.f41803b, ((Integer) pairMo54150a.second).intValue(), f11);
    }

    /* renamed from: a */
    private void m54128a() {
        int i10 = this.f41803b;
        if (i10 == 8) {
            this.f41808g = this.f41804c.mo54169l();
        } else if (i10 != 9) {
            m54137c();
        } else {
            this.f41808g = this.f41804c.mo54166i();
        }
    }
}
