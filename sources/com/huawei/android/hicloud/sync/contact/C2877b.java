package com.huawei.android.hicloud.sync.contact;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.protocol.C2924c;
import com.huawei.android.hicloud.sync.protocol.C2925d;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfo;
import com.huawei.android.hicloud.sync.service.aidl.ModuleRst;
import com.huawei.android.hicloud.sync.syncutil.C2975d;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9722c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import p514o9.C11839m;
import p517oc.C11847b;
import p517oc.C11848c;
import p551pc.C12127a;
import p551pc.C12128b;
import tc.C13007b;

/* renamed from: com.huawei.android.hicloud.sync.contact.b */
/* loaded from: classes3.dex */
public class C2877b extends C2876a {
    public C2877b(Context context, String str, String str2, String str3, String str4) {
        super(context, str, str2, str3, str4);
    }

    /* renamed from: K */
    public void m17281K() throws JSONException {
        C2975d.m17838b(this.mContext, m17272r(this.mContext), -2, m17273s(this.mContext), m17274t(), this.f12794h);
    }

    /* renamed from: L */
    public void m17282L() {
        this.f12792f.m17229k();
        this.mContext = null;
    }

    /* renamed from: M */
    public void m17283M() {
        C11839m.m70688i("AddressLogicProcess", "End sync for source " + this.mModuleName);
        this.f12795i = null;
        this.f12796j = null;
        this.f12797k = null;
        this.f12799m = null;
        this.f12800n = null;
        this.f12803q = null;
        this.f12804r = null;
        this.f12805s = null;
        this.f12806t = null;
        this.f12807u = null;
        this.f12808v = null;
        this.f12809w = null;
        this.f12802p = null;
        this.f12801o = null;
        this.f12777Q = 0;
        this.f12778R = 0;
        this.f12779S = 0;
        this.f12774N = 0;
        this.f12775O = 0;
        this.f12776P = 0;
    }

    /* renamed from: N */
    public void m17284N() {
        C11839m.m70688i("AddressLogicProcess", "End sync for source " + this.mModuleName);
        this.f12810x = null;
        this.f12811y = null;
        this.f12812z = null;
        this.f12762B = null;
        this.f12763C = null;
        this.f12803q = null;
        this.f12804r = null;
        this.f12805s = null;
        this.f12806t = null;
        this.f12807u = null;
        this.f12808v = null;
        this.f12809w = null;
        this.f12766F = null;
        this.f12767G = null;
    }

    /* renamed from: O */
    public void m17285O() {
        this.f12774N = 0;
        this.f12775O = 0;
        this.f12776P = 0;
        this.f12777Q = 0;
        this.f12778R = 0;
        this.f12779S = 0;
        m17282L();
    }

    /* renamed from: P */
    public void m17286P(int i10, String str) throws JSONException {
        C2975d.m17840d(this.mContext, m17272r(this.mContext), -2, m17273s(this.mContext), i10, str, this.f12794h);
    }

    /* renamed from: Q */
    public void m17287Q(ModuleRst moduleRst) {
        if (moduleRst == null || moduleRst.getAllNum() <= 0) {
            return;
        }
        this.mContext.sendBroadcast(new Intent("com.huawei.hicloud.CONTACT_RESTORE_FINISHED"), "com.huawei.hicloud.permission.CONTACT_RESTORE_FINISHED");
    }

    /* renamed from: R */
    public void m17288R() {
        try {
            Uri uriBuild = ContactsContract.AUTHORITY_URI.buildUpon().appendPath("merge_groups").build();
            ContentValues contentValues = new ContentValues();
            contentValues.put("ACCOUNT_TYPE", C2880e.m17353b());
            contentValues.put("ACCOUNT_NAME", C2880e.m17352a());
            this.mContext.getContentResolver().update(uriBuild, contentValues, null, null);
        } catch (Exception e10) {
            C11839m.m70688i("AddressLogicProcess", "merge_groups URI update failed = " + e10.toString());
        }
    }

