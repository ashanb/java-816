package javamodularity.providers.factory;

public class ExampleProviderFactory2 {
  public static ExampleProvider provider() {
    return new ExampleProvider("Analyzer created by factory");
  }
}
