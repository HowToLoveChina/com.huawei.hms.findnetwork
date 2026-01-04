package com.huawei.hicloud.notification.data;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.MediaStore;
import com.huawei.hicloud.notification.log.NotifyLogger;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import p015ak.C0213f;
import p015ak.C0219i;
import p035bk.C1249b;

/* loaded from: classes6.dex */
public class MediaDataCollector extends BaseDataCollector {
    private static final String DATA = "_data";
    private static final int MIN_ARRAY_SIZE = 2;
    private static final String SIZE = "_size";
    private static final String TAG = "MediaDataCollector";
    private CountDownLatch countDownLatch;
    private int picAmount;
    private long picSize;
    private int videoAmount;
    private long videoSize;

    public MediaDataCollector(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    private Object[] getMediaInfoCompatible(int i10) throws Throwable {
        Cursor cursor = null;
        try {
            try {
                NotifyLogger.m29915i(TAG, "getMediaInfo type=" + i10);
                Uri mediaUri = getMediaUri(i10);
                if (mediaUri == null) {
                    return null;
                }
                String[] strArr = {"COUNT(_data) AS filecount , SUM(_size) AS filesize"};
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("_data like ? ");
                ArrayList<String> storagePath = getStoragePath();
                String[] strArr2 = new String[storagePath.size()];
                strArr2[0] = storagePath.get(0) + "/DCIM/Camera%";
                for (int i11 = 1; i11 < storagePath.size(); i11++) {
                    StringBuffer stringBuffer2 = new StringBuffer(storagePath.get(i11));
                    stringBuffer2.append("/DCIM/Camera%");
                    strArr2[i11] = stringBuffer2.toString();
                    stringBuffer.append(" or ");
                    stringBuffer.append("_data like ? ");
                }
                String string = stringBuffer.toString();
                NotifyLogger.m29915i(TAG, "media selection type=" + i10 + ", selection=" + string);
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a == null) {
                    return null;
                }
                Cursor cursorQuery = contextM1377a.getContentResolver().query(mediaUri, strArr, string, strArr2, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                try {
                    Object[] objArr = new Object[2];
                    if (cursorQuery.moveToFirst()) {
                        objArr[0] = Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("filecount")));
                        objArr[1] = Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("filesize")));
                    }
                    NotifyLogger.m29915i(TAG, "type=" + i10 + ",filecount=" + objArr[0] + ",filesize=" + objArr[1]);
                    cursorQuery.close();
                    return objArr;
                } catch (Exception unused) {
                    cursor = cursorQuery;
                    NotifyLogger.m29914e(TAG, "getMediaInfo error");
                    if (cursor != null) {
                        cursor.close();
                    }
                    return new Object[0];
                } catch (Throwable th2) {
                    cursor = cursorQuery;
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception unused2) {
        }
    }

    private Object[] getMediaInfoForEMUI10(int i10) {
        int count;
        Cursor cursorQuery = null;
        try {
            try {
                NotifyLogger.m29915i(TAG, "getMediaInfoForEMUI10 getMediaInfo type=" + i10);
                Uri mediaUri = getMediaUri(i10);
                if (mediaUri == null) {
                    return null;
                }
                String[] strArr = {DATA, SIZE};
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a == null) {
                    return null;
                }
                cursorQuery = contextM1377a.getContentResolver().query(mediaUri, strArr, null, null, null);
                long j10 = 0;
                if (cursorQuery == null || cursorQuery.getCount() <= 0 || cursorQuery.getColumnCount() <= 0) {
                    count = 0;
                } else {
                    cursorQuery.moveToFirst();
                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow(SIZE);
                    count = cursorQuery.getCount();
                    do {
                        j10 += cursorQuery.getInt(columnIndexOrThrow);
                    } while (cursorQuery.moveToNext());
                }
                Object[] objArr = {Integer.valueOf(count), Long.valueOf(j10)};
                NotifyLogger.m29915i(TAG, "getMediaInfoForEMUI10 type=" + i10 + ",filecount=" + count + ",filesize=" + j10);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return objArr;
            } catch (Exception unused) {
                NotifyLogger.m29914e(TAG, "getMediaInfoForEMUI10 getMediaInfo error");
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return new Object[0];
            }
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    private Uri getMediaUri(int i10) {
        if (i10 == 0) {
            return MediaStore.Images.Media.getContentUri("external");
        }
        if (1 == i10) {
            return MediaStore.Video.Media.getContentUri("external");
        }
        return null;
    }

    private ArrayList<String> getStoragePath() {
        StorageManager storageManager = (StorageManager) C0213f.m1377a().getSystemService("storage");
        StorageVolume[] storageVolumeArrM7483f = C1249b.m7483f(storageManager);
        ArrayList<String> arrayList = new ArrayList<>();
        for (StorageVolume storageVolume : storageVolumeArrM7483f) {
            if ("mounted".equals(storageVolume.getState())) {
                if (storageVolume.isPrimary() && storageVolume.isEmulated()) {
                    arrayList.add(C1249b.m7481d(storageVolume));
                } else {
                    String uuid = storageVolume.getUuid();
                    if (uuid != null) {
                        Object objM7479b = C1249b.m7479b(C1249b.m7478a(storageManager, uuid));
                        if (objM7479b != null && C1249b.m7485h(objM7479b)) {
                            arrayList.add(C1249b.m7481d(storageVolume));
                        } else if (objM7479b != null && C1249b.m7486i(objM7479b)) {
                            arrayList.add(C1249b.m7481d(storageVolume));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hicloud.notification.data.BaseDataCollector
    public void execute() {
        Object[] mediaInfo = getMediaInfo(0);
        if (mediaInfo != null && mediaInfo.length >= 2) {
            this.picAmount = ((Integer) mediaInfo[0]).intValue();
            this.picSize = ((Long) mediaInfo[1]).longValue();
        }
        Object[] mediaInfo2 = getMediaInfo(1);
        if (mediaInfo2 != null && mediaInfo2.length >= 2) {
            this.videoAmount = ((Integer) mediaInfo2[0]).intValue();
            this.videoSize = ((Long) mediaInfo2[1]).longValue();
        }
        this.mAmount = this.picAmount + this.videoAmount;
        this.mSize = this.picSize + this.videoSize;
        CountDownLatch countDownLatch = this.countDownLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public Object[] getMediaInfo(int i10) {
        return C0219i.m1463a() >= 21 ? getMediaInfoForEMUI10(i10) : getMediaInfoCompatible(i10);
    }
}
