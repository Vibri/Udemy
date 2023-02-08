FROM nginx:1.23.2
RUN apt-get update && apt-get install -y procps
EXPOSE 80/tcp
EXPOSE 443/tcp
RUN mkdir /bloggingtemplate
COPY /bloggingtemplate /bloggingtemplate
RUN mkdir -p /etc/nginx/ssl
RUN openssl req -x509 -days 10000 -nodes -newkey rsa:2048 -keyout /etc/nginx/ssl/self.key -out /etc/nginx/ssl/self.cert -subj "/C=CZ/ST=Prague/L=Prague/O=OKsystem/OU=IT Department/CN=example.com"
COPY nginx.conf /etc/nginx/nginx.conf