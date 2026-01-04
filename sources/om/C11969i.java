package om;

import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import p514o9.C11839m;
import p815ym.AbstractC14026a;
import sl.C12815f;
import tl.C13026e;

/* renamed from: om.i */
/* loaded from: classes6.dex */
public class C11969i implements InterfaceC11974n {

    /* renamed from: d */
    public final String f55713d;

    /* renamed from: a */
    public final Map<String, Integer> f55710a = new ConcurrentHashMap();

    /* renamed from: b */
    public final Map<String, Float> f55711b = new ConcurrentHashMap();

    /* renamed from: c */
    public final Map<String, Float> f55712c = new ConcurrentHashMap();

    /* renamed from: e */
    public int f55714e = 0;

    /* renamed from: om.i$a */
    public static class a {

        /* renamed from: a */
        public float f55715a;

        /* renamed from: b */
        public float f55716b;

        /* renamed from: c */
        public float f55717c;

        /* renamed from: d */
        public int f55718d;

        /* renamed from: e */
        public int f55719e;

        /* renamed from: f */
        public int f55720f;

        /* renamed from: a */
        public float m72013a() {
            float f10;
            float f11;
            float f12;
            int i10 = this.f55720f;
            if (i10 == 0) {
                int i11 = this.f55719e;
                if (i11 == 0) {
                    i11 = this.f55718d;
                    if (i11 != 0) {
                        f11 = this.f55715a;
                        f12 = i11;
                    } else {
                        f10 = 0.0f;
                    }
                } else {
                    int i12 = this.f55718d;
                    if (i12 != 0) {
                        f10 = ((this.f55715a * 0.7f) / i12) + ((this.f55716b * 0.3f) / i11);
                    } else {
                        f11 = this.f55716b;
                        f12 = i11;
                    }
                }
                f10 = f11 / f12;
            } else {
                int i13 = this.f55719e;
                if (i13 == 0) {
                    f11 = this.f55715a + this.f55717c;
                    f12 = this.f55718d + i10;
                    f10 = f11 / f12;
                } else {
                    f10 = (((this.f55715a + this.f55717c) * 0.9f) / (this.f55718d + i10)) + ((this.f55716b * 0.1f) / i13);
                }
            }
            C11839m.m70686d("BackupV3Progress", "systemProgress: " + this.f55715a + " thirdProgress: " + this.f55716b + " thirdAppDataProgress: " + this.f55717c + " systemPower: " + this.f55718d + " thirdPower: " + this.f55719e + " thirdAppDataPower: " + this.f55720f + " progress:" + f10);
            return ((int) (f10 * 100.0f)) / 100.0f;
        }

        /* renamed from: b */
        public void m72014b(a aVar) {
            this.f55715a += aVar.f55715a;
            this.f55716b += aVar.f55716b;
            this.f55717c += aVar.f55717c;
            this.f55718d += aVar.f55718d;
            this.f55719e += aVar.f55719e;
            this.f55720f += aVar.f55720f;
        }
    }

    public C11969i(String str, Deque<CloudBackupStatus> deque, C13026e c13026e) {
        this.f55713d = str;
        m72012u(str, deque, c13026e);
    }

    @Override // om.InterfaceC11974n
    /* renamed from: a */
    public float mo71989a(BackupItem backupItem) {
        return "thirdApp".equals(backupItem.m29870d()) ? m72007p(backupItem) : m72002k(Collections.singletonList(backupItem)).m72013a();
    }

    @Override // om.InterfaceC11974n
    /* renamed from: b */
    public int mo71990b(List<BackupItem> list) {
        Iterator<BackupItem> it = list.iterator();
        int iMo71990b = 0;
        while (it.hasNext()) {
            List<BackupItem> listM29824I0 = it.next().m29824I0();
            iMo71990b = (listM29824I0 == null || listM29824I0.isEmpty()) ? iMo71990b + 1 : iMo71990b + mo71990b(listM29824I0);
        }
        return iMo71990b;
    }

