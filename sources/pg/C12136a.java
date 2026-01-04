package pg;

import android.content.Context;
import android.text.TextUtils;
import bf.C1175a;
import com.google.gson.Gson;
import com.huawei.android.remotecontrol.util.account.bean.AccountInfo;
import p015ak.C0213f;
import p520of.C11853c;
import p521og.C11877j;
import p576qf.InterfaceC12348a;
import p809yg.C13981a;
import sg.C12797b;
import ug.C13171a;

/* renamed from: pg.a */
/* loaded from: classes4.dex */
public class C12136a {
    /* renamed from: a */
    public static void m72755a(Context context) {
        if (C13171a.m79199e()) {
            C1175a.m7383e(context);
        } else {
            C11877j.m71263f(context);
        }
    }

    /* renamed from: b */
    public static void m72756b(AccountInfo accountInfo) {
        if (!TextUtils.isEmpty(accountInfo.getDeviceID())) {
            C13981a.m83989i("AccountDataWriter", "device not empty");
            return;
        }
        if (!C1175a.m7389k(C0213f.m1377a())) {
            C13981a.m83989i("AccountDataWriter", "getEnable false");
            return;
        }
        C13981a.m83989i("AccountDataWriter", "cloneAccountInfo");
        accountInfo.setAccountName(accountInfo.getAccountNameEncrypted());
        accountInfo.setDeviceID(accountInfo.getDeviceIDEncrypted());
        accountInfo.setServiceToken(accountInfo.getServiceTokenEncrypted());
        accountInfo.setDeviceTicket(accountInfo.getDeviceTicketEncrypted());
        accountInfo.setClearCmdData(accountInfo.getClearCmdDataEncrypted());
        accountInfo.setCountryCode(accountInfo.getCountryCodeEncrypted());
        accountInfo.setUserKey(accountInfo.getUserKeyEncrypted());
    }

    /* renamed from: c */
    public static AccountInfo m72757c(Context context) {
        AccountInfo accountInfo;
        AccountInfo accountInfo2;
        try {
            accountInfo = (AccountInfo) new Gson().fromJson(C1175a.m7396r(context), AccountInfo.class);
        } catch (Exception e10) {
            C13981a.m83988e("AccountDataWriter", "fromJson exception" + e10.getMessage());
            C13171a.m79203i();
            new C12797b().m76784j(context, "AccountDataWriter", "001_1000", "readData fromJson exception", null, "01011", null, "taWriteError", true);
            accountInfo = null;
        }
        if (accountInfo == null) {
            C13981a.m83990w("AccountDataWriter", "accountInfo is null");
            accountInfo = new AccountInfo();
            accountInfo.resetAccountInfo();
        } else if (accountInfo.getAccountName() == null) {
            C13981a.m83988e("AccountDataWriter", "getAccountName null");
        }
        try {
            accountInfo2 = (AccountInfo) accountInfo.clone();
        } catch (CloneNotSupportedException unused) {
            C13981a.m83988e("AccountDataWriter", "readAccountInfoFromAntiTheft CloneNotSupportedException");
            accountInfo2 = new AccountInfo();
            accountInfo2.readAccountInfo(context, accountInfo);
        }
        if (C11853c.m70968g().m70972h(context)) {
            C13981a.m83989i("AccountDataWriter", "read encrypt data");
            accountInfo2.readEncryptedAccountInfo(context, accountInfo);
        }
        return accountInfo2;
    }

