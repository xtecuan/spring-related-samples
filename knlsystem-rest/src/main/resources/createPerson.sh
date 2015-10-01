#!/bin/bash

########Change according to your settings###############
json_sample_file=/home/julianr/Work/NetbeansProjects/knlsystem-services-onlyPerson/knlsystem-rest/src/main/resources/person.json
bookmarks_url=http://debjulianr:8080/persons/
########End Change according to your settings###########

curl -v -H "Content-Type: application/json" -X POST --data "@${json_sample_file}" ${bookmarks_url}