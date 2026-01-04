package p426kd;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.drive.clouddisk.expand.DriveExpand;
import com.huawei.android.hicloud.drive.clouddisk.expand.SyncDriveRequest;
import com.huawei.android.hicloud.drive.clouddisk.model.FileExpand;
import com.huawei.android.sync.R$string;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.cloud.services.drive.model.File;
import com.huawei.cloud.services.drive.model.FileList;
import com.huawei.hicloud.base.bean.DownloadItem;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hicloud.request.opengw.bean.LsRequest;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import fk.C9721b;
import gp.C10028c;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ke.C11046a;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0227m;
import p363ia.C10463a;
import p399jk.AbstractC10896a;
import p458lo.C11322a;
import p514o9.C11829c;
import p514o9.C11839m;
import p516ob.C11845a;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import to.C13049a;
import ua.C13142a;

/* renamed from: kd.k */
/* loaded from: classes3.dex */
public class AsyncTaskC11037k extends AsyncTask<Void, Void, List<ModuleItem>> {

    /* renamed from: d */
    public static AsyncTaskC11037k f52154d;

    /* renamed from: e */
    public static final String[] f52155e = new String[0];

    /* renamed from: a */
    public String f52156a;

    /* renamed from: b */
    public Context f52157b;

    /* renamed from: c */
    public Messenger f52158c;

    /* renamed from: kd.k$a */
    public static class a {

        /* renamed from: a */
        public long f52159a;

        /* renamed from: b */
        public long f52160b;

        /* renamed from: c */
        public int f52161c;

        /* renamed from: d */
        public long f52162d;

        /* renamed from: e */
        public String f52163e;

        /* renamed from: f */
        public ArrayList<DownloadItem> f52164f;
    }

    public AsyncTaskC11037k(Context context, Messenger messenger) {
        this.f52157b = context;
        this.f52158c = messenger;
    }

    /* renamed from: f */
    public static AsyncTaskC11037k m66546f(Context context, Messenger messenger) {
        if (f52154d == null || AsyncTask.Status.FINISHED.equals(f52154d.getStatus())) {
            f52154d = new AsyncTaskC11037k(context, messenger);
        } else {
            AsyncTaskC11037k asyncTaskC11037k = f52154d;
            if (messenger != asyncTaskC11037k.f52158c) {
                asyncTaskC11037k.f52158c = messenger;
            }
        }
        return f52154d;
    }

