package com.huawei.android.hicloud.p088ui.views.status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.android.hicloud.p088ui.views.CheckMarkView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudBackupCompleteStateView extends RelativeLayout {

    /* renamed from: a */
    public ImageView f19564a;

    public CloudBackupCompleteStateView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m25815a() {
        View viewInflate = View.inflate(getContext(), R$layout.backup_complete_state_layout, this);
        CheckMarkView checkMarkView = (CheckMarkView) C12809f.m76831d(viewInflate, R$id.backup_complete);
        this.f19564a = (ImageView) C12809f.m76831d(viewInflate, R$id.backup_complete_bg);
        checkMarkView.setVisibility(0);
        checkMarkView.m25690e();
        checkMarkView.m25693h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        C11839m.m70686d("CloudBackupCompleteStateView", "CloudBackupPrepareStateView onAttachedToWindow");
        super.onAttachedToWindow();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(RuleConfig.DEFAULT_BACKUP_RESTORE_TAR_COUNT);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
        this.f19564a.startAnimation(rotateAnimation);
    }

    public CloudBackupCompleteStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloudBackupCompleteStateView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m25815a();
    }
}
