package com.huawei.android.hicloud.album.service.logic.callable;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p031b7.C1120a;
import p031b7.C1124e;
import p581qk.AbstractC12367d;

/* loaded from: classes2.dex */
public class QueryLocalMediaTask extends AbstractC12367d {
    private static final int FIRST_PAGE_COUNT = 200;
    private static final String TAG = "QueryLocalMediaTask";
    private final Handler handler;
    private boolean isCancelled;
    private String selectedKey;
    private List<MediaFileBean> selectedList;

    public QueryLocalMediaTask(Handler handler, String str, List<MediaFileBean> list) {
        this.handler = handler;
        this.selectedKey = str;
        this.selectedList = list;
    }

    private String[] getProjection() {
        return new String[]{"_id", "_display_name", "date_added", "mime_type", "_data", "date_modified", "duration", "datetaken", ParamConstants.Param.ORIENTATION, "_size"};
    }

    private String getSelection() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_size");
        sb2.append(" > 0 ");
        sb2.append(" AND ((");
        sb2.append("media_type");
        sb2.append(" = 3");
        sb2.append(" OR ");
        sb2.append("mime_type");
        sb2.append(" like 'video/%'");
        sb2.append(") ");
        sb2.append(" OR ");
        sb2.append("(");
        sb2.append("media_type");
        sb2.append(" = 1");
        sb2.append(" OR ");
        sb2.append("mime_type");
        sb2.append(" like 'image/%'");
        sb2.append(")) ");
        String strM6866j = C1124e.m6866j();
        if (!TextUtils.isEmpty(strM6866j)) {
            sb2.append(" AND ");
            sb2.append("_data");
            sb2.append(" not like '");
            sb2.append(strM6866j);
            if (strM6866j.endsWith(File.separator)) {
                sb2.append(".%'");
            } else {
                sb2.append("/.%'");
            }
        }
        return sb2.toString();
    }

    private String getSortOrder() {
        return " date_modified desc ";
    }

    private void sendQuery(int i10, List<MediaFileBean> list) {
        C1120a.m6677i(TAG, "sendQuery : isCancelled = " + this.isCancelled);
        if (this.isCancelled) {
            list.clear();
            return;
        }
        Message message = new Message();
        message.what = i10;
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("extra_query_local_data", new ArrayList<>(list));
        message.setData(bundle);
        this.handler.sendMessage(message);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        if (this.handler != null) {
            queryDataFromFiles();
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean cancel() {
        this.isCancelled = true;
        return super.cancel();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:248|179|(6:(5:181|244|182|(3:265|184|268)|266)(2:264|188)|(2:204|(8:206|207|253|211|(1:217)(1:214)|218|267|266)(1:208))(1:209)|253|211|(3:217|218|267)(0)|266)|259|189|190|255|191|192|(2:246|194)(2:198|(2:200|201))|202|210) */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0269, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x026a, code lost:
    
        r5 = r21;
        r17 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x026e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x026f, code lost:
    
        r23 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:217:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x028c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:270:? A[Catch: SQLException -> 0x0288, SYNTHETIC, TRY_LEAVE, TryCatch #4 {SQLException -> 0x0288, blocks: (B:238:0x0295, B:237:0x0292, B:228:0x0282, B:233:0x028c), top: B:250:0x0073, inners: #0 }] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v15 */
    /* JADX WARN: Type inference failed for: r17v16 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void queryDataFromFiles() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.album.service.logic.callable.QueryLocalMediaTask.queryDataFromFiles():void");
    }
}
