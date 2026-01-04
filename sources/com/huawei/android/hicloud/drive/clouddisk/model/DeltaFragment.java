package com.huawei.android.hicloud.drive.clouddisk.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Consumer;

/* loaded from: classes3.dex */
public class DeltaFragment {
    private static final byte[] EMPTY_HASH = new byte[32];
    private static final Comparator<DeltaFragment> FRAG_ORDER = new Comparator() { // from class: com.huawei.android.hicloud.drive.clouddisk.model.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return DeltaFragment.lambda$static$0((DeltaFragment) obj, (DeltaFragment) obj2);
        }
    };
    private short layerSeq;
    private long length;
    private long offset;
    private long position;
    private byte[] sha256;

    public DeltaFragment(long j10, long j11, byte[] bArr) {
        this.position = j10;
        this.length = j11;
        this.sha256 = bArr;
        this.layerSeq = (short) 0;
        this.offset = j10;
    }

    public static int compare(byte[] bArr, byte[] bArr2) {
        return compare(bArr, 0, bArr.length, bArr2, 0, bArr2.length);
    }

    public static List<DeltaFragment> diffDn(List<DeltaFragment> list, List<DeltaFragment> list2) {
        DeltaFragment next;
        ArrayList arrayList = new ArrayList();
        final TreeMap treeMap = new TreeMap(FRAG_ORDER);
        list.forEach(new Consumer() { // from class: com.huawei.android.hicloud.drive.clouddisk.model.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                DeltaFragment deltaFragment = (DeltaFragment) obj;
                treeMap.put(deltaFragment, deltaFragment);
            }
        });
        Iterator<DeltaFragment> it = list2.iterator();
        while (true) {
            DeltaFragment deltaFragment = null;
            while (it.hasNext()) {
                next = it.next();
                DeltaFragment deltaFragment2 = (DeltaFragment) treeMap.get(next);
                if (deltaFragment2 != null) {
                    if (deltaFragment != null && deltaFragment.getPosition() + deltaFragment.getLength() == next.getPosition() && deltaFragment.getOffset() + deltaFragment.getLength() == deltaFragment2.getOffset()) {
                        deltaFragment.setLength(deltaFragment.getLength() + deltaFragment2.getLength());
                    } else {
                        deltaFragment = new DeltaFragment(next.getPosition(), deltaFragment2.length, EMPTY_HASH, deltaFragment2.getLayerSeq(), deltaFragment2.getOffset());
                        arrayList.add(deltaFragment);
                    }
                }
            }
            return arrayList;
            arrayList.add(next);
        }
    }

    public static List<DeltaFragment> diffUp(List<DeltaFragment> list, List<DeltaFragment> list2) {
        ArrayList arrayList = new ArrayList();
        final TreeMap treeMap = new TreeMap(FRAG_ORDER);
        list.forEach(new Consumer() { // from class: com.huawei.android.hicloud.drive.clouddisk.model.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                DeltaFragment deltaFragment = (DeltaFragment) obj;
                treeMap.put(deltaFragment, deltaFragment);
            }
        });
        long length = 0;
        for (DeltaFragment deltaFragment : list2) {
            DeltaFragment deltaFragment2 = (DeltaFragment) treeMap.get(deltaFragment);
            if (deltaFragment2 != null) {
                arrayList.add(new DeltaFragment(deltaFragment.getPosition(), deltaFragment2.length, deltaFragment2.getSha256(), deltaFragment2.getLayerSeq(), deltaFragment2.getOffset()));
            } else {
                DeltaFragment deltaFragment3 = new DeltaFragment(deltaFragment.getPosition(), deltaFragment.length, deltaFragment.getSha256(), deltaFragment.getLayerSeq(), length);
                length += deltaFragment.getLength();
                arrayList.add(deltaFragment3);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(DeltaFragment deltaFragment, DeltaFragment deltaFragment2) {
        int iCompare = Long.compare(deltaFragment.length, deltaFragment2.length);
        return iCompare != 0 ? iCompare : compare(deltaFragment.sha256, deltaFragment2.sha256);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DeltaFragment deltaFragment = (DeltaFragment) obj;
        return this.length == deltaFragment.length && Arrays.equals(this.sha256, deltaFragment.sha256);
    }

    public short getLayerSeq() {
        return this.layerSeq;
    }

    public long getLength() {
        return this.length;
    }

    public long getOffset() {
        return this.offset;
    }

    public long getPosition() {
        return this.position;
    }

    public byte[] getSha256() {
        return this.sha256;
    }

    public int hashCode() {
        return (Objects.hash(Long.valueOf(this.length)) * 31) + Arrays.hashCode(this.sha256);
    }

    public void setLayerSeq(short s10) {
        this.layerSeq = s10;
    }

    public void setLength(long j10) {
        this.length = j10;
        this.sha256 = EMPTY_HASH;
    }

    public String toString() {
        return ((int) this.layerSeq) + ":" + this.position + ":" + this.length + ":" + this.offset;
    }

    public static int compare(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13) {
        if (bArr == bArr2 && i10 == i12 && i11 == i13) {
            return 0;
        }
        int i14 = i10 + i11;
        int i15 = i12 + i13;
        while (i10 < i14 && i12 < i15) {
            int i16 = bArr[i10] & 255;
            int i17 = bArr2[i12] & 255;
            if (i16 != i17) {
                return i16 - i17;
            }
            i10++;
            i12++;
        }
        return i11 - i13;
    }

    public DeltaFragment(long j10, long j11, byte[] bArr, short s10, long j12) {
        this.position = j10;
        this.length = j11;
        this.sha256 = bArr;
        this.layerSeq = s10;
        this.offset = j12;
    }
}
