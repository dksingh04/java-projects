package com.dk.strings;

public class TestCDCommand {
    /*
      Given a path and passing array of command instruction, which is similar to cd command on terminal.
      Supported operations are .., cd to path, exit to root directory.
      For e.g.

      Example 1:
      Input: Path: /a/b/c/d, cmd: ".."
      Output: /a/b/c

      Example 2:
      Input: Path: /a/b/c/d/e, cmd: "x"
      Output: /a/b/c/d/e/x

      Example 3:
      Input: Path: /a/b/c/d/e, cmd: "/"
      Output: /

     */

    public static void main(String ...args){
        CDPath path = new CDPath("a/b/c/d");
        path = path.cd("x");
        path = path.cd("..");
        path = path.cd("..");
        path = path.cd("/");
        path = path.cd("../x/y");

        System.out.println(path.getPath());
    }

}
