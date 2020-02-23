mkdir -p mods

$JAVA_HOME/bin/javac  -p C:\bins\javafx-jmods --module-source-path src -d mods -m easytext.analysis.api,easytext.analysis.coleman,easytext.analysis.kincaid,easytext.gui

$JAVA_HOME/bin/java -p C:\bins\javafx-sdk-11.0.2\lib\;mods -m easytext.gui/javamodularity.easytext.gui.Main ../exampletext.txt


jlink --module-path C:\bins\javafx-sdk-11.0.2\lib\;mods --add-modules easytext.cli --output image

jlink --module-path mods --add-modules easytext.cli  --add-modules easytext.analysis.coleman --add-modules easytext.analysis.kincaid --output image

// not working (launcher should point to  packaged modular jar)
jlink --module-path mods --add-modules easytext.cli  --add-modules easytext.analysis.coleman --add-modules easytext.analysis.kincaid --output image --launcher easytext.cli

call from the image

java -m easytext.cli/javamodularity.easytext.cli.Main ../../exampletext.txt