    /* renamed from: d */
    public static AccountInfo m72758d(Context context) {
        Gson gson = new Gson();
        if (!C13171a.m79199e()) {
            C13981a.m83989i("AccountDataWriter", "getAccountInfo is empty");
            return new AccountInfo();
        }
        AccountInfo accountInfoM72757c = m72757c(context);
        if (TextUtils.isEmpty(accountInfoM72757c.getUserID4RC())) {
            C13981a.m83989i("AccountDataWriter", "getAccountInfo from sp");
            String strM71266g = C11877j.m71266g(context);
            if (!TextUtils.isEmpty(strM71266g)) {
                try {
                    AccountInfo accountInfo = (AccountInfo) gson.fromJson(strM71266g, AccountInfo.class);
                    try {
                        C13981a.m83989i("AccountDataWriter", "getAccountInfo from json");
                        m72756b(accountInfo);
                        return accountInfo;
                    } catch (Exception e10) {
                        e = e10;
                        accountInfoM72757c = accountInfo;
                        C13981a.m83988e("AccountDataWriter", "getAccountInfo fromJson exception" + e.getMessage());
                        return accountInfoM72757c;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            }
        } else {
            C13981a.m83989i("AccountDataWriter", "accountInfo exist");
            if (TextUtils.isEmpty(C11877j.m71266g(context))) {
                C13981a.m83989i("AccountDataWriter", "write info to sp");
                C11877j.m71221M0(context, gson.toJson(accountInfoM72757c));
            }
        }
        return accountInfoM72757c;
    }

    /* renamed from: e */
    public static void m72759e(AccountInfo accountInfo, Context context) {
        if (C11853c.m70968g().m70972h(context)) {
            accountInfo.setEncryptedAccountInfo(context, accountInfo);
        }
        C13981a.m83989i("AccountDataWriter", "writeAccountInfo");
        C11877j.m71221M0(context, new Gson().toJson(accountInfo));
    }

    /* renamed from: f */
    public static void m72760f(AccountInfo accountInfo, Context context, InterfaceC12348a interfaceC12348a) {
        try {
            AccountInfo accountInfo2 = (AccountInfo) accountInfo.clone();
            accountInfo2.setAccountInfo(context, accountInfo);
            if (C11853c.m70968g().m70972h(context)) {
                accountInfo2.setEncryptedAccountInfo(context, accountInfo);
            }
            String json = new Gson().toJson(accountInfo2);
            if (json != null) {
                C1175a.m7400v(json, interfaceC12348a);
                return;
            }
            C13981a.m83988e("AccountDataWriter", "writeAccountInfoToAntiTheft str is null");
            if (interfaceC12348a != null) {
                interfaceC12348a.onResult(false);
            }
        } catch (CloneNotSupportedException unused) {
            C13981a.m83987d("AccountDataWriter", "writeAccountInfoToAntiTheft CloneNotSupportedException");
            if (interfaceC12348a != null) {
                interfaceC12348a.onResult(false);
            }
        }
    }

    /* renamed from: g */
    public static void m72761g(boolean z10, AccountInfo accountInfo, Context context, InterfaceC12348a interfaceC12348a) {
        String str;
        boolean z11 = true;
        if (accountInfo == null) {
            str = "accountInfo null";
        } else if (TextUtils.isEmpty(accountInfo.getUserID())) {
            str = "accountInfo.u-id is empty";
        } else if (TextUtils.isEmpty(accountInfo.getDeviceID())) {
            str = "accountInfo.dev-Id is empty";
        } else {
            str = "";
            z11 = false;
        }
        String str2 = str;
        if (z10 && z11) {
            C13981a.m83988e("AccountDataWriter", str2);
            new C12797b().m76784j(context, "AccountDataWriter", "001_1000", str2, null, "01011", null, "active", true);
            if (interfaceC12348a != null) {
                interfaceC12348a.onResult(false);
                return;
            }
            return;
        }
        if (C13171a.m79199e()) {
            C13981a.m83989i("AccountDataWriter", "writeAccountInfoToStorage");
            m72759e(accountInfo, context);
            m72760f(accountInfo, context, interfaceC12348a);
        } else {
            C13981a.m83989i("AccountDataWriter", "writeAccountInfoToStorage, not support AntiTheft");
            m72759e(accountInfo, context);
            if (interfaceC12348a != null) {
                interfaceC12348a.onResult(false);
            }
        }
    }
}
