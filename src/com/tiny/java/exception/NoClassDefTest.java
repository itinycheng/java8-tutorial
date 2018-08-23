package com.tiny.java.exception;

/**
 * TODO 还原NoClassDefFoundError
 * <p>
 * java.lang.NoClassDefFoundError: Could not initialize class com.tiny.analytics.game.etl.flink.support.DubboConfig
 * at com.tiny.analytics.game.etl.flink.operator.RouteFlatMap.close(RouteFlatMap.java:118)
 * at org.apache.flink.api.common.functions.util.FunctionUtils.closeFunction(FunctionUtils.java:45)
 * at org.apache.flink.streaming.api.operators.AbstractUdfStreamOperator.dispose(AbstractUdfStreamOperator.java:107)
 * at org.apache.flink.streaming.runtime.tasks.StreamTask.disposeAllOperators(StreamTask.java:440)
 * at org.apache.flink.streaming.runtime.tasks.StreamTask.invoke(StreamTask.java:339)
 * at org.apache.flink.runtime.taskmanager.Task.run(Task.java:642)
 * at java.lang.Thread.run(Thread.java:745)
 * 2018-08-08 17:21:54,206 INFO  org.apache.flink.runtime.taskmanager.Task                     - Source: game_sdk_standard_replace -> ToLineFlatMap -> SplitFlatMap -> StandardSdkMerge -> DataPackageFlatMap -> RouteFlatMap -> (ToStringFlatMap -> Sink: debug, ToStringFlatMap -> Sink: device, ToStringFlatMap -> Sink: datapackage, ToStringFlatMap -> Sink: collector) (20/36) (ddefc0829aa436ae8413fb1967d2c074) switched from RUNNING to FAILED.
 * java.lang.ExceptionInInitializerError
 * at com.tiny.analytics.game.etl.flink.support.DubboConfig.<clinit>(DubboConfig.java:36)
 * at com.tiny.analytics.game.etl.flink.operator.RouteFlatMap.open(RouteFlatMap.java:41)
 * at org.apache.flink.api.common.functions.util.FunctionUtils.openFunction(FunctionUtils.java:38)
 * at org.apache.flink.streaming.api.operators.AbstractUdfStreamOperator.open(AbstractUdfStreamOperator.java:91)
 * at org.apache.flink.streaming.api.operators.StreamFlatMap.open(StreamFlatMap.java:41)
 * at org.apache.flink.streaming.runtime.tasks.StreamTask.openAllOperators(StreamTask.java:390)
 * at org.apache.flink.streaming.runtime.tasks.StreamTask.invoke(StreamTask.java:257)
 * at org.apache.flink.runtime.taskmanager.Task.run(Task.java:642)
 * at java.lang.Thread.run(Thread.java:745)
 * Caused by: java.lang.NumberFormatException: For input string: ""
 * at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
 * at java.lang.Integer.parseInt(Integer.java:592)
 * at java.lang.Integer.parseInt(Integer.java:615)
 * at com.tiny.analytics.game.etl.flink.utils.ConstantConf.<clinit>(ConstantConf.java:13)
 * ... 9 more
 *
 * @author tiny.wang
 */
public class NoClassDefTest {

    public static void main(String[] args) {
        NoClassDef2.test();
    }

    static class NoClassDef2 {
        private static NoClassDef noClassDef = new NoClassDef();

        public static void test() {
            System.out.println("def 2");
        }
    }

    private static class NoClassDef {
        private static Integer number = Integer.parseInt("");

        static {
            System.out.println(number);
        }
    }
}
