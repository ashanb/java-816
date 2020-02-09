package io;

import java.nio.charset.Charset;

public class EncodingTester {
   public static void main(String[] args) {
      Charset usAsciiCharset = Charset.forName("US-ASCII");
      Charset utf8Charset = Charset.forName("UTF-8");
      Charset utf16Charset = Charset.forName("UTF-16");
   }
}
