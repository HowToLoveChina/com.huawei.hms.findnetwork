package com.huawei.openalliance.p169ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7484ms;
import com.huawei.openalliance.p169ad.C7565oz;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.constant.SpKeys;
import com.huawei.openalliance.p169ad.inter.data.LinkedSplashAd;
import com.huawei.openalliance.p169ad.inter.listeners.IExSplashCallback;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.inter.b */
/* loaded from: classes2.dex */
public class C7287b extends BroadcastReceiver {

    /* renamed from: a */
    private Context f33524a;

    /* renamed from: b */
    private InterfaceC7146gc f33525b;

    public C7287b(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f33524a = applicationContext;
        this.f33525b = C7124fh.m43316b(applicationContext);
    }

    /* renamed from: b */
    private void m44223b(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("landpage_app_prompt");
        int iOptInt2 = jSONObject.optInt("splash_skip_area");
        String strOptString = jSONObject.optString("scheme_info");
        String strOptString2 = jSONObject.optString(MapKeyNames.GLOBAL_SWITCH);
        String strOptString3 = jSONObject.optString(MapKeyNames.LANDPAGE_APP_WHITE_LIST);
        String strOptString4 = jSONObject.optString(MapKeyNames.LANDPAGE_APP_PROMPT_MAP);
        String strOptString5 = jSONObject.optString(MapKeyNames.LANDPAGE_WEB_BLACK_LIST);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("ExLinkedSplashReceiver", "landPageAppPrompt:%s", Integer.valueOf(iOptInt));
            AbstractC7185ho.m43818a("ExLinkedSplashReceiver", "splashSkipArea=%s", Integer.valueOf(iOptInt2));
            AbstractC7185ho.m43818a("ExLinkedSplashReceiver", "schemeInfo=%s", AbstractC7819dl.m48375a(strOptString));
            AbstractC7185ho.m43818a("ExLinkedSplashReceiver", "globalSwitch=%s", AbstractC7819dl.m48375a(strOptString2));
            AbstractC7185ho.m43818a("ExLinkedSplashReceiver", "lpWhiteList=%s", AbstractC7819dl.m48375a(strOptString3));
            AbstractC7185ho.m43818a("ExLinkedSplashReceiver", "promptMapString=%s", AbstractC7819dl.m48375a(strOptString4));
            AbstractC7185ho.m43818a("ExLinkedSplashReceiver", "lpWebBlackList=%s", AbstractC7819dl.m48375a(strOptString5));
        }
        InterfaceC7146gc interfaceC7146gc = this.f33525b;
        if (interfaceC7146gc != null) {
            interfaceC7146gc.mo43465j(iOptInt);
            this.f33525b.mo43369b(iOptInt2);
            this.f33525b.mo43482p(strOptString2);
            if (!TextUtils.isEmpty(strOptString)) {
                List list = (List) AbstractC7758be.m47739b(strOptString, List.class, String.class);
                AbstractC7185ho.m43818a("ExLinkedSplashReceiver", " schemeInfo info=%s", Boolean.valueOf(list.isEmpty()));
                this.f33525b.mo43331a(new HashSet(list));
            }
            if (!TextUtils.isEmpty(strOptString3)) {
                List<String> list2 = (List) AbstractC7758be.m47739b(strOptString3, List.class, String.class);
                if (TextUtils.isEmpty(strOptString4)) {
                    this.f33525b.mo43329a(list2, (Map<String, Boolean>) null);
                } else {
                    this.f33525b.mo43329a(list2, (Map<String, Boolean>) AbstractC7758be.m47739b(strOptString4, Map.class, String.class, Boolean.class));
                }
            }
            if (TextUtils.isEmpty(strOptString5)) {
                return;
            }
            this.f33525b.mo43371b((List<String>) AbstractC7758be.m47739b(strOptString5, List.class, String.class));
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        Log.d("ExLinkedSplashReceiver", "onReceive.");
        if (intent == null) {
            return;
        }
        try {
            if (Constants.ACTION_EXSPLASH_START_LINKED.equals(intent.getAction())) {
                AbstractC7185ho.m43820b("ExLinkedSplashReceiver", "receiver exlinkedsplash action");
                long longExtra = intent.getLongExtra(SpKeys.EXSPLASH_SLOGAN_START_TIME, 0L);
                Long lValueOf = Long.valueOf(longExtra);
                int intExtra = intent.getIntExtra(SpKeys.EXSPLASH_SLOGAN_SHOW_TIME, 0);
                String stringExtra = intent.getStringExtra(SpKeys.LINKED_CONTENT_ID);
                String stringExtra2 = intent.getStringExtra("linked_content_slotId");
                int intExtra2 = intent.getIntExtra(SpKeys.EXSPLASH_REDUNDANCY_TIME, 0);
                AbstractC7185ho.m43818a("ExLinkedSplashReceiver", "ExLinkedSplashReceiver, startTime: %s, showTime: %s, contentId: %s", lValueOf, Integer.valueOf(intExtra), stringExtra);
                context.removeStickyBroadcast(intent);
                InterfaceC7146gc interfaceC7146gc = this.f33525b;
                if (interfaceC7146gc != null) {
                    interfaceC7146gc.mo43457g(longExtra);
                    this.f33525b.mo43459h(intExtra);
                    this.f33525b.mo43480o(stringExtra);
                    this.f33525b.mo43462i(intExtra2);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MapKeyNames.CONTENT_ID, stringExtra);
                jSONObject.put(MapKeyNames.PACKAGE_NAME, this.f33524a.getPackageName());
                jSONObject.put(MapKeyNames.IS_OLD_FAT, true);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    jSONObject.put("slotid", stringExtra2);
                }
                C7484ms.m45854a(context).m45855a(RTCMethods.REQ_LINKED_VIDEO, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.b.1
                    @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != 200) {
                            AbstractC7185ho.m43823c("ExLinkedSplashReceiver", "call reqExLinked failed");
                            C7287b.this.m44221a();
                            return;
                        }
                        AbstractC7185ho.m43820b("ExLinkedSplashReceiver", "reqExLinkedVideo success");
                        try {
                            ContentRecord contentRecordM44220a = C7287b.this.m44220a(new JSONObject(callResult.getData()));
                            if (contentRecordM44220a != null) {
                                contentRecordM44220a.m41513b(true);
                                final LinkedSplashAd linkedSplashAdM46668a = C7565oz.m46668a(context, contentRecordM44220a);
                                linkedSplashAdM46668a.m44494e(true);
                                final IExSplashCallback iExSplashCallbackMo44053f = HiAd.m44014a(context).mo44053f();
                                if (iExSplashCallbackMo44053f != null) {
                                    AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.inter.b.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            String contentId;
                                            String slotId;
                                            boolean zCanDisplayLinkedVideo = iExSplashCallbackMo44053f.canDisplayLinkedVideo(linkedSplashAdM46668a);
                                            AbstractC7185ho.m43821b("ExLinkedSplashReceiver", "onReceive, isCanDisplay: %s", Boolean.valueOf(zCanDisplayLinkedVideo));
                                            if (zCanDisplayLinkedVideo) {
                                                return;
                                            }
                                            AbstractC7185ho.m43823c("ExLinkedSplashReceiver", "isCanDisplay false, start show normal splash. ");
                                            C7287b.this.m44221a();
                                            LinkedSplashAd linkedSplashAd = linkedSplashAdM46668a;
                                            if (linkedSplashAd != null) {
                                                contentId = linkedSplashAd.getContentId();
                                                slotId = linkedSplashAdM46668a.getSlotId();
                                            } else {
                                                contentId = null;
                                                slotId = null;
                                            }
                                            new C6922c(context).m39092a(context.getPackageName(), 1, slotId, contentId);
                                        }
                                    });
                                    return;
                                }
                                AbstractC7185ho.m43823c("ExLinkedSplashReceiver", "exSplashCallback is null");
                            } else {
                                AbstractC7185ho.m43823c("ExLinkedSplashReceiver", "content is null");
                            }
                            C7287b.this.m44221a();
                        } catch (JSONException unused) {
                            AbstractC7185ho.m43823c("ExLinkedSplashReceiver", "reqLinkedVideo onRemoteCallResult JSONException ");
                        }
                    }
                }, String.class);
            }
        } catch (JSONException unused) {
            AbstractC7185ho.m43823c("ExLinkedSplashReceiver", "reqExLinkedVideo JSONException");
            m44221a();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ExLinkedSplashReceiver", "reqLinkedVideo exception: %s", th2.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public ContentRecord m44220a(JSONObject jSONObject) {
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        ContentRecord contentRecord;
        ContentRecord contentRecord2 = null;
        try {
            strOptString = jSONObject.optString(MapKeyNames.PARAM_FROM_SERVER);
            strOptString2 = jSONObject.optString(MapKeyNames.THIRD_MONITORS);
            strOptString3 = jSONObject.optString(MapKeyNames.CONTENT_RECORD);
            strOptString4 = jSONObject.optString(MapKeyNames.LANDPAGE_WHITELIST);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("ExLinkedSplashReceiver", " paramJsonObjString content= %s", AbstractC7819dl.m48375a(strOptString));
                AbstractC7185ho.m43818a("ExLinkedSplashReceiver", " thirdMonitors content= %s", AbstractC7819dl.m48375a(strOptString2));
                AbstractC7185ho.m43818a("ExLinkedSplashReceiver", " whiteList content= %s", AbstractC7819dl.m48375a(strOptString4));
            }
            contentRecord = (ContentRecord) AbstractC7758be.m47739b(strOptString3, ContentRecord.class, new Class[0]);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("ExLinkedSplashReceiver", " adContent content= %s", AbstractC7819dl.m48375a(strOptString3));
            }
            if (contentRecord == null) {
                return contentRecord;
            }
            contentRecord.m41583l(strOptString);
            if (!TextUtils.isEmpty(strOptString2)) {
                contentRecord.m41537c((List<Monitor>) AbstractC7758be.m47739b(strOptString2, List.class, Monitor.class));
            }
            contentRecord.m41614w(strOptString4);
            m44223b(jSONObject);
            return contentRecord;
        } catch (Throwable th3) {
            th = th3;
            contentRecord2 = contentRecord;
            AbstractC7185ho.m43824c("ExLinkedSplashReceiver", "handleResponse exception: %s", th.getClass().getSimpleName());
            return contentRecord2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m44221a() {
        C7484ms.m45854a(this.f33524a).m45855a(RTCMethods.SHOW_SPLASH, null, null, null);
    }
}
