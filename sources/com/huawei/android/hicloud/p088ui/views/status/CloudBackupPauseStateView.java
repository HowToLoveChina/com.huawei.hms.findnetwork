package com.huawei.android.hicloud.p088ui.views.status;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import om.C11965e;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudBackupPauseStateView extends RelativeLayout {

    /* renamed from: a */
    public TextView f19588a;

    /* renamed from: b */
    public LinearLayout f19589b;

    /* renamed from: c */
    public ImageView f19590c;

    /* renamed from: d */
    public ImageView f19591d;

    public CloudBackupPauseStateView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m25831a() {
        View viewInflate = View.inflate(getContext(), R$layout.backup_pause_state_layout, this);
        this.f19588a = (TextView) C12809f.m76831d(viewInflate, R$id.backup_pause_progress);
        this.f19589b = (LinearLayout) C12809f.m76831d(viewInflate, R$id.bc_progress_content);
        this.f19590c = (ImageView) C12809f.m76831d(viewInflate, R$id.bc_progress_bg);
        this.f19591d = (ImageView) C12809f.m76831d(viewInflate, R$id.backup_backing_pause_bg);
    }

    /* renamed from: b */
    public void m25832b() {
        this.f19589b.setVisibility(8);
        this.f19590c.setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        C11839m.m70686d("CloudBackupPauseStateView", "CloudBackupPrepareStateView onAttachedToWindow");
        super.onAttachedToWindow();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(RuleConfig.DEFAULT_BACKUP_RESTORE_TAR_COUNT);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
        this.f19591d.startAnimation(rotateAnimation);
    }

    public void setProgress(float f10) throws Resources.NotFoundException {
        if (f10 < 0.0f) {
            return;
        }
        this.f19590c.setVisibility(8);
        this.f19589b.setVisibility(0);
        this.f19588a.setText(C11965e.m71974f().m71980i(f10, getResources().getDimensionPixelSize(R$dimen.backup_percent_12)));
    }

    public CloudBackupPauseStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloudBackupPauseStateView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m25831a();
    }
}
