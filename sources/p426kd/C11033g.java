package p426kd;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.drive.clouddisk.expand.DriveExpand;
import com.huawei.android.hicloud.drive.clouddisk.expand.SyncDriveRequest;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import je.C10800n;
import md.C11439b;
import p363ia.C10463a;
import p458lo.C11322a;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import p664u0.C13108a;
import to.C13049a;
import ua.C13142a;

@CBServiceTask(request = 55000003, response = 66000003)
/* renamed from: kd.g */
/* loaded from: classes3.dex */
public class C11033g extends C11439b<Boolean> {

    /* renamed from: p */
    public String f52124p;

    /* renamed from: q */
    public int f52125q;

    /* renamed from: r */
    public String f52126r;

    /* renamed from: s */
    public C13049a f52127s = null;

    /* renamed from: t */
    public ArrayList<String> f52128t = null;

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        String string;
        String string2;
        C13108a.m78878b(this.f53282a).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT"));
        if ("autosmslistkey".equals(this.f52126r)) {
            new C11322a().m68030n(this.f52124p, this.f52125q, NavigationUtils.SMS_SCHEMA_PREF);
            return Boolean.TRUE;
        }
        if ("autocallloglistkey".equals(this.f52126r)) {
            new C11322a().m68030n(this.f52124p, this.f52125q, "callLog");
            return Boolean.TRUE;
        }
        if ("autorecordingkey".equals(this.f52126r)) {
            if (C10028c.m62182c0().m62420y1()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("/Hicloud");
                String str = File.separator;
                sb2.append(str);
                sb2.append(this.f52124p);
                sb2.append("/media");
                sb2.append(str);
                sb2.append("recording");
                string2 = sb2.toString();
            } else {
                string2 = "/RecordBackup" + File.separator + this.f52124p;
            }
            return Boolean.valueOf(m66520C(new String[]{string2}));
        }
        if (!"autophonemanagerkey".equals(this.f52126r)) {
            if (!"notepad".equals(this.f52126r)) {
                return Boolean.FALSE;
            }
            ArrayList<String> arrayList = this.f52128t;
            return (arrayList == null || arrayList.isEmpty()) ? Boolean.valueOf(m66523z()) : Boolean.valueOf(m66522y());
        }
        if (C10028c.m62182c0().m62420y1()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("/Hicloud");
            String str2 = File.separator;
            sb3.append(str2);
            sb3.append(this.f52124p);
            sb3.append("/sysdata");
            sb3.append(str2);
            sb3.append("phonemanager");
            sb3.append(SnapshotDBManager.SUFFIX_DATABASE_NAME);
            string = sb3.toString();
        } else {
            string = "/BlockedBackup" + File.separator + this.f52124p;
        }
        return Boolean.valueOf(m66520C(new String[]{string}));
    }

    @Override // md.C11439b
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public Bundle mo66521n(Boolean bool) {
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        Bundle bundle = new Bundle();
        bundle.putString("moduleName", this.f52126r);
        bundle.putString("deviceId", this.f52124p);
        bundle.putBoolean("result", bool.booleanValue());
        return bundle;
    }

    /* renamed from: C */
    public final boolean m66520C(String[] strArr) {
        try {
            Result resultM78736f0 = this.f52127s.m78736f0(strArr, false);
            if (resultM78736f0.getFailList().isEmpty()) {
                return true;
            }
            Iterator<Result.ErrMsg> it = resultM78736f0.getFailList().iterator();
            while (it.hasNext()) {
                int errCode = it.next().getErrCode();
                if (errCode != 102 && errCode != 401) {
                    return false;
                }
            }
            return true;
        } catch (C9721b unused) {
            return false;
        }
    }

    @Override // md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f52124p = (String) c10800nM68549a.m65739d("deviceId");
        this.f52125q = ((Integer) c10800nM68549a.m65739d(JsbMapKeyNames.H5_DEVICE_TYPE)).intValue();
        this.f52126r = (String) c10800nM68549a.m65739d("moduleName");
        this.f52128t = (ArrayList) c10800nM68549a.m65739d("fileIdList");
        this.f52127s = new C13049a(EnumC12999a.CLOUD_MORE, null);
    }

    /* renamed from: y */
    public final boolean m66522y() {
        DriveExpand driveExpandM64282d = C10463a.m64279e().m64282d();
        Iterator<String> it = this.f52128t.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            try {
                Drive.Files.Delete delete = driveExpandM64282d.files().delete(it.next());
                C4609l headers = delete.getHeaders();
                headers.set("x-hw-open-app-id", C13142a.f59637b);
                delete.setHeaders(headers);
                new SyncDriveRequest(delete).execute();
            } catch (C9721b e10) {
                C11839m.m70687e("DeleteBaseTask", "deleteNotePadByDrive error: " + e10.getMessage());
                z10 = false;
            } catch (IOException e11) {
                C11839m.m70687e("DeleteBaseTask", "deleteNotePadByDrive io error: " + e11.getMessage());
                z10 = false;
            }
        }
        return z10;
    }

    /* renamed from: z */
    public final boolean m66523z() {
        String string;
        String str;
        if (C10028c.m62182c0().m62420y1()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("/Hicloud");
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(this.f52124p);
            sb2.append("/sysdata");
            sb2.append(str2);
            sb2.append("notepad");
            sb2.append(SnapshotDBManager.SUFFIX_DATABASE_NAME);
            string = sb2.toString();
            str = "/Hicloud" + str2 + this.f52124p + "/sysdata" + str2 + "notepadRes.zip";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("/NoteBackup");
            String str3 = File.separator;
            sb3.append(str3);
            sb3.append(this.f52124p);
            sb3.append(str3);
            sb3.append("notepad");
            sb3.append(SnapshotDBManager.SUFFIX_DATABASE_NAME);
            string = sb3.toString();
            str = "/NoteBackup" + str3 + this.f52124p + str3 + "notepadRes.zip";
        }
        return m66520C(new String[]{string, str});
    }
}
