package com.huawei.animation.physical2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.huawei.animation.physical2.j */
/* loaded from: classes4.dex */
public abstract class AbstractC4561j {
    protected AbstractC4560i adapter;
    private int index;
    protected long startTime;
    protected List<a> listenerList = new CopyOnWriteArrayList();
    protected boolean isRunning = false;
    private float frameDelta = 1.0f;
    private boolean isAnimToEnd = false;
    private int distance = -1;

    /* renamed from: com.huawei.animation.physical2.j$a */
    public interface a {
        /* renamed from: a */
        void m28023a(float f10, float f11);
    }

    public AbstractC4561j(int i10) {
        this.index = i10;
    }

    public AbstractC4561j addListener(a aVar) {
        if (aVar != null) {
            this.listenerList.add(aVar);
        }
        return this;
    }

    public abstract void cancel();

    public abstract void doDistanceToNeighbor();

    public void endToValue(float f10, float f11) {
        this.isAnimToEnd = true;
    }

    public AbstractC4560i getAdapter() {
        return this.adapter;
    }

    public int getDistance() {
        return this.distance;
    }

    public float getFrameDelta() {
        return this.frameDelta;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isAnimToEnd() {
        return this.isAnimToEnd;
    }

    public boolean isDoFrame() {
        return true;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void onEnd(float f10) {
    }

    public void onRunning() {
    }

    public void onUpdate(float f10, float f11) {
    }

    public AbstractC4561j removeListener(a aVar) {
        this.listenerList.remove(aVar);
        return this;
    }

    public void resetValue(float f10) {
    }

    public AbstractC4561j setAdapter(AbstractC4560i abstractC4560i) {
        this.adapter = abstractC4560i;
        return this;
    }

    public AbstractC4561j setAnimToEnd(boolean z10) {
        this.isAnimToEnd = z10;
        return this;
    }

    public void setDistance(int i10) {
        this.distance = i10;
    }

    public abstract void setDistanceDelta(int i10, int i11);

    public AbstractC4561j setFrameDelta(float f10) {
        this.frameDelta = f10;
        return this;
    }

    public AbstractC4561j setIndex(int i10) {
        this.index = i10;
        return this;
    }

    public void setValue(float f10) {
        this.isAnimToEnd = false;
    }

    public abstract void transferParams(float f10, float f11);

    public void endToValue(float f10, float f11, float f12, float f13) {
        this.isAnimToEnd = true;
    }

    public void onEnd(float f10, float f11) {
    }

    public void onUpdate(float f10, float f11, float f12, float f13) {
    }

    public void resetValue(float f10, float f11) {
    }

    public void setValue(float f10, float f11) {
        this.isAnimToEnd = false;
    }
}
