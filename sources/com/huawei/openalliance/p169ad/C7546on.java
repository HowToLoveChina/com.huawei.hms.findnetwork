package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.util.Pair;
import com.huawei.openalliance.p169ad.analysis.C6921b;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.AppCollection;
import com.huawei.openalliance.p169ad.beans.server.AppDataCollectionRsp;
import com.huawei.openalliance.p169ad.beans.server.DelSyncedAppDataReq;
import com.huawei.openalliance.p169ad.beans.server.RetAndMsg;
import com.huawei.openalliance.p169ad.constant.ConfigMapKeys;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.p171db.bean.AppDataCollectionRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import com.huawei.openalliance.p169ad.utils.C7779bz;
import com.huawei.openalliance.p169ad.utils.C7809db;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.on */
/* loaded from: classes8.dex */
public class C7546on implements InterfaceC7612qn {

    /* renamed from: a */
    private final InterfaceC7140fx f35092a;

    /* renamed from: b */
    private final Context f35093b;

    /* renamed from: c */
    private final List<AppDataCollectionRecord> f35094c = new ArrayList();

    /* renamed from: d */
    private final List<String> f35095d = new ArrayList();

    /* renamed from: e */
    private final List<String> f35096e = new ArrayList();

    /* renamed from: f */
    private List<AppDataCollectionRecord> f35097f;

    /* renamed from: g */
    private List<AppCollection> f35098g;

    /* renamed from: h */
    private List<AppCollection> f35099h;

    /* renamed from: i */
    private final int f35100i;

    public C7546on(Context context, int i10) {
        this.f35093b = context;
        this.f35092a = C7118fb.m43196a(context);
        this.f35100i = i10;
    }

    /* renamed from: c */
    public RetAndMsg m46363c() {
        String string;
        RetAndMsg retAndMsg = new RetAndMsg();
        List<AppDataCollectionRecord> listM42961a = C7097em.m42958a(this.f35093b).m42961a(AbstractC7806cz.m48145a(C7124fh.m43316b(this.f35093b).mo43070b(ConfigMapKeys.MAX_UPLOAD_APP_DATA_SIZE, ""), 50));
        this.f35097f = listM42961a;
        if (AbstractC7760bg.m47767a(listM42961a)) {
            AbstractC7185ho.m43820b("AppDataCollectionProcessor", "report data empty");
            string = "data empty";
        } else {
            retAndMsg.m40958a(this.f35097f.size());
            AbstractC7185ho.m43817a("AppDataCollectionProcessor", "report data");
            AppDataCollectionRsp appDataCollectionRspMo43278b = this.f35092a.mo43278b(AbstractC7572pf.m46754b(this.f35097f, this.f35093b));
            if (appDataCollectionRspMo43278b != null && 200 == appDataCollectionRspMo43278b.m40942a()) {
                return retAndMsg;
            }
            AbstractC7185ho.m43817a("AppDataCollectionProcessor", "report app data collection failed");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("report failed, code: ");
            sb2.append(appDataCollectionRspMo43278b == null ? -2 : appDataCollectionRspMo43278b.m40942a());
            string = sb2.toString();
        }
        retAndMsg.m40959a(string);
        retAndMsg.m40960a(false);
        return retAndMsg;
    }

