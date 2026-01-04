package com.huawei.hms.common.data;

import com.huawei.android.backup.service.utils.BackupConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes8.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        return freezeIterable(arrayList);
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        BackupConstant.C21561 c21561 = (ArrayList<T>) new ArrayList();
        if (iterable == null) {
            return c21561;
        }
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            c21561.add(it.next().freeze());
        }
        return c21561;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        return freezeIterable(Arrays.asList(eArr));
    }
}
