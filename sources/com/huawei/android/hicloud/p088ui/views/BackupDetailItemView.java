package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import om.C11965e;
import p015ak.C0209d;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupDetailItemView extends RelativeLayout {

    /* renamed from: a */
    public Context f19329a;

    /* renamed from: b */
    public ImageView f19330b;

    /* renamed from: c */
    public ImageView f19331c;

    /* renamed from: d */
    public TextView f19332d;

    /* renamed from: e */
    public TextView f19333e;

    /* renamed from: f */
    public TextView f19334f;

    /* renamed from: g */
    public HwProgressBar f19335g;

    /* renamed from: h */
    public ImageView f19336h;

    /* renamed from: i */
    public CheckMarkView f19337i;

    /* renamed from: j */
    public CircleProgressView f19338j;

    /* renamed from: k */
    public View f19339k;

    /* renamed from: l */
    public TextView f19340l;

    /* renamed from: m */
    public int f19341m;

    /* renamed from: n */
    public ImageView f19342n;

    /* renamed from: o */
    public HwProgressBar f19343o;

    /* renamed from: p */
    public boolean f19344p;

    /* renamed from: q */
    public RelativeLayout f19345q;

    public BackupDetailItemView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public void m25649a(String str) {
        if (SplitAppUtil.hasSplitAppSuffix(str)) {
            this.f19331c.setVisibility(0);
        } else {
            this.f19331c.setVisibility(8);
        }
    }

    /* renamed from: b */
    public void m25650b(boolean z10) {
        this.f19336h.setImageResource(z10 ? R$drawable.ic_16_arrow_up : R$drawable.ic_16_arrow_down);
    }

    /* renamed from: c */
    public void m25651c() {
        this.f19342n.clearAnimation();
        this.f19342n.setVisibility(8);
    }

    /* renamed from: d */
    public void m25652d() {
        this.f19336h.setVisibility(8);
    }

    /* renamed from: e */
    public void m25653e() {
        this.f19340l.setVisibility(8);
    }

    /* renamed from: f */
    public void m25654f() {
        this.f19338j.setVisibility(8);
        this.f19337i.setVisibility(8);
    }

    /* renamed from: g */
    public void m25655g() {
        this.f19343o.setVisibility(8);
    }

    /* renamed from: h */
    public void m25656h() {
        this.f19335g.setVisibility(8);
        this.f19334f.setVisibility(8);
    }

    /* renamed from: i */
    public final void m25657i(Context context) {
        if (C0209d.m1195O(context) >= 1.75f) {
            View.inflate(context, R$layout.item_backup_detail_view_font_scale, this);
        } else {
            View.inflate(context, R$layout.item_backup_detail_view, this);
        }
        this.f19330b = (ImageView) C12809f.m76831d(this, R$id.item_backup_image);
        this.f19331c = (ImageView) C12809f.m76831d(this, R$id.item_backup_image_badge);
        this.f19336h = (ImageView) C12809f.m76831d(this, R$id.backup_down_arrow_image);
        this.f19332d = (TextView) C12809f.m76831d(this, R$id.item_backup_title);
        this.f19333e = (TextView) C12809f.m76831d(this, R$id.item_backup_state);
        TextView textView = (TextView) C12809f.m76831d(this, R$id.backup_progress_text);
        this.f19334f = textView;
        textView.setMaxWidth(getResources().getDisplayMetrics().widthPixels >> 2);
        HwProgressBar hwProgressBar = (HwProgressBar) C12809f.m76831d(this, R$id.backup_progress);
        this.f19335g = hwProgressBar;
        hwProgressBar.setMax(100);
        this.f19337i = (CheckMarkView) C12809f.m76831d(this, R$id.check_mark_view);
        this.f19338j = (CircleProgressView) C12809f.m76831d(this, R$id.bc_circle_progress_view);
        this.f19339k = C12809f.m76831d(this, R$id.view_line_bottom);
        this.f19340l = (TextView) C12809f.m76831d(this, R$id.backup_size);
        this.f19342n = (ImageView) C12809f.m76831d(this, R$id.loading_progressbar);
        this.f19343o = (HwProgressBar) C12809f.m76831d(this, R$id.pre_backup_item_progress);
        this.f19345q = (RelativeLayout) C12809f.m76831d(this, R$id.rel_item);
        this.f19344p = C11842p.m70732H0(this.f19329a);
    }

    /* renamed from: j */
    public void m25658j(String str, float f10) {
        this.f19335g.setFlickerEnable(!this.f19344p);
        this.f19335g.setVisibility(0);
        this.f19335g.setProgress((int) f10);
        this.f19334f.setVisibility(0);
        this.f19334f.setTextColor(this.f19329a.getColor(R$color.emui10_textColorPrimaryActivated));
        this.f19334f.setText(C11965e.m71974f().m71977e(f10));
    }

    /* renamed from: k */
    public void m25659k() {
        this.f19336h.setVisibility(0);
    }

    /* renamed from: l */
    public void m25660l(String str) {
        m25655g();
        this.f19340l.setVisibility(0);
        this.f19340l.setTextColor(this.f19329a.getColor(R$color.emui_color_gray_6));
        this.f19340l.setText(str);
    }

    /* renamed from: m */
    public void m25661m(boolean z10) {
        this.f19339k.setVisibility(z10 ? 0 : 8);
    }

    /* renamed from: n */
    public void m25662n() {
        this.f19343o.setVisibility(0);
    }

    /* renamed from: o */
    public void m25663o() {
        if (this.f19336h.getVisibility() != 0) {
            m25653e();
            m25656h();
            m25651c();
            this.f19337i.setVisibility(0);
            this.f19337i.m25691f();
            this.f19337i.m25692g();
            setMakeFileProgress(100);
        }
    }

    /* renamed from: p */
    public void m25664p() {
        this.f19342n.setVisibility(0);
        if (this.f19342n.getAnimation() != null) {
            return;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
        this.f19342n.startAnimation(rotateAnimation);
    }

    public void setBackUpItemIcon(Drawable drawable) {
        this.f19330b.setImageDrawable(drawable);
    }

    public void setBackUpState(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f19333e.setVisibility(8);
        } else {
            this.f19333e.setVisibility(0);
            this.f19333e.setText(str);
        }
    }

    public void setBackupAppName(String str) {
        this.f19332d.setText(str);
    }

    public void setMakeFileProgress(int i10) {
        m25651c();
        this.f19338j.setVisibility(0);
        this.f19338j.setProgress(i10);
    }

    public BackupDetailItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackupDetailItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m25657i(context);
        this.f19329a = context;
        this.f19341m = (int) C11842p.m70844o(context, 72);
    }
}
