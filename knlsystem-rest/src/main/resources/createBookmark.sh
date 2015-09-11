#!/bin/bash

########Change according to your settings###############
json_sample_file=/home/julianr/Work/NetbeansProjects/knlsystem-services/knlsystem-rest/src/main/resources/bookmark.json
bookmarks_url=http://debjulianr:8080/ogierke/bookmarks/
########End Change according to your settings###########

curl -v -H "Content-Type: application/json" -X POST --data "@${json_sample_file}" ${bookmarks_url}