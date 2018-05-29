FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD learnbootkafka-manual-offset-docker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080 8443 8000
COPY ./docker-entrypoint.sh /docker-entrypoint.sh
DOCKER_HOST=tcp://192.168.99.100:2375
ENTRYPOINT ["/docker-entrypoint.sh"]
RUN chmod +x /docker-entrypoint.sh
CMD ["start"]