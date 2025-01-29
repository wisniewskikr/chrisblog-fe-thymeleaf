DESCRIPTION
-----------

#####Goal
Application Chrisblog ia a blog engine which enables to create and publish blog articles. 

#####Details
This project consists of following pages:
* **List of all Articles**: links and short descriptions of all articles are displayed here. Also user can here:
    * Search by some text
	* Filter by Category
	* Order by few attributes
* **Single Article**: article is displayed here
* **About Me**: information about author is displayed here

#####Technologies
Used technologies:
* Java
* Maven
* Git
* Spring Boot
* H2 Database
* Docker
* AWS


URLS
----

* **Blog**: http://localhost:8080
* **H2 Console**: http://localhost:8080/console (Database URL: jdbc:h2:mem:db-embedded;DB_CLOSE_DELAY=-1, Database username: sa, Database password: -)


USAGE - LOCAL MACHINE
-------------------

Usage steps:
1. Start Chrisblog application
2. Test Chrisblog application
3. Stop Chrisblog application

##### Ad 1\ Start Chrisblog application

Please download source code from Github and switch to **master** branch. 

You can start this application in two ways:
- **Option 1**: in application **chrisblog** open class **Application.java** and run method **main()**
- **Option 2**: open command line on folder **chrisblog** and run following Maven command: **mvn spring-boot:run**

##### Ad 2\ Test Chrisblog application

To test Chrisblog application please:
* Open any browser
* Type following URL there: http://localhost:8080

##### Ad 3\ Stop Chrisblog application
To stop this application for:
* **Option 1**: stop application in IDE
* **Option 2**: type in Console **ctrl + C**


USAGE - DOMAIN CHRISBLOG.EU
-------------------------

Developer steps:
1. Create 'feature' branch from 'develop' branch
2. Implement changes on 'feature' branch
3. Create Merge Request on Github
4. Inform Administrator about Merge Request

Administrator steps:
5. Approve/Reject Merge Request on Github
6. Publish Changes

##### Ad 1\ Create 'feature' branch from 'develop' branch
Steps to create 'feature' branch:
* Switch to 'develop' branch: command **git checkout develop** and **git pull origin develop**
* Create 'feature' branch: command **git checkout -b feature/{articleId}** (for instance: **git checkout -b feature/1**)

##### Ad 2\ Implement changes on 'feature' branch
Whole work has to be done on 'feature' branch. Git commands:
* git add .
* git status
* git commit -m "{message}"

##### Ad 3\ Create Merge Request on Github
Steps:
* Push 'feature' branch to Github: command **git push origin feature/{articleId}** (for instance: **git push origin feature/1**)
* Create **Merge Request** on Github

##### Ad 4\ Inform Administrator about Merge Request
Please inform **Krzysztof Wisniewski** about new Merge Request.

##### Ad 5\ Approve/Reject Merge Request on Github (Administrator)
Adminstrator checks Merge Request and approves or rejects changes. So if changes are:
* **Approved**: then 'feature' branch should be merged to 'develop' branch
* **Rejected**: then Developer should be informed about it

##### Ad 6\ Publish Changes (Administrator)
To publish changes branch 'develop' has to be merged to branch 'master'. The rest is done automatically by AWS.


DOCKER
------

Maven profiles:
* ** mvn clean install -PdockerRefreshImage **: this command refreshes Docker Image (stop Container if exists and refresh Image);
* ** mvn clean install -PdockerRefreshContainer **: this command refreshes Docker Container (stop Container if exists, refresh Image and run new Container);
* ** mvn clean install -PdockerStopContainer **: this command stops Docker Container (stop Container if exists);
* ** mvn clean install -PdockerPushImage ** : this command pushes Image to default remote Docker Hub repository (stop Container if exists, build Image and push it. It requires changes in file "m2/settings.xml");

Commands about images:
* docker images: list of all images
* docker rmi <IMAGE ID>: remove image with specific id

Command about container:
* docker ps: list of active containers
* docker ps -a: list of all containers
* docker stop <CONTAINER ID>: stop container with specific id
* docker start <CONTAINER ID>: start container with specific id
* docker rm <CONTAINER ID>: remove container with specific id

Commands to build, run and deploy Docker image:
* docker build -t wisniewskikr/chrisblog .
* docker run -p 8080:8080 wisniewskikr/chrisblog
* docker push wisniewskikr/chrisblog

Docker page:
https://hub.docker.com/


PROFILES
--------

There are two profiles:
* ** default **: used on local machine
* ** prod **: definied in file "Dockerfile". It means that this profile is used always when application is build by docker


AWS
---

AWS services used in this application:
* RDS (US East; N. Virginia) - database 'chrisblog' has to be created manually. Command: CREATE DATABASE chrisblog;
* ECR (US East; N. Virginia)
* Load Balancer (US East; N. Virginia)
* ECS (US East; N. Virginia)
* CodeBuild (US East; N. Virginia)
* CodePipeline (US East; N. Virginia)
* Certificate Manager (US East; N. Virginia)
* S3 (Global)
* Route 53 (Global)
* CloudFront (Global)


JENKINS
-------

* chrisblog-selenium
* chrisblog-jenkins
    * every one hour
    * on change chrisblog-tests
    * on change with delay 10 minutes chrisblog
    * email notification
* chrisblog-tests


CLIENT
------

* chrisblog-client-ui
* chrisblog-client-db
* chrisblog-client-store


TODO
----

Articles:
* Basic
* Bearer
* ApiKey
* OpenId
* OAuth2
* SSO
* Facebook
* Google
* Sonar
* Swagger 2
* Jason/Hudson
* Google Analytics
* Automated Tests
* Cache
* Text from properties
* Multilanguage
* Registration
* Own Annotations
* Footer
* Schedulers
* Docker
* Read CSV
* Import CSV
* Export CSV
* Send emails