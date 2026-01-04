package p426kd;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.hicloud.sync.syncutil.C2972a;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import fk.C9721b;
import java.io.File;
import java.util.LinkedHashMap;
import je.C10812z;
import ke.C11046a;
import md.C11439b;
import md.C11440c;
import p015ak.C0214f0;
import p015ak.C0221j;
import p514o9.C11829c;
import p514o9.C11839m;
import p573qc.C12338d;
import p606r9.C12478a;
import p652t9.EnumC12999a;
import p664u0.C13108a;
import p684un.C13223b;
import p709vj.C13452e;

/* renamed from: kd.a */
/* loaded from: classes3.dex */
public abstract class AbstractC11027a extends C11439b<Boolean> {

    /* renamed from: A */
    public int f52104A;

    /* renamed from: u */
    public String[] f52111u;

    /* renamed from: y */
    public String f52115y;

    /* renamed from: p */
    public String f52106p = null;

    /* renamed from: q */
    public boolean f52107q = false;

    /* renamed from: r */
    public int f52108r = 0;

    /* renamed from: s */
    public int f52109s = -1;

    /* renamed from: t */
    public boolean f52110t = false;

    /* renamed from: v */
    public String f52112v = "";

    /* renamed from: w */
    public String f52113w = "";

    /* renamed from: x */
    public C12478a f52114x = null;

    /* renamed from: z */
    public String f52116z = "";

    /* renamed from: B */
    public ICallback f52105B = new a();

    /* renamed from: kd.a$a */
    public class a implements ICallback {
        public a() {
        }

        @Override // com.huawei.android.hicloud.connect.progress.ICallback
        public void onProgress(long j10, long j11) {
        }

        @Override // com.huawei.android.hicloud.connect.progress.ICallback
        public boolean onStop() {
            if (AbstractC11027a.this.f52112v.equals("recording")) {
                return AbstractC11027a.this.f53287f || !CloudSyncUtil.m15940A0(AbstractC11027a.this.f53282a, "autorecordingkey");
            }
            return AbstractC11027a.this.f53287f;
        }
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        cloudDiskModuleRst.setModuleName(this.f52113w);
        int i10 = -1;
        if (this.f53298n != -1) {
            if (m68511i() || this.f53297m.m68524c(this.f52112v)) {
                i10 = 3;
            } else if (this.f52107q) {
                i10 = 2;
            }
        }
        cloudDiskModuleRst.setRetCode(i10);
        mo66479D(this.f52109s, this.f52108r, this.f52110t);
        this.f53295k.m68552a().obj = cloudDiskModuleRst;
        C11046a.m66593a(this.f53297m, 1003, 0, 0, cloudDiskModuleRst);
        if (this.f53296l) {
            C0221j.m1494d(this.f52106p, this.f52112v);
        }
        if (C11829c.m70611r0() || m66484I()) {
            return;
        }
        C12338d.m74195s().m74235l0();
    }

    /* renamed from: C */
    public abstract CloudDiskModuleRst mo66478C() throws C9721b;

    /* renamed from: D */
    public abstract void mo66479D(int i10, int i11, boolean z10);

    /* renamed from: E */
    public abstract void mo66480E();

