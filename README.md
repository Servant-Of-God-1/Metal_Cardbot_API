# METAL CARDBOT API Code 🤖

<p align="center">
  <img src="https://static.wikia.nocookie.net/metal-cardbot/images/e/ef/Slider_image_1.jpg/revision/latest?cb=20260528020307" alt="Metal Cardbot S (season 2)" width="100%" />
  <img src="https://static.wikia.nocookie.net/metal-cardbot/images/a/ae/Slider_image_3.jpg/revision/latest/scale-to-width-down/800?cb=20260528231155" alt="Metal Cardbot W (season 3)" width="100%" />
  <img src="https://static.wikia.nocookie.net/metal-cardbot/images/1/16/Slider_image_8.jpg/revision/latest/scale-to-width-down/800?cb=20260528020503" alt="Metal Cardbot (season 1)" width="100%" />
</p>

I'm using Information From https://metal-cardbot.fandom.com/wiki/METAL_CARDBOT_Wiki for build a API Public.
I dont use a database anything (just Spring Boot and gladle for kotlin). So this API Public Static (with JSON) Im using image from https://metal-cardbot.fandom.com/wiki/METAL_CARDBOT_Wiki and and video url from https://www.youtube.com/@metalcardbotTV.
Don't worry about price, its free you use a my API PUBLIC
If you want to edit my API like adding additional information, you can edit my API (there is no prohibition for that)
It is strictly forbidden to misuse the API for personal gain that will harm me, the Metal Cardbot fandom wiki, and SAMG (as its creator) ❌
Available in two languages: English and Indonesian

# Data variable structrue
consists of data such as
1. id (String) = id character,
2. name (String) = name character,
3. Image (String) = image character (url link),
4. Image1 (String) = image character (url link),
5. Image2 (String) = image character (url link),
6. Qoute (String) = Qoute Character (using \"{qoute}\" for {qoute}),
7. Caption (String) = Explain the context,
8. Caption1 (String) = Explain the context,
9. Caption3 (String) = Explain the context,
10. Decription (String) = Description about character (Overview),
11. Decription1 (String) = Description about character,
12. Decription2 (String) = Description about character,
13. Decription3 (String) = Description about character,
14. Url_Video (String) = video link (url youtube only),
15. category (String) = Language category

# Public API Call Types
## 1. api/information to display all Metal Cardbot character information
## 2. api/information?language=id to display all Metal Cardbot character information in Indonesian
## 3. api/information?language=en to display all Metal Cardbot character information in English
## 4. api/information/{id} to display specific information about one of the Metal Cardbot characters. Each ID has a different language, with the ID format being name_character-id (for Indonesian) and name_character-en (for English).
## 5. api/information/{id}/image to display image one Metal Cardbot characters
## 6. api/information/{id}/image1 to display image one Metal Cardbot characters
## 7. api/information/{id}/image2 to display image one Metal Cardbot characters
## 8. api/information/{id}/video to display video about one Metal Cardbot characters
## 9. api/information/{id}/quote to display pupolar quote about one Metal Cardbot characters
## 10. api/information/{id}/description to display description about one Metal Cardbot characters
## 11. api/information/{id}/description1 to display description about one Metal Cardbot characters
## 12. api/information/{id}/description2 to display description about one Metal Cardbot characters
## 13. api/information/{id}/description3 to display description about one Metal Cardbot characters
## 14. api/categories to display how many are there in that category


if you want recreate the my API configurate, (like add a variable data) You have to edit the InformationController file in src/main/kotlin/Metalcardbot_testmyapi_kotlin_restful_api/Controller to set up the public API call  
and edit the information file in src/main/kotlin/Metalcardbot_testmyapi_kotlin_restful_api/model to add the data variable.
or if you want to change a information, you have to edit in information.json file from src/main/kotlin/resources/data 

# How to deploy a METAL CARDBOT API code
## A. Run your connection (Local Network)
### 1. Download my repository code
https://github.com/Servant-Of-God-1/Metal_Cardbot_API/archive/refs/heads/master.zip
### 2. download Intelij IDEA for running restful API
### 3. Extract ZIP file resful API from repository and open with intelij IDEA
### 4. Please double-check the Java machine version on your laptop by typing "java --version" in the command prompt and remove the value before the dot. Match the Java machine in your project to the one on your computer by editing the build.gradle.kts file (kotlin-restful-api) and changing it to the following code:
``` kotlin
java {
toolchain {
languageVersion = JavaLanguageVersion.of(Java machine on your computer)
}
}
```
### 5. Click Play for running the restful API
### 6. To check whether the Restful API is actually working, try testing it in a browser by typing http://localhost:8080/api/information
### 7. Connection your laptop and your device with the same Connection (like same WI-FI or same connection)
### 8. Check your IPv4 address by searching through the command prompt by typing ipconfig.
### 9. Copy the IPv4 address from the command prompt to display information from the Public API.

Warning: If you are using the local network option, then try to use a WiFi hotspot-based network from a cellphone that supports turning on the hotspot + WiFi simultaneously to avoid IPV4 changes due to the device restarting. Or maybe try to create a Static IP network by following the steps in the video link below https://youtu.be/HL5gEHqHk4A?si=6sdacLEohUaXOKvg

## B. Run your deploy (Via Railway)
### 1. Download my repository code
https://github.com/Servant-Of-God-1/Metal_Cardbot_API/archive/refs/heads/master.zip
### 2. Create your own GitHub repository
### 3. Log in to railway to run the API
### 4. Select the repository you created to deploy the application
### 5. Select the Railpack builder and adjust the Java version used in the deployment in the build.gradle.kts file (kotlin-restful-api) and change it to the following code:
``` kotlin
java {
   toolchain {
   languageVersion = JavaLanguageVersion.of(Java version that supports railpack railway)
    }
}
```
### 6. Enter public networking to get the public API link (if you're unsure, just click custom domain)
### 7. Copy the public API link you created and paste it into your project


Thank you to the Metal Cardbot fandom wiki for providing information about Metal Cardbot as a resource🙏.  And thank you also to those of you who have used my API🙏.
I apologize if this API I created is still not perfect in your opinion🙏.
