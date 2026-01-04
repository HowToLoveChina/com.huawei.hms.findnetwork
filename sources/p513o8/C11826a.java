package p513o8;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import com.huawei.android.hicloud.clouddisk.logic.media.model.C2739a;
import com.huawei.android.hicloud.clouddisk.logic.media.model.RemoteFile;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import com.huawei.hicloud.request.opengw.bean.LsRequest;
import fk.C9721b;
import gp.C10028c;
import hk.C10279b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import je.C10812z;
import ke.C11046a;
import md.C11439b;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0221j;
import p015ak.C0227m;
import p015ak.C0241z;
import p514o9.C11835i;
import p514o9.C11839m;
import p548p8.C12120a;
import p548p8.C12121b;
import p606r9.C12478a;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import to.C13049a;

/* renamed from: o8.a */
/* loaded from: classes2.dex */
public class C11826a {

    /* renamed from: a */
    public C12120a f54733a;

    /* renamed from: b */
    public int f54734b;

    /* renamed from: c */
    public int f54735c;

    /* renamed from: d */
    public int f54736d;

    /* renamed from: f */
    public int f54738f;

    /* renamed from: g */
    public String f54739g;

    /* renamed from: h */
    public String f54740h;

    /* renamed from: i */
    public C13049a f54741i;

    /* renamed from: e */
    public String f54737e = "0";

    /* renamed from: j */
    public C12121b f54742j = new C12121b();

    public C11826a() {
        if (C10028c.m62182c0().m62420y1()) {
            this.f54742j.m72684f("/Hicloud/" + C0227m.m1592e(C13452e.m80781L().m80950o()));
        } else {
            this.f54742j.m72684f("/RecordBackup/" + C0227m.m1593f(C13452e.m80781L().m80950o()));
        }
        this.f54736d = -1;
        this.f54733a = new C12120a();
        this.f54741i = new C13049a(EnumC12999a.CLOUD_MORE, null);
    }

    /* renamed from: g */
    public static void m70448g(int i10, File file, RemoteFile remoteFile, List<String> list, List<RemoteFile> list2) {
        String name = file.getName();
        remoteFile.m15466k(file);
        remoteFile.m15469n(name);
        list.set(i10, name);
        list2.set(i10, remoteFile);
    }

