package com.huawei.uikit.hwrecyclerview.widget;

import android.annotation.TargetApi;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class HwListDeleteAnimationHelper {
    public static final int DIRECTION_TO_ADAPTER = 1;
    public static final int DIRECTION_TO_LIST = 0;

    /* renamed from: d */
    private static final String f43716d = "HwListDeleteAnimationHelper";

    /* renamed from: e */
    private static final int f43717e = -1;

    /* renamed from: f */
    private static final int f43718f = 10;

    /* renamed from: a */
    private HwAvlTree<HwPositionPair> f43719a = new HwAvlTree<>();

    /* renamed from: b */
    private int f43720b = 0;

    /* renamed from: c */
    private int f43721c = 0;

    @TargetApi(5)
    /* renamed from: a */
    private boolean m55164a(HwPositionPair hwPositionPair, int i10) {
        if (((Integer) ((Pair) hwPositionPair).first).intValue() >= 0 && ((Integer) ((Pair) hwPositionPair).first).intValue() < i10 && ((Integer) ((Pair) hwPositionPair).second).intValue() >= 0 && ((Integer) ((Pair) hwPositionPair).second).intValue() < i10) {
            return true;
        }
        Log.e(f43716d, "isPositionPairValid: position is invalid. positionPair: " + hwPositionPair + " itemCount: " + i10);
        return false;
    }

    @TargetApi(5)
    /* renamed from: b */
    private int m55165b(HwPositionPair hwPositionPair) {
        int iIntValue = 0;
        for (T t10 : this.f43719a.searchAllMatchKey(hwPositionPair)) {
            hwPositionPair = m55163a(t10, hwPositionPair);
            this.f43719a.remove(t10);
            iIntValue += (((Integer) ((Pair) t10).second).intValue() - ((Integer) ((Pair) t10).first).intValue()) + 1;
        }
        this.f43719a.insert(hwPositionPair);
        return ((((Integer) ((Pair) hwPositionPair).second).intValue() - ((Integer) ((Pair) hwPositionPair).first).intValue()) + 1) - iIntValue;
    }

    @TargetApi(5)
    /* renamed from: c */
    private void m55166c(HwPositionPair hwPositionPair) {
        if (!m55164a(hwPositionPair, this.f43720b)) {
            Log.e(f43716d, "recordRemovedItemRange, input range error, positionPair: " + hwPositionPair);
            return;
        }
        if (this.f43719a.search(hwPositionPair) == null) {
            this.f43719a.insert(hwPositionPair);
            this.f43721c += (((Integer) ((Pair) hwPositionPair).second).intValue() - ((Integer) ((Pair) hwPositionPair).first).intValue()) + 1;
            return;
        }
        int iM55165b = m55165b(hwPositionPair);
        if (iM55165b > 0) {
            this.f43721c += iM55165b;
            return;
        }
        Log.e(f43716d, "recordRemovedItemRange merge position error, newAddedCount: " + iM55165b + " positionPair: " + hwPositionPair);
    }

    public void clearRemovedItemsRecord() {
        if (this.f43719a.isEmpty()) {
            return;
        }
        this.f43719a = new HwAvlTree<>();
        this.f43721c = 0;
    }

    @TargetApi(5)
    public void recordRemovedItemRange(HwPositionPair hwPositionPair) {
        ArrayList arrayList = new ArrayList();
        int i10 = -1;
        int i11 = -1;
        for (int iIntValue = ((Integer) ((Pair) hwPositionPair).first).intValue(); iIntValue <= ((Integer) ((Pair) hwPositionPair).second).intValue(); iIntValue++) {
            int iUpdateItemPosition = updateItemPosition(iIntValue, 1);
            if (i10 != -1) {
                int i12 = i11 + 1;
                if (iUpdateItemPosition == i12) {
                    i11 = i12;
                } else {
                    arrayList.add(new HwPositionPair(Integer.valueOf(i10), Integer.valueOf(i11)));
                    i10 = iUpdateItemPosition;
                    i11 = i10;
                }
            } else {
                i10 = iUpdateItemPosition;
                i11 = i10;
            }
        }
        if (i10 != -1) {
            arrayList.add(new HwPositionPair(Integer.valueOf(i10), Integer.valueOf(i11)));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m55166c((HwPositionPair) it.next());
        }
    }

    public int updateItemCount(int i10) {
        this.f43720b = i10;
        return i10 - this.f43721c;
    }

    public int updateItemPosition(int i10, int i11) {
        if (i11 != 0 && i11 != 1) {
            Log.e(f43716d, "updateItemPosition, mappingDirection error, position: " + i10 + " mappingDirection: " + i11);
            return -1;
        }
        int i12 = this.f43720b;
        if (i12 == 0) {
            Log.e(f43716d, "updateItemPosition, mRealItemCount error, position: " + i10);
            return -1;
        }
        if (i10 < 0 || i10 >= i12) {
            Log.e(f43716d, "updateItemPosition, input error, position: " + i10);
            return -1;
        }
        if (this.f43721c != 0) {
            if (i11 != 0) {
                return m55161a(i10);
            }
            if (this.f43719a.search(new HwPositionPair(Integer.valueOf(i10), Integer.valueOf(i10))) != null) {
                return -1;
            }
            return i10 - m55162a(new HwPositionPair(0, Integer.valueOf(i10 - 1)));
        }
        if (i10 % 10 == 0) {
            Log.e(f43716d, "updateItemPosition, end, mRecordItemCount is zero, position: " + i10 + " mappingDirection: " + i11);
        }
        return i10;
    }

    @TargetApi(5)
    /* renamed from: a */
    private HwPositionPair m55163a(HwPositionPair hwPositionPair, HwPositionPair hwPositionPair2) {
        Integer num = (Integer) (((Integer) ((Pair) hwPositionPair).first).intValue() < ((Integer) ((Pair) hwPositionPair2).first).intValue() ? ((Pair) hwPositionPair).first : ((Pair) hwPositionPair2).first);
        num.intValue();
        Integer num2 = (Integer) (((Integer) ((Pair) hwPositionPair).second).intValue() > ((Integer) ((Pair) hwPositionPair2).second).intValue() ? ((Pair) hwPositionPair).second : ((Pair) hwPositionPair2).second);
        num2.intValue();
        return new HwPositionPair(num, num2);
    }

    @TargetApi(5)
    /* renamed from: a */
    private int m55162a(HwPositionPair hwPositionPair) {
        int iIntValue = 0;
        for (T t10 : this.f43719a.searchAllMatchKey(hwPositionPair)) {
            iIntValue += (((Integer) ((Pair) t10).second).intValue() - ((Integer) ((Pair) t10).first).intValue()) + 1;
        }
        return iIntValue;
    }

    @TargetApi(5)
    /* renamed from: a */
    private int m55161a(int i10) {
        int iIntValue = -1;
        int i11 = -1;
        for (T t10 : this.f43719a.getInOrderNodes()) {
            int iIntValue2 = ((Integer) ((Pair) t10).first).intValue() == 0 ? 0 : (((Integer) ((Pair) t10).first).intValue() - 1) - iIntValue;
            if (iIntValue2 < 0) {
                Log.e(f43716d, "findPositionDirectionToAdapter failed, newStep: " + iIntValue2 + " positionPair.first: " + ((Pair) t10).first + " lastPairSecond: " + iIntValue + " position: " + i10);
                return -1;
            }
            int i12 = iIntValue2 + i11;
            if (i10 <= i12) {
                return iIntValue + (i10 - i11);
            }
            iIntValue = ((Integer) ((Pair) t10).second).intValue();
            i11 = i12;
        }
        int i13 = (i10 - i11) + iIntValue;
        if (i13 < this.f43720b) {
            return i13;
        }
        Log.e(f43716d, "findPositionDirectionToAdapter failed, updatedPosition: " + i13 + " exceeds max, lastPairSecond: " + iIntValue + " position: " + i10 + " currentPosition: " + i11);
        return -1;
    }
}
