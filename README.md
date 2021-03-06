######  PreRequisites:

1. Download latest [ chromedriver ]( https://sites.google.com/a/chromium.org/chromedriver/downloads ) and put under directory */usr/local/bin* on Mac OS
2.Maven
3.Java 7 or java 8

###### Additional Info:
Serenity + Cucumber + BDD concepts

1.To run test cases , from command line execute below command

---- maven-failsafe-plugin ----

mvn clean verify -Drun.parallel=false


2.To run the test cases parallel 
Pre-requistic:
 **install docker** 
----  docker debug mode VNC ---

docker run -d -p 4444:4444 --name selenium-hub -e GRID_BROWSER_TIMEOUT=31000 selenium/hub

docker run -d -P -p 5900:5900 --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-chrome-debug

docker run -d -P -p 5901:5900 --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-chrome-debug

---- maven-failsafe-plugin ----

**Linux**

mvn verify -Drun.parallel=true -Dwebdriver.remote.driver=CHROME -Dwebdriver.remote.url=http://hub_container_external_ip:4444/wd/hub -Dwebdriver.base.url=http://automationpractice.com/index.php -Dwebdriver.remote.os=LINUX

**Windows**

mvn verify -Drun.parallel=true -Dwebdriver.remote.driver=CHROME -Dwebdriver.remote.url=http://hub_container_external_ip:4444/wd/hub -Dwebdriver.base.url=http://automationpractice.com/index.php -Dwebdriver.remote.os=WINDOWS

#### reports ####

3.Consolidated report can be found under 

   **Cucumber Reports - **/target/cucumber-htmlreport/index.html**
  
   **Serenity report - **target/site/cucumber-reports/feature-overview.html**


4.Test Cases are automated using **BDD** approach with help of **Cucumber** & **Selenium**

5.**PageObject* & **PageFactory** design patterns are used to keep code DRY
