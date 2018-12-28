package com.demo.zc.AgentSsist;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void main(String[] args){
        System.err.println("main方法");
    }

    public static void premain(String arg, Instrumentation instrumentation){
        System.err.println("premain方法---Java Agent 运行");
        instrumentation.addTransformer((loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
            System.err.println("ClassName："+className);
            return new byte[0];
        });
    }

}
