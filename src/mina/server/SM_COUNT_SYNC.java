package mina.server;

import gameserver.entity.Int3;
import gameserver.entity.Player;
import gameserver.service.CountId;
import gameserver.service.CountManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mina.core.BaseServerPacket;
import org.apache.mina.core.buffer.IoBuffer;

/**
 *
 * @author caoxin
 */
public class SM_COUNT_SYNC extends BaseServerPacket {

    private List<Int3> cds;

    @Override
    protected void writeImp(IoBuffer ioBuffer) {
    }

    @Override
    public void perform() {
    }

    public void init(Int3 int3) {
        this.cds = Collections.singletonList(int3);
    }

    public void init(Player player) {
        cds = new ArrayList<Int3>();
        Map<CountId, CountManager.CountInfo> countmap = player.getCountManager().getCountMap();
        Iterator<CountId> it = countmap.keySet().iterator();
        while (it.hasNext()) {
            CountId id = it.next();
            if (id.isSync()) {
                cds.add(new Int3(id.value(), countmap.get(id).cur, countmap.get(id).max));
            }
        }
    }
}