package com.zc.AgentSsist;

import org.apache.ibatis.javassist.*;

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class Agent {

    private static final String NULL = "null";

    private static final String BASE_JDBC_LOGGER = "org/apache/ibatis/logging/jdbc/BaseJdbcLogger";

    private static final String DRUID_POOLED_PREPARED_STATEMENT = "com/alibaba/druid/pool/DruidPooledPreparedStatement$PreparedStatementKey";

    public static void main(String[] args) {
        System.err.println("main方法");
    }

    public static void premain(String arg, Instrumentation instrumentation) {
        System.err.println("premain方法---Java Agent 运行");
        instrumentation.addTransformer(
                Agent::transform);
    }


    private static byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if (className == null || NULL.equals(className) || "".equals(className)) {
            return new byte[0];
        }
        if (BASE_JDBC_LOGGER.equals(className)) {
            try {
                ClassPool pool = ClassPool.getDefault();
                CtClass ctc = pool.get(className.replace("/", "."));
                CtConstructor[] ctcons = ctc.getDeclaredConstructors();
                for (CtConstructor ctcon : ctcons) {
                    // zc Print Data exclusive BaseJdbcLogger：：：：：：org.apache.ibatis.logging.slf4j.Slf4jImpl@53a28ab9
                    // zc Print Data exclusive BaseJdbcLogger：：：：：： Preparing: SELECT Id,text FROM sbd
                    ctcon.insertAfter(" System.err.println(\"zc Print Data exclusive BaseJdbcLogger：：：：：：\"+$1); ");
                }
                CtMethod ctm = ctc.getDeclaredMethod("debug");
                // zc Print Data exclusive BaseJdbcLogger debug：：：：：：     Total: 2
                ctm.insertAfter(" System.err.println(\"zc Print Data exclusive BaseJdbcLogger debug：：：：：：\"+$1); ");
                CtMethod ctmRow = ctc.getDeclaredMethod("trace");
                // zc Print Data exclusive BaseJdbcLogger trace：：：：：：   Columns: Id, text
                // zc Print Data exclusive BaseJdbcLogger trace：：：：：：       Row: 4444, 3333
                // zc Print Data exclusive BaseJdbcLogger trace：：：：：：       Row: 6666, 5555
                ctmRow.insertAfter("System.err.println(\"zc Print Data exclusive BaseJdbcLogger trace：：：：：：\"+$1); ");
                return ctc.toBytecode();
            } catch (NotFoundException e) {
                e.printStackTrace();
            } catch (CannotCompileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (DRUID_POOLED_PREPARED_STATEMENT.equals(className)) {
            try {
                ClassPool pool = ClassPool.getDefault();
                CtClass ctc = pool.get(className.replace("/", "."));
                CtConstructor[] ctcons = ctc.getDeclaredConstructors();
                for (CtConstructor ctcon : ctcons) {
                    // zc Print Data exclusive dp：：：：：：SELECT Id,text  FROM sbd
                    // zc Print Data exclusive dp：：：：：：SELECT Id,text  FROM sbd
                    ctcon.insertAfter(" System.err.println(\"zc Print Data exclusive dp：：：：：：\"+$1); ");
                }
                return ctc.toBytecode();
            } catch (NotFoundException e) {
                e.printStackTrace();
            } catch (CannotCompileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new byte[0];
    }

}