    @Override // om.InterfaceC11974n
    /* renamed from: c */
    public float mo71991c(List<BackupItem> list, int i10) {
        return m72002k(list).m72013a();
    }

    /* renamed from: f */
    public final float m71997f(BackupItem backupItem, float f10) {
        long jM29875i = backupItem.m29875i();
        long jM29868a = backupItem.m29868a();
        float[] fArrM72000i = m72000i(backupItem.m29882r(), backupItem.m29881q(), 0.1f);
        float f11 = fArrM72000i[0];
        float f12 = fArrM72000i[1];
        float[] fArrM72000i2 = m72000i(backupItem.m29885v(), backupItem.m29856A(), 0.1f);
        float f13 = fArrM72000i2[0];
        float f14 = fArrM72000i2[1];
        float[] fArrM72000i3 = m72000i(backupItem.m29883s(), backupItem.m29884t(), 0.1f);
        float f15 = fArrM72000i3[0];
        float f16 = fArrM72000i3[1];
        float[] fArrM72000i4 = m72000i(jM29868a, jM29875i, ((1.0f - f11) - f13) - f15);
        float f17 = fArrM72000i4[0];
        float f18 = fArrM72000i4[1];
        float f19 = ((f11 * f12) + (f14 * f13) + (f16 * f15) + (f17 * f18)) * f10;
        int i10 = (int) f19;
        if (this.f55714e != i10) {
            C11839m.m70686d("BackupV3Progress", "v3 progress appid:" + backupItem.m29870d() + " p1: " + f12 + " p2: " + f14 + " p3: " + f16 + " p5:" + f18 + " pro: " + f19 + " ssaByte: " + backupItem.m29885v() + " sdcount: " + backupItem.m29856A() + " asCount: " + backupItem.m29882r() + " petaSize: " + backupItem.m29883s() + " pstaSize: " + backupItem.m29879o() + " alreadybyte: " + backupItem.m29868a() + " dataByte: " + backupItem.m29875i());
            this.f55714e = i10;
        }
        return f19;
    }

    /* renamed from: g */
    public final float m71998g(long j10, long j11) {
        if (j11 <= 0 || j10 <= 0) {
            return 0.0f;
        }
        return Math.min((float) ((j10 / j11) * 100.0d), 100.0f);
    }

