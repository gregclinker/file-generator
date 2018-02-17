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
	<create name="/tmp/file1" size="2" count="10"  initial-wait="2000" threads="15"/>
	<create name="/tmp/file2" size="5" count="2"  initial-wait="5000" threads="5"/>
</tests>
```

## Versioning

## Authors

* **Greg Clinker**

## License

None

