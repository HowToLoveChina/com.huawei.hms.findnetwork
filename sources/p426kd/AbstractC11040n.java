package p426kd;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.hicloud.p088ui.notification.CloudSyncNotificationManager;
import com.huawei.android.sync.R$plurals;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import com.huawei.hicloud.base.bean.ModuleItem;
import fk.C9721b;
import hk.C10278a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import je.C10812z;
import ke.C11046a;
import md.C11439b;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0221j;
import p514o9.C11839m;
import p516ob.C11845a;

/* renamed from: kd.n */
/* loaded from: classes3.dex */
public abstract class AbstractC11040n extends C11439b<Boolean> {

    /* renamed from: p */
    public ModuleItem f52179p;

    /* renamed from: q */
    public String f52180q;

    /* renamed from: r */
    public int f52181r;

    /* renamed from: s */
    public int f52182s;

    /* renamed from: t */
    public String f52183t;

    /* renamed from: w */
    public String f52186w;

    /* renamed from: u */
    public List<ModuleItem> f52184u = new ArrayList();

    /* renamed from: v */
    public CloudSyncNotificationManager f52185v = null;

    /* renamed from: x */
    public String f52187x = "";

    /* renamed from: y */
    public a f52188y = new a(false);

    /* renamed from: kd.n$a */
    public class a implements ICallback {

        /* renamed from: a */
        public boolean f52189a;

        public a(boolean z10) {
            this.f52189a = z10;
        }

        /* renamed from: b */
        public void m66584b(boolean z10) {
            this.f52189a = z10;
        }

        @Override // com.huawei.android.hicloud.connect.progress.ICallback
        public void onProgress(long j10, long j11) {
            if (this.f52189a) {
                if ("autophonemanagerkey".equals(AbstractC11040n.this.f52180q)) {
                    C11046a.m66593a(AbstractC11040n.this.f53297m, 1110, (int) j10, (int) j11, null);
                } else if ("notepad".equals(AbstractC11040n.this.f52180q)) {
                    C11046a.m66593a(AbstractC11040n.this.f53297m, 1108, (int) j10, (int) j11, null);
                }
            }
        }

        @Override // com.huawei.android.hicloud.connect.progress.ICallback
        public boolean onStop() {
            return AbstractC11040n.this.f53287f;
        }
    }

    /* renamed from: G */
    private boolean m66568G() {
        if (!"notepad".equals(this.f52180q) && !"autophonemanagerkey".equals(this.f52180q) && !"autorecordingkey".equals(this.f52180q)) {
            return true;
        }
        if (!C0221j.m1475C(this.f53282a, this.f53297m)) {
            return false;
        }
        String strM1515y = C0221j.m1515y();
        this.f52183t = strM1515y;
        if (strM1515y == null || !C10278a.m63442h(strM1515y).exists()) {
            return false;
        }
        if (C0221j.m1492b(this.f52183t, this.f53297m)) {
            return true;
        }
        mo66572C(ModuleItem.State.FAILED);
        return false;
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
        this.f53298n = 1;
        super.mo66488a(bool);
    }

