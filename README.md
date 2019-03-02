Docker container is necessary
docker run --name mytomcat8 -p 8080:8080 -it -d --rm tomcat:8.0

# https://gist.github.com/telekosmos/603543c8b9262bf6668ae72a82bf1109
#run with jvm remote debugger
docker run --name mytomcat8 -p 8080:8080 -p 5005:5005 -e "JAVA_OPTS=\"-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n\"" -it -d --rm tomcat:8.5.35-jre8


TU RUN
from docker directory
docker-compose up -d

CONTENT
- Hibernate Jpa 2 implementation with no persistence xml
- docker app and database containers
- spring 4 mvc and security