# UptakeInterview

Unfortunately I ran into trouble early on getting my Spring configuration set up properly in my IDE. So I'm posting what I have. 

I was able to figure out how to compute some of the amicable numbers less than seed but not all of them. If I hadn't lost time due to set up issues, I would spend more time researching formulas on how to compute all amicable numbers. 

I ran out of time in creating a cron job for a Tomcat instance. If I had more time, I would create a listener class defined in the <listener-class> tag in the Tomcat web.xml file. In the corresponding class I would create logic that would send a json to my controller every 3 seconds as stated in the requirements.

I removed Tomcat from my project so that it would run using the command:  mvn spring-boot:run
