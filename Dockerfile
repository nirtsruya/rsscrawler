FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
COPY target/rsscrawler-1.0.jar rsscrawler-1.0.jar
EXPOSE 8080
CMD java -jar rsscrawler-1.0.jar