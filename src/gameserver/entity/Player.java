package gameserver.entity;

import gameserver.service.CoolDownManager;
import gameserver.service.CountManager;
import mina.core.BaseServerPacket;
import org.apache.mina.core.session.IoSession;

/**
 *
 * @author caoxin
 */
public class Player {

    private IoSession ioSession;
    private CoolDownManager coolManager;
    private CountManager countManager;

    public IoSession getIoSession() {
        return ioSession;
    }

    public void setIoSession(IoSession ioSession) {
        this.ioSession = ioSession;
    }

    public CoolDownManager getCoolManager() {
        return coolManager;
    }

    public void setCoolManager(CoolDownManager coolDownManager) {
        this.coolManager = coolDownManager;
    }

    public CountManager getCountManager() {
        return countManager;
    }

    public void setCountManager(CountManager countManager) {
        this.countManager = countManager;
    }

    /**
     * 向客户端发送消息
     *
     * @param baseServerPacket
     */
    public <T extends BaseServerPacket> void sendPacket(T o) {
        this.ioSession.write(o);
    }
}