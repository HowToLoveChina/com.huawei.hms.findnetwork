package com.baidu.location.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.p065a.C1534f;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@SuppressLint({"NewApi"})
/* renamed from: com.baidu.location.provider.b */
/* loaded from: classes.dex */
public class C1539b {

    /* renamed from: a */
    public static final long f6719a = 3000;

    /* renamed from: b */
    public static final int f6720b = 3;

    /* renamed from: c */
    public static int f6721c;

    /* renamed from: d */
    public static int f6722d;

    /* renamed from: e */
    private static C1539b f6723e;

    /* renamed from: f */
    private TelephonyManager f6724f = null;

    /* renamed from: g */
    private C1538a f6725g = new C1538a();

    /* renamed from: h */
    private C1538a f6726h = null;

    /* renamed from: i */
    private List<C1538a> f6727i = null;

    /* renamed from: j */
    private a f6728j = null;

    /* renamed from: k */
    private boolean f6729k = false;

    /* renamed from: l */
    private boolean f6730l = false;

    /* renamed from: com.baidu.location.provider.b$a */
    public class a extends PhoneStateListener {
        public a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation == null) {
                return;
            }
            try {
                C1539b.this.m8791i();
            } catch (Exception unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            C1538a c1538a;
            int cdmaDbm;
            if (C1539b.this.f6725g != null) {
                if (C1539b.this.f6725g.f6715i == 'g') {
                    c1538a = C1539b.this.f6725g;
                    cdmaDbm = signalStrength.getGsmSignalStrength();
                } else {
                    if (C1539b.this.f6725g.f6715i != 'c') {
                        return;
                    }
                    c1538a = C1539b.this.f6725g;
                    cdmaDbm = signalStrength.getCdmaDbm();
                }
                c1538a.f6714h = cdmaDbm;
            }
        }
    }

    private C1539b() {
    }

    /* renamed from: a */
    private int m8780a(int i10) {
        if (i10 == Integer.MAX_VALUE) {
            return -1;
        }
        return i10;
    }

    /* renamed from: c */
    private void m8787c(C1538a c1538a) throws IOException {
        if (c1538a.m8769b()) {
            C1538a c1538a2 = this.f6725g;
            if (c1538a2 == null || !c1538a2.m8768a(c1538a)) {
                this.f6725g = c1538a;
                if (!c1538a.m8769b()) {
                    List<C1538a> list = this.f6727i;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.f6727i.size();
                C1538a c1538a3 = size == 0 ? null : this.f6727i.get(size - 1);
                if (c1538a3 != null) {
                    int i10 = c1538a3.f6708b;
                    C1538a c1538a4 = this.f6725g;
                    if (i10 == c1538a4.f6708b && c1538a3.f6707a == c1538a4.f6707a) {
                        return;
                    }
                }
                this.f6727i.add(this.f6725g);
                if (this.f6727i.size() > 3) {
                    this.f6727i.remove(0);
                }
                m8790h();
                this.f6730l = false;
            }
        }
    }

    /* renamed from: g */
    private void m8789g() throws IOException {
        String strM8724c = C1534f.m8724c();
        if (strM8724c == null) {
            return;
        }
        File file = new File(strM8724c + File.separator + "lcvif.dat");
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                long j10 = 0;
                randomAccessFile.seek(0L);
                if (System.currentTimeMillis() - randomAccessFile.readLong() > 60000) {
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
                randomAccessFile.readInt();
                int i10 = 0;
                while (i10 < 3) {
                    long j11 = randomAccessFile.readLong();
                    int i11 = randomAccessFile.readInt();
                    int i12 = randomAccessFile.readInt();
                    int i13 = randomAccessFile.readInt();
                    int i14 = randomAccessFile.readInt();
                    int i15 = randomAccessFile.readInt();
                    char c10 = i15 == 2 ? 'c' : i15 == 1 ? 'g' : (char) 0;
                    if (j11 != j10) {
                        C1538a c1538a = new C1538a(i13, i14, i11, i12, 0, c10, -1);
                        c1538a.f6713g = j11;
                        if (c1538a.m8769b()) {
                            this.f6730l = true;
                            this.f6727i.add(c1538a);
                        }
                    }
                    i10++;
                    j10 = 0;
                }
                randomAccessFile.close();
            } catch (Exception e10) {
                if (C1534f.f6655a) {
                    e10.printStackTrace();
                }
                file.delete();
            }
        }
    }

    /* renamed from: h */
    private void m8790h() throws IOException {
        List<C1538a> list = this.f6727i;
        if (list == null && this.f6726h == null) {
            return;
        }
        if (list == null && this.f6726h != null) {
            LinkedList linkedList = new LinkedList();
            this.f6727i = linkedList;
            linkedList.add(this.f6726h);
        }
        String strM8724c = C1534f.m8724c();
        if (strM8724c == null) {
            return;
        }
        File file = new File(strM8724c + File.separator + "lcvif.dat");
        int size = this.f6727i.size();
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeLong(this.f6727i.get(size - 1).f6713g);
            randomAccessFile.writeInt(size);
            for (int i10 = 0; i10 < 3 - size; i10++) {
                randomAccessFile.writeLong(0L);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(2);
            }
            for (int i11 = 0; i11 < size; i11++) {
                randomAccessFile.writeLong(this.f6727i.get(i11).f6713g);
                randomAccessFile.writeInt(this.f6727i.get(i11).f6709c);
                randomAccessFile.writeInt(this.f6727i.get(i11).f6710d);
                randomAccessFile.writeInt(this.f6727i.get(i11).f6707a);
                randomAccessFile.writeInt(this.f6727i.get(i11).f6708b);
                if (this.f6727i.get(i11).f6715i == 'g') {
                    randomAccessFile.writeInt(1);
                } else if (this.f6727i.get(i11).f6715i == 'c') {
                    randomAccessFile.writeInt(2);
                } else {
                    randomAccessFile.writeInt(3);
                }
            }
            randomAccessFile.close();
        } catch (Exception e10) {
            if (C1534f.f6655a) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: i */
    public void m8791i() throws IOException {
        C1538a c1538aM8792j = m8792j();
        if (C1534f.f6655a && c1538aM8792j != null) {
            C1534f.m8725c(" new cell api = " + c1538aM8792j.m8775h());
        }
        if (c1538aM8792j != null) {
            m8787c(c1538aM8792j);
        }
        if (c1538aM8792j == null || !c1538aM8792j.m8769b()) {
            C1538a c1538aM8782a = m8782a(this.f6724f.getCellLocation());
            if (C1534f.f6655a && c1538aM8782a != null) {
                C1534f.m8725c(" old cell api = " + c1538aM8782a.m8775h());
            }
            if (c1538aM8782a == null || !c1538aM8782a.m8769b()) {
                C1534f.m8725c("cell is null");
                if (this.f6725g.m8779l()) {
                    return;
                }
                C1534f.m8725c("cell valid time > 5 min");
                C1538a c1538a = new C1538a();
                this.f6725g = c1538a;
                c1538a.f6708b = -1;
                c1538a.f6707a = -1;
                c1538a.f6709c = -1;
                c1538a.f6710d = -1;
                c1538a.f6715i = (char) 0;
                c1538a.f6714h = -1;
                c1538a.f6711e = Integer.MAX_VALUE;
                c1538a.f6712f = Integer.MAX_VALUE;
                c1538a.f6713g = System.currentTimeMillis();
                C1534f.m8725c("清除缓存 clear cellInfo");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0053 A[PHI: r0 r5
  0x0053: PHI (r0v2 com.baidu.location.provider.a) = (r0v0 com.baidu.location.provider.a), (r0v3 com.baidu.location.provider.a) binds: [B:81:0x0051, B:84:0x0059] A[DONT_GENERATE, DONT_INLINE]
  0x0053: PHI (r5v3 'e' java.lang.Throwable) = (r5v2 'e' java.lang.Throwable), (r5v4 'e' java.lang.Throwable) binds: [B:81:0x0051, B:84:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.baidu.location.provider.C1538a m8792j() {
        /*
            r5 = this;
            r0 = 0
            android.telephony.TelephonyManager r1 = r5.f6724f     // Catch: java.lang.NoSuchMethodError -> L39 java.lang.Exception -> L47
            java.util.List r1 = r1.getAllCellInfo()     // Catch: java.lang.NoSuchMethodError -> L39 java.lang.Exception -> L47
            if (r1 == 0) goto L49
            int r2 = r1.size()     // Catch: java.lang.NoSuchMethodError -> L39 java.lang.Exception -> L47
            if (r2 <= 0) goto L49
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.NoSuchMethodError -> L39 java.lang.Exception -> L47
            r2 = r0
        L14:
            boolean r3 = r1.hasNext()     // Catch: java.lang.NoSuchMethodError -> L39 java.lang.Exception -> L3b
            if (r3 == 0) goto L45
            java.lang.Object r3 = r1.next()     // Catch: java.lang.NoSuchMethodError -> L39 java.lang.Exception -> L3b
            android.telephony.CellInfo r3 = (android.telephony.CellInfo) r3     // Catch: java.lang.NoSuchMethodError -> L39 java.lang.Exception -> L3b
            boolean r4 = r3.isRegistered()     // Catch: java.lang.NoSuchMethodError -> L39 java.lang.Exception -> L3b
            if (r4 == 0) goto L14
            com.baidu.location.provider.a r2 = r5.m8781a(r3)     // Catch: java.lang.NoSuchMethodError -> L39 java.lang.Exception -> L3b
            if (r2 != 0) goto L2d
            goto L14
        L2d:
            boolean r5 = r2.m8769b()     // Catch: java.lang.NoSuchMethodError -> L39 java.lang.Exception -> L3b
            if (r5 != 0) goto L3e
            java.lang.String r5 = " !res.isValid()"
            com.baidu.location.p065a.C1534f.m8725c(r5)     // Catch: java.lang.NoSuchMethodError -> L39 java.lang.Exception -> L3b
            goto L44
        L39:
            r5 = move-exception
            goto L4f
        L3b:
            r5 = move-exception
            r0 = r2
            goto L57
        L3e:
            java.lang.String r5 = " res.isValid()"
            com.baidu.location.p065a.C1534f.m8725c(r5)     // Catch: java.lang.NoSuchMethodError -> L39 java.lang.Exception -> L3b
            r0 = r2
        L44:
            return r0
        L45:
            r0 = r2
            goto L5c
        L47:
            r5 = move-exception
            goto L57
        L49:
            java.lang.String r5 = "getAllCellInfo = null"
            com.baidu.location.p065a.C1534f.m8725c(r5)     // Catch: java.lang.NoSuchMethodError -> L39 java.lang.Exception -> L47
            goto L5c
        L4f:
            boolean r1 = com.baidu.location.p065a.C1534f.f6655a
            if (r1 == 0) goto L5c
        L53:
            r5.printStackTrace()
            goto L5c
        L57:
            boolean r1 = com.baidu.location.p065a.C1534f.f6655a
            if (r1 == 0) goto L5c
            goto L53
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.C1539b.m8792j():com.baidu.location.provider.a");
    }

    /* renamed from: d */
    public int m8798d() {
        TelephonyManager telephonyManager = this.f6724f;
        if (telephonyManager == null) {
            return 0;
        }
        return telephonyManager.getNetworkType();
    }

    /* renamed from: e */
    public C1538a m8799e() {
        C1538a c1538a;
        C1538a c1538a2 = this.f6725g;
        if ((c1538a2 == null || !c1538a2.m8767a() || !this.f6725g.m8769b()) && this.f6724f != null) {
            try {
                m8791i();
            } catch (Exception e10) {
                if (C1534f.f6655a) {
                    e10.printStackTrace();
                }
            }
        }
        C1538a c1538a3 = this.f6725g;
        if (c1538a3 != null && c1538a3.m8772e()) {
            this.f6726h = null;
            C1538a c1538a4 = this.f6725g;
            this.f6726h = new C1538a(c1538a4.f6707a, c1538a4.f6708b, c1538a4.f6709c, c1538a4.f6710d, c1538a4.f6714h, c1538a4.f6715i, c1538a4.f6716j);
        }
        C1538a c1538a5 = this.f6725g;
        if (c1538a5 != null && c1538a5.m8771d() && (c1538a = this.f6726h) != null) {
            C1538a c1538a6 = this.f6725g;
            if (c1538a6.f6715i == 'g') {
                c1538a6.f6710d = c1538a.f6710d;
                c1538a6.f6709c = c1538a.f6709c;
            }
        }
        return this.f6725g;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x007b A[PHI: r6
  0x007b: PHI (r6v2 'e' java.lang.Throwable) = (r6v1 'e' java.lang.Throwable), (r6v3 'e' java.lang.Throwable) binds: [B:69:0x0079, B:72:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.baidu.location.provider.C1538a> m8800f() {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.telephony.TelephonyManager r1 = r6.f6724f     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            int r1 = r1.getSimState()     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            com.baidu.location.provider.C1539b.f6721c = r1     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            android.telephony.TelephonyManager r1 = r6.f6724f     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            java.util.List r1 = r1.getAllCellInfo()     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            r2.<init>()     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            java.lang.String r3 = "listCellInfo = "
            r2.append(r3)     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            r2.append(r1)     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            java.lang.String r2 = r2.toString()     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            com.baidu.location.data.C1536a.m8739a(r2)     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            if (r1 == 0) goto L84
            int r2 = r1.size()     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            if (r2 <= 0) goto L84
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            r2 = 0
        L34:
            boolean r3 = r1.hasNext()     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            if (r3 == 0) goto L84
            java.lang.Object r3 = r1.next()     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            android.telephony.CellInfo r3 = (android.telephony.CellInfo) r3     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            boolean r4 = r3.isRegistered()     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            if (r4 == 0) goto L34
            com.baidu.location.provider.a r3 = r6.m8781a(r3)     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            if (r3 == 0) goto L34
            boolean r4 = r3.m8769b()     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            if (r4 == 0) goto L34
            r4 = 2
            if (r2 >= r4) goto L34
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            r4.<init>()     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            java.lang.String r5 = "添加基站信息 = "
            r4.append(r5)     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            java.lang.String r5 = r3.m8775h()     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            r4.append(r5)     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            java.lang.String r4 = r4.toString()     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            com.baidu.location.data.C1536a.m8739a(r4)     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            r0.add(r3)     // Catch: java.lang.NoSuchMethodError -> L73 java.lang.Exception -> L75
            int r2 = r2 + 1
            goto L34
        L73:
            r6 = move-exception
            goto L77
        L75:
            r6 = move-exception
            goto L7f
        L77:
            boolean r1 = com.baidu.location.p065a.C1534f.f6655a
            if (r1 == 0) goto L84
        L7b:
            r6.printStackTrace()
            goto L84
        L7f:
            boolean r1 = com.baidu.location.p065a.C1534f.f6655a
            if (r1 == 0) goto L84
            goto L7b
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.C1539b.m8800f():java.util.List");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:58|60|(1:62)(7:64|(2:66|(5:71|112|72|(2:78|(1:81))|(1:70))(0))(2:88|(1:90)(1:91))|(3:110|93|(1:95))|114|101|108|109)|63|(0)|114|101|108|109) */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0213, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0216, code lost:
    
        if (com.baidu.location.p065a.C1534f.f6655a != false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0218, code lost:
    
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x021b, code lost:
    
        r0.f6713g = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0153 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00db A[PHI: r1
  0x00db: PHI (r1v16 int) = (r1v14 int), (r1v17 int) binds: [B:86:0x010e, B:69:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.baidu.location.provider.C1538a m8781a(android.telephony.CellInfo r9) {
        /*
            Method dump skipped, instructions count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.C1539b.m8781a(android.telephony.CellInfo):com.baidu.location.provider.a");
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x0097 A[PHI: r7
  0x0097: PHI (r7v2 'e' java.lang.Throwable) = (r7v1 'e' java.lang.Throwable), (r7v3 'e' java.lang.Throwable) binds: [B:87:0x0095, B:90:0x009d] A[DONT_GENERATE, DONT_INLINE]] */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m8788d(com.baidu.location.provider.C1538a r8) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.telephony.TelephonyManager r1 = r7.f6724f     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            java.util.List r1 = r1.getAllCellInfo()     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            if (r1 == 0) goto L8d
            int r2 = r1.size()     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            if (r2 <= 0) goto L8d
            java.lang.String r2 = "&nc="
            r0.append(r2)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
        L1c:
            boolean r2 = r1.hasNext()     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            if (r2 == 0) goto La0
            java.lang.Object r2 = r1.next()     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            android.telephony.CellInfo r2 = (android.telephony.CellInfo) r2     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            boolean r3 = r2.isRegistered()     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            if (r3 == 0) goto L2f
            goto L1c
        L2f:
            com.baidu.location.provider.a r2 = r7.m8781a(r2)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            if (r2 != 0) goto L36
            goto L1c
        L36:
            int r3 = r2.f6707a     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r4 = -1
            if (r3 == r4) goto L1c
            int r5 = r2.f6708b     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            if (r5 == r4) goto L1c
            int r4 = r8.f6707a     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            java.lang.String r5 = ";"
            java.lang.String r6 = "|"
            if (r4 == r3) goto L70
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r3.<init>()     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            int r4 = r2.f6707a     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r3.append(r4)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r3.append(r6)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            int r4 = r2.f6708b     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r3.append(r4)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r3.append(r6)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            int r2 = r2.f6714h     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r3.append(r2)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r3.append(r5)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            java.lang.String r2 = r3.toString()     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
        L68:
            r0.append(r2)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            goto L1c
        L6c:
            r7 = move-exception
            goto L93
        L6e:
            r7 = move-exception
            goto L9b
        L70:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r3.<init>()     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r3.append(r6)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            int r4 = r2.f6708b     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r3.append(r4)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r3.append(r6)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            int r2 = r2.f6714h     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r3.append(r2)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            r3.append(r5)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            java.lang.String r2 = r3.toString()     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            goto L68
        L8d:
            java.lang.String r7 = "getAllCellInfo = null"
            com.baidu.location.p065a.C1534f.m8725c(r7)     // Catch: java.lang.NoSuchMethodError -> L6c java.lang.Exception -> L6e
            goto La0
        L93:
            boolean r8 = com.baidu.location.p065a.C1534f.f6655a
            if (r8 == 0) goto La0
        L97:
            r7.printStackTrace()
            goto La0
        L9b:
            boolean r8 = com.baidu.location.p065a.C1534f.f6655a
            if (r8 == 0) goto La0
            goto L97
        La0:
            java.lang.String r7 = r0.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.C1539b.m8788d(com.baidu.location.provider.a):java.lang.String");
    }

    /* renamed from: b */
    public String m8795b(C1538a c1538a) {
        int i10;
        StringBuffer stringBuffer = new StringBuffer(128);
        try {
            stringBuffer.append("&nw=");
            stringBuffer.append(c1538a.f6715i);
            Locale locale = Locale.CHINA;
            stringBuffer.append(String.format(locale, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(c1538a.f6709c), Integer.valueOf(c1538a.f6710d), Integer.valueOf(c1538a.f6707a), Integer.valueOf(c1538a.f6708b), Integer.valueOf(c1538a.f6714h)));
            if (c1538a.f6711e < Integer.MAX_VALUE && (i10 = c1538a.f6712f) < Integer.MAX_VALUE) {
                stringBuffer.append(String.format(locale, "&cdmall=%.6f|%.6f", Double.valueOf(i10 / 14400.0d), Double.valueOf(c1538a.f6711e / 14400.0d)));
            }
            stringBuffer.append("&cl_t=");
            stringBuffer.append(c1538a.f6713g);
            if (c1538a.f6716j != Integer.MAX_VALUE) {
                stringBuffer.append("&cl_cs=");
                stringBuffer.append(c1538a.f6716j);
            }
            List<C1538a> list = this.f6727i;
            if (list != null && list.size() > 0) {
                int size = this.f6727i.size();
                stringBuffer.append("&clt=");
                for (int i11 = 0; i11 < size; i11++) {
                    C1538a c1538a2 = this.f6727i.get(i11);
                    int i12 = c1538a2.f6709c;
                    if (i12 != c1538a.f6709c) {
                        stringBuffer.append(i12);
                    }
                    stringBuffer.append("|");
                    int i13 = c1538a2.f6710d;
                    if (i13 != c1538a.f6710d) {
                        stringBuffer.append(i13);
                    }
                    stringBuffer.append("|");
                    int i14 = c1538a2.f6707a;
                    if (i14 != c1538a.f6707a) {
                        stringBuffer.append(i14);
                    }
                    stringBuffer.append("|");
                    int i15 = c1538a2.f6708b;
                    if (i15 != c1538a.f6708b) {
                        stringBuffer.append(i15);
                    }
                    stringBuffer.append("|");
                    stringBuffer.append((System.currentTimeMillis() - c1538a2.f6713g) / 1000);
                    stringBuffer.append(";");
                }
            }
            if (f6721c > 100) {
                f6721c = 0;
            }
            int i16 = f6721c + (f6722d << 8);
            C1534f.m8725c("sim state:" + f6721c + "," + i16);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("&cs=");
            sb2.append(i16);
            stringBuffer.append(sb2.toString());
            C1534f.m8725c(stringBuffer.toString());
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public boolean m8797c() {
        return this.f6730l;
    }

    /* renamed from: a */
    private C1538a m8782a(CellLocation cellLocation) {
        return m8783a(cellLocation, false);
    }

    /* renamed from: b */
    public synchronized void m8796b() {
        TelephonyManager telephonyManager;
        try {
            if (this.f6729k) {
                a aVar = this.f6728j;
                if (aVar != null && (telephonyManager = this.f6724f) != null) {
                    telephonyManager.listen(aVar, 0);
                }
                this.f6728j = null;
                this.f6724f = null;
                this.f6727i.clear();
                this.f6727i = null;
                m8790h();
                C1534f.m8725c("cell manager stop ...");
                this.f6729k = false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    private C1538a m8783a(CellLocation cellLocation, boolean z10) throws IOException {
        char c10;
        int i10;
        if (cellLocation == null || this.f6724f == null) {
            return null;
        }
        if (z10) {
            C1534f.m8725c("set dual cell info.." + cellLocation.toString());
        }
        C1538a c1538a = new C1538a();
        if (z10) {
            c1538a.m8773f();
        }
        c1538a.f6713g = System.currentTimeMillis();
        try {
            String networkOperator = this.f6724f.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                if (networkOperator.length() >= 3) {
                    int iIntValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (iIntValue < 0) {
                        iIntValue = this.f6725g.f6709c;
                    }
                    c1538a.f6709c = iIntValue;
                }
                String strSubstring = networkOperator.substring(3);
                if (strSubstring != null) {
                    char[] charArray = strSubstring.toCharArray();
                    i10 = 0;
                    while (i10 < charArray.length && Character.isDigit(charArray[i10])) {
                        i10++;
                    }
                } else {
                    i10 = 0;
                }
                int iIntValue2 = Integer.valueOf(strSubstring.substring(0, i10)).intValue();
                if (iIntValue2 < 0) {
                    iIntValue2 = this.f6725g.f6710d;
                }
                c1538a.f6710d = iIntValue2;
            }
            f6721c = this.f6724f.getSimState();
            C1534f.m8725c("sim state:" + f6721c);
        } catch (Exception e10) {
            if (C1534f.f6655a) {
                e10.printStackTrace();
            }
            f6722d = 1;
        }
        if (!(cellLocation instanceof GsmCellLocation)) {
            c10 = cellLocation instanceof CdmaCellLocation ? 'c' : 'g';
            m8787c(c1538a);
            return c1538a;
        }
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        c1538a.f6707a = gsmCellLocation.getLac();
        c1538a.f6708b = gsmCellLocation.getCid();
        c1538a.f6715i = c10;
        m8787c(c1538a);
        return c1538a;
    }

    /* renamed from: a */
    public static C1539b m8784a() {
        if (f6723e == null) {
            f6723e = new C1539b();
        }
        return f6723e;
    }

    /* renamed from: a */
    public String m8793a(C1538a c1538a) {
        String strM8788d;
        String str = "";
        try {
            strM8788d = m8788d(c1538a);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (strM8788d != null && !strM8788d.equals("") && !strM8788d.equals("&nc=")) {
            return strM8788d;
        }
        List<NeighboringCellInfo> neighboringCellInfo = this.f6724f.getNeighboringCellInfo();
        if (neighboringCellInfo == null || neighboringCellInfo.isEmpty()) {
            str = strM8788d;
        } else {
            int i10 = 0;
            String str2 = "&nc=";
            for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                int lac = neighboringCellInfo2.getLac();
                if (lac != -1 && neighboringCellInfo2.getCid() != -1) {
                    str2 = c1538a.f6707a != lac ? str2 + lac + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() + ";" : str2 + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() + ";";
                }
                i10++;
                if (i10 >= 8) {
                    break;
                }
            }
            str = str2;
        }
        if (str == null || !str.equals("&nc=")) {
            return str;
        }
        return null;
    }

    /* renamed from: a */
    public synchronized void m8794a(Context context) {
        a aVar;
        if (this.f6729k) {
            return;
        }
        this.f6724f = (TelephonyManager) LocationClient.mContext.getApplicationContext().getSystemService("phone");
        this.f6727i = new LinkedList();
        this.f6728j = new a();
        m8789g();
        TelephonyManager telephonyManager = this.f6724f;
        if (telephonyManager == null || (aVar = this.f6728j) == null) {
            return;
        }
        try {
            telephonyManager.listen(aVar, 272);
        } catch (Exception e10) {
            if (C1534f.f6655a) {
                e10.printStackTrace();
            }
        }
        C1534f.m8725c("cell manager start...");
        this.f6729k = true;
        C1534f.m8725c("cellman inited");
    }
}
