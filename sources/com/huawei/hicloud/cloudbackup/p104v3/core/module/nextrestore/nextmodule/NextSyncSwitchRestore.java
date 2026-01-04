package com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.MigrateSyncSwitchData;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncSwitchStatus;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncSwitchStatusSingleFrame;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9721b;
import hk.C10278a;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import p015ak.C0209d;
import p514o9.C11839m;
import p815ym.AbstractC14026a;
import pl.C12161c;
import pl.C12164f;

/* loaded from: classes6.dex */
public class NextSyncSwitchRestore extends NextModuleRestore {
    private static final Map<String, String> BUNDLE_NAME_SYNCTYPE_MAPPING;
    private static final String TAG = "NextSyncSwitchRestore";

    static {
        HashMap map = new HashMap();
        BUNDLE_NAME_SYNCTYPE_MAPPING = map;
        map.put("com.huawei.hmos.hinote", NotifyUtil.HI_NOTE_SYNC_TYPE);
        map.put("com.huawei.hmos.notepad", "notepad");
        map.put("com.huawei.hmos.calendar", "calendar");
        map.put("com.ohos.contacts", "addressbook");
        map.put("com.huawei.hmos.browser", "browser");
        map.put("com.huawei.hmos.photos", HNConstants.DataType.MEDIA);
    }

