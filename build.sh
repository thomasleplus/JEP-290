#!/bin/bash
set -euo pipefail
IFS=$'\n\t'

dir=$(dirname "$0")

"${dir}/mvnw" clean compile jar:jar war:war

docker build --tag=jep290/java --pull -f src/main/docker/java/Dockerfile "${dir}"

docker build --tag=jep290/jboss --pull -f src/main/docker/jboss/Dockerfile "${dir}"