    /* renamed from: a */
    public final void m66547a(List<ModuleItem> list, List<ModuleItem> list2, List<ModuleItem> list3, String str, ModuleItem moduleItem) {
        if (str != null && str.equals(moduleItem.getDeviceID())) {
            moduleItem.setCurrent(true);
            moduleItem.setDisplayName(this.f52157b.getResources().getString(R$string.cloudbackup_self_device_new_update, moduleItem.getName()));
            list.add(moduleItem);
        } else {
            if (moduleItem.getDeviceID() != null && !moduleItem.getDeviceID().isEmpty()) {
                list2.add(moduleItem);
                return;
            }
            Resources resources = this.f52157b.getResources();
            int i10 = R$string.setting_other;
            moduleItem.setDisplayName(resources.getString(i10));
            moduleItem.setName(this.f52157b.getResources().getString(i10));
            list3.add(moduleItem);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0093  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m66548b(java.util.Map<java.lang.String, p426kd.AsyncTaskC11037k.a> r6, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r7) {
        /*
            r5 = this;
            java.util.Iterator r5 = r7.iterator()
        L4:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L9e
            java.lang.Object r7 = r5.next()
            java.util.Map r7 = (java.util.Map) r7
            java.lang.String r0 = "name"
            java.lang.Object r0 = r7.get(r0)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "/"
            java.lang.String[] r0 = r0.split(r1)
            gp.c r1 = gp.C10028c.m62182c0()
            boolean r1 = r1.m62420y1()
            r2 = 4
            java.lang.String r3 = "GetNotePadTask"
            if (r1 == 0) goto L37
            int r1 = r0.length
            r4 = 5
            if (r1 == r4) goto L40
            java.lang.String r7 = "arrays length !=5"
            p514o9.C11839m.m70689w(r3, r7)
            goto L4
        L37:
            int r1 = r0.length
            if (r1 == r2) goto L40
            java.lang.String r7 = "arrays length !=4"
            p514o9.C11839m.m70689w(r3, r7)
            goto L4
        L40:
            java.lang.String r1 = "size"
            java.lang.Object r1 = r7.get(r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "itemcount"
            java.lang.Object r7 = r7.get(r3)
            if (r7 == 0) goto L57
            java.lang.String r7 = r7.toString()
            goto L59
        L57:
            java.lang.String r7 = ""
        L59:
            r3 = 2
            r3 = r0[r3]
            gp.c r4 = gp.C10028c.m62182c0()
            boolean r4 = r4.m62420y1()
            if (r4 == 0) goto L69
            r0 = r0[r2]
            goto L6c
        L69:
            r2 = 3
            r0 = r0[r2]
        L6c:
            java.lang.Object r2 = r6.get(r3)
            if (r2 != 0) goto L78
            kd.k$a r2 = new kd.k$a
            r2.<init>()
            goto L7e
        L78:
            java.lang.Object r2 = r6.get(r3)
            kd.k$a r2 = (p426kd.AsyncTaskC11037k.a) r2
        L7e:
            java.lang.String r4 = ".db"
            boolean r0 = r0.endsWith(r4)
            if (r0 == 0) goto L93
            long r0 = p015ak.C0241z.m1688f(r1)
            r2.f52159a = r0
            int r7 = p015ak.C0241z.m1685c(r7)
            r2.f52161c = r7
            goto L99
        L93:
            long r0 = p015ak.C0241z.m1688f(r1)
            r2.f52160b = r0
        L99:
            r6.put(r3, r2)
            goto L4
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p426kd.AsyncTaskC11037k.m66548b(java.util.Map, java.util.List):void");
    }

    @Override // android.os.AsyncTask
    /* renamed from: c */
    public List<ModuleItem> doInBackground(Void... voidArr) {
        C11839m.m70688i("GetNotePadTask", "getNotePadTask start");
        try {
            HashMap<String, a> map = new HashMap<>();
            try {
                DriveExpand driveExpandM64282d = C10463a.m64279e().m64282d();
                if (driveExpandM64282d != null) {
                    DriveExpand.FilesExpand.GenerateIds generateIds = driveExpandM64282d.filesExpand().generateIds();
                    String str = C13142a.f59637b;
                    generateIds.set("seed", (Object) ("applicationData" + str));
                    C4609l headers = generateIds.getHeaders();
                    headers.set("x-hw-open-app-id", str);
                    generateIds.setHeaders(headers);
                    List<String> ids = ((FileExpand) new SyncDriveRequest(generateIds).execute()).getIds();
                    for (int i10 = 0; i10 < ids.size(); i10++) {
                        List<File> listM66550d = m66550d(driveExpandM64282d, ids.get(i10));
                        for (int i11 = 0; i11 < listM66550d.size(); i11++) {
                            a aVar = new a();
                            File file = listM66550d.get(i11);
                            if (file != null) {
                                m66551e(file, aVar);
                                aVar.f52163e = file.getId();
                                map.put(file.getFileName(), aVar);
                            }
                        }
                    }
                    boolean z10 = false;
                    for (Map.Entry<String, a> entry : map.entrySet()) {
                        a value = entry.getValue();
                        m66552g(driveExpandM64282d, value, value.f52163e, entry.getKey(), 0);
                        ArrayList<DownloadItem> arrayList = value.f52164f;
                        z10 = (arrayList == null || arrayList.isEmpty()) ? false : true;
                        entry.setValue(value);
                    }
                    if (!z10) {
                        return new ArrayList();
                    }
                }
            } catch (Exception e10) {
                AbstractC10896a.m65887i("GetNotePadTask", "cloudFileList exception: " + e10.toString());
            }
            List<CBSDevice> listM68004K = new C11322a().m68004K();
            return !map.isEmpty() ? m66554i(listM68004K, map) : m66553h(listM68004K, "notepad");
        } catch (Exception e11) {
            C11839m.m70686d("GetNotePadTask", "cbs queryDevice exception：" + e11.toString());
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.huawei.cloud.services.drive.Drive$Files$List] */
    /* renamed from: d */
    public final List<File> m66550d(DriveExpand driveExpand, String str) throws C9721b, IOException {
        Drive.Files.List list = driveExpand.files().list();
        list.setContainers("applicationData");
        C4609l headers = list.getHeaders();
        headers.set("x-hw-open-app-id", C13142a.f59637b);
        list.setHeaders(headers);
        return ((FileList) new SyncDriveRequest(list.setCursor(null).setFields2("nextCursor,files/id,files/fileName,files/editedTime,files/recycledTime,files/parentFolder,files/mimeType,files/recycled,files/directlyRecycled,files/version,files/contentVersion,files/size,files/sha256,files/md5,files/properties,files/attributes,files/operatedByMe,files/isRiskFile").setQueryParam("'" + str + "' in parentFolder")).execute()).getFiles();
    }

    /* renamed from: e */
    public final void m66551e(File file, a aVar) {
        if (file.get("attributes") != null) {
            Object obj = file.get("attributes");
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.isEmpty()) {
                    C11839m.m70688i("GetNotePadTask", "getHistoryAttribute attributes is empty");
                    return;
                }
                Object obj2 = map.get("notepadSize");
                Object obj3 = map.get("notepadItemCount");
                if (obj2 instanceof BigDecimal) {
                    aVar.f52162d = ((BigDecimal) obj2).longValue();
                }
                if (obj3 instanceof BigDecimal) {
                    aVar.f52161c = ((BigDecimal) obj3).intValue();
                }
            }
        }
    }

    /* renamed from: g */
    public final a m66552g(DriveExpand driveExpand, a aVar, String str, String str2, int i10) throws C9721b, IOException {
        List<File> listM66550d = m66550d(driveExpand, str);
        ArrayList<DownloadItem> arrayList = new ArrayList<>();
        int i11 = i10 + 1;
        for (int i12 = 0; i12 < listM66550d.size(); i12++) {
            File file = listM66550d.get(i12);
            boolean zEquals = "application/vnd.huawei-apps.folder".equals(file.getMimeType());
            boolean z10 = C11829c.m70584i0(C0213f.m1377a()) || "sysdata".equals(str2);
            if (!z10 && zEquals && i11 <= 5) {
                return m66552g(driveExpand, aVar, file.getId(), file.getFileName(), i11);
            }
            if (z10) {
                DownloadItem downloadItem = new DownloadItem();
                downloadItem.setFileId(file.getId());
                downloadItem.setFileName(file.getFileName());
                downloadItem.setSavePath("/storage/emulated/0/huawei/HwCloud/sysdata/notepad/" + file.getFileName());
                downloadItem.setFileSize(file.getSize().longValue());
                arrayList.add(downloadItem);
            }
        }
        aVar.f52164f = arrayList;
        return aVar;
    }

    /* renamed from: h */
    public final List<ModuleItem> m66553h(List<CBSDevice> list, String str) throws C9721b {
        String str2;
        String str3;
        List<ModuleItem> arrayList = new ArrayList<>();
        List<ModuleItem> arrayList2 = new ArrayList<>();
        List<ModuleItem> arrayList3 = new ArrayList<>();
        String strM80950o = C13452e.m80781L().m80950o();
        C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, null);
        LsRequest lsRequest = new LsRequest();
        if (C10028c.m62182c0().m62420y1()) {
            lsRequest.setServerPath("/Hicloud");
        } else {
            lsRequest.setServerPath("/NoteBackup");
        }
        lsRequest.setFields(new String[]{"name"});
        lsRequest.setType(2);
        lsRequest.setRecursive(1);
        List<Map<String, Object>> listM78718T = c13049a.m78718T(lsRequest);
        ArrayList arrayList4 = new ArrayList();
        for (Map<String, Object> map : listM78718T) {
            if (C10028c.m62182c0().m62420y1()) {
                str2 = "/Hicloud/" + map.get("name") + "/sysdata/notepad.db";
                str3 = "/Hicloud/" + map.get("name") + "/sysdata/notepadRes.zip";
            } else {
                str2 = "/NoteBackup/" + map.get("name") + "/notepad.db";
                str3 = "/NoteBackup/" + map.get("name") + "/notepadRes.zip";
            }
            arrayList4.add(str2);
            arrayList4.add(str3);
        }
        if (arrayList4.size() == 0) {
            C11839m.m70688i("GetNotePadTask", "getServerDirList done. requestPaths.size = 0");
            return arrayList;
        }
        List<Map<String, Object>> successList = c13049a.m78709H((String[]) arrayList4.toArray(f52155e), new String[]{"name", "size", "itemcount"}).getSuccessList();
        if (successList == null) {
            C11839m.m70687e("GetNotePadTask", "successList is null");
            return arrayList;
        }
        Map<String, a> map2 = new HashMap<>();
        m66548b(map2, successList);
        for (Map.Entry<String, a> entry : map2.entrySet()) {
            if (entry.getValue().f52161c > 0) {
                String key = entry.getKey();
                ModuleItem moduleItem = new ModuleItem();
                moduleItem.setModuleName(this.f52156a);
                moduleItem.setDeviceIdMD5(key);
                moduleItem.setNum(entry.getValue().f52161c);
                moduleItem.setSpace(entry.getValue().f52159a + entry.getValue().f52160b);
                Iterator<CBSDevice> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CBSDevice next = it.next();
                    if (key.equals(C0227m.m1592e(next.getDeviceId()))) {
                        moduleItem.setDeviceID(next.getDeviceId());
                        String aliasName = next.getAliasName();
                        String devDisplayName = next.getDevDisplayName();
                        if (!TextUtils.isEmpty(devDisplayName)) {
                            aliasName = devDisplayName;
                        } else if (TextUtils.isEmpty(aliasName)) {
                            aliasName = next.getTerminalType();
                        }
                        moduleItem.setName(aliasName);
                        moduleItem.setDisplayName(aliasName);
                    }
                }
                m66547a(arrayList, arrayList2, arrayList3, strM80950o, moduleItem);
            }
        }
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    /* renamed from: i */
    public final List<ModuleItem> m66554i(List<CBSDevice> list, HashMap<String, a> map) throws C9721b {
        List<ModuleItem> arrayList = new ArrayList<>();
        List<ModuleItem> arrayList2 = new ArrayList<>();
        List<ModuleItem> arrayList3 = new ArrayList<>();
        String strM80950o = C13452e.m80781L().m80950o();
        for (Map.Entry<String, a> entry : map.entrySet()) {
            a value = entry.getValue();
            if (value.f52161c > 0) {
                String key = entry.getKey();
                ModuleItem moduleItem = new ModuleItem();
                moduleItem.setModuleName(this.f52156a);
                moduleItem.setDeviceIdMD5(key);
                moduleItem.setNum(value.f52161c);
                moduleItem.setSpace(value.f52162d);
                moduleItem.setDownloadItems(value.f52164f);
                Iterator<CBSDevice> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CBSDevice next = it.next();
                    if (key.equals(C0227m.m1592e(next.getDeviceId()))) {
                        moduleItem.setDeviceID(next.getDeviceId());
                        String aliasName = next.getAliasName();
                        String devDisplayName = next.getDevDisplayName();
                        if (!TextUtils.isEmpty(devDisplayName)) {
                            aliasName = devDisplayName;
                        } else if (TextUtils.isEmpty(aliasName)) {
                            aliasName = next.getTerminalType();
                        }
                        moduleItem.setName(aliasName);
                        moduleItem.setDisplayName(aliasName);
                    }
                }
                m66547a(arrayList, arrayList2, arrayList3, strM80950o, moduleItem);
            }
        }
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    @Override // android.os.AsyncTask
    /* renamed from: j */
    public void onPostExecute(List<ModuleItem> list) throws RemoteException {
        Message message = new Message();
        message.what = PlayerConstants.ErrorCode.SWITCH_PLAYMODE_AUDIO_FAILED;
        if (list == null || (list.isEmpty() && !C0209d.m1208S0(this.f52157b))) {
            message.arg1 = -5;
        } else if (list.isEmpty()) {
            message.arg1 = -10;
            if (!CloudSyncUtil.m16016i0(this.f52156a) && !CloudSyncUtil.m16007f0()) {
                C11845a.m70908E("notepad", list);
                C11845a.m70937x(this.f52156a, Long.valueOf(System.currentTimeMillis()));
            }
        } else {
            message.arg1 = 0;
            if (!CloudSyncUtil.m16016i0(this.f52156a) && !CloudSyncUtil.m16007f0()) {
                C11845a.m70908E("notepad", list);
                C11845a.m70937x(this.f52156a, Long.valueOf(System.currentTimeMillis()));
            }
        }
        C11839m.m70688i("GetNotePadTask", "getNotePadTask done, arg1 = " + message.arg1);
        C11046a.m66596d(this.f52158c, message);
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        this.f52156a = "notepad";
    }
}
