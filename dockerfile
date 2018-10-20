FROM centos

WORKDIR /root/
ENV PATH=$PATH:/root/sbt/bin/

RUN yum install -y java-1.8.0-openjdk java-1.8.0-openjdk-devel git
RUN curl https://sbt-downloads.cdnedge.bluemix.net/releases/v1.2.1/sbt-1.2.1.tgz > sbt-1.2.1.tgz
RUN tar -xzvf sbt-1.2.1.tgz
RUN rm sbt-1.2.1.tgz
WORKDIR /root/project
RUN git clone https://github.com/yumlonne/scalatra_first_app
WORKDIR /root/project/scalatra_first_app
RUN sbt compile

EXPOSE 9000
CMD cd /root/project/$PROJECT && sbt `echo $CMD`
