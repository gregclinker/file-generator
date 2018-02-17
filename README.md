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
java -jar target/file-tester-0.1.0.jar
```

Go to a browser and look at [http://localhost:8080/](http://localhost:8080/) to test

## Running in redirect mode

```
java -DREDIRECT_URL=http://localhost:8090/ -jar target/simple-proxy-0.1.0.jar
```

Go to a browser and look at [http://localhost:8080/](http://localhost:8080/) to test

## Versioning

## Authors

* **Greg Clinker**

## License

None