    /* renamed from: F */
    public final void m66481F(Handler.Callback callback) throws C9721b {
        C11839m.m70688i("BackupBaseTask", this.f52112v + " start backupRaw");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C13108a.m78878b(this.f53282a).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT"));
        if (this.f53296l && !C0221j.m1492b(this.f52106p, callback)) {
            C11046a.m66593a(callback, 1004, 0, 0, "fail");
            return;
        }
        if (m66486K()) {
            CloudDiskModuleRst cloudDiskModuleRstMo66478C = mo66478C();
            if (cloudDiskModuleRstMo66478C == null) {
                C11839m.m70687e("BackupBaseTask", "server error, resultCode = " + this.f52109s);
                return;
            }
            cloudDiskModuleRstMo66478C.setModuleName(this.f52112v);
            this.f52107q = cloudDiskModuleRstMo66478C.getRetCode() >= 0;
            this.f52108r = cloudDiskModuleRstMo66478C.getSuccessNum();
            this.f52109s = cloudDiskModuleRstMo66478C.getRetCode();
            C11839m.m70688i("BackupBaseTask", this.f52112v + " backup data resultcode = " + this.f52109s + " successNum = " + this.f52108r);
            if (cloudDiskModuleRstMo66478C.getRetCode() != 0 && cloudDiskModuleRstMo66478C.getRetCode() != 1) {
                this.f52110t = true;
            }
            C11439b.a aVar = (C11439b.a) callback;
            if (aVar.m68524c(this.f52112v)) {
                cloudDiskModuleRstMo66478C.setBiCode("1");
                C13223b.m79485m(this.f53282a, cloudDiskModuleRstMo66478C, this.f52112v);
            } else {
                if (cloudDiskModuleRstMo66478C.getRetCode() == 3) {
                    cloudDiskModuleRstMo66478C.setBiCode("1");
                } else if (cloudDiskModuleRstMo66478C.getRetCode() == -2) {
                    cloudDiskModuleRstMo66478C.setBiCode("3");
                    cloudDiskModuleRstMo66478C.setRetCode(-1);
                    this.f52110t = false;
                    C11046a.m66593a(callback, 99001, 0, 0, cloudDiskModuleRstMo66478C);
                    C11839m.m70687e("BackupBaseTask", "server storage lack, resultCode = " + this.f52109s);
                }
                C13223b.m79485m(this.f53282a, cloudDiskModuleRstMo66478C, this.f52112v);
            }
            if (cloudDiskModuleRstMo66478C.getRetCode() == 3) {
                int iM68522a = aVar.m68522a();
                this.f52104A = iM68522a;
                String strM68516p = m68516p(iM68522a);
                cloudDiskModuleRstMo66478C.setFailReason(strM68516p);
                C11839m.m70688i("BackupBaseTask", "module:" + cloudDiskModuleRstMo66478C.getModuleName() + ",errorReason:" + strM68516p);
            }
            m66487L();
            String failReason = cloudDiskModuleRstMo66478C.getFailReason();
            linkedHashMap.put("successNum", String.valueOf(this.f52108r));
            linkedHashMap.put("failNum", String.valueOf(cloudDiskModuleRstMo66478C.getFailNum()));
            linkedHashMap.put("totalNum", String.valueOf(cloudDiskModuleRstMo66478C.getTotalNum()));
            if (this.f52109s == 0) {
                C11046a.m66593a(callback, 1004, 0, 0, "done");
            } else {
                C11046a.m66593a(callback, 1004, 0, 0, "fail");
            }
            C11839m.m70688i("BackupBaseTask", this.f52112v + ",code = " + this.f52109s + ",successNum:" + String.valueOf(cloudDiskModuleRstMo66478C.getSuccessNum()) + ",failNum:" + String.valueOf(cloudDiskModuleRstMo66478C.getFailNum()) + ",totalNum:" + String.valueOf(cloudDiskModuleRstMo66478C.getTotalNum()) + ",traceId:" + this.f52115y);
            C10812z.m65839h(this.f53282a, this.f52112v, this.f52109s, this.f52116z, failReason, "03009", "more_data_backup", this.f52115y, linkedHashMap, true);
        }
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws C9721b {
        C11839m.m70688i("BackupBaseTask", this.f52112v + " task do work");
        if (this.f52112v == null || !m66486K()) {
            return Boolean.FALSE;
        }
        if (this.f53298n == 1) {
            this.f53298n = 2;
            if (!m66485J()) {
                C11839m.m70689w("BackupBaseTask", "backupFiles MSG_CBS_FILECREATEFAIL");
                CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
                cloudDiskModuleRst.setRetCode(-1);
                cloudDiskModuleRst.setBiCode("4");
                C13223b.m79485m(this.f53282a, cloudDiskModuleRst, this.f52112v);
                C11046a.m66593a(this.f53297m, 1202, 0, 0, null);
                this.f53298n = 0;
            }
            m66481F(this.f53297m);
        }
        return Boolean.TRUE;
    }

    /* renamed from: H */
    public final String m66483H() {
        return this.f52112v.equals(NavigationUtils.SMS_SCHEMA_PREF) ? "autosmslistkey" : this.f52112v.equals("callLog") ? "autocallloglistkey" : this.f52112v.equals("recording") ? "autorecordingkey" : this.f52112v.equals("phonemanager") ? "autophonemanagerkey" : "autoAPPlistkey";
    }

    /* renamed from: I */
    public boolean m66484I() {
        return C11440c.m68531i("autocallloglistkey") || C11440c.m68531i("autosmslistkey") || C11440c.m68531i("autophonemanagerkey") || C11440c.m68531i("autorecordingkey");
    }

    /* renamed from: J */
    public final boolean m66485J() {
        if ("phonemanager".equals(this.f52112v)) {
            if (!C0221j.m1475C(this.f53282a, this.f53297m)) {
                return false;
            }
            String strM1515y = C0221j.m1515y();
            this.f52106p = strM1515y;
            if (strM1515y == null || !new File(this.f52106p).exists()) {
                return false;
            }
            this.f53296l = true;
        }
        return true;
    }

    /* renamed from: K */
    public final boolean m66486K() {
        if (this.f53298n == -1) {
            C11839m.m70686d("BackupBaseTask", "backupRaw not manually cancel");
            C11046a.m66593a(this.f53297m, 1004, 0, 0, "fail");
            return false;
        }
        if (!m68511i() && !this.f53297m.m68524c(this.f52112v)) {
            return true;
        }
        C11839m.m70686d("BackupBaseTask", "backupRaw isAbort");
        C11046a.m66593a(this.f53297m, 1004, 0, 0, "abort");
        return false;
    }

    /* renamed from: L */
    public final void m66487L() {
        if (C11829c.m70611r0() || this.f52104A == 2010) {
            return;
        }
        C2972a.m17812f(this.f52109s, this.f52112v);
    }

    @Override // md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("BackupBaseTask", "BackupTask beforeWorkStart");
        this.f53295k.m68555e(1004);
        String[] strArr = (String[]) this.f53284c.m68549a().m65739d("BackupModuleArray");
        this.f52111u = strArr;
        if (strArr == null || strArr.length <= 0) {
            C11839m.m70687e("BackupBaseTask", "BackupTask params error.");
            return;
        }
        String str = strArr[0];
        this.f52112v = str;
        if (str == null || str.isEmpty()) {
            C11839m.m70687e("BackupBaseTask", "getModulesNumber = 0");
            return;
        }
        if (C13452e.m80781L().m80927i1()) {
            C11839m.m70687e("BackupBaseTask", "Sync Risk");
            return;
        }
        if (C13452e.m80781L().m80917g1()) {
            C11839m.m70687e("BackupBaseTask", "Local ST invalid flag is true");
            return;
        }
        this.f53298n = 1;
        mo66480E();
        this.f52113w = m66483H();
        C11839m.m70688i("BackupBaseTask", this.f52112v + " begin autobackup");
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        cloudDiskModuleRst.setModuleName(this.f52112v);
        cloudDiskModuleRst.setRetCode(4);
        C11046a.m66593a(this.f53297m, 1001, 0, 0, cloudDiskModuleRst);
        String strM65832a = C10812z.m65832a("03009");
        this.f52115y = strM65832a;
        this.f52114x = new C12478a(EnumC12999a.CLOUD_MORE, strM65832a);
        if (C11829c.m70611r0() || "autoAPPlistkey".equals(this.f52113w)) {
            return;
        }
        C12338d.m74195s().m74213Q();
    }

    @Override // md.AbstractC11438a
    /* renamed from: h */
    public void mo66491h() {
        super.mo66491h();
        this.f53286e = C0214f0.m1382b(this.f53282a, "deviceNameSp", 0);
    }

    @Override // md.C11439b
    /* renamed from: l */
    public void mo66492l(boolean z10) {
        super.mo66492l(z10);
    }

    @Override // md.C11439b
    /* renamed from: r */
    public boolean mo66493r(Message message) {
        super.mo66493r(message);
        if (message.what != 1004) {
            return false;
        }
        C11839m.m70688i("BackupBaseTask", "one module backup done." + this.f52112v + " " + message.obj);
        return false;
    }
}
