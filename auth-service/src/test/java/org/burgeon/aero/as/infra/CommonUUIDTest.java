package org.burgeon.aero.as.infra;

import org.burgeon.aero.as.infra.utils.CommonUUID;
import org.burgeon.aero.as.infra.utils.ThreadUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @author Sam Lu
 * @date 2021/11/27
 */
public class CommonUUIDTest {

    /**
     * 基于时间的UUID，只要时间是错开的，产生的UUID就是单调递增的
     */
    @Test
    public void testGenerateType1UUID() {
        List<UUID> uuidList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UUID uuid = CommonUUID.generateType1UUID();
            uuidList.add(uuid);
            System.out.println(uuid);
            ThreadUtils.sleep(1);
        }

        System.out.println();

        Collections.sort(uuidList);
        for (UUID uuid : uuidList) {
            System.out.println(uuid);
        }
    }

    /**
     * 随机的UUID，时间错开，产生的UUID也不是单调递增的
     */
    @Test
    public void testRandomUUID() {
        List<UUID> uuidList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UUID uuid = UUID.randomUUID();
            uuidList.add(uuid);
            System.out.println(uuid);
            ThreadUtils.sleep(1);
        }

        System.out.println();

        Collections.sort(uuidList);
        for (UUID uuid : uuidList) {
            System.out.println(uuid);
        }
    }

}
