package p676ud;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.huawei.hicloud.sync.R$dimen;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import p015ak.C0229n;
import p514o9.C11829c;
import p514o9.C11842p;
import sk.C12809f;

/* renamed from: ud.k */
/* loaded from: classes3.dex */
public class C13164k {

    /* renamed from: a */
    public PopupWindow f59672a;

    /* renamed from: b */
    public TextView f59673b;

    /* renamed from: c */
    public ImageView f59674c;

    /* renamed from: d */
    public final Activity f59675d;

    /* renamed from: e */
    public int f59676e;

    public C13164k(Activity activity) {
        this.f59675d = activity;
        this.f59676e = (int) (C11842p.m70758Q(activity) * 0.5d);
    }

    /* renamed from: f */
    public void m79155f() {
        PopupWindow popupWindow = this.f59672a;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
        this.f59672a = null;
    }

    /* renamed from: g */
    public final PopupWindow m79156g(String str) throws Resources.NotFoundException {
        View viewInflate = LayoutInflater.from(this.f59675d).inflate(R$layout.popup_tip_right_down_black, (ViewGroup) null);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: ud.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f59670a.m79162m(view);
            }
        });
        this.f59674c = (ImageView) C12809f.m76831d(viewInflate, R$id.arrow);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.text);
        this.f59673b = textView;
        Activity activity = this.f59675d;
        int i10 = R$dimen.cloud_space_24_dp;
        C0229n.m1602a(textView, activity, i10, i10, i10);
        this.f59673b.setText(str);
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }

    /* renamed from: h */
    public final PopupWindow m79157h(String str) throws Resources.NotFoundException {
        View viewInflate = LayoutInflater.from(this.f59675d).inflate(R$layout.popup_tip_right_up_black, (ViewGroup) null);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: ud.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f59667a.m79163n(view);
            }
        });
        this.f59674c = (ImageView) C12809f.m76831d(viewInflate, R$id.arrow);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.text);
        this.f59673b = textView;
        Activity activity = this.f59675d;
        int i10 = R$dimen.cloud_space_24_dp;
        C0229n.m1602a(textView, activity, i10, i10, i10);
        this.f59673b.setText(str);
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }

    /* renamed from: i */
    public final PopupWindow m79158i(String str) throws Resources.NotFoundException {
        View viewInflate = LayoutInflater.from(this.f59675d).inflate(R$layout.popup_tip_left_down, (ViewGroup) null);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: ud.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f59669a.m79164o(view);
            }
        });
        this.f59674c = (ImageView) C12809f.m76831d(viewInflate, R$id.arrow);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.text);
        this.f59673b = textView;
        Activity activity = this.f59675d;
        int i10 = R$dimen.cloud_space_24_dp;
        C0229n.m1602a(textView, activity, i10, i10, i10);
        this.f59673b.setText(str);
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }

    /* renamed from: j */
    public final PopupWindow m79159j(String str) throws Resources.NotFoundException {
        View viewInflate = LayoutInflater.from(this.f59675d).inflate(R$layout.popup_tip_left_up, (ViewGroup) null);
        this.f59674c = (ImageView) C12809f.m76831d(viewInflate, R$id.arrow);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.text);
        this.f59673b = textView;
        Activity activity = this.f59675d;
        int i10 = R$dimen.cloud_space_24_dp;
        C0229n.m1602a(textView, activity, i10, i10, i10);
        this.f59673b.setText(str);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: ud.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f59668a.m79165p(view);
            }
        });
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }

    /* renamed from: k */
    public final PopupWindow m79160k(String str) throws Resources.NotFoundException {
        View viewInflate = LayoutInflater.from(this.f59675d).inflate(R$layout.popup_tip_right_up, (ViewGroup) null);
        this.f59674c = (ImageView) C12809f.m76831d(viewInflate, R$id.arrow);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.text);
        this.f59673b = textView;
        Activity activity = this.f59675d;
        int i10 = R$dimen.cloud_space_24_dp;
        C0229n.m1602a(textView, activity, i10, i10, i10);
        this.f59673b.setText(str);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: ud.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f59671a.m79166q(view);
            }
        });
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }

    /* renamed from: l */
    public boolean m79161l() {
        PopupWindow popupWindow = this.f59672a;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }

    /* renamed from: m */
    public final /* synthetic */ void m79162m(View view) {
        m79155f();
    }

    /* renamed from: n */
    public final /* synthetic */ void m79163n(View view) {
        m79155f();
    }

    /* renamed from: o */
    public final /* synthetic */ void m79164o(View view) {
        m79155f();
    }

    /* renamed from: p */
    public final /* synthetic */ void m79165p(View view) {
        m79155f();
    }

    /* renamed from: q */
    public final /* synthetic */ void m79166q(View view) {
        m79155f();
    }

    /* renamed from: r */
    public void m79167r(View view, String str, int i10, int i11) throws Resources.NotFoundException {
        PopupWindow popupWindowM79156g = m79156g(str);
        this.f59672a = popupWindowM79156g;
        if (popupWindowM79156g.isShowing()) {
            return;
        }
        this.f59672a.getContentView().measure(0, 0);
        View contentView = this.f59672a.getContentView();
        contentView.measure(0, 0);
        int iMin = Math.min(contentView.getMeasuredWidth(), this.f59676e);
        ViewGroup.LayoutParams layoutParams = this.f59673b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = iMin;
            this.f59673b.setLayoutParams(layoutParams);
            contentView.measure(0, 0);
        }
        this.f59672a.setWidth(iMin);
        int measuredWidth = (int) (view.getMeasuredWidth() * 0.5d);
        int dimensionPixelOffset = this.f59675d.getResources().getDimensionPixelOffset(R$dimen.cloud_space_44_dp);
        this.f59672a.showAsDropDown(view, C11842p.m70765S0() ? (-iMin) + measuredWidth + dimensionPixelOffset + i10 : (measuredWidth - dimensionPixelOffset) - i10, (-this.f59675d.getResources().getDimensionPixelOffset(R$dimen.cloud_space_12_dp)) + i11);
    }

    /* renamed from: s */
    public void m79168s(View view, String str, int i10, int i11) throws Resources.NotFoundException {
        PopupWindow popupWindowM79157h = m79157h(str);
        this.f59672a = popupWindowM79157h;
        if (popupWindowM79157h.isShowing()) {
            return;
        }
        View contentView = this.f59672a.getContentView();
        contentView.measure(0, 0);
        int iMin = Math.min(contentView.getMeasuredWidth(), this.f59676e);
        ViewGroup.LayoutParams layoutParams = this.f59673b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = iMin;
            this.f59673b.setLayoutParams(layoutParams);
            contentView.measure(0, 0);
        }
        this.f59672a.setWidth(iMin);
        int measuredHeight = contentView.getMeasuredHeight();
        int measuredWidth = (int) (view.getMeasuredWidth() * 0.5d);
        int measuredHeight2 = view.getMeasuredHeight();
        int dimensionPixelOffset = this.f59675d.getResources().getDimensionPixelOffset(R$dimen.cloud_space_44_dp);
        this.f59672a.showAsDropDown(view, C11842p.m70765S0() ? (-iMin) + measuredWidth + dimensionPixelOffset + i10 : (measuredWidth - dimensionPixelOffset) - i10, ((-measuredHeight2) - measuredHeight) + this.f59675d.getResources().getDimensionPixelOffset(R$dimen.cloud_space_12_dp) + i11);
    }

    /* renamed from: t */
    public void m79169t(View view, String str, int i10, int i11) throws Resources.NotFoundException {
        PopupWindow popupWindowM79158i = m79158i(str);
        this.f59672a = popupWindowM79158i;
        if (popupWindowM79158i.isShowing()) {
            return;
        }
        this.f59672a.getContentView().measure(0, 0);
        View contentView = this.f59672a.getContentView();
        contentView.measure(0, 0);
        int iMin = Math.min(contentView.getMeasuredWidth(), this.f59676e);
        ViewGroup.LayoutParams layoutParams = this.f59673b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = iMin;
            this.f59673b.setLayoutParams(layoutParams);
            contentView.measure(0, 0);
        }
        this.f59672a.setWidth(iMin);
        int measuredWidth = (int) (view.getMeasuredWidth() * 0.5d);
        int dimensionPixelOffset = this.f59675d.getResources().getDimensionPixelOffset(R$dimen.cloud_space_44_dp);
        this.f59672a.showAsDropDown(view, C11842p.m70765S0() ? (measuredWidth - dimensionPixelOffset) - i10 : (-iMin) + measuredWidth + dimensionPixelOffset + i10, (-this.f59675d.getResources().getDimensionPixelOffset(R$dimen.cloud_space_12_dp)) + i11);
    }

    /* renamed from: u */
    public void m79170u(View view, String str, int i10, int i11) throws Resources.NotFoundException {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f59675d.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i12 = displayMetrics.heightPixels;
        view.getLocationOnScreen(new int[2]);
        if (r1[1] < i12 * 0.5d) {
            m79169t(view, str, i10, i11);
        } else {
            m79171v(view, str, i10, -i11);
        }
    }

    /* renamed from: v */
    public void m79171v(View view, String str, int i10, int i11) throws Resources.NotFoundException {
        int i12;
        int dimensionPixelOffset;
        PopupWindow popupWindowM79159j = m79159j(str);
        this.f59672a = popupWindowM79159j;
        if (popupWindowM79159j.isShowing()) {
            return;
        }
        View contentView = this.f59672a.getContentView();
        contentView.measure(0, 0);
        int iMin = Math.min(contentView.getMeasuredWidth(), this.f59676e);
        ViewGroup.LayoutParams layoutParams = this.f59673b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = iMin;
            this.f59673b.setLayoutParams(layoutParams);
            contentView.measure(0, 0);
        }
        this.f59672a.setWidth(iMin);
        int measuredHeight = contentView.getMeasuredHeight();
        int measuredWidth = (int) (view.getMeasuredWidth() * 0.5d);
        int measuredHeight2 = view.getMeasuredHeight();
        int dimensionPixelOffset2 = this.f59675d.getResources().getDimensionPixelOffset(R$dimen.cloud_space_44_dp);
        int dimensionPixelOffset3 = this.f59675d.getResources().getDimensionPixelOffset(R$dimen.cloud_space_12_dp);
        if (C11842p.m70765S0()) {
            i12 = (measuredWidth - dimensionPixelOffset2) - i10;
            dimensionPixelOffset = ((-measuredHeight2) - measuredHeight) - this.f59675d.getResources().getDimensionPixelOffset(R$dimen.cloud_space_5_dp);
        } else {
            i12 = (-iMin) + measuredWidth + dimensionPixelOffset2 + i10;
            dimensionPixelOffset = ((-measuredHeight2) - measuredHeight) + dimensionPixelOffset3;
        }
        this.f59672a.showAsDropDown(view, i12, dimensionPixelOffset + i11);
    }

    /* renamed from: w */
    public void m79172w(View view, String str, int i10, int i11) throws Resources.NotFoundException {
        PopupWindow popupWindowM79160k = m79160k(str);
        this.f59672a = popupWindowM79160k;
        if (popupWindowM79160k.isShowing()) {
            return;
        }
        this.f59676e = (int) (C11829c.m70549V(this.f59675d) * 0.66d);
        View contentView = this.f59672a.getContentView();
        contentView.measure(0, 0);
        int iMin = Math.min(contentView.getMeasuredWidth(), this.f59676e);
        ViewGroup.LayoutParams layoutParams = this.f59673b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = iMin;
            this.f59673b.setLayoutParams(layoutParams);
            contentView.measure(0, 0);
        }
        this.f59672a.setWidth(iMin);
        int measuredHeight = contentView.getMeasuredHeight();
        int measuredWidth = (int) (view.getMeasuredWidth() * 0.5d);
        int measuredHeight2 = view.getMeasuredHeight();
        int dimensionPixelOffset = this.f59675d.getResources().getDimensionPixelOffset(R$dimen.cs_24_dp);
        this.f59672a.showAsDropDown(view, C11842p.m70765S0() ? (-iMin) + measuredWidth + dimensionPixelOffset + i10 : (measuredWidth - dimensionPixelOffset) + i10, ((-measuredHeight2) - measuredHeight) + i11);
    }

    /* renamed from: x */
    public void m79173x(View view, String str, int i10, int i11) throws Resources.NotFoundException {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f59675d.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i12 = displayMetrics.heightPixels;
        int i13 = displayMetrics.widthPixels;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i14 = iArr[0];
        int i15 = iArr[1];
        boolean zM70765S0 = C11842p.m70765S0();
        boolean z10 = ((double) i14) > ((double) i13) * 0.5d;
        if (i15 < i12 * 0.5d) {
            if ((!z10 || zM70765S0) && (z10 || !zM70765S0)) {
                m79167r(view, str, i10, i11);
                return;
            } else {
                m79169t(view, str, i10, i11);
                return;
            }
        }
        if ((z10 && zM70765S0) || (!z10 && !zM70765S0)) {
            m79168s(view, str, i10, -i11);
        } else if (zM70765S0) {
            m79171v(view, str, i10, i11);
        } else {
            m79171v(view, str, i10, -i11);
        }
    }

    public C13164k(Activity activity, double d10) {
        this.f59675d = activity;
        this.f59676e = (int) (C11842p.m70758Q(activity) * d10);
    }
}
