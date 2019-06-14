package com.github.fish56;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class ApplicationTest {
    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    public Application application = new Application();

    /**
     * benchmarkRounds: 运行多少次测试用例
     */
    @BenchmarkOptions(warmupRounds = 0, benchmarkRounds = 5)
    @Test
    public void string() {
        String s = "";
        for (int i = 0; i < 40 * 1000; i++) {
            s = s + "Hello world";
        }
    }
    // round: 1.69 [+- 0.44], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 175, GC.time: 0.17, time.total: 8.44, time.warmup: 0.04, time.bench: 8.40

    /**
     * round: 单词使用的时间： 秒
     * time.total: 总计使用的时间
     */
    @BenchmarkOptions(warmupRounds = 0, benchmarkRounds = 5)
    @Test
    public void stringBuilder() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 2000 * 1000; i++) {
            s = s.append("Hello world");
        }
    }
    // round: 0.03 [+- 0.01], round.block: 0.00 [+- 0.00], round.gc: 0.00 [+- 0.00], GC.calls: 1, GC.time: 0.00, time.total: 0.16, time.warmup: 0.00, time.bench: 0.16
}
