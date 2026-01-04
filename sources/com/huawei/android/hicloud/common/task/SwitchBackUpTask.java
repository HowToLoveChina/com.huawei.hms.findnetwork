package com.huawei.android.hicloud.common.task;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupConditionsUtil;
import com.huawei.android.hicloud.common.task.SwitchBackUpTask;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import gp.C10028c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import p010a9.C0080b;
import p015ak.C0227m;
import p020ap.C1006a;
import p020ap.C1008c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p618rm.C12597u1;
import p709vj.C13452e;
import tl.C13026e;

/* loaded from: classes3.dex */
public class SwitchBackUpTask extends AbstractC12367d {

    /* renamed from: a */
    public final CallBack f12014a;

    /* renamed from: b */
    public final Context f12015b;

    /* renamed from: c */
    public final String f12016c;

    public interface CallBack {
        /* renamed from: a */
        void mo15731a(String str);

        /* renamed from: b */
        void mo15732b(String str);

        void onError(String str);
    }

    public SwitchBackUpTask(Context context, String str, CallBack callBack) {
        this.f12014a = callBack;
        this.f12016c = str;
        this.f12015b = context;
    }

    /* renamed from: e */
    public static /* synthetic */ void m15810e(Map map, C10028c c10028c, List list, List list2, SyncConfigService syncConfigService) {
        int iM62286W;
        if (map.containsKey(syncConfigService.getId())) {
            return;
        }
        int i10 = (c10028c.m62388s(syncConfigService.getId()) || syncConfigService.getSwitchStatus()) ? 1 : 0;
        C0080b.b bVar = new C0080b.b();
        bVar.setType(syncConfigService.getId());
        bVar.setStatus(i10);
        if (list.contains(syncConfigService.getId()) && 2 != (iM62286W = c10028c.m62286W(syncConfigService.getId()))) {
            bVar.setMemberStatus(Integer.valueOf(iM62286W));
        }
        list2.add(bVar);
    }

