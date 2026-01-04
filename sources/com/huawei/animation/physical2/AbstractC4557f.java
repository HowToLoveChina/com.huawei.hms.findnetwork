package com.huawei.animation.physical2;

import android.os.SystemClock;
import android.util.Log;
import com.huawei.animation.physical2.AbstractC4561j;

/* renamed from: com.huawei.animation.physical2.f */
/* loaded from: classes4.dex */
public abstract class AbstractC4557f extends AbstractC4561j {
    private static final String TAG = "SimpleSpringNode";
    protected int maximumDistanceDelta;
    protected int minimumDistanceDelta;
    protected C4559h spring;
    protected float value;
    protected float valueAccuracy;
    protected float velocity;

    public AbstractC4557f(int i10, float f10) {
        super(i10);
        this.velocity = 0.0f;
        this.valueAccuracy = 1.0f;
        this.minimumDistanceDelta = -1;
        this.maximumDistanceDelta = -1;
        this.value = f10;
        this.spring = new C4559h();
    }

    @Override // com.huawei.animation.physical2.AbstractC4561j
    public void cancel() {
        this.isRunning = false;
        this.velocity = 0.0f;
        onEnd(this.value);
    }

    @Override // com.huawei.animation.physical2.AbstractC4561j
    public void doDistanceToNeighbor() {
    }

    @Override // com.huawei.animation.physical2.AbstractC4561j
    public void endToValue(float f10, float f11) {
        super.endToValue(f10, f11);
        if (this.isRunning) {
            if (this.adapter.mo27977a().isAnimToEnd()) {
                this.startTime = SystemClock.uptimeMillis() - 16;
            } else {
                this.startTime = SystemClock.uptimeMillis() - ((int) (getFrameDelta() * 16.0f));
            }
            this.spring.m28015i(this.value).m28014h(f10).m28016j(this.velocity).m28018l(this.valueAccuracy).m28011e();
            onRunning();
        } else {
            this.startTime = SystemClock.uptimeMillis();
            this.isRunning = true;
            this.spring.m28015i(this.value).m28014h(f10).m28016j(f11).m28018l(this.valueAccuracy).m28011e();
            isDoFrame();
        }
        notifyNext(f10, f11);
    }

    public float getValue() {
        return this.value;
    }

    public float getVelocity() {
        return this.velocity;
    }

    @Override // com.huawei.animation.physical2.AbstractC4561j
    public boolean isDoFrame() {
        if (!this.isRunning) {
            return true;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.value = this.spring.m28009c(jUptimeMillis);
        float fM28010d = this.spring.m28010d(jUptimeMillis);
        this.velocity = fM28010d;
        if (this.spring.m28012f(this.value, fM28010d)) {
            this.isRunning = false;
            this.value = this.spring.m28008b();
            this.velocity = 0.0f;
            onUpdateInternal();
            onEnd(this.value);
            Log.w(TAG, "isDoFrame: index:" + getIndex() + " is at equilibrium value:" + this.value);
        } else {
            onUpdateInternal();
            this.isRunning = true;
        }
        return !this.isRunning;
    }

    public void notifyNext(float f10, float f11) {
        if (this != this.adapter.mo27977a()) {
            return;
        }
        AbstractC4561j abstractC4561jMo27978b = this.adapter.mo27978b(this);
        while (abstractC4561jMo27978b != null) {
            abstractC4561jMo27978b.endToValue(f10, f11);
            abstractC4561jMo27978b = this.adapter.mo27978b(abstractC4561jMo27978b);
        }
    }

    public void onUpdateInternal() {
        onUpdate(this.value, this.velocity);
        for (AbstractC4561j.a aVar : this.listenerList) {
            if (aVar != null) {
                aVar.m28023a(this.value, this.velocity);
            }
        }
    }

    public void resetNode(float f10, float f11) {
        this.value = f10;
        this.velocity = f11;
        onUpdateInternal();
    }

    @Override // com.huawei.animation.physical2.AbstractC4561j
    public void resetValue(float f10) {
        this.value = f10;
        onUpdateInternal();
    }

    @Override // com.huawei.animation.physical2.AbstractC4561j
    public void setDistanceDelta(int i10, int i11) {
        if (i10 < 0 || i11 < 0 || i11 < i10) {
            return;
        }
        this.minimumDistanceDelta = i10;
        this.maximumDistanceDelta = i11;
    }

    @Override // com.huawei.animation.physical2.AbstractC4561j
    public void setValue(float f10) {
        super.setValue(f10);
        this.value = f10;
        onUpdateInternal();
        notifyNext(f10, this.velocity);
    }

    public AbstractC4557f setValueAccuracy(float f10) {
        this.valueAccuracy = f10;
        return this;
    }

    @Override // com.huawei.animation.physical2.AbstractC4561j
    public void transferParams(float f10, float f11) {
        this.spring.m28017k(f10).m28013g(f11);
    }

    public AbstractC4557f(int i10) {
        this(i10, 0.0f);
    }
}
