package com.huawei.uikit.hwrecyclerview.widget;

import android.annotation.TargetApi;
import android.util.Pair;

@TargetApi(5)
/* loaded from: classes4.dex */
public class HwPositionPair extends Pair<Integer, Integer> implements Comparable<HwPositionPair> {
    public HwPositionPair(Integer num, Integer num2) {
        super(num, num2);
    }

    @Override // java.lang.Comparable
    public int compareTo(HwPositionPair hwPositionPair) {
        if (((Integer) ((Pair) this).second).intValue() < ((Integer) ((Pair) hwPositionPair).first).intValue()) {
            return -1;
        }
        return ((Integer) ((Pair) this).first).intValue() > ((Integer) ((Pair) hwPositionPair).second).intValue() ? 1 : 0;
    }
}