    public NextSyncSwitchRestore(Context context, C4880b c4880b, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        super(context, c4880b, cloudRestoreStatusV3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$restoreSyncSwitchStatus$0(List list, SyncSwitchStatusSingleFrame syncSwitchStatusSingleFrame) {
        String str = BUNDLE_NAME_SYNCTYPE_MAPPING.get(syncSwitchStatusSingleFrame.getBundleName());
        if (str != null) {
            list.add(new SyncSwitchStatus(str, syncSwitchStatusSingleFrame.getStatus()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.io.Closeable, java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    private int restoreSyncSwitchStatus(String str) throws Throwable {
        FileInputStream fileInputStream;
        Closeable closeable;
        Closeable closeable2;
        BufferedReader bufferedReader;
        final ArrayList arrayList;
        List<SyncSwitchStatusSingleFrame> syncSwitch;
        C11839m.m70689w(TAG, "restoreSyncSwitchStatus start");
        ?? M63442h = C10278a.m63442h(str);
        int iRestoreSyncSwitchData = -1;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                fileInputStream = new FileInputStream((File) M63442h);
                try {
                    M63442h = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                    try {
                        bufferedReader = new BufferedReader(M63442h);
                        try {
                            String line = bufferedReader.readLine();
                            C11839m.m70688i(TAG, "get sync switch status: " + line);
                            MigrateSyncSwitchData migrateSyncSwitchData = (MigrateSyncSwitchData) new Gson().fromJson(line, new TypeToken<MigrateSyncSwitchData>() { // from class: com.huawei.hicloud.cloudbackup.v3.core.module.nextrestore.nextmodule.NextSyncSwitchRestore.1
                            }.getType());
                            arrayList = new ArrayList();
                            syncSwitch = migrateSyncSwitchData.getSyncSwitch();
                        } catch (FileNotFoundException e10) {
                            e = e10;
                            bufferedReader2 = bufferedReader;
                            C11839m.m70687e(TAG, "get sync switch status FileNotFoundException: " + e.toString());
                            closeable = M63442h;
                            C0209d.m1263i(bufferedReader2);
                            closeable2 = closeable;
                            C0209d.m1263i(closeable2);
                            C0209d.m1263i(fileInputStream);
                            C11839m.m70689w(TAG, "restoreSyncSwitchStatus end,restoreResult:" + iRestoreSyncSwitchData);
                            return iRestoreSyncSwitchData;
                        } catch (IOException e11) {
                            e = e11;
                            bufferedReader2 = bufferedReader;
                            C11839m.m70687e(TAG, "get sync switch status IOException: " + e.toString());
                            closeable = M63442h;
                            C0209d.m1263i(bufferedReader2);
                            closeable2 = closeable;
                            C0209d.m1263i(closeable2);
                            C0209d.m1263i(fileInputStream);
                            C11839m.m70689w(TAG, "restoreSyncSwitchStatus end,restoreResult:" + iRestoreSyncSwitchData);
                            return iRestoreSyncSwitchData;
                        } catch (Exception e12) {
                            e = e12;
                            bufferedReader2 = bufferedReader;
                            C11839m.m70687e(TAG, "get sync switch status Exception: " + e.getMessage());
                            closeable = M63442h;
                            C0209d.m1263i(bufferedReader2);
                            closeable2 = closeable;
                            C0209d.m1263i(closeable2);
                            C0209d.m1263i(fileInputStream);
                            C11839m.m70689w(TAG, "restoreSyncSwitchStatus end,restoreResult:" + iRestoreSyncSwitchData);
                            return iRestoreSyncSwitchData;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            C0209d.m1263i(bufferedReader2);
                            C0209d.m1263i(M63442h);
                            C0209d.m1263i(fileInputStream);
                            throw th;
                        }
                    } catch (FileNotFoundException e13) {
                        e = e13;
                    } catch (IOException e14) {
                        e = e14;
                    } catch (Exception e15) {
                        e = e15;
                    }
                } catch (FileNotFoundException e16) {
                    e = e16;
                    M63442h = 0;
                } catch (IOException e17) {
                    e = e17;
                    M63442h = 0;
                } catch (Exception e18) {
                    e = e18;
                    M63442h = 0;
                } catch (Throwable th3) {
                    th = th3;
                    M63442h = 0;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
                M63442h = 0;
                fileInputStream = null;
            } catch (IOException e20) {
                e = e20;
                M63442h = 0;
                fileInputStream = null;
            } catch (Exception e21) {
                e = e21;
                M63442h = 0;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                M63442h = 0;
                fileInputStream = null;
            }
            if (AbstractC14026a.m84159a(syncSwitch)) {
                C11839m.m70687e(TAG, "switchStatus list is empty.");
                C0209d.m1263i(bufferedReader);
                C0209d.m1263i(M63442h);
                C0209d.m1263i(fileInputStream);
                return -1;
            }
            syncSwitch.forEach(new Consumer() { // from class: com.huawei.hicloud.cloudbackup.v3.core.module.nextrestore.nextmodule.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    NextSyncSwitchRestore.lambda$restoreSyncSwitchStatus$0(arrayList, (SyncSwitchStatusSingleFrame) obj);
                }
            });
            iRestoreSyncSwitchData = RestoreUtil.restoreSyncSwitchData(this.mRestoreStatus, arrayList);
            C0209d.m1263i(bufferedReader);
            closeable2 = M63442h;
            C0209d.m1263i(closeable2);
            C0209d.m1263i(fileInputStream);
            C11839m.m70689w(TAG, "restoreSyncSwitchStatus end,restoreResult:" + iRestoreSyncSwitchData);
            return iRestoreSyncSwitchData;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public String getApkModuleName() {
        return "virtual.hmos.sync.switch.status";
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public String getBackupProviderUri() {
        return "";
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public int onRestore(C12164f c12164f) throws C9721b {
        C11839m.m70688i(TAG, "onRestore begin");
        if (this.mContext == null || this.mRestoreStatus == null || this.mTask == null || c12164f == null) {
            C11839m.m70687e(TAG, "params error");
            return -1;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mTask.getLocation());
        String str = File.separator;
        sb2.append(str);
        sb2.append(getAppId());
        sb2.append("/nextdata");
        if (!C10278a.m63442h(sb2.toString()).exists()) {
            C11839m.m70688i(TAG, "no nextdata, success.");
            return 0;
        }
        this.mRestoreStatus.getUid();
        if (TextUtils.isEmpty(this.mTask.getLocation())) {
            C11839m.m70687e(TAG, "pmsRestore mLocation is empty");
            return -1;
        }
        List<C12161c> listM73068a0 = c12164f.m73068a0(6);
        if (AbstractC14026a.m84159a(listM73068a0)) {
            C11839m.m70687e(TAG, "restore sync switches error,snapshot is empty.");
            return -1;
        }
        return restoreSyncSwitchStatus(getSrcPath() + str + "nextdata" + str + listM73068a0.get(0).m73011z());
    }
}
