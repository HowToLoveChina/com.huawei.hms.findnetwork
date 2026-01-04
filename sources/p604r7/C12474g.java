package p604r7;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Message;
import com.huawei.android.hicloud.drive.cloudphoto.model.MessageList;
import com.huawei.android.hicloud.drive.cloudphoto.request.Messages;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import gp.C10028c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p283fa.C9678a;
import p514o9.C11829c;
import p581qk.AbstractC12367d;
import p649t6.C12941a;
import p649t6.C12948h;
import p664u0.C13108a;
import p709vj.C13452e;
import p804ya.C13924a;

/* renamed from: r7.g */
/* loaded from: classes2.dex */
public class C12474g extends AbstractC12367d {
    /* renamed from: c */
    public final void m74871c(C13924a c13924a, ArrayList<Message> arrayList, String str, String str2, HashSet<String> hashSet) throws IOException {
        String strM6755Z0 = C1122c.m6755Z0("04019");
        Messages.List fields2 = c13924a.m83557n().list().setFields2("message,nextCursor");
        fields2.setQ(str);
        fields2.setAlbumClientHeader(strM6755Z0);
        if (!TextUtils.isEmpty(str2)) {
            fields2.addHeader("x-hw-album-owner-Id", str2);
        }
        String nextCursor = null;
        do {
            MessageList messageListExecute = fields2.setCursor(nextCursor).execute();
            C1120a.m6675d("MessageSyncTask", "messageList: " + messageListExecute.toString());
            List<Message> messages = messageListExecute.getMessages();
            if (messages != null) {
                C1120a.m6677i("MessageSyncTask", "messages size: " + messages.size());
                for (Message message : messages) {
                    if (message != null && !TextUtils.isEmpty(message.getAlbumId())) {
                        if (hashSet == null) {
                            arrayList.add(message);
                        } else if (hashSet.contains(message.getAlbumId())) {
                            arrayList.add(message);
                        }
                    }
                }
            }
            nextCursor = messageListExecute.getNextCursor();
        } while (!TextUtils.isEmpty(nextCursor));
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        boolean z10 = !C11829c.m70532M0() || C10028c.m62182c0().m62413x();
        if (!C13452e.m80781L().m80842P0() || !zM62221H1 || !z10) {
            C1120a.m6676e("MessageSyncTask", "condition not support");
            return;
        }
        if (!CloudAlbumSettings.m14363h().m14376l()) {
            C1120a.m6676e("MessageSyncTask", "user not support");
            return;
        }
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("MessageSyncTask", "version not support");
            return;
        }
        if (!CloudAlbumSettings.m14363h().m14383s()) {
            C1120a.m6676e("MessageSyncTask", "configure not support");
            return;
        }
        try {
            C13924a c13924aM60445d = C9678a.m60442e().m60445d();
            if (c13924aM60445d == null) {
                C1120a.m6676e("MessageSyncTask", "MessageSyncTask cloudPhoto is null ");
                return;
            }
            ArrayList<Album> arrayListM77727B = new C12941a().m77727B(1, false);
            ArrayList<Message> arrayList = new ArrayList<>();
            m74871c(c13924aM60445d, arrayList, "messageType=1", "", null);
            m74872d(c13924aM60445d, arrayList, "messageType=2", arrayListM77727B);
            m74871c(c13924aM60445d, arrayList, "messageType=7", "", null);
            C12948h c12948h = new C12948h();
            C1120a.m6677i("MessageSyncTask", "cloudMessageList size: " + arrayList.size());
            Iterator<Message> it = arrayList.iterator();
            while (it.hasNext()) {
                Message next = it.next();
                Message messageM77845p = c12948h.m77845p(next.getMessageId());
                if (messageM77845p != null) {
                    next.setRead(messageM77845p.isRead());
                }
            }
            c12948h.m77839j();
            c12948h.m77838i(arrayList);
            Intent intent = new Intent();
            intent.setAction("com.huawei.hidisk.action.ALBUM_CLIENT_MESSAGE_SYNC_COMPLETE");
            C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
        } catch (Exception e10) {
            C1120a.m6676e("MessageSyncTask", "MessageSyncTask Exception " + e10.toString());
        }
    }

    /* renamed from: d */
    public final void m74872d(C13924a c13924a, ArrayList<Message> arrayList, String str, ArrayList<Album> arrayList2) throws IOException {
        if (arrayList2.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        HashSet<String> hashSet2 = new HashSet<>();
        Iterator<Album> it = arrayList2.iterator();
        while (it.hasNext()) {
            Album next = it.next();
            if (next != null && !"1.0".equals(next.getAlbumVersion()) && !C1122c.m6705I1(next)) {
                String albumOwnerId = next.getAlbumOwnerId();
                String id2 = next.getId();
                if (!TextUtils.isEmpty(albumOwnerId) && !TextUtils.isEmpty(id2)) {
                    hashSet.add(albumOwnerId);
                    hashSet2.add(id2);
                }
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            m74871c(c13924a, arrayList, str, (String) it2.next(), hashSet2);
        }
    }
}
