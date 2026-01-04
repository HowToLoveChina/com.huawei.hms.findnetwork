package com.huawei.android.hicloud.cloudspace.manager;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.commonlib.space.QuotaDetail;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoRsp;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hicloud.bean.DataTypeNum;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.bean.SyncConfigServiceDataType;
import com.huawei.hicloud.notification.manager.SyncModuleConfigManager;
import com.huawei.hicloud.notification.syncconfig.IQueryNumFinished;
import fk.C9721b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import je.C10812z;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import to.C13049a;

/* loaded from: classes2.dex */
public class SyncConfigStructureNumRequestor implements IQueryNumFinished {

    /* renamed from: a */
    public Context f11869a;

    /* renamed from: b */
    public CountDownLatch f11870b;

    /* renamed from: com.huawei.android.hicloud.cloudspace.manager.SyncConfigStructureNumRequestor$a */
    public static class C2743a extends AbstractC12367d {

        /* renamed from: a */
        public SyncConfigService f11871a;

        /* renamed from: b */
        public IQueryNumFinished f11872b;

        /* renamed from: c */
        public CountDownLatch f11873c;

        /* renamed from: d */
        public Context f11874d;

        public C2743a(SyncConfigService syncConfigService, IQueryNumFinished iQueryNumFinished, CountDownLatch countDownLatch, Context context) {
            this.f11871a = syncConfigService;
            this.f11872b = iQueryNumFinished;
            this.f11873c = countDownLatch;
            this.f11874d = context;
        }

        /* renamed from: c */
        public final void m15521c(QuotaUsedInfoRsp quotaUsedInfoRsp, SyncConfigServiceDataType[] syncConfigServiceDataTypeArr) {
            int length;
            QuotaDetail[] quotaDetails = quotaUsedInfoRsp.getQuotaDetails();
            if (quotaUsedInfoRsp.getRetCode() != 0 || (length = quotaDetails.length) <= 0) {
                return;
            }
            for (SyncConfigServiceDataType syncConfigServiceDataType : syncConfigServiceDataTypeArr) {
                DataTypeNum[] dataTypeNumArr = new DataTypeNum[length];
                for (int i10 = 0; i10 < length; i10++) {
                    QuotaDetail quotaDetail = quotaDetails[i10];
                    if (quotaDetail != null && syncConfigServiceDataType.getTypeId().equals(quotaDetail.getKind())) {
                        DataTypeNum dataTypeNum = new DataTypeNum();
                        dataTypeNum.setSumNum(quotaDetail.getRecordsCount());
                        if (quotaDetail.isTrashed()) {
                            dataTypeNum.setStatus(-1);
                        } else {
                            dataTypeNum.setStatus(2);
                        }
                        dataTypeNumArr[i10] = dataTypeNum;
                    }
                }
                syncConfigServiceDataType.setTypeNum(dataTypeNumArr);
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            SyncConfigServiceDataType[] dataTypes = this.f11871a.getDataTypes();
            C13049a c13049a = new C13049a(EnumC12999a.CLOUD_SYNC, C10812z.m65832a("03007"));
            StringBuffer stringBuffer = new StringBuffer("collection=private and kind in [");
            if (dataTypes != null) {
                try {
                    if (dataTypes.length != 0) {
                        for (SyncConfigServiceDataType syncConfigServiceDataType : dataTypes) {
                            stringBuffer.append(syncConfigServiceDataType.getTypeId());
                            stringBuffer.append(",");
                        }
                        if ("collection=private and kind in [".equals(stringBuffer.toString())) {
                            C11839m.m70689w("SyncConfigStructureNumRequestor", "QueryQutoNumTask no datatype");
                            return;
                        }
                        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                        stringBuffer.append("] and (trashed=true or trashed=false)");
                        String str = new String(stringBuffer);
                        C11839m.m70686d("SyncConfigStructureNumRequestor", "QueryQutoNumTask q =" + str);
                        String strM78761z = c13049a.m78761z(DriveSyncUtil.m17958C(this.f11871a.getId()), str);
                        C11839m.m70686d("SyncConfigStructureNumRequestor", "QueryQutoNumTask  response=" + strM78761z);
                        m15521c((QuotaUsedInfoRsp) new Gson().fromJson(strM78761z, QuotaUsedInfoRsp.class), dataTypes);
                        this.f11872b.onNumQueryFinished(this.f11871a);
                        this.f11873c.countDown();
                        return;
                    }
                } catch (JsonSyntaxException e10) {
                    C11839m.m70687e("SyncConfigStructureNumRequestor", "QueryQutoNumTask JsonSyntaxEx:" + e10.toString());
                    return;
                } catch (C9721b e11) {
                    C11839m.m70687e("SyncConfigStructureNumRequestor", "QueryQutoNumTask exception:" + e11.toString());
                    return;
                }
            }
            C11839m.m70689w("SyncConfigStructureNumRequestor", "QueryQutoNumTask dataTypes is empty");
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SYNC_CONFIG;
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    public SyncConfigStructureNumRequestor(Context context) {
        this.f11869a = context;
    }

    /* renamed from: a */
    public final void m15519a(SyncConfigService syncConfigService) {
        C12515a.m75110o().m75172d(new C2743a(syncConfigService, this, this.f11870b, this.f11869a));
    }

    /* renamed from: b */
    public List<SyncConfigService> m15520b() {
        try {
            C11839m.m70686d("SyncConfigStructureNumRequestor", "request context:" + this.f11869a);
            List<SyncConfigService> syncServicesFromDb = SyncModuleConfigManager.getInstance().getSyncServicesFromDb();
            if (syncServicesFromDb.size() <= 0) {
                return null;
            }
            this.f11870b = new CountDownLatch(syncServicesFromDb.size());
            Iterator<SyncConfigService> it = syncServicesFromDb.iterator();
            while (it.hasNext()) {
                m15519a(it.next());
            }
            try {
                if (this.f11870b.await(30000L, TimeUnit.MILLISECONDS)) {
                    C11839m.m70688i("SyncConfigStructureNumRequestor", "all task finished");
                }
            } catch (InterruptedException e10) {
                C11839m.m70687e("SyncConfigStructureNumRequestor", "wait task finished error : " + e10.getMessage());
            }
            return syncServicesFromDb;
        } catch (Exception e11) {
            C11839m.m70687e("SyncConfigStructureNumRequestor", "SyncConfigStructureNumRequestor request exception:" + e11.toString());
            return null;
        }
    }

    @Override // com.huawei.hicloud.notification.syncconfig.IQueryNumFinished
    public void onNumQueryFinished(DriveConfigService driveConfigService) {
    }

    @Override // com.huawei.hicloud.notification.syncconfig.IQueryNumFinished
    public void onNumQueryFinished(SyncConfigService syncConfigService) {
    }
}
