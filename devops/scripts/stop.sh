#!/bin/bash

echo "================================="
echo "Stopping OmniHub"
echo "================================="

cd ../compose || exit

docker compose down

echo "================================="
echo "OmniHub Stopped"
echo "================================="