    /* renamed from: h */
    public final int m71999h(BackupItem backupItem) {
        Integer num = this.f55710a.get(backupItem.m29870d() + backupItem.m29861N());
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    /* renamed from: i */
    public final float[] m72000i(long j10, long j11, float f10) {
        float[] fArr = {0.0f, 0.0f};
        if (j11 > 0) {
            fArr[0] = f10;
            float f11 = j10 / j11;
            fArr[1] = f11;
            if (f11 > 1.0f) {
                f11 = 1.0f;
            }
            fArr[1] = f11;
        }
        return fArr;
    }

    /* renamed from: j */
    public final float m72001j(BackupItem backupItem) {
        Float f10;
        String strM72003l = m72003l(backupItem);
        int iM29860M = backupItem.m29860M();
        if (iM29860M == 0) {
            return 0.0f;
        }
        if (iM29860M == 1) {
            float fM71998g = m71998g(backupItem.m29879o(), backupItem.m29880p()) * 0.1f;
            C11839m.m70686d("BackupV3Progress", "data prepare batch upload : " + strM72003l + ", already: " + backupItem.m29879o() + "all: " + backupItem.m29880p() + ", progress: " + fM71998g);
            return fM71998g;
        }
        if (iM29860M != 4) {
            return iM29860M != 5 ? (iM29860M == 6 || iM29860M == 7) ? 100.0f : 0.0f : (m72005n(backupItem) * 0.1f) + 90.0f;
        }
        float fM71997f = m71997f(backupItem, 80.0f) + 10.0f;
        if (this.f55712c.containsKey(strM72003l) && (f10 = this.f55712c.get(strM72003l)) != null && f10.floatValue() > fM71997f) {
            C11839m.m70686d("BackupV3Progress", "module progress has changed: " + strM72003l + ", lastProgress: " + f10 + ", progress: " + fM71997f);
            fM71997f = f10.floatValue();
        }
        float fMin = Math.min(fM71997f, 90.0f);
        this.f55712c.put(strM72003l, Float.valueOf(fMin));
        return fMin;
    }

    /* renamed from: k */
    public a m72002k(List<BackupItem> list) {
        a aVar = new a();
        for (BackupItem backupItem : list) {
            List<BackupItem> listM29824I0 = backupItem.m29824I0();
            if (listM29824I0 == null || listM29824I0.isEmpty()) {
                aVar.m72014b(m72004m(backupItem));
            } else {
                aVar.m72014b(m72002k(listM29824I0));
            }
        }
        return aVar;
    }

    /* renamed from: l */
    public final String m72003l(BackupItem backupItem) {
        int iM29861N = backupItem.m29861N();
        String strM29870d = backupItem.m29870d();
        if (iM29861N != 0) {
            strM29870d = strM29870d + iM29861N;
        }
        if (AbstractC14026a.m84159a(backupItem.m29824I0())) {
            return strM29870d;
        }
        return strM29870d + "main";
    }

    /* renamed from: m */
    public a m72004m(BackupItem backupItem) {
        a aVar = new a();
        float fM72008q = backupItem.m29858I() != 3 ? m72008q(backupItem) : m72001j(backupItem);
        if (backupItem.m29862O() && backupItem.m29878m() == -1) {
            fM72008q = 0.0f;
        }
        if (backupItem.m29866T() || backupItem.m29867U()) {
            int iM71999h = m71999h(backupItem);
            aVar.f55715a = iM71999h * fM72008q;
            aVar.f55718d = iM71999h;
        } else if ("thirdAppData".equals(backupItem.m29826K0())) {
            int iM71999h2 = m71999h(backupItem);
            aVar.f55717c = iM71999h2 * fM72008q;
            aVar.f55720f = iM71999h2;
        } else if ("thirdApp".equals(backupItem.m29826K0())) {
            int iM71999h3 = m71999h(backupItem);
            aVar.f55716b = iM71999h3 * fM72008q;
            aVar.f55719e = iM71999h3;
        }
        return aVar;
    }

    /* renamed from: n */
    public final float m72005n(BackupItem backupItem) {
        int iM29876j = backupItem.m29876j();
        int iM29869c = backupItem.m29869c();
        long jM29868a = backupItem.m29868a();
        long jM29873g = backupItem.m29873g();
        boolean zM29862O = backupItem.m29862O();
        float fM71998g = m71998g(jM29868a, jM29873g);
        return zM29862O ? (fM71998g * 0.5f) + (m71998g(iM29869c, iM29876j) * 0.5f) : fM71998g;
    }

    /* renamed from: o */
    public final float m72006o(BackupItem backupItem) {
        Float f10;
        int iM29876j = backupItem.m29876j();
        int iM29869c = backupItem.m29869c();
        long jM29868a = backupItem.m29868a();
        long jM29875i = backupItem.m29875i();
        String strM72003l = m72003l(backupItem);
        float fMin = Math.min(backupItem.m29865S() ? m71998g(iM29869c, iM29876j) : m71998g(jM29868a, jM29875i), 99.999f);
        if (this.f55711b.containsKey(strM72003l) && (f10 = this.f55711b.get(strM72003l)) != null && f10.floatValue() > fMin) {
            C11839m.m70686d("BackupV3Progress", "module progress has changed: " + strM72003l + ", lastProgress: " + f10 + ", progress: " + fMin);
            fMin = f10.floatValue();
        }
        this.f55711b.put(strM72003l, Float.valueOf(fMin));
        return fMin;
    }

    /* renamed from: p */
    public float m72007p(BackupItem backupItem) {
        String strM72003l = m72003l(backupItem);
        switch (backupItem.m29860M()) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.f55711b.remove(strM72003l);
                return 0.0f;
            case 4:
                return m72006o(backupItem);
            case 5:
                return m72005n(backupItem);
            case 6:
            case 7:
                this.f55711b.remove(strM72003l);
                return 100.0f;
            default:
                return 0.0f;
        }
    }

