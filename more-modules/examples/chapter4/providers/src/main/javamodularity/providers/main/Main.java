package javamodularity.providers.main;


import javamodularity.easytext.analysis.api.Analyzer;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        Iterable<Analyzer> analyzers = ServiceLoader.load(Analyzer.class);

        ServiceLoader<Analyzer> bs = ServiceLoader.load(Analyzer.class);
        //bs.forEach(bs -> bs.notify());

        for (Analyzer analyzer : analyzers) {
            System.out.println(analyzer.getName());
        }
    }
}
