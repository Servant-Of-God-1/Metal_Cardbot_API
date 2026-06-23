# METAL CARDBOT Restful API Code (read only) 🤖

<p align="center">
  <img src="https://static.wikia.nocookie.net/metal-cardbot/images/e/ef/Slider_image_1.jpg/revision/latest?cb=20260528020307" alt="Metal Cardbot S (season 2)" width="100%" />
  <b>Metal Cardbot S (season 2)</b>
  <img src="https://static.wikia.nocookie.net/metal-cardbot/images/a/ae/Slider_image_3.jpg/revision/latest/scale-to-width-down/800?cb=20260528231155" alt="Metal Cardbot W (season 3)" width="100%" />
  <b>Metal Cardbot W (season 3)</b>
  <img src="https://static.wikia.nocookie.net/metal-cardbot/images/1/16/Slider_image_8.jpg/revision/latest/scale-to-width-down/800?cb=20260528020503" alt="Metal Cardbot (season 1)" width="100%" />
  <b>Metal Cardbot (season 1)</b>
</p>

I'm using Information from 
```
https://metal-cardbot.fandom.com/wiki/METAL_CARDBOT_Wiki
```
for build a Restful API code. I dont use a database anything (just Spring Boot and gladle for kotlin). So this Restful API code Static (with JSON). 
Im using image from 
```
https://metal-cardbot.fandom.com/wiki/METAL_CARDBOT_Wiki
```
and video url from 
```
https://www.youtube.com/@metalcardbotTV.
```
It is strictly forbidden to misuse the API for personal gain that will harm me, the Metal Cardbot fandom wiki, and SAMG (as its creator). Furthermore, this code is in no way affiliated with SAMG (this is purely programming-based fanart). Available in two languages: English and Indonesian (I will develop it for other languages ​​in the future if possible)

# Data variable structrue
consists of data such as
| type data | explain |
| :--- | :--- |
| id (String) | id character |
| name (String) |  name character | 
| Image (String) |  image character (url link) | 
| Image1 (String) |  image character (url link) |
| Image2 (String) |  image character (url link) |
| Qoute (String) |  Qoute Character (using ```\"{qoute}\"``` for {qoute}) |
| Caption (String) |  Explain the context |
| Caption1 (String) |  Explain the context |
| Caption3 (String) |  Explain the context |
| Decription (String) |  Description about character (Overview) |
| Decription1 (String) |  Description about character |
| Decription2 (String) |  Description about character |
| Decription3 (String) |  Description about character |
| Url_Video (String) |  video link (url youtube only) |
| category (String) |  Language category |

# Public API Call Types
| API CALL | Function |
| :--- | :--- |
| api/information | display all Metal Cardbot character information |
| api/information?language=id | display all Metal Cardbot character information in Indonesian |
| api/information?language=en | display all Metal Cardbot character information in English |
| api/information/{id} | display specific information about one of the Metal Cardbot characters. Each ID has a different language,  with the ID format being name_character-id (for Indonesian) and name_character-en (for English). |
| api/information/{id}/image | display image one Metal Cardbot characters |
| api/information/{id}/image1 | display image one Metal Cardbot characters |
| api/information/{id}/image2 | display image one Metal Cardbot characters |
| api/information/{id}/video | display video about one Metal Cardbot characters |
| api/information/{id}/quote | display pupolar quote about one Metal Cardbot characters |
| api/information/{id}/description | display description about one Metal Cardbot characters |
| api/information/{id}/description1 | display description about one Metal Cardbot characters |
| api/information/{id}/description2 | display description about one Metal Cardbot characters |
| api/information/{id}/description3 | display description about one Metal Cardbot characters |
| api/categories | display how many are there in that category


***if you want recreate the my API configurate, (like add a variable data) You have to edit the InformationController file in 
``` 
src/main/kotlin/Metalcardbot_testmyapi_kotlin_restful_api/Controller
``` 
to set up the public API call and edit the information file in 
```
src/main/kotlin/Metalcardbot_testmyapi_kotlin_restful_api/model
``` 
to add the data variable. or if you want to change a information, you have to edit in information.json file from 
```
src/main/kotlin/resources/data
```
***

# How to deploy a METAL CARDBOT API code
## A. Run your connection (Local Network)
### 1. Download my repository code
```
https://github.com/Servant-Of-God-1/Metal_Cardbot_API/archive/refs/heads/master.zip
```
### 2. download Intelij IDEA for running restful API
### 3. Extract ZIP file resful API from repository and open with intelij IDEA
### 4. Please double-check the Java machine version on your laptop by typing "java --version" in the command prompt and remove the value before the dot. Match the Java machine in your project to the one on your computer by editing the build.gradle.kts file (kotlin-restful-api) and changing it to the following code:
```
java {
toolchain {
languageVersion = JavaLanguageVersion.of(Java machine on your computer)
}
}
```
### 5. Click Play for running the restful API
### 6. To check whether the Restful API is actually working, try testing it in a browser by typing 
``` http://localhost:8080/api/information ```
### 7. Connection your laptop and your device with the same Connection (like same WI-FI or same connection)
### 8. Check your IPv4 address by searching through the command prompt by typing ipconfig.
### 9. Copy the IPv4 address from the command prompt to display information from the Public API.

***Warning: If you are using the local network option, then try to use a WiFi hotspot-based network from a cellphone that supports turning on the hotspot + WiFi simultaneously to avoid IPV4 changes due to the device restarting. Or maybe try to create a Static IP network by following the steps in the video link below 
```
https://youtu.be/HL5gEHqHk4A?si=6sdacLEohUaXOKvg
```
***

## B. Run your deploy (Via Railway)
### 1. Download my repository code
```https://github.com/Servant-Of-God-1/Metal_Cardbot_API/archive/refs/heads/master.zip```
### 2. Create your own GitHub repository
### 3. Log in to railway to run the API
### 4. Select the repository you created to deploy the application
### 5. Select the Railpack builder and adjust the Java version used in the deployment in the build.gradle.kts file (kotlin-restful-api) and change it to the following code:
```
java {
   toolchain {
   languageVersion = JavaLanguageVersion.of(Java version that supports railpack railway)
    }
}
```
### 6. Enter public networking to get the public API link (if you're unsure, just click custom domain)
### 7. Copy the public API link you created and paste it into your project


Thank you to the Metal Cardbot fandom wiki for providing information about Metal Cardbot as a resource🙏. thank you also to those of you who have used my API🙏.
I apologize if this API I created is still not perfect in your opinion🙏 and i apologize for making a ready-to-use version due to limited funds to deploy it🙏.
