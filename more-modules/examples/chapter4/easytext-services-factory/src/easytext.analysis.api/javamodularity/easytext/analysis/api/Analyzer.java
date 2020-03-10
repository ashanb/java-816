package javamodularity.easytext.analysis.api;

import java.util.List;
import java.util.ServiceLoader;

public interface Analyzer {

   String getName();

   double analyze(List<List<String>> text);

   static Iterable<Analyzer> getAnalyzers() {
     return ServiceLoader.load(Analyzer.class); // <1>
   }

}
