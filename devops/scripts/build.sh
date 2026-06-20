#!/bin/bash

echo "================================="
echo "Building KoffeeStrap Containers"
echo "================================="

cd ../compose || exit

docker compose build

echo "================================="
echo "Build Complete"
echo "================================="