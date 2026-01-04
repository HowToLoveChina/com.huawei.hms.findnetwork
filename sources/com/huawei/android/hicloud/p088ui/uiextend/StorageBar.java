package com.huawei.android.hicloud.p088ui.uiextend;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.android.p073ds.R$id;
import java.util.ArrayList;
import p514o9.C11839m;
import p514o9.C11842p;
import p771xd.C13771o;
import p771xd.C13772p;

/* loaded from: classes3.dex */
public class StorageBar extends View {
    private static final int GAP_WIDTH_DP = 2;
    private static final int LEVEL_BASE = 10000;
    private static final int MARGIN_HORIZON = 32;
    public static final int MAX_DISPLAY_COUNT = 4;
    private static final String TAG = "StorageBar";
    private C13772p mCurrentLevel;
    private ArrayList<Float> mCurrentPercents;
    private ArrayList<ClipDrawable> mDataClips;
    private ArrayList<ClipDrawable> mGapClips;
    private int mGapWidthPix;
    private LayerDrawable mLayerDrawable;
    private ClipDrawable mSpaceFullClip;
    private C13771o mStorageBarEvaluator;
    private int mStorageBarWidth;
    private C13772p mTargetLevel;
    private ValueAnimator.AnimatorUpdateListener updateListener;
    private ValueAnimator valueAnimator;

