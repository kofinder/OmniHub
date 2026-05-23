#!/bin/bash

echo "================================="
echo "Stopping KoffeeStrap"
echo "================================="

cd ../compose || exit

docker compose down

echo "================================="
echo "KoffeeStrap Stopped"
echo "================================="