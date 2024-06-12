# acl.back
acl challenge - backend

## Requirements

The project makes use of Gradle and uses the [Gradle wrapper] which means you don't need Gradle installed.


### Build the project

Compiles the project, runs the test and then creates an executable JAR file

```console
$ ./gradlew build
```
### Run the application

Run the application which will be listening on port `8080`.

```console
$ ./gradlew bootRun
```

### Stop the application

Stop all daemons running

```console
$ ./gradlew -stop
```

## API

Below is the API endpoint with the input and output. Please note that the application needs to be
running for the following endpoints to work.

### Task Creation

Endpoint

```text
POST /api/v1/task/create
```

Example of body

```json
{
  "description": "My Description"
}
```
Example output

```json
{
    "id": 1,
    "description": "My description",
    "created": "2024-06-12T02:13:08.364617",
    "isvalid": true
}

### Task Listing

Endpoint

```text
GET /api/v1/task/
```

Example output

```json
[
    {
        "id": 1,
        "description": "My description",
        "created": "2024-06-12T02:12:59.757725",
        "isvalid": true
    },
    {
        "id": 2,
        "description": "My description",
        "created": "2024-06-12T02:13:08.364617",
        "isvalid": true
    }
]
