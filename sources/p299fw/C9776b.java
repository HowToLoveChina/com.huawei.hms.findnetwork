package p299fw;

import android.util.Log;
import com.ultrasoniclibrary.ultrasoundcore.classfun.FreqParam;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

/* renamed from: fw.b */
/* loaded from: classes9.dex */
public class C9776b {

    /* renamed from: a */
    public byte[] f48066a;

    /* renamed from: b */
    public int f48067b;

    /* renamed from: c */
    public String f48068c;

    /* renamed from: d */
    public float[] f48069d;

    /* renamed from: e */
    public float[] f48070e;

    /* renamed from: f */
    public float[] f48071f;

    /* renamed from: g */
    public long f48072g;

    /* renamed from: h */
    public long f48073h;

    /* renamed from: i */
    public float f48074i;

    /* renamed from: j */
    public int f48075j;

    /* renamed from: k */
    public FreqParam f48076k;

    /* renamed from: l */
    public LinkedList<float[]> f48077l;

    /* renamed from: m */
    public LinkedList<float[]> f48078m;

    /* renamed from: n */
    public LinkedList<float[]> f48079n;

    /* renamed from: fw.b$a */
    public static class a {

        /* renamed from: a */
        public byte[] f48080a;

        /* renamed from: c */
        public String f48082c;

        /* renamed from: d */
        public float[] f48083d;

        /* renamed from: e */
        public float[] f48084e;

        /* renamed from: f */
        public float[] f48085f;

        /* renamed from: j */
        public int f48089j;

        /* renamed from: k */
        public FreqParam f48090k;

        /* renamed from: l */
        public LinkedList<float[]> f48091l;

        /* renamed from: m */
        public LinkedList<float[]> f48092m;

        /* renamed from: n */
        public LinkedList<float[]> f48093n;

        /* renamed from: b */
        public int f48081b = 0;

        /* renamed from: g */
        public long f48086g = 1000000000;

        /* renamed from: h */
        public long f48087h = -1;

        /* renamed from: i */
        public float f48088i = -100.0f;

        /* renamed from: a */
        public C9776b m60821a() {
            return new C9776b(this);
        }

        /* renamed from: b */
        public a m60822b(LinkedList<float[]> linkedList) {
            this.f48092m = C9776b.m60813b(linkedList);
            return this;
        }

        /* renamed from: c */
        public a m60823c(int i10) {
            this.f48089j = i10;
            return this;
        }

        /* renamed from: d */
        public a m60824d(long j10) {
            this.f48086g = j10;
            return this;
        }

        /* renamed from: e */
        public a m60825e(float f10) {
            this.f48088i = f10;
            return this;
        }

        /* renamed from: f */
        public a m60826f(FreqParam freqParam) {
            this.f48090k = freqParam;
            return this;
        }

        /* renamed from: g */
        public a m60827g(LinkedList<float[]> linkedList) {
            this.f48093n = C9776b.m60813b(linkedList);
            return this;
        }

        /* renamed from: h */
        public a m60828h(LinkedList<float[]> linkedList) {
            this.f48091l = C9776b.m60813b(linkedList);
            return this;
        }

        /* renamed from: i */
        public a m60829i(byte[] bArr) {
            this.f48080a = bArr;
            return this;
        }

        /* renamed from: j */
        public a m60830j(String str) {
            this.f48082c = str;
            return this;
        }

        /* renamed from: k */
        public a m60831k(int i10) {
            this.f48081b = i10;
            return this;
        }

        /* renamed from: l */
        public a m60832l(long j10) {
            this.f48087h = j10;
            return this;
        }
    }

    public C9776b(a aVar) {
        this.f48066a = aVar.f48080a;
        this.f48067b = aVar.f48081b;
        this.f48068c = aVar.f48082c;
        this.f48069d = aVar.f48083d;
        this.f48070e = aVar.f48084e;
        this.f48071f = aVar.f48085f;
        this.f48072g = aVar.f48086g;
        this.f48073h = aVar.f48087h;
        this.f48074i = aVar.f48088i;
        this.f48075j = aVar.f48089j;
        this.f48076k = aVar.f48090k;
        this.f48077l = aVar.f48091l;
        this.f48078m = aVar.f48092m;
        this.f48079n = aVar.f48093n;
    }

    /* renamed from: b */
    public static <T> LinkedList<T> m60813b(LinkedList<T> linkedList) throws Throwable {
        LinkedList<T> linkedList2;
        Throwable th2;
        LinkedList<T> linkedList3 = new LinkedList<>();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    try {
                        objectOutputStream.writeObject(linkedList);
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        try {
                            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                            try {
                                linkedList2 = (LinkedList) objectInputStream.readObject();
                                try {
                                    objectInputStream.close();
                                    byteArrayInputStream.close();
                                    try {
                                        objectOutputStream.close();
                                        try {
                                            byteArrayOutputStream.close();
                                            return linkedList2;
                                        } catch (IOException | ClassNotFoundException e10) {
                                            e = e10;
                                            linkedList3 = linkedList2;
                                            Log.e("PositioningInput", "deepCopy error: " + e.getMessage());
                                            return linkedList3;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        linkedList3 = linkedList2;
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Throwable th4) {
                                            th.addSuppressed(th4);
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th5) {
                                    th2 = th5;
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (Throwable th6) {
                                        th2.addSuppressed(th6);
                                    }
                                    throw th2;
                                }
                            } finally {
                            }
                        } catch (Throwable th7) {
                            linkedList2 = linkedList3;
                            th2 = th7;
                            byteArrayInputStream.close();
                            throw th2;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        linkedList3 = linkedList2;
                        try {
                            objectOutputStream.close();
                        } catch (Throwable th9) {
                            th.addSuppressed(th9);
                        }
                        throw th;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    objectOutputStream.close();
                    throw th;
                }
            } catch (Throwable th11) {
                th = th11;
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException | ClassNotFoundException e11) {
            e = e11;
        }
    }

    /* renamed from: c */
    public LinkedList<float[]> m60814c() {
        return this.f48078m;
    }

    /* renamed from: d */
    public int m60815d() {
        return this.f48075j;
    }

    /* renamed from: e */
    public long m60816e() {
        return this.f48072g;
    }

    /* renamed from: f */
    public float m60817f() {
        return this.f48074i;
    }

    /* renamed from: g */
    public LinkedList<float[]> m60818g() {
        return this.f48077l;
    }

    /* renamed from: h */
    public byte[] m60819h() {
        return this.f48066a;
    }

    /* renamed from: i */
    public long m60820i() {
        return this.f48073h;
    }

    public String toString() {
        return "PositioningInput: mRecordData: , TagState: , Orientation: ";
    }
}
