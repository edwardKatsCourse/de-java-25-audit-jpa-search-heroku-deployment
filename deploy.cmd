heroku container:login && ^
heroku container:push web -a ancient-retreat-47963 && ^
heroku container:release web -a ancient-retreat-47963 && ^
heroku logs -a ancient-retreat-47963 --tail