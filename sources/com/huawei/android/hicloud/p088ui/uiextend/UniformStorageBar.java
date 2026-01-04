package com.huawei.android.hicloud.p088ui.uiextend;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.android.hicloud.cloudspace.bean.StorageModuleInfo;
import com.huawei.android.p073ds.R$color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0213f;
import p514o9.C11839m;
import p514o9.C11842p;
import p703v8.C13368e;
import p771xd.C13772p;
import p771xd.C13774r;

/* loaded from: classes3.dex */
public class UniformStorageBar extends View {
    private static final int GAP_WIDTH_DP = 2;
    private static final int LEVEL_BASE_VALUE = 10000;
    private static final int MARGIN_HORIZON_DP = 32;
    private static final int RADIUS_5DP = 5;
    private static final String TAG = "UniformStorageBar";
    private C13772p mCurrentLevelValue;
    private ArrayList<Float> mCurrentPercentValues;
    private ArrayList<ClipDrawable> mDataClipLayers;
    public int mDisplayCount;
    private ArrayList<ClipDrawable> mGapClipLayers;
    private int mGapWidthPX;
    private LayerDrawable mLayerDrawable;
    private ClipDrawable mSpaceFullClipLayer;
    private C13774r mStorageBarEvaluator;
    private int mStorageBarWidthPx;
    private C13772p mTargetLevelValue;
    private ValueAnimator.AnimatorUpdateListener updateListener;
    private ValueAnimator valueAnimator;

