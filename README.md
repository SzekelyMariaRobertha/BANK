# BANK
This project represents an IT system for the management of a banking structure.
The application will use a MySQL database management system, and the interaction with it will be done only through the graphic interface. The functionalities that the program will offer are aimed at operations related to the management of clients, employees and the administration of current operations within a bank.

__Note__: This project was implemented together with one of my colleagues.

## Requirements
### Installation manual
It is assumed that you have the following applications installed on your computer:
1. MySQL Workbench 8.0
2. IntelliJ/Eclipse
otherwise please install them according to the installation guide of the respective application on the official websites.
1. Unzip Bancomat.zip
2. Double-click on ATM.sql and by default open the MySQL application.
• Choose the connection that the root user uses.
• If this does not use Hostname- localhost / the IP 127.0.0.1 write down your respective IP
• Check that the port used is 3306
4. Run all code in MySQL.
  As a result the database will be created and populated.

## Usage
The implementation of this project consists in the creation of a complex database that will serve as a dynamic source of information (database data can be renewed/changed/deleted and supplemented with new information directly through the interface); development of an application that offers all options for viewing, accessing information from the database, all administration and management operations required within a bank.

This application is dynamic because depending on the type of user desired, totally other menus and options can be accessed. Within the database, I have created the tables so that there is a logical correspondence between them and there are no cycles, the connection between the tables can be done by means of foreign keys and various MySQL statements. Each table has a single primary key by which records are identified and is sufficient to uniquely identify any record in the database. For a good user profile management, I opted for a single table. Depending on the data entered in the table, 3 different types of users can be obtained, as follows:
- Client – When logging in, you have the option to Create an Account, from where you will receive the credentials for logging in. After logging in, a window will open with your account management operations: Issuance of Card, Bank Transfer, Favorite Contacts, View Accounts and Account Liquidation. A "customer" type user will be able to: request his card, a request that will have to be approved by an employee, transfer money both to favorite accounts and to
other accounts, see all their accounts and be able to liquidate any account.
- Employee – Upon logging in as "employee", the user has two options: View Client and Accounts, he can see each client with his accounts, and Notification Panel, from where he will be able to accept or refuse operations at the client's request.
- Admin- If you are logged in as "admin" you will have available the operations Pay Salaries, Delete Client, Modify client data, Modify employee data, Search for client, Search for employee, Filter users. These commands are sufficiently suggestive that they need no further explanation

## Visuals
### Login Page
<div align="center">
  <img src="https://user-images.githubusercontent.com/93877610/232568483-41011f52-7360-4e72-bf35-c80e52951cc3.jpg" width="500" height="300">
</div>

### Client Page
<div align="center">
  <img src="https://user-images.githubusercontent.com/93877610/232568518-2d484bfe-2b21-4bd0-a702-c48f7400be1e.jpg" width="500" height="300">
</div>

### Employee Page
<div align="center">
  <img src="https://user-images.githubusercontent.com/93877610/232568589-8820beee-2b16-489d-96dc-1297cf88ec6e.jpg" width="500" height="300">
</div>

### Admin Page

<div align="center">
  <img src="https://user-images.githubusercontent.com/93877610/232568642-09908313-51ca-4f13-affe-bbfd61e6fafc.jpg" width="500" height="300">
</div>
