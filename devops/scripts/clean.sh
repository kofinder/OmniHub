#!/bin/bash

echo "================================="
echo "Building OmniHub Containers"
echo "================================="

docker compose down -v
docker system prune -f

echo "================================="
echo "Build Complete"
echo "================================="