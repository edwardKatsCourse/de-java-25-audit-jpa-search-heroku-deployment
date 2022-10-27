#heroku login

# login to Heroku Docker Hub
heroku container:login

# docker build by Heroku CLI
heroku container:push web -a de-java-25-deploy

# Deploy spring docker image to Heroku App de-java-25-deploy
heroku container:release web -a de-java-25-deploy

# Show logs from de-java-25-deploy (--tail show always)
heroku logs -a de-java-25-deploy --tail

