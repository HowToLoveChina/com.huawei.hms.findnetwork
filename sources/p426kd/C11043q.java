package p426kd;

import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import fk.C9721b;
import gp.C10028c;
import je.C10812z;
import ke.C11046a;
import p015ak.AbstractC0218h0;
import p015ak.C0221j;
import p514o9.C11839m;
import p516ob.C11845a;
import p605r8.C12476a;
import p606r9.C12478a;
import p652t9.EnumC12999a;

@CBServiceTask(request = 55000205, response = 66000205)
/* renamed from: kd.q */
/* loaded from: classes3.dex */
public class C11043q extends AbstractC11040n {

    /* renamed from: kd.q$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f52194a;

        static {
            int[] iArr = new int[ModuleItem.State.values().length];
            f52194a = iArr;
            try {
                iArr[ModuleItem.State.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52194a[ModuleItem.State.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52194a[ModuleItem.State.CANCLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52194a[ModuleItem.State.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52194a[ModuleItem.State.NORMAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f52194a[ModuleItem.State.DELETING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f52194a[ModuleItem.State.DONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // p426kd.AbstractC11040n
    /* renamed from: C */
    public void mo66572C(ModuleItem.State state) {
        C11839m.m70688i("callbackSendMsg", CommonConstant.ReqAccessTokenParam.STATE_LABEL + state);
        int i10 = a.f52194a[state.ordinal()];
        if (i10 == 1 || i10 == 2) {
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, 0, 0, null);
            return;
        }
        if (i10 == 3) {
            CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
            cloudDiskModuleRst.setRetCode(3);
            C11046a.m66593a(this.f53297m, 1017, 3, 0, cloudDiskModuleRst);
        } else {
            if (i10 != 4) {
                return;
            }
            CloudDiskModuleRst cloudDiskModuleRst2 = new CloudDiskModuleRst();
            cloudDiskModuleRst2.setRetCode(-1);
            C11046a.m66593a(this.f53297m, 1017, -1, 0, cloudDiskModuleRst2);
        }
    }

    @Override // p426kd.AbstractC11040n
    /* renamed from: H */
    public CloudDiskModuleRst mo66576H() throws InterruptedException {
        C11839m.m70688i("RestorePhoneManagerTask", "restoreData start");
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        C0221j.m1494d(this.f52183t, "phonemanager");
        if (m68511i()) {
            C11839m.m70688i("RestorePhoneManagerTask", "restoreData is aborted before request!");
            cloudDiskModuleRst.setRetCode(3);
            mo66572C(ModuleItem.State.CANCLE);
            return cloudDiskModuleRst;
        }
        cloudDiskModuleRst.setRetCode(-1);
        cloudDiskModuleRst.setModuleName("phonemanager");
        cloudDiskModuleRst.setDeviceID(this.f52179p.getDeviceID());
        m66589P(cloudDiskModuleRst);
        if (m68511i()) {
            C11839m.m70688i("RestorePhoneManagerTask", "restoreData is aborted after request!");
            cloudDiskModuleRst.setRetCode(3);
            mo66572C(ModuleItem.State.CANCLE);
            return cloudDiskModuleRst;
        }
        m66590Q(cloudDiskModuleRst);
        this.f52179p.setProgress(100);
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e10) {
            C11839m.m70687e("RestorePhoneManagerTask", "InterruptedException :" + e10.toString());
        }
        C11046a.m66593a(this.f53297m, 1017, 0, 0, cloudDiskModuleRst);
        C0221j.m1494d(this.f52183t, "phonemanager");
        return cloudDiskModuleRst;
    }

    @Override // p426kd.AbstractC11040n
    /* renamed from: I */
    public void mo66577I() {
        this.f52180q = "autophonemanagerkey";
        this.f52181r = 517;
        this.f52182s = R$string.cloudbackup_notify_tile_phonemanager_new;
        this.f52184u = C11845a.m70927n("phonemanager");
        this.f52187x = "112";
    }

    /* renamed from: P */
    public final void m66589P(CloudDiskModuleRst cloudDiskModuleRst) {
        String str;
        try {
            C11839m.m70688i("RestorePhoneManagerTask", "downloadFile start");
            this.f52188y.m66584b(true);
            C12478a c12478a = new C12478a(EnumC12999a.CLOUD_MORE, this.f52186w);
            if (C10028c.m62182c0().m62420y1()) {
                str = "/Hicloud/" + this.f52179p.getDeviceIdMD5() + "/sysdata/phonemanager" + SnapshotDBManager.SUFFIX_DATABASE_NAME;
            } else {
                str = "/BlockedBackup/" + this.f52179p.getDeviceIdMD5() + "/phonemanager" + SnapshotDBManager.SUFFIX_DATABASE_NAME;
            }
            c12478a.m74913i(str, this.f52183t + "/phonemanager" + SnapshotDBManager.SUFFIX_DATABASE_NAME, this.f52188y);
        } catch (C9721b e10) {
            C11839m.m70689w("RestorePhoneManagerTask", "ICBException" + e10.m60659c() + ",Message:" + e10.getMessage());
            if (1001 == e10.m60659c()) {
                cloudDiskModuleRst.setRetCode(3);
                C11046a.m66593a(this.f53297m, 1017, 3, 0, cloudDiskModuleRst);
            } else {
                cloudDiskModuleRst.setRetCode(-1);
                C11046a.m66593a(this.f53297m, 1017, -1, 0, cloudDiskModuleRst);
            }
            C10812z.m65838g(this.f53282a, "phonemanager", e10.m60663g(), "112", e10.getMessage(), "03010", "local_download", this.f52186w);
        }
    }

    /* renamed from: Q */
    public void m66590Q(CloudDiskModuleRst cloudDiskModuleRst) {
        int num = this.f52179p.getNum();
        C12476a c12476a = new C12476a();
        AbstractC0218h0 abstractC0218h0M1485M = C0221j.m1485M(C0221j.m1515y(), null, null, "phonemanager", "storHandlerForData", this.f53297m);
        if (abstractC0218h0M1485M == null) {
            return;
        }
        CloudDiskModuleRst cloudDiskModuleRstM74877e = c12476a.m74877e(this.f53282a, abstractC0218h0M1485M, null, this.f53297m, num, null, false);
        abstractC0218h0M1485M.mo1452a();
        cloudDiskModuleRst.setRetCode(cloudDiskModuleRstM74877e.getRetCode());
        cloudDiskModuleRst.setSuccessNum(cloudDiskModuleRstM74877e.getSuccessNum());
        cloudDiskModuleRst.setFailNum(cloudDiskModuleRstM74877e.getFailNum());
        if (cloudDiskModuleRst.getRetCode() != -1) {
            if (cloudDiskModuleRst.getSuccessNum() > num) {
                cloudDiskModuleRst.setTotalNum(cloudDiskModuleRst.getSuccessNum());
                cloudDiskModuleRst.setRetCode(0);
            } else {
                cloudDiskModuleRst.setTotalNum(num);
                cloudDiskModuleRst.setRetCode(0);
            }
        }
    }
}