    /* renamed from: q */
    public final float m72008q(BackupItem backupItem) {
        float fM71998g;
        float f10;
        switch (backupItem.m29860M()) {
            case 0:
            default:
                return 0.0f;
            case 1:
                return m71998g(backupItem.m29882r(), backupItem.m29881q()) * 0.05f;
            case 2:
                fM71998g = m71998g(backupItem.m29883s(), backupItem.m29884t()) * 0.05f;
                f10 = 5.0f;
                break;
            case 3:
                fM71998g = m71998g(backupItem.m29885v(), backupItem.m29856A()) * 0.1f;
                f10 = 10.0f;
                break;
            case 4:
                fM71998g = m72006o(backupItem) * 0.7f;
                f10 = 20.0f;
                break;
            case 5:
                fM71998g = m72005n(backupItem) * 0.1f;
                f10 = 90.0f;
                break;
            case 6:
            case 7:
                return 100.0f;
        }
        return fM71998g + f10;
    }

    /* renamed from: r */
    public final void m72009r(final C13026e c13026e) {
        c13026e.m78397u().forEach(new Consumer() { // from class: om.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f55708a.m72010s(c13026e, (BackupOptionItem) obj);
            }
        });
    }

    /* renamed from: s */
    public final /* synthetic */ void m72010s(C13026e c13026e, BackupOptionItem backupOptionItem) {
        long jMo78392m = c13026e.mo78392m(backupOptionItem);
        int iCeil = (jMo78392m <= 0 || !backupOptionItem.getBackupSwitch()) ? backupOptionItem.getItemTotal() > 0 ? (int) Math.ceil(backupOptionItem.getItemTotal() / 10000.0d) : 1 : ((int) Math.ceil(jMo78392m / 1.048576E8d)) + ((int) Math.floor(backupOptionItem.getDataBytes() / 1.048576E9d));
        C11839m.m70686d("BackupV3Progress", backupOptionItem.getAppId() + backupOptionItem.getUid() + " : " + iCeil);
        Map<String, Integer> map = this.f55710a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(backupOptionItem.getAppId());
        sb2.append(backupOptionItem.getUid());
        map.put(sb2.toString(), Integer.valueOf(iCeil));
    }

    /* renamed from: t */
    public final /* synthetic */ void m72011t(List list, CloudBackupStatus cloudBackupStatus) {
        int iM29391a1 = cloudBackupStatus.m29391a1();
        C11839m.m70686d("BackupV3Progress", "db: " + cloudBackupStatus.m29870d() + cloudBackupStatus.m29861N() + " : " + iM29391a1);
        Map<String, Integer> map = this.f55710a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cloudBackupStatus.m29870d());
        sb2.append(cloudBackupStatus.m29861N());
        Integer num = map.get(sb2.toString());
        if (iM29391a1 > 0) {
            this.f55710a.put(cloudBackupStatus.m29870d() + cloudBackupStatus.m29861N(), Integer.valueOf(iM29391a1));
            return;
        }
        if (num == null || num.intValue() <= 0) {
            return;
        }
        cloudBackupStatus.m29399d2(num.intValue());
        list.add(cloudBackupStatus);
    }

    /* renamed from: u */
    public final void m72012u(String str, Deque<CloudBackupStatus> deque, C13026e c13026e) {
        this.f55710a.clear();
        this.f55711b.clear();
        this.f55712c.clear();
        m72009r(c13026e);
        final ArrayList arrayList = new ArrayList();
        deque.forEach(new Consumer() { // from class: om.g
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f55706a.m72011t(arrayList, (CloudBackupStatus) obj);
            }
        });
        try {
            new C12815f(str).batchReplace(arrayList);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupV3Progress", "replace power error: " + e10.getMessage());
        }
    }
}
