#!/bin/sh
set -e

if [ ! -f config.env ]; then
  echo "config.env missing"
  exit 1
fi

export $(grep -v '^#' config.env | xargs)

docker compose --env-file config.env up -d --build