    /* renamed from: S */
    public final void m17289S(Map<String, List<Record>> map, Map<String, List<FailRet>> map2) throws C9722c {
        ArrayList<C11848c> arrayList = this.f12771K;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        List<Record> arrayList2 = map.get("addSuccessList") == null ? new ArrayList<>() : map.get("addSuccessList");
        List<FailRet> arrayList3 = map2.get("addFailList") == null ? new ArrayList<>() : map2.get("addFailList");
        HashMap map3 = new HashMap();
        ArrayList arrayList4 = new ArrayList();
        if (arrayList2 != null) {
            for (Record record : arrayList2) {
                if (record != null) {
                    map3.put(record.getId(), record);
                }
            }
        }
        Iterator<C11848c> it = this.f12771K.iterator();
        while (it.hasNext()) {
            C11848c next = it.next();
            String guid = next.getGuid();
            Record record2 = (Record) map3.get(guid);
            if (record2 != null) {
                next.setGuid(guid);
                next.setEtag(String.valueOf(record2.getVersion()));
                arrayList4.add(next);
            }
        }
        this.f12778R += m17253I(arrayList4, false, null);
        C11839m.m70688i("AddressLogicProcess", "syncV2 local suc add group size: " + arrayList4.size() + ", dataType = " + this.mDataType);
        if (arrayList3 == null || arrayList3.isEmpty()) {
            return;
        }
        C11839m.m70688i("AddressLogicProcess", "syncV2 local fail group size = " + arrayList3.size() + ", dataType = " + this.mDataType);
        baseBeanParseFailList(this.f12771K, arrayList3, "local_add_upload");
    }