    /* renamed from: d */
    private void m46354d() {
        C7097em.m42958a(this.f35093b).m42963b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m46356e() {
        m46354d();
        C7097em c7097emM42958a = C7097em.m42958a(this.f35093b);
        long jM42964c = c7097emM42958a.m42964c();
        if (jM42964c == 0) {
            AbstractC7185ho.m43817a("AppDataCollectionProcessor", "local data record num is 0, return");
            return;
        }
        RetAndMsg retAndMsgM46363c = m46363c();
        RetAndMsg retAndMsgM46361b = m46361b(retAndMsgM46363c.m40961a());
        long jM42964c2 = c7097emM42958a.m42964c();
        Map<String, Long> mapM42965d = c7097emM42958a.m42965d();
        StringBuilder sb2 = new StringBuilder();
        if (!C7765bl.m47802a(mapM42965d)) {
            for (Map.Entry<String, Long> entry : mapM42965d.entrySet()) {
                sb2.append(entry.getKey());
                sb2.append('=');
                sb2.append(entry.getValue());
                sb2.append(',');
            }
            AbstractC7806cz.m48159a(sb2, ',');
        }
        String string = sb2.toString();
        AbstractC7185ho.m43818a("AppDataCollectionProcessor", "report remaining records: %s", string);
        m46357a(jM42964c, jM42964c2, string, retAndMsgM46363c, retAndMsgM46361b);
    }

    /* renamed from: a */
    public void m46357a(long j10, long j11, String str, RetAndMsg retAndMsg, RetAndMsg retAndMsg2) {
        C6921b c6921b = new C6921b();
        c6921b.m38828al(String.valueOf(j10 - j11));
        c6921b.m38829am(String.valueOf(j11));
        c6921b.m38830an(str);
        c6921b.m38831ao(String.valueOf(retAndMsg.m40961a()));
        c6921b.m38832ap(retAndMsg.m40962b());
        c6921b.m38833aq(String.valueOf(retAndMsg.m40963c()));
        c6921b.m38834ar(String.valueOf(retAndMsg2.m40961a()));
        c6921b.m38835as(retAndMsg2.m40962b());
        c6921b.m38836at(String.valueOf(retAndMsg2.m40963c()));
        AbstractC7185ho.m43821b("AppDataCollectionProcessor", "cache event beforeCount - afterCount = %s, afterCount = %s", c6921b.m38814aN(), c6921b.m38815aO());
        new C6922c(this.f35093b).m39097a(AppDataCollectionRecord.class.getSimpleName(), c6921b);
    }

    /* renamed from: b */
    public RetAndMsg m46361b(boolean z10) {
        RetAndMsg retAndMsg = new RetAndMsg();
        if (!z10) {
            retAndMsg.m40960a(false);
            retAndMsg.m40959a("report data error");
            AbstractC7185ho.m43820b("AppDataCollectionProcessor", "report app collection data error");
            return retAndMsg;
        }
        if (AbstractC7760bg.m47767a(this.f35097f)) {
            AbstractC7185ho.m43820b("AppDataCollectionProcessor", "no ids need del");
            retAndMsg.m40960a(false);
            retAndMsg.m40959a("upLoadRecords empty");
            return retAndMsg;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<AppDataCollectionRecord> it = this.f35097f.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().m41331b()));
        }
        int iM42962b = C7097em.m42958a(this.f35093b).m42962b(arrayList);
        retAndMsg.m40958a(iM42962b);
        if (iM42962b < 0) {
            retAndMsg.m40960a(false);
            retAndMsg.m40959a("del error");
        }
        return retAndMsg;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7612qn
    /* renamed from: b */
    public void mo46362b() {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.on.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (8 != C7546on.this.f35100i && C6982bz.m41152b(C7546on.this.f35093b)) {
                        if (!C7809db.m48267a(C7546on.this.f35093b)) {
                            AbstractC7185ho.m43817a("AppDataCollectionProcessor", "no need to sync");
                            return;
                        }
                        C7098en.m42966a(C7546on.this.f35093b).mo42969b();
                        Pair<Integer, String> pairM47851a = C7779bz.m47851a(C7546on.this.f35093b, "/dd/sync", "");
                        if (pairM47851a != null && ((Integer) pairM47851a.first).intValue() == 200 && !AbstractC7806cz.m48165b((String) pairM47851a.second)) {
                            C7546on.this.m46350a((String) pairM47851a.second);
                            if (AbstractC7760bg.m47767a(C7546on.this.f35098g) && AbstractC7760bg.m47767a(C7546on.this.f35099h)) {
                                AbstractC7185ho.m43817a("AppDataCollectionProcessor", "empty list from kit");
                                C7546on.this.m46356e();
                                return;
                            }
                            C7546on c7546on = C7546on.this;
                            c7546on.m46358a(c7546on.f35098g, C7546on.this.f35099h);
                            C7546on c7546on2 = C7546on.this;
                            c7546on2.m46359a(c7546on2.m46360a());
                            C7546on.this.m46356e();
                            return;
                        }
                        AbstractC7185ho.m43817a("AppDataCollectionProcessor", "empty resp from kit");
                        C7546on.this.m46356e();
                        return;
                    }
                    AbstractC7185ho.m43817a("AppDataCollectionProcessor", "is TV or not inner device");
                } catch (Throwable th2) {
                    AbstractC7185ho.m43814a(3, "AppDataCollectionProcessor", th2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m46350a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("appCollections");
            String strOptString2 = jSONObject.optString("appInstallDatas");
            if (!AbstractC7806cz.m48165b(strOptString)) {
                List<AppCollection> list = (List) AbstractC7758be.m47722a(strOptString, List.class, AppCollection.class);
                this.f35098g = list;
                AbstractC7185ho.m43821b("AppDataCollectionProcessor", "convert collectionRecord size is : %s", Integer.valueOf(list.size()));
            }
            if (AbstractC7806cz.m48165b(strOptString2)) {
                return;
            }
            List<AppCollection> list2 = (List) AbstractC7758be.m47722a(strOptString2, List.class, AppCollection.class);
            this.f35099h = list2;
            AbstractC7185ho.m43821b("AppDataCollectionProcessor", "convert installDataRecords size is : %s", Integer.valueOf(list2.size()));
        } catch (JSONException unused) {
            AbstractC7185ho.m43820b("AppDataCollectionProcessor", "parse data error, json format error");
        }
    }

