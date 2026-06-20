#!/bin/bash

echo "================================="
echo "Starting KoffeeStrap"
echo "================================="

cd ../compose || exit

docker compose up --build -d

echo "================================="
echo "KoffeeStrap Started"
echo "================================="

docker ps