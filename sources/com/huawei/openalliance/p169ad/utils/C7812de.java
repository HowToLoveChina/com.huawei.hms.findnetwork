package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7131fo;
import com.huawei.openalliance.p169ad.C7484ms;
import com.huawei.openalliance.p169ad.InterfaceC7151gh;
import com.huawei.openalliance.p169ad.beans.tags.TagCfgModel;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.constant.TagConstants;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.utils.de */
/* loaded from: classes2.dex */
public class C7812de {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static List<String> m48354b(Context context, List<TagCfgModel> list) {
        ArrayList arrayList = new ArrayList();
        for (TagCfgModel tagCfgModel : list) {
            String strM40966a = tagCfgModel.m40966a();
            long jMo43560e = C7131fo.m43547a(context).mo43560e(strM40966a);
            long j10 = Integer.parseInt(tagCfgModel.m40968c());
            AbstractC7185ho.m43818a("TagSyncUtil", "sync tag: %s, interval: %s", strM40966a, Long.valueOf(j10));
            if (j10 < 0) {
                AbstractC7185ho.m43820b("TagSyncUtil", "sync tag interval less than zero");
            } else if (AbstractC7741ao.m47566c() - jMo43560e <= j10 * 60000) {
                AbstractC7185ho.m43818a("TagSyncUtil", "query tag %s , intvl not satisfied", strM40966a);
            } else {
                arrayList.add(strM40966a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m48352a(final Context context) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.de.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                List<TagCfgModel> listMo43440ck = C7124fh.m43316b(context).mo43440ck();
                if (AbstractC7760bg.m47767a(listMo43440ck)) {
                    str = "no tag need to sync";
                } else {
                    List<String> listM48354b = C7812de.m48354b(context, listMo43440ck);
                    if (!AbstractC7760bg.m47767a(listM48354b)) {
                        C7131fo.m43547a(context).mo43555a(listM48354b, AbstractC7741ao.m47566c());
                        AbstractC7185ho.m43818a("TagSyncUtil", "do sync tag, need sync tag list is : %s", listM48354b);
                        try {
                            C7484ms.m45854a(context).m45855a(RTCMethods.QUERY_USER_TAG, AbstractC7760bg.m47765a(listM48354b, ","), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.utils.de.1.1
                                @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                                public void onRemoteCallResult(String str2, CallResult<String> callResult) {
                                    if (callResult == null || callResult.getCode() != 200) {
                                        return;
                                    }
                                    AbstractC7185ho.m43820b("TagSyncUtil", "sync tag method execute success");
                                    if (AbstractC7806cz.m48165b(callResult.getData())) {
                                        AbstractC7185ho.m43817a("TagSyncUtil", "sync tag data is empty");
                                    } else {
                                        C7812de.m48355b(context, callResult.getData());
                                    }
                                }
                            }, String.class);
                            return;
                        } catch (Throwable th2) {
                            AbstractC7185ho.m43824c("TagSyncUtil", "sync tag failed: %s", th2.getClass().getSimpleName());
                            return;
                        }
                    }
                    str = "interval failed, no need to sync tag";
                }
                AbstractC7185ho.m43820b("TagSyncUtil", str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m48355b(Context context, String str) {
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray(TagConstants.TAG_LIST_KEY);
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                    if (AbstractC7806cz.m48165b(jSONObjectOptJSONObject.toString())) {
                        AbstractC7185ho.m43817a("TagSyncUtil", "tag obj is empty , no need to save");
                    } else {
                        InterfaceC7151gh interfaceC7151ghM43547a = C7131fo.m43547a(context);
                        String strOptString = jSONObjectOptJSONObject.optString("type");
                        String strOptString2 = jSONObjectOptJSONObject.optString("value");
                        interfaceC7151ghM43547a.mo43554a(strOptString, strOptString2);
                        long jOptLong = jSONObjectOptJSONObject.optLong("updateTime");
                        interfaceC7151ghM43547a.mo43553a(strOptString, jOptLong);
                        int iOptInt = jSONObjectOptJSONObject.optInt(TagConstants.TRIGGER_MODE);
                        interfaceC7151ghM43547a.mo43552a(strOptString, iOptInt);
                        AbstractC7185ho.m43818a("TagSyncUtil", "save tag to sp, type: %s, tagValue is : %s, updateTime is : %s, triggerMode is : %s", strOptString, strOptString2, Long.valueOf(jOptLong), Integer.valueOf(iOptInt));
                    }
                }
                return;
            }
            AbstractC7185ho.m43817a("TagSyncUtil", "tag array is empty, no need to save");
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("TagSyncUtil", "saveTagData error: %s", th2.getClass().getSimpleName());
        }
    }
}
