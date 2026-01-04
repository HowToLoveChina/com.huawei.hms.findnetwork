package com.huawei.android.hicloud.cloudbackup.process;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.notification.manager.HNCloudConfig;
import com.huawei.hicloud.notification.manager.HNLocalConfig;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.request.cbs.bean.CBSDataBackup;
import com.huawei.hicloud.request.cbs.bean.CBSInitParam;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p015ak.C0213f;
import p514o9.C11839m;
import p711vl.C13465e;
import pl.C12161c;

/* loaded from: classes2.dex */
public class MusicBackup {
    private static final String MEDIA = "media";
    private static final String TAG = "MusicBackup";
    private Context mContext;
    private boolean mDeviceMatch = false;
    private CBSInitParam mInitParam;
    private String mLocation;

    public static class MusicFileData {
        private String apkName;
        private long dataSize;
        private String path;

        public long getDataSize() {
            return this.dataSize;
        }

        public String getMusicApkName() {
            return this.apkName;
        }

        public String getPath() {
            return this.path;
        }

        public void setDataSize(long j10) {
            this.dataSize = j10;
        }

        public void setMusicApkName(String str) {
            this.apkName = str;
        }

        public void setPath(String str) {
            this.path = str;
        }
    }

    public static class MusicSetting {
        private String apkName;
        private List<String> conditions;
        private List<String> paths = new ArrayList();
        private List<String> blackList = new ArrayList();

        public static List<MusicSetting> getFromApkList(List<CBSDataBackup> list) {
            Context contextM1377a = C0213f.m1377a();
            ArrayList arrayList = new ArrayList();
            if (contextM1377a == null) {
                C11839m.m70687e(MusicBackup.TAG, "getFromApkList context is null");
                return arrayList;
            }
            PackageManager packageManager = contextM1377a.getPackageManager();
            if (packageManager == null) {
                C11839m.m70687e(MusicBackup.TAG, "getFromApkList context is null");
                return arrayList;
            }
            for (CBSDataBackup cBSDataBackup : list) {
                cBSDataBackup.changePathSelf();
                String cBSApkName = cBSDataBackup.getCBSApkName();
                try {
                    String str = packageManager.getPackageInfo(cBSApkName, 16384).versionName;
                    C11839m.m70686d(MusicBackup.TAG, cBSApkName + " versionName = " + str);
                    MusicSetting musicSettingMatchVersion = matchVersion(cBSDataBackup, str);
                    if (musicSettingMatchVersion == null) {
                        C11839m.m70689w(MusicBackup.TAG, "musicSetting is null");
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.addAll(cBSDataBackup.getFileSuffixes());
                        musicSettingMatchVersion.setConditions(arrayList2);
                        musicSettingMatchVersion.setMusicSettingApkName(cBSApkName);
                        arrayList.add(musicSettingMatchVersion);
                    }
                } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                    C11839m.m70689w(MusicBackup.TAG, cBSApkName + " is not found");
                }
            }
            return arrayList;
        }

        public static List<MusicSetting> getFromGalleryList(List<CBSDataBackup> list) {
            return null;
        }

        public static List<MusicSetting> getSettingFromDataList(List<CBSDataBackup> list) {
            ArrayList arrayList = new ArrayList();
            for (CBSDataBackup cBSDataBackup : list) {
                cBSDataBackup.changePathSelf();
                MusicSetting musicSetting = new MusicSetting();
                List<String> paths = musicSetting.getPaths();
                String cBSApkName = cBSDataBackup.getCBSApkName();
                pathInfosToSetting(cBSDataBackup.getDefaultInfo(), paths);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(cBSDataBackup.getFileSuffixes());
                musicSetting.setConditions(arrayList2);
                musicSetting.setMusicSettingApkName(cBSApkName);
                arrayList.add(musicSetting);
            }
            return arrayList;
        }

