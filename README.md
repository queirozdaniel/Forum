# Forum API

> Rest API Project

## Build Setup

``` bash
# install dependencies and build fatjar
mvn clean package

# create docker image
docker build -t {preference-name}/forum .

# run docker image
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE='prod' -e FORUM_DATABASE_URL={FORUM_DATABASE_URL} -e FORUM_DATABASE_USERNAME={FORUM_DATABASE_USERNAME} -e FORUM_DATABASE_PASSWORD={FORUM_DATABASE_PASSWORD} -e FORUM_JWT_SECRET={FORUM_JWT_SECRET} {preference-name}/forum

```
