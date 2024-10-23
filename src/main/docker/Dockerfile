FROM hub.shijiuzhi.com:15000/openjdk:slim
MAINTAINER Jim Liu "liujun@qitai.com"
ENV WORK_DIR="/app" \
    LOG_DIR="logs" \
    MODULE_NAME="cpm"

ENV GC_LOG_DIR="${WORK_DIR}/${LOG_DIR}/${MODULE_NAME}"

ENV GC_LOG_FILE="${GC_LOG_DIR}/gcLog.log"
ENV JAVA_OPTS="${JAVA_OPTS} -Xloggc:${GC_LOG_FILE}"
## 工作目录
WORKDIR ${WORK_DIR}

RUN mkdir -p ${GC_LOG_DIR} \
	&& chmod a+rwx ${GC_LOG_DIR}

## 添加编译后的jar包
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["sh", "-c", "/usr/local/openjdk8/bin/java ${JAVA_OPTS}  -Dspring.profiles.active=${ENVIRONMENT} -jar app.jar"]
