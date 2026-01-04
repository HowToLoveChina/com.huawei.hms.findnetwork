package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.hihttp.request.response.SaveOriginalInfo;
import com.huawei.android.hicloud.album.service.p075vo.CloudAlbumVersion;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import java.util.concurrent.Callable;
import p031b7.C1120a;
import p031b7.C1136q;
import p251e8.C9423b;
import p635s7.C12737i0;
import p635s7.C12754s;
import p664u0.C13108a;
import p850zo.InterfaceC14353d;

/* loaded from: classes2.dex */
public class SaveOriginalCallable implements Callable {
    private static final String TAG = "SaveOriginalCallable";
    private boolean force;
    private Context mContext;
    private InterfaceC14353d mSaveOriginalListener;

    public SaveOriginalCallable(Context context, boolean z10, InterfaceC14353d interfaceC14353d) {
        this.mSaveOriginalListener = interfaceC14353d;
        this.mContext = context;
        this.force = z10;
    }

    private int compareVersion(SaveOriginalInfo saveOriginalInfo, CloudAlbumVersion cloudAlbumVersion, String str) {
        long latestVersion = saveOriginalInfo.getLatestVersion();
        String shareVersion = saveOriginalInfo.getShareVersion();
        long latestVersion2 = cloudAlbumVersion.getLatestVersion();
        C1120a.m6677i(TAG, "compareVersion sdk general: " + latestVersion + ":" + latestVersion2 + ", share: " + shareVersion + ":" + str);
        return latestVersion == latestVersion2 ? str.equals(shareVersion) ? 3 : 1 : str.equals(shareVersion) ? 0 : 2;
    }

    private boolean isParameterIllegal(SaveOriginalInfo saveOriginalInfo, CloudAlbumVersion cloudAlbumVersion, String str) {
        return saveOriginalInfo == null || cloudAlbumVersion == null || str == null;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        C1136q.b.m7046b1(this.mContext, this.force);
        Intent intent = new Intent("com.huawei.cg.action.MOBILE_SAVE_ORIGINAL_ACTION");
        intent.putExtra("mobile_save_original_force", this.force);
        C13108a.m78878b(this.mContext).m78881d(intent);
        if (CloudAlbumSettings.m14363h().m14385u()) {
            SaveOriginalInfo saveOriginalInfoM59103j = new C9423b().m59103j(this.mContext);
            C12754s c12754s = new C12754s(this.mContext, "");
            Bundle bundleM76583s = c12754s.m76583s(c12754s.mo76565p());
            CloudAlbumVersion cloudAlbumVersion = (bundleM76583s == null || !bundleM76583s.containsKey("CloudAlbumVersion")) ? null : (CloudAlbumVersion) bundleM76583s.getParcelable("CloudAlbumVersion");
            C12737i0 c12737i0 = new C12737i0(this.mContext, "", "3");
            Bundle bundleM76583s2 = c12737i0.m76583s(c12737i0.mo76565p());
            String string = bundleM76583s2.containsKey("shareVersion") ? bundleM76583s2.getString("shareVersion") : null;
            if (isParameterIllegal(saveOriginalInfoM59103j, cloudAlbumVersion, string)) {
                C1120a.m6676e(TAG, "SaveOriginalCallable params error");
                this.mSaveOriginalListener.mo20563a();
                return null;
            }
            int iCompareVersion = compareVersion(saveOriginalInfoM59103j, cloudAlbumVersion, string);
            if (iCompareVersion == 3) {
                this.mSaveOriginalListener.mo20564b(iCompareVersion, saveOriginalInfoM59103j.getHaveAnotherNum());
            } else {
                this.mSaveOriginalListener.mo20565c(iCompareVersion);
            }
        }
        return null;
    }
}
