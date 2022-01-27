#!/bin/bash -e

function initDatabase() {
    containerName="mysql"
    sqlFile="first.sql"
    echo "Using [$sqlFile]"
    docker exec -i $containerName mysql -uroot -proot < "$sqlFile"
}

initDatabase