    /* renamed from: C */
    public abstract void mo66572C(ModuleItem.State state);

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        while (m66575F()) {
            m66578J();
        }
        return Boolean.TRUE;
    }

    /* renamed from: E */
    public final boolean m66574E() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(C11845a.m70921h());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((ModuleItem) it.next()).getState().equals(ModuleItem.State.LOADING)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: F */
    public final boolean m66575F() {
        ModuleItem next;
        Iterator<ModuleItem> it = this.f52184u.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (ModuleItem.State.WAITING.equals(next.getState())) {
                break;
            }
        }
        if (next == null) {
            this.f52179p = null;
            return false;
        }
        this.f52179p = next;
        next.setInTask(true);
        this.f53298n = 1;
        mo66572C(ModuleItem.State.WAITING);
        mo18031w();
        return true;
    }

    /* renamed from: H */
    public abstract CloudDiskModuleRst mo66576H();

    /* renamed from: I */
    public abstract void mo66577I();

    /* renamed from: J */
    public final void m66578J() throws C9721b {
        C11839m.m70688i("RestoreBaseTask", "RestoreTask restoreRaw start");
        if (this.f52179p == null) {
            return;
        }
        while (m66574E()) {
            if (m68511i()) {
                C11839m.m70688i("RestoreBaseTask", "restoreData is aborted during wait,module is " + this.f52180q);
                mo66572C(ModuleItem.State.CANCLE);
                return;
            }
        }
        if (this.f53298n == 1) {
            ModuleItem moduleItem = this.f52179p;
            ModuleItem.State state = ModuleItem.State.LOADING;
            moduleItem.setState(state);
            mo66572C(state);
            if (m66568G()) {
                if (m68511i()) {
                    C11839m.m70688i("RestoreBaseTask", "restoreData is aborted before request,module is " + this.f52180q);
                    mo66572C(ModuleItem.State.CANCLE);
                    return;
                }
                C11839m.m70688i("RestoreBaseTask", "restoreData start name = " + this.f52180q);
                CloudDiskModuleRst cloudDiskModuleRstMo66576H = mo66576H();
                if (cloudDiskModuleRstMo66576H.getRetCode() == 3) {
                    String strM68516p = m68516p(this.f53297m.m68522a());
                    cloudDiskModuleRstMo66576H.setFailReason(strM68516p);
                    C11839m.m70688i("RestoreBaseTask", "module:" + cloudDiskModuleRstMo66576H.getModuleName() + ",errorReason:" + strM68516p);
                }
                String failReason = cloudDiskModuleRstMo66576H.getFailReason();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("successNum", String.valueOf(cloudDiskModuleRstMo66576H.getSuccessNum()));
                linkedHashMap.put("failNum", String.valueOf(cloudDiskModuleRstMo66576H.getFailNum()));
                linkedHashMap.put("noChangeNum", String.valueOf(cloudDiskModuleRstMo66576H.getNochangeNum()));
                linkedHashMap.put("totalNum", String.valueOf(cloudDiskModuleRstMo66576H.getTotalNum()));
                linkedHashMap.put("deviceName", this.f52179p.getDisplayName() == null ? "Other" : this.f52179p.getDisplayName());
                C11839m.m70688i("RestoreBaseTask", cloudDiskModuleRstMo66576H.getModuleName() + ",code: " + cloudDiskModuleRstMo66576H.getRetCode() + ",successNum: " + cloudDiskModuleRstMo66576H.getSuccessNum() + ",failNum: " + cloudDiskModuleRstMo66576H.getFailNum() + ",noChangeNum: " + cloudDiskModuleRstMo66576H.getNochangeNum() + ",totalNum: " + cloudDiskModuleRstMo66576H.getTotalNum() + ",traceId: " + this.f52186w);
                C10812z.m65839h(this.f53282a, cloudDiskModuleRstMo66576H.getModuleName(), cloudDiskModuleRstMo66576H.getRetCode(), this.f52187x, failReason, "03010", "more_data_restore", this.f52186w, linkedHashMap, true);
            }
        }
    }

    /* renamed from: K */
    public final void m66579K(Message message) {
        if (message.arg2 != this.f52179p.getNum()) {
            this.f52179p.setNum(message.arg2);
        }
        int i10 = (message.arg1 * 100) / message.arg2;
        if (i10 > 5) {
            this.f52179p.setProgress(i10);
        }
    }

    /* renamed from: L */
    public final void m66580L(Message message) {
        Bundle data = message.getData();
        long j10 = data.getLong("completedSize");
        long j11 = data.getLong("totalSize");
        if (j11 == 0) {
            this.f52179p.setProgress(100);
            return;
        }
        int i10 = (int) ((j10 * 100) / j11);
        if (i10 > 5) {
            this.f52179p.setProgress(i10);
        }
    }

    /* renamed from: M */
    public final void m66581M(Message message) {
        int i10 = message.arg2;
        if (i10 == 0) {
            this.f52179p.setProgress(100);
            return;
        }
        int i11 = (message.arg1 * 95) / i10;
        if (i11 > 5) {
            this.f52179p.setProgress(i11);
        }
    }

    /* renamed from: N */
    public final void m66582N(Message message) throws Resources.NotFoundException, NumberFormatException {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "deviceNameSp", 0);
        CloudDiskModuleRst cloudDiskModuleRst = (CloudDiskModuleRst) message.obj;
        int failNum = cloudDiskModuleRst.getFailNum();
        int successNum = cloudDiskModuleRst.getSuccessNum() + cloudDiskModuleRst.getNochangeNum();
        String deviceID = cloudDiskModuleRst.getDeviceID();
        if (cloudDiskModuleRst.getRetCode() == -1) {
            message.arg1 = -1;
            m66583O(message, failNum, successNum);
        } else if (cloudDiskModuleRst.getRetCode() != 3 && cloudDiskModuleRst.getRetCode() != 0) {
            message.arg1 = 2;
            m66583O(message, failNum, successNum);
        }
        this.f52179p.setInTask(false);
        this.f52179p.setState(ModuleItem.State.NORMAL);
        if (cloudDiskModuleRst.getRetCode() != 0 || TextUtils.isEmpty(deviceID)) {
            return;
        }
        sharedPreferencesM1382b.edit().putBoolean(this.f52180q + "_download" + deviceID, true).commit();
    }

    /* renamed from: O */
    public final void m66583O(Message message, int i10, int i11) throws Resources.NotFoundException, NumberFormatException {
        String string = this.f52179p.getName() == null ? this.f53282a.getResources().getString(R$string.setting_other) : this.f52179p.getName();
        int i12 = message.arg1;
        if (i12 == -1) {
            this.f52185v.sendRestoreNotify(this.f52181r, this.f52179p.getDeviceID(), this.f53282a.getResources().getString(this.f52182s, string), this.f53282a.getResources().getString(R$string.download_fail_item));
            return;
        }
        if (i12 == 2) {
            CloudSyncNotificationManager cloudSyncNotificationManager = this.f52185v;
            int i13 = this.f52181r;
            String deviceID = this.f52179p.getDeviceID();
            String string2 = this.f53282a.getResources().getString(this.f52182s, string);
            Resources resources = this.f53282a.getResources();
            int i14 = R$string.notify_download_potal_success;
            Resources resources2 = this.f53282a.getResources();
            int i15 = R$plurals.cloudbackup_some_records;
            cloudSyncNotificationManager.sendRestoreNotify(i13, deviceID, string2, resources.getString(i14, resources2.getQuantityString(i15, i11, Integer.valueOf(i11)), this.f53282a.getResources().getQuantityString(i15, i10, Integer.valueOf(i10))));
        }
    }

    @Override // md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("RestoreBaseTask", "RestoreTask beforeWorkStart");
        mo66577I();
        Context context = this.f53282a;
        if (context == null) {
            C11839m.m70687e("RestoreBaseTask", "beforeWorkStart mContext is null");
        } else {
            this.f52185v = new CloudSyncNotificationManager(context);
            this.f52186w = C10812z.m65832a("03010");
        }
    }

    @Override // md.C11439b
    /* renamed from: l */
    public void mo66492l(boolean z10) {
        super.mo66492l(z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    @Override // md.C11439b
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo66493r(android.os.Message r5) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            r4 = this;
            super.mo66493r(r5)
            int r0 = r5.what
            r1 = 15
            r2 = 0
            if (r0 == r1) goto L38
            r1 = 1103(0x44f, float:1.546E-42)
            if (r0 == r1) goto L34
            r1 = 1106(0x452, float:1.55E-42)
            if (r0 == r1) goto L34
            r1 = 1108(0x454, float:1.553E-42)
            if (r0 == r1) goto L30
            r1 = 1110(0x456, float:1.555E-42)
            if (r0 == r1) goto L30
            r1 = 99101(0x1831d, float:1.3887E-40)
            if (r0 == r1) goto L38
            r1 = 99813(0x185e5, float:1.39868E-40)
            if (r0 == r1) goto L2c
            switch(r0) {
                case 1013: goto L28;
                case 1014: goto L28;
                case 1015: goto L28;
                case 1016: goto L28;
                case 1017: goto L28;
                default: goto L27;
            }
        L27:
            goto L68
        L28:
            r4.m66582N(r5)
            goto L68
        L2c:
            r4.m66580L(r5)
            goto L68
        L30:
            r4.m66581M(r5)
            goto L68
        L34:
            r4.m66579K(r5)
            goto L68
        L38:
            java.util.List<com.huawei.hicloud.base.bean.ModuleItem> r5 = r4.f52184u
            java.util.Iterator r5 = r5.iterator()
        L3e:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L5c
            java.lang.Object r0 = r5.next()
            com.huawei.hicloud.base.bean.ModuleItem r0 = (com.huawei.hicloud.base.bean.ModuleItem) r0
            com.huawei.hicloud.base.bean.ModuleItem$State r1 = com.huawei.hicloud.base.bean.ModuleItem.State.WAITING
            com.huawei.hicloud.base.bean.ModuleItem$State r3 = r0.getState()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L3e
            com.huawei.hicloud.base.bean.ModuleItem$State r1 = com.huawei.hicloud.base.bean.ModuleItem.State.NORMAL
            r0.setState(r1)
            goto L3e
        L5c:
            com.huawei.hicloud.base.bean.ModuleItem r5 = r4.f52179p
            r5.setInTask(r2)
            com.huawei.hicloud.base.bean.ModuleItem r4 = r4.f52179p
            com.huawei.hicloud.base.bean.ModuleItem$State r5 = com.huawei.hicloud.base.bean.ModuleItem.State.NORMAL
            r4.setState(r5)
        L68:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p426kd.AbstractC11040n.mo66493r(android.os.Message):boolean");
    }
}
