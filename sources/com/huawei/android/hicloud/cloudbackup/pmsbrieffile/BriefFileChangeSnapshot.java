package com.huawei.android.hicloud.cloudbackup.pmsbrieffile;

import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import mk.C11476b;
import p015ak.C0209d;
import p015ak.C0241z;
import p514o9.C11839m;
import p618rm.C12583q;
import p618rm.C12590s0;
import pl.C12161c;
import pl.C12164f;

/* loaded from: classes2.dex */
public class BriefFileChangeSnapshot {
    private static final int BATCH_REPLACE_SIZE = 120;
    private static final int SECOND_TO_MS = 1000;
    private static final String TAG = "BriefFileChangeSnapshot";
    private final List<C12161c> cloudBackupMetas = new ArrayList();
    private final CloudBackupStatus mBackupStatus;
    private final String originAppId;
    private final ProgressCallback progressCallback;

    public BriefFileChangeSnapshot(ProgressCallback progressCallback, String str, CloudBackupStatus cloudBackupStatus) {
        this.progressCallback = progressCallback;
        this.originAppId = str;
        this.mBackupStatus = cloudBackupStatus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List, java.util.List<pl.c>] */
    private void batchReplaceToSnapshot(C12164f c12164f, boolean z10) throws C9721b {
        if (this.cloudBackupMetas.size() > 120 || z10) {
            try {
                if (this.progressCallback.onStop()) {
                    C11839m.m70687e(TAG, "android data backup is stop");
                    throw new C9721b(1001, "android data backup is stop");
                }
                try {
                    c12164f.batchReplace(this.cloudBackupMetas);
                } catch (C9721b e10) {
                    C11839m.m70689w(TAG, "android data backup error: " + e10.toString());
                }
            } finally {
                this.cloudBackupMetas.clear();
            }
        }
    }

    private C12161c createSnapshotMeta(String[] strArr) {
        C12161c c12161c = new C12161c();
        c12161c.m72956L(this.mBackupStatus.m29870d());
        c12161c.m72957M(this.mBackupStatus.m29871e());
        c12161c.m72998o0(0);
        String strSplitAppAndroidDataPathToOriginPath = strArr[0];
        String strTrim = C10278a.m63442h(strSplitAppAndroidDataPathToOriginPath).getName().trim();
        if (this.mBackupStatus.m29861N() != 0) {
            strSplitAppAndroidDataPathToOriginPath = SplitAppUtil.splitAppAndroidDataPathToOriginPath(strArr[0]);
        }
        String strM75665a = C12583q.m75665a(C12590s0.m75797S2(this.mBackupStatus.m29870d(), this.mBackupStatus.mo29421n(), this.mBackupStatus.m29861N(), strSplitAppAndroidDataPathToOriginPath, this.mBackupStatus.m29345E0()), 0, this.mBackupStatus.m29861N());
        String strM75648B = C12583q.m75648B(strM75665a);
        if (ICBUtil.hasEmojiCharacter(strM75665a)) {
            c12161c.m72959O(1L);
            strM75665a = ICBUtil.getEncodedPath(strM75665a);
        }
        c12161c.m72994m0(strM75648B);
        c12161c.m72964T(strM75665a.substring(strM75648B.length()));
        if (ICBUtil.hasEmojiCharacter(strTrim) || ICBUtil.checkFileName(strTrim)) {
            strTrim = C11476b.m68626h(strTrim);
        }
        c12161c.m72990k0(strTrim);
        c12161c.m72975c0(C0241z.m1688f(strArr[4]) * 1000);
        c12161c.m72971a0(System.currentTimeMillis());
        if (C0241z.m1685c(strArr[2]) == 0) {
            c12161c.m73000p0(6L);
            c12161c.m72996n0(C0241z.m1688f(strArr[3]));
            c12161c.m72962R(C0241z.m1688f(strArr[3]));
        } else {
            c12161c.m73000p0(5L);
        }
        return c12161c;
    }

    private void insertCustInfo(String[] strArr, C12164f c12164f, boolean z10, boolean z11) throws C9721b {
        if (isIllegal(strArr)) {
            batchReplaceToSnapshot(c12164f, z10);
            return;
        }
        C12161c c12161cCreateSnapshotMeta = createSnapshotMeta(strArr);
        if (z11 && c12161cCreateSnapshotMeta.m72951G() <= 0) {
            batchReplaceToSnapshot(c12164f, z10);
        } else {
            this.cloudBackupMetas.add(c12161cCreateSnapshotMeta);
            batchReplaceToSnapshot(c12164f, z10);
        }
    }

    private boolean isIllegal(String[] strArr) {
        if (strArr.length < 5 || strArr.length > 5) {
            C11839m.m70689w(TAG, "isIllegal: " + strArr.length);
            return true;
        }
        String str = strArr[0];
        if (str == null || !str.startsWith("/")) {
            C11839m.m70689w(TAG, "isIllegal firstStr: " + str);
            return true;
        }
        if (str.contains(this.originAppId)) {
            return false;
        }
        C11839m.m70689w(TAG, "isIllegal firstStr: " + str);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.io.Closeable, java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    public void readBriefFileToSnapshot(String str, C12164f c12164f, boolean z10) throws C9721b {
        FileInputStream fileInputStream;
        ?? M63442h = C10278a.m63442h(str);
        BufferedReader bufferedReader = null;
        try {
            try {
                C11839m.m70688i(TAG, "readBriefFileToSnapshot start ");
                fileInputStream = new FileInputStream((File) M63442h);
                try {
                    M63442h = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(M63442h);
                        try {
                            String line = bufferedReader2.readLine();
                            int i10 = 0;
                            while (line != null) {
                                i10++;
                                String[] strArrSplit = line.split(";");
                                String line2 = bufferedReader2.readLine();
                                insertCustInfo(strArrSplit, c12164f, line2 == null, z10);
                                line = line2;
                            }
                            C11839m.m70688i(TAG, "readTxtFileToDb sum = " + i10);
                            C0209d.m1263i(bufferedReader2);
                            C0209d.m1263i(M63442h);
                            C0209d.m1263i(fileInputStream);
                        } catch (FileNotFoundException e10) {
                            e = e10;
                            C11839m.m70687e(TAG, "readTxtFileByFileUtils FileNotFoundException: " + e.toString());
                            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "readTxtFileByFileUtils FileNotFoundException delete error " + e.toString());
                        } catch (IOException e11) {
                            e = e11;
                            C11839m.m70687e(TAG, "readTxtFileByFileUtils IOException: " + e.toString());
                            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "readTxtFileByFileUtils IOException delete error " + e.toString());
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            C0209d.m1263i(bufferedReader);
                            C0209d.m1263i(M63442h);
                            C0209d.m1263i(fileInputStream);
                            throw th;
                        }
                    } catch (FileNotFoundException e12) {
                        e = e12;
                    } catch (IOException e13) {
                        e = e13;
                    } catch (Throwable th3) {
                        th = th3;
                        C0209d.m1263i(bufferedReader);
                        C0209d.m1263i(M63442h);
                        C0209d.m1263i(fileInputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e14) {
                    e = e14;
                } catch (IOException e15) {
                    e = e15;
                } catch (Throwable th4) {
                    th = th4;
                    M63442h = 0;
                }
            } catch (FileNotFoundException e16) {
                e = e16;
            } catch (IOException e17) {
                e = e17;
            } catch (Throwable th5) {
                th = th5;
                M63442h = 0;
                fileInputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
    }
}
