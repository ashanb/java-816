module provider.factory.example {
   requires easytext.analysis.api;

   provides javamodularity.easytext.analysis.api.Analyzer
           with javamodularity.providers.factory.ExampleProviderFactory;

//   provides javamodularity.easytext.analysis.api.Analyzer
//           with javamodularity.providers.factory.ExampleProviderFactory2;  // Duplicate error.
}
