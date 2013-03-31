rand_loc
========

To compile:

mvn install

To deploy:

Copy target/application.war file to your application server webapps folder. 


Once deployed using a browser and type: http:<IP>:<port>/location/index.jsp

To see the search text field. 

To use the API:

http:<IP>:<port>/location/api/broker/<new broker>

to add new broker. 


http:<IP>:<port>/location/api/broker/<broker>/<search term>

to search for locations. 