    /* renamed from: f */
    public static /* synthetic */ void m15811f(List list, BackupOptionItem backupOptionItem) {
        C0080b.b bVar = new C0080b.b();
        bVar.setBundleName(backupOptionItem.getPackageName());
        bVar.setStatus(backupOptionItem.getBackupSwitch() ? 1 : 0);
        list.add(bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        StringBuilder sb2;
        File file;
        C11839m.m70688i("SwitchBackUpTask", "SwitchBackUpTask begin");
        boolean zM80842P0 = C13452e.m80781L().m80842P0();
        String strM1593f = C0227m.m1593f(C13452e.m80781L().m80971t0());
        if (!zM80842P0 || TextUtils.isEmpty(strM1593f)) {
            CallBack callBack = this.f12014a;
            if (callBack != null) {
                callBack.onError("not login or uid is null");
                return;
            }
            return;
        }
        C0080b c0080b = new C0080b();
        c0080b.setUidSha256(strM1593f);
        c0080b.setFrameworkType("0");
        final List<String> listM6037B = C1008c.m6035v().m6037B(this.f12015b);
        final Map<String, Pair<Integer, Integer>> mapM76027c = C12597u1.m76027c();
        boolean zM80887a1 = C13452e.m80781L().m80887a1();
        final C10028c c10028cM62183d0 = C10028c.m62183d0(this.f12015b);
        final ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, Pair<Integer, Integer>>> it = mapM76027c.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            int iM5975v = HNConstants.DataType.MEDIA.equals(key) ? C1006a.m5936k().m5975v(this.f12015b) : c10028cM62183d0.m62388s(key);
            C0080b.b bVar = new C0080b.b();
            bVar.setType(key);
            bVar.setStatus(iM5975v);
            if (listM6037B.contains(key)) {
                int iM62286W = c10028cM62183d0.m62286W(key);
                if (2 != iM62286W) {
                    bVar.setMemberStatus(Integer.valueOf(iM62286W));
                }
            } else if (HNConstants.DataType.MEDIA.equals(key)) {
                int iM5964j = C1006a.m5936k().m5964j(this.f12015b);
                C11839m.m70688i("SwitchBackUpTask", "SwitchBackUpTask albumMemberStatus is " + iM5964j);
                bVar.setMemberStatus(Integer.valueOf(iM5964j));
            }
            arrayList.add(bVar);
        }
        NotifyUtil.getShownSyncServiceItems(this.f12015b).forEach(new Consumer() { // from class: i9.f
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SwitchBackUpTask.m15810e(mapM76027c, c10028cM62183d0, listM6037B, arrayList, (SyncConfigService) obj);
            }
        });
        c0080b.setSyncSwitch(arrayList);
        C0080b.a aVar = new C0080b.a();
        aVar.setBackupFrequency(CloudBackupConditionsUtil.getUserBackUpFrequency());
        boolean zM62388s = c10028cM62183d0.m62388s("backup_key");
        if (zM80887a1) {
            aVar.setBaseStatusNew(Integer.valueOf(c10028cM62183d0.m62303a1() ? 1 : 0));
            aVar.setStatusNew(Integer.valueOf(zM62388s ? 1 : 0));
            aVar.setBaseStatus(c10028cM62183d0.m62330g1(C13452e.m80781L().m80790C()) ? 1 : 0);
        }
        aVar.setStatus(zM62388s ? 1 : 0);
        final ArrayList arrayList2 = new ArrayList();
        new C13026e().m78397u().stream().forEach(new Consumer() { // from class: i9.g
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SwitchBackUpTask.m15811f(arrayList2, (BackupOptionItem) obj);
            }
        });
        aVar.setAppSwitch(arrayList2);
        c0080b.setBackupSwitch(aVar);
        Gson gson = new Gson();
        CallBack callBack2 = this.f12014a;
        if (callBack2 != null) {
            callBack2.mo15732b(gson.toJson(c0080b));
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                file = new File(this.f12016c);
                if (file.exists()) {
                    file.delete();
                }
            } catch (FileNotFoundException e10) {
                e = e10;
            } catch (IOException e11) {
                e = e11;
            }
            if (!file.createNewFile()) {
                C11839m.m70688i("SwitchBackUpTask", "SwitchBackUpTask create fail");
                return;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(gson.toJson(c0080b).getBytes(StandardCharsets.UTF_8));
                fileOutputStream2.flush();
                fileOutputStream2.close();
                C11839m.m70688i("SwitchBackUpTask", "SwitchBackUpTask file ---" + file.length());
                CallBack callBack3 = this.f12014a;
                if (callBack3 != null) {
                    callBack3.mo15731a(file.getAbsolutePath());
                }
                C11839m.m70688i("SwitchBackUpTask", "SwitchBackUpTask finish");
            } catch (FileNotFoundException e12) {
                e = e12;
                fileOutputStream = fileOutputStream2;
                C11839m.m70689w("SwitchBackUpTask", "SwitchBackUpTask FileNotFoundException");
                CallBack callBack4 = this.f12014a;
                if (callBack4 != null) {
                    callBack4.onError(e.getMessage());
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e13) {
                        e = e13;
                        sb2 = new StringBuilder();
                        sb2.append("fileOutputStream.close() err: ");
                        sb2.append(e.getMessage());
                        C11839m.m70689w("SwitchBackUpTask", sb2.toString());
                        C11839m.m70688i("SwitchBackUpTask", "SwitchBackUpTask end");
                    }
                }
                C11839m.m70688i("SwitchBackUpTask", "SwitchBackUpTask end");
            } catch (IOException e14) {
                e = e14;
                fileOutputStream = fileOutputStream2;
                C11839m.m70689w("SwitchBackUpTask", "SwitchBackUpTask IOException " + e.getMessage());
                CallBack callBack5 = this.f12014a;
                if (callBack5 != null) {
                    callBack5.onError(e.getMessage());
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e15) {
                        e = e15;
                        sb2 = new StringBuilder();
                        sb2.append("fileOutputStream.close() err: ");
                        sb2.append(e.getMessage());
                        C11839m.m70689w("SwitchBackUpTask", sb2.toString());
                        C11839m.m70688i("SwitchBackUpTask", "SwitchBackUpTask end");
                    }
                }
                C11839m.m70688i("SwitchBackUpTask", "SwitchBackUpTask end");
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e16) {
                        C11839m.m70689w("SwitchBackUpTask", "fileOutputStream.close() err: " + e16.getMessage());
                    }
                }
                throw th;
            }
            try {
                fileOutputStream2.close();
            } catch (IOException e17) {
                e = e17;
                sb2 = new StringBuilder();
                sb2.append("fileOutputStream.close() err: ");
                sb2.append(e.getMessage());
                C11839m.m70689w("SwitchBackUpTask", sb2.toString());
                C11839m.m70688i("SwitchBackUpTask", "SwitchBackUpTask end");
            }
            C11839m.m70688i("SwitchBackUpTask", "SwitchBackUpTask end");
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
