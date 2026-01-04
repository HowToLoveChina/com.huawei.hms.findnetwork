package p814yl;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0241z;
import p514o9.C11829c;
import p514o9.C11839m;
import p618rm.C12590s0;
import p744wl.C13619c;
import p815ym.AbstractC14026a;
import p848zl.C14333b;

/* renamed from: yl.e0 */
/* loaded from: classes6.dex */
public class C14004e0 {
    /* renamed from: h */
    public static /* synthetic */ boolean m84149h(String str, CloudRestoreItem cloudRestoreItem) {
        return str.equals(cloudRestoreItem.getAppId());
    }

    /* renamed from: b */
    public final int m84150b(App app) {
        int iM1685c = C0241z.m1685c(m84158k(app.getProperties(), SnapshotBackupMeta.KEY_STRING_APP_EXTEND));
        int iIntValue = app.getApkType().intValue();
        if (iIntValue != 1) {
            if (iIntValue == 2) {
                return 5;
            }
            if (iIntValue != 3 && iIntValue != 6) {
                return 0;
            }
        }
        if (iM1685c == 1) {
            return 6;
        }
        return iM1685c == 2 ? 7 : 4;
    }

    /* renamed from: c */
    public final int m84151c(int i10) {
        if (i10 == 0 || i10 == 1) {
            return 4;
        }
        return i10 != 2 ? 5 : 0;
    }

    /* renamed from: d */
    public void m84152d(CloudRestoreStatusV3 cloudRestoreStatusV3, App app, boolean z10, Boolean bool, boolean z11) {
        String str;
        boolean z12;
        String id2 = app.getId();
        String strM84155g = m84155g(app);
        Map<String, String> properties = app.getProperties();
        String strM84158k = m84158k(properties, SnapshotBackupMeta.KEY_STRING_APP_NAME);
        int iM1686d = bool != null ? bool.booleanValue() : RestoreUtil.isNewBmRecord() ? C0241z.m1686d(m84158k(properties, "bmAppDataType"), 0) : 0;
        String strM84158k2 = m84158k(properties, "AggVirtualAppId");
        int iM1685c = C0241z.m1685c(m84158k(properties, "appShowType"));
        int iM84151c = z11 ? m84151c(iM1685c) : m84150b(app);
        int iM84153e = m84153e(properties);
        int iM84157j = z11 ? m84157j(iM1686d, iM1685c) : m84156i(strM84155g, iM84151c, iM1686d);
        int iIntValue = app.getFileCount().intValue();
        int size = !AbstractC14026a.m84159a(app.getAttachments()) ? app.getAttachments().size() : 0;
        String strM84158k3 = m84158k(properties, SnapshotBackupMeta.KEY_STRING_APP_VERSION);
        String strM84158k4 = m84158k(properties, "splitappuid");
        StringBuilder sb2 = new StringBuilder();
        int i10 = iM1686d;
        sb2.append("buildRestoreV3Status appId: ");
        sb2.append(strM84155g);
        sb2.append(" ,uid: ");
        sb2.append(strM84158k4);
        C11839m.m70686d("CloudRestoreV3Client", sb2.toString());
        int iM1685c2 = C0241z.m1685c(app.getPackageVersion());
        long jLongValue = app.getAppTotalSize().longValue();
        int i11 = iM84157j;
        long jM1688f = C0241z.m1688f(properties.get("apksize"));
        String str2 = properties.get(SnapshotBackupMeta.KEY_SHOW_TYPE);
        String str3 = properties.get("appdatasize");
        if (z10) {
            if (cloudRestoreStatusV3.m29498s() == 0) {
                cloudRestoreStatusV3.m29460E0(iM84153e);
                if (iM84153e == 1) {
                    cloudRestoreStatusV3.setAction(0);
                }
            }
            cloudRestoreStatusV3.setSize(cloudRestoreStatusV3.getSize() + jLongValue).setCombineUid(cloudRestoreStatusV3.getCombineUid() + "&" + strM84158k4).setUid(0);
        } else {
            cloudRestoreStatusV3.setAppId(strM84155g).setAppName(strM84158k).setAppType(iM84151c).setAppShowType(iM1685c).setAggVirtualAppId(strM84158k2).setHarmonyNext(z11).setCount(iIntValue).setSize(jLongValue).setAsize(jM1688f).m29463H0(id2).m29475O0(i11).m29460E0(iM84153e).m29504v0(size).m29489V0(strM84158k3).m29456A0(str2).m29487U0(iM1685c2).setUid(C0241z.m1685c(strM84158k4)).setSplitApkType(app.getSplitApkType()).setOriBackupAppName(app.getOriBackupAppName()).setCombineUid(strM84158k4).setBmAppDataType(i10);
        }
        cloudRestoreStatusV3.setAsize(jM1688f);
        if (TextUtils.isEmpty(str3)) {
            str = "CloudRestoreV3Client";
        } else {
            str = "CloudRestoreV3Client";
            C11839m.m70686d(str, "buildRestoreV3Status appId: " + strM84155g + " appDataSize: " + str3);
            cloudRestoreStatusV3.m29458C0(str3);
        }
        if (!cloudRestoreStatusV3.is3rdAppType()) {
            C11839m.m70688i(str, "appId: " + cloudRestoreStatusV3.getAppId() + "current: " + C12590s0.m75790R(cloudRestoreStatusV3.getAppId()) + ", backup: " + C0241z.m1685c(m84158k(app.getProperties(), "backupApkVersion")));
        } else if (cloudRestoreStatusV3.m29498s() != 1) {
            cloudRestoreStatusV3.setAction(1);
            cloudRestoreStatusV3.m29460E0(0);
        }
        String str4 = properties.get(SnapshotBackupMeta.KEY_SHOW_TYPE);
        if (!TextUtils.isEmpty(str4)) {
            C11839m.m70688i(str, "virtualAppShowType " + str4 + "  appId " + strM84155g);
            cloudRestoreStatusV3.m29456A0(str4);
        }
        if (!z11 || C13619c.m81951g(cloudRestoreStatusV3.getAppId())) {
            return;
        }
        C11839m.m70688i(str, "unSupportRestore appId " + strM84155g);
        if (cloudRestoreStatusV3.getAppId().equals("com.huawei.hmos.photos") && C13619c.m81951g(NextRestoreConstants.BUNDLE_NAME_GALLERY)) {
            z12 = false;
            cloudRestoreStatusV3.setAction(0);
        } else {
            z12 = false;
            cloudRestoreStatusV3.setAction(2);
        }
        cloudRestoreStatusV3.setCompatible(z12);
    }