        public static List<MusicSetting> getSettingFromMediaList(List<CBSDataBackup> list) {
            ArrayList arrayList = new ArrayList();
            for (CBSDataBackup cBSDataBackup : list) {
                cBSDataBackup.changePathSelf();
                MusicSetting musicSetting = new MusicSetting();
                pathInfosToSetting(cBSDataBackup.getBackList(), musicSetting.getBlackList());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(cBSDataBackup.getFileSuffixes());
                musicSetting.setConditions(arrayList2);
                musicSetting.setMusicSettingApkName(MusicBackup.MEDIA);
                arrayList.add(musicSetting);
            }
            return arrayList;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static com.huawei.android.hicloud.cloudbackup.process.MusicBackup.MusicSetting matchVersion(com.huawei.hicloud.request.cbs.bean.CBSDataBackup r9, java.lang.String r10) {
            /*
                java.util.List r0 = r9.getPathInfos()
                com.huawei.android.hicloud.cloudbackup.process.MusicBackup$MusicSetting r1 = new com.huawei.android.hicloud.cloudbackup.process.MusicBackup$MusicSetting
                r1.<init>()
                java.util.List r2 = r1.getPaths()
                java.lang.String r3 = r9.getVerMix()
                int r3 = p514o9.C11829c.m70524I1(r10, r3)
                java.lang.String r4 = " ,versionName = "
                java.lang.String r5 = "MusicBackup"
                if (r3 > 0) goto L46
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r3 = "matchVersion less than mix version = "
                r0.append(r3)
                java.lang.String r3 = r9.getVerMix()
                r0.append(r3)
                r0.append(r4)
                r0.append(r10)
                java.lang.String r10 = " ,appId = "
                r0.append(r10)
                java.lang.String r10 = r9.getCBSApkName()
                r0.append(r10)
                java.lang.String r10 = r0.toString()
                p514o9.C11839m.m70688i(r5, r10)
                goto L96
            L46:
                java.util.Iterator r0 = r0.iterator()
                r3 = 0
            L4b:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L94
                java.lang.Object r6 = r0.next()
                com.huawei.hicloud.request.cbs.bean.CBSDataBackup$PathInfo r6 = (com.huawei.hicloud.request.cbs.bean.CBSDataBackup.PathInfo) r6
                java.lang.String r7 = r6.getPath()
                boolean r8 = android.text.TextUtils.isEmpty(r7)
                if (r8 == 0) goto L67
                java.lang.String r6 = "matchVersion paths is empty"
                p514o9.C11839m.m70689w(r5, r6)
                goto L4b
            L67:
                java.lang.String r6 = r6.getVersionCondition()
                java.lang.String r8 = com.huawei.android.hicloud.cloudbackup.process.MusicBackup.access$000(r6)
                boolean r8 = r10.matches(r8)
                if (r8 == 0) goto L4b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r8 = "matchVersion matched versionCondition = "
                r3.append(r8)
                r3.append(r6)
                r3.append(r4)
                r3.append(r10)
                java.lang.String r3 = r3.toString()
                p514o9.C11839m.m70686d(r5, r3)
                r2.add(r7)
                r3 = 1
                goto L4b
            L94:
                if (r3 != 0) goto L9d
            L96:
                java.util.List r9 = r9.getDefaultInfo()
                pathInfosToSetting(r9, r2)
            L9d:
                boolean r9 = r2.isEmpty()
                if (r9 == 0) goto La9
                java.lang.String r9 = "matchVersion settingPaths is emtpy:"
                p514o9.C11839m.m70689w(r5, r9)
                r1 = 0
            La9:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.MusicBackup.MusicSetting.matchVersion(com.huawei.hicloud.request.cbs.bean.CBSDataBackup, java.lang.String):com.huawei.android.hicloud.cloudbackup.process.MusicBackup$MusicSetting");
        }

        private static void pathInfosToSetting(List<CBSDataBackup.PathInfo> list, List<String> list2) {
            if (list == null) {
                return;
            }
            Iterator<CBSDataBackup.PathInfo> it = list.iterator();
            while (it.hasNext()) {
                String path = it.next().getPath();
                if (TextUtils.isEmpty(path)) {
                    C11839m.m70689w(MusicBackup.TAG, "pathInfosToSetting path is empty");
                } else {
                    list2.add(path);
                }
            }
        }

        public List<String> getBlackList() {
            return this.blackList;
        }

        public List<String> getConditions() {
            return this.conditions;
        }

        public String getMusicSettingApkName() {
            return this.apkName;
        }

        public List<String> getPaths() {
            return this.paths;
        }

        public void setBlackList(List<String> list) {
            this.blackList = list;
        }

        public void setConditions(List<String> list) {
            this.conditions = list;
        }

        public void setMusicSettingApkName(String str) {
            this.apkName = str;
        }

        public void setPaths(List<String> list) {
            this.paths = list;
        }

        public String toString() {
            return "MusicSetting{paths=" + this.paths + ", apkName='" + this.apkName + "', conditions=" + this.conditions + ", blackList=" + this.blackList + '}';
        }
    }

    public MusicBackup(String str, Context context, CBSInitParam cBSInitParam) {
        this.mLocation = str;
        this.mContext = context;
        this.mInitParam = cBSInitParam;
    }

    private StringBuffer buildSelection(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!list.contains("*")) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                String strReplaceAll = list.get(i10).replaceAll("\\*", "%").replaceAll("\\?", "_");
                if (i10 == list.size() - 1) {
                    stringBuffer.append("_display_name LIKE '" + strReplaceAll + "'");
                } else {
                    stringBuffer.append("_display_name LIKE '" + strReplaceAll + "' OR ");
                }
            }
        }
        return stringBuffer;
    }

    private boolean checkDevice() {
        NotificationConfig config;
        HNCloudConfig hNCloudConfig = new HNCloudConfig();
        if (hNCloudConfig.isExist()) {
            config = hNCloudConfig.getConfig();
        } else {
            HNLocalConfig hNLocalConfig = new HNLocalConfig();
            C11839m.m70688i(TAG, "checkDevice cloud config not exist");
            config = hNLocalConfig.getConfig();
        }
        if (config != null) {
            return matchDevice(config.getSupportMusicDevicelistType());
        }
        C11839m.m70689w(TAG, "checkDevice config is null");
        return false;
    }

    private void getScanedPaths(List<MusicSetting> list, List<String> list2) {
        Iterator<MusicSetting> it = list.iterator();
        while (it.hasNext()) {
            List<String> paths = it.next().getPaths();
            if (paths != null) {
                list2.addAll(paths);
            }
        }
    }

    private Map<String, List<MusicSetting>> getSetting() {
        ArrayList arrayList = new ArrayList();
        CBSInitParam cBSInitParam = this.mInitParam;
        if (cBSInitParam == null) {
            C11839m.m70687e(TAG, "getSetting cbsInitParam is null");
            return null;
        }
        arrayList.addAll(MusicSetting.getFromApkList(cBSInitParam.getApkDataBackupList()));
        arrayList.addAll(MusicSetting.getSettingFromDataList(this.mInitParam.getDataBackupList()));
        List<MusicSetting> settingFromMediaList = MusicSetting.getSettingFromMediaList(this.mInitParam.getMediaLibBackup());
        HashMap map = new HashMap();
        map.put("nomedia", arrayList);
        map.put(MEDIA, settingFromMediaList);
        C11839m.m70686d(TAG, "getSetting noMediaSetting = " + arrayList);
        C11839m.m70686d(TAG, "getSetting mediaSettings = " + settingFromMediaList);
        return map;
    }

    private List<MusicFileData> initMusicFiles() {
        Map<String, List<MusicSetting>> setting = getSetting();
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<MusicFileData> listScanFiles = scanFiles(setting);
        if (listScanFiles != null) {
            arrayList.addAll(listScanFiles);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        C11839m.m70688i(TAG, "initMusicFiles scanfiles total time = " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " ms");
        try {
            List<MusicFileData> listScanMediaFiles = scanMediaFiles(setting);
            if (listScanMediaFiles != null) {
                arrayList.addAll(listScanMediaFiles);
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "initMusicFiles scanMediaFiles error : " + e10.toString());
        }
        C11839m.m70688i(TAG, "initMusicFiles scanMediaFiles total time = " + (System.currentTimeMillis() - jCurrentTimeMillis2) + " ms");
        return arrayList;
    }

    private boolean isBlackFile(List<String> list, String str) {
        for (String str2 : list) {
            String strConvertToAbsolutePath = ICBUtil.convertToAbsolutePath(str2, this.mLocation);
            if (TextUtils.isEmpty(strConvertToAbsolutePath)) {
                C11839m.m70689w(TAG, "scanMediaFiles realPath is empty, blackPath = " + str2);
            } else if (str.startsWith(strConvertToAbsolutePath)) {
                return true;
            }
        }
        return false;
    }

    private boolean isScaned(List<String> list, String str) {
        for (String str2 : list) {
            String strConvertToAbsolutePath = ICBUtil.convertToAbsolutePath(str2, this.mLocation);
            if (TextUtils.isEmpty(strConvertToAbsolutePath)) {
                C11839m.m70689w(TAG, "scanMediaFiles realPath is empty, path = " + str2);
            } else if (str.startsWith(strConvertToAbsolutePath)) {
                return true;
            }
        }
        return false;
    }

    private boolean matchDevice(List<String> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70689w(TAG, "matchDevice config is empty");
            return false;
        }
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w(TAG, "matchDevice phoneType is empty");
            return false;
        }
        C11839m.m70686d(TAG, "matchDevice cloud phoneTypes " + list + " ,current phoneType = " + str);
        for (String str2 : list) {
            if (TextUtils.isEmpty(str2)) {
                C11839m.m70687e(TAG, "device is empty");
            } else if (str.matches(patternToExpression(str2))) {
                C11839m.m70688i(TAG, "matchDevice config = " + list);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String patternToExpression(String str) {
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

    private List<MusicFileData> scanDirectory(File file, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (!file.exists() || !file.isDirectory()) {
            C11839m.m70689w(TAG, "This is not a dictionary!");
            return null;
        }
        File[] fileArrM63440f = C10278a.m63440f(file);
        if (fileArrM63440f == null || fileArrM63440f.length == 0) {
            C11839m.m70689w(TAG, "This is an empty dictionary path = " + C10279b.m63452a(file));
            return null;
        }
        for (File file2 : fileArrM63440f) {
            MusicFileData musicFileData = new MusicFileData();
            if (!file2.isDirectory()) {
                String name = file2.getName();
                long length = file2.length();
                if (length > 0) {
                    Iterator<String> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (name.matches(patternToExpression(it.next()))) {
                            musicFileData.setMusicApkName(str);
                            musicFileData.setDataSize(length);
                            musicFileData.setPath(C10279b.m63452a(file2));
                            arrayList.add(musicFileData);
                            break;
                        }
                    }
                } else {
                    C11839m.m70689w(TAG, "scanDirectory file = " + C10279b.m63452a(file2) + " length is 0.");
                }
            } else {
                List<MusicFileData> listScanDirectory = scanDirectory(file2, list, str);
                if (listScanDirectory != null && !listScanDirectory.isEmpty()) {
                    arrayList.addAll(listScanDirectory);
                }
            }
        }
        return arrayList;
    }

    private List<MusicFileData> scanMediaFiles(Map<String, List<MusicSetting>> map) throws C9721b {
        if (map == null || map.isEmpty()) {
            C11839m.m70687e(TAG, "scanMediaFiles settingmap is empty");
            return null;
        }
        return scanMediaFiles(map.get(MEDIA), map.get("nomedia"));
    }

    public String currentId() {
        return "music";
    }

    public List<MusicFileData> getAllMusicMetas() {
        if (this.mDeviceMatch) {
            return initMusicFiles();
        }
        C11839m.m70688i(TAG, "getAllMusicMetas device not match");
        return null;
    }

    public SnapshotBackupMeta getMusicBackupMeta() {
        if (!this.mDeviceMatch) {
            C11839m.m70688i(TAG, "getBackupStatus device not match");
            return null;
        }
        List<MusicFileData> listInitMusicFiles = initMusicFiles();
        SnapshotBackupMeta snapshotBackupMeta = new SnapshotBackupMeta();
        if (listInitMusicFiles.isEmpty()) {
            return null;
        }
        int size = listInitMusicFiles.size();
        Iterator<MusicFileData> it = listInitMusicFiles.iterator();
        long dataSize = 0;
        while (it.hasNext()) {
            dataSize += it.next().getDataSize();
        }
        snapshotBackupMeta.setData(currentId());
        snapshotBackupMeta.setSize(dataSize);
        snapshotBackupMeta.setCount(size);
        C11839m.m70688i(TAG, "getMusicBackupMeta datasize:" + dataSize);
        return snapshotBackupMeta;
    }

    public C12161c getMusicCloudBackupV3Meta() {
        if (!this.mDeviceMatch) {
            C11839m.m70688i(TAG, "getBackupStatus device not match");
            return null;
        }
        List<MusicFileData> listInitMusicFiles = initMusicFiles();
        C12161c c12161c = new C12161c();
        if (listInitMusicFiles.isEmpty()) {
            return null;
        }
        int size = listInitMusicFiles.size();
        Iterator<MusicFileData> it = listInitMusicFiles.iterator();
        long dataSize = 0;
        while (it.hasNext()) {
            dataSize += it.next().getDataSize();
        }
        c12161c.m72956L(currentId());
        c12161c.m72996n0(dataSize);
        c12161c.m72963S(size);
        C11839m.m70688i(TAG, "getMusicCloudBackupV3Meta datasize:" + dataSize);
        return c12161c;
    }

    public void init() {
        this.mDeviceMatch = checkDevice();
    }

    public List<MusicFileData> scanFiles(Map<String, List<MusicSetting>> map) {
        if (map == null || map.isEmpty()) {
            C11839m.m70687e(TAG, "scanFiles settingmap is empty");
            return null;
        }
        List<MusicSetting> list = map.get("nomedia");
        if (list != null && !list.isEmpty()) {
            return scanFiles(list);
        }
        C11839m.m70687e(TAG, "scanFiles nomedia settinglist is empty");
        return null;
    }

    public List<MusicFileData> scanMediaFiles(List<MusicSetting> list, List<MusicSetting> list2) throws C9721b {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        if (list2 == null || list2.isEmpty()) {
            C11839m.m70688i(TAG, "scanMediaFiles settings is empty");
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        getScanedPaths(list2, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (MusicSetting musicSetting : list) {
            List<String> blackList = musicSetting.getBlackList();
            if (blackList != null) {
                arrayList3.addAll(blackList);
            }
            List<String> conditions = musicSetting.getConditions();
            if (conditions != null) {
                arrayList4.addAll(conditions);
            }
        }
        C13465e.m81052f().m81066o("musicBlackList", arrayList3);
        List<String> blackPathBackup = CloudBackupConstant.MusicFileFilterPath.getBlackPathBackup();
        arrayList3.removeAll(blackPathBackup);
        arrayList3.addAll(blackPathBackup);
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] strArr = {"_id", "title", "_data", "mime_type", "_display_name"};
        StringBuffer stringBufferBuildSelection = buildSelection(arrayList4);
        C11839m.m70686d(TAG, "scanMediaFiles selection = " + stringBufferBuildSelection.toString());
        try {
            cursorQuery = this.mContext.getContentResolver().query(uri, strArr, TextUtils.isEmpty(stringBufferBuildSelection.toString()) ? null : stringBufferBuildSelection.toString(), null, null);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "scanMediaFiles error = " + e10.toString());
            cursorQuery = null;
        }
        if (cursorQuery == null) {
            C11839m.m70687e(TAG, "scanMediaFiles cursor is null");
            return null;
        }
        while (cursorQuery.moveToNext()) {
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
            File fileM63442h = C10278a.m63442h(string);
            String strM63452a = C10279b.m63452a(fileM63442h);
            C11839m.m70686d(TAG, "scanMediaFiles data = " + string);
            if (!fileM63442h.exists()) {
                C11839m.m70689w(TAG, "scanMediaFiles file is not exists fpath = " + string);
            } else {
                long length = fileM63442h.length();
                if (length <= 0) {
                    C11839m.m70689w(TAG, "scanMediaFiles file = " + strM63452a + "length <= 0");
                } else {
                    MusicFileData musicFileData = new MusicFileData();
                    boolean zIsScaned = isScaned(arrayList2, string);
                    if (!isBlackFile(arrayList3, strM63452a) && !zIsScaned) {
                        musicFileData.setMusicApkName(MEDIA);
                        musicFileData.setDataSize(length);
                        musicFileData.setPath(strM63452a);
                        arrayList.add(musicFileData);
                    }
                }
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    public List<MusicFileData> scanFiles(List<MusicSetting> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            C11839m.m70688i(TAG, "scanFiles setting is null");
            return null;
        }
        for (MusicSetting musicSetting : list) {
            List<String> paths = musicSetting.getPaths();
            List<String> conditions = musicSetting.getConditions();
            String musicSettingApkName = musicSetting.getMusicSettingApkName();
            for (String str : paths) {
                String strConvertToAbsolutePath = ICBUtil.convertToAbsolutePath(str, this.mLocation);
                if (TextUtils.isEmpty(strConvertToAbsolutePath)) {
                    C11839m.m70689w(TAG, "scanFiles realPath is empty, filePath = " + str);
                } else {
                    List<MusicFileData> listScanDirectory = scanDirectory(C10278a.m63442h(strConvertToAbsolutePath), conditions, musicSettingApkName);
                    if (listScanDirectory != null && !listScanDirectory.isEmpty()) {
                        arrayList.addAll(listScanDirectory);
                    }
                }
            }
        }
        C11839m.m70688i(TAG, "MusicBackup file list success!");
        return arrayList;
    }
}
