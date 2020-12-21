### Contents

| | |
---|---
`./no/pkg` | Plain Example without a package.
`./pkg`| Example using a package. Has the dependencies `./other/pkg` and `no_main.jar` (see below).
`./other/pkg` | Package without `main()`. Used by `pkg`. Can't be used by `yes_main.jar` (to be clarified).
`./jar..` | Example using `.jar` files.
`./jar/src` | Source for `yes_main.jar` and `no_main.jar`.
`./jar/out` | The `yes_main.jar` and `no_main.jar` files.
`./jar/out` | Unpacked `yes_main.jar` and `no_main.jar` files. Note that the path within the jar starts with `./jar/...`.
`.sh` | The `.sh` files contain the commands for compiling and runnig the examples.


| | |
---|---
`Tools.md` | Ant, Maven, Gradle (TODO)
`Jar.md`|
