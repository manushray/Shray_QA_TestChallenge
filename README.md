# Shray_QA_TestChallenge

# The Test Cases & Bugs are present in "TestCase&Bugs.xlsx" also the Answer for Quesionnaire asked is present in "AnswerOfQuestionnaire.docx".

# Description About Code/Framework :

I have created a partial Automation Framework comprise of (Selenium+ JAVA+ Page Object Model+ TestNG + log4j2).

• "Base" class is Parent Class of all the Test Class & Login Class(Class as page object repository) where Driver initialisation + capabilities are defined which is present under package name "Friendsurance.TestChallenge.Base". 
• All the application code is present under package: “Friendsurance.TestChallenge.Pages” 
• Logging is done by using log4j2.
• Test Cases are handled by TestNG and as I have build my code using MAVEN hence its present under “src/test/java”

As I have made my code dynamic from where you can change the parameter and data set/Test scenario by changing in the config.properties file which is present under package name "src/main/java/Friendsurance/TestChallenge/Configuration/config.properties”

No need to change anywhere in the code but if you want to change the test data mention in the code challenge then you can change the data in config.properties which is present in configuration package

Total time which code will run : 34 sec

# Steps for How to build and execute the solution/code

# Steps to run from command line

cd /to path where you want to clone the code.

Copy the command and hit it at the terminal:

git clone https://github.com/manushray/shray_dwivedi_QA_Challenge.git

cd / to Shray_QA_TestChallenge

run the below command:

mvn clean install

# Step to run the code from Eclipse

Clone the code at your preferred location by entering below command:

git clone https://github.com/manushray/Shray_QA_TestChallenge.git

Open the project from Eclipse:

Browse the location of the clone project from the eclipse

Click on the "Import > Maven > Existing Maven Projects > Browse > Shray_QA_TestChallenge > Finish".

Right click on the project > Run As > Maven test
