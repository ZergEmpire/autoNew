FROM maven:3.8.6-amazoncorretto-17
WORKDIR /test
COPY . .

RUN  mvn test -Dcucumber.filter.tags="@Second"

