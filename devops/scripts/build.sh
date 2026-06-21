#!/bin/bash

echo "================================="
echo "Building OmniHub Containers"
echo "================================="

cd ../compose || exit

docker compose build

echo "================================="
echo "Build Complete"
echo "================================="