    public UniformStorageBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDataClipLayers = new ArrayList<>();
        this.mGapClipLayers = new ArrayList<>();
        this.mCurrentPercentValues = new ArrayList<>();
        this.updateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.android.hicloud.ui.uiextend.UniformStorageBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                C13772p c13772p = (C13772p) valueAnimator.getAnimatedValue();
                if (c13772p == null) {
                    C11839m.m70687e(UniformStorageBar.TAG, "onAnimationUpdate showLevel is null");
                } else {
                    UniformStorageBar.this.validateBar(c13772p);
                }
            }
        };
        this.mGapWidthPX = C11842p.m70840n(context, 2);
        updateBarWidth();
    }

    private LayerDrawable buildLayerDrawable() {
        List<StorageModuleInfo> listM80227Q = C13368e.m80184F().m80227Q();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        arrayList.add(buildProgressGradientDrawable(getResources().getColor(R$color.storage_bar_default_color, null)));
        if (listM80227Q.size() > 0) {
            for (int size = listM80227Q.size() - 1; size >= 0; size--) {
                if (listM80227Q.get(size) != null) {
                    ClipDrawable clipDrawableBuildProgressClipDrawable = buildProgressClipDrawable(getResources().getColor(R$color.uniform_bar_gap_color, null));
                    ClipDrawable clipDrawableBuildProgressClipDrawable2 = buildProgressClipDrawable(getResources().getColor(R$color.emui_color_gray_1));
                    arrayList.add(clipDrawableBuildProgressClipDrawable);
                    arrayList.add(clipDrawableBuildProgressClipDrawable2);
                    arrayList2.add(clipDrawableBuildProgressClipDrawable);
                    arrayList3.add(clipDrawableBuildProgressClipDrawable2);
                }
            }
            this.mGapClipLayers.clear();
            this.mDataClipLayers.clear();
            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                ClipDrawable clipDrawable = (ClipDrawable) arrayList2.get(size2);
                ClipDrawable clipDrawable2 = (ClipDrawable) arrayList3.get(size2);
                this.mGapClipLayers.add(clipDrawable);
                this.mDataClipLayers.add(clipDrawable2);
            }
        }
        ClipDrawable clipDrawableBuildProgressClipDrawable3 = buildProgressClipDrawable(getResources().getColor(R$color.emui_color_8, null));
        this.mSpaceFullClipLayer = clipDrawableBuildProgressClipDrawable3;
        arrayList.add(clipDrawableBuildProgressClipDrawable3);
        LayerDrawable layerDrawable = new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[arrayList.size()]));
        this.mLayerDrawable = layerDrawable;
        return layerDrawable;
    }

    private ClipDrawable buildProgressClipDrawable(int i10) {
        return new ClipDrawable(buildProgressGradientDrawable(i10), 8388611, 1);
    }

    private GradientDrawable buildProgressGradientDrawable(int i10) {
        int iM70840n = C11842p.m70840n(C0213f.m1377a(), 5);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i10);
        gradientDrawable.setCornerRadius(iM70840n);
        return gradientDrawable;
    }

    private void calcCheck(float f10, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        int i10 = 10000 / this.mStorageBarWidthPx;
        for (int i11 = 0; i11 < this.mDisplayCount; i11++) {
            if (i11 == 0) {
                int iIntValue = (arrayList.get(i11).intValue() * this.mStorageBarWidthPx) / 10000;
                if (iIntValue > this.mCurrentPercentValues.get(i11).floatValue() * this.mStorageBarWidthPx) {
                    arrayList.set(i11, Integer.valueOf(arrayList.get(i11).intValue() - i10));
                }
                arrayList2.set(i11, Integer.valueOf(arrayList.get(i11).intValue() + arrayList2.get(i11).intValue()));
                if (((arrayList2.get(i11).intValue() * this.mStorageBarWidthPx) / 10000) - iIntValue > this.mGapWidthPX) {
                    arrayList2.set(i11, Integer.valueOf(arrayList2.get(i11).intValue() - i10));
                }
            } else {
                int i12 = i11 - 1;
                arrayList.set(i11, Integer.valueOf(arrayList2.get(i12).intValue() + arrayList.get(i11).intValue()));
                int iIntValue2 = ((arrayList.get(i11).intValue() * this.mStorageBarWidthPx) / 10000) - ((arrayList2.get(i12).intValue() * this.mStorageBarWidthPx) / 10000);
                if (this.mCurrentPercentValues.get(i11).floatValue() <= f10) {
                    if (iIntValue2 > this.mGapWidthPX) {
                        arrayList.set(i11, Integer.valueOf(arrayList.get(i11).intValue() - i10));
                    }
                } else if (iIntValue2 > this.mCurrentPercentValues.get(i11).floatValue() * this.mStorageBarWidthPx) {
                    arrayList.set(i11, Integer.valueOf(arrayList.get(i11).intValue() - i10));
                }
                arrayList2.set(i11, Integer.valueOf(arrayList.get(i11).intValue() + arrayList2.get(i11).intValue()));
                if (((arrayList2.get(i11).intValue() * this.mStorageBarWidthPx) / 10000) - ((arrayList.get(i11).intValue() * this.mStorageBarWidthPx) / 10000) > this.mGapWidthPX) {
                    arrayList2.set(i11, Integer.valueOf(arrayList2.get(i11).intValue() - i10));
                }
            }
        }
    }

    private void calculateTargetLevel() {
        updateBarWidth();
        int i10 = this.mStorageBarWidthPx;
        if (i10 == 0) {
            C11839m.m70687e(TAG, "bar width zero");
            return;
        }
        float f10 = this.mGapWidthPX / i10;
        int iRound = Math.round(f10 * 10000.0f);
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i11 = 0; i11 < this.mDisplayCount; i11++) {
            arrayList.add(0);
            arrayList2.add(0);
        }
        int i12 = 0;
        int iIntValue = 0;
        for (int i13 = 0; i13 < this.mDisplayCount; i13++) {
            if (this.mCurrentPercentValues.get(i13).floatValue() <= 0.0f) {
                arrayList.set(i13, 0);
                arrayList2.set(i13, 0);
            } else {
                if (this.mCurrentPercentValues.get(i13).floatValue() <= 0.0f || this.mCurrentPercentValues.get(i13).floatValue() > f10) {
                    arrayList.set(i13, Integer.valueOf(Math.round(this.mCurrentPercentValues.get(i13).floatValue() * 10000.0f)));
                } else {
                    arrayList.set(i13, Integer.valueOf(iRound));
                    i12 += iRound;
                }
                arrayList2.set(i13, Integer.valueOf(iRound));
                i12 += iRound;
                iIntValue += arrayList.get(i13).intValue() + arrayList2.get(i13).intValue();
            }
        }
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (arrayList.get(size).intValue() > 0) {
                arrayList2.set(size, 0);
                i12 -= iRound;
                iIntValue -= iRound;
                break;
            }
            size--;
        }
        int i14 = i12;
        if (iIntValue > 10000) {
            arrayList = dealOutBoundary(arrayList, i14, iRound, this.mCurrentPercentValues, 10000);
        }
        if (arrayList == null) {
            return;
        }
        calcCheck(f10, arrayList, arrayList2);
        this.mTargetLevelValue.m82687e(arrayList, arrayList2);
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

    private void initLevelAndAnimator() {
        C11839m.m70688i(TAG, "initLevelAndAnimator");
        this.mCurrentLevelValue = new C13772p(this.mDisplayCount);
        this.mTargetLevelValue = new C13772p(this.mDisplayCount);
        C13774r c13774r = new C13774r(this.mDisplayCount);
        this.mStorageBarEvaluator = c13774r;
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(c13774r, this.mCurrentLevelValue, this.mTargetLevelValue);
        this.valueAnimator = valueAnimatorOfObject;
        valueAnimatorOfObject.addUpdateListener(this.updateListener);
        this.mCurrentPercentValues.clear();
        for (int i10 = 0; i10 < this.mDisplayCount; i10++) {
            this.mCurrentPercentValues.add(Float.valueOf(0.0f));
        }
    }

    private boolean isLevelEqual() {
        return this.mCurrentLevelValue.m82686d(this.mTargetLevelValue);
    }

    private boolean isPercentEqual(ArrayList<Float> arrayList) {
        for (int i10 = 0; i10 < this.mDisplayCount; i10++) {
            if (!this.mCurrentPercentValues.get(i10).equals(arrayList.get(i10))) {
                return false;
            }
        }
        return true;
    }

    private void refreshDrawableColor(ArrayList<StorageModuleInfo> arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.size() == this.mDisplayCount) {
                    for (int i10 = 0; i10 < this.mDisplayCount; i10++) {
                        ClipDrawable clipDrawable = this.mDataClipLayers.get(i10);
                        StorageModuleInfo storageModuleInfo = arrayList.get(i10);
                        if (storageModuleInfo == null) {
                            C11839m.m70688i(TAG, "refreshDrawableColor moduleInfo null");
                            return;
                        }
                        int moduleColor = storageModuleInfo.getModuleColor();
                        if (C11842p.m70732H0(getContext())) {
                            moduleColor = storageModuleInfo.getModuleDarkColor();
                        }
                        clipDrawable.setDrawable(buildProgressGradientDrawable(moduleColor));
                    }
                    return;
                }
            } catch (Exception e10) {
                C11839m.m70688i(TAG, "refreshDrawableColor exception:" + e10.toString());
                return;
            }
        }
        C11839m.m70688i(TAG, "refresh percents array null or wrong size");
    }

    private void startRefreshAnim(ArrayList<Float> arrayList) {
        if (isPercentEqual(arrayList)) {
            C11839m.m70688i(TAG, "TargetPercent Equal");
            return;
        }
        updateCurrentLevel(this.mTargetLevelValue);
        updateCurrentPercent(arrayList);
        calculateTargetLevel();
        if (isLevelEqual()) {
            C11839m.m70688i(TAG, "Level Equal");
        } else {
            this.valueAnimator.setDuration(1500L);
            this.valueAnimator.start();
        }
    }

    private void updateBarWidth() {
        if (C11842p.m70753O0(getContext())) {
            this.mStorageBarWidthPx = C11842p.m70752O(getContext()) - C11842p.m70840n(getContext(), 32);
        } else {
            this.mStorageBarWidthPx = C11842p.m70758Q(getContext()) - C11842p.m70840n(getContext(), 32);
        }
    }

    private void updateCurrentLevel(C13772p c13772p) {
        this.mCurrentLevelValue.m82688f(c13772p);
    }

    private void updateCurrentPercent(ArrayList<Float> arrayList) {
        C11839m.m70688i(TAG, "enter updateCurrentPercent");
        if (arrayList == null || arrayList.size() != this.mCurrentPercentValues.size()) {
            return;
        }
        for (int i10 = 0; i10 < this.mCurrentPercentValues.size() && arrayList.get(i10) != null; i10++) {
            this.mCurrentPercentValues.set(i10, arrayList.get(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateBar(C13772p c13772p) {
        if (c13772p == null) {
            return;
        }
        try {
            ArrayList<Integer> arrayListM82684b = c13772p.m82684b();
            ArrayList<Integer> arrayListM82685c = c13772p.m82685c();
            if (arrayListM82684b != null && arrayListM82684b.size() == this.mDisplayCount && arrayListM82685c != null && arrayListM82685c.size() == this.mDisplayCount) {
                for (int i10 = 0; i10 < this.mDisplayCount && arrayListM82684b.get(i10) != null && arrayListM82685c.get(i10) != null; i10++) {
                    ClipDrawable clipDrawable = this.mDataClipLayers.get(i10);
                    ClipDrawable clipDrawable2 = this.mGapClipLayers.get(i10);
                    if (clipDrawable != null && clipDrawable2 != null) {
                        clipDrawable.setLevel(arrayListM82684b.get(i10).intValue());
                        clipDrawable2.setLevel(arrayListM82685c.get(i10).intValue());
                    }
                    return;
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "validateBar exception:" + e10.toString());
        }
    }

    public void clearAll() {
        C13772p c13772p = this.mCurrentLevelValue;
        if (c13772p != null && this.mTargetLevelValue != null) {
            c13772p.m82683a();
            this.mTargetLevelValue.m82683a();
            validateBar(this.mCurrentLevelValue);
        }
        clearSpaceFull();
    }

    public boolean clearSpaceFull() {
        ClipDrawable clipDrawable = this.mSpaceFullClipLayer;
        if (clipDrawable != null) {
            return clipDrawable.setLevel(0);
        }
        return false;
    }

    public void initLayerBackground() {
        this.mLayerDrawable = buildLayerDrawable();
        setDisplayCount();
        initLevelAndAnimator();
        setBackground(this.mLayerDrawable);
    }

    public void refresh(ArrayList<StorageModuleInfo> arrayList) {
        refreshDrawableColor(arrayList);
        refreshArray(arrayList);
    }

    public void refreshArray(ArrayList<StorageModuleInfo> arrayList) {
        if (arrayList == null || arrayList.size() != this.mDisplayCount) {
            C11839m.m70688i(TAG, "percents array null or wrong size");
            return;
        }
        ArrayList<Float> arrayList2 = new ArrayList<>();
        Iterator<StorageModuleInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(it.next().getPercent()));
        }
        synchronized (this) {
            startRefreshAnim(arrayList2);
        }
    }

    public void reset() {
        ArrayList<StorageModuleInfo> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < this.mDisplayCount; i10++) {
            arrayList.add(new StorageModuleInfo());
        }
        refresh(arrayList);
    }

    public void setDisplayCount() {
        this.mDisplayCount = C13368e.m80184F().m80227Q().size();
    }

    public boolean showSpaceFull() {
        ClipDrawable clipDrawable = this.mSpaceFullClipLayer;
        if (clipDrawable != null) {
            return clipDrawable.setLevel(10000);
        }
        return false;
    }

    public void updateDirection() {
        calculateTargetLevel();
        validateBar(this.mTargetLevelValue);
    }
}
