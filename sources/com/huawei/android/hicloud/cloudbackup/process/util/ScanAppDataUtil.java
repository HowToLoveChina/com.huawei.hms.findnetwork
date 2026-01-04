package com.huawei.android.hicloud.cloudbackup.process.util;

import am.InterfaceC0275i1;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupPathInfo;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.model.ScanMediaLibData;
import com.huawei.android.hicloud.cloudbackup.model.VirtualAppFileData;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.task.ScanMediaCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0221j;
import p015ak.C0224k0;
import p015ak.C0241z;
import p514o9.C11839m;
import p618rm.C12538b;
import p618rm.C12565k;
import p618rm.C12571m;
import p618rm.C12583q;
import p618rm.C12585q1;
import p618rm.C12586r;

/* loaded from: classes2.dex */
public class ScanAppDataUtil {
    public static final String ANDROID_DATA = "Android/data";
    private static final String DATA_PATH = "/data/data/";
    public static final String EMUI11_PREFIX = "11.0";
    public static final int MAX_FIXED_POOL_THREADS_SIZE = 4;
    public static final String MEDIALIB = "mediaLib";
    private static final String PACKAGE_NAME_FLAG = "$(packagename)";
    private static final String TAG = "ScanAppDataUtil";
    private final String mAppId;
    private List<CloudBackupPathInfo> mCloudBackupExclude;
    private List<CloudBackupPathInfo> mCloudBackupInclude;
    private final String mOriginAppId;
    private final int uid;

    public class FileSearchTask implements Callable<SearchResult> {
        private static final String TAG = "FileSearchTask";
        private CloudBackupAppDataUtil appDataUtil;
        final ExecutorCompletionService completionService;
        private int fileCount;
        private List<SearchResult> results;
        private String searchFilePath;
        final AtomicInteger threadCount;
        private long totalSize;

        public FileSearchTask(ExecutorCompletionService executorCompletionService, String str, AtomicInteger atomicInteger, CloudBackupAppDataUtil cloudBackupAppDataUtil, List<SearchResult> list) {
            this.completionService = executorCompletionService;
            this.threadCount = atomicInteger;
            this.searchFilePath = str;
            this.appDataUtil = cloudBackupAppDataUtil;
            this.results = list;
        }

        private boolean isThreadPoolFree() {
            return this.threadCount.get() <= 4;
        }

        public void startSearch(String str) {
            File fileM63442h = C10278a.m63442h(str);
            if (!fileM63442h.exists()) {
                C11839m.m70689w(TAG, "file is not exists, scanFiles fail path = " + str);
                return;
            }
            if (this.appDataUtil.isFilterFile(fileM63442h)) {
                C11839m.m70688i(TAG, "get App Data Size, filter file: " + str);
                return;
            }
            if (!fileM63442h.isDirectory()) {
                this.totalSize += fileM63442h.length();
                this.fileCount++;
                return;
            }
            File[] fileArrListFiles = fileM63442h.listFiles();
            if (fileArrListFiles == null) {
                C11839m.m70688i(TAG, "get App Data Size, file is null directory: " + str);
                return;
            }
            C11839m.m70686d(TAG, "get App Data Size, file length = " + fileArrListFiles.length);
            for (File file : fileArrListFiles) {
                String strM63452a = C10279b.m63452a(file);
                if (file.isDirectory() && isThreadPoolFree()) {
                    File[] fileArrListFiles2 = file.listFiles();
                    if (fileArrListFiles2 != null && fileArrListFiles2.length > 0) {
                        ScanAppDataUtil.this.addScanTask(strM63452a, this.completionService, this.appDataUtil, this.threadCount, this.results);
                    }
                } else {
                    startSearch(strM63452a);
                }
            }
        }

        @Override // java.util.concurrent.Callable
        public SearchResult call() {
            startSearch(this.searchFilePath);
            SearchResult searchResult = new SearchResult(this.fileCount, this.totalSize);
            this.results.add(searchResult);
            C11839m.m70686d(TAG, "remove scan task, file: " + this.searchFilePath);
            this.threadCount.decrementAndGet();
            return searchResult;
        }
    }

    public static class SearchResult {
        private int totalCount;
        private long totalSize;

        public SearchResult(int i10, long j10) {
            this.totalCount = i10;
            this.totalSize = j10;
        }

        public int getTotalCount() {
            return this.totalCount;
        }

        public long getTotalSize() {
            return this.totalSize;
        }

        public void setTotalCount(int i10) {
            this.totalCount = i10;
        }

        public void setTotalSize(long j10) {
            this.totalSize = j10;
        }
    }

    public ScanAppDataUtil(String str, List<CloudBackupPathInfo> list, List<CloudBackupPathInfo> list2) {
        this(str, 0, str, list, list2);
    }

