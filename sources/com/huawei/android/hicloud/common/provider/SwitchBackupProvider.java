package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.common.task.SwitchBackUpTask;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p362i9.C10462i;
import p514o9.C11839m;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class SwitchBackupProvider extends ContentProvider {

    /* renamed from: b */
    public static final UriMatcher f11979b;

    /* renamed from: a */
    public boolean f11980a = true;

    /* renamed from: com.huawei.android.hicloud.common.provider.SwitchBackupProvider$a */
    public class C2758a implements SwitchBackUpTask.CallBack {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f11981a;

        /* renamed from: b */
        public final /* synthetic */ CountDownLatch f11982b;

        public C2758a(ArrayList arrayList, CountDownLatch countDownLatch) {
            this.f11981a = arrayList;
            this.f11982b = countDownLatch;
        }

        @Override // com.huawei.android.hicloud.common.task.SwitchBackUpTask.CallBack
        /* renamed from: a */
        public void mo15731a(String str) {
            C11839m.m70688i("SwitchBackupProvider", "handleBackupQuery switchBackUpTask onFinish ");
            this.f11981a.add("content://com.huawei.hicloud.provider.BackupProvider/switch_file");
            this.f11982b.countDown();
        }

        @Override // com.huawei.android.hicloud.common.task.SwitchBackUpTask.CallBack
        /* renamed from: b */
        public void mo15732b(String str) {
        }

        @Override // com.huawei.android.hicloud.common.task.SwitchBackUpTask.CallBack
        public void onError(String str) {
            C11839m.m70689w("SwitchBackupProvider", "handleBackupQuery switchBackUpTask onError" + str);
            this.f11982b.countDown();
        }
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11979b = uriMatcher;
        uriMatcher.addURI("com.huawei.hicloud.provider.BackupProvider", "switch_file", 3);
    }

    /* renamed from: a */
    public final Bundle m15726a(Bundle bundle) {
        return null;
    }

    /* renamed from: b */
    public final Bundle m15727b(String str, Bundle bundle) throws InterruptedException {
        C11839m.m70688i("SwitchBackupProvider", "handleBackupQuery begin");
        if (!TextUtils.equals(str, CloudBackupConstant.Command.PMS_CMD_BACKUP)) {
            if (!TextUtils.equals(str, "restore")) {
                return null;
            }
            C11839m.m70688i("SwitchBackupProvider", "handleBackupQuery new phone");
            return new Bundle();
        }
        C11839m.m70688i("SwitchBackupProvider", "handleBackupQuery old phone");
        ArrayList<String> arrayList = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C12515a.m75110o().m75175e(new SwitchBackUpTask(getContext(), "data/data/com.huawei.hidisk/files/switch.json", new C2758a(arrayList, countDownLatch)), true);
        try {
            countDownLatch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            C11839m.m70687e("SwitchBackupProvider", "create switch.json fail");
        }
        if (arrayList.isEmpty()) {
            C11839m.m70688i("SwitchBackupProvider", "copyPathList.isEmpty");
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("openfile_uri_list", arrayList);
        C11839m.m70688i("SwitchBackupProvider", "handleBackupQuery end");
        return bundle2;
    }

    /* renamed from: c */
    public final Bundle m15728c(Bundle bundle) {
        C11839m.m70688i("SwitchBackupProvider", "handleBackupRecoverComplete begin");
        C12515a.m75110o().m75175e(new C10462i(getContext(), null, "data/data/com.huawei.hidisk/files/switch.json"), false);
        return null;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, String str3, Bundle bundle) {
        if (!"com.huawei.hicloud.provider.BackupProvider".equals(str)) {
            C11839m.m70688i("SwitchBackupProvider", "authority error " + str);
            return null;
        }
        if ("backup_start".equals(str2)) {
            return m15730e(str3, bundle);
        }
        if ("backup_query".equals(str2)) {
            return m15727b(str3, bundle);
        }
        if (NotifyConstants.BACKUP_COMPLETE.equals(str2)) {
            return m15726a(bundle);
        }
        if ("backup_recover_start".equals(str2)) {
            return m15729d(bundle);
        }
        if ("backup_recover_complete".equals(str2)) {
            return m15728c(bundle);
        }
        C11839m.m70689w("SwitchBackupProvider", "unkonw method " + str2);
        return null;
    }

    /* renamed from: d */
    public final Bundle m15729d(Bundle bundle) {
        C11839m.m70688i("SwitchBackupProvider", "handleBackupRecoverStart begin");
        Bundle bundle2 = new Bundle();
        if (bundle == null) {
            bundle2.putBoolean("permit", false);
            C11839m.m70688i("SwitchBackupProvider", "handleBackupRecoverStart extras is null");
            return bundle2;
        }
        bundle2.putBoolean("permit", this.f11980a);
        Iterator<String> it = bundle.getStringArrayList("openfile_uri_list").iterator();
        while (it.hasNext()) {
            C11839m.m70688i("SwitchBackupProvider", "restoreBundle openUri " + it.next());
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("content://com.huawei.hicloud.provider.BackupProvider/switch_file");
        bundle2.putStringArrayList("openfile_uri_list", arrayList);
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: e */
    public final Bundle m15730e(String str, Bundle bundle) {
        Bundle bundle2;
        C11839m.m70688i("SwitchBackupProvider", "handleBackStart begin");
        if (!TextUtils.equals(str, CloudBackupConstant.Command.PMS_CMD_BACKUP)) {
            if (!TextUtils.equals(str, "restore")) {
                return null;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString("versionName", "16.0.0.300");
            bundle3.putString("versionCode", "160000300");
            bundle3.putString("frameworkType", "0");
            bundle3.putInt("dataVersion", 1);
            Bundle bundle4 = new Bundle();
            bundle4.putBundle("ability_info", bundle3);
            return bundle4;
        }
        if (bundle == null || (bundle2 = bundle.getBundle("new_phone_ability_info")) != null) {
            return null;
        }
        String string = bundle2.getString("frameworkType", "-1");
        int i10 = bundle2.getInt("dataVersion", 0);
        if (TextUtils.equals(string, "0") && 1 > i10) {
            C11839m.m70688i("SwitchBackupProvider", "handleBackStart bold CUR_DATA_VERSION 1> dataVersion" + i10);
            this.f11980a = false;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        C11839m.m70688i("SwitchBackupProvider", "insert: match: " + f11979b.match(uri));
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007e -> B:27:0x0096). Please report as a decompilation issue!!! */
    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        C11839m.m70688i("SwitchBackupProvider", "openFile mode " + str);
        ParcelFileDescriptor parcelFileDescriptorOpen = null;
        if (f11979b.match(uri) != 3) {
            return null;
        }
        char c10 = "r".equals(str) ? (char) 0 : (char) 0;
        if (c10 == 0) {
            File file = new File("data/data/com.huawei.hidisk/files/switch.json");
            boolean zExists = file.exists();
            C11839m.m70688i("SwitchBackupProvider", "openFile create file " + zExists);
            if (zExists) {
                return ParcelFileDescriptor.open(file, 805306368);
            }
            return null;
        }
        if (c10 != 0) {
            return null;
        }
        File file2 = new File("data/data/com.huawei.hidisk/files/switch.json");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            if (file2.createNewFile()) {
                parcelFileDescriptorOpen = ParcelFileDescriptor.open(file2, 805306368);
            } else {
                C11839m.m70688i("SwitchBackupProvider", "openFile create file fail");
            }
        } catch (IOException e10) {
            C11839m.m70688i("SwitchBackupProvider", "openFile IOException " + e10.getMessage());
        }
        return parcelFileDescriptorOpen;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        C11839m.m70688i("SwitchBackupProvider", "query: match: " + f11979b.match(uri));
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
