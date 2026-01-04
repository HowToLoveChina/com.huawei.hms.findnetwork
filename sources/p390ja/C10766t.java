package p390ja;

import com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.InputSource;
import com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.SeekableInput;
import com.huawei.android.hicloud.drive.clouddisk.model.DeltaFragment;
import com.huawei.android.hicloud.drive.clouddisk.model.Digest;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p514o9.C11839m;

/* renamed from: ja.t */
/* loaded from: classes3.dex */
public class C10766t {

    /* renamed from: a */
    public long f51480a;

    /* renamed from: b */
    public Digest f51481b;

    /* renamed from: ja.t$a */
    public class a implements SeekableInput {

        /* renamed from: a */
        public final /* synthetic */ RandomAccessFile f51482a;

        public a(RandomAccessFile randomAccessFile) {
            this.f51482a = randomAccessFile;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            RandomAccessFile randomAccessFile = this.f51482a;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.close();
        }

        @Override // com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.SeekableInput
        public void read(byte[] bArr, int i10, int i11) throws IOException {
            RandomAccessFile randomAccessFile = this.f51482a;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.readFully(bArr, i10, i11);
        }

        @Override // com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.SeekableInput
        public void seek(long j10) throws IOException {
            RandomAccessFile randomAccessFile = this.f51482a;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.seek(j10);
        }
    }

    public C10766t(long j10, Digest digest) {
        this.f51480a = j10;
        this.f51481b = digest;
    }

    /* renamed from: i */
    public static C10766t m65570i(long j10, Digest digest, Digest digest2) {
        return new C10766t(j10, Digest.diffDn(digest, digest2));
    }

    /* renamed from: j */
    public static /* synthetic */ SeekableInput m65571j(IntFunction intFunction, Integer num) {
        return ((InputSource) intFunction.apply(num.intValue())).mo16345a();
    }

