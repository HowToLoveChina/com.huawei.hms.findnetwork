package com.huawei.openalliance.p169ad;

import android.view.MotionEvent;
import android.view.View;
import com.huawei.openalliance.p169ad.views.PPSRewardView;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* renamed from: com.huawei.openalliance.ad.uo */
/* loaded from: classes8.dex */
public class ViewOnTouchListenerC7720uo implements View.OnTouchListener {

    /* renamed from: a */
    float f35782a;

    /* renamed from: b */
    float f35783b;

    /* renamed from: c */
    float f35784c;

    /* renamed from: d */
    float f35785d;

    /* renamed from: e */
    private final PPSRewardView f35786e;

    public ViewOnTouchListenerC7720uo(PPSRewardView pPSRewardView) {
        this.f35786e = pPSRewardView;
    }

    /* renamed from: a */
    private int m47411a(MotionEvent motionEvent) {
        return motionEvent.getAction() & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int iM47411a = m47411a(motionEvent);
        if (iM47411a == 0) {
            this.f35782a = motionEvent.getX();
            this.f35783b = motionEvent.getY();
        }
        if (iM47411a != 1) {
            return false;
        }
        this.f35784c = Math.abs(motionEvent.getX() - this.f35782a);
        float fAbs = Math.abs(motionEvent.getY() - this.f35783b);
        this.f35785d = fAbs;
        if (this.f35784c >= 30.0f || fAbs >= 30.0f) {
            return false;
        }
        AbstractC7185ho.m43820b("RewardContentViewOTL", "click action");
        if (this.f35786e.m49608r() || !this.f35786e.m49603j()) {
            return false;
        }
        this.f35786e.m49604k();
        return false;
    }
}
