package p426kd;

import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import gp.C10028c;
import ke.C11046a;
import p015ak.C0221j;
import p513o8.C11826a;
import p514o9.C11839m;
import p516ob.C11845a;
import p684un.C13223b;

@CBServiceTask(request = 55000204, response = 66000204)
/* renamed from: kd.r */
/* loaded from: classes3.dex */
public class C11044r extends AbstractC11040n {

    /* renamed from: kd.r$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f52195a;

        static {
            int[] iArr = new int[ModuleItem.State.values().length];
            f52195a = iArr;
            try {
                iArr[ModuleItem.State.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52195a[ModuleItem.State.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52195a[ModuleItem.State.CANCLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52195a[ModuleItem.State.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52195a[ModuleItem.State.NORMAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f52195a[ModuleItem.State.DELETING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f52195a[ModuleItem.State.DONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // p426kd.AbstractC11040n
    /* renamed from: C */
    public void mo66572C(ModuleItem.State state) {
        C11839m.m70688i("RestoreRecordingTask", "callbackSendMsg: state = " + state);
        int i10 = a.f52195a[state.ordinal()];
        if (i10 == 1 || i10 == 2) {
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, 0, 0, null);
            return;
        }
        if (i10 == 3) {
            CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
            cloudDiskModuleRst.setRetCode(3);
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, 3, 0, cloudDiskModuleRst);
        } else {
            if (i10 != 4) {
                return;
            }
            CloudDiskModuleRst cloudDiskModuleRst2 = new CloudDiskModuleRst();
            cloudDiskModuleRst2.setRetCode(-1);
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, -1, 0, cloudDiskModuleRst2);
        }
    }

    @Override // p426kd.AbstractC11040n
    /* renamed from: H */
    public CloudDiskModuleRst mo66576H() throws InterruptedException {
        C11839m.m70688i("RestoreRecordingTask", "RestoreRecordingTask restoreData start");
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        C11826a c11826a = new C11826a();
        c11826a.m70473x();
        c11826a.m70453A(this.f52186w);
        c11826a.m70475z(this.f52179p.getDisplayName());
        try {
            if (C10028c.m62182c0().m62420y1()) {
                cloudDiskModuleRst = c11826a.m70458d(this.f53282a, "/Hicloud/" + this.f52179p.getDeviceIdMD5() + "/media/recording", "recording", this.f53297m, this.f52188y);
            } else {
                cloudDiskModuleRst = c11826a.m70458d(this.f53282a, "/RecordBackup/" + this.f52179p.getDeviceIdMD5(), "recording", this.f53297m, this.f52188y);
            }
            cloudDiskModuleRst.setModuleName("recording");
            cloudDiskModuleRst.setDeviceID(this.f52179p.getDeviceID());
        } catch (C9721b e10) {
            cloudDiskModuleRst.setRetCode(e10.m60659c());
            cloudDiskModuleRst.setFailReason(e10.getMessage());
            if (1001 == e10.m60659c()) {
                C11839m.m70689w("RestoreRecordingTask", "ICBException" + e10.m60659c());
                C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, 3, 0, cloudDiskModuleRst);
                C0221j.m1494d(this.f52183t, "recording");
                return cloudDiskModuleRst;
            }
            C11839m.m70687e("RestoreRecordingTask", "ICBException" + e10.getMessage());
        }
        m66591P(cloudDiskModuleRst, c11826a);
        return cloudDiskModuleRst;
    }

    @Override // p426kd.AbstractC11040n
    /* renamed from: I */
    public void mo66577I() {
        this.f52180q = "autorecordingkey";
        this.f52181r = 260;
        this.f52182s = R$string.cloudbackup_notify_tile_recording_new;
        this.f52184u = C11845a.m70927n("recordig");
        this.f52187x = "112";
    }

    /* renamed from: P */
    public final void m66591P(CloudDiskModuleRst cloudDiskModuleRst, C11826a c11826a) throws InterruptedException {
        int iM70461h = c11826a.m70461h();
        int iM70470u = c11826a.m70470u();
        int i10 = iM70461h - iM70470u;
        int iM70465n = c11826a.m70465n();
        int i11 = iM70470u + i10 + iM70465n;
        if (-1 == iM70461h || m66592Q(iM70461h, iM70470u, i10, iM70465n)) {
            cloudDiskModuleRst.setRetCode(-1);
            C11839m.m70688i("RestoreRecordingTask", "restore recording fail");
        } else if (iM70461h == 0) {
            cloudDiskModuleRst.setRetCode(0);
            C11839m.m70688i("RestoreRecordingTask", "restore recording noChange");
        } else if (iM70470u + iM70465n == 0) {
            cloudDiskModuleRst.setRetCode(-1);
            C11839m.m70688i("RestoreRecordingTask", "restore recording fail");
        } else if (iM70461h == iM70470u) {
            cloudDiskModuleRst.setRetCode(0);
            C11839m.m70688i("RestoreRecordingTask", "restore recording success");
        } else if (cloudDiskModuleRst.getRetCode() != 3) {
            cloudDiskModuleRst.setRetCode(2);
        }
        C11839m.m70688i("RestoreRecordingTask", "restoreRecording: retCode = " + cloudDiskModuleRst.getRetCode() + ", restoreNum is " + iM70461h + ", successNum is " + iM70470u + ", failNum is " + i10 + ", totalNum is " + i11);
        cloudDiskModuleRst.setFailNum(i10);
        cloudDiskModuleRst.setNochangeNum(iM70465n);
        cloudDiskModuleRst.setSuccessNum(iM70470u);
        cloudDiskModuleRst.setTotalNum(i11);
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e10) {
            C11839m.m70687e("RestoreRecordingTask", "Update UI Progress Interrupted : " + e10.toString());
        }
        C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, 0, 0, cloudDiskModuleRst);
        C13223b.m79473a(this.f53282a, "CLOUDBACKUP_RESTORENUM_ALL_RECORDING", "" + iM70461h);
        UBAAnalyze.m29949J("CKC", "CLOUDBACKUP_RESTORENUM_ALL_RECORDING", "value", "" + iM70461h);
        C13223b.m79473a(this.f53282a, "CLOUDBACKUP_RESTORENUM_SUCESS_RECORDING", "" + iM70470u);
        UBAAnalyze.m29949J("CKC", "CLOUDBACKUP_RESTORENUM_SUCESS_RECORDING", "value", "" + iM70470u);
    }

    /* renamed from: Q */
    public final boolean m66592Q(int i10, int i11, int i12, int i13) {
        return i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0;
    }
}