    public StorageBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDataClips = new ArrayList<>(4);
        this.mGapClips = new ArrayList<>(4);
        this.mCurrentPercents = new ArrayList<>(4);
        this.mStorageBarEvaluator = new C13771o();
        this.updateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.android.hicloud.ui.uiextend.StorageBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                C13772p c13772p = (C13772p) valueAnimator.getAnimatedValue();
                if (c13772p == null) {
                    C11839m.m70687e(StorageBar.TAG, "onAnimationUpdate showLevel null");
                } else {
                    StorageBar.this.validateBar(c13772p);
                }
            }
        };
        LayerDrawable layerDrawable = (LayerDrawable) getBackground();
        this.mLayerDrawable = layerDrawable;
        this.mDataClips.add((ClipDrawable) layerDrawable.findDrawableByLayerId(R$id.cloud_backup_layer));
        this.mDataClips.add((ClipDrawable) this.mLayerDrawable.findDrawableByLayerId(R$id.favorite_layer));
        this.mDataClips.add((ClipDrawable) this.mLayerDrawable.findDrawableByLayerId(R$id.gallery_layer));
        this.mDataClips.add((ClipDrawable) this.mLayerDrawable.findDrawableByLayerId(R$id.app_data_layer));
        this.mSpaceFullClip = (ClipDrawable) this.mLayerDrawable.findDrawableByLayerId(R$id.space_full_layer);
        this.mGapClips.add((ClipDrawable) this.mLayerDrawable.findDrawableByLayerId(R$id.cloud_backup_gap_layer));
        this.mGapClips.add((ClipDrawable) this.mLayerDrawable.findDrawableByLayerId(R$id.favorite_gap_layer));
        this.mGapClips.add((ClipDrawable) this.mLayerDrawable.findDrawableByLayerId(R$id.gallery_gap_layer));
        this.mGapClips.add((ClipDrawable) this.mLayerDrawable.findDrawableByLayerId(R$id.app_data_gap_layer));
        this.mCurrentLevel = new C13772p(4);
        C13772p c13772p = new C13772p(4);
        this.mTargetLevel = c13772p;
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(this.mStorageBarEvaluator, this.mCurrentLevel, c13772p);
        this.valueAnimator = valueAnimatorOfObject;
        valueAnimatorOfObject.addUpdateListener(this.updateListener);
        this.mGapWidthPix = C11842p.m70840n(context, 2);
        updateBarWidth();
        for (int i10 = 0; i10 < 4; i10++) {
            this.mCurrentPercents.add(Float.valueOf(0.0f));
        }
    }

    private void calcCheck(float f10, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        int i10 = 10000 / this.mStorageBarWidth;
        for (int i11 = 0; i11 < 4; i11++) {
            if (i11 == 0) {
                int iIntValue = (arrayList.get(i11).intValue() * this.mStorageBarWidth) / 10000;
                if (iIntValue > this.mCurrentPercents.get(i11).floatValue() * this.mStorageBarWidth) {
                    arrayList.set(i11, Integer.valueOf(arrayList.get(i11).intValue() - i10));
                }
                arrayList2.set(i11, Integer.valueOf(arrayList.get(i11).intValue() + arrayList2.get(i11).intValue()));
                if (((arrayList2.get(i11).intValue() * this.mStorageBarWidth) / 10000) - iIntValue > this.mGapWidthPix) {
                    arrayList2.set(i11, Integer.valueOf(arrayList2.get(i11).intValue() - i10));
                }
            } else {
                int i12 = i11 - 1;
                arrayList.set(i11, Integer.valueOf(arrayList2.get(i12).intValue() + arrayList.get(i11).intValue()));
                int iIntValue2 = ((arrayList.get(i11).intValue() * this.mStorageBarWidth) / 10000) - ((arrayList2.get(i12).intValue() * this.mStorageBarWidth) / 10000);
                if (this.mCurrentPercents.get(i11).floatValue() <= f10) {
                    if (iIntValue2 > this.mGapWidthPix) {
                        arrayList.set(i11, Integer.valueOf(arrayList.get(i11).intValue() - i10));
                    }
                } else if (iIntValue2 > this.mCurrentPercents.get(i11).floatValue() * this.mStorageBarWidth) {
                    arrayList.set(i11, Integer.valueOf(arrayList.get(i11).intValue() - i10));
                }
                arrayList2.set(i11, Integer.valueOf(arrayList.get(i11).intValue() + arrayList2.get(i11).intValue()));
                if (((arrayList2.get(i11).intValue() * this.mStorageBarWidth) / 10000) - ((arrayList.get(i11).intValue() * this.mStorageBarWidth) / 10000) > this.mGapWidthPix) {
                    arrayList2.set(i11, Integer.valueOf(arrayList2.get(i11).intValue() - i10));
                }
            }
        }
    }

    private void calculateTargetLevel() {
        updateBarWidth();
        int i10 = this.mStorageBarWidth;
        if (i10 == 0) {
            C11839m.m70687e(TAG, "bar width is zero");
            return;
        }
        float f10 = this.mGapWidthPix / i10;
        int iRound = Math.round(f10 * 10000.0f);
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        ArrayList<Integer> arrayList2 = new ArrayList<>(4);
        for (int i11 = 0; i11 < 4; i11++) {
            arrayList.add(0);
            arrayList2.add(0);
        }
        int i12 = 0;
        int iIntValue = 0;
        for (int i13 = 0; i13 < 4; i13++) {
            if (this.mCurrentPercents.get(i13).floatValue() <= 0.0f) {
                arrayList.set(i13, 0);
                arrayList2.set(i13, 0);
            } else {
                if (this.mCurrentPercents.get(i13).floatValue() <= 0.0f || this.mCurrentPercents.get(i13).floatValue() > f10) {
                    arrayList.set(i13, Integer.valueOf(Math.round(this.mCurrentPercents.get(i13).floatValue() * 10000.0f)));
                } else {
                    arrayList.set(i13, Integer.valueOf(iRound));
                    i12 += iRound;
                }
                arrayList2.set(i13, Integer.valueOf(iRound));
                i12 += iRound;
                iIntValue += arrayList.get(i13).intValue() + arrayList2.get(i13).intValue();
            }
        }
        if (iIntValue > 10000) {
            arrayList = dealOutBoundary(arrayList, i12, iRound, this.mCurrentPercents, 10000);
        }
        if (arrayList == null) {
            return;
        }
        calcCheck(f10, arrayList, arrayList2);
        this.mTargetLevel.m82687e(arrayList, arrayList2);
    }

    private boolean checkDataLevelsLegality(ArrayList<Integer> arrayList, ArrayList<Float> arrayList2) {
        int size;
        if (arrayList == null || arrayList2 == null || (size = arrayList.size()) == 0 || size != arrayList2.size()) {
            return true;
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (arrayList.get(i10) == null || arrayList2.get(i10) == null) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Integer> dealOutBoundary(ArrayList<Integer> arrayList, int i10, int i11, ArrayList<Float> arrayList2, int i12) {
        if (checkDataLevelsLegality(arrayList, arrayList2)) {
            return null;
        }
        int size = arrayList.size();
        ArrayList<Integer> arrayList3 = new ArrayList<>(size);
        for (int i13 = 0; i13 < size; i13++) {
            arrayList3.add(arrayList.get(i13));
        }
        int iIntValue = i12 - i10;
        while (true) {
            for (boolean z10 = false; !z10; z10 = true) {
                for (int i14 = 0; i14 < size; i14++) {
                    if (arrayList3.get(i14).intValue() != 0 && arrayList3.get(i14).intValue() > i11) {
                        int iRound = Math.round(arrayList2.get(i14).floatValue() * iIntValue);
                        if (iRound >= i11) {
                            arrayList3.set(i14, Integer.valueOf(iRound));
                        } else {
                            iIntValue -= arrayList3.get(i14).intValue() - i11;
                            arrayList3.set(i14, Integer.valueOf(i11));
                            if (i14 != 0) {
                                for (int i15 = i14 - 1; i15 >= 0; i15--) {
                                    arrayList3.set(i15, arrayList.get(i15));
                                }
                            }
                        }
                    }
                }
            }
            return arrayList3;
        }
    }

    private boolean isLevelEqual() {
        return this.mCurrentLevel.m82686d(this.mTargetLevel);
    }

    private boolean isPercentEqual(ArrayList<Float> arrayList) {
        for (int i10 = 0; i10 < 4; i10++) {
            if (!this.mCurrentPercents.get(i10).equals(arrayList.get(i10))) {
                return false;
            }
        }
        return true;
    }

    private void startRefreshAnim(ArrayList<Float> arrayList) {
        if (isPercentEqual(arrayList)) {
            C11839m.m70688i(TAG, "TargetPercent equal");
            return;
        }
        updateCurrentLevel(this.mTargetLevel);
        updateCurrentPercent(arrayList);
        calculateTargetLevel();
        if (isLevelEqual()) {
            C11839m.m70688i(TAG, "LevelEqual");
        } else {
            this.valueAnimator.setDuration(1500L);
            this.valueAnimator.start();
        }
    }

    private void updateBarWidth() {
        if (C11842p.m70753O0(getContext())) {
            this.mStorageBarWidth = C11842p.m70752O(getContext()) - C11842p.m70840n(getContext(), 32);
        } else {
            this.mStorageBarWidth = C11842p.m70758Q(getContext()) - C11842p.m70840n(getContext(), 32);
        }
    }

    private void updateCurrentLevel(C13772p c13772p) {
        this.mCurrentLevel.m82688f(c13772p);
    }

    private void updateCurrentPercent(ArrayList<Float> arrayList) {
        C11839m.m70688i(TAG, "enter updateCurrentPercent");
        if (arrayList == null || arrayList.size() != this.mCurrentPercents.size()) {
            return;
        }
        for (int i10 = 0; i10 < this.mCurrentPercents.size() && arrayList.get(i10) != null; i10++) {
            this.mCurrentPercents.set(i10, arrayList.get(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateBar(C13772p c13772p) {
        if (c13772p == null) {
            return;
        }
        ArrayList<Integer> arrayListM82684b = c13772p.m82684b();
        ArrayList<Integer> arrayListM82685c = c13772p.m82685c();
        if (arrayListM82684b == null || arrayListM82684b.size() != 4 || arrayListM82685c == null || arrayListM82685c.size() != 4) {
            return;
        }
        for (int i10 = 0; i10 < 4 && arrayListM82684b.get(i10) != null && arrayListM82685c.get(i10) != null; i10++) {
            ClipDrawable clipDrawable = this.mDataClips.get(i10);
            ClipDrawable clipDrawable2 = this.mGapClips.get(i10);
            if (clipDrawable == null || clipDrawable2 == null) {
                return;
            }
            clipDrawable.setLevel(arrayListM82684b.get(i10).intValue());
            clipDrawable2.setLevel(arrayListM82685c.get(i10).intValue());
        }
    }

    public void clearAll() {
        this.mCurrentLevel.m82683a();
        this.mTargetLevel.m82683a();
        validateBar(this.mCurrentLevel);
        clearSpaceFull();
    }

    public boolean clearSpaceFull() {
        return this.mSpaceFullClip.setLevel(0);
    }

    public void refresh(float f10, float f11, float f12, float f13) {
        ArrayList<Float> arrayList = new ArrayList<>(4);
        arrayList.add(Float.valueOf(f10));
        arrayList.add(Float.valueOf(f11));
        arrayList.add(Float.valueOf(f12));
        arrayList.add(Float.valueOf(f13));
        refreshArray(arrayList);
    }

    public void refreshArray(ArrayList<Float> arrayList) {
        if (arrayList == null || arrayList.size() != 4) {
            C11839m.m70688i(TAG, "percents array is null or wrong size");
        } else {
            synchronized (this) {
                startRefreshAnim(arrayList);
            }
        }
    }

    public boolean showSpaceFull() {
        return this.mSpaceFullClip.setLevel(10000);
    }

    public void updateDirection() {
        calculateTargetLevel();
        validateBar(this.mTargetLevel);
    }
}
