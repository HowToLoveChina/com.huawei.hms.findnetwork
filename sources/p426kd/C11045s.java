package p426kd;

import com.huawei.android.hicloud.clouddisk.logic.sms.BackupSmsImp;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.android.sync.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import ke.C11046a;
import p514o9.C11839m;
import p516ob.C11845a;

@CBServiceTask(request = 55000201, response = 66000201)
/* renamed from: kd.s */
/* loaded from: classes3.dex */
public class C11045s extends AbstractC11040n {

    /* renamed from: kd.s$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f52196a;

        static {
            int[] iArr = new int[ModuleItem.State.values().length];
            f52196a = iArr;
            try {
                iArr[ModuleItem.State.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52196a[ModuleItem.State.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52196a[ModuleItem.State.CANCLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52196a[ModuleItem.State.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52196a[ModuleItem.State.NORMAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f52196a[ModuleItem.State.DELETING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f52196a[ModuleItem.State.DONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // p426kd.AbstractC11040n
    /* renamed from: C */
    public void mo66572C(ModuleItem.State state) {
        int i10 = a.f52196a[state.ordinal()];
        if (i10 == 1) {
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, 0, 0, null);
            return;
        }
        if (i10 == 2) {
            C11046a.m66593a(this.f53297m, 1106, 0, this.f52179p.getNum(), NavigationUtils.SMS_SCHEMA_PREF);
            return;
        }
        if (i10 == 3) {
            CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
            cloudDiskModuleRst.setRetCode(3);
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, 3, 0, cloudDiskModuleRst);
        } else {
            if (i10 != 4) {
                return;
            }
            CloudDiskModuleRst cloudDiskModuleRst2 = new CloudDiskModuleRst();
            cloudDiskModuleRst2.setRetCode(-1);
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, -1, 0, cloudDiskModuleRst2);
        }
    }

    @Override // p426kd.AbstractC11040n
    /* renamed from: H */
    public CloudDiskModuleRst mo66576H() throws Throwable {
        C11839m.m70688i("RestoreSmsTask", "RestoreSmsTask restoreData start");
        CloudDiskModuleRst cloudDiskModuleRstOnRestore = new BackupSmsImp(this.f53282a).onRestore(this.f52179p, this.f53297m, this.f52186w);
        cloudDiskModuleRstOnRestore.setModuleName(NavigationUtils.SMS_SCHEMA_PREF);
        cloudDiskModuleRstOnRestore.setDeviceID(this.f52179p.getDeviceID());
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e10) {
            C11839m.m70687e("RestoreSmsTask", "Interrupted : " + e10.toString());
        }
        C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, cloudDiskModuleRstOnRestore.getRetCode(), 0, cloudDiskModuleRstOnRestore);
        return cloudDiskModuleRstOnRestore;
    }

    @Override // p426kd.AbstractC11040n
    /* renamed from: I */
    public void mo66577I() {
        this.f52180q = "autosmslistkey";
        this.f52181r = 257;
        this.f52182s = R$string.cloudbackup_notify_tile_sms_new;
        this.f52184u = C11845a.m70927n(NavigationUtils.SMS_SCHEMA_PREF);
        this.f52187x = "102";
    }
}