    /* renamed from: k */
    public static /* synthetic */ SeekableInput m65572k(Map map, final IntFunction intFunction, int i10) {
        return (SeekableInput) map.computeIfAbsent(Integer.valueOf(i10), new Function() { // from class: ja.s
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C10766t.m65571j(intFunction, (Integer) obj);
            }
        });
    }

    /* renamed from: l */
    public static /* synthetic */ SeekableInput m65573l(IntFunction intFunction, Integer num) {
        return ((InputSource) intFunction.apply(num.intValue())).mo16345a();
    }

    /* renamed from: m */
    public static /* synthetic */ SeekableInput m65574m(Map map, final IntFunction intFunction, int i10) {
        return (SeekableInput) map.computeIfAbsent(Integer.valueOf(i10), new Function() { // from class: ja.r
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C10766t.m65573l(intFunction, (Integer) obj);
            }
        });
    }

    /* renamed from: n */
    public static /* synthetic */ boolean m65575n(DeltaFragment deltaFragment) {
        return deltaFragment.getLayerSeq() == 0;
    }

    /* renamed from: o */
    public static /* synthetic */ boolean m65576o(int i10, DeltaFragment deltaFragment) {
        return deltaFragment.getLayerSeq() == i10;
    }

    /* renamed from: p */
    public static /* synthetic */ int m65577p(DeltaFragment deltaFragment, DeltaFragment deltaFragment2) {
        return Long.compare(deltaFragment.getPosition(), deltaFragment2.getPosition());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:37:0x003a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:131)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:57)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    /* renamed from: r */
    public static com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.SeekableInput m65578r(java.io.File r5) {
        /*
            java.lang.String r0 = "close IOException: "
            java.lang.String r1 = "DigestFile"
            r2 = 0
            if (r5 == 0) goto L13
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> Lf java.io.FileNotFoundException -> L11
            java.lang.String r4 = "r"
            r3.<init>(r5, r4)     // Catch: java.lang.Throwable -> Lf java.io.FileNotFoundException -> L11
            goto L14
        Lf:
            r5 = move-exception
            goto L5d
        L11:
            r3 = r2
            goto L3a
        L13:
            r3 = r2
        L14:
            ja.t$a r5 = new ja.t$a     // Catch: java.lang.Throwable -> L37 java.io.FileNotFoundException -> L3a
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L37 java.io.FileNotFoundException -> L3a
            if (r3 == 0) goto L36
            r3.close()     // Catch: java.io.IOException -> L1f
            goto L36
        L1f:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = r2.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            p514o9.C11839m.m70687e(r1, r0)
        L36:
            return r5
        L37:
            r5 = move-exception
            r2 = r3
            goto L5d
        L3a:
            java.lang.String r5 = "file invalid"
            p514o9.C11839m.m70687e(r1, r5)     // Catch: java.lang.Throwable -> L37
            if (r3 == 0) goto L5c
            r3.close()     // Catch: java.io.IOException -> L45
            goto L5c
        L45:
            r5 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r5 = r5.toString()
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            p514o9.C11839m.m70687e(r1, r5)
        L5c:
            return r2
        L5d:
            if (r2 == 0) goto L7a
            r2.close()     // Catch: java.io.IOException -> L63
            goto L7a
        L63:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = r2.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            p514o9.C11839m.m70687e(r1, r0)
        L7a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p390ja.C10766t.m65578r(java.io.File):com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.SeekableInput");
    }

    /* renamed from: h */
    public void m65579h(OutputStream outputStream, final IntFunction<InputSource> intFunction) throws IOException {
        final HashMap map = new HashMap();
        IntFunction intFunction2 = new IntFunction() { // from class: ja.q
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return C10766t.m65572k(map, intFunction, i10);
            }
        };
        try {
            List<DeltaFragment> fragments = this.f51481b.getFragments();
            byte[] bArr = null;
            long j10 = 0;
            long j11 = 0;
            for (int i10 = 0; i10 < fragments.size(); i10++) {
                DeltaFragment deltaFragment = fragments.get(i10);
                SeekableInput seekableInput = (SeekableInput) intFunction2.apply(deltaFragment.getLayerSeq());
                int length = (int) deltaFragment.getLength();
                int i11 = 0;
                while (true) {
                    int i12 = length - i11;
                    if (i12 > 0) {
                        if (i12 >= 10485760) {
                            i12 = 10485760;
                        }
                        if (bArr == null || bArr.length < i12) {
                            bArr = new byte[i12];
                        }
                        IntFunction intFunction3 = intFunction2;
                        List<DeltaFragment> list = fragments;
                        seekableInput.seek(deltaFragment.getOffset() + i11);
                        seekableInput.read(bArr, 0, i12);
                        i11 += i12;
                        outputStream.write(bArr, 0, i12);
                        outputStream.flush();
                        long j12 = i12;
                        j10 += j12;
                        j11 += j12;
                        if (j11 >= 1048576) {
                            outputStream.flush();
                            C11839m.m70688i("DigestFile", "flush to file length:" + j10);
                            j11 = 0;
                        }
                        intFunction2 = intFunction3;
                        fragments = list;
                    }
                }
            }
            map.values().forEach(new C10762p());
            if (j10 != this.f51480a) {
                throw new IllegalStateException("Check length failure");
            }
        } catch (Throwable th2) {
            map.values().forEach(new C10762p());
            throw th2;
        }
    }

    /* renamed from: q */
    public void m65580q(int[] iArr, final IntFunction<InputSource> intFunction) throws IOException {
        List<DeltaFragment> list;
        List<DeltaFragment> list2;
        final HashMap map = new HashMap();
        IntFunction intFunction2 = new IntFunction() { // from class: ja.l
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return C10766t.m65574m(map, intFunction, i10);
            }
        };
        ArrayList arrayList = new ArrayList();
        try {
            List<DeltaFragment> fragments = this.f51481b.getFragments();
            arrayList.addAll((List) fragments.stream().filter(new Predicate() { // from class: ja.m
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C10766t.m65575n((DeltaFragment) obj);
                }
            }).collect(Collectors.toList()));
            int i10 = 0;
            while (i10 < iArr.length) {
                final int i11 = i10 + 1;
                List<DeltaFragment> list3 = (List) fragments.stream().filter(new Predicate() { // from class: ja.n
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return C10766t.m65576o(i11, (DeltaFragment) obj);
                    }
                }).collect(Collectors.toList());
                list3.sort(new Comparator() { // from class: ja.o
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return C10766t.m65577p((DeltaFragment) obj, (DeltaFragment) obj2);
                    }
                });
                C11839m.m70688i("DigestFile", i11 + " frags size:" + list3.size());
                if (list3.size() > 0) {
                    long j10 = 0;
                    long j11 = 0;
                    long offset = 0;
                    long length = 0;
                    long position = -1;
                    for (DeltaFragment deltaFragment : list3) {
                        if (deltaFragment.getOffset() == offset + length) {
                            long j12 = offset - j11;
                            long length2 = deltaFragment.getLength() + j12 + length;
                            int i12 = iArr[i10];
                            if (length2 >= i12) {
                                long j13 = i12 - (j12 + length);
                                long j14 = length + j13;
                                if (j14 != j10) {
                                    arrayList.add(new DeltaFragment(position, j14, null, (short) i11, offset));
                                }
                                position = deltaFragment.getPosition() + j13;
                                offset = deltaFragment.getOffset() + j13;
                                long length3 = deltaFragment.getLength() - j13;
                                int i13 = iArr[i10];
                                list2 = fragments;
                                length = length3;
                                j11 = (offset / i13) * i13;
                            } else {
                                length += deltaFragment.getLength();
                                int i14 = iArr[i10];
                                long j15 = (offset / i14) * i14;
                                if (position == -1) {
                                    position = deltaFragment.getPosition();
                                }
                                list2 = fragments;
                                j11 = j15;
                            }
                        } else {
                            if (length != j10) {
                                arrayList.add(new DeltaFragment(position, length, null, (short) i11, offset));
                            }
                            long position2 = deltaFragment.getPosition();
                            long offset2 = deltaFragment.getOffset();
                            int i15 = iArr[i10];
                            long j16 = (offset2 / i15) * i15;
                            long length4 = deltaFragment.getLength() + (offset2 - j16);
                            int i16 = iArr[i10];
                            if (length4 >= i16) {
                                long j17 = i16 - (length - j16);
                                if (j17 != 0) {
                                    arrayList.add(new DeltaFragment(position2, j17, null, (short) i11, offset2));
                                }
                                position = deltaFragment.getPosition() + j17;
                                offset = deltaFragment.getOffset() + j17;
                                long length5 = deltaFragment.getLength() - j17;
                                int i17 = iArr[i10];
                                list2 = fragments;
                                length = length5;
                                j11 = (offset / i17) * i17;
                            } else {
                                list2 = fragments;
                                long length6 = deltaFragment.getLength();
                                int i18 = iArr[i10];
                                long j18 = (offset2 / i18) * i18;
                                if (position2 == -1) {
                                    position = deltaFragment.getPosition();
                                    length = length6;
                                    j11 = j18;
                                } else {
                                    length = length6;
                                    j11 = j18;
                                    position = position2;
                                }
                                offset = offset2;
                            }
                        }
                        fragments = list2;
                        j10 = 0;
                    }
                    list = fragments;
                    if (length != j10) {
                        arrayList.add(new DeltaFragment(position, length, null, (short) i11, offset));
                    }
                } else {
                    list = fragments;
                }
                i10 = i11;
                fragments = list;
            }
            for (int i19 = 0; i19 < arrayList.size(); i19++) {
                DeltaFragment deltaFragment2 = (DeltaFragment) arrayList.get(i19);
                SeekableInput seekableInput = (SeekableInput) intFunction2.apply(deltaFragment2.getLayerSeq());
                seekableInput.seek(deltaFragment2.getOffset());
                seekableInput.read(null, 0, (int) deltaFragment2.getLength());
            }
            this.f51481b.setMergedFragments(arrayList);
            map.values().forEach(new C10762p());
        } catch (Throwable th2) {
            map.values().forEach(new C10762p());
            throw th2;
        }
    }
}
