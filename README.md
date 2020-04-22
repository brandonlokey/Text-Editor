# Practicum-Final-Project

 - You can access the S3 bucket hosted website here:
http://practinote.s3-website-us-east-1.amazonaws.com/

- You will need to clone the repo locally and run Server.java for the site to function correctly as it still references localhost / loop backs.
https://github.com/gourmetpez/Practicum-Final-Project

The reason why EC2 is not hosting the server files is because I have had issues in the past with Amazon and had them essentially disable my services, this should have been cleared up, however, there still seemed to be strange routing issues with connecting to my instances. Since I do not have this hosted, I can present the steps I would take if it were not for these issues.

1) Start up a Windows EC2 instance
2) Install Java and Eclipse on this new instance
3) Run the server
4) Configure port routing for 8080 that allows traffic to this instance (Via security groups)
5) Edit the HTML from the front end to reference the AWS public domain name and port 8080 exmple: ec2-35-172-162-86.compute-1.amazonaws.com:8080 (This is referencing the EC2 instance I made for this, however, I could not get connected to my EC2 box despite troubleshooting it for hours until finally calling it quits)
This would make all of the requests from the S3 hosted site to be sent to the EC2 instance. 
