package com.zc.common.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class JWTUtilTest {

    @Test
    public void encrypted() {
        JWTUtil.Encrypted("123");
    }

    @Test
    public void payload() {
        JWTUtil.Payload("eyJhbGciOiJBMTI4S1ciLCJlbmMiOiJBMTI4Q0JDLUhTMjU2In0.Qir3tCruf" +
                "kOwF3aIbSD0FpsuYQ1Xbi4hruS_9VOkmv2DdJRGiEwhWw.7XxxHIEs5GuLYxvPk5XPfg.6EH8s6G" +
                "26JcBnsclVehJ2A.ytS6jEQTDrYHwLdJrVPQCw", null);
    }
}