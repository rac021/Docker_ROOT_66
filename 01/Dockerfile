
FROM alpine:3.1

MAINTAINER R.Yahiaoui <r.yahiaoui.21@gmail.com>

RUN apk update && apk upgrade

COPY test2.sh /opt

ENTRYPOINT ["/bin/sh", "-c", "echo Hello From alpine container"]  

