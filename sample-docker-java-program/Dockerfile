FROM openjdk:11
# Copy the class file after build from the current location of your class file.
COPY out/production/* /opt
WORKDIR /opt
CMD ["java", "com.dk.learning.docker.Main"]
