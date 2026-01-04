package com.huawei.openalliance.p169ad.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.InterfaceC7328jb;
import com.huawei.openalliance.p169ad.constant.SkipPosition;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.util.IllegalFormatException;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.views.v */
/* loaded from: classes2.dex */
public class C8152v extends FrameLayout {

    /* renamed from: a */
    private static final String f38155a = "v";

    /* renamed from: b */
    private static int f38156b = 16;

    /* renamed from: c */
    private static int f38157c = 16;

    /* renamed from: d */
    private static int f38158d = 4;

    /* renamed from: e */
    private static int f38159e = 16;

    /* renamed from: f */
    private static int f38160f = 16;

    /* renamed from: g */
    private static int f38161g = 24;

    /* renamed from: h */
    private static int f38162h = 24;

    /* renamed from: i */
    private Context f38163i;

    /* renamed from: j */
    private String f38164j;

    /* renamed from: k */
    private String f38165k;

    /* renamed from: l */
    private int f38166l;

    /* renamed from: m */
    private int f38167m;

    /* renamed from: n */
    private int f38168n;

    /* renamed from: o */
    private final String f38169o;

    /* renamed from: p */
    private InterfaceC7328jb f38170p;

    /* renamed from: q */
    private boolean f38171q;

    /* renamed from: r */
    private Resources f38172r;

    /* renamed from: s */
    private TextView f38173s;

    /* renamed from: t */
    private boolean f38174t;

    /* renamed from: u */
    private int f38175u;

    /* renamed from: v */
    private float f38176v;

    /* renamed from: w */
    private int f38177w;

    /* renamed from: x */
    private boolean f38178x;

    /* renamed from: y */
    private boolean f38179y;

    /* renamed from: z */
    private boolean f38180z;

    public C8152v(Context context, String str, int i10, int i11, int i12, String str2, boolean z10, int i13, float f10, int i14, boolean z11) {
        super(context);
        this.f38168n = 0;
        this.f38174t = false;
        this.f38178x = false;
        this.f38179y = true;
        this.f38180z = false;
        this.f38163i = context;
        this.f38172r = context.getResources();
        m50523b();
        this.f38166l = i10;
        this.f38167m = i11;
        this.f38168n = i12;
        this.f38169o = str2 == null ? "tr" : str2;
        this.f38164j = context.getString(C6849R.string.hiad_default_skip_text);
        this.f38165k = m50519a(str);
        this.f38171q = z10;
        this.f38175u = i13;
        this.f38176v = f10;
        this.f38177w = i14;
        this.f38178x = z11;
        this.f38179y = C6982bz.m41152b(context);
        m50524c();
        this.f38180z = false;
        m50525d();
    }

