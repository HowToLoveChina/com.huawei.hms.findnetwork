package p618rm;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.AppInfoList;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackup;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupPathInfo;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.android.hicloud.cloudbackup.process.util.FileCategoryUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.manager.HNCloudConfig;
import com.huawei.hicloud.notification.manager.HNLocalConfig;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import p514o9.C11839m;
import p617rl.C12519c;
import p711vl.C13465e;
import p815ym.AbstractC14026a;

/* renamed from: rm.p1 */
/* loaded from: classes6.dex */
public class C12582p1 {

    /* renamed from: e */
    @SuppressLint({"SdCardPath"})
    public static final String[] f57944e = {"/external/Recordings/", "/external/record/", "/external/Sounds/", "/external/Sounds/CallRecord/", "/sdcard/Sounds/CallRecord/", "/sdcard/record/", "/data/hw_init/product/media/Pre-loaded/Music/", "/data/hw_init/version/region_comm/china/media/Pre-loaded/Music/", "/data/hw_init/product/region_comm/china/media/Pre-loaded/Music/", "/usb/", "/product/media/Pre-loaded/Music/", "/hw_product/media/Pre-loaded/Music/"};

    /* renamed from: a */
    public final String f57945a;

    /* renamed from: b */
    public final Context f57946b;

    /* renamed from: c */
    public boolean f57947c = false;

    /* renamed from: d */
    public final Map<String, List<CloudBackupPathInfo>> f57948d;

    /* renamed from: rm.p1$a */
    public static class a {

        /* renamed from: a */
        public String f57949a;

        /* renamed from: b */
        public long f57950b;

        /* renamed from: a */
        public long m75643a() {
            return this.f57950b;
        }

        /* renamed from: b */
        public String m75644b() {
            return this.f57949a;
        }

        /* renamed from: c */
        public void m75645c(long j10) {
            this.f57950b = j10;
        }

        /* renamed from: d */
        public void m75646d(String str) {
            this.f57949a = str;
        }
    }

    public C12582p1(String str, Context context) {
        HashMap map = new HashMap();
        this.f57948d = map;
        map.put("media", new ArrayList());
        map.put("userlib", new ArrayList());
        map.put("excludes", new ArrayList());
        this.f57945a = str;
        this.f57946b = context;
        m75638v();
    }

    /* renamed from: B */
    public static /* synthetic */ CloudBackupPathInfo m75595B(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return (CloudBackupPathInfo) list.get(0);
    }

    /* renamed from: D */
    public static /* synthetic */ void m75596D(List list, CloudBackupPathInfo cloudBackupPathInfo) {
        list.addAll(cloudBackupPathInfo.getPaths());
    }

