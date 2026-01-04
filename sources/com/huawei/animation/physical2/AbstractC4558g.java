package com.huawei.animation.physical2;

import android.os.SystemClock;
import android.util.Log;

/* renamed from: com.huawei.animation.physical2.g */
/* loaded from: classes4.dex */
public abstract class AbstractC4558g extends AbstractC4557f {
    private static final int DEFAULT_VALUE = 1;
    private static final String TAG = "SimpleSpringNodeEx";
    protected int fixMode;
    private float lastTheoryValue;

    public AbstractC4558g(int i10, float f10) {
        super(i10, f10);
        this.fixMode = 0;
        this.lastTheoryValue = 0.0f;
    }

    private void fixValue(float f10) {
        if (this.fixMode != 1) {
            this.value = f10;
        } else {
            simpleFixedValue(f10);
        }
    }

    private void simpleFixedValue(float f10) {
        if (this.fixMode != 1) {
            Log.w(TAG, "fix mode is unmatch.");
            this.value = f10;
            return;
        }
        float f11 = f10 - this.lastTheoryValue;
        this.lastTheoryValue = f10;
        if (Math.abs(f11) >= 1.0f) {
            this.value = f10;
        } else {
            this.value += Math.signum(f11);
        }
    }

    @Override // com.huawei.animation.physical2.AbstractC4557f, com.huawei.animation.physical2.AbstractC4561j
    public void doDistanceToNeighbor() {
        if (this.minimumDistanceDelta == -1 || this.maximumDistanceDelta == -1) {
            Log.w(TAG, "doDistanceToNeighbor: minimumDistanceDelta or maximumDistanceDelta is not configured.");
            return;
        }
        if (this.adapter.mo27977a().getIndex() > getIndex()) {
            AbstractC4561j abstractC4561jMo27979c = this.adapter.mo27979c(getIndex() + 1);
            if (!(abstractC4561jMo27979c instanceof AbstractC4557f)) {
                return;
            }
            float value = ((AbstractC4557f) abstractC4561jMo27979c).getValue();
            this.value = Math.max(Math.min(this.minimumDistanceDelta + value, this.value), value - this.maximumDistanceDelta);
        }
        if (this.adapter.mo27977a().getIndex() < getIndex()) {
            AbstractC4561j abstractC4561jMo27979c2 = this.adapter.mo27979c(getIndex() - 1);
            if (abstractC4561jMo27979c2 instanceof AbstractC4557f) {
                float value2 = ((AbstractC4557f) abstractC4561jMo27979c2).getValue();
                this.value = Math.max(Math.min(this.maximumDistanceDelta + value2, this.value), value2 - this.minimumDistanceDelta);
            }
        }
    }

    public int getFixMode() {
        return this.fixMode;
    }

    @Override // com.huawei.animation.physical2.AbstractC4557f, com.huawei.animation.physical2.AbstractC4561j
    public boolean isDoFrame() {
        if (!this.isRunning) {
            return true;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        float fM28009c = this.spring.m28009c(jUptimeMillis);
        fixValue(fM28009c);
        doDistanceToNeighbor();
        float fM28010d = this.spring.m28010d(jUptimeMillis);
        this.velocity = fM28010d;
        if (this.spring.m28012f(this.value, fM28010d) || this.spring.m28012f(fM28009c, this.velocity)) {
            this.isRunning = false;
            this.value = this.spring.m28008b();
            this.velocity = 0.0f;
            onUpdateInternal();
            onEnd(this.value);
            Log.w(TAG, "isDoFrame: index:" + getIndex() + " is at equilibrium value:" + this.value);
        } else {
            this.isRunning = true;
            onUpdateInternal();
        }
        return !this.isRunning;
    }

    @Override // com.huawei.animation.physical2.AbstractC4557f
    public void notifyNext(float f10, float f11) {
        AbstractC4560i abstractC4560i = this.adapter;
        if ((abstractC4560i instanceof C4555d) && this == abstractC4560i.mo27977a()) {
            C4555d c4555d = (C4555d) this.adapter;
            int iM27982h = c4555d.m27982h();
            for (int i10 = 1; i10 <= iM27982h; i10++) {
                int i11 = iM27982h + i10;
                if (c4555d.m27983i(i11)) {
                    this.adapter.mo27979c(i11).endToValue(f10, f11);
                }
                int i12 = iM27982h - i10;
                if (c4555d.m27983i(i12)) {
                    this.adapter.mo27979c(i12).endToValue(f10, f11);
                }
            }
        }
    }

    @Override // com.huawei.animation.physical2.AbstractC4561j
    public void onRunning() {
        doDistanceToNeighbor();
        onUpdateInternal();
    }

    public void setFixMode(int i10) {
        this.fixMode = i10;
    }

    public AbstractC4558g(int i10) {
        super(i10);
        this.fixMode = 0;
        this.lastTheoryValue = 0.0f;
    }
}
