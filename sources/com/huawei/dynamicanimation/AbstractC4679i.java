package com.huawei.dynamicanimation;

/* renamed from: com.huawei.dynamicanimation.i */
/* loaded from: classes5.dex */
public abstract class AbstractC4679i implements InterfaceC4678h {
    public static final float DEFAULT_END_POSITION0 = 0.0f;
    public static final float DEFAULT_END_POSITION1 = 1.0f;
    public static final float DEFAULT_INITIAL_VELOCITY = 0.0f;
    public static final float MAXIMUM_END_POSITION0 = 0.0f;
    public static final float MAXIMUM_END_POSITION1 = 99999.0f;
    public static final float MAXIMUM_INITIAL_VELOCITY = 99999.0f;
    public static final float MINIMUM_END_POSITION0 = 0.0f;
    public static final float MINIMUM_END_POSITION1 = -99999.0f;
    public static final float MINIMUM_INITIAL_VELOCITY = -99999.0f;
    protected static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
    protected float mStartPosition = 0.0f;
    protected float mEndPosition = 0.0f;
    protected long mStartTime = 0;
    protected float mStartVelocity = 0.0f;
    protected float mValueThreshold = Float.MIN_VALUE;
    protected float mVelocityThreshold = Float.MIN_VALUE;

    public abstract float getAcceleration();

    public abstract float getAcceleration(float f10);

    public float getEndPosition() {
        return this.mEndPosition;
    }

    public abstract float getEstimatedDuration();

    public abstract float getMaxAbsX();

    public abstract float getPosition();

    public abstract float getPosition(float f10);

    public float getStartPosition() {
        return this.mStartPosition;
    }

    public float getStartTime() {
        return this.mStartTime;
    }

    public float getStartVelocity() {
        return this.mStartVelocity;
    }

    public abstract float getVelocity();

    public abstract float getVelocity(float f10);

    public abstract boolean isAtEquilibrium();

    public abstract boolean isAtEquilibrium(float f10);

    public abstract boolean isAtEquilibrium(float f10, float f11);

    public AbstractC4679i setEndPosition(float f10) {
        this.mEndPosition = f10;
        return this;
    }

    @Override // 
    public AbstractC4679i setValueThreshold(float f10) {
        float fAbs = Math.abs(f10);
        this.mValueThreshold = fAbs;
        this.mVelocityThreshold = fAbs * VELOCITY_THRESHOLD_MULTIPLIER;
        return this;
    }
}