    /* renamed from: E */
    public static /* synthetic */ void m75597E(final List list, List list2) {
        list2.forEach(new Consumer() { // from class: rm.f1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C12582p1.m75596D(list, (CloudBackupPathInfo) obj);
            }
        });
    }

    /* renamed from: F */
    public static /* synthetic */ CloudBackupPathInfo m75598F(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return (CloudBackupPathInfo) list.get(0);
    }

    /* renamed from: H */
    public static /* synthetic */ void m75599H(List list, CloudBackupPathInfo cloudBackupPathInfo) {
        if (cloudBackupPathInfo.getPaths().isEmpty()) {
            return;
        }
        list.add(cloudBackupPathInfo);
    }

    /* renamed from: I */
    public static /* synthetic */ void m75600I(final List list, List list2) {
        list2.forEach(new Consumer() { // from class: rm.e1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C12582p1.m75599H(list, (CloudBackupPathInfo) obj);
            }
        });
    }

    /* renamed from: L */
    public static /* synthetic */ void m75603L(List list, CloudBackupPathInfo cloudBackupPathInfo) {
        list.addAll(cloudBackupPathInfo.getPaths());
    }

    /* renamed from: M */
    public static /* synthetic */ void m75604M(final List list, List list2, List list3) {
        list3.forEach(new Consumer() { // from class: rm.i1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C12582p1.m75603L(list, (CloudBackupPathInfo) obj);
            }
        });
        list2.addAll(list3);
    }

    /* renamed from: O */
    public static String m75605O(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (char c10 : str.toCharArray()) {
            if (c10 == '*') {
                sb2.append("(.)*");
            } else if (c10 == '_') {
                sb2.append("[\\s\\S]");
            } else if (c10 == '.') {
                sb2.append("[.]");
            } else {
                sb2.append(c10);
            }
        }
        return sb2.toString();
    }

    /* renamed from: A */
    public final boolean m75618A(String str, List<String> list) {
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.startsWith(ICBUtil.convertToAbsolutePath(it.next(), this.f57945a))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: C */
    public final /* synthetic */ void m75619C(String str, List list, a aVar, long j10, List list2, CloudBackupPathInfo cloudBackupPathInfo) {
        if (!m75642z(str, cloudBackupPathInfo.getMimeTypes()) || m75640x(str, list)) {
            return;
        }
        aVar.m75645c(j10);
        aVar.m75646d(str);
        list2.add(aVar);
    }

    /* renamed from: G */
    public final /* synthetic */ void m75620G(String str, List list, a aVar, long j10, List list2, CloudBackupPathInfo cloudBackupPathInfo) {
        if (!m75642z(str, cloudBackupPathInfo.getMimeTypes()) || m75640x(str, list)) {
            return;
        }
        aVar.m75645c(j10);
        aVar.m75646d(str);
        list2.add(aVar);
    }

    /* renamed from: N */
    public final boolean m75621N(List<String> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70689w("MusicBackupV3", "matchDevice config is empty");
            return false;
        }
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("MusicBackupV3", "matchDevice phoneType is empty");
            return false;
        }
        C11839m.m70686d("MusicBackupV3", "matchDevice cloud phoneTypes " + list + " ,current phoneType = " + str);
        for (String str2 : list) {
            if (TextUtils.isEmpty(str2)) {
                C11839m.m70687e("MusicBackupV3", "device is empty");
            } else if (str.matches(m75605O(str2))) {
                C11839m.m70688i("MusicBackupV3", "matchDevice config = " + list);
                return true;
            }
        }
        return false;
    }

    /* renamed from: P */
    public final void m75622P(String str, final List<CloudBackupPathInfo> list) {
        Optional.ofNullable(this.f57948d.get(str)).ifPresent(new Consumer() { // from class: rm.h1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((List) obj).addAll(list);
            }
        });
    }

    /* renamed from: Q */
    public final void m75623Q(String str, final CloudBackupPathInfo cloudBackupPathInfo) {
        Optional.ofNullable(this.f57948d.get(str)).ifPresent(new Consumer() { // from class: rm.d1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((List) obj).add(cloudBackupPathInfo);
            }
        });
    }

    /* renamed from: R */
    public final List<a> m75624R(File file, List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!file.exists()) {
                C11839m.m70689w("MusicBackupV3", "This is not a dictionary!");
                return arrayList;
            }
            if (file.isFile()) {
                if (file.length() <= 0) {
                    C11839m.m70689w("MusicBackupV3", "scanDirectory file = " + C10279b.m63452a(file) + " length is 0.");
                    return arrayList;
                }
                if (m75642z(file.getCanonicalPath(), list) && !m75641y(file.getCanonicalPath(), this.f57948d.get("excludes"))) {
                    a aVar = new a();
                    aVar.m75645c(file.length());
                    aVar.m75646d(file.getCanonicalPath());
                    arrayList.add(aVar);
                    return arrayList;
                }
            }
            File[] fileArrM63440f = C10278a.m63440f(file);
            if (fileArrM63440f == null || fileArrM63440f.length == 0) {
                C11839m.m70689w("MusicBackupV3", "This is an empty dictionary path = " + C10279b.m63452a(file));
                return arrayList;
            }
            for (File file2 : fileArrM63440f) {
                arrayList.addAll(m75624R(file2, list));
            }
            return arrayList;
        } catch (IOException unused) {
            C11839m.m70689w("MusicBackupV3", String.format(Locale.ENGLISH, "getCanonicalPath failed, file name %s is invalid!", file.getPath()));
            return arrayList;
        }
    }

    /* renamed from: S */
    public List<a> m75625S(List<CloudBackupPathInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (CloudBackupPathInfo cloudBackupPathInfo : list) {
            List<String> paths = cloudBackupPathInfo.getPaths();
            List<Integer> mimeTypes = cloudBackupPathInfo.getMimeTypes();
            for (String str : paths) {
                String strConvertToAbsolutePath = ICBUtil.convertToAbsolutePath(str, this.f57945a);
                if (TextUtils.isEmpty(strConvertToAbsolutePath)) {
                    C11839m.m70689w("MusicBackupV3", "scanFiles realPath is empty, filePath = " + str);
                } else {
                    arrayList.addAll(m75624R(C10278a.m63442h(strConvertToAbsolutePath), mimeTypes));
                }
            }
        }
        C11839m.m70688i("MusicBackupV3", "MusicBackup file traversal complete!");
        return arrayList;
    }

    /* renamed from: T */
    public List<a> m75626T(Map<String, List<CloudBackupPathInfo>> map) {
        if (map == null || map.isEmpty()) {
            C11839m.m70687e("MusicBackupV3", "scanFiles settingmap is empty");
            return null;
        }
        List<CloudBackupPathInfo> list = map.get("userlib");
        if (list != null && !list.isEmpty()) {
            return m75625S(list);
        }
        C11839m.m70687e("MusicBackupV3", "scanFiles nomedia settinglist is empty");
        return null;
    }

    /* renamed from: U */
    public List<a> m75627U() throws C9721b {
        List listAsList = Arrays.asList(f57944e);
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (AbstractC14026a.m84159a(this.f57948d.get("media"))) {
            C11839m.m70687e("MusicBackupV3", "get no mediaLib info from OM Config, or parse OM failed, default configuration will be applied");
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(new CloudBackupPathInfo());
            this.f57948d.put("media", arrayList4);
            ArrayList arrayList5 = new ArrayList(listAsList);
            CloudBackupPathInfo cloudBackupPathInfo = new CloudBackupPathInfo();
            arrayList3.addAll(arrayList5);
            cloudBackupPathInfo.setPaths(arrayList5);
            arrayList2.add(cloudBackupPathInfo);
        } else {
            Optional.ofNullable(this.f57948d.get("excludes")).ifPresent(new Consumer() { // from class: rm.g1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C12582p1.m75604M(arrayList3, arrayList2, (List) obj);
                }
            });
        }
        C13465e.m81052f().m81066o("musicBlackList", arrayList3);
        List<String> blackPathBackup = CloudBackupConstant.MusicFileFilterPath.getBlackPathBackup();
        CloudBackupPathInfo cloudBackupPathInfo2 = new CloudBackupPathInfo();
        cloudBackupPathInfo2.setPaths(blackPathBackup);
        arrayList2.add(cloudBackupPathInfo2);
        m75636t(arrayList, arrayList2);
        return arrayList;
    }

    /* renamed from: V */
    public final List<a> m75628V(Map<String, List<CloudBackupPathInfo>> map) throws C9721b {
        if (map != null && !map.isEmpty()) {
            return m75627U();
        }
        C11839m.m70687e("MusicBackupV3", "scanMediaFiles settingmap is empty");
        return null;
    }

    /* renamed from: m */
    public final void m75629m(final List<a> list, final List<CloudBackupPathInfo> list2, Uri uri, String[] strArr, String str, ContentResolver contentResolver) throws C9721b {
        int i10 = 0;
        while (true) {
            try {
                Cursor cursorQuery = contentResolver.query(uri, strArr, null, null, str + " LIMIT " + (i10 + ",100"));
                if (cursorQuery == null || cursorQuery.getCount() == 0) {
                    break;
                }
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                    if (!C4633d0.m28404a(string)) {
                        File fileM63442h = C10278a.m63442h(string);
                        final String strM63452a = C10279b.m63452a(fileM63442h);
                        C11839m.m70686d("MusicBackupV3", String.format(Locale.ENGLISH, "file has been scanned, file name is %s", string));
                        if (fileM63442h.exists()) {
                            final long length = fileM63442h.length();
                            if (length <= 0) {
                                C11839m.m70689w("MusicBackupV3", "scanMediaFiles file = " + strM63452a + "length <= 0");
                            } else {
                                final a aVar = new a();
                                Optional.ofNullable(this.f57948d.get("media")).map(new Function() { // from class: rm.l1
                                    @Override // java.util.function.Function
                                    public final Object apply(Object obj) {
                                        return C12582p1.m75595B((List) obj);
                                    }
                                }).ifPresent(new Consumer() { // from class: rm.m1
                                    @Override // java.util.function.Consumer
                                    public final void accept(Object obj) {
                                        this.f57925a.m75619C(strM63452a, list2, aVar, length, list, (CloudBackupPathInfo) obj);
                                    }
                                });
                            }
                        } else {
                            C11839m.m70689w("MusicBackupV3", "scanMediaFiles file is not exists fpath = " + string);
                        }
                    }
                }
                cursorQuery.close();
                i10 += 100;
            } catch (Exception e10) {
                C11839m.m70687e("MusicBackupV3", "scanMediaFiles error = " + e10);
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "scanMediaFiles error:" + e10.getMessage());
            }
        }
        C11839m.m70687e("MusicBackupV3", "scanMediaFiles cursor is null");
    }

    /* renamed from: n */
    public final boolean m75630n() {
        NotificationConfig config;
        HNCloudConfig hNCloudConfig = new HNCloudConfig();
        if (hNCloudConfig.isExist()) {
            config = hNCloudConfig.getConfig();
        } else {
            HNLocalConfig hNLocalConfig = new HNLocalConfig();
            C11839m.m70688i("MusicBackupV3", "checkDevice cloud config not exist");
            config = hNLocalConfig.getConfig();
        }
        if (config != null) {
            return m75621N(config.getSupportMusicDevicelistType());
        }
        C11839m.m70689w("MusicBackupV3", "checkDevice config is null");
        return false;
    }

    /* renamed from: o */
    public String m75631o() {
        return "music";
    }

    /* renamed from: p */
    public List<a> m75632p() {
        if (this.f57947c) {
            return m75639w();
        }
        C11839m.m70688i("MusicBackupV3", "getAllMusicMetas device not match");
        return null;
    }

    /* renamed from: q */
    public List<String> m75633q() {
        m75637u();
        final ArrayList arrayList = new ArrayList(CloudBackupConstant.MusicFileFilterPath.getBlackPathBackup());
        Optional.ofNullable(this.f57948d.get("excludes")).ifPresent(new Consumer() { // from class: rm.n1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C12582p1.m75597E(arrayList, (List) obj);
            }
        });
        return arrayList;
    }

    /* renamed from: r */
    public SnapshotBackupMeta m75634r() {
        SnapshotBackupMeta snapshotBackupMeta = new SnapshotBackupMeta();
        if (!this.f57947c) {
            C11839m.m70688i("MusicBackupV3", "getBackupStatus device not match");
            return null;
        }
        List<a> listM75639w = m75639w();
        if (listM75639w.isEmpty()) {
            return null;
        }
        int size = listM75639w.size();
        Iterator<a> it = listM75639w.iterator();
        long jM75643a = 0;
        while (it.hasNext()) {
            jM75643a += it.next().m75643a();
        }
        snapshotBackupMeta.setData(m75631o());
        snapshotBackupMeta.setSize(jM75643a);
        snapshotBackupMeta.setCount(size);
        C11839m.m70688i("MusicBackupV3", "getMusicBackupMeta datasize:" + jM75643a);
        return snapshotBackupMeta;
    }

    /* renamed from: s */
    public CloudBackupStatus m75635s() {
        CloudBackupStatus cloudBackupStatus = new CloudBackupStatus();
        if (!this.f57947c) {
            C11839m.m70688i("MusicBackupV3", "getBackupStatus device not match");
            return null;
        }
        List<a> listM75639w = m75639w();
        if (listM75639w.isEmpty()) {
            return null;
        }
        int size = listM75639w.size();
        Iterator<a> it = listM75639w.iterator();
        long jM75643a = 0;
        while (it.hasNext()) {
            jM75643a += it.next().m75643a();
        }
        cloudBackupStatus.mo29313Y(m75631o());
        cloudBackupStatus.mo29323e0(jM75643a);
        cloudBackupStatus.mo29327g0(size);
        C11839m.m70688i("MusicBackupV3", "getMusicCloudBackupV3Meta datasize:" + jM75643a);
        return cloudBackupStatus;
    }

    /* renamed from: t */
    public final void m75636t(final List<a> list, final List<CloudBackupPathInfo> list2) throws C9721b {
        Cursor cursorQuery;
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] strArr = {"_id", "title", "_data", "mime_type", "_display_name"};
        ContentResolver contentResolver = this.f57946b.getContentResolver();
        try {
            m75629m(list, list2, uri, strArr, "title ASC", contentResolver);
        } catch (C9721b unused) {
            try {
                cursorQuery = contentResolver.query(uri, strArr, null, null, null);
            } catch (Exception e10) {
                C11839m.m70687e("MusicBackupV3", "scanMediaFiles error = " + e10);
                cursorQuery = null;
            }
            Cursor cursor = cursorQuery;
            if (cursor == null) {
                C11839m.m70687e("MusicBackupV3", "scanMediaFiles cursor is null");
                return;
            }
            while (cursor.moveToNext()) {
                try {
                    String string = cursor.getString(cursor.getColumnIndex("_data"));
                    File fileM63442h = C10278a.m63442h(string);
                    final String strM63452a = C10279b.m63452a(fileM63442h);
                    C11839m.m70686d("MusicBackupV3", String.format(Locale.ENGLISH, "file has been scanned, file name is %s", string));
                    if (fileM63442h.exists()) {
                        final long length = fileM63442h.length();
                        if (length <= 0) {
                            C11839m.m70689w("MusicBackupV3", "scanMediaFiles file = " + strM63452a + "length <= 0");
                        } else {
                            final a aVar = new a();
                            Optional.ofNullable(this.f57948d.get("media")).map(new Function() { // from class: rm.j1
                                @Override // java.util.function.Function
                                public final Object apply(Object obj) {
                                    return C12582p1.m75598F((List) obj);
                                }
                            }).ifPresent(new Consumer() { // from class: rm.k1
                                @Override // java.util.function.Consumer
                                public final void accept(Object obj) {
                                    this.f57913a.m75620G(strM63452a, list2, aVar, length, list, (CloudBackupPathInfo) obj);
                                }
                            });
                        }
                    } else {
                        C11839m.m70689w("MusicBackupV3", "scanMediaFiles file is not exists fpath = " + string);
                    }
                } catch (Throwable th2) {
                    cursor.close();
                    throw th2;
                }
            }
            cursor.close();
        }
    }

    /* renamed from: u */
    public final void m75637u() {
        Iterator<Map.Entry<String, List<CloudBackupPathInfo>>> it = this.f57948d.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().clear();
        }
        Iterator<AppInfoList> it2 = new C12519c().m75300k("music").iterator();
        while (it2.hasNext()) {
            CloudBackup cloudBackup = it2.next().getCloudBackup();
            for (CloudBackupPathInfo cloudBackupPathInfo : cloudBackup.getInclude()) {
                int iIndexOf = cloudBackupPathInfo.getPaths().indexOf(ScanAppDataUtil.MEDIALIB);
                if (iIndexOf != -1) {
                    CloudBackupPathInfo cloudBackupPathInfo2 = new CloudBackupPathInfo();
                    CloudBackupPathInfo cloudBackupPathInfo3 = new CloudBackupPathInfo();
                    cloudBackupPathInfo.getPaths().remove(iIndexOf);
                    cloudBackupPathInfo3.setPaths(cloudBackupPathInfo.getPaths());
                    cloudBackupPathInfo3.setMimeTypes(cloudBackupPathInfo.getMimeTypes());
                    cloudBackupPathInfo2.setMimeTypes(cloudBackupPathInfo.getMimeTypes());
                    m75623Q("media", cloudBackupPathInfo2);
                    m75623Q("userlib", cloudBackupPathInfo3);
                } else {
                    m75623Q("userlib", cloudBackupPathInfo);
                }
            }
            m75622P("excludes", cloudBackup.getExclude());
        }
    }

    /* renamed from: v */
    public final void m75638v() {
        this.f57947c = m75630n();
    }

    /* renamed from: w */
    public final List<a> m75639w() {
        m75637u();
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<a> listM75626T = m75626T(this.f57948d);
        if (listM75626T != null) {
            arrayList.addAll(listM75626T);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        C11839m.m70688i("MusicBackupV3", "initMusicFiles scanfiles total time = " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " ms");
        try {
            List<a> listM75628V = m75628V(this.f57948d);
            if (listM75628V != null) {
                arrayList.addAll(listM75628V);
            }
        } catch (C9721b e10) {
            C11839m.m70687e("MusicBackupV3", "initMusicFiles scanMediaFiles error : " + e10);
        }
        C11839m.m70688i("MusicBackupV3", "initMusicFiles scanMediaFiles total time = " + (System.currentTimeMillis() - jCurrentTimeMillis2) + " ms");
        return arrayList;
    }

    /* renamed from: x */
    public final boolean m75640x(String str, List<CloudBackupPathInfo> list) {
        final ArrayList arrayList = new ArrayList();
        Optional.ofNullable(this.f57948d.get("userlib")).ifPresent(new Consumer() { // from class: rm.o1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C12582p1.m75600I(arrayList, (List) obj);
            }
        });
        arrayList.addAll(list);
        return m75641y(str, arrayList);
    }

    /* renamed from: y */
    public final boolean m75641y(String str, List<CloudBackupPathInfo> list) {
        if (str == null) {
            C11839m.m70688i("MusicBackupV3", "file canonical path is null");
            return true;
        }
        boolean zM75618A = false;
        for (CloudBackupPathInfo cloudBackupPathInfo : list) {
            List<String> paths = cloudBackupPathInfo.getPaths();
            List<Integer> mimeTypes = cloudBackupPathInfo.getMimeTypes();
            if (!paths.isEmpty() || !mimeTypes.isEmpty()) {
                zM75618A = (str.startsWith(BackupRestoreConstans.DATA_PATH) || mimeTypes.isEmpty()) ? m75618A(str, paths) : paths.isEmpty() ? m75642z(str, mimeTypes) : m75618A(str, paths) && m75642z(str, mimeTypes);
                if (zM75618A) {
                    break;
                }
            }
        }
        return zM75618A;
    }

    /* renamed from: z */
    public final boolean m75642z(String str, List<Integer> list) {
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.isDirectory() || list.isEmpty()) {
            return true;
        }
        return list.contains(Integer.valueOf(FileCategoryUtil.getFileCategory(C12538b.m75479b(fileM63442h).m73355a())));
    }
}
