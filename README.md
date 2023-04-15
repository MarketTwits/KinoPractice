# FilmApp - Android App ![Build status](https://github.com/wallabag/android-app/workflows/CI/badge.svg?branch=master)

This application is written for educational practice on the subject of "Mobile application development"

## About

The application works with a local server and processes information from it. The server is written in php, MySQL is used as a database.

Initially, the application was written in Java using AsyncTask. In the refactor_1 branch, 
the application was rewritten to kotlin using Retrofit, ViewModel. The application is adapted for writing UNIT tests.
Local server will be adding it this repository.

## Features

The android app lets you:
* Add films 
* Add theaters 
* Get list with films 
* Get list with theaters and address

## Screenshots

<p float="left">
<img src="https://user-images.githubusercontent.com/96594802/232232653-f4332006-d36e-41ad-a1a7-0d57225803ba.png" width="250" height="530"/>
<img src="https://user-images.githubusercontent.com/96594802/232232698-7c01a738-02cb-4773-b1fc-03f2bd8b2f24.png" width="250" height="530"/>
<img src="https://user-images.githubusercontent.com/96594802/232232726-9c8970a4-e433-48b9-be89-0c54cd13e06c.png" width="250" height="530"/>
</p>

## Permissions

On Android versions prior to Android 6.0, wallabag requires the following permissions:
- Full Network Access.
- View Network Connections.

