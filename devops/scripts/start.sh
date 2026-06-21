#!/bin/bash

echo "================================="
echo "Starting OmniHub"
echo "================================="

cd ../compose || exit

docker compose up --build -d

echo "================================="
echo "OmniHub Started"
echo "================================="

docker ps