    public void addScanTask(String str, ExecutorCompletionService executorCompletionService, CloudBackupAppDataUtil cloudBackupAppDataUtil, AtomicInteger atomicInteger, List<SearchResult> list) {
        C11839m.m70686d(TAG, "add scan task, file: " + str);
        atomicInteger.incrementAndGet();
        executorCompletionService.submit(new FileSearchTask(executorCompletionService, str, atomicInteger, cloudBackupAppDataUtil, list));
    }

    private static void backupByPmsAndroidDataPathToWritePath(List<String> list, List<String> list2, String str, int i10, List<String> list3, List<String> list4) {
        for (String str2 : list) {
            if (C12583q.m75654H(i10, str2, str)) {
                list3.add(SplitAppUtil.splitAppDestAndroidDataPathToWritePath(str2, i10));
            } else {
                list3.add(str2);
            }
        }
        if (list2 != null) {
            for (String str3 : list2) {
                if (C12583q.m75654H(i10, str3, str)) {
                    list4.add(SplitAppUtil.splitAppDestAndroidDataPathToWritePath(str3, i10));
                } else {
                    list4.add(str3);
                }
            }
        }
    }

    private void countFiles(File file, final CloudBackupAppDataUtil cloudBackupAppDataUtil, final long[] jArr) throws IOException {
        try {
            Stream<Path> streamWalk = Files.walk(Paths.get(C10279b.m63452a(file), new String[0]), new FileVisitOption[0]);
            try {
                Objects.requireNonNull(cloudBackupAppDataUtil);
                streamWalk.filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.w
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return cloudBackupAppDataUtil.filterPath((Path) obj);
                    }
                }).forEach(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.x
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ScanAppDataUtil.lambda$countFiles$4(jArr, (Path) obj);
                    }
                });
                streamWalk.close();
            } finally {
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "countFiles error: " + e10.getMessage());
        }
    }

    private void countFilesInfo(File file, CloudBackupAppDataUtil cloudBackupAppDataUtil, long[] jArr) {
        if (!file.exists()) {
            C11839m.m70689w(TAG, "file is not exists, scanFiles fail path = " + C10279b.m63452a(file));
            return;
        }
        if (cloudBackupAppDataUtil.isFilterFile(file)) {
            C11839m.m70686d(TAG, "get App Data Size, filter file:" + C10279b.m63452a(file));
            return;
        }
        if (!file.isDirectory()) {
            jArr[0] = jArr[0] + 1;
            jArr[1] = jArr[1] + file.length();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2 != null) {
                    countFilesInfo(file2, cloudBackupAppDataUtil, jArr);
                }
            }
        }
    }

    public static void executePmsMoveProcess(String str) {
        if (C12565k.m75529o()) {
            String str2 = C0213f.m1377a().getFilesDir() + "";
            BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(C0213f.m1377a(), (ICallback) null, str2);
            String str3 = backupRestoreUtil.checkLocation(str2) + "/pmsmove/";
            File fileM63442h = C10278a.m63442h(str3);
            if (!fileM63442h.exists() && !fileM63442h.mkdir()) {
                C11839m.m70688i(TAG, "pms move dir not exists, could not execute pms move.");
                return;
            }
            if (C10278a.m63442h(str).exists() && fileM63442h.exists()) {
                C11839m.m70688i(TAG, "backup dir exists, execute pms move: " + str);
                backupRestoreUtil.move(CloudBackupConstant.Command.PMS_OPTION_DIR, str, str3);
            }
            C12571m.m75542d(str3);
        }
    }

    public static long get3rdAppDataDirSize(String str, int i10) {
        long dirSize;
        long packageSize = getPackageSize(str, i10);
        String str2 = ICBUtil.getTheAndroidDataCachePath(str, i10) + File.separator;
        File fileM63442h = C10278a.m63442h(str2);
        if (i10 == 0 || !SplitAppUtil.notSupportSplitAndroidScanVersion()) {
            dirSize = getDirSize(fileM63442h);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            dirSize = getFileCountAndSizeByPMS(arrayList, null, str, i10)[1];
        }
        C11839m.m70688i(TAG, "get3rdAppDataDirSize, appId :" + str + " ,uid: " + i10 + ", in data path: " + packageSize + ", in android:" + dirSize);
        return packageSize - dirSize;
    }

    private List<String> getAllExcludePath(CloudBackupAppDataUtil cloudBackupAppDataUtil) {
        HashSet hashSet = new HashSet();
        cloudBackupAppDataUtil.changeToSeparaSetting(this.uid);
        List<CloudBackupPathInfo> list = cloudBackupAppDataUtil.getmCloudBackupExclude();
        String strM75670f = C12583q.m75670f(this.uid, ICBUtil.ANDROID_DATA, this.mOriginAppId);
        Iterator<CloudBackupPathInfo> it = list.iterator();
        while (it.hasNext()) {
            for (String str : it.next().getPaths()) {
                if (str.startsWith(strM75670f)) {
                    hashSet.add(str);
                }
            }
        }
        String strM1186L = C0209d.m1186L();
        if (strM1186L.startsWith(EMUI11_PREFIX) || C0209d.m1273k1() || C0224k0.m1567v()) {
            hashSet.add(C12583q.m75670f(this.uid, ICBUtil.ANDROID_MEDIA, this.mOriginAppId));
        }
        if (strM1186L.startsWith(EMUI11_PREFIX) || C0224k0.m1567v()) {
            hashSet.add(C12583q.m75670f(this.uid, ICBUtil.ANDROID_SANDBOX, this.mOriginAppId));
        }
        return new ArrayList(hashSet);
    }

    private long getAllExcludeSize(CloudBackupAppDataUtil cloudBackupAppDataUtil, boolean z10) {
        List<String> allExcludePath = getAllExcludePath(cloudBackupAppDataUtil);
        if (z10) {
            return getFileCountAndSizeByPMS(allExcludePath, null, this.mOriginAppId, this.uid)[1];
        }
        final AtomicLong atomicLong = new AtomicLong(0L);
        allExcludePath.forEach(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.u
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ScanAppDataUtil.lambda$getAllExcludeSize$1(atomicLong, (String) obj);
            }
        });
        return 0L;
    }

    public static long getDirSize(File file) {
        long dirSize = 0;
        if (!file.exists()) {
            C11839m.m70689w(TAG, "file is not exists, scanFiles fail path = " + C10279b.m63452a(file));
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            if (file2 != null) {
                dirSize += getDirSize(file2);
            }
        }
        return dirSize;
    }

    public static long getDirSizeFilterFile(CloudBackupAppDataUtil cloudBackupAppDataUtil, File file) {
        long dirSizeFilterFile = 0;
        if (!file.exists()) {
            C11839m.m70689w(TAG, "file is not exists, scanFiles fail path = " + C10279b.m63452a(file));
            return 0L;
        }
        if (cloudBackupAppDataUtil.isFilterFile(file)) {
            C11839m.m70688i(TAG, "get App Data Size, filter file: " + file);
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            if (file2 != null) {
                dirSizeFilterFile += getDirSizeFilterFile(cloudBackupAppDataUtil, file2);
            }
        }
        return dirSizeFilterFile;
    }

    private long[] getFileCountAndSize(CloudBackupAppDataUtil cloudBackupAppDataUtil, List<String> list) throws IOException {
        long[] jArr = new long[2];
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            countFiles(C10278a.m63442h(it.next()), cloudBackupAppDataUtil, jArr);
        }
        C11839m.m70688i(TAG, "getFileCountAndSize cost time " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", scan files:" + jArr[0] + ", scan size: " + jArr[1]);
        return jArr;
    }

    private static long[] getFileCountAndSizeByPMS(List<String> list, List<String> list2, String str, int i10) {
        final long[] jArr = new long[2];
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (i10 != 0) {
            backupByPmsAndroidDataPathToWritePath(list, list2, str, i10, arrayList, arrayList2);
        }
        Optional.ofNullable(new BackupRestoreUtil(C0213f.m1377a()).getBrief(CloudBackupConstant.Command.PMS_OPTION_FILE, arrayList, arrayList2, i10, str)).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.v
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ScanAppDataUtil.lambda$getFileCountAndSizeByPMS$3(jArr, (BackupRestoreUtil.BriefSupplier) obj);
            }
        });
        C11839m.m70688i(TAG, "getFileCountAndSizeByPMS cost time " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", scan files:" + jArr[0] + " size: " + jArr[1]);
        return jArr;
    }

    private static long getPackageSize(String str, int i10) {
        return AppDataSizeUtil.getPackageSize(C0213f.m1377a(), str, i10);
    }

    private Uri getUri(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 4 ? MediaStore.Files.getContentUri("external") : MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    private VirtualAppFileData getVirtualAppFileData() {
        VirtualAppFileData virtualAppFileData = new VirtualAppFileData();
        ScanMediaLibData scanMediaData = getScanMediaData();
        return scanMediaData.isScanMedia() ? getScanMediaFileData(scanMediaData.getMimeType()) : virtualAppFileData;
    }

    private boolean isMatchPath(String str) {
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        Iterator<CloudBackupPathInfo> it = this.mCloudBackupExclude.iterator();
        while (it.hasNext()) {
            Iterator<String> it2 = it.next().getPaths().iterator();
            while (it2.hasNext()) {
                if (str.startsWith(ICBUtil.convertToAbsolutePath(it2.next(), C12586r.m75710a()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ void lambda$countFiles$4(long[] jArr, Path path) {
        try {
            jArr[0] = jArr[0] + 1;
            jArr[1] = jArr[1] + Files.size(path);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "get file size error: " + e10.getMessage());
        }
    }

    public static /* synthetic */ void lambda$getAllExcludeSize$1(AtomicLong atomicLong, String str) {
        atomicLong.set(atomicLong.get() + getDirSize(C10278a.m63442h(str)));
    }

    public static /* synthetic */ void lambda$getFileCountAndSizeByPMS$2(long[] jArr, String[] strArr) {
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + C0241z.m1688f(strArr[3]);
    }

    public static /* synthetic */ void lambda$getFileCountAndSizeByPMS$3(final long[] jArr, BackupRestoreUtil.BriefSupplier briefSupplier) {
        if (briefSupplier.isValid() && briefSupplier.isSupport()) {
            try {
                briefSupplier.traverse(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.y
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ScanAppDataUtil.lambda$getFileCountAndSizeByPMS$2(jArr, (String[]) obj);
                    }
                });
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "getFileCountAndSizeByPMS :" + e10.getMessage());
            }
        }
        briefSupplier.close();
    }

    public static /* synthetic */ void lambda$initScanDir$0(List list, BackupRestoreUtil.BriefSupplier briefSupplier, BackupRestoreUtil.BriefSupplier briefSupplier2) {
        if (briefSupplier2.isValid() && briefSupplier2.isSupport()) {
            try {
                briefSupplier2.checkExists(list);
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "initScanDir traverse exception: " + e10.getMessage());
            }
        }
        briefSupplier.close();
    }

    private boolean needFilter(String str, List<String> list) {
        String lowerCase = ANDROID_DATA.toLowerCase(Locale.getDefault());
        if (str.contains(ANDROID_DATA)) {
            String strReplace = str.replace(ANDROID_DATA, lowerCase);
            if (list.contains(str) || list.contains(strReplace)) {
                return true;
            }
        }
        if (str.contains(lowerCase)) {
            String strReplace2 = str.replace(lowerCase, ANDROID_DATA);
            if (list.contains(str) || list.contains(strReplace2)) {
                return true;
            }
        }
        return list.contains(str);
    }

    private static void originAppDataRenameToRealPath(String str, String str2, String str3) throws C9721b {
        File fileM63443i = C10278a.m63443i(str, str3);
        File fileM63443i2 = C10278a.m63443i(str, str2);
        File fileM63443i3 = C10278a.m63443i(str, str3 + ".txt");
        File fileM63443i4 = C10278a.m63443i(str, str2 + ".txt");
        SplitAppUtil.deleteDir(fileM63443i2);
        SplitAppUtil.deleteDir(fileM63443i4);
        if (!fileM63443i.renameTo(fileM63443i2)) {
            throw new C9721b(2101, "currentOriginDir.renameTo(realRenameToDir) failed: " + C10279b.m63452a(fileM63443i2));
        }
        if (fileM63443i3.renameTo(fileM63443i4)) {
            return;
        }
        throw new C9721b(2101, "currentOriginTxtFile.renameTo(realRenameToTxtFile) failed: " + C10279b.m63452a(fileM63443i4));
    }

    public static boolean scanDir(List<File> list, String str) {
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.exists()) {
            return false;
        }
        if (!fileM63442h.isDirectory()) {
            list.add(fileM63442h);
            return true;
        }
        File[] fileArrListFiles = fileM63442h.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        for (File file : fileArrListFiles) {
            String strM63452a = C10279b.m63452a(file);
            if (!scanDir(list, strM63452a)) {
                C11839m.m70689w(TAG, "scanFiles fail path = " + strM63452a);
            }
        }
        return true;
    }

    public void appDataPrepare(String str, CacheTask cacheTask, String str2, String str3, InterfaceC0275i1 interfaceC0275i1) throws C9721b {
        File fileM63442h = C10278a.m63442h(str);
        boolean zExists = fileM63442h.exists();
        String[] list = fileM63442h.list();
        if (zExists && (list == null || list.length > 0)) {
            executePmsMoveProcess(str);
        }
        boolean zExists2 = fileM63442h.exists();
        String[] list2 = fileM63442h.list();
        if (zExists2 && (list2 == null || list2.length > 0)) {
            throw new C9721b(1020, "prepare backup tempDir delete failed appId = " + str2);
        }
        BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(C0213f.m1377a(), cacheTask, str, interfaceC0275i1);
        List<String> dataPath = getDataPath(str3);
        if (dataPath.isEmpty()) {
            C11839m.m70689w(TAG, "appDataPrepare v3 dataPath is empty " + str2);
            return;
        }
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70689w(TAG, "tempDir mkdir error " + str);
        }
        for (String str4 : dataPath) {
            ICBUtil.checkModuleNeedLocalSize(str2, str3, true);
            if (backupRestoreUtil.pmsBackup(str2, str4) != 0) {
                ICBUtil.checkDataLocalLimitSpace(str2 + " local size not enough v3 left space: ");
                throw new C9721b(2101, "prepare backup v3 data failed appId = " + str2 + " datapath = " + str4);
            }
        }
        if (!TextUtils.equals(str3, str2)) {
            originAppDataRenameToRealPath(str, str2, str3);
        }
        C11839m.m70688i(TAG, "appDataPrepare end, " + str2);
    }

    public long get3rdAppDataSize(CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        long sdcardFileSize = getSdcardFileSize(cloudBackupAppDataUtil);
        long packageSize = getPackageSize(this.mOriginAppId, this.uid);
        long allExcludeSize = getAllExcludeSize(cloudBackupAppDataUtil, PmsUtils.isSupportNewRYFeature() || (this.uid != 0 && SplitAppUtil.notSupportSplitAndroidScanVersion()));
        C11839m.m70688i(TAG, "get 3rd app data size, mAppId :" + this.mOriginAppId + ", uid :" + this.uid + ", in data path: " + packageSize + ", in sd path:" + sdcardFileSize);
        long j10 = (sdcardFileSize + packageSize) - allExcludeSize;
        if (j10 < 0) {
            return 0L;
        }
        return j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long[] get3rdAppDataSizeInfo(com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil r19, boolean r20, com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem r21, com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil r22) throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil.get3rdAppDataSizeInfo(com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil, boolean, com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem, com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil):long[]");
    }

    public List<String> getAndroidDataPaths(int i10) throws C9721b {
        Pair<List<String>, List<String>> pairInitScanDir = initScanDir(i10);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection) pairInitScanDir.first);
        return arrayList;
    }

    public List<String> getDataPath(String str) throws C9721b {
        return getDataPath(str, this.uid);
    }

    public List<String> getExcludeAndroidDataPathWithoutRegex(String str) throws C9721b {
        ArrayList arrayList = new ArrayList();
        List<CloudBackupPathInfo> list = this.mCloudBackupExclude;
        if (list == null) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getExcludeDataPathWithoutRegex error mExclude is null");
        }
        Iterator<CloudBackupPathInfo> it = list.iterator();
        while (it.hasNext()) {
            for (String str2 : it.next().getPaths()) {
                if (str2.contains(ANDROID_DATA)) {
                    arrayList.add(str2.replace(PACKAGE_NAME_FLAG, this.mOriginAppId));
                }
            }
        }
        C11839m.m70686d(TAG, str + " getExcludeDataPathWithoutRegex " + arrayList);
        return arrayList;
    }

    public List<String> getExcludeDataPathWithRegex(String str) throws C9721b {
        ArrayList arrayList = new ArrayList();
        List<CloudBackupPathInfo> list = this.mCloudBackupExclude;
        if (list == null) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getExcludeDataPathWithRegex error mExclude is null");
        }
        Iterator<CloudBackupPathInfo> it = list.iterator();
        while (it.hasNext()) {
            for (String str2 : it.next().getPaths()) {
                if (C12585q1.m75697g(str2)) {
                    arrayList.add(str2.replace(PACKAGE_NAME_FLAG, str));
                }
            }
        }
        C11839m.m70686d(TAG, str + " getExcludeDataPathWithRegex " + arrayList);
        return arrayList;
    }

    public List<String> getExcludeDataPathWithoutRegex(String str) throws C9721b {
        ArrayList arrayList = new ArrayList();
        List<CloudBackupPathInfo> list = this.mCloudBackupExclude;
        if (list == null) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getExcludeDataPathWithoutRegex error mExclude is null");
        }
        Iterator<CloudBackupPathInfo> it = list.iterator();
        while (it.hasNext()) {
            for (String str2 : it.next().getPaths()) {
                if (str2.startsWith("/data/data/")) {
                    arrayList.add(str2.replace(PACKAGE_NAME_FLAG, str));
                }
            }
        }
        C11839m.m70686d(TAG, str + " getExcludeDataPathWithoutRegex " + arrayList);
        return arrayList;
    }

    public Cursor getScanMediaCursor(int i10) {
        String[] strArr = {"_id", "title", "_data", "mime_type", "_display_name"};
        ContentResolver contentResolver = C0213f.m1377a().getContentResolver();
        try {
            Uri uri = getUri(i10);
            C11839m.m70688i(TAG, "getScanMediaCursor uri " + uri);
            if (uri == null) {
                return null;
            }
            List<String> listM75480c = C12538b.m75480c(i10);
            C11839m.m70688i(TAG, "getScanMediaCursor selectionArgList " + listM75480c.toString());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("( ");
            for (int i11 = 0; i11 < listM75480c.size(); i11++) {
                if (i11 == listM75480c.size() - 1) {
                    stringBuffer.append("mime_type= ?");
                } else {
                    stringBuffer.append("mime_type= ? OR ");
                }
            }
            if (5 == i10) {
                stringBuffer.append(" OR _data LIKE '%.rar'");
            }
            stringBuffer.append(" )");
            if (this.mCloudBackupExclude == null) {
                return null;
            }
            stringBuffer.append(" AND _size > 0 ");
            Iterator<CloudBackupPathInfo> it = this.mCloudBackupExclude.iterator();
            while (it.hasNext()) {
                List<String> paths = it.next().getPaths();
                for (int i12 = 0; i12 < paths.size(); i12++) {
                    String str = paths.get(i12);
                    if (!TextUtils.isEmpty(str)) {
                        stringBuffer.append(" AND (_data NOT LIKE ? )");
                        listM75480c.add("%" + str + "%");
                    }
                }
            }
            String[] strArr2 = new String[listM75480c.size()];
            for (int i13 = 0; i13 < listM75480c.size(); i13++) {
                strArr2[i13] = listM75480c.get(i13);
            }
            return contentResolver.query(uri, strArr, stringBuffer.toString(), strArr2, null);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "scanMediaFiles error = " + e10.toString());
            return null;
        }
    }

    public ScanMediaLibData getScanMediaData() {
        ScanMediaLibData scanMediaLibData = new ScanMediaLibData();
        HashSet hashSet = new HashSet();
        boolean z10 = false;
        for (CloudBackupPathInfo cloudBackupPathInfo : this.mCloudBackupInclude) {
            Iterator<String> it = cloudBackupPathInfo.getPaths().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().indexOf(MEDIALIB) != -1) {
                    List<Integer> mimeTypes = cloudBackupPathInfo.getMimeTypes();
                    if (mimeTypes != null) {
                        hashSet.addAll(mimeTypes);
                    }
                    z10 = true;
                }
            }
        }
        scanMediaLibData.setScanMedia(z10);
        scanMediaLibData.setMimeType(new ArrayList(hashSet));
        return scanMediaLibData;
    }

    public VirtualAppFileData getScanMediaFileData(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return new VirtualAppFileData();
        }
        int i10 = 0;
        long j10 = 0;
        for (Integer num : list) {
            Cursor scanMediaCursor = getScanMediaCursor(num.intValue());
            if (scanMediaCursor == null) {
                C11839m.m70689w(TAG, "scanMediaFiles cursor is null, mimeType = " + num);
            } else {
                while (scanMediaCursor.moveToNext()) {
                    try {
                        try {
                            String string = scanMediaCursor.getString(scanMediaCursor.getColumnIndex("_data"));
                            File fileM63442h = C10278a.m63442h(string);
                            C11839m.m70686d(TAG, "file has been scanned, file name is" + string);
                            if (!fileM63442h.exists()) {
                                C11839m.m70689w(TAG, "scanMediaFiles file is not exists fpath = " + string);
                            } else if (isMatchPath(fileM63442h.getCanonicalPath())) {
                                C11839m.m70688i(TAG, "getScanMediaFileData, filter file: " + string);
                            } else if (isMatchMimeType(fileM63442h, list)) {
                                String strM1501k = C0221j.m1501k();
                                if (TextUtils.isEmpty(strM1501k) || TextUtils.isEmpty(string) || !string.startsWith(strM1501k)) {
                                    long length = fileM63442h.length();
                                    if (length <= 0) {
                                        C11839m.m70689w(TAG, "scanMediaFiles file = " + C10279b.m63452a(fileM63442h) + "length <= 0");
                                    } else {
                                        j10 += length;
                                        i10++;
                                    }
                                } else {
                                    C11839m.m70688i(TAG, "getScanMediaFileData, appClonePath filter file: " + string);
                                }
                            } else {
                                C11839m.m70688i(TAG, "getScanMediaFileData, mimeTypes filter file: " + string);
                            }
                        } catch (Exception e10) {
                            C11839m.m70687e(TAG, "getScanMediaFileSize exception = " + e10.toString());
                        }
                    } catch (Throwable th2) {
                        scanMediaCursor.close();
                        throw th2;
                    }
                }
                scanMediaCursor.close();
            }
        }
        VirtualAppFileData virtualAppFileData = new VirtualAppFileData();
        virtualAppFileData.setFileCount(i10);
        virtualAppFileData.setFileSize(j10);
        return virtualAppFileData;
    }

    public long[] getSdcardAndAndroidDataInfo(CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        Pair<List<String>, List<String>> pairInitScanDir = initScanDir(this.uid);
        List list = (List) pairInitScanDir.first;
        List<String> list2 = (List) pairInitScanDir.second;
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(list);
        arrayList.addAll(list2);
        C11839m.m70688i(TAG, "get 3rd app sdcard data size, appId: " + this.mAppId + ", scanDir size: " + arrayList.size());
        if (arrayList.isEmpty()) {
            return new long[2];
        }
        if (this.uid == 0 || !SplitAppUtil.notSupportSplitAndroidScanVersion()) {
            return getFileCountAndSize(cloudBackupAppDataUtil, arrayList);
        }
        long[] fileCountAndSizeByPMS = getFileCountAndSizeByPMS(list, null, this.mOriginAppId, this.uid);
        long[] fileCountAndSize = getFileCountAndSize(cloudBackupAppDataUtil, list2);
        fileCountAndSizeByPMS[0] = fileCountAndSizeByPMS[0] + fileCountAndSize[0];
        fileCountAndSizeByPMS[1] = fileCountAndSizeByPMS[1] + fileCountAndSize[1];
        return fileCountAndSizeByPMS;
    }

    public List<String> getSdcardAndAndroidDataPaths(int i10) throws C9721b {
        Pair<List<String>, List<String>> pairInitScanDir = initScanDir(i10);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection) pairInitScanDir.first);
        arrayList.addAll((Collection) pairInitScanDir.second);
        return arrayList;
    }

    public long getSdcardFileSize(CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        long fileSize = getVirtualAppFileData().getFileSize();
        List<String> sdcardPaths = getSdcardPaths(this.uid);
        C11839m.m70688i(TAG, "get sdcard file size size, appId: " + this.mAppId + ", scanDir size: " + sdcardPaths.size());
        if (sdcardPaths.isEmpty()) {
            return fileSize;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<String> it = sdcardPaths.iterator();
        while (it.hasNext()) {
            fileSize += getDirSizeFilterFile(cloudBackupAppDataUtil, new File(it.next()));
        }
        C11839m.m70688i(TAG, "cost time " + (System.currentTimeMillis() - jCurrentTimeMillis) + ",scan file size:" + fileSize + " _ appid" + this.mAppId + "_" + this.uid);
        return fileSize;
    }

    public List<String> getSdcardPaths(int i10) throws C9721b {
        return new ArrayList((Collection) initScanDir(i10).second);
    }

    public VirtualAppFileData getSdcardSize(CloudBackupAppDataUtil cloudBackupAppDataUtil, AtomicBoolean atomicBoolean) throws C9721b {
        VirtualAppFileData virtualAppFileData = getVirtualAppFileData();
        long fileSize = virtualAppFileData.getFileSize();
        int fileCount = virtualAppFileData.getFileCount();
        List<String> sdcardPaths = getSdcardPaths(this.uid);
        C11839m.m70688i(TAG, "get 3rd app data size, appId: " + this.mAppId + ", scanDir size: " + sdcardPaths.size());
        if (sdcardPaths.isEmpty()) {
            return virtualAppFileData;
        }
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(threadPoolExecutor);
        try {
            try {
                AtomicInteger atomicInteger = new AtomicInteger();
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = sdcardPaths.iterator();
                while (it.hasNext()) {
                    addScanTask(it.next(), executorCompletionService, cloudBackupAppDataUtil, atomicInteger, arrayList);
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                while (true) {
                    if (executorCompletionService.take() == null) {
                        break;
                    }
                    if (atomicInteger.get() == 0) {
                        C11839m.m70688i(TAG, "get 3rd app data size success,break");
                        break;
                    }
                }
                for (SearchResult searchResult : arrayList) {
                    fileSize += searchResult.getTotalSize();
                    fileCount += searchResult.getTotalCount();
                }
                C11839m.m70688i(TAG, "cost time " + (System.currentTimeMillis() - jCurrentTimeMillis) + ",scan files:" + fileCount);
            } catch (InterruptedException e10) {
                C11839m.m70687e(TAG, "get 3rd app data size catch InterruptedException " + e10.getMessage());
                atomicBoolean.set(true);
            } catch (Exception e11) {
                C11839m.m70687e(TAG, "get 3rd app data size catch Exception " + e11.getMessage());
                atomicBoolean.set(true);
            }
            threadPoolExecutor.shutdownNow();
            virtualAppFileData.setFileSize(fileSize);
            virtualAppFileData.setFileCount(fileCount);
            return virtualAppFileData;
        } catch (Throwable th2) {
            threadPoolExecutor.shutdownNow();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<java.util.List<java.lang.String>, java.util.List<java.lang.String>> initScanDir(int r15) throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil.initScanDir(int):android.util.Pair");
    }

    public boolean isMatchMimeType(File file, List<Integer> list) {
        if (file.isDirectory() || list.isEmpty()) {
            return true;
        }
        return list.contains(Integer.valueOf(FileCategoryUtil.getFileCategory(C12538b.m75479b(file).m73355a())));
    }

    public void startScanMediaFile(ScanMediaCallback scanMediaCallback) {
        if (!getScanMediaData().isScanMedia()) {
            C11839m.m70688i(TAG, " not scan media lib");
            return;
        }
        List<Integer> mimeType = getScanMediaData().getMimeType();
        Iterator<Integer> it = mimeType.iterator();
        while (it.hasNext()) {
            Cursor scanMediaCursor = getScanMediaCursor(it.next().intValue());
            if (scanMediaCursor != null) {
                while (scanMediaCursor.moveToNext()) {
                    try {
                        try {
                            String string = scanMediaCursor.getString(scanMediaCursor.getColumnIndex("_data"));
                            File fileM63442h = C10278a.m63442h(string);
                            if (!fileM63442h.exists()) {
                                C11839m.m70689w(TAG, "scanMediaFiles file is not exists fpath = " + string);
                            } else if (isMatchPath(fileM63442h.getCanonicalPath())) {
                                C11839m.m70688i(TAG, "getScanMediaFileData, filter file: " + string);
                            } else if (isMatchMimeType(fileM63442h, mimeType)) {
                                String strM1501k = C0221j.m1501k();
                                if (TextUtils.isEmpty(strM1501k) || TextUtils.isEmpty(string) || !string.startsWith(strM1501k)) {
                                    scanMediaCallback.onScanEnd(fileM63442h);
                                } else {
                                    C11839m.m70688i(TAG, "getScanMediaFileData, appClonePath filter file: " + string);
                                }
                            } else {
                                C11839m.m70688i(TAG, "getScanMediaFileData, mimeTypes filter file: " + string);
                            }
                        } catch (Exception e10) {
                            C11839m.m70687e(TAG, "getScanMediaFileSize exception = " + e10.toString());
                        }
                    } catch (Throwable th2) {
                        scanMediaCursor.close();
                        throw th2;
                    }
                }
                scanMediaCursor.close();
            }
        }
    }

    public ScanAppDataUtil(String str, int i10, List<CloudBackupPathInfo> list, List<CloudBackupPathInfo> list2) {
        this(str, i10, str, list, list2);
    }

    public List<String> getDataPath(String str, int i10) throws C9721b {
        ArrayList arrayList = new ArrayList();
        List<CloudBackupPathInfo> list = this.mCloudBackupInclude;
        if (list == null) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getScanDir error mIncloude is null");
        }
        Iterator<CloudBackupPathInfo> it = list.iterator();
        while (it.hasNext()) {
            for (String str2 : it.next().getPaths()) {
                if (str2.startsWith("/data/data/")) {
                    arrayList.add(str2.replace(PACKAGE_NAME_FLAG, str));
                }
            }
        }
        if (arrayList.isEmpty()) {
            C11839m.m70689w(TAG, str + " data setting is empty");
            arrayList.add(BackupRestoreConstans.getDataPathByUid(str, i10));
        }
        C11839m.m70686d(TAG, str + " getDataPath " + arrayList);
        return arrayList;
    }

    public ScanAppDataUtil(String str, int i10, String str2, List<CloudBackupPathInfo> list, List<CloudBackupPathInfo> list2) {
        this.mCloudBackupInclude = new ArrayList();
        new ArrayList();
        this.mAppId = str;
        this.uid = i10;
        this.mOriginAppId = str2;
        this.mCloudBackupInclude = list;
        this.mCloudBackupExclude = list2;
    }

    public void appDataPrepare(String str, ICallback iCallback, String str2) throws C9721b {
        File fileM63442h = C10278a.m63442h(str);
        boolean zExists = fileM63442h.exists();
        String[] list = fileM63442h.list();
        if (zExists && (list == null || list.length > 0)) {
            executePmsMoveProcess(C0213f.m1377a().getFilesDir() + "/cloudbackup");
            throw new C9721b(1020, "app dir delete error: " + str);
        }
        BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(C0213f.m1377a(), iCallback, str);
        List<String> dataPath = getDataPath(str2);
        if (dataPath.isEmpty()) {
            C11839m.m70689w(TAG, "appDataPrepare dataPath is empty " + str2);
            return;
        }
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70689w(TAG, "tempDir mkdir error " + str);
        }
        for (String str3 : dataPath) {
            ICBUtil.checkModuleNeedLocalSize(str2, str2, false);
            if (backupRestoreUtil.pmsBackup(str2, str3) != 0) {
                ICBUtil.checkDataLocalLimitSpace(str2 + " local size not enough left space: ");
                throw new C9721b(2101, "prepare backup data failed appId = " + str2 + " datapath = " + str3);
            }
        }
        C11839m.m70688i(TAG, "appDataPrepare end, " + str2);
    }
}
