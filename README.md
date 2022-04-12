# FindMyVehicle
FindMyVehicle is a web-app which notifies the location (i.e xyz ground in a particular area) immediately after their vehicle is towed by the RTO authorities.

FindMyVehicle uses OCR(Optical Image Recognition) technology to extract text from the number-plate images.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
	To play with this project,you will have to install the things mentioned below:
	Java (Java SE Development Kit)
	Any Java-Devlopment Supported IDE (Eclipse,Netbeans etc)
	Server (Apache Tomcat)
	Database (MySQL,Oracle, any)
	SQL query tool (SQL Workbench,Yog any)

### Installing
Having all the prerequisites,Simply clone this repo in a directory of your local pc
git clone https://github.com/Prit27/FindMyVehicle.git 

	Fire up your IDE
	Configure Java Runtime
	Add Server Runtime
	Run on Server 
	Switch to your SQL query tool you will see all the table's there
	Fill up dummy details in TowDetails and login table
		login - enabled(1),role (ROLE_ADMIN) 
		same goes with user - role (ROLE_USER)
		(will attach sql scripts though)
	Restart Server->Run 
	Login as admin/user
	Done

Note:
	FMV notifies by Mail and SMS, for sms to work you will have to install 2 apps from google 		play.
	
	Refer the Acknowledgements section for more.

## Built With

* [Spring MVC](https://spring.io/web-applications) - The web framework used
* [Bootstrap-4,HTML,CSS3]

## Acknowledgments

* Cloudinary for cloud storage
* Google Vision API (Integrated in Cloudinary)
* GSM Modem app for sms testing (https://play.google.com/store/apps/details?id=com.gsmmodem&hl=en) 
* OCR.space for providing free ocr api (used in early versions)