    /* renamed from: T */
    public final void m17290T(Map<String, List<Record>> map, Map<String, List<FailRet>> map2) throws C9722c {
        ArrayList<C11848c> arrayList = this.f12772L;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        List<Record> arrayList2 = map.get("updateSuccessList") == null ? new ArrayList<>() : map.get("updateSuccessList");
        List<FailRet> arrayList3 = map2.get("updateFailList") == null ? new ArrayList<>() : map2.get("updateFailList");
        HashMap map3 = new HashMap();
        ArrayList arrayList4 = new ArrayList();
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            for (Record record : arrayList2) {
                if (record != null) {
                    map3.put(record.getId(), record);
                }
            }
        }
        Iterator<C11848c> it = this.f12772L.iterator();
        while (it.hasNext()) {
            C11848c next = it.next();
            Record record2 = (Record) map3.get(next.getGuid());
            if (record2 != null) {
                next.setEtag(String.valueOf(record2.getVersion()));
                arrayList4.add(next);
            }
        }
        this.f12778R += m17253I(arrayList4, false, null);
        C11839m.m70688i("AddressLogicProcess", "syncV2 local suc update group size: " + arrayList4.size() + ", dataType = " + this.mDataType);
        if (arrayList3 == null || arrayList3.isEmpty()) {
            return;
        }
        C11839m.m70688i("AddressLogicProcess", "syncV2 local fail update group size = " + arrayList3.size() + ", dataType = " + this.mDataType);
        baseBeanParseFailList(this.f12772L, arrayList3, "local_modify_upload");
    }

    /* renamed from: U */
    public final void m17291U(Map<String, String> map, List<Record> list) throws C9722c, IOException {
        ArrayList<C11847b> arrayList = this.f12807u;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        C11839m.m70688i("AddressLogicProcess", "syncV2 local add size = " + this.f12807u.size() + ", dataType = " + this.mDataType);
        List<String> listGenerateGuids = generateGuids(this.mSyncType, this.mDataType, Integer.valueOf(this.f12807u.size()));
        checkGuids(listGenerateGuids, this.f12807u.size(), "local_add_upload");
        for (int i10 = 0; i10 < listGenerateGuids.size(); i10++) {
            C11847b c11847b = this.f12807u.get(i10);
            c11847b.setGuid(listGenerateGuids.get(i10));
            Record record = new Record();
            record.setId(listGenerateGuids.get(i10));
            C2882g c2882gM70940a = c11847b.m70940a();
            if (c2882gM70940a == null) {
                throw new C9722c(2220, "syncV2 data is null", this.mSyncType, "local_add_upload");
            }
            if (encryptDataV2(this.traceId, record, this.mSyncType, c11847b.getLuid(), C2885j.m17577k(c2882gM70940a), null, "local_add_upload") == null) {
                throw new C9722c(2220, "syncV2 encryptData data is null", this.mSyncType, "local_add_upload");
            }
            record.setRecycled(Boolean.FALSE);
            list.add(record);
            map.put(record.getId(), SyncProtocol.Constant.ADD);
        }
    }

    /* renamed from: V */
    public final void m17292V() throws Throwable {
        ArrayList<C11847b> arrayList = this.f12809w;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        C11839m.m70688i("AddressLogicProcess", "syncV2 local delete size = " + this.f12809w.size() + ", dataType = " + this.mDataType);
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        m17299c0(map, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        updateRecycleRecords(arrayList2, arrayList3, arrayList4, "local_soft_delete_upload");
        if (!arrayList3.isEmpty()) {
            C11839m.m70688i("AddressLogicProcess", "syncV2 local delete success size = " + arrayList3.size());
            ArrayList arrayList5 = new ArrayList();
            for (Record record : arrayList3) {
                if (record != null) {
                    String str = map.get(record.getId());
                    if (!TextUtils.isEmpty(str)) {
                        arrayList5.add(str);
                    }
                }
            }
            if (!arrayList5.isEmpty()) {
                m17269o(arrayList5);
            }
        }
        if (arrayList4.isEmpty()) {
            return;
        }
        baseBeanParseFailList(this.f12809w, arrayList4, "local_soft_delete_upload");
        C11839m.m70688i("AddressLogicProcess", "syncV2 local delete fail contact size = " + arrayList4.size() + ", dataType = " + this.mDataType);
    }

    /* renamed from: W */
    public final void m17293W() throws Throwable {
        Map<String, C11847b> map = this.f12795i;
        if (map == null || map.size() <= 0) {
            return;
        }
        isCancel();
        this.f12789c = true;
        Iterator<Map.Entry<String, C11847b>> it = this.f12795i.entrySet().iterator();
        while (it.hasNext()) {
            this.f12807u.add(it.next().getValue());
            if (100 == this.f12807u.size()) {
                isCancel();
                if (!this.f12781U) {
                    this.f12792f.m17231m(this.f12807u);
                }
                m17297a0();
                this.f12807u.clear();
            }
        }
        if (this.f12807u.size() > 0) {
            isCancel();
            if (!this.f12781U) {
                this.f12792f.m17231m(this.f12807u);
            }
            m17297a0();
            this.f12807u.clear();
        }
    }

    /* renamed from: X */
    public void m17294X() throws Throwable {
        m17295Y();
        m17296Z();
        m17293W();
        this.f12787a = true;
    }

    /* renamed from: Y */
    public final void m17295Y() throws Throwable {
        Map<String, C11847b> map = this.f12797k;
        if (map == null || map.size() <= 0) {
            return;
        }
        isCancel();
        this.f12789c = true;
        Iterator<Map.Entry<String, C11847b>> it = this.f12797k.entrySet().iterator();
        while (it.hasNext()) {
            this.f12809w.add(it.next().getValue());
            if (100 == this.f12809w.size()) {
                isCancel();
                this.f12792f.m17231m(this.f12809w);
                m17292V();
                this.f12809w.clear();
            }
        }
        if (this.f12809w.size() > 0) {
            isCancel();
            this.f12792f.m17231m(this.f12809w);
            m17292V();
            this.f12809w.clear();
        }
    }

    /* renamed from: Z */
    public final void m17296Z() throws Throwable {
        Map<String, C11847b> map = this.f12796j;
        if (map == null || map.size() <= 0) {
            return;
        }
        isCancel();
        this.f12789c = true;
        Iterator<Map.Entry<String, C11847b>> it = this.f12796j.entrySet().iterator();
        while (it.hasNext()) {
            this.f12808v.add(it.next().getValue());
            if (100 == this.f12808v.size()) {
                isCancel();
                this.f12792f.m17231m(this.f12808v);
                m17298b0();
                this.f12808v.clear();
            }
        }
        if (this.f12808v.size() > 0) {
            isCancel();
            this.f12792f.m17231m(this.f12808v);
            m17298b0();
            this.f12808v.clear();
        }
        this.f12792f.m17231m(this.f12808v);
    }

    /* renamed from: a0 */
    public final void m17297a0() throws Throwable {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        checkIsHasPartialException(this.mSyncType);
        m17291U(map, arrayList);
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        createRecords(Constants.NORMAL_CACHE, arrayList, map2, map3);
        parseAddDataV2(map2, map3);
    }

    /* renamed from: b0 */
    public final void m17298b0() throws Throwable {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        m17309m0(map, arrayList);
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        updateRecords(Constants.NORMAL_CACHE, arrayList, map2, map3);
        parseUpdateDataV2(map2, map3);
    }

    /* renamed from: c0 */
    public final void m17299c0(Map<String, String> map, List<Record> list) throws C9722c {
        ArrayList<C11847b> arrayList = this.f12809w;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        C11839m.m70688i("AddressLogicProcess", "syncV2 processDelteDataV2 local delete size = " + this.f12809w.size());
        Iterator<C11847b> it = this.f12809w.iterator();
        while (it.hasNext()) {
            C11847b next = it.next();
            String guid = next.getGuid();
            map.put(guid, next.getLuid());
            Record record = new Record();
            record.setId(guid);
            record.setRecycled(Boolean.TRUE);
            list.add(record);
        }
    }

    /* renamed from: d0 */
    public final void m17300d0(Map<String, String> map, List<Record> list) throws C9722c, IOException {
        ArrayList<C11848c> arrayList = this.f12771K;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        C11839m.m70688i("AddressLogicProcess", "syncV2 local add size = " + this.f12771K.size() + ", dataType = " + this.mDataType);
        List<String> listGenerateGuids = generateGuids(this.mSyncType, this.mDataType, Integer.valueOf(this.f12771K.size()));
        checkGuids(listGenerateGuids, this.f12771K.size(), "local_add_upload");
        for (int i10 = 0; i10 < listGenerateGuids.size(); i10++) {
            C11848c c11848c = this.f12771K.get(i10);
            c11848c.setGuid(listGenerateGuids.get(i10));
            Record record = new Record();
            record.setId(listGenerateGuids.get(i10));
            C2890o c2890oM70942a = c11848c.m70942a();
            if (c2890oM70942a == null) {
                throw new C9722c(2220, "syncV2 data is null", this.mSyncType, "local_add_upload");
            }
            m17255a(c2890oM70942a);
            if (encryptDataV2(this.traceId, record, this.mSyncType, c11848c.getLuid(), C2887l.m17601b(c2890oM70942a, true), null, "local_add_upload") == null) {
                throw new C9722c(2220, "syncV2 encryptData data is null", this.mSyncType, "local_add_upload");
            }
            record.setRecycled(Boolean.FALSE);
            list.add(record);
            map.put(record.getId(), SyncProtocol.Constant.ADD);
        }
    }

    /* renamed from: e0 */
    public final void m17301e0() throws Throwable {
        ArrayList<C11848c> arrayList = this.f12773M;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        C11839m.m70688i("AddressLogicProcess", "syncV2 local delete size = " + this.f12773M.size() + ", dataType = " + this.mDataType);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        HashMap map = new HashMap();
        Iterator<C11848c> it = this.f12773M.iterator();
        while (it.hasNext()) {
            arrayList4.add(it.next().getGuid());
        }
        deleteRecords(this.mSyncType, this.mDataType, arrayList4, arrayList2, arrayList3, "local_delete_upload");
        C11839m.m70688i("AddressLogicProcess", "syncV2 local delete success size = " + arrayList2.size() + ", fail size = " + arrayList3.size() + ", dataType = " + this.mDataType);
        if (!arrayList2.isEmpty()) {
            ArrayList arrayList5 = new ArrayList();
            Iterator<C11848c> it2 = this.f12773M.iterator();
            while (it2.hasNext()) {
                C11848c next = it2.next();
                if (next != null) {
                    String luid = next.getLuid();
                    String guid = next.getGuid();
                    map.put(guid, luid);
                    if (arrayList2.contains(guid)) {
                        arrayList5.add(luid);
                    }
                }
            }
            if (!arrayList5.isEmpty()) {
                m17269o(arrayList5);
            }
        }
        if (arrayList3.isEmpty()) {
            return;
        }
        baseBeanParseFailList(this.f12809w, arrayList3, "local_soft_delete_upload");
        C11839m.m70688i("AddressLogicProcess", "syncV2 local delete fail group size = " + arrayList3.size() + ", dataType = " + this.mDataType);
    }

    /* renamed from: f0 */
    public final void m17302f0() throws Throwable {
        Map<String, C11848c> map = this.f12810x;
        if (map == null || map.size() <= 0) {
            return;
        }
        isCancel();
        this.f12790d = true;
        Iterator<Map.Entry<String, C11848c>> it = this.f12810x.entrySet().iterator();
        while (it.hasNext()) {
            this.f12771K.add(it.next().getValue());
            if (100 == this.f12771K.size()) {
                isCancel();
                m17307k0();
                this.f12771K.clear();
            }
        }
        if (this.f12771K.size() > 0) {
            isCancel();
            m17307k0();
            this.f12771K.clear();
        }
    }

    /* renamed from: g0 */
    public void m17303g0() throws Throwable {
        m17304h0();
        m17305i0();
        m17302f0();
        this.f12788b = true;
    }

    /* renamed from: h0 */
    public final void m17304h0() throws Throwable {
        Map<String, C11848c> map = this.f12812z;
        if (map == null || map.size() <= 0) {
            return;
        }
        isCancel();
        this.f12790d = true;
        Iterator<Map.Entry<String, C11848c>> it = this.f12812z.entrySet().iterator();
        while (it.hasNext()) {
            this.f12773M.add(it.next().getValue());
            if (100 == this.f12773M.size()) {
                isCancel();
                m17301e0();
                this.f12773M.clear();
            }
        }
        if (this.f12773M.size() > 0) {
            isCancel();
            m17301e0();
            this.f12773M.clear();
        }
    }

    /* renamed from: i0 */
    public final void m17305i0() throws Throwable {
        Map<String, C11848c> map = this.f12811y;
        if (map == null || map.size() <= 0) {
            return;
        }
        isCancel();
        this.f12790d = true;
        Iterator<Map.Entry<String, C11848c>> it = this.f12811y.entrySet().iterator();
        while (it.hasNext()) {
            this.f12772L.add(it.next().getValue());
            if (100 == this.f12772L.size()) {
                isCancel();
                m17308l0();
                this.f12772L.clear();
            }
        }
        if (this.f12772L.size() > 0) {
            isCancel();
            m17308l0();
            this.f12772L.clear();
        }
    }

    public boolean isNeedQueryCloudDataV2() {
        return this.f12785Y != 3 || isCloudDataChanged(this.f12786Z, 1) || C13007b.m78205Y(this.mContext).m78298z(this.mSyncType, this.mDataType);
    }

    /* renamed from: j0 */
    public final void m17306j0(Map<String, String> map, List<Record> list) throws C9722c {
        ArrayList<C11848c> arrayList = this.f12772L;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        C11839m.m70688i("AddressLogicProcess", "syncV2 local update size = " + this.f12772L.size() + ", dataType = " + this.mDataType);
        Iterator<C11848c> it = this.f12772L.iterator();
        while (it.hasNext()) {
            C11848c next = it.next();
            map.put(next.getGuid(), SyncProtocol.Constant.UPDATE);
            Record record = new Record();
            record.setId(next.getGuid());
            C2890o c2890oM70942a = next.m70942a();
            if (c2890oM70942a == null) {
                throw new C9722c(2220, "syncV2 data is null", this.mSyncType, "local_modify_upload");
            }
            m17255a(c2890oM70942a);
            if (encryptDataV2(this.traceId, record, this.mSyncType, next.getLuid(), C2887l.m17601b(c2890oM70942a, true), null, "local_modify_upload") == null) {
                throw new C9722c(2220, "syncV2 encryptData data is null", this.mSyncType, "local_modify_upload");
            }
            record.setRecycled(Boolean.FALSE);
            list.add(record);
        }
    }

    /* renamed from: k0 */
    public final void m17307k0() throws Throwable {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        checkIsHasPartialException(this.mSyncType);
        m17300d0(map, arrayList);
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        createRecords(Constants.NORMAL_CACHE, arrayList, map2, map3);
        m17289S(map2, map3);
    }

    /* renamed from: l0 */
    public final void m17308l0() throws Throwable {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        m17306j0(map, arrayList);
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        updateRecords(Constants.NORMAL_CACHE, arrayList, map2, map3);
        m17290T(map2, map3);
    }

    /* renamed from: m0 */
    public final void m17309m0(Map<String, String> map, List<Record> list) throws C9722c {
        ArrayList<C11847b> arrayList = this.f12808v;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        C11839m.m70688i("AddressLogicProcess", "syncV2 local update size = " + this.f12808v.size() + ", dataType = " + this.mDataType);
        Iterator<C11847b> it = this.f12808v.iterator();
        while (it.hasNext()) {
            C11847b next = it.next();
            map.put(next.getGuid(), SyncProtocol.Constant.UPDATE);
            Record record = new Record();
            record.setId(next.getGuid());
            C2882g c2882gM70940a = next.m70940a();
            if (c2882gM70940a == null) {
                throw new C9722c(2220, "syncV2 data is null", this.mSyncType, "local_modify_upload");
            }
            if (encryptDataV2(this.traceId, record, this.mSyncType, next.getLuid(), C2885j.m17577k(c2882gM70940a), null, "local_modify_upload") == null) {
                throw new C9722c(2220, "syncV2 encryptData data is null", this.mSyncType, "local_modify_upload");
            }
            record.setRecycled(Boolean.FALSE);
            list.add(record);
        }
    }

    /* renamed from: n0 */
    public final void m17310n0(List<String> list) throws C9722c {
        C11847b c11847b;
        isCancel();
        m17311o0(this.mSyncType, this.mDataType, list);
        Map<String, C2924c> map = this.cloudData;
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, C2924c> entry : this.cloudData.entrySet()) {
            String key = entry.getKey();
            C2924c value = entry.getValue();
            Map<String, C11847b> map2 = this.f12799m;
            if (map2 == null || !map2.containsKey(key)) {
                Map<String, C11847b> map3 = this.f12800n;
                if (map3 != null && map3.containsKey(key) && (c11847b = this.f12800n.get(key)) != null) {
                    c11847b.m70941b(C2888m.m17629u(value.m17741a()));
                    Map<String, C11847b> map4 = this.f12802p;
                    if (map4 != null) {
                        map4.put(key, this.f12800n.get(key));
                    }
                }
            } else {
                C11847b c11847b2 = this.f12799m.get(key);
                if (c11847b2 != null) {
                    c11847b2.m70941b(C2888m.m17629u(value.m17741a()));
                    Map<String, C11847b> map5 = this.f12801o;
                    if (map5 != null) {
                        map5.put(key, this.f12799m.get(key));
                    }
                }
            }
        }
    }

    /* renamed from: o0 */
    public void m17311o0(String str, String str2, List<String> list) throws C9722c {
        this.cloudData = new HashMap();
        ArrayList<Record> recordsDataByIdList = getRecordsDataByIdList(str, str2, list, "records(attributes,cipher,createdTime,editedTime,id,kind,recycled,recycledTime,status,version)", "getData");
        if (recordsDataByIdList.isEmpty()) {
            return;
        }
        for (Record record : recordsDataByIdList) {
            this.cloudData.put(record.getId(), new C2924c(getDecryptData(str, record)));
        }
    }

    /* renamed from: p0 */
    public final void m17312p0(List<String> list) throws C9722c {
        isCancel();
        m17311o0(this.mSyncType, this.mDataType, list);
        Map<String, C2924c> map = this.cloudData;
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, C2924c> entry : this.cloudData.entrySet()) {
            String key = entry.getKey();
            String strM17741a = entry.getValue().m17741a();
            if (this.f12762B.containsKey(key)) {
                this.f12762B.get(key).m70944c(C2887l.m17607h(strM17741a));
                this.f12766F.put(key, this.f12762B.get(key));
            } else if (this.f12763C.containsKey(key)) {
                this.f12763C.get(key).m70944c(C2887l.m17607h(strM17741a));
                this.f12767G.put(key, this.f12763C.get(key));
            } else if (this.f12764D.containsKey(key)) {
                this.f12764D.get(key).m70944c(C2887l.m17607h(strM17741a));
                this.f12768H.put(key, this.f12764D.get(key));
            }
        }
    }

    public final void parseAddDataV2(Map<String, List<Record>> map, Map<String, List<FailRet>> map2) throws C9722c {
        ArrayList<C11847b> arrayList = this.f12807u;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        List<Record> arrayList2 = map.get("addSuccessList") == null ? new ArrayList<>() : map.get("addSuccessList");
        List<FailRet> arrayList3 = map2.get("addFailList") == null ? new ArrayList<>() : map2.get("addFailList");
        HashMap map3 = new HashMap();
        ArrayList arrayList4 = new ArrayList();
        if (arrayList2 != null) {
            for (Record record : arrayList2) {
                if (record != null) {
                    map3.put(record.getId(), record);
                }
            }
        }
        Iterator<C11847b> it = this.f12807u.iterator();
        while (it.hasNext()) {
            C11847b next = it.next();
            String guid = next.getGuid();
            Record record2 = (Record) map3.get(guid);
            if (record2 != null) {
                next.setGuid(guid);
                next.setEtag(String.valueOf(record2.getVersion()));
                arrayList4.add(next);
            }
        }
        this.f12778R += m17251G(arrayList4, false, null);
        C11839m.m70688i("AddressLogicProcess", "syncV2 local suc add contact size: " + arrayList4.size() + ", dataType = " + this.mDataType);
        if (arrayList3 == null || arrayList3.isEmpty()) {
            return;
        }
        C11839m.m70688i("AddressLogicProcess", "syncV2 local fail contact size = " + arrayList3.size() + ", dataType = " + this.mDataType);
        baseBeanParseFailList(this.f12807u, arrayList3, "local_add_upload");
    }

    public final void parseUpdateDataV2(Map<String, List<Record>> map, Map<String, List<FailRet>> map2) throws C9722c {
        ArrayList<C11847b> arrayList = this.f12808v;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        List<Record> arrayList2 = map.get("updateSuccessList") == null ? new ArrayList<>() : map.get("updateSuccessList");
        List<FailRet> arrayList3 = map2.get("updateFailList") == null ? new ArrayList<>() : map2.get("updateFailList");
        HashMap map3 = new HashMap();
        ArrayList arrayList4 = new ArrayList();
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            for (Record record : arrayList2) {
                if (record != null) {
                    map3.put(record.getId(), record);
                }
            }
        }
        Iterator<C11847b> it = this.f12808v.iterator();
        while (it.hasNext()) {
            C11847b next = it.next();
            Record record2 = (Record) map3.get(next.getGuid());
            if (record2 != null) {
                next.setEtag(String.valueOf(record2.getVersion()));
                arrayList4.add(next);
            }
        }
        this.f12778R += m17251G(arrayList4, false, null);
        C11839m.m70688i("AddressLogicProcess", "syncV2 local suc update contact size: " + arrayList4.size() + ", dataType = " + this.mDataType);
        if (arrayList3 == null || arrayList3.isEmpty()) {
            return;
        }
        C11839m.m70688i("AddressLogicProcess", "syncV2 local fail update contact size = " + arrayList3.size() + ", dataType = " + this.mDataType);
        baseBeanParseFailList(this.f12808v, arrayList3, "local_modify_upload");
    }

    public void processCloudData() throws Throwable {
        updateLocalData();
        m17271q(this.f12803q);
    }

    /* renamed from: q0 */
    public void m17313q0() {
        this.f12804r = new ArrayList<>();
        this.f12803q = new ArrayList<>();
        this.f12805s = new ArrayList<>();
        this.f12806t = new ArrayList<>();
        this.f12807u = new ArrayList<>();
        this.f12808v = new ArrayList<>();
        this.f12809w = new ArrayList<>();
    }

    /* renamed from: r0 */
    public void m17314r0() {
        this.f12804r = new ArrayList<>();
        this.f12803q = new ArrayList<>();
        this.f12769I = new ArrayList<>();
        this.f12770J = new ArrayList<>();
        this.f12771K = new ArrayList<>();
        this.f12772L = new ArrayList<>();
        this.f12773M = new ArrayList<>();
        this.f12791e = true;
    }

    /* renamed from: s0 */
    public void m17315s0(int i10) throws Throwable {
        try {
            C11839m.m70688i("AddressLogicProcess", "[contact]syncV2 unLock, value = " + i10);
            String strM78224J = C13007b.m78205Y(this.mContext).m78224J(this.mSyncType, this.mSyncModulePackageName);
            if ("addressbook".equals(this.mModuleName)) {
                if (i10 != 14 && (this.f12789c || this.f12790d)) {
                    this.ctagList.clear();
                    ArrayList arrayList = new ArrayList();
                    m17316t0(arrayList);
                    m17319w0(arrayList);
                    m17252H(true);
                    if (!TextUtils.isEmpty(strM78224J)) {
                        unlockV2(this.mSyncType);
                        return;
                    }
                    C11839m.m70689w("AddressLogicProcess", "syncV2 x-hw-lock is null or empty, don't need unlock, syncType = " + this.mSyncType);
                    return;
                }
                C11839m.m70686d("AddressLogicProcess", "syncV2 no ctag need update");
                if (!TextUtils.isEmpty(strM78224J)) {
                    unlockV2(this.mSyncType);
                    return;
                }
                C11839m.m70689w("AddressLogicProcess", "syncV2 x-hw-lock is null or empty, don't need unlock, syncType = " + this.mSyncType);
            }
        } catch (C12127a e10) {
            C11839m.m70687e("AddressLogicProcess", "syncV2 unlock SyncProtocolException ,errorCode = " + e10.m60666c() + ", errorMessage = " + e10.getMessage());
        } catch (C12128b e11) {
            C11839m.m70687e("AddressLogicProcess", "syncV2 unlock SyncTransportException ,errorCode = " + e11.m60666c() + ", errorMessage = " + e11.getMessage());
        } catch (Exception e12) {
            C11839m.m70687e("AddressLogicProcess", "syncV2 unlock Exception ,errorCode = " + e12.toString());
        }
    }

    /* renamed from: t0 */
    public final void m17316t0(List<C2925d> list) {
        if (this.f12789c) {
            String strGenerateCtag = generateCtag();
            C2925d c2925d = new C2925d();
            c2925d.m17754g(HNConstants.DataType.CONTACT);
            Map<String, Object> mapM17751d = c2925d.m17751d();
            mapM17751d.put(SyncProtocol.Constant.CTAG, strGenerateCtag);
            mapM17751d.put("lastctag", getLocalCtag(HNConstants.DataType.CONTACT));
            if (this.f12787a) {
                C11839m.m70686d("AddressLogicProcess", "update contact ctag, newCtag = " + strGenerateCtag);
                CtagInfo ctagInfo = new CtagInfo();
                ctagInfo.setCtagName(HNConstants.DataType.CONTACT);
                ctagInfo.setCtagValue(strGenerateCtag);
                this.ctagList.add(ctagInfo);
            }
            list.add(c2925d);
        }
    }

    /* renamed from: u0 */
    public final void m17317u0() throws C9722c, InterruptedException {
        ArrayList<C11847b> arrayList;
        ArrayList<C11847b> arrayList2;
        isCancel();
        Map<String, C11847b> map = this.f12801o;
        if (map != null) {
            for (Map.Entry<String, C11847b> entry : map.entrySet()) {
                if (entry != null && (arrayList2 = this.f12805s) != null) {
                    arrayList2.add(entry.getValue());
                }
            }
        }
        m17318v0(this.f12805s, 1);
        Map<String, C11847b> map2 = this.f12801o;
        if (map2 != null) {
            map2.clear();
        }
        ArrayList<C11847b> arrayList3 = this.f12805s;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        Map<String, C11847b> map3 = this.f12802p;
        if (map3 != null) {
            for (Map.Entry<String, C11847b> entry2 : map3.entrySet()) {
                if (entry2 != null && (arrayList = this.f12806t) != null) {
                    arrayList.add(entry2.getValue());
                }
            }
        }
        m17318v0(this.f12806t, 2);
        Map<String, C11847b> map4 = this.f12802p;
        if (map4 != null) {
            map4.clear();
        }
        ArrayList<C11847b> arrayList4 = this.f12806t;
        if (arrayList4 != null) {
            arrayList4.clear();
        }
    }

    public final void updateLocalData() throws Throwable {
        int size;
        Map<String, C11847b> map;
        ArrayList<String> arrayList = this.f12804r;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        if (HNConstants.DataType.CONTACT.equals(this.f12786Z) && (map = this.f12795i) != null && map.size() < 300 && this.f12795i.size() > 0) {
            this.f12781U = true;
            this.f12792f.m17230l(this.f12795i, false);
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f12804r.size(); i11 = size) {
            isCancel();
            int i12 = i10 * 100;
            size = i12 + 100;
            if (size > this.f12804r.size()) {
                size = this.f12804r.size();
            }
            if (HNConstants.DataType.CONTACT.equals(this.f12786Z)) {
                m17310n0(this.f12804r.subList(i12, size));
                Map<String, C11847b> map2 = this.f12795i;
                if (map2 != null && map2.size() > 0) {
                    m17258d();
                }
                m17317u0();
            } else {
                m17312p0(this.f12804r.subList(i12, size));
                if (this.f12810x.size() > 0) {
                    m17265k();
                }
                if (this.f12765E.size() > 0) {
                    m17263i();
                }
                m17320x0();
            }
            i10++;
        }
    }

    /* renamed from: v0 */
    public final void m17318v0(ArrayList<C11847b> arrayList, int i10) throws InterruptedException, C9722c {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < arrayList.size()) {
            int i13 = i12 * 20;
            int size = i13 + 20;
            if (size > arrayList.size()) {
                size = arrayList.size();
            }
            m17249E();
            if (1 == i10) {
                this.f12774N += m17251G(this.f12792f.m17220b(arrayList.subList(i13, size)), false, null);
                C11839m.m70686d("AddressLogicProcess", "local add data = " + this.f12774N);
            } else if (2 == i10) {
                this.f12775O += m17251G(this.f12792f.m17215R(arrayList.subList(i13, size)), false, null);
                C11839m.m70686d("AddressLogicProcess", "local modify data = " + this.f12775O);
            }
            i12++;
            i11 = size;
        }
    }

    /* renamed from: w0 */
    public final void m17319w0(List<C2925d> list) {
        if (this.f12790d) {
            String strGenerateCtag = generateCtag();
            C2925d c2925d = new C2925d();
            c2925d.m17754g("group");
            Map<String, Object> mapM17751d = c2925d.m17751d();
            mapM17751d.put(SyncProtocol.Constant.CTAG, strGenerateCtag);
            mapM17751d.put("lastctag", getLocalCtag("group"));
            if (this.f12788b) {
                C11839m.m70686d("AddressLogicProcess", "update group ctag, newCtag = " + strGenerateCtag);
                CtagInfo ctagInfo = new CtagInfo();
                ctagInfo.setCtagName("group");
                ctagInfo.setCtagValue(strGenerateCtag);
                this.ctagList.add(ctagInfo);
            }
            list.add(c2925d);
        }
    }

    /* renamed from: x0 */
    public final void m17320x0() throws C9722c, InterruptedException {
        isCancel();
        Iterator<Map.Entry<String, C11848c>> it = this.f12766F.entrySet().iterator();
        while (it.hasNext()) {
            this.f12769I.add(it.next().getValue());
        }
        m17321y0(this.f12769I, 1);
        this.f12766F.clear();
        this.f12769I.clear();
        Iterator<Map.Entry<String, C11848c>> it2 = this.f12767G.entrySet().iterator();
        while (it2.hasNext()) {
            this.f12770J.add(it2.next().getValue());
        }
        m17321y0(this.f12770J, 2);
        this.f12767G.clear();
        this.f12770J.clear();
    }

    /* renamed from: y0 */
    public final void m17321y0(ArrayList<C11848c> arrayList, int i10) throws C9722c, InterruptedException {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < arrayList.size()) {
            isCancel();
            int i13 = i12 * 20;
            int size = i13 + 20;
            if (size > arrayList.size()) {
                size = arrayList.size();
            }
            m17249E();
            if (1 == i10) {
                this.f12774N += m17253I(this.f12792f.m17222d(arrayList.subList(i13, size)), false, null);
            } else if (2 == i10) {
                this.f12775O += m17253I(this.f12792f.m17218U(arrayList.subList(i13, size)), false, null);
            }
            i12++;
            i11 = size;
        }
    }
}
