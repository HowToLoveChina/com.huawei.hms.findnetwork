package fm;

import am.InterfaceC0275i1;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextCommonModuleRestore;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextFileManagerRestore;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextGalleryDataRestore;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextMemoRestore;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextSoundRecorderRestore;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextSyncSwitchRestore;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import java.util.HashMap;
import java.util.Map;
import p514o9.C11839m;
import sl.C12816g;

/* renamed from: fm.b */
/* loaded from: classes6.dex */
public class C9727b {

    /* renamed from: b */
    public static final Map<String, Class> f47962b = new a();

    /* renamed from: a */
    public long f47963a = 0;

    /* renamed from: fm.b$a */
    public class a extends HashMap<String, Class> {
        public a() {
            put("com.huawei.hmos.filemanager", NextFileManagerRestore.class);
            put("com.huawei.hmos.notepad", NextMemoRestore.class);
            put(NextRestoreConstants.BUNDLE_NAME_GALLERY, NextGalleryDataRestore.class);
            put("com.huawei.hmos.soundrecorder", NextSoundRecorderRestore.class);
            put("virtual.hmos.sync.switch.status", NextSyncSwitchRestore.class);
        }
    }

    /* renamed from: b */
    public NextModuleRestore m60678b(Context context, C4880b c4880b, final CloudRestoreStatusV3 cloudRestoreStatusV3) {
        if (cloudRestoreStatusV3 == null || TextUtils.isEmpty(cloudRestoreStatusV3.getAppId())) {
            C11839m.m70689w("CloudRestoreNextModuleFactory", "appId is null");
            return null;
        }
        try {
            Class cls = f47962b.get(cloudRestoreStatusV3.getAppId());
            NextModuleRestore nextCommonModuleRestore = cls == null ? new NextCommonModuleRestore(context, c4880b, cloudRestoreStatusV3) : (NextModuleRestore) cls.getConstructor(Context.class, C4880b.class, CloudRestoreStatusV3.class).newInstance(context, c4880b, cloudRestoreStatusV3);
            nextCommonModuleRestore.registerPmsRestoreStatus(new InterfaceC0275i1() { // from class: fm.a
                @Override // am.InterfaceC0275i1
                /* renamed from: a */
                public final void mo1767a(long j10) {
                    this.f47960a.m60679c(cloudRestoreStatusV3, j10);
                }
            });
            return nextCommonModuleRestore;
        } catch (NoSuchMethodException unused) {
            C11839m.m70689w("CloudRestoreNextModuleFactory", "getRestoreModule NoSuchMethodException");
            return null;
        } catch (SecurityException unused2) {
            C11839m.m70689w("CloudRestoreNextModuleFactory", "getRestoreModule SecurityException");
            return null;
        } catch (Exception unused3) {
            C11839m.m70689w("CloudRestoreNextModuleFactory", "getRestoreModule other Exception");
            return null;
        }
    }

    /* renamed from: c */
    public final /* synthetic */ void m60679c(CloudRestoreStatusV3 cloudRestoreStatusV3, long j10) {
        long jMin = Math.min(j10, cloudRestoreStatusV3.getSize());
        long j11 = jMin - this.f47963a;
        this.f47963a = jMin;
        cloudRestoreStatusV3.addPmsAlreadyBytes(j11 > 0 ? j11 : 0L);
        RestoreProgress.updateStatus(cloudRestoreStatusV3);
        C11839m.m70688i("CloudRestoreNextModuleFactory", "pms copy completed size is: " + jMin + " ,increase: " + j11);
    }

    /* renamed from: d */
    public void m60680d(int i10, CloudRestoreStatusV3 cloudRestoreStatusV3, C12816g c12816g) {
        if (cloudRestoreStatusV3 == null || c12816g == null) {
            C11839m.m70687e("CloudRestoreNextModuleFactory", "updatePmsRestoreStatus params error");
            return;
        }
        if (i10 == -3 || i10 == -7) {
            cloudRestoreStatusV3.setStatus(i10);
        } else {
            cloudRestoreStatusV3.setStatus(7).setType(i10 == 0 ? 1 : 2);
        }
        c12816g.m76957u(cloudRestoreStatusV3);
    }
}