    /* renamed from: a */
    private int m50517a(boolean z10) {
        int i10 = z10 ? f38161g : f38157c;
        if (5 == this.f38167m) {
            return z10 ? f38162h : f38160f;
        }
        return i10;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    private void m50524c() {
        View.inflate(getContext(), C6849R.layout.hiad_view_skip_button, this);
        TextView textView = (TextView) findViewById(C6849R.id.hiad_skip_text);
        this.f38173s = textView;
        textView.setText(this.f38164j);
        if (this.f38176v > 0.0f) {
            if (AbstractC7741ao.m47592n(this.f38163i)) {
                this.f38173s.setTextSize(1, 24.0f);
                if (this.f38177w > 0) {
                    this.f38173s.setHeight(AbstractC7741ao.m47535a(this.f38163i, 48.0f));
                }
            } else {
                this.f38173s.setTextSize(2, this.f38176v);
                int i10 = this.f38177w;
                if (i10 > 0) {
                    this.f38173s.setHeight(AbstractC7741ao.m47565c(this.f38163i, i10));
                }
            }
        }
        this.f38173s.setPadding(getSkipAdPaddingPx(), 0, getSkipAdPaddingPx(), 0);
        setPaddingRelative(getSkipAdLeftPaddingPx(), getSkipAdTopPaddingPx(), getSkipAdRightPaddingPx(), getSkipAdBottomPaddingPx());
        setClickable(true);
        setLayoutParams(getSkipAdLayoutParams());
    }

    /* renamed from: d */
    private void m50525d() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.v.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (motionEvent.getAction() == 0) {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a(C8152v.f38155a, "touch down skipAdButton x=%f, y=%f", Float.valueOf(rawX), Float.valueOf(rawY));
                    }
                    if (!C8152v.this.f38180z && C8152v.this.f38170p != null) {
                        C8152v.this.f38180z = true;
                        C8152v.this.f38170p.mo45150a((int) rawX, (int) rawY);
                    }
                }
                return true;
            }
        });
    }

    private int getHorizontalSideGapDpSize() {
        int i10 = f38156b;
        if (5 == this.f38167m) {
            i10 = f38159e;
        }
        return !this.f38179y ? f38158d : i10;
    }

    private int getHorizontalSideMarginDp() {
        int horizontalSideGapDpSize = getHorizontalSideGapDpSize();
        int i10 = this.f38168n;
        if (horizontalSideGapDpSize < i10) {
            return 0;
        }
        return horizontalSideGapDpSize - i10;
    }

    private int getHorizontalSidePaddingDp() {
        return Math.min(getHorizontalSideGapDpSize(), this.f38168n);
    }

    private int getSkipAdBottomMarginPx() {
        if (!SkipPosition.LOWER_RIGHT.equals(this.f38169o)) {
            return 0;
        }
        int iM48326f = (this.f38166l != 0 || 5 == this.f38167m || C7845x.m48595q(this.f38163i) || C7845x.m48587n(this.f38163i)) ? this.f38171q ? 0 : AbstractC7811dd.m48326f(this.f38163i) : 0;
        if (!this.f38171q && AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(f38155a, "navigation bar h: %d", Integer.valueOf(iM48326f));
        }
        return AbstractC7741ao.m47535a(this.f38163i, getVerticalSideBottomMarginDp()) + iM48326f;
    }

    private int getSkipAdBottomPaddingPx() {
        Context context;
        int verticalSidePaddingDp;
        if (SkipPosition.LOWER_RIGHT.equals(this.f38169o)) {
            context = this.f38163i;
            verticalSidePaddingDp = getVerticalSidePaddingDp();
        } else {
            context = this.f38163i;
            verticalSidePaddingDp = this.f38168n;
        }
        return AbstractC7741ao.m47535a(context, verticalSidePaddingDp);
    }

    private RelativeLayout.LayoutParams getSkipAdLayoutParams() {
        int iM47535a;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(SkipPosition.LOWER_RIGHT.equals(this.f38169o) ? 12 : 10);
        layoutParams.addRule(21);
        int skipAdLeftMarginPx = getSkipAdLeftMarginPx();
        int skipAdTopMarginPx = getSkipAdTopMarginPx();
        int skipAdRightMarginPx = getSkipAdRightMarginPx();
        int skipAdBottomMarginPx = getSkipAdBottomMarginPx();
        if (1 != this.f38166l) {
            if (!this.f38178x) {
                skipAdRightMarginPx += this.f38175u;
            }
            skipAdRightMarginPx = this.f38179y ? skipAdRightMarginPx + AbstractC7811dd.m48326f(this.f38163i) : AbstractC7811dd.m48326f(this.f38163i);
            if ("tr".equals(this.f38169o)) {
                iM47535a = AbstractC7741ao.m47535a(this.f38163i, 12.0f);
                skipAdTopMarginPx += iM47535a;
            }
        } else if ("tr".equals(this.f38169o)) {
            iM47535a = this.f38175u;
            skipAdTopMarginPx += iM47535a;
        }
        layoutParams.setMargins(skipAdLeftMarginPx, skipAdTopMarginPx, skipAdRightMarginPx, skipAdBottomMarginPx);
        layoutParams.setMarginEnd(skipAdRightMarginPx);
        return layoutParams;
    }

    private int getSkipAdLeftMarginPx() {
        return 0;
    }

    private int getSkipAdLeftPaddingPx() {
        return this.f38172r.getDimensionPixelOffset(C6849R.dimen.hiad_margin_m);
    }

    private int getSkipAdPaddingPx() {
        return this.f38172r.getDimensionPixelOffset(C6849R.dimen.hiad_margin_l);
    }

    private int getSkipAdRightMarginPx() {
        return AbstractC7741ao.m47535a(this.f38163i, getHorizontalSideMarginDp());
    }

    private int getSkipAdRightPaddingPx() {
        return AbstractC7741ao.m47535a(this.f38163i, getHorizontalSidePaddingDp());
    }

    private int getSkipAdTopMarginPx() {
        if (SkipPosition.LOWER_RIGHT.equals(this.f38169o)) {
            return 0;
        }
        return AbstractC7741ao.m47535a(this.f38163i, getVerticalSideMarginDp());
    }

    private int getSkipAdTopPaddingPx() {
        Context context;
        int topPaddingDp;
        if (SkipPosition.LOWER_RIGHT.equals(this.f38169o)) {
            context = this.f38163i;
            topPaddingDp = this.f38168n;
        } else {
            context = this.f38163i;
            topPaddingDp = getTopPaddingDp();
        }
        return AbstractC7741ao.m47535a(context, topPaddingDp);
    }

    private int getTopPaddingDp() {
        return Math.min(5 == this.f38167m ? f38160f : f38157c, this.f38168n);
    }

    private int getVerticalSideBottomMarginDp() {
        int iM50517a = m50517a(true);
        int i10 = this.f38168n;
        if (iM50517a < i10) {
            return 0;
        }
        return iM50517a - i10;
    }

    private int getVerticalSideMarginDp() {
        int iM50517a = m50517a(false);
        int i10 = this.f38168n;
        if (iM50517a < i10) {
            return 0;
        }
        return iM50517a - i10;
    }

    private int getVerticalSidePaddingDp() {
        return Math.min(m50517a(false), this.f38168n);
    }

    public void setAdMediator(InterfaceC7328jb interfaceC7328jb) {
        this.f38170p = interfaceC7328jb;
    }

    public void setLinkedOnTouchListener(View.OnTouchListener onTouchListener) {
        setOnTouchListener(onTouchListener);
    }

    public void setShowLeftTime(boolean z10) {
        this.f38174t = z10;
    }

    /* renamed from: b */
    private void m50523b() {
        Context context;
        Resources resources = this.f38172r;
        if (resources == null || (context = this.f38163i) == null) {
            return;
        }
        f38156b = AbstractC7741ao.m47557b(context, resources.getDimension(C6849R.dimen.hiad_splash_skip_phone_margin));
        f38157c = AbstractC7741ao.m47557b(this.f38163i, this.f38172r.getDimension(C6849R.dimen.hiad_splash_skip_phone_margin_top));
        f38158d = AbstractC7741ao.m47557b(this.f38163i, this.f38172r.getDimension(C6849R.dimen.hiad_splash_skip_third_margin));
        f38159e = AbstractC7741ao.m47557b(this.f38163i, this.f38172r.getDimension(C6849R.dimen.hiad_splash_skip_tablet_margin));
        f38160f = AbstractC7741ao.m47557b(this.f38163i, this.f38172r.getDimension(C6849R.dimen.hiad_splash_skip_tablet_margin_top));
        f38161g = AbstractC7741ao.m47557b(this.f38163i, this.f38172r.getDimension(C6849R.dimen.hiad_splash_skip_phone_margin_bottom));
        f38162h = AbstractC7741ao.m47557b(this.f38163i, this.f38172r.getDimension(C6849R.dimen.hiad_splash_skip_tablet_margin_bottom));
    }

    /* renamed from: a */
    private String m50519a(String str) {
        String strM48168c = AbstractC7806cz.m48168c(str);
        return AbstractC7806cz.m48165b(strM48168c) ? this.f38163i.getString(C6849R.string.hiad_default_skip_text_time) : strM48168c;
    }

    /* renamed from: a */
    public void m50526a(int i10) {
        if (this.f38174t && !TextUtils.isEmpty(this.f38165k)) {
            try {
                String str = String.format(Locale.getDefault(), this.f38165k, Integer.valueOf(i10));
                AbstractC7185ho.m43818a(f38155a, "updateLeftTime : %s", str);
                this.f38173s.setText(str);
                return;
            } catch (IllegalFormatException unused) {
                AbstractC7185ho.m43826d(f38155a, "updateLeftTime IllegalFormatException");
            }
        }
        this.f38173s.setText(this.f38164j);
    }
}
