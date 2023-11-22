# Password Generator
Simple application that just uses Linux "apg"-command (backend) to generate random password.

Pre-requirement:
- Docker or Java 17

Run with Maven + Java
* Linux:
  * ./run.sh

Run with Docker (using docker container)
* Linux:
  * ./run-docker.sh
* Windows:
  * run.bat

To access it web page, open browser and go to:
* http://localhost (for local development)
* http://<your-server>

## Docker

### Run application using exists image from DockerHub
``
$ docker run -it --rm -p 80:80 phzfi/password-generator:latest
``

#### Run application using docker container
``
$ docker-compose up
``

#### Clean up
``
$ docker-compose down
``

## DockerHub
``
$ docker login
``

#### Build image (1.0.0 is tag version number)
``
$ docker build --no-cache -t phzfi/password-generator:1.0.0 .
``

#### Push image to docker hub (1.0.0 is tag version number)
```
$ docker push phzfi/password-generator:1.0.0
$ docker image tag phzfi/password-generator:1.0.0 phzfi/password-generator:latest
$ docker push phzfi/password-generator:latest
```