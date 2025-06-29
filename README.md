To run the springboot application as a container: 

1. Create a clean build with gradlew

```shell
./gradlew clean build
```

2. Create a docker image

```shell
docker build . -t njabbic-api-server
```

3. Run the docker image

```shell
docker run -p 8080:8080 njabbic-api-server
```