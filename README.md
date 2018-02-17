# simple-proxy

File generator tool.

## Getting Started

Build with maven run from a fat jar.


## Building

```
mvn clean install
```

## Running

```
java -jar target/file-tester-1.0.jar file-gererator.xml
```

## Where file-generator.xml

```
<tests>
	<create name="/tmp/file1" size="100" count="2"  initial-wait="200" />
	<create name="/tmp/file1" size="100" count="1"  initial-wait="200" />
	<create name="/tmp/file2" size="5" count="2"  initial-wait="5000" />
</tests>
```

## example output from file-generator.log

```
2018-02-17 10:38:31,254 DEBUG [main] c.s.f.Application [Application.java:60] started Create [baseName=/tmp/file1, size=100, count=2, intitalWait=200, threads=null]
2018-02-17 10:38:31,256 DEBUG [main] c.s.f.Application [Application.java:64] waiting 200 to create /tmp/file1_0
2018-02-17 10:38:31,462 DEBUG [main] c.s.f.Application [Application.java:64] waiting 200 to create /tmp/file1_1
2018-02-17 10:38:31,472 DEBUG [Thread-0] c.s.f.RandomFile [RandomFile.java:34] started create /tmp/file1_0(size=100Mb)
2018-02-17 10:38:31,664 DEBUG [main] c.s.f.Application [Application.java:69] finished starting threads
2018-02-17 10:38:31,664 DEBUG [Thread-1] c.s.f.RandomFile [RandomFile.java:34] started create /tmp/file1_1(size=100Mb)
2018-02-17 10:38:31,664 DEBUG [main] c.s.f.Application [Application.java:60] started Create [baseName=/tmp/file1, size=100, count=1, intitalWait=200, threads=null]
2018-02-17 10:38:31,664 DEBUG [main] c.s.f.Application [Application.java:64] waiting 200 to create /tmp/file1_0
2018-02-17 10:38:31,865 DEBUG [main] c.s.f.Application [Application.java:69] finished starting threads
2018-02-17 10:38:31,865 DEBUG [main] c.s.f.Application [Application.java:60] started Create [baseName=/tmp/file2, size=5, count=2, intitalWait=5000, threads=null]
2018-02-17 10:38:31,865 DEBUG [main] c.s.f.Application [Application.java:64] waiting 5000 to create /tmp/file2_0
2018-02-17 10:38:31,865 DEBUG [Thread-2] c.s.f.RandomFile [RandomFile.java:34] started create /tmp/file1_0(size=100Mb)
2018-02-17 10:38:31,885 DEBUG [Thread-0] c.s.f.RandomFile [RandomFile.java:45] finished create /tmp/file1_0(size=100Mb) in 411ms
2018-02-17 10:38:32,044 DEBUG [Thread-1] c.s.f.RandomFile [RandomFile.java:45] finished create /tmp/file1_1(size=100Mb) in 380ms
2018-02-17 10:38:32,237 DEBUG [Thread-2] c.s.f.RandomFile [RandomFile.java:45] finished create /tmp/file1_0(size=100Mb) in 371ms
2018-02-17 10:38:36,866 DEBUG [main] c.s.f.Application [Application.java:64] waiting 5000 to create /tmp/file2_1
2018-02-17 10:38:36,867 DEBUG [Thread-3] c.s.f.RandomFile [RandomFile.java:34] started create /tmp/file2_0(size=5Mb)
2018-02-17 10:38:36,922 DEBUG [Thread-3] c.s.f.RandomFile [RandomFile.java:45] finished create /tmp/file2_0(size=5Mb) in 54ms
2018-02-17 10:38:41,868 DEBUG [Thread-4] c.s.f.RandomFile [RandomFile.java:34] started create /tmp/file2_1(size=5Mb)
2018-02-17 10:38:41,868 DEBUG [main] c.s.f.Application [Application.java:69] finished starting threads
2018-02-17 10:38:41,926 DEBUG [Thread-4] c.s.f.RandomFile [RandomFile.java:45] finished create /tmp/file2_1(size=5Mb) in 55ms
2018-02-17 10:41:32,211 DEBUG [main] c.s.f.Application started Create [baseName=/tmp/file1, size=100, count=2, intitalWait=200, threads=null]
2018-02-17 10:41:32,213 DEBUG [main] c.s.f.Application waiting 200 to create /tmp/file1_0
2018-02-17 10:41:32,419 DEBUG [main] c.s.f.Application waiting 200 to create /tmp/file1_1
2018-02-17 10:41:32,428 DEBUG [Thread-0] c.s.f.RandomFile started create /tmp/file1_0(size=100Mb)
2018-02-17 10:41:32,620 DEBUG [main] c.s.f.Application finished starting threads
2018-02-17 10:41:32,620 DEBUG [Thread-1] c.s.f.RandomFile started create /tmp/file1_1(size=100Mb)
2018-02-17 10:41:32,620 DEBUG [main] c.s.f.Application started Create [baseName=/tmp/file1, size=100, count=1, intitalWait=200, threads=null]
2018-02-17 10:41:32,621 DEBUG [main] c.s.f.Application waiting 200 to create /tmp/file1_0
2018-02-17 10:41:32,821 DEBUG [main] c.s.f.Application finished starting threads
2018-02-17 10:41:32,821 DEBUG [Thread-2] c.s.f.RandomFile started create /tmp/file1_0(size=100Mb)
2018-02-17 10:41:32,822 DEBUG [main] c.s.f.Application started Create [baseName=/tmp/file2, size=5, count=2, intitalWait=5000, threads=null]
2018-02-17 10:41:32,822 DEBUG [main] c.s.f.Application waiting 5000 to create /tmp/file2_0
2018-02-17 10:41:32,864 DEBUG [Thread-0] c.s.f.RandomFile finished create /tmp/file1_0(size=100Mb) in 434ms
2018-02-17 10:41:33,044 DEBUG [Thread-1] c.s.f.RandomFile finished create /tmp/file1_1(size=100Mb) in 423ms
2018-02-17 10:41:33,221 DEBUG [Thread-2] c.s.f.RandomFile finished create /tmp/file1_0(size=100Mb) in 399ms
2018-02-17 10:41:37,823 DEBUG [main] c.s.f.Application waiting 5000 to create /tmp/file2_1
2018-02-17 10:41:37,823 DEBUG [Thread-3] c.s.f.RandomFile started create /tmp/file2_0(size=5Mb)
2018-02-17 10:41:37,879 DEBUG [Thread-3] c.s.f.RandomFile finished create /tmp/file2_0(size=5Mb) in 54ms
2018-02-17 10:41:42,824 DEBUG [main] c.s.f.Application finished starting threads
2018-02-17 10:41:42,825 DEBUG [Thread-4] c.s.f.RandomFile started create /tmp/file2_1(size=5Mb)
2018-02-17 10:41:42,879 DEBUG [Thread-4] c.s.f.RandomFile finished create /tmp/file2_1(size=5Mb) in 52ms
```


## Versioning

## Authors

* **Greg Clinker**

## License

None