    /* renamed from: i */
    public static long m70449i(String str) {
        StatFs statFs = new StatFs(str);
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    /* renamed from: l */
    public static List<String> m70450l(List<RemoteFile> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<RemoteFile> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m15460e().toLowerCase(Locale.getDefault()));
        }
        return arrayList;
    }

    /* renamed from: q */
    public static long m70451q(List<RemoteFile> list) {
        Iterator<RemoteFile> it = list.iterator();
        long jM15462g = 0;
        while (it.hasNext()) {
            jM15462g += it.next().m15462g();
        }
        return jM15462g;
    }

    /* renamed from: r */
    public static String m70452r(long j10, String str, String str2) {
        C11839m.m70688i("RestoreMedia", "getRestorePath: restoreSize = " + j10);
        String strM1505o = C0221j.m1505o();
        long jM70449i = 0;
        if (strM1505o == null || strM1505o.isEmpty()) {
            if (str2 != null && !str2.isEmpty()) {
                jM70449i = m70449i(str2);
                C11839m.m70688i("RestoreMedia", "getRestorePath: outterSDSize = " + jM70449i);
                if (jM70449i >= j10) {
                    return str2;
                }
            }
            long jM70449i2 = m70449i(str);
            C11839m.m70688i("RestoreMedia", "getRestorePath: innerSDSize = " + jM70449i2);
            if (jM70449i2 >= j10) {
                return str;
            }
            if (jM70449i2 + jM70449i > j10) {
                return str2;
            }
            return null;
        }
        long jM70449i3 = m70449i(strM1505o);
        C11839m.m70688i("RestoreMedia", "getRestorePath: defaultSDSize = " + jM70449i3);
        if (jM70449i3 >= j10) {
            return strM1505o;
        }
        if (!strM1505o.equals(str2)) {
            str = str2;
        }
        if (str != null && !str.isEmpty()) {
            jM70449i = m70449i(str);
            C11839m.m70688i("RestoreMedia", "getRestorePath: anotherSDSize = " + jM70449i);
            if (jM70449i >= j10) {
                return str;
            }
        }
        if (jM70449i3 + jM70449i > j10) {
            return strM1505o;
        }
        return null;
    }

    /* renamed from: A */
    public void m70453A(String str) {
        this.f54739g = str;
    }

    /* renamed from: B */
    public final void m70454B(RemoteFile remoteFile) throws C9721b {
        List<Map<String, Object>> successList = this.f54741i.m78709H(new String[]{remoteFile.m15461f() + File.separator + remoteFile.m15460e()}, new String[]{"name", "sslUrl"}).getSuccessList();
        if (successList.isEmpty()) {
            return;
        }
        remoteFile.m15474s(successList.get(0).get("sslUrl").toString());
    }

    /* renamed from: a */
    public final void m70455a(List<RemoteFile> list, String str) {
        Iterator<RemoteFile> it = list.iterator();
        while (it.hasNext()) {
            it.next().m15468m(str);
        }
    }

    /* renamed from: b */
    public final void m70456b(long j10, RemoteFile remoteFile) throws C9721b {
        if (System.currentTimeMillis() - j10 > 9000000) {
            m70454B(remoteFile);
        }
    }

    /* renamed from: c */
    public final CloudDiskModuleRst m70457c(Context context, Handler.Callback callback, List<RemoteFile> list, String str, long j10, ICallback iCallback) throws C9721b {
        C11839m.m70688i("RestoreMedia", "doDownload: module = " + str);
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        C2739a c2739a = new C2739a(null, false);
        c2739a.m15477b(list, false);
        C11046a.m66594b(callback, C11046a.m66595c(c2739a.m15476a(), str, false));
        c2739a.m15480e(callback);
        C11439b.a aVar = (C11439b.a) callback;
        int i10 = 3;
        if (aVar.m68523b()) {
            C11839m.m70688i("RestoreMedia", "Restore task is aborted before downloadFile");
            cloudDiskModuleRst.setRetCode(3);
            return cloudDiskModuleRst;
        }
        int size = list.size();
        int i11 = 1;
        while (i11 < size + 1) {
            if (aVar.m68523b()) {
                C11839m.m70688i("RestoreMedia", "Restore task is aborted during downloadFile");
                cloudDiskModuleRst.setRetCode(i10);
                return cloudDiskModuleRst;
            }
            RemoteFile remoteFile = list.get(i11 - 1);
            int i12 = i11;
            int iM70460f = m70460f(callback, remoteFile, j10, iCallback, cloudDiskModuleRst);
            if (aVar.m68523b()) {
                C11839m.m70688i("RestoreMedia", "Restore task is aborted after downloadFile");
                cloudDiskModuleRst.setRetCode(i10);
                return cloudDiskModuleRst;
            }
            c2739a.m15481f(remoteFile);
            remoteFile.m15464i();
            m70474y(iM70460f, i12, size, str, callback);
            if (iM70460f != 99804) {
                cloudDiskModuleRst.setRetCode(-20);
                long jM15462g = remoteFile.m15462g();
                long jM70449i = m70449i(C11835i.m70645i(context).getPath());
                long jM70449i2 = m70449i(remoteFile.m15459d());
                C11839m.m70688i("RestoreMedia", "doDownload: downloadFileSize = " + jM15462g + ", baseCacheDirSize = " + jM70449i + ", localCardSize = " + jM70449i2);
                if (jM15462g > jM70449i || jM15462g > jM70449i2) {
                    break;
                }
            }
            i11 = i12 + 1;
            i10 = 3;
        }
        c2739a.m15478c();
        return cloudDiskModuleRst;
    }

    /* renamed from: d */
    public CloudDiskModuleRst m70458d(Context context, String str, String str2, C11439b.a aVar, ICallback iCallback) throws C9721b {
        List<RemoteFile> list;
        C11839m.m70688i("RestoreMedia", "doRestore: module = " + str2);
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        List<RemoteFile> arrayList = new ArrayList<>();
        List<RemoteFile> arrayList2 = new ArrayList<>();
        if (aVar.m68523b()) {
            C11839m.m70688i("RestoreMedia", "Restore task is aborted");
            cloudDiskModuleRst.setRetCode(3);
            return cloudDiskModuleRst;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<RemoteFile> listM70469t = m70469t(str2, str, aVar);
        if (listM70469t == null || listM70469t.isEmpty()) {
            C11839m.m70688i("RestoreMedia", "Restore is over because serverList is empty");
            cloudDiskModuleRst.setRetCode(1);
            cloudDiskModuleRst.setFailReason("Restore is over because serverList is empty");
            return cloudDiskModuleRst;
        }
        int size = listM70469t.size();
        Map<String, String> mapM72674f = this.f54733a.m72674f(context);
        String str3 = mapM72674f.get("in");
        String str4 = mapM72674f.get("out");
        if (!TextUtils.isEmpty(str3)) {
            arrayList = m70463k(str3, str2);
        }
        if (!TextUtils.isEmpty(str4)) {
            arrayList2 = m70463k(str4, str2);
        }
        List<RemoteFile> listM70467p = m70467p(listM70469t, arrayList, arrayList2);
        this.f54736d = listM70467p.size();
        C11839m.m70688i("RestoreMedia", "doRestore: serverListNum = " + size + ", expectDownLoadNum = " + this.f54736d);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("deviceName", this.f54740h);
        linkedHashMap.put("totalNum", String.valueOf(size));
        linkedHashMap.put("expectDownLoadNum", String.valueOf(this.f54736d));
        C10812z.m65839h(context, "recording", 0, "", "", "03010", "more_data_restore", this.f54739g, linkedHashMap, true);
        this.f54738f = size - this.f54736d;
        String strM70452r = m70452r(m70451q(listM70467p), str3, str4);
        C11839m.m70686d("RestoreMedia", "doRestore: restorePath = " + strM70452r);
        if (strM70452r == null) {
            this.f54737e = "4";
            m70474y(99101, 0, 0, str2, aVar);
            C11839m.m70688i("RestoreMedia", "Restore space is not enough.");
            cloudDiskModuleRst.setRetCode(-1);
            cloudDiskModuleRst.setFailReason("Restore space is not enough.");
            return cloudDiskModuleRst;
        }
        if (!m70471v(strM70452r, str2)) {
            this.f54737e = "4";
            m70474y(99102, 0, 0, str2, aVar);
            C11839m.m70688i("RestoreMedia", "Restore create temp folder error.");
            cloudDiskModuleRst.setRetCode(-1);
            cloudDiskModuleRst.setFailReason("Restore create temp folder error.");
            return cloudDiskModuleRst;
        }
        if (aVar.m68523b()) {
            C11839m.m70688i("RestoreMedia", "Restore task is aborted during");
            cloudDiskModuleRst.setRetCode(3);
            return cloudDiskModuleRst;
        }
        if (strM70452r.equals(str4)) {
            list = listM70467p;
            m70472w(list, listM70469t, arrayList2, arrayList);
        } else {
            list = listM70467p;
            m70472w(list, listM70469t, arrayList, arrayList2);
        }
        this.f54733a.m72677i(list);
        String str5 = strM70452r + this.f54742j.m72680a().get(str2);
        m70455a(list, str5);
        try {
            CloudDiskModuleRst cloudDiskModuleRstM70457c = m70457c(context, aVar, list, str2, jCurrentTimeMillis, iCallback);
            cloudDiskModuleRst.setRetCode(cloudDiskModuleRstM70457c.getRetCode());
            cloudDiskModuleRst.setFailReason(cloudDiskModuleRstM70457c.getFailReason());
            C11839m.m70686d("RestoreMedia", "RetCode:" + cloudDiskModuleRst.getRetCode() + ",FailReason：" + cloudDiskModuleRst.getFailReason());
            if (cloudDiskModuleRst.getRetCode() != 3 && cloudDiskModuleRst.getRetCode() != -1 && cloudDiskModuleRst.getRetCode() != -20) {
                m70474y(99813, 0, 0, str2, aVar);
                cloudDiskModuleRst.setRetCode(0);
            }
            return cloudDiskModuleRst;
        } catch (C9721b e10) {
            this.f54733a.m72672c(str5);
            throw e10;
        }
    }

    /* renamed from: e */
    public final void m70459e(RemoteFile remoteFile, ICallback iCallback) throws C9721b {
        new C12478a(EnumC12999a.CLOUD_MORE, this.f54739g).m74913i(remoteFile.m15461f() + "/" + remoteFile.m15460e(), remoteFile.m15459d() + "/" + remoteFile.m15460e(), iCallback);
    }

    /* renamed from: f */
    public final int m70460f(Handler.Callback callback, RemoteFile remoteFile, long j10, ICallback iCallback, CloudDiskModuleRst cloudDiskModuleRst) throws C9721b {
        m70456b(j10, remoteFile);
        if (((C11439b.a) callback).m68523b()) {
            C11839m.m70688i("RestoreMedia", "dwnloadFile Restore task is aborted during downloadFile");
            cloudDiskModuleRst.setRetCode(3);
            return 99806;
        }
        try {
            m70459e(remoteFile, iCallback);
            return 99804;
        } catch (C9721b e10) {
            C11839m.m70687e("RestoreMedia", "dwnloadFile down fail for exception:" + e10.toString());
            cloudDiskModuleRst.setRetCode(e10.m60659c());
            cloudDiskModuleRst.setFailReason(e10.getMessage());
            return 99806;
        }
    }

    /* renamed from: h */
    public int m70461h() {
        return this.f54736d;
    }

    /* renamed from: j */
    public final List<RemoteFile> m70462j(String str, String str2) {
        File[] fileArrListFiles;
        SharedPreferences sharedPreferencesM1382b;
        LinkedList linkedList = new LinkedList();
        File file = new File(str);
        int i10 = 0;
        long j10 = (!CloudSyncUtil.m15954H0(C0213f.m1377a()) || (sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "deviceNameSp", 0)) == null) ? 0L : sharedPreferencesM1382b.getLong("recordingtimestamp", 0L);
        C11839m.m70688i("RestoreMedia", "timestamp: " + j10);
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            if (j10 > 0) {
                int length = fileArrListFiles.length;
                while (i10 < length) {
                    File file2 = fileArrListFiles[i10];
                    if (!file2.isDirectory() && file2.length() != 0 && file2.lastModified() <= j10) {
                        m70466o(str2, linkedList, file2);
                    }
                    i10++;
                }
            } else {
                int length2 = fileArrListFiles.length;
                while (i10 < length2) {
                    File file3 = fileArrListFiles[i10];
                    if (!file3.isDirectory() && file3.length() != 0) {
                        m70466o(str2, linkedList, file3);
                    }
                    i10++;
                }
            }
        }
        return linkedList;
    }

    /* renamed from: k */
    public List<RemoteFile> m70463k(String str, String str2) {
        return m70462j(str + this.f54742j.m72680a().get(str2), str2);
    }

    /* renamed from: m */
    public final String m70464m(String str, List<String> list, List<String> list2, List<String> list3) {
        String strM72673e = null;
        boolean zM72675g = false;
        int i10 = 0;
        while (!zM72675g) {
            strM72673e = this.f54733a.m72673e(i10, str);
            i10++;
            zM72675g = this.f54733a.m72675g(strM72673e.toLowerCase(Locale.getDefault()), list, list2, list3);
        }
        return strM72673e;
    }

    /* renamed from: n */
    public int m70465n() {
        return this.f54738f;
    }

    /* renamed from: o */
    public final void m70466o(String str, List<RemoteFile> list, File file) {
        for (String str2 : this.f54742j.m72682c().get(str)) {
            if (C10279b.m63452a(file).toLowerCase(Locale.getDefault()).endsWith(str2)) {
                RemoteFile remoteFile = new RemoteFile();
                remoteFile.m15466k(file);
                remoteFile.m15473r(str);
                if (C10028c.m62182c0().m62420y1()) {
                    remoteFile.m15471p(this.f54742j.m72683e() + this.f54742j.m72681b().get(str));
                } else {
                    remoteFile.m15471p(this.f54742j.m72683e());
                }
                remoteFile.m15469n(file.getName());
                remoteFile.m15472q(file.length());
                remoteFile.m15468m(C10279b.m63452a(file));
                list.add(remoteFile);
                return;
            }
        }
    }

    /* renamed from: p */
    public final List<RemoteFile> m70467p(List<RemoteFile> list, List<RemoteFile> list2, List<RemoteFile> list3) {
        LinkedList linkedList = new LinkedList();
        list.removeAll(list2);
        list.removeAll(list3);
        linkedList.addAll(list);
        return linkedList;
    }

    /* renamed from: s */
    public List<RemoteFile> m70468s(String str, String str2) throws C9721b {
        ArrayList arrayList = new ArrayList();
        LsRequest lsRequest = new LsRequest();
        lsRequest.setServerPath(str2);
        lsRequest.setFields(new String[]{"name", "size", "sslUrl", "md5", "createTime"});
        lsRequest.setType(1);
        lsRequest.setRecursive(1);
        for (Map<String, Object> map : this.f54741i.m78718T(lsRequest)) {
            RemoteFile remoteFile = new RemoteFile();
            remoteFile.m15469n(map.get("name").toString());
            remoteFile.m15474s((String) map.get("sslUrl"));
            remoteFile.m15471p(str2);
            remoteFile.m15470o((String) map.get("md5"));
            remoteFile.m15472q(C0241z.m1688f((String) map.get("size")));
            arrayList.add(remoteFile);
        }
        return arrayList;
    }

    /* renamed from: t */
    public final List<RemoteFile> m70469t(String str, String str2, Handler.Callback callback) {
        String str3;
        try {
            if (((C11439b.a) callback).m68523b()) {
                return null;
            }
            if (C10028c.m62182c0().m62420y1()) {
                str3 = "/Hicloud" + File.separator + str;
            } else {
                str3 = "/RecordBackup" + File.separator + str;
            }
            return m70468s(str3, str2);
        } catch (C9721b e10) {
            m70474y(99904, 0, 0, str2, callback);
            C11839m.m70687e("RestoreMedia", "Exception happen when download file" + e10.toString());
            return null;
        }
    }

    /* renamed from: u */
    public int m70470u() {
        return this.f54734b;
    }

    /* renamed from: v */
    public final boolean m70471v(String str, String str2) {
        if (str == null) {
            return false;
        }
        return this.f54733a.m72671b(str, str + this.f54742j.m72680a().get(str2));
    }

    /* renamed from: w */
    public final void m70472w(List<RemoteFile> list, List<RemoteFile> list2, List<RemoteFile> list3, List<RemoteFile> list4) {
        if (list.isEmpty()) {
            return;
        }
        List<String> listM70450l = m70450l(list2);
        List<String> listM70450l2 = m70450l(list3);
        List<String> listM70450l3 = m70450l(list4);
        Iterator<RemoteFile> it = list.iterator();
        while (it.hasNext()) {
            int iIndexOf = listM70450l2.indexOf(it.next().m15460e().toLowerCase(Locale.getDefault()));
            if (iIndexOf != -1) {
                RemoteFile remoteFile = list3.get(iIndexOf);
                File fileM15458c = remoteFile.m15458c();
                String name = fileM15458c.getName();
                String strM70464m = m70464m(name, listM70450l3, listM70450l2, listM70450l);
                File fileM72676h = this.f54733a.m72676h(fileM15458c, strM70464m);
                if (strM70464m.equals(fileM72676h.getName())) {
                    m70448g(iIndexOf, fileM72676h, remoteFile, listM70450l2, list3);
                    int iIndexOf2 = listM70450l3.indexOf(name.toLowerCase(Locale.getDefault()));
                    if (iIndexOf2 != -1) {
                        RemoteFile remoteFile2 = list4.get(iIndexOf2);
                        if (remoteFile.m15462g() == remoteFile2.m15462g()) {
                            File fileM15458c2 = remoteFile2.m15458c();
                            String strReplace = strM70464m.replace(name, fileM15458c2.getName());
                            if (strReplace.equals(this.f54733a.m72676h(fileM15458c2, strReplace).getName())) {
                                m70448g(iIndexOf2, fileM15458c2, remoteFile2, listM70450l3, list4);
                            }
                        }
                    }
                } else {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: x */
    public void m70473x() {
        this.f54734b = 0;
        this.f54738f = 0;
        this.f54735c = 0;
        this.f54736d = 0;
    }

    /* renamed from: y */
    public void m70474y(int i10, int i11, int i12, String str, Handler.Callback callback) {
        if (callback != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.arg1 = i11;
            messageObtain.arg2 = i12;
            messageObtain.obj = str;
            callback.handleMessage(messageObtain);
        }
        switch (i10) {
            case 99804:
                this.f54734b++;
                break;
            case 99805:
                break;
            default:
                this.f54735c++;
                break;
        }
    }

    /* renamed from: z */
    public void m70475z(String str) {
        this.f54740h = str;
    }
}
