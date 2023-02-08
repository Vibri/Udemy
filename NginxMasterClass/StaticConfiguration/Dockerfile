FROM nginx:1.23.2
RUN apt-get update && apt-get install -y procps
EXPOSE 80/tcp
RUN mkdir /bloggingtemplate
COPY /bloggingtemplate /bloggingtemplate
COPY nginx.conf /etc/nginx/nginx.conf