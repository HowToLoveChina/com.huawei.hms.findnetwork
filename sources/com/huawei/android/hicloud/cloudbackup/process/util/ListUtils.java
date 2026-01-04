package com.huawei.android.hicloud.cloudbackup.process.util;

import java.util.AbstractList;
import java.util.List;

/* loaded from: classes2.dex */
public class ListUtils {

    public static class Partition<T> extends AbstractList<List<T>> {
        private final List<T> list;
        private final int size;

        public Partition(List<T> list, int i10) {
            this.list = list;
            this.size = i10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size() % this.size > 0 ? (this.list.size() / this.size) + 1 : this.list.size() / this.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> get(int i10) {
            int size = size();
            if (i10 < 0) {
                throw new IndexOutOfBoundsException("Index " + i10 + "must not be negative");
            }
            if (i10 < size) {
                int i11 = this.size;
                int i12 = i10 * i11;
                return this.list.subList(i12, Math.min(i11 + i12, this.list.size()));
            }
            throw new IndexOutOfBoundsException("Index " + i10 + "must be less than size " + size);
        }
    }

    public static <T> List<List<T>> partition(List<T> list, int i10) {
        return new Partition(list, i10);
    }
}
