package com.huawei.android.hicloud.p088ui.views.status;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
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
public class CloudBackupBackingStateView extends RelativeLayout {

    /* renamed from: a */
    public TextView f19561a;

    /* renamed from: b */
    public View f19562b;

    /* renamed from: c */
    public ImageView f19563c;

    public CloudBackupBackingStateView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m25814a() {
        View viewInflate = View.inflate(getContext(), R$layout.backup_backing_state_layout, this);
        this.f19562b = C12809f.m76831d(viewInflate, R$id.backup_backing_bg);
        this.f19561a = (TextView) C12809f.m76831d(viewInflate, R$id.backup_backing_progress);
        this.f19563c = (ImageView) C12809f.m76831d(viewInflate, R$id.bc_progress_bg);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        C11839m.m70686d("CloudBackupBackingStateView", "CloudBackupBackingStateView onAttachedToWindow");
        super.onAttachedToWindow();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(RuleConfig.DEFAULT_BACKUP_RESTORE_TAR_COUNT);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
        this.f19562b.startAnimation(rotateAnimation);
    }

    public void setProgress(float f10) throws Resources.NotFoundException {
        if (f10 > 100.0f) {
            return;
        }
        this.f19561a.setText(C11965e.m71974f().m71980i(f10, getResources().getDimensionPixelSize(R$dimen.backup_percent_12)));
        this.f19563c.setVisibility(8);
    }

    public CloudBackupBackingStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloudBackupBackingStateView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m25814a();
    }
}