    /* renamed from: e */
    public final int m84153e(Map<String, String> map) {
        return String.valueOf(1).equals(m84158k(map, "appwithdata")) ? 1 : 0;
    }

    /* renamed from: f */
    public Map<String, CloudRestoreStatusV3> m84154f(List<CloudRestoreItem> list) {
        HashMap map = new HashMap();
        for (CloudRestoreItem cloudRestoreItem : list) {
            final String appId = cloudRestoreItem.getAppId();
            List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
            if (C11829c.m70599n0(listM29202r)) {
                CloudRestoreStatusV3 cloudRestoreStatusV3 = new CloudRestoreStatusV3();
                cloudRestoreStatusV3.setAppId(appId);
                cloudRestoreStatusV3.update(cloudRestoreItem);
                cloudRestoreStatusV3.setAppName(cloudRestoreItem.getAppName()).m29475O0(m84156i(appId, cloudRestoreItem.getAppType(), cloudRestoreItem.getBmAppDataType())).setAppType(cloudRestoreItem.getAppType()).setCompatible(cloudRestoreItem.isCompatible()).setHarmonyNext(cloudRestoreItem.isHarmonyNext()).setAppShowType(cloudRestoreItem.getAppShowType()).setAggVirtualAppId(cloudRestoreItem.getAggVirtualAppId());
                int i10 = 1;
                if (RestoreUtil.isNewBmRecord() && cloudRestoreItem.getBmAppDataType() == 2) {
                    cloudRestoreStatusV3.m29460E0(1);
                }
                if (cloudRestoreItem.is3rdAppType()) {
                    if (!cloudRestoreItem.m29187M() || cloudRestoreStatusV3.getAction() != 2) {
                        if (RestoreUtil.isNewBmRecord() && cloudRestoreItem.getBmAppDataType() == 2) {
                            cloudRestoreStatusV3.m29460E0(1);
                        } else {
                            cloudRestoreStatusV3.m29460E0(cloudRestoreItem.m29187M() ? 1 : 0);
                        }
                        List<CloudRestoreItem> list2 = RestoreCache.getInstance().get3rdAppDataStatusList();
                        if (!list2.isEmpty()) {
                            Iterator it = ((List) list2.stream().filter(new Predicate() { // from class: yl.d0
                                @Override // java.util.function.Predicate
                                public final boolean test(Object obj) {
                                    return C14004e0.m84149h(appId, (CloudRestoreItem) obj);
                                }
                            }).collect(Collectors.toList())).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                int action = ((CloudRestoreItem) it.next()).getAction();
                                if (cloudRestoreStatusV3.getAction() == 0 && action == 2) {
                                    C11839m.m70688i("CloudRestoreV3Client", "do not restore app file data, appId = " + appId);
                                    cloudRestoreStatusV3.setAction(i10);
                                    break;
                                }
                                String combineUid = cloudRestoreItem.getCombineUid();
                                C11839m.m70688i("CloudRestoreV3Client", "getActionStatusList appId = " + appId + " combineUid = " + combineUid);
                                if (!TextUtils.isEmpty(combineUid) && combineUid.contains("&")) {
                                    for (String str : combineUid.split("&")) {
                                        int iM1685c = C0241z.m1685c(str);
                                        if (iM1685c > 0) {
                                            CloudRestoreStatusV3 cloudRestoreStatusV32 = new CloudRestoreStatusV3();
                                            cloudRestoreStatusV32.setAppId(appId);
                                            cloudRestoreStatusV32.update(cloudRestoreItem);
                                            cloudRestoreStatusV32.m29460E0(cloudRestoreItem.m29187M() ? 1 : 0);
                                            cloudRestoreStatusV32.setUid(iM1685c);
                                            cloudRestoreStatusV32.setAppName(cloudRestoreItem.getAppName()).m29475O0(m84156i(appId, cloudRestoreItem.getAppType(), cloudRestoreItem.getBmAppDataType())).setAppType(cloudRestoreItem.getAppType());
                                            map.put(appId + str, cloudRestoreStatusV32);
                                        } else {
                                            cloudRestoreStatusV3.setUid(iM1685c);
                                        }
                                    }
                                }
                                i10 = 1;
                            }
                        }
                    }
                }
                map.put(cloudRestoreStatusV3.getAppId(), cloudRestoreStatusV3);
            } else if (!"thirdAppData".equals(cloudRestoreItem.getAppId())) {
                map.putAll(m84154f(listM29202r));
            }
        }
        return map;
    }

    /* renamed from: g */
    public String m84155g(App app) {
        return app != null ? app.getBackupAppName() : "";
    }

    /* renamed from: i */
    public final int m84156i(String str, int i10, int i11) {
        if (i11 == 1) {
            return 3;
        }
        if (i11 == 2) {
            return 4;
        }
        if (C14333b.m85486u().containsKey(str)) {
            if (C14333b.m85482q().contains(str)) {
                return 1;
            }
        } else if (5 != i10) {
            return 2;
        }
        return 0;
    }

    /* renamed from: j */
    public final int m84157j(int i10, int i11) {
        if (i10 == 1) {
            return 3;
        }
        if (i10 == 2) {
            return 4;
        }
        if (i11 != 1) {
            return i11 != 2 ? 2 : 0;
        }
        return 1;
    }

    /* renamed from: k */
    public String m84158k(Map<String, String> map, String str) {
        String str2 = map.get(str);
        return str2 == null ? "" : str2;
    }
}