    /* renamed from: a */
    public void m46358a(List<AppCollection> list, List<AppCollection> list2) {
        if (!AbstractC7760bg.m47767a(list)) {
            Collection<AppDataCollectionRecord> collectionM46749a = AbstractC7572pf.m46749a(list, this.f35093b.getPackageName());
            if (!AbstractC7760bg.m47767a(collectionM46749a)) {
                this.f35094c.addAll(collectionM46749a);
                Iterator<AppCollection> it = list.iterator();
                while (it.hasNext()) {
                    this.f35095d.add(it.next().m39804c());
                }
            }
        }
        if (AbstractC7760bg.m47767a(list2)) {
            return;
        }
        Collection<AppDataCollectionRecord> collectionM46749a2 = AbstractC7572pf.m46749a(list2, this.f35093b.getPackageName());
        if (AbstractC7760bg.m47767a(collectionM46749a2)) {
            return;
        }
        this.f35094c.addAll(collectionM46749a2);
        Iterator<AppCollection> it2 = list2.iterator();
        while (it2.hasNext()) {
            this.f35096e.add(it2.next().m39804c());
        }
    }

    /* renamed from: a */
    public void m46359a(boolean z10) {
        if (!z10) {
            AbstractC7185ho.m43820b("AppDataCollectionProcessor", "insert error, no need del sync data");
            return;
        }
        DelSyncedAppDataReq delSyncedAppDataReq = new DelSyncedAppDataReq();
        delSyncedAppDataReq.m40948a(this.f35093b.getPackageName());
        delSyncedAppDataReq.m40949a(this.f35095d);
        delSyncedAppDataReq.m40950b(this.f35096e);
        AbstractC7185ho.m43821b("AppDataCollectionProcessor", "rpt del sync data req is : %s", AbstractC7758be.m47740b(this.f35093b, delSyncedAppDataReq));
        C7484ms.m45854a(this.f35093b).m45855a(RTCMethods.DEL_SYNCED_APP_DATA, AbstractC7758be.m47742b(delSyncedAppDataReq), null, null);
    }

    /* renamed from: a */
    public boolean m46360a() {
        long jM42959a = C7097em.m42958a(this.f35093b).m42959a(this.f35094c);
        AbstractC7185ho.m43818a("AppDataCollectionProcessor", "insert appCollectionRecord : %s", Long.valueOf(jM42959a));
        return jM42959a > 0;
    }
}
