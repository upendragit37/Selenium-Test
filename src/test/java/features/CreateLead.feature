Feature: Leaftaps CreateLead
Background:
Given Open the chromebrowser
And Maximise the Browser
And Set the Implicit Timeouts
And Load the leaftaps URL


Scenario Outline: TC001 Verify CreateLead
Given Enter the Username as Demosalesmanager
And Enter the Password as crmsfa
When Click on the Login Button  
Then Verify Login Successful
And Click on the CRM/SFA 
And Click on the CreateLead LinkText
And Enter the Companyname as <companyname>
And Enter the Firstname as <firstname> 
And Enter the Lastname as <lastname>
When Click on the CreateLead button
Then Verify the name

Examples: 
|companyname|firstname|lastname|
|Testleaf|Upendranath|M|
|HCL|Upendranath|M|