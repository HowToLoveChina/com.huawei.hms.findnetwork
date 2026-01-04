package p426kd;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import com.huawei.hicloud.base.bean.DownloadItem;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ke.C11046a;
import p015ak.AbstractC0218h0;
import p015ak.C0221j;
import p015ak.C0241z;
import p514o9.C11839m;
import p516ob.C11845a;
import p570q8.C12293c;
import p606r9.C12478a;
import p607ra.C12481c;
import p652t9.EnumC12999a;
import p684un.C13223b;
import to.C13049a;

@CBServiceTask(request = 55000203, response = 66000203)
/* renamed from: kd.p */
/* loaded from: classes3.dex */
public class C11042p extends AbstractC11040n {

    /* renamed from: z */
    public static final TypeToken<Map<String, ArrayList<Map<String, String>>>> f52192z = new a();

    /* renamed from: kd.p$a */
    public class a extends TypeToken<Map<String, ArrayList<Map<String, String>>>> {
    }

    /* renamed from: kd.p$b */
    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f52193a;

        static {
            int[] iArr = new int[ModuleItem.State.values().length];
            f52193a = iArr;
            try {
                iArr[ModuleItem.State.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52193a[ModuleItem.State.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52193a[ModuleItem.State.CANCLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52193a[ModuleItem.State.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52193a[ModuleItem.State.NORMAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f52193a[ModuleItem.State.DELETING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f52193a[ModuleItem.State.DONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // p426kd.AbstractC11040n
    /* renamed from: C */
    public void mo66572C(ModuleItem.State state) {
        int i10 = b.f52193a[state.ordinal()];
        if (i10 == 1 || i10 == 2) {
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, 0, 0, null);
            return;
        }
        if (i10 == 3) {
            CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
            cloudDiskModuleRst.setRetCode(3);
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, 3, 0, cloudDiskModuleRst);
        } else {
            if (i10 != 4) {
                return;
            }
            CloudDiskModuleRst cloudDiskModuleRst2 = new CloudDiskModuleRst();
            cloudDiskModuleRst2.setRetCode(-1);
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, -1, 0, cloudDiskModuleRst2);
        }
    }

    @Override // p426kd.AbstractC11040n
    /* renamed from: H */
    public CloudDiskModuleRst mo66576H() throws InterruptedException {
        C0221j.m1494d(this.f52183t, "notepad");
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        try {
            cloudDiskModuleRst.setRetCode(-1);
            cloudDiskModuleRst.setModuleName("notepad");
            ArrayList<DownloadItem> downloadItems = this.f52179p.getDownloadItems();
            if (downloadItems == null) {
                CloudDiskModuleRst cloudDiskModuleRstM66586Q = m66586Q(cloudDiskModuleRst);
                if (cloudDiskModuleRstM66586Q != null) {
                    return cloudDiskModuleRstM66586Q;
                }
            } else {
                CloudDiskModuleRst cloudDiskModuleRstM66585P = m66585P(cloudDiskModuleRst, downloadItems);
                if (cloudDiskModuleRstM66585P != null) {
                    return cloudDiskModuleRstM66585P;
                }
            }
            cloudDiskModuleRst = m66588S();
            this.f52179p.setProgress(100);
            C11046a.m66594b(this.f53297m, C11046a.m66595c(this.f52179p.getNum(), "notepad", false));
            cloudDiskModuleRst.setModuleName("notepad");
            cloudDiskModuleRst.setDeviceID(this.f52179p.getDeviceID());
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e10) {
                C11839m.m70687e("RestoreNotepadTask", "InterruptedException :" + e10.toString());
            }
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, 0, 0, cloudDiskModuleRst);
            C0221j.m1494d(this.f52183t, "notepad");
        } catch (C9721b e11) {
            C11839m.m70689w("RestoreNotepadTask", "ICBException" + e11.m60659c());
            cloudDiskModuleRst.setFailReason(e11.getMessage());
            if (1001 == e11.m60659c()) {
                cloudDiskModuleRst.setRetCode(3);
                C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, 3, 0, cloudDiskModuleRst);
            } else {
                cloudDiskModuleRst.setRetCode(-1);
                C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, -1, 0, cloudDiskModuleRst);
            }
        }
        return cloudDiskModuleRst;
    }

    @Override // p426kd.AbstractC11040n
    /* renamed from: I */
    public void mo66577I() {
        this.f52180q = "notepad";
        this.f52181r = 259;
        this.f52182s = R$string.cloudbackup_notify_tile_notepad_new;
        this.f52184u = C11845a.m70927n("notepad");
        this.f52187x = "102";
    }

    /* renamed from: P */
    public final CloudDiskModuleRst m66585P(CloudDiskModuleRst cloudDiskModuleRst, ArrayList<DownloadItem> arrayList) throws C9721b {
        if (arrayList == null) {
            cloudDiskModuleRst.setRetCode(-1);
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, -1, 0, cloudDiskModuleRst);
            C11839m.m70687e("RestoreNotepadTask", "notepad res download fail, download item is null");
            cloudDiskModuleRst.setFailReason("download item is null");
            return cloudDiskModuleRst;
        }
        DownloadItem downloadItemM66587R = m66587R(arrayList, SnapshotDBManager.SUFFIX_DATABASE_NAME);
        if (downloadItemM66587R == null) {
            cloudDiskModuleRst.setRetCode(-1);
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, -1, 0, cloudDiskModuleRst);
            C11839m.m70687e("RestoreNotepadTask", "notepad res download fail");
            cloudDiskModuleRst.setFailReason("db item is null");
            return cloudDiskModuleRst;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f52183t);
            String str = File.separator;
            sb2.append(str);
            sb2.append(downloadItemM66587R.getFileName());
            downloadItemM66587R.setSavePath(sb2.toString());
            new C12481c(downloadItemM66587R, this.f52188y).m74951c(true);
            if (m68511i()) {
                C11839m.m70688i("RestoreNotepadTask", "restore notepad task is aborted after request");
                cloudDiskModuleRst.setRetCode(3);
                mo66572C(ModuleItem.State.CANCLE);
                return cloudDiskModuleRst;
            }
            DownloadItem downloadItemM66587R2 = m66587R(arrayList, FeedbackWebConstants.SUFFIX);
            if (downloadItemM66587R2 == null) {
                C11839m.m70687e("RestoreNotepadTask", "notepad zipItem is null");
                return null;
            }
            try {
                this.f52188y.m66584b(true);
                downloadItemM66587R2.setSavePath(this.f52183t + str + downloadItemM66587R2.getFileName());
                new C12481c(downloadItemM66587R2, this.f52188y).m74951c(true);
                cloudDiskModuleRst.setTotalSize(downloadItemM66587R2.getFileSize());
                cloudDiskModuleRst.setSuccessSize(downloadItemM66587R2.getFileSize());
                C11046a.m66593a(this.f53297m, 1109, 0, 0, cloudDiskModuleRst);
                if (!m68511i()) {
                    return null;
                }
                C11839m.m70688i("RestoreNotepadTask", "restore notepad task is aborted after request");
                cloudDiskModuleRst.setRetCode(3);
                mo66572C(ModuleItem.State.CANCLE);
                return cloudDiskModuleRst;
            } catch (C9721b | IOException e10) {
                cloudDiskModuleRst.setRetCode(-1);
                C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, -1, 0, cloudDiskModuleRst);
                C11839m.m70687e("RestoreNotepadTask", "notepad res download fail");
                cloudDiskModuleRst.setFailReason(e10.getMessage());
                return cloudDiskModuleRst;
            }
        } catch (C9721b | IOException e11) {
            cloudDiskModuleRst.setRetCode(-1);
            C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, -1, 0, cloudDiskModuleRst);
            C11839m.m70687e("RestoreNotepadTask", "notepad res download fail");
            cloudDiskModuleRst.setFailReason(e11.getMessage());
            return cloudDiskModuleRst;
        }
    }

    /* renamed from: Q */
    public final CloudDiskModuleRst m66586Q(CloudDiskModuleRst cloudDiskModuleRst) throws C9721b {
        String str;
        String str2;
        if (C10028c.m62182c0().m62420y1()) {
            str = "/Hicloud/" + this.f52179p.getDeviceIdMD5() + "/sysdata/" + this.f52180q + SnapshotDBManager.SUFFIX_DATABASE_NAME;
        } else {
            str = "/NoteBackup/" + this.f52179p.getDeviceIdMD5() + "/" + this.f52180q + SnapshotDBManager.SUFFIX_DATABASE_NAME;
        }
        String str3 = this.f52183t + "/" + this.f52180q + SnapshotDBManager.SUFFIX_DATABASE_NAME;
        EnumC12999a enumC12999a = EnumC12999a.CLOUD_MORE;
        new C12478a(enumC12999a, this.f52186w).m74913i(str, str3, this.f52188y);
        if (m68511i()) {
            C11839m.m70688i("RestoreNotepadTask", "restore notepad task is aborted before request");
            cloudDiskModuleRst.setRetCode(3);
            mo66572C(ModuleItem.State.CANCLE);
            return cloudDiskModuleRst;
        }
        if (C10028c.m62182c0().m62420y1()) {
            str2 = "/Hicloud/" + this.f52179p.getDeviceIdMD5() + "/sysdata/";
        } else {
            str2 = "/NoteBackup/" + this.f52179p.getDeviceIdMD5() + "/";
        }
        List<Map<String, Object>> successList = new C13049a(enumC12999a, this.f52186w).m78709H(new String[]{str2 + "notepadRes.zip"}, new String[]{"name", "size", "itemcount"}).getSuccessList();
        if (successList != null && successList.size() == 1) {
            String str4 = (String) successList.get(0).get("size");
            C11046a.m66593a(this.f53297m, NotifyErr.NET_DISABLE_HMS_ERROR, 0, 0, null);
            try {
                this.f52188y.m66584b(true);
                new C12478a(enumC12999a, this.f52186w).m74913i(str2 + "notepadRes.zip", this.f52183t + "/notepadRes.zip", this.f52188y);
                cloudDiskModuleRst.setTotalSize(C0241z.m1688f(str4));
                cloudDiskModuleRst.setSuccessSize(C0241z.m1688f(str4));
                C11839m.m70688i("RestoreNotepadTask", "notepad res download success,successNum is " + cloudDiskModuleRst.getSuccessSize() + ",totalSize is " + cloudDiskModuleRst.getTotalSize());
                C11046a.m66593a(this.f53297m, 1109, 0, 0, cloudDiskModuleRst);
            } catch (C9721b e10) {
                cloudDiskModuleRst.setRetCode(-1);
                C11046a.m66593a(this.f53297m, FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, -1, 0, cloudDiskModuleRst);
                C11839m.m70687e("RestoreNotepadTask", "notepad res download fail");
                cloudDiskModuleRst.setFailReason(e10.getMessage());
                return cloudDiskModuleRst;
            }
        }
        if (!m68511i()) {
            return null;
        }
        C11839m.m70688i("RestoreNotepadTask", "restore notepad task is aborted after request");
        cloudDiskModuleRst.setRetCode(3);
        mo66572C(ModuleItem.State.CANCLE);
        return cloudDiskModuleRst;
    }

    /* renamed from: R */
    public final DownloadItem m66587R(ArrayList<DownloadItem> arrayList, String str) {
        Iterator<DownloadItem> it = arrayList.iterator();
        while (it.hasNext()) {
            DownloadItem next = it.next();
            String fileName = next.getFileName();
            if (!TextUtils.isEmpty(fileName) && fileName.endsWith(str)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: S */
    public CloudDiskModuleRst m66588S() {
        int num = this.f52179p.getNum();
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        C12293c c12293c = new C12293c();
        AbstractC0218h0 abstractC0218h0M1485M = C0221j.m1485M(this.f52183t, null, null, "notepad", "storHandlerForData", this.f53297m);
        if (abstractC0218h0M1485M == null) {
            return cloudDiskModuleRst;
        }
        CloudDiskModuleRst cloudDiskModuleRstM73859f = c12293c.m73859f(this.f53282a, abstractC0218h0M1485M, this.f53297m, Integer.valueOf(num));
        abstractC0218h0M1485M.mo1452a();
        if (cloudDiskModuleRstM73859f.getRetCode() == -1) {
            cloudDiskModuleRstM73859f.setRetCode(-1);
        } else if (cloudDiskModuleRstM73859f.getSuccessNum() > num) {
            cloudDiskModuleRstM73859f.setTotalNum(cloudDiskModuleRstM73859f.getSuccessNum());
            cloudDiskModuleRstM73859f.setRetCode(0);
        } else {
            cloudDiskModuleRstM73859f.setTotalNum(num);
            cloudDiskModuleRstM73859f.setRetCode(0);
        }
        C13223b.m79473a(this.f53282a, "CLOUDBACKUP_RESTORENUM_SYSTEMDATA_ALL_NOTE", "" + num);
        UBAAnalyze.m29949J("CKC", "CLOUDBACKUP_RESTORENUM_SYSTEMDATA_ALL_NOTE", "value", "" + num);
        C13223b.m79473a(this.f53282a, "CLOUDBACKUP_RESTORENUM_SYSTEMDATA_SUCESS_NOTE", "" + cloudDiskModuleRstM73859f.getSuccessNum());
        UBAAnalyze.m29949J("CKC", "CLOUDBACKUP_RESTORENUM_SYSTEMDATA_SUCESS_NOTE", "value", "" + cloudDiskModuleRstM73859f.getSuccessNum());
        return cloudDiskModuleRstM73859f;
    